package Controller;

import DataBase.DadosSimulados;
import Model.Cliente;
import Model.Carrinho;
import Model.Produto;
import Model.FormaPgto;
import Model.Pedido;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarrinhoController {

    private List<Produto> produtosDisponiveis; // referenciado a partir do "banco de dados" simulado
    private List<Pedido> pedidosRegistrados;   // lista geral ou individual, depende da arquitetura

    public CarrinhoController(List<Produto> produtosDisponiveis, List<Pedido> pedidosRegistrados) {
        this.produtosDisponiveis = produtosDisponiveis;
        this.pedidosRegistrados = pedidosRegistrados;
    }

    private Map<Integer, Carrinho> mapaCarrinhos = new HashMap<>();

    public void criarCarrinho(Cliente cliente) {
        if (!mapaCarrinhos.containsKey(cliente.getIdCliente())) {
            Carrinho novoCarrinho = new Carrinho(cliente);
            mapaCarrinhos.put(cliente.getIdCliente(), novoCarrinho);
            DadosSimulados.listaCarrinhos.add(novoCarrinho); // ← ADICIONAR AQUI
        }
    }

    public Carrinho buscarCarrinhoPorCliente(Cliente cliente) {
        return mapaCarrinhos.get(cliente.getIdCliente());
    }

    public void adicionarProdutoAoCarrinho(Cliente cliente, int idProduto) {
        Carrinho carrinho = buscarCarrinhoPorCliente(cliente);
        Produto produto = buscarProdutoPorId(idProduto);
        if (produto != null && carrinho != null) {
            carrinho.adicionarProduto(produto);
        }
    }

    public void removerProdutoDoCarrinho(Cliente cliente, int idProduto) {
        Carrinho carrinho = buscarCarrinhoPorCliente(cliente);
        if (carrinho != null) {
            carrinho.removerProdutoPorId(idProduto);
        }
    }

    public void limparCarrinho(Cliente cliente) {
        Carrinho carrinho = buscarCarrinhoPorCliente(cliente);
        if (carrinho != null) {
            carrinho.getProdutos().clear();
        }
    }

    public void finalizarPedido(Cliente cliente, FormaPgto formaPgtoSelecionada) {
        Carrinho carrinho = buscarCarrinhoPorCliente(cliente);
        if (carrinho != null && !carrinho.getProdutos().isEmpty()) {
            Pedido novoPedido = new Pedido(carrinho, formaPgtoSelecionada);
            cliente.getListaPedidos().add(novoPedido);
            pedidosRegistrados.add(novoPedido); // se houver lista global
            cliente.setCarrinho(new Carrinho(cliente)); // novo carrinho limpo
        }
    }

    private Produto buscarProdutoPorId(int idProduto) {
        for (Produto p : produtosDisponiveis) {
            if (p.getIdProduto() == idProduto) {
                return p;
            }
        }
        return null;
    }
}