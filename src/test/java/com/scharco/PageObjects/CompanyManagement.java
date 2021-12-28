package com.scharco.PageObjects;


import com.scharco.PageData.CompanyManagementData;
import com.scharco.Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CompanyManagement extends BaseClass {

    WebDriver localDriver;

    public CompanyManagement (WebDriver remoteDriver) {
        localDriver = remoteDriver;
        PageFactory.initElements(remoteDriver,this);
    }
    @FindBy(xpath = "//span[contains(text(),'Select Country')]")
    WebElement clickOnCountry;

    @FindBy(xpath = "//span[contains(text(),'Enter State')]")
    WebElement stateTextBox;

    @FindBy(xpath = "//span[contains(text(),'Enter Market Segment')]")
    WebElement marketSegmentTextBox;

    @FindBy(xpath = "//span[normalize-space()='Submit']")
    WebElement clickOnSubmit;

    @FindBy(css = "[class*='cdk-column-companyEmail']")
    List<WebElement> allEmailColumn;

    @FindBy(xpath = "//button[@class='mat-focus-indicator btn btn-orange mat-button mat-button-base']")
    WebElement clickOnOKButtonDelete;

    public void selectStateFromDropdown(String stateName)
    {
        webDriver.findElement(By.xpath("//span[normalize-space()=\""+stateName+"\"]")).click();
    }
    public WebElement getClickOnCountry() {
        return clickOnCountry;
    }
    public WebElement getStateTextBox() {
        return stateTextBox;
    }
    public void selectCountry(String country)
    {
        localDriver.findElement(By.xpath("//span[normalize-space()=\""+country+"\"]")).click();
    }
    public void selectState(String state)
    {
        localDriver.findElement(By.xpath("//span[normalize-space()=\""+state+"\"]")).click();
    }

    public WebElement getMarketSegmentTextBox(){ return marketSegmentTextBox;}

    public void selectMarketSegment(String marketSegment)
    {
        localDriver.findElement(By.xpath("//span[normalize-space()=\""+ marketSegment +"\"]")).click();
    }
    public WebElement getClickOnSubmit()
    {

        return clickOnSubmit;
    }
    public WebElement getClickOnOKButtonDelete() {
        return clickOnOKButtonDelete;
    }
    public List<WebElement> getAllEmailColumn() {
        return allEmailColumn;
    }

    public void clickOnDeleteButton(String companyEmail)
    {
        webDriver.findElement(By.xpath("//td[contains(text(),\""+companyEmail+"\")]//ancestor::tr//following-sibling::td[7]//div//ul//li[3]//a")).click();
    }
}
