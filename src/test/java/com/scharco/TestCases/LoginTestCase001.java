package com.scharco.TestCases;

import com.scharco.Utilities.BaseClass;
import com.scharco.WebAppFunctions.LoginPageFunctions;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTestCase001 extends BaseClass {

    @Test
    public void TestCase001_UserLogin() throws InterruptedException, IOException {
        LoginPageFunctions loginPageFunctions = new LoginPageFunctions(webDriver);
        loginPageFunctions.loginFunction();
        loginPageFunctions.logoutFunctionality();
    }
}
