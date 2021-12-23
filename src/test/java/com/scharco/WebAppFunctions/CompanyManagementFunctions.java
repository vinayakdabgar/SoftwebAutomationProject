package com.scharco.WebAppFunctions;

import com.scharco.PageData.CompanyManagementData;
import com.scharco.PageObjects.CompanyManagement;
import com.scharco.Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class CompanyManagementFunctions extends BaseClass {

    public CompanyManagementFunctions(WebDriver remoteDriver) {
        webDriver = remoteDriver;
    }
    public void addCompany() throws InterruptedException, IOException {

        LoginPageFunctions loginPageFunctions = new LoginPageFunctions(webDriver);
        CompanyManagement companyManagement = new CompanyManagement(webDriver);

        loginPageFunctions.loginFunction();
        waitForLoadingIconDisappear();

}
}
