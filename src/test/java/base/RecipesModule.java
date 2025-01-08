package base;
import com.google.gson.internal.bind.util.ISO8601Utils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.RecipePage;

import java.util.concurrent.TransferQueue;


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
    Thread.sleep(2000);
    homePage.clickRecipesSidebarBtn();

}
    @Test(priority = 1)
    public void sortRecipesList () throws InterruptedException {
        Thread.sleep(2000);
        homePage.clickRecipesSidebarBtn();
        Thread.sleep(2000);
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
        Assert.assertTrue(recipesPage.getFirstRowName().compareTo(recipesPage.getThirdRowName())<=0);
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
        recipesPage.refreshWindow();
        Thread.sleep(1000);
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
        recipesPage.refreshWindow();
        Thread.sleep(1000);
        //clear any preset filter
        //click filter
        recipesPage.clickFilterBtn();
        //click clear
        recipesPage.clickFilterClearBtn();
        //click apply
        recipesPage.clickFilterApplyBtn();
        //show the created at column
        Assert.assertEquals(recipesPage.getFourthHeaderColumnText(), "Created At");
        //hide the created at column
        Thread.sleep(1000);
        recipesPage.clickViewBtn();
        recipesPage.clickToggleToCreateAtView();
        Assert.assertFalse(recipesPage.createdAtColumnHeaderDisplayed());
        Thread.sleep(1000);
        recipesPage.clickViewBtn();
        recipesPage.clickToggleToCreateAtView();
    }
    @Test(priority = 5)
    public void searchByRecipeName() throws InterruptedException {
        //clear any preset filter
        //click filter
        recipesPage.refreshWindow();
        recipesPage.clickFilterBtn();
        //click clear
        recipesPage.clickFilterClearBtn();
        //click apply
        recipesPage.clickFilterApplyBtn();
        //search by recipe name
        Thread.sleep(1000);
        String recipeName = recipesPage.getFirstRowName();
        recipesPage.sendTextToSearchNameTextField(recipeName);
        recipesPage.clickSearchBtn();
        Thread.sleep(2000);
        Assert.assertEquals(recipesPage.getFirstRowName(),recipeName);
        recipesPage.refreshWindow();
        Thread.sleep(1000);
    }
     //parameter list scenarios
    @Test(priority = 6)
    public void checkParameterList() throws InterruptedException {
    //go to parameters list
        recipesPage.refreshWindow();
        Thread.sleep(2000);
    recipesPage.clickFirstRowActions();
    recipesPage.clickRowViewParametersAction();
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
    public void searchByParameterName() throws InterruptedException {

    //preset any filter
    recipesPage.clickFilterRecipeParametersBtn();
    //clear any preset filter
    recipesPage.ClickRecipeParametersClearFilterBtn();
    //click apply button
    recipesPage.ClickRecipeParametersApplyFilterBtn();
    //search by second parameter name
    String parameterName = recipesPage.getSecondRowNameRP();
        System.out.println(parameterName);
        Thread.sleep(2000);
        recipesPage.sendTextToSearchNameTextFieldRP(parameterName);
        recipesPage.clickRecipeParametersSearchBtn();
    Thread.sleep(2000);
    Assert.assertEquals(recipesPage.getFirstRowNameRP(),parameterName);
    Thread.sleep(2000);
    recipesPage.refreshWindow();
    Thread.sleep(2000);
    }
        @Test(priority = 8)
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
    @Test(priority = 9)
    public void sortParametersList() throws InterruptedException {
    //sorting by name
        // preset any filter
        recipesPage.clickFilterRecipeParametersBtn();
        //clear any preset filter
        recipesPage.ClickRecipeParametersClearFilterBtn();
        //click apply button
        recipesPage.ClickRecipeParametersApplyFilterBtn();
    Thread.sleep(2000);
    recipesPage.clickViewRecipeParametersBtn();
    recipesPage.ClickToggleToIndexViewRPOption();
    recipesPage.ClickSortingIndexRPBtn();
    recipesPage.ClickSortingIndexAscRP();
    Thread.sleep(1000);
    recipesPage.ClickSortingNameRPBtn();
    recipesPage.ClickSortingNameAscRP();
        Thread.sleep(1000);
    Assert.assertTrue(recipesPage.getFirstRowName().compareTo(recipesPage.getSecondRowName())<=0);
        Thread.sleep(2000);
        recipesPage.ClickSortingNameRPBtn();
        recipesPage.ClickSortingNameAscRP();
        Thread.sleep(1000);
        recipesPage.ClickSortingIndexRPBtn();
        recipesPage.ClickSortingIndexAscRP();

    }
    @Test(priority = 10)
    public void viewColumnsInParametersList () throws InterruptedException {
        // view and hide columns
        Thread.sleep(1000);
        Assert.assertEquals(recipesPage.getFifthColumnText(), "Index");
        Thread.sleep(1000);
        recipesPage.clickViewRecipeParametersBtn();
        Thread.sleep(1000);
        recipesPage.ClickToggleToBiasViewRPOption();
        Assert.assertEquals(recipesPage.getSixthColumnText(), "Bias");
        Thread.sleep(1000);
        recipesPage.clickViewRecipeParametersBtn();
        Thread.sleep(1000);
        recipesPage.ClickToggleToAvgViewRPOption();
        Assert.assertEquals(recipesPage.getSeventhColumnText(), "Avg");
        Thread.sleep(1000);
        recipesPage.clickViewRecipeParametersBtn();
        Thread.sleep(1000);
        recipesPage.ClickToggleToSlopeViewRPOption();
        Assert.assertEquals(recipesPage.getEighthColumnText(), "Slope");
        Thread.sleep(1000);
        recipesPage.clickViewRecipeParametersBtn();
        Thread.sleep(1000);
        recipesPage.ClickToggleToMinViewRPOption();
        Assert.assertEquals(recipesPage.getNinthColumnText(), "Min");
        Thread.sleep(1000);
        recipesPage.clickViewRecipeParametersBtn();
        Thread.sleep(1000);
        recipesPage.ClickToggleToMaxViewRPOption();
        Assert.assertEquals(recipesPage.getTenthColumnText(), "Max");
        Thread.sleep(1000);
        recipesPage.clickViewRecipeParametersBtn();
        Thread.sleep(1000);
        recipesPage.ClickToggleToMahalanobisViewRPOption();
        Assert.assertEquals(recipesPage.getEleventhColumnText(), "Mahalanobis");
        Thread.sleep(1000);
        recipesPage.clickViewRecipeParametersBtn();
        Thread.sleep(1000);
        recipesPage.ClickToggleToCreateAtViewRPOption();
        Thread.sleep(1000);
        recipesPage.clickViewRecipeParametersBtn();
        Thread.sleep(1000);
        recipesPage.ClickToggleToBiasViewRPOption();
        Thread.sleep(1000);
        recipesPage.clickViewRecipeParametersBtn();
        Thread.sleep(1000);
        recipesPage.ClickToggleToAvgViewRPOption();
        Thread.sleep(1000);
        recipesPage.clickViewRecipeParametersBtn();
        Thread.sleep(1000);
        recipesPage.ClickToggleToSlopeViewRPOption();
        Thread.sleep(1000);
        recipesPage.clickViewRecipeParametersBtn();
        Thread.sleep(1000);
        recipesPage.ClickToggleToMinViewRPOption();
        Thread.sleep(1000);
        recipesPage.clickViewRecipeParametersBtn();
        Thread.sleep(1000);
        recipesPage.ClickToggleToMaxViewRPOption();
        Thread.sleep(1000);
        recipesPage.clickViewRecipeParametersBtn();
        Thread.sleep(1000);
        recipesPage.ClickToggleToMahalanobisViewRPOption();
    }
    @Test(priority = 11)
    public void viewCalibrationFiles() throws InterruptedException {
    //recipesPage.refreshWindow();
    Thread.sleep(1000);
    recipesPage.clickFirstRowActionBtnRP();
    recipesPage.ClickFirstRowViewCalFilesOptionRP();
    }
    @Test(priority = 12)
    public void checkCalibrationFilesList(){
    recipesPage.calibrationFilesBackPageBtnIsDisplayed();
    recipesPage.calibrationFilesBckRowBtnIsDisplayed();
    recipesPage.calibrationFilesDeployedAtFieldIsDisplayed();
    recipesPage.calibrationFilesExpandBtnIsDisplayed();
    recipesPage.calibrationFilesDeployedAtFieldIsDisplayed();
    recipesPage.calibrationFilesFrowardPageBtnIsDisplayed();
    recipesPage.calibrationFilesPageTitleIsDisplayed();
    recipesPage.calibrationFilesSearchBtnIsDisplayed();
    recipesPage.calibrationFilesSearchTextFieldIsDisplayed();
    recipesPage.viewCalibrationFilesBtnIsDisplayed();
    recipesPage.filterCalibrationFilesBtnIsDisplayed();
    }

    //delay until migrate the calibration files table to AG-grid
//    @Test(priority = 13)
//    public void filterCalibrationFiles(){
//    recipesPage.clickFilterCalibrationFilesBtn();
//    recipesPage.calibrationFilesApplyFilterBtnIsDisplayed();
//    recipesPage.calibrationFilesClearFilterBtnIsDisplayed();
//    recipesPage.calibrationFilesCloseFilterBtnIsDisplayed();
//    recipesPage.calibrationFilesCancelFilterBtnIsDisplayed();
//    recipesPage.calibrationFilesFilterWindowTitleIsDisplayed();
//    recipesPage.calibrationFilesFilterCreatedAtIsDisplayed();
//    recipesPage.calibrationFilesFilterNameIsDisplayed();
//    recipesPage.calibrationFilesFilterCreatedByIsDisplayed();
//    recipesPage.ClickCalibrationFilesCancelFilterBtn();
//
//    }
//
//    @Test(priority = 14)
//    public void expandCalibrationFilesList(){
//    recipesPage.clickExpandBtnCalibrationFiles();
//    recipesPage.calibrationFilesStatusFieldIsDisplayed();
//    recipesPage.calibrationFilesDeployedAtFieldIsDisplayed();
//    recipesPage.calibrationFilesModifiedAtFieldIsDisplayed();
//    recipesPage.calibrationFilesCreatedAtFieldIsDisplayed();
//    recipesPage.calibrationFilesSecondRowActionBtnIsDisplayed();
//    }
//    @Test(priority = 15)
//    public void deployFileOnCalibrationFiles(){
//    recipesPage.clickOnActionBtnCalibrationFiles();
//    recipesPage.clickOnDeployBtn();
//    recipesPage.calibrationFilesDeploymentPopupCloseBtnIsDisplayed();
//    recipesPage.calibrationFilesDeploymentPopupTitleIsDisplayed();
//    recipesPage.calibrationFilesDeploymentPopupCancelBtnIsDisplayed();
//    recipesPage.calibrationFilesDeploymentPopupSubmitBtnIsDisplayed();
//    }





@AfterClass
    public void closeBrowser(){
    MainTestRunner.ChromeDriver.quit();
}

}