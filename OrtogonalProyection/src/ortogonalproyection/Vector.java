/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ortogonalproyection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class Vector {
    int dimension;
    List<Double> elements = new ArrayList<>();

    public Vector(){
    }
    
    public Vector(double[] nums) {
        for(int i = 0; i < nums.length; i++){
            this.elements.add(nums[i]);
        }
        
        this.dimension = this.elements.size();
    }
    
    public static double dotProduct(Vector v1, Vector v2){
        
        Iterator iteratorV1 = v1.elements.iterator();
        Iterator iteratorV2 = v2.elements.iterator();
            
        double ans = 0;
            
            
        while(iteratorV1.hasNext()){
            ans += (double)iteratorV1.next() * (double)iteratorV2.next();
        }
            
        return ans;
      
    }
    
    public static double[][] projectionOfABase(double[][] base){
        double[][] u = base;
        double[][] w = new double[base.length][base[0].length];
        
        w[0] = u[0];
         
        for(int i = 1; i < base.length; i++){
            w[i] = u[i];
            
            for(int j = 0; j < i ; j++){
               
                w[i] = add(w[i], proyect(w[i],w[j]));
            }
        }
        
        return w;
    }
    
    public static double[] proyect(double[] u1, double[] u2){
        Vector v1 = new Vector(u1);
        Vector v2 = new Vector(u2);
        double[] ans = u2.clone();
        
        if(v1.dimension == v2.dimension){
            double dotProductDivision = dotProduct(v1, v2) / dotProduct(v2, v2);
            
            for(int i = 0; i < u2.length; i++){
                ans[i] *= -dotProductDivision;
            }
        }
        
        return ans; 
    }
    
    public static double[] add(double[] u1, double[] u2){
        double[] a = u1;
        double[] b = u2;
        
        if(a.length == b.length){
            for(int i = 0; i < u2.length; i++){
                b[i] += a[i];
            }
        }
        
        return b;
    }
    
    public static boolean allDimensionsEqual(double[][] matrix){
        List<Vector> vectorList = new ArrayList<>();
        
        for(double[] arr : matrix){
            vectorList.add(new Vector(arr));
        }
      
        for(Vector v : vectorList){
            if(v.dimension != vectorList.get(0).dimension){
                return false;
            }
        }
        
        return true;
    }
}
