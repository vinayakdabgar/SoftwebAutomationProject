package com.scharco.TestCases;


import com.scharco.WebAppFunctions.RuleManagementFunctions;
import org.testng.annotations.Test;
import com.scharco.Utilities.BaseClass;

import java.io.IOException;

public class RuleManagement007 extends BaseClass {

    @Test(priority=1)
    public void Verify_User_Can_New_Rule() throws InterruptedException, IOException {
        RuleManagementFunctions ruleManagementFunctions = new RuleManagementFunctions(webDriver);
        ruleManagementFunctions.addRule();
    }

    @Test(priority=2)
    public void Verify_User_Can_Delete_Rule() throws InterruptedException, IOException {
        RuleManagementFunctions ruleManagementFunctions = new RuleManagementFunctions(webDriver);
        ruleManagementFunctions.deleteRule();
        }

}
