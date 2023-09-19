package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage{

    private final static By inputUsername = By.id("user-name");
    private final static By inputPassword = By.id("password");
    private final static By loginButton = By.id("login-button");
    private final static By errorLabel = By.tagName("h3");


    private SelenideElement getInputUsername(){ return $(By.id("user-name")); }
    private SelenideElement getInputPassword(){ return $(inputPassword); }
    private SelenideElement getLoginButton(){ return $(loginButton); }
    private SelenideElement getErrorLabel(){ return $(errorLabel); }

    public void setInputUsername(String text){
        getInputUsername().sendKeys(text);
    }

    public void setInputPassword(String text){
        getInputPassword().sendKeys(text);
    }

    public void clickLoginButton(){
        getLoginButton().click();
    }

    public String getTextFromErrorLabel(){ return getErrorLabel().getText(); }

    public ProductsPage successLoginButtonClick(){
        clickLoginButton();
        return new ProductsPage();
    }
}
