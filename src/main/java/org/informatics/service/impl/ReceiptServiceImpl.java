package org.informatics.service.impl;

import org.informatics.data.Goods;
import org.informatics.data.Receipt;
import org.informatics.service.ReceiptService;

public class ReceiptServiceImpl implements ReceiptService {
    @Override
    public double calculateTotalPrice(Receipt receipt){
        double price = receipt.getTotalPrice();
        for (Goods item : receipt.getGoods()){
            price += item.getSellingPrice();
        }
        return  price;
    }
}
