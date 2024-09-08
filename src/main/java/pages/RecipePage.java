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
    public boolean filterNameTxtField() {
        return isDisplayed(filterName, 10);
    }

    //method check if filter created at text field is displayed
    public boolean filterCreatedAtTxtField() {
        return isDisplayed(filterCreatedAt, 10);
    }

    //method check if filter affiliate text field is displayed
    public boolean filterAffiliateTxtField() {
        return isDisplayed(filterAffiliate, 10);
    }

    //method check if filter cancel button is displayed
    public boolean filterCancelBtn() {
        return isDisplayed(filterCancelBtn, 10);
    }

    //method check if filter clear button is displayed
    public boolean filterClearBtn() {
        return isDisplayed(filterClearBtn, 10);
    }

    //method check if filter apply button is displayed
    public boolean filterApplyBtn() {
        return isDisplayed(filterApplyBtn, 10);
    }

    //method check if filter close button is displayed
    public boolean filterCloseBtn() {
        return isDisplayed(filterCloseBtn, 10);
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
}
