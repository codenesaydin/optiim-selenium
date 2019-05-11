package com.pages.web;

import com.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject
{
    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(id = "gh-cat")
    public WebElement categoriesSelect;

}
