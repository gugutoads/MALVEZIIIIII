package model;

public class ContaCorrente extends Conta {
    private double limite;

    public ContaCorrente(int numero, double limite) {
        super(numero, "Corrente");
        this.limite = limite;
    }

    @Override
    public String consultarDetalhes() {
        return "Conta Corrente - Número: " + getNumero() + ", Saldo: R$" + getSaldo() + ", Limite: R$" + limite;
    }
}
