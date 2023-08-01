/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libs.search;

import java.util.ArrayList;
import java.util.Collections;
import libs.Lots;

/**
 *
 * @author Riniels
 */
public class PricePriority implements Search {
    Search filter;
    
    public PricePriority(Search filter) {
       this.filter = filter;
    }
    
    public ArrayList<Lots> filterData(ArrayList<Lots> unsorted, char block, String minPrice, String maxPrice, String minSize, String maxSize, String lot){
        return sort(filter.filterData(unsorted, block, minPrice, maxPrice, minSize, maxSize, lot));
    }
    
    public ArrayList<Lots> sort(ArrayList<Lots> unsorted){
        Collections.sort(unsorted, Lots.orderLotPrice);
        return unsorted;
    }
}
