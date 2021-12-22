package com.scharco.WebAppFunctions;

import com.scharco.PageData.RoleManagementData;
import com.scharco.PageObjects.RoleManagement;
import com.scharco.Utilities.BaseClass;
import com.scharco.Utilities.PropertiesRead;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class AddRoleFunctions extends BaseClass {

    WebDriver webDriver;
    PropertiesRead propertiesRead = new PropertiesRead();

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
        waitForLoadingIconDisappear();
    }

    public void deleteRole() throws IOException, InterruptedException {

        RoleManagement roleManagement = new RoleManagement(webDriver);
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
    }
}