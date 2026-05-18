package org.informatics.service;

import org.informatics.data.Cashier;
import org.informatics.data.Goods;
import org.informatics.data.Receipt;
import org.informatics.data.Shop;

import java.math.BigDecimal;

public interface ShopService {
    public void addCashiers(Shop shop, Cashier cashier);
    public void addDeliveredProduct(Shop shop,Goods goods);
    public void addSoldProduct(Shop shop,Goods goods);
    public void addReceipt(Shop shop,Receipt receipt);
    public BigDecimal calculateExpenses(Shop shop);
    public BigDecimal calculateIncome(Shop shop);
    public BigDecimal calculateProfit(Shop shop);
}
