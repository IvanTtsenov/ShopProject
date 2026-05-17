package org.informatics.service.impl;

import org.informatics.data.Goods;
import org.informatics.exceptions.ExpiredGoodsException;
import org.informatics.service.GoodsService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class GoodsServiceImpl implements GoodsService {
    int maxDaysBeforeExpDiscount = 5;
    double markUpIfEdible = 1.20;
    double markupIfNotEdible = 1.10;
    double discountIfEdible = 0.80;
    double discountIfNotEdible = 0.90;

    @Override
    public boolean isExpired(Goods goods) {
        LocalDate today = LocalDate.now();
        return today.isAfter(goods.getExpiryDate()) || today.isEqual(goods.getExpiryDate());
    }

    @Override
    public long daysUntilExpiry(Goods goods) {
        return ChronoUnit.DAYS.between(LocalDate.now(), goods.getExpiryDate());
    }

    @Override
    public double calculateSellingPrice(Goods goods) {
        if (isExpired(goods)) {
            throw new ExpiredGoodsException(goods.getName() + " has expired on: " + goods.getExpiryDate());
        }

        long days = daysUntilExpiry(goods);
        double price;

        if (goods.isEdible()) {
            price = goods.getInitialPrice() * markUpIfEdible;
            if (days < maxDaysBeforeExpDiscount) {
                price *= discountIfEdible;
            }
        } else {
            price = goods.getInitialPrice() * markupIfNotEdible;
            if (days < maxDaysBeforeExpDiscount) {
                price *= discountIfNotEdible;
            }
        }
        goods.setSellingPrice(price);
        return goods.getSellingPrice();
    }
}
