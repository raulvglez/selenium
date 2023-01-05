package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.common.CommonPage;

public class CheckoutCompletePage extends CommonPage {

    private final WebDriver driver;

    @FindBy(id = "back-to-products")
    private WebElement buttonGoBackHome;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goBackHome() {
        buttonGoBackHome.click();
    }
}
