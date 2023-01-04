package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private final WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement inputUsername;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(id = "login-button")
    private WebElement buttonLogin;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sendCredentialsAndLogin (String username, String password) {
        System.out.println("Sending Credentials: Username: '" + username + "' , Password: '" + password + "'");
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        buttonLogin.click();
    }



}
