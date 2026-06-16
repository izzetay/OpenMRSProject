package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage  {
    WebDriver driver;
    WebDriverWait wait;

    public ProfilePage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//li[@class='nav-item identifier']")
    public WebElement profileButtonHover;

    @FindBy(css = "a[href='/openmrs/adminui/myaccount/myAccount.page']")
    public WebElement myAccountButton;

    @FindBy(css = "a[href='/openmrs//appointmentschedulingui/home.page']")
    public WebElement appointmentScheduleButton;

    @FindBy(xpath = "//a[contains(@id,\"manageAppointments\")]")
    public WebElement manageAppointmentsButton;

    @FindBy(xpath = "//a[contains(@id,\"datamanagement\")]")
    public WebElement dataManagementButton;

    @FindBy(xpath = "//a[contains(@id,\"mergePatientsHomepageLink\")]")
    public WebElement mergePatientButton;

    @FindBy(id = "patient1-text")
    public WebElement mergePatient1;

    @FindBy(id = "patient2-text")
    public WebElement mergePatient2;

    @FindBy(id = "confirm-button")
    public WebElement confirmButton;

    @FindBy(xpath = "(//div[@class='messages-container'])[2]")
    public WebElement mergeMessage;

    @FindBy(id = "first-patient")
    public WebElement selectPatient1;

    @FindBy(id = "body-wrapper")
    public WebElement wrapper;

    public void openMyAccount(){
        profileButtonHover.click();
        myAccountButton.click();
    }

    public void goToAppointment(){
        appointmentScheduleButton.click();
        manageAppointmentsButton.click();
    }

    public void printTimeZoneWarning(){
       String warning = driver.findElement(By.id("time-zone-warning")).getText();
       System.out.println(warning);
    }

    public void mergeMSG(){
        new Actions(driver).scrollByAmount(0, 1000).build().perform();
        mergeMessage.getText();
    }
}
