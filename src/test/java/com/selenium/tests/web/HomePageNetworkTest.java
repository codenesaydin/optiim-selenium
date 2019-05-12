package com.selenium.tests.web;

import com.selenium.annotations.Description;
import com.selenium.context.AbstractEbayTest;
import com.selenium.context.flag.NetworkExecutable;
import com.selenium.context.flag.ParallelExecutable;
import com.selenium.pages.UrlFactory;
import net.lightbody.bmp.core.har.HarEntry;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.List;

@Category({ParallelExecutable.class, NetworkExecutable.class})
public class HomePageNetworkTest extends AbstractEbayTest
{
    private static final Logger logger = Logger.getLogger(HomePageNetworkTest.class);

    @Before
    public void init() throws Exception
    {
        super.init(true);
    }

    @Test
    @Description("Home Page Image Load Test")
    public void testHomePageImageUpload()
    {
        navigateToURL(UrlFactory.MAIN_URL);

        List<HarEntry> entries = proxy.getHar().getLog().getEntries();

        entries.stream()
                .filter(link -> link.getRequest().getUrl().contains(".png") | link.getRequest().getUrl().contains(".jpg"))
                .forEach(png -> {
                    logger.info("Check Response This Url -> " + png.getRequest().getUrl());

                    Assert.assertEquals("HTTP Request Error : " + png.getRequest().getUrl(), 200, png.getResponse().getStatus());
                });
    }
}
