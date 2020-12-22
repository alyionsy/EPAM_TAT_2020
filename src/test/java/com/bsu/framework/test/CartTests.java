package com.bsu.framework.test;

import com.bsu.framework.page.CartPage;
import com.bsu.framework.page.ItemPage;
import com.bsu.framework.page.LandingPage;
import com.bsu.framework.page.SearchResultPage;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CartTests extends CommonConditions {
    public static final String ITEM_NAME = "BLACKPINK - 1st FULL ALBUM [THE ALBUM] (Ver.3)";

    @Test
    public void addToCartTest() {
        String url = "http://www.ktown4u.com/";

        LandingPage landingPage = new LandingPage(driver);
        landingPage.openPage();

        landingPage.fillSearchField("BLACKPINK - 1st FULL ALBUM [THE ALBUM] (Ver.3)");
        landingPage.clickSearchButton();

        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.itemLinkClick();

        ItemPage itemPage = new ItemPage(driver);
        itemPage.cartButtonClick();

        itemPage.waitForTheNextWebElement(itemPage.getGoToCartButton());
        itemPage.goToCartButtonClick();

        CartPage cartPage = new CartPage(driver);

        assertThat(cartPage.getItemName(), is(equalTo(ITEM_NAME)));
    }
}