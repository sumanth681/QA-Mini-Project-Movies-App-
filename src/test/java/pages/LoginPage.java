package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.time.Duration;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    public WebDriver driver;
    public WebDriverWait  wait;

                         //Locating Specific Elements

    WebElement logoElement ;
    @FindBy(className = "sign-in-heading") WebElement headingElement;
    @FindBy (id = "usernameInput") WebElement userEle;
    @FindBy (id = "passwordInput") WebElement passwrdEle;
    @FindBy(className = "login-button") WebElement loginBtn;
    @FindBy(className = "error-message") WebElement errorMsg;

    WebElement userLabel;
    WebElement passwordLabel;


                         //Methods for interacting with Web Elements

    public  LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
        logoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login-website-logo")));
        userLabel = driver.findElement(By.xpath("//label[text()='USERNAME']"));
        passwordLabel = driver.findElement(By.xpath("//label[text()='PASSWORD']"));

    }
    public boolean checkTheLogoElement(){
       return logoElement.isDisplayed();
    }
    public String checkTheHeadingElement(){
        return headingElement.getText();
    }
    public String checkTheUserLabel(){
        return userLabel.getText();
    }
    public String checkThePasswordLabel(){
        return passwordLabel.getText();
    }

     public boolean checkTheLoginBtn(){
        return wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).isEnabled();
     }


    public String errorMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
        return errorMsg.getText();
    }

    public void LoginToApplication(String username , String password){
        userEle.sendKeys(username);
        passwrdEle.sendKeys(password);
        loginBtn.click();
    }
}