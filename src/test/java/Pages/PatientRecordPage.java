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

    public void searchRecordedPatient(String patientID) {
        searchButton.sendKeys(patientID);
        recordedPatient.click();
    }

    public void printDiagnoses(){
        System.out.println("=========DIAGNOSES=========");
        WebElement diagnosesPanel = driver.findElement(By.id("coreapps-diagnosesList"));
        System.out.println(diagnosesPanel.getText());
    }

    public void printLtestOperationts(){
        System.out.println("=========OPERATIONS=========");
        WebElement operationsPanel = driver.findElement(By.xpath("//h3[contains(text(),'DIAGNOSES')]"));
        System.out.println(operationsPanel.getText());
    }

    public void printVitals(){
        System.out.println("=========VITALS=========");
        WebElement vitalsPanel = driver.findElement(By.id("vitals"));
        System.out.println(vitalsPanel.getText());
    }

    public void printRecentVisits(){
        System.out.println("=========VISITS=========");
        WebElement recentVisitPanel = driver.findElement(By.xpath("//h3[contains(text(),'RECENT VISITS')]"));
        System.out.println(recentVisitPanel.getText());
    }

    public void printFamilyPanel(){
        System.out.println("=========FAMILY=========");
        WebElement familyPanel = driver.findElement(By.xpath("//h3[contains(text(),'FAMILY')]"));
        System.out.println(familyPanel.getText());
    }

    public void printConditionsPanel(){
        System.out.println("=========CONDITIONS=========");
        WebElement conditionsPanel = driver.findElement(By.xpath("//h3[contains(text(),'CONDITIONS')]"));
        System.out.println(conditionsPanel.getText());
    }

    public void printAttachmentsPanel() {
        System.out.println("=========ATTACHMENTS=========");
        WebElement attechmentPanel = driver.findElement(By.xpath("//h3[contains(text(),'ATTACHMENTS')]"));
        System.out.println(attechmentPanel.getText());
    }

    public void printAllergiesPanel() {
        System.out.println("=========ALLERGIES=========");
        WebElement allergiesPanel = driver.findElement(By.xpath("//h3[contains(text(),'ALLERGIES')]"));
        System.out.println(allergiesPanel.getText());
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






