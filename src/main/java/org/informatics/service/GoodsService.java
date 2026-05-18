package org.informatics.service;

import org.informatics.data.Goods;

import java.math.BigDecimal;

public interface GoodsService {
        boolean isExpired(Goods goods);
        long daysUntilExpiry(Goods goods);
        BigDecimal calculateSellingPrice(Goods goods);
}
