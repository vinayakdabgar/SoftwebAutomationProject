package com.scharco.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout {

    WebDriver localDriver;

    public Logout(WebDriver remoteDriver) {
        localDriver = remoteDriver;
        PageFactory.initElements(remoteDriver,this);
    }

    @FindBy(xpath = "//a[@class='dropdown-toggle']")
    WebElement toggleDropdown;

    @FindBy(xpath = "//button[normalize-space()='Sign Out']")
    WebElement signOutButton;

    public WebElement getSignOutButton() {
        return signOutButton;
    }

    public WebElement getToggleDropdown() {
        return toggleDropdown;
    }
}
