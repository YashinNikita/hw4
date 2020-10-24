package hw4;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] saveScreenShotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("I am in onTestFailure method " + getTestMethodName(result) + " failed");
        Object driver = result.getTestContext().getAttribute("driver");
        if (driver instanceof WebDriver) {
            System.out.println("Screenshot for test case:" + getTestMethodName(result));
            saveScreenShotPNG((WebDriver) driver);
        }
    }
}

