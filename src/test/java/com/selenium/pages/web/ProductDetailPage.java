package com.selenium.pages.web;

import com.selenium.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends PageObject
{
    public ProductDetailPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(id = "prcIsum")
    public WebElement productPriceText;

    @FindBy(css = "#vi-atl-lnk span:nth-child(2)")
    public WebElement addToWatchListTet;

}
