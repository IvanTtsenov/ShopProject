package org.informatics.service.impl;

import org.informatics.data.Goods;
import org.informatics.data.TypeOfGood;
import org.informatics.exceptions.ExpiredGoodsException;
import org.informatics.service.GoodsService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class GoodsServiceImpl implements GoodsService {
    int maxDaysBeforeExpDiscount = 5;
    BigDecimal markUpIfEdible = BigDecimal.valueOf(1.2);
    BigDecimal markupIfNotEdible = BigDecimal.valueOf(1.1);
    BigDecimal discountIfEdible = BigDecimal.valueOf(0.8);
    BigDecimal discountIfNotEdible = BigDecimal.valueOf(0.9);

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
    public BigDecimal calculateSellingPrice(Goods goods) {
        if (isExpired(goods)) {
            throw new ExpiredGoodsException(goods.getName() + " has expired on: " + goods.getExpiryDate());
        }

        long daysUntilExpiry = daysUntilExpiry(goods);
        BigDecimal price;

        if (goods.getIsEdible() == TypeOfGood.EDIBLE) {
            price = goods.getInitialPrice().multiply(markUpIfEdible);
            if (daysUntilExpiry < maxDaysBeforeExpDiscount) {
                price =price.multiply(discountIfEdible);
            }
        } else {
            price = goods.getInitialPrice().multiply(markupIfNotEdible);
            if (daysUntilExpiry < maxDaysBeforeExpDiscount) {
                price = price.multiply(discountIfNotEdible);
            }
        }
        return price;
    }
}
