package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utiles.MethodHandles;


public class AffiliatePage extends MethodHandles {
    //constructor
    public AffiliatePage(ChromeDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    
    /************************Allocators*****************************/
    //<editor-fold desc="Affiliates page allocators">
    //sidebar button expands and collapses it
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[1]/div[1]/div[1]/button")
    private WebElement sidebarBtn;

    //profile icon
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[1]/div[2]/div[1]/div/span/span")
    private WebElement profileIconBtn;

    //profile name
    @FindBy(xpath = "/html/body/div[2]/div/div[1]/div/div/span")
    private WebElement profileName;

    //sign out button
    @FindBy(xpath = "/html/body/div[2]/div/div[2]")
    private WebElement signOutBtn;

    //change theme button
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[1]/div[2]/button[2]")
    private WebElement changeThemeBtn;

    //change language button
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[1]/div[2]/button[1]")
    private WebElement changeLanguageBtn;

    //first language option (English)
    @FindBy(xpath = "/html/body/div[2]/div/div[3]")
    private WebElement firstLanguageOption;

    //second language option (Portuguese)
    @FindBy(xpath = "/html/body/div[2]/div/div[4]")
    private WebElement secondLanguageOption;

    //third language option (Chinese)
    @FindBy(xpath = "/html/body/div[2]/div/div[5]")
    private WebElement thirdLanguageOption;

    //fourth language option (Korean)
    @FindBy(xpath = "/html/body/div[2]/div/div[6]")
    private WebElement fourthLanguageOption;

    //fifth language option (Polish)
    @FindBy(xpath = "/html/body/div[2]/div/div[7]")
    private WebElement fifthLanguageOption;

    //sixth language option (Spanish)
    @FindBy(xpath = "/html/body/div[2]/div/div[8]")
    private WebElement sixthLanguageOption;

    //button to return to homepage
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[1]/div[1]/nav/ol/li[1]/button")
    private WebElement homeBtn;

    //dashboard button in sidebar
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div[1]/div")
    private WebElement dashboardSidebarBtn;

    //analytics button in sidebar
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div[2]/div")
    private WebElement analyticsBtn;

    //instruments button in sidebar
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div[3]/div")
    private WebElement instrumentsBtn;

    //recipes button in sidebar
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div[4]/div")
    private WebElement recipesBtn;

    //journals button in sidebar
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div[5]/div")
    private WebElement journalsBtn;

    //alerts button in sidebar
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div[6]/div")
    private WebElement alertsBtn;

    //users button in sidebar
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div[8]/div")
    private WebElement usersBtn;

    //help and support sidebar btn
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div[3]/div[2]/div")
    private WebElement helpAndSupportBtn;

    //affiliates page title
    @FindBy(id = "affiliate-list-add-section-text-content")
    private WebElement affiliatesPageTitle;

    //add affiliates button
    @FindBy(id = "affiliate-list-add-section-button")
    private WebElement addAffiliateBtn;

    //search field to search by user
    @FindBy(id="search")
    private WebElement searchField;

    //search button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/form/div/button")
    private WebElement searchBtn;

    //filter button
    @FindBy(id = "affiliate-list-table-filter-button")
    private WebElement filterBtn;

    //views button
    @FindBy(id = "affiliate-list-table-viewing-option-dropdown-trigger")
    private WebElement viewBtn;

    //toggle the created at view
    @FindBy(xpath = "/html/body/div[2]/div/div[3]")
    private WebElement toggleCreatedAtColumnOption;

    //toggle the modified at view
    @FindBy(xpath = "/html/body/div[2]/div/div[4]")
    private WebElement toggleModifiedAtColumnOption;

    //clear any pinning
    @FindBy(xpath = "/html/body/div[2]/div/div[6]")
    private WebElement clearPinningOption;

    //clear any sorting
    @FindBy(xpath = "/html/body/div[2]/div/div[7]")
    private WebElement clearSortingOption;

    //name sorting
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/thead/tr/th[2]/div/div/div")
    private WebElement nameSortingBtn;

    //sorting name asc
    @FindBy(xpath = "/html/body/div[2]/div/div[1]")
    private WebElement sortingNameAsc;

    //sorting name desc
    @FindBy(xpath = "/html/body/div[2]/div/div[2]")
    private WebElement sortingNameDesc;

    //pin column
    @FindBy(xpath = "/html/body/div[2]/div/div[4]")
    private WebElement pinColumn;

    //max users sorting
    @FindBy(xpath = "/html/body/div[1]/div[1]/div[3]/div[2]/div/div[3]/table/thead/tr/th[4]/div/div/div")
    private WebElement usersCountSortingBtn;

    //sorting users count asc
    @FindBy(xpath = "/html/body/div[2]/div/div[1]")
    private WebElement sortingUsersCountAsc;

    //sorting users count desc
    @FindBy(xpath = "/html/body/div[2]/div/div[1]")
    private WebElement sortingUsersCountDesc;

    //name of first affiliate in the table
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr[1]/td[2]/div")
    private WebElement firstAffiliateName;

    //type of first affiliate in the table
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr/td[3]/div")
    private WebElement firstAffiliateType;

    //users count of first affiliate in the table
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr[1]/td[5]/div")
    private WebElement firstAffiliateUsersCount;

    //max users count of first affiliate in the table
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[3]/table/tbody/tr[1]/td[5]/div/p")
    private WebElement firstAffiliateMaxUsers;

    //status of first affiliate in the table
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[3]/table/tbody/tr[1]/td[6]/div/div")
    private WebElement firstAffiliateStatus;

    //option of first affiliate in the table
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr/td[7]/button")
    private WebElement firstAffiliateOptionsBtn;

    //edit option of first affiliate in the table
    @FindBy(xpath = "/html/body/div[2]/div/div[1]")
    private WebElement firstAffiliateEditBtn;

    //delete option of first affiliate in the table
    @FindBy(xpath = "/html/body/div[2]/div/div[3]")
    private WebElement firstAffiliateDeleteBtn;

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

    //<editor-fold desc="Add affiliate page allocators">
    //add affiliates page title
    @FindBy(id = "affiliate-form-container-typography-title")
    private WebElement addAffiliatePageTitle;

    //upload logo
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div/div/div[1]/div/div/div/button")
    private WebElement uploadLogoBtn;

    //affiliate name text field
    @FindBy(id = "affiliate-form-input-name")
    private WebElement affiliateName;

    //max users field
    @FindBy(id = "affiliate-form-input-maxUsersNumber")
    private WebElement maxUsers;

    //abbreviation text field
    @FindBy(id = "affiliate-form-input-abbreviation")
    private WebElement affiliateAbbreviation;

    //affiliate type
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div/div/div[4]/div/div/div[1]/div[2]/input")
    private WebElement affiliateType;

    //cancel button
    @FindBy(id = "affiliate-form-container-button-cancel")
    private WebElement cancelBtn;

    //reset button
    @FindBy(id = "affiliate-form-container-button-clear")
    private WebElement resetBtn;

    //save button
    @FindBy(id = "affiliate-form-container-button-submit")
    private WebElement saveBtn;
    //</editor-fold>

    //<editor-fold desc="Filter window allocators">
    //title
    @FindBy(xpath = "/html/body/div[3]/div/h4")
    private WebElement filterPopTitle;

    //filter affiliate name
    @FindBy(xpath = "/html/body/div[3]/form/div[1]/div[1]/div/div/div/input")
    private WebElement filterAffiliateName;

    //filter affiliate type
    @FindBy(xpath = "/html/body/div[3]/form/div[1]/div[2]/div/div/div[1]/div[2]/input")
    private WebElement filterAffiliateType;

    //filter cancel button
    @FindBy(xpath = "/html/body/div[3]/form/div[2]/button")
    private WebElement cancelFilterBtn;

    //clear filter button
    @FindBy(xpath = "/html/body/div[3]/form/div[2]/div/button[1]")
    private WebElement clearFiltersBtn;

    //apply filter button
    @FindBy(xpath = "/html/body/div[3]/form/div[2]/div/button[2]")
    private WebElement applyFilterBtn;

    //close filter button X
    @FindBy(xpath = "/html/body/div[3]/button/svg")
    private WebElement closeFilterBtn;
    //</editor-fold>

    /************************Is Displayed Methods*****************************/
    //<editor-fold desc="Is displayed methods for affiliates page">
    //method check if sidebar button is displayed
    public boolean sidebarBtnIsDisplayed() {
        return isDisplayed(sidebarBtn, 10);
    }

    //method check if profile icon is displayed
    public boolean profileIconBtnIsDisplayed() {
        return isDisplayed(profileIconBtn, 10);
    }

    //method check if profile name is displayed
    public boolean profileNameIsDisplayed() {
        return isDisplayed(profileName, 10);
    }

    //method check if sign out is displayed
    public boolean signOutIsDisplayed() {
        return isDisplayed(signOutBtn, 10);
    }

    //method check if change theme button is displayed
    public boolean changeThemeBtnIsDisplayed() {
        return isDisplayed(changeThemeBtn, 10);
    }

    //method check if change language button is displayed
    public boolean changeLanguageBtnIsDisplayed() {
        return isDisplayed(changeLanguageBtn, 10);
    }

    //method check if first language option is displayed
    public boolean changeFirstLanguageBtnIsDisplayed() {
        return isDisplayed(firstLanguageOption, 10);
    }

    //method check if second language option is displayed
    public boolean changeSecondLanguageBtnIsDisplayed() {
        return isDisplayed(secondLanguageOption, 10);
    }

    //method check if third language option is displayed
    public boolean changeThirdLanguageBtnIsDisplayed() {
        return isDisplayed(thirdLanguageOption, 10);
    }

    //method check if fourth language option is displayed
    public boolean changeFourthLanguageBtnIsDisplayed() {
        return isDisplayed(fourthLanguageOption, 10);
    }

    //method check if fifth language option is displayed
    public boolean changeFifthLanguageBtnIsDisplayed() {
        return isDisplayed(fifthLanguageOption, 10);
    }

    //method check if Sixth language option is displayed
    public boolean changeSixthLanguageBtnIsDisplayed() {
        return isDisplayed(sixthLanguageOption, 10);
    }

    //method check if home page button is displayed
    public boolean homePageBtnIsDisplayed() {
        return isDisplayed(homeBtn, 10);
    }

    //method check if Dashboard button is displayed
    public boolean dashboardBtnIsDisplayed() {
        return isDisplayed(dashboardSidebarBtn, 10);
    }

    //method check if analytics button is displayed
    public boolean analyticsBtnIsDisplayed() {
        return isDisplayed(analyticsBtn, 10);
    }

    //method check if instrument button is displayed
    public boolean instrumentBtnIsDisplayed() {
        return isDisplayed(instrumentsBtn, 10);
    }

    //method check if recipes button is displayed
    public boolean recipesBtnIsDisplayed() {
        return isDisplayed(recipesBtn, 10);
    }

    //method check if journals button is displayed
    public boolean journalsBtnIsDisplayed() {
        return isDisplayed(journalsBtn, 10);
    }

    //method check if alerts button is displayed
    public boolean alertsBtnIsDisplayed() {
        return isDisplayed(alertsBtn, 10);
    }

    //method check if users button is displayed
    public boolean usersBtnIsDisplayed() {
        return isDisplayed(usersBtn, 10);
    }

    //method check if help and support button is displayed
    public boolean helpAndSupportBtnIsDisplayed() {
        return isDisplayed(helpAndSupportBtn, 10);
    }

    //method check if affiliates page title label is displayed
    public boolean affiliatesPageTitleIsDisplayed() {
        return isDisplayed(affiliatesPageTitle, 10);
    }

    //method check if add affiliate button is displayed
    public boolean addAffiliateBtnIsDisplayed() {
        return isDisplayed(addAffiliateBtn, 10);
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

    //method check if toggle modified at column option is displayed
    public boolean toggleModifiedAtColumnOptionIsDisplayed() {
        return isDisplayed(toggleModifiedAtColumnOption, 10);
    }

    //method check if clear pinning option is displayed
    public boolean clearPinningOptionIsDisplayed() {
        return isDisplayed(clearPinningOption, 10);
    }

    //method check if clear sorting option is displayed
    public boolean clearSortingOptionIsDisplayed() {
        return isDisplayed(clearSortingOption, 10);
    }

    //method check if name sorting button is displayed
    public boolean nameSortingBtnIsDisplayed() {
        return isDisplayed(nameSortingBtn, 10);
    }

    //method check if users count sorting button is displayed
    public boolean usersCountSortingBtnIsDisplayed() {
        return isDisplayed(usersCountSortingBtn, 10);
    }

    //method check if sorting name Asc button is displayed
    public boolean sortingNameAscBtnIsDisplayed() {
        return isDisplayed(sortingNameAsc, 10);
    }

    //method check if sorting name Desc button is displayed
    public boolean sortingNameDescBtnIsDisplayed() {
        return isDisplayed(sortingNameDesc, 10);
    }

    //method check if pin column button is displayed
    public boolean pinColumnIsDisplayed() {
        return isDisplayed(pinColumn, 10);
    }

    //method check if sorting users count Asc button is displayed
    public boolean sortingUsersCountAscBtnIsDisplayed() {
        return isDisplayed(sortingUsersCountAsc, 10);
    }

    //method check if sorting users count Desc button is displayed
    public boolean sortingUsersCountDescBtnIsDisplayed() {
        return isDisplayed(sortingUsersCountDesc, 10);
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

    //<editor-fold desc="Is displayed methods for add affiliate page">
    //method check if add affiliate page title is displayed
    public boolean addAffiliatePageTitleIsDisplayed() {
        return isDisplayed(addAffiliatePageTitle, 10);
    }

    //method check if upload logo button is displayed
    public boolean uploadLogoBtnIsDisplayed() {
        return isDisplayed(uploadLogoBtn, 10);
    }

    //method check if affiliate name text field is displayed
    public boolean affiliateNameIsDisplayed() {
        return isDisplayed(affiliateName, 10);
    }

    //method check if affiliate max users field is displayed
    public boolean affiliateMaxUsersIsDisplayed() {
        return isDisplayed(maxUsers, 10);
    }

    //method check if affiliate abbreviation field is displayed
    public boolean affiliateAbbreviationIsDisplayed() {
        return isDisplayed(affiliateAbbreviation, 10);
    }

    //method check if affiliate Type field is displayed
    public boolean affiliateTypeIsDisplayed() {
        return isDisplayed(affiliateType, 10);
    }

    //method check if cancel button is displayed
    public boolean cancelBtnIsDisplayed() {
        return isDisplayed(cancelBtn, 10);
    }

    //method check if save button is displayed
    public boolean saveBtnIsDisplayed() {
        return isDisplayed(saveBtn, 10);
    }

    //method check if reset button is displayed
    public boolean resetBtnIsDisplayed() {
        return isDisplayed(resetBtn, 10);
    }
    //</editor-fold>

    //<editor-fold desc="Is displayed methods for filter window">
    //method check if filter window title is displayed
    public boolean filterWindowTitleIsDisplayed() {
        return isDisplayed(filterPopTitle, 10);
    }

    //method check if filter affiliate name text field is displayed
    public boolean filterAffiliateNameTextFieldIsDisplayed() {
        return isDisplayed(filterAffiliateName, 10);
    }

    //method check if filter cancel button is displayed
    public boolean filterCancelBtnIsDisplayed() {
        return isDisplayed(cancelFilterBtn, 10);
    }

    //method check if filter affiliate type text field is displayed
    public boolean filterAffiliateTypeTextFieldIsDisplayed() {
        return isDisplayed(filterAffiliateType, 10);
    }

    //method check if filter clear button is displayed
    public boolean filterClearBtnIsDisplayed() {
        return isDisplayed(clearFiltersBtn, 10);
    }

    //method check if filter apply button is displayed
    public boolean filterApplyBtnIsDisplayed() {
        return isDisplayed(applyFilterBtn, 10);
    }

    //method check if filter close (X) button is displayed
    public boolean filterCloseBtnIsDisplayed() {
        return isDisplayed(closeFilterBtn, 10);
    }
    //</editor-fold>


    /************************Click Methods*****************************/
    //<editor-fold desc="Click methods for affiliates page">
    //method to click sidebar button
    public boolean clickSidebarBtn() {
        return clickElement(sidebarBtn);
    }

    //method to click profile icon button
    public boolean clickProfileIconBtn() {
        return clickElement(profileIconBtn);
    }

    //method to click sign out button
    public boolean clickSignOutBtn() {
        return clickElement(signOutBtn);
    }

    //method to click change theme button
    public boolean clickChangeThemeBtn() {
        return clickElement(changeThemeBtn);
    }

    //method to click change language button
    public boolean clickChangeLanguageBtn() {
        return clickElement(changeLanguageBtn);
    }

    //method to click first language option
    public boolean clickFirstLanguageOption() {
        return clickElement(firstLanguageOption);
    }

    //method to click second language option
    public boolean clickSecondLanguageOption() {
        return clickElement(secondLanguageOption);
    }

    //method to click first language option
    public boolean clickThirdLanguageOption() {
        return clickElement(thirdLanguageOption);
    }

    //method to click fourth language option
    public boolean clickFourthLanguageOption() {
        return clickElement(fourthLanguageOption);
    }

    //method to click fifth language option
    public boolean clickFifthLanguageOption() {
        return clickElement(fifthLanguageOption);
    }

    //method to click sixth language option
    public boolean clickSixthLanguageOption() {
        return clickElement(sixthLanguageOption);
    }

    //method to click home page button
    public boolean clickHomePageBtn() {
        return clickElement(homeBtn);
    }

    //method to click dashboard button
    public boolean clickDashboardBtn() {
        return clickElement(dashboardSidebarBtn);
    }

    //method to click analytics button
    public boolean clickAnalyticsBtn() {
        return clickElement(analyticsBtn);
    }

    //method to click instrument button
    public boolean clickInstrumentBtn() {
        return clickElement(instrumentsBtn);
    }

    //method to click recipes button
    public boolean clickRecipesBtn() {
        return clickElement(recipesBtn);
    }

    //method to click journals button
    public boolean clickJournalsBtn() {
        return clickElement(journalsBtn);
    }

    //method to click alerts button
    public boolean clickAlertsBtn() {
        return clickElement(alertsBtn);
    }

    //method to click users button
    public boolean clickUsersBtn() {
        return clickElement(usersBtn);
    }

    //method to click help and support button
    public boolean clickHelpAndSupportBtn() {
        return clickElement(helpAndSupportBtn);
    }

    //method to click add affiliate button
    public boolean clickAddAffiliateBtn() {
        return clickElement(addAffiliateBtn);
    }

    //method to click add search field
    public boolean clickSearchField() {
        return clickElement(searchField);
    }

    //method to click add search button
    public boolean clickSearchBtn() {
        return clickElement(searchBtn);
    }

    //method to click add search button
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

    //method to click toggle modified at column option
    public boolean clickToggleModifiedAtColumnOption() {
        return clickElement(toggleModifiedAtColumnOption);
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

    //method to click users count sorting button
    public boolean clickUsersCountSortingBtn() {
        return clickElement(usersCountSortingBtn);
    }

    //method to click sorting name Asc button
    public boolean clickSortingNameAscBtn() {
        return clickElement(sortingNameAsc);
    }

    //method to click sorting name Desc button
    public boolean clickSortingNameDescBtn() {
        return clickElement(sortingNameDesc);
    }

    //method to click pin column button
    public boolean clickPinColumnBtn() {
        return clickElement(pinColumn);
    }

    //method to click sorting users count Asc button
    public boolean clickSortingUsersCountAscBtn() {
        return clickElement(sortingUsersCountAsc);
    }

    //method to click sorting users count Desc button
    public boolean clickSortingUsersCountDescBtn() {
        return clickElement(sortingUsersCountDesc);
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

    //method to click first affiliate options button
    public boolean clickFirstAffiliateOptionsBtn() {
        return clickElement(firstAffiliateOptionsBtn);
    }

    //method to click first affiliate edit button
    public boolean clickFirstAffiliateEditBtn() {
        return clickElement(firstAffiliateEditBtn);
    }

    //method to click first affiliate delete button
    public boolean clickFirstAffiliateDeleteBtn() {
        return clickElement(firstAffiliateDeleteBtn);
    }
    //</editor-fold>

    //<editor-fold desc="Add affiliate click methods">
    //method to click upload logo button
    public boolean clickUploadLogoBtn() {
        return clickElement(uploadLogoBtn);
    }

    //method to click affiliate name text field
    public boolean clickAffiliateNameTextField() {
        return clickElement(affiliateName);
    }

    //method to click affiliate max users text field
    public boolean clickAffiliateMaxUsersTextField() {
        return clickElement(maxUsers);
    }

    //method to click affiliate type text field
    public boolean clickAffiliateTypeTextField() {
        return clickElement(affiliateType);
    }

    //method to click cancelBtn
    public boolean clickCancelBtn() {
        return clickElement(cancelBtn);
    }
    //</editor-fold>

    //<editor-fold desc="click methods for filter window">
    //method to click filter affiliate name text field
    public boolean clickFilterAffiliateNameTextField() {
        return clickElement(filterAffiliateName);
    }

    //method to click filter affiliate type text field
    public boolean clickFilterAffiliateTypeTextField() {
        return clickElement(filterAffiliateType);
    }

    //method to click filter cancel button
    public boolean clickFilterCancelBtn() {
        return clickElement(cancelFilterBtn);
    }

    //method to click filter clear button
    public boolean clickFilterClearBtn() {
        return clickElement(clearFiltersBtn);
    }

    //method to click filter apply button
    public boolean clickFilterApplyBtn() {
        return clickElement(applyFilterBtn);
    }

    //method to click filter apply button
    public boolean clickFilterCloseBtn() {
        return clickElement(closeFilterBtn);
    }
    //</editor-fold>


    /************************Get Text Methods*****************************/
    //<editor-fold desc="Get text methods for affiliates page">
    //method to get profile name
    public String getProfileName() {
        return getElementText(profileName);
    }

    //method to get affiliates page title
    public String getAffiliatesPageTitle() {
        return getElementText(affiliatesPageTitle);
    }

    //method to get first affiliate name in table
    public String getFirstAffiliateName() {
        return getElementText(firstAffiliateName);
    }

    //method to get first affiliate type in table
    public String getFirstAffiliateType() {
        return getElementText(firstAffiliateType);
    }

    //method to get first affiliate user count in table
    public String getFirstAffiliateUsersCount() {
        return getElementText(firstAffiliateUsersCount);
    }

    //method to get first affiliate max users count in table
    public String getFirstAffiliateMaxUsers() {
        return getElementText(firstAffiliateMaxUsers);
    }

    //method to get first affiliate status in table
    public String getFirstAffiliateStatus() {
        return getElementText(firstAffiliateStatus);
    }
    //</editor-fold>

    //<editor-fold desc="Get text methods for add affiliate page">
    //method to get add affiliate page title
    public String getAddAffiliatePageTitle() {
        return getElementText(addAffiliatePageTitle);
    }
    //</editor-fold>

    //<editor-fold desc="Get text methods for filter window">
    //method to get add affiliate page title
    public String getFilterWindowTitle() {
        return getElementText(filterPopTitle);
    }
    //</editor-fold>


    /************************Set And Reset Text Methods*****************************/
    //<editor-fold desc="Set and reset text methods for affiliates page">
    //method to send text to search field
    public boolean sendTextToSearchField(String text) {
        return sendTextToElement(searchField, text);
    }

    //method to clear search field text
    public boolean resetSearchField() {
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

    //<editor-fold desc="Set and reset methods for add affiliate page">
    //method to send text to affiliate name text field
    public boolean sendTextToAffiliateNameTextField(String text) {
        return sendTextToElement(affiliateName, text);
    }

    //method to clear  affiliate name text field
    public boolean resetAffiliateNameTextField() {
        return clearText(affiliateName);
    }

    //method to send text to affiliate max users text field
    public boolean sendTextToAffiliateMaxUsersTextField(String text) {
        return sendTextToElement(maxUsers, text);
    }

    //method to clear affiliate max users text field
    public boolean resetAffiliateMaxUsersTextField() {
        return clearText(maxUsers);
    }

    //method to send text to affiliate abbreviation text field
    public boolean sendTextToAffiliateAbbreviationTextField(String text) {
        return sendTextToElement(affiliateAbbreviation, text);
    }

    //method to clear affiliate abbreviation text field
    public boolean resetAffiliateAbbreviationTextField() {
        return clearText(affiliateAbbreviation);
    }

    //method to send text to affiliate type text field
    public boolean sendTextToAffiliateTypeTextField(String text) {
        return sendTextToElement(affiliateType, text, Keys.ENTER);
    }

    //method to clear affiliate type text field
    public boolean resetAffiliateTypeTextField() {
        return clearText(affiliateType);
    }
    //</editor-fold>

    //<editor-fold desc="Set and reset methods for filter window">
    //method to send text to filter affiliate name text field
    public boolean sendTextToFilterAffiliateNameTextField(String text) {
        return sendTextToElement(filterAffiliateName, text);
    }

    //method to clear filter affiliate name text field
    public boolean resetFilterAffiliateNameTextField() {
        return clearText(filterAffiliateName);
    }

    //method to send text to filter affiliate type text field
    public boolean sendTextToFilterAffiliateTypeTextField(String text) {
        return sendTextToElement(filterAffiliateType, text,Keys.ENTER);
    }

    //method to clear filter affiliate type text field
    public boolean resetFilterAffiliateTypeTextField() {
        return clearText(filterAffiliateType);
    }
    //</editor-fold>


    //////////////////////////////////////////////////////////////////////////////////////////////////////////M

    //method to click save affiliate button
    public boolean clickSaveAffiliateBtn(){return clickElement(saveBtn);}

    //the error message appears under affiliate text field
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div/div/div[2]/div[2]/span")
    private WebElement affiliateRequiredErrorMsg;

    //the error message appears under max users text field
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div/div/div[3]/div[2]/span")
    private WebElement maxUsersRequiredErrorMsg;

    //the error message appears under type text field
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div/div/div[4]/div[2]/span")
    private WebElement typeRequiredErrorMsg;

    //the input field to upload image as logo
    @FindBy(xpath = "//*[@id=\"main-layout\"]/div[2]/form/div/div[3]/div/div/div[1]/div/input")
    private WebElement uploadAffiliateLogoField;

    //submit affiliate edits button
    @FindBy(xpath = "/html/body/div[3]/div[2]/button[2]")
    private WebElement submitAffiliateEditBtn;

    //second affiliate name
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr[2]/td[2]/div")
    private WebElement secondAffiliateName;

    //second afffiliate users count
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr[2]/td[4]/div")
    private WebElement secondAffiliateUsersCount;

    @FindBy(xpath = "/html/body/div[3]/div[2]/button[2]")
    private WebElement confirmDeleteBtn;

    @FindBy(xpath = "/html/body/div[3]/div[2]/button[1]")
    private WebElement cancelDeleteBtn;

    public boolean clickCancelDeleteBtn(){
        return clickElement(cancelDeleteBtn);
    }
    public boolean clickConfirmDeleteBtn(){
        return clickElement(confirmDeleteBtn);
    }
    public boolean clickSubmitAffiliateBtn(){
        return clickElement(submitAffiliateEditBtn);
    }
    public String getAffiliateRequiredErrorMsg(){
        return getElementText(affiliateRequiredErrorMsg);
    }

    public String getMaxUsersRequiredErrorMsg(){
        return getElementText(maxUsersRequiredErrorMsg);
    }

    public String getTypeRequiredErrorMsg(){
        return getElementText(typeRequiredErrorMsg);
    }

    public boolean uploadAffiliateLogo(String filePath){
        try{
            uploadAffiliateLogoField.sendKeys(filePath);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public boolean clearAffiliateNameTextField(){
        return clearText(affiliateName);
    }

    public boolean clearMaxUsersTextField(){
        return clearText(maxUsers);
    }

    public boolean clearAbbreviation(){
        return clearText(affiliateAbbreviation);
    }

    public String getSecondAffiliateName(){
        return getElementText(secondAffiliateName);
    }

    public String getSecondAffiliateUserCount(){
        return getElementText(secondAffiliateUsersCount);
    }
}