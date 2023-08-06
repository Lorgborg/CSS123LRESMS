/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libs;

import libs.users.Customer;
import java.util.ArrayList;

/**
 *
 * @author Riniel
 */
public class Database {
    public static ArrayList<Customer> listOfCustomers = new ArrayList<Customer>();
    private final ArrayList<Lot> listOfLots = createLots(new ArrayList<Lot>());
    private static Database databaseInstance;
    
    private Database() {
        
    }
    
    public static Database getDatabase() {
        if(databaseInstance == null) {
            databaseInstance = new Database();
        }
        return databaseInstance;
    }
    
    public ArrayList<Lot> createLots(ArrayList<Lot> a) {
        char block = 'A';
        for(int i = 0; i < 10; i++){            
            
            for(int j = 0; j < 10; j++){
                int sizeDeviance = (int)(Math.random() * 10) + 1;
                int priceDeviance = (int)(Math.random() * 10000) + 1;
                a.add(new Lot(100 + sizeDeviance, 1000 + priceDeviance, j+1, block, "Unoccupied"));
            }
            ++block;
        }
        return a;
    }
    
    public static boolean addCustomer(Customer customer){
        try {
            listOfCustomers.add(customer);
        } catch(Exception e) {
            System.out.println("Error with message: " + e);
            return false;
        }
        System.out.println("Customer " + customer.getName() + " added to db!");
        return true;
    }

    public ArrayList<Lot> getListOfLots() {
        return listOfLots;
    }
    
    
    
}
