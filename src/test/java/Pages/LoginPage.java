package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "username")
    public WebElement usernameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id = "loginButton")
    public WebElement loginButton;

    @FindBy(xpath = "//li[text()='Isolation Ward']")
    public WebElement isolationWard;

    public void enterUserName(String username){
        driver.findElement(By.id("username")).sendKeys("admin");
    }
    public void enterPassword(String password){
        driver.findElement(By.id("password")).sendKeys("Admin123");
    }
    public void selectLocation(){
        driver.findElement(By.xpath("//li[text()='Isolation Ward']")).click();
    }

    public void loginTester(String username,String password) {

        driver.findElement(By.cssSelector("div[class='wp-block-button is-style-outline is-style-outline--2']")).click();
        new Actions(driver).scrollByAmount(0, 1000).build().perform();
        driver.findElement(By.xpath("//a[text()=\"Explore OpenMRS 2\"]")).click();
        usernameInput.sendKeys("test");
        passwordInput.sendKeys("Tester123");
        selectLocation();
        loginButton.click();
    }

    public void login (String username,String password){
        driver.findElement(By.cssSelector("div[class='wp-block-button is-style-outline is-style-outline--2']")).click();
        new Actions(driver).scrollByAmount(0, 1000).build().perform();
        driver.findElement(By.xpath("//a[text()=\"Explore OpenMRS 2\"]")).click();
        enterUserName(username);
        enterPassword(password);
        selectLocation();
        loginButton.click();
    }
    public void logout(){

        WebElement logoutButton = driver.findElement(By.cssSelector("a[href='/openmrs/appui/header/logout.action?successUrl=openmrs']"));
        logoutButton.click();
    }

    public void verifyLocationError(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='location-error']")));
        WebElement locationError = driver.findElement(By.cssSelector("span[class='location-error']"));
        System.out.println(locationError);

    }
    public void verifyLoginError(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#error-message")));
        WebElement passwordError = driver.findElement(By.cssSelector("div#error-message"));
        System.out.println(passwordError);
    }

}
