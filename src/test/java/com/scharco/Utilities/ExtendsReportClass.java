package com.scharco.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendsReportClass extends BaseClass {

    static ExtentReports exReports;

    public static ExtentReports extendReportGenerator()
    {
        String reportPath = System.getProperty("user.dir")+"\\Reports\\TestReport.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
        reporter.config().setReportName("Environment : Scharco QA Server");
        reporter.config().setDocumentTitle("Scharco QA Server-Test Results");
        reporter.config().setTheme(Theme.STANDARD);

        exReports = new ExtentReports();
        exReports.attachReporter(reporter);
        exReports.setSystemInfo("Environment", "Scharco QA Server");
        exReports.setSystemInfo("Test By", "Automation Team");
        return exReports;
    }

}
