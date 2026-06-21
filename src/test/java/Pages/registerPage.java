package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class registerPage {

    WebDriver driver;
    WebDriverWait wait;

    public registerPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[contains(@id,\"registerPatient\")]")
    public WebElement registerPatientButton;

    @FindBy(xpath = "//input[@name='givenName']")
    public WebElement patientName;

    @FindBy(xpath= "//input[@name='familyName']")
    public WebElement patientLastname;

    @FindBy(id = "next-button")
    public WebElement  nextButton;

    @FindBy(css = "option[value='M']")
    public WebElement genderMale;

    @FindBy(css = "option[value='F']")
    public WebElement genderFemale;

    @FindBy(id = "birthdateDay-field")
    public WebElement birthDateDay;

    @FindBy(id = "birthdateMonth-field")
    public WebElement birthMonthMenuDropdown;

    @FindBy(css = "option[value='3']")
    public WebElement birthMonthSelect;

    @FindBy(id = "birthdateYear-field")
    public WebElement birthDateYear;

    @FindBy(id = "address1")
    public WebElement addressLine1;

    @FindBy(id = "cityVillage")
    public WebElement cityInput;

    @FindBy(id = "stateProvince")
    public WebElement stateInput;

    @FindBy(id = "country")
    public WebElement countryInput;

    @FindBy(id = "postalCode")
    public WebElement postalCodeInput;

    @FindBy(xpath = "//input[@name='phoneNumber']")
    public WebElement phoneNumberInput;

    @FindBy(css = "option[data-val='Doctor']")
    public WebElement relatedSelectDoctor;

    @FindBy(css = "option[data-val='Sibling']")
    public WebElement relatedSelectSibling;

    @FindBy(css = "option[data-val='Parent']")
    public WebElement relatedSelectParent;

    @FindBy(css = "option[data-val='Aunt/Uncle']")
    public WebElement relatedSelectAuntUncle;

    @FindBy(css = "option[data-val='Supervisor']")
    public WebElement relatedSelectSupervisor;

    @FindBy(css = "option[data-val='Patient']")
    public WebElement relatedSelectPatient;

    @FindBy(css = "option[data-val='Child']")
    public WebElement relatedSelectChild;

    @FindBy(css = "option[data-val='Niece/Nephew']")
    public WebElement relatedSelectNieceNephew;

    @FindBy(css = "option[data-val='Supervisee']")
    public WebElement relatedSelectSupervisee;

    @FindBy(css = "input[placeholder='Person Name']")
    public WebElement relatedPersonNameInput;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(xpath = "//em[contains(text(),'Patient ID')]/following-sibling::span")
    public WebElement patientID;

    @FindBy(css = "i[class='icon-home small']")
    public WebElement homeButton;

    public void registerPatient(String name,String lastName){
        wait.until(ExpectedConditions.elementToBeClickable(registerPatientButton));
        registerPatientButton.click();
        patientName.sendKeys(name);
        patientLastname.sendKeys(lastName);
        nextButton.click();
    }

    public void registerPatientGender(String gender) {
        if (gender.equals("male")) {
            genderMale.click();
        } else if (gender.equals("female")) {
            genderFemale.click();
        }
        nextButton.click();
    }

    public void regigerPatientBirthdate(String day,String year){
        birthDateDay.sendKeys(day);
        birthMonthMenuDropdown.click();
        birthMonthSelect.click();
        birthDateYear.sendKeys(year);
        nextButton.click();
    }
    public void registerPatientAddress(String adresLine1,String city,String state,String country,String postalCode){
        addressLine1.sendKeys(adresLine1);
        cityInput.sendKeys(city);
        stateInput.sendKeys(state);
        countryInput.sendKeys(country);
        postalCodeInput.sendKeys(postalCode);
        nextButton.click();
    }
    public void registerPatientPhone(String phone){
        phoneNumberInput.sendKeys(phone);
        nextButton.click();
    }
    public void registerPatientRelated(String related,String relatedName){

        switch (related.toLowerCase()){
            case "doctor": relatedSelectDoctor.click(); break;
            case "sibling": relatedSelectSibling.click(); break;
            case "parent": relatedSelectParent.click(); break;
            case "aunt": relatedSelectAuntUncle.click(); break;
            case "uncle": relatedSelectAuntUncle.click(); break;
            case "supervisor": relatedSelectSupervisor.click(); break;
            case "patient": relatedSelectPatient.click(); break;
            case "child": relatedSelectChild.click(); break;
            case "niece": relatedSelectNieceNephew.click(); break;
            case "nephew": relatedSelectNieceNephew.click(); break;
            case "supervisee": relatedSelectSupervisee.click(); break;
        }
        relatedPersonNameInput.sendKeys(relatedName);

        nextButton.click();
        submitButton.click();
    }

}

