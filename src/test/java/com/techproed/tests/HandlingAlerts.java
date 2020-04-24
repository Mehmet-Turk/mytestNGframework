package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;

public class HandlingAlerts {
     /*
    Create 3 methods
    1. acceptAlert
    2. dismissAlert
    3. sendKeysAlert
    Create a @BeforeMethod
    Go to https://the-internet.herokuapp.com/javascript_alerts
     */
     WebDriver driver;
     @BeforeClass
    public void setup(){
         WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
         driver.get("https://the-internet.herokuapp.com/javascript_alerts");

     }
     @Test
    public void acceptAlert(){
         WebElement alertButton = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
         alertButton.click();
         //GETTING TEXT FROM ALERT
         System.out.println(driver.switchTo().alert().getText());
         //ALERT DEALS WITH POP-UP MENU OK OR CANCEL ETC... TO DO THAT WE NEED TO
         //SWITCH TO THE ALERT
         driver.switchTo().alert().accept();//pop up menu clicking on OK
         WebElement resultMessage = driver.findElement(By.id("result"));
         Assert.assertTrue(resultMessage.isDisplayed());

     }
     @Test
    public void dismissAlert(){
         WebElement confirmButton = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
         confirmButton.click();
         driver.switchTo().alert().dismiss();//clicking on CANCEL on pop up menu
         WebElement actualResultMessage = driver.findElement(By.id("result"));
         String expectedResultMessage = "You clicked: Cancel";
         Assert.assertEquals(actualResultMessage.getText(),expectedResultMessage);

     }
     @Test
    public void sendKeysAlert(){
         WebElement promptButton = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
         promptButton.click();
         String message = "Mehmet Turk";
         driver.switchTo().alert().sendKeys(message);//sending message to pop-up menu
         driver.switchTo().alert().accept();
         WebElement actualResultMessage = driver.findElement(By.id("result"));
         String expectedResultMessage = "You entered: " + message;
         Assert.assertEquals(actualResultMessage.getText(), expectedResultMessage);

     }
}
