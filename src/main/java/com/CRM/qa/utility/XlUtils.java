package com.CRM.qa.utility;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class XlUtils {


    private static FileInputStream fis;
    private static FileOutputStream fo;
    private static XSSFWorkbook wb;
    private static XSSFSheet ws;
    private static XSSFRow row;
    private static XSSFCell cell;
    private static int rowcount;
    private static int colcount;

    public XlUtils(String path, String SheetName) throws Exception {
        fis = new FileInputStream(path);
        wb = new XSSFWorkbook(fis);
        ws = wb.getSheet(SheetName);


    }

    public static Object[][] getData(String path, String SheetName) throws Exception {

        XlUtils excel = new XlUtils(path, SheetName);
        Object[][] data;
        int rownum = excel.getRowCount();
        int colnum = excel.getColumnCount();


        data = new Object[rownum][colnum];

        for (int i = 1; i <= rownum; i++) {
            for (int j = 0; j < colnum; j++) {

                data[i - 1][j] = excel.getCellData(path, SheetName, i, j);

            }
        }
        System.out.println(data);
        return data;

    }

    public int getRowCount() {

        rowcount = ws.getLastRowNum();
        return rowcount;
    }

    public int getColumnCount() {

        colcount = ws.getRow(0).getLastCellNum();
        return colcount;

    }

    public String getCellData(String path, String SheetName, int rownum, int colnum) {
        //XlUtils excel = new XlUtils(path, SheetName);
        row = ws.getRow(rownum);
        cell = row.getCell(colnum);
        String data;
        try {
            DataFormatter formatter = new DataFormatter();
            return formatter.formatCellValue(cell);

        } catch (Exception e) {
            data = "";
        }
        return data;
    }


}

