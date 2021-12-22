package com.scharco.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver localDriver;

    public LoginPage(WebDriver remoteDriver) {
        localDriver = remoteDriver;
        PageFactory.initElements(remoteDriver,this);
    }

    // Properties

    @FindBy(xpath = "//input[@id='mat-input-0']")
    WebElement enterEmailAddressTextBox;

    @FindBy(xpath = "//input[@id='mat-input-1']")
    WebElement enterPasswordTextBox;

    @FindBy(xpath = "//button[@class='mat-focus-indicator btn-global mat-button mat-button-base']")
    WebElement clickOnLoginButton;

    @FindBy(xpath = "//h2[normalize-space()='Login']")
    WebElement loginHeaderText;

    public WebElement getLoginHeaderText() {
        return loginHeaderText;
    }

    public WebElement getClickOnLoginButton() {
        return clickOnLoginButton;
    }

    public WebElement getEnterPasswordTextBox() {
        return enterPasswordTextBox;
    }

    public WebElement getEnterEmailAddressTextBox() {
        return enterEmailAddressTextBox;
    }
}
