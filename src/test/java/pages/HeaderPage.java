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
    By websiteLogp = By.className("website-logo");

    public HeaderPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }


    public void clickLoginButton(){ driver.findElement(LoginButton).click(); }
    public void enterUsername(String username){
        driver.findElement(USERNAME).sendKeys(username);
    }
    public void enterPassword(String password){
        driver.findElement(PASSWORD).sendKeys(password);
    }

    public boolean isLogoElementLocated(){
        return driver.findElement(websiteLogp).isDisplayed();
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



}