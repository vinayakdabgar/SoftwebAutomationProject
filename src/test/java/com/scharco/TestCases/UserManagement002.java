package com.scharco.TestCases;

import com.scharco.Utilities.BaseClass;
import com.scharco.WebAppFunctions.LoginPageFunctions;
import com.scharco.WebAppFunctions.UserManagementFunctions;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class UserManagement002 extends BaseClass {

    @Test(priority=1)
    public void TestCase002_AddUser() throws InterruptedException, IOException, AWTException {
        UserManagementFunctions userManagementFunctions = new UserManagementFunctions(webDriver);
        userManagementFunctions.addUser();
    }

    @Test(priority=2)
    public void TestCase003_EditUser() throws IOException, InterruptedException {
        UserManagementFunctions userManagementFunctions = new UserManagementFunctions(webDriver);
        userManagementFunctions.editUser();
    }

    @Test(priority=3)
    public void TestCase004_DeleteUser() throws IOException, InterruptedException {
        UserManagementFunctions userManagementFunctions = new UserManagementFunctions(webDriver);
        userManagementFunctions.deleteUser();
    }
}
