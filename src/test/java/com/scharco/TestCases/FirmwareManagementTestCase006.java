package com.scharco.TestCases;

import com.scharco.Utilities.BaseClass;
import com.scharco.WebAppFunctions.AddRoleFunctions;
import com.scharco.WebAppFunctions.FirmwareManagementFunctions;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class FirmwareManagementTestCase006 extends BaseClass {


    @Test
    public void TestCase006_FirmwareManagement() throws InterruptedException, IOException, AWTException {
        FirmwareManagementFunctions firmwareManagementFunctions = new FirmwareManagementFunctions(webDriver);
        firmwareManagementFunctions.addNewFirmware();
        firmwareManagementFunctions.delFirmware();
    }
}
