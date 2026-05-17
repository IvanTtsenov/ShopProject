package org.informatics.service;

import org.informatics.data.Goods;

public interface GoodsService {
        boolean isExpired(Goods goods);
        long daysUntilExpiry(Goods goods);
        double calculateSellingPrice(Goods goods);
}
