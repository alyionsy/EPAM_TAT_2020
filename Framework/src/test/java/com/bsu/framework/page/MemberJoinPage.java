package com.bsu.framework.page;

import com.bsu.framework.model.AccountInfo;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MemberJoinPage extends AbstractPage {
    private final String MEMBER_JOIN_URL = "http://www.ktown4u.com/memberjoin";

    @FindBy(xpath = "//select[@id=\"NATI_NO\"]")
    private WebElement selectNationButton;

    @FindBy(xpath = "//input[@id=\"USER_NM\"]")
    private WebElement userNameField;

    @FindBy(xpath = "//input[@id=\"EMAIL\"]")
    private WebElement userEmailField;

    @FindBy(xpath = "//input[@id=\"PASSWD\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id=\"user_pw_chk\"]")
    private WebElement passwordCheckField;

    @FindBy(xpath = "//input[@name=\"agreechk\"]")
    private WebElement agreementCheckbox;

    @FindBy(xpath = "//input[@id=\"memberJoin\"]")
    private WebElement createAccountButton;

    public MemberJoinPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MemberJoinPage createNewAccount(AccountInfo info) {
        Select selectNation = new Select(selectNationButton);
        selectNation.selectByVisibleText(info.getNation());
        userNameField.sendKeys(info.getName());
        userEmailField.sendKeys(info.getEmail());
        passwordField.sendKeys(info.getPassword());
        passwordCheckField.sendKeys(info.getPassword());
        agreementCheckbox.click();
        createAccountButton.click();

        Alert alertOK = driver.switchTo().alert();
        alertOK.accept();

        return this;
    }

    public boolean isPasswordFieldActive() {
        return passwordField.equals(driver.switchTo().activeElement());
    }

    @Override
    public MemberJoinPage openPage() {
        driver.navigate().to(MEMBER_JOIN_URL);
        return this;
    }
}
