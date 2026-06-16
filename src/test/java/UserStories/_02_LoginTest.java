package UserStories;

import Pages.HomePage;
import Pages.LoginPage;
import Utility.BaseDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _02_LoginTest  extends BaseDriver {

    LoginPage LoginPage;
    HomePage HomePage;

    private static final Logger logger = LogManager.getLogger(_02_LoginTest.class);

    @BeforeMethod
    public void beforeMethod(){
        driver.get("https://openmrs.org/demo/");
        logger.info("Website is opened");
    }

    @Test(groups = "smoke,login")
    public void validLoginTest() {
        HomePage = new HomePage(driver, wait);
        LoginPage = new LoginPage(driver,wait);

        LoginPage.login("admin", "Admin123");
        logger.info("Right e-mail and password used");

        HomePage.isUserLoggedIn();

    }
}
