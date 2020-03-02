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

    static long contadorInstrucciones;

    public MergeSort() {
        this.contadorInstrucciones = 0;
    }

    /**
     *
     * @param arr Vector que será particionado
     * @param l Inicial
     * @param m Punto medio
     * @param r Final
     */
    public void rMerge(BigInteger arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        contadorInstrucciones += 6 + n1 + n2;
        BigInteger leftArray[] = new BigInteger[n1];
        BigInteger rightArray[] = new BigInteger[n2];
        
        for (int i = 0; i < n1; ++i) {
            leftArray[i] = arr[l + i];
        }
        
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = arr[m + 1 + j];
        }
        
        int i = 0, j = 0;
        int k = l;
        
        while (i < n1 && j < n2) {
            contadorInstrucciones++;
            if (leftArray[i].compareTo(rightArray[j]) == -1) {
                contadorInstrucciones += 2;
                arr[k] = leftArray[i];
                i++;
            } else {
                contadorInstrucciones += 2;
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        
        while (i < n1) {
            contadorInstrucciones += 3;
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        
        while (j < n2) {
            contadorInstrucciones += 3;
            arr[k] = rightArray[j]; 
            j++;
            k++;
        }
    }

    /**
     *
     * @param arr Vector que será ordenado
     * @param l Inicial
     * @param r Final
     */
    public void sort(BigInteger arr[], int l, int r) {

        if (l < r) {
            contadorInstrucciones += 4;
            // Find the middle point 
            int m = (l + r) / 2;
            // Sort first and second halves 
            sort(arr, l, m);
            sort(arr, m + 1, r);
            // Merge the sorted halves 
            rMerge(arr, l, m, r);
        }

    }

    public long getContadorInstrucciones() {
        return contadorInstrucciones;
    }

   
    
    public void iterativeMergeSort(BigInteger arr[], int n) {

        for (int i = 1; i <= n - 1; i = 2 * i) {
            for (int j = 0; j < n - 1; j += 2 * i) {
                int mid = Math.min(j + i - 1, n - 1);
                int right_end = Math.min(j + 2 * i - 1, n - 1);
                rMerge(arr, j, mid, right_end);
            }
        }
    }

    
    
    public static void merge(BigInteger arr[], int l, int m, int r) {
        int i, j, k;
        int n1 = m - l + 1;
        int n2 = r - m;

        /* create temp arrays */
        BigInteger L[] = new BigInteger[n1];
        BigInteger R[] = new BigInteger[n2];

        /* Copy data to temp arrays L[] 
		and R[] */
        for (i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }
        for (j = 0; j < n2; j++) {
            R[j] = arr[m + 1 + j];
        }

        /* Merge the temp arrays back into 
		arr[l..r]*/
        i = 0;
        j = 0;
        k = l;
        while (i < n1 && j < n2) {
            if (L[i].compareTo(R[j]) == -1 || L[i].compareTo(R[j]) == 0) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy the remaining elements of 
		L[], if there are any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy the remaining elements of 
		R[], if there are any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

}
