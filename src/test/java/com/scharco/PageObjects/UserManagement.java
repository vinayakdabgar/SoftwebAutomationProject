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

    @FindBy(xpath = "//span[normalize-space()='User Management']")
    WebElement userManagementMenu;

    @FindBy(xpath = "//span[@class='mat-button-wrapper']//span[contains(text(),'User')]")
    WebElement createNewUserButton;

    @FindBy(xpath = "//input[@formcontrolname='firstName']")
    WebElement firstNameTextBox;

    @FindBy(xpath = "//input[@formcontrolname='lastName']")
    WebElement lastNameTextBox;

    @FindBy(xpath = "//input[@formcontrolname='emailAddress']")
    WebElement emailTextBox;

    @FindBy(xpath = "//input[@formcontrolname='contactNumber']")
    WebElement contactTextBox;

    @FindBy(xpath = "//mat-select[@formcontrolname='roleId']")
    WebElement clickOnUserRole;

    @FindBy(xpath = "//span[normalize-space()='Submit']")
    WebElement clickOnSubmit;

    @FindBy(css = "[class*='cdk-column-emailAddress']")
    List<WebElement> allEmailColumn;

    @FindBy(xpath = "//button[@class='mat-focus-indicator btn btn-orange mat-button mat-button-base']")
    WebElement clickOnOKButtonDelete;

    public WebElement getClickOnOKButtonDelete() {
        return clickOnOKButtonDelete;
    }

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

    public WebElement getClickOnSubmit() {
        return clickOnSubmit;
    }

    public void selectRole(String role)
    {
        localDriver.findElement(By.xpath("//span[normalize-space()=\""+role+"\"]")).click();
    }

    public WebElement getClickOnUserRole() {
        return clickOnUserRole;
    }

    public WebElement getContactTextBox() {
        return contactTextBox;
    }

    public WebElement getEmailTextBox() {
        return emailTextBox;
    }

    public WebElement getLastNameTextBox() {
        return lastNameTextBox;
    }

    public WebElement getFirstNameTextBox() {
        return firstNameTextBox;
    }

    public WebElement getCreateNewUserButton() {
        return createNewUserButton;
    }

    public WebElement getUserManagementMenu() {
        return userManagementMenu;
    }
}
