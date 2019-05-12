package com.selenium.pages.web;

import com.selenium.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends PageObject
{
    public SearchResultPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(className = "page-notice__cell")
    public WebElement pageNoticeStatusText;

    @FindBy(css = ".srp-results li a.s-item__link")
    public List<WebElement> searchResultProducts;

    @FindBy(className = "srp-save-search__tooltip-close")
    public WebElement tooltipCloseButton;

}
