package com.scharco.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RuleManagement {

    WebDriver webDriver;

    public RuleManagement(WebDriver remoteDriver) {
        webDriver = remoteDriver;
        PageFactory.initElements(remoteDriver,this);
    }

    public void selectValueFromDropdown(String value)
    {
        webDriver.findElement(By.xpath("//span[contains(text(),\""+value+"\")]")).click();
    }
}
