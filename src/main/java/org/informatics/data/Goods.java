package org.informatics.data;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Goods implements Serializable {
    private final UUID uuid;
    private String name;
    private BigDecimal initialPrice;
    private TypeOfGood isEdible;
    private LocalDate expiryDate;
    private BigDecimal quantity;

    public Goods(String name, BigDecimal initialPrice, TypeOfGood isEdible, LocalDate expiryDate, BigDecimal quantity) {
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

    public BigDecimal getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(BigDecimal initialPrice) {
        this.initialPrice = initialPrice;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public TypeOfGood getIsEdible() {
        return isEdible;
    }

    public void setIsEdible(TypeOfGood isEdible) {
        this.isEdible = isEdible;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", initialPrice=" + initialPrice +
                ", isEdible=" + isEdible +
                ", expiryDate=" + expiryDate +
                ", quantity=" + quantity +
                '}';
    }

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

}
