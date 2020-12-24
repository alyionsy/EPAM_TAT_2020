package com.bsu.framework.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
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

    public LandingPage goToLoginPage() {
        loginButton.click();
        return this;
    }

    public LandingPage enterSearchRequest(String itemName) {
        searchField.sendKeys(itemName);
        return this;
    }

    public SearchResultPage search() {
        searchButton.click();
        return new SearchResultPage(driver);
    }

    public LoginPage openLoginPage() {
        return new LoginPage(driver);
    }

    @Override
    public LandingPage openPage() {
        driver.navigate().to(LANDING_URL);
        logger.info("Open landing page.");
        return this;
    }
}
