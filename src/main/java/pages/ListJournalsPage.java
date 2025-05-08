package pages;

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

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/form/div/div[3]/div/div/div[3]/div/div/div[1]/div[2]/input")
    public WebElement journalEntriesFilter;

    //sample name filter text box
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/form/div/div[3]/div/div/div[3]/div/div/div/input")
    public WebElement sampleNameFilterText;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/form/div/div[3]/div/div/div[3]/div/div/div[1]/div[2]/input")
    public WebElement journalsFilterDropdown;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/form/div/div[3]/div/div/div[3]/div/div/div[1]/div[2]/input")
    public WebElement journalsFilter;


    //reset filter button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[1]/div[2]/div[2]/div[2]/button[2]")
    public WebElement resetFilterBtn;
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

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div/div[3]/div[2]/div[2]/div[1]")
    public WebElement journalsListTableHeader;

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

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div/div[3]/div[2]/div[2]/div[8]/div[2]/div")
    public WebElement tableHorizontalScrollBar;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/div/div[1]/div/h4")
    public WebElement journalDetailsHeader;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/div/div[2]")
    public WebElement sampleNameDetails;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/div/div[3]")
    public WebElement sampleSettingsDetails;

    @FindBy(id ="journal-details-dialog-icon-close" )
    public WebElement closeJournalDetailsDialog;

    @FindBy(id="journal-details-spectra-plot-button")
    public WebElement journalDetailsSpectraPlotBtn;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div/div/div/div[2]")
    public WebElement dataSampleNameFirstCheckbox;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[1]/div[2]/div[1]/div/div/div/div[2]")
    public WebElement dataSampleNameSecondCheckbox;


    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/button[1]/div")
    public WebElement manageReferenceValuesBtn;

    @FindBy(xpath = "/html/body/div[2]/div/div[1]")
    public WebElement exportReferenceValuesBtn;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]")
    public WebElement importReferenceValuesBtn;

    @FindBy(xpath = "/html/body/div[2]/div/div[3]")
    public WebElement exportTemplateBtn;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/div/div[2]/div/div/svg/g[6]")
    public WebElement exportSpectraOptions;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/div/div[2]/div/div/div/ul/li[2]")
    public WebElement exportSpectrumPNG;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/div/div[2]/div/div/div/ul/li[3]")
    public WebElement exportSpectrumPDF;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/div/svg")
    public WebElement closeSpectraPlotDialog;

    @FindBy(id = "journal-details-selection-cancel-button")
    public WebElement journalDetailsCancelSelectionBtn;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div/div[3]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]")
    public WebElement journalListSelectAllCheckbox;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/div[1]/button[2]")
    public WebElement journalListHistogramBtn;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/div[3]/div/div[1]/div")
    public WebElement firstHistogram;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/div[3]/div/div[2]")
    public WebElement secondHistogram;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/button[2]")
    public WebElement manageJournalsBtn;

    @FindBy(xpath = "/html/body/div[2]/div/div[1]")
    public WebElement markAsCheckedOption;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]")
    public WebElement markAsUncheckedOption;

}