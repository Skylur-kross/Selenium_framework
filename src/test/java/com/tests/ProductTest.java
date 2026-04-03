package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.main.Utils.DriverFactory;
import com.main.base.BaseTest;
import com.main.pages.LoginPage;
import com.main.pages.ProductPage;

public class ProductTest extends BaseTest {

    @Test
    public void addToCartTest() {

        // Login
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.login("standard_user", "secret_sauce");

        // Product Page
        ProductPage productPage = new ProductPage(DriverFactory.getDriver());

        // Add product
        productPage.addProductByName("Sauce Labs Backpack");

        // Validation
        String cartCount = productPage.getCartCount();
        Assert.assertEquals(cartCount, "1", "Product not added to cart!");
    }
}