package com.bsu.framework.test;

import com.bsu.framework.model.Item;
import com.bsu.framework.page.ItemPage;
import com.bsu.framework.page.LoginPage;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CartTests extends CommonConditions {
    private Item item = new Item("http://www.ktown4u.com/iteminfo?grp_no=1741898&goods_no=47178",
            "//span[@class=\"btxt\"]",
            "BLACKPINK - 1st FULL ALBUM [THE ALBUM] (Ver.3)");

    @Test
    public void addToCartTest() {
        Boolean isItemInCart = new ItemPage(driver, item.getUrl())
                .openPage()
                .addToCart()
                .waitForTheNextWebElement()
                .goToCart()
                .openCartPage(item.getXpath())
                .isItemInCart();
        assertThat(isItemInCart, is(true));
    }

    @Test
    public void deleteFromCartTest() {
        Boolean isItemInCart = new ItemPage(driver, item.getUrl())
                .openPage()
                .addToCart()
                .waitForTheNextWebElement()
                .goToCart()
                .openCartPage(item.getXpath())
                .deleteItem()
                .confirmDelete()
                .isItemInCart();

        assertThat(isItemInCart, is(false));
    }

    @Test
    public void proceedToCheckoutWithoutAuthorizationTest() {
        Boolean isCurrentPageLoginPage = new ItemPage(driver, item.getUrl())
                .openPage()
                .addToCart()
                .waitForTheNextWebElement()
                .goToCart()
                .openCartPage(item.getXpath())
                .proceedToCheckout()
                .openLoginPage()
                .getCurrentPageUrl()
                .contains(new LoginPage(driver).getLoginPageUrl()); // ???

        assertThat(isCurrentPageLoginPage, is(true));
    }

    @Test
    public void savingItemsInTheCart() {

    }
}