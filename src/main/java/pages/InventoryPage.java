package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.common.CommonPage;

import java.util.List;

public class InventoryPage extends CommonPage {

    private WebDriver driver;

    @FindBy(id = "inventory_item_name")
    private List<WebElement> itemNames;

    @FindBy(xpath = "//*[contains(text(), 'Add to cart')]")
    private List<WebElement> buttonsAddToCart;

    @FindBy(xpath = "//*[contains(text(), 'Remove')]")
    private List<WebElement> buttonsRemoveFromCart;

    @FindBy(className = "inventory_item")
    private List<WebElement> allItemsInInventory;

    public InventoryPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getButtonsAddToCart() {
        return buttonsAddToCart;
    }

    public List<WebElement> getAllItemsInInventory() {
        return allItemsInInventory;
    }

    public List<WebElement> getButtonsRemoveFromCart() {
        return buttonsRemoveFromCart;
    }
}
