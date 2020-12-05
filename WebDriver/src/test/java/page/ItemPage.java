package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ItemPage {
    private WebDriver driver;

    public ItemPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//button[@id=\"cartGo2\"]")
    private WebElement cartButton;

    @FindBy(xpath = "//a[@class=\"modal-btn btn-light-blue\"]")
    private WebElement goToCartButton;

    public void cartButtonClick() {
        cartButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(10).getSeconds())
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class=\"modal-btn btn-light-blue\"]")));
    }

    public void goToCartButtonClick() {
        goToCartButton.click();
    }

    public WebElement getGoToCartButton() {
        return goToCartButton;
    }

    public void waitForTheNextWebElement(WebElement nextElement) {
        new WebDriverWait(driver, Duration.ofSeconds(10).getSeconds())
                .until(ExpectedConditions.elementToBeClickable(nextElement));
    }
}
