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

    public CarrinhoController(List<Produto> produtosDisponiveis) {
        this.produtosDisponiveis = produtosDisponiveis;
    }

    private Map<Integer, Carrinho> mapaCarrinhos = new HashMap<>();

    public void criarCarrinho(Cliente cliente) {
        if (!mapaCarrinhos.containsKey(cliente.getIdCliente())) {
            Carrinho novoCarrinho = new Carrinho(cliente);
            mapaCarrinhos.put(cliente.getIdCliente(), novoCarrinho);
            cliente.setCarrinho(novoCarrinho);
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
            System.out.println("mudou");
        }
    }

    public void removerProdutoDoCarrinhoPorIndice(Cliente cliente, int indice) {
        Carrinho carrinho = buscarCarrinhoPorCliente(cliente);
        if (carrinho != null) {
            System.out.println("achou o carrinho com sucesso.");
            carrinho.removerProdutoPorIndice(indice);
        }
    }

    public void limparCarrinho(Cliente cliente) {
        Carrinho carrinho = buscarCarrinhoPorCliente(cliente);
        if (carrinho != null) {
            carrinho.getProdutos().clear();
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