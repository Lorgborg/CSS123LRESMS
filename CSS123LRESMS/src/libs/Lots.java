/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libs;

import java.util.Comparator;
import libs.users.Customer;

/**
 *
 * @author Riniel
 */
public class Lots {
    private int size, price, lot;
    private String status;
    private char block;
    private Customer owner;
    
    public Lots(int size, int price, int lot, char block, String status){
        this.size = size;
        this.price = price;
        this.status = status;
        this.block = block;
        this.lot = lot;
    }

    public int getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public char getBlock() {
        return block;
    }

    public int getLot() {
        return lot;
    }
    
    public void Owner(Customer ownerInput){
        this.owner = ownerInput;
    }
    
    public static Comparator<Lots> orderLotSize = new Comparator<Lots>() {
        public int compare(Lots s1, Lots s2) {
            int size1 = s1.getSize();
            int size2 = s2.getSize();
            return size1 - size2;
        }
    };
    
    public static Comparator<Lots> orderLotPrice = new Comparator<Lots>() {
        public int compare(Lots s1, Lots s2) {
            int size1 = s1.getPrice();
            int size2 = s2.getPrice();
            return size1 - size2;
        }
    };
}