package Model;

public class Endereco {

    private static int contadorEndereco = 1;

    int idEndereco;
    String ruaEndereco;
    String bairroEndereco;
    String complementoEndereco;
    String cepEndereco;
    String cidadeEndereco;
    String estadoEndereco;
    String numeroEndereco;

    public Endereco() {}

    public Endereco(String ruaEndereco, String bairroEndereco, String complementoEndereco,
                    String cepEndereco, String cidadeEndereco, String estadoEndereco, String numeroEndereco) {
        this.idEndereco = contadorEndereco++;
        this.ruaEndereco = ruaEndereco;
        this.bairroEndereco = bairroEndereco;
        this.complementoEndereco = complementoEndereco;
        this.cepEndereco = cepEndereco;
        this.cidadeEndereco = cidadeEndereco;
        this.estadoEndereco = estadoEndereco;
        this.numeroEndereco = numeroEndereco;
    }

    public int getIdEndereco() { return idEndereco; }

    public String getRuaEndereco() { return ruaEndereco; }
    public void setRuaEndereco(String ruaEndereco) { this.ruaEndereco = ruaEndereco; }

    public String getBairroEndereco() { return bairroEndereco; }
    public void setBairroEndereco(String bairroEndereco) { this.bairroEndereco = bairroEndereco; }

    public String getComplementoEndereco() { return complementoEndereco; }
    public void setComplementoEndereco(String complementoEndereco) { this.complementoEndereco = complementoEndereco; }

    public String getCepEndereco() { return cepEndereco; }
    public void setCepEndereco(String cepEndereco) { this.cepEndereco = cepEndereco; }

    public String getCidadeEndereco() { return cidadeEndereco; }
    public void setCidadeEndereco(String cidadeEndereco) { this.cidadeEndereco = cidadeEndereco; }

    public String getEstadoEndereco() { return estadoEndereco; }
    public void setEstadoEndereco(String estadoEndereco) { this.estadoEndereco = estadoEndereco; }

    public String getNumeroEndereco() { return numeroEndereco; }
    public void setNumeroEndereco(String numeroEndereco) { this.numeroEndereco = numeroEndereco; }

    @Override
    public String toString() {
        /* Possível variante de retorno
        return "Endereço " +
                "ID " + idEndereco +
                ":\n Rua:" + ruaEndereco + ",\n" +
                "Bairro: " + bairroEndereco + ",\n" +
                "Complemento:" + complementoEndereco + ",\n" +
                "CEP:" + cepEndereco + ",\n" +
                "Cidade: " + cidadeEndereco + ",\n" +
                "Estado: " + estadoEndereco + ",\n" +
                "Número: " + numeroEndereco;
        */

        return "Endereço " +
                "ID " + idEndereco +
                ":\n" + ruaEndereco + ", " + numeroEndereco + " - " + bairroEndereco + ", " +
        cidadeEndereco + " - " + estadoEndereco + ", CEP: " + cepEndereco +
                (complementoEndereco.isEmpty() ? "" : " (" + complementoEndereco + ")");

    }
}