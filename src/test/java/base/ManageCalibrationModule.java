package base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class ManageCalibrationModule {
    RecipePage recipePage;
    HomePage homePage;
    Actions actions;
    ManageCalibrationPage manageCalibrationPage;

    @BeforeClass
    public void initializeClasses(){
        recipePage= new RecipePage((ChromeDriver) MainTestRunner.ChromeDriver);
        homePage=new HomePage((ChromeDriver) MainTestRunner.ChromeDriver);
        manageCalibrationPage= new ManageCalibrationPage((ChromeDriver) MainTestRunner.ChromeDriver);
        actions= new Actions((ChromeDriver) MainTestRunner.ChromeDriver,20);
    }

    @Test
    public void isManageDeploymentBtnDisplayed() throws InterruptedException {
        //navigate to users pages
        actions.clickElement(homePage.recipesSidebarBtn);

        //test that manage calibration deployment button is visible
        Assert.assertTrue(actions.isElementDisplayed(recipePage.manageCalibrationBtn));

        //click manage calibration btn
        actions.clickElement(recipePage.manageCalibrationBtn);

        //test that user got redirected to manage calibration deployment page
        Thread.sleep(2000);
        Assert.assertEquals(actions.getCurrentUrl(),"https://lablake-dev.neospectra.cloud/fleet-management/recipe/manage-calibration-deployment");
    }

    @Test(priority = 1,dependsOnMethods = "isManageDeploymentBtnDisplayed")
    public void viewRecipes() throws InterruptedException {
        //test that recipes filter is visible
        actions.isElementDisplayed(manageCalibrationPage.chosenRecipesFromDropdown);

        //insert two recipes to filter with
        actions.chooseFromDropDown(manageCalibrationPage.recipeNameDropdown,"Milk");
        actions.chooseFromDropDown(manageCalibrationPage.recipeNameDropdown,"Acloned");

        //test that two recipes are filtered by
        Assert.assertTrue(actions.getText(manageCalibrationPage.chosenRecipesFromDropdown).contains("Acloned") && actions.getText(manageCalibrationPage.chosenRecipesFromDropdown).contains("Milk"));

        //click view recipes button
        actions.clickElement(manageCalibrationPage.viewRecipesBtn);

        //test that the recipe name is displayed
        Thread.sleep(3000);
        Assert.assertEquals(actions.getText(manageCalibrationPage.firstSelectedRecipeName),"Acloned");
        Assert.assertEquals(actions.getText(manageCalibrationPage.secondSelectedRecipeName),"Milk");

        //test that tooltip is visible
        Assert.assertTrue(actions.isElementDisplayed(manageCalibrationPage.latestTransferBtn));

        //test that transfer calibration data btn is displayed
        Assert.assertTrue(actions.isElementDisplayed(manageCalibrationPage.transferCalibrationBtn));

        //test that the latest calibration timestamp display
        Assert.assertTrue(actions.isElementDisplayed(manageCalibrationPage.firstSelectedRecipeFirstParameterCalibrationTimestamp));

        //test that grid is displayed
        Assert.assertTrue(actions.isElementDisplayed(manageCalibrationPage.firstSelectedRecipeGrid));
        Assert.assertTrue(actions.isElementDisplayed(manageCalibrationPage.secondSelectedRecipeGrid));

        //test that nested grid is expandable
        actions.clickElement(manageCalibrationPage.firstSelectedRecipeFirstParameterExpandBtn);

        Assert.assertTrue(actions.isElementDisplayed(manageCalibrationPage.firstSelectedRecipeFirstParameterNestedGrid));

    }

    @Test(priority = 2)
    public void transferCalibrationData() throws InterruptedException {
        //click transfer calibration data btn
        actions.clickElement(manageCalibrationPage.transferCalibrationBtn);

        //test that popup appears
        Assert.assertTrue(actions.isElementDisplayed(manageCalibrationPage.saveTransferBtn));

        //click save without inserting any data
        actions.clickElement(manageCalibrationPage.saveTransferBtn);

        //test that error messages appear under dropdown
        Assert.assertEquals(actions.getText(manageCalibrationPage.destinationSxSuiteErrorMsg),"Destination can not be empty!");
        Assert.assertEquals(actions.getText(manageCalibrationPage.sourceSxSuiteErrorMsg),"Source is required.");
        Assert.assertEquals(actions.getText(manageCalibrationPage.includedParameterErrorMsg),"Included parameters can not be empty!");

        //select source sx-suite
        actions.chooseFromDropDown(manageCalibrationPage.sourceSxSuiteDropdown,"sub1");

        //select destination sx-suite
        actions.chooseFromDropDown(manageCalibrationPage.destinationSxSuiteDropdown,"sub2");

        //select included parameters
        actions.chooseFromDropDown(manageCalibrationPage.includedParameterDropdown,"Moisture");

        //click cancel
        actions.clickElement(manageCalibrationPage.cancelTransferBtn);

        //verify that pop-up disappears
        Assert.assertTrue(actions.isElementDisplayed(manageCalibrationPage.firstSelectedRecipeGrid));
    }

    @Test(priority = 3)
    public void verifyManageCalibrationDeploymentNestedGrid() throws InterruptedException {
        //navigate back to recipes main page
        actions.clickElement(homePage.recipesSidebarBtn);

        //click on manage calibration deployment
        actions.clickElement(recipePage.manageCalibrationBtn);

        //insert recipe name in dropdown
        actions.chooseFromDropDown(manageCalibrationPage.recipeNameDropdown,"Milk" );

        //click view recipes
        actions.clickElement(manageCalibrationPage.viewRecipesBtn);

        //expand first parameter
        actions.clickElement(manageCalibrationPage.firstParameterExpandGridManageDeployment);

        //test the content of the nested grid
        Thread.sleep(2000);
        Assert.assertTrue(actions.getText(manageCalibrationPage.firstSelectedRecipeFirstParameterNestedGrid).contains("Range"));
        Assert.assertTrue(actions.getText(manageCalibrationPage.firstSelectedRecipeFirstParameterNestedGrid).contains("Samples"));
        Assert.assertTrue(actions.getText(manageCalibrationPage.firstSelectedRecipeFirstParameterNestedGrid).contains("SEC"));
        Assert.assertTrue(actions.getText(manageCalibrationPage.firstSelectedRecipeFirstParameterNestedGrid).contains("SECV"));
        Assert.assertTrue(actions.getText(manageCalibrationPage.firstSelectedRecipeFirstParameterNestedGrid).contains("R2"));
        Assert.assertTrue(actions.getText(manageCalibrationPage.firstSelectedRecipeFirstParameterNestedGrid).contains("Method"));
        Assert.assertTrue(actions.getText(manageCalibrationPage.firstSelectedRecipeFirstParameterNestedGrid).contains("Treat"));
        Assert.assertTrue(actions.getText(manageCalibrationPage.firstSelectedRecipeFirstParameterNestedGrid).contains("Factors"));
        Assert.assertTrue(actions.getText(manageCalibrationPage.firstSelectedRecipeFirstParameterNestedGrid).contains("SEP"));
        Assert.assertTrue(actions.getText(manageCalibrationPage.firstSelectedRecipeFirstParameterNestedGrid).contains("ISO12099"));
    }
}
