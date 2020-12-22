package com.bsu.framework.page;

import com.bsu.framework.util.StringHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class SearchResultPage extends AbstractPage {
    private final String BASE_URL = "http://www.ktown4u.com/";

    @FindBy(xpath = "//a[@href=\"javascript:getPageMove('goodsSearch', 'newgoods', null, '');\"]")
    private WebElement sortByNewestButton;

    @FindBy(xpath = "//a[@href=\"javascript:getPageMove('goodsSearch', 'bestgoods', null, '');\"]")
    private WebElement sortByBestSalesButton;

    @FindBy(xpath = "//a[@href=\"javascript:getPageMove('goodsSearch', 'nameasc', null, '');\"]")
    private WebElement sortByNameUpButton;

    @FindBy(xpath = "//a[@href=\"javascript:getPageMove('goodsSearch', 'namedesc', null, '');\"]")
    private WebElement sortByNameDownButton;

    @FindBy(xpath = "//input[@id=\"noneOutOfStock\"]")
    private WebElement outOfStockCheckbox;

    public SearchResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public SearchResultPage sortByNewest() {
        sortByNewestButton.click();
        return this;
    }

    public SearchResultPage sortByBestSales() {
        sortByBestSalesButton.click();
        return this;
    }

    public SearchResultPage sortByNameUp() {
        sortByNameUpButton.click();
        return this;
    }

    public SearchResultPage sortByNameDown() {
        sortByNameDownButton.click();
        return this;
    }

    public SearchResultPage excludeOutOfStockItems() {
        outOfStockCheckbox.click();
        new WebDriverWait(driver, Duration.ofSeconds(10).getSeconds())
                .until(ExpectedConditions.elementToBeClickable(outOfStockCheckbox));
        return this;
    }

    public List<Date> getResultItemsDates() {
        By stuffSelector = By.xpath("//div[@class='item']/descendant::span[@class='stxt'][not(ancestor::a)]");
        return driver.findElements(stuffSelector).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList())
                .stream()
                .map(StringHandler::stringToDateConverter)
                .collect(Collectors.toList());
    }

    public List<Integer> getResultItemsSales() {
        By stuffSelector = By.xpath("//div[@class='item']/descendant::a[@target=\"_blank\"]/descendant::span[@class='stxt' and not(@style=\"display:none;\")]");
        return driver.findElements(stuffSelector).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList())
                .stream()
                .map(StringHandler::stringToIntConverter)
                .collect(Collectors.toList());
    }

    public List<String> getResultItemsNames() {
        By stuffSelector = By.xpath("//span[@class=\"btxt\"]");
        return driver.findElements(stuffSelector).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public boolean anyOutOfStockInItems() {
        By stuffSelector = By.xpath("//span[@class=\"btxt\"]");
        List<String> info = driver.findElements(stuffSelector).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList())
                .stream()
                .filter(itemInfo -> itemInfo.contains("(Out Of Stock)"))
                .collect(Collectors.toList());
        return info.size() > 0;
    }

    @Override
    public SearchResultPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }
}
