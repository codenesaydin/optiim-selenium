package com.selenium.pages.web;

import com.selenium.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject
{
    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(id = "userid")
    public WebElement usernameInput;

    @FindBy(id = "pass")
    public WebElement passwordInput;

    @FindBy(id = "sgnBt")
    public WebElement signInButton;

}
