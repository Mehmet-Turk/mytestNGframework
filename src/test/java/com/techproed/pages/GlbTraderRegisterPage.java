package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlbTraderRegisterPage {

    public GlbTraderRegisterPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "email")
    public WebElement email;
    @FindBy(id = "name")
    public WebElement name;
    @FindBy (id = "mobile")
    public WebElement phone;
    @FindBy (id = "password")
    public WebElement password;
    @FindBy(id = "re_password")
    public WebElement rePassword;
    @FindBy(xpath = "//button[@name='submit']")
    public WebElement submitButton;
    @FindBy(xpath = "//strong")
    public WebElement successMessage;
}
