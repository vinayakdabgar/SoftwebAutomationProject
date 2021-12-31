package com.scharco.WebAppFunctions;

import com.scharco.PageData.CompanyManagementData;
import com.scharco.PageData.NotificationData;
import com.scharco.PageData.RuleManagementData;
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
import com.scharco.Utilities.TestBase;
import com.scharco.Utilities.FileUpload;

import java.io.IOException;
import java.util.List;
import java.awt.*;

public class CompanyManagementFunctions extends BaseClass {

    PropertiesRead propertiesRead = new PropertiesRead();
    TestBase testBase = new TestBase();

    public CompanyManagementFunctions(WebDriver remoteDriver) {
        webDriver = remoteDriver;
    }
    public void addCompany() throws InterruptedException, IOException , AWTException{
        String listOfCountryName = propertiesRead.readProperties("country");
        String listOfMarketName = propertiesRead.readProperties("market");
        String buttonSubmit = propertiesRead.readProperties("clickOnSubmit");
        LoginPageFunctions loginPageFunctions = new LoginPageFunctions(webDriver);
        CompanyManagement companyManagement = new CompanyManagement(webDriver);
        String companyMenu = propertiesRead.readProperties("companyNameMenu");
        String newCompanyButton = propertiesRead.readProperties("createNewCompanyButton");
        String companyName = propertiesRead.readProperties("companyNameTextBox");
        String companyEmail = propertiesRead.readProperties("companyEmailTextBox");
        String firstName = propertiesRead.readProperties("firstNameTextBox");
        String lastName= propertiesRead.readProperties("lastNameTextBox");
        String companyContact= propertiesRead.readProperties("companyContactTextBox");
        String address= propertiesRead.readProperties("addressTextBox");
        String city= propertiesRead.readProperties("cityTextBox");
        String noOfDevices= propertiesRead.readProperties("noOfDevicesTextBox");
        String msgPerMonthPerDevice= propertiesRead.readProperties("msgPerMonthPerDeviceNameTextBox");
        String totalMessage= propertiesRead.readProperties("msgTotalPerMonthTextBox");
        String sageCompanyID= propertiesRead.readProperties("sageIdTextBox");
        String toastMessage = propertiesRead.readProperties("toastMessage");
        String buttonBrowse = propertiesRead.readProperties("browseImageFile");
        String buttonBrowse2 = propertiesRead.readProperties("browseAnyFile");

        loginPageFunctions.loginFunction();
        waitForLoadingIconDisappear();
        webDriver.findElement(By.xpath(companyMenu)).click();
        waitForLoadingIconDisappear();
        webDriver.findElement(By.xpath(newCompanyButton)).click();
        waitForLoadingIconDisappear();

        webDriver.findElement(By.xpath(companyName)).click();
        webDriver.findElement(By.xpath(companyName)).sendKeys(CompanyManagementData.companyName);

        webDriver.findElement(By.xpath(companyEmail)).click();
        webDriver.findElement(By.xpath(companyEmail)).sendKeys(CompanyManagementData.companyEmail);

        webDriver.findElement(By.xpath(firstName)).click();
        webDriver.findElement(By.xpath(firstName)).sendKeys(CompanyManagementData.firstName);

        webDriver.findElement(By.xpath(lastName)).click();
        webDriver.findElement(By.xpath(lastName)).sendKeys(CompanyManagementData.lastName);

        webDriver.findElement(By.xpath(companyContact)).click();
        webDriver.findElement(By.xpath(companyContact)).sendKeys(CompanyManagementData.companyContact);

        webDriver.findElement(By.xpath(address)).click();
        webDriver.findElement(By.xpath(address)).sendKeys(CompanyManagementData.address);

        webDriver.findElement(By.xpath(city)).click();
        webDriver.findElement(By.xpath(city)).sendKeys(CompanyManagementData.city);

        webDriver.findElement(By.xpath(noOfDevices)).click();
        webDriver.findElement(By.xpath(noOfDevices)).sendKeys(CompanyManagementData.noOfDevices);

        webDriver.findElement(By.xpath(msgPerMonthPerDevice)).click();
        webDriver.findElement(By.xpath(msgPerMonthPerDevice)).sendKeys(CompanyManagementData.msgPerMonthPerDevice);

        webDriver.findElement(By.xpath(totalMessage)).click();
        webDriver.findElement(By.xpath(totalMessage)).sendKeys(CompanyManagementData.totalMessage);

        webDriver.findElement(By.xpath(sageCompanyID)).click();
        webDriver.findElement(By.xpath(sageCompanyID)).sendKeys(CompanyManagementData.sageCompanyID);

        companyManagement.getClickOnCountry().click();
        companyManagement.selectCountry(CompanyManagementData.country);

        List<WebElement> listOfCountry = webDriver.findElements(By.cssSelector(listOfCountryName));
        int count = 1;
        for(WebElement countryName : listOfCountry)
        {
            if(countryName.getText().equalsIgnoreCase(CompanyManagementData.country))
            {
                String country1 = countryName.getText();
                Assert.assertEquals(country1, CompanyManagementData.country);
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
        webDriver.findElement(By.xpath(buttonBrowse)).click();
        Thread.sleep(3000);
        FileUpload fileUpload = new FileUpload();
        fileUpload.imageUpload("CompanyLogo.jpg");

//        webDriver.findElement(By.xpath(buttonBrowse2)).click();
//        Thread.sleep(3000);
//        FileUpload fileUpload1 = new FileUpload();
//        fileUpload1.imageUpload("CompanyTxt.txt");

        Thread.sleep(1000);
        webDriver.findElement(By.xpath(buttonSubmit)).click();

        testBase.verifyToastMessage(toastMessage, CompanyManagementData.toastSuccessMessage);
        //testBase.verifyToastMessage(toastMessage, CompanyManagementData.toastFileSuccessMessage);
        waitForLoadingIconDisappear();
}
    public void editCompany() throws InterruptedException, IOException {
        CompanyManagement companyManagement = new CompanyManagement(webDriver);
        String toastMessage = propertiesRead.readProperties("toastMessage");
        for (WebElement emailData : companyManagement.getAllEmailColumn())
        {
            if(emailData.getText().contains(CompanyManagementData.companyEmail))
            {
                companyManagement.clickOnEditButton(CompanyManagementData.companyEmail);
                Thread.sleep(2000);
                break;
            }
        }

            String listOfCountryName = propertiesRead.readProperties("country");
            String listOfMarketName = propertiesRead.readProperties("market");
            String buttonSubmit = propertiesRead.readProperties("clickOnSubmit");
            String companyName = propertiesRead.readProperties("companyNameTextBox");
            String companyContact= propertiesRead.readProperties("companyContactTextBox");
            String address= propertiesRead.readProperties("addressTextBox");
            String city= propertiesRead.readProperties("cityTextBox");
            String noOfDevices= propertiesRead.readProperties("noOfDevicesTextBox");
            String msgPerMonthPerDevice= propertiesRead.readProperties("msgPerMonthPerDeviceNameTextBox");
            String sageCompanyID= propertiesRead.readProperties("sageIdTextBox");

            webDriver.findElement(By.xpath(companyName)).click();
            webDriver.findElement(By.xpath(companyName)).clear();
            webDriver.findElement(By.xpath(companyName)).sendKeys(CompanyManagementData.updateCompanyName);


            webDriver.findElement(By.xpath(companyContact)).click();
            webDriver.findElement(By.xpath(companyContact)).clear();
            webDriver.findElement(By.xpath(companyContact)).sendKeys(CompanyManagementData.updateCompanyContact);

            webDriver.findElement(By.xpath(address)).click();
            webDriver.findElement(By.xpath(address)).clear();
            webDriver.findElement(By.xpath(address)).sendKeys(CompanyManagementData.updateAddress);

            webDriver.findElement(By.xpath(city)).click();
            webDriver.findElement(By.xpath(city)).clear();
            webDriver.findElement(By.xpath(city)).sendKeys(CompanyManagementData.updateCity);

            webDriver.findElement(By.xpath(noOfDevices)).click();
            webDriver.findElement(By.xpath(noOfDevices)).clear();
            webDriver.findElement(By.xpath(noOfDevices)).sendKeys(CompanyManagementData.updateNoOfDevices);

            webDriver.findElement(By.xpath(msgPerMonthPerDevice)).click();
            webDriver.findElement(By.xpath(msgPerMonthPerDevice)).clear();
            webDriver.findElement(By.xpath(msgPerMonthPerDevice)).sendKeys(CompanyManagementData.updateMsgPerMonthPerDevice);


            webDriver.findElement(By.xpath(sageCompanyID)).click();
            webDriver.findElement(By.xpath(sageCompanyID)).clear();
            webDriver.findElement(By.xpath(sageCompanyID)).sendKeys(CompanyManagementData.updateSageCompanyID);


            companyManagement.getClickOnCountry().click();

            companyManagement.selectCountry(CompanyManagementData.updateCountry);

            List<WebElement> listOfCountry = webDriver.findElements(By.cssSelector(listOfCountryName));
            int count = 1;
            for(WebElement countryName : listOfCountry)
            {
                if(countryName.getText().equalsIgnoreCase(CompanyManagementData.updateCountry))
                {
                    String country1 = countryName.getText();
                    Assert.assertEquals(country1, CompanyManagementData.updateCountry);
                    count++;
                } else {
                    System.out.println("Sorry!! Something wrong..");
                }
            }
            Thread.sleep(3000);
            companyManagement.getStateTextBox().click();

            companyManagement.selectStateFromDropdown("Farah");

            companyManagement.getMarketSegmentTextBox().click();

            companyManagement.selectMarketSegment(CompanyManagementData.updateMarketSegment);

            List<WebElement> listOfMarket = webDriver.findElements(By.cssSelector(listOfMarketName));
            int count2 = 1;
            for(WebElement stateName : listOfMarket)
            {
                if(stateName.getText().equalsIgnoreCase(CompanyManagementData.updateMarketSegment))
                {
                    String market = stateName.getText();
                    Assert.assertEquals(market, CompanyManagementData.updateMarketSegment);
                    count2++;
                } else {
                    System.out.println("Sorry!! Something wrong..");
                }
            }

            Thread.sleep(1000);
            webDriver.findElement(By.xpath(buttonSubmit)).click();

        testBase.verifyToastMessage(toastMessage, CompanyManagementData.toastEditMessage);
        waitForLoadingIconDisappear();
    }

    public void deleteCompany() throws InterruptedException, IOException {
        CompanyManagement companyManagement = new CompanyManagement(webDriver);
        String toastMessage = propertiesRead.readProperties("toastMessage");
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
        testBase.verifyToastMessage(toastMessage, CompanyManagementData.toastDeleteMessage);
        waitForLoadingIconDisappear();
    }
}
