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


    @Test(priority=1)
    public void Verify_User_Can_Add_New_Firmware() throws InterruptedException, IOException, AWTException {
        FirmwareManagementFunctions firmwareManagementFunctions = new FirmwareManagementFunctions(webDriver);
        firmwareManagementFunctions.addNewFirmware();
    }

    @Test(priority=2)
    public void Verify_User_Can_Add_New_OTAUpdate() throws IOException, InterruptedException {
        OTAUpdatesFunctions otaUpdatesFunctions = new OTAUpdatesFunctions(webDriver);
        otaUpdatesFunctions.addOTAUpdates();
    }

    @Test(priority=3)
    public void Verify_User_Can_Delete_Firmware() throws IOException, InterruptedException {
        FirmwareManagementFunctions firmwareManagementFunctions = new FirmwareManagementFunctions(webDriver);
        firmwareManagementFunctions.delFirmware();
    }

}
