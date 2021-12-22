package com.scharco.TestCases;

import com.scharco.Utilities.BaseClass;
import com.scharco.WebAppFunctions.AddRoleFunctions;
import com.scharco.WebAppFunctions.UserManagementFunctions;
import org.testng.annotations.Test;

import java.io.IOException;

public class RoleManagement003 extends BaseClass {

    @Test
    public void TestCase003_RoleManagement() throws InterruptedException, IOException {
        AddRoleFunctions addRoleFunctions = new AddRoleFunctions(webDriver);
        addRoleFunctions.createNewRuleWithAllPermission();
        addRoleFunctions.deleteRole();
    }

}
