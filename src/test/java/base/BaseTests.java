package base;

import data.DataModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import reader.ReadDataFromJson;
import utils.ScreenRecorderUtil;
import utils.UtilsTests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTests {

    RemoteWebDriver remoteWebDriver;
    DesiredCapabilities desiredCapabilities;

    URL url;
    protected WebDriver driver;
    protected ReadDataFromJson readDataFromJson;
    protected HomePage homePage;

    ChromeOptions chromeOptions;
    FirefoxOptions firefoxOptions;
    UtilsTests utilsTests;

    @Parameters("browser")
    @BeforeClass
    public void setUp(String browser) throws MalformedURLException {
        setUpBrowser(browser);
        driver.manage().window().maximize();
        homePage = new HomePage((ChromeDriver) driver);

    }

    @BeforeMethod
    public void goHome(Method method) throws Exception {
        driver.get(dataModel().URL);
        ScreenRecorderUtil.startRecord(method.getName());
    }

    @AfterMethod
    public void afterMethod(Method method, ITestResult result) throws Exception {
        utilsTests = new UtilsTests(driver);
        utilsTests.takeScreenShot(method);
        ScreenRecorderUtil.stopRecord();
        utilsTests.setStatus(method, result);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    protected DataModel dataModel() throws FileNotFoundException {
        readDataFromJson = new ReadDataFromJson();
        return readDataFromJson.readJson();
    }

    @Parameters("browser")
    public void setUpBrowser(String browser) throws MalformedURLException {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("headlessChrome")) {
            chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            driver = new ChromeDriver(chromeOptions);
        } else if (browser.equalsIgnoreCase("FIREFOX")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("headlessfirefox")) {
            firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--headless");
            driver = new FirefoxDriver(firefoxOptions);
        }
        else if (browser.equalsIgnoreCase("dockerChrome")) {
            desiredCapabilities = new DesiredCapabilities();
            chromeOptions = new ChromeOptions();
            chromeOptions.setCapability(ChromeOptions.CAPABILITY,chromeOptions);
            url = new URL("http://localhost:4444/wd/hub");
            remoteWebDriver = new RemoteWebDriver(url,desiredCapabilities);
        }

    }

    @BeforeSuite
    public void beforeSuite() {
        utilsTests = new UtilsTests(driver);
        utilsTests.createReport();
    }

    @AfterSuite
    public void afterSuite() {
        utilsTests = new UtilsTests(driver);
        utilsTests.flushReport();
    }
}
