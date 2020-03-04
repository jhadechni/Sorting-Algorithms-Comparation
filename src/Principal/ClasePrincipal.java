/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Clases.BubbleSort;
import Clases.MergeSort;
import Vistas.Vistas;
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
 * @date Marzo - 2020. 
 * Objetivo: Comparar los ordenamientos MergeSort y BubbleSort para grandes conjuntos de datos.
 * Código: 200128153.
 * Nombre: Jaime Luis Sierra Hadechine. 
 * Programa: Ingeniería de Sistemas y Computación
 * Nombre del programa: SierraHadechineJaimeLuis.
 */
public class ClasePrincipal {

    /**
     * @param args the command line arguments
     */
    static long startTime1, endTime1, startTime2, endTime2;
    static double runningTime1, runningTime2;

    public static void main(String[] args) throws InterruptedException, IOException {
        // TODO code application logic here
//        int numberKeys;
//        BubbleSort bu = new BubbleSort();
//        MergeSort me = new MergeSort();
//
//        Scanner sc = new Scanner(System.in);
//        
        
        Vistas pl = new Vistas();
        pl.setVisible(true);
//        pl.setSize(1310,650);
        pl.setLocationRelativeTo(null);
        
        
        
        
//        System.out.println("Digite el número de claves");
//        numberKeys = sc.nextInt();
//
//        BigInteger vec2[] = new BigInteger[numberKeys];
//        BigInteger vec3[] = new BigInteger[vec2.length];

//        File recursiveBubble = new File("src/Archivos/Bubble_Sort");
//        File original = new File("src/Archivos/Original");
//        File mergeSort = new File("src/Archivos/Merge_Sort");
//        recursiveBubble.delete();
//        original.delete();
//        mergeSort.delete();
//        for (int i = 0; i < vec2.length; i++) {
//            vec2[i] = vec3[i] = randomBig(10000);
//
//        }

//        guardarArchivo(original, vec2, "VECTOR ORIGINAL");
//
//        sort(vec2, 0, vec2.length - 1);
//        guardarArchivo(mergeSort, vec2, "MERGE SORT");
//        recursiveBubbleSort(vec3, vec3.length);
//        bu.recursiveBubble(vec3);
//        me.sort(vec2, 0, vec2.length - 1);

//        guardarArchivo(recursiveBubble, vec3, "BUBBLE SORT");
//        System.out.println("\n");
//
//        System.out.println("Tiempo de corrida de Merge Sort: " + runningTime1 + " milliseconds");
//        System.out.println("Tiempo de corrida de Bubble Sort: " + runningTime2 + " milliseconds");
//        System.out.println("Número de instrucciones del BubbleSort " + bu.getContadorInstrucciones());
//        System.out.println("Número de instrucciones del MergeSort " + me.getContadorInstrucciones());

    }

    /**
     *
     * @param digitosDecimales Número de dígitos decimales del número a generar.
     * @return Genera un numero aleatorio de n dígitos.
     */
//    public static BigInteger randomBig(int digitosDecimales) {
//        Random numeroRandom = new Random();
//        BigInteger bi = BigInteger.ZERO;
//        for (int i = 0; i < digitosDecimales; i++) {
//            int ir = i == 0 ? numeroRandom.nextInt(9) + 1 : numeroRandom.nextInt(10);
//            bi = bi.multiply(BigInteger.TEN).add(BigInteger.valueOf(ir));
//        }
//
//        return bi;
//
//    }

    
}
