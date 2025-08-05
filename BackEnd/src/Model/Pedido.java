package Model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private static int contadorPedido = 1;

    private int idPedido;
    private Cliente clientePedido;
    private List<Produto> produtosPedido = new ArrayList<>();
    private FormaPgto formaPgtoPedido;
    private double valorFretePedido;
    private double valorTotalPedido;

    public Pedido() {}

    public Pedido(Carrinho carrinho, FormaPgto formaPgto) {
        this.idPedido = contadorPedido++;
        this.clientePedido = carrinho.getCliente();
        this.produtosPedido = carrinho.getProdutos();
        this.formaPgtoPedido = formaPgtoPedido;
        this.valorFretePedido = calcularFretePedido();
        this.valorTotalPedido = calcularValorTotalPedido();
    }

    public int getIdPedido() { return idPedido; }

    public Cliente getClientePedido() { return clientePedido; }
    public void setClientePedido(Cliente clientePedido) { this.clientePedido = clientePedido; }

    public List<Produto> getProdutosPedido() { return produtosPedido; }
    public void setProdutosPedido(List<Produto> produtosPedido) { this.produtosPedido = produtosPedido; }

    public FormaPgto getFormaPgtoPedido() { return formaPgtoPedido; }
    public void setFormaPgtoPedido(FormaPgto formaPgtoPedido) { this.formaPgtoPedido = formaPgtoPedido; }

    public double getValorFretePedido() { return valorFretePedido; }
    public void setValorFretePedido(double valorFretePedido) { this.valorFretePedido = valorFretePedido; }

    public double getValorTotalPedido() { return valorTotalPedido; }
    public void setValorTotalPedido(double valorTotalPedido) { this.valorTotalPedido = valorTotalPedido; }

    // Metodo: calcula o frete com base no estado do endereço do cliente
    public double calcularFretePedido() {
        String estado = clientePedido.getEnderecoCliente().getEstadoEndereco().toUpperCase();
        switch (estado) {
            case "SP": return 10.00;
            case "RJ": return 12.00;
            case "MG": return 14.00;
            default: return 20.00;
        }
    }

    // Metodo: soma valor dos produtos + frete
    public double calcularValorTotalPedido() {
        double totalProdutos = produtosPedido.stream()
                .mapToDouble(Produto::getValorProduto)
                .sum();
        return totalProdutos + valorFretePedido;
    }

    @Override
    public String toString() {
        StringBuilder nomesProdutos = new StringBuilder();
        for (int i = 0; i < produtosPedido.size(); i++) {
            Produto p = produtosPedido.get(i);
            nomesProdutos.append("| ")
                    .append(i + 1)
                    .append(" - ")
                    .append(p.getNomeProduto())
                    .append(" (ID: ")
                    .append(p.getIdProduto())
                    .append(") | R$ ")
                    .append(String.format("%.2f", p.getValorProduto()))
                    .append("\n");
        }
        
        return "Pedido " +
                "ID " + idPedido +
                ":\n Cliente: " + clientePedido.getNomeCliente() + ",\n" +
                "Produtos: " + nomesProdutos + ",\n" +
                "Forma de Pagamento: " + formaPgtoPedido + ",\n" +
                "Frete: R$" + valorFretePedido + ",\n" +
                "Valor total (com Frete): " + valorTotalPedido;
    }

    // Metodo auxiliar (opcional)
    public String resumoPedido() {
        return "Pedido #" + idPedido + " | Cliente: " + clientePedido.getNomeCliente() +
                " | Total: R$" + valorTotalPedido + " | Pagamento: " + formaPgtoPedido;
    }
}