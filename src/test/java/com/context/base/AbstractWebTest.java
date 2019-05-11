package com.context.base;

import com.context.manager.DriverManager;
import com.utils.ReportGenerate;
import com.utils.recorder.VideoRecorder;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.proxy.CaptureType;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public abstract class AbstractWebTest extends AbstractSeleniumTest
{
    private static final Logger logger = Logger.getLogger(AbstractWebTest.class);

    @Rule
    public final TestName testName = new TestName();

    @Rule
    public ReportGenerate reportGenerate = new ReportGenerate();

    @Rule
    public TestRule statusLog = new TestWatcher()
    {
        @Override
        protected void starting(Description description)
        {
            logger.info(String.format("====> TEST STARTED {%s}", getDisplayName(description)));
        }

        @Override
        public void succeeded(Description description)
        {
            logger.info(String.format("====> TEST PASSED {%s}", getDisplayName(description)));
        }

        @Override
        public void failed(Throwable e, Description description)
        {
            logger.info(String.format("====> TEST FAILED {%s}", getDisplayName(description)));
        }

        @Override
        public void finished(Description description)
        {
            logger.info(String.format("====> TEST FINISHED {%s}", getDisplayName(description)));
        }
    };

    @Before
    public void init() throws Exception
    {
        init(false);
    }

    public void init(Boolean withProxy) throws Exception
    {
        DriverManager driverManager;
        driverManager = DriverWebTestFactory.getManager();

        if (withProxy)
        {
            while (true)
            {
                try
                {
                    proxy = new BrowserMobProxyServer();
                    proxy.setMitmDisabled(false);
                    proxy.start();
                    proxy.enableHarCaptureTypes(CaptureType.REQUEST_BINARY_CONTENT);
                    proxy.newHar();
                    break;
                }
                catch (Exception ex)
                {
                    logger.error("Already Use Proxy, retrying start proxy.");
                    continue;
                }
            }

        }

        driver = driverManager.getDriver(withProxy);

        VideoRecorder.startRecording(testName.getMethodName(), configuration.getTakeAVideo());
    }

    @After
    public void tearDown() throws Exception
    {
        VideoRecorder.stopRecording(configuration.getTakeAVideo());

        try
        {
            if (proxy != null) proxy.stop();
        }
        catch (IllegalStateException ex)
        {
            logger.info("Already Stopped Proxy");
        }

        if (driver != null)
        {
            driver.close();
            driver.quit();
            driver = null;
        }
    }

    private String getDisplayName(Description description)
    {
        return description.getMethodName() + " (" + description.getTestClass().getSimpleName() + ")";
    }

}
