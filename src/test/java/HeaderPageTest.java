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
        headerpage.enterUsername("rahul");
        headerpage.enterPassword("rahul@2021");
        headerpage.clickLoginButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        Assert.assertTrue(headerpage.isLogoElementLocated() ,"Logo Element Not Found");
    }

    @Test(priority=2)
    public void checkTheNavBars() {
        headerpage.enterUsername("rahul");
        headerpage.enterPassword("rahul@2021");
        headerpage.clickLoginButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        Assert.assertTrue(headerpage.isHomeNavbarDisplayed() , "Home Page NavBar is Not Working As Expected" );
        Assert.assertTrue(headerpage.isPopularNavBarDisplayed(), "Popular Page NavBar is Not Working As Expected" );
        Assert.assertTrue(headerpage.isAccountNavBarDisplayed() , "Account Page NavBar is Not Working As Expected" );

    }


}