package DataBase;

import Model.*;

import java.util.ArrayList;
import java.util.List;

public class DadosSimulados {

    public static List<Cliente> listaClientes = new ArrayList<>();
    public static List<Produto> listaProdutos = new ArrayList<>();
    public static List<Pedido> listaPedidos = new ArrayList<>();
    public static List<Carrinho> listaCarrinhos = new ArrayList<>();
    public static Administrador administrador = new Administrador();

    static {
        // Endereço de exemplo
        Endereco enderecoExemplo = new Endereco(
                "Rua A", "Centro", "", "01000-000", "São Paulo", "SP", "123"
        );

        // Cliente fictício
        Cliente clientePadrao = new Cliente(
                "João Silva", "12345678900", "joao@email.com", "senha123",
                "11999999999", enderecoExemplo, "Musculação"
        );
        clientePadrao.setCarrinho(new Carrinho(clientePadrao));

        // Produtos fictícios
        Produto produto1 = new Produto(
                "Camiseta Dry Fit", "Roupas", 79.90,
                "Ideal para treinos intensos", "M"
        );
        Produto produto2 = new Produto(
                "Creatina 300g", "Suplemento", 119.90,
                "Alta performance e recuperação muscular", "300g"
        );
        listaProdutos.add(produto1);
        listaProdutos.add(produto2);

        // Carrinho pré-preenchido
        clientePadrao.getCarrinho().adicionarProduto(produto1);
        clientePadrao.getCarrinho().adicionarProduto(produto2);
        listaCarrinhos.add(clientePadrao.getCarrinho());

        // Pedido fictício já finalizado
        FormaPgto formaPgtoExemplo = FormaPgto.CREDITO;
        Pedido pedidoExemplo = new Pedido(clientePadrao.getCarrinho(), formaPgtoExemplo);

        // Associar pedido ao cliente e à lista global
        clientePadrao.getListaPedidos().add(pedidoExemplo);
        listaPedidos.add(pedidoExemplo);

        // Adicionar cliente à lista
        listaClientes.add(clientePadrao);
    }
}