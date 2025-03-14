package pageObjects;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageActions {
    WebDriver driver;

    @FindBy(xpath = "//input[@id='email']")
    WebElement userName;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement signIn;

    @FindBy(css = "#otp")
    WebElement authenticationCode;

    @FindBy(xpath = "//button[@data-pc-name='button']")
    WebElement authenticateButton;


    public LoginPageActions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clearUsername() {
        userName.clear();
    }

    public void enterUsername(String user) {
        userName.sendKeys(user);
    }

    public void clearPassword() {
        password.clear();
    }

    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }

    public void clickSignIn() {
        signIn.click();
    }

    public void enterAuthenticationCode(String code) {
        authenticationCode.sendKeys(code);
    }

    public void clearAuthenticationCode() {
        authenticationCode.clear();
    }

    public void clickAuthenticateButton(){
    authenticateButton.click();
    }
}