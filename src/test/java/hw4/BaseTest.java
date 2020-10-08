package hw4;

import hw.base.DataHW;
import hw.pages.ex1.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class BaseTest {

    protected WebDriver driver;
    protected HomePage homePage;
    protected DataHW dataHW;
    protected Properties properties;

    private final String jasonDataPath = "src/test/resources/config/dataForHW.json";
    private final String configDataPath = "src/test/resources/config/config.properties";

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        try {
            dataHW = DataHW.get(jasonDataPath);
            properties = new Properties();
            FileInputStream ip = new FileInputStream(configDataPath);
            properties.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //17 Close Browser
    @AfterClass
    public void tearDownClass() {
        if (driver != null) {
            driver.quit();
        }

    }

    public void compareStrings(String actual, String expected) {
        Assert.assertEquals(actual, expected);
    }

    public void compareQuantity(int actual, int expected) {
        Assert.assertEquals(actual, expected);
    }

    public void expectTrue(boolean actual) {
        Assert.assertTrue(actual);
    }

    public void compareListStrings(List actual, List expected) {
        Assert.assertEquals(actual, expected);
    }

    public WebDriver getDriver() {
        return driver;
    }

}
