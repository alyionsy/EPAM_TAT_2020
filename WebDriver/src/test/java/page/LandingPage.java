package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    private WebDriver driver;

    public LandingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void openPage(String url) {
        driver.get(url);
    }

    @FindBy(xpath = "//a[@href=\"/login\"]")
    private WebElement loginButton;

    @FindBy(xpath = "//input[@id=\"goodsTextSearch\"]")
    private WebElement searchField;

    @FindBy(xpath = "//button[@id=\"searchGo\"]")
    private WebElement searchButton;

    public void clickLoginButton() {
        loginButton.click();
    }

    public void fillSearchField(String itemName) {
        searchField.sendKeys(itemName);
    }

    public void clickSearchButton() {
        searchButton.click();
    }
}
