package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsPage {
    WebDriverWait wait;
    public String newAlertPageURL;
    public AlertsPage(){
    }

    public AlertsPage(ChromeDriver driver){
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        newAlertPageURL="https://lablake-dev.neospectra.cloud/fleet-management/alert/add";
    }

    //new alert button
    @FindBy(id="alert-list-add-section-button")
    public WebElement newAlertBtn;

    @FindBy(id ="alerts-list-table-filter-button")
    public WebElement filterBtn;

    @FindBy(id="alerts-list-table-viewing-options")
    public WebElement viewingOptions;

    @FindBy(id="alerts-list-table-refresh")
    public WebElement refreshBtn;

    @FindBy(id="alerts-list-table-search-input")
    public WebElement searchTextBox;

    @FindBy(id="alerts-list-table-search-submit")
    public WebElement searchBtn;

    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[1]/div/button[1]")
    public WebElement optionsBtn;

    @FindBy(id="alerts-list-table-actions-cell-0")
    public WebElement firstAlertActionsBtn;

    @FindBy(id="dropdown-menu-item-alert-list-table-option-edit")
    public WebElement editAlertOptionBtn;

    @FindBy(id="dropdown-menu-item-activate")
    public WebElement activateAlertOptionBtn;

    @FindBy(id="dropdown-menu-item-delete")
    public WebElement deleteAlertOptionBtn;

    @FindBy(id="alerts-list-table-filter-input-name")
    public WebElement filterNameInput;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[1]/div/div[2]/div/div/div/form/div[1]/div[2]/div/div/div[1]/div[2]/input")
    public WebElement filterAffiliateInput;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[1]/div/div[2]/div/div/div/form/div[1]/div[3]/div/div/div[1]/div[2]/input")
    public WebElement filterRecipeInput;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[1]/div/div[2]/div/div/div/form/div[1]/div[5]/div/div/div[1]/div[2]/input")
    public WebElement filterStatusInput;

    @FindBy(id="alerts-list-table-filter-button-cancel")
    public WebElement cancelFilterBtn;

    @FindBy(id="alerts-list-table-filter-button-clear")
    public WebElement clearFilterBtn;

    @FindBy(id="alerts-list-table-filter-button-submit")
    public WebElement submitFilterBtn;

    @FindBy(xpath = "/html/body/div[2]/div/div[1]")
    public WebElement activateOption;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]")
    public WebElement deactivateOption;

    @FindBy(xpath = "/html/body/div[2]/div/div[3]")
    public WebElement deleteOption;

    @FindBy(id="alerts-list-table-name-column-options-trigger")
    public WebElement alertsNameColumn;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div/div[1]")
    public WebElement firstAlertName;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[4]")
    public WebElement firstAlertAffiliate;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[2]")
    public WebElement firstAlertRecipe;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[4]/div/div/div")
    public WebElement firstAlertStatus;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[2]/div[1]/div/span")
    public WebElement secondAlertName;

    @FindBy(id = "alerts-list-table-name-column-options-menu-item-asc")
    public WebElement sortAlertsByNameAscOption;

    @FindBy(id = "alerts-list-table-name-column-options-menu-item-desc")
    public WebElement sortAlertsByNameDescOption;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div[1]/div[2]/div[1]/div[2]/span")
    public WebElement newAlertNameEmptyMsg;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div[1]/div[2]/div[2]/div[2]/span")
    public WebElement newAlertAffiliateEmptyMsg;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div[1]/div[2]/div[3]/div[2]/span")
    public WebElement newAlertRecipeEmptyMsg;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div[1]/div[2]/div[4]/div[2]/span")
    public WebElement newAlertIngredientEmptyMsg;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div[2]/div/div/div[2]/span")
    public WebElement newAlertParameterEmptyMsg;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div[3]/div[2]/div[2]/span")
    public WebElement newAlertRecipientsEmptyMsg;

    @FindBy(id = "alert-list-alert-dialog-button-confirm")
    public WebElement confirmDeleteBtn;



    ///////////////////////////////////new & edit alert page elements///////////////////////////////////
    @FindBy(id  ="alert-form-input-name")
    public WebElement newAlertName;

    @FindBy(xpath="/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div[1]/div[2]/div[2]/div/div/div[1]/div[2]/input")
    public WebElement newAlertAffiliate;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div[1]/div[2]/div[3]/div/div/div[1]/div[2]/input")
    public WebElement newAlertRecipe;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div[1]/div[2]/div[4]/div/div/div[1]/div[2]/input")
    public WebElement newAlertInstrument;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div[2]/div/div/div/div[1]/div/div/div[1]/div[2]/input")
    public WebElement newAlertFirstParameter;

    @FindBy(id="alert-form-input-parameters[0].min-0")
    public WebElement newAlertFirstParameterMinValue;

    @FindBy(id="alert-form-input-parameters[0].max-0")
    public WebElement newAlertFirstParameterMaxValue;

    @FindBy(id="alert-form-input-parameters[0].equal-0")
    public WebElement newAlertFirstParameterEqualValue;

    @FindBy(id="alert-form-constraint-button-add-parameter")
    public WebElement newAlertAddParameterBtn;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div[2]/div/div[2]/div/div[1]/div/div/div[1]/div[2]/input")
    public WebElement newAlertSecondParameter;

    @FindBy(id="alert-form-input-parameters[1].min-1")
    public WebElement newAlertSecondParameterMinValue;

    @FindBy(id="alert-form-input-parameters[1].max-1")
    public WebElement newAlertSecondParameterMaxValue;

    @FindBy(id="alert-form-input-parameters[1].equal-1")
    public WebElement newAlertSecondParameterEqualValue;



    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div[3]/div[2]/div[1]/div[1]/div[1]/div[2]/input")
    public WebElement newAlertRecipients;

    @FindBy(id = "alert-form-container-button-cancel")
    public WebElement newAlertCancelBtn;

    @FindBy(id="alert-form-container-button-submit")
    public WebElement newAlertSaveBtn;

    ///////////////////////////////////new alert page elements///////////////////////////////////



}
