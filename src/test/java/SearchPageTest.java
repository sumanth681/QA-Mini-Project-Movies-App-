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
    public void CheckSearchFunctionality(){
        searchPage.LoginToApplication("rahul","rahul@2021");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

        WebElement searchButton = driver.findElement(By.className("search-empty-button"));
        searchButton.click();

        WebElement searchButton1 = driver.findElement(By.className("search-button"));
        searchButton1.click();

        // We can search Movie and  pass the movie as an Argument below line , we can get the list of movies
        int value = searchPage.searchFunctionalities("Avatar");
        if(value >=1){
            System.out.println("Search Functionality is Working Expected");
        }
    }
}
