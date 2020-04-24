package com.techproed.pages;

import com.techproed.smoketest.PositiveTest;
import com.techproed.utilities.Driver;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class FhcRoomReservationPage {
   public FhcRoomReservationPage(){
       PageFactory.initElements(Driver.getDriver(), this);
   }
   @FindBy(xpath = "//span[@class='caption-subject font-green-sharp bold uppercase']")
    public WebElement listOfReservationText;
   @FindBy(xpath = "//span[@class='hidden-480']")
    public WebElement addRoomReservationButton;
   @FindBy(xpath = "//input[@name='ContactNameSurname']")
    public WebElement contactNameSurnameText;
   @FindBy (xpath = "//button[@class='btn btn-sm yellow filter-submit margin-bottom']")
    public WebElement searchButton;


    public WebElement cellFinder(int row, int column){
        WebElement cell = Driver.getDriver().findElement(By.xpath("//tbody//tr["+row+"]//td["+column+"]"));
        return cell;
    }

}
