package com.Banking.testCases;

import com.Banking.pageObjects.HomePage;
import com.Banking.pageObjects.LoginPage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

public class HomePageTest extends BaseClass{

    public static Logger log = LogManager.getLogger(BaseClass.class.getName());

    public WebDriver driver;
    @BeforeTest
    public void initialize() throws IOException
    {
        driver =initializeDriver();
        log.info("Driver is launched");
    }

    @Test
    public void addNewCustomer() throws IOException {
        driver.get(url);
        LoginPage lp = new LoginPage(driver);
        lp.getUsername().sendKeys(username);
        lp.getPassword().sendKeys(password);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        lp.getLoginButton().click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        log.info("User is logged in");

        HomePage hm = new HomePage(driver);
        hm.getbuttons("New Customer").click();
        hm.getNewCustomerFormFields("name").sendKeys("abc");
        hm.getRadioButtons().click();
        hm.getNewCustomerFormFields("dob").sendKeys("12");
        hm.getNewCustomerFormFields("dob").sendKeys("06");
        hm.getNewCustomerFormFields("dob").sendKeys("1985");
        hm.getNewCustomerFormFields("addr").sendKeys("This is address");
        hm.getNewCustomerFormFields("city").sendKeys("Pune");
        hm.getNewCustomerFormFields("state").sendKeys("MH");
        hm.getNewCustomerFormFields("pinno").sendKeys("411051");
        hm.getNewCustomerFormFields("telephoneno").sendKeys("8888888888");
        hm.getNewCustomerFormFields("emailid").sendKeys(randomString());
        hm.getFormButtons("Submit").click();
        boolean res = driver.getPageSource().contains("Customer Registered Successfully!");

        if (res==true){
            log.info("Customer is added successfully");
            Assert.assertTrue(true);

        }

        else{
            log.info("Some issue with adding new Customer");
            captureScreen(driver,"addNewCustomer");
            Assert.assertTrue(false);
        }
    }



    @AfterTest
    public void teardown()
    {
        driver.close();
    }
}
