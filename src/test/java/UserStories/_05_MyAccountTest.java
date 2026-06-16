package UserStories;

import Pages.LoginPage;
import Pages.ProfilePage;
import Utility.BaseDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _05_MyAccountTest extends BaseDriver {
    LoginPage LoginPage;
    ProfilePage profilePage;

    private static final Logger logger = LogManager.getLogger(_05_MyAccountTest.class);


    @BeforeMethod
    public void setup(){
        driver.get("https://openmrs.org/demo/");
        LoginPage = new LoginPage(driver, wait);
        profilePage = new ProfilePage(driver, wait);
    }
    @Test(groups = "smoke")
    public void myAccount(){

        LoginPage.login("admin","Admin123");
        logger.info("User has been logged in succesfully");
        profilePage.openMyAccount();

    }
}
