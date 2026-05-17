package org.informatics.data;

import org.informatics.exceptions.ExpiredGoodsException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.UUID;

public class Goods {
    private final UUID uuid;
    private String name;
    private double initialPrice;
    private double sellingPrice;
    private boolean isEdible;
    private LocalDate expiryDate;
    private int quantity;

    public Goods(String name, double initialPrice, boolean isEdible, LocalDate expiryDate, int quantity) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.initialPrice = initialPrice;
        this.isEdible = isEdible;
        this.expiryDate = expiryDate;
        this.quantity = quantity;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(double initialPrice) {
        this.initialPrice = initialPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    //    public long daysUntilExpiry(){
//        LocalDate today = LocalDate.now();
//        long days = ChronoUnit.DAYS.between(today, this.expiryDate);
//        return days;
//    }

//    public void setSellingPrice(double initialPrice) {
//            if(isExpired()){
//                throw new ExpiredGoodsException(this.name + " has expired on: " + this.expiryDate);
//            }
//            long days = daysUntilExpiry();
//            if (isEdible) {
//                double price = initialPrice * markUpIfEdible;
//                if (days < maxDaysBeforeExpDiscount) {
//                    price *= discountIfEdible;
//                }
//                this.sellingPrice = price;
//            } else {
//                double price = initialPrice * markupIfNotEdible;
//                if (days < maxDaysBeforeExpDiscount) {
//                    price *= discountIfNotEdible;
//                }
//                this.sellingPrice = price;
//            }
//    }

    public boolean isEdible() {
        return isEdible;
    }

    public void setEdible(boolean edible) {
        this.isEdible = edible;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //public boolean isExpired(){
        //return LocalDate.now().isAfter(expiryDate) || LocalDate.now().isEqual(expiryDate);
   // }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return Objects.equals(uuid, goods.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(uuid);
    }

    @Override
    public String toString() {
        return "Goods{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", initialPrice=" + initialPrice +
                ", sellingPrice=" + sellingPrice +
                ", isEdible=" + isEdible +
                ", expiryDate=" + expiryDate +
                ", quantity=" + quantity +
                '}';
    }
}
