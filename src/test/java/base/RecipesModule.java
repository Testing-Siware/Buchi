package base;
import com.google.gson.internal.bind.util.ISO8601Utils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.Actions;
import pages.HomePage;
import pages.LoginPage;
import pages.RecipePage;

import java.util.concurrent.TransferQueue;


public class RecipesModule {
    HomePage homePage;
    RecipePage recipesPage;
    LoginPage loginPage;
    Actions actions;

    @BeforeClass
public void startTestRecipesList() throws InterruptedException {
    homePage = new HomePage((ChromeDriver) MainTestRunner.ChromeDriver);
    recipesPage= new RecipePage((ChromeDriver) MainTestRunner.ChromeDriver);
    loginPage= new LoginPage((ChromeDriver) MainTestRunner.ChromeDriver);
    actions= new Actions((ChromeDriver) MainTestRunner.ChromeDriver,20);

    //login and navigate to Recipes page
    Thread.sleep(1000);
//    loginPage.loginWithCredentials("mostafa.hassan+pa@si-ware.com","Cqc@12345");


}
    @Test(priority = 1)
    public void sortRecipesList () throws InterruptedException {
        Thread.sleep(2000);
        homePage.clickRecipesSidebarBtn();
        Thread.sleep(2000);
        //clear any preset filter
        //click filter
        actions.clickElement(recipesPage.filterBtn);
        //click clear
        actions.clickElement(recipesPage.filterClearBtn);

        //sort by name ascending
        Thread.sleep(3000);
        actions.clickElement(recipesPage.nameRecipesColumnHeader);

        actions.clickElement(recipesPage.sortingRPNameAsc);
        Thread.sleep(2000);

        System.out.println(actions.getText(recipesPage.firstRowName));
        System.out.println(actions.getText(recipesPage.secondRowName));
        System.out.println((actions.getText(recipesPage.firstRowName)).compareTo(actions.getText(recipesPage.secondRowName)));
    }

    @Test(priority = 3)
    public void filterByName() throws InterruptedException {

        //clear any preset filter
        actions.clickElement(recipesPage.filterBtn);
        actions.clickElement(recipesPage.filterClearBtn);

        //fetch data to filter by
        Thread.sleep(2000);
        String recipeToFilter=actions.getText(recipesPage.thirdRowName);
        actions.clickElement(recipesPage.filterBtn);

        //click filter
        actions.clickElement(recipesPage.filterBtn);

        //send text to name filter
        actions.enterText(recipesPage.filterName,recipeToFilter);

        //click apply
        actions.clickElement(recipesPage.filterApplyBtn);

        //filter the recipes by name
        Thread.sleep(2000);

        //test that results appear
        System.out.println(recipeToFilter);
        System.out.println(actions.getText(recipesPage.firstRowName));

    }

    @Test(priority = 4)
    public void viewColumns () throws InterruptedException {

        //clear any preset filter
        actions.clickElement(recipesPage.filterBtn);
        actions.clickElement(recipesPage.filterClearBtn);

        Thread.sleep(2000);

        //click view button
        actions.clickElement(recipesPage.viewBtn);

        //toggle created at column
        actions.clickElement(recipesPage.toggleToCreatedAtView);

        //test that created at column is not visible
        Thread.sleep(1000);
        Assert.assertFalse(actions.isElementDisplayed(recipesPage.createdAtColumnHeader));

        //click view button
        actions.clickElement(recipesPage.viewBtn);

        //toggle created at column
        actions.clickElement(recipesPage.toggleToCreatedAtView);

        //test that created at column is visible
        Thread.sleep(1000);
        Assert.assertTrue(actions.isElementDisplayed(recipesPage.createdAtColumnHeader));
    }

    @Test(priority = 5)
    public void searchByRecipeName() throws InterruptedException {
        //clear any preset filter
        actions.clickElement(recipesPage.filterBtn);
        //click clear
        actions.clickElement(recipesPage.filterClearBtn);

        //fetch data too search by
        Thread.sleep(1000);
        String recipeName = actions.getText(recipesPage.firstRowName);

        //send the recipe name to search field
        actions.enterText(recipesPage.searchField,recipeName);
        actions.clickElement(recipesPage.searchBtn);

        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(recipesPage.firstRowName),recipeName);
    }
     //parameter list scenarios
    @Test(priority = 6)
    public void checkParameterList() throws InterruptedException {
        //go to parameters list
        Thread.sleep(2000);

        //click first action btn
        actions.clickElement(recipesPage.firstRowActions);

        //click view parameters
        actions.clickElement(recipesPage.viewRecipeParametersBtn);

        //check display of parameter list
        Thread.sleep(2000);
        System.out.println(MainTestRunner.ChromeDriver.getCurrentUrl());
    }

    @Test(priority = 7)
    public void searchByParameterName() throws InterruptedException {

    //preset any filter
    actions.clickElement(recipesPage.filterRecipeParametersBtn);
    
    //clear any preset filter
    actions.clickElement(recipesPage.recipeParametersClearFilterBtn);
    Thread.sleep(2000);

    //fetch data to search by
    String parameterName = actions.getText(recipesPage.firstRowNameRP);
    System.out.println(parameterName);

    //send data to search by
    actions.enterText(recipesPage.recipeParameterSearchField,parameterName);
    actions.clickElement(recipesPage.recipeParametersSearchBtn);

    //test that results appear
    Thread.sleep(2000);
    Assert.assertEquals(actions.getText(recipesPage.firstRowNameRP),parameterName);
    }

    @Test(priority = 8)
    public void filterByNameInParameters() throws InterruptedException {
        //clear any preset filter
        actions.clickElement(recipesPage.filterRecipeParametersBtn);
        actions.clickElement(recipesPage.recipeParametersClearFilterBtn);

        //fetch data to filter by
        String parameterName = actions.getText(recipesPage.firstRowNameRP);
        System.out.println(parameterName);

        //filter by first row name
        actions.clickElement(recipesPage.filterRecipeParametersBtn);
        actions.enterText(recipesPage.recipeParametersFilterName,parameterName);
        actions.clickElement(recipesPage.recipeParametersApplyFilterBtn);

        //test that data appears
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(recipesPage.firstRowNameRP),parameterName);
    }

    @Test(priority = 9)
    public void sortParametersList() throws InterruptedException {
        //clear any preset filter
        actions.clickElement(recipesPage.filterRecipeParametersBtn);
        actions.clickElement(recipesPage.recipeParametersClearFilterBtn);

        //click sort by name button
        Thread.sleep(2000);
        actions.clickElement(recipesPage.nameSortingRPBtn);

        //click sort ascending
        actions.clickElement(recipesPage.sortingRPNameAsc);

        //test that data is sorted
        Thread.sleep(2000);
        String first=actions.getText(recipesPage.firstRowNameRP);
        String second=actions.getText(recipesPage.secondRowNameRP);
        System.out.println(first.compareTo(second));
        Assert.assertTrue((first.compareTo(second))<=0);


        //click sort by name button
        Thread.sleep(2000);
        actions.clickElement(recipesPage.nameSortingRPBtn);

        //click sort descending
        actions.clickElement(recipesPage.sortingRPNameDesc);

        //test that data is sorted
        Thread.sleep(2000);
         first=actions.getText(recipesPage.firstRowNameRP);
         second=actions.getText(recipesPage.secondRowNameRP);
        System.out.println(first.compareTo(second));
        Assert.assertTrue((first.compareTo(second))>=0);

    }
    @Test(priority = 10)
    public void viewColumnsInParametersList () throws InterruptedException {
        //click view
        actions.clickElement(recipesPage.viewRecipeParametersBtn);

        //toggle index column
        actions.clickElement(recipesPage.toggleToIndexViewRP);

        //test that index column appears
        Assert.assertTrue(actions.isElementDisplayed(recipesPage.indexSortingRPBtn));

        //click view
        actions.clickElement(recipesPage.viewRecipeParametersBtn);

        //toggle index column
        actions.clickElement(recipesPage.toggleToBiasViewRP);

        //test that index column appears
        Assert.assertTrue(actions.isElementDisplayed(recipesPage.recipeParameterBiasColumn));

        //click view
        actions.clickElement(recipesPage.viewRecipeParametersBtn);

        //toggle index column
        actions.clickElement(recipesPage.toggleToAvgViewRP);

        //scroll horizontally in table
        actions.scrollToElementHorizontally(recipesPage.tableHorizontalScrollBar, (ChromeDriver) MainTestRunner.ChromeDriver);

        //test that index column appears
        Assert.assertTrue(actions.isElementDisplayed(recipesPage.recipeParameterAvgColumn));

        //click view
        actions.clickElement(recipesPage.viewRecipeParametersBtn);

        //toggle index column
        actions.clickElement(recipesPage.toggleToSlopeViewRP);

        //scroll horizontally in table
        actions.scrollToElementHorizontally(recipesPage.tableHorizontalScrollBar, (ChromeDriver) MainTestRunner.ChromeDriver);

        //test that index column appears
        Assert.assertTrue(actions.isElementDisplayed(recipesPage.recipeParameterSlopeColumn));

        //click view
        actions.clickElement(recipesPage.viewRecipeParametersBtn);

        //toggle index column
        actions.clickElement(recipesPage.toggleToMinViewRP);

        //scroll horizontally in table
        actions.scrollToElementHorizontally(recipesPage.tableHorizontalScrollBar, (ChromeDriver) MainTestRunner.ChromeDriver);

        //test that index column appears
        Assert.assertTrue(actions.isElementDisplayed(recipesPage.recipeParameterMinColumn));

        //click view
        actions.clickElement(recipesPage.viewRecipeParametersBtn);

        //toggle index column
        actions.clickElement(recipesPage.toggleToMaxViewRP);

        //scroll horizontally in table
        actions.scrollToElementHorizontally(recipesPage.tableHorizontalScrollBar, (ChromeDriver) MainTestRunner.ChromeDriver);

        //test that index column appears
        Assert.assertTrue(actions.isElementDisplayed(recipesPage.recipeParameterMaxColumn));

        //click view
        actions.clickElement(recipesPage.viewRecipeParametersBtn);

        //toggle index column
        actions.clickElement(recipesPage.toggleToMahalanobisViewRP);

        //scroll horizontally in table
        actions.scrollToElementHorizontally(recipesPage.tableHorizontalScrollBar, (ChromeDriver) MainTestRunner.ChromeDriver);

        //test that index column appears
        Assert.assertTrue(actions.isElementDisplayed(recipesPage.recipeParameterMahalanobisColumn));

        //click view
        actions.clickElement(recipesPage.viewRecipeParametersBtn);

        //toggle index column
        actions.clickElement(recipesPage.toggleToCreatedAtView);

        //scroll horizontally in table
        actions.scrollToElementHorizontally(recipesPage.tableHorizontalScrollBar, (ChromeDriver) MainTestRunner.ChromeDriver);

        //test that index column appears
        Assert.assertTrue(actions.isElementDisplayed(recipesPage.recipeParameterCreatedByColumn));
    }

    @Test(priority = 11)
    public void viewCalibrationFiles() throws InterruptedException {
    //recipesPage.refreshWindow();
    Thread.sleep(1000);
    actions.clickElement(recipesPage.firstRowActionsBtnInParameters);
    actions.clickElement(recipesPage.firstRowViewCalibrationActions);
    System.out.println(MainTestRunner.ChromeDriver.getCurrentUrl());
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