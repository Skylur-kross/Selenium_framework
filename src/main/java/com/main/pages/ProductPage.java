package com.main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By firstProductAddToCart = By.id("add-to-cart-sauce-labs-backpack");
    By cartIcon = By.className("shopping_cart_link");
    By cartBadge = By.className("shopping_cart_badge");

    // Actions
    public void addFirstProductToCart() {
        driver.findElement(firstProductAddToCart).click();
    }

    public void clickCart() {
        driver.findElement(cartIcon).click();
    }

    public String getCartCount() {
        return driver.findElement(cartBadge).getText();
    }
}