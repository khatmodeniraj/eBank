package com.Banking.testCases;

import com.Banking.pageObjects.LoginPage;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class LoginTest extends BaseClass{


    public static Logger log = LogManager.getLogger(BaseClass.class.getName());

    public WebDriver driver;
    @BeforeTest
    public void initialize() throws IOException
    {
        driver =initializeDriver();
        log.info("Driver is launched");
    }

    @Test
    public void loginTest() throws InterruptedException, IOException {

        driver.get(url);
        LoginPage lp = new LoginPage(driver);
        lp.getUsername().sendKeys(username);
        lp.getPassword().sendKeys(password);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        lp.getLoginButton().click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        log.info("User is logged in");

        if(lp.getLogOut()!= null){
            System.out.println("Element is Present");
            log.info("Element is Present");
            Assert.assertTrue(true);
            captureScreen(driver,"loginTest");
        }
        else{
            System.out.println("Element is Absent");
            log.info("Element is Absent");
            Assert.assertTrue(false);
        }

    }

    @AfterTest
    public void teardown()
    {
        driver.close();
    }
}
