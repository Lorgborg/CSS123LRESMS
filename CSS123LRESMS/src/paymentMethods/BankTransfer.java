/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paymentMethods;

import java.awt.Dimension;
import javax.swing.JOptionPane;
import libs.Transaction;
import src.SearchResults;

/**
 *
 * @author Riniel
 */
public class BankTransfer implements Payment{
    private PayGUI gui = new PayGUI();
    private String creditCardNum, validThru, memSince;
    private char[] cv;
    
    public void setPaymentDetails() {
        gui.setVisible(true);
        gui.getPaymentTitle().setText("Bank Transfer");
        gui.getInputLabel3().setText("Credit Card Number");
        gui.getInputLabel2().setText("Valid Thru");
        gui.getInputLabel1().setText("Member Since");
        gui.getPasswordLabel().setText("CV");
        gui.getPasswordField().setPreferredSize(new Dimension(158, 29));
        
    }
    
    public void getPaymentDetails(){
        creditCardNum = gui.getInputField3().getText();
        validThru = gui.getInputField2().getText();
        memSince = gui.getInputField1().getText();
        cv = gui.getPasswordField().getPassword();
        
        try {
            Integer.parseInt(new String(cv));
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(gui, "cv must be numbers: ");
        }
    }
    
    @Override
    public String processPayment(double amount) {
        int confirmation = JOptionPane.showConfirmDialog(gui, "Pay Php " + SearchResults.result.getPrice() + " Using the Credit Card Account " + this.creditCardNum);
        Receipt receipt = new Receipt();
        if(confirmation == 0) {
            SearchResults.result.setStatus("Owned");
            SearchResults.result.setOwner(Transaction.getTransaction().getUser());
        }
        
        receipt.setPaymentMethod("Bank Transfer");
        receipt.addReceiptDetails("Credit Card Number", this.creditCardNum);
        receipt.addReceiptDetails("Block", String.valueOf(SearchResults.result.getBlock()));
        receipt.addReceiptDetails("Lot", ((Integer)SearchResults.result.getLot()).toString());
        receipt.addReceiptDetails("Username", Transaction.getTransaction().getUser().getName());
        Transaction.getTransaction().getUser().updateOwnedLots(SearchResults.result);
        return receipt.generateReceipt();
    }
}
