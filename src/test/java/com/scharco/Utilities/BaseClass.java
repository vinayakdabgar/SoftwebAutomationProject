package com.scharco.Utilities;

import com.scharco.PageObjects.PageLoading;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseClass {

    public static WebDriver webDriver;

    @BeforeClass
    public void setup() throws IOException {

        PropertiesRead propertiesRead = new PropertiesRead();
        String url = propertiesRead.readProperties("URL");
        String browser = propertiesRead.readProperties("Browser");

        if (browser.equalsIgnoreCase("Chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("start-maximized");
            WebDriverManager.chromedriver().setup();
            
            webDriver = new ChromeDriver(chromeOptions);
        }
        else if (browser.equalsIgnoreCase("Edge"))
        {
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.addArguments("start-maximized");
            WebDriverManager.edgedriver().setup();
            webDriver = new EdgeDriver(edgeOptions);
        }
        webDriver.get(url);
    }

    public String getScreenshotPath(String TestCaseName) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) webDriver;
        String dateName = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        String destPath = System.getProperty("user.dir")+"\\Reports\\Screenshots\\"+TestCaseName+dateName+".png";
        File file = new File(destPath);
        FileUtils.copyFile(source, file);
        return destPath;
    }

    public void waitForLoadingIconDisappear() throws InterruptedException {
        PageLoading pageLoading = new PageLoading(webDriver);
        int count = 0;
        while (pageLoading.getLoadingIcon().size() != 0 && count<8){
            Thread.sleep(1000);
            count++;
        }
    }

    @AfterClass
    public void teardown(){
        webDriver.quit();
    }
}