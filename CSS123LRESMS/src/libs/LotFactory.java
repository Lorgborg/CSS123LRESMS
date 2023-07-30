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
    
    public ArrayList<Lots> CreateLots(){
        char block = 'A';
        ArrayList<Lots> lotArray = new ArrayList<Lots>();
        for(int i = 0; i < amountOfBlocks; i++){            
            
            for(int j = 0; j < amountOfLots; j++){
                lotArray.add(new Lots(10, 10, j+1, block, "Unoccupied"));
            }
            
            ++block;
        }
        
        return lotArray;
    }
}
