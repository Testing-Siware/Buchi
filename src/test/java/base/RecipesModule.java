package base;
import data.Credentials;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.Actions;
import pages.HomePage;
import pages.LoginPage;
import pages.RecipePage;
import utils.Helpers;

import java.util.Date;
import java.util.List;


public class RecipesModule {
    HomePage homePage;
    RecipePage recipesPage;
    LoginPage loginPage;
    Actions actions;

    @BeforeClass
    public void startTestRecipesList() throws InterruptedException {
        homePage = new HomePage((ChromeDriver) MainTestRunner.ChromeDriver);
        recipesPage = new RecipePage((ChromeDriver) MainTestRunner.ChromeDriver);
        loginPage = new LoginPage((ChromeDriver) MainTestRunner.ChromeDriver);
        actions = new Actions((ChromeDriver) MainTestRunner.ChromeDriver, 20);

        //login and navigate to Recipes page
        Thread.sleep(1000);
//    loginPage.loginWithCredentials("mostafa.hassan+pa@si-ware.com","Cqc@12345");


    }

    @Test(priority = 1, dependsOnMethods = "verifyPagingFunctionality")
    public void sortRecipesList() throws InterruptedException {
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
        actions.clickElement(recipesPage.nameColumnHeader);

        actions.clickElement(recipesPage.sortRecipeNameAsc);
        Thread.sleep(2000);

        Assert.assertTrue((actions.getText(recipesPage.firstRowName)).compareTo(actions.getText(recipesPage.secondRowName)) <= 0);
    }

    @Test(priority = 3)
    public void filterByName() throws InterruptedException {

        //clear any preset filter
        actions.clickElement(recipesPage.filterBtn);
        actions.clickElement(recipesPage.filterClearBtn);

        //fetch data to filter by
        Thread.sleep(2000);
        String recipeToFilter = actions.getText(recipesPage.thirdRowName);
        actions.clickElement(recipesPage.filterBtn);

        //click filter
        actions.clickElement(recipesPage.filterBtn);

        //send text to name filter
        actions.enterText(recipesPage.filterName, recipeToFilter);

        //click apply
        actions.clickElement(recipesPage.filterApplyBtn);

        //filter the recipes by name
        Thread.sleep(2000);

        //test that results appear
        Assert.assertEquals(actions.getText(recipesPage.firstRowName), recipeToFilter);
    }

    @Test(priority = 4)
    public void viewColumns() throws InterruptedException {

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
        Assert.assertFalse(actions.isElementDisplayed(recipesPage.recipeCreatedAtColumnHeader));

        //click view button
        actions.clickElement(recipesPage.viewBtn);

        //toggle created at column
        actions.clickElement(recipesPage.toggleToCreatedAtView);

        //test that created at column is visible
        Thread.sleep(1000);
        Assert.assertTrue(actions.isElementDisplayed(recipesPage.recipeCreatedAtColumnHeader));
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
        actions.enterText(recipesPage.searchField, recipeName);
        actions.clickElement(recipesPage.searchBtn);

        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(recipesPage.firstRowName), recipeName);
    }

    //parameter list scenarios
    @Test(priority = 6)
    public void checkParameterList() throws InterruptedException {
        //go to parameters list
        Thread.sleep(2000);

        //click first action btn
        actions.clickElement(recipesPage.firstRowActions);

        //click view parameters
        actions.clickElement(recipesPage.RowViewParametersAction);

        //test that user was re-directed
        Thread.sleep(2000);
        Assert.assertTrue(MainTestRunner.ChromeDriver.getCurrentUrl().contains("parameters"));
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
        actions.enterText(recipesPage.recipeParameterSearchField, parameterName);
        actions.clickElement(recipesPage.recipeParametersSearchBtn);

        //test that results appear
        MainTestRunner.ChromeDriver.navigate().refresh();
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(recipesPage.firstRowNameRP), parameterName);
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
        actions.enterText(recipesPage.recipeParametersFilterName, parameterName);
        actions.clickElement(recipesPage.recipeParametersApplyFilterBtn);

        //test that data appears
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(recipesPage.firstRowNameRP), parameterName);
    }

    @Test(priority = 9)
    public void sortParametersList() throws InterruptedException {
        //clear any preset filter
        actions.clickElement(recipesPage.filterRecipeParametersBtn);
        actions.clickElement(recipesPage.recipeParametersClearFilterBtn);

        //clear index sort

        //click view button
        Thread.sleep(2000);
        actions.clickElement(recipesPage.viewRecipeParametersBtn);

        //toggle index column
        actions.clickElement(recipesPage.toggleToIndexViewRP);

        //click index column
        actions.clickElement(recipesPage.indexSortingRPBtn);

        //remove ascending sort
        actions.clickElement(recipesPage.sortingRPIndexAsc);

        //click view button
        actions.clickElement(recipesPage.viewRecipeParametersBtn);

        //toggle index column
        actions.clickElement(recipesPage.toggleToIndexViewRP);

        //click sort by name button
        Thread.sleep(2000);
        actions.clickElement(recipesPage.nameSortingRPBtn);

        //click sort ascending
        actions.clickElement(recipesPage.sortingRPNameAsc);

        //test that data is sorted
        Thread.sleep(2000);
        String first = actions.getText(recipesPage.firstRowNameRP);
        String second = actions.getText(recipesPage.secondRowNameRP);
        System.out.println(first.compareTo(second));
        Assert.assertTrue((first.compareTo(second)) <= 0);

        //click sort by name button
        Thread.sleep(2000);
        actions.clickElement(recipesPage.nameSortingRPBtn);

        //click sort descending
        actions.clickElement(recipesPage.sortingRPNameDesc);

        //test that data is sorted
        Thread.sleep(2000);
        first = actions.getText(recipesPage.firstRowNameRP);
        second = actions.getText(recipesPage.secondRowNameRP);
        System.out.println(first.compareTo(second));
        Assert.assertTrue((first.compareTo(second)) >= 0);

        //remove sorting
        //click view
        actions.clickElement(recipesPage.viewRecipeParametersBtn);

        //click clear sorting
        actions.clickElement(recipesPage.clearSortingViewRP);
    }

    @Test(priority = 10)
    public void viewColumnsInParametersList() throws InterruptedException {
        //click view
        Thread.sleep(2000);
        actions.clickElement(recipesPage.viewRecipeParametersBtn);

        //toggle index column
        actions.clickElement(recipesPage.toggleToIndexViewRP);

        //test that index column appears
        Assert.assertTrue(actions.isElementDisplayed(recipesPage.indexSortingRPBtn));

        //click view
        Thread.sleep(2000);
        actions.clickElement(recipesPage.viewRecipeParametersBtn);

        //toggle bias column
        actions.clickElement(recipesPage.toggleToBiasViewRP);

        //test that index column appears
        Assert.assertTrue(actions.isElementDisplayed(recipesPage.recipeParameterBiasColumn));

        //click view
        Thread.sleep(2000);
        actions.clickElement(recipesPage.viewRecipeParametersBtn);

        //toggle avg column
        actions.clickElement(recipesPage.toggleToAvgViewRP);

        //scroll horizontally in table
        actions.scrollToElementHorizontally(recipesPage.tableHorizontalScrollBar, 1000);

        //test that avg column appears
        Assert.assertTrue(actions.isElementDisplayed(recipesPage.recipeParameterAvgColumn));

        //click view
        Thread.sleep(2000);
        actions.clickElement(recipesPage.viewRecipeParametersBtn);

        //toggle slope column
        actions.clickElement(recipesPage.toggleToSlopeViewRP);

        //scroll horizontally in table
        actions.scrollToElementHorizontally(recipesPage.tableHorizontalScrollBar, 1000);

        //test that slope column appears
        Assert.assertTrue(actions.isElementDisplayed(recipesPage.recipeParameterSlopeColumn));

        //click view
        Thread.sleep(2000);
        actions.clickElement(recipesPage.viewRecipeParametersBtn);

        //toggle min column
        actions.clickElement(recipesPage.toggleToMinViewRP);

        //scroll horizontally in table
        actions.scrollToElementHorizontally(recipesPage.tableHorizontalScrollBar, 1000);

        //test that min column appears
        Assert.assertTrue(actions.isElementDisplayed(recipesPage.recipeParameterMinColumn));

        //click view
        Thread.sleep(2000);
        actions.clickElement(recipesPage.viewRecipeParametersBtn);

        //toggle max column
        actions.clickElement(recipesPage.toggleToMaxViewRP);

        //scroll horizontally in table
        actions.scrollToElementHorizontally(recipesPage.tableHorizontalScrollBar, 1000);

        //test that  column appears
        Assert.assertTrue(actions.isElementDisplayed(recipesPage.recipeParameterMaxColumn));

        //click view
        Thread.sleep(2000);
        actions.clickElement(recipesPage.viewRecipeParametersBtn);

        //toggle Mahalanobis column
        actions.clickElement(recipesPage.toggleToMahalanobisViewRP);

        //scroll horizontally in table
        actions.scrollToElementHorizontally(recipesPage.tableHorizontalScrollBar, 1000);

        //test that Mahalanobis column appears
        Assert.assertTrue(actions.isElementDisplayed(recipesPage.recipeParameterMahalanobisColumn));

        //click view
        Thread.sleep(2000);
        actions.clickElement(recipesPage.viewRecipeParametersBtn);

        //toggle created by column
        actions.clickElement(recipesPage.toggleToCreatedByView);

        //scroll horizontally in table
        actions.scrollToElementHorizontally(recipesPage.tableHorizontalScrollBar, 1000);

        //test that created by column appears
        Assert.assertTrue(actions.isElementDisplayed(recipesPage.recipeParameterCreatedByColumn));
    }

    @Test(priority = 11)
    public void viewCalibrationFiles() throws InterruptedException {
        //recipesPage.refreshWindow();
        Thread.sleep(1000);
        actions.clickElement(recipesPage.firstRowActionsBtnInParameters);
        actions.clickElement(recipesPage.firstRowViewCalibrationActions);
        Assert.assertTrue(MainTestRunner.ChromeDriver.getCurrentUrl().contains("calibration-files"));
    }

    @Test(priority = 12)
    public void sortCalibrationFiles() throws InterruptedException {
        //navigate to recipes page
        homePage.clickRecipesSidebarBtn();

        //search for milk recipe
        Thread.sleep(2000);
        //send the recipe name to search field
        actions.enterText(recipesPage.searchField, "Milk");
        actions.clickElement(recipesPage.searchBtn);

        Thread.sleep(3000);

        //click actions button
        actions.clickElement(recipesPage.firstRowActions);

        //click view parameters
        actions.clickElement(recipesPage.RowViewParametersAction);

        //click first parameter action button
        Thread.sleep(3000);
        actions.scrollToElementHorizontally(recipesPage.tableHorizontalScrollBar, 1000);
        actions.clickElement(recipesPage.firstRowActionsBtnInParameters);

        //click view calibration files
        actions.clickElement(recipesPage.firstRowViewCalibrationActions);

        //click name column
        Thread.sleep(3000);
        actions.clickElement(recipesPage.calibrationFilesTableNameColumn);

        //click sort descending
        actions.clickElement(recipesPage.sortingCalibrationFilesNameDesc);
        Thread.sleep(2000);

        Assert.assertTrue(actions.getText(recipesPage.firstCalibrationFileName).compareTo(actions.getText(recipesPage.secondCalibrationFileName)) >= 0);

        //click name column
        actions.clickElement(recipesPage.calibrationFilesTableNameColumn);

        //click sort ascending
        actions.clickElement(recipesPage.sortingCalibrationFilesNameAsc);
        Thread.sleep(2000);

        Assert.assertTrue(actions.getText(recipesPage.firstCalibrationFileName).compareTo(actions.getText(recipesPage.secondCalibrationFileName)) <= 0);

        //clear ascending name sorting
        //click name column
        actions.clickElement(recipesPage.calibrationFilesTableNameColumn);

        //click sort ascending
        actions.clickElement(recipesPage.sortingCalibrationFilesNameAsc);

        //click created at column
        actions.clickElement(recipesPage.createdAtColumnHeader);

        //click sort ascending
        actions.clickElement(recipesPage.calibrationCreatedAtAsc);

        //test sorting
        Thread.sleep(2000);
        Date first = new Date(actions.getText(recipesPage.firstCalibrationFileCreatedAt));
        Date second = new Date(actions.getText(recipesPage.secondCalibrationFileCreatedAt));

        Assert.assertTrue(first.compareTo(second) <= 0);

        //click created at column
        actions.clickElement(recipesPage.createdAtColumnHeader);

        //click sort descending
        actions.clickElement(recipesPage.calibrationCreatedAtDesc);

        //test sorting
        Thread.sleep(2000);
        first = new Date(actions.getText(recipesPage.firstCalibrationFileCreatedAt));
        second = new Date(actions.getText(recipesPage.secondCalibrationFileCreatedAt));

        Assert.assertTrue(first.compareTo(second) >= 0);


        //click deployed at column
        actions.clickElement(recipesPage.deplyedAtCalibrationColumn);

        //sort ascending
        actions.clickElement(recipesPage.calibrationSortDeployedAtAsc);

        Thread.sleep(2000);
        first = new Date(actions.getText(recipesPage.firstCalibrationFileDeployedAt));
        second = new Date(actions.getText(recipesPage.secondCalibrationFileDeployedAt));

        Assert.assertTrue(first.compareTo(second) <= 0);
        
        //click deployed at column
        actions.clickElement(recipesPage.deplyedAtCalibrationColumn);

        //sort descending
        actions.clickElement(recipesPage.calibrationSortDeployedAtDesc);

        Thread.sleep(2000);
        first = new Date(actions.getText(recipesPage.firstCalibrationFileDeployedAt));
        second = new Date(actions.getText(recipesPage.secondCalibrationFileDeployedAt));
        System.out.println(first.compareTo(second));
        Assert.assertTrue(first.compareTo(second) >= 0);
        

    }

    @Test(priority = 13)
    public void deployCalibrationFile() throws InterruptedException {
        //expand first calibration file
        actions.clickElement(recipesPage.firstCalibrationExpandBtn);

        //click action button for second version
        actions.clickElement(recipesPage.secondCalibrationFileVersionActionBtn);

        //click deploy option
        actions.clickElement(recipesPage.deployOptionAction);

        Assert.assertEquals(actions.getText(recipesPage.deployCalibrationFilePopupHeader),"Deploy Calibration Files");

        //click cancel
        actions.clickElement(recipesPage.deployCalibrationFilePopupCancelBtn);
    }

    @Test(priority = 13)
    public void verifyBreadCrumbsText() throws InterruptedException {
        System.out.println(actions.getText(recipesPage.navBarBreadCrumbs));
        Thread.sleep(2000);
        Assert.assertTrue(actions.getText(recipesPage.navBarBreadCrumbs).contains("Recipes"));
        Assert.assertTrue(actions.getText(recipesPage.navBarBreadCrumbs).contains("Milk"));
        Assert.assertTrue(actions.getText(recipesPage.navBarBreadCrumbs).contains("Fat"));
    }

    @Test(priority = 13)
    public void verifyTsvTableBtns(){
        //fetch all children of tsv table buttons (view and refresh only)
       List<WebElement> tsvTableBtns= recipesPage.tsvTableButtons.findElements(By.xpath("./child::*"));
       Assert.assertEquals(tsvTableBtns.size(),2);

    }

    @Test(priority = 14)
    public void verifyNumberOfRecordsInTsvFile(){
        //expand first tsv file
        actions.clickElement(recipesPage.expandFirstRowTsvTable);

        //scroll down
        actions.scrollToElement(recipesPage.expandFirstRowTsvTable);

        //fetch records fo tsv file
        List<WebElement> tsvTableRecords= recipesPage.tsvTableRecords.findElements(By.xpath("./child::*"));

        //test that records are not more than 10
        System.out.println(tsvTableRecords.size());
        Assert.assertTrue(tsvTableRecords.size()<=10);
    }

    @Test(priority = 15)
    public void verifyRollbackAsPartnerAdmin() throws InterruptedException{
        //logout from support and login as Partner Admin
        homePage.clickProfileIconBtn();
        homePage.clickSignoutBtn();

        Helpers.loginWithValidUser( (ChromeDriver) MainTestRunner.ChromeDriver,Credentials.partnerAdminUsername,Credentials.partnerAdminPassword);

        //navigate to recipes page
        homePage.clickRecipesSidebarBtn();

        //search for milk recipe
        Thread.sleep(2000);
        //send the recipe name to search field
        actions.enterText(recipesPage.searchField, "Milk");
        actions.clickElement(recipesPage.searchBtn);

        Thread.sleep(3000);

        //click actions button
        actions.clickElement(recipesPage.firstRowActions);

        //click view parameters
        actions.clickElement(recipesPage.RowViewParametersAction);

        //click first parameter action button
        Thread.sleep(3000);
        actions.scrollToElementHorizontally(recipesPage.tableHorizontalScrollBar, 1000);
        actions.clickElement(recipesPage.firstRowActionsBtnInParameters);

        //click view calibration files
        actions.clickElement(recipesPage.firstRowViewCalibrationActions);

        //expand first calibration file
        actions.clickElement(recipesPage.firstCalibrationExpandBtn);

        //click action button for second version
        actions.clickElement(recipesPage.secondCalibrationFileVersionActionBtn);

        //click deploy option
        actions.clickElement(recipesPage.deployOptionAction);

        Assert.assertEquals(actions.getText(recipesPage.deployCalibrationFilePopupHeader),"Deploy Calibration Files");

        //click cancel
        actions.clickElement(recipesPage.deployCalibrationFilePopupCancelBtn);
    }

    @Test(priority = 15)
    public void verifyRollbackAsAdmin() throws InterruptedException{
        //scroll back up
        actions.scrollToElement(homePage.profileIconBtn);

        //logout from Partner Admin and login as Partner Admin
        homePage.clickProfileIconBtn();
        homePage.clickSignoutBtn();

        Helpers.loginWithValidUser( (ChromeDriver) MainTestRunner.ChromeDriver,Credentials.adminUsername,Credentials.adminPassword);

        //navigate to recipes page
        homePage.clickRecipesSidebarBtn();

        //search for milk recipe
        Thread.sleep(2000);
        //send the recipe name to search field
        actions.enterText(recipesPage.searchField, "A");
        actions.clickElement(recipesPage.searchBtn);

        Thread.sleep(3000);

        //click actions button
        actions.clickElement(recipesPage.firstRowActions);

        //click view parameters
        actions.clickElement(recipesPage.RowViewParametersAction);

        //click first parameter action button
        Thread.sleep(3000);
        actions.scrollToElementHorizontally(recipesPage.tableHorizontalScrollBar, 1000);
        actions.clickElement(recipesPage.firstRowActionsBtnInParameters);

        //click view calibration files
        actions.clickElement(recipesPage.firstRowViewCalibrationActions);

        //expand first calibration file
        actions.clickElement(recipesPage.firstCalibrationExpandBtn);

        //click action button for second version
        actions.clickElement(recipesPage.thirdCalibrationFileVersionActionBtn);

        //click deploy option
        actions.clickElement(recipesPage.deployOptionAction);

        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(recipesPage.deployCalibrationFilePopupHeader),"Deploy Calibration Files");

        //click cancel
        actions.clickElement(recipesPage.deployCalibrationFilePopupCancelBtn);

        //click no
        actions.clickElement(recipesPage.deployCalibrationFilePopupCancelAnotherBtn);
    }

    @Test(priority = 1)
    public void verifyPagingFunctionality() throws InterruptedException{

        //navigate to recipes page
        homePage.clickRecipesSidebarBtn();
        Thread.sleep(2000);

        //fetch name of first recipe
        String firstRecipe=actions.getText(recipesPage.firstRowName);

        //click next page in table
        actions.clickElement(recipesPage.nextPageTablePagination);

        //test that first row recipe changed
        Thread.sleep(2000);
        Assert.assertNotEquals(actions.getText(recipesPage.firstRowName),firstRecipe);

        //navigate to previous page again
        actions.clickElement(recipesPage.previousPageTablePagination);
    }



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




//
//@AfterClass
//    public void closeBrowser(){
//    MainTestRunner.ChromeDriver.quit();
//}
//
//}