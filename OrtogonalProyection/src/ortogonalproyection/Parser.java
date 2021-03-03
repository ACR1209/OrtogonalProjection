package ortogonalproyection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Clase encargada de parsear la entrada de texto en la GUI.
 * @author Andrés Coronel
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
