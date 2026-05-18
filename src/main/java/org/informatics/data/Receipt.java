package org.informatics.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

public class Receipt implements Serializable {
    private static long counter = 0;
    private long idNumber;
    private Cashier cashier;
    private LocalDateTime time;
    private ArrayList<Goods> goods;
    private BigDecimal totalPrice;

    public Receipt(Cashier cashier) {
        this.idNumber = counter++;
        this.cashier = cashier;
        this.time = LocalDateTime.now();
        this.goods = new ArrayList<>();
        this.totalPrice = BigDecimal.ZERO;
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

    public BigDecimal getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
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
                ", time=" + time.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")) +
                ", goods=" + goods +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
