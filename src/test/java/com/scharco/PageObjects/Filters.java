package com.scharco.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Filters {

    WebDriver webDriver;

    public Filters(WebDriver remoteDriver) {
        webDriver = remoteDriver;
        PageFactory.initElements(remoteDriver,this);
    }

    public void selectCompanyFromDropdown(String companyName)
    {
        webDriver.findElement(By.xpath("//span[contains(text(),\""+companyName+"\")]")).click();
    }

    public void selectDate(String date){
        webDriver.findElement(By.xpath("//div[normalize-space()=\""+date+"\"]")).click();
    }
}
