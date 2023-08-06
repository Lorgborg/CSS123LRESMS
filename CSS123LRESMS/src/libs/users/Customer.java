package libs.users;
import java.util.ArrayList;
import libs.Database;
import libs.Lot;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Riniel
 */
public class Customer extends User{
    private String name;
    private char[] password;
    private ArrayList<Lot> ownedLots = new ArrayList<Lot>();
    
    public Customer(String name, char[] password){
        this.name = name;
        this.password = password;
    }
    
    public void update(){
        Database.addCustomer(this);
    }
    
    public String getName() {
        return name;
    }

    public char[] getPassword() {
        return password;
    }
    
    public ArrayList<Lot> getOwnedLots() {
        return ownedLots;
    }
    
    public void updateOwnedLots(Lot lot) {
        this.ownedLots.add(lot);
        System.out.println("added: " + lot);
    }
}
