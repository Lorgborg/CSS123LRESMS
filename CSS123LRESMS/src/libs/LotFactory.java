/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libs;
import java.util.ArrayList;

/**
 *
 * @author Riniel
 */
public class LotFactory {
    private int amountOfBlocks;
    private int amountOfLots;
    
    public LotFactory(int amountOfBlocks, int amountOfLots) {
        this.amountOfBlocks = amountOfBlocks;
        this.amountOfLots = amountOfLots;
    }
    
    public void CreateLots(){
        char block = 'A';
        for(int i = 0; i < amountOfBlocks; i++){            
            
            for(int j = 0; j < amountOfLots; j++){
                int sizeDeviance = (int)(Math.random() * 10) + 1;
                int priceDeviance = (int)(Math.random() * 10000) + 1;
                Database.getLots().add(new Lot(100 + sizeDeviance, 1000 + priceDeviance, j+1, block, "Unoccupied"));
            }
            
            ++block;
        }
    }
}
