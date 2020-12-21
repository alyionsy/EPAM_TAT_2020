package com.bsu.framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {
    private final String BASE_URL = "http://www.ktown4u.com/";

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

    public void clickLoginSubmitButton() {
        loginSubmitButton.click();
    }

    public String getLogin() {
        return loginField.getText();
    }

    @Override
    public LoginPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }
}
