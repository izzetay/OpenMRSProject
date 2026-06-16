package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

    public class ExtentTestNGListener implements ITestListener {

        private ExtentReports extent = ExtentReportManager.getInstance();
        private ThreadLocal<ExtentTest> test = new ThreadLocal<>();

        @Override
        public void onTestStart(ITestResult result) {
            // Her test başladığında rapora bir entry oluştur
            ExtentTest extentTest = extent.createTest(
                    result.getMethod().getMethodName(),
                    result.getMethod().getDescription()
            );

            // Test parametrelerinden browser bilgisini al
            Object[] parameters = result.getParameters();
            if (parameters != null && parameters.length > 0) {
                extentTest.assignCategory(parameters[0].toString());
            }
            test.set(extentTest);
        }

        @Override
        public void onTestSuccess(ITestResult result) {
            test.get().log(Status.PASS, "Test BAŞARILI geçti");
        }

        @Override
        public void onTestFailure(ITestResult result) {
            test.get().log(Status.FAIL, "Test BAŞARISIZ: " + result.getThrowable().getMessage());
            // İstersen buraya screenshot ekleme kodu da yazabilirsin
        }

        @Override
        public void onTestSkipped(ITestResult result) {
            test.get().log(Status.SKIP, "Test ATLANDI: " + result.getThrowable().getMessage());
        }

        @Override
        public void onFinish(ITestContext context) {
            // Tüm testler bittiğinde raporu diske yaz
            extent.flush();
        }
    }

