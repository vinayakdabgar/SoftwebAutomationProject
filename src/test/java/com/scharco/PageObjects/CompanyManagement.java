package com.scharco.PageObjects;


import com.scharco.PageData.CompanyManagementData;
import com.scharco.Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CompanyManagement extends BaseClass {

    WebDriver localDriver;

    public CompanyManagement (WebDriver remoteDriver) {
        localDriver = remoteDriver;
        PageFactory.initElements(remoteDriver,this);
    }
    @FindBy(xpath = "/html/body/app-root/app-layout/mat-drawer-container/mat-drawer-content/app-leftnav/aside/section/ul/li[4]/a/span")
    WebElement companyNameMenu;

}
