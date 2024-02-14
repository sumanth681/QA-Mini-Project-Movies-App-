package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import java.util.*;
public class HomePage {
    public WebDriver driver;

    By LoginButton=By.className("login-button");
    By USERNAME=By.id("usernameInput");
    By PASSWORD=By.id("passwordInput");


    public  HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public String testHomeHeading(){
        WebElement homeHeading = driver.findElement(By.linkText("Home"));
        String  value = homeHeading.getText();
        return  value;
    }

    public String testPopularHeading(){
        WebElement popularHeading = driver.findElement(By.linkText("Popular"));
        String  value = popularHeading.getText();
        return  value;
    }

    public boolean testPlayButton(){
        WebElement  playBtn = driver.findElement(By.className("home-movie-play-button"));
        return  playBtn.isDisplayed();
    }

    public  boolean testContactUsSection(){

        WebElement googleIcon = driver.findElement(By.className("google-icon"));
        WebElement twitterIcon = driver.findElement(By.className("twitter-icon"));
        WebElement instagramIcon = driver.findElement(By.className("instagram-icon"));
        WebElement youTubeIcon = driver.findElement(By.className("youtube-icon"));
        WebElement contactUs = driver.findElement(By.className("contact-us-paragraph"));

        boolean are_Visible = googleIcon.isDisplayed() && twitterIcon.isDisplayed() && instagramIcon.isDisplayed() && youTubeIcon.isDisplayed() && youTubeIcon.isDisplayed() && contactUs.isDisplayed();
        if(are_Visible)
            return are_Visible;

        return contactUs.isDisplayed();
    }


    public  boolean checkMoviesSections(){
        List<WebElement> trendingSection =  driver.findElements(By.xpath("html/body/div/div/div[2]/div[1]/div//a"));
        List<WebElement> originalSection = driver.findElements(By.xpath("html/body/div/div/div[2]/div[2]/div//a"));
        return !trendingSection.isEmpty() && !originalSection.isEmpty();
    }

    public void LoginToApplication(String username , String password){
        driver.findElement(USERNAME).sendKeys(username);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LoginButton).click();
    }
}




