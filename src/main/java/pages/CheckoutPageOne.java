package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.common.CommonPage;

public class CheckoutPageOne extends CommonPage {

    private final WebDriver driver;

    @FindBy(id = "first-name")
    private WebElement inputFirstName;

    @FindBy(id = "last-name")
    private WebElement inputLastName;

    @FindBy(id = "postal-code")
    private WebElement inputPostalCode;

    @FindBy(id = "cancel")
    private WebElement buttonCancelCheckout;

    @FindBy(id = "continue")
    private WebElement buttonContinueCheckout;

    public CheckoutPageOne(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sendFormDataAndClickContinue(String firstName, String lastName, String postalCode) {
        inputFirstName.sendKeys(firstName);
        inputLastName.sendKeys(lastName);
        inputPostalCode.sendKeys(postalCode);
        buttonContinueCheckout.click();
    }
}
