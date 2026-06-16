package UserStories;

import Pages.LoginPage;
import Pages.PatientRecordPage;
import Pages.ProfilePage;
import Utility.BaseDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _10_AppointmentTest extends BaseDriver {

    LoginPage LoginPage;
    ProfilePage ProfilePage;
    PatientRecordPage PatientRecordPage;
    private static final Logger logger = LogManager.getLogger(_08_ListPatientsTest.class);


    @BeforeMethod
    public void setup() {
        driver.get("https://openmrs.org/demo/");
        LoginPage = new LoginPage(driver, wait);
        ProfilePage = new ProfilePage(driver,wait);
        PatientRecordPage = new PatientRecordPage(driver,wait);
    }

    @Test(groups = "regression, appointment")
    public void appointmentTest() {
        LoginPage.login("admin","Admin123");
        logger.info("User has been logged in succesfully");
        ProfilePage.goToAppointment();
        PatientRecordPage.searchButton.sendKeys("DA");
        PatientRecordPage.recordedPatient.click();
        ProfilePage.printTimeZoneWarning();
        logger.error("User cant get an appointment due to time zone being wrong");
    }
}
