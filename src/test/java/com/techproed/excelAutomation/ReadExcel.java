package com.techproed.excelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;
import org.testng.reporters.Files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadExcel {
    @Test
    public void readFromExcel() throws IOException {
        String path = "C:\\Users\\user\\Desktop\\Capitals.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        //open the workbook using fileinputstream going to upper level of workbook
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        //going to worksheet
        Sheet sheet = workbook.getSheetAt(0);//1st sheet
        //going inside worksheet and first comes row
        Row row = sheet.getRow(0);//first row
        Cell cell = row.getCell(0);//not header first cell
        System.out.println("first row first column data is: " + cell);
        System.out.println(readFromExcelSheet(2,2).toUpperCase());
        //how to get the last index number starts index 0
        System.out.println(sheet.getLastRowNum());
        //how to get the number of row that is used starts index 1
        System.out.println("used rows not empty ones:"+sheet.getPhysicalNumberOfRows());

        Map<String, String> capital = new HashMap<>();
        int countryColumn = 0;
        int capitalColumn = 1;
        



    }
    public String readFromExcelSheet( int row, int column) throws IOException {
        String path = "C:\\Users\\user\\Desktop\\Capitals.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        //open the workbook using fileinputstream going to upper level of workbook
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        //going to worksheet
        return workbook.getSheetAt(0).getRow(row-1).getCell(column-1).toString();
    }
}
