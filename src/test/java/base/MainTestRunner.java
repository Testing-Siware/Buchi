package base;

import com.beust.ah.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.Actions;
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
    public static String  downloadDir = System.getProperty("user.home") + "\\Downloads";
    public static Actions actions;

    static File passwordFile = new File("src/main/resources/createdUserPassword.txt");

    static DateFormat myFormat;

    @BeforeTest
    static public void InitializePortalTest()
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

        actions=new Actions((org.openqa.selenium.chrome.ChromeDriver) ChromeDriver,20);

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

