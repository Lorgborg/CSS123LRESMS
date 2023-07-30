/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libs;

/**
 *
 * @author Riniel
 */
public class Lots {
    private int size, price, lot;
    private String status;
    private char block;
    
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
    
}