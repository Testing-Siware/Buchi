package base;



import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.RecipePage;


public class RecipesModule {
    HomePage homePage;
    RecipePage recipesPage;
    LoginPage loginPage;
@BeforeClass
public void startTestRecipesList() throws InterruptedException {
    homePage = new HomePage((ChromeDriver) MainTestRunner.ChromeDriver);
    recipesPage= new RecipePage((ChromeDriver) MainTestRunner.ChromeDriver);
    loginPage= new LoginPage((ChromeDriver) MainTestRunner.ChromeDriver);
    //login and navigate to Recipes page
    Thread.sleep(1000);
    loginPage.loginWithCredentials("mostafa.hassan+pa@si-ware.com","Cqc@12345");
    homePage.clickRecipesSidebarBtn();
}
    @Test(priority = 1)
    public void sortRecipesList () throws InterruptedException {
        //clear any preset filter
        //click filter
        recipesPage.clickFilterBtn();
        //click clear
        recipesPage.clickFilterClearBtn();
        //click apply
        recipesPage.clickFilterApplyBtn();
        //sort by name ascending
        Thread.sleep(3000);
        recipesPage.clickSortingNameColBtn();
        //check the display of the sorting options
        recipesPage.sortingNameColIsDisplayed();
        recipesPage.sortingNameAscIsDisplayed();
        recipesPage.sortingNameDescIsDisplayed();
        recipesPage.pinNameColumnOptionIsDisplayed();
        //sorting by name ascending
        recipesPage.clickSortingNameAscOption();
        Assert.assertTrue(recipesPage.getFirstRowName().compareTo(recipesPage.getSecondRowName())<=0);
    }
    @Test(priority = 2)
    public void displayOfTableAndButtons() throws InterruptedException {
        //assert the display of the Recipes table and buttons
        recipesPage.backPageBtnIsDisplayed();
        recipesPage.backRowBtnIsDisplayed();
        recipesPage.filterBtnIsDisplayed();
        recipesPage.viewBtnIsDisplayed();
        recipesPage.searchBtnIsDisplayed();
        recipesPage.searchTextFieldIsDisplayed();
        recipesPage.recipePageTitleIsDisplayed();
        recipesPage.firstRowActionsBtnIsDisplayed();
        recipesPage.firstRowCreatedByIsDisplayed();
        recipesPage.firstRowNameIsDisplayed();
        recipesPage.firstRowAffiliateIsDisplayed();
        recipesPage.rowsPerPageIsDisplayed();
        recipesPage.frowardRowBtnIsDisplayed();
        recipesPage.frowardPageBtnIsDisplayed();

    }
    @Test(priority = 3)
    public void filterByName() throws InterruptedException {

        //clear any preset filter
        //click filter and check the display of filter window
        recipesPage.clickFilterBtn();
        recipesPage.filterWindowTitleIsDisplayed();
        recipesPage.filterNameTxtFieldIsDisplayed();
        recipesPage.filterCreatedAtTxtFieldIsDisplayed();
        recipesPage.filterAffiliateTxtFieldIsDisplayed();
        recipesPage.filterCancelBtnIsDisplayed();
        recipesPage.filterClearBtnIsDisplayed();
        recipesPage.filterApplyBtnIsDisplayed();
        recipesPage.filterCloseBtnIsDisplayed();
        //click clear
        recipesPage.clickFilterClearBtn();
        //click apply
        recipesPage.clickFilterApplyBtn();
        //filter the recipes by name
        recipesPage.clickFilterBtn();
        recipesPage.sendTextToFilterNameTextField(recipesPage.getFirstRowName());
        recipesPage.clickFilterApplyBtn();
    }
    @Test(priority = 4)
    public void viewColumns () throws InterruptedException {
        //clear any preset filter
        //click filter
        recipesPage.clickFilterBtn();
        //click clear
        recipesPage.clickFilterClearBtn();
        //click apply
        recipesPage.clickFilterApplyBtn();

        //show the created at column
        recipesPage.clickViewBtn();
        recipesPage.clickToggleToCreateAtView();
        Assert.assertEquals(recipesPage.getFourthHeaderColumnText(), "Created at");
        //hide the created at column
        Thread.sleep(1000);
        recipesPage.clickViewBtn();
        recipesPage.clickToggleToCreateAtView();
        Assert.assertFalse(recipesPage.createdAtColumnHeaderDisplayed());
    }
    @Test(priority = 5)
    public void searchByRecipeName() throws InterruptedException {
        //clear any preset filter
        //click filter
        recipesPage.clickFilterBtn();
        //click clear
        recipesPage.clickFilterClearBtn();
        //click apply
        recipesPage.clickFilterApplyBtn();
        //search by recipe name
        String recipeName = recipesPage.getSecondRowName();
        recipesPage.sendTextToSearchField(recipeName);
        recipesPage.clickSearchBtn();
        Thread.sleep(2000);
        Assert.assertEquals(recipesPage.getFirstRowName(),recipeName);
        recipesPage.refreshWindow();
        Thread.sleep(1000);
    }
     //parameter list scenarios
    @Test(priority = 6)
    public void checkParameterList(){
    //go to parameters list
    recipesPage.clickFirstRowActions();
    recipesPage.clickFirstRowViewParametersAction();
    //check display of parameter list
    recipesPage.recipeParameterPageTitleIsDisplayed();
    recipesPage.recipeParametersBackPageBtnIsDisplayed();
    recipesPage.recipeParametersFrowardPageBtnIsDisplayed();
    recipesPage.recipeParametersFrowardRowBtnIsDisplayed();
    recipesPage.recipeParametersBckRowBtnIsDisplayed();
    recipesPage.recipeParametersSearchBtnIsDisplayed();
    recipesPage.recipeParametersSearchTextFieldIsDisplayed();
    recipesPage.viewRecipeParametersBtnIsDisplayed();
    recipesPage.filterRecipeParametersBtnIsDisplayed();
    recipesPage.firstRowActionsBtnIsDisplayed();
    recipesPage.recipeParametersRowsPerPageIsDisplayed();
    recipesPage.recipeParameterActionBtnIsDisplayed();
    }
    @Test(priority = 7)
    public void filterByNameInParameters(){
    //filter by name and check display of filter window
    recipesPage.clickFilterRecipeParametersBtn();
    recipesPage.recipeParametersFilterWindowTitleIsDisplayed();
    recipesPage.recipeParametersFilterNameIsDisplayed();
    recipesPage.recipeParametersFilterCreatedAtIsDisplayed();
    recipesPage.recipeParametersFilterCreatedByIsDisplayed();
    recipesPage.recipeParametersCancelFilterBtnIsDisplayed();
    recipesPage.recipeParametersClearFilterBtnIsDisplayed();
    recipesPage.recipeParametersApplyFilterBtnIsDisplayed();
    recipesPage.recipeParametersCloseFilterBtnIsDisplayed();
    //clear any preset filter
    recipesPage.ClickRecipeParametersClearFilterBtn();
    //click apply button
    recipesPage.ClickRecipeParametersApplyFilterBtn();
    //filter by first row name
    recipesPage.clickFilterRecipeParametersBtn();
    recipesPage.sendTextToRecipeParametersFilterNameField(recipesPage.getFirstRowName());
    recipesPage.ClickRecipeParametersApplyFilterBtn();
    }
    @Test(priority = 8)
    public void searchByParameterName() throws InterruptedException {

    //preset any filter
    recipesPage.clickFilterRecipeParametersBtn();
    //clear any preset filter
    recipesPage.ClickRecipeParametersClearFilterBtn();
    //click apply button
    recipesPage.ClickRecipeParametersApplyFilterBtn();
    //search by second parameter name
    String parameterName = recipesPage.getSecondRowName();
    recipesPage.sendTextToRecipeParameterSearchField(parameterName);
    recipesPage.clickRecipeParametersSearchBtn();
    Thread.sleep(2000);
    Assert.assertEquals(recipesPage.getFirstRowName(),parameterName);
    Thread.sleep(2000);
    recipesPage.clickSearchField();
    recipesPage.resetSearchField(parameterName);
    recipesPage.refreshWindow();
    Thread.sleep(2000);
    }
    @Test(priority = 9)
    public void sortParametersList() throws InterruptedException {

    //sorting by name
    recipesPage.ClickSortingNameRPBtn();
    recipesPage.ClickSortingNameAscRP();
    Assert.assertTrue(recipesPage.getFirstRowNameRP().compareTo(recipesPage.getSecondRowNameRP())<=0);
//    recipesPage.ClickSortingNameRPBtn();
//    recipesPage.clickPinNameColumnOption();
    recipesPage.refreshWindow();


    }
    @Test(priority = 10)
    public void viewColumnsInParametersList () throws InterruptedException {
    // view and hide columns
        Thread.sleep(1000);
    recipesPage.clickViewRecipeParametersBtn();
        Thread.sleep(1000);
    recipesPage.ClickToggleToLocationViewRPOption();
        Thread.sleep(1000);
    Assert.assertEquals(recipesPage.getFifthColumnText(), "Location");
    Thread.sleep(1000);
    recipesPage.clickViewRecipeParametersBtn();
        Thread.sleep(1000);
    recipesPage.ClickToggleToLocationViewRPOption();
        Thread.sleep(1000);
        recipesPage.clickViewRecipeParametersBtn();
    recipesPage.ClickToggleToSlopViewRPOption();
    Assert.assertEquals(recipesPage.getFifthColumnText(), "Slope");
        Thread.sleep(1000);
    recipesPage.clickViewRecipeParametersBtn();
        Thread.sleep(1000);
    recipesPage.ClickToggleToSlopViewRPOption();
        Thread.sleep(1000);
        recipesPage.clickViewRecipeParametersBtn();
        Thread.sleep(1000);
    recipesPage.ClickToggleToMinViewRPOption();
    Assert.assertEquals(recipesPage.getFifthColumnText(), "min");
        Thread.sleep(1000);
    recipesPage.clickViewRecipeParametersBtn();
        Thread.sleep(1000);
    recipesPage.ClickToggleToMinViewRPOption();
        Thread.sleep(1000);
        recipesPage.clickViewRecipeParametersBtn();
        Thread.sleep(1000);
    recipesPage.ClickToggleToMaxViewRPOption();
    Assert.assertEquals(recipesPage.getFifthColumnText(), "max");
        Thread.sleep(1000);
    recipesPage.clickViewRecipeParametersBtn();
        Thread.sleep(1000);
    recipesPage.ClickToggleToMaxViewRPOption();
        Thread.sleep(1000);
        recipesPage.clickViewRecipeParametersBtn();
        Thread.sleep(1000);
    recipesPage.ClickToggleToMahalanobisViewRPOption();
    Assert.assertEquals(recipesPage.getFifthColumnText(), "Mahalanobis");
         Thread.sleep(1000);
        recipesPage.clickViewRecipeParametersBtn();
        Thread.sleep(1000);
        recipesPage.ClickToggleToMahalanobisViewRPOption();
        Thread.sleep(1000);
        recipesPage.clickViewRecipeParametersBtn();
        Thread.sleep(1000);
        recipesPage.ClickToggleToCreateByViewRPOption();
        Assert.assertEquals(recipesPage.getFifthColumnText(), "Created by");
        Thread.sleep(1000);
    recipesPage.clickViewRecipeParametersBtn();
        Thread.sleep(1000);
    recipesPage.ClickToggleToCreateByViewRPOption();
        Thread.sleep(1000);
        recipesPage.clickViewRecipeParametersBtn();
        Thread.sleep(1000);
    recipesPage.ClickToggleToCreateAtViewRPOption();
    Assert.assertEquals(recipesPage.getFifthColumnText(), "Created at");
        Thread.sleep(1000);
        recipesPage.refreshWindow();
    }
    @Test(priority = 11)
    public void viewCalibrationFiles(){
    recipesPage.ClickFirstRowActionsBtnRP();
    recipesPage.ClickFirstRowViewCalFilesOptionRP();
    }





@AfterClass
    public void closeBrowser(){
    MainTestRunner.ChromeDriver.quit();
}

}
