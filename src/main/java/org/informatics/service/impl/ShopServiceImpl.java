package org.informatics.service.impl;

import org.informatics.data.Cashier;
import org.informatics.data.Goods;
import org.informatics.data.Receipt;
import org.informatics.data.Shop;
import org.informatics.service.ShopService;

import java.util.Map;

public class ShopServiceImpl implements ShopService {
    @Override
    public void addDeliveredProduct(Shop shop, Goods goods) {
        shop.getDeliveredProducts().put(goods, goods.getQuantity());
    }
    @Override
    public void addSoldProduct(Shop shop,Goods goods) {
        shop.getSoldProducts().put(goods, goods.getQuantity());
    }
    @Override
    public void addReceipt(Shop shop,Receipt receipt) {
        shop.getReceipts().add(receipt);
    }

    @Override
    public double calculateExpenses(Shop shop){
        double wages = 0;
        for (Cashier cashier : shop.getCashiers()){
            wages += cashier.getWage();
        }

        double goodsCost = 0;
        for (Map.Entry<Goods, Integer> entry : shop.getDeliveredProducts().entrySet()){
            Goods goods = entry.getKey();
            int quantity = entry.getValue();
            goodsCost += goods.getInitialPrice() * quantity;
        }

        shop.setExpenses(wages + goodsCost);
        return shop.getExpenses();
    }
    @Override
    public double calculateIncome(Shop shop){
        double income = 0;
        for (Map.Entry<Goods, Integer> entry : shop.getSoldProducts().entrySet()){
            Goods goods = entry.getKey();
            int quantity = entry.getValue();
            income += goods.getSellingPrice() * quantity;
        }
        shop.setIncome(income);
        return shop.getIncome();
    }
    @Override
    public double calculateProfit(Shop shop){
        double profit = shop.getIncome() - shop.getExpenses();
        shop.setProfit(profit);
        return shop.getProfit();
    }
}
