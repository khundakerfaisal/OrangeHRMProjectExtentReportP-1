package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPages {
    @FindBy(name = "username")
    WebElement txtUserName;
    @FindBy(name = "password")
    WebElement txtPassword;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement loginButton;

    public LoginPages(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void hrmLoginPage(String username,String password) throws InterruptedException {
        txtUserName.sendKeys(username);
        Thread.sleep(1000);
        txtPassword.sendKeys(password);
        Thread.sleep(1000);
        loginButton.click();
        Thread.sleep(2000);
    }
}
