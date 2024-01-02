package pages;
import org.openqa.selenium.By;
import java.time.Duration;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    public WebDriver driver;
    public WebDriverWait  wait;

    By LoginButton=By.className("login-button");
    By USERNAME=By.id("usernameInput");
    By PASSWORD=By.id("passwordInput");

    public AccountPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    public void LoginToApplication(String username , String password){
        driver.findElement(USERNAME).sendKeys(username);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LoginButton).click();
    }
}
