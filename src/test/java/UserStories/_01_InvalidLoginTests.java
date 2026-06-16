package UserStories;

import Pages.HomePage;
import Pages.LoginPage;
import Utility.BaseDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _01_InvalidLoginTests extends BaseDriver {

    LoginPage LoginPage;

    private static final Logger logger = LogManager.getLogger(_01_InvalidLoginTests.class);

    @BeforeMethod
    public void beforeMethod(){
        driver.get("https://openmrs.org/demo/");
        logger.info("Websitesine giris yapildi");
    }

    //Gecersiz login
    @Test(groups = "smoke, login", priority = 1)
    public void invalidLoginWithoutLocation(){
        LoginPage = new LoginPage(driver,wait);
        LoginPage.loginTester("tester","tester123");
        LoginPage.loginButton.click();
        LoginPage.verifyLocationError();
        logger.error("Negatif login gerceklesti");
    }

    //Gecersiz login
    @Test(groups = "smoke, login", priority = 2)
    public void invalidLoginWithLocation(){
        LoginPage = new LoginPage(driver,wait);
        LoginPage.loginTester("tester","tester123");
        LoginPage.isolationWard.click();
        LoginPage.loginButton.click();
        LoginPage.verifyLoginError();
        logger.error("Negatif login  gerceklesti");
    }

    //Basarili Login
    @Test(groups = "smoke, login", priority = 3)
    public void validLogin(){
        LoginPage.login("admin","Admin123");
        logger.info("Dogru e-mail ve sifre girildi");
        HomePage HomePage = new HomePage(driver,wait);

        HomePage.isUserLoggedIn();

    }
}
