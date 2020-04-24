package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframeTest {
    /*
    create a class : IframeTest
    create a @BeforeMethod and go to https://the-internet.herokuapp.com/iframe
     */
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/iframe");
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public void iFrame(){
        System.out.println(driver.findElement(By.tagName("h3")).getText());//or by xpath "//h3"
        //Trying to type in the box
        //WebElement textBox=driver.findElement(By.xpath("//p"));//This Fails
        //IF YOUR CODE FAILS WHAT DO YOU DO?
        //1.checking of the webelement is correct
        //2.checking if i have wait problem
        //3.then check the page if you have some iframe
        //trying to write in iframe
        //if I HAVE IFRAME I NEED TO SWTICH TO IFRAME
        //THERE ARE 3 WAYS TO SWITCH AN IFRAME 1)INDEX, 2)ID OR 3)WEB ELEMENT
        //driver.switchTo().frame("mce_0_ifr");//SWITCHING TO IFRAME BY ID
        //driver.switchTo().frame(0);//SWITCHING TO IFRAME BY INDEX NUMBER FIRST OR SECOND ETC
        WebElement frame = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(frame);//SWITCHING BY WEB ELEMENT TO DO I NEED TO PROVIDE AN WEB ELEMENT
        WebElement textBox= driver.findElement(By.xpath("//p"));
        textBox.clear();//CLEAR INSIDE THE TEXTBOX
        textBox.sendKeys("Hello world");
        //typing the box
        //Print Elemental Selenium
        //switching back to parent frame
        //driver.switchTo().parentFrame();

        driver.switchTo().defaultContent();
        WebElement selenium = driver.findElement(By.partialLinkText("Selenium"));
        System.out.println(selenium.getText());


    }
}
