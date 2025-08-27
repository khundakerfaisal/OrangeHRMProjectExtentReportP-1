package TestRunner;

import Config.BasePage;
import Pages.LoginPages;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Utils;

import java.io.IOException;

public class LoginTestWithJson extends BasePage {
    @Test(priority = 1,groups = "smoke",description = "Employee Login Successfully!!",enabled = false)
    public void doLoginWithValidCred() throws InterruptedException, IOException, ParseException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        LoginPages loginPages=new LoginPages(driver);
        String username= Utils.getUserCred().get("UserName").toString();
        String password= Utils.getUserCred().get("Password").toString();
        loginPages.hrmLoginPage(username,password);
        Thread.sleep(1000);
        String TextExpected=driver.findElement(By.xpath("//span/h6[text()='Dashboard']")).getText();
        String TextActual="Dashboard";
        Assert.assertEquals(TextActual,TextExpected);
        Thread.sleep(1000);
    }
}
