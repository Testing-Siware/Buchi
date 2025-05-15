package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.time.Duration;
import java.awt.event.KeyEvent;


public class Actions {

    WebDriverWait wait;
    ChromeDriver driver;

    public Actions(){
    }

//    public Actions(IOSDriver driver, int duration){
//        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
//        wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
//    }

    public Actions(ChromeDriver driver, int duration){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
    }
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public boolean isElementSelected(WebElement element){
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isSelected();
        }
        catch (Exception e){
            return false;
        }
    }

    public void clearText(WebElement element){
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            element.clear();
        }
        catch (Exception ignored){
        }
    }

    public void sendKeys(WebElement element, Keys[] keys){
        try{
            wait.until(ExpectedConditions.visibilityOf(element));
            for (Keys key : keys){
                element.sendKeys(key);
            }
        }
        catch (Exception ignored){

        }
    }

    public boolean isElementDisplayed(WebElement element){
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();

        }
        catch (Exception e){
            return false;
        }
    }

    public void scrollToElementHorizontally(WebElement element,int scrollAmount){
        String script="arguments[0].scrollLeft += "+String.valueOf(scrollAmount)+";";
        ((JavascriptExecutor) driver).executeScript(script, element);
    }

    public void scrollToElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void enterText(WebElement element, String text){
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            element.sendKeys(text);
        }
        catch (Exception ignored){
        }
    }

    public void refreshWindow(){
        driver.navigate().refresh();
    }

    public String getText(WebElement element){
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.getText();
        }
        catch (Exception ignored){
        }
        return null;
    }

    public void clickElement(WebElement element){
        try{
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        }
        catch (Exception ignored){
        }
    }

    public void chooseFromDropDown(WebElement element, String text){
        try {
            Thread.sleep(2000);
            element.sendKeys(text, Keys.ENTER);
        }
        catch (Exception ignored){
            System.out.println(ignored.toString());
        }
    }

    public boolean isElementEnabled(WebElement element){
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isEnabled();

        }
        catch (Exception e){
            return false;
        }
    }


    public void uploadFileWithRobot(String filePath) throws AWTException {
        // Copy the file path to clipboard
        StringSelection selection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        // Create Robot instance
        Robot robot = new Robot();
        robot.delay(1000); // Wait for file dialog to appear

        // Press CTRL+V
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.delay(500);

        // Press ENTER
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

}