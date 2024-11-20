package model;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(int numero) {
        super(numero, "Poupança");
    }

    @Override
    public String consultarDetalhes() {
        return "Conta Poupança - Número: " + getNumero() + ", Saldo: R$" + getSaldo();
    }
}
