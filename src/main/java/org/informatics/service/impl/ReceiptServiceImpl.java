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
        receipt.setTotalPrice(price);
        return receipt.getTotalPrice();
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
    @Override
    public void writeFile(Receipt receipt){
        try (FileOutputStream fileOutputStream = new FileOutputStream("receipt" + receipt.getIdNumber() + ".txt")) {
            fileOutputStream.write(receipt.toString().getBytes());
            System.out.println("Successfully wrote to file.");
        } catch (IOException e) {
            System.out.println("Error writing file.");
            e.printStackTrace();
        }
    }
}
