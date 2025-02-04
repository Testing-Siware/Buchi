package pages;

import org.openqa.selenium.Keys;
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
    public WebElement instrumentsPageTitle;


    //search text field
    @FindBy(id = "recipes-list-table-search-input")
    public WebElement searchField;

    //search button
    @FindBy(id = "recipes-list-table-search-submit")
    public WebElement searchBtn;

    //seventh column header
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/thead/tr/th[8]/div/div/div")
    public WebElement eigthColHeader;

    //filter button
    @FindBy(id = "instruments-list-table-filter-hstack")
    public WebElement filterBtn;

    //view button
    @FindBy(id = "instruments-list-table-viewing-options")
    public WebElement viewBtn;

    //toggle the created at view
    @FindBy(id = "createdAt")
    public WebElement toggleCreatedAtColumnOption;

    //toggle the last updated at view
    @FindBy(id = "lastUpdatedAt")
    public WebElement toggleLastUpdatedAtColumnOption;

    //clear any pinning
    @FindBy(xpath = "/html/body/div[2]/div/div[6]")
    public WebElement clearPinningOption;

    //clear any sorting
    @FindBy(id = "recipes-list-table-viewing-options-dropdown-menu-item-clear-sorting")
    public WebElement clearSortingOption;

    //second instrument name
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[2]/div[1]")
    public WebElement secondInstrumentName;

    //second instrument serial
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[2]/div[2]")
    public WebElement secondSerialNumber;

    //name sorting button
    @FindBy(id = "instruments-list-table-name-column")
    public WebElement nameSortingBtn;

    //sorting name Asc
    @FindBy(id = "instruments-list-table-name-column-options-menu-item-asc")
    public WebElement sortingNameAsc;

    //sorting name Desc
    @FindBy(id = "instruments-list-table-name-column-options-menu-item-desc")
    public WebElement sortingNameDesc;

    //pin name column
    @FindBy(id = "instruments-list-table-name-column-options-menu-item-pin")
    public WebElement pinNameColumn;

    //sorting serial number button
    @FindBy(id = "serialNumber")
    public WebElement serialNumberSortingBtn;

    //sorting serial number Asc
    @FindBy(id = "instruments-list-table-serialNumber-column-options-menu-item-asc")
    public WebElement sortingSerialNumberAsc;

    //sorting serial number Desc
    @FindBy(id = "instruments-list-table-serialNumber-column-options-menu-item-desc")
    public WebElement sortingSerialNumberDesc;

    //sorting created by button
    @FindBy(id = "instruments-list-table-createdBy-column")
    public WebElement sortingCreatedByBtn;

    //second created at date
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr[2]/td[7]")
    public WebElement secondCreatedAtDate;

    //sorting created by Asc
    @FindBy(id = "instruments-list-table-createdBy-column-options-menu-item-asc")
    public WebElement sortingCreatedByAsc;

    //sorting created by Desc
    @FindBy(id = "instruments-list-table-createdBy-column-options-menu-item-desc")
    public WebElement sortingCreatedByDesc;

    //sorting created at button
    @FindBy(id = "instruments-list-table-createdAt-column")
    public WebElement sortingCreatedAtBtn;

    //sorting created at Asc
    @FindBy(id = "instruments-list-table-createdAt-column-options-menu-item-asc")
    public WebElement sortingCreatedAtAsc;

    //sorting created at Desc
    @FindBy(id = "instruments-list-table-createdAt-column-options-menu-item-desc")
    public WebElement sortingCreatedAtDesc;

    //hide created at column
    @FindBy(id = "instruments-list-table-createdAt-column-options-menu-item-hide")
    public WebElement hideCreatedAtColumn;

    //first row name
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[1]")
    public WebElement firstRowName;

    //first row serial number
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[2]")
    public WebElement firstRowSerialNumber;

    //first row type
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[3]")
    public WebElement firstRowType;

    //first row affiliate
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[4]")
    public WebElement firstRowAffiliate;

    //first row model
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[5]")
    public WebElement firstRowModel;

    //first row installation point
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[6]")
    public WebElement firstRowInstallationPoint;

    //first row created by
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[7]")
    public WebElement firstRowCreatedBy;

    //first row created at
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[8]")
    public WebElement firstRowCreatedAt;

    //first row updated at
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[9]")
    public WebElement firstRowUpdatedAt;

    //first row options button
    @FindBy(id = "instruments-list-table-actions-cell-0")
    public WebElement firstRowOptionsBtn;

    //first row edit option
    @FindBy(id = "dropdown-menu-item-instrument-list-table-options-edit")
    public WebElement firstRowEditOption;

    //rows per page field
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[4]/div/div[1]/div[2]/div/div/div[1]/div[2]/input")
    public WebElement rowsPerPage;

    //back page button
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[4]/div/div[2]/div[2]/button[1]")
    public WebElement backPageBtn;

    //back row button
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[4]/div/div[2]/div[2]/button[2]")
    public WebElement backRowBtn;

    //froward row button
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[4]/div/div[2]/div[2]/button[3]")
    public WebElement frowardRowBtn;

    //froward page button
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[4]/div/div[2]/div[2]/button[4]")
    public WebElement frowardPageBtn;
    //</editor-fold>

    //<editor-fold desc="Allocators for filter window">
    //filter name text field
    @FindBy(id = "instruments-list-table-filter-input-name")
    public WebElement filterNameTextField;

    //filter serial number text field
    @FindBy(id = "instruments-list-table-filter-input-serialNumber")
    public WebElement filterSerialNumber;

    //filter type field
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[1]/div/div[2]/div/div/div/form/div[1]/div[3]/div/div/div[1]/div[2]/input")
    public WebElement filterTypeField;

    //filter model text field
    @FindBy(id = "instruments-list-table-filter-input-model")
    public WebElement filterModelTextField;

    //filter cancel button
    @FindBy(id = "instruments-list-table-filter-button-cancel")
    public WebElement filterCancelBtn;

    //clear filters button
    @FindBy(id = "instruments-list-table-filter-button-clear")
    public WebElement clearFiltersBtn;

    //apply filters button
    @FindBy(id = "instruments-list-table-filter-button-submit")
    public WebElement applyFilterBtn;
    //</editor-fold>

    //sort by name option
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/thead/tr/th[1]/div/div/div")
    public WebElement sortByNameBtn;

    //<editor-fold desc="Allocators for edit instrument page">
    //edit page instrument name
    @FindBy(id = "instrument-form-input-name")
    public WebElement editName;

    @FindBy(id = "instrument-form-input-installationPoint")
    public WebElement installationPointTextField;

    @FindBy(id = "instrument-form-container-button-submit")
    public WebElement submitEditBtn;

    //edit page instrument serial number
    @FindBy(id = "instrument-form-input-serialNumber")
    public WebElement editSerialNumber;

    //edit page instrument serial type
    @FindBy(id = "instrument-form-input-type")
    public WebElement editType;

    //edit page instrument model
    @FindBy(id = "instrument-form-input-model")
    public WebElement editModel;

    //error message appearing under instrument name
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div/div/div[1]/div[2]/span")
    public WebElement errorMsgNameRequired;

    //cancel edit point
    @FindBy(id = "instrument-form-container-button-cancel")
    public WebElement cancelEditBtn;

    //reset edit point
    @FindBy(id = "instrument-form-container-button-clear")
    public WebElement resetEditBtn;

    //save edit point
    @FindBy(id = "instrument-form-container-button-submit")
    public WebElement saveEditBtn;
}