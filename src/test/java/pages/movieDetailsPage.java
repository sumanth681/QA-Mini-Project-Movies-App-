package pages;
import org.openqa.selenium.By;
import java.time.Duration;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
public class movieDetailsPage {
    public WebDriver driver;
    public WebDriverWait  wait;

    By LoginButton=By.className("login-button");
    By USERNAME=By.id("usernameInput");
    By PASSWORD=By.id("passwordInput");

    By HomeNavBar=By.linkText("Home");
    By PopularNavBar=By.linkText("Popular");
    By AccountNavBar = By.className("avatar-button");
    By websiteLogo = By.className("website-logo");
    By movieTitle = By.className("movie-title");

    By watchTime = By.className("watch-time");
    By sensorRating = By.className("sensor-rating");
    By releaseYear = By.className("release-year");
    By movieOverview = By.className("movie-overview");
    By playButton = By.className("play-button");


    By  genresCategory = By.className("genres-category");
    By genresHeading = By.className("genres-heading");
    By genresParagraphContainer = By.className("genres-container");
    By audioCategory = By.className("audio-category");
    By audioHeading = By.className("audio-heading");
    By audioParagraphListContainer = By.className("audio-container");


    By ratingCategory =  By.className("rating-category");
    By ratingHeading = By.className("rating-heading");
    By categoryParagraph = By.className("category-paragraph");
    By ratingAverageHeading = By.className("rating-average-heading");
    By  ratingParagraph = By.className("category-paragraph");
    By budgetCategory = By.className("budget-category");
    By budgetHeading = By.className("budget-heading");
    By budgetCategoryParagraph = By.className("category-paragraph");
    By releaseDateHeading = By.className("release-date-heading");
    By releaseDateParagraph = By.className("category-paragraph");
    By similarMoviesContainer = By.className("similar-movies-container");
    By similarMoviesHeading = By.className("similar-movies-heading");
    By similarMoviesListContainer = By.className("similar-movies-list-container");
    By footerContainer = By.className("footer-container");
    By footerIconsContainer = By.className("footer-icons-container");

    By googleIcon = By.className("google-icon");
    By twitterIcon = By.className("twitter-icon");
    By instagramIcon = By.className("instagram-icon");
    By youTubeIcon = By.className("youtube-icon");
    By contactUs = By.className("contact-us-paragraph");
    By moreLikeThisMoviesList = By.className("image-style");
    By popularMovieIconItem = By.className("movie-icon-item");

    public movieDetailsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }


    public boolean isLogoElementLocated(){
        return driver.findElement(websiteLogo).isDisplayed();
    }

    public boolean isHomeNavbarDisplayed() {
        return driver.findElement(HomeNavBar).isDisplayed();
    }
    public boolean isPopularNavBarDisplayed(){
        return  driver.findElement(PopularNavBar).isDisplayed();
    }
    public boolean isAccountNavBarDisplayed(){
        return  driver.findElement(AccountNavBar).isDisplayed();
    }
    public  boolean isSerachNavBarDisplayed(){return driver.findElement(AccountNavBar).isDisplayed();}

    public boolean checkTitleDetailsContainer(){
        boolean isAllDisplayed = driver.findElement(movieTitle).isDisplayed() && driver.findElement(watchTime).isDisplayed() && driver.findElement(sensorRating).isDisplayed()  && driver.findElement(releaseYear).isDisplayed() && driver.findElement(movieOverview).isDisplayed() && driver.findElement(playButton).isDisplayed();
        return isAllDisplayed;
    }


    public boolean checkDetailedMovieCategoriesContainer(){

        boolean iSAllDisplayed =

                driver.findElement(genresCategory).isDisplayed() && driver.findElement(genresHeading).isDisplayed() &&
                        driver.findElement(genresParagraphContainer).isDisplayed() && driver.findElement(audioCategory).isDisplayed() &&
                        driver.findElement(audioHeading).isDisplayed() && driver.findElement(audioParagraphListContainer).isDisplayed() &&
                        driver.findElement(ratingCategory).isDisplayed() && driver.findElement(ratingHeading).isDisplayed() &&
                        driver.findElement(categoryParagraph).isDisplayed() && driver.findElement(ratingAverageHeading).isDisplayed() &&
                        driver.findElement(ratingParagraph).isDisplayed() && driver.findElement(budgetCategory).isDisplayed() &&
                        driver.findElement(budgetHeading).isDisplayed() && driver.findElement(budgetCategoryParagraph).isDisplayed() &&
                        driver.findElement(releaseDateHeading).isDisplayed() && driver.findElement(releaseDateParagraph).isDisplayed();

        return  iSAllDisplayed;

    }

    public  boolean similarMoviesContainer(){
        boolean isAllDisplayed = driver.findElement(similarMoviesContainer).isDisplayed() &&
                driver.findElement(similarMoviesHeading).isDisplayed() && driver.findElement(similarMoviesListContainer).isDisplayed();
        return  isAllDisplayed;
    }

    public boolean checkFooterContainer(){
        boolean isAllDisplayed = driver.findElement(footerContainer).isDisplayed() &&  driver.findElement(footerIconsContainer).isDisplayed();
        return isAllDisplayed;
    }
    public boolean checkAllIcons(){
        boolean are_Visible = driver.findElement(googleIcon).isDisplayed() && driver.findElement(twitterIcon).isDisplayed() &&
                driver.findElement(instagramIcon).isDisplayed() &&
                driver.findElement(youTubeIcon).isDisplayed() &&
                driver.findElement(contactUs).isDisplayed() ;
        return are_Visible;
    }

    public boolean checkMoreLikeThisMoviesList(){
        return driver.findElement(moreLikeThisMoviesList).isDisplayed();
    }

    public boolean checkPopularsMovieList(){
        return driver.findElement(popularMovieIconItem).isDisplayed();

    }

    public void LoginToApplication(String username , String password){
        driver.findElement(USERNAME).sendKeys(username);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LoginButton).click();
    }
}