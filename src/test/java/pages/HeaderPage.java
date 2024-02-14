package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class HeaderPage {
    WebDriver driver;


    By LoginButton=By.className("login-button");
    By USERNAME=By.id("usernameInput");
    By PASSWORD=By.id("passwordInput");


    By HomeNavBar=By.linkText("Home");
    By PopularNavBar=By.linkText("Popular");
    By AccountNavBar = By.className("avatar-button");
    By websiteLogo = By.className("website-logo");

    public HeaderPage(WebDriver driver) {
        this.driver=driver;
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


    public void LoginToApplication(String username , String password){
        driver.findElement(USERNAME).sendKeys(username);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LoginButton).click();
    }


}