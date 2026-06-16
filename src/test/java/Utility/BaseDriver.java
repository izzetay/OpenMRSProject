package Utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseDriver {

    public WebDriver driver;
    public WebDriverWait wait;
    public JavascriptExecutor js;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Driver Çalıştı.");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        js = (JavascriptExecutor) driver;
    }
    @AfterClass(alwaysRun = true)
    public void finalOperations() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
        System.out.println("Driver kapatıldı.");
    }

}
