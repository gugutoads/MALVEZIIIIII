package model;

import java.io.Serializable;

public abstract class Conta implements Serializable {
    private int numero;
    private double saldo;
    private String tipoConta;

    public Conta(int numero, String tipoConta) {
        this.numero = numero;
        this.tipoConta = tipoConta;
        this.saldo = 0.0;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public abstract String consultarDetalhes();
}
