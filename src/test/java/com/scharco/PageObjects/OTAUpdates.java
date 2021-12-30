package com.scharco.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OTAUpdates {

    WebDriver webDriver;

    public OTAUpdates(WebDriver remoteDriver) {
        webDriver = remoteDriver;
        PageFactory.initElements(remoteDriver,this);
    }

    public void selectValueFromDropdown(String value)
    {
        webDriver.findElement(By.xpath("//span[contains(text(),\""+value+"\")]")).click();
    }

    public void selectValueFromTargetDropdown(String targetValue)
    {
        webDriver.findElement(By.xpath("//span[@class='mat-option-text'][normalize-space()=\""+targetValue+"\"]")).click();
    }

}
