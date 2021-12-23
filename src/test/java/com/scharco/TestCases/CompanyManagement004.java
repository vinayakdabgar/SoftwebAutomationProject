package com.scharco.TestCases;

import com.scharco.Utilities.BaseClass;
import com.scharco.WebAppFunctions.CompanyManagementFunctions;
import com.scharco.WebAppFunctions.LoginPageFunctions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class CompanyManagement004 {
    
    @Test
    public void TestCase004_CompanyManagement() throws InterruptedException, IOException {

        CompanyManagementFunctions companyManagementFunctions = new CompanyManagementFunctions(webDriver);
        CompanyManagementFunctions addCompany();

    }
}
