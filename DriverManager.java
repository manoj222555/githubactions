package com.pomtesting.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class DriverManager {
    private static AppiumDriver driver;

    public static AppiumDriver getDriver() {
        return driver;
    }

    public static void initializeDriver(String deviceName, String udid, String appPackage, String appActivity) {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName", deviceName);
            capabilities.setCapability("udid", udid);
            capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("appPackage", appPackage);
			capabilities.setCapability("appActivity",  appActivity);
            capabilities.setCapability("automationName", "UiAutomator2");

            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AndroidDriver(url, capabilities);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
