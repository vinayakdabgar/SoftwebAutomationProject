package com.scharco.WebAppFunctions;

import com.scharco.PageData.FirmwareManagementPageData;
import com.scharco.PageObjects.FirmwareManagement;
import com.scharco.Utilities.BaseClass;
import com.scharco.Utilities.FileUpload;
import com.scharco.Utilities.PropertiesRead;
import com.scharco.Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class FirmwareManagementFunctions extends BaseClass {

    WebDriver webDriver;
    PropertiesRead propertiesRead = new PropertiesRead();
    TestBase testBase = new TestBase();

    public FirmwareManagementFunctions(WebDriver remoteDriver) {
        webDriver = remoteDriver;
    }

    public void addNewFirmware() throws IOException, InterruptedException, AWTException {
        LoginPageFunctions loginPageFunctions = new LoginPageFunctions(webDriver);
        FirmwareManagement firmwareManagement = new FirmwareManagement(webDriver);
        String menuFirmware = propertiesRead.readProperties("menuFirmwareManagement");
        String addNewFirmware = propertiesRead.readProperties("createNewFirmwareButton");
        String textBoxFirmwareName = propertiesRead.readProperties("firmwareName");
        String dropdownDeviceType = propertiesRead.readProperties("deviceTypeDropdownFirmware");
        String textBoxHardwareVersion = propertiesRead.readProperties("hardwareVersion");
        String textBoxSoftwareVersion = propertiesRead.readProperties("softwareVersion");
        String buttonBrowse = propertiesRead.readProperties("browseFile");
        String textAreaHWDescription = propertiesRead.readProperties("hardwareDescription");
        String textAreaSWDescription = propertiesRead.readProperties("softwareDescription");
        String buttonSubmitFirmware = propertiesRead.readProperties("submitFirmwareButton");
        String toastMessage = propertiesRead.readProperties("toastMessage");

        loginPageFunctions.loginFunction();
        webDriver.findElement(By.xpath(menuFirmware)).click();
        waitForLoadingIconDisappear();
        webDriver.findElement(By.xpath(addNewFirmware)).click();
        waitForLoadingIconDisappear();
        webDriver.findElement(By.xpath(textBoxFirmwareName)).sendKeys(FirmwareManagementPageData.firmwareName);
        webDriver.findElement(By.xpath(dropdownDeviceType)).click();
        firmwareManagement.selectDeviceTypeFromDropdown(FirmwareManagementPageData.deviceType);
        webDriver.findElement(By.xpath(textBoxHardwareVersion)).sendKeys(FirmwareManagementPageData.hardwareVersion);
        webDriver.findElement(By.xpath(textBoxSoftwareVersion)).sendKeys(FirmwareManagementPageData.softwareVersion);

        webDriver.findElement(By.xpath(buttonBrowse)).click();
        Thread.sleep(3000);
        FileUpload fileUpload = new FileUpload();
        fileUpload.imageUpload("FirmwareFile.txt");

        webDriver.findElement(By.xpath(textAreaHWDescription)).sendKeys(FirmwareManagementPageData.hardwareDescription);
        webDriver.findElement(By.xpath(textAreaSWDescription)).sendKeys(FirmwareManagementPageData.softwareDescription);

        webDriver.findElement(By.xpath(buttonSubmitFirmware)).click();
        testBase.expWait(toastMessage);
        String toastFirmwareSuccessMessage = webDriver.findElement(By.xpath(toastMessage)).getText();
        Assert.assertEquals(toastFirmwareSuccessMessage, FirmwareManagementPageData.toastSuccessMessage);
        waitForLoadingIconDisappear();
        releaseSoftwareVersion();
    }

    public void releaseSoftwareVersion() throws IOException, InterruptedException {

        FirmwareManagement firmwareManagement = new FirmwareManagement(webDriver);
        String buttonOkDelete = propertiesRead.readProperties("OkButtonDeletePopup");
        String toastMessage = propertiesRead.readProperties("toastMessage");

        firmwareManagement.clickOnSoftwareUpgradeDraft(FirmwareManagementPageData.firmwareName);
        waitForLoadingIconDisappear();
        firmwareManagement.clickOnReleaseSoftwareVersion(FirmwareManagementPageData.softwareVersion);
        waitForLoadingIconDisappear();
        webDriver.findElement(By.xpath(buttonOkDelete)).click();
        testBase.expWait(toastMessage);
        String toastSuccessSWPublishMessage = webDriver.findElement(By.xpath(toastMessage)).getText();
        Assert.assertEquals(toastSuccessSWPublishMessage,FirmwareManagementPageData.toastSuccessFirmwareSoftwarePublish);
        waitForLoadingIconDisappear();
    }

    public void delFirmware() throws IOException, InterruptedException {

        FirmwareManagement firmwareManagement = new FirmwareManagement(webDriver);
        String listOfFirmware = propertiesRead.readProperties("listOfFirmwareName");
        String buttonOkDelete = propertiesRead.readProperties("OkButtonDeletePopup");
        String toastMessage = propertiesRead.readProperties("toastMessage");

        List<WebElement> listOfFirmwareName = webDriver.findElements(By.cssSelector(listOfFirmware));
        for(WebElement firmware : listOfFirmwareName)
        {
            if(firmware.getText().contains(FirmwareManagementPageData.firmwareName))
            {
                firmwareManagement.clickOnFirmwareDeleteButton(FirmwareManagementPageData.firmwareName);
                webDriver.findElement(By.xpath(buttonOkDelete)).click();
                Thread.sleep(2000);
                break;
            }
        }
        testBase.expWait(toastMessage);
        String toastFirmwareDeleteMessage = webDriver.findElement(By.xpath(toastMessage)).getText();
        Assert.assertEquals(toastFirmwareDeleteMessage,FirmwareManagementPageData.toastDeleteMessage);
    }
}