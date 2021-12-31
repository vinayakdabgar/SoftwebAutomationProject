package com.scharco.WebAppFunctions;

import com.scharco.PageData.OTAUpdatesPageData;
import com.scharco.PageData.UserManagementPageData;
import com.scharco.PageObjects.UserManagement;
import com.scharco.Utilities.BaseClass;
import com.scharco.Utilities.FileUpload;
import com.scharco.Utilities.PropertiesRead;
import com.scharco.Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.awt.*;
import java.io.IOException;

import static com.scharco.Utilities.BaseClass.webDriver;

public class UserManagementFunctions extends BaseClass {

    WebDriver webDriver;
    PropertiesRead propertiesRead = new PropertiesRead();
    TestBase testBase = new TestBase();

    public UserManagementFunctions(WebDriver remoteDriver) {
        webDriver = remoteDriver;
    }

    public void addUser() throws InterruptedException, IOException, AWTException {

        LoginPageFunctions loginPageFunctions = new LoginPageFunctions(webDriver);
        UserManagement userManagement = new UserManagement(webDriver);
        String buttonBrowse = propertiesRead.readProperties("browseFile");
        String toastMessage = propertiesRead.readProperties("toastMessage");

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

        webDriver.findElement(By.xpath(buttonBrowse)).click();
        Thread.sleep(2000);
        FileUpload fileUpload = new FileUpload();
        fileUpload.imageUpload("Dummy_Image.jpg");

        Thread.sleep(1000);
        WebElement element = userManagement.getClickOnSubmit();
        JavascriptExecutor executor = (JavascriptExecutor)webDriver;
        executor.executeScript("arguments[0].click();", element);
        testBase.verifyToastMessage(toastMessage, UserManagementPageData.toastSuccessMessage);
        waitForLoadingIconDisappear();
    }

    public void editUser() throws IOException, InterruptedException {

        UserManagement userManagement = new UserManagement(webDriver);
        String toastMessage = propertiesRead.readProperties("toastMessage");

        userManagement.clickOnEditButton(UserManagementPageData.emailAddress);
        waitForLoadingIconDisappear();

        userManagement.getFirstNameTextBox().clear();
        userManagement.getFirstNameTextBox().sendKeys(UserManagementPageData.firstName + "HP");

        userManagement.getLastNameTextBox().clear();
        userManagement.getLastNameTextBox().sendKeys(UserManagementPageData.lastName + "PA");

        userManagement.getContactTextBox().clear();
        userManagement.getContactTextBox().sendKeys(UserManagementPageData.contactNumber + "94");

        userManagement.getClickOnUserRole().click();
        userManagement.selectRole(UserManagementPageData.updateRole);

        Thread.sleep(1000);
        WebElement element = userManagement.getClickOnSubmit();
        JavascriptExecutor executor = (JavascriptExecutor)webDriver;
        executor.executeScript("arguments[0].click();", element);
        testBase.verifyToastMessage(toastMessage, UserManagementPageData.toastUpdateMessage);
        waitForLoadingIconDisappear();
    }

    public void deleteUser() throws InterruptedException, IOException {
        UserManagement userManagement = new UserManagement(webDriver);
        String toastMessage = propertiesRead.readProperties("toastMessage");
        String buttonOkDelete = propertiesRead.readProperties("OkButtonDeletePopup");

        for (WebElement emailData : userManagement.getAllEmailColumn())
        {
            if(emailData.getText().contains(UserManagementPageData.emailAddress))
            {
                userManagement.clickOnDeleteButton(UserManagementPageData.emailAddress);
                webDriver.findElement(By.xpath(buttonOkDelete)).click();
                Thread.sleep(2000);
                break;
            }
        }
        testBase.verifyToastMessage(toastMessage, UserManagementPageData.toastDeleteMessage);
    }
}