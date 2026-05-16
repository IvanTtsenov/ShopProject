package org.informatics.data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class Receipt implements Serializable {
    private static long counter = 0;
    private long idNumber;
    private Cashier cashier;
    private LocalDateTime time;
    private ArrayList<Goods> goods;
    private double totalPrice;

    public Receipt(Cashier cashier) {
        this.idNumber = counter++;
        this.cashier = cashier;
        this.time = LocalDateTime.now();
        this.goods = new ArrayList<>();
        this.totalPrice = 0;
    }

    public long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public ArrayList<Goods> getGoods() {
        return goods;
    }

    public void setGoods(ArrayList<Goods> goods) {
        this.goods = goods;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Receipt receipt = (Receipt) o;
        return idNumber == receipt.idNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idNumber);
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "idNumber=" + idNumber +
                ", cashier=" + cashier +
                ", time=" + time +
                ", goods=" + goods +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
