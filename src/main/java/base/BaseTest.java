package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pageObjects.LoginPageActions;
import utilities.ExtentReportManager;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    LoginPageActions loginPage;

    @BeforeSuite
    public void beforeSuite() {
        ExtentReportManager.setupReport(); // Initialize ExtentReports
    }

    @BeforeClass
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/SumanaGhimire/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://4.237.57.227/discovery/login");
        loginPage = new LoginPageActions(driver);
        loginPage.login("sumana.g@guardware.com.au", "TESTER");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

}