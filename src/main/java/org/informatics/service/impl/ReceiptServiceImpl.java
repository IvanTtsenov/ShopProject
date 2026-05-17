package org.informatics.service.impl;

import org.informatics.data.Goods;
import org.informatics.data.Receipt;
import org.informatics.service.ReceiptService;

import java.io.*;

public class ReceiptServiceImpl implements ReceiptService {
    @Override
    public double calculateTotalPrice(Receipt receipt){
        double price = receipt.getTotalPrice();
        for (Goods item : receipt.getGoods()){
            price += item.getSellingPrice() * item.getQuantity();
        }
        return  price;
    }
    @Override
    public void addGoods(Receipt receipt,Goods good){
        receipt.getGoods().add(good);
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
    @Override
    public Receipt deserializeObj(String filename) throws IOException, ClassNotFoundException {
        try (
                FileInputStream fileInputStream = new FileInputStream(filename);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                )
        {
            return (Receipt) objectInputStream.readObject();
        }
    }
}
