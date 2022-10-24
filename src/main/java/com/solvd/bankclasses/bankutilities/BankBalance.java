package com.solvd.bankclasses.bankutilities;

public class BankBalance {

    private int fundsId;
    private double balance;

    public BankBalance(int fundsId, double balance) {
        this.fundsId = fundsId;
        this.balance = balance;
    }

    public int getFundsId() {
        return fundsId;
    }

    public void setFundsId(int fundsId) {
        this.fundsId = fundsId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
