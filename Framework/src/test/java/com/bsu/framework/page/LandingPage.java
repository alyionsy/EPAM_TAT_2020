package com.bsu.framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractPage {
    private final String LANDING_URL = "http://www.ktown4u.com/";

    @FindBy(xpath = "//a[@href=\"/login\"]")
    private WebElement loginButton;

    @FindBy(xpath = "//input[@id=\"goodsTextSearch\"]")
    private WebElement searchField;

    @FindBy(xpath = "//button[@id=\"searchGo\"]")
    private WebElement searchButton;

    public LandingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LandingPage clickLoginButton() {
        loginButton.click();
        return this;
    }

    public void fillSearchField(String itemName) {
        searchField.sendKeys(itemName);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public LoginPage openLoginPage() {
        return new LoginPage(driver);
    }

    @Override
    public LandingPage openPage() {
        driver.navigate().to(LANDING_URL);
        return this;
    }
}
