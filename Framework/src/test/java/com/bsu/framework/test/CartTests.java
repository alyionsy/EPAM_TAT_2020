package com.bsu.framework.test;

import com.bsu.framework.model.Item;
import com.bsu.framework.page.CartPage;
import com.bsu.framework.page.ItemPage;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CartTests extends CommonConditions {
    private Item item = new Item("http://www.ktown4u.com/iteminfo?grp_no=1741898&goods_no=47178",
            "BLACKPINK - 1st FULL ALBUM [THE ALBUM] (Ver.3)");

    @Test
    public void addToCartTest() {
        new ItemPage(driver, item.getUrl())
                .openPage()
                .addToCart()
                .waitForTheNextWebElement()
                .goToCart();

        String itemInCartName = new CartPage(driver)
                .openPage()
                .getItemName();

        assertThat(itemInCartName, is(equalTo(item.getName())));
    }
}