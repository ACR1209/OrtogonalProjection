/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ortogonalproyection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class Parser {
    public static double[][] getVector(String str){
        String[] items = str.split("//");
        List<double[]> numbers = new ArrayList<>();
        
        
        for(String idk : items){
            String[] numbersStr = idk.split(" ");

            double[] currentVector = new double[numbersStr.length];
            for(int i = 0; i < numbersStr.length; i++){
                
                currentVector[i] = Double.parseDouble(numbersStr[i]);
            }
            
            numbers.add(currentVector);
        }
        
        double[][] vectors = new double[numbers.size()][((double[])numbers.get(0)).length];
        
        for(int i = 0; i < numbers.size(); i++){ 
            vectors[i] = (double[])numbers.get(i);
        }
        
        return vectors;
        
    }
}
