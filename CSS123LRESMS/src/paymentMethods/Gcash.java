/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paymentMethods;

import java.awt.Dimension;
import javax.swing.JOptionPane;
import libs.Transaction;
import paymentMethods.Payment;
import src.SearchResults;

/**
 *
 * @author Riniel
 */
public class Gcash implements Payment{
//    private PayGUI gui = new PayGUI();
    private String phoneNum;
    private char[] password;
    
    public void setPaymentDetails() {
        gui.setVisible(true);
        gui.getPaymentTitle().setText("Gcash");
        gui.getInputLabel1().setText("Phone Number");
        gui.getPasswordLabel().setText("Enter 4 Number Password");
        gui.getPasswordField().setPreferredSize(new Dimension(158, 29));
        gui.getInputLabel2().setVisible(false);
        gui.getInputLabel3().setVisible(false);
        gui.getInputField2().setVisible(false);
        gui.getInputField3().setVisible(false);
        
    }
    
    public void getPaymentDetails(){
        phoneNum = gui.getInputField1().getText();
        password = gui.getPasswordField().getPassword();
        
        if(password.length != 4) {
            JOptionPane.showMessageDialog(gui, "Password must be 4 numbers");
            return;
        }
        try {
            Integer.parseInt(new String(password));
            return;
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(gui, "Password must be numbers: " + e);
        }
    }
    
    @Override
    public String processPayment(double amount) {
        int confirmation = JOptionPane.showConfirmDialog(gui, "Pay Php " + SearchResults.result.getPrice() + " Using the Gcash Account " + this.phoneNum);
        Receipt receipt = new Receipt();
        if(confirmation == 0) {
            System.out.println("Processing Payment with details: " + this.phoneNum);
            SearchResults.result.setStatus("Owned");
            SearchResults.result.setOwner(Transaction.getTransaction().getUser());
        }
        
        receipt.setPaymentMethod("Gcash");
        receipt.addReceiptDetails("Phone Number", phoneNum);
        receipt.addReceiptDetails("Block", String.valueOf(SearchResults.result.getBlock()));
        receipt.addReceiptDetails("Lot", ((Integer)SearchResults.result.getLot()).toString());
        receipt.addReceiptDetails("Username", Transaction.getTransaction().getUser().getName());
        return receipt.generateReceipt();
    }
}

