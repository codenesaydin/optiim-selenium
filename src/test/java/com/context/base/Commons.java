package com.context.base;

import com.pages.UrlFactory;
import org.openqa.selenium.WebElement;

public interface Commons
{

    void navigateToURL(UrlFactory url);

    void waitAndClick(WebElement element);

    void selectOptionValue(WebElement element, String itemValue);

    void waitAndSendKeys(WebElement element, String text);

    void waitElementToBeClickable(WebElement element);

    void waitElementVisible(WebElement element);

    String getText(WebElement element);

}
