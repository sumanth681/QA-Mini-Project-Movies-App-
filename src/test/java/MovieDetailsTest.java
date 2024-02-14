import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import pages.movieDetailsPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class MovieDetailsTest {
    public static WebDriver driver;
    movieDetailsPage movieDetailsPage;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        movieDetailsPage = new movieDetailsPage(driver);
    }

    @AfterMethod
    public void setdown() {
        driver.close();
    }

    @Test(priority = 1)
    public void checkHomePageFuctionalities() {
        movieDetailsPage.LoginToApplication("rahul", "rahul@2021");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

        WebElement homePage = driver.findElement(By.linkText("Home"));
        homePage.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement movie = driver.findElement(By.xpath("html/body/div/div/div[2]/div[1]/div/div/div/div/div[3]/div/a/div/img"));
        movie.click();

        boolean value1 = movieDetailsPage.isLogoElementLocated();
        boolean value2 = movieDetailsPage.isHomeNavbarDisplayed();
        boolean value3 = movieDetailsPage.isPopularNavBarDisplayed();
        boolean value4 = movieDetailsPage.isAccountNavBarDisplayed();
        boolean value5 = movieDetailsPage.isSerachNavBarDisplayed();

        boolean value6 = movieDetailsPage.checkDetailedMovieCategoriesContainer();
        boolean value7 = movieDetailsPage.checkTitleDetailsContainer();
        boolean value8 = movieDetailsPage.similarMoviesContainer();
        boolean value9 = movieDetailsPage.checkMoreLikeThisMoviesList();
        boolean value10 = movieDetailsPage.checkFooterContainer();
        boolean value11 = movieDetailsPage.checkAllIcons();


        boolean final_result = value1 && value2 && value3 && value4
                && value5 && value6
                && value7 && value8 && value9
                && value10 && value11;

        Assert.assertTrue(final_result, "Original Movie Detail's Page Section Failed");
    }

    @Test(priority = 2)
    public void checkPopularPageFuctionalities() {
        movieDetailsPage.LoginToApplication("rahul", "rahul@2021");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

        WebElement  popularPage = driver.findElement(By.linkText("Popular"));
        popularPage.click();

        WebElement movie = driver.findElement(By.xpath("/html/body/div/div/div[1]/li[1]"));
        movie.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        boolean value1 = movieDetailsPage.isLogoElementLocated();
        boolean value2 = movieDetailsPage.isHomeNavbarDisplayed();
        boolean value3 = movieDetailsPage.isPopularNavBarDisplayed();
        boolean value4 = movieDetailsPage.isAccountNavBarDisplayed();
        boolean value5 = movieDetailsPage.isSerachNavBarDisplayed();

        boolean value6 = movieDetailsPage.checkDetailedMovieCategoriesContainer();
        boolean value7 = movieDetailsPage.checkTitleDetailsContainer();
        boolean value8 = movieDetailsPage.similarMoviesContainer();
        boolean value9 = movieDetailsPage.checkMoreLikeThisMoviesList();
        boolean value10 = movieDetailsPage.checkFooterContainer();
        boolean value11 = movieDetailsPage.checkAllIcons();

        boolean final_result = value1 && value2 && value3 && value4
                && value5 && value6
                && value7 && value8 && value9
                && value10 && value11;

        Assert.assertTrue(final_result, "Popular Movie Detail's Page Section Failed");
    }
}