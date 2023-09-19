package tests;

import baseEntities.BaseTest;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.testng.ScreenShooter;
import core.ReadProperties;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@Listeners({ScreenShooter.class})
public class FirstClass extends BaseTest {

    LoginPage loginPage;
    ProductsPage productsPage;

    @Test
    public void firstSelenideTest(){

        open("/");

        $(By.id("user-name")).sendKeys(ReadProperties.getInstance().getUsername());
        $(By.id("password")).sendKeys(ReadProperties.getInstance().getPassword());
        $(By.id("login-button")).click();

        $(".title").should(exist);
        $(".title").shouldBe(visible);
        $(".title").shouldHave(exactText("Products"));

        $(".product_sort_container")
                .selectOptionByValue("za");

        SelenideElement inventoryList = $(".inventory_list");

        ElementsCollection list = inventoryList.findAll(".inventory_item_name");

        list
                .shouldHave(CollectionCondition.size(6))
                .findBy(text("Sauce Labs Bolt T-Shirt")).click();

        /*$$(".inventory_item_name")
                .shouldHave(CollectionCondition.size(6))
                .findBy(text("Sauce Labs Bolt T-Shirt")).click();

         */
        $(".inventory_details_back_button")
                .should(exist)
                .shouldBe(visible);

        String text = $(".inventory_details_desc").getText();
        System.out.println(text);
    }

    @Test
    public void secondSelenideTest(){
        loginPage = open("/", LoginPage.class);
        loginPage.setInputUsername("standard_user");
        loginPage.setInputPassword("secret_sauce");
        productsPage = loginPage.successLoginButtonClick();

        productsPage.getTitleLabel()
                .should(exist)
                .shouldBe(visible)
                .shouldHave(exactText("Products"));
    }
}
