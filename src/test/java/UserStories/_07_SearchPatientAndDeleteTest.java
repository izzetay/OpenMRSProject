package UserStories;

import Pages.PatientRecordPage;
import Pages.LoginPage;
import Utility.BaseDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _07_SearchPatientAndDeleteTest extends BaseDriver {

    LoginPage LoginPage;
    PatientRecordPage PatientRecordPage;
    private static final Logger logger = LogManager.getLogger(_07_SearchPatientAndDeleteTest.class);


    @BeforeMethod
    public void setup() {
        driver.get("https://openmrs.org/demo/");
        LoginPage = new LoginPage(driver, wait);
    }
    @Test(groups = "smoke, patientManagement")
    public void SearchandDelete() {
        LoginPage.login("admin", "Admin123");
        logger.info("User has been logged in succesfully");
        PatientRecordPage = new PatientRecordPage(driver, wait);
        PatientRecordPage.patientInfoButton.click();
        PatientRecordPage.searchRecordedPatient();
        PatientRecordPage.deletePatientButton.click();
        PatientRecordPage.deleteReason.sendKeys("Patient has been discharged");
        PatientRecordPage.confirmButton.click();
        logger.info("Patient has been deleted from the system records");
    }
}
