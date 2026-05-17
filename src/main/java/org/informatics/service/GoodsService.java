package org.informatics.service;

public interface GoodsService {
        boolean isExpired(Goods goods);
        long daysUntilExpiry(Goods goods);
        double calculateSellingPrice(Goods goods);
        void applySellingPrice(Goods goods);
}
