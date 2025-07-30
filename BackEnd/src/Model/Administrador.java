package Model;

public class Administrador {
    private final int idAdmin = 1;
    private final String nomeAdmin = "Admin";
    private final String senhaAdmin = "123";

    public Administrador() {}

    public int getIdAdmin() { return idAdmin; }
    public String getNomeAdmin() { return nomeAdmin; }
    public String getSenhaAdmin() { return senhaAdmin; }

    // Autenticação simples
    public boolean autenticarAdmin(String nome, String senha) {
        return this.nomeAdmin.equals(nome) && this.senhaAdmin.equals(senha);
    }

    @Override
    public String toString() {
        return "Administrador (ID: " + idAdmin + ") - " + nomeAdmin;
    }
}