package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.main.base.BaseTest;
import com.main.pages.LoginPage;
import com.main.pages.ProductPage;

public class ProductTest extends BaseTest {

    @Test
    public void addToCartTest() {

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        // Product Page
        ProductPage productPage = new ProductPage(driver);

        productPage.addFirstProductToCart();
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Validation
        String cartCount = productPage.getCartCount();

        Assert.assertEquals(cartCount, "1", "Product not added to cart!");
    }
}