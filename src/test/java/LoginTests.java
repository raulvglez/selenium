import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.common.CommonPage;

public class LoginTests {

    private final String SAUCEDEMO_URL = "https://www.saucedemo.com/";

    private final String STANDARD_USER = "standard_user";

    private final String LOCKED_OUT_USER = "locked_out_user";

    private final String PROBLEM_USER = "problem_user";

    private final String PERFORMANCE_GLITCH_USER = "performance_glitch_user";

    private final String PASSWORD = "secret_sauce";

    private static WebDriver driver;

    private static LoginPage loginPage;

    private static CommonPage commonPage;

    @Test
    public void testLoginStandardUser_shouldPass() {
        testLoginWithCredentials(STANDARD_USER, PASSWORD);
    }

    @Test
    public void testLoginLockedOutUser_shouldFail() {
        testLoginWithCredentials(LOCKED_OUT_USER, PASSWORD);
    }

    @Test
    public void testLoginProblemUser_shouldPass() {
        testLoginWithCredentials(PROBLEM_USER, PASSWORD);
    }

    @Test
    public void testLoginPerformanceGlitchUser_shouldPass() {
        testLoginWithCredentials(PERFORMANCE_GLITCH_USER, PASSWORD);
    }

    public void testLoginWithCredentials(String username, String password) {
        loginPage.sendCredentialsAndLogin(username, password);
        Assert.assertEquals(SAUCEDEMO_URL + "inventory.html", driver.getCurrentUrl());
    }

    @Before
    public void initializeDriverAndPages() {
        //Initializes the chrome driver and also the Pages, so that all elements in the pages are available to use.
        driver = new ChromeDriver();
        driver.get(SAUCEDEMO_URL);
        loginPage = new LoginPage(driver);
        commonPage = new CommonPage(driver);
    }

    @After
    public void closeDriver()  {
        driver.close();
        driver.quit();
    }
}
