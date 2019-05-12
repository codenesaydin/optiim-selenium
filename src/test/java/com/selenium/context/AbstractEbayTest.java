package com.selenium.context;

import com.selenium.context.base.AbstractWebTest;
import com.selenium.pages.web.LoginPage;

public abstract class AbstractEbayTest extends AbstractWebTest
{
    private LoginPage loginPage;

    protected void login(String username, String password)
    {
        if (loginPage == null)
        {
            loginPage = new LoginPage(driver);
        }

        waitAndSendKeys(loginPage.usernameInput, username);
        waitAndSendKeys(loginPage.passwordInput, password);
        waitAndClick(loginPage.signInButton);
    }
}
