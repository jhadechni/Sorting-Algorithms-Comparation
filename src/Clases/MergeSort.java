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
public class MergeSort {

    public MergeSort(long contadorInstrucciones) {
    }
    
    
    
    
    
     public static void merge(BigInteger arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1;
        int n2 = r - m;
        /* Create temp arrays */
        BigInteger leftArray[] = new BigInteger[n1];
        BigInteger rightArray[] = new BigInteger[n2];
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i) {
            leftArray[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = arr[m + 1 + j];
        }
        /* Merge the temp arrays */
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0;
        // Initial index of merged subarry array 
        int k = l;
        while (i < n1 && j < n2) {
            if (leftArray[i].compareTo(rightArray[j]) == -1) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
    
    
    
    
    
}
