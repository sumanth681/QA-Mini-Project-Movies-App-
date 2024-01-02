package stepdefinations;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class LogoutFunctionalitySteps {
    public WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Given("I am on the login page for logout")
    public void iAmOnLoginPageForLogout(){
        driver.get("https://qamoviesapp.ccbp.tech/login");
    }

    @When("I enter valid username and password for logout")
    public void iEnterValidUsernameAndPasswordForLogout() {
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
    }

    @And("I click on login button for logout")
    public void iClickOnTheLoginButtonForLogout() {
        driver.findElement(By.className("login-button")).click();
    }


    @When("I click on account page")
    public void iClickOnAccountPage(){
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.className("avatar-button")));
       element.click();
    }

    @And("I click on logout button")
    public void iClickOnTheLogoutButton() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement  logoutButton  = driver.findElement(By.className("logout-button"));
        logoutButton.click();
    }

    @Then("I should be redirect to login page")
    public void iShouldBeRedirectedToTheLoginPage(){
        String expectedUrl = "https://qamoviesapp.ccbp.tech/login";
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, currentUrl, "URLs do not match");
    }

    @After
    public void setdown(){
        driver.close();
    }
}
