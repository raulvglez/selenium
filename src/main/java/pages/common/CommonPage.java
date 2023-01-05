package pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CommonPage {

    private final WebDriver driver;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement buttonLeftMenu;

    @FindBy(id = "inventory_sidebar_link")
    private WebElement linkToInventory;

    @FindBy(id = "about_sidebar_link")
    private WebElement linkToAbout;

    @FindBy(id = "logout_sidebar_link")
    private WebElement linkToLogout;

    @FindBy(id = "reset_sidebar_link")
    private WebElement linkToResetAppState;

    @FindBy(id = "react-burger-cross-btn")
    private WebElement buttonCloseLeftMenu;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;

    @FindBy(className = "shopping_cart_badge")
    private WebElement itemsInCart;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openLeftMenu() throws InterruptedException {
        buttonLeftMenu.click();
        Thread.sleep(1000); //When clicking the button to open the left menu it takes a while to load, so sleeping the thread for 1s gives it time to load.
    }

    public void closeLeftMenu() {
        buttonCloseLeftMenu.click();
    }

    public boolean areItemsInCartLoaded() {
        return itemsInCart.isDisplayed();
    }

    public int numberOfItemsInCart() {
        if (areItemsInCartLoaded()) {
            return Integer.parseInt(itemsInCart.getText());
        } else {
            throw new RuntimeException();
        }
    }

    public void goToCart() {
        cartIcon.click();
    }
}
