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

    @FindBy(xpath =  "//span[normalize-space()='Company Management']")
    WebElement companyNameMenu;

    @FindBy(xpath =  "//span[@class='mat-button-wrapper']//span[contains(text(),'Company')]")
    WebElement createNewCompanyButton;

    @FindBy(xpath =  "//*[@id='mat-input-1']")
    WebElement companyNameTextBox;

    @FindBy(xpath =  "//*[@id='mat-input-2']")
    WebElement companyEmailTextBox;

    @FindBy(xpath =  "//*[@id='mat-input-3']")
    WebElement firstNameTextBox;

    @FindBy(xpath =  "//*[@id='mat-input-4']")
    WebElement lastNameTextBox;

    @FindBy(xpath =  "//*[@id='mat-input-5']")
    WebElement companyContactTextBox;

    @FindBy(xpath =  "//*[@id='mat-input-6']")
    WebElement addressTextBox;

    @FindBy(xpath = "//span[contains(text(),'Select Country')]")
    WebElement clickOnCountry;

    @FindBy(xpath = "//span[contains(text(),'Enter State')]")
    WebElement stateTextBox;

    @FindBy(xpath =  "//*[@id='mat-input-7']")
    WebElement cityTextBox;

    @FindBy(xpath = "//span[contains(text(),'Enter Market Segment')]")
    WebElement marketSegmentTextBox;

    @FindBy(xpath =  "//*[@id='mat-input-8']")
    WebElement noOfDevicesTextBox;

    @FindBy(xpath =  "//*[@id='mat-input-9']")
    WebElement msgPerMonthPerDeviceNameTextBox;

    @FindBy(xpath =  "//*[@id='mat-input-10']")
    WebElement msgTotalPerMonthTextBox;

    @FindBy(xpath =  "//*[@id='mat-input-11']")
    WebElement sageIdTextBox;

    @FindBy(xpath = "//span[normalize-space()='Submit']")
    WebElement clickOnSubmit;

    @FindBy(css = "[class*='cdk-column-companyEmail']")
    List<WebElement> allEmailColumn;

    @FindBy(xpath = "//button[@class='mat-focus-indicator btn btn-orange mat-button mat-button-base']")
    WebElement clickOnOKButtonDelete;

    public WebElement getCompanyNameMenu() {
        return companyNameMenu;
    }

    public WebElement getCreateNewCompanyButton() {
        return createNewCompanyButton;
    }
    public WebElement getCompanyNameTextBox() {
        return companyNameTextBox;
    }

    public WebElement getCompanyEmailTextBox(){
        return companyEmailTextBox;
    }
    public WebElement getFirstNameTextBox(){
        return firstNameTextBox;
    }
    public WebElement getLastNameTextBox(){
        return lastNameTextBox;
    }

    public WebElement getCompanyContactTextBox(){
        return companyContactTextBox;
    }
    public WebElement getAddressTextBox(){
        return addressTextBox;
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

    public WebElement getCityTextBox(){
        return cityTextBox;
    }
    public WebElement getMarketSegmentTextBox(){ return marketSegmentTextBox;}

    public void selectMarketSegment(String marketSegment)
    {
        localDriver.findElement(By.xpath("//span[normalize-space()=\""+ marketSegment +"\"]")).click();
    }
    public WebElement getNoOfDevicesTextBox(){
        return noOfDevicesTextBox;
    }
    public WebElement getMsgPerMonthPerDeviceNameTextBox(){
        return msgPerMonthPerDeviceNameTextBox;
    }
    public WebElement getMsgTotalPerMonthTextBox(){
        return msgTotalPerMonthTextBox;
    }
    public WebElement getSageIdTextBox(){
        return sageIdTextBox;
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
