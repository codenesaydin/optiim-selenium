package com.selenium.tests.web;

import com.selenium.annotations.Description;
import com.selenium.context.AbstractEbayTest;
import com.selenium.context.flag.ParallelExecutable;
import com.selenium.pages.UrlFactory;
import com.selenium.pages.web.HomePage;
import com.selenium.pages.web.ProductDetailPage;
import com.selenium.pages.web.SearchResultPage;
import com.selenium.utils.Constants;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(ParallelExecutable.class)
public class SearchTest extends AbstractEbayTest
{
    private static final Logger logger = Logger.getLogger(SearchTest.class);

    private HomePage homePage;
    private SearchResultPage searchResultPage;
    private ProductDetailPage productDetailPage;

    @Before
    public void before()
    {
        homePage = new HomePage(driver);
        searchResultPage = new SearchResultPage(driver);
        productDetailPage = new ProductDetailPage(driver);

        testUser = testUserAccountManager.getTestUser(0);
    }

    @Test
    @Description("Book search and add to watch list")
    public void testBookSearch()
    {
        navigateToURL(UrlFactory.MAIN_URL);
        selectOptionValue(homePage.categoriesSelect, "267");
        waitAndClick(homePage.searchButton);

        Assert.assertEquals("page notice text not same !!!", Constants.Search.TOP_LEVEL_CATEGORY_CRAWLING_IS_NOT_ALLOWED, getText(searchResultPage.pageNoticeStatusText));

        waitAndSendKeys(searchResultPage.searchInput, Constants.Search.searchKeyword);
        waitAndClick(searchResultPage.searchButton);
        waitAndClick(searchResultPage.tooltipCloseButton);
        waitAndClick(searchResultPage.searchResultProducts.get(0));

        String productPrice = getText(productDetailPage.productPriceText);

        logger.info("Product Price --> " + productPrice);

        waitAndClick(productDetailPage.addToWatchListTet);

        login(testUser.getUsername(), testUser.getPassword());

        Assert.assertEquals("product does not appear in the watchlist !!!", "Watching", getText(productDetailPage.addToWatchListTet));
    }


}
