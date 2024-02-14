import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.Assert;
import pages.PopularPage;

public class PopularPageTest {
    public  static WebDriver driver;
    PopularPage popularPage;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        popularPage = new PopularPage(driver);

    }

    @AfterMethod
    public void setdown() {
        driver.close();
    }


    @Test(priority = 1)
    public  void checkPopularPageSection(){
        popularPage.LoginToApplication("rahul","rahul@2021");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        boolean value = popularPage.checkPopularPageSection();
        Assert.assertTrue(value ,"Popular Page Section Failed");
    }
    @Test(priority = 2)
    public void checkMovieRedirection(){
        popularPage.LoginToApplication("rahul","rahul@2021");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        int value = popularPage.checkPopularPageMovies();

        if(value == 30){
            System.out.println("Movies List are displayed as Expected");
        }else{
            System.out.println("Movies  display failed");
        }

        //Checking a Movie Redirection

        List<WebElement>  popularMovieList = driver.findElements(By.className("movie-icon-item"));
        WebElement venom_Movie = popularMovieList.get(0);
        venom_Movie.click();

        String VenomMoviePage = driver.getCurrentUrl();
        Assert.assertEquals(VenomMoviePage,"https://qamoviesapp.ccbp.tech/movies/320dee56-fdb2-40cf-8df8-92b251bd781f","Movie Redirection Failed");

    }
}
