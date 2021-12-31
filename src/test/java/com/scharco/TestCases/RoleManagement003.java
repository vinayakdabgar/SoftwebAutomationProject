package com.scharco.TestCases;

import com.scharco.Utilities.BaseClass;
import com.scharco.WebAppFunctions.AddRoleFunctions;
import com.scharco.WebAppFunctions.UserManagementFunctions;
import org.testng.annotations.Test;

import java.io.IOException;

public class RoleManagement003 extends BaseClass {

    @Test(priority=1)
    public void TestCase001_AddRole() throws InterruptedException, IOException {
        AddRoleFunctions addRoleFunctions = new AddRoleFunctions(webDriver);
        addRoleFunctions.createNewRuleWithAllPermission();
    }

    @Test(priority=2)
    public void TestCase002_EditRole() throws InterruptedException, IOException {
        AddRoleFunctions addRoleFunctions = new AddRoleFunctions(webDriver);
        addRoleFunctions.editRole();
    }

    @Test(priority=3)
    public void TestCase003_DeleteRole() throws InterruptedException, IOException {
        AddRoleFunctions addRoleFunctions = new AddRoleFunctions(webDriver);
        addRoleFunctions.deleteRole();
    }
}
