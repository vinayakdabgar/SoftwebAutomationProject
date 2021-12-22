package com.scharco.WebAppFunctions;

import com.scharco.PageData.UserManagementPageData;
import com.scharco.PageObjects.UserManagement;
import com.scharco.Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class UserManagementFunctions extends BaseClass {

    WebDriver webDriver;

    public UserManagementFunctions(WebDriver remoteDriver) {
        webDriver = remoteDriver;
    }

    public void addUser() throws InterruptedException, IOException {

        LoginPageFunctions loginPageFunctions = new LoginPageFunctions(webDriver);
        UserManagement userManagement = new UserManagement(webDriver);

        loginPageFunctions.loginFunction();
        waitForLoadingIconDisappear();
        userManagement.getUserManagementMenu().click();
        waitForLoadingIconDisappear();
        userManagement.getCreateNewUserButton().click();
        waitForLoadingIconDisappear();

        userManagement.getFirstNameTextBox().click();
        userManagement.getFirstNameTextBox().sendKeys(UserManagementPageData.firstName);

        userManagement.getLastNameTextBox().click();
        userManagement.getLastNameTextBox().sendKeys(UserManagementPageData.lastName);

        userManagement.getEmailTextBox().click();
        userManagement.getEmailTextBox().sendKeys(UserManagementPageData.emailAddress);

        userManagement.getContactTextBox().click();
        userManagement.getContactTextBox().sendKeys(UserManagementPageData.contactNumber);

        userManagement.getClickOnUserRole().click();
        userManagement.selectRole(UserManagementPageData.role);

        Thread.sleep(1000);
        WebElement element = userManagement.getClickOnSubmit();
        JavascriptExecutor executor = (JavascriptExecutor)webDriver;
        executor.executeScript("arguments[0].click();", element);
        waitForLoadingIconDisappear();
    }

    public void deleteUser() throws InterruptedException {
        UserManagement userManagement = new UserManagement(webDriver);

        for (WebElement emailData : userManagement.getAllEmailColumn())
        {
            System.out.println("emails"+emailData.getText());
            if(emailData.getText().contains(UserManagementPageData.emailAddress))
            {
                userManagement.clickOnDeleteButton(UserManagementPageData.emailAddress);
                webDriver.findElement(By.xpath("//span[normalize-space()='OK']")).click();
                Thread.sleep(2000);
                break;
            }
        }
    }
}