package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    WebDriverWait wait;

    public DashboardPage(ChromeDriver driver){
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[1]/div[1]/div[1]/p")
    public WebElement informationMessage;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[1]")
    public WebElement firstRowExpand;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[2]/div")
    public WebElement firstRowSxSuite;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[3]/div/p")
    public WebElement firstRowInstrument;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[2]/div/p")
    public WebElement firstRowInstrumentAdmin;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/div[2]/div[2]/div/div")
    public WebElement MDChart;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[4]/div")
    public WebElement firstRowStatus;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[5]/div")
    public WebElement firstRowEvents;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[6]")
    public WebElement firstRowRecipe;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[7]")
    public WebElement firstRowAlias;
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[2]")
    public  WebElement secondRowExpand;
    
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[2]/div[2]/div")
    public  WebElement secondRowSxSuite;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[2]/div[3]/div/p")
    public WebElement secondRowInstrument;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[2]/div[4]/div")
    public WebElement secondRowStatus;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[2]/div[5]/div")
    public WebElement secondRowEvents;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[2]/div[6]/div")
    public WebElement secondRowRecipe;

    @FindBy(id="dashboard-suites-list-table-filter-button")
    public WebElement filterBtn;

    @FindBy(id="dashboard-suites-list-table-viewing-options")
    public WebElement viewBtn;

    @FindBy(id="dashboard-suites-list-table-refresh")
    public WebElement refreshBtn;

    @FindBy(id = "dashboard-suites-list-table-filter-select-parameter-input")
    public WebElement parameterDropdownFilter;

    @FindBy(id = "dashboard-suites-list-table-filter-number-range-md-from")
    public WebElement mdFromFilter;

    @FindBy(id = "dashboard-suites-list-table-filter-number-range-md-to")
    public WebElement mdToFilter;

    @FindBy(id = "dashboard-suites-list-table-filter-number-range-predictionValue-from")
    public WebElement predictionValueFromFilter;

    @FindBy(id = "dashboard-suites-list-table-filter-number-range-predictionValue-to")
    public WebElement predictionValueToFilter;

    @FindBy(id="dashboard-suites-list-table-filter-select-events-input")
    public WebElement eventsDropdownFilter;

    @FindBy(id = "dashboard-suites-list-table-filter-select-iso12099-input")
    public WebElement iso12099DropdownFilter;

    @FindBy(id = "dashboard-suites-list-table-filter-button-cancel")
    public WebElement cancelFilterBtn;

    @FindBy(id="dashboard-suites-list-table-filter-button-clear")
    public WebElement clearFilterBtn;

    @FindBy(id = "dashboard-suites-list-table-filter-button-submit")
    public WebElement submitFilterBtn;

    @FindBy(id = "dashboard-suites-list-table-viewing-options-dropdown-menu-item-clear-sorting")
    public WebElement clearSortingViewBtn;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[4]/div/div/div")
    public WebElement firstRowNestedGrid;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[4]/div/div/div/div[3]/div[2]/div[2]/div[1]/div[2]/div/div")
    public WebElement firstRowNestedGridHeader;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[4]/div/div/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[1]")
    public WebElement firstRowNestedGridFirstRowParameter;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[4]/div/div/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[5]/div")
    public WebElement firstRowNestedGridFirstRowISO;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[1]")
    public WebElement firstParameterChart;
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[1]/div/div[1]")
    public WebElement dashboardInstrumentHeader;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[1]/div[2]/div/div/div[1]")
    public WebElement sxSuiteColumnHeader;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[1]/div[2]/div/div/div[5]")
    public WebElement eventsColumnHeader;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[1]/div[2]/div/div/div[7]/div[3]")
    public WebElement aliasColumnHeader;

    @FindBy(xpath = "//*[@id=\"dashboard-suites-list-container\"]/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[2]/div[1]")
    public WebElement secondRowExpandBtn;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[4]/div/div/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[4]")
    public WebElement firstParameterPredictionValue;

    @FindBy(xpath="/html/body/div/div[1]/div[3]/div[2]/div/div[1]/div/div[2]/div/div")
    public WebElement graphTimeFilter;

    @FindBy(xpath = "//*[@id=\"admin-layout\"]/div[2]/div/div[1]/div/div[1]/button")
    public WebElement backBtnDashboardPage;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/div[2]/div/div/div/div/div[3]")
    public WebElement parameterDetailWidget;

    @FindBy(id="dashboard-suites-list-table-suiteName-column-options-menu-item-asc")
    public WebElement sxSuiteSortAscOption;

    @FindBy(id="dashboard-suites-list-table-suiteName-column-options-menu-item-desc")
    public WebElement sxSuiteSortDescOption;

    @FindBy(id="dashboard-suites-list-table-suiteName-column-options-menu-item-pin")
    public WebElement sxSuiteSortPinOption;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[1]/div[2]/div/div/div[3]/div[3]")
    public WebElement instrumentColumnHeader;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[1]/div[2]/div/div/div[4]/div[3]")
    public WebElement statusColumnHeader;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[1]/div[2]/div/div/div[6]/div[3]")
    public WebElement recipeColumnHeader;


}
