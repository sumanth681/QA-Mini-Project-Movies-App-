import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import pages.AccountPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class AccountPageTest {
    public  static WebDriver driver;
    AccountPage  accountPage;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        accountPage = new  AccountPage(driver);
    }

    @AfterMethod
    public void setdown() {
        driver.close();
    }

    @Test
    public void checkAccountPage(){
        
        accountPage.LoginToApplication("rahul","rahul@2021");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

        WebElement accountPage = driver.findElement(By.className("avatar-button"));
        accountPage.click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        WebElement accountHeading = driver.findElement(By.className("account-heading"));
        wait.until(ExpectedConditions.visibilityOf(accountHeading));

        WebElement membershipContainer = driver.findElement(By.className("membership-container"));
        wait.until(ExpectedConditions.visibilityOf(membershipContainer));

        WebElement planContainer  = driver.findElement(By.className("plan-container"));
        wait.until(ExpectedConditions.visibilityOf(planContainer));

        WebElement  logoutButton  = driver.findElement(By.className("logout-button"));
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));

        WebElement iconsContainer =  driver.findElement(By.className("footer-icons-container"));
        wait.until(ExpectedConditions.visibilityOf(iconsContainer));

        WebElement contactUsPara = driver.findElement(By.className("contact-us-paragraph"));
        wait.until(ExpectedConditions.visibilityOf(contactUsPara));



    }

}
