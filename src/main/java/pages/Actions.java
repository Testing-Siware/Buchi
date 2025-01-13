package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Actions {

    WebDriverWait wait;

    public Actions(){
    }

//    public Actions(IOSDriver driver, int duration){
//        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
//        wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
//    }

    public Actions(ChromeDriver driver, int duration){
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
    }

    //Elements Needed Actions//
    public boolean isElementVisible(WebElement element){
        try{
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        }
        catch (Exception e){
            return false;
        }
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

    public void enterText(WebElement element, String text){
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            element.sendKeys(text);
        }
        catch (Exception ignored){
        }
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
            wait.until(ExpectedConditions.visibilityOf(element));
            Thread.sleep(2000);
            element.sendKeys(text, Keys.ENTER);
        }
        catch (Exception ignored){
            System.out.println(ignored.toString());
        }
    }
}