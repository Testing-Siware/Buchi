package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utiles.MethodHandles;

public class RecipePage extends MethodHandles {

    //constructor
    public RecipePage(ChromeDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    /************************Allocators*****************************/
    //<editor-fold desc="Allocators for recipe page">
    //recipe page title
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[1]/div[1]/div[1]/h4")
    private WebElement pageTitle;

    //search field
    @FindBy(id = "search")
    private WebElement searchField;

    //search button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/form/div/button")
    private WebElement searchBtn;

    // header of the table list
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/thead/tr")
    private WebElement headerOfTable;

    //first column header in recipe
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/thead/tr/th[2]/div/div/div/p")
    private WebElement firstColumnHeader;

    //second column header in recipe
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/thead/tr/th[3]/div/div/div/p")
    private WebElement secondColumnHeader;

    //third column header in recipe
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/thead/tr/th[4]/div/div/div/p")
    private WebElement thirdColumnHeader;

    //fourth column header in recipe
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/thead/tr/th[5]/div/div/div/p")
    private WebElement fourthColumnHeader;

    //fifth column header in parameter
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/thead/tr/th[6]/div/div/div/p")
    private WebElement fifthColumnHeaderRP;

    //name column sorting button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/thead/tr/th[2]/div/div/div")
    private WebElement nameSortingBtn;

    //sorting name Asc
    @FindBy(xpath = "/html/body/div[2]/div/div[1]")
    private WebElement sortingNameAsc;

    //sorting name Desc
    @FindBy(xpath = "/html/body/div[2]/div/div[2]")
    private WebElement sortingNameDesc;

    //pin name column
    @FindBy(xpath = "/html/body/div[2]/div/div[4]")
    private WebElement pinNameColumn;

    //sorting affiliate column
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/thead/tr/th[3]/div/div/div")
    private WebElement sortingAffiliateBtn;

    //sorting affiliate Asc
    @FindBy(xpath = "/html/body/div[2]/div/div[1]")
    private WebElement sortingAffiliateAsc;

    //sorting affiliate Desc
    @FindBy(xpath = "/html/body/div[2]/div/div[2]")
    private WebElement sortingAffiliateDesc;

    //hide affiliate column
    @FindBy(xpath = "/html/body/div[2]/div/div[4]")
    private WebElement hideAffiliateColumn;

    //sorting created by column button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/thead/tr/th[4]/div/div/div")
    private WebElement sortingCreatedByBtn;

    //sorting created by column Asc
    @FindBy(xpath = "/html/body/div[2]/div/div[1]")
    private WebElement sortingCreatedByAsc;

    //sorting created by column Desc
    @FindBy(xpath = "/html/body/div[2]/div/div[2]")
    private WebElement sortingCreatedByDesc;

    //hide created by column option
    @FindBy(xpath = "/html/body/div[2]/div/div[4]")
    private WebElement hideCreatedByColumn;

    //first row name
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr[1]/td[2]/div/p")
    private WebElement firstRowName;

    //second row name
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr[2]/td[2]/div/p")
    private WebElement secondRowName;

    //first row affiliate
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr[1]/td[3]/div/p")
    private WebElement firstRowAffiliate;

    //first row created by
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr[1]/td[4]/div/p")
    private WebElement firstRowCreatedBy;

    //first row action button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr[1]/td[5]/button")
    private WebElement firstRowActions;

    //second row action button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr[2]/td[5]/button")
    private WebElement secondRowActions;

    //first row edit action
    @FindBy(xpath = "/html/body/div[2]/div/div[1]")
    private WebElement firstRowEditAction;

    //first row view parameters action
    @FindBy(xpath = "/html/body/div[2]/div/div[2]")
    private WebElement firstRowViewParametersAction;

    //first row assign to instrument action
    @FindBy(xpath = "/html/body/div[2]/div/div[3]")
    private WebElement firstRowAssignToInstrumentAction;

    //first row delete action
    @FindBy(xpath = "/html/body/div[2]/div/div[4]")
    private WebElement firstRowDeleteAction;

    //rows per page field
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[4]/div/div/div[1]/div[2]/div/div/div[1]/div[2]/input")
    private WebElement rowsPerPage;

    //back page button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[4]/div/div[2]/div[2]/button[1]")
    private WebElement backPageBtn;

    //back row button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[4]/div/div[2]/div[2]/button[2]")
    private WebElement backRowBtn;

    //froward row button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[4]/div/div[2]/div[2]/button[3]")
    private WebElement frowardRowBtn;

    //froward page button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[4]/div/div[2]/div[2]/button[4]")
    private WebElement frowardPageBtn;

    //filter button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/div/button")
    private WebElement filterBtn;

    //view button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/button[1]")
    private WebElement viewBtn;

    //toggle to affiliate view
    @FindBy(xpath = "/html/body/div[2]/div/div[3]")
    private WebElement toggleToAffiliateView;

    //toggle to created by view
    @FindBy(xpath = "/html/body/div[2]/div/div[4]")
    private WebElement toggleToCreatedByView;

    //toggle to created at view
    @FindBy(xpath = "/html/body/div[2]/div/div[5]")
    private WebElement toggleToCreatedAtView;

    //toggle to clear pinning view
    @FindBy(xpath = "/html/body/div[2]/div/div[7]")
    private WebElement toggleToClearPanningView;

    //toggle to clear sorting view
    @FindBy(xpath = "/html/body/div[2]/div/div[8]")
    private WebElement toggleToClearSortingView;
    //</editor-fold>

    //<editor-fold desc = "Allocators for filter window">
    //filter window title
    @FindBy(xpath = "/html/body/div[3]/div/h4")
    private WebElement filterWindowTitle;

    //filter name text field
    @FindBy(xpath = "/html/body/div[3]/form/div[1]/div[1]/div/div/div/input")
    private WebElement filterName;

    //filter created at text field
    @FindBy(xpath = "/html/body/div[3]/form/div[1]/div[2]/div/input")
    private WebElement filterCreatedAt;

    //filter affiliate text field
    @FindBy(xpath = "/html/body/div[3]/form/div[1]/div[3]/div/div[1]/div[1]/div[2]/input")
    private WebElement filterAffiliate;

    //filter cancel button
    @FindBy(xpath = "/html/body/div[3]/form/div[2]/button")
    private WebElement filterCancelBtn;

    //filter clear button
    @FindBy(xpath = "/html/body/div[3]/form/div[2]/div/button[1]")
    private WebElement filterClearBtn;

    //filter apply button
    @FindBy(xpath = "/html/body/div[3]/form/div[2]/div/button[2]")
    private WebElement filterApplyBtn;

    //filter close button
    @FindBy(xpath = "/html/body/div[3]/button")
    private WebElement filterCloseBtn;
    //</editor-fold>

    //<editor-fold desc = "Allocators for recipe parameters page">
    //recipe page title
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[1]/div[1]/div[1]/h4")
    private WebElement recipeParametersPageTitle;

    //parameter search field
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/form/div/div/div/div/div/input")
    private WebElement recipeParameterSearchField;

    //search button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/form/div/button")
    private WebElement recipeParametersSearchBtn;

    //add parameter button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[1]/div[1]/div[2]/button")
    private WebElement addParameterBtn;

    //rows per page field
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[4]/div/div/div[1]/div[2]/div/div/div[1]/div[2]/input")
    private WebElement recipeParametersRowsPerPage;

    //back page button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[4]/div/div[2]/div[2]/button[1]")
    private WebElement recipeParametersBackPageBtn;

    //back row button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[4]/div/div[2]/div[2]/button[2]")
    private WebElement recipeParametersBckRowBtn;

    //froward row button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[4]/div/div[2]/div[2]/button[3]")
    private WebElement recipeParametersFrowardRowBtn;

    //froward page button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[4]/div/div[2]/div[2]/button[4]")
    private WebElement recipeParametersFrowardPageBtn;

    //filter button in recipe parameters page
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/div/button")
    private WebElement filterRecipeParametersBtn;

    //recipe parameters filter window title
    @FindBy(xpath = "/html/body/div[3]/div/h4")
    private WebElement recipeParametersFilterWindowTitle;

    //name text field in recipe parameters filter window
    @FindBy(xpath = "/html/body/div[3]/form/div[1]/div[1]/div/div/div/input")
    private WebElement recipeParametersFilterName;

    //created at text field in recipe parameters filter window
    @FindBy(xpath = "/html/body/div[3]/form/div[1]/div[2]/div/input")
    private WebElement recipeParametersFilterCreatedAt;

    //created by text field in recipe parameters filter window
    @FindBy(xpath = "/html/body/div[3]/form/div[1]/div[3]/div/div/div[1]/div[2]/input")
    private WebElement recipeParametersFilterCreatedBy;

    //cancel filter button in recipe parameters filter window
    @FindBy(xpath = "/html/body/div[3]/form/div[2]/button")
    private WebElement recipeParametersCancelFilterBtn;

    //clear filter button in recipe parameters filter window
    @FindBy(xpath = "/html/body/div[3]/form/div[2]/div/button[1]")
    private WebElement recipeParametersClearFilterBtn;

    //apply filter button in recipe parameters filter window
    @FindBy(xpath = "/html/body/div[3]/form/div[2]/div/button[2]")
    private WebElement recipeParametersApplyFilterBtn;

    //close filter button in recipe parameters filter window
    @FindBy(xpath = "/html/body/div[3]/button/svg")
    private WebElement recipeParametersCloseFilterBtn;

    //view button in recipe parameters page
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/button[1]")
    private WebElement viewRecipeParametersBtn;

    //toggle to location view
    @FindBy(xpath = "/html/body/div[2]/div/div[3]")
    private WebElement toggleToLocationViewRP;

    //toggle to slope view
    @FindBy(xpath = "/html/body/div[2]/div/div[4]")
    private WebElement toggleToSlopeViewRP;

    //toggle to min view
    @FindBy(xpath = "/html/body/div[2]/div/div[5]")
    private WebElement toggleToMinViewRP;

    //toggle to max view
    @FindBy(xpath = "/html/body/div[2]/div/div[6]")
    private WebElement toggleToMaxViewRP;

    //toggle to mahalanobis view
    @FindBy(xpath = "/html/body/div[2]/div/div[7]")
    private WebElement toggleToMahalanobisViewRP;

    //toggle to created by view
    @FindBy(xpath = "/html/body/div[2]/div/div[8]")
    private WebElement toggleToCreatedByViewRP;

    //toggle to created at view
    @FindBy(xpath = "/html/body/div[2]/div/div[9]")
    private WebElement toggleToCreatedAtViewRP;

    //clear any pinning view option
    @FindBy(xpath = "/html/body/div[2]/div/div[11]")
    private WebElement clearPinningViewRP;

    //clear any sorting view option
    @FindBy(xpath = "/html/body/div[2]/div/div[12]")
    private WebElement clearSortingViewRP;

    //name sorting button in recipe parameters page
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/thead/tr/th[2]/div/div/div")
    private WebElement nameSortingRPBtn;

    //sorting name column in recipe parameters page Asc
    @FindBy(xpath = "/html/body/div[2]/div/div[1]")
    private WebElement sortingRPNameAsc;

    //sorting name column in recipe parameters page Desc
    @FindBy(xpath = "/html/body/div[2]/div/div[2]")
    private WebElement sortingRPNameDesc;

    //pin name column in recipe parameters page
    @FindBy(xpath = "/html/body/div[2]/div/div[4]")
    private WebElement pinRPName;

    //sorting alias button in recipe parameters page
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/thead/tr/th[3]/div/div/div")
    private WebElement aliasSortingRPBtn;

    //sorting alias column in recipe parameters page Asc
    @FindBy(xpath = "/html/body/div[2]/div/div[1]")
    private WebElement sortingRPAliasAsc;

    //sorting alias column in recipe parameters page Desc
    @FindBy(xpath = "/html/body/div[2]/div/div[2]")
    private WebElement sortingRPAliasDesc;

    //sorting parameter alias button in recipe parameters page
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/thead/tr/th[4]/div/div/div")
    private WebElement parameterAliasSortingRPBtn;

    //sorting parameter alias column in recipe parameters page Asc
    @FindBy(xpath = "/html/body/div[2]/div/div[1]")
    private WebElement sortingRPParameterAliasAsc;

    //sorting parameter alias column in recipe parameters page Desc
    @FindBy(xpath = "/html/body/div[2]/div/div[2]")
    private WebElement sortingRPParameterAliasDesc;

    //first row name in recipe parameter page
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr[1]/td[2]/div/p")
    private WebElement firstRowNameRP;

    //second row name in recipe parameter page
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr[2]/td[2]/div/p")
    private WebElement secondRowNameRP;

    //first row alias in recipe parameter page
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr/td[3]/div/p")
    private WebElement firstRowAliasRP;

    //first row parameter alias in recipe parameter page
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr/td[4]/div/p")
    private WebElement firstRowParameterAliasRP;

    //first row bias in recipe parameter page
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr/td[5]/div/p")
    private WebElement firstRowBiasRP;

    //first row actions button in recipe parameter page
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr/td[6]/button")
    private WebElement firstRowActionsBtnInParameters;

    //first row view calibration files action
    @FindBy(xpath = "/html/body/div[2]/div/div")
    private WebElement firstRowViewCalibrationActions;
    //</editor-fold

          //<editor-fold desc = "Allocators for Calibration files page">

    //Calibration files page title
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[1]/div[1]/div[1]/h4")
        private WebElement calibrationFilesPageTitle;

    //calibration files search field
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/form/div/div/div/div/div/input")
    private WebElement calibrationFilesSearchField;

    //search button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/form/div/button")
    private WebElement calibrationFilesSearchBtn;


    //rows per page field
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[4]/div/div/div[1]/div[2]/div/div/div[1]/div[2]/input")
    private WebElement rowsPerPageCalibrationFiles;

    //back page button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[4]/div/div/div[2]/div[2]/button[1]")
    private WebElement calibrationFilesBackPageBtn;

    //back row button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[4]/div/div/div[2]/div[2]/button[2]")
    private WebElement calibrationFilesBckRowBtn;

    //froward row button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[4]/div/div/div[2]/div[2]/button[3]")
    private WebElement calibrationFilesFrowardRowBtn;

    //froward page button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[4]/div/div/div[2]/div[2]/button[4]")
    private WebElement calibrationFilesFrowardPageBtn;

    //filter button in calibration files
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/div/button")
    private WebElement calibrationFilesFilterBtn;

    //view button in calibration files
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/button[1]")
    private WebElement calibrationFilesViewBtn;

    //calibration files filter window title
    @FindBy(xpath = "/html/body/div[3]/div/h4")
    private WebElement calibrationFilesFilterWindowTitle;

    //name text field in calibration Files filter window
    @FindBy(xpath = "/html/body/div[3]/form/div[1]/div[1]/div/div/div/input")
    private WebElement calibrationFilesFilterName;

    //created at text field in calibration files filter window
    @FindBy(xpath = "/html/body/div[3]/form/div[1]/div[2]/div/input")
    private WebElement calibrationFilesFilterCreatedAt;

    //created by text field in calibration files filter window
    @FindBy(xpath = "/html/body/div[3]/form/div[1]/div[3]/div/div/div[1]/div[2]/input")
    private WebElement calibrationFilesFilterCreatedBy;

    //cancel filter button in calibration files filter window
    @FindBy(xpath = "/html/body/div[3]/form/div[2]/button")
    private WebElement calibrationFilesCancelFilterBtn;

    //clear filter button in calibration files filter window
    @FindBy(xpath = "/html/body/div[3]/form/div[2]/div/button[1]")
    private WebElement calibrationFilesClearFilterBtn;

    //apply filter button in calibration files filter window
    @FindBy(xpath = "/html/body/div[3]/form/div[2]/div/button[2]")
    private WebElement calibrationFilesApplyFilterBtn;

    //close filter button in calibration files filter window
    @FindBy(xpath = "/html/body/div[3]/button")
    private WebElement calibrationFilesCloseFilterBtn;

    //toggle to created at view
    @FindBy(xpath = "/html/body/div[2]/div/div[3]")
    private WebElement toggleToCreatedAtCalibrationFiles;

    //toggle to deployed at view
    @FindBy(xpath = "/html/body/div[2]/div/div[4]")
    private WebElement toggleToDeployedAtCalibrationFiles;

    //clear any pinning view option
    @FindBy(xpath = "/html/body/div[2]/div/div[6]")
    private WebElement clearPinningViewCalibrationFiles;

    //clear any sorting view option
    @FindBy(xpath = "/html/body/div[2]/div/div[7]")
    private WebElement clearSortingViewCalibrationFiles;

    //sorting name column in calibration files page Asc
    @FindBy(xpath = "/html/body/div[2]/div/div[1]")
    private WebElement sortingCalibrationFilesNameAsc;

    //sorting name column in calibration files page Desc
    @FindBy(xpath = "/html/body/div[2]/div/div[2]")
    private WebElement sortingCalibrationFilesNameDesc;

    //pin name column in calibration files page
    @FindBy(xpath = "/html/body/div[2]/div/div[4]")
    private WebElement pinCalibrationFilesName;

    //first row name in calibration files page
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr[1]/td[2]/div/p")
    private WebElement firstRowNameCalibrationFiles;

    //first row type in the calibration files page
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr[1]/td[3]/div/p")
    private WebElement firstRowTypeCalibrationFiles;

    //second row name in calibration files page
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr[2]/td[2]/div/p")
    private WebElement secondRowNameCalibrationFiles;

    //second row type in the calibration files page
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr[2]/td[3]/div/p")
    private WebElement secondRowTypeCalibrationFiles;

    //first column header in calibration files
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/thead/tr/th[2]/div/div/div/p")
    private WebElement firstColumnHeaderCalibrationFiles;

    //second column header in calibration files
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/thead/tr/th[3]/p")
    private WebElement secondColumnHeaderCalibrationFiles;

    //third column header in calibration files
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/thead/tr/th[4]/div/div/div/p")
    private WebElement thirdColumnHeaderCalibrationFiles;

    //fourth column header in calibration files
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/thead/tr/th[5]/div/div/div/p")
    private WebElement fourthColumnHeaderCalibrationFiles;

    //fifth column header in calibration files
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/thead/tr/th[6]/div/div/div/p")
    private WebElement fifthColumnHeaderCalibrationFiles;

    //expand and collapse the calibration files button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr[1]/td[1]/div")
    private WebElement expandCalibrationFilesBtn;

    //file status in first row calibration files
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/div/div[1]/table/tbody/tr[1]/td[1]/div/div")
    private WebElement filesStatusInFirstRow;

    //file created at in first row calibration files
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/div/div[1]/table/tbody/tr[1]/td[2]/p")
    private WebElement filesCreatedAtInFirstRow;

    //file modified at in first row calibration files
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/div/div[1]/table/tbody/tr[1]/td[3]/p")
    private WebElement filesModifiedAtInFirstRow;

    //file deployed at in first row calibration files
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/div/div[1]/table/tbody/tr[1]/td[4]/p")
    private WebElement filesDeployedAtInFirstRow;

    //file status in second row calibration files
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/div/div[1]/table/tbody/tr[2]/td[1]/div/div")
    private WebElement filesStatusInSecondRow;

    //file created at in second row calibration files
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/div/div[1]/table/tbody/tr[2]/td[2]/p")
    private WebElement filesCreatedAtInSecondRow;

    //file modified at in second row calibration files
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/div/div[1]/table/tbody/tr[2]/td[3]/p")
    private WebElement filesModifiedAtInSecondRow;

    //file deployed at in second row calibration files
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/div/div[1]/table/tbody/tr[2]/td[4]/p")
    private WebElement filesDeployedAtInSecondRow;

    //file action button for the second row
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/div/div[1]/table/tbody/tr[3]/td[5]/button")
    private WebElement fileActionBtnInSecondRow;

    //file deploy button on the action list on the second row
    @FindBy(xpath = "/html/body/div[2]/div")
    private WebElement deployBtnOnActionList;

    //submit button in the deploy popup after clicking deploy button
    @FindBy(xpath = "/html/body/div[3]/div[3]/div/button")
    private WebElement submitBtn;

    //cancel button in the deploy popup after clicking deploy button
    @FindBy(xpath = "/html/body/div[3]/div[3]/button")
    private WebElement cancelBtn;

    //close button after in the deploy popup after clicking deploy button
    @FindBy(xpath = "/html/body/div[3]/button")
    private WebElement closeBtn;

    //deploy popup title
    @FindBy(xpath = "/html/body/div[3]/h4")
    private WebElement deployPopupTitle;





    /************************Is Displayed Methods*****************************/
    //<editor-fold desc = "Is displayed methods for recipe page">
    //method check if recipe page title is displayed
    public boolean recipePageTitleIsDisplayed() {
        return isDisplayed(pageTitle, 10);
    }

    //method check if search text field is displayed
    public boolean searchTextFieldIsDisplayed() {
        return isDisplayed(searchField, 10);
    }

    //method check if the created at column is displayed
    public boolean createdAtColumnHeaderDisplayed(){return isDisplayed(fourthColumnHeader,10); }

    //method check if search button is displayed
    public boolean searchBtnIsDisplayed() {
        return isDisplayed(searchBtn, 10);
    }

    //method check if sorting name column button is displayed
    public boolean sortingNameColIsDisplayed() {
        return isDisplayed(nameSortingBtn, 10);
    }

    //method check if sorting name Asc option is displayed
    public boolean sortingNameAscIsDisplayed() {
        return isDisplayed(sortingNameAsc, 10);
    }

    //method check if sorting name Desc option is displayed
    public boolean sortingNameDescIsDisplayed() {
        return isDisplayed(sortingNameDesc, 10);
    }

    //method check if pin name column option is displayed
    public boolean pinNameColumnOptionIsDisplayed() {
        return isDisplayed(pinNameColumn, 10);
    }

    //method check if sorting affiliate column button is displayed
    public boolean sortingAffiliateColumnOptionIsDisplayed() {
        return isDisplayed(sortingAffiliateBtn, 10);
    }

    //method check if sorting affiliate Asc option is displayed
    public boolean sortingAffiliateAscIsDisplayed() {
        return isDisplayed(sortingAffiliateAsc, 10);
    }

    //method check if sorting affiliate Desc option is displayed
    public boolean sortingAffiliateDescIsDisplayed() {
        return isDisplayed(sortingAffiliateDesc, 10);
    }

    //method check if hide affiliate column option is displayed
    public boolean hideAffiliateColumnOptionIsDisplayed() {
        return isDisplayed(hideAffiliateColumn, 10);
    }

    //method check if sorting created by column button is displayed
    public boolean sortingCreatedByColumnOptionIsDisplayed() {
        return isDisplayed(sortingCreatedByBtn, 10);
    }

    //method check if sorting created by Asc option is displayed
    public boolean sortingCreatedByAscIsDisplayed() {
        return isDisplayed(sortingCreatedByAsc, 10);
    }

    //method check if sorting created by Desc option is displayed
    public boolean sortingCreatedByDescIsDisplayed() {
        return isDisplayed(sortingCreatedByDesc, 10);
    }

    //method check if hide created by column option is displayed
    public boolean hideCreatedByColumnOptionIsDisplayed() {
        return isDisplayed(hideCreatedByColumn, 10);
    }

    //method check if first row name is displayed
    public boolean firstRowNameIsDisplayed() {
        return isDisplayed(firstRowName, 10);
    }

    //method check if first row affiliate is displayed
    public boolean firstRowAffiliateIsDisplayed() {
        return isDisplayed(firstRowAffiliate, 10);
    }

    //method check if first row created by is displayed
    public boolean firstRowCreatedByIsDisplayed() {
        return isDisplayed(firstRowCreatedBy, 10);
    }

    //method check if first row options button is displayed
    public boolean firstRowActionsBtnIsDisplayed() {
        return isDisplayed(firstRowActions, 10);
    }

    //method check if rows per page is displayed
    public boolean rowsPerPageIsDisplayed() {
        return isDisplayed(rowsPerPage, 10);
    }

    //method check if back page button is displayed
    public boolean backPageBtnIsDisplayed() {
        return isDisplayed(backPageBtn, 10);
    }

    //method check if back row button is displayed
    public boolean backRowBtnIsDisplayed() {
        return isDisplayed(backRowBtn, 10);
    }

    //method check if froward row button is displayed
    public boolean frowardRowBtnIsDisplayed() {
        return isDisplayed(frowardRowBtn, 10);
    }

    //method check if froward row button is displayed
    public boolean frowardPageBtnIsDisplayed() {
        return isDisplayed(frowardPageBtn, 10);
    }

    //method check if filter button is displayed
    public boolean filterBtnIsDisplayed() {
        return isDisplayed(filterBtn, 10);
    }

    //method check if view button is displayed
    public boolean viewBtnIsDisplayed() {
        return isDisplayed(viewBtn, 10);
    }
    //</editor-fold>

    //<editor-fold desc = "Is displayed methods for filter window">
    //method check if filter page title is displayed
    public boolean filterWindowTitleIsDisplayed() {
        return isDisplayed(filterWindowTitle, 10);
    }

    //method check if filter name text field is displayed
    public boolean filterNameTxtFieldIsDisplayed() {
        return isDisplayed(filterName, 10);
    }

    //method check if filter created at text field is displayed
    public boolean filterCreatedAtTxtFieldIsDisplayed() {
        return isDisplayed(filterCreatedAt, 10);
    }

    //method check if filter affiliate text field is displayed
    public boolean filterAffiliateTxtFieldIsDisplayed() {
        return isDisplayed(filterAffiliate, 10);
    }

    //method check if filter cancel button is displayed
    public boolean filterCancelBtnIsDisplayed() {
        return isDisplayed(filterCancelBtn, 10);
    }

    //method check if filter clear button is displayed
    public boolean filterClearBtnIsDisplayed() {
        return isDisplayed(filterClearBtn, 10);
    }

    //method check if filter apply button is displayed
    public boolean filterApplyBtnIsDisplayed() {
        return isDisplayed(filterApplyBtn, 10);
    }

    //method check if filter close button is displayed
    public boolean filterCloseBtnIsDisplayed() {
        return isDisplayed(filterCloseBtn, 10);
    }
    //</editor-fold>

    //<editor-fold desc = "Is displayed methods for recipe parameters page">
    //method check if recipe parameters title is displayed
    public boolean recipeParameterPageTitleIsDisplayed() {
        return isDisplayed(recipeParametersPageTitle, 10);
    }

    //method check if recipe parameters search text field is displayed
    public boolean recipeParametersSearchTextFieldIsDisplayed() {
        return isDisplayed(recipeParameterSearchField, 10);
    }

    //method check if search button is displayed
    public boolean recipeParametersSearchBtnIsDisplayed() {
        return isDisplayed(recipeParametersSearchBtn, 10);
    }

    //method check if the action button is displayed
    public boolean recipeParameterActionBtnIsDisplayed(){return isDisplayed(firstRowActionsBtnInParameters,10);}

    //method check if rows per page in recipe page is displayed
    public boolean recipeParametersRowsPerPageIsDisplayed() {
        return isDisplayed(recipeParametersRowsPerPage, 10);
    }

    //method check if back page button in recipe page is displayed
    public boolean recipeParametersBackPageBtnIsDisplayed() {
        return isDisplayed(recipeParametersBackPageBtn, 10);
    }

    //method check if back row button in recipe page is displayed
    public boolean recipeParametersBckRowBtnIsDisplayed() {
        return isDisplayed(recipeParametersBckRowBtn, 10);
    }

    //method check if froward row button in recipe page is displayed
    public boolean recipeParametersFrowardRowBtnIsDisplayed() {
        return isDisplayed(recipeParametersFrowardRowBtn, 10);
    }

    //method check if froward row button in recipe page is displayed
    public boolean recipeParametersFrowardPageBtnIsDisplayed() {
        return isDisplayed(recipeParametersFrowardPageBtn, 10);
    }

    //method check if add parameter button in recipe page is displayed
    public boolean addParameterBtnIsDisplayed() {
        return isDisplayed(addParameterBtn, 10);
    }

    //method check if filter button in recipe page is displayed
    public boolean filterRecipeParametersBtnIsDisplayed() {
        return isDisplayed(filterRecipeParametersBtn, 10);
    }

    //method check if recipe page filter window title is displayed
    public boolean recipeParametersFilterWindowTitleIsDisplayed() {
        return isDisplayed(recipeParametersFilterWindowTitle, 10);
    }

    //method check if filter name text field in recipe page is displayed
    public boolean recipeParametersFilterNameIsDisplayed() {
        return isDisplayed(recipeParametersFilterName, 10);
    }

    //method check if filter created at text field in recipe page is displayed
    public boolean recipeParametersFilterCreatedAtIsDisplayed() {
        return isDisplayed(recipeParametersFilterCreatedAt, 10);
    }

    //method check if filter created by text field in recipe page is displayed
    public boolean recipeParametersFilterCreatedByIsDisplayed() {
        return isDisplayed(recipeParametersFilterCreatedBy, 10);
    }

    //method check if filter cancel button in recipe parameters filter window is displayed
    public boolean recipeParametersCancelFilterBtnIsDisplayed() {
        return isDisplayed(recipeParametersCancelFilterBtn, 10);
    }

    //method check if filter clear button in recipe parameters filter window is displayed
    public boolean recipeParametersClearFilterBtnIsDisplayed() {
        return isDisplayed(recipeParametersClearFilterBtn, 10);
    }

    //method check if filter apply button in recipe parameters filter window is displayed
    public boolean recipeParametersApplyFilterBtnIsDisplayed() {
        return isDisplayed(recipeParametersApplyFilterBtn, 10);
    }

    //method check if filter close button in recipe parameters filter window is displayed
    public boolean recipeParametersCloseFilterBtnIsDisplayed() {
        return isDisplayed(recipeParametersCloseFilterBtn, 10);
    }

    //method check if view button in recipe page is displayed
    public boolean viewRecipeParametersBtnIsDisplayed() {
        return isDisplayed(viewRecipeParametersBtn, 10);
    }

            //<editor-fold desc = "Is displayed methods for calibration files page">
    //method check if calibration files title is displayed
    public boolean calibrationFilesPageTitleIsDisplayed() {
        return isDisplayed(calibrationFilesPageTitle, 10);
    }

    //method check if calibration files search text field is displayed
    public boolean calibrationFilesSearchTextFieldIsDisplayed() {
        return isDisplayed(calibrationFilesSearchField, 10);
    }

    //method check if search button is displayed
    public boolean calibrationFilesSearchBtnIsDisplayed() {
        return isDisplayed(calibrationFilesSearchBtn, 10);
    }

    //method check if back page button in calibration files is displayed
    public boolean calibrationFilesBackPageBtnIsDisplayed() {
        return isDisplayed(calibrationFilesBackPageBtn, 10);
    }

    //method check if back row button in calibration files is displayed
    public boolean calibrationFilesBckRowBtnIsDisplayed() { return isDisplayed(calibrationFilesBckRowBtn, 10);}

    //method check if froward row button in calibration files is displayed
    public boolean calibrationFilesFrowardRowBtnIsDisplayed() {
        return isDisplayed(calibrationFilesFrowardRowBtn, 10);
    }

    //method check if froward row button in calibration files is displayed
    public boolean calibrationFilesFrowardPageBtnIsDisplayed() { return isDisplayed(calibrationFilesFrowardPageBtn, 10);}

    //method check if filter button in calibration files is displayed
    public boolean filterCalibrationFilesBtnIsDisplayed() {return isDisplayed(calibrationFilesFilterBtn, 10);}

    //method check if calibration files filter window title is displayed
    public boolean calibrationFilesFilterWindowTitleIsDisplayed() {return isDisplayed(calibrationFilesFilterWindowTitle, 10);}

    //method check if filter name text field in calibration files is displayed
    public boolean calibrationFilesFilterNameIsDisplayed() {
        return isDisplayed(calibrationFilesFilterName, 10);
    }

    //method check if filter created at text field in calibration files is displayed
    public boolean calibrationFilesFilterCreatedAtIsDisplayed() {return isDisplayed(calibrationFilesFilterCreatedAt, 10);}

    //method check if filter created by text field in calibration files is displayed
    public boolean calibrationFilesFilterCreatedByIsDisplayed() {return isDisplayed(calibrationFilesFilterCreatedBy, 10);}

    //method check if filter cancel button in calibration files filter window is displayed
    public boolean calibrationFilesCancelFilterBtnIsDisplayed() {return isDisplayed(calibrationFilesCancelFilterBtn, 10);}

    //method check if filter clear button in calibration files filter window is displayed
    public boolean calibrationFilesClearFilterBtnIsDisplayed() {return isDisplayed(calibrationFilesClearFilterBtn, 10);}

    //method check if filter apply button in calibration files filter window is displayed
    public boolean calibrationFilesApplyFilterBtnIsDisplayed() {return isDisplayed(calibrationFilesApplyFilterBtn, 10);}

    //method check if filter close button in calibration files filter window is displayed
    public boolean calibrationFilesCloseFilterBtnIsDisplayed() {return isDisplayed(calibrationFilesCloseFilterBtn, 10);}

    //method check if view button in calibration files is displayed
    public boolean viewCalibrationFilesBtnIsDisplayed() {
        return isDisplayed(calibrationFilesViewBtn, 10);
    }

    //method check if collapse button is displayed
    public boolean calibrationFilesExpandBtnIsDisplayed(){return  isDisplayed(expandCalibrationFilesBtn,10);}

    //method check if file status field is displayed
    public boolean calibrationFilesStatusFieldIsDisplayed(){return  isDisplayed(filesStatusInFirstRow,10);}

    //method check if file created at field id displayed
    public boolean calibrationFilesCreatedAtFieldIsDisplayed(){return  isDisplayed(filesCreatedAtInFirstRow,10);}

    //method check if file modified at field id displayed
    public boolean calibrationFilesModifiedAtFieldIsDisplayed(){return  isDisplayed(filesModifiedAtInFirstRow,10);}

    //method check if file deployed at field id displayed
    public boolean calibrationFilesDeployedAtFieldIsDisplayed(){return  isDisplayed(filesDeployedAtInFirstRow,10);}

    //method to check if the action button in the second row is displayed
    public boolean calibrationFilesSecondRowActionBtnIsDisplayed(){
        return isDisplayed(fileActionBtnInSecondRow,10);
    }

    //method to check the deployment popup title is displayed
    public boolean calibrationFilesDeploymentPopupTitleIsDisplayed(){return isDisplayed(deployPopupTitle,10);}

    //method to check the deployment popup cancel button is displayed
    public boolean calibrationFilesDeploymentPopupCancelBtnIsDisplayed(){return isDisplayed(cancelBtn,10);}

    //method to check the deployment popup submit button is displayed
    public boolean calibrationFilesDeploymentPopupSubmitBtnIsDisplayed(){return isDisplayed(submitBtn,10);}

    //method to check the deployment popup close button is displayed
    public boolean calibrationFilesDeploymentPopupCloseBtnIsDisplayed(){return isDisplayed(closeBtn,10);}

    //</editor-fold>


    /************************Click Methods*****************************/
    //<editor-fold desc = "Click methods for recipe page">
    //method to click Search field
    public boolean clickSearchField() {
        return clickElement(searchField);
    }

    //method to click Search button
    public boolean clickSearchBtn() {
        return clickElement(searchBtn);
    }

    //method to click sorting name column button
    public boolean clickSortingNameColBtn() {
        return clickElement(nameSortingBtn);
    }

    //method to click sorting name Asc option
    public boolean clickSortingNameAscOption() {
        return clickElement(sortingNameAsc);
    }

    //method to click sorting name Desc option
    public boolean clickSortingNameDescOption() {
        return clickElement(sortingNameDesc);
    }

    //method to click pin name column option
    public boolean clickPinNameColumnOption() {
        return clickElement(pinNameColumn);
    }

    //method to click sorting affiliate button
    public boolean clickSortingAffiliateBtn() {
        return clickElement(sortingAffiliateBtn);
    }

    //method to click sorting affiliate column Asc option
    public boolean clickSortingAffiliateAscOption() {
        return clickElement(sortingAffiliateAsc);
    }

    //method to click sorting affiliate column Desc option
    public boolean clickSortingAffiliateDescOption() {
        return clickElement(sortingAffiliateDesc);
    }

    //method to click hide affiliate column option
    public boolean clickHideAffiliateColOption() {
        return clickElement(hideAffiliateColumn);
    }

    //method to click sorting created by button
    public boolean clickSortingCreatedByBtn() {
        return clickElement(sortingCreatedByBtn);
    }

    //method to click sorting created by column Asc option
    public boolean clickSortingCreatedByAscOption() {
        return clickElement(sortingCreatedByAsc);
    }

    //method to click sorting created by column Desc option
    public boolean clickSortingCreatedByDescOption() {
        return clickElement(sortingCreatedByDesc);
    }

    //method to click hide created by column option
    public boolean clickHideCreatedByColOption() {
        return clickElement(hideCreatedByColumn);
    }

    //method to click first row actions button
    public boolean clickFirstRowActions() {
        return clickElement(firstRowActions);
    }

    //method to click second row action button
    public boolean clickSecondRowActions(){
        return clickElement(secondRowActions);
    }

    //method to click first row edit action button
    public boolean clickFirstRowEditAction() {
        return clickElement(firstRowEditAction);
    }

    //method to click first row view parameters action button
    public boolean clickFirstRowViewParametersAction() {
        return clickElement(firstRowViewParametersAction);
    }

    //method to click first row assign to instrument action button
    public boolean clickFirstRowAssignInstrumentAction() {
        return clickElement(firstRowAssignToInstrumentAction);
    }

    //method to click first row delete action button
    public boolean clickFirstRowDeleteAction() {
        return clickElement(firstRowDeleteAction);
    }

    //method to click back page button
    public boolean clickBackPageBtn() {
        return clickElement(backPageBtn);
    }

    //method to click back row button
    public boolean clickBackRowBtn() {
        return clickElement(backRowBtn);
    }

    //method to click froward row button
    public boolean clickFrowardRowBtn() {
        return clickElement(frowardRowBtn);
    }

    //method to click froward page button
    public boolean clickFrowardPageBtn() {
        return clickElement(frowardPageBtn);
    }

    //method to click filter button
    public boolean clickFilterBtn() {
        return clickElement(filterBtn);
    }

    //method to click view button
    public boolean clickViewBtn() {
        return clickElement(viewBtn);
    }

    //method to click toggle to affiliate view
    public boolean clickToggleToAffiliateView() {
        return clickElement(toggleToAffiliateView);
    }

    //method to click toggle to created by view
    public boolean clickToggleToCreatedByView() {
        return clickElement(toggleToCreatedByView);
    }

    //method to click toggle to created at view
    public boolean clickToggleToCreateAtView() {
        return clickElement(toggleToCreatedAtView);
    }

    //method to click toggle to clear pinning view
    public boolean clickToggleToClearPinningView() {
        return clickElement(toggleToClearPanningView);
    }

    //method to click clear sorting view
    public boolean clickClearSortingView() {
        return clickElement(toggleToClearSortingView);
    }

    //</editor-fold>

    //<editor-fold desc = "Click methods for filter window">
    //method to click filter name text field
    public boolean clickFilterNameField() {
        return clickElement(filterName);
    }

    //method to click filter created at text field
    public boolean clickFilterCreatedAtField() {
        return clickElement(filterCreatedAt);
    }

    //method to click filter affiliate text field
    public boolean clickFilterAffiliateField() {
        return clickElement(filterAffiliate);
    }

    //method to click filter cancel button
    public boolean clickFilterCancelBtn() {
        return clickElement(filterCancelBtn);
    }

    //method to click filter clear button
    public boolean clickFilterClearBtn() {
        return clickElement(filterClearBtn);
    }

    //method to click filter apply button
    public boolean clickFilterApplyBtn() {
        return clickElement(filterApplyBtn);
    }

    //method to click filter close button
    public boolean clickFilterCloseBtn() {
        return clickElement(filterCloseBtn);
    }
    //</editor-fold>

    //<editor-fold desc = "Click methods for recipe parameters page">
    //method to click recipe parameters search field
    public boolean clickRecipeParametersSearchField() {
        return clickElement(recipeParameterSearchField);
    }

    //method to click recipe parameters search button
    public boolean clickRecipeParametersSearchBtn() {
        return clickElement(recipeParametersSearchBtn);
    }

    //method to click add parameter button in recipe parameters page
    public boolean clickAddParameterBtn() {
        return clickElement(addParameterBtn);
    }

    //method to click back page button in recipe parameters page
    public boolean clickRecipeParametersBackPageBtn() {
        return clickElement(recipeParametersBackPageBtn);
    }

    //method to click back row button in recipe parameters page
    public boolean clickRecipeParametersBackRowBtn() {
        return clickElement(recipeParametersBckRowBtn);
    }

    //method to click froward row button in recipe parameters page
    public boolean clickRecipeParametersFrowardRowBtn() {
        return clickElement(recipeParametersFrowardRowBtn);
    }

    //method to click froward page button in recipe parameters page
    public boolean clickRecipeParametersFrowardPageBtn() {
        return clickElement(recipeParametersFrowardPageBtn);
    }

    //method to click filter button in recipe parameters page
    public boolean clickFilterRecipeParametersBtn() {
        return clickElement(filterRecipeParametersBtn);
    }

    //method to click view button in recipe parameters page
    public boolean clickViewRecipeParametersBtn() {
        return clickElement(viewRecipeParametersBtn);
    }

    //method to click filter name text field in recipe parameters page
    public boolean clickRecipeParametersFilterName() {
        return clickElement(recipeParametersFilterName);
    }

    //method to click filter created at text field in recipe parameters page
    public boolean clickRecipeParametersFilterCreatedAt() {
        return clickElement(recipeParametersFilterCreatedAt);
    }

    //method to click filter created by text field in recipe parameters page
    public boolean clickRecipeParametersFilterCreatedBy() {
        return clickElement(recipeParametersFilterCreatedBy);
    }

    //method to click filter cancel button in recipe parameters filter window
    public boolean ClickRecipeParametersCancelFilterBtn() {
        return clickElement(recipeParametersCancelFilterBtn);
    }

    //method to click filter clear button in recipe parameters filter window
    public boolean ClickRecipeParametersClearFilterBtn() {
        return clickElement(recipeParametersClearFilterBtn);
    }

    //method to click filter apply button in recipe parameters filter window
    public boolean ClickRecipeParametersApplyFilterBtn() {
        return clickElement(recipeParametersApplyFilterBtn);
    }

    //method to click filter close button in recipe parameters filter window
    public boolean ClickRecipeParametersCloseFilterBtn() {
        return clickElement(recipeParametersCloseFilterBtn);
    }

    //method to click toggle to location view option in recipe parameters
    public boolean ClickToggleToLocationViewRPOption() {
        return clickElement(toggleToLocationViewRP);
    }

    //method to click toggle to slop view option in recipe parameters
    public boolean ClickToggleToSlopViewRPOption() {
        return clickElement(toggleToSlopeViewRP);
    }

    //method to click toggle to min view option in recipe parameters
    public boolean ClickToggleToMinViewRPOption() {
        return clickElement(toggleToMinViewRP);
    }

    //method to click toggle to max view option in recipe parameters
    public boolean ClickToggleToMaxViewRPOption() {
        return clickElement(toggleToMaxViewRP);
    }

    //method to click toggle to mahalanobis view option in recipe parameters
    public boolean ClickToggleToMahalanobisViewRPOption() {
        return clickElement(toggleToMahalanobisViewRP);
    }

    //method to click toggle to create at view option in recipe parameters
    public boolean ClickToggleToCreateAtViewRPOption() {
        return clickElement(toggleToCreatedAtViewRP);
    }

    //method to click toggle to create by view option in recipe parameters
    public boolean ClickToggleToCreateByViewRPOption() {
        return clickElement(toggleToCreatedByViewRP);
    }

    //method to click clear pinning view option in recipe parameters
    public boolean ClickClearPinningViewRPViewRPOption() {
        return clickElement(clearPinningViewRP);
    }

    //method to click clear sorting view option in recipe parameters
    public boolean ClickClearSortingViewRPViewRPOption() {
        return clickElement(clearSortingViewRP);
    }

    //method to click sorting name button in recipe parameters
    public boolean ClickSortingNameRPBtn() {
        return clickElement(nameSortingRPBtn);
    }

    //method to click sorting name Asc option in recipe parameters
    public boolean ClickSortingNameAscRP() {
        return clickElement(sortingRPNameAsc);
    }

    //method to click sorting name Desc option in recipe parameters
    public boolean ClickSortingNameDescRP() {
        return clickElement(sortingRPNameDesc);
    }

    //method to click pin name column option in recipe parameters
    public boolean ClickPinNameRP() {
        return clickElement(pinRPName);
    }

    //method to click sorting alias button in recipe parameters
    public boolean ClickSortingAliasRPBtn() {
        return clickElement(aliasSortingRPBtn);
    }

    //method to click sorting alias Asc option in recipe parameters
    public boolean ClickSortingAliasAscRP() {
        return clickElement(sortingRPAliasAsc);
    }

    //method to click sorting alias Desc option in recipe parameters
    public boolean ClickSortingAliasDescRP() {
        return clickElement(sortingRPAliasDesc);
    }

    //method to click sorting parameter alias button in recipe parameters
    public boolean ClickSortingParameterAliasRPBtn() {
        return clickElement(parameterAliasSortingRPBtn);
    }

    //method to click sorting parameter alias Asc option in recipe parameters
    public boolean ClickSortingParameterAliasAscRP() {
        return clickElement(sortingRPParameterAliasAsc);
    }

    //method to click sorting parameter alias Desc option in recipe parameters
    public boolean ClickSortingParameterAliasDescRP() {
        return clickElement(sortingRPParameterAliasDesc);
    }

    //method to click actions button in recipe parameters
    public boolean ClickFirstRowActionsBtnRP() {
        return clickElement(firstRowActionsBtnInParameters);}

    //<editor-fold desc = "Click methods for calibration files page">

    //method to click view calibration files action in recipe parameters
    public boolean ClickFirstRowViewCalFilesOptionRP() {
        return clickElement(firstRowViewCalibrationActions);
    }

    //method to click recipe parameters search field
    public boolean clickCalibrationFilesSearchField() {
        return clickElement(calibrationFilesSearchField);}

    //method to click calibration files search button
    public boolean clickCalibrationFilesSearchBtn() {
        return clickElement(calibrationFilesSearchBtn);}
    //method to click back page button in calibration files page
    public boolean clickCalibrationFilesBackPageBtn() {
        return clickElement(calibrationFilesBackPageBtn);}

    //method to click back row button in calibration files page
    public boolean clickCalibrationFilesBackRowBtn() {
        return clickElement(calibrationFilesBckRowBtn);}

    //method to click froward row button in calibration files page
    public boolean clickCalibrationFilesFrowardRowBtn() {
        return clickElement(calibrationFilesFrowardRowBtn);}

    //method to click froward page button in calibration files page
    public boolean clickCalibrationFilesFrowardPageBtn() {
        return clickElement(calibrationFilesFrowardPageBtn);}
    //method to click filter button in calibration files page
    public boolean clickFilterCalibrationFilesBtn() {
        return clickElement(calibrationFilesFilterBtn);}

    //method to click view button in calibration files page
    public boolean clickViewCalibrationFilesBtn() {
        return clickElement(calibrationFilesViewBtn);}

    //method to click filter name text field in calibration files page
    public boolean clickCalibrationFilesFilterName() {
        return clickElement(calibrationFilesFilterName);}

    //method to click filter created at text field in calibration files page
    public boolean clickCalibrationFilesFilterCreatedAt() {
        return clickElement(calibrationFilesFilterCreatedAt);}

    //method to click filter created by text field in calibration files page
    public boolean clickCalibrationFilesFilterCreatedBy() {
        return clickElement(calibrationFilesFilterCreatedBy);}

    //method to click filter cancel button in calibration files filter window
    public boolean ClickCalibrationFilesCancelFilterBtn() {
        return clickElement(calibrationFilesCancelFilterBtn);}

    //method to click filter clear button in calibration files filter window
    public boolean ClickCalibrationFilesClearFilterBtn() {
        return clickElement(calibrationFilesClearFilterBtn);}

    //method to click filter apply button in calibration files filter window
    public boolean ClickCalibrationFilesApplyFilterBtn() {
        return clickElement(calibrationFilesApplyFilterBtn);}

    //method to click filter close button in calibration files filter window
    public boolean ClickCalibrationFilesCloseFilterBtn() {
        return clickElement(calibrationFilesCloseFilterBtn);}

    //method to click toggle to create at view option in calibration files
    public boolean ClickToggleToCreateAtViewCalibrationFilesOption() {
        return clickElement(toggleToCreatedAtCalibrationFiles);}

    //method to click toggle to deployed at view option in calibration files
    public boolean ClickToggleToDeployedAtViewCalibrationFilesOption() {
        return clickElement(toggleToDeployedAtCalibrationFiles);}

    //method to click clear pinning view option in calibration files
    public boolean ClickClearPinningViewCalibrationFilesViewRPOption() {
        return clickElement(clearPinningViewCalibrationFiles);}

    //method to click clear sorting view option in calibration files
    public boolean ClickClearSortingViewRPViewCalibrationFilesOption() {
        return clickElement(clearSortingViewCalibrationFiles);}

    //method to click sorting name button in calibration files
    public boolean ClickSortingNameCalibrationFilesBtn() {
        return clickElement(nameSortingRPBtn);}

    //method to click sorting name Asc option in calibration files
    public boolean ClickSortingNameAscCalibrationFiles() {
        return clickElement(sortingCalibrationFilesNameAsc);}

    //method to click sorting name Desc option in calibration files
    public boolean ClickSortingNameDescCalibrationFiles() {
        return clickElement(sortingCalibrationFilesNameDesc);
    }

    //method to click pin name column option in calibration files
    public boolean ClickPinNameCalibrationFiles() {
        return clickElement(pinCalibrationFilesName);
    }

    //method to click on the action button on the calibration files
    public boolean clickOnActionBtnCalibrationFiles(){
        return clickElement(fileActionBtnInSecondRow);
    }

    //method to click expand or collapse button
    public boolean clickExpandBtnCalibrationFiles(){
        return clickElement(expandCalibrationFilesBtn);
    }

    //method to click deploy button on the second row
    public boolean clickOnDeployBtn(){
        return clickElement(deployBtnOnActionList);
    }

    //method to click close button on the deployment popup
    public boolean clickCloseBtnOnDeploymentPopup(){return clickElement(closeBtn);}

    //method to click cancel button on the deployment popup
    public boolean clickCancelBtnOnDeploymentPopup(){return clickElement(cancelBtn);}

    //method to click submit button on the deployment popup
    public boolean clickSubmitBtnOnDeploymentPopup(){return clickElement(submitBtn);}


    //</editor-fold


    /************************Get Text Methods*****************************/
    //<editor-fold desc = "Get text methods for recipe page">
    //method to get recipe page title
    public String getRecipePageTitle() {
        return getElementText(pageTitle);
    }

    //method to get search field text
    public String getSearchFieldText() {
        return getElementText(searchField);
    }

    //method to get first column header text
    public String getFirstHeaderColumnText(){return getElementText(firstColumnHeader);}

    //method to get second column header text
    public String getSecondHeaderColumnText(){return getElementText(secondColumnHeader);}

    //method to get third column header text
    public String getThirdHeaderColumnText(){return getElementText(thirdColumnHeader);}

    //method to get fourth column header text
    public String getFourthHeaderColumnText(){return getElementText(fourthColumnHeader);}

    //method to get fifth column header text
    public String getFifthColumnText(){return  getElementText(fifthColumnHeaderRP);}

    //method to get first row name
    public String getFirstRowName() {
        return getElementText(firstRowName);
    }

    //method to get second row name
    public String getSecondRowName() {return getElementText(secondRowName);
    }

    //method to get first row affiliate
    public String getFirstRowAffiliate() {
        return getElementText(firstRowAffiliate);
    }

    //method to get first row created by
    public String getFirstRowCreatedBy() {
        return getElementText(firstRowCreatedBy);
    }
    //</editor-fold>

    //<editor-fold desc = "Get text methods for filter window">
    //method to get filter window title
    public String getFilterWindowTitle() {
        return getElementText(filterWindowTitle);
    }

    //method to get filter name text
    public String getFilterNameText() {
        return getElementText(filterName);
    }
    //get the created at text in view toggle
    public String getCreatedAtText(){
        return getElementText(toggleToCreatedAtView);
    }
    //method to get filter created at text
    public String getFilterCreatedAt() {
        return getElementText(filterCreatedAt);
    }

    //method to get filter affiliate text
    public String getFilterAffiliateText() {
        return getElementText(filterAffiliate);
    }
    //</editor-fold>

    //<editor-fold desc = "Get text methods for calibration files page">

    //method to get calibration files page title
    public String getCalibrationFilesTitle() {
        return getElementText(calibrationFilesPageTitle);
    }

    //method to get text from calibration files search field
    public String getCalibrationFilesSearchFieldText() {
        return getElementText(calibrationFilesSearchField);
    }

    //method to get calibration files filter window title
    public String getCalibrationFilesFilterWindowTitle() {
        return getElementText(calibrationFilesFilterWindowTitle);
    }

    //method to get calibration files filter created at text field
    public String getCalibrationFilesFilterCreatedAt() {
        return getElementText(calibrationFilesFilterCreatedAt);
    }

    //method to get calibration files filter created by text field
    public String getCalibrationFilesFilterCreatedBy() {
        return getElementText(calibrationFilesFilterCreatedBy);
    }

    //method to get first row name in calibration files page
    public String getFirstRowNameCalibrationFiles() {
        return getElementText(firstRowNameCalibrationFiles);
    }

    //method to get second row name in calibration files page
    public String getSecondRowNameCalibrationFiles() {return getElementText(secondRowNameCalibrationFiles);}

    //method to get recipe parameters page title
    public String getRecipeParametersTitle() {
        return getElementText(recipeParametersPageTitle);
    }

    //method to get text from recipe parameters search field
    public String getRecipeParameterSearchFieldText() {
        return getElementText(recipeParameterSearchField);
    }

    //method to get recipe parameters filter window title
    public String getRecipeParametersFilterWindowTitle() {
        return getElementText(recipeParametersFilterWindowTitle);
    }

    //method to get recipe parameters filter name text field
    public String getRecipeParametersFilterName() {
        return getElementText(recipeParametersFilterName);
    }

    //method to get recipe parameters filter created at text field
    public String getRecipeParametersFilterCreatedAt() {
        return getElementText(recipeParametersFilterCreatedAt);
    }

    //method to get recipe parameters filter created by text field
    public String getRecipeParametersFilterCreatedBy() {
        return getElementText(recipeParametersFilterCreatedBy);
    }

    //method to get first row name in recipe parameters page
    public String getFirstRowNameRP() {
        return getElementText(firstRowNameRP);
    }

    //method to get second row name in recipe parameters page
    public String getSecondRowNameRP() {return getElementText(secondRowNameRP);}

    //method to get first row alias in recipe parameters page
    public String getFirstRowAliasRP() {
        return getElementText(firstRowAliasRP);
    }

    //method to get first row parameter alias in recipe parameters page
    public String getFirstRowParameterAliasRP() {
        return getElementText(firstRowParameterAliasRP);
    }

    //method to get first row bias in recipe parameters page
    public String getFirstRowBiasRP() {
        return getElementText(firstRowBiasRP);
    }


    //</editor-fold


    /************************Set And Reset Text Methods*****************************/
    //<editor-fold desc = "Set and reset text methods for recipe page">
    //method to send text to search field
    public boolean sendTextToSearchField(String text) {
        return sendTextToElement(searchField, text);
    }

    //method to reset search field
    public boolean resetSearchField(String text) {
        return clearText(searchField);
    }

    //method to send text to rows per page field
    public boolean sendTextToRowsPerPageField(String text) {
        return sendTextToElement(rowsPerPage, text);
    }

    //method to clear rows per page field text
    public boolean resetRowsPerPageField() {
        return clearText(rowsPerPage);
    }
    //</editor-fold>

    //<editor-fold desc = "Set and reset methods for filter window">
    //method to send text to filter name field
    public boolean sendTextToFilterNameTextField(String text) {
        return sendTextToElement(filterName, text);
    }

    //method to reset filter name field
    public boolean resetFilterNameTextField(String text) {
        return clearText(filterName);
    }

    //method to send text to filter created at field
    public boolean sendTextToFilterCreatedAtTextField(String text) {
        return sendTextToElement(filterCreatedAt, text);
    }

    //method to reset filter filter created at field
    public boolean resetFilterCreatedAtTextField(String text) {
        return clearText(filterCreatedAt);
    }

    //method to send text to filter affiliate field
    public boolean sendTextToFilterAffiliateTextField(String text) {
        return sendTextToElement(filterAffiliate, text);
    }

    //method to reset filter affiliate field
    public boolean resetFilterAffiliateTextField(String text) {
        return clearText(filterAffiliate);
    }
    //</editor-fold>

    //<editor-fold desc = "Set and reset methods for recipe parameters page">
    //method to send text to search field in recipe parameters page
    public boolean sendTextToRecipeParameterSearchField(String text) {
        return sendTextToElement(recipeParameterSearchField, text);
    }

    //method to clear rows per page field text in recipe parameters page
    public boolean resetRecipeParameterSearchField() {
        return clearText(recipeParameterSearchField);
    }

    //method to send text to rows per page field in recipe parameters page
    public boolean sendTextToRecipeParametersRowsPerPageField(String text) {
        return sendTextToElement(recipeParametersRowsPerPage, text);
    }

    //method to clear rows per page field text in recipe parameters page
    public boolean resetRecipeParametersRowsPerPageField() {
        return clearText(recipeParametersRowsPerPage);
    }

    //method to send text to recipe parameters filter name text field
    public boolean sendTextToRecipeParametersFilterNameField(String text) {
        return sendTextToElement(recipeParametersFilterName, text);
    }

    //method to clear recipe parameters filter name text field
    public boolean resetRecipeParametersFilterNameField() {
        return clearText(recipeParametersFilterName);
    }

    //method to send text to recipe parameters filter created at text field
    public boolean sendTextToRecipeParametersFilterCreatedAtField(String text) {
        return sendTextToElement(recipeParametersFilterCreatedAt, text);
    }

    //method to clear recipe parameters filter created at text field
    public boolean resetRecipeParametersFilterCreatedAtField() {
        return clearText(recipeParametersFilterCreatedAt);
    }

    //method to send text to recipe parameters filter created by text field
    public boolean sendTextToRecipeParametersFilterCreatedByField(String text) {
        return sendTextToElement(recipeParametersFilterCreatedBy, text);
    }

    //method to clear recipe parameters filter created by text field
    public boolean resetRecipeParametersFilterCreatedByField() {
        return clearText(recipeParametersFilterCreatedBy);
    }

    //method to send text to search field in calibration files page
    public boolean sendTextToCalibrationFilesSearchField(String text) {
        return sendTextToElement(calibrationFilesSearchField, text);
    }

    //method to send text to calibration files filter name text field
    public boolean sendTextToCalibrationFilesFilterNameField(String text) {
        return sendTextToElement(calibrationFilesFilterName, text);
    }
    //</editor-fold>
}