package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import utiles.MethodHandles;



public class ListJournalsPage extends MethodHandles {

    public ListJournalsPage(WebDriver driver) {
        super((ChromeDriver) driver);
        PageFactory.initElements(driver, this);
    }

    //edit filters button in journals' instruments page
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[1]/div[2]/div[2]/div[2]/button[1]")
    public WebElement editFiltersBtn;

    //recipe filter dropdown
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/form/div/div[3]/div/div/div[1]/div/div/div[1]/div[2]/input")
    public WebElement recipeFilterText;

    //instrument SNR filter
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/form/div/div[3]/div/div/div[2]/div/div/div[1]/div[2]/input")
    public WebElement instrumentSNRFilterText;

    //sample name filter text box
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/form/div/div[3]/div/div/div[3]/div/div/div/input")
    public WebElement sampleNameFilterText;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/form/div/div[3]/div/div/div[3]/div/div/div[1]/div[2]/input")
    public WebElement journalsFilterDropdown;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/form/div/div[3]/div/div/div[3]/div/div/div[1]/div[2]/input")
    public WebElement journalsFilter;

    /// cancel filter button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/form/div/div[4]/button")
    public WebElement cancelFilterBtn;

    //save filter button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/form/div/div[4]/div/button")
    public WebElement saveFilterBtn;

    //search text field
    @FindBy(id = "journal-details-list-search-input")
    public WebElement searchTextFields;

    //search button
    @FindBy(id = "journal-details-list-search-submit")
    public WebElement searchBtn;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/button[5]")
    public WebElement exportBtn;

    @FindBy(id = "journal-details-list-viewing-options")
    public WebElement viewBtn;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/button[1]")
    public WebElement manageReferenceValuesBtn;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/button[2]")
    public WebElement manageJournalsBtn;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/button[3]")
    public WebElement spectraOptionsBtn;

    //clear pinning button
    @FindBy(xpath = "/html/body/div[2]/div/div[5]")
    public WebElement clearPinningBtn;

    //clear sorting button
    @FindBy(id = "journal-details-list-viewing-options-dropdown-menu-item-clear-sorting")
    public WebElement clearSortingBtn;

    @FindBy(id = "metadata")
    public WebElement toggleMetadataBtn;

    @FindBy(id = "values")
    public WebElement toggleValuesBtn;

    @FindBy(id = "spectra")
    public WebElement toggleSpectraBtn;

    //first scan checkbox
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[1]/div/div[1]/div/div/div/div[2]")
    public WebElement firstSampleCheckBox;

    //minimize expanded recipe name
    @FindBy(xpath = "/html/body/div[3]/button")
    public WebElement minimizeSampleBtn;

    //first sample name
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[1]/div/div[2]/div")
    public WebElement firstSampleName;

    //first sample recipe name
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div/div[1]")
    public WebElement firstSampleRecipeName;

    //first sample instrument
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div/div[3]")
    public WebElement firstSampleInstrument;

}