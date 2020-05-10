package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FhcUsersPage {
    public FhcUsersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//span[@class='title'])[3]")
    public WebElement hotelManagement;
    @FindBy(xpath = "//a[@href='/admin/HotelRoomAdmin']")
    public WebElement hotelRooms;
    @FindBy(xpath = "//span[@class='caption-subject font-green-sharp bold uppercase']")
    public WebElement listOfUsersText;
    @FindBy(xpath = "//a[@href='/admin/RoomReservationAdmin']")
    public WebElement roomReservation;
    //==========================================================
    @FindBy(xpath = "(//span[@class='title'])[2]")
    public WebElement userManagementText;
    @FindBy(xpath = "//a[@href='/admin/UserAdmin']")
    public WebElement userList;
    @FindBy(name = "IDUser")
    public WebElement userId;
    @FindBy(name = "UserName")
    public WebElement userNameCheckbox;
    @FindBy(name = "Email")
    public WebElement emailCheckbox;
    @FindBy(name = "NameSurname")
    public WebElement nameSurnameCheckbox;
    @FindBy(name = "BirthDateBegin")
    public WebElement birthDateBeginCheckbox;
    @FindBy(name = "BirthDateEnd")
    public WebElement birthDateEndCheckbox;
    @FindBy(name = "PhoneNo")
    public WebElement phoneNoCheckbox;
    @FindBy(name = "lkpRoles")
    public WebElement role;
    @FindBy(xpath = "//button[@class='btn btn-sm yellow filter-submit margin-bottom']")
    public WebElement searchButton;
    @FindBy(xpath = "//button[@class='btn btn-sm red filter-cancel']")
    public WebElement clearButton;
    @FindBy(xpath = "//span[@class='hidden-480']")
    public WebElement addUserButton;
    @FindBy(xpath = "//span[@class='caption-subject font-green-sharp bold uppercase']")
    public WebElement listOfUsersText1;
    public String userNameText = "cihannuma";
    public String userEmailText = "cihannuma@gmail.com";
    public String userPhoneNumber = "0545 545 45 45";

    public WebElement cellFinder(int row, int column) {
        WebElement cell = Driver.getDriver().findElement(By.xpath("//tbody//tr[" + row + "]//td[" + column + "]"));
        return cell;
    }
}