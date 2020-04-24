package com.techproed.excelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteExcel {
    @Test
    public void writeExcel() throws IOException {
        String path = "src\\test\\resources\\Capitals.xlsx";
        FileInputStream file = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(0);
        Cell cell = row.createCell(3);//creating a cell
        cell.setCellValue("POPULATION");//setting value
        List<String> population = new ArrayList<String>();
        population.add("2148000");
        population.add("994347");
        population.add("664046");
        population.add("702455");
        population.add("821752");
        population.add("1056000");
        population.add("174383");
        population.add("1208000");
        for (int i=0;i<8;i++){
            workbook.getSheetAt(0).getRow(i+1).createCell(3).setCellValue(population.get(i));
        }



        //workbook.getSheetAt(0).getRow(2).createCell(3).setCellValue("21480000");

        //row.removeCell(row.getCell(4));
        FileOutputStream fileOutputStream = new FileOutputStream(path);//opening file to send data
        workbook.write(fileOutputStream);//write and save changes
        fileOutputStream.close();
        file.close();
        workbook.close();


    }
}
