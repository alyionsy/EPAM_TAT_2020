package com.bsu.framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class SearchResultPage extends AbstractPage {
    private final String BASE_URL = "http://www.ktown4u.com/";

    @FindBy(xpath = "//span[@class=\"btxt\"]")
    private WebElement itemLink;

    public SearchResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void itemLinkClick() {
        itemLink.click();
        driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(1));
    }

    @Override
    public SearchResultPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }
}
