import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.*;

public class PageObjectTest {
    private LandingPage landingPage;
    private LoginPage loginPage;
    private SearchResultPage searchResultPage;
    private ItemPage itemPage;
    private CartPage cartPage;
    private WebDriver driver;

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
    }

    @Test
    public void addToCartTest() {
        String url = "http://www.ktown4u.com/";
        landingPage.openPage(url);

        String itemName = "BLACKPINK - 1st FULL ALBUM [THE ALBUM] (Ver.3)";

        landingPage.fillSearchField(itemName);
        landingPage.clickSearchButton();

        searchResultPage.itemLinkClick();

        itemPage.cartButtonClick();

        itemPage.waitForTheNextWebElement(itemPage.getGoToCartButton());
        itemPage.goToCartButtonClick();

        Assert.assertEquals(cartPage.getItemName(), itemName);
    }

    @Test
    public void invalidPasswordTest() {
        String userId = "erionolsen@gmail.com";
        String wrongPassword = "12345mq";

        String url = "http://www.ktown4u.com/";
        landingPage.openPage(url);

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
