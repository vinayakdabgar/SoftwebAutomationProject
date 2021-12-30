package com.scharco.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FirmwareManagement {

    WebDriver webDriver;

    public FirmwareManagement(WebDriver remoteDriver) {
        webDriver = remoteDriver;
        PageFactory.initElements(remoteDriver,this);
    }

    public void selectDeviceTypeFromDropdown(String value)
    {
        webDriver.findElement(By.xpath("//span[contains(text(),\""+value+"\")]")).click();
    }

    public void clickOnFirmwareDeleteButton(String firmwareName)
    {
        webDriver.findElement(By.xpath("//td[contains(text(),\""+firmwareName+"\")]//ancestor::td//following-sibling::td[5]//div//ul//li[2]//a")).click();
    }

    public void clickOnSoftwareUpgradeDraft(String firmwareName)
    {
        webDriver.findElement(By.xpath("//td[contains(text(),\""+firmwareName+"\")]//ancestor::td//following-sibling::td[4]//a")).click();
    }

    public void clickOnReleaseSoftwareVersion(String softwareVersion)
    {
        webDriver.findElement(By.xpath("//td[contains(text(),\""+softwareVersion+"\")]//ancestor::td//following-sibling::td[4]//ul//li[1]//a")).click();
    }
}
