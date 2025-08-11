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
    @FindBy(id = "side-menu-access-management-affiliates-tooltip-trigger")
    public WebElement sidebarBtn;

    //profile icon
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[1]/div[2]/div[1]/div/span/span")
    public WebElement profileIconBtn;

    //profile name
    @FindBy(xpath = "/html/body/div[2]/div/div[1]/div/div/span")
    public WebElement profileName;

    //sign out button
    @FindBy(xpath = "/html/body/div[2]/div/div[2]")
    public WebElement signOutBtn;

    //change theme button
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[1]/div[2]/button[2]")
    public WebElement changeThemeBtn;

    //change language button
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[1]/div[2]/button[1]")
    public WebElement changeLanguageBtn;

    //first language option (English)
    @FindBy(xpath = "/html/body/div[2]/div/div[3]")
    public WebElement firstLanguageOption;

    //second language option (Portuguese)
    @FindBy(xpath = "/html/body/div[2]/div/div[4]")
    public WebElement secondLanguageOption;

    //third language option (Chinese)
    @FindBy(xpath = "/html/body/div[2]/div/div[5]")
    public WebElement thirdLanguageOption;

    //fourth language option (Korean)
    @FindBy(xpath = "/html/body/div[2]/div/div[6]")
    public WebElement fourthLanguageOption;

    //fifth language option (Polish)
    @FindBy(xpath = "/html/body/div[2]/div/div[7]")
    public WebElement fifthLanguageOption;

    //sixth language option (Spanish)
    @FindBy(xpath = "/html/body/div[2]/div/div[8]")
    public WebElement sixthLanguageOption;

    //button to return to homepage
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[1]/div[1]/nav/ol/li[1]/button")
    public WebElement homeBtn;

    //dashboard button in sidebar
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div[1]/div")
    public WebElement dashboardSidebarBtn;

    //analytics button in sidebar
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div[2]/div")
    public WebElement analyticsBtn;

    //instruments button in sidebar
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div[3]/div")
    public WebElement instrumentsBtn;

    //recipes button in sidebar
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div[4]/div")
    public WebElement recipesBtn;

    //journals button in sidebar
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div[5]/div")
    public WebElement journalsBtn;

    //alerts button in sidebar
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div[6]/div")
    public WebElement alertsBtn;

    //users button in sidebar
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div[8]/div")
    public WebElement usersBtn;

    //help and support sidebar btn
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div[3]/div[2]/div")
    public WebElement helpAndSupportBtn;

    //affiliates page title
    @FindBy(id = "affiliate-list-add-section-text-content")
    public WebElement affiliatesPageTitle;

    //add affiliates button
    @FindBy(id = "affiliate-list-add-section-button")
    public WebElement addAffiliateBtn;

    //search field to search by user
    @FindBy(id="affiliates-list-table-search-input")
    public WebElement searchField;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[8]/div[2]")
    public WebElement tableHorizontalScrollBar;

    //search button
    @FindBy(id = "affiliates-list-table-search-submit")
    public WebElement searchBtn;

    //filter button
    @FindBy(id = "affiliates-list-table-filter-button")
    public WebElement filterBtn;

    //views button
    @FindBy(id = "affiliates-list-table-viewing-options")
    public WebElement viewBtn;

    //toggle the created at view
    @FindBy(id = "createdAt")
    public WebElement toggleCreatedAtColumnOption;

    //toggle the modified at view
    @FindBy(id = "lastUpdatedAt")
    public WebElement toggleLastUpdatedAtColumnOption;


    //clear any sorting
    @FindBy(id = "affiliates-list-table-viewing-options-dropdown-menu-item-clear-sorting")
    public WebElement clearSortingOption;

    //fifth column header (can be created or modified at)
    @FindBy(id = "affiliates-list-table-lastUpdatedAt-column")
    public WebElement lastUpdatedAtColumn;

    @FindBy(id="affiliates-list-table-partner-column")
    public WebElement partnerColumn;

    @FindBy(id="affiliates-list-table-name-column")
    public WebElement nameColumn;

    @FindBy(id="affiliates-list-table-type-column")
    public WebElement typeColumn;

    @FindBy(id="affiliates-list-table-currentActiveUsers-column")
    public WebElement currentActiveUsersColumn;

    @FindBy(id="affiliates-list-table-maxUsersNumber-column")
    public WebElement maxUsersNumberColumn;

    @FindBy(id="affiliates-list-table-maxInstruments-column-options-menu-item-asc")
    public WebElement sortMaxInstrumentsAscOption;

    @FindBy(id="affiliates-list-table-maxInstruments-column-options-menu-item-desc")
    public WebElement sortMaxInstrumentsDescOption;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[6]")
    public WebElement firstAffiliateMaxInstruments;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[2]/div[6]")
    public WebElement secondAffiliateMaxInstruments;

    @FindBy(id="affiliates-list-table-maxInstruments-column")
    public WebElement maxInstrumentsColumn;


    @FindBy(id="affiliates-list-table-createdAt-column")
    public WebElement createdAtColumn;

    @FindBy(id="affiliates-list-table-name-column-options-menu-item-asc")
    public WebElement sortNamesAscOption;

    @FindBy(id="affiliates-list-table-name-column-options-menu-item-desc")
    public WebElement sortNamesDescOption;

    @FindBy(id="affiliates-list-table-name-column-options-menu-item-pin")
    public WebElement pinNameColumnOption;

    @FindBy(id="affiliates-list-table-currentActiveUsers-column-options-menu-item-asc")
    public WebElement sortActiveUsersAscOption;

    @FindBy(id="affiliates-list-table-currentActiveUsers-column-options-menu-item-desc")
    public WebElement sortActiveUsersDescOption;


    //name of first affiliate in the table
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[2]")
    public WebElement firstAffiliateName;

    //type of first affiliate in the table
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[3]")
    public WebElement firstAffiliateType;

    //users count of first affiliate in the table
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[4]")
    public WebElement firstAffiliateActiveUsersCount;

    //max users count of first affiliate in the table
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[5]")
    public WebElement firstAffiliateMaxUsers;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[6]")
    public WebElement firstAffiliateCreatedAt;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[7]")
    public WebElement firstAffiliateLastUpdatedAt;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[8]")
    public WebElement firstAffiliateStatus;

    //option of first affiliate in the table
    @FindBy(id = "affiliates-list-table-actions-cell-0")
    public WebElement firstAffiliateOptionsBtn;

    //edit option of first affiliate in the table
    @FindBy(id = "dropdown-menu-item-edit")
    public WebElement affiliateEditOptionBtn;

    //delete option of first affiliate in the table
    @FindBy(id = "dropdown-menu-item-delete")
    public WebElement affiliateDeleteOptionBtn;


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

    //<editor-fold desc="Add affiliate page allocators">
    //add affiliates page title
    @FindBy(id = "affiliate-form-container-typography-title")
    public WebElement addAffiliatePageTitle;

    //upload logo
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div/div/div[1]/div/div/div/button")
    public WebElement uploadLogoBtn;

    //affiliate name text field
    @FindBy(id = "affiliate-form-input-name")
    public WebElement affiliateName;

    //max users field
    @FindBy(id = "affiliate-form-input-maxUsersNumber")
    public WebElement maxUsers;

    //max instruments field
    @FindBy(id = "affiliate-form-input-maxInstruments")
    public WebElement maxInstruments;

    //abbreviation text field
    @FindBy(id = "affiliate-form-input-abbreviation")
    public WebElement affiliateAbbreviation;

    //affiliate type
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div/div/div[5]/div[1]/div/div[1]/div[2]/input")
    public WebElement affiliateType;

    //cancel button
    @FindBy(id = "affiliate-form-container-button-cancel")
    public WebElement cancelBtn;

    //reset button
    @FindBy(id = "affiliate-form-container-button-clear")
    public WebElement resetBtn;

    //save button
    @FindBy(id = "affiliate-form-container-button-submit")
    public WebElement saveBtn;
    //</editor-fold>

    //<editor-fold desc="Filter window allocators">
    //title
    @FindBy(xpath = "/html/body/div[3]/div/h4")
    public WebElement filterPopTitle;

    //filter affiliate name
    @FindBy(id = "affiliates-list-table-filter-input-name")
    public WebElement filterAffiliateName;

    //filter affiliate type
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[1]/div/div[2]/div/div/div/form/div[1]/div[2]/div/div/div[1]/div[2]/input")
    public WebElement filterAffiliateType;

    //filter cancel button
    @FindBy(id = "affiliates-list-table-filter-button-cancel")
    public WebElement cancelFilterBtn;

    //clear filter button
    @FindBy(id = "affiliates-list-table-filter-button-clear")
    public WebElement clearFiltersBtn;

    //apply filter button
    @FindBy(id = "affiliates-list-table-filter-button-submit")
    public WebElement applyFilterBtn;

    //close filter button X
    @FindBy(xpath = "/html/body/div[3]/button/svg")
    public WebElement closeFilterBtn;
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
        return isDisplayed(toggleLastUpdatedAtColumnOption, 10);
    }


    //method check if clear sorting option is displayed
    public boolean clearSortingOptionIsDisplayed() {
        return isDisplayed(clearSortingOption, 10);
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
        return clickElement(toggleLastUpdatedAtColumnOption);
    }



    //method to click clear sorting option
    public boolean clickClearSortingOption() {
        return clickElement(clearSortingOption);
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
        scrollToElement(affiliateEditOptionBtn);
        return clickElement(affiliateEditOptionBtn);
    }

    //method to click first affiliate delete button
    public boolean clickFirstAffiliateDeleteBtn() {
        return clickElement(affiliateDeleteOptionBtn);
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

    public String getlastUpdatedAtColumnText(){
        return getElementText(lastUpdatedAtColumn);
    }

    public boolean clickNameColumn(){
        return clickElement(nameColumn);
    }

    public boolean clickSortNameAscOption(){
        return clickElement(sortNamesAscOption);
    }

    public boolean clickSortNameDescOption(){
        return clickElement(sortNamesDescOption);
    }

    public boolean clickActiveUsersColumn(){
        return clickElement(currentActiveUsersColumn);
    }

    public boolean clickSortActiveUsersAscOption(){
        return clickElement(sortActiveUsersAscOption);
    }

    public boolean clickSortActiveUsersDescOption(){
        return clickElement(sortActiveUsersDescOption);
    }







    public boolean isLastUpdatedAtColumnDisplayed(){
        return isDisplayed(lastUpdatedAtColumn,5);
    }

    public boolean isCreatedAtColumnDisplayed(){
        return isDisplayed(createdAtColumn,5);
    }



    //method to get first affiliate type in table
    public String getFirstAffiliateType() {
        return getElementText(firstAffiliateType);
    }

    //method to get first affiliate user count in table
    public String getFirstAffiliateUsersCount() {
        return getElementText(firstAffiliateActiveUsersCount);
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
        return sendTextToElement(maxInstruments, text);
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
    public WebElement affiliateRequiredErrorMsg;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div/div/div[4]/div[2]/span")
    public WebElement maxInstrumentsErrorMsg;

    //the error message appears under max users text field
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div/div/div[3]/div[2]/span")
    public WebElement maxUsersRequiredErrorMsg;

    //the error message appears under type text field
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div/div/div[5]/div[2]/span")
    public WebElement typeRequiredErrorMsg;

    //the input field to upload image as logo
    @FindBy(xpath = "//*[@id=\"main-layout\"]/div[2]/form/div/div[3]/div/div/div[1]/div/input")
    public WebElement uploadAffiliateLogoField;

    //submit affiliate edits button
    @FindBy(id = "affiliate-form-alert-dialog-button-confirm")
    public WebElement submitAffiliateEditBtn;

    //second affiliate name
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[2]/div[2]")
    public WebElement secondAffiliateName;

    //second afffiliate users count
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[2]/div[4]")
    public WebElement secondAffiliateUsersCount;

    @FindBy(id = "affiliate-list-alert-dialog-button-confirm")
    public WebElement confirmDeleteBtn;

    @FindBy(xpath = "/html/body/div[3]/div[2]/button[1]")
    public WebElement cancelDeleteBtn;


    //generate license option of first affiliate in the table
    @FindBy(id="dropdown-menu-item-generateLicense")
    public WebElement affiliateGenerateLicenseBtn;

    @FindBy(id="dropdown-menu-item-viewLicense")
    public WebElement affiliateViewLicenseOptionBtn;

    @FindBy(id="license-button-copy")
    public WebElement copyLicenseBtn;

    @FindBy(id="license-button-cancel")
    public WebElement cancelLicenseCopyBtn;

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