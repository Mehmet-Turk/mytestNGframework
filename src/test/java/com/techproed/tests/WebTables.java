package com.techproed.tests;

import com.google.gson.internal.$Gson$Preconditions;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.lang.annotation.Repeatable;
import java.util.List;

public class WebTables extends TestBase {
    /*
    Create a class: WebTables


Find the total number of rows and cells in the table body
Print headers, rows, and cells
Print the elements of 4th row
Print the elements of the 5th column
Print the element of a 15th cell
     */

    public void login(){
//        Create a method: login() and log in : http://www.fhctrip.com/admin/HotelRoomAdmin
//        manager2
//        Man1ager2!
        driver.get("http://www.fhctrip.com/admin/HotelRoomAdmin");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!");
        driver.findElement(By.xpath("//button[@type='submit']")).click();



    }
    @Test
    public void entireTable() throws InterruptedException {
            login();//loging in using the login method.

//        Print headers, rows, and cells
//        Print the elements of 4th row
//        Print the elements of the 5th column
//        Print the element of a 15th cell
            Thread.sleep(3000);
            WebElement tBody=driver.findElement(By.xpath("//tbody"));
            System.out.println(tBody.getText());
            //Finding the size=>find the total number of cells in the table bodyu
            List<WebElement> table=driver.findElements(By.xpath("//tbody//td"));
            System.out.println("The size of the table body is ===>> "+table.size());//Size of the table
            System.out.println(driver.findElements(By.tagName("//tbody//td")).size());//We can use tag name to find the data

}
    //        Find the total number of rows and cells in the table body
    @Test
    public void printRows(){
        login();
        System.out.println("There are " +driver.findElements(By.xpath("//tbody//tr")).size()+ " rows in the table");
        List<WebElement> allRows = driver.findElements(By.xpath("//tbody//tr"));
        allRows.stream().map(t -> t.getText()+ " | ").forEach(System.out::print);
        System.out.println();

        List<WebElement> fourRow = driver.findElements(By.xpath("//tbody//tr[4]//td"));
        fourRow.stream().map(t->t.getText()+ " | ").forEach(System.out::print);
    }
    @Test
    public void printCells(){
        login();
        System.out.println("There are " +driver.findElements(By.xpath("//tbody//td")).size()+ " cells in the table");
        List<WebElement> cells = driver.findElements(By.xpath("//tbody//td"));
        cells.stream().map(t->t.getText()+" | ").forEach(System.out::print);
    }
    @Test
    public void printColumns(){
        login();
        System.out.println("There are " +driver.findElements(By.xpath("//tr[3]//td")).size()+ " column in the table");
    }
    @Test
    public void printHeaders(){
        login();
        List<WebElement> headers = driver.findElements(By.tagName("th"));
        headers.stream().map(t->t.getText()+ " | ").forEach(System.out::print);
    }
    @Test
    public void columnFive() {
        login();
        List<WebElement> column5 = driver.findElements(By.xpath("//tbody//td[5]"));
        column5.stream().map(t -> t.getText() + " | ").forEach(System.out::print);
    }
    public void printData(int row, int column){
        /*
        Use WebTables class
        1.Create a void method: printData(int row, int column);
        When you enter the row and column number,
        Then printData method should print the data on that cell.
        2.Print another TEST METHOD : printDataTest();
        And use this method to call and print printData() method
        Example printData(3,5);=> should print the data on the 3rd row, 5th column
         */
        login();
        //List<WebElement> rowColumnPrint = driver.findElements(By.xpath("//tbody//tr["+row+"]//td"));
        String xpath = "//tbody//tr["+row+"]//td["+column+"]";
        WebElement data = driver.findElement(By.xpath(xpath));
        System.out.println(data.getText());
    }
    @Test
    public void printDataTest(){
        printData(3,4);
    }



}
