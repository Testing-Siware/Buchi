package utiles;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class MethodHandles {

    WebDriverWait wait;
    Actions scroll;
    ChromeDriver driver;

    @FindBy(xpath = "/html/body/div/div[2]/div/div/div[2]/div/p")
    private WebElement alertMessage;


    @FindBy(xpath = "//*[@id=\"main-sidebar\"]/div[3]")
    private WebElement sideBar;


    private final By loader = By.cssSelector("");
    public MethodHandles(ChromeDriver driver){
        this.driver = driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        scroll=new Actions(driver);
    }

    protected WebElement webElement(By locator){
        return driver.findElement(locator);
    }

    protected void explicitWait(WebElement element, int time){
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void invisibilityOfElement(WebElement element, int time){
        try {
            wait = new WebDriverWait(driver,Duration.ofSeconds(time));
            wait.until(ExpectedConditions.invisibilityOf(element));
        }catch (NoSuchElementException e){
        }
    }

    //method to click on element
    public boolean clickElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        return true;
    }

    //method to get Element Text
    public String getElementText(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    //method to scroll to element
    public boolean scrollToElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView();", element);

        wait.until(ExpectedConditions.visibilityOf(element));
        return true;
    }

    //method to send text in form of String to element
    public boolean sendTextToElement(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
        return true;
    }

    public MethodHandles(){

    }

    //method to send text in form of String & keys to element
    public boolean sendTextToElement(WebElement element, String text, Keys keys[]){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
        for(int i=0;i<keys.length;i++){
            element.sendKeys(keys[i]);
        }
        return true;
    }

    //method to send text in form of String & keys to element
    public boolean sendTextToElement(WebElement element, String text, Keys key){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text,key);
        return true;
    }

    //method to send text in form of keys to element
    public boolean sendTextToElement(WebElement element,Keys keys[]){
        wait.until(ExpectedConditions.visibilityOf(element));
        for(int i=0;i<keys.length;i++){
            element.sendKeys(keys[i]);
        }
        return true;
    }

    protected void hoverOverElement(WebElement element,int time){
        invisibilityOfElement(element,10);
        scroll = new Actions(driver);
        explicitWait(element,time);
        scroll.moveToElement(element);
    }

    //clear text in web element
    public boolean clearText(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        return true;
    }

    /*
    protected void clickWithActions(By locator,int time){
        invisibilityOfElement(loader,10);
        actions = new Actions(driver);
        explicitWait(locator,time);
        actions.click(driver.findElement(locator)).build().perform();
    }
*/
    protected boolean isDisplayed(WebElement element, int time){
       try{
           invisibilityOfElement(element,1);
           explicitWait(element,time);
           return element.isDisplayed();
       }
       catch (Exception ex){
           return false;
       }
    }

    public boolean ignoreNotification(){
        try{
            wait.until(ExpectedConditions.visibilityOf(alertMessage));
            alertMessage.click();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public String getNotificationText(){
        wait.until(ExpectedConditions.visibilityOf(alertMessage));
        return alertMessage.getText();
    }

    public String getSidebarContent(){
        wait.until(ExpectedConditions.visibilityOf(sideBar));
        return sideBar.getText();
    }

    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }

    public String getWindowHandle(){
        return driver.getWindowHandle();
    }

    public void changeWindow()
    {
        String originalWindow = driver.getWindowHandle();
        wait.until(numberOfWindowsToBe(2));
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }

        }
    }

    public void navigateBack(){
        driver.navigate().back();
    }

    public void switchWindow(String windowHandle){
        driver.switchTo().window(windowHandle);
    }

    public void navigateTo(String url){
        driver.navigate().to(url);
    }

    public void refreshWindow(){
        driver.navigate().refresh();
    }

}
