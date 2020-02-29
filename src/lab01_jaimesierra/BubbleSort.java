/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_jaimesierra;

import java.math.BigInteger;

/**
 *
 * @author jaimi
 */
public class BubbleSort {

    static long contadorInstrucciones;

    public BubbleSort() {
        BubbleSort.contadorInstrucciones = 0;
    }

    public static void sort(BigInteger arr[], int i, int j) {
        contadorInstrucciones += 3;
        BigInteger temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void recursiveBubble(BigInteger arr[]) {
        contadorInstrucciones += 2;
        for (int k = 0; k < arr.length - 1; k++) {
            for (int i = 0; i < arr.length - 1 - k; i++) {
                if (arr[i].compareTo(arr[i + 1]) == 1) {
                    contadorInstrucciones++;
                    sort(arr, i, i + 1);
                }
            }

        }
    }

    public BigInteger[] noRecursiveSort(BigInteger[] vec) {

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

    public long getContadorInstrucciones() {
        return contadorInstrucciones;
    }

}
