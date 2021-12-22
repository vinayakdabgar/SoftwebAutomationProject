package com.scharco.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RoleManagement {

    WebDriver webDriver;

    public RoleManagement(WebDriver remoteDriver) {
        webDriver = remoteDriver;
        PageFactory.initElements(remoteDriver,this);
    }

    @FindBy(css = "[class*='cdk-column-roleName']")
    List<WebElement> listOfRoleName;

    public List<WebElement> getListOfRoleName() {
        return listOfRoleName;
    }

    public void clickOnRoleDeleteButton(String roleName)
    {
        webDriver.findElement(By.xpath("//td[contains(text(),\""+roleName+"\")]//ancestor::td//following-sibling::td[5]//div//ul//li[2]//a")).click();
    }
}
