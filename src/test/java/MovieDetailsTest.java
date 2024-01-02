import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import pages.MovieDetailsPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MovieDetailsTest  {
    public  static WebDriver driver;
    MovieDetailsPage movieDetailsPage ;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        movieDetailsPage = new MovieDetailsPage(driver);
    }

    @AfterMethod
    public void setdown() {
        driver.close();
    }


    @Test(priority = 1)
    public void checkHomePageFuctionalities(){
        movieDetailsPage.LoginToApplication("rahul","rahul@2021");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

        WebElement homeHeading = driver.findElement(By.linkText("Home"));
        homeHeading.click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement movie = driver.findElement(By.xpath("/html/body/div/div/div"));
        movie.click();

        WebElement titleContainer = driver.findElement(By.className("home-movie-details-container"));
        wait.until(ExpectedConditions.visibilityOf(titleContainer));

       WebElement movieTitle = driver.findElement(By.className("home-movie-heading"));
       wait.until(ExpectedConditions.visibilityOf(movieTitle));


        WebElement movieOverview =  driver.findElement(By.className("home-movie-description"));
        wait.until(ExpectedConditions.visibilityOf(movieOverview));


        WebElement playButton = driver.findElement(By.className("home-movie-play-button"));
        wait.until(ExpectedConditions.elementToBeClickable(playButton));


        WebElement  homeBottomContainer = driver.findElement(By.className("home-bottom-container"));
        wait.until(ExpectedConditions.visibilityOf(homeBottomContainer));


        WebElement iconsContainer = driver.findElement(By.className("footer-icons-container"));
        wait.until(ExpectedConditions.visibilityOf(iconsContainer));

        WebElement contactUsparagraph = driver.findElement(By.className("contact-us-paragraph"));
        wait.until(ExpectedConditions.visibilityOf(contactUsparagraph));

        if(titleContainer.isDisplayed() && movieTitle.isDisplayed()  && movieOverview.isDisplayed() &&
                playButton.isDisplayed()  && homeBottomContainer.isDisplayed() &&
               iconsContainer.isDisplayed() && contactUsparagraph.isDisplayed()
        ){
            System.out.println("Home Page Fuctionalities is Working As Expected");
        }
    }

    @Test(priority = 2)
    public void  checkPopularPageFuctionalities(){
        movieDetailsPage.LoginToApplication("rahul","rahul@2021");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

        WebElement homeHeading = driver.findElement(By.linkText("Popular"));
        homeHeading.click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        WebElement movie = driver.findElement(By.xpath("/html/body/div/div/div[1]/li[1]/a/img"));
        movie.click();

        //
        WebElement titleContainer = driver.findElement(By.className("movie-details-container"));
        wait.until(ExpectedConditions.visibilityOf(titleContainer));

        WebElement movieTitle = driver.findElement(By.className("movie-title"));
        wait.until(ExpectedConditions.visibilityOf(movieTitle));


        WebElement movieOverview =  driver.findElement(By.className("movie-overview"));
        wait.until(ExpectedConditions.visibilityOf(movieOverview));


        WebElement playButton = driver.findElement(By.className("play-button"));
        wait.until(ExpectedConditions.elementToBeClickable(playButton));


        WebElement  homeBottomContainer = driver.findElement(By.className("detailed-movie-categories-container"));
        wait.until(ExpectedConditions.visibilityOf(homeBottomContainer));


        WebElement iconsContainer = driver.findElement(By.className("footer-icons-container"));
        wait.until(ExpectedConditions.visibilityOf(iconsContainer));

        WebElement contactUsparagraph = driver.findElement(By.className("contact-us-paragraph"));
        wait.until(ExpectedConditions.visibilityOf(contactUsparagraph));

        if(titleContainer.isDisplayed() && movieTitle.isDisplayed()  && movieOverview.isDisplayed() &&
                playButton.isDisplayed()  && homeBottomContainer.isDisplayed() &&
                iconsContainer.isDisplayed() && contactUsparagraph.isDisplayed()
        ){
            System.out.println("Popular Page Fuctionalities is Working As Expected");
        }

    }


}
