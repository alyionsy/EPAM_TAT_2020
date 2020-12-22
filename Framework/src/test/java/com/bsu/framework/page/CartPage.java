package com.bsu.framework.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final String CART_URL = "http://www.ktown4u.com/cart";
    private String itemXpath;

    @FindBy(xpath = "//a[@id=\"cartDel\"]")
    private WebElement deleteButton;

    @FindBy(xpath = "//a[@class=\"modal-btn btn-light-blue\"]")
    private WebElement confirmDeleteButton;

    @FindBy(xpath = "//input[@id=\"settleButton\"]")
    private WebElement proceedToCheckoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        itemXpath = "";
    }

    public CartPage(WebDriver driver, String itemXpath) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.itemXpath = itemXpath;
    }

    public boolean isItemInCart() {
        try {
            return driver.findElement(By.xpath(itemXpath)) != null;
        } catch (NoSuchElementException exception) {
            logger.error("No such element in the cart.");
            return false;
        }
    }

    public CartPage deleteItem() {
        deleteButton.click();
        return this;
    }

    public CartPage confirmDelete() {
        confirmDeleteButton.click();
        return this;
    }

    public CartPage proceedToCheckout() {
        proceedToCheckoutButton.click();
        return this;
    }

    public LoginPage openLoginPage() {
        return new LoginPage(driver);
    }

    @Override
    public CartPage openPage() {
        driver.navigate().to(CART_URL);
        return this;
    }
}
