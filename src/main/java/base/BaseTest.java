package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import utilities.ExtentReportManager;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        ExtentReportManager.setupReport();
    }

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/SumanaGhimire/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://4.237.57.227/pdd");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
