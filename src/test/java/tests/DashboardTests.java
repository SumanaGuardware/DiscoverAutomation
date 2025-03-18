package tests;

import base.BaseTest;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.DashboardPageActions;
import pageObjects.LoginPageActions;
import utilities.ExtentReportManager;

public class DashboardTests extends BaseTest {

    DashboardPageActions dashboardPageActions;
    LoginPageActions loginPageActions;

    @BeforeMethod
    public void setupTest() {
        dashboardPageActions = new DashboardPageActions(driver);
        loginPageActions = new LoginPageActions(driver);
    }

    @Test(priority = 1, description = "Dashboard Navigation Test")
    public void testDashboardNavigation() throws InterruptedException {
        ExtentTest test = ExtentReportManager.startTest("Dashboard Test");
        test.info("Starting Dashboard Test");
        dashboardPageActions.clickDashboard();
        test.info("Clicked on dashboard icon");
        Thread.sleep(1000);
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
        test.info("User redirected to dashboard");
        test.pass("Dashboard Button Click Test successful");
        Thread.sleep(2000);
    }

    @Test (priority = 2, description = "Data Governance Navigation Test")
    public void testDataGovernanceNavigation() throws InterruptedException {
        ExtentTest test = ExtentReportManager.startTest("Data Governance Test");
        test.info("Starting Data Governance Test");
        dashboardPageActions.clickDataGovernance();
        test.info("Clicked on Data Governance icon");
        Thread.sleep(1000);
        Assert.assertTrue(driver.getCurrentUrl().contains("data-governance"));
        test.info("User redirected to Data Governance");
        test.pass("Data Governance Button Click Test successful");
        Thread.sleep(2000);
    }

    @Test (priority = 3, description = "Devices Navigation Test")
    public void testDevicesNavigation() throws InterruptedException {
        ExtentTest test = ExtentReportManager.startTest("Devices Test");
        test.info("Starting Devices Test");
        dashboardPageActions.clickDevices();
        test.info("Clicked on Devices icon");
        Thread.sleep(1000);
        Assert.assertTrue(driver.getCurrentUrl().contains("devices"));
        test.info("User redirected to Devices");
        test.pass("Devices Button Click Test successful");
        Thread.sleep(2000);
    }

    @Test (priority = 4, description = "End Users Navigation Test")
    public void testEndUsersNavigation() throws InterruptedException {
        ExtentTest test = ExtentReportManager.startTest("End Users Test");
        test.info("Starting End Users Test");
        dashboardPageActions.clickEndUsers();
        test.info("Clicked on End Users icon");
        Thread.sleep(1000);
        Assert.assertTrue(driver.getCurrentUrl().contains("organizations"));
        test.info("User redirected to End Users");
        test.pass("End Users Button Click Test successful");
        Thread.sleep(2000);
    }

    @Test (priority = 5, description = "Discover Navigation Test")
    public void testDiscoverNavigation() throws InterruptedException {
        ExtentTest test = ExtentReportManager.startTest("Discover Test");
        test.info("Starting Discover Test");
        dashboardPageActions.clickDiscover();
        test.info("Clicked on Discover icon");
        Thread.sleep(1000);
        Assert.assertTrue(driver.getCurrentUrl().contains("agents"));
        test.info("User redirected to Discover");
        test.pass("Discover Button Click Test successful");
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDownTest() {
        ExtentReportManager.endTest();
    }
}