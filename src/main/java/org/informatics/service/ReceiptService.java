package org.informatics.service;

import org.informatics.data.Goods;
import org.informatics.data.Receipt;

public interface ReceiptService  {
    public double calculateTotalPrice(Receipt receipt);
}
