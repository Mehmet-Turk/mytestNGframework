package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WaitTest extends TestBase {
    /*
    Test Case:
Create a class: WaitTest
Create two method: 1. implicyWait, 2. explicitWait
When user goes to https://the-internet.herokuapp.com/dynamic_controls
And click on Remove button
Then verify "It's gone!" message displays
     */
    @Test
    public void implicitlyWait(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement removeButton = driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
        removeButton.click();
        WebElement goneMessage = driver.findElement(By.id("message"));
        String actualMessage = goneMessage.getText();
        String expectedMessage = "It's gone!";
        Assert.assertEquals(actualMessage, expectedMessage);

    }
    @Test
    public void explicitlyWait(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement removeButton = driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
        removeButton.click();
        WebElement goneMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        String actualMessage = goneMessage.getText();
        String expectedMessage = "It's gone!";
        Assert.assertEquals(actualMessage, expectedMessage);

    }
    @Test
    public void enableTest(){
        /*
         When use goes to https://the-internet.herokuapp.com/dynamic_controls
    And clicks on Enable button
    Then verify that textbox is enable-I can type in
    And verify the text "It's enabled!
         */
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement enableButton = driver.findElement(By.xpath("//button[@onclick='swapInput()']"));
        enableButton.click();
        //WebElement actualMessage = driver.findElement(By.id("message"));
        //commanding implicitly wait on TestBase class
        //WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        //implicitly wait does not work so use explicit wait
        WebElement textBox = wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//input[@type='text']"))));

        //to text if it is enabled or not
        Assert.assertTrue(textBox.isEnabled());
        WebElement actualMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        String expectedMessage = "It's enabled!";
        Assert.assertEquals(actualMessage.getText(), expectedMessage);



    }
}
