package com.Banking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    public WebDriver driver;
    public static String button = "//a[contains(text(),'%s')]";
    public static String new_customer_form_fields = "//*[@name='%s']";
    public static String form_button = "//*[@value='%s']";
    public static String radio_button = "//*[@name='rad1']";


    public HomePage (WebDriver driver){
        this.driver = driver;
    }

    public WebElement getbuttons(String buttonName){

        return driver.findElement(By.xpath(String.format(button,buttonName)));
    }

    public WebElement getNewCustomerFormFields(String customer_field){

        return driver.findElement(By.xpath(String.format(new_customer_form_fields,customer_field)));
    }

    public WebElement getFormButtons(String form_buttons){

        return driver.findElement(By.xpath(String.format(form_button,form_buttons)));
    }

    public WebElement getRadioButtons(){

        return driver.findElement(By.xpath(radio_button));
    }
    public WebElement custDOB(String mm){

        return driver.findElement(By.xpath(String.format(new_customer_form_fields,mm)));
    }
}

