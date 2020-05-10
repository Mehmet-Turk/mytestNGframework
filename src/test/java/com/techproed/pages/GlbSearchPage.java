package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GlbSearchPage {
    public GlbSearchPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy (xpath = "//h4[@class='icon-hotproduct']")
    public List<WebElement> allProducts;
    @FindBy (xpath = "//div[@class='row']")
    public List<WebElement> allProducts1;


}
