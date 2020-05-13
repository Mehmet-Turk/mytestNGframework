package com.techproed.tests;

import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class JSExecutorDemo {
    //you can handle hidden elements
    //you can bold an image
    //you can change the background color
    //when selenium has some limitation, then javascript executor can be used
    @Test
    public void JavascriptExecutorTest() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("fhc_login_url"));
        WebElement loginButton=Driver.getDriver().findElement(By.id("btnSubmit"));
        clickElementByJS(loginButton);
        System.out.println(getTitleByJS());

        scrollIntoViewByJS(Driver.getDriver().findElement(By.xpath("//*[.='Instagram']")));
        scrollDownByJS();
        generateAlert("Merhaba");
    }
    //This method will takes two parameter: WebElement, and WebDriver
    //When you pass the element, JS will click on that element
    public void clickElementByJS(WebElement element){
        JavascriptExecutor jsexecutor=((JavascriptExecutor) Driver.getDriver());
        jsexecutor.executeScript("arguments[0].click();",element);
    }
    //to get page title with JS
    public String getTitleByJS(){
        JavascriptExecutor jsexecutor=((JavascriptExecutor) Driver.getDriver());
        String title = jsexecutor.executeScript("return document.title").toString();
        return title;
    }
    //to scroll down by using js
    public void scrollDownByJS(){
        JavascriptExecutor jsexecutor=((JavascriptExecutor) Driver.getDriver());
        jsexecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    //to scroll down to a element
    public void scrollIntoViewByJS(WebElement element){
        JavascriptExecutor jsexecutor=((JavascriptExecutor) Driver.getDriver());
        jsexecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void flash(WebElement element, WebDriver driver){
        String bgColor=element.getCssValue("backgroundcolor");
        for (int i=0;i<10;i++){
            changeColor("rgb(0,200,0",element);
            changeColor(bgColor,element);
        }
    }
    public void changeColor(String color, WebElement element) {
        JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) Driver.getDriver());
        javascriptExecutor.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //this will generate an alert when needed
    public void generateAlert(String message) throws InterruptedException {
        JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) Driver.getDriver());
        javascriptExecutor.executeScript("alert('" + message + "')");
        Thread.sleep(3000);
    }
}
