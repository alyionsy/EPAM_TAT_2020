import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;

public class WebDriverTest {
    private WebDriver driver;

    @BeforeClass
    public void initialize() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("disable-gpu");
        chromeOptions.addArguments("window-size=1920,1080");

        driver = new ChromeDriver(chromeOptions);

//        driver.manage().window().maximize();
    }

    @Test
    public void addToCartTest() {
        String url = "http://www.ktown4u.com/";
        driver.get(url);

        String itemName = "BLACKPINK - 1st FULL ALBUM [THE ALBUM] (Ver.3)";

        WebElement searchField = driver.findElement(By.xpath("//input[@id=\"goodsTextSearch\"]"));
        searchField.sendKeys(itemName);
        WebElement searchButton = driver.findElement(By.xpath("//button[@id=\"searchGo\"]"));
        searchButton.click();

        WebElement itemLink = driver.findElement(By.xpath("//span[@class=\"btxt\"]"));
        itemLink.click();
        driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(1));

        WebElement cartButton = driver.findElement(By.xpath("//button[@id=\"cartGo2\"]"));
        cartButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(10).getSeconds())
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class=\"modal-btn btn-light-blue\"]")));

        WebElement goToCartButton = driver.findElement(By.xpath("//a[@class=\"modal-btn btn-light-blue\"]"));
        goToCartButton.click();

        String itemInCartName = driver.findElement(By.xpath("//span[@class=\"btxt\"]")).getText();
        Assert.assertEquals(itemInCartName, itemName);
    }

    @AfterClass
    public void quitWebDriver() {
        driver.quit();
    }
}
