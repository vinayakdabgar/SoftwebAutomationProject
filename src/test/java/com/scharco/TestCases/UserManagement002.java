package com.scharco.TestCases;

import com.scharco.Utilities.BaseClass;
import com.scharco.WebAppFunctions.LoginPageFunctions;
import com.scharco.WebAppFunctions.UserManagementFunctions;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserManagement002 extends BaseClass {

    @Test
    public void TestCase002_UserManagement() throws InterruptedException, IOException {
        UserManagementFunctions userManagementFunctions = new UserManagementFunctions(webDriver);
        userManagementFunctions.addUser();
        userManagementFunctions.deleteUser();
    }
}
