package com.techproed.tests;

import org.testng.annotations.*;

public class TestNGAnnotations {

    @BeforeMethod//runs before each method that has @Test annotation
    public void beforeMethod(){
        System.out.println("This is before method");

    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("This is before class");
    }
    @Test//use to create test cases or test method
    public void test1(){
        System.out.println("This is test1 method test case");

    }
    @Test
    public void test2(){
        System.out.println("This is test2 method test case");
    }
    @Ignore//used to skip test case not for before and after
    @Test
    public void test3(){
        System.out.println("This is test3 method test case");
    }
    @Ignore
    @AfterMethod
    public void afterMethod(){
        System.out.println("This is after method");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("This is after class");
    }
}
