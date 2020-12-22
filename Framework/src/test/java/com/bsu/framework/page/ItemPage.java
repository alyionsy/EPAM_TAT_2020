package com.bsu.framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ItemPage extends AbstractPage {
    private String itemUrl;

    @FindBy(xpath = "//button[@id=\"cartGo2\"]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//a[@class=\"modal-btn btn-light-blue\"]")
    private WebElement goToCartButton;

    public ItemPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ItemPage(WebDriver driver, String itemUrl) {
        super(driver);
        this.itemUrl = itemUrl;
        PageFactory.initElements(this.driver, this);
    }

    public ItemPage addToCart() {
        addToCartButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(10).getSeconds())
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class=\"modal-btn btn-light-blue\"]")));
        return this;
    }

    public ItemPage goToCart() {
        goToCartButton.click();
        return this;
    }

    public ItemPage waitForTheNextWebElement() {
        new WebDriverWait(driver, Duration.ofSeconds(10).getSeconds())
                .until(ExpectedConditions.elementToBeClickable(goToCartButton));
        return this;
    }

    public CartPage openCartPage(String itemXpath) {
        return new CartPage(driver, itemXpath);
    }

    @Override
    public ItemPage openPage() {
        driver.navigate().to(itemUrl);
        return this;
    }
}
