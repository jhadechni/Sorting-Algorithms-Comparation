/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_jaimesierra;

import Clases.BubbleSort;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Jaime Sierra. 
 * User: jhadechine.
 * @date Febrero - 2020. 
 * Objetivo: Comparar los ordenamientos MergeSort y BubbleSort para grandes conjuntos de datos. 
 * Código: 200128153. 
 * Nombre: Jaime Luis Sierra Hadechine. 
 * Nombre del programa: SierraHadechineJaimeLuis.
 */
public class Lab01_JaimeSierra {

    /**
     * @param args the command line arguments
     */
    static long startTime1, endTime1, startTime2, endTime2;
    static double runningTime1, runningTime2;

    public static void main(String[] args) throws InterruptedException, IOException {
        // TODO code application logic here
        int numberKeys;
        BubbleSort bu= new BubbleSort();
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite el número de claves");
        numberKeys = sc.nextInt();

        BigInteger vec2[] = new BigInteger[numberKeys];
        BigInteger vec3[] = new BigInteger[vec2.length];

        File bubbleSort = new File("src/Archivos/Bubble_Sort");
        File original = new File("src/Archivos/Original");
        File mergeSort = new File("src/Archivos/Merge_Sort");
        bubbleSort.delete();
        original.delete();
        mergeSort.delete();
       

        for (int i = 0; i < vec2.length; i++) {
            vec2[i] = vec3[i] = randomBig(10000);

        }

        guardarArchivo(original, vec2, "VECTOR ORIGINAL");

        sort(vec2, 0, vec2.length - 1);
        guardarArchivo(mergeSort, vec2, "MERGE SORT");

        recursiveBubbleSort(vec3, vec3.length);
        
        guardarArchivo(bubbleSort, vec3, "BUBBLE SORT");

        System.out.println("\n");

        System.out.println("Tiempo de corrida de Merge Sort: " + runningTime1 + " milliseconds");
        System.out.println("Tiempo de corrida de Bubble Sort: " + runningTime2 + " milliseconds");

    }

    /**
     *
     * @param arr Vector que será ordenado
     * @param l Inicial
     * @param r Final
     */
    public static void sort(BigInteger arr[], int l, int r) {
        startTime1 = System.currentTimeMillis();

        if (l < r) {
            // Find the middle point 
            int m = (l + r) / 2;
            // Sort first and second halves 
            sort(arr, l, m);
            sort(arr, m + 1, r);
            // Merge the sorted halves 
            merge(arr, l, m, r);
        }

        endTime1 = System.currentTimeMillis();

        runningTime1 = (double) ((endTime1 - startTime1));

    }

    /**
     *
     * @param arr Vector que será particionado
     * @param l Inicial
     * @param m Punto medio
     * @param r Final
     */
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

    /**
     *
     * @param digitosDecimales Número de dígitos decimales del número a generar.
     * @return Genera un numero aleatorio de n dígitos.
     */
    public static BigInteger randomBig(int digitosDecimales) {
        Random numeroRandom = new Random();
        BigInteger bi = BigInteger.ZERO;
        for (int i = 0; i < digitosDecimales; i++) {
            int ir = i == 0 ? numeroRandom.nextInt(9) + 1 : numeroRandom.nextInt(10);
            bi = bi.multiply(BigInteger.TEN).add(BigInteger.valueOf(ir));
        }

        return bi;

    }

    /**
     *
     * @param vec Vector a ordenar.
     * @return Regresa un vector ordenado medianta el ordenamiento de BubbleSort
     */
   public static BigInteger[] bubbleSort(BigInteger[] vec) {

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
/**
 * 
 * @param arr Vector a ordenar.
 * @param n Tamaño del vector.
 */
    public static void recursiveBubbleSort(BigInteger arr[], int n) {
        startTime2 = System.currentTimeMillis();
        if (n == 1) {
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) == 1) {
                BigInteger temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }

        recursiveBubbleSort(arr, n - 1);

        endTime2 = System.currentTimeMillis();

        runningTime2 = (double) ((endTime2 - startTime2));
    }

    /**
     *
     * @param archivo Archivo a crear
     * @param vec Vector que contiene la información que será guardada en el
     * archivo.
     * @param text Texto de referencia del archivo.
     * @throws IOException Exception.
     */
    public static void guardarArchivo(File archivo, BigInteger[] vec, String text) throws IOException {
        BufferedWriter bw;

        bw = new BufferedWriter(new FileWriter(archivo));
        if (archivo.exists()) {
            bw.write(text);
            bw.newLine();

        }
        for (int i = 0; i < vec.length; i++) {
            if (archivo.exists()) {
                bw.write(String.valueOf(vec[i]));
                bw.newLine();
            } else {
                bw.write(String.valueOf(vec[i]));
                bw.newLine();
            }
        }
        bw.close();

    }
}
