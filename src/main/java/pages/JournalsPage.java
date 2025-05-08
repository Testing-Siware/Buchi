package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utiles.MethodHandles;

public class JournalsPage extends MethodHandles {

    public JournalsPage(WebDriver driver) {
        super((ChromeDriver) driver);
        PageFactory.initElements(driver, this);
    }

    //-----------------------Journals main page elements-----------------------//

    //search field
    @FindBy(id = "journals-select-recipe-list-table-search-input")
    public WebElement searchField;

    //submit search button
    @FindBy(id = "journals-select-recipe-list-table-search-submit")
    public WebElement submitSearchBtn;

    //filter button
    @FindBy(id = "journals-select-recipe-list-table-filter-button")
    public WebElement filterBtn;



    //name filter text field
    @FindBy(id = "journals-select-recipe-list-table-filter-input-name")
    public WebElement nameFilterTextField;

    @FindBy(id="journals-select-recipe-list-table-filter-select-affiliates-component")
    public WebElement affiliateFilterDropdown;

    //affiliate filter
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[1]/div/div[2]/div/div/div/form/div[1]/div[3]/div/div[1]/div[1]/div[2]/input")
    public WebElement affiliateFilterDropDown;

    //apply filter button
    @FindBy(id = "journals-select-recipe-list-table-filter-button-submit")
    public WebElement applyFilterBtn;

    //cancel filter button
    @FindBy(id = "journals-select-recipe-list-table-filter-button-cancel")
    public WebElement cancelFilterBtn;

    //clear filters button
    @FindBy(id = "journals-select-recipe-list-table-filter-button-clear")
    public WebElement clearFilterBtn;

    //view button
    @FindBy(id = "journals-select-recipe-list-table-viewing-options")
    public WebElement viewBtn;

    //toggle affiliate button from view
    @FindBy(id = "affiliateName")
    public WebElement toggleAffiliateBtn;

    //toggle created by button from view
    @FindBy(id = "createdBy")
    public WebElement toggleCreatedBy;

    //toggle created at button from view
    @FindBy(id = "createdAt")
    public WebElement toggleCreatedAt;

    //clear pinning button
    @FindBy(id = "select-recipe-table-viewing-option-dropdown-menu-item-clear-pin")
    public WebElement clearPinningBtn;

    //clear sorting button
    @FindBy(id = "journals-select-recipe-list-table-viewing-options-dropdown-menu-item-clear-sorting")
    public WebElement clearSortingBtn;

    //fetch recipes button
    @FindBy(id = "select-recipe-table-refresh")
    public WebElement fetchRecipesBtn;

    //expand first recipe button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div/div[3]")
    public WebElement expandFirstRecipeBtn;

    //first recipe name
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[1]")
    public WebElement firstRecipeName;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[2]")
    public WebElement firstJournalAffiliate;

    //first recipe affiliate
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[2]")
    public WebElement firstRecipeAffiliate;

    //first recipe created by
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[3]")
    public WebElement firstRecipeCreatedBy;

    //first recipe created at date
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[4]")
    public WebElement firstRecipeCreatedAt;

    //first recipe name
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[2]/div[1]")
    public WebElement secondRecipeName;

    //first recipe affiliate
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[2]/div[2]")
    public WebElement secondRecipeAffiliate;

    //first recipe created by
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[2]/div[3]")
    public WebElement secondRecipeCreatedBy;

    //first recipe created at date
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[2]/div[4]")
    public WebElement secondRecipeCreatedAt;

    //sort by name button
    @FindBy(id = "journals-select-recipe-list-table-name-column")
    public WebElement RecipesNameColumn;

    //sort by affiliate button
    @FindBy(id = "journals-select-recipe-list-table-affiliateName-column")
    public WebElement affiliateNameColumn;

    //sort by created by button
    @FindBy(id = "journals-select-recipe-list-table-createdBy-column")
    public WebElement createdByColumn;

    //sort by created at button
    @FindBy(id = "journals-select-recipe-list-table-createdAt-column")
    public WebElement createdAtColumn;

    //first instrument name of first recipe
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[4]/div/div/div/div/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div/div")
    public WebElement firstInstrument;

    //next button to expand instrument
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[4]/div/div/button")
    public WebElement nextBtn;

}