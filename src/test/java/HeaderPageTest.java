import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.HeaderPage;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeaderPageTest {
    public static WebDriver driver;
    public HeaderPage headerpage ;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\admin\\\\Downloads\\\\chromedriver-win32\\\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        headerpage=new HeaderPage(driver);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


    @Test(priority = 1)
    public void checkTheLogoElement(){
        headerpage.LoginToApplication("rahul","rahul@2021");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

        Assert.assertTrue(headerpage.isLogoElementLocated() ,"Logo Element Not Found");
    }

    @Test(priority=2)
    public void checkTheNavBars() {
        headerpage.LoginToApplication("rahul","rahul@2021");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

        Assert.assertTrue(headerpage.isHomeNavbarDisplayed() , "Home Page NavBar is Not Working As Expected" );
        Assert.assertTrue(headerpage.isPopularNavBarDisplayed(), "Popular Page NavBar is Not Working As Expected" );
        Assert.assertTrue(headerpage.isAccountNavBarDisplayed() , "Account Page NavBar is Not Working As Expected" );
        Assert.assertTrue(headerpage.isSerachNavBarDisplayed(),    "Search Button Navbar is Not Working As Expected");

    }

    @Test(priority = 3)
    public void checkTheNavigationFunctionalities(){
        headerpage.LoginToApplication("rahul","rahul@2021");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

        // Home Header Section
        WebElement homeLink = driver.findElement(By.xpath("//a[contains(text(), 'Home')]"));
        homeLink.click();
        String homePage = driver.getCurrentUrl();
        Assert.assertEquals(homePage,"https://qamoviesapp.ccbp.tech/","Not Navigated to Home Page");

        // Popular Header Section
        WebElement popularHeaderSection = driver.findElement(By.xpath("//a[contains(text(), 'Popular')]"));
        popularHeaderSection.click();
        String popularPage = driver.getCurrentUrl();
        Assert.assertEquals(popularPage,"https://qamoviesapp.ccbp.tech/popular","Not Navigated to Popular Page");

        // Search Header Section
        WebElement searchHeaderSection =  driver.findElement(By.className("search-empty-button"));
        searchHeaderSection.click();
        String searchPage = driver.getCurrentUrl();
        Assert.assertEquals(searchPage,"https://qamoviesapp.ccbp.tech/search","Not Navigated to Search Page");

        // Account Header Section
        WebElement accountHeaderSection = driver.findElement(By.className("avatar-button"));
        accountHeaderSection.click();
        String accountPage = driver.getCurrentUrl();
        Assert.assertEquals(accountPage,"https://qamoviesapp.ccbp.tech/account","Not Navigated to Search Page");

    }
}
