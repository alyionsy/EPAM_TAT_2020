package com.bsu.framework.page;

import com.bsu.framework.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final String LOGIN_URL = "http://www.ktown4u.com/login";

    @FindBy(xpath = "//input[@id=\"user_id\"]")
    private WebElement loginField;

    @FindBy(xpath = "//input[@id=\"user_pw\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id=\"loginSubmit\"]")
    private WebElement loginSubmitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterLogin(String login) {
        loginField.sendKeys(login);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void submitLogin() {
        loginSubmitButton.click();
    }

    public LoginPage login(User user) {
        enterLogin(user.getLogin());
        enterPassword(user.getPassword());
        submitLogin();
        logger.info("Authentication was completed.");
        return this;
    }

    public String getLogin() {
        return loginField.getText();
    }

    public boolean isLoginFieldEmpty() {
        return getLogin().equals("");
    }

    public String getCurrentPageUrl() {
        return driver.getCurrentUrl();
    }

    public String getLoginPageUrl() {
        return LOGIN_URL;
    }

    public CartPage openCartPage() {
        return new CartPage(driver);
    }

    @Override
    public LoginPage openPage() {
        driver.navigate().to(LOGIN_URL);
        logger.info("Open login page.");
        return this;
    }
}
