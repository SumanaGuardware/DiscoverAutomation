package tests;
import base.BaseTest;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LoginPageActions;
import utilities.ExtentReportManager;

public class LoginTests extends BaseTest {
    LoginPageActions loginPage;
    ExtentTest test;

    @BeforeMethod
    public void setupTest() {
        loginPage = new LoginPageActions(driver);
    }
    @Test(priority = 1, description = "Invalid Login Test with invalid credentials")
    public void testInvalidLogin() throws InterruptedException {
        test = ExtentReportManager.startTest("Invalid Login Test");
        test.info("Starting Invalid Login Test");
        loginPage.enterUsername("invalidUser@example.com");
        test.info("Entered invalid username");
        loginPage.enterPassword("WrongPassword");
        test.info("Entered invalid password");
        loginPage.clickSignIn();
        test.info("Clicked on sign in button");
        Thread.sleep(1000);
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
        test.info("Login failed as expected");
        test.pass("Login failed as expected");
    }

    @Test(priority = 2, description = "Valid Login Test with valid credentials")
    public void testValidLogin() throws InterruptedException {
        test = ExtentReportManager.startTest("Valid Login Test");
        test.info("Starting Valid Login Test");
        loginPage.clearUsername();
        loginPage.enterUsername("sumana.g@guardware.com.au");
        test.info("Entered username");
        loginPage.clearPassword();
        loginPage.enterPassword("TESTER");
        Thread.sleep(1000);
        test.info("Entered password");
        loginPage.clickSignIn();
        test.info("Clicked on sign in button");
        Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().contains("authentication"));
        test.info("Login successful");
        test.pass("Login successful");
    }

    @Test(priority = 3, description = "Authentication Test with valid credentials")
    public void testAuthentication() throws InterruptedException {
        test = ExtentReportManager.startTest("Authentication Test");
        test.info("Starting Authentication Test");
        loginPage.enterAuthenticationCode("123455");
        loginPage.clearAuthenticationCode();
        Thread.sleep(15000);
        loginPage.clickAuthenticateButton();
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("landing"));
        test.info("Authentication successful");
        test.pass("Authentication successful");
    }
    @AfterMethod
    public void tearDownTest() {
        ExtentReportManager.endTest();
    }
}