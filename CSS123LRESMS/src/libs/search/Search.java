/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libs.search;

import java.util.ArrayList;
import libs.Lots;
/**
 *
 * @author Riniel
 */
public interface Search{
    public ArrayList<Lots> filterData(ArrayList<Lots> unsorted, char block, String minPrice, String maxPrice, String minSize, String maxSize, String lot);
}