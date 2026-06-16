package UserStories;

import Pages.LoginPage;
import Pages.ProfilePage;
import Pages.registerPage;
import Utility.BaseDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class _09_PatientRecordMergeTest extends BaseDriver {

    LoginPage LoginPage;
    registerPage registerPage;
    ProfilePage ProfilePage;
    private List<String> patientIds = new ArrayList<>();
    private static final Logger logger = LogManager.getLogger(_09_PatientRecordMergeTest.class);

    @Test
    public void registerPatient1() {
        driver.get("https://openmrs.org/demo/");
        LoginPage = new LoginPage(driver, wait);
        registerPage = new registerPage(driver, wait);
        LoginPage.login("admin", "Admin123");
        registerPage.registerPatient("Anvil", "Javanier");
        registerPage.registerPatientGender("female");
        registerPage.regigerPatientBirthdate("11", "1999");
        registerPage.registerPatientAddress("123 Test Avenue", "Springfield", "IL", "USA", "62701");
        registerPage.registerPatientPhone("+1 (555) 010-4829");
        registerPage.registerPatientRelated("parent", "Michale");
        patientIds.add(registerPage.patientID.getText());
        logger.info("Patient registered succesfully");

    }

    @Test(dependsOnMethods = "registerPatient1")
    public void registerPatient2() {
        registerPage = new registerPage(driver, wait);
        registerPage.homeButton.click();
        registerPage.registerPatient("Paul", "Kodak");
        registerPage.registerPatientGender("male");
        registerPage.regigerPatientBirthdate("23", "1987");
        registerPage.registerPatientAddress("144 Test Ave", "Springfield", "TX", "USA", "62701");
        registerPage.registerPatientPhone("+1 (555) 123-4444");
        registerPage.registerPatientRelated("doctor", "Georce");
        patientIds.add(registerPage.patientID.getText());
        logger.info("Patient registered succesfully");

    }

    @Test(dependsOnMethods = {"registerPatient1","registerPatient2"})
    public void mergePatient() {
        ProfilePage = new ProfilePage(driver, wait);
        registerPage.homeButton.click();
        ProfilePage.dataManagementButton.click();
        ProfilePage.mergePatientButton.click();
        ProfilePage.mergePatient1.sendKeys(patientIds.get(0));
        ProfilePage.mergePatient2.sendKeys(patientIds.get(1));
        ProfilePage.wrapper.click();
        ProfilePage.confirmButton.click();
        ProfilePage.mergeMSG();
        ProfilePage.selectPatient1.click();
        ProfilePage.confirmButton.click();
        logger.info("Patients merged succesfully");
    }
}

