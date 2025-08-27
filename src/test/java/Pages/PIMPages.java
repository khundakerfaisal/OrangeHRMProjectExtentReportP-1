package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

import java.util.List;

public class PIMPages {
    WebDriver driver;
    @FindBy(className = "oxd-main-menu-item-wrapper")
    List<WebElement> pimMenu;
    @FindBy(className = "oxd-button")
    List<WebElement> clickAddButton;

    @FindBy(name = "firstName")
    WebElement inputFirstName;
    @FindBy(name = "middleName")
    WebElement inputMiddleName;
    @FindBy(name = "lastName")
    WebElement inputLastName;

    @FindBy(className = "oxd-switch-input")
    List<WebElement> checkBoxSelection;


    @FindBy(className = "oxd-input")
    List<WebElement> inputUsername;
    @FindBy(className = "oxd-input")
    List<WebElement> inputPassword;
    @FindBy(className = "oxd-input")
    List<WebElement> inputConfirmPassword;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement submitCreateAuthButton;
    public PIMPages(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void pimMenuOperation(String firstName,String middleName,String lastName,String userName,String password,String confirmPassword) throws InterruptedException {
        pimMenu.get(1).click();
        Thread.sleep(1000);
        clickAddButton.get(2).click();
        Thread.sleep(1000);
        inputFirstName.sendKeys(firstName);
        Thread.sleep(1000);
        inputMiddleName.sendKeys(middleName);
        Thread.sleep(1000);
        inputLastName.sendKeys(lastName);
        Thread.sleep(1000);
        checkBoxSelection.get(0).click();
        Thread.sleep(1000);
        inputUsername.get(5).sendKeys(userName);
        Thread.sleep(1000);
        Utils.scrollBy(driver);
        inputPassword.get(6).sendKeys(password);
        Thread.sleep(1000);
        inputConfirmPassword.get(7).sendKeys(confirmPassword);
        Thread.sleep(1000);
        submitCreateAuthButton.click();
        Thread.sleep(1000);


    }
}
