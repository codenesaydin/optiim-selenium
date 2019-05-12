package com.selenium.context;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration
{
    private static final Logger logger = Logger.getLogger(Configuration.class);

    private Properties configProps = new Properties();

    private String browserType;
    private Boolean takeAVideo;
    private String galenReportPath;
    private String harFilePath;
    private Integer pageLoadTimeout;
    private Integer waitLoadTimeout;
    private Integer implicitlyWait;
    private String macChromeDriver;
    private String windowsChromeDriver;
    private String testResultReport;

    public Configuration() throws IOException
    {
        loadConfigProperties();

        this.browserType = System.getProperties().getProperty("browser.type");
        this.takeAVideo = readBooleanParameter("take.a.video");
        this.galenReportPath = configProps.getProperty("galen.report.path");
        this.harFilePath = configProps.getProperty("har.file.path");
        this.pageLoadTimeout = Integer.valueOf(configProps.getProperty("page.load.timeout"));
        this.waitLoadTimeout = Integer.valueOf(configProps.getProperty("wait.timeout.seconds"));
        this.implicitlyWait = Integer.valueOf(configProps.getProperty("implicitly.wait"));
        this.macChromeDriver = configProps.getProperty("mac.chrome.driver");
        this.windowsChromeDriver = configProps.getProperty("windows.chrome.driver");
        this.testResultReport = configProps.getProperty("test.result.report");
    }

    private void loadConfigProperties() throws IOException
    {
        String configFile = "config.properties";
        InputStream in = ClassLoader.getSystemResourceAsStream(configFile);

        configProps.load(in);
    }

    private boolean readBooleanParameter(String propertyKey)
    {
        boolean defaultValue = false;
        String propertyValue = System.getProperties().getProperty(propertyKey);

        if (StringUtils.isNotBlank(propertyValue))
        {
            try
            {
                defaultValue = Boolean.valueOf(propertyValue);
            }
            catch (Exception e)
            {
                System.out.println(propertyKey + " : default (false)");
            }
        }

        return defaultValue;
    }

    public String getBrowserType()
    {
        return browserType;
    }

    public void setBrowserType(String browserType)
    {
        this.browserType = browserType;
    }

    public Boolean getTakeAVideo()
    {
        return takeAVideo;
    }

    public void setTakeAVideo(Boolean takeAVideo)
    {
        this.takeAVideo = takeAVideo;
    }

    public String getGalenReportPath()
    {
        return galenReportPath;
    }

    public void setGalenReportPath(String galenReportPath)
    {
        this.galenReportPath = galenReportPath;
    }

    public String getHarFilePath()
    {
        return harFilePath;
    }

    public void setHarFilePath(String harFilePath)
    {
        this.harFilePath = harFilePath;
    }

    public Integer getPageLoadTimeout()
    {
        return pageLoadTimeout;
    }

    public void setPageLoadTimeout(Integer pageLoadTimeout)
    {
        this.pageLoadTimeout = pageLoadTimeout;
    }

    public Integer getWaitLoadTimeout()
    {
        return waitLoadTimeout;
    }

    public void setWaitLoadTimeout(Integer waitLoadTimeout)
    {
        this.waitLoadTimeout = waitLoadTimeout;
    }

    public Integer getImplicitlyWait()
    {
        return implicitlyWait;
    }

    public void setImplicitlyWait(Integer implicitlyWait)
    {
        this.implicitlyWait = implicitlyWait;
    }

    public String getMacChromeDriver()
    {
        return macChromeDriver;
    }

    public void setMacChromeDriver(String macChromeDriver)
    {
        this.macChromeDriver = macChromeDriver;
    }

    public String getWindowsChromeDriver()
    {
        return windowsChromeDriver;
    }

    public void setWindowsChromeDriver(String windowsChromeDriver)
    {
        this.windowsChromeDriver = windowsChromeDriver;
    }

    public String getTestResultReport()
    {
        return testResultReport;
    }

    public void setTestResultReport(String testResultReport)
    {
        this.testResultReport = testResultReport;
    }

}
