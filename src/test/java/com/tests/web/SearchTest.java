package com.tests.web;

import com.annotations.Description;
import com.context.AbstractEbayTest;
import com.context.flag.ParallelExecutable;
import com.pages.UrlFactory;
import com.pages.web.HomePage;
import com.pages.web.ProductDetailPage;
import com.pages.web.SearchResultPage;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(ParallelExecutable.class)
public class SearchTest extends AbstractEbayTest
{
    private static final Logger logger = Logger.getLogger(SearchTest.class);

    private String TOP_LEVEL_CATEGORY_CRAWLING_IS_NOT_ALLOWED = "Top level category browsing is not allowed. Please provide keywords or more filters for the applied top level category.";
    private String searchKeyword = "Yüzüklerin Efendisi";

    private HomePage homePage;
    private SearchResultPage searchResultPage;
    private ProductDetailPage productDetailPage;

    @Before
    public void before()
    {
        homePage = new HomePage(driver);
        searchResultPage = new SearchResultPage(driver);
        productDetailPage = new ProductDetailPage(driver);
    }

    @Test
    @Description("Book search and add to watch list")
    public void testBookSearch()
    {
        navigateToURL(UrlFactory.MAIN_URL);
        selectOptionValue(homePage.categoriesSelect, "267");
        waitAndClick(homePage.searchButton);

        Assert.assertEquals("page notice text not same !!!", TOP_LEVEL_CATEGORY_CRAWLING_IS_NOT_ALLOWED, getText(searchResultPage.pageNoticeStatusText));

        waitAndSendKeys(searchResultPage.searchInput, searchKeyword);
        waitAndClick(searchResultPage.searchButton);
        waitAndClick(searchResultPage.tooltipCloseButton);
        waitAndClick(searchResultPage.searchResultProducts.get(0));

        String productPrice = getText(productDetailPage.productPriceText);

        logger.info("Product Price --> " + productPrice);

        waitAndClick(productDetailPage.addToWatchListTet);

        login(configuration.getTestUsername(), configuration.getTestUsernamePassword());

        Assert.assertEquals("product does not appear in the watchlist !!!", "Watching", getText(productDetailPage.addToWatchListTet));
    }


}
