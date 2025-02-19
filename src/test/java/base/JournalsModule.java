package base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.*;
import utils.Helpers;


public class JournalsModule {
    HomePage homePage;
    JournalsPage journalsPage;
    ListJournalsPage journalsListPage;
    Actions actions;

    @BeforeClass
    public void initializeClasses(){
        homePage=new HomePage((ChromeDriver) MainTestRunner.ChromeDriver);
        journalsPage=new JournalsPage( MainTestRunner.ChromeDriver);
        journalsListPage=new ListJournalsPage(MainTestRunner.ChromeDriver);
        actions= new Actions((ChromeDriver) MainTestRunner.ChromeDriver,20);
    }

    @Test()
    public void searchForJournal() throws InterruptedException {

        //navigate to journals
        actions.clickElement(homePage.journalsSidebarBtn);

        //send value to search bar
        Thread.sleep(2000);
        actions.enterText(journalsPage.searchField,"Global");

        //click search button
        actions.clickElement(journalsPage.submitSearchBtn);

        Thread.sleep(3000);
        //test that data searched for appears
        Assert.assertEquals(actions.getText(journalsPage.firstRecipeName),"Global");

        //refresh window to clear results
        journalsPage.refreshWindow();

        Thread.sleep(8000);
    }

    @Test(priority = 1)
    public void filterByName() throws InterruptedException {
        
        //navigate to journals
        Thread.sleep(4000);
        actions.clickElement(homePage.journalsSidebarBtn);

        //click filter button
        actions.clickElement(journalsPage.filterBtn);

        //send text to filter name
        actions.enterText(journalsPage.nameFilterTextField,"Global");

        //click apply
        actions.clickElement(journalsPage.applyFilterBtn);
        
        //test that results appear
        Thread.sleep(4000);
        Assert.assertEquals(actions.getText(journalsPage.firstRecipeName),"Global");
        
        //todo:add negative scenario
    }

    @Test(priority = 2)
    public void toggleView() throws InterruptedException {
        //clear any preset filter
        
        //click filter
        actions.clickElement(journalsPage.filterBtn);;
        
        //click clear
        actions.clickElement(journalsPage.clearFilterBtn);

        //click apply filter
        actions.clickElement(journalsPage.applyFilterBtn);

        //click view button
        Thread.sleep(3000);
        actions.clickElement(journalsPage.viewBtn);

        //toggle affiliate column
        actions.clickElement(journalsPage.toggleAffiliateBtn);

        //test that affiliate column is visible
        Assert.assertFalse(actions.isElementDisplayed(journalsPage.affiliateNameColumn));

        //click view button
        Thread.sleep(3000);
        actions.clickElement(journalsPage.viewBtn);

        //toggle createdBy column
        actions.clickElement(journalsPage.toggleCreatedBy);

        //test that createdBy column is visible
        Assert.assertTrue(actions.isElementDisplayed(journalsPage.createdByColumn));

        //click view button
        Thread.sleep(3000);
        actions.clickElement(journalsPage.viewBtn);

        //toggle createdAt column
        actions.clickElement(journalsPage.toggleCreatedAt);

        //test that createdBy column is visible
        Assert.assertFalse(actions.isElementDisplayed(journalsPage.createdAtColumn));
    }

    @Test(priority = 3)
    public void exportRecipeSamples() throws InterruptedException {

        //get length of downloads directory
        int filesNum=Helpers.getNumberOfFiles(MainTestRunner.downloadDir);

        journalsListPage=new ListJournalsPage( MainTestRunner.ChromeDriver);

        //clear any preset filter
        //click filter
        actions.clickElement(journalsPage.filterBtn);;

        //click clear
        actions.clickElement(journalsPage.clearFilterBtn);

        //click filter
        actions.clickElement(journalsPage.filterBtn);;

        //click filter by name
        actions.enterText(journalsPage.nameFilterTextField,"Wheat");

        //click apply filter
        actions.clickElement(journalsPage.applyFilterBtn);

        //wait for results and expand them
        Thread.sleep(2000);
        actions.clickElement(journalsPage.expandFirstRecipeBtn);

        //choose first instrument
        actions.clickElement(journalsPage.firstInstrument);

        //click next
        actions.clickElement(journalsPage.nextBtn);

        //wait for data
        Thread.sleep(2000);

        //choose first sample
        journalsListPage.clickFirstScanCheckBox();
        actions.clickElement(journalsListPage.firstSampleCheckBox);
        
        //click export
        actions.clickElement(journalsListPage.exportBtn);

        //wait for file to be downloaded
        Thread.sleep(4000);

        System.out.println(filesNum);
        System.out.println(Helpers.getNumberOfFiles(MainTestRunner.downloadDir));

        //test that file is downloaded
        Assert.assertTrue(filesNum<Helpers.getNumberOfFiles(MainTestRunner.downloadDir));
    }

//    @Test(priority = 5)
//    public void invalidSampleNameFilter() throws InterruptedException {
//
//        //click filter button
//        Thread.sleep(2000);
//        actions.clickElement(journalsListPage.editFiltersBtn);
//
//        //clear sample name filter
//        journalsListPage.clearSampleNameFilterText();
//
//        //insert invalid sample name
//        journalsListPage.sendTextToSampleNameFilterText("Invalid Sample");
//
//        //click save
//        actions.clickElement(journalsListPage.saveFilterBtn);
//
//        //test that no samples appear
//        Assert.assertFalse(journalsListPage.isFirstSampleNameDisplayed());
//    }


    @Test(priority = 5)
    @Ignore
    public void validSampleNameFilter() throws InterruptedException {

        //click filter button
        actions.clickElement(journalsListPage.editFiltersBtn);
        

        //clear sample filter name
        journalsListPage.clearSampleNameFilterText();
        actions.clearText(journalsListPage.sampleNameFilterText);
        
        //insert invalid sample name
        journalsListPage.sendTextToSampleNameFilterText("2024");
        actions.enterText(journalsListPage.sampleNameFilterText,"2024");
        
        //click save
        actions.clickElement(journalsListPage.saveFilterBtn);
        

        //test that sample appears
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(journalsListPage.firstSampleName),"2024-08-01 18:14:37 B15FG114");
    }

    @Ignore
    @Test(priority = 5)
    public void validRecipeNameFilter() throws InterruptedException {
        //click filter button
        actions.clickElement(journalsListPage.editFiltersBtn);


        //insert invalid sample name
        journalsListPage.sendTextToRecipeFilterText("Global");
        actions.chooseFromDropDown(journalsListPage.recipeFilterText,"Global");

        //click save
        actions.clickElement(journalsListPage.saveFilterBtn);

        //test that sample appears
        Assert.assertEquals(journalsListPage.getFirstSampleRecipeName(),"GLOBAL");
    }

    @Test(priority = 4)
    public void validInstrumentFilter() throws InterruptedException {

        //click filter button
        Thread.sleep(2000);
        actions.clickElement(journalsListPage.editFiltersBtn);

        //clear sample filter name

        //change recipe name to "A"
        Thread.sleep(2000);
        journalsListPage.sendTextToRecipeFilterText("Test");


        //insert invalid sample name
        actions.chooseFromDropDown(journalsListPage.instrumentSNRFilterText,"B15FG114");


        //click save
        actions.clickElement(journalsListPage.saveFilterBtn);

        Thread.sleep(2000);
        //test that sample appears
        Assert.assertEquals(actions.getText(journalsListPage.firstSampleInstrument),"ProcessAnalyzer");
    }
}
