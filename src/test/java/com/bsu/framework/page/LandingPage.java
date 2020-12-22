package com.bsu.framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractPage {
    private final String BASE_URL = "http://www.ktown4u.com/";

    @FindBy(xpath = "//a[@href=\"/login\"]")
    private WebElement loginButton;

    @FindBy(xpath = "//input[@id=\"goodsTextSearch\"]")
    private WebElement searchField;

    @FindBy(xpath = "//button[@id=\"searchGo\"]")
    private WebElement searchButton;

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void fillSearchField(String itemName) {
        searchField.sendKeys(itemName);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }
}
