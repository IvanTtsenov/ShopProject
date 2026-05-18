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
        Goods goods1 = new Goods(
                "Milk",
                BigDecimal.valueOf(1),
                TypeOfGood.EDIBLE,
                LocalDate.of(2026, 5, 27),
                BigDecimal.valueOf(5));
        Goods goods2 = new Goods(
                "Moreni",
                BigDecimal.valueOf(1.5),
                TypeOfGood.NOT_EDIBLE,
                LocalDate.of(2026, 5, 27),
                BigDecimal.valueOf(2));

        GoodsService goodsService = new GoodsServiceImpl();
        goodsService.calculateSellingPrice(goods1);
        goodsService.calculateSellingPrice(goods2);
        System.out.println("!!!Print Goods:");
        System.out.println(goods1);


        Cashier cashier1 = new Cashier("Ivan",BigDecimal.valueOf(2000));
        Cashier cashier2 = new Cashier("Petq",BigDecimal.valueOf(1800));
        Cashier cashier3 = new Cashier("Kalin",BigDecimal.valueOf(1000));
        Cashier cashier4 = new Cashier("Ivo",BigDecimal.valueOf(1500));
        CashRegister cashRegister = new CashRegister(cashier1,1);
        System.out.println("!!!!Print cashRegister: ");
        CashRegisterService cashRegisterService = new CashRegisterServiceImpl();
        System.out.println(cashRegister);

        Receipt receipt1 = new Receipt(cashier1);
        Receipt receipt2 = new Receipt(cashier1);
        ReceiptService receiptService = new ReceiptServiceImpl(goodsService);
        receiptService.addGoods(receipt1,goods1);
        receiptService.addGoods(receipt1,goods2);
        receiptService.calculateTotalPrice(receipt1);
        System.out.println("WRITE RECEIPT:");
        receiptService.writeFile(receipt1);
        receiptService.writeFile(receipt2);
        System.out.println("READ RECEIPT:");
        receiptService.readFile(receipt1);
        System.out.println("!!!!Print receipt1:");
        System.out.println(receipt1);

        Shop shop = new Shop();
        ShopService shopService = new ShopServiceImpl(goodsService);
        shopService.addCashiers(shop,cashier1);
        shopService.addDeliveredProduct(shop,goods1);
        shopService.addDeliveredProduct(shop,goods2);
        shopService.addReceipt(shop,receipt1);
        shopService.calculateExpenses(shop);
        shopService.addSoldProduct(shop,goods1);
        shopService.addSoldProduct(shop,goods2);
        shopService.calculateIncome(shop);
        shopService.calculateProfit(shop);
        System.out.println("!!!!Print shop");
        System.out.println(shop);











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