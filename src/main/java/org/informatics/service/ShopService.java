package org.informatics.service;

import org.informatics.data.Cashier;
import org.informatics.data.Goods;
import org.informatics.data.Receipt;
import org.informatics.data.Shop;

import java.util.Map;
import java.util.Set;

public interface ShopService {
    public void addCashiers(Shop shop, Cashier cashier);
    public void addDeliveredProduct(Shop shop,Goods goods);
    public void addSoldProduct(Shop shop,Goods goods);
    public void addReceipt(Shop shop,Receipt receipt);
    public double calculateExpenses(Shop shop);
    public double calculateIncome(Shop shop);
    public double calculateProfit(Shop shop);
}
