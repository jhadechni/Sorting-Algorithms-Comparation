/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.math.BigInteger;
import java.util.Arrays;

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
    public  void merge(BigInteger arr[], int l, int m, int r) {
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
                contadorInstrucciones+=2;
                arr[k] = leftArray[i];
                i++;
            } else {
                contadorInstrucciones+=2;
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            contadorInstrucciones+=3;
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            contadorInstrucciones+=3;
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
            merge(arr, l, m, r);
        }

    }

    public long getContadorInstrucciones() {
        return contadorInstrucciones;
    }
    
    // Merge two sorted sub-arrays A[from .. mid] and A[mid + 1 .. to]
	public static void merge(int[] A, int[] temp, int from, int mid, int to)
	{
		int k = from, i = from, j = mid + 1;

		// loop till there are elements in the left and right runs
		while (i <= mid && j <= to) {
			if (A[i] < A[j]) {
				temp[k++] = A[i++];
			} else {
				temp[k++] = A[j++];
			}
		}

		// Copy remaining elements
		while (i <= mid) {
			temp[k++] = A[i++];
		}

		// Don't need to copy second half

		// copy back to the original array to reflect sorted order
		for (i = from; i <= to; i++) {
			A[i] = temp[i];
		}
	}

	// Iteratively sort array A[low..high] using temporary array
	public static void mergesort(int[] A)
	{
		int low = 0;
		int high = A.length - 1;

		// sort array A[] using temporary array temp
		int[] temp = Arrays.copyOf(A, A.length);

		// divide the array into blocks of size m
		// m = [1, 2, 4, 8, 16...]
		for (int m = 1; m <= high - low; m = 2*m)
		{
			// for m = 1, i = 0, 2, 4, 6, 8...
			// for m = 2, i = 0, 4, 8, 12...
			// for m = 4, i = 0, 8, 16...
			// ...
			for (int i = low; i < high; i += 2*m)
			{
				int from = i;
				int mid = i + m - 1;
				int to = Integer.min(i + 2 * m - 1, high);

				merge(A, temp, from, mid, to);
			}
		}
        }

}
