package org.informatics.service.impl;

import org.informatics.data.Goods;
import org.informatics.data.Receipt;
import org.informatics.exceptions.InsufficientQuantityException;
import org.informatics.service.GoodsService;
import org.informatics.service.ReceiptService;

import java.io.*;
import java.math.BigDecimal;

public class ReceiptServiceImpl implements ReceiptService {
    private final GoodsService goodsService;

    public ReceiptServiceImpl(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @Override
    public BigDecimal calculateTotalPrice(Receipt receipt){
        BigDecimal price = receipt.getTotalPrice();
        for (Goods item : receipt.getGoods()){
            price = price.add(goodsService.calculateSellingPrice(item).multiply(item.getQuantity()));
        }
        receipt.setTotalPrice(price);
        return receipt.getTotalPrice();
    }
    @Override
    public void addGoods(Receipt receipt,Goods good,BigDecimal itemQty){
        if(itemQty.compareTo(good.getQuantity()) > 0){
            throw new InsufficientQuantityException(
                    "Insufficient quantity for: " + good.getName() +
                            " available: " + good.getQuantity() +
                            " requested: " + itemQty +
                            " missing: " + itemQty.subtract(good.getQuantity())
            );
        }else {
            receipt.getGoods().add(good);
        }
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
    @Override
    public void readFile(Receipt receipt) {
        try (FileInputStream fileInputStream = new FileInputStream("receipt" + receipt.getIdNumber() + ".txt")) {
            String content = new String(fileInputStream.readAllBytes());
            System.out.println(content);
        } catch (IOException e) {
            System.out.println("Error reading file.");
            e.printStackTrace();
        }
    }
}
