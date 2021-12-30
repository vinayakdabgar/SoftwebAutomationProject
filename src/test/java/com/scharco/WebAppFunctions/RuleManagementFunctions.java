package com.scharco.WebAppFunctions;


import com.scharco.PageData.CompanyManagementData;
import com.scharco.PageObjects.CompanyManagement;
import com.scharco.PageObjects.RuleManagement;
import com.scharco.PageData.RuleManagementData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.scharco.Utilities.BaseClass;
import com.scharco.Utilities.PropertiesRead;

import java.io.IOException;
import java.util.List;

public class RuleManagementFunctions extends BaseClass{
    WebDriver webDriver;
    PropertiesRead propertiesRead = new PropertiesRead();

    public RuleManagementFunctions(WebDriver remoteDriver) {
        webDriver = remoteDriver;
    }

    public void addRule() throws InterruptedException,IOException {
        String ruleMenu = propertiesRead.readProperties("menuRuleManagement");
        String ruleNewButton = propertiesRead.readProperties("createNewRule");
        String ruleName = propertiesRead.readProperties("ruleName");
        String deviceType = propertiesRead.readProperties("deviceTypeDropdown");
        String severity = propertiesRead.readProperties("severityLevel");
        String attribute = propertiesRead.readProperties("attributeDropdown");
        String condition = propertiesRead.readProperties("conditionDropdown");
        String value = propertiesRead.readProperties("valueTextBox");
        String company = propertiesRead.readProperties("companyDropdown");
        String receipts = propertiesRead.readProperties("recipients");
        String notification = propertiesRead.readProperties("notificationType");
        String submitButton =propertiesRead.readProperties("submitButtonRule");
        String ruleApply = propertiesRead.readProperties("ruleApply");

        LoginPageFunctions loginPageFunctions = new LoginPageFunctions(webDriver);
        RuleManagement ruleManagement = new RuleManagement(webDriver);

        loginPageFunctions.loginFunction();
        waitForLoadingIconDisappear();
        webDriver.findElement(By.xpath(ruleMenu)).click();
        waitForLoadingIconDisappear();
        webDriver.findElement(By.xpath(ruleNewButton)).click();
        waitForLoadingIconDisappear();

        webDriver.findElement(By.xpath(ruleName)).click();
        webDriver.findElement(By.xpath(ruleName)).sendKeys(RuleManagementData.ruleName);
        Thread.sleep(2000);
        webDriver.findElement(By.xpath(deviceType)).click();
        Thread.sleep(2000);
        ruleManagement.selectDeviceType(RuleManagementData.deviceType);
        webDriver.findElement(By.xpath(severity)).click();
        Thread.sleep(2000);
        ruleManagement.selectSeverity(RuleManagementData.severityLevel);
        webDriver.findElement(By.xpath(attribute)).click();
        Thread.sleep(2000);
        ruleManagement.selectAttribute(RuleManagementData.attribute);
        webDriver.findElement(By.xpath(condition)).click();
        Thread.sleep(2000);
        ruleManagement.selectAttribute(RuleManagementData.condition);
        webDriver.findElement(By.xpath(value)).click();
        webDriver.findElement(By.xpath(value)).sendKeys(RuleManagementData.value);
        webDriver.findElement(By.xpath(company)).click();
        Thread.sleep(2000);
        ruleManagement.selectCompany(RuleManagementData.company);
        Thread.sleep(2000);
        //webDriver.findElement(By.cssSelector("input[id='mat-radio-8-input']")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.cssSelector(receipts)).click();
        Thread.sleep(2000);
        webDriver.findElement(By.cssSelector(notification)).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath(submitButton)).click();
        waitForLoadingIconDisappear();


    }
    public void deleteRule() throws InterruptedException, IOException {
        RuleManagement ruleManagement = new RuleManagement(webDriver);
        String buttonOkDelete = propertiesRead.readProperties("OkButtonDeletePopup");

        for (WebElement ruleData : ruleManagement.getAllRuleName())
        {
            if(ruleData.getText().contains(RuleManagementData.ruleName))
            {
                ruleManagement.clickOnDeleteButton(RuleManagementData.ruleName);
                webDriver.findElement(By.xpath(buttonOkDelete)).click();
                Thread.sleep(2000);
                break;
            }
        }
    }


}

