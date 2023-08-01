/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libs.search;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import libs.Lots;
import src.SearchGUI;

/**
 *
 * @author Riniel
 */
public class Filter implements Search {
    public ArrayList<Lots> filterData(ArrayList<Lots> unsorted, char block, String minPrice, String maxPrice, String minSize, String maxSize, String lot){
        String[] stringConstraints = {minPrice, maxPrice, minSize, maxSize};
        if(block != ' ') {
            unsorted.removeIf(filter -> filter.getBlock() != block);
        }
        
        if(!lot.isEmpty()) {
            int lotInt = Integer.parseInt(lot);
            unsorted.removeIf(filter -> filter.getLot() != lotInt);
            return unsorted;
        }
        
        int[] intConstraints = new int[5];;
        int i = 0;
        boolean hasMaxPrice = true;
        boolean hasMaxSize = true;
        for(String constraint : stringConstraints) {
            int processedConstraint = 0;
            if(!constraint.isEmpty()) {
                try {
                    processedConstraint = Integer.parseInt(constraint);
                } catch (Error e) {
                    JOptionPane.showMessageDialog(new SearchGUI(), "Constaint must either be empty or a non decimal number");
                }
            } else {
                if(i % 2 == 0){
                    processedConstraint = 0;
                } else if(i == 1) {
                    hasMaxPrice = false;
                } else if(i == 3) {
                    hasMaxSize = false;
                }
            }
            intConstraints[i] = processedConstraint;
            i++;
        }
        for(int c : intConstraints) {
            System.out.println(c);
        }
        
        unsorted.removeIf(filter -> filter.getSize() < intConstraints[0]);
        unsorted.removeIf(filter -> filter.getPrice() < intConstraints[2]);
        
        if (hasMaxSize){
            unsorted.removeIf(filter -> filter.getSize() > intConstraints[3]);
            System.out.println("filtered max size");
        }
        
        if (hasMaxPrice) {
            System.out.println("filtered max price");
            unsorted.removeIf(filter -> filter.getPrice() > intConstraints[1]);
        }
        
        unsorted.removeIf(filter -> filter.getStatus().equals("Occupied"));
        
        return unsorted;
    }
}
