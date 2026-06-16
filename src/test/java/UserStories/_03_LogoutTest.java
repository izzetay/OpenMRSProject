package UserStories;

import Pages.HomePage;
import Pages.LoginPage;
import Utility.BaseDriver;
import lombok.extern.flogger.Flogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _03_LogoutTest extends BaseDriver {

    LoginPage LoginPage;

    private static final Logger logger = LogManager.getLogger(_03_LogoutTest.class);

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://openmrs.org/demo/");

        driver.findElement(By.cssSelector("div[class='wp-block-button is-style-outline is-style-outline--2']")).click();

        new Actions(driver).scrollByAmount(0, 1000).build().perform();

        driver.findElement(By.xpath("//a[text()=\"Explore OpenMRS 2\"]")).click();

        LoginPage = new LoginPage(driver, wait);

    }

    @Parameters({"username","password"})
    @Test
    public void validLogin(){
        LoginPage.login("admin", "Admin123");

        HomePage HomePage = new HomePage(driver,wait);
    }

    //Logout Test
    @Test(groups = "smoke, logout", dependsOnMethods = {"validLogin"})
    public void logoutTest(){
        LoginPage.logout();
        logger.info("User has been signed out");

    }
}
