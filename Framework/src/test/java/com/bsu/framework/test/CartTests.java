package com.bsu.framework.test;

//-Dtestng.dtd.http=${true} -Dbrowser=${chrome} -Dsurefire.suiteXmlFiles=${src\test\resources\com.bsu.framework\testng-all.xml} clean test
import com.bsu.framework.model.Item;
import com.bsu.framework.model.User;
import com.bsu.framework.page.ItemPage;
import com.bsu.framework.page.LoginPage;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CartTests extends CommonConditions {
    private final Item item = new Item("http://www.ktown4u.com/iteminfo?grp_no=1741898&goods_no=47178",
            "//a[@href=\"/iteminfo?grp_no=1741898&goods_no=47178\"]",
            "BLACKPINK - 1st FULL ALBUM [THE ALBUM] (Ver.3)");
    private final User user = new User("erionolsen@gmail.com", "PQ3cd$jc.c9rLBK");
    private final Item oldItem = new Item("http://www.ktown4u.com/iteminfo?grp_no=1741898&goods_no=31777",
            "//a[@href=\"/iteminfo?grp_no=1741898&goods_no=31777\"]",
            "EXO - 2017 Winter Special Album");

    @Test
    public void addToCartTest() {
        Boolean isItemInCart = new ItemPage(driver, item.getUrl())
                .openPage()
                .addToCart()
                .waitForTheNextWebElement()
                .goToCart()
                .openCartPage()
                .isItemInCart(item.getXpath());
        assertThat(isItemInCart, is(true));
    }

    @Test
    public void deleteFromCartTest() {
        Boolean isItemInCart = new ItemPage(driver, item.getUrl())
                .openPage()
                .addToCart()
                .waitForTheNextWebElement()
                .goToCart()
                .openCartPage()
                .deleteItem()
                .confirmDelete()
                .isItemInCart(item.getXpath());

        assertThat(isItemInCart, is(false));
    }

    @Test
    public void proceedToCheckoutWithoutAuthenticationTest() {
        Boolean isCurrentPageLoginPage = new ItemPage(driver, item.getUrl())
                .openPage()
                .addToCart()
                .waitForTheNextWebElement()
                .goToCart()
                .openCartPage()
                .proceedToCheckout()
                .openLoginPage()
                .getCurrentPageUrl()
                .contains(new LoginPage(driver).getLoginPageUrl()); // ???

        assertThat(isCurrentPageLoginPage, is(true));
    }

    @Test
    public void savingItemsInTheCartTest() {
        Boolean isItemStillInCart = new ItemPage(driver, item.getUrl())
                .openPage()
                .addToCart()
                .waitForTheNextWebElement()
                .goToCart()
                .openCartPage()
                .proceedToCheckout()
                .openLoginPage()
                .login(user)
                .openCartPage()
                .isItemInCart(oldItem.getXpath());

        assertThat(isItemStillInCart, is(true));
    }

    @Test
    public void modifyItemQuantityInCartTest() {
        String quantityToWrite = "2";
        String currentQuantity = new ItemPage(driver, item.getUrl())
                .openPage()
                .addToCart()
                .waitForTheNextWebElement()
                .goToCart()
                .openCartPage()
                .modifyItemQuantity(quantityToWrite)
                .getModifyFieldContent();

        assertThat(currentQuantity, is(equalTo(quantityToWrite)));
    }

    @Test
    public void modifyItemQuantityInCartWithIncorrectDataTest() {
        String incorrectData = "aaa";
        String currentQuantity = new ItemPage(driver, item.getUrl())
                .openPage()
                .addToCart()
                .waitForTheNextWebElement()
                .goToCart()
                .openCartPage()
                .modifyItemQuantity(incorrectData)
                .getModifyFieldContent();

        String initialQuantity = "1";
        assertThat(currentQuantity, is(equalTo(initialQuantity)));
    }
}