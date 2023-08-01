/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paymentMethods;

import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author Riniel
 */
public class Receipt {
    private String paymentMethod;
    HashMap<String, String> receiptDetails = new HashMap<String, String>();
    
    public void setPaymentMethod(String paymentMethod){
        this.paymentMethod = paymentMethod;
    }
    
    public void addReceiptDetails(String key, String val){
        this.receiptDetails.put(key, val);
    }
    
    public String generateReceipt(){
        Date date = new Date();
        String receipt = "Better Call Sales" + paymentMethod;
        for(String item : this.receiptDetails.keySet()) {
            receipt += "\n";
            receipt += item + ": " + this.receiptDetails.get(item);
        }
        receipt += "\n Generated " + date.toString();
        return receipt;
    }
}
