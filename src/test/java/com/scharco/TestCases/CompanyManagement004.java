package com.scharco.TestCases;

import com.scharco.Utilities.BaseClass;
import com.scharco.WebAppFunctions.CompanyManagementFunctions;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class CompanyManagement004 extends BaseClass {

    @Test(priority=1)
    public void Verify_User_Can_Add_Company() throws InterruptedException, IOException, AWTException {
        CompanyManagementFunctions companyManagementFunctions = new CompanyManagementFunctions(webDriver);
        companyManagementFunctions.addCompany();
    }

    @Test(priority=2)
    public void Verify_User_Can_Edit_Company() throws InterruptedException, IOException, AWTException {
        CompanyManagementFunctions companyManagementFunctions = new CompanyManagementFunctions(webDriver);
        companyManagementFunctions.editCompany();
    }

    @Test(priority=3)
    public void Verify_User_Can_Delete_Company() throws InterruptedException, IOException, AWTException {
        CompanyManagementFunctions companyManagementFunctions = new CompanyManagementFunctions(webDriver);
        companyManagementFunctions.deleteCompany();
    }
}
