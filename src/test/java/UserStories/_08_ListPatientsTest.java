package UserStories;

import Pages.LoginPage;
import Pages.PatientRecordPage;
import Utility.BaseDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _08_ListPatientsTest extends BaseDriver {

    LoginPage LoginPage;
    PatientRecordPage PatientRecordPage;
    private static final Logger logger = LogManager.getLogger(_08_ListPatientsTest.class);


    @BeforeMethod
    public void setup() {
        driver.get("https://openmrs.org/demo/");
        LoginPage = new LoginPage(driver, wait);
    }
    @Test(groups = "regression,patientManagement")
    public void ListPatients() throws InterruptedException {
        LoginPage.login("admin", "Admin123");
        logger.info("User has been logged in succesfully");
        PatientRecordPage = new PatientRecordPage(driver, wait);
        PatientRecordPage.patientInfoButton.click();
        PatientRecordPage.patientSearch.sendKeys("da");
        Thread.sleep(3000);
        PatientRecordPage.compareNumbers();
        logger.info("Expected and displayed numbers are match");

    }
}
