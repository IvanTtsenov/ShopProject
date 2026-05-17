package org.informatics;

import org.informatics.data.*;
import org.informatics.service.CashRegisterService;
import org.informatics.service.ReceiptService;
import org.informatics.service.ShopService;
import org.informatics.service.impl.CashRegisterServiceImpl;
import org.informatics.service.impl.ReceiptServiceImpl;
import org.informatics.service.impl.ShopServiceImpl;

import java.io.IOException;
import java.time.LocalDate;

//Alt+F12
//Git → Commit (Ctrl+K) — вместо git add + git commit
//Git → Push (Ctrl+Shift+K) — вместо git push
//Git → Pull — вместо git pull//
public class Main {
    public static void main(String[] args) {
        Goods goods1 = new Goods(
                "Milk",
                1,
                true,
                LocalDate.of(2026, 5, 27),
                5);
        Goods goods2 = new Goods(
                "Moreni",
                1.5,
                true,
                LocalDate.of(2026, 5, 27),
                2);

//        Goods goods2 = new Goods(
//                "Bread",
//                2,
//                false,
//                LocalDate.of(2025, 11, 15),
//                5);
//
//        Goods goods3 = new Goods(
//                "Chocolate",
//                10,
//                true,
//                LocalDate.of(2027, 1, 10),
//                3);
//
//        Goods goods4 = new Goods(
//                "Cheese",
//                4,
//                false,
//                LocalDate.of(2025, 8, 2),
//                2);
//
//        Goods goods5 = new Goods(
//                "Juice",
//                7,
//                true,
//                LocalDate.of(2026, 12, 31),
//                8);
        Cashier cashier1 = new Cashier("Ivan",2000);
        Cashier cashier2 = new Cashier("Petq",1800);
        Cashier cashier3 = new Cashier("Kalin",1000);
        Cashier cashier4 = new Cashier("Ivo",1500);
        CashRegister cashRegister = new CashRegister(cashier1,1);
        System.out.println(cashRegister);
        CashRegisterService cashRegisterService = new CashRegisterServiceImpl();
        cashRegisterService.addMoney(cashRegister,1000);
        System.out.println(cashRegister.getMoney());

        Receipt receipt1 = new Receipt(cashier1);
        ReceiptService receiptService = new ReceiptServiceImpl();
        receiptService.addGoods(receipt1,goods1);
        receiptService.addGoods(receipt1,goods2);
        System.out.println("Total rpice: ");
        receiptService.calculateTotalPrice(receipt1);
        System.out.println(receipt1);

        Shop shop = new Shop();
        System.out.println("Shop stringify:");
        ShopService shopService = new ShopServiceImpl();
        shopService.addCashiers(shop,cashier1);
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