package com.techproed.soh;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.concurrent.TimeUnit;


public class Soh_Day_2 extends TestBase {

    // go to fhctrip.com and verify the "FHCTRIP" text on the top-left corner
    @Test
    public void fhctripTextTest(){
        driver.get("http://www.fhctrip.com/");
        String actualBrandName = driver.findElement(By.className("navbar-brand")).getText();
        String expectedBrandName = "FHCTRIP";
        Assert.assertEquals(actualBrandName,expectedBrandName);

    }

    // go to fhctrip.com and verify the "Welcome To Our Hotel" text
    @Test
    public void welcomeTest()throws InterruptedException{
        driver.get("http://www.fhctrip.com/");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        WebElement actualText = driver.findElement(By.xpath("//h2[@class='mb-4']"));
        Thread.sleep(1000);

        String expectedText = "Welcome To Our Hotel";
        Assert.assertEquals(actualText.getText(), expectedText);

    }

    // go to fhctrip.com and verify the number of staff is "1,000"
    @Test
    public void staffNumberTest() throws InterruptedException{
        driver.get("http://www.fhctrip.com/");
        for (int i =0;i<6;i++){
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            Thread.sleep(500);
        }
        Thread.sleep(8000);
        WebElement actualNumberOfStaff = driver.findElement(By.xpath("(//strong[@class='number'])[3]"));
        Assert.assertEquals(actualNumberOfStaff.getText(),"1,000");


    }


}