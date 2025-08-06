package Controller;

import Model.*;

import static DataBase.DadosSimulados.listaPedidos;
import java.util.ArrayList;
import java.util.List;

public class PedidoController {

    private CarrinhoController carrinhoController;

    public PedidoController(CarrinhoController carrinhoController) {
        this.carrinhoController = carrinhoController;
    }

    public Pedido criarPedido(Cliente cliente, Carrinho carrinho, FormaPgto formaPgto) {
        Pedido novoPedido = new Pedido(carrinho, formaPgto);
        System.out.println(cliente.getCarrinho());
        listaPedidos.add(novoPedido);                      // adiciona à lista global
        cliente.getListaPedidos().add(novoPedido);         // adiciona à lista do cliente
        carrinhoController.limparCarrinho(cliente);        // esvazia o carrinho do cliente
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
}