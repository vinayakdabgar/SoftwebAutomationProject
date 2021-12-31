package com.scharco.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RuleManagement {

    WebDriver webDriver;

    public RuleManagement(WebDriver remoteDriver) {
        webDriver = remoteDriver;
        PageFactory.initElements(remoteDriver,this);
    }
    @FindBy(xpath = "//button[@class='mat-focus-indicator btn btn-orange mat-button mat-button-base']")
    WebElement clickOnOKButtonDelete;

    @FindBy(css = "[class*='cdk-column-ruleName']")
    List<WebElement> allRuleName;

    public void selectDeviceType(String device)
    {
        webDriver.findElement(By.xpath("//span[contains(text(),\""+device+"\")]")).click();
    }
    public void selectSeverity(String severity)
    {
        webDriver.findElement(By.xpath("//span[contains(text(),\""+severity+"\")]")).click();
    }
    public void selectAttribute(String attribute)
    {
        webDriver.findElement(By.xpath("//span[contains(text(),\""+attribute+"\")]")).click();
    }
    public void selectCondition(String condition)
    {
        webDriver.findElement(By.xpath("//span[contains(text(),\""+condition+"\")]")).click();
    }
    public void selectCompany(String company)
    {
        webDriver.findElement(By.xpath("//span[contains(text(),\""+company+"\")]")).click();
    }
    public WebElement getClickOnOKButtonDelete() {
        return clickOnOKButtonDelete;
    }
    public List<WebElement> getAllRuleName() {
        return allRuleName;
    }
    public void clickOnDeleteButton(String ruleName)
    {
        webDriver.findElement(By.xpath("//td[contains(text(),\""+ruleName+"\")]//ancestor::tr//following-sibling::td[5]/div[1]/ul[1]/li[3]/a")).click();
    }
}
