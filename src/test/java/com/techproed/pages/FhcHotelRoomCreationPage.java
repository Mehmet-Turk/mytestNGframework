package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FhcHotelRoomCreationPage {
    public FhcHotelRoomCreationPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//span[@class='hidden-480']")
    public WebElement addRoomButton;
    @FindBy(id = "IDHotel")
    public WebElement idHotel;
    public String idHotelText = "BugShooters Hotel";
    @FindBy(id = "Code")
    public WebElement code;
    public String codeText = "500";
    @FindBy (id = "Name")
    public WebElement name;
    public String nameText = "Victoria";
    @FindBy (xpath = "//textarea[@dir='ltr']")
    public WebElement description;
    public String descriptionText = "This room created for special guests";
    @FindBy (id = "Price")
    public WebElement priceTextBox;
    @FindBy(xpath = "//li[@data-id='500']")
    public WebElement priceAmount;
    @FindBy (id = "IDGroupRoomType")
    public WebElement roomType;
    public String roomTypeText = "King";
    @FindBy (id = "MaxAdultCount")
    public WebElement maxAdultCount;
    public String maxAdultCountText = "2";
    @FindBy(id = "MaxChildCount")
    public WebElement maxChildrenCount;
    public String maxChildrenCountText = "3";
    @FindBy(id = "uniform-IsAvailable")
    public WebElement approvedCheckBox;
    @FindBy (id = "btnSubmit")
    public WebElement saveButton;
    @FindBy (xpath = "//div[@class='bootbox-body']")
    public WebElement popOpText;
    public String expectedPopUpText = "HotelRoom was inserted successfully";
    @FindBy (xpath = "//button[@data-bb-handler='ok']")
    public WebElement popOpButton;




}
