package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import utiles.MethodHandles;



public class ListJournalsPage extends MethodHandles {

   public ListJournalsPage(WebDriver driver) {
        super((ChromeDriver) driver);
        PageFactory.initElements(driver, this);
    }

    //edit filters button in journals' instruments page
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[1]/div[2]/div[2]/button")
    private WebElement editFiltersBtn;

    //recipe filter dropdown
    @FindBy(xpath="/html/body/div/div[1]/div[3]/div[2]/div/form/div/div[3]/div/div/div[1]/div/div/div[1]/div[2]/input")
    private WebElement recipeFilterText;

    //instrument SNR filter
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/form/div/div[3]/div/div/div[2]/div/div/div[1]/div[2]/input")
    private WebElement instrumentSNRFilterText;

    //sample name filter text box
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/form/div/div[3]/div/div/div[3]/div/div/div/input")
    private WebElement sampleNameFilterText;

    ///cancel filter button
    @FindBy(xpath="/html/body/div/div[1]/div[3]/div[2]/div/form/div/div[4]/button")
    private WebElement cancelFilterBtn;

    //save filter button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/form/div/div[4]/div/button")
    private WebElement saveFilterBtn;

    //search text field
    @FindBy(id = "search")
    private WebElement searchTextFields;

    //search button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/div[2]/div/div[1]/form/div/button")
    private WebElement searchBtn;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/div[2]/div/div[1]/div/button[1]")
    private WebElement exportBtn;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/div[2]/div/div[1]/div/button[2]")
    private WebElement viewBtn;

    //clear pinning button
    @FindBy(xpath = "/html/body/div[2]/div/div[5]")
    private WebElement clearPinningBtn;

    //clear sorting button
    @FindBy(xpath = "/html/body/div[2]/div/div[6]")
    private WebElement clearSortingBtn;

    //first scan checkbox
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/table/tbody/tr/td[1]/div/button")
    private WebElement firstSampleCheckBox;

    //minimize expanded recipe name
    @FindBy(xpath = "/html/body/div[3]/button")
    private WebElement minimizeSampleBtn;

    //first sample name
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/table/tbody/tr/td[2]")
    private WebElement firstSampleName;

    //first sample recipe name
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/table/tbody/tr/td[3]")
    private WebElement firstSampleRecipeName;

    //first sample instrument
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/table/tbody/tr/td[6]")
    private WebElement firstSampleInstrument;

    //-----------------------Click Methods-----------------------//
    public boolean clickEditFiltersBtn() {
        return clickElement(editFiltersBtn);
    }

    public boolean clickCancelFilterBtn() {
        return clickElement(cancelFilterBtn);
    }

    public boolean clickMinimizeSampleBtn() {
        return clickElement(minimizeSampleBtn);
    }

    public boolean clickSaveFilterBtn() {
        return clickElement(saveFilterBtn);
    }

    public boolean clickSearchBtn() {
        return clickElement(searchBtn);
    }

    public boolean clickExportBtn(){
        return clickElement(exportBtn);
    }

    public boolean clickViewBtn(){
        return clickElement(viewBtn);
    }

    public boolean clickClearPinningBtn(){
        return clickElement(clearPinningBtn);
    }

    public boolean clickClearSortingBtn(){
        return clickElement(clearSortingBtn);
    }

    public boolean clickFirstScanCheckBox(){
        return clickElement(firstSampleCheckBox);
    }


    //-----------------------Send Text Methods-----------------------//
    public boolean sendTextToRecipeFilterText(String text) {
        explicitWait(recipeFilterText, 10);
        recipeFilterText.sendKeys(text, Keys.ENTER);
        return true;
    }

    public boolean sendTextToInstrumentSNRFilterText(String text) {
        explicitWait(instrumentSNRFilterText, 10);
        instrumentSNRFilterText.sendKeys(text, Keys.ENTER);
        return true;
    }

    public boolean sendTextToSampleNameFilterText(String text) {
        return sendTextToElement(sampleNameFilterText, text);

    }

    public boolean sendTextToSearchFields(String text) {
        return sendTextToElement(searchTextFields, text);
    }


    //-----------------------Get Text Methods-----------------------//
    public String getFirstSampleName(){
        return getElementText(firstSampleName);
    }

    public String getFirstSampleRecipeName(){
        return getElementText(firstSampleRecipeName);
    }

    public String getFirstSampleInstrument(){
        return getElementText(firstSampleInstrument);
    }

    //-----------------------isDisplayed  Methods-----------------------//
    public boolean isFirstSampleNameDisplayed(){
        return isDisplayed(firstSampleName,5);
    }

    //-----------------------Clear Text Methods-----------------------//
    public boolean clearSampleNameFilterText(){
         clearText(sampleNameFilterText);
        sampleNameFilterText.sendKeys("a",Keys.BACK_SPACE);
        return true;
    }

}
