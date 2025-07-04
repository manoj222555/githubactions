package com.pomtesting.tests;

import com.pomtesting.pages.LoginPage;
import com.pomtesting.utils.DriverManager;
import io.appium.java_client.AppiumDriver;

public class LoginTest {
    public static void main(String[] args) {
        DriverManager.initializeDriver(
        		"Oppo A11k",                              // device name
                "SSBUB65PS44T5H49",                       // udid
                "com.swaglabsmobileapp",                 // appPackage
                "com.swaglabsmobileapp.MainActivity"     // appActivity
        		);
        AppiumDriver driver = DriverManager.getDriver();

        LoginPage loginPage = new LoginPage(driver);

        System.out.println("Running invalid login test...");

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.tapLoginButton();

        // Add validation/assertion if required

//        DriverManager.quitDriver();
        System.out.println("Test completed.");
    }
}
