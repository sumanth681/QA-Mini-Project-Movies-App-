import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.Assert;
import pages.HomePage;

public class HomePageTest {
    public WebDriver driver;
    HomePage homePage;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/");
        homePage = new HomePage(driver);

    }

    @AfterMethod
    public void setdown() {
        driver.close();
    }

    @Test(priority = 1)
    public void checkTheHeadingTexts(){
        homePage.LoginToApplication("rahul","rahul@2021");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

        String value1 = homePage.testHomeHeading();
        Assert.assertEquals(value1,"Home", "Home Heading is Not Working");

        String value2 = homePage.testPopularHeading();
        Assert.assertEquals(value2 , "Popular" ,"Popular Heading is Not Working");
    }

   @Test(priority = 2)
    public void checkPlayBtn(){
       homePage.LoginToApplication("rahul","rahul@2021");
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

        boolean value = homePage.testPlayButton();
        Assert.assertTrue(value , "Play Button is Not Working");
    }

    @Test(priority = 3)
    public void checkMoviesDisplay(){
        homePage.LoginToApplication("rahul","rahul@2021");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        boolean value = homePage.checkMoviesSections();
        Assert.assertTrue(value , "Movies Display is Not Working");
    }

    @Test(priority = 4)
    public void checkContact(){
        homePage.LoginToApplication("rahul","rahul@2021");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

        boolean value = homePage.testContactUs();
        Assert.assertTrue(value , "Contact Us is Not Working");
    }

}
