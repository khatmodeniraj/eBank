package com.Banking.testCases;

import com.Banking.pageObjects.LoginPage;
import com.Banking.utilities.XLUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginDDT extends BaseClass{

    public static Logger log = LogManager.getLogger(BaseClass.class.getName());

    @BeforeTest
    public void initialize() throws IOException
    {
        driver =initializeDriver();
        log.info("Driver is launched");
    }

    @Test(dataProvider = "LoginData")
    public void LoginDDT(String usr,String pwd) throws IOException {
        driver.get(url);
        LoginPage lp = new LoginPage(driver);
        lp.getUsername().sendKeys(usr);
        log.info("Adding username " + usr);
        lp.getPassword().sendKeys(pwd);
        log.info("Adding password " + pwd);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        lp.getLoginButton().click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        if (isAlertPresent() == true) {
            log.info("Entered Invalid user "+usr);
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
            Assert.assertTrue(false);
            captureScreen(driver,"loginTest");
        }

        else {
            log.info("Entered Valid user "+usr);
            Assert.assertTrue(true);
            lp.getLogOut().click();
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
        }
    }
    public boolean isAlertPresent(){

        try {
            driver.switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException e){
            return false;
        }

    }

    @DataProvider(name = "LoginData")
    Object[][] getlogin() throws IOException {

        String path = System.getProperty("user.dir")+"/src/test/java/com/Banking/testData/LoginData.xlsx";
        int rowNum = XLUtils.getRowCount(path,"Sheet1");
        int colCount = XLUtils.getCellCount(path,"Sheet1",1);

        String loginData [][] = new String[rowNum][colCount];

        for (int i=1;i<=rowNum;i++) {

            for (int j = 0; j < colCount; j++) {

                loginData[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);

            }

        }
        return loginData;
    }
    @AfterTest
    public void teardown()
    {
        driver.close();
    }



}
