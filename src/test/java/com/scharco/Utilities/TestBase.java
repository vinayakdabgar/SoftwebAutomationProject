package com.scharco.Utilities;

import com.scharco.PageData.RoleManagementData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;

import static com.scharco.Utilities.BaseClass.webDriver;

public class TestBase extends WebDriverTestBase {

    @Override
    public void scrollPage(WebElement element) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @Override
    public void expWait(String data)
    {
        WebDriverWait wait = new WebDriverWait(webDriver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(data)));
    }

    @Override
    public void verifyToastMessage(String actualToastMessageXpath, String expToastMessage) {
        expWait(actualToastMessageXpath);
        String actualToastMessage = webDriver.findElement(By.xpath(actualToastMessageXpath)).getText();
        Assert.assertEquals(actualToastMessage, expToastMessage);
    }
}
