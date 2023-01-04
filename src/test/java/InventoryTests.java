import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.InventoryPage;
import pages.LoginPage;

public class InventoryTests {

    private final String SAUCEDEMO_URL = "https://www.saucedemo.com/";

    private final String STANDARD_USER = "standard_user";

    private final String LOCKED_OUT_USER = "locked_out_user";

    private final String PROBLEM_USER = "problem_user";

    private final String PERFORMANCE_GLITCH_USER = "performance_glitch_user";

    private final String PASSWORD = "secret_sauce";

    private static WebDriver driver;

    private static LoginPage loginPage;

    private static InventoryPage inventoryPage;

    @Test
    public void addAllItemsToCartStandardUser_shouldPass() {
        loginPage.sendCredentialsAndLogin(STANDARD_USER, PASSWORD);
        inventoryPage.getButtonsAddToCart().forEach(WebElement::click);
        Assert.assertEquals("6", inventoryPage.numberOfItemsInCart());
    }

    @Test
    public void addAllItemsToCartProblemUser_shouldFail() {
        loginPage.sendCredentialsAndLogin(PROBLEM_USER, PASSWORD);
        inventoryPage.getButtonsAddToCart().forEach(WebElement::click);
        Assert.assertEquals("6", inventoryPage.numberOfItemsInCart());
    }

    @Test
    public void addAllItemsToCartPerformanceGlitchUser_shouldPass() {
        loginPage.sendCredentialsAndLogin(PERFORMANCE_GLITCH_USER, PASSWORD);
        inventoryPage.getButtonsAddToCart().forEach(WebElement::click);
        Assert.assertEquals("6", inventoryPage.numberOfItemsInCart());
    }

    @Before
    public void initializeDriverAndPages() {
        //Initializes the chrome driver and also the Pages, so that all elements in the pages are available to use.
        driver = new ChromeDriver();
        driver.get(SAUCEDEMO_URL);
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
    }

    @After
    public void closeDriver()  {
        driver.close();
        driver.quit();
    }
    
    
}
