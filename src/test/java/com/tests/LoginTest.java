package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.main.Utils.DriverFactory;
import com.main.base.*;
import com.main.pages.HomePage;
import com.main.pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

        loginPage.login("standard_user", "secret_sauce");
     // Assertion
        String currentUrl = DriverFactory.getDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory"),
                "Login failed - URL does not contain inventory");
        HomePage homePage = new HomePage(DriverFactory.getDriver());

        String title = homePage.getPageTitle();

        Assert.assertEquals(title, "Products", "Login failed!");
    }
//    @Test
//    public void invalidLoginTest() {
//
//        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
//        loginPage.login("wrong_user", "wrong_pass");
//
//        String currentUrl = DriverFactory.getDriver().getCurrentUrl();
//
//        Assert.assertFalse(currentUrl.contains("inventory"),
//                "Login should not succeed with invalid credentials");
//    }
}