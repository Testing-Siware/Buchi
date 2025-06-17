package utils;

import data.Credentials;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Random;

public class Helpers {

    public static String FormatDateAndTime(String DT) {
        String NewDateAndTime = DT.replace('/', '-');
        NewDateAndTime = NewDateAndTime.replace(' ', '-');
        NewDateAndTime = NewDateAndTime.replace(':', '-');
        return NewDateAndTime;
    }

    // Method to get the number of files in a directory
    public static int getNumberOfFiles(String directoryPath) {
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            // Get all files and directories inside the given directory
            File[] files = directory.listFiles();

            return files.length;
        }
        return 0; // Return 0 if the directory doesn't exist or has no files
    }

    public static String getLatestDownloadedFile(String directoryPath) {
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles(File::isFile); // Only get files, not directories

            if (files == null || files.length == 0) {
                return null;
            }

            // Sort by last modified date in descending order
            Arrays.sort(files, (f1, f2) -> Long.compare(f2.lastModified(), f1.lastModified()));

            return files[0].getName();
        }
        return null;
    }

    public static String generateRandomString() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            sb.append(randomChar);
        }

        return sb.toString();
    }

    public static String getFile(String fileName) {
        if (System.getProperty("os.name").contains("Windows")) {
            return new File("").getAbsolutePath() + "\\src\\main\\resources\\" + fileName;
        } else {
            return new File("").getAbsolutePath() + "/src/main/resources/" + fileName;
        }

    }

    //Helper logs out from Support
    public void logoutFromUser(String username, String password, ChromeDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.navigate().refresh();

        //expand user
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main-items-header\"]/div/div/div[2]/div/h6")));
        driver.findElement(By.xpath("//*[@id=\"main-items-header\"]/div/div/div[2]/div/h6")).click();

        //click logout
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"user-dropdown\"]/span[1]/a[5]/li")));
        driver.findElement(By.xpath("//*[@id=\"user-dropdown\"]/span[1]/a[5]/li")).click();


        Thread.sleep(4000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("idp-discovery-username")));
        driver.findElement(By.id("idp-discovery-username")).sendKeys(username);

        driver.findElement(By.id("idp-discovery-submit")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okta-signin-password")));
        driver.findElement(By.id("okta-signin-password")).sendKeys(password);

        driver.findElement(By.id("okta-signin-submit")).click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.urlToBe(EnvironmentSelector.OverviewUrl));

    }

    //Helper logs out from Partner User
    public static void logoutPartnerUser(String userName, String password, ChromeDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //expand user
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main-items-header\"]/div/div/div[2]")));
        driver.findElement(By.xpath("//*[@id=\"main-items-header\"]/div/div/div[2]")).click();

        //click logout
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"user-dropdown\"]/span[1]/a[3]/li")));
        driver.findElement(By.xpath("//*[@id=\"user-dropdown\"]/span[1]/a[3]/li")).click();

        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("idp-discovery-username")));
        driver.findElement(By.id("idp-discovery-username")).sendKeys(userName);

        driver.findElement(By.id("idp-discovery-submit")).click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okta-signin-password")));
        driver.findElement(By.id("okta-signin-password")).sendKeys(password);

        driver.findElement(By.id("okta-signin-submit")).click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.urlToBe(EnvironmentSelector.OverviewUrl));

        Assert.assertEquals(driver.getCurrentUrl(), EnvironmentSelector.OverviewUrl);
    }

    //Helper logs out from Partner Admin
    public static void logoutPartnerAdmin(String userName, String password, ChromeDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //expand user
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main-items-header\"]/div/div/div[2]")));
        driver.findElement(By.xpath("//*[@id=\"main-items-header\"]/div/div/div[2]")).click();

        //click logout
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"user-dropdown\"]/span[1]/a[3]/li")));
        driver.findElement(By.xpath("//*[@id=\"user-dropdown\"]/span[1]/a[5]/li")).click();

        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("idp-discovery-username")));
        driver.findElement(By.id("idp-discovery-username")).sendKeys(userName);

        driver.findElement(By.id("idp-discovery-submit")).click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okta-signin-password")));
        driver.findElement(By.id("okta-signin-password")).sendKeys(password);

        driver.findElement(By.id("okta-signin-submit")).click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.urlToBe(EnvironmentSelector.OverviewUrl));

        Assert.assertEquals(driver.getCurrentUrl(), EnvironmentSelector.OverviewUrl);
    }

    //helper logs out from user or superadmin
    public static void logoutFromSuperAdminOrUser(String userName, String password, ChromeDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.navigate().refresh();
        //expand user
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main-items-header\"]/div/div/div[2]/div/h6")));
        driver.findElement(By.xpath("//*[@id=\"main-items-header\"]/div/div/div[2]/div/h6")).click();

        //click logout
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"user-dropdown\"]/span[1]/a[3]/li")));
        driver.findElement(By.xpath("//*[@id=\"user-dropdown\"]/span[1]/a[3]/li")).click();

        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("idp-discovery-username")));
        driver.findElement(By.id("idp-discovery-username")).sendKeys(userName);

        driver.findElement(By.id("idp-discovery-submit")).click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okta-signin-password")));
        driver.findElement(By.id("okta-signin-password")).sendKeys(password);

        driver.findElement(By.id("okta-signin-submit")).click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.urlToBe(EnvironmentSelector.OverviewUrl));

        Assert.assertEquals(driver.getCurrentUrl(), EnvironmentSelector.OverviewUrl);
    }

    //Helper that logs out from admin
    public static void logoutFromAdmin(String userName, String password, ChromeDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.navigate().refresh();

        //expand user
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main-items-header\"]/div/div/div[2]/div/h6")));
        driver.findElement(By.xpath("//*[@id=\"main-items-header\"]/div/div/div[2]/div/h6")).click();

        //click logout
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"user-dropdown\"]/span[1]/a[4]")));
        driver.findElement(By.xpath("//*[@id=\"user-dropdown\"]/span[1]/a[4]")).click();

        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("idp-discovery-username")));
        driver.findElement(By.id("idp-discovery-username")).sendKeys(userName);

        driver.findElement(By.id("idp-discovery-submit")).click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okta-signin-password")));
        driver.findElement(By.id("okta-signin-password")).sendKeys(password);

        driver.findElement(By.id("okta-signin-submit")).click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.urlToBe(EnvironmentSelector.OverviewUrl));

        Assert.assertEquals(driver.getCurrentUrl(), EnvironmentSelector.OverviewUrl);
    }

    //Helper logs out from Support
    public static void logoutFromSupport(String username, String password, ChromeDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.navigate().refresh();

        //expand user
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main-items-header\"]/div/div/div[2]/div/h6")));
        driver.findElement(By.xpath("//*[@id=\"main-items-header\"]/div/div/div[2]/div/h6")).click();

        //click logout
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"user-dropdown\"]/span[1]/a[5]/li")));
        driver.findElement(By.xpath("//*[@id=\"user-dropdown\"]/span[1]/a[5]/li")).click();


        Thread.sleep(4000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("idp-discovery-username")));
        driver.findElement(By.id("idp-discovery-username")).sendKeys(username);

        driver.findElement(By.id("idp-discovery-submit")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okta-signin-password")));
        driver.findElement(By.id("okta-signin-password")).sendKeys(password);

        driver.findElement(By.id("okta-signin-submit")).click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.urlToBe(EnvironmentSelector.OverviewUrl));

        Assert.assertEquals(driver.getCurrentUrl(), EnvironmentSelector.OverviewUrl);
    }

    private static File makeScreenshot() throws AWTException, IOException {

        try{ // Capture the screen size
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage screenFullImage = new Robot().createScreenCapture(screenRect);

            // Create a temporary file
            File tempFile = File.createTempFile("screenshot", ".png");

            // Write the captured image to the temporary file
            ImageIO.write(screenFullImage, "png", tempFile);

            return tempFile;

        } catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }


    public static String getOCR() throws TesseractException, IOException, AWTException {
        JFrame frame = new JFrame();
        File image = makeScreenshot();
        return GetOCR.readScreen(image);
    }

    public static void loginWithValidUser(ChromeDriver driver,String email,String password) throws  InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        HomePage homePage=new HomePage(driver);

        loginPage.EnterEmailField(email);
        loginPage.ClickLoginNextButton();
        loginPage.EnterPasswordField(password);
        loginPage.ClickSignInButton();
    }

}
