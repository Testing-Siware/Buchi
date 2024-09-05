package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utiles.MethodHandles;

public class InstrumentsPage extends MethodHandles {

    public InstrumentsPage(ChromeDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    /************************Allocators*****************************/
    //<editor-fold desc="Allocators for instruments page">
    //instruments page title
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[1]/div[1]/div[1]/h4")
    private WebElement instrumentsPageTitle;

    //search text field
    @FindBy(id = "search")
    private WebElement searchField;

    //search button
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[2]/form/div/button")
    private WebElement searchBtn;

    //filter button
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div/div/button")
    private WebElement filterBtn;

    //view button
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div/button")
    private WebElement viewBtn;

    //toggle the created at view
    @FindBy(xpath = "/html/body/div[2]/div/div[3]")
    private WebElement toggleCreatedAtColumnOption;

    //toggle the last updated at view
    @FindBy(xpath = "/html/body/div[2]/div/div[4]")
    private WebElement toggleLastUpdatedAtColumnOption;

    //clear any pinning
    @FindBy(xpath = "/html/body/div[2]/div/div[6]")
    private WebElement clearPinningOption;

    //clear any sorting
    @FindBy(xpath = "/html/body/div[2]/div/div[7]")
    private WebElement clearSortingOption;

    //name sorting button
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[3]/table/thead/tr/th[1]/div/div/div")
    private WebElement nameSortingBtn;

    //sorting name Asc
    @FindBy(xpath = "/html/body/div[2]/div/div[1]")
    private WebElement sortingNameAsc;

    //sorting name Desc
    @FindBy(xpath = "/html/body/div[2]/div/div[1]")
    private WebElement sortingNameDesc;

    //pin name column
    @FindBy(xpath = "/html/body/div[2]/div/div[4]")
    private WebElement pinNameColumn;

    //sorting serial number button
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[3]/table/thead/tr/th[2]/div/div/div")
    private WebElement serialNumberSortingBtn;

    //sorting serial number Asc
    @FindBy(xpath="/html/body/div[2]/div/div[1]")
    private WebElement sortingSerialNumberAsc;

    //sorting serial number Desc
    @FindBy(xpath="/html/body/div[2]/div/div[2]")
    private WebElement sortingSerialNumberDesc;

    //sorting created by button
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[3]/table/thead/tr/th[7]/div/div/div")
    private WebElement sortingCreatedByBtn;

    //sorting created by Asc
    @FindBy(xpath = "/html/body/div[2]/div/div[1]")
    private WebElement sortingCreatedByAsc;

    //sorting created by Desc
    @FindBy(xpath = "/html/body/div[2]/div/div[2]")
    private WebElement sortingCreatedByDesc;

    //sorting created at button
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[3]/table/thead/tr/th[8]/div/div/div")
    private WebElement sortingCreatedAtBtn;

    //sorting created at Asc
    @FindBy(xpath = "/html/body/div[2]/div/div[1]")
    private WebElement sortingCreatedAtAsc;

    //sorting created at Desc
    @FindBy(xpath = "/html/body/div[2]/div/div[2]")
    private WebElement sortingCreatedAtDesc;

    //hide created at column
    @FindBy(xpath = "/html/body/div[2]/div/div[4]")
    private WebElement hideCreatedAtColumn;

    //first row name
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[3]/table/tbody/tr[1]/td[1]/div/p")
    private WebElement firstRowName;

    //first row serial number
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[3]/table/tbody/tr[1]/td[2]/div/p")
    private WebElement firstRowSerialNumber;

    //first row type
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[3]/table/tbody/tr[1]/td[3]/div/p")
    private WebElement firstRowType;

    //first row affiliate
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[3]/table/tbody/tr[1]/td[4]/div/p")
    private WebElement firstRowAffiliate;

    //first row model
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[3]/table/tbody/tr[1]/td[5]/div/p")
    private WebElement firstRowModel;

    //first row installation point
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[3]/table/tbody/tr[1]/td[6]/div/p")
    private WebElement firstRowInstallationPoint;

    //first row created by
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[3]/table/tbody/tr[1]/td[7]/div/p")
    private WebElement firstRowCreatedBy;

    //first row created at
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[3]/table/tbody/tr[1]/td[8]/p")
    private WebElement firstRowCreatedAt;

    //first row options button
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[3]/table/tbody/tr[1]/td[9]/button")
    private WebElement firstRowOptionsBtn;

    //first row edit option
    @FindBy(xpath = "/html/body/div[2]/div/div")
    private WebElement firstRowEditOption;

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
    //</editor-fold>

    //<editor-fold desc="Allocators for filter window">
    //filter name text field
    @FindBy(xpath = "/html/body/div[3]/form/div[1]/div[1]/div/div/div/input")
    private WebElement filterNameTextField;

    //filter serial number text field
    @FindBy(xpath = "/html/body/div[3]/form/div[1]/div[2]/div/div/div/input")
    private WebElement filterSerialNumber;

    //filter type field
    @FindBy(xpath = "/html/body/div[3]/form/div[1]/div[3]/div/div/div[1]/div[2]/input")
    private WebElement filterTypeField;

    //filter model text field
    @FindBy(xpath = "/html/body/div[3]/form/div[1]/div[4]/div/div/div/input")
    private WebElement filterModelTextField;

    //filter cancel button
    @FindBy(xpath = "/html/body/div[3]/form/div[2]/button")
    private WebElement filterCancelBtn;

    //clear filters button
    @FindBy(xpath = "/html/body/div[3]/form/div[2]/div/button[1]")
    private WebElement clearFiltersBtn;

    //apply filters button
    @FindBy(xpath = "/html/body/div[3]/form/div[2]/div/button[2]")
    private WebElement applyFilterBtn;
    //</editor-fold>

    //<editor-fold desc="Allocators for edit instrument page">
    //edit page instrument name
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/form/div/div[3]/div/div/div[1]/div/div/div/input")
    private WebElement editName;

    //edit page instrument serial number
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/form/div/div[3]/div/div/div[2]/div/div/div/input")
    private WebElement editSerialNumber;

    //edit page instrument serial type
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/form/div/div[3]/div/div/div[3]/div/div/div[1]/div[2]/input")
    private WebElement editType;

    //edit page instrument model
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/form/div/div[3]/div/div/div[4]/div/div/div/input")
    private WebElement editModel;

    //edit page instrument installation point
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/form/div/div[3]/div/div/div[2]/div/div/div/input")
    private WebElement editInstallationPoint;

    //cancel edit point
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/form/div/div[4]/button")
    private WebElement cancelEditBtn;

    //reset edit point
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/form/div/div[4]/div/button[1]")
    private WebElement resetEditBtn;

    //save edit point
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/form/div/div[4]/div/button[2]")
    private WebElement saveEditBtn;
    //</editor-fold>


    /************************Is Displayed Methods*****************************/
    //<editor-fold desc="Is displayed methods for instruments page">
    //method check if instruments page title is displayed
    public boolean instrumentsPageTitleIsDisplayed() {
        return isDisplayed(instrumentsPageTitle, 10);
    }

    //method check if search field is displayed
    public boolean searchFieldIsDisplayed() {
        return isDisplayed(searchField, 10);
    }

    //method check if search button is displayed
    public boolean searchBtnIsDisplayed() {
        return isDisplayed(searchBtn, 10);
    }

    //method check if filter button is displayed
    public boolean filterBtnIsDisplayed() {
        return isDisplayed(filterBtn, 10);
    }

    //method check if view button is displayed
    public boolean viewBtnIsDisplayed() {
        return isDisplayed(viewBtn, 10);
    }

    //method check if toggle created at column option is displayed
    public boolean toggleCreatedAtColumnOptionIsDisplayed() {
        return isDisplayed(toggleCreatedAtColumnOption, 10);
    }

    //method check if toggle last update at column option is displayed
    public boolean toggleLastUpdateAtColumnOptionIsDisplayed() {
        return isDisplayed(toggleLastUpdatedAtColumnOption, 10);
    }

    //method check if clear pinning option is displayed
    public boolean clearPinningOptionIsDisplayed() {
        return isDisplayed(clearPinningOption, 10);
    }

    //method check if clear sorting option is displayed
    public boolean clearSortingOptionIsDisplayed() {
        return isDisplayed(clearSortingOption, 10);
    }

    //method check if created at column is displayed
    public boolean createdAtColumnIsDisplayed() {
        return isDisplayed(sortingCreatedAtBtn, 10);
    }

    //method check if first row name is displayed
    public boolean firstRowNameIsDisplayed() {
        return isDisplayed(firstRowName, 10);
    }

    //method check if first row serial number is displayed
    public boolean firstRowSerialNumberIsDisplayed() {
        return isDisplayed(firstRowSerialNumber, 10);
    }

    //method check if first row type is displayed
    public boolean firstRowTypeIsDisplayed() {
        return isDisplayed(firstRowType, 10);
    }

    //method check if first row affiliate is displayed
    public boolean firstRowAffiliateIsDisplayed() {
        return isDisplayed(firstRowAffiliate, 10);
    }

    //method check if first row model is displayed
    public boolean firstRowModelIsDisplayed() {
        return isDisplayed(firstRowModel, 10);
    }

    //method check if first row installation point is displayed
    public boolean firstRowFirstRowInstallationPointIsDisplayed() {
        return isDisplayed(firstRowInstallationPoint, 10);
    }

    //method check if first row created by is displayed
    public boolean firstRowCreatedByIsDisplayed() {
        return isDisplayed(firstRowCreatedBy, 10);
    }

    //method check if first row created at is displayed
    public boolean firstRowCreatedAtIsDisplayed() {
        return isDisplayed(firstRowCreatedAt, 10);
    }

    //method check if first row options button is displayed
    public boolean firstRowOptionsBtnIsDisplayed() {
        return isDisplayed(firstRowOptionsBtn, 10);
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
    //</editor-fold>

    //<editor-fold desc="Is displayed methods for filter window">
    //method check if filter name text field is displayed
    public boolean filterNameTextFieldIsDisplayed() {
        return isDisplayed(filterNameTextField, 10);
    }

    //method check if filter serial number text field is displayed
    public boolean filterSerialNumberTextFieldIsDisplayed() {
        return isDisplayed(filterSerialNumber, 10);
    }

    //method check if filter type text field is displayed
    public boolean filterTypeTextFieldIsDisplayed() {
        return isDisplayed(filterTypeField, 10);
    }

    //method check if filter model text field is displayed
    public boolean filterModelTextFieldIsDisplayed() {
        return isDisplayed(filterModelTextField, 10);
    }

    //method check if cancel filter button is displayed
    public boolean cancelFilterBtnIsDisplayed() {
        return isDisplayed(filterCancelBtn, 10);
    }

    //method check if clear filters button is displayed
    public boolean clearFiltersBtnIsDisplayed() {
        return isDisplayed(clearFiltersBtn, 10);
    }

    //method check if apply filter button is displayed
    public boolean applyFilterBtnIsDisplayed() {
        return isDisplayed(applyFilterBtn, 10);
    }
    //</editor-fold>

    //<editor-fold desc="Is displayed methods for edit instrument page">
    //method check if edit name text field is displayed
    public boolean editNameTextFieldIsDisplayed() {
        return isDisplayed(editName, 10);
    }

    //method check if edit serial number text field is displayed
    public boolean editSerialNumberTextFieldIsDisplayed() {
        return isDisplayed(editSerialNumber, 10);
    }

    //method check if edit type text field is displayed
    public boolean editTypeTextFieldIsDisplayed() {
        return isDisplayed(editType, 10);
    }

    //method check if edit model text field is displayed
    public boolean editModelTextFieldIsDisplayed() {
        return isDisplayed(editModel, 10);
    }

    //method check if edit installation point text field is displayed
    public boolean editInstallationPointTextFieldIsDisplayed() {
        return isDisplayed(editInstallationPoint, 10);
    }

    //method check if edit cancel button is displayed
    public boolean editCancelBtnIsDisplayed() {
        return isDisplayed(cancelEditBtn, 10);
    }

    //method check if edit reset button is displayed
    public boolean editResetBtnIsDisplayed() {
        return isDisplayed(resetEditBtn, 10);
    }

    //method check if edit save button is displayed
    public boolean editSaveBtnIsDisplayed() {
        return isDisplayed(saveEditBtn, 10);
    }
    //</editor-fold>


    /************************Click Methods****************************/
    //<editor-fold desc="Click methods for instruments page">
    //method to click Search field
    public boolean clickSearchField() {
        return clickElement(searchField);
    }

    //method to click Search button
    public boolean clickSearchBtn() {
        return clickElement(searchBtn);
    }

    //method to click filter button
    public boolean clickFilterBtn() {
        return clickElement(filterBtn);
    }

    //method to click view button
    public boolean clickViewBtn() {
        return clickElement(viewBtn);
    }

    //method to click toggle created at column option
    public boolean clickToggleCreatedAtColumnOption() {
        return clickElement(toggleCreatedAtColumnOption);
    }

    //method to click toggle last updated at column option
    public boolean clickToggleLastUpdatedAtColumnOption() {
        return clickElement(toggleLastUpdatedAtColumnOption);
    }

    //method to click clear pinning option
    public boolean clickClearPinningOption() {
        return clickElement(clearPinningOption);
    }

    //method to click clear sorting option
    public boolean clickClearSortingOption() {
        return clickElement(clearSortingOption);
    }

    //method to click name sorting button
    public boolean clickNameSortingBtn() {
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

    //method to click pin name option
    public boolean clickPinNameOption() {
        return clickElement(pinNameColumn);
    }

    //method to click sorting serial number button
    public boolean clickSerialNumberSortingBtn() {
        return clickElement(serialNumberSortingBtn);
    }

    //method to click sorting serial number Asc option
    public boolean clickSortingSerialNumberAscOption() {
        return clickElement(sortingSerialNumberAsc);
    }

    //method to click sorting serial number Desc option
    public boolean clickSortingSerialNumberDescOption() {
        return clickElement(sortingSerialNumberDesc);
    }

    //method to click sorting created by button
    public boolean clickSortingCreatedByBtn() {
        return clickElement(sortingCreatedByBtn);
    }

    //method to click sorting created by Asc option
    public boolean clickSortingCreatedByAscOption() {
        return clickElement(sortingCreatedByAsc);
    }

    //method to click sorting created by Desc option
    public boolean clickSortingCreatedByDescOption() {
        return clickElement(sortingCreatedByDesc);
    }

    //method to click sorting created at button
    public boolean clickSortingCreatedAtBtn() {
        return clickElement(sortingCreatedAtBtn);
    }

    //method to click sorting created at Asc option
    public boolean clickSortingCreatedAtAscOption() {
        return clickElement(sortingCreatedAtAsc);
    }

    //method to click sorting created at Desc option
    public boolean clickSortingCreatedAtDescOption() {
        return clickElement(sortingCreatedAtDesc);
    }

    //method to click hide created at column option
    public boolean clickHideCreatedAtColumnOption() {
        return clickElement(hideCreatedAtColumn);
    }

    //method to click first row options button
    public boolean clickFirstRowOptionsBtn() {
        return clickElement(firstRowOptionsBtn);
    }

    //method to click first row edit option
    public boolean clickFirstRowEditOption() {
        return clickElement(firstRowEditOption);
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
    //</editor-fold>

    //<editor-fold desc="Click methods for filter window">
    //method to click filter name field
    public boolean clickFilterNameTextField() {
        return clickElement(filterNameTextField);
    }

    //method to click filter serial number field
    public boolean clickFilterSerialNumberTextField() {
        return clickElement(filterSerialNumber);
    }

    //method to click filter type field
    public boolean clickFilterTypeTextField() {
        return clickElement(filterTypeField);
    }

    //method to click filter model field
    public boolean clickFilterModelTextField() {
        return clickElement(filterModelTextField);
    }

    //method to click filter cancel button
    public boolean clickFilterCancelBtn() {
        return clickElement(filterCancelBtn);
    }

    //method to click clear filters button
    public boolean clickClearFiltersBtn() {
        return clickElement(clearFiltersBtn);
    }

    //method to click apply filter button
    public boolean clickApplyFilterBtn() {
        return clickElement(applyFilterBtn);
    }
    //</editor-fold>

    //<editor-fold desc="Click methods for edit instrument page">
    //method to click edit name text field
    public boolean clickEditNameTextField() {
        return clickElement(editName);
    }

    //method to click edit serial number text field
    public boolean clickEditSerialNumberTextField() {
        return clickElement(editSerialNumber);
    }

    //method to click edit Type text field
    public boolean clickEditTypeTextField() {
        return clickElement(editType);
    }

    //method to click edit Model text field
    public boolean clickEditModelTextField() {
        return clickElement(editModel);
    }

    //method to click edit installation point text field
    public boolean clickEditInstallationPointTextField() {
        return clickElement(editInstallationPoint);
    }

    //method to click edit cancel button
    public boolean clickEditCancelBtn() {
        return clickElement(cancelEditBtn);
    }

    //method to click edit reset button
    public boolean clickEditResetBtn() {
        return clickElement(resetEditBtn);
    }

    //method to click edit save button
    public boolean clickEditSaveBtn() {
        return clickElement(saveEditBtn);
    }
    //</editor-fold>


    /************************Get Text Methods*****************************/
    //<editor-fold desc="Get Text methods for instruments page">
    //method to get search field text
    public String getSearchFieldText() {
        return getElementText(searchField);
    }

    //method to get instruments page title text
    public String getInstrumentsPageTitle() {
        return getElementText(instrumentsPageTitle);
    }

    //method to get first row name text
    public String getFirstRowNameText() {
        return getElementText(firstRowName);
    }

    //method to get first row serial number text
    public String getFirstRowSerialNumberText() {
        return getElementText(firstRowSerialNumber);
    }

    //method to get first row type text
    public String getFirstRowTypeText() {
        return getElementText(firstRowType);
    }

    //method to get first row affiliate text
    public String getFirstRowAffiliateText() {
        return getElementText(firstRowAffiliate);
    }

    //method to get first row model text
    public String getFirstRowModelText() {
        return getElementText(firstRowModel);
    }

    //method to get first row installation point text
    public String getFirstRowInstallationPointText() {
        return getElementText(firstRowInstallationPoint);
    }

    //method to get first row created by text
    public String getFirstRowCreatedByText() {
        return getElementText(firstRowCreatedBy);
    }

    //method to get first row created at text
    public String getFirstRowCreatedAtText() {
        return getElementText(firstRowCreatedAt);
    }
    //</editor-fold>

    //<editor-fold desc="Get Text Methods for filter window">
    //method to get filter name text field text
    public String getFilterNameFieldText() {
        return getElementText(filterNameTextField);
    }

    //method to get filter serial number text field text
    public String getFilterSerialNumberFieldText() {
        return getElementText(filterSerialNumber);
    }

    //method to get filter type text field text
    public String getFilterTypeFieldText() {
        return getElementText(filterTypeField);
    }

    //method to get filter model text field text
    public String getFilterModelFieldText() {
        return getElementText(filterModelTextField);
    }
    //</editor-fold>

    //<editor-fold desc="Get text methods for edit instrument page">
    //method to get edit name text field text
    public String getEditNameFieldText() {
        return getElementText(editName);
    }

    //method to get edit serial number text field text
    public String getEditSerialNumberFieldText() {
        return getElementText(editSerialNumber);
    }

    //method to get edit type text field text
    public String getEditTypeFieldText() {
        return getElementText(editType);
    }

    //method to get edit model text field text
    public String getEditModelFieldText() {
        return getElementText(editModel);
    }

    //method to get edit installation point text field text
    public String getEditInstallationPointFieldText() {
        return getElementText(editInstallationPoint);
    }
    //</editor-fold>


    /************************Set And Reset Text Methods*****************************/
    //<editor-fold desc="Set And Reset Text methods for instruments page">
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

    //<editor-fold desc="Set and reset text methods for filter window">

    //method to send text to filter name text field
    public boolean sendTextToFilterNameTextField(String text) {
        return sendTextToElement(filterNameTextField, text);
    }

    //method to reset filter name text field
    public boolean resetFilterNameField(String text) {
        return clearText(filterNameTextField);
    }

    //method to send text to filter serial number text field
    public boolean sendTextToFilterSerialNumberTextField(String text) {
        return sendTextToElement(filterSerialNumber, text);
    }

    //method to reset filter serial number text field
    public boolean resetFilterSerialNumberField(String text) {
        return clearText(filterSerialNumber);
    }

    //method to send text to filter type text field
    public boolean sendTextToFilterTypeTextField(String text) {
        return sendTextToElement(filterTypeField, text);
    }

    //method to reset filter type text field
    public boolean resetFilterTypeField(String text) {
        return clearText(filterTypeField);
    }

    //method to send text to filter model text field
    public boolean sendTextToFilterModelTextField(String text) {
        return sendTextToElement(filterModelTextField, text);
    }

    //method to reset filter model text field
    public boolean resetFilterModelField(String text) {
        return clearText(filterModelTextField);
    }
    //</editor-fold

    //<editor-fold desc="Set and reset text methods for edit instrument page">
    //method to send text to edit name text field
    public boolean sendTextToEditNameTextField(String text) {
        return sendTextToElement(editName, text);
    }

    //method to reset edit name text field
    public boolean resetEditNameField(String text) {
        return clearText(editName);
    }

    //method to send text to edit serial number text field
    public boolean sendTextToEditSerialNumberTextField(String text) {
        return sendTextToElement(editSerialNumber, text);
    }

    //method to reset edit serial number text field
    public boolean resetEditSerialNumberField(String text) {
        return clearText(editSerialNumber);
    }

    //method to send text to edit type text field
    public boolean sendTextToEditTypeTextField(String text) {
        return sendTextToElement(editType, text);
    }

    //method to reset edit type text field
    public boolean resetEditTypeField(String text) {
        return clearText(editType);
    }

    //method to send text to edit model text field
    public boolean sendTextToEditModelTextField(String text) {
        return sendTextToElement(editModel, text);
    }

    //method to reset edit model text field
    public boolean resetEditModelField(String text) {
        return clearText(editModel);
    }

    //method to send text to edit installation point text field
    public boolean sendTextToEditInstallationPointTextField(String text) {
        return sendTextToElement(editInstallationPoint, text);
    }

    //method to reset edit installation point text field
    public boolean resetEditInstallationPointField(String text) {
        return clearText(editInstallationPoint);
    }
    //</editor-fold>
}