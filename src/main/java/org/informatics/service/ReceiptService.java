package org.informatics.service;

import org.informatics.data.Goods;
import org.informatics.data.Receipt;

import java.io.File;
import java.io.IOException;

public interface ReceiptService  {
    public double calculateTotalPrice(Receipt receipt);
    public void serializeObj(Receipt receipt, String filename) throws IOException;

}
