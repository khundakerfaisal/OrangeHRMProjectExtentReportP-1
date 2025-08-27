package TestRunner;

import Config.BasePage;
import Config.LoginCsvDataSet;
import Pages.LoginPages;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Utils;

public class LoginTest extends BasePage {

    @Test (dataProvider="loginCsvData",dataProviderClass = LoginCsvDataSet.class)
    public void doLoginWithValidCred(String username,String password) throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        LoginPages loginPages=new LoginPages(driver);

//        loginPages.hrmLoginPage("Admin","admin123");
        loginPages.hrmLoginPage(username,password);
        Thread.sleep(1000);
        String TextExpected=driver.findElement(By.xpath("//span/h6[text()='Dashboard']")).getText();
        String TextActual="Dashboard";
        Assert.assertEquals(TextActual,TextExpected);
        Thread.sleep(1000);
    }

}
