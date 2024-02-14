package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.time.Duration;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import java.util.*;
public class SearchPage {
    public WebDriver driver;
    public WebDriverWait  wait;

    By LoginButton=By.className("login-button");
    By USERNAME=By.id("usernameInput");
    By PASSWORD=By.id("passwordInput");

    public SearchPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    public  int searchAvatarMovieFunctionalities(String Movie){

        WebElement searchInput =  driver.findElement(By.id("search"));
        searchInput.sendKeys(Movie);

        List<WebElement> movieList = driver.findElements(By.className("movie-icon-item"));
        return movieList.size();
    }


    public  int searchSquidGameMovieFunctionalities(String Movie){

        WebElement searchInput =  driver.findElement(By.id("search"));
        searchInput.sendKeys(Movie);

        List<WebElement> movieList = driver.findElements(By.className("movie-icon-item"));
        return movieList.size();
    }

    public void LoginToApplication(String username , String password){
        driver.findElement(USERNAME).sendKeys(username);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LoginButton).click();
    }
}
