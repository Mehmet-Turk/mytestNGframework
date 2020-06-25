package com.techproed.tests;

import com.techproed.pages.FhcLogin;
import com.techproed.pages.FhcLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DataProviderDemo {

    @Test(dataProvider = "login data")
    public void LoginTest(String user, String pass){
        Driver.getDriver().get(ConfigReader.getProperty("fhc_login_url"));
        FhcLogin fhcLogin = new FhcLogin();
        fhcLogin.username.sendKeys(user);
        fhcLogin.password.sendKeys(pass);
        fhcLogin.logInButton.click();
        Assert.assertFalse(fhcLogin.error_message.getText().contains(ConfigReader.getProperty("login_error_message")));

    }
    @DataProvider(name = "login data")//while using dataprovider use this name
    //defines method as data provider and data provider takes 2 dimensional array and returns
    //it one by one
    public Object [][] getData(){
        //{{user1,pass1},
        // {user2,pass2},
        // {user3,pass3}}
        Object[][] data=new Object[3][2];
        //1st row of data
        data[0][0]="user1";
        data[0][1]="pass1";
        //2nd row of data
        data[1][0]="user2";
        data[1][1]="pass2";
        //3rd data
        data[2][0]="user3";
        data[2][1]="pass3";
        return data;
    }


}


