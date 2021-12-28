package com.scharco.WebAppFunctions;

import com.scharco.PageData.CompanyManagementData;
import com.scharco.PageData.NotificationData;
import com.scharco.PageData.UserManagementPageData;
import com.scharco.PageObjects.CompanyManagement;
import com.scharco.PageObjects.UserManagement;
import com.scharco.Utilities.BaseClass;
import com.scharco.Utilities.PropertiesRead;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class CompanyManagementFunctions extends BaseClass {

    PropertiesRead propertiesRead = new PropertiesRead();

    public CompanyManagementFunctions(WebDriver remoteDriver) {
        webDriver = remoteDriver;
    }
    public void addCompany() throws InterruptedException, IOException {
        String listOfCountryName = propertiesRead.readProperties("country");

        String listOfMarketName = propertiesRead.readProperties("market");
        String buttonSubmit = propertiesRead.readProperties("submitButton");
        LoginPageFunctions loginPageFunctions = new LoginPageFunctions(webDriver);
        CompanyManagement companyManagement = new CompanyManagement(webDriver);

        loginPageFunctions.loginFunction();
        waitForLoadingIconDisappear();
        companyManagement.getCompanyNameMenu().click();
        waitForLoadingIconDisappear();
        companyManagement.getCreateNewCompanyButton().click();
        waitForLoadingIconDisappear();

        companyManagement.getCompanyNameTextBox().click();
        companyManagement.getCompanyNameTextBox().sendKeys(CompanyManagementData.companyName);

        companyManagement.getCompanyEmailTextBox().click();
        companyManagement.getCompanyEmailTextBox().sendKeys(CompanyManagementData.companyEmail);

        companyManagement.getFirstNameTextBox().click();
        companyManagement.getFirstNameTextBox().sendKeys(CompanyManagementData.firstName);

        companyManagement.getLastNameTextBox().click();
        companyManagement.getLastNameTextBox().sendKeys(CompanyManagementData.lastName);

        companyManagement.getCompanyContactTextBox().click();
        companyManagement.getCompanyContactTextBox().sendKeys(CompanyManagementData.companyContact);

        companyManagement.getAddressTextBox().click();
        companyManagement.getAddressTextBox().sendKeys(CompanyManagementData.address);

        companyManagement.getCityTextBox().click();
        companyManagement.getCityTextBox().sendKeys(CompanyManagementData.city);

        companyManagement.getNoOfDevicesTextBox().click();
        companyManagement.getNoOfDevicesTextBox().sendKeys(CompanyManagementData.noOfDevices);

        companyManagement.getMsgPerMonthPerDeviceNameTextBox().click();
        companyManagement.getMsgPerMonthPerDeviceNameTextBox().sendKeys(CompanyManagementData.msgPerMonthPerDevice);

        companyManagement.getMsgTotalPerMonthTextBox().click();
        companyManagement.getMsgTotalPerMonthTextBox().sendKeys(CompanyManagementData.totalMessage);

        companyManagement.getSageIdTextBox().click();
        companyManagement.getSageIdTextBox().sendKeys(CompanyManagementData.sageCompanyID);

        companyManagement.getClickOnCountry().click();
        companyManagement.selectCountry(CompanyManagementData.country);

        List<WebElement> listOfCountry = webDriver.findElements(By.cssSelector(listOfCountryName));
        int count = 1;
        for(WebElement countryName : listOfCountry)
        {
            if(countryName.getText().equalsIgnoreCase(CompanyManagementData.country))
            {
                String country = countryName.getText();
                Assert.assertEquals(country, CompanyManagementData.country);
                count++;
            } else {
                System.out.println("Sorry!! Something wrong..");
            }
        }
        Thread.sleep(3000);
        companyManagement.getStateTextBox().click();
        companyManagement.selectStateFromDropdown("Gujarat");

        companyManagement.getMarketSegmentTextBox().click();
        companyManagement.selectMarketSegment(CompanyManagementData.marketSegment);

        List<WebElement> listOfMarket = webDriver.findElements(By.cssSelector(listOfMarketName));
        int count2 = 1;
        for(WebElement stateName : listOfMarket)
        {
            if(stateName.getText().equalsIgnoreCase(CompanyManagementData.marketSegment))
            {
                String market = stateName.getText();
                Assert.assertEquals(market, CompanyManagementData.marketSegment);
                count2++;
            } else {
                System.out.println("Sorry!! Something wrong..");
            }
        }

        Thread.sleep(1000);
        webDriver.findElement(By.xpath(buttonSubmit)).click();
        waitForLoadingIconDisappear();
}
    public void deleteCompany() throws InterruptedException, IOException {
        CompanyManagement companyManagement = new CompanyManagement(webDriver);
        String buttonOkDelete = propertiesRead.readProperties("OkButtonDeletePopup");

        for (WebElement emailData : companyManagement.getAllEmailColumn())
        {
            if(emailData.getText().contains(CompanyManagementData.companyEmail))
            {
                companyManagement.clickOnDeleteButton(CompanyManagementData.companyEmail);
                webDriver.findElement(By.xpath(buttonOkDelete)).click();
                Thread.sleep(2000);
                break;
            }
        }
    }
}
