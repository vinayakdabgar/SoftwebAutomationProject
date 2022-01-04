package com.scharco.WebAppFunctions;

import com.scharco.PageData.LoginPageData;
import com.scharco.Utilities.BaseClass;
import com.scharco.Utilities.PropertiesRead;
import com.scharco.Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class LoginPageFunctions extends BaseClass {

    WebDriver webDriver;
    PropertiesRead propertiesRead = new PropertiesRead();
    TestBase testBase = new TestBase();

    public LoginPageFunctions(WebDriver remoteDriver) {
        webDriver = remoteDriver;
    }

    public void loginFunction() throws IOException {
        String adminUserId = propertiesRead.readProperties("AdminUserId");
        String adminPassword = propertiesRead.readProperties("AdminUserPassword");
        String headerTextLogin = propertiesRead.readProperties("loginHeaderText");
        String textBoxEmailAddress = propertiesRead.readProperties("emailAddressTextBox");
        String textBoxPassword = propertiesRead.readProperties("enterPasswordTextBox");
        String buttonLogin = propertiesRead.readProperties("clickOnLoginButton");
        String toggleDropdown = propertiesRead.readProperties("toggleDropdown");

        String loginText = webDriver.findElement(By.xpath(headerTextLogin)).getText();
        Assert.assertEquals(loginText, LoginPageData.expLoginTitleStr);
        webDriver.findElement(By.xpath(textBoxEmailAddress)).sendKeys(adminUserId);
        webDriver.findElement(By.xpath(textBoxPassword)).sendKeys(adminPassword);
        WebElement element = webDriver.findElement(By.xpath(buttonLogin));
        testBase.clickJavaScriptExecutor(element);
        testBase.expWait(toggleDropdown);
    }

    public void logoutFunctionality() throws IOException {
        String toggleDropdown = propertiesRead.readProperties("toggleDropdown");
        String buttonLogout = propertiesRead.readProperties("signOutButton");

        webDriver.findElement(By.xpath(toggleDropdown)).click();
        webDriver.findElement(By.xpath(buttonLogout)).click();
    }
}