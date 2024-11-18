package base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.*;
import utils.Helpers;


public class JournalsModule {
    HomePage homePage;
    JournalsPage journalsPage;
    ListJournalsPage journalsListPage;


    @Test()
    @Ignore
    public void searchForJournal() throws InterruptedException {
        homePage=new HomePage((ChromeDriver) MainTestRunner.ChromeDriver);
        journalsPage=new JournalsPage((ChromeDriver) MainTestRunner.ChromeDriver);
        journalsListPage=new ListJournalsPage((ChromeDriver) MainTestRunner.ChromeDriver);

        //navigate to journals
        homePage.clickJournalsSidebarBtn();

        //send value to search bar
        Thread.sleep(2000);
        journalsPage.sendTextToSearchField("Global");

        //click search button
        journalsPage.clickSubmitSearchBtn();

        Thread.sleep(3000);
        //test that data searched for appears
        Assert.assertEquals(journalsPage.getFirstRecipeName(),"Global");

        //refresh window to clear results
        journalsPage.refreshWindow();

        Thread.sleep(8000);
    }

    @Test(priority = 1)
    public void filterByName() throws InterruptedException {
        homePage=new HomePage((ChromeDriver) MainTestRunner.ChromeDriver);
        journalsPage=new JournalsPage((ChromeDriver) MainTestRunner.ChromeDriver);
        journalsListPage=new ListJournalsPage((ChromeDriver) MainTestRunner.ChromeDriver);

        //navigate to journals
        Thread.sleep(4000);
        homePage.clickJournalsSidebarBtn();
        homePage.clickJournalsSidebarBtn();

        //click filter button
        journalsPage.clickFilterBtn();

        //send text to filter name
        journalsPage.sendTextToNameFilterTextField("Global");

        //click apply
        journalsPage.clickApplyFilterBtn();

        //test that results appear
        Thread.sleep(4000);
        Assert.assertEquals(journalsPage.getFirstRecipeName(),"Global");
    }

    @Test(priority = 2)
    public void toggleView() throws InterruptedException {
        //clear any preset filter

        //click filter
        journalsPage.clickFilterBtn();

        //click clear
        journalsPage.clickClearFilterBtn();

        //click apply filter
        journalsPage.clickApplyFilterBtn();

        //click view button
        Thread.sleep(3000);
        journalsPage.clickViewBtn();

        //toggle affiliate column
        journalsPage.clickToggleAffiliateBtn();

        //fetch second column title and test it is Created by
        Assert.assertEquals(journalsPage.getSecondColumnTitle(),"Created by");

        //click view button
        Thread.sleep(3000);
        journalsPage.clickViewBtn();

        //toggle created by column
        journalsPage.clickToggleCreatedBy();

        //fetch second column title and test it is Created at
        Assert.assertEquals(journalsPage.getSecondColumnTitle(),"Created at");

        //click view button
        Thread.sleep(3000);
        journalsPage.clickViewBtn();

        //toggle created by column
        journalsPage.clickToggleCreatedAt();

        //test that there is no second column
        Assert.assertFalse(journalsPage.isSecondColumnDisplayed());


    }

    @Test(priority = 3)
    public void exportRecipeSamples() throws InterruptedException {

        //get length of downloads directory
        int filesNum=Helpers.getNumberOfFiles(MainTestRunner.downloadDir);

        journalsListPage=new ListJournalsPage((ChromeDriver) MainTestRunner.ChromeDriver);

        //clear any preset filter
        //click filter
        journalsPage.clickFilterBtn();

        //click clear
        journalsPage.clickClearFilterBtn();

        //click apply filter
        journalsPage.clickApplyFilterBtn();

        //click filter
        journalsPage.clickFilterBtn();

        //click filter by name
        journalsPage.sendTextToNameFilterTextField("Global");

        //click apply filter
        journalsPage.clickApplyFilterBtn();

        //wait for results and expand them
        Thread.sleep(2000);
        journalsPage.clickExpandFirstRecipeBtn();

        //choose first instrument
        journalsPage.clickFirstInstrumentBtn();

        //click next
        journalsPage.clickNextBtn();

        //wait for data
        Thread.sleep(2000);

        //choose first sample
        journalsListPage.clickFirstScanCheckBox();


        //click export
        journalsListPage.clickExportBtn();

        //wait for file to be downloaded
        Thread.sleep(4000);

        System.out.println(filesNum);
        System.out.println(Helpers.getNumberOfFiles(MainTestRunner.downloadDir));

        //test that file is downloaded
        Assert.assertTrue(filesNum<Helpers.getNumberOfFiles(MainTestRunner.downloadDir));
    }

    @Test(priority = 5)
    public void invalidSampleNameFilter() throws InterruptedException {

        //click filter button
        Thread.sleep(2000);
        journalsListPage.clickEditFiltersBtn();

        //clear sample name filter
        journalsListPage.clearSampleNameFilterText();

        //insert invalid sample name
        journalsListPage.sendTextToSampleNameFilterText("Invalid Sample");

        //click save
        journalsListPage.clickSaveFilterBtn();

        //test that no samples appear
        Assert.assertFalse(journalsListPage.isFirstSampleNameDisplayed());
    }

    @Test(priority = 5)
    public void validSampleNameFilter() throws InterruptedException {

        //click filter button
        journalsListPage.clickEditFiltersBtn();

        //clear sample filter name
        journalsListPage.clearSampleNameFilterText();

        //insert invalid sample name
        journalsListPage.sendTextToSampleNameFilterText("2024");

        //click save
        journalsListPage.clickSaveFilterBtn();

        //test that sample appears
        Thread.sleep(2000);
        Assert.assertEquals(journalsListPage.getFirstSampleName(),"2024-08-01 18:14:37 B15FG114");
    }

    @Test(priority = 5)
    public void validRecipeNameFilter() throws InterruptedException {
        //click filter button
        journalsListPage.clickEditFiltersBtn();

        //clear sample filter name
        journalsListPage.clearSampleNameFilterText();

        //insert invalid sample name
        journalsListPage.sendTextToRecipeFilterText("Global");

        //click save
        journalsListPage.clickSaveFilterBtn();

        //test that sample appears
        Assert.assertEquals(journalsListPage.getFirstSampleRecipeName(),"GLOBAL");
    }

    @Test(priority = 4)
    public void validInstrumentFilter() throws InterruptedException {

        //click filter button
        Thread.sleep(2000);
        journalsListPage.clickEditFiltersBtn();

        //clear sample filter name

        //change recipe name to "A"
        Thread.sleep(2000);
        journalsListPage.sendTextToRecipeFilterText("A");
        journalsListPage.clearSampleNameFilterText();

        //insert invalid sample name
        journalsListPage.sendTextToInstrumentSNRFilterText("B15FG114");
        journalsListPage.clearSampleNameFilterText();

        //click save
        journalsListPage.clickSaveFilterBtn();

        Thread.sleep(2000);
        //test that sample appears
        Assert.assertEquals(journalsListPage.getFirstSampleInstrument(),"B15FG114");
    }
}
