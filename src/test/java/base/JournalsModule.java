package base;

import data.Credentials;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.*;
import utils.EnvironmentSelector;
import utils.Helpers;

import java.awt.*;


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
        actions.enterText(journalsPage.searchField,"Milk");

        //click search button
        actions.clickElement(journalsPage.submitSearchBtn);

        Thread.sleep(3000);
        //test that data searched for appears
        Assert.assertEquals(actions.getText(journalsPage.firstRecipeName),"Milk");

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
        actions.enterText(journalsPage.nameFilterTextField,"Milk");

        //click apply
        actions.clickElement(journalsPage.applyFilterBtn);

        //test that results appear
        Thread.sleep(4000);
        Assert.assertEquals(actions.getText(journalsPage.firstRecipeName),"Milk");

        //click filter
        actions.clickElement(journalsPage.filterBtn);

        //click clear
        actions.clickElement(journalsPage.clearFilterBtn);

        //click filter
        actions.clickElement(journalsPage.filterBtn);

        //send text to filter name
        actions.enterText(journalsPage.nameFilterTextField,"None");

        //click apply
        actions.clickElement(journalsPage.applyFilterBtn);

        //test that no results appear
        Thread.sleep(4000);
        Assert.assertFalse(actions.isElementDisplayed(journalsPage.firstRecipeName));
    }

    @Test(priority = 1)
    public void filterByAffiliate() throws InterruptedException {
        //navigate to journals
        Thread.sleep(4000);
        actions.clickElement(homePage.journalsSidebarBtn);

        //click filter button
        actions.clickElement(journalsPage.filterBtn);

        //choose dropdown
        Thread.sleep(1500);
        actions.chooseFromDropDown(journalsPage.affiliateFilterDropDown,"Sub2");

        //click apply
        actions.clickElement(journalsPage.applyFilterBtn);

        Thread.sleep(3000);

        Assert.assertEquals(actions.getText(journalsPage.firstJournalAffiliate),"Sub2");
    }

    @Test(priority = 3)
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

    @Test(priority = 4)
    public void exportRecipeSamples() throws InterruptedException {

        Thread.sleep(2000);
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
        actions.enterText(journalsPage.nameFilterTextField,"Milk");

        //click apply filter
        actions.clickElement(journalsPage.applyFilterBtn);

        //wait for results and expand them
        Thread.sleep(3000);
        actions.clickElement(journalsPage.expandFirstRecipeBtnSupport);

        //choose first instrument
        actions.clickElement(journalsPage.firstInstrument);

        //test that the next button is enables
        Assert.assertTrue(journalsPage.nextBtn.isEnabled());

        //click next
        actions.clickElement(journalsPage.nextBtn);

        Assert.assertEquals(actions.getCurrentUrl(), EnvironmentSelector.journalsUrl);

        //wait for data
        Thread.sleep(2000);

        //choose first sample
        actions.clickElement(journalsListPage.firstSampleCheckBox);

        //click export
        actions.clickElement(journalsListPage.exportBtn);

        //wait for file to be downloaded
        Thread.sleep(6000);

        System.out.println(filesNum);
        int newFilesNum=Helpers.getNumberOfFiles(MainTestRunner.downloadDir);

        //test that file is downloaded
        Assert.assertTrue(filesNum<newFilesNum);
    }

    @Ignore
    @Test(priority = 6)
    public void validSampleNameFilter() throws InterruptedException {

        //click filter button
        actions.clickElement(journalsListPage.editFiltersBtn);


        //clear sample filter name
        actions.clearText(journalsListPage.sampleNameFilterText);

        //insert invalid sample name
        actions.enterText(journalsListPage.sampleNameFilterText,"2024");

        //click save
        actions.clickElement(journalsListPage.saveFilterBtn);


        //test that sample appears
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(journalsListPage.firstSampleName),"2024-08-01 18:14:37 B15FG114");
    }

    @Test(priority = 6)
    public void validRecipeNameFilter() throws InterruptedException {
        //click filter button
        actions.clickElement(journalsListPage.editFiltersBtn);

        //insert invalid sample name
        actions.chooseFromDropDown(journalsListPage.recipeFilterText,"Wheat");

        //click save
        actions.clickElement(journalsListPage.saveFilterBtn);

        //test that no sample appears
        Thread.sleep(2000);
        Assert.assertFalse(actions.isElementDisplayed(journalsListPage.firstSampleRecipeName));

        //click filter button
        actions.clickElement(journalsListPage.editFiltersBtn);

        //insert invalid sample name
        actions.chooseFromDropDown(journalsListPage.recipeFilterText,"TestTsv");

        //click save
        actions.clickElement(journalsListPage.saveFilterBtn);

        //test that sample appears
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(journalsListPage.firstSampleRecipeName),"TestTsv");

        //return to journals back
        MainTestRunner.ChromeDriver.navigate().back();

        //wait for results and expand them
        Thread.sleep(2000);
        actions.clickElement(journalsPage.expandFirstRecipeBtnSupport);

        //choose first instrument
        Thread.sleep(1000);
        actions.clickElement(journalsPage.firstInstrument);

        //test that the next button is enabled
        Assert.assertTrue(journalsPage.nextBtn.isEnabled());

        //click next
        actions.clickElement(journalsPage.nextBtn);

        //click filter button
        Thread.sleep(2000);
        actions.clickElement(journalsListPage.editFiltersBtn);

        //change recipe name to "A"
        Thread.sleep(2000);

        //insert invalid sample name
        actions.chooseFromDropDown(journalsListPage.instrumentSNRFilterText,"B15FG114");

        //click save filter
        actions.clickElement(journalsListPage.saveFilterBtn);
    }

    @Test(priority = 5)
    public void validInstrumentFilter() throws InterruptedException {
        //click filter button
        Thread.sleep(2000);
        actions.clickElement(journalsListPage.editFiltersBtn);

        System.out.println(actions.getText(journalsListPage.journalsFilterDropdown));

        //change recipe name to "A"
        Thread.sleep(2000);
        actions.chooseFromDropDown(journalsListPage.recipeFilterText,"Test");

        //insert invalid sample name
        actions.chooseFromDropDown(journalsListPage.instrumentSNRFilterText,"B15FG114");

        //click save
        actions.clickElement(journalsListPage.saveFilterBtn);

        Thread.sleep(2000);
        //test that sample appears
        Assert.assertEquals(actions.getText(journalsListPage.firstSampleInstrument),"ProcessAnalyzer");
    }

    @Test(priority = 7)
    public void viewingOptions()throws InterruptedException{
        //test scrolling horizontal
        actions.scrollToElementHorizontally(journalsListPage.tableHorizontalScrollBar,500);

        //click view button
        actions.clickElement(journalsListPage.viewBtn);

        //toggle metadata
        actions.clickElement(journalsListPage.toggleMetadataBtn);

        //test that metadata is not visible
        Assert.assertFalse(actions.getText(journalsListPage.journalsListTableHeader).contains("Metadata"));

        //click view button
        actions.clickElement(journalsListPage.viewBtn);

        //toggle values
        actions.clickElement(journalsListPage.toggleValuesBtn);

        //test that values is not visible
        Assert.assertFalse(actions.getText(journalsListPage.journalsListTableHeader).contains("Values"));

        //click view button
        actions.clickElement(journalsListPage.viewBtn);

        //toggle spectral data
        actions.clickElement(journalsListPage.toggleSpectraBtn);

        //test that spectral data is not visible
        Assert.assertFalse(actions.getText(journalsListPage.journalsListTableHeader).contains("Spectral Data"));

    }

    @Test(priority = 8)
    public void viewSampleDetails() throws InterruptedException{
        //click on first sample name
        actions.clickElement(journalsListPage.firstSampleName);
        String sampleName=actions.getText(journalsListPage.firstSampleName);

        //test that sample name in details is the same
        Assert.assertTrue(actions.getText(journalsListPage.sampleNameDetails).contains(sampleName));

        //test that all necessary fields appear
        Assert.assertEquals(actions.getText(journalsListPage.journalDetailsHeader),"Journal details");

        Assert.assertTrue(actions.getText(journalsListPage.sampleSettingsDetails).contains("Created By"));
        Assert.assertTrue(actions.getText(journalsListPage.sampleSettingsDetails).contains("Captured At"));
        Assert.assertTrue(actions.getText(journalsListPage.sampleSettingsDetails).contains("Instruments SNR"));
        Assert.assertTrue(actions.getText(journalsListPage.sampleSettingsDetails).contains("Instrument Type"));
        Assert.assertTrue(actions.getText(journalsListPage.sampleSettingsDetails).contains("Recipe Name"));
        Assert.assertTrue(actions.getText(journalsListPage.sampleSettingsDetails).contains("Points"));

        //test that it contains parameters' names
        Assert.assertTrue(actions.getText(journalsListPage.sampleSettingsDetails).contains("Fat"));
        Assert.assertTrue(actions.getText(journalsListPage.sampleSettingsDetails).contains("Lactose"));
        Assert.assertTrue(actions.getText(journalsListPage.sampleSettingsDetails).contains("Test1"));
        Assert.assertTrue(actions.getText(journalsListPage.sampleSettingsDetails).contains("Protein"));

        //click edit ref values button
        actions.clickElement(journalsListPage.journalDetailsEditRefBtn);

        //test that edit references pop up appears
        Assert.assertEquals(actions.getText(journalsListPage.journalDetailsEditRefsTitle),"Edit Reference Values");

        int randomNum= (int) (Math.random()*20)+1;

        //change first parameter ref value
        actions.clearText(journalsListPage.journalDetailsFirstElementRefValueEdit);
        actions.enterText(journalsListPage.journalDetailsFirstElementRefValueEdit,randomNum+"");

        //click submit
        actions.clickElement(journalsListPage.editRefValuesSubmitBtn);
        Thread.sleep(2000);

        //test that value changed
        int newNum= Integer.parseInt(actions.getText(journalsListPage.journalDetailsFirstElementRefValue));
        Assert.assertEquals(newNum,randomNum);

        System.out.println(actions.getText(journalsListPage.sampleSettingsDetails));

        Assert.assertTrue(actions.getText(journalsListPage.sampleSettingsDetails).contains("Edit"));
        Assert.assertTrue(actions.getText(journalsListPage.sampleSettingsDetails).contains("Prediction/Reference"));
        Assert.assertTrue(actions.getText(journalsListPage.sampleSettingsDetails).contains("Parameter Name"));
        Assert.assertTrue(actions.getText(journalsListPage.sampleSettingsDetails).contains("Prediction Value"));
        Assert.assertTrue(actions.getText(journalsListPage.sampleSettingsDetails).contains("Reference Value"));
        Assert.assertTrue(actions.getText(journalsListPage.sampleSettingsDetails).contains("Data"));
        Assert.assertTrue(actions.getText(journalsListPage.sampleSettingsDetails).contains("History"));
        Assert.assertTrue(actions.getText(journalsListPage.sampleSettingsDetails).contains("Last modified at"));
        Assert.assertFalse(actions.getText(journalsListPage.sampleSettingsDetails).contains("Delete"));

        //close the pop-up
        actions.clickElement(journalsListPage.closeJournalDetailsDialog);

        //test that pop-up is closed
        Assert.assertFalse(actions.isElementDisplayed(journalsListPage.journalDetailsHeader));
    }
    @Ignore
    @Test(priority = 8)
    public void exportSampleDetails() throws InterruptedException{
        int filesNum=Helpers.getNumberOfFiles(MainTestRunner.downloadDir);

        //check on first sample name checkbox
        actions.clickElement(journalsListPage.firstSampleCheckBox);

        //click spectra plot button
        actions.clickElement(journalsListPage.journalDetailsSpectraPlotBtn);

        //click export spectra options
        actions.clickElement(journalsListPage.exportSpectraOptions);

        //click export as PNG
        actions.clickElement(journalsListPage.exportSpectrumPNG);

        //click export spectra options
        actions.clickElement(journalsListPage.exportSpectraOptions);

        //click export as PNG
        actions.clickElement(journalsListPage.exportSpectrumPDF);

        actions.clickElement(journalsListPage.closeSpectraPlotDialog);

        Thread.sleep(2000);

        int newFilesNum=Helpers.getNumberOfFiles(MainTestRunner.downloadDir);

        Assert.assertTrue(filesNum+2==newFilesNum);
    }

    @Test(priority = 9)
    public void manageReferenceValues() throws InterruptedException{
        //get length of downloads directory
        int filesNum=Helpers.getNumberOfFiles(MainTestRunner.downloadDir);

        //test that manageReference value is visible
        Assert.assertTrue(actions.isElementDisplayed(journalsListPage.manageRefValuesBtn));

        //test that export & import are accessible
        actions.clickElement(journalsListPage.manageRefValuesBtn);

        //test that export & import buttons are displayed
        Assert.assertTrue(actions.isElementDisplayed(journalsListPage.exportTemplateBtn));
        Assert.assertTrue(actions.isElementDisplayed(journalsListPage.exportRefValuesBtn));
        Assert.assertTrue(actions.isElementDisplayed(journalsListPage.importRefValuesBtn));

        //click export button
        actions.clickElement(journalsListPage.exportRefValuesBtn);

        Thread.sleep(7000);

        //test that file is downloaded
        int newFilesNum=Helpers.getNumberOfFiles(MainTestRunner.downloadDir);

        Assert.assertTrue(filesNum+1==newFilesNum);

        //click manage reference values btn
        actions.clickElement(journalsListPage.manageRefValuesBtn);

        //click import references option
        actions.clickElement(journalsListPage.importRefValuesBtn);

        try {
            actions.uploadFileWithRobot("src/main/resources/import_ref_values.xlsx" +
                    "");
        } catch (AWTException e) {
            System.out.println("Error");
        }

        Thread.sleep(6000);
        actions.refreshWindow();

        //expand first sample details
        actions.clickElement(journalsListPage.firstSampleName);

        String[] newRefValues=actions.getText(journalsListPage.sampleSettingsDetails).split("--");
        System.out.println("LEN: "+newRefValues.length);

        for (int i=1;i<newRefValues.length;i++){
            System.out.println(newRefValues[i]+"\n----------\n");
            Assert.assertTrue(newRefValues[i].contains("74"));
        }

        //close dialog
        actions.clickElement(journalsListPage.closeJournalDetailsDialog);

    }

    @Test(priority = 10)
    public void plotSpectra() throws InterruptedException{

        //test by default that plot spectra button is by default disabled
        actions.scrollToElement(journalsListPage.journalDetailsSpectraPlotBtn);
        Assert.assertFalse(actions.isElementEnabled(journalsListPage.journalDetailsSpectraPlotBtn));

        //check first two samples
        actions.clickElement(journalsListPage.dataSampleNameFirstCheckbox);
        actions.clickElement(journalsListPage.dataSampleNameSecondCheckbox);

        //scroll to plot spectra button
        actions.clickElement(journalsListPage.exportSpectraOptions);

        //test that spectra button is enabled
        Assert.assertTrue(actions.isElementEnabled(journalsListPage.journalDetailsSpectraPlotBtn));

        //test that the button reflects the selected samples
        System.out.println(actions.getText(journalsListPage.journalDetailsSpectraPlotBtn));
        Assert.assertTrue(actions.getText(journalsListPage.journalDetailsSpectraPlotBtn).contains("2"));

        //test that cancel selection is enabled
        Assert.assertTrue(actions.isElementEnabled(journalsListPage.journalDetailsCancelSelectionBtn));

        //cancel selection of the first two checkboxes
        actions.clickElement(journalsListPage.journalDetailsCancelSelectionBtn);

        //test that the cancel selection button becomes disabled
        Assert.assertFalse(actions.isElementEnabled(journalsListPage.journalDetailsCancelSelectionBtn));

        //test the plot spectra is disabled
        Assert.assertFalse(actions.isElementEnabled(journalsListPage.journalDetailsSpectraPlotBtn));

        //select all samples
        Thread.sleep(2000);
        actions.clickElement(journalsListPage.journalListSelectAllCheckbox);

        //test that all samples are selected (1 is total of samples)
        System.out.println(actions.getText(journalsListPage.journalDetailsSpectraPlotBtn));
        Assert.assertTrue(actions.getText(journalsListPage.journalDetailsSpectraPlotBtn).contains("3"));

        //uncheck all samples
        actions.clickElement(journalsListPage.journalListSelectAllCheckbox);

        //test that all samples are unchecked
        Assert.assertFalse(actions.isElementEnabled(journalsListPage.journalDetailsSpectraPlotBtn));

    }

    @Test(priority = 11)
    public void checkJournals() throws InterruptedException{

        //select first sample
        actions.clickElement(journalsListPage.firstSampleCheckBox);
        String firstSampleName=actions.getText(journalsListPage.firstSampleName);

        //click manage journals
        actions.clickElement(journalsListPage.manageJournalsBtn);

        //test that both option mark as uncheck & mark as check are enabled
        Assert.assertTrue(actions.isElementEnabled(journalsListPage.markAsCheckedOption));
        Assert.assertTrue(actions.isElementEnabled(journalsListPage.markAsUncheckedOption));

        //test that both options show number of selected samples
        Assert.assertTrue(actions.getText(journalsListPage.markAsCheckedOption).contains("1"));
        Assert.assertTrue(actions.getText(journalsListPage.markAsUncheckedOption).contains("1"));

        //click mark as unchecked
        actions.clickElement(journalsListPage.markAsUncheckedOption);

        //test that sample no longer appears
        Thread.sleep(2000);
        Assert.assertNotEquals(actions.getText(journalsListPage.firstSampleName),firstSampleName);

       //refresh page
        actions.refreshWindow();
        Thread.sleep(3000);

        //click edit filters
        actions.clickElement(journalsListPage.editFiltersBtn);

        //change journal entries to "Unchecked Journal Entries"
        actions.chooseFromDropDown(journalsListPage.journalEntriesFilter,"All");

        //click save filter
        actions.clickElement(journalsListPage.saveFilterBtn);

        //test that sample appears
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(journalsListPage.firstSampleName),firstSampleName);

        //refresh page
        actions.refreshWindow();
        Thread.sleep(3000);

        //click edit filters
        actions.clickElement(journalsListPage.editFiltersBtn);

        //change journal entries to "Unchecked Journal Entries"
        actions.chooseFromDropDown(journalsListPage.journalEntriesFilter,"Unch");

        //click save filter
        actions.clickElement(journalsListPage.saveFilterBtn);

        //test that sample appears
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(journalsListPage.firstSampleName),firstSampleName);

        //select first sample
        actions.clickElement(journalsListPage.firstSampleCheckBox);

        //click manage journals
        actions.clickElement(journalsListPage.manageJournalsBtn);

        //click mark as checked
        actions.clickElement(journalsListPage.markAsCheckedOption);

        //test that sample no longer appears
        Thread.sleep(2000);
        Assert.assertNotEquals(actions.getText(journalsListPage.firstSampleName),firstSampleName);

        //scroll to edit filters button
        actions.scrollToElement(journalsListPage.editFiltersBtn);

        //refresh page
        actions.refreshWindow();
        Thread.sleep(3000);

        //click edit filters
        actions.clickElement(journalsListPage.editFiltersBtn);

        //change journal entries to "Unchecked Journal Entries"
        actions.chooseFromDropDown(journalsListPage.journalEntriesFilter,"Checked");

        //click save filter
        actions.clickElement(journalsListPage.saveFilterBtn);

        //test that sample appears
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(journalsListPage.firstSampleName),firstSampleName);
    }

    @Test(priority = 12)
    public void histogramTab() throws InterruptedException {
        //click on histogram button tab
        actions.clickElement(journalsListPage.journalListHistogramBtn);

        //test that first parameter histogram is visible
        System.out.println(actions.getText(journalsListPage.firstHistogram));
        Assert.assertTrue(actions.getText(journalsListPage.firstHistogram).contains("Protein Histogram"));

        actions.scrollToElement(journalsListPage.secondHistogram);

        //test that second parameter histogram is visible

        System.out.println(actions.getText(journalsListPage.secondHistogram));
        Assert.assertTrue(actions.getText(journalsListPage.secondHistogram).contains("Fat Histogram"));

        //refresh window
        actions.refreshWindow();
        Thread.sleep(2000);

    }

    @Test(priority = 13)
    public void residualPlotTab() throws InterruptedException {

        //click on first residual tab
        actions.clickElement(journalsListPage.journalListResidualPlotBtn);
        Thread.sleep(2000);
        //test that first parameter histogram is visible
        System.out.println(actions.getText(journalsListPage.firstResidualPlot));
        Assert.assertTrue(actions.getText(journalsListPage.firstResidualPlot).contains("Residuals Plot For Protein"));

        actions.scrollToElement(journalsListPage.secondResidualPlot);


        //test that second parameter histogram is visible
        System.out.println("----------\n"+actions.getText(journalsListPage.secondResidualPlot));
        Assert.assertTrue(actions.getText(journalsListPage.secondResidualPlot).contains("Residuals Plot For Fat"));

    }
    @Test(priority = 14)
    public void accessForPartnerAdmin() throws InterruptedException{
        //signout from user
        actions.clickElement(homePage.profileIconBtn);
        actions.clickElement(homePage.signoutBtn);

        ///login with super-admin account
        Helpers.loginWithValidUser((ChromeDriver) MainTestRunner.ChromeDriver, Credentials.partnerAdminUsername,Credentials.partnerAdminPassword);

        //navigate to journals
        actions.clickElement(homePage.journalsSidebarBtn);

        //click filter button
        actions.clickElement(journalsPage.filterBtn);
        
        //click filter by name
        actions.enterText(journalsPage.nameFilterTextField,"Milk");

        //click apply filter
        actions.clickElement(journalsPage.applyFilterBtn);

        //wait for results and expand them (expand button has different xpath in partneradmin)
        Thread.sleep(2000);
        actions.clickElement(journalsPage.firstRecipeExpandBtnPartnerAdmin);

        //choose first instrument
        actions.clickElement(journalsPage.firstInstrument);

        //click next
        actions.clickElement(journalsPage.nextBtn);

        //click on histogram button tab
        actions.clickElement(journalsListPage.journalListHistogramBtn);

        //test that first parameter histogram is visible
        Assert.assertTrue(actions.getText(journalsListPage.firstHistogram).contains("Fat Histogram")||actions.getText(journalsListPage.firstHistogram).contains("Test1 Histogram")||actions.getText(journalsListPage.firstHistogram).contains("Lactose Histogram")||actions.getText(journalsListPage.firstHistogram).contains("Protein Histogram")) ;

        actions.scrollToElement(journalsListPage.secondHistogram);

        //test that second parameter histogram is visible
        Assert.assertTrue(actions.getText(journalsListPage.secondHistogram).contains("Lactose Histogram") || actions.getText(journalsListPage.secondHistogram).contains("Fat Histogram") || actions.getText(journalsListPage.secondHistogram).contains("Test1 Histogram")||actions.getText(journalsListPage.secondHistogram).contains("Protein Histogram"));

        //refresh window
        actions.refreshWindow();
        Thread.sleep(2000);
        //navigate to data tab
        actions.clickElement(journalsListPage.journalListDataBtn);

        //click on first sample name
        actions.clickElement(journalsListPage.firstSampleName);

        //click edit ref values button
        actions.clickElement(journalsListPage.journalDetailsEditRefBtn);

        //test that edit references pop up appears
        Assert.assertEquals(actions.getText(journalsListPage.journalDetailsEditRefsTitle),"Edit Reference Values");

        int randomNum= (int) (Math.random()*20)+1;
        //change first parameter ref value
        actions.clearText(journalsListPage.journalDetailsFirstElementRefValueEdit);
        actions.enterText(journalsListPage.journalDetailsFirstElementRefValueEdit,randomNum+"");

        //click submit
        actions.clickElement(journalsListPage.editRefValuesSubmitBtn);
        Thread.sleep(2000);

        //test that value changed
        int newNum= Integer.parseInt(actions.getText(journalsListPage.journalDetailsFirstElementRefValue));
        Assert.assertEquals(newNum,randomNum);

        //close pop-up
        actions.clickElement(journalsListPage.closeJournalDetailsDialog);
    }

    @Test(priority = 14)
    public void accessForAdmin() throws InterruptedException{
        //signout from user
        actions.clickElement(homePage.profileIconBtn);
        actions.clickElement(homePage.signoutBtn);

        ///login with admin account
        Helpers.loginWithValidUser((ChromeDriver) MainTestRunner.ChromeDriver, Credentials.adminUsername,Credentials.adminPassword);

        //navigate to journals
        actions.clickElement(homePage.journalsSidebarBtn);

        //click filter button
        actions.clickElement(journalsPage.filterBtn);

        //click filter by name
        actions.enterText(journalsPage.nameFilterTextField,"Milk");

        //click apply filter
        actions.clickElement(journalsPage.applyFilterBtn);

        //wait for results and expand them
        Thread.sleep(2000);
        actions.clickElement(journalsPage.expandFirstRecipeBtnSupport);

        //choose first instrument
        actions.clickElement(journalsPage.firstInstrument);

        //click next
        actions.clickElement(journalsPage.nextBtn);

        //click on histogram button tab
        actions.clickElement(journalsListPage.journalListHistogramBtn);

        //test that first parameter histogram is visible
        Thread.sleep(2000);
        System.out.println(actions.getText(journalsListPage.firstHistogram));
        Assert.assertTrue(actions.getText(journalsListPage.firstHistogram).contains("Fat Histogram") || actions.getText(journalsListPage.firstHistogram).contains("Test1 Histogram")|| actions.getText(journalsListPage.firstHistogram).contains("Lactose Histogram"));

        actions.scrollToElement(journalsListPage.secondHistogram);
        System.out.println(actions.getText(journalsListPage.secondHistogram));

        //test that second parameter histogram is visible
        Assert.assertTrue(actions.getText(journalsListPage.secondHistogram).contains("Test1 Histogram") || actions.getText(journalsListPage.secondHistogram).contains("Fat Histogram")|| actions.getText(journalsListPage.secondHistogram).contains("Lactose Histogram"));

        //refresh window
        actions.refreshWindow();
        Thread.sleep(2000);
        //navigate to data tab
        actions.clickElement(journalsListPage.journalListDataBtn);

        //click on first sample name
        actions.clickElement(journalsListPage.firstSampleName);

        //click edit ref values button
        actions.clickElement(journalsListPage.journalDetailsEditRefBtn);

        //test that edit references pop up appears
        Assert.assertEquals(actions.getText(journalsListPage.journalDetailsEditRefsTitle),"Edit Reference Values");

        int randomNum= (int) (Math.random()*20)+1;
        //change first parameter ref value
        actions.clearText(journalsListPage.journalDetailsFirstElementRefValueEdit);
        actions.enterText(journalsListPage.journalDetailsFirstElementRefValueEdit,randomNum+"");

        //click submit
        actions.clickElement(journalsListPage.editRefValuesSubmitBtn);
        Thread.sleep(2000);

        //test that value changed
        int newNum= Integer.parseInt(actions.getText(journalsListPage.journalDetailsFirstElementRefValue));
        Assert.assertEquals(newNum,randomNum);

        //close pop-up
        actions.clickElement(journalsListPage.closeJournalDetailsDialog);
    }
}
