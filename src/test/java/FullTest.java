import org.checkerframework.checker.units.qual.C;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class FullTest {

    private final String SAUCEDEMO_URL = "https://www.saucedemo.com/";

    private final String STANDARD_USER = "standard_user";

    private final String PROBLEM_USER = "problem_user";

    private final String PERFORMANCE_GLITCH_USER = "performance_glitch_user";

    private final String PASSWORD = "secret_sauce";

    private static WebDriver driver;

    private static LoginPage loginPage;

    private static InventoryPage inventoryPage;

    private static CartPage cartPage;

    private static CheckoutPageOne checkoutPageOne;

    private static CheckoutPageTwo checkoutPageTwo;

    private static CheckoutCompletePage checkoutCompletePage;

    @Test
    public void fullTestStandardUser_shouldPass() {
        fromInventoryToCheckout(STANDARD_USER, PASSWORD, "testFirstName", "testLastName", "00000");
    }

    @Test
    public void fullTestProblemUser_shouldFail() {
        fromInventoryToCheckout(PROBLEM_USER, PASSWORD, "testFirstName", "testLastName", "00000");
    }

    @Test
    public void fullTestPerformanceGlitchUser_shouldPass() {
        fromInventoryToCheckout(PERFORMANCE_GLITCH_USER, PASSWORD, "testFirstName", "testLastName", "00000");
    }





    public void fromInventoryToCheckout(String username, String password, String firstName, String lastName, String postalCode) {
        loginPage.sendCredentialsAndLogin(username, password);
        inventoryPage.getButtonsAddToCart().get(0).click();
        inventoryPage.goToCart();
        cartPage.clickCheckoutButton();
        checkoutPageOne.sendFormDataAndClickContinue(firstName, lastName, postalCode);
        checkoutPageTwo.clickFinishCheckoutButton();
        checkoutCompletePage.goBackHome();
        Assert.assertEquals(SAUCEDEMO_URL + "inventory.html", driver.getCurrentUrl());
    }


    @Before
    public void initializeDriverAndPages() {
        //Initializes the chrome driver and also the Pages, so that all elements in the pages are available to use.
        driver = new ChromeDriver();
        driver.get(SAUCEDEMO_URL);
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutPageOne = new CheckoutPageOne(driver);
        checkoutPageTwo = new CheckoutPageTwo(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
    }

    @After
    public void closeDriver()  {
        driver.close();
        driver.quit();
    }
}
