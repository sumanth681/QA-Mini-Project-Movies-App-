package stepdefinations;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class LoginFunctionalitySteps {
    public WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Given("I am on login Page")
    public void iAmOnLoginPage(){
        driver.get("https://qamoviesapp.ccbp.tech/login");

    }

    @When("I enter valid username and password")
    public void iEnterValidUsernameAndPassword() {
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
    }

    @And("I click on login button")
    public void iClickOnTheLoginButton() {
        driver.findElement(By.className("login-button")).click();
    }

    @Then("I should be redirect to home page")
    public void iShouldBeRedirectedToTheHomePage(){
        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
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
