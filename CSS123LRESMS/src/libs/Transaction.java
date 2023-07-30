/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libs;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import libs.users.*;
import src.LogIn;

/**
 *
 * @author Riniel
 */
public class Transaction implements Mediator {
    private User user;
    private boolean userValidated;
    
    
    public Transaction(String username, char[] password, boolean isRealtor){
        
        if(isRealtor){
            if(username.equals(Realtor.getUsername()) && Arrays.equals(Realtor.getPass(), password)) {
                this.user = new Realtor();
                JOptionPane.showMessageDialog(new LogIn(true), "Welcome Realtor " + this.user.getName());
                return;
            }
        }
        
        Database.listOfCustomers.forEach((customerDB)-> {
            
            // ------- initiating database checks --------
            // database is not empty
            
            if(Database.listOfCustomers.size() == 0) {
                System.out.println("Size is 0");
                return;
            }
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
            JOptionPane.showMessageDialog(new LogIn(false), "welcome" + this.user.getName());
            return;
        });
       
        if(!this.userValidated){
            System.out.println("New Customer created");
            this.user = new Customer(username, password);
            this.user.update();
            JOptionPane.showMessageDialog(new LogIn(false), "Registered user: " + this.user.getName());
        }
    }
    
    @Override
    public void logOn(Customer user){
        
    }
    
    public void purchase(){
        
    }
    
}
