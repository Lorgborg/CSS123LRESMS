/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libs.search;

import java.util.ArrayList;
import libs.Lot;
/**
 *
 * @author Riniel
 */
public interface Search{
    public ArrayList<Lot> filterData(ArrayList<Lot> unsorted, char block, String minPrice, String maxPrice, String minSize, String maxSize, String lot);
}