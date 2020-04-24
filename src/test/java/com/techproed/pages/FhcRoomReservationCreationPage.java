package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FhcRoomReservationCreationPage {
    public FhcRoomReservationCreationPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//div[@class='caption']")
    public WebElement roomCreationText;
    @FindBy(id = "IDUser")
    public WebElement IDUser;
    @FindBy(id = "IDHotelRoom")
    public WebElement IdHotelRoom;
    @FindBy(id = "Price")
    public WebElement price;
    @FindBy(id = "DateStart")
    public WebElement dateStart;
    @FindBy(id = "DateEnd")
    public WebElement dateEnd;
    @FindBy(id = "AdultAmount")
    public WebElement adultAmount;
    @FindBy(id = "ChildrenAmount")
    public WebElement childrenAmount;
    @FindBy(id = "ContactNameSurname")
    public WebElement contactNameSurname;
    @FindBy(id = "ContactPhone")
    public WebElement contactPhone;
    @FindBy(id = "ContactEmail")
    public WebElement contactEmail;
    @FindBy(id = "Notes")
    public WebElement notes;
    @FindBy(id = "Approved")
    public WebElement approved;
    @FindBy(xpath = "(//input[@name='IsPaid'])[1]")
    public WebElement isPaid;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;
    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement popUpText;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement popUpButton;

}
