package com.pomtesting.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private AppiumDriver driver;

    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
    }
    
    public WebElement usernameField() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(
            MobileBy.AccessibilityId("test-Username")
        ));
    }
    
    public WebElement userpasswordField() {
    	return driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]"));
    }


    private WebElement loginButton() {
        return driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]"));
    }

    public void enterUsername(String username) {
        usernameField().click();
        usernameField().sendKeys(username);
    }
    
    public void enterPassword(String password) {
    	userpasswordField().click();
    	userpasswordField().sendKeys(password);
    }

    public void tapLoginButton() {
        loginButton().click();
    }
}

