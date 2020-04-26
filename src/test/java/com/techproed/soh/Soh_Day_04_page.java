package com.techproed.soh;

import com.techproed.utilities.Driver;
import javafx.beans.value.WeakChangeListener;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Soh_Day_04_page {
    public Soh_Day_04_page(){
        PageFactory.initElements(Driver.getDriver(), this); }
    @FindBy(id = "user-name")
    public WebElement username;
    @FindBy(id = "password")
    public WebElement password;
    @FindBy(xpath = "//input[@class='btn_action']")
    public WebElement loginButton;
    public String url = "https://www.saucedemo.com/";
    public  String expectedErrorMessage = "Sorry, this user has been locked out.";
    @FindBy(xpath = "//h3[@data-test='error']")
    public WebElement errorMessage;


}
