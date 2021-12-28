package com.scharco.TestCases;

import com.scharco.Utilities.BaseClass;
import com.scharco.WebAppFunctions.CompanyManagementFunctions;
import org.testng.annotations.Test;

import java.io.IOException;

public class CompanyManagement004 extends BaseClass {

    @Test
    public void TestCase004_CompanyManagement() throws InterruptedException, IOException {

        CompanyManagementFunctions companyManagementFunctions = new CompanyManagementFunctions(webDriver);
        companyManagementFunctions.addCompany();
        companyManagementFunctions.deleteCompany();
    }
}
