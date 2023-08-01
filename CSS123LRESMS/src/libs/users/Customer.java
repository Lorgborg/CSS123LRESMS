package libs.users;
import libs.Database;
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
    
    public Customer(String name, char[] password){
        this.name = name;
        this.password = password;
    }
    
    public void update(){
        new Database().addCustomer(this);
    }
    
    public String getName() {
        return name;
    }

    public char[] getPassword() {
        return password;
    }
    
    // dependent on Lot
    @Override
    public void searchLots(){
        
    }
}
