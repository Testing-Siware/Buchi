package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utiles.MethodHandles;

public class journalsPage extends MethodHandles {

    journalsPage(WebDriver driver) {
        super((ChromeDriver) driver);
        PageFactory.initElements(driver, this);
    }

    //-----------------------Journals main page elements-----------------------//

    //search field
    @FindBy(id="search")
    private WebElement searchField;

    //submit search button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/form/div/button")
    private WebElement  submitSearchBtn;

    //filter button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/div/button")
    private WebElement filterBtn;

    //name filter text field
    @FindBy(xpath = "/html/body/div[3]/form/div[1]/div[1]/div/div/div/input")
    private WebElement nameFilterTextField;

    //view button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/button[1]")
    private WebElement viewBtn;

    //toggle affiliate button from view
    @FindBy(xpath = "/html/body/div[2]/div/div[3]")
    private WebElement toggleAffiliateBtn;

    //toggle created by button from view
    @FindBy(xpath = "/html/body/div[2]/div/div[4]")
    private WebElement toggleCreatedBy;

    //toggle created at button from view
    @FindBy(xpath = "/html/body/div[2]/div/div[5]")
    private WebElement toggleCreatedAt;

    //clear pinning button
    @FindBy(xpath = "/html/body/div[2]/div/div[7]")
    private WebElement clearPinningBtn;

    //clear sorting button
    @FindBy(xpath = "/html/body/div[2]/div/div[8]")
    private WebElement clearSortingBtn;

    //fetch recipes button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/button[2]")
    private WebElement fetchRecipesBtn;

    //expand first recipe button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr[1]/td[1]/div")
    private WebElement expandFirstRecipeBtn;

    //first recipe name
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr[1]/td[2]/div")
    private WebElement firstRecipeName;

    //first recipe affiliate
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr[1]/td[3]/div")
    private WebElement firstRecipeAffiliate;

    //first recipe created by
    @FindBy(xpath ="/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr[1]/td[4]/div")
    private WebElement firstRecipeCreatedBy;

    //first recipe created at date
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr[1]/td[5]")
    private WebElement firstRecipeCreatedAt;

    //first recipe name
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr[2]/td[2]/div")
    private WebElement secondRecipeName;

    //first recipe affiliate
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr[2]/td[3]/div")
    private WebElement secondRecipeAffiliate;

    //first recipe created by
    @FindBy(xpath ="/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr[2]/td[4]/div")
    private WebElement secondRecipeCreatedBy;

    //first recipe created at date
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr[2]/td[5]")
    private WebElement secondRecipeCreatedAt;

    //sort by name button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/thead/tr/th[2]/div/div/div")
    private WebElement sortRecipesByNameBtn;

    //sort by affiliate button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/thead/tr/th[3]/div/div/div")
    private WebElement sortRecipesByAffiliateBtn;

    //sort by created by button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/thead/tr/th[4]/div/div/div")
    private WebElement sortRecipesByCreatedByBtn;

    //sort by created at button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/thead/tr/th[5]/div/div/div")
    private WebElement sortRecipesByCreatedAtBtn;

    //first instrument name of first recipe
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/div/div[1]/table/tbody/tr[1]/td")
    private WebElement firstInstrument;

    //next button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/div/div[2]/button")
    private WebElement nextBtn;

    //-----------------------send text methods-----------------------//
    public boolean sendTextToSearchField(String text) {
        return sendTextToElement(searchField, text);
    }

    public boolean sendTextToNameFilterTextField(String text) {
        return sendTextToElement(filterBtn, text);
    }

    //-----------------------clear text methods-----------------------//
    public boolean clearSearchField() {
        return clearText(searchField);
    }

    //-----------------------click methods-----------------------//
    public boolean clickSubmitSearchBtn() {
        return clickElement(submitSearchBtn);
    }

    public boolean clickFilterBtn() {
        return clickElement(filterBtn);
    }

    public boolean clickToggleAffiliateBtn() {
        return clickElement(toggleAffiliateBtn);
    }

    public boolean clickToggleCreatedBy() {
        return clickElement(toggleCreatedBy);
    }

    public boolean clickToggleCreatedAt() {
        return clickElement(toggleCreatedAt);
    }

    public boolean clickClearPinningBtn() {
        return clickElement(clearPinningBtn);
    }

    public boolean clickClearSortingBtn() {
        return clickElement(clearSortingBtn);
    }

    public boolean clickViewBtn(){
        return clickElement(viewBtn);
    }

    public boolean clickFetchRecipesBtn(){
        return clickElement(fetchRecipesBtn);
    }

    public boolean clickExpandFirstRecipeBtn(){
        return clickElement(expandFirstRecipeBtn);
    }

    public boolean clickSortRecipesByName() {
        return clickElement(sortRecipesByNameBtn);
    }

    public boolean clickSortRecipesByAffiliate() {
        return clickElement(sortRecipesByAffiliateBtn);
    }

    public boolean clickSortRecipesByCreatedBy(){
        return clickElement(sortRecipesByCreatedByBtn);
    }

    public boolean clickSortRecipesByCreatedAt() {
        return clickElement(sortRecipesByCreatedAtBtn);
    }

    public boolean clickFirstInstrumentBtn(){
        return clickElement(firstInstrument);
    }
    //-----------------------get text methods-----------------------//
    public String getFirstRecipeName() {
        return getElementText(firstRecipeName);
    }

    public String getFirstRecipeAffiliate(){
        return getElementText(firstRecipeAffiliate);
    }

    public String getFirstRecipeCreatedByText(){
        return getElementText(firstRecipeCreatedBy);
    }

    public String getFirstRecipeCreatedAt(){
        return getElementText(firstRecipeCreatedAt);
    }

    public String getSecondRecipeName() {
        return getElementText(secondRecipeName);
    }

    public String getSecondRecipeAffiliate(){
        return getElementText(secondRecipeAffiliate);
    }

    public String getSecondRecipeCreatedByText(){
        return getElementText(secondRecipeCreatedBy);
    }

    public String getSecondRecipeCreatedAt(){
        return getElementText(secondRecipeCreatedAt);
    }

    public String getFirstColumnTitle(){
        return getElementText(sortRecipesByNameBtn);
    }

    public String getSecondColumnTitle(){
        return getElementText(sortRecipesByAffiliateBtn);
    }

    public String getThirdColumnTitle(){
        return getElementText(sortRecipesByCreatedByBtn);
    }

    public String getFourthColumnTitle(){
        return getElementText(sortRecipesByCreatedAtBtn);
    }

    //-----------------------isDisplayed  methods-----------------------//
    public boolean isFirstColumnDisplayed(){
        return isDisplayed(sortRecipesByNameBtn,5);
    }

    public boolean isSecondColumnDisplayed(){
        return isDisplayed(sortRecipesByAffiliateBtn,5);
    }

    public boolean isThirdColumnDisplayed(){
        return isDisplayed(sortRecipesByCreatedByBtn,5);
    }

    public boolean isFourthColumnDisplayed(){
        return isDisplayed(sortRecipesByCreatedAtBtn,5);
    }
}