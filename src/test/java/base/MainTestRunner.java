package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.EnvironmentSelector;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MainTestRunner {

    static WebDriver ChromeDriver;
    static DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    static Date date = new Date();
    public static String CurrentTestTime = formatter.format(date);
    static String downloadDir = "/Users/mohamedelgendy/Downloads";

    static File passwordFile = new File("src/main/resources/createdUserPassword.txt");

    static DateFormat myFormat;

    @BeforeTest
    public void InitializePortalTest()
    {
        //System.setProperty("webdriver.chrome.driver","src/main/java/utiles/chromedriver.exe");

        Map<String, Object> chromePrefs = new HashMap<String, Object>();

        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.setExperimentalOption("prefs", chromePrefs);
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--start-maximized");
        //chromeOptions.addArguments("--headless=new");
        chromePrefs.put("download.prompt_for_download", false);

        ChromeDriver = new ChromeDriver(chromeOptions);

        //CurrentTestTime = formatter.format(date);

        /////////////////IMPORTANT/////////////////
        //Set Environment
        EnvironmentSelector.SetEnvironment("DEV"); //"DEV" OR "TEST"

        //Launch
        ChromeDriver.navigate().to(utils.EnvironmentSelector.PortaMainlUrl);
        //ChromeDriver.manage().window().maximize();
    }


    @AfterTest
    public void EndPortalTest()
    {
        //ChromeDriver.quit();
    }
}

