package com.scharco.TestCases;

import com.scharco.Utilities.BaseClass;
import com.scharco.WebAppFunctions.AddRoleFunctions;
import com.scharco.WebAppFunctions.DashboardFunctions;
import org.testng.annotations.Test;

import java.io.IOException;

public class Dashboard005 extends BaseClass {

    @Test
    public void Verify_User_Can_Filter_The_Notification() throws InterruptedException, IOException {
        DashboardFunctions dashboardFunctions = new DashboardFunctions(webDriver);
        dashboardFunctions.viewAll();
    }
}
