package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaceLoginPage {
    //we will create page element in this class so that we can use in other class to reduce work
    //we will store all of web elements in this class end use other class
    //creating driver
    //initialize the driver using constructor
    public FaceLoginPage(){
        //We are using PageFactory to initialize the driver
        PageFactory.initElements(Driver.getDriver(),this);//driver is page instance, this means page instance
    }
    @FindBy(id = "email")
    public WebElement email;
    @FindBy(id = "pass")
    public WebElement password;
    @FindBy(id = "u_0_b")
    public WebElement submitButton;
}
