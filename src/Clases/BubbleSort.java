/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.math.BigInteger;

/**
 *
 * @author jaimi
 */
public class BubbleSort {
    private static long contadorInstrucciones;

    public static long getContadorInstrucciones() {
        return contadorInstrucciones;
    }
   
    public BubbleSort() {
        BubbleSort.contadorInstrucciones = 0;
    }
    
    public static void recursiveSort(BigInteger arr[], int n) {
        if (n == 1) {
            contadorInstrucciones+=2;
            return;
        }
        
        for (int i = 0; i < n - 1; i++) {
            contadorInstrucciones+=6;
            if (arr[i].compareTo(arr[i + 1]) == 1) {
                BigInteger temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        
        contadorInstrucciones+=1;
        recursiveSort(arr, n - 1);
    }
    public static BigInteger[] noRecursiveSort(BigInteger[] vec) {

        for (int i = 0; i < vec.length - 1; i++) {
            for (int j = 0; j < vec.length - i - 1; j++) {
                if (vec[j].compareTo(vec[j + 1]) == 1) {
                    BigInteger temp = vec[j];
                    vec[j] = vec[j + 1];
                    vec[j + 1] = temp;
                }
            }
        }

        return vec;
    }


   
    
    
}
