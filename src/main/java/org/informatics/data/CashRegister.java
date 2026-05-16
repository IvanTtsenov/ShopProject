package org.informatics.data;

import java.util.Objects;

public class CashRegister {
    private Cashier cashier;
    private double money;
    private int registerNumber;

    public CashRegister(Cashier cashier, int registerNumber) {
        this.cashier = cashier;
        this.registerNumber = registerNumber;
        this.money = 0;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(int registerNumber) {
        this.registerNumber = registerNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CashRegister that = (CashRegister) o;
        return registerNumber == that.registerNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(registerNumber);
    }

    @Override
    public String toString() {
        return "CashRegister{" +
                "cashier=" + cashier +
                ", money=" + money +
                ", registerNumber=" + registerNumber +
                '}';
    }
}
