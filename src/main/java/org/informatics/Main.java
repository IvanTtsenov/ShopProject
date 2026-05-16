package org.informatics;

import org.informatics.data.Cashier;
import org.informatics.data.Receipt;
import org.informatics.service.ReceiptService;
import org.informatics.service.impl.ReceiptServiceImpl;

import java.io.IOException;

//Alt+F12
//Git → Commit (Ctrl+K) — вместо git add + git commit
//Git → Push (Ctrl+Shift+K) — вместо git push
//Git → Pull — вместо git pull//
public class Main {
    public static void main(String[] args) {
        Cashier cashier = new Cashier("Ivan",2000);
        Receipt receipt = new Receipt(cashier);
        Receipt receipt1 = new Receipt(cashier);
        Receipt receipt2 = new Receipt(cashier);
        String filename = "receipt.ser";
        ReceiptService receiptService = new ReceiptServiceImpl();
        try {
            //receiptService.serializeObj(receipt,filename);
           //receiptService.serializeObj(receipt1,filename);
            receiptService.serializeObj(receipt2,filename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {

            System.out.println( receiptService.deserializeObj(filename));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    }