import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
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
    public void checkPopularPageMovies(){
        popularPage.LoginToApplication("rahul","rahul@2021");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        int value = popularPage.checkPopularPageMovies();
        if(value == 30){
            System.out.println("Movies are displayed as Expected");
        }else{
            System.out.println("Movies are display failed");
        }
    }
}
