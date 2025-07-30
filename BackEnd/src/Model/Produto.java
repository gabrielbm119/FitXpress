package Model;

public class Produto {
    private static int contadorProduto = 1;

    private int idProduto;
    private String nomeProduto;
    private String categoriaProduto;
    private double valorProduto;
    private String descricaoProduto;
    private String tamanhoOuPesoProduto;

    public Produto() {}

    public Produto(String nomeProduto, String categoriaProduto, double valorProduto,
                   String descricaoProduto, String tamanhoOuPesoProduto) {
        this.idProduto = contadorProduto++;
        this.nomeProduto = nomeProduto;
        this.categoriaProduto = categoriaProduto;
        this.valorProduto = valorProduto;
        this.descricaoProduto = descricaoProduto;
        this.tamanhoOuPesoProduto = tamanhoOuPesoProduto;
    }

    public int getIdProduto() { return idProduto; }

    public String getNomeProduto() { return nomeProduto; }
    public void setNomeProduto(String nomeProduto) { this.nomeProduto = nomeProduto; }

    public String getCategoriaProduto() { return categoriaProduto; }
    public void setCategoriaProduto(String categoriaProduto) { this.categoriaProduto = categoriaProduto; }

    public double getValorProduto() { return valorProduto; }
    public void setValorProduto(double valorProduto) { this.valorProduto = valorProduto; }

    public String getDescricaoProduto() { return descricaoProduto; }
    public void setDescricaoProduto(String descricaoProduto) { this.descricaoProduto = descricaoProduto; }

    public String getTamanhoOuPesoProduto() { return tamanhoOuPesoProduto; }
    public void setTamanhoOuPesoProduto(String tamanhoOuPesoProduto) {
        this.tamanhoOuPesoProduto = tamanhoOuPesoProduto;
    }

    @Override
    public String toString() {
        return "Cliente " +
                "ID " + idProduto +
                "Nome: " + nomeProduto + ",\n" +
                "Categoria: " + categoriaProduto + ",\n" +
                "Valor: R$" + valorProduto + ",\n" +
                "Descrição: " + descricaoProduto + ",\n" +
                "Tamanho/Peso: " + tamanhoOuPesoProduto;
    }

    // Metodo auxiliar (opcional): exibir informações básicas
    public String resumoProduto() {
        return "Produto: " + nomeProduto + " | Categoria: " + categoriaProduto + " | R$" + valorProduto;
    }
}