package org.informatics.data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Shop {
    private Set<Cashier> cashiers;
    private Map<Goods, Integer> deliveredProducts;
    private Map<Goods, Integer> soldProducts;
    private Set<Receipt> receipts;
    private double expenses;
    private double income;
    private double profit;

    public Shop() {
        this.cashiers = new HashSet<>();
        this.deliveredProducts = new HashMap<>();
        this.soldProducts = new HashMap<>();
        this.receipts = new HashSet<>();
        this.expenses = 0;
        this.income = 0;
        this.profit = 0;
    }

    public Set<Cashier> getCashiers() {
        return cashiers;
    }

    public void addCashier(Cashier cashier) {
        cashiers.add(cashier);
    }


    public Map<Goods, Integer> getDeliveredProducts() {
        return deliveredProducts;
    }

    public Map<Goods, Integer> getSoldProducts() {
        return soldProducts;
    }

    public Set<Receipt> getReceipts() {
        return receipts;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "cashiers=" + cashiers +
                ", deliveredProducts=" + deliveredProducts +
                ", soldProducts=" + soldProducts +
                ", receipts=" + receipts +
                ", expenses=" + expenses +
                ", income=" + income +
                ", profit=" + profit +
                '}';
    }
}
