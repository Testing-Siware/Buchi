package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utiles.MethodHandles;

public class LicensePage extends MethodHandles {
    //constructor
    public LicensePage(ChromeDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "licenses-list-table-organization.name-column")
    public WebElement licenseNameColumnHeader;

    @FindBy(id="licenses-list-table-organization.name-column-options-menu-item-asc")
    public WebElement sortLicenseNameAscOption;

    @FindBy(id="licenses-list-table-organization.name-column-options-menu-item-desc")
    public WebElement sortLicenseNameDescOption;

    @FindBy(id = "licenses-list-table-status-column")
    public WebElement licenseStatusColumnHeader;

    @FindBy(id="licenses-list-table-status-column-options-menu-item-asc")
    public WebElement sortLicenseStatusAscOption;

    @FindBy(id="licenses-list-table-status-column-options-menu-item-asc")
    public WebElement sortLicenseStatusDescOption;



    @FindBy(xpath="/html/body/div/div[1]/div[3]/div[2]/div/div[3]/div/div/div/div[2]/div[2]/button")
    public WebElement cancelLicenseCopyBtn;

    @FindBy(id="licenses-list-table-actions-cell-0")
    public WebElement licenseTableFirstRowActionCell;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[1]")
    public WebElement licenseTableFirstRowName;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[2]/div[1]")
    public WebElement licenseTableSecondRowName;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[2]/div[2]/div")
    public WebElement licenseTableSecondtRowStatus;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div/div[1]")
    public WebElement licenseTableFirstRowAffiliate;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div/div[2]")
    public WebElement licenseTableFirstRowStatus;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div/div[3]")
    public WebElement licenseTableFirstRowInstruments;

    @FindBy(id = "licenses-list-table-search-input")
    public WebElement licenseSearchInput;

    //confirm license generate butto
    @FindBy(id="affiliate-list-alert-dialog-button-confirm")
    public WebElement confirmLicenseGenerateBtn;

    @FindBy(id = "affiliate-list-alert-dialog-button-cancel")
    public WebElement cancelLicenseGenerateBtn;

    @FindBy(id="affiliate-licenses-button")
    public WebElement licensesBtn;

    @FindBy(id="license-list-add-section-button")
    public WebElement generateLicenseBtn;

    @FindBy(id="license-form-select-organizationId-input")
    public WebElement licenseAffiliateDropdown;

    @FindBy(id = "license-form-input-instruments")
    public WebElement licenseInstrumentField;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div[2]/div[1]/button")
    public WebElement licenseAddInstrumentBtn;

    @FindBy(id="license-form-container-button-cancel")
    public WebElement licenseCancelBtn;

    @FindBy(id="license-form-container-button-clear")
    public WebElement licenseClearBtn;

    @FindBy(id="license-form-container-button-submit")
    public WebElement licenseSubmitBtn;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div[2]/div[2]")
    public WebElement licenseAddedInstruments;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div[1]/div/div/div[2]/span")
    public WebElement licenseAffiliateRequiredMsg;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div[2]/div[1]/div/div/div[2]/span")
    public WebElement licenseInstrumentRequiredMsg;

    @FindBy(id="license-instrument-delete-button")
    public WebElement licenseDeleteInstrumentBtn;

    @FindBy(id = "licenses-list-table-search-submit")
    public WebElement licenseSearchBtn;

    @FindBy(id="licenses-list-table-filter-button")
    public WebElement licenseFilterBtn;

    @FindBy(id="licenses-list-table-filter-button-clear")
    public WebElement clearFilterBtn;

    @FindBy(id="licenses-list-table-filter-button-submit")
    public  WebElement filterSubmitBtn;

    @FindBy(id="licenses-list-table-filter-button-cancel")
    public WebElement cancelFilterBtn;

    @FindBy(id="dropdown-menu-item-editLicense")
    public WebElement editLicenseOption;

    @FindBy(id="dropdown-menu-item-viewLicense")
    public WebElement viewLicenseOption;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/div/div/div/div[2]/div[1]/button")
    public WebElement copyLicenseBtn;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/div/div/div/div[2]/div[2]/button")
    public WebElement cancelCopyLicenseBtn;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[1]/div[1]/div[1]")
    public WebElement licensePageTitle;

}
