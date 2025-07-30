package DataBase;

import Model.*;
import java.util.ArrayList;
import java.util.List;

public class DadosSimulados {
    public static List<Cliente> listaClientes = new ArrayList<>();
    public static List<Produto> listaProdutos = new ArrayList<>();
    public static List<Pedido> listaPedidos = new ArrayList<>();
    public static Administrador administrador = new Administrador();

    static {
        // Criar um endereço de exemplo
        Endereco enderecoExemplo = new Endereco("Rua A", "123", "", "Centro", "São Paulo", "SP", "01000-000");

        // Cliente padrão
        Cliente clientePadrao = new Cliente("João Silva", "12345678900", "joao@email.com", "senha123",
                "11999999999", enderecoExemplo, "Musculação");

        listaClientes.add(clientePadrao);

        // Produtos padrão
        Produto produto1 = new Produto("Camiseta Dry Fit", "Roupas", 79.90, "Ideal para treinos", "M");
        Produto produto2 = new Produto("Creatina 300g", "Suplemento", 119.90, "Alta pureza", "300g");
        Produto produto3 = new Produto("Luva de Academia", "Acessório", 49.99, "Antiderrapante", "G");

        listaProdutos.add(produto1);
        listaProdutos.add(produto2);
        listaProdutos.add(produto3);

        // Pedido exemplo
        List<Produto> produtosPedido = new ArrayList<>();
        produtosPedido.add(produto1);
        produtosPedido.add(produto2);

        Pedido pedidoExemplo = new Pedido(clientePadrao, produtosPedido, FormaPgto.CREDITO);
        listaPedidos.add(pedidoExemplo);
    }
}