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
    
    public boolean addCustomer(Customer customer){
        try {
            listOfCustomers.add(customer);
        } catch(Exception e) {
            System.out.println("Error with message: " + e);
            return false;
        }
        System.out.println("Customer " + customer.getName() + " added to db!");
        return true;
    }
}
