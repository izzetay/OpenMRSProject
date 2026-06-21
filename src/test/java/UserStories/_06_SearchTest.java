package UserStories;

import Pages.PatientRecordPage;
import Pages.LoginPage;
import Utility.BaseDriver;
import lombok.extern.flogger.Flogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _06_SearchTest extends BaseDriver {

    LoginPage LoginPage;
    PatientRecordPage FindPatientRecordPage;

    private static final Logger logger = LogManager.getLogger(_06_SearchTest.class);


    @BeforeMethod
    public void setup() {
        driver.get("https://openmrs.org/demo/");
        LoginPage = new LoginPage(driver, wait);
    }
    @Test(groups = "patientManagement")
    public void SearchTest(){
        LoginPage.login("admin","Admin123");
        logger.info("User has been logged in succesfully");
        FindPatientRecordPage = new PatientRecordPage(driver,wait);
        FindPatientRecordPage.patientInfoButton.click();
        FindPatientRecordPage.searchRecordedPatient("100J8U");
        FindPatientRecordPage.printDiagnoses();
        FindPatientRecordPage.printVitals();
        FindPatientRecordPage.printRecentVisits();
        FindPatientRecordPage.printFamilyPanel();
        FindPatientRecordPage.printConditionsPanel();
        FindPatientRecordPage.printAttachmentsPanel();
        FindPatientRecordPage.printAllergiesPanel();
        logger.info("Patient record is printed");

    }
}
