package com.scharco.TestCases;

import com.scharco.Utilities.BaseClass;
import com.scharco.WebAppFunctions.AddRoleFunctions;
import com.scharco.WebAppFunctions.UserManagementFunctions;
import org.testng.annotations.Test;

import java.io.IOException;

public class RoleManagement003 extends BaseClass {

    @Test(priority=1)
    public void Verify_User_Can_Add_New_Role() throws InterruptedException, IOException {
        AddRoleFunctions addRoleFunctions = new AddRoleFunctions(webDriver);
        addRoleFunctions.createNewRuleWithAllPermission();
    }

    @Test(priority=2)
    public void Verify_User_Can_Edit_Role() throws InterruptedException, IOException {
        AddRoleFunctions addRoleFunctions = new AddRoleFunctions(webDriver);
        addRoleFunctions.editRole();
    }

    @Test(priority=3)
    public void Verify_User_Can_Delete_Role() throws InterruptedException, IOException {
        AddRoleFunctions addRoleFunctions = new AddRoleFunctions(webDriver);
        addRoleFunctions.deleteRole();
    }
}
