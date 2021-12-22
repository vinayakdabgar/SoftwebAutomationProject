package com.scharco.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageLoading {

    WebDriver localDriver;

    public PageLoading(WebDriver remoteDriver) {
        localDriver = remoteDriver;
        PageFactory.initElements(remoteDriver,this);
    }

    @FindBy(xpath = "//*[@class='mat-spinner mat-progress-spinner mat-primary mat-progress-spinner-indeterminate-animation']")
    public List<WebElement> loadingIcon;

    public List<WebElement> getLoadingIcon() {
        return loadingIcon;
    }
}
