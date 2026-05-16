package org.informatics.service.impl;

import org.informatics.data.Goods;
import org.informatics.data.Receipt;
import org.informatics.service.ReceiptService;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ReceiptServiceImpl implements ReceiptService {
    @Override
    public double calculateTotalPrice(Receipt receipt){
        double price = receipt.getTotalPrice();
        for (Goods item : receipt.getGoods()){
            price += item.getSellingPrice();
        }
        return  price;
    }
    @Override
    public void serializeObj(Receipt receipt, String filename) throws IOException {
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(filename);
                ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
                )
        {
                outputStream.writeObject(receipt);
        }
    }
}
