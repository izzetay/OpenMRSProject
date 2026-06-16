package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.List;

public class PatientRecordPage {
    WebDriver driver;
    WebDriverWait wait;

    public PatientRecordPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[class='btn btn-default btn-lg button app big align-self-center']")
    public WebElement patientInfoButton;

    @FindBy(id = "patient-search")
    public WebElement searchButton;

    @FindBy(xpath = "//td[text()='100DAV']")
    public WebElement recordedPatient;

    @FindBy(css = "div[class='info-body']")
    public WebElement patientInfoBody;

    @FindBy(css = "div[class='info-header']")
    public WebElement patientInfoHeader;

    @FindBy(className = "dataTables_empty")
    public WebElement noMatchAllert;

    @FindBy(xpath = "//*[normalize-space()='Delete Patient']")
    public WebElement deletePatientButton;

    @FindBy(id = "delete-reason")
    public WebElement deleteReason;

    @FindBy(xpath = "(//button)[18]")
    public WebElement confirmButton;

    @FindBy(css = "span[class='recent-lozenge']")
    public WebElement patientCount;

    @FindBy(id = "patient-search-results-table_info")
    public WebElement patientCountInfo;

    @FindBy(id = "patient-search")
    public WebElement patientSearch;

    public void searchRecordedPatient() {
        searchButton.sendKeys("100DAV");
        recordedPatient.click();
    }

    public void printPatientInfo(){
        List<WebElement> infoHeader =
                driver.findElements(By.cssSelector("div[class='info-header']"));
        List<WebElement> infoBody =
                driver.findElements(By.cssSelector("div[class='info-body']"));

        for (int i = 1; i < infoBody.size(); i+=11){
            System.out.println("DIAGNOSES: " + infoBody.get(i).getText());
            System.out.println("RECENT VISITS: " + infoBody.get(i+6).getText());

            }
        }

        public void compareNumbers(){

            String text = driver.findElement(By.id("patient-search-results-table_info")).getText();
            String[] parts = text.split(" ");
            int expectedCount = Integer.parseInt(parts[3]);
            System.out.println(expectedCount);

            List<WebElement> patientsCount = driver.findElements(By.cssSelector("tr[class='odd']"));
            int displayedCount = patientsCount.size();
            List<WebElement> patientCount2 = driver.findElements(By.cssSelector("tr[class='even']"));
            int displayedCount2 = patientCount2.size();
            int displayedTotalCount = displayedCount + displayedCount2;

            System.out.println(displayedTotalCount);

            Assert.assertEquals(displayedTotalCount,expectedCount,"Results does not match");

        }
    }






