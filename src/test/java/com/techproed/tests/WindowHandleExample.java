package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import java.util.Collections;
import java.util.Set;

public class WindowHandleExample extends TestBase {
    /*
    Given user is on the https://the-internet.herokuapp.com/windows
    Then user verifies the text : “Opening a new window”
    Then user verifies the title of the page is “The Internet”
    When user clicks on the Click Here button
    Then user verifies the new window title is “New Window”
    Then user verifies the text:  “New Window”
    When user goes back to the previous window and then verifies the title : “The Internet”
     */
    @Test
    public void windowHandle(){
        //Passing to Given user is on the https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");
        String parentWindowHandle = driver.getWindowHandle();
        // verification of the text : “Opening a new window”
        String actualText = driver.findElement(By.tagName("h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(actualText,expectedText);
        //Verification of the title of the page is “The Internet”
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(actualTitle,expectedTitle);
        // clicking on the Click Here button
        WebElement clickButton = driver.findElement(By.partialLinkText("Click"));
        clickButton.click();
        //Then user verifies the new window title is “New Window”
        //to do that i need to take all opec windows references and
        //compare it with parent window references if it is not equal then switch to new tag
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String e: allWindowHandles){
            if(!parentWindowHandle.equals(e)){
                driver.switchTo().window(e);
            }

        }
        String actualNewWindowTitle = driver.getTitle();
        String expectedNewWindowTitle = "New Window";
        //Then user verifies the text:  “New Window”
        String actualNewWindowText = driver.findElement(By.tagName("h3")).getText();
        String expectedNewWindowText = "New Window";
        Assert.assertEquals(actualNewWindowText,expectedNewWindowText);
        //When user goes back to the previous window and then verifies the title : “The Internet”
        //i need to go back to parent window
        driver.switchTo().window(parentWindowHandle);
        Assert.assertEquals(driver.getTitle(),"The Internet");





    }

}
