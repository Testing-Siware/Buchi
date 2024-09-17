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
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[1]/div[1]/h4")
    private WebElement pageTitle;

    //search field
    @FindBy(id = "search")
    private WebElement searchField;

    //search button
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[2]/form/div/button")
    private WebElement searchBtn;

    //name column sorting button
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[3]/table/thead/tr/th[2]/div/div/div")
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
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[3]/table/thead/tr/th[3]/div/div/div")
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
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[3]/table/thead/tr/th[4]/div/div/div")
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
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[3]/table/tbody/tr[1]/td[2]/div/p")
    private WebElement firstRowName;

    //first row affiliate
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[3]/table/tbody/tr[1]/td[3]/div/p")
    private WebElement firstRowAffiliate;

    //first row created by
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[3]/table/tbody/tr[1]/td[4]/div/p")
    private WebElement firstRowCreatedBy;

    //first row action button
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[3]/table/tbody/tr[1]/td[5]/button")
    private WebElement firstRowActions;

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
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[4]/div/div[1]/div[2]/div/div/div[1]/div[2]/input")
    private WebElement rowsPerPage;

    //back page button
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[4]/div/div[2]/div[2]/button[1]")
    private WebElement backPageBtn;

    //back row button
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[4]/div/div[2]/div[2]/button[2]")
    private WebElement backRowBtn;

    //froward row button
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[4]/div/div[2]/div[2]/button[3]")
    private WebElement frowardRowBtn;

    //froward page button
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[4]/div/div[2]/div[2]/button[4]")
    private WebElement frowardPageBtn;

    //filter button
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div/div/button")
    private WebElement filterBtn;

    //view button
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div/button")
    private WebElement viewBtn;

    //toggle to affiliate view
    @FindBy(xpath = "/html/body/div[2]/div/div[3]")
    private WebElement toggleToAffiliateView;

    //toggle to created by view
    @FindBy(xpath = "/html/body/div[2]/div/div[3]")
    private WebElement toggleToCreatedByView;

    //toggle to created at view
    @FindBy(xpath = "/html/body/div[2]/div/div[3]")
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
    @FindBy(xpath = "/html/body/div[3]/button/svg")
    private WebElement filterCloseBtn;
    //</editor-fold>

    //<editor-fold desc = "Allocators for recipe parameters page">
    //recipe page title
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[1]/div[1]/h4")
    private WebElement recipeParametersPageTitle;

    //parameter search field
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[2]/form/div/div/div/div/div/input")
    private WebElement recipeParameterSearchField;

    //search button
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[2]/form/div/button")
    private WebElement recipeParametersSearchBtn;

    //add parameter button
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[1]/div[2]/button")
    private WebElement addParameterBtn;

    //rows per page field
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[4]/div/div[1]/div[2]/div/div/div[1]/div[2]/input")
    private WebElement recipeParametersRowsPerPage;

    //back page button
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[4]/div/div[2]/div[2]/button[1]")
    private WebElement recipeParametersBackPageBtn;

    //back row button
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[4]/div/div[2]/div[2]/button[2]")
    private WebElement recipeParametersBckRowBtn;

    //froward row button
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[4]/div/div[2]/div[2]/button[3]")
    private WebElement recipeParametersFrowardRowBtn;

    //froward page button
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[4]/div/div[2]/div[2]/button[4]")
    private WebElement recipeParametersFrowardPageBtn;

    //filter button in recipe parameters page
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div/div/button")
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
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div/button")
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
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[3]/table/thead/tr/th[2]/div/div/div")
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
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[3]/table/thead/tr/th[3]/div/div/div")
    private WebElement aliasSortingRPBtn;

    //sorting alias column in recipe parameters page Asc
    @FindBy(xpath = "/html/body/div[2]/div/div[1]")
    private WebElement sortingRPAliasAsc;

    //sorting alias column in recipe parameters page Desc
    @FindBy(xpath = "/html/body/div[2]/div/div[2]")
    private WebElement sortingRPAliasDesc;

    //sorting parameter alias button in recipe parameters page
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[3]/table/thead/tr/th[4]/div/div/div")
    private WebElement parameterAliasSortingRPBtn;

    //sorting parameter alias column in recipe parameters page Asc
    @FindBy(xpath = "/html/body/div[2]/div/div[1]")
    private WebElement sortingRPParameterAliasAsc;

    //sorting parameter alias column in recipe parameters page Desc
    @FindBy(xpath = "/html/body/div[2]/div/div[2]")
    private WebElement sortingRPParameterAliasDesc;

    //first row name in recipe parameter page
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[3]/table/tbody/tr/td[2]/div/p")
    private WebElement firstRowNameRP;

    //first row alias in recipe parameter page
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[3]/table/tbody/tr/td[3]/div/p")
    private WebElement firstRowAliasRP;

    //first row parameter alias in recipe parameter page
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[3]/table/tbody/tr/td[4]/div/p")
    private WebElement firstRowParameterAliasRP;

    //first row bias in recipe parameter page
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[3]/table/tbody/tr/td[5]/div/p")
    private WebElement firstRowBiasRP;

    //first row actions button in recipe parameter page
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[3]/table/tbody/tr/td[6]/button")
    private WebElement firstRowActionsBtn;

    //first row view calibration files action
    @FindBy(xpath = "/html/body/div[2]/div/div")
    private WebElement firstRowViewCalibrationActions;
    //</editor-fold


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
        return clickElement(firstRowActionsBtn);
    }

    //method to click view calibration files action in recipe parameters
    public boolean ClickFirstRowViewCalFilesOptionRP() {
        return clickElement(firstRowViewCalibrationActions);
    }
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

    //method to get first row name
    public String getFirstRowName() {
        return getElementText(firstRowName);
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

    //method to get filter created at text
    public String getFilterCreatedAt() {
        return getElementText(filterCreatedAt);
    }

    //method to get filter affiliate text
    public String getFilterAffiliateText() {
        return getElementText(filterAffiliate);
    }
    //</editor-fold>

    //<editor-fold desc = "Get text methods for recipe parameters page">
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

    //method to send text to filter filter created at field
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
    //</editor-fold>
}