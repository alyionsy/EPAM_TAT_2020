package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class SearchResultPage {
    private WebDriver driver;

    public SearchResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//span[@class=\"btxt\"]")
    private WebElement itemLink;

    public void itemLinkClick() {
        itemLink.click();
        driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(1));
    }
}
