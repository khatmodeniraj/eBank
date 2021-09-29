package com.Banking.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public WebDriver driver;

    By username = By.xpath("//input[@name='uid']");
    By password = By.xpath("//input[@name='password']");
    By login_button = By.xpath("//input[@name='btnLogin']");
    By logout_button = By.xpath("//a[contains(text(),'Log out')]");

    public LoginPage (WebDriver driver){
        this.driver = driver;
    }

    public WebElement getUsername() {
        return driver.findElement(username);
    }

    public WebElement getPassword() {
        return driver.findElement(password);
    }

    public WebElement getLoginButton() {
        return driver.findElement(login_button);
    }
    public WebElement getLogOut() {
        return driver.findElement(logout_button);
    }
}
