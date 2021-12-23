package com.scharco.WebAppFunctions;

import com.scharco.PageData.LoginPageData;
import com.scharco.PageData.NotificationData;
import com.scharco.PageObjects.Filters;
import com.scharco.Utilities.BaseClass;
import com.scharco.Utilities.PropertiesRead;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class DashboardFunctions extends BaseClass {

    WebDriver webDriver;
    PropertiesRead propertiesRead = new PropertiesRead();

    public DashboardFunctions(WebDriver remoteDriver) {
        webDriver = remoteDriver;
    }

    public void viewAll() throws InterruptedException, IOException {
        LoginPageFunctions loginPageFunctions = new LoginPageFunctions(webDriver);
        Filters filters = new Filters(webDriver);
        String headerNotificationText = propertiesRead.readProperties("textNotifications");
        String linkViewAll = propertiesRead.readProperties("viewAllLink");
        String headerNotificationListText = propertiesRead.readProperties("textNotificationList");
        String buttonFilter = propertiesRead.readProperties("filterNotification");
        String dropdownCompanyName = propertiesRead.readProperties("clickOnCompanyNameDropdown");
        String filterStartDate = propertiesRead.readProperties("filterStartDate");
        String filterEndDate = propertiesRead.readProperties("filterEndDate");
        String buttonPreviousCalender = propertiesRead.readProperties("previousButtonCalender");
        String currentDate = propertiesRead.readProperties("selectCurrentDate");
        String buttonApply = propertiesRead.readProperties("buttonApply");
        String buttonClear = propertiesRead.readProperties("buttonClear");
        String listOfCompanyName = propertiesRead.readProperties("companyColumn");

        loginPageFunctions.loginFunction();
        WebElement element = webDriver.findElement(By.xpath(headerNotificationText));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
        webDriver.findElement(By.xpath(linkViewAll)).click();
        waitForLoadingIconDisappear();
        String textNotificationList = webDriver.findElement(By.xpath(headerNotificationListText)).getText();
        Assert.assertEquals(textNotificationList, NotificationData.expHeaderName);

        webDriver.findElement(By.xpath(buttonFilter)).click();
        webDriver.findElement(By.xpath(dropdownCompanyName)).click();
        filters.selectCompanyFromDropdown(NotificationData.companyName);

        webDriver.findElement(By.xpath(filterStartDate)).click();
        webDriver.findElement(By.cssSelector(buttonPreviousCalender)).click();
        filters.selectDate("1");

        webDriver.findElement(By.xpath(filterEndDate)).click();
        webDriver.findElement(By.cssSelector(currentDate)).click();

        webDriver.findElement(By.xpath(buttonApply)).click();

        List<WebElement> listOfCompanies = webDriver.findElements(By.xpath(listOfCompanyName));
        int count = 1;
        for(WebElement companyName : listOfCompanies)
        {
            if(companyName.getText().equalsIgnoreCase(NotificationData.companyName))
            {
                String comName = companyName.getText();
                Assert.assertEquals(comName, NotificationData.companyName);
                count++;
            } else {
                System.out.println("Sorry!! Something wrong..");
            }
        }

        webDriver.findElement(By.xpath(buttonFilter)).click();
        webDriver.findElement(By.xpath(buttonClear)).click();

    }
}