package com.scharco.TestCases;

import com.scharco.PageObjects.OTAUpdates;
import com.scharco.Utilities.BaseClass;
import com.scharco.WebAppFunctions.AddRoleFunctions;
import com.scharco.WebAppFunctions.FirmwareManagementFunctions;
import com.scharco.WebAppFunctions.OTAUpdatesFunctions;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class FirmwareAndOTAUpdateTestCase006 extends BaseClass {


    @Test
    public void TestCase006_FirmwareManagement() throws InterruptedException, IOException, AWTException {
        FirmwareManagementFunctions firmwareManagementFunctions = new FirmwareManagementFunctions(webDriver);
        firmwareManagementFunctions.addNewFirmware();
    }

    @Test
    public void TestCase008_AddOTAUpdates() throws IOException, InterruptedException {
        OTAUpdatesFunctions otaUpdatesFunctions = new OTAUpdatesFunctions(webDriver);
        otaUpdatesFunctions.addOTAUpdates();
    }

    @Test
    public void TestCase007_DeleteFirmwareManagement() throws IOException, InterruptedException {
        FirmwareManagementFunctions firmwareManagementFunctions = new FirmwareManagementFunctions(webDriver);
        firmwareManagementFunctions.delFirmware();
    }

}
