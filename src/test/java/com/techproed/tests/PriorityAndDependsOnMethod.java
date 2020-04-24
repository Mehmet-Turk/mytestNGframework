package com.techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class PriorityAndDependsOnMethod {
    /*
    in testNG, test methods runs by alphabetical order.They do not run top to bottom
    to prioritize a test case we use priority annotation you can give -23 vs..
    if the priority number are same it execute them in alphabetical order
    IF WE WANT TO DEPEND TWO METHODS WE USE DEPENDSONMETHODS IF FIRST ONE FAILS
    OTHER ONE WILL NOT RUN
     */
    @Test(priority = 0)
    public void login(){
        System.out.println("This is login page");

    }
    @Test(priority = 2)
    public void homePage() {
        System.out.println("This is home page");

    }
    @Test(priority = 3)
    public void search(){
        System.out.println("This is search page");
        Assert.assertTrue(false);

    }
    @Test(priority = 4,dependsOnMethods = "search")//depends running to search method
    public void result(){
        System.out.println("This is result page");

    }
}
