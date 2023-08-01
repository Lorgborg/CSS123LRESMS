/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libs.search;

import java.util.ArrayList;
import java.util.Collections;
import libs.Lot;

/**
 *
 * @author Riniels
 */
public class PricePriority implements Search {
    Search filter;
    
    public PricePriority(Search filter) {
       this.filter = filter;
    }
    
    public ArrayList<Lot> filterData(ArrayList<Lot> unsorted, char block, String minPrice, String maxPrice, String minSize, String maxSize, String lot){
        return sort(filter.filterData(unsorted, block, minPrice, maxPrice, minSize, maxSize, lot));
    }
    
    public ArrayList<Lot> sort(ArrayList<Lot> unsorted){
        Collections.sort(unsorted, Lot.orderLotPrice);
        return unsorted;
    }
}
