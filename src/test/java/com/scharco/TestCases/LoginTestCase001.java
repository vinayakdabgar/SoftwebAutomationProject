package com.scharco.TestCases;

import com.scharco.Utilities.BaseClass;
import com.scharco.WebAppFunctions.LoginPageFunctions;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTestCase001 extends BaseClass {

    @Test
    public void Verify_User_Can_Able_To_Login() throws InterruptedException, IOException {
        LoginPageFunctions loginPageFunctions = new LoginPageFunctions(webDriver);
        loginPageFunctions.loginFunction();
    }

    @Test
    public void Verify_User_Can_Able_To_LogOut() throws InterruptedException, IOException {
        LoginPageFunctions loginPageFunctions = new LoginPageFunctions(webDriver);
        loginPageFunctions.logoutFunctionality();
    }
}
