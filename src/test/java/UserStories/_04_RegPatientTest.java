package UserStories;

import Pages.LoginPage;
import Pages.PatientRecordPage;
import Pages.ProfilePage;
import Pages.registerPage;
import Utility.BaseDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _04_RegPatientTest extends BaseDriver {
    LoginPage LoginPage;
    registerPage registerPage;
    private static final Logger logger = LogManager.getLogger(_04_RegPatientTest.class);


    @BeforeMethod
    public void setup() {
        driver.get("https://openmrs.org/demo/");
        LoginPage = new LoginPage(driver, wait);
        registerPage = new registerPage(driver,wait);
    }

    @Test(priority = 3)
    public void PatientRegister(){
        LoginPage.login("admin","Admin123");

        registerPage.registerPatient("tester " , "test");
        registerPage.registerPatientGender("male");
        registerPage.regigerPatientBirthdate("11","1999");
        registerPage.registerPatientAddress("123 Test Avenue","Springfield","IL","USA","62701");
        registerPage.registerPatientPhone("+1 (555) 010-4829");
        registerPage.registerPatientRelated("parent","Michale");
        logger.info("Patient registered succesfully");

    }
}
