import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.*;

import java.time.Duration;

public class WebDriverTest {
    public LandingPage landingPage;
    public LoginPage loginPage;
    public SearchResultPage searchResultPage;
    public ItemPage itemPage;
    public CartPage cartPage;
    public WebDriver driver;

    @BeforeClass
    public void initialize() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("disable-gpu");
        chromeOptions.addArguments("window-size=1920,1080");

        driver = new ChromeDriver(chromeOptions);

        landingPage = new LandingPage(driver);
        loginPage = new LoginPage(driver);
        searchResultPage = new SearchResultPage(driver);
        itemPage = new ItemPage(driver);
        cartPage = new CartPage(driver);

        driver.manage().window().maximize();
    }

    @Test
    public void addToCartTest() {
        driver.get("http://www.ktown4u.com/");

        landingPage.fillSearchField("BLACKPINK - 1st FULL ALBUM [THE ALBUM] (Ver.3)");
        landingPage.clickSearchButton();

        searchResultPage.itemLinkClick();

        itemPage.cartButtonClick();
        new WebDriverWait(driver, Duration.ofSeconds(10).getSeconds())
                .until(ExpectedConditions.elementToBeClickable(itemPage.getGoToCartButton()));
        itemPage.goToCartButtonClick();

        Assert.assertEquals(cartPage.getItemName(), "BLACKPINK - 1st FULL ALBUM [THE ALBUM] (Ver.3)");
    }

    @Test
    public void invalidPasswordTest() {
        String userId = "erionolsen@gmail.com";
        String wrongPassword = "12345mq";
        driver.get("http://www.ktown4u.com/");

        landingPage.clickLoginButton();
        loginPage.enterLogin(userId);
        loginPage.enterPassword(wrongPassword);
        loginPage.clickLoginSubmitButton();

        Assert.assertEquals("", loginPage.getLogin());
    }

    @AfterClass
    public void quitWebDriver() {
        driver.quit();
    }
}
