package com.scharco.TestCases;


import com.scharco.WebAppFunctions.RuleManagementFunctions;
import org.testng.annotations.Test;
import com.scharco.Utilities.BaseClass;

import java.io.IOException;

public class RuleManagement007 extends BaseClass {

        @Test
        public void TestCase007_RuleManagement() throws InterruptedException, IOException {

            RuleManagementFunctions ruleManagementFunctions = new RuleManagementFunctions(webDriver);
            ruleManagementFunctions.addRule();
            ruleManagementFunctions.deleteRule();

        }

}
