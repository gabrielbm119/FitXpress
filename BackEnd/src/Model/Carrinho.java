package Model;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private static int contadorCarrinho = 1;

    private int idCarrinho;
    private Cliente cliente;
    private List<Produto> produtos = new ArrayList<>();
    private double totalParcial;

    public Carrinho() {}

    public Carrinho(Cliente cliente) {
        this.idCarrinho = contadorCarrinho++;
        this.cliente = cliente;
        this.totalParcial = 0.0;
    }

    public int getIdCarrinho() { return idCarrinho; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public List<Produto> getProdutos() { return produtos; }
    public void setProdutos(List<Produto> produtos) { this.produtos = produtos;
        calcularTotalParcial(); // recalcular se lista for substituída
    }

    public void adicionarProduto(Produto produto) { this.produtos.add(produto);
        this.totalParcial += produto.getValorProduto();
    }

    public void removerProdutoPorIndice(int indice) {
        if (indice >= 0 && indice < produtos.size()) {
            produtos.remove(indice);
            calcularTotalParcial();
        } else {
            System.out.println("não achou");
        }
    }

    public double getTotalParcial() { return totalParcial; }
    public void calcularTotalParcial() {
        this.totalParcial = produtos.stream()
                .mapToDouble(Produto::getValorProduto)
                .sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Carrinho Nº ").append(idCarrinho).append("\n");
        sb.append("Cliente: ").append(cliente.getNomeCliente()).append("\n");
        sb.append("Produtos no carrinho:\n");
        for (Produto p : produtos) {
            sb.append(" - ").append(p.getNomeProduto())
                    .append(" (R$ ").append(p.getValorProduto()).append(")\n");
        }
        sb.append("Total parcial: R$ ").append(String.format("%.2f", totalParcial));
        return sb.toString();
    }
}
