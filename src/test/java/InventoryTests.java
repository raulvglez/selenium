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

    private final String PROBLEM_USER = "problem_user";

    private final String PERFORMANCE_GLITCH_USER = "performance_glitch_user";

    private final String PASSWORD = "secret_sauce";

    private static WebDriver driver;

    private static LoginPage loginPage;

    private static InventoryPage inventoryPage;

    @Test
    public void addAllItemsToCartStandardUser_shouldPass() {
        addingAllItemsToCartAndCheckingSizeByUser(STANDARD_USER, PASSWORD);
    }

    @Test
    public void addAllItemsToCartProblemUser_shouldFail() {
        //One of the problems the Problem User has is not being able to add all items to cart, so this test will fail.
        addingAllItemsToCartAndCheckingSizeByUser(PROBLEM_USER, PASSWORD);
    }

    @Test
    public void addAllItemsToCartPerformanceGlitchUser_shouldPass() {
        addingAllItemsToCartAndCheckingSizeByUser(PERFORMANCE_GLITCH_USER, PASSWORD);
    }

    @Test
    public void addAllItemsToCartThenRemoveStandardUser_shouldPass() {
        addingAllItemsToCartAndRemovingThem(STANDARD_USER, PASSWORD);
    }

    @Test
    public void addAllItemsToCartThenRemoveProblemUser_shouldFail() {
        addingAllItemsToCartAndRemovingThem(PROBLEM_USER, PASSWORD);
    }

    @Test
    public void addAllItemsToCartThenRemovePerformanceGlitchUser_shouldPass() {
        addingAllItemsToCartAndRemovingThem(PERFORMANCE_GLITCH_USER, PASSWORD);
    }


    public void addingAllItemsToCartAndRemovingThem(String username, String password) {
        loginPage.sendCredentialsAndLogin(username, password);
        inventoryPage.getButtonsAddToCart().forEach(WebElement::click);
        inventoryPage.getButtonsRemoveFromCart().forEach(WebElement::click);
        Assert.assertEquals(inventoryPage.getAllItemsInInventory().size(), inventoryPage.getButtonsAddToCart().size());
    }

    public void addingAllItemsToCartAndCheckingSizeByUser(String username, String password) {
        loginPage.sendCredentialsAndLogin(username, password);
        inventoryPage.getButtonsAddToCart().forEach(WebElement::click);
        Assert.assertEquals(inventoryPage.getAllItemsInInventory().size(), inventoryPage.numberOfItemsInCart());
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
