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
        String menuUserManagement = propertiesRead.readProperties("userManagementMenu");
        String buttonCreateNewUser = propertiesRead.readProperties("createNewUserButton");
        String textBoxFirstName = propertiesRead.readProperties("firstNameUserTextBox");
        String textBoxLastName = propertiesRead.readProperties("lastNameUserTextBox");
        String textBoxEmail = propertiesRead.readProperties("emailTextBox");
        String textBoxContact = propertiesRead.readProperties("contactTextBox");
        String dropdownSelectRole = propertiesRead.readProperties("clickOnUserRole");
        String buttonSubmit = propertiesRead.readProperties("clickOnSubmit");

        String buttonBrowse = propertiesRead.readProperties("browseFile");
        String toastMessage = propertiesRead.readProperties("toastMessage");
        String firstNameValidation = propertiesRead.readProperties("firstNameValidation");
        String lastNameValidation = propertiesRead.readProperties("lastNameValidation");
        String emailValidation = propertiesRead.readProperties("emailValidation");
        String contactValidation = propertiesRead.readProperties("contactValidation");
        String roleValidation = propertiesRead.readProperties("roleValidation");

        loginPageFunctions.loginFunction();
        waitForLoadingIconDisappear();
        webDriver.findElement(By.xpath(menuUserManagement)).click();
        waitForLoadingIconDisappear();
        webDriver.findElement(By.xpath(buttonCreateNewUser)).click();
        waitForLoadingIconDisappear();

        /* Verify validations */

        WebElement submitButton = webDriver.findElement(By.xpath(buttonSubmit));
        testBase.clickJavaScriptExecutor(submitButton);
        String firstNameValidationText = webDriver.findElement(By.xpath(firstNameValidation)).getText();
        Assert.assertEquals(firstNameValidationText,UserManagementPageData.expFirstNameValidation);

        String lastNameValidationText = webDriver.findElement(By.xpath(lastNameValidation)).getText();
        Assert.assertEquals(lastNameValidationText,UserManagementPageData.expLastNameValidation);

        String emailValidationText = webDriver.findElement(By.xpath(emailValidation)).getText();
        Assert.assertEquals(emailValidationText,UserManagementPageData.expEmailAddressValidation);

        String contactValidationText = webDriver.findElement(By.xpath(contactValidation)).getText();
        Assert.assertEquals(contactValidationText,UserManagementPageData.expContactNumberValidation);

        String roleValidationText = webDriver.findElement(By.xpath(roleValidation)).getText();
        Assert.assertEquals(roleValidationText,UserManagementPageData.expSelectRoleValidation);

        webDriver.findElement(By.xpath(textBoxFirstName)).sendKeys(UserManagementPageData.firstName);
        webDriver.findElement(By.xpath(textBoxLastName)).sendKeys(UserManagementPageData.lastName);
        webDriver.findElement(By.xpath(textBoxEmail)).sendKeys(UserManagementPageData.emailAddress);
        webDriver.findElement(By.xpath(textBoxContact)).sendKeys(UserManagementPageData.contactNumber);
        webDriver.findElement(By.xpath(dropdownSelectRole)).click();
        userManagement.selectRole(UserManagementPageData.role);

        webDriver.findElement(By.xpath(buttonBrowse)).click();
        Thread.sleep(2000);
        FileUpload fileUpload = new FileUpload();
        fileUpload.imageUpload("Dummy_Image.jpg");

        Thread.sleep(1000);
        testBase.clickJavaScriptExecutor(submitButton);
        testBase.verifyToastMessage(toastMessage, UserManagementPageData.toastSuccessMessage);
        waitForLoadingIconDisappear();
    }

    public void editUser() throws IOException, InterruptedException {

        UserManagement userManagement = new UserManagement(webDriver);
        String textBoxFirstName = propertiesRead.readProperties("firstNameUserTextBox");
        String textBoxLastName = propertiesRead.readProperties("lastNameUserTextBox");
        String textBoxContact = propertiesRead.readProperties("contactTextBox");
        String dropdownSelectRole = propertiesRead.readProperties("clickOnUserRole");
        String buttonSubmit = propertiesRead.readProperties("clickOnSubmit");
        String toastMessage = propertiesRead.readProperties("toastMessage");

        userManagement.clickOnEditButton(UserManagementPageData.emailAddress);
        waitForLoadingIconDisappear();

        webDriver.findElement(By.xpath(textBoxFirstName)).clear();
        webDriver.findElement(By.xpath(textBoxFirstName)).sendKeys(UserManagementPageData.firstName + "HP");

        webDriver.findElement(By.xpath(textBoxLastName)).clear();
        webDriver.findElement(By.xpath(textBoxLastName)).sendKeys(UserManagementPageData.lastName + "PA");

        webDriver.findElement(By.xpath(textBoxContact)).clear();
        webDriver.findElement(By.xpath(textBoxContact)).sendKeys(UserManagementPageData.contactNumber + "94");

        webDriver.findElement(By.xpath(dropdownSelectRole)).click();
        userManagement.selectRole(UserManagementPageData.updateRole);

        Thread.sleep(1000);
        WebElement element = webDriver.findElement(By.xpath(buttonSubmit));
        testBase.clickJavaScriptExecutor(element);
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