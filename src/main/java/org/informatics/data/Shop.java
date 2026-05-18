package org.informatics.data;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Shop {
    private Set<Cashier> cashiers;
    private Map<Goods, BigDecimal> deliveredProducts;
    private Map<Goods, BigDecimal> soldProducts;
    private Set<Receipt> receipts;

    public Shop() {
        this.cashiers = new HashSet<>();
        this.deliveredProducts = new HashMap<>();
        this.soldProducts = new HashMap<>();
        this.receipts = new HashSet<>();
    }

    public Set<Cashier> getCashiers() {
        return cashiers;
    }

    public Map<Goods, BigDecimal> getDeliveredProducts() {
        return deliveredProducts;
    }

    public Map<Goods, BigDecimal> getSoldProducts() {
        return soldProducts;
    }

    public Set<Receipt> getReceipts() {
        return receipts;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "cashiers=" + cashiers +
                ", deliveredProducts=" + deliveredProducts +
                ", soldProducts=" + soldProducts +
                ", receipts=" + receipts +
                '}';
    }
}
