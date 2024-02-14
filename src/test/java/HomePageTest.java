import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.Assert;
import pages.HomePage;
import java.util.*;

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
    public void checkMovieDisplaySections(){
        homePage.LoginToApplication("rahul","rahul@2021");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

        boolean value = homePage.checkMoviesSections();

        // Testing whether all Movies are displayed in the Trending section below
        List<WebElement> trendingMovieList = driver.findElements(By.xpath("html/body/div/div/div[2]/div[1]/div/div/div/div/div/div/a"));
        if (trendingMovieList.size() >=10) {
            System.out.println("Movies are displayed in the Trending section");
        } else {
            System.out.println("Movies are not displayed in the Trending section");
        }


        // Testing whether all Movies are displayed in the Originals section below
        List<WebElement> originalsMovieList = driver.findElements(By.xpath("/html/body/div/div/div[2]/div[2]/div/div/div/div/div/div/a"));
        if (originalsMovieList.size() >=10) {
            System.out.println("Movies are displayed in the Originals section");
        } else {
            System.out.println("Movies are not displayed in the Originals section");
        }
        Assert.assertTrue(value,"Movies are not Displayed in Corresponding Section");
    }


    @Test(priority = 4)
    public void checkContact(){
        homePage.LoginToApplication("rahul","rahul@2021");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

        boolean ContactUsSection = homePage.testContactUsSection();
        Assert.assertTrue(ContactUsSection , "Contact Us is not Implemented");
    }

}
