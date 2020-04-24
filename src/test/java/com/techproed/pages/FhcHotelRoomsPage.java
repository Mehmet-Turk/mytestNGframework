package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FhcHotelRoomsPage {
    public FhcHotelRoomsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//span[@class='hidden-480']")
    public WebElement addHotelRoom;
    @FindBy(xpath = "//span[@class='caption-subject font-green-sharp bold uppercase']")
    public WebElement listOfRoomsText;
    @FindBy (name = "Code")
    public WebElement codeTextBox;
    @FindBy(xpath = "//button[@class='btn btn-sm yellow filter-submit margin-bottom']")
    public WebElement searchButton;
    @FindBy(xpath = "//td[@class='sorting_1']")
    public WebElement codeData;
    @FindBy(xpath = "//input[@name='Name']")
    public WebElement nameTextBox;

    public WebElement cellFinder(int row, int column){
        WebElement cell = Driver.getDriver().findElement(By.xpath("//tbody//tr["+row+"]//td["+column+"]"));
        return cell;
    }
}
