package org.informatics;

import org.informatics.data.*;
import org.informatics.service.CashRegisterService;
import org.informatics.service.GoodsService;
import org.informatics.service.ReceiptService;
import org.informatics.service.ShopService;
import org.informatics.service.impl.CashRegisterServiceImpl;
import org.informatics.service.impl.GoodsServiceImpl;
import org.informatics.service.impl.ReceiptServiceImpl;
import org.informatics.service.impl.ShopServiceImpl;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

//Alt+F12
//Git → Commit (Ctrl+K) — вместо git add + git commit
//Git → Push (Ctrl+Shift+K) — вместо git push
//Git → Pull — вместо git pull//
public class Main {
    public static void main(String[] args) {
        //Goods
        Goods goods1 = new Goods(
                "Milk",
                BigDecimal.valueOf(1),
                TypeOfGood.EDIBLE,
                LocalDate.of(2026, 5, 27),
                BigDecimal.valueOf(5));

        GoodsService goodsService = new GoodsServiceImpl();
        goodsService.calculateSellingPrice(goods1);

        //Cashiers
        Cashier cashier1 = new Cashier("Ivan",BigDecimal.valueOf(2000));

        //CashRegisters
        CashRegister cashRegister = new CashRegister(cashier1,1);
        CashRegisterService cashRegisterService = new CashRegisterServiceImpl();

        //Shop
        Shop shop = new Shop();
        ShopService shopService = new ShopServiceImpl(goodsService);
        shopService.addCashiers(shop,cashier1);
        shopService.addDeliveredProduct(shop,goods1);

        //Receipts
        Receipt receipt1 = new Receipt(cashier1);
        ReceiptService receiptService = new ReceiptServiceImpl(goodsService);
        String filename = "receipt.ser";
        receiptService.addGoods(receipt1,goods1,BigDecimal.valueOf(5));
        receiptService.calculateTotalPrice(receipt1);
        receiptService.writeFile(receipt1);
        receiptService.readFile(receipt1);

        try {
            receiptService.serializeObj(receipt1,filename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            receiptService.deserializeObj(filename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


//        receiptService.calculateTotalPrice(receipt1);
//        System.out.println("WRITE RECEIPT:");
//        receiptService.writeFile(receipt1);
//        receiptService.writeFile(receipt2);
//        System.out.println("READ RECEIPT:");
//        receiptService.readFile(receipt1);
//        System.out.println("!!!!Print receipt1:");
//        System.out.println(receipt1);













//        Cashier cashier = new Cashier("Ivan",2000);
//        Receipt receipt = new Receipt(cashier);
//        Receipt receipt1 = new Receipt(cashier);
//        Receipt receipt2 = new Receipt(cashier);
//        String filename = "receipt.ser";
//        ReceiptService receiptService = new ReceiptServiceImpl();
//        try {
//            //receiptService.serializeObj(receipt,filename);
//           //receiptService.serializeObj(receipt1,filename);
//            receiptService.serializeObj(receipt2,filename);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        try {
//
//            System.out.println( receiptService.deserializeObj(filename));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
    }
    }