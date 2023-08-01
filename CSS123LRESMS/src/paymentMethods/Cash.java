/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paymentMethods;

import java.awt.Dimension;
import libs.Transaction;
import src.SearchResults;

/**
 *
 * @author Riniel
 */
public class Cash implements Payment{
    private PayGUI gui = new PayGUI();
    
    @Override
    public String processPayment(double amount) {
        return "";
    }
    
    public void getPaymentDetails(){
        
    }
    
    public void setPaymentDetails() {
        gui.getPaymentTitle().setText("Cash");
        gui.getInputLabel1().setText("Phone number");
        gui.getInputLabel1().setPreferredSize(new Dimension(158, 29));
        gui.getInputLabel2().setText("email");
        gui.getInputLabel3().setText("Current Adress");
        gui.getPasswordLabel().setVisible(false);
        SearchResults.result.setStatus("Reserved");
        SearchResults.result.setOwner(Transaction.getTransaction().getUser());
    }
}
