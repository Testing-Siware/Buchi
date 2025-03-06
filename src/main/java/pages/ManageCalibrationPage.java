package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageCalibrationPage {

    public ManageCalibrationPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[1]/div/button[1]")
    public WebElement viewRecipesBtn;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[1]/div/div/div/div[1]/div[1]/div[2]/input")
    public WebElement recipeNameDropdown;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[1]/div/div/div/div[1]/div[1]")
    public WebElement chosenRecipesFromDropdown;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[1]/div[1]/div/p")
    public WebElement firstSelectedRecipeName;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[1]/div[2]")
    public WebElement firstSelectedRecipeGrid;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/span/span[2]/span")
    public WebElement firstSelectedRecipeFirstParameterExpandBtn;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[4]/div/div/div/div[3]/div[2]/div[2]/div[4]/div[1]")
    public WebElement firstSelectedRecipeFirstParameterNestedGrid;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[1]")
    public WebElement firstSelectedRecipeFirstParameterCalibrationTimesstamp;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div[1]/div/p")
    public WebElement secondSelectedRecipeName;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div[2]")
    public WebElement secondSelectedRecipeGrid;

    @FindBy(id = "transfer-calibration-button")
    public WebElement transferCalibrationBtn;

    @FindBy(id="latest-transfer-button")
    public WebElement latestTransferBtn;

    @FindBy(id="edit-ref-values-button-submit")
    public WebElement saveTransferBtn;

    @FindBy(id="edit-ref-values-button-cancel")
    public WebElement cancelTransferBtn;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[1]/div[3]/div/div/div/form/div[1]/div[1]/div/div/div[1]/div[2]/input")
    public WebElement sourceSxSuiteDropdown;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[1]/div[3]/div/div/div/form/div[1]/div[2]/div/div[1]/div[1]/div[2]/input")
    public WebElement destinationSxSuiteDropdown;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[1]/div[3]/div/div/div/form/div[1]/div[3]/div/div[1]/div[1]/div[2]/input")
    public WebElement includedParameterDropdown;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[1]/div[3]/div/div/div/form/div[1]/div[1]/div[2]/span")
    public WebElement sourceSxSuiteErrorMsg;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[1]/div[3]/div/div/div/form/div[1]/div[2]/div[2]/span")
    public WebElement destinationSxSuiteErrorMsg;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[1]/div[3]/div/div/div/form/div[1]/div[3]/div[2]/span")
    public WebElement includedParameterErrorMsg;

}
