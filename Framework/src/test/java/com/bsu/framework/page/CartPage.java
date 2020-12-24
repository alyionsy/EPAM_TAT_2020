package com.bsu.framework.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CartPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final String CART_URL = "http://www.ktown4u.com/cart";


    @FindBy(xpath = "//a[@id=\"cartDel\"]")
    private WebElement deleteButton;

    @FindBy(xpath = "//a[@class=\"modal-btn btn-light-blue\"]")
    private WebElement confirmDeleteButton;

    @FindBy(xpath = "//input[@id=\"settleButton\"]")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//input[@class=\"kt_btn1\"]")
    private WebElement modifyButton;

    @FindBy(xpath = "//input[@class=\"kt_input1\"]")
    private WebElement modifyField;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CartPage(WebDriver driver, String itemXpath) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isItemInCart(String itemXpath) {
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
        logger.info("Item was deleted from the cart.");
        return this;
    }

    public CartPage proceedToCheckout() {
        proceedToCheckoutButton.click();
        return this;
    }

    public CartPage modifyItemQuantity(String newQuantity) {
        modifyField.clear();
        modifyField.sendKeys(newQuantity);
        modifyButton.click();

        Alert alertOK = driver.switchTo().alert();
        alertOK.accept();

        driver.navigate().refresh();

        logger.info("Item quantity was modified.");
        return this;
    }

    public String getModifyFieldContent() {
        return modifyField.getAttribute("value");
    }

    public LoginPage openLoginPage() {
        return new LoginPage(driver);
    }

    @Override
    public CartPage openPage() {
        driver.navigate().to(CART_URL);
        logger.info("Open cart page.");
        return this;
    }
}
