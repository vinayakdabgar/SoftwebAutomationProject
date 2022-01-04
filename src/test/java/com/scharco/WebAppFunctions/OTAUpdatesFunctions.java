package com.scharco.WebAppFunctions;

import com.scharco.PageData.FirmwareManagementPageData;
import com.scharco.PageData.OTAUpdatesPageData;
import com.scharco.PageObjects.OTAUpdates;
import com.scharco.Utilities.BaseClass;
import com.scharco.Utilities.PropertiesRead;
import com.scharco.Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class OTAUpdatesFunctions extends BaseClass {

    WebDriver webDriver;
    PropertiesRead propertiesRead = new PropertiesRead();
    TestBase testBase = new TestBase();

    public OTAUpdatesFunctions(WebDriver remoteDriver) {
        webDriver = remoteDriver;
    }

    public void addOTAUpdates() throws IOException, InterruptedException {

        OTAUpdates otaUpdates = new OTAUpdates(webDriver);
        String menuOTAUpdates = propertiesRead.readProperties("menuOTAUpdates");
        String dropdownHardwareVersion = propertiesRead.readProperties("selectHardwareVersion");
        String dropdownSoftwareVersion = propertiesRead.readProperties("selectSoftwareVersion");
        String iconScheduleOTACalender = propertiesRead.readProperties("calenderScheduleOTA");
        String tomorrowDateSelect = propertiesRead.readProperties("selectTomorrowDate");
        String dropdownSelectTarget = propertiesRead.readProperties("selectTarget");
        String dropdownSelectDevice = propertiesRead.readProperties("selectDevice");
        String buttonSubmitOTA = propertiesRead.readProperties("submitButtonOTAUpdate");
        String menuFirmware = propertiesRead.readProperties("menuFirmwareManagement");
        String toastMessage = propertiesRead.readProperties("toastMessage");

        String otaHardwareVersionValidation = propertiesRead.readProperties("otaHardwareVersionValidation");
        String otaSoftwareVersionValidation = propertiesRead.readProperties("otaSoftwareVersionValidation");
        String otaDeviceTypeValidation = propertiesRead.readProperties("otaDeviceTypeValidation");
        String otaScheduleOTAValidation = propertiesRead.readProperties("otaScheduleOTAValidation");
        String otaTargetValidation = propertiesRead.readProperties("otaTargetValidation");
        String otaSelectCompanyDropdownValidation = propertiesRead.readProperties("otaSelectCompanyDropdownValidation");
        String otaSelectDeviceDropdownValidation = propertiesRead.readProperties("otaSelectDeviceDropdownValidation");

        webDriver.findElement(By.xpath(menuOTAUpdates)).click();
        waitForLoadingIconDisappear();

        /* Validation Data */
        WebElement element = webDriver.findElement(By.xpath(buttonSubmitOTA));
        testBase.clickJavaScriptExecutor(element);

        String otaHardwareVersionValidationText = webDriver.findElement(By.xpath(otaHardwareVersionValidation)).getText();
        Assert.assertEquals(otaHardwareVersionValidationText,OTAUpdatesPageData.expHardwareVersionValidation);

        String otaSoftwareVersionValidationText = webDriver.findElement(By.xpath(otaSoftwareVersionValidation)).getText();
        Assert.assertEquals(otaSoftwareVersionValidationText,OTAUpdatesPageData.expSoftwareVersionValidation);

        String otaDeviceTypeValidationText = webDriver.findElement(By.xpath(otaDeviceTypeValidation)).getText();
        Assert.assertEquals(otaDeviceTypeValidationText,OTAUpdatesPageData.expDeviceTypeValidation);

        String otaScheduleOTAValidationText = webDriver.findElement(By.xpath(otaScheduleOTAValidation)).getText();
        Assert.assertEquals(otaScheduleOTAValidationText,OTAUpdatesPageData.expScheduleOTADateValidation);

        String otaTargetValidationText = webDriver.findElement(By.xpath(otaTargetValidation)).getText();
        Assert.assertEquals(otaTargetValidationText,OTAUpdatesPageData.expTargetNameValidation);

        webDriver.findElement(By.xpath(dropdownSelectTarget)).click();
        Thread.sleep(1000);
        otaUpdates.selectValueFromTargetDropdown(OTAUpdatesPageData.targetDevice);

        String otaSelectDeviceDropdownValidationText = webDriver.findElement(By.xpath(otaSelectDeviceDropdownValidation)).getText();
        Assert.assertEquals(otaSelectDeviceDropdownValidationText,OTAUpdatesPageData.expDeviceNameValidation);

        webDriver.findElement(By.xpath(dropdownSelectTarget)).click();
        Thread.sleep(1000);
        otaUpdates.selectValueFromTargetDropdown(OTAUpdatesPageData.targetCompany);

        String otaSelectCompanyDropdownValidationText = webDriver.findElement(By.xpath(otaSelectCompanyDropdownValidation)).getText();
        Assert.assertEquals(otaSelectCompanyDropdownValidationText,OTAUpdatesPageData.expCompanyNameValidation);

        webDriver.findElement(By.xpath(dropdownHardwareVersion)).click();
        otaUpdates.selectValueFromDropdown(FirmwareManagementPageData.firmwareName);
        Thread.sleep(2000);
        webDriver.findElement(By.xpath(dropdownSoftwareVersion)).click();
        otaUpdates.selectValueFromDropdown(FirmwareManagementPageData.softwareVersion);

        webDriver.findElement(By.xpath(iconScheduleOTACalender)).click();
        webDriver.findElement(By.xpath(tomorrowDateSelect)).click();

        webDriver.findElement(By.xpath(dropdownSelectTarget)).click();
        Thread.sleep(1000);
        otaUpdates.selectValueFromTargetDropdown(OTAUpdatesPageData.targetDevice);

        Thread.sleep(1000);
        webDriver.findElement(By.xpath(dropdownSelectDevice)).click();
        otaUpdates.selectValueFromDropdown(OTAUpdatesPageData.deviceName);

        waitForLoadingIconDisappear();
        testBase.clickJavaScriptExecutor(element);
        testBase.verifyToastMessage(toastMessage,OTAUpdatesPageData.toastSuccessMessage);
        waitForLoadingIconDisappear();
        webDriver.findElement(By.xpath(menuFirmware)).click();
        waitForLoadingIconDisappear();
    }
}
