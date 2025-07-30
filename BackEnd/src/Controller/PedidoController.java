package Controller;

import Model.Cliente;
import Model.FormaPgto;
import Model.Pedido;
import Model.Produto;

import static DataBase.DadosSimulados.listaPedidos;
import java.util.ArrayList;
import java.util.List;

public class PedidoController {

    public Pedido criarPedido(Cliente cliente, List<Produto> listaProdutos, FormaPgto formaPgto) {
        Pedido novoPedido = new Pedido(cliente, listaProdutos, formaPgto);
        listaPedidos.add(novoPedido);
        return novoPedido;
    }

    public List<Pedido> listarTodosPedidos() {
        return listaPedidos;
    }

    public List<Pedido> listarPedidosDoCliente(Cliente cliente) {
        List<Pedido> pedidosDoCliente = new ArrayList<>();
        for (Pedido pedido : listaPedidos) {
            if (pedido.getClientePedido().getIdCliente() == cliente.getIdCliente()) {
                pedidosDoCliente.add(pedido);
            }
        }
        return pedidosDoCliente;
    }

    public boolean editarPedido(int idPedido, Cliente cliente, List<Produto> novosProdutos, FormaPgto novaFormaPgto) {
        for (Pedido pedido : listaPedidos) {
            if (pedido.getIdPedido() == idPedido && pedido.getClientePedido().getIdCliente() == cliente.getIdCliente()) {
                pedido.setProdutosPedido(novosProdutos);
                pedido.setFormaPgtoPedido(novaFormaPgto);
                pedido.setValorFretePedido(pedido.calcularFretePedido());
                pedido.setValorTotalPedido(pedido.calcularValorTotalPedido());
                return true;
            }
        }
        return false;
    }
}