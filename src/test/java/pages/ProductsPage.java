package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class ProductsPage {
    private final static String endpoint = "inventory.html";

    private final static By titleLabel = By.xpath("//span[@class='title']");
    private final static String product_addToCart_Button_By = "//div[. = 'replace']/ancestor::div[@class='inventory_item_description']//button";

    public SelenideElement getTitleLabel() { return $(titleLabel);}
    public String getTitleLabelText() { return getTitleLabel().getText(); }
    public WebElement addToCartButtonForProduct(String productName){
        return $(product_addToCart_Button_By.replace("replace", productName));
    }
    public void clickAddToCart(String productName){
        addToCartButtonForProduct(productName).click();
    }
}
