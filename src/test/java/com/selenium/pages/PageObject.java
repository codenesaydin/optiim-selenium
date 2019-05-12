package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class PageObject
{
    public PageObject(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "gh-ac")
    public WebElement searchInput;

    @FindBy(id = "gh-btn")
    public WebElement searchButton;
}
