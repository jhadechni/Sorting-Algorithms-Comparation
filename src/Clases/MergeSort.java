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
        // Find sizes of two subarrays to be merged 

        int n1 = m - l + 1;
        int n2 = r - m;
        contadorInstrucciones += 6 + n1 + n2;
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
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            contadorInstrucciones += 3;
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        /* Copy remaining elements of R[] if any */
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

    /* Iterative mergesort function to sor 
	t arr[0...n-1] */
    public void iterativeMergeSort(BigInteger arr[], int n) {

        // For current size of subarrays to 
        // be merged curr_size varies from 
        // 1 to n/2 
        int curr_size;

        // For picking starting index of 
        // left subarray to be merged 
        int left_start;

        // Merge subarrays in bottom up 
        // manner. First rMerge subarrays 
        // of size 1 to create sorted 
        // subarrays of size 2, then rMerge 
        // subarrays of size 2 to create 
        // sorted subarrays of size 4, and 
        // so on. 
        for (curr_size = 1; curr_size <= n - 1;
                curr_size = 2 * curr_size) {

            // Pick starting point of different 
            // subarrays of current size 
            for (left_start = 0; left_start < n - 1;
                    left_start += 2 * curr_size) {
                // Find ending point of left 
                // subarray. mid+1 is starting 
                // point of right 
                int mid = Math.min(left_start + curr_size - 1, n - 1);

                int right_end = Math.min(left_start
                        + 2 * curr_size - 1, n - 1);

                // Merge Subarrays arr[left_start...mid] 
                // & arr[mid+1...right_end] 
                rMerge(arr, left_start, mid, right_end);
            }
        }
    }

    /* Function to rMerge the two haves arr[l..m] and 
	arr[m+1..r] of array arr[] */
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
