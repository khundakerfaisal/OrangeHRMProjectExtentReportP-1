package Pages;

import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

import java.io.IOException;

import static Config.BasePage.test;

public class LoginPages {

    WebDriver driver;
    @FindBy(name = "username")
    WebElement txtUserName;
    @FindBy(name = "password")
    WebElement txtPassword;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement loginButton;

    public LoginPages(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void hrmLoginPage(String username,String password) throws InterruptedException, IOException {

        txtUserName.sendKeys(username);
        Utils.getScreenShot(driver,"User name found as expected");
        test.info("User name found as expected");
        Thread.sleep(1000);

        txtPassword.sendKeys(password);
        test.info("Password found as expected");
        Thread.sleep(1000);
        loginButton.click();
//        test.pass("Login button Press Successfully");
        Utils.getScreenShot(driver,"Login button Press Successfully");
        Thread.sleep(2000);
    }
}
