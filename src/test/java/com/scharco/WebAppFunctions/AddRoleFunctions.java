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
        String roleNameValidation = propertiesRead.readProperties("roleNameValidation");
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

        /* Role Validation */
        webDriver.findElement(By.xpath(buttonSubmit)).click();
        String roleNameValidationText = webDriver.findElement(By.xpath(roleNameValidation)).getText();
        Assert.assertEquals(roleNameValidationText,RoleManagementData.expRoleNameValidation);
        testBase.verifyToastMessage(toastMessage,RoleManagementData.expPermissionValidation);
        Thread.sleep(3000);

        webDriver.findElement(By.xpath(textBoxRoleName)).sendKeys(RoleManagementData.roleName);
        webDriver.findElement(By.xpath(textBoxRoleDescription)).sendKeys(RoleManagementData.roleDescription);
        webDriver.findElement(By.xpath(selectAllCheckBox)).click();
        webDriver.findElement(By.xpath(buttonSubmit)).click();
        testBase.verifyToastMessage(toastMessage,RoleManagementData.toastSuccessMessage);
        waitForLoadingIconDisappear();
    }

    public void editRole() throws IOException, InterruptedException {

        RoleManagement roleManagement = new RoleManagement(webDriver);
        String textBoxRoleName = propertiesRead.readProperties("roleName");
        String textBoxRoleDescription = propertiesRead.readProperties("roleDescription");
        String selectAllCheckBox = propertiesRead.readProperties("selectAllCheckBox");
        String buttonSubmit = propertiesRead.readProperties("submitButton");
        String toastMessage = propertiesRead.readProperties("toastMessage");

        roleManagement.clickOnRoleEditButton(RoleManagementData.roleName);
        waitForLoadingIconDisappear();

        webDriver.findElement(By.xpath(textBoxRoleName)).clear();
        webDriver.findElement(By.xpath(textBoxRoleName)).sendKeys(RoleManagementData.roleName + "Update");

        webDriver.findElement(By.xpath(textBoxRoleDescription)).clear();
        webDriver.findElement(By.xpath(textBoxRoleDescription)).sendKeys(RoleManagementData.roleDescription + "Update");

        webDriver.findElement(By.xpath(selectAllCheckBox)).click();
        roleManagement.selectPermissionCheckBox("Company Management","View");
        Thread.sleep(1000);
        roleManagement.selectPermissionCheckBox("Company Management","Manage");

        webDriver.findElement(By.xpath(buttonSubmit)).click();
        testBase.verifyToastMessage(toastMessage,RoleManagementData.toastUpdateMessage);
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
            if(roles.getText().contains(RoleManagementData.roleName + "Update"))
            {
                roleManagement.clickOnRoleDeleteButton(RoleManagementData.roleName + "Update");
                webDriver.findElement(By.xpath(buttonOkDelete)).click();
                Thread.sleep(2000);
                break;
            }
        }
        testBase.verifyToastMessage(toastMessage,RoleManagementData.toastDeleteMessage);
    }
}