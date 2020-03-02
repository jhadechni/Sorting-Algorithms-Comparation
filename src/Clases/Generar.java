/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author Jaime Sierra
 */
public class Generar {

    public void generarExcel(String[][] entrada, String ruta) throws IOException, WriteException {

        WorkbookSettings conf = new WorkbookSettings();
        conf.setEncoding("ISO-8859-1");
        WritableWorkbook workbook = Workbook.createWorkbook(new File(ruta), conf);

        WritableSheet sheet = workbook.createSheet("RESULTADO", 0);
        WritableFont h = new WritableFont(WritableFont.COURIER, 16);
        WritableCellFormat hFormat = new WritableCellFormat(h);

//        for (int i = 0; i < numero; i++) {
//            for (int j = 0; j < 6; j++) {
//                sheet.addCell(new jxl.write.Label(j, i, entrada[i][j], hFormat));
//            }
//        }
        workbook.write();
        workbook.close();

    }

}
