package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utiles.MethodHandles;

import java.lang.ref.WeakReference;
import java.time.Duration;
import java.util.List;

public class AffiliatePage extends MethodHandles {

    WebDriverWait wait;

    public AffiliatePage(ChromeDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    //<editor-fold desc="Affiliates page allocators">
    //sidebar button expands and collapses it
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[1]/div[1]/div[1]/button")
    private WebElement sideBarBtn;

    //profile icon
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[1]/div[2]/div[1]/div/span/span")
    private WebElement profileIconBtn;

    //profile name
    @FindBy(xpath = "/html/body/div[2]/div/div[1]/div/div/span")
    private WebElement profileName;

    //profile level
    @FindBy(xpath = "/html/body/div[2]/div/div[1]/div/div/p")
    private WebElement profileLevel;

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
    private WebElement analyticsDashboardBtn;

    //instruments button in sidebar
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div[3]/div")
    private WebElement instrumentsSidebarBtn;

    //recipes button in sidebar
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div[4]/div")
    private WebElement recipesSidebarBtn;

    //journals button in sidebar
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div[5]/div")
    private WebElement journalsSidebarBtn;

    //alerts button in sidebar
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div[6]/div")
    private WebElement alertsSidebarBtn;

    //users button in sidebar
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div[8]/div")
    private WebElement usersSidebarBtn;

    //help and support sidebar btn
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div[3]/div[2]/div")
    private WebElement helpAndSupportSidebarBtn;

    //affiliates page title
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[1]/div[1]/div[1]/h4")
    private WebElement affiliatesPageTitle;

    //add affiliates button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[1]/div[1]/div[2]/button")
    private WebElement addAffiliateBtn;

    //search field to search by user
    @FindBy(id="search")
    private WebElement searchField;

    //search button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/form/div/button")
    private WebElement searchBtn;

    //filter button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/button")
    private WebElement filterBtn;

    //views button
    @FindBy(xpath = "//html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/button")
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
    //</editor-fold>

    //<editor-fold desc="Add affiliate page allocators">
    //add affiliates page title
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[1]/div/h3")
    private WebElement addAffiliatePageTitle;

    //upload logo
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div/div/div[1]/div/div/div/button")
    private WebElement uploadLogoBtn;

    //affiliate name text field
    @FindBy(xpath = "//*[@id=\"name\"]")
    private WebElement affiliateName;

    //max users field
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div/div/div[3]/div/div/div/input")
    private WebElement maxUsers;

    //abbreviation text field
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div/div/div[5]/div/div/div/input")
    private WebElement affiliateAbbreviation;

    //affiliate type
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div/div/div[4]/div/div")
    private Select affiliateType;

    //cancel button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[4]/button")
    private WebElement cancelBtn;

    //reset button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[4]/div/button[1]")
    private WebElement resetBtn;

    //save button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[4]/div/button[2]")
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
    private Select filterAffiliateType;

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


    /*****************************Click Methods*******************************/
    //<editor-fold desc="Affiliates page click methods">
    public boolean clickSideBarBtn(){
        return clickElement(sideBarBtn);
    }

    public boolean clickSignOutBtn(){
        return clickElement(signOutBtn);
    }

    public boolean clickSidebarAnalyticsBtn(){
        return clickElement(analyticsDashboardBtn);
    }

    public boolean clickDashBoardSidebarBtn(){
        return clickElement(dashboardSidebarBtn);
    }

    public boolean clickInstrumentsDashboardBtn(){
        return clickElement(instrumentsSidebarBtn);
    }

    public boolean clickRecipesSidebarBtn(){
        return clickElement(recipesSidebarBtn);
    }

    public boolean clickJournalsSidebarBtn(){
        return clickElement(journalsSidebarBtn);
    }

    public boolean clickAlertsSidebarBtn(){
        return clickElement(alertsSidebarBtn);
    }

    public boolean clickUsersSidebarBtn(){
        return clickElement(usersSidebarBtn);
    }

    public boolean clickHelpAndSupportSidebarBtn(){
        return clickElement(helpAndSupportSidebarBtn);
    }

    public boolean clickProfileIconBtn(){
        return clickElement(profileIconBtn);
    }

    public boolean clickChangeThemeBtn(){
        return clickElement(changeThemeBtn);
    }

    public boolean clickChangeLanguageBtn(){
        return clickElement(changeLanguageBtn);
    }

    public boolean clickFirstLanguageOption(){
        return clickElement(firstLanguageOption);
    }

    public boolean clickSecondLanguageOption(){
        return clickElement(secondLanguageOption);
    }

    public boolean clickThirdLanguageOption(){
        return clickElement(thirdLanguageOption);
    }

    public boolean clickFourthLanguageOption(){
        return clickElement(fourthLanguageOption);
    }

    public boolean clickFifthLanguageOption(){
        return clickElement(fifthLanguageOption);
    }

    public boolean clickSixthLanguageOption(){
        return clickElement(sixthLanguageOption);
    }

    public boolean clickHomeBtn(){
        return clickElement(homeBtn);
    }

    public boolean sendTextToSearchField(String text) {
        return sendTextToElement(searchField, text);
    }

    public boolean clickSearchBtn() {
        return clickElement(searchBtn);
    }

    public boolean clickFilterBtn() {
        return clickElement(filterBtn);
    }

    public boolean clickAddAffiliateBtn() {
        return clickElement(addAffiliateBtn);
    }

    public boolean clickViewBtn() {
        return clickElement(viewBtn);
    }

    public boolean clickToggleCreatedAtColumn() {
        return clickElement(toggleCreatedAtColumnOption);
    }

    public boolean clickToggleModifiedAtColumn() {
        return clickElement(toggleModifiedAtColumnOption);
    }

    public boolean clickClearPinningOption() {
        return clickElement(clearPinningOption);
    }

    public boolean clickClearSortingOption() {
        return clickElement(clearSortingOption);
    }
    //</editor-fold>

    //<editor-fold desc="Add affiliate click methods">
    public boolean clickUploadLogoBtn() {
        return clickElement(uploadLogoBtn);
    }

    public boolean clickAffiliateName(){
        return clickElement(affiliateName);
    }

    public boolean clickAffiliateMaxUsers(){
        return clickElement(maxUsers);
    }

    public boolean clickAffiliateAbbreviation() {
        return clickElement(affiliateAbbreviation);
    }

    public boolean clickCancelBtn() {
        return clickElement(cancelBtn);
    }

    public boolean clickResetBtn() {
        return clickElement(resetBtn);
    }

    public boolean clickSaveBtn() {
        return clickElement(saveBtn);
    }

    //</editor-fold>

    //<editor-fold desc="Filter window click methods">
    public boolean clickAffiliateNameFilterTextField() {
        return clickElement(filterAffiliateName);
    }

    public boolean clickCancelFilterBtn() {
        return clickElement(cancelFilterBtn);
    }

    public boolean clickClearFilterBtn() {
        return clickElement(clearFiltersBtn);
    }

    public boolean clickApplyFilterBtn() {
        return clickElement(applyFilterBtn);
    }

    public boolean clickCloseFilterBtn() {
        return clickElement(closeFilterBtn);
    }
    ///</editor-fold>


    /*****************************Get Text Methods*******************************/
    //<editor-fold desc="Affiliates page get text methods">
    public String getProfName(){
        return getElementText(profileName);
    }

    public String getProfileLevel (){
        return getElementText(profileLevel);
    }

    public String getAffiliatesPageTitle (){
        return getElementText(affiliatesPageTitle);
    }
    //</editor-fold>

    //<editor-fold desc="Add affiliate get text methods">
    public String getAddAffiliatePageTitle() {
        return getElementText(addAffiliatePageTitle);
    }

    public List<WebElement> getAffiliateTypeAllOptions() {
        return affiliateType.getOptions();
    }
    //</editor-fold>

    //<editor-fold desc="Filter window get text methods">
    public String getFilterWindowTitle() {
        return filterPopTitle.getText();
    }
    ///</editor-fold>

    /*****************************Set Text Fields Methods*******************************/
    //<editor-fold desc="Affiliate set text methods">
    public void setSearchData(String searchData) {
        searchField.sendKeys(searchData);
    }

    public void resetSearchTextField() {
        searchField.clear();
    }
    //</editor-fold>

    //<editor-fold desc="Add affiliate set text methods">
    public void setAffiliateName(String text) {
        affiliateName.sendKeys(text);
    }
    public void resetAffiliateName() {
        affiliateName.clear();
    }

    public void setAffiliateMaxUsers(String text) {
        maxUsers.sendKeys(text);
    }
    public void resetAffiliateMaxUsers() {
        maxUsers.clear();
    }

    public void setAffiliateAbbreviation(String text) {
        affiliateAbbreviation.sendKeys(text);
    }
    public void resetAffiliateAbbreviation() {
        affiliateAbbreviation.clear();
    }

    public void selectAffiliateType (String select) {
        affiliateType.selectByValue(select);
    }

    public void uploadAffiliateLogo(String path) {
        uploadLogoBtn.sendKeys(path);
    }
    //</editor-fold>

    //<editor-fold desc="Filter window set text fields methods"
    public void SetAffiliateNameFilter(String name) {
        filterAffiliateName.sendKeys(name);
    }

    public void selectAffiliateTypeFilter (String select) {
        filterAffiliateType.selectByValue(select);
    }
    //</editor-fold>
}
