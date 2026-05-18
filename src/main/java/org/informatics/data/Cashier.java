package org.informatics.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class Cashier implements Serializable {
    private final UUID uuid;
    private String name;
    private BigDecimal wage;

    public Cashier(String name, BigDecimal wage) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.wage = wage;
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

    public BigDecimal getWage() {
        return wage;
    }

    public void setWage(BigDecimal wage) {
        this.wage = wage;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cashier cashier = (Cashier) o;
        return Objects.equals(uuid, cashier.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(uuid);
    }

    @Override
    public String toString() {
        return "Cashier{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", wage=" + wage +
                '}';
    }
}
