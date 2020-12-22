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
    private final String BASE_URL = "http://www.ktown4u.com/";

    @FindBy(xpath = "//button[@id=\"cartGo2\"]")
    private WebElement cartButton;

    @FindBy(xpath = "//a[@class=\"modal-btn btn-light-blue\"]")
    private WebElement goToCartButton;

    public ItemPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void cartButtonClick() {
        cartButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(10).getSeconds())
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class=\"modal-btn btn-light-blue\"]")));
    }

    public void goToCartButtonClick() {
        goToCartButton.click();
    }

    public WebElement getGoToCartButton() {
        return goToCartButton;
    }

    public void waitForTheNextWebElement(WebElement nextElement) {
        new WebDriverWait(driver, Duration.ofSeconds(10).getSeconds())
                .until(ExpectedConditions.elementToBeClickable(nextElement));
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }
}
