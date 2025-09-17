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
    @FindBy(id = "recipe-list-header-text-title")
    public WebElement pageTitle;

    //search field
    @FindBy(id = "recipes-list-table-search-input")
    public WebElement searchField;

    //search button
    @FindBy(id = "recipes-list-table-search-submit")
    public WebElement searchBtn;

    // header of the table list
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/thead/tr")
    public WebElement headerOfTable;

    //first column header in recipe
    @FindBy(id = "recipes-list-table-name-column")
    public WebElement nameColumnHeader;

    //second column header in recipe
    @FindBy(id = "recipes-list-table-affiliateName-column")
    public WebElement affiliateNameColumnHeader;

    //third column header in recipe
    @FindBy(id = "recipes-list-table-createdBy-column")
    public WebElement createdByColumnHeader;

    //fourth column header in recipe
    @FindBy(id = "recipes-list-table-createdAt-column")
    public WebElement recipeCreatedAtColumnHeader;

    //seventh column header in parameter
    @FindBy(id = "avg")
    public WebElement seventhColumnHeaderRP;

    //eighth column header in parameter
    @FindBy(id = "slope")
    public WebElement eighthColumnHeaderRP;

    //ninth column header in parameter
    @FindBy(id = "min")
    public WebElement ninthColumnHeaderRP;

    //tenth column header in parameter
    @FindBy(id = "max")
    public WebElement tenthColumnHeaderRP;

    //manage calibration deployment button
    @FindBy(id="recipe-list-header-button")
    public WebElement manageCalibrationBtn;

    //eleventh column header in parameter
    @FindBy(id = "mahalanobis")
    public WebElement eleventhColumnHeaderRP;

    //twelfth column header in parameter
    @FindBy(id = "createdAt")
    public WebElement twelfthColumnHeaderRP;

    //sorting name Asc
    @FindBy(id = "recipes-list-table-name-column-options-menu-item-asc")
    public WebElement sortingNameAsc;

    //sorting name Desc
    @FindBy(id = "recipes-list-table-name-column-options-menu-item-desc")
    public WebElement sortingNameDesc;

    //pin name column
    @FindBy(id = "recipes-list-table-name-column-options-menu-item-pin")
    public WebElement pinNameColumn;

    //sorting affiliate column
    @FindBy(id = "recipes-list-table-affiliateName-column-options-trigger")
    public WebElement sortingAffiliateBtn;

    //sorting affiliate Asc
    @FindBy(id = "recipes-list-table-affiliateName-column-options-menu-item-asc")
    public WebElement sortingAffiliateAsc;

    //sorting affiliate Desc
    @FindBy(id = "recipes-list-table-affiliateName-column-options-menu-item-desc")
    public WebElement sortingAffiliateDesc;

    //sorting created by column button
    @FindBy(id = "recipes-list-table-createdBy-column")
    public WebElement sortingCreatedByBtn;

    //sorting created by column Asc
    @FindBy(id = "recipes-list-table-createdBy-column-options-menu-item-asc")
    public WebElement sortingCreatedByAsc;

    //sorting created by column Desc
    @FindBy(id = "recipes-list-table-createdBy-column-options-menu-item-desc")
    public WebElement sortingCreatedByDesc;

    //first row name
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[2]")
    public WebElement firstRowName;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[3]")
    public WebElement firstRowAlias;

    //second row name
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[2]/div[2]")
    public WebElement secondRowName;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[2]/div[3]")
    public WebElement secondRowAlias;

    //third row name
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[3]/div[2]")
    public WebElement thirdRowName;

    //first row affiliate
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[3]")
    public WebElement firstRowAffiliate;

    //first row created by
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[4]")
    public WebElement firstRowCreatedBy;

    @FindBy(id="recipes-list-table-filter-input-alias")
    public WebElement aliasFilterInput;

    @FindBy(id = "recipes-list-table-alias-column")
    public WebElement aliasColumnHeader;

    @FindBy(id="recipes-list-table-alias-column-options-menu-item-asc")
    public WebElement sortByAliasAsc;

    @FindBy(id="recipes-list-table-alias-column-options-menu-item-desc")
    public WebElement sortByAliasDesc;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[8]/div[2]")
    public WebElement tableHorizontalScrollBar;

    //first row action button
    @FindBy(id = "recipes-list-table-actions-cell-0")
    public WebElement firstRowActions;

    //second row action button
    @FindBy(id = "recipes-list-table-actions-cell-1")
    public WebElement secondRowActions;

    //third row action button
    @FindBy(id = "recipes-list-table-actions-cell-2")
    public WebElement thirdRowActions;

    //first row edit action
    @FindBy(id = "dropdown-menu-item-recipe-list-table-option-edit")
    public WebElement editOption;

    //first row view parameters action
    @FindBy(id = "dropdown-menu-item-recipe-list-table-option-view-parameters")
    public WebElement RowViewParametersAction;

    //first row assign to instrument action
    @FindBy(id = "dropdown-menu-item-recipe-list-table-option-assign-to-instruments")
    public WebElement firstRowAssignToInstrumentAction;

    //first row delete action
    @FindBy(id = "dropdown-menu-item-recipe-list-table-option-delete")
    public WebElement firstRowDeleteAction;

    //rows per page field
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[4]/div/div/div[1]/div[2]/div/div/div[1]/div[2]/input")
    public WebElement rowsPerPage;

    //back page button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[4]/div/div[2]/div[2]/button[1]")
    public WebElement backPageBtn;

    //back row button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[4]/div/div[2]/div[2]/button[2]")
    public WebElement backRowBtn;

    //froward row button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[4]/div/div[2]/div[2]/button[3]")
    public WebElement frowardRowBtn;

    //froward page button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[4]/div/div[2]/div[2]/button[4]")
    public WebElement frowardPageBtn;

    //filter button
    @FindBy(id = "recipes-list-table-filter-button")
    public WebElement filterBtn;

    //view button
    @FindBy(id = "recipes-list-table-viewing-options")
    public WebElement viewBtn;

    //toggle to affiliate view
    @FindBy(id = "/html/body/div[2]/div/div[3]")
    public WebElement toggleToAffiliateView;

    //toggle to created by view
    @FindBy(id = "createdBy")
    public WebElement toggleToCreatedByView;

    //toggle to created at view
    @FindBy(id = "createdAt")
    public WebElement toggleToCreatedAtView;

    //toggle to clear pinning view
    @FindBy(xpath = "/html/body/div[2]/div/div[7]")
    public WebElement toggleToClearPanningView;

    //toggle to clear sorting view
    @FindBy(id = "recipes-list-table-viewing-options-dropdown-menu-item-clear-sorting")
    public WebElement toggleToClearSortingView;
    //</editor-fold>

    //<editor-fold desc = "Allocators for filter window">
    //filter window title
    @FindBy(xpath = "/html/body/div[3]/div/h4")
    public WebElement filterWindowTitle;

    //filter name text field
    @FindBy(id = "recipes-list-table-filter-input-name")
    public WebElement filterName;

    //filter created at text field
    @FindBy(id = "recipes-list-table-filter-dateRange-createdAt-from-vstack")
    public WebElement filterCreatedAtFrom;

    @FindBy(id = "recipes-list-table-filter-dateRange-createdAt-to-vstack")
    public WebElement filterCreatedAtTo;

    //filter affiliate text field
    @FindBy(id="recipes-list-table-filter-select-affiliates-input")
    public WebElement filterAffiliate;

    //filter cancel button
    @FindBy(id = "recipes-list-table-filter-button-cancel")
    public WebElement filterCancelBtn;

    //filter clear button
    @FindBy(id = "recipes-list-table-filter-button-clear")
    public WebElement filterClearBtn;

    //filter apply button
    @FindBy(id = "recipes-list-table-filter-button-submit")
    public WebElement filterApplyBtn;

    //filter close button
    @FindBy(id = "recipes-list-table-filter-icon-close")
    public WebElement filterCloseBtn;
    //</editor-fold>

    //<editor-fold desc = "Allocators for recipe parameters page">
    //recipe page title
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[1]/div[1]/div[1]/h4")
    public WebElement recipeParametersPageTitle;

    //parameter search field
    @FindBy(id = "recipes-parameters-list-table-search-input")
    public WebElement recipeParameterSearchField;

    //search button
    @FindBy(id = "recipes-parameters-list-table-search-submit")
    public WebElement recipeParametersSearchBtn;

    //recipe parameters bias column
    @FindBy(id="recipes-parameters-list-table-bias-column")
    public WebElement recipeParameterBiasColumn;

    @FindBy(id="recipes-parameters-list-table-avg-column")
    public WebElement recipeParameterAvgColumn;

    @FindBy(id="recipes-parameters-list-table-slope-column")
    public WebElement recipeParameterSlopeColumn;

    @FindBy(id="recipes-parameters-list-table-min-column")
    public WebElement recipeParameterMinColumn;

    @FindBy(id="recipes-parameters-list-table-max-column")
    public WebElement recipeParameterMaxColumn;

    @FindBy(id="recipes-parameters-list-table-mahalanobis-column")
    public WebElement recipeParameterMahalanobisColumn;

    @FindBy(id="recipes-parameters-list-table-createdBy-column")
    public WebElement recipeParameterCreatedByColumn;

    //add parameter button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[1]/div[1]/div[2]/button")
    public WebElement addParameterBtn;

    //rows per page field
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[4]/div/div/div[1]/div[2]/div/div/div[1]/div[2]/input")
    public WebElement recipeParametersRowsPerPage;

    //back page button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[4]/div/div[2]/div[2]/button[1]")
    public WebElement recipeParametersBackPageBtn;

    //back row button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[4]/div/div[2]/div[2]/button[2]")
    public WebElement recipeParametersBckRowBtn;

    //froward row button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[4]/div/div[2]/div[2]/button[3]")
    public WebElement recipeParametersFrowardRowBtn;

    //froward page button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[4]/div/div[2]/div[2]/button[4]")
    public WebElement recipeParametersFrowardPageBtn;

    //filter button in recipe parameters page
    @FindBy(id = "recipes-parameters-list-table-filter-button")
    public WebElement filterRecipeParametersBtn;

    //recipe parameters filter window title
    @FindBy(xpath = "/html/body/div[3]/div/h4")
    public WebElement recipeParametersFilterWindowTitle;

    //name text field in recipe parameters filter window
    @FindBy(id = "recipes-parameters-list-table-filter-input-name")
    public WebElement recipeParametersFilterName;

    //created at text field in recipe parameters filter window
    @FindBy(id = "recipes-parameters-list-table-filter-dateRange-createdAt-from")
    public WebElement recipeParametersFilterCreatedAtFrom;

    //created at text field in recipe parameters filter window
    @FindBy(id = "recipes-parameters-list-table-filter-dateRange-createdAt-to")
    public WebElement recipeParametersFilterCreatedAtTo;

    //created by text field in recipe parameters filter window
    @FindBy(xpath = "/html/body/div[3]/form/div[1]/div[3]/div/div/div[1]/div[2]/input")
    public WebElement recipeParametersFilterCreatedBy;

    //cancel filter button in recipe parameters filter window
    @FindBy(id = "recipes-parameters-list-table-filter-button-cancel")
    public WebElement recipeParametersCancelFilterBtn;

    //clear filter button in recipe parameters filter window
    @FindBy(id = "recipes-parameters-list-table-filter-button-clear")
    public WebElement recipeParametersClearFilterBtn;

    //apply filter button in recipe parameters filter window
    @FindBy(id = "recipes-parameters-list-table-filter-button-submit")
    public WebElement recipeParametersApplyFilterBtn;

    //close filter button in recipe parameters filter window
    @FindBy(id = "recipes-parameters-list-table-filter-icon-close")
    public WebElement recipeParametersCloseFilterBtn;

    //view button in recipe parameters page
    @FindBy(id = "recipes-parameters-list-table-viewing-options")
    public WebElement viewRecipeParametersBtn;

    //toggle to location view
    @FindBy(xpath = "/html/body/div[2]/div/div[3]")
    public WebElement toggleToLocationViewRP;

    //toggle to bias view
    @FindBy(id = "bias")
    public WebElement toggleToBiasViewRP;

    //toggle to slope view
    @FindBy(id = "slope")
    public WebElement toggleToSlopeViewRP;

    //toggle to min view
    @FindBy(id = "min")
    public WebElement toggleToMinViewRP;

    //toggle to max view
    @FindBy(id = "max")
    public WebElement toggleToMaxViewRP;

    //toggle to mahalanobis view
    @FindBy(id = "mahalanobis")
    public WebElement toggleToMahalanobisViewRP;

    //toggle to created by view
    @FindBy(xpath = "/html/body/div[2]/div/div[8]")
    public WebElement toggleToCreatedByViewRP;

    //toggle to created at view
    @FindBy(id = "createdAt")
    public WebElement toggleToCreatedAtViewRP;

    //toggle to index at view
    @FindBy(id = "index")
    public WebElement toggleToIndexViewRP;

    //toggle to Avg at view
    @FindBy(id = "avg")
    public WebElement toggleToAvgViewRP;

    //clear any pinning view option
    @FindBy(xpath = "/html/body/div[2]/div/div[11]")
    public WebElement clearPinningViewRP;

    //clear any sorting view option
    @FindBy(id = "recipes-parameters-list-table-viewing-options-dropdown-menu-item-clear-sorting")
    public WebElement clearSortingViewRP;

    //name sorting button in recipe parameters page
    @FindBy(id = "recipes-parameters-list-table-name-column")
    public WebElement nameSortingRPBtn;

    //sorting name column in recipe parameters page Asc
    @FindBy(id = "recipes-parameters-list-table-name-column-options-menu-item-asc")
    public WebElement sortingRPNameAsc;

    @FindBy(id="recipes-list-table-name-column-options-menu-item-asc")
    public WebElement sortRecipeNameAsc;

    @FindBy(id="recipes-list-table-name-column-options-menu-item-desc")
    public WebElement sortRecipeNameDesc;
    //sorting name column in recipe parameters page Desc
    @FindBy(id = "recipes-parameters-list-table-name-column-options-menu-item-desc")
    public WebElement sortingRPNameDesc;

    //index sorting button in recipe parameters page
    @FindBy(id = "recipes-parameters-list-table-index-column")
    public WebElement indexSortingRPBtn;

    //sorting name column in recipe parameters page Asc
    @FindBy(id = "recipes-parameters-list-table-index-column-options-menu-item-asc")
    public WebElement sortingRPIndexAsc;

    //sorting name column in recipe parameters page Desc
    @FindBy(id = "recipes-parameters-list-table-index-column-options-menu-item-desc")
    public WebElement sortingRPIndexDesc;

    //pin name column in recipe parameters page
    @FindBy(id = "recipes-parameters-list-table-name-column-options-menu-item-pin")
    public WebElement pinRPName;

    //sorting alias button in recipe parameters page
    @FindBy(id = "recipes-parameters-list-table-alias-column")
    public WebElement aliasSortingRPBtn;

    //sorting alias column in recipe parameters page Asc
    @FindBy(id = "recipes-parameters-list-table-alias-column-options-menu-item-asc")
    public WebElement sortingRPAliasAsc;

    //sorting alias column in recipe parameters page Desc
    @FindBy(id = "recipes-parameters-list-table-alias-column-options-menu-item-desc")
    public WebElement sortingRPAliasDesc;

    //sorting parameter alias button in recipe parameters page
    @FindBy(id = "recipes-parameters-list-table-paramAlias-column")
    public WebElement parameterAliasSortingRPBtn;

    //sorting parameter alias column in recipe parameters page Asc
    @FindBy(id = "recipes-parameters-list-table-paramAlias-column-options-menu-item-asc")
    public WebElement sortingRPParameterAliasAsc;

    //sorting parameter alias column in recipe parameters page Desc
    @FindBy(id = "recipes-parameters-list-table-paramAlias-column-options-menu-item-desc")
    public WebElement sortingRPParameterAliasDesc;

    //first row name in recipe parameter page
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[2]")
    public WebElement firstRowNameRP;

    //second row name in recipe parameter page
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[2]/div[2]")
    public WebElement secondRowNameRP;

    //first row alias in recipe parameter page
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[3]")
    public WebElement firstRowAliasRP;

    //first row parameter alias in recipe parameter page
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[4]")
    public WebElement firstRowParameterAliasRP;

    //first row bias in recipe parameter page
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[6]")
    public WebElement firstRowBiasRP;

    //first row actions button in recipe parameter page
    @FindBy(id = "recipes-parameters-list-table-actions-cell-0")
    public WebElement firstRowActionsBtnInParameters;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[1]/div[2]/div/div")
    public WebElement viewCalibrationFilesGridHeader;


    //first row view calibration files action
    @FindBy(id = "dropdown-menu-item-recipe-parameter-list-table-option-view-calibration")
    public WebElement firstRowViewCalibrationActions;
    //</editor-fold

    //<editor-fold desc = "Allocators for Calibration files page">

    //Calibration files page title
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[1]/div[1]/div[1]/h4")
    public WebElement calibrationFilesPageTitle;

    //calibration files search field
    @FindBy(id = "recipes-calibration-list-table-search-input")
    public WebElement calibrationFilesSearchField;

    //search button
    @FindBy(id = "recipes-calibration-list-table-search-submit")
    public WebElement calibrationFilesSearchBtn;

    //rows per page field
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[4]/div/div/div[1]/div[2]/div/div/div[1]/div[2]/input")
    public WebElement rowsPerPageCalibrationFiles;

    //back page button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[4]/div/div/div[2]/div[2]/button[1]")
    public WebElement calibrationFilesBackPageBtn;

    //back row button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[4]/div/div/div[2]/div[2]/button[2]")
    public WebElement calibrationFilesBckRowBtn;

    //froward row button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[4]/div/div/div[2]/div[2]/button[3]")
    public WebElement calibrationFilesFrowardRowBtn;

    //froward page button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[4]/div/div/div[2]/div[2]/button[4]")
    public WebElement calibrationFilesFrowardPageBtn;

    //filter button in calibration files
    @FindBy(id = "recipes-calibration-list-table-filter-button")
    public WebElement calibrationFilesFilterBtn;

    //view button in calibration files
    @FindBy(id = "recipes-calibration-list-table-viewing-options")
    public WebElement calibrationFilesViewBtn;

    //calibration files filter window title
    @FindBy(xpath = "/html/body/div[3]/div/h4")
    public WebElement calibrationFilesFilterWindowTitle;

    //name text field in calibration Files filter window
    @FindBy(id = "recipes-calibration-list-table-filter-input-name")
    public WebElement calibrationFilesFilterName;

    //created at text field in calibration files filter window
    @FindBy(id = "recipes-calibration-list-table-filter-dateRange-createdAt-from")
    public WebElement calibrationFilesFilterCreatedAtFrom;

    @FindBy(id = "recipes-calibration-list-table-filter-dateRange-createdAt-to")
    public WebElement calibrationFilesFilterCreatedAtTo;

    //created by text field in calibration files filter window
    @FindBy(xpath = "/html/body/div[3]/form/div[1]/div[3]/div/div/div[1]/div[2]/input")
    public WebElement calibrationFilesFilterCreatedBy;

    //cancel filter button in calibration files filter window
    @FindBy(id = "recipes-calibration-list-table-filter-button-cancel")
    public WebElement calibrationFilesCancelFilterBtn;

    //clear filter button in calibration files filter window
    @FindBy(id = "recipes-calibration-list-table-filter-button-clear")
    public WebElement calibrationFilesClearFilterBtn;

    //apply filter button in calibration files filter window
    @FindBy(id = "recipes-calibration-list-table-filter-button-submit")
    public WebElement calibrationFilesApplyFilterBtn;

    //close filter button in calibration files filter window
    @FindBy(xpath = "/html/body/div[3]/button")
    public WebElement calibrationFilesCloseFilterBtn;

    //toggle to created at view
    @FindBy(id = "createdBy")
    public WebElement toggleToCreatedByCalibrationFiles;

    //toggle to created at view
    @FindBy(id = "createdAt")
    public WebElement toggleToCreatedAtCalibrationFiles;

    //toggle to deployed at view
    @FindBy(id = "deployedAt")
    public WebElement toggleToDeployedAtCalibrationFiles;

    //clear any pinning view option
    @FindBy(xpath = "/html/body/div[2]/div/div[6]")
    public WebElement clearPinningViewCalibrationFiles;

    //clear any sorting view option
    @FindBy(id = "recipes-calibration-list-table-viewing-options-dropdown-menu-item-clear-sorting")
    public WebElement clearSortingViewCalibrationFiles;

    @FindBy(id = "recipes-calibration-list-table-name-column")
    public WebElement calibrationFilesTableNameColumn;

    //sorting name column in calibration files page Asc
    @FindBy(id = "recipes-calibration-list-table-name-column-options-menu-item-asc")
    public WebElement sortingCalibrationFilesNameAsc;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[1]")
    public WebElement firstCalibrationExpandBtn;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[2]/div[1]")
    public WebElement secondCalibrationExpandBtn;

    @FindBy(id="recipes-list-table-pagination-navigators-next-page")
    public WebElement nextPageTablePagination;

    @FindBy(id="recipes-list-table-pagination-navigators-previous-page")
    public WebElement previousPageTablePagination;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div[1]/div")
    public WebElement tsvTableButtons;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[1]")
    public WebElement expandFirstRowTsvTable;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[4]/div/div/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div")
    public WebElement tsvTableRecords;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[4]/div/div/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div")
    public WebElement calibrationFilesTableRecords;

    @FindBy(id="affiliates-list-table-actions-cell-1")
    public WebElement secondCalibrationFileVersionActionBtn;

    @FindBy(id="affiliates-list-table-actions-cell-2")
    public WebElement thirdCalibrationFileVersionActionBtn;

    @FindBy(id="navbar-breadcrumbs-desktop-view")
    public WebElement navBarBreadCrumbs;

    @FindBy(id="dropdown-menu-item-deploy")
    public WebElement deployOptionAction;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/div/div/div/h4")
    public WebElement deployCalibrationFilePopupHeader;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/div/div/div/div[3]/button")
    public WebElement deployCalibrationFilePopupCancelBtn;




    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/div/div/div/div[4]/button")
    public WebElement deployCalibrationFilePopupCancelAnotherBtn;
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[2]")
    public WebElement firstCalibrationFileName;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[2]/div[2]")
    public WebElement secondCalibrationFileName;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[5]")
    public WebElement firstCalibrationFileCreatedAt;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[2]/div[5]")
    public WebElement secondCalibrationFileCreatedAt;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[6]")
    public WebElement firstCalibrationFileDeployedAt;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[2]/div[6]")
    public WebElement secondCalibrationFileDeployedAt;

    @FindBy(id="recipes-calibration-list-table-deployedAt-column-options-menu-item-asc")
    public WebElement calibrationSortDeployedAtAsc;

    @FindBy(id="recipes-calibration-list-table-deployedAt-column-options-menu-item-desc")
    public WebElement calibrationSortDeployedAtDesc;

    //sorting name column in calibration files page Desc
    @FindBy(id = "recipes-calibration-list-table-name-column-options-menu-item-desc")
    public WebElement sortingCalibrationFilesNameDesc;

    //pin name column in calibration files page
    @FindBy(id = "recipes-calibration-list-table-name-column-options-menu-item-pin")
    public WebElement pinCalibrationFilesName;

    //first row name in calibration files page
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr[1]/td[2]/div/p")
    public WebElement firstRowNameCalibrationFiles;

    //first row type in the calibration files page
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr[1]/td[3]/div/p")
    public WebElement firstRowTypeCalibrationFiles;

    //second row name in calibration files page
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr[2]/td[2]/div/p")
    public WebElement secondRowNameCalibrationFiles;

    //second row type in the calibration files page
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr[2]/td[3]/div/p")
    public WebElement secondRowTypeCalibrationFiles;

    //first column header in calibration files
    @FindBy(id = "recipes-calibration-list-table-name-column")
    public WebElement nameRecipesColumnHeader;

    //second column header in calibration files
    @FindBy(id = "recipes-calibration-list-table-type-column")
    public WebElement typeColumnHeader;

    //third column header in calibration files
    @FindBy(id = "recipes-calibration-list-table-createdBy-column")
    public WebElement createdByRecipesColumnHeader;

    //fourth column header in calibration files
    @FindBy(id = "recipes-calibration-list-table-createdAt-column")
    public WebElement createdAtColumnHeader;

    @FindBy(id="recipes-calibration-list-table-createdAt-column-options-menu-item-asc")
    public WebElement calibrationCreatedAtAsc;

    @FindBy(id="recipes-calibration-list-table-createdAt-column-options-menu-item-desc")
    public WebElement calibrationCreatedAtDesc;

    //fifth column header in calibration files
    @FindBy(id = "recipes-calibration-list-table-deployedAt-column")
    public WebElement deplyedAtCalibrationColumn;


    //expand and collapse the calibration files button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr[1]/td[1]/div")
    public WebElement expandCalibrationFilesBtn;

    //file status in first row calibration files
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/div/div[1]/table/tbody/tr[1]/td[1]/div/div")
    public WebElement filesStatusInFirstRow;

    //file created at in first row calibration files
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/div/div[1]/table/tbody/tr[1]/td[2]/p")
    public WebElement filesCreatedAtInFirstRow;

    //file modified at in first row calibration files
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/div/div[1]/table/tbody/tr[1]/td[3]/p")
    public WebElement filesModifiedAtInFirstRow;

    //file deployed at in first row calibration files
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/div/div[1]/table/tbody/tr[1]/td[4]/p")
    public WebElement filesDeployedAtInFirstRow;

    //file status in second row calibration files
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/div/div[1]/table/tbody/tr[2]/td[1]/div/div")
    public WebElement filesStatusInSecondRow;

    //file created at in second row calibration files
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/div/div[1]/table/tbody/tr[2]/td[2]/p")
    public WebElement filesCreatedAtInSecondRow;

    //file modified at in second row calibration files
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/div/div[1]/table/tbody/tr[2]/td[3]/p")
    public WebElement filesModifiedAtInSecondRow;

    //file deployed at in second row calibration files
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/div/div[1]/table/tbody/tr[2]/td[4]/p")
    public WebElement filesDeployedAtInSecondRow;

    //file action button for the second row
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/div/div[1]/table/tbody/tr[3]/td[5]/button")
    public WebElement fileActionBtnInSecondRow;

    //file deploy button on the action list on the second row
    @FindBy(xpath = "/html/body/div[2]/div")
    public WebElement deployBtnOnActionList;

    //submit button in the deploy popup after clicking deploy button
    @FindBy(xpath = "/html/body/div[3]/div[3]/div/button")
    public WebElement submitBtn;

    //cancel button in the deploy popup after clicking deploy button
    @FindBy(xpath = "/html/body/div[3]/div[3]/button")
    public WebElement cancelBtn;

    //close button after in the deploy popup after clicking deploy button
    @FindBy(xpath = "/html/body/div[3]/button")
    public WebElement closeBtn;

    //deploy popup title
    @FindBy(xpath = "/html/body/div[3]/h4")
    public WebElement deployPopupTitle;
}
