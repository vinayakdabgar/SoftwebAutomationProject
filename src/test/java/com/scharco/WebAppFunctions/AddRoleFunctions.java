package com.scharco.WebAppFunctions;

import com.scharco.PageData.RoleManagementData;
import com.scharco.PageData.UserManagementPageData;
import com.scharco.PageObjects.RoleManagement;
import com.scharco.Utilities.BaseClass;
import com.scharco.Utilities.PropertiesRead;
import com.scharco.Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class AddRoleFunctions extends BaseClass {

    WebDriver webDriver;
    PropertiesRead propertiesRead = new PropertiesRead();
    TestBase testBase = new TestBase();

    public AddRoleFunctions(WebDriver remoteDriver) {
        webDriver = remoteDriver;
    }

    public void createNewRuleWithAllPermission() throws IOException, InterruptedException {

        LoginPageFunctions loginPageFunctions = new LoginPageFunctions(webDriver);
        String menuRoleManagement = propertiesRead.readProperties("menuRoleManagement");
        String buttonCreateNewRole = propertiesRead.readProperties("createNewRole");
        String textBoxRoleName = propertiesRead.readProperties("roleName");
        String textBoxRoleDescription = propertiesRead.readProperties("roleDescription");
        String selectAllCheckBox = propertiesRead.readProperties("selectAllCheckBox");
        String buttonSubmit = propertiesRead.readProperties("submitButton");
        String toastMessage = propertiesRead.readProperties("toastMessage");

        loginPageFunctions.loginFunction();
        waitForLoadingIconDisappear();
        webDriver.findElement(By.xpath(menuRoleManagement)).click();
        waitForLoadingIconDisappear();
        webDriver.findElement(By.xpath(buttonCreateNewRole)).click();
        waitForLoadingIconDisappear();
        webDriver.findElement(By.xpath(textBoxRoleName)).sendKeys(RoleManagementData.roleName);
        webDriver.findElement(By.xpath(textBoxRoleDescription)).sendKeys(RoleManagementData.roleDescription);
        webDriver.findElement(By.xpath(selectAllCheckBox)).click();
        webDriver.findElement(By.xpath(buttonSubmit)).click();
        testBase.expWait(toastMessage);
        String toastSuccessMessage = webDriver.findElement(By.xpath(toastMessage)).getText();
        System.out.println("toastSuccessMessage :"+toastSuccessMessage);
        Assert.assertEquals(toastSuccessMessage, RoleManagementData.toastSuccessMessage);
        waitForLoadingIconDisappear();
    }

    public void deleteRole() throws IOException, InterruptedException {

        RoleManagement roleManagement = new RoleManagement(webDriver);
        String toastMessage = propertiesRead.readProperties("toastMessage");
        String rolesName = propertiesRead.readProperties("listOfRoleName");
        String buttonOkDelete = propertiesRead.readProperties("OkButtonDeletePopup");

        List<WebElement> listOfRoles = webDriver.findElements(By.cssSelector(rolesName));
        for(WebElement roles : listOfRoles)
        {
            System.out.println("roles"+roles.getText());
            if(roles.getText().contains(RoleManagementData.roleName))
            {
                roleManagement.clickOnRoleDeleteButton(RoleManagementData.roleName);
                webDriver.findElement(By.xpath(buttonOkDelete)).click();
                Thread.sleep(2000);
                break;
            }
        }
        testBase.expWait(toastMessage);
        String toastDeleteMessage = webDriver.findElement(By.xpath(toastMessage)).getText();
        Assert.assertEquals(toastDeleteMessage,RoleManagementData.toastDeleteMessage);
    }
}