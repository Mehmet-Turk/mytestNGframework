package com.techproed.pages;

import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FhcLogin {
    //create a login page with objects and log in method
    public FhcLogin(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    //page objects
    @FindBy(id = "UserName")
    public WebElement username;
    @FindBy(id = "Password")
    public WebElement password;
    @FindBy(xpath = "//input[@type='submit']")
    public WebElement logInButton;
    @FindBy(xpath = "//div[@id='divMessageResult']")
    public WebElement error_message;
    //creating a log in method
    public void login(){
        //login("manager2","Manager2!");==> user=manager2,pass=Manager2!
        //login("asdga","asdga");==>user="asdga" , pass="asdga"
        Driver.getDriver().get(ConfigReader.getProperty("fhc_login_url"));
        username.sendKeys(ConfigReader.getProperty("valid_username"));
        password.sendKeys(ConfigReader.getProperty("valid_password"));
        logInButton.click();
    }
}

