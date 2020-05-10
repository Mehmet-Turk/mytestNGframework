package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FhcLoginPage {
    WebDriver driver;
    public FhcLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    public FhcLoginPage(WebDriver driver){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "UserName")
    public WebElement username;
    @FindBy(id = "Password")
    public WebElement password;
    @FindBy(id = "btnSubmit")
    public WebElement loginButton;
    @FindBy(id = "divMessageResult")
    public WebElement warningMessage;

}
