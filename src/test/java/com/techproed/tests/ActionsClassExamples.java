package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsClassExamples extends TestBase {
    /*
    Create a class: ActionsClassExample
Create a test method : contextClickMethod() and test the following scenario:
Given user is on the https://the-internet.herokuapp.com/context_menu
When use Right clicks on the box
Then verify the alert message is “You selected a context menu”
Then accept the alert
     */
    @Test
    public void contextClickMethod(){
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement rightClickArea = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);//it for mouse and keyboard actions
        actions.contextClick(rightClickArea).perform();
        String actualAlertMessage = driver.switchTo().alert().getText();
        String expectedAlertMessage = "You selected a context menu";
        Assert.assertEquals(actualAlertMessage,expectedAlertMessage);
        driver.switchTo().alert().accept();
        WebElement target = driver.findElement(By.linkText("Elemental Selenium"));
        actions.contextClick(target).perform();
    }
    @Test
    public void hoverOver(){
         /*Create another test method : hoverOver() and test the following scenario:
        Given user is on the https://www.amazon.com/
        When use click on “Your Account” link
        Then verify the page title contains “Your Account”
         */
         driver.get("https://www.amazon.ca/");
         WebElement account = driver.findElement(By.id("nav-link-accountList"));
         actions.moveToElement(account).perform();
         driver.findElement(By.xpath("(//span[@class='nav-text'])[9]")).click();
         String actualTitle = driver.getTitle();
         String expectedTitle ="Your Account";
         Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
    @Test
    public void imageTest(){
        driver.get("https://www.amazon.ca/");
        WebElement tryPrime = driver.findElement(By.id("nav-link-prime"));
        actions.moveToElement(tryPrime).perform();
        WebElement picture = driver.findElement(By.xpath("//div[@class='pin-nav-content-img']"));
        Assert.assertTrue(picture.isDisplayed());
    }
    @Test
    public void keysUpDown(){
        /*
        Create a method in the same class: keysUpDown()
        Go to google
        Search for IPHONE X PRICES (all capital)
        And double click on the text box
         */
        driver.get("https://www.google.com/");
        WebElement searchBox = driver.findElement(By.name("q"));
        // searchBox.sendKeys("iphone x prices");
        //input => iphone x prices. output => IPHONE X PRICES
        //METHOD 1 TO SEND UPPER CASE:
        //searchBox.sendKeys(Keys.SHIFT+"iphone x prices");
        //searchBox.sendKeys(Keys.SHIFT+"iphone x prices");
        //METHOD 2 : ACTIONS CLASS
        //using Keys.Shift we are pressing shift key on the keyboard
//        actions.
//                moveToElement(searchBox).
//                click().
//                keyDown(Keys.SHIFT).
//                sendKeys("iphone x prices").
//////                perform();
        actions.//using the actions object
                keyDown(searchBox, Keys.SHIFT).//pressing shift on the keyboard
                sendKeys("iphone x prices").//typing
                keyUp(searchBox, Keys.SHIFT).//releasing the shift button
                perform();//performing the action
       // searchBox.sendKeys(  Keys.SHIFT+"i"+Keys.SHIFT+"phone11");
        actions.keyDown(searchBox,Keys.SHIFT).sendKeys("se").keyUp(searchBox,Keys.SHIFT).perform();
        //actions.doubleClick(searchBox).perform();//Go and double click on searchBox
    }
    @Test
    public void scrollUpDown() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        //Scrolling down the page
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(5000);
        //We can use multiple page down or page up on a single class
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(5000);
        //ARROW_DOWN also scrolls down the page, but it scroll less amount
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(5000);
        //Scroll Up A Page using sendKeys(Keys.PAGE_UP)
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(5000);
        //Scroll Up A Page using sendKeys(Keys.ARROW_UP)
        actions.sendKeys(Keys.ARROW_UP).perform();
    }

}

