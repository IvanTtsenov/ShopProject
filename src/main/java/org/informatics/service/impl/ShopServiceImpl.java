package org.informatics.service.impl;

import org.informatics.data.Cashier;
import org.informatics.data.Goods;
import org.informatics.data.Receipt;
import org.informatics.data.Shop;
import org.informatics.service.GoodsService;
import org.informatics.service.ShopService;

import java.math.BigDecimal;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private final GoodsService goodsService;

    public ShopServiceImpl(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @Override
    public void addCashiers(Shop shop,Cashier cashier){
        shop.getCashiers().add(cashier);
    }
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
    public BigDecimal calculateExpenses(Shop shop){
        BigDecimal wages = BigDecimal.ZERO;
        for (Cashier cashier : shop.getCashiers()){
            wages = wages.add(cashier.getWage());
        }

        BigDecimal goodsCost = BigDecimal.ZERO;
        for (Map.Entry<Goods, BigDecimal> entry : shop.getDeliveredProducts().entrySet()){
            Goods goods = entry.getKey();
            BigDecimal quantity = entry.getValue();
            goodsCost =goodsCost.add(goods.getInitialPrice().multiply(quantity));
        }
        BigDecimal expenses = wages.add(goodsCost);
        return expenses;
    }
    @Override
    public BigDecimal calculateIncome(Shop shop){
        BigDecimal income = BigDecimal.ZERO;
        for (Map.Entry<Goods, BigDecimal> entry : shop.getSoldProducts().entrySet()){
            Goods goods = entry.getKey();
            BigDecimal quantity = entry.getValue();
            income =income.add(goodsService.calculateSellingPrice(goods).multiply(quantity));
        }
        return income;
    }
    @Override
    public BigDecimal calculateProfit(Shop shop){
        BigDecimal profit = calculateIncome(shop).subtract(calculateExpenses(shop));
        return profit;
    }
}
