package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static ExtentReports extent;
    private static ExtentTest test;

    public static void setupReport() {
        String path = "test-output/ExtentReport.html";
        ExtentSparkReporter spark = new ExtentSparkReporter(path);
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    public static ExtentTest startTest(String testName) {
        test = extent.createTest(testName);
        return test;
    }

    public static void endTest() {
        extent.flush();
    }
}
