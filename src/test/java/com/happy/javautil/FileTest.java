package com.happy.javautil;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.InputStream;

public class FileTest {
    public static void main(String[] args) {
        String file = "F://456.xlsx";
        try {
            InputStream inputStream = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            if (null == workbook.getSheet("sheet1")) {
                workbook.createSheet("sheet1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
