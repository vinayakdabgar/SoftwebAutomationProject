package com.scharco.PageObjects;

import com.scharco.PageData.UserManagementPageData;
import com.scharco.Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UserManagement extends BaseClass {

    WebDriver localDriver;

    public UserManagement(WebDriver remoteDriver) {
        localDriver = remoteDriver;
        PageFactory.initElements(remoteDriver,this);
    }

    @FindBy(css = "[class*='cdk-column-emailAddress']")
    List<WebElement> allEmailColumn;

    public List<WebElement> getAllEmailColumn() {
        return allEmailColumn;
    }

    public void clickOnDeleteButton(String email)
    {
        webDriver.findElement(By.xpath("//span[contains(text(),\""+email+"\")]//ancestor::td//following-sibling::td[5]//div//ul//li[2]//a")).click();
    }

    public void clickOnEditButton(String email)
    {
        webDriver.findElement(By.xpath("//span[contains(text(),\""+email+"\")]//ancestor::td//following-sibling::td[5]//div//ul//li[1]//a")).click();
    }

    public void selectRole(String role)
    {
        localDriver.findElement(By.xpath("//span[normalize-space()=\""+role+"\"]")).click();
    }
}
