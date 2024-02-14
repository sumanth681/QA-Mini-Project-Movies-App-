package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.time.Duration;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import java.util.*;
public class PopularPage {
    public WebDriver driver;
    public WebDriverWait  wait;


    By LoginButton=By.className("login-button");
    By USERNAME=By.id("usernameInput");
    By PASSWORD=By.id("passwordInput");

    public PopularPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    public boolean checkPopularPageSection(){
        WebElement PopularSec = driver.findElement(By.linkText("Popular"));
        PopularSec.click();
        WebElement popularSection = driver.findElement(By.className("search-movies-container"));
        return  popularSection.isDisplayed();
    }

    public int checkPopularPageMovies(){
        WebElement PopularSec = driver.findElement(By.linkText("Popular"));
        PopularSec.click();
        List<WebElement>  popularPageList = driver.findElements(By.className("movie-icon-item"));
        return  popularPageList.size();
    }

    public void LoginToApplication(String username , String password){
        driver.findElement(USERNAME).sendKeys(username);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LoginButton).click();
    }
}