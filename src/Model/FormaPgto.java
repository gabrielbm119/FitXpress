package Model;

public enum FormaPgto {
    PIX("Pix"),
    BOLETO("Boleto"),
    CREDITO("Cartão de Crédito"),
    DEBITO("Cartão de Débito");

    private final String nomeFormaPgto;

    FormaPgto(String nomeFormaPgto) {
        this.nomeFormaPgto = nomeFormaPgto;
    }

    public String getNomeFormaPgto() { return nomeFormaPgto; }

    @Override
    public String toString() {
        return nomeFormaPgto;
    }
}