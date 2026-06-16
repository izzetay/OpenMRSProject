package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public boolean isUserLoggedIn() {
        boolean isDisplayed = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("a[href='/openmrs/appui/header/logout.action?successUrl=openmrs']"))).isDisplayed();

        Assert.assertTrue(isDisplayed, "User login failed");

        Reporter.log("User is logged in successfully", true);

        return true;
    }
}
