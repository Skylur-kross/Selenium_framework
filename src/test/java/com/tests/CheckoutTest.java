package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.main.Utils.DriverFactory;
import com.main.base.BaseTest;
import com.main.pages.LoginPage;
import com.main.pages.ProductPage;
import com.main.pages.CartPage;
import com.main.pages.CheckoutPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void completeCheckoutFlow() throws InterruptedException {

        // Login
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.login("standard_user", "secret_sauce");

        // Add Product
        ProductPage productPage = new ProductPage(DriverFactory.getDriver());
        productPage.addProductByName("Sauce Labs Backpack");

//        Thread.sleep(2000);

        productPage.clickCart();

        // Cart Page
        CartPage cartPage = new CartPage(DriverFactory.getDriver());
        String item = cartPage.getItemName();

        Assert.assertEquals(item, "Sauce Labs Backpack", "Wrong product in cart!");

        cartPage.clickCheckout();

        // Checkout Page
        CheckoutPage checkoutPage = new CheckoutPage(DriverFactory.getDriver());
        checkoutPage.enterDetails("John", "Doe", "110001");
        checkoutPage.clickContinue();

//        Thread.sleep(3000);
    }
}