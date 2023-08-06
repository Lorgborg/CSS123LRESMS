/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libs;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import libs.users.*;
import src.CustomerDashboard;
import src.LogIn;
import src.RealtorDashboard;
import src.SearchGUI;

/**
 *
 * @author Riniel
 */
public class Transaction{
    private User user;
    private boolean userValidated;
    private static Transaction transactionInstance;
    
    private Transaction(){
        
    }
    
    public static Transaction getTransaction(){
        if(transactionInstance == null){
            transactionInstance = new Transaction();
        }
        return transactionInstance;
    }
    
    
    public void validateTransactionSession(String username, char[] password, boolean isRealtor){
        if(isRealtor){
            if(username.equals(Realtor.getUsername()) && Arrays.equals(Realtor.getPass(), password)) {
                this.user = new Realtor();
                JOptionPane.showMessageDialog(new LogIn(true), "Welcome Realtor " + Realtor.getUsername());
                new RealtorDashboard().setVisible(true);
                return;
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect Realtor Details");
                return;
            }
        }
        
        Database.listOfCustomers.forEach((customerDB) -> { 
            
            // ------- initiating database checks --------
            if(Database.listOfCustomers.size() == 0) {
                System.out.println("Size is 0");
                return;
            }            // database is not empty
            

            // username transaction is found within customer database
            if(!customerDB.getName().equals(username)){
                System.out.println("username not found");
                return;
            }
            // user password transaction is found within customer database
            if(!Arrays.equals(customerDB.getPassword(), password)){
                return;
            }
            
            // checks are validated, user in session is used
            this.userValidated = true;
            this.user = customerDB;
            JOptionPane.showMessageDialog(new LogIn(false), "welcome " + this.user.getName());
            new CustomerDashboard(customerDB).setVisible(true);
            for(Lot lot : customerDB.getOwnedLots()) {
                System.out.println("name: " + customerDB.getName() + ": block" + lot.getBlock() + " lot" + lot.getLot());
            }
            return;
        });
       
        if(!this.userValidated){
            System.out.println("New Customer created");
            this.user = new Customer(username, password);
            this.user.update();
            JOptionPane.showMessageDialog(new LogIn(false), "Registered user: " + this.user.getName());
            new SearchGUI().setVisible(true);
        }
    }
    
    public void searchLots(){
        this.user.searchLots();
    }
    
    public User getUser(){
        return this.user;
    }
    
}
