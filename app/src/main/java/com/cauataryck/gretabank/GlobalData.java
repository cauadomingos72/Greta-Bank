package com.cauataryck.gretabank;

public class GlobalData {
    private static GlobalData instance;
    private double saldo = 17.80;

    private GlobalData() {
    }

    public static synchronized GlobalData getInstance() {
        if (instance == null) {
            instance = new GlobalData();
        }
        return instance;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double novoSaldo) {
        saldo = novoSaldo;
    }
}
