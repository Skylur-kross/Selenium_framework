package com.main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator
    By productsTitle = By.className("title");

    // Method
    public String getPageTitle() {
        return driver.findElement(productsTitle).getText();
    }
}