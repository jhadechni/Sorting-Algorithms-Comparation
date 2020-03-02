/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Clases.BubbleSort;
import Clases.MergeSort;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jaime Sierra
 */
public class Vistas extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Vistas() {
        initComponents();
        tabla();
    }
    long startTimeBS, endTimeBS, timeBS, startTimeMS, endTimeMS, timeMS;
    File infor = new File("src/Archivos/info");

    void tabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Número de claves");
        modelo.addColumn("Tamaño de las claves");
        modelo.addColumn("Promedio de Instrucciones BS");
        modelo.addColumn("Promedio de Instrucciones MS");
        modelo.addColumn("Promedio de Tiempo BS");
        modelo.addColumn("Promedio de Tiempo MS");
        jTable1.setModel(modelo);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Digite el número máximo de claves a generar:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 270, 24));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 180, -1));

        jLabel2.setText("Digite el tamaño de las claves:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 180, -1));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 180, -1));

        jButton2.setText("GENERAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 90, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Número de claves", "Tamaño de las claves", "Promedio de Instrucciones BS", "Promedio de Instrucciones MS", "Promedio de Tiempo BS", "Promedio de Tiempo MS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 1150, 360));

        jButton3.setText("GENERAR ARCHIVO EXCEL");
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 210, 30));

        jButton4.setText("MOSTRAR ARCHIVOS");
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, 190, 30));

        jLabel3.setText("Digite el incremento:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, 30));

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 180, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    public static BigInteger randomBig(int digitosDecimales) {
        Random numeroRandom = new Random();
        BigInteger bi = BigInteger.ZERO;
        for (int i = 0; i < digitosDecimales; i++) {
            int ir = i == 0 ? numeroRandom.nextInt(9) + 1 : numeroRandom.nextInt(10);
            bi = bi.multiply(BigInteger.TEN).add(BigInteger.valueOf(ir));
        }

        return bi;

    }

    public void mostrar() {

    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//        try {
            int numberMaxKeys = Integer.parseInt(jTextField1.getText());
            int keysSize = Integer.parseInt(jTextField2.getText());
            BubbleSort bu = new BubbleSort();
            MergeSort me = new MergeSort();
             //Modelo
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Número de claves");
            modelo.addColumn("Tamaño de las claves");
            modelo.addColumn("Promedio de Instrucciones BS");
            modelo.addColumn("Promedio de Instrucciones MS");
            modelo.addColumn("Promedio de Tiempo BS");
            modelo.addColumn("Promedio de Tiempo MS");

            for (int w = 100; w < numberMaxKeys; w+=Integer.parseInt(jTextField3.getText())) {
            BigInteger vec2[] = new BigInteger[w];
            BigInteger vec3[] = new BigInteger[vec2.length];

            for (int i = 0; i < vec2.length; i++) {
                vec2[i] = vec3[i] = randomBig(keysSize);

            }
            startTimeBS = System.nanoTime();
            bu.iterativeBubbleSort(vec3);
            endTimeBS = System.nanoTime();
            timeBS = endTimeBS - startTimeBS;

            startTimeMS = System.nanoTime();
            me.iterativeMergeSort(vec2,vec2.length);
            endTimeMS = System.nanoTime();
            timeMS = endTimeBS - startTimeBS;

           

            String[] a = new String[6];
            a[0]=String.valueOf(w);
            a[1]=String.valueOf(keysSize);
            a[2]=String.valueOf(bu.getContadorInstrucciones());
            a[3]=String.valueOf(me.getContadorInstrucciones());
            a[4]=String.valueOf(timeBS);
            a[5]=String.valueOf(timeMS);
                    
            modelo.addRow(a);
             jTable1.setModel(modelo);

            }
           
           
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Debe ingresar número enteros");
//        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    public static void guardarArchivo(File archivo, String[] vec) throws IOException {
        BufferedWriter bw;

        bw = new BufferedWriter(new FileWriter(archivo));

        for (int i = 0; i < vec.length; i++) {
            if (archivo.exists()) {
                bw.write(vec[i]);
                bw.newLine();
            } else {
                bw.write(String.valueOf(vec[i]));
                bw.newLine();
            }
        }
        bw.close();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vistas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vistas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vistas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vistas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vistas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
