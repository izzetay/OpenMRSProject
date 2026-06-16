package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
    private static ExtentReports extent;
    private static ExtentTest test;

    public static ExtentReports createInstance() {
        // Türkçe locale bug'ını çözmek için
        java.util.Locale.setDefault(java.util.Locale.ENGLISH);

        // Dinamik dosya adı: reports/TestReport_2026-05-26_16-38-26.html
        String timestamp = new java.text.SimpleDateFormat("yyyy-MM-ddHH-mm-ss").format(new java.util.Date());
        String reportPath = "reports/TestReport" + timestamp + ".html";

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);

        // Rapor görünüm ayarları
        sparkReporter.config().setDocumentTitle("Test Otomasyon Raporu");
        sparkReporter.config().setReportName("TestNG Training - Test Sonuçları");
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setEncoding("UTF-8");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Raporda görünecek sistem bilgileri
        extent.setSystemInfo("İşletim Sistemi", System.getProperty("os.name"));
        extent.setSystemInfo("Java Versiyonu", System.getProperty("java.version"));
        extent.setSystemInfo("Tester", "Izzet");
        extent.setSystemInfo("Browser(s)", "Chrome");

        return extent;
    }

    public static ExtentReports getInstance() {
        if (extent == null) {
            createInstance();
        }
        return extent;
    }
}

