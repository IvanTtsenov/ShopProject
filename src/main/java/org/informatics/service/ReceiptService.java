package org.informatics.service;

import org.informatics.data.Goods;
import org.informatics.data.Receipt;
import org.informatics.data.Shop;


import java.io.IOException;

public interface ReceiptService  {
    public double calculateTotalPrice(Receipt receipt);
    public void addGoods(Receipt receipt, Goods good);
    public void serializeObj(Receipt receipt, String filename) throws IOException;
    Receipt deserializeObj(String filename) throws IOException, ClassNotFoundException;
    public  void writeFile(Receipt receipt);
    public void readFile(Receipt receipt);
}
