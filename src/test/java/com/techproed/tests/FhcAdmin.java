package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class FhcAdmin extends TestBase {
    /*
    Homework
Go to http://www.fhctrip.com/admin/HotelAdmin
kullanici adi:manager2
password;Man1ager2!
Create a hotel if the is not any
And Click on Details on one of the hotel
And verifies the “Edit Hotel” text that opened on the window
     */

    @Test
    public void editHotel(){
        driver.get("http://www.fhctrip.com/admin/HotelAdmin");
        //fhcLogin.login("Ali", "veli");
        WebElement userName = driver.findElement(By.id("UserName"));
        userName.sendKeys("manager2");
        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("Man1ager2!");
//        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        //driver.navigate().refresh();
       driver.findElement(By.xpath("//a[@title='Next']")).click();
       driver.findElement(By.xpath("(//a[@target='_blank'])[6]")).click();



//        driver.get("http://www.fhctrip.com/admin/HotelAdmin");//go to url
//        driver.findElement(By.id("UserName")).sendKeys("manager2");//enter manager2 to finding element
//        driver.findElement(By.id("Password")).sendKeys("Man1ager2!");//enter man1ager2! to finding element
//        driver.findElement(By.cssSelector("button[type='submit']")).click();//click login
//        String firstSite=driver.getWindowHandle();
//        System.out.println(firstSite);
//        driver.findElement(By.cssSelector("a[title='Next']")).click();//2. sayafaya gider
//        driver.findElement(By.cssSelector("a[href='./HotelAdmin/Edit?Id=63']")).click();//detailse tiklar
//        Set<String> sekmeler = driver.getWindowHandles();
//        for(String e:sekmeler){
//            if(!e.equals(firstSite)){
//                driver.switchTo().window(e);
//            }
//        }
//        String actualText=driver.findElement(By.cssSelector("div[class='caption']")).getText();
//        String expectedText="Edit Hotel";
//        Assert.assertEquals(actualText,expectedText);
    }
}
