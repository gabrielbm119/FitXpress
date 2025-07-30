package Model;

public class Cliente {
    private static int contadorCliente = 1;

    private int idCliente;
    private String nomeCliente;
    private String cpfCliente;
    private String emailCliente;
    private String senhaCliente;
    private String telefoneCliente;
    private Endereco enderecoCliente;
    private String esportePreferenciaCliente;

    public Cliente() {}

    public Cliente(String nomeCliente, String cpfCliente, String emailCliente, String senhaCliente,
                   String telefoneCliente, Endereco enderecoCliente, String esportePreferenciaCliente) {
        this.idCliente = contadorCliente++;
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        this.emailCliente = emailCliente;
        this.senhaCliente = senhaCliente;
        this.telefoneCliente = telefoneCliente;
        this.enderecoCliente = enderecoCliente;
        this.esportePreferenciaCliente = esportePreferenciaCliente;
    }

    public int getIdCliente() { return idCliente; }

    public String getNomeCliente() { return nomeCliente; }
    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }

    public String getCpfCliente() { return cpfCliente; }
    public void setCpfCliente(String cpfCliente) { this.cpfCliente = cpfCliente; }

    public String getEmailCliente() { return emailCliente; }
    public void setEmailCliente(String emailCliente) { this.emailCliente = emailCliente; }

    public String getSenhaCliente() { return senhaCliente; }
    public void setSenhaCliente(String senhaCliente) { this.senhaCliente = senhaCliente; }

    public String getTelefoneCliente() { return telefoneCliente; }
    public void setTelefoneCliente(String telefoneCliente) { this.telefoneCliente = telefoneCliente; }

    public Endereco getEnderecoCliente() { return enderecoCliente; }
    public void setEnderecoCliente(Endereco enderecoCliente) { this.enderecoCliente = enderecoCliente; }

    public String getEsportePreferenciaCliente() { return esportePreferenciaCliente; }
    public void setEsportePreferenciaCliente(String esportePreferenciaCliente) {
        this.esportePreferenciaCliente = esportePreferenciaCliente;
    }

    @Override
    public String toString() {
        return "Cliente " +
                "ID " + idCliente +
                ":\n" + nomeCliente + ",\n" +
                "CPF: " + cpfCliente + ",\n" +
                "Email: " + emailCliente + ",\n" +
                "Telefone: " + telefoneCliente;
    }

    // Metodo auxiliar (opcional): exibir dados resumidos
    public String resumoCliente() {
        return "Cliente: " + nomeCliente + " | CPF: " + cpfCliente + " | Email: " + emailCliente;
    }
}
