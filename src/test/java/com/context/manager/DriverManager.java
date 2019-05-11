package com.context.manager;

import com.context.Configuration;
import net.lightbody.bmp.BrowserMobProxy;
import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class DriverManager
{
    protected static RemoteWebDriver driver;
    protected static BrowserMobProxy proxy;
    protected static Configuration configuration;
    public static String session;

    protected void createDriver(Boolean withProxy) {}

    public RemoteWebDriver getDriver(Boolean withProxy) throws Exception
    {
        if (driver == null)
        {
            configuration  = new Configuration();

            createDriver(withProxy);
        }
        return driver;
    }
}
