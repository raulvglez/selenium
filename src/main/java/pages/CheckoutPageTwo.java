package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.common.CommonPage;

import java.util.List;

public class CheckoutPageTwo extends CommonPage {

    private final WebDriver driver;

    @FindBy(className = "cart_item")
    private List<WebElement> itemsInFinalCheckout;

    @FindBy(id = "cancel")
    private WebElement buttonCancelCheckout;

    @FindBy(id = "finish")
    private WebElement buttonFinishCheckout;

    public CheckoutPageTwo(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickFinishCheckoutButton() {
        buttonFinishCheckout.click();
    }
}
