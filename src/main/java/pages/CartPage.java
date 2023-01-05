package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.common.CommonPage;

import java.util.List;

public class CartPage extends CommonPage {

    private final WebDriver driver;

    @FindBy(className = "cart_item")
    private List<WebElement> elementsInCart;

    @FindBy(xpath = "//*[contains(text(), 'Remove')]")
    private List<WebElement> buttonsRemoveFromCart;

    @FindBy(id = "checkout")
    private WebElement buttonCheckout;

    @FindBy(id = "continue-shopping")
    private WebElement buttonContinueShopping;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCheckoutButton() {
        buttonCheckout.click();
    }

    public void clickContinueShoppingButton() {
        buttonContinueShopping.click();
    }

    public void removeAllItemsFromCart() {
        buttonsRemoveFromCart.forEach(WebElement::click);
    }

    public List<WebElement> getAllElementsInCart() {
        return elementsInCart;
    }
}
