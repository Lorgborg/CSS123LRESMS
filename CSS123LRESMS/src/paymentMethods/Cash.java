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
public class Cash implements Payment{
    private PayGUI gui = new PayGUI();
    String name, phoneNum, email, address;
    
    @Override
    public String processPayment(double amount) {
        int confirmation = JOptionPane.showConfirmDialog(gui, "Pay Php " + SearchResults.result.getPrice() + " to office to complete the purchase. The lot will not be owned but reserved.");
        Receipt receipt = new Receipt();
        if(confirmation == 0) {
            SearchResults.result.setStatus("Reserved");
            SearchResults.result.setOwner(Transaction.getTransaction().getUser());
        }
        
        receipt.setPaymentMethod("Gcash");
        receipt.addReceiptDetails("Name", Transaction.getTransaction().getUser().getName());
        receipt.addReceiptDetails("Phone number", this.phoneNum);
        receipt.addReceiptDetails("Email", this.email);
        receipt.addReceiptDetails("Block", String.valueOf(SearchResults.result.getBlock()));
        receipt.addReceiptDetails("Lot", ((Integer)SearchResults.result.getLot()).toString());
        Transaction.getTransaction().getUser().updateOwnedLots(SearchResults.result);
        return receipt.generateReceipt();
    }
    
    public void getPaymentDetails(){
        this.phoneNum = gui.getInputField1().getText();
        this.email = gui.getInputField2().getText();
        this.address = gui.getInputField3().getText();
    }
    
    public void setPaymentDetails() {
        gui.setVisible(true);
        gui.getPaymentTitle().setText("Cash");
        gui.getInputLabel1().setText("Phone number");
        gui.getInputLabel1().setPreferredSize(new Dimension(158, 29));
        gui.getInputLabel2().setText("email");
        gui.getInputLabel3().setText("Current Adress");
        gui.getPasswordLabel().setVisible(false);
        gui.getPasswordField().setVisible(false);
    }
}
