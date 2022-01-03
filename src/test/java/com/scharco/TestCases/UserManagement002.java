package com.scharco.TestCases;

import com.scharco.Utilities.BaseClass;
import com.scharco.WebAppFunctions.LoginPageFunctions;
import com.scharco.WebAppFunctions.UserManagementFunctions;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class UserManagement002 extends BaseClass {

    @Test(priority=1)
    public void Verify_User_Can_Add_New_User() throws InterruptedException, IOException, AWTException {
        UserManagementFunctions userManagementFunctions = new UserManagementFunctions(webDriver);
        userManagementFunctions.addUser();
    }

    @Test(priority=2)
    public void Verify_User_Can_Edit_User() throws IOException, InterruptedException {
        UserManagementFunctions userManagementFunctions = new UserManagementFunctions(webDriver);
        userManagementFunctions.editUser();
    }

    @Test(priority=3)
    public void Verify_User_Can_Delete_User() throws IOException, InterruptedException {
        UserManagementFunctions userManagementFunctions = new UserManagementFunctions(webDriver);
        userManagementFunctions.deleteUser();
    }
}
