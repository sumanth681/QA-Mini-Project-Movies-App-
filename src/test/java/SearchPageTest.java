import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import pages.SearchPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class SearchPageTest {
    public  static WebDriver driver;
    SearchPage searchPage;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        searchPage = new SearchPage(driver);
    }

    @AfterMethod
    public void setdown() {
        driver.close();
    }

    @Test
    public void SearchAvatarMovie(){
        searchPage.LoginToApplication("rahul","rahul@2021");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

        // Searching Avatar Movie

        WebElement searchButton = driver.findElement(By.className("search-empty-button"));
        searchButton.click();

        WebElement searchButton1 = driver.findElement(By.className("search-button"));
        searchButton1.click();


        int value = searchPage.searchAvatarMovieFunctionalities("Avatar");

        // Avatar Movie Detail

        WebElement AvatarMovieDetail = driver.findElement(By.xpath("/html/body/div/div/ul/li[24]/a/img"));
        AvatarMovieDetail.click();

        String AvatarPage = driver.getCurrentUrl();
        Assert.assertEquals(AvatarPage,"https://qamoviesapp.ccbp.tech/movies/cfdd2370-ab67-4e0e-99f9-3014cb532a17","Avatar Movie Detail Page Failed");

        WebElement homePage = driver.findElement(By.linkText("Home"));
        homePage.click();

        if(value == 1){
            System.out.println("Search Functionality is Working Expected");
        }

    }

    @Test
    public void SerachSquidGameMovie(){
        searchPage.LoginToApplication("rahul","rahul@2021");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));


        // Searching Squid Game Movie

        WebElement searchButtonMovie2 = driver.findElement(By.className("search-empty-button"));
        searchButtonMovie2.click();

        WebElement searchButtonMovie_2 = driver.findElement(By.className("search-button"));
        searchButtonMovie_2.click();

        int value1 = searchPage.searchSquidGameMovieFunctionalities("Squid Game");

        // Squid Game Movie Detail
        WebElement SquidGameMovieDetail = driver.findElement(By.xpath("/html/body/div/div/ul/li[26]/a/img"));
        SquidGameMovieDetail.click();

        String SquidGamePage = driver.getCurrentUrl();
        Assert.assertEquals(SquidGamePage,"https://qamoviesapp.ccbp.tech/movies/828f0c17-3f21-4e34-9671-54dfb66fcac9","Avatar Movie Detail Page Failed");

        WebElement homePage = driver.findElement(By.linkText("Home"));
        homePage.click();

        if(value1 == 1){
            System.out.println("Search Functionality is Working Expected");
        }
    }
}
