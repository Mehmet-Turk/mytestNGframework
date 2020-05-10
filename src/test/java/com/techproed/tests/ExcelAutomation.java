package com.techproed.tests;

import com.techproed.pages.DataTablesExcel;
import com.techproed.utilities.Driver;
import com.techproed.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class ExcelAutomation {
    DataTablesExcel dataTablesExcel = new DataTablesExcel();
    ExcelUtil excelUtil;
    List<Map<String, String>> testData;
    @BeforeMethod
    public void getTestData(){
        excelUtil = new ExcelUtil(".\\src\\test\\resources\\exceldata.xlsx", "Sheet1");
        testData = excelUtil.getDataList();

    }
    @Test
    public void excelDataAutomation() throws InterruptedException {
        int count = 1;
        for (Map<String, String> appData: testData) {
            Driver.getDriver().get("https://editor.datatables.net/");
            dataTablesExcel.newButton.click();
            dataTablesExcel.firstNameBox.sendKeys(appData.get("firstname"));
            dataTablesExcel.lastNameBox.sendKeys(appData.get("lastname"));
            dataTablesExcel.positionBox.sendKeys(appData.get("position"));
            dataTablesExcel.officeBox.sendKeys(appData.get("office"));
            dataTablesExcel.extensionBox.sendKeys(appData.get("extension"));
            dataTablesExcel.salaryBox.sendKeys(appData.get("salary"));
            dataTablesExcel.startDateBox.sendKeys(appData.get("startdate"));
            dataTablesExcel.createButton.click();
            dataTablesExcel.searchBox.sendKeys(appData.get("firstname"));
            Thread.sleep(2000);
            Assert.assertTrue(dataTablesExcel.nameField.getText().contains(appData.get("firstname")));
            System.out.println(count);
            count++;
        }

    }
}
