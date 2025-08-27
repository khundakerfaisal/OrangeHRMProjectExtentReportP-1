package TestRunner;

import Config.BasePage;
import Pages.LoginPages;
import Pages.PIMPages;
import com.github.javafaker.Faker;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Utils;

import java.io.IOException;

public class PIMTest extends BasePage {
    @Test(priority=1,groups = "smoke",description = "Admin Login Successfully!!",enabled = false)
    public void doLoginWithValidCred() throws InterruptedException, IOException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        LoginPages loginPages=new LoginPages(driver);
        String username= System.getProperty("username");
        String password= System.getProperty("password");
        loginPages.hrmLoginPage(username,password);
        Thread.sleep(1000);
        String TextExpected=driver.findElement(By.xpath("//span/h6[text()='Dashboard']")).getText();
        String TextActual="Dashboard";
        Assert.assertEquals(TextActual,TextExpected);
        Thread.sleep(1000);
    }
    @Test(priority=2,groups = "smoke",description = "Employee User create successfully!!",enabled = false)
    public void createEmployee() throws InterruptedException, IOException, ParseException {
        PIMPages pimPages=new PIMPages(driver);
        Faker faker=new Faker();
        String firstName=faker.name().firstName();
        String middleName=faker.name().nameWithMiddle();
        String lastName=faker.name().lastName();
        String userName=faker.name().username();
        String password="Pa@ssord123";
        String confirmPassword="Pa@ssord123";


        pimPages.pimMenuOperation(firstName,middleName,lastName,userName,password,confirmPassword);
        Thread.sleep(1000);
        Utils.SaveEmployee(firstName,lastName,userName,password);

//        String TextExpected=driver.findElement(By.xpath("//span/h6[text()='Dashboard']")).getText();
//        String TextActual="Dashboard";
//        Assert.assertEquals(TextActual,TextExpected);
//        Thread.sleep(1000);
    }
}
