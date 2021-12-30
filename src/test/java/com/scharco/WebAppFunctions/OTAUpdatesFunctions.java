package com.scharco.WebAppFunctions;

import com.scharco.PageData.FirmwareManagementPageData;
import com.scharco.PageData.OTAUpdatesPageData;
import com.scharco.PageObjects.OTAUpdates;
import com.scharco.Utilities.BaseClass;
import com.scharco.Utilities.PropertiesRead;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class OTAUpdatesFunctions extends BaseClass {

    WebDriver webDriver;
    PropertiesRead propertiesRead = new PropertiesRead();

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

        webDriver.findElement(By.xpath(menuOTAUpdates)).click();
        waitForLoadingIconDisappear();
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
        WebElement element = webDriver.findElement(By.xpath(buttonSubmitOTA));
        JavascriptExecutor executor = (JavascriptExecutor)webDriver;
        executor.executeScript("arguments[0].click();", element);
        waitForLoadingIconDisappear();
        webDriver.findElement(By.xpath(menuFirmware)).click();
        waitForLoadingIconDisappear();
    }

}
