package com.Banking.testCases;

import com.Banking.utilities.ReadConfig;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    ReadConfig readConfig = new ReadConfig();
    public String url= readConfig.getApplicationURL();
    public String username = readConfig.getUserName();
    public String password = readConfig.getPassword();
    public String browserName= readConfig.getBrowser();


    public WebDriver driver;

    public Properties prop;
    public WebDriver initializeDriver() throws IOException
    {
        System.out.println(browserName);
        if(browserName.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
            driver= new ChromeDriver();
            driver.manage().window().maximize();
            //execute in chrome driver

        }
        else if (browserName.equals("firefox"))
        {
            driver= new FirefoxDriver();
            //firefox code
        }
        else if (browserName.equals("IE"))
        {
//	IE code
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
    public void captureScreen(WebDriver driver, String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
        //FileUtils.copyFile(source, target);
        FileHandler.copy(source, target);
        System.out.println("Screenshot taken");
    }

    public String randomString(){
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        String randomEmail = "username"+ randomInt +"@gmail.com";
        return randomEmail;
    }
}
