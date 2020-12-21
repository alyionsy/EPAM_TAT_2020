package com.bsu.framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends AbstractPage {
    private final String CART_URL = "http://www.ktown4u.com/cart";

    @FindBy(xpath = "//span[@class=\"btxt\"]")
    private WebElement item;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getItemName() {
        return item.getText();
    }

    @Override
    public CartPage openPage() {
        driver.navigate().to(CART_URL);
        return this;
    }
}
