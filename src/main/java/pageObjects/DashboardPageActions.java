package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPageActions {

    WebDriver driver;

    @FindBy(css = "a[ng-reflect-router-link='/dashboard']")
    WebElement dashboard;

    @FindBy(xpath = "(//i[@class='bx bx-laptop'])[1]")
    WebElement dataGovernance;

    @FindBy(css = "a[ng-reflect-router-link='devices'] i[class='bx bx-laptop']")
    WebElement devices;

    @FindBy(css = ".bx.bx-group")
    WebElement endUsers;

    @FindBy(css = ".bx.bx-compass")
    WebElement discover;


    public DashboardPageActions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickDashboard() {
        dashboard.click();
    }

    public void clickDataGovernance() {
        dataGovernance.click();
    }

    public void clickDevices() {
        devices.click();
    }

    public void clickEndUsers() {
        endUsers.click();
    }

    public void clickDiscover() {
        discover.click();
    }


}