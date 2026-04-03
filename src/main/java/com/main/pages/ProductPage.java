package com.main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class ProductPage {

    private WebDriver driver;

    // Constructor
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By cartIcon = By.className("shopping_cart_link");
    private By cartBadge = By.className("shopping_cart_badge");

    // Actions

    // Add specific product by name (dynamic)
    public void addProductByName(String productName) {

        String xpath = "//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();
    }
    // Click cart icon
    public void clickCart() {
        driver.findElement(cartIcon).click();
    }

    // Get cart count
    public String getCartCount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge)).getText();
    }
}