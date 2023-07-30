/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;
import java.util.ArrayList;
import libs.*;

/**
 *
 * @author Riniel
 */
public class main {
    
    public static void main(String[] args) {
        LotFactory factory = new LotFactory(5, 10);
        ArrayList<Lots> lotArray = factory.CreateLots();
        for(Lots var : lotArray){
            System.out.println(var.getBlock() + ": " + var.getLot());
        }
    }
}
