/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libs.users;
import java.util.ArrayList;
import libs.Database;
import libs.Lot;

/**
 *
 * @author Riniel
 */
public abstract class User {
    private String username;
    private char[] password;
    
    public String getName() {
        return username;
    }

    public char[] getPassword() {
        return password;
    }
    
    public abstract void update();
    public void updateOwnedLots(Lot lot){
        
    }
    public ArrayList<Lot> getOwnedLots(){
        return null;
    }
    
}
