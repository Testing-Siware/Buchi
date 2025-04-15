package base;

import data.Credentials;
import org.checkerframework.checker.units.qual.Temperature;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;
import pages.Actions;
import pages.AlertsPage;
import pages.HomePage;
import pages.InstrumentsPage;
import utils.Helpers;

import java.util.Date;

public class InstrumentsModule {
    InstrumentsPage instrumentsPage;
    HomePage homePage;
    Actions actions;
    
    @Test(priority = 0)
    public void intializeClasses() {
        homePage= new HomePage((ChromeDriver) MainTestRunner.ChromeDriver);
        instrumentsPage= new InstrumentsPage((ChromeDriver) MainTestRunner.ChromeDriver); 
        actions = new Actions((ChromeDriver) MainTestRunner.ChromeDriver,20);
    }

    @Test(priority = 1)
    public void instrumentSearch() throws InterruptedException {
        instrumentsPage = new InstrumentsPage((ChromeDriver) MainTestRunner.ChromeDriver);
        homePage = new HomePage((ChromeDriver) MainTestRunner.ChromeDriver);

        //navigate to instruments page
        homePage.clickInstrumentsDashboardBtn();

        //send text to search field
        Thread.sleep(2000);
        actions.enterText(instrumentsPage.searchField,"416FG106");
        actions.clickElement(instrumentsPage.searchBtn);

        //test that results appear
        Thread.sleep(2000);
        
        Assert.assertEquals(actions.getText(instrumentsPage.firstRowName), "416FG106");

        instrumentsPage.refreshWindow();
        Thread.sleep(8000);
    }

    @Test(priority = 2)
    public void filterByInstrumentName() throws InterruptedException {
        //clear any preset filter

        //click filter
        actions.clickElement(instrumentsPage.filterBtn);
        

        //click clear
        Thread.sleep(2000);
        actions.clickElement(instrumentsPage.clearFiltersBtn);
        
        //click filter
        actions.clickElement(instrumentsPage.filterBtn);

        //insert instrument name
        
        actions.enterText(instrumentsPage.filterNameTextField,"416FG106");
        
        //click apply
        actions.clickElement(instrumentsPage.applyFilterBtn);

        //test that filtered instrument appears
        Thread.sleep(3000);
        Assert.assertEquals(actions.getText(instrumentsPage.firstRowName), "416FG106");
    }

    @Test(priority = 2)
    public void filterBySerialNumber() throws InterruptedException {
        //clear any preset filter

        //click filter
        actions.clickElement(instrumentsPage.filterBtn);

        //click clear
        actions.clickElement(instrumentsPage.clearFiltersBtn);
        

        Thread.sleep(2000);
        String firstSerialNumber = actions.getText(instrumentsPage.firstRowSerialNumber);
        

        //click filter
        actions.clickElement(instrumentsPage.filterBtn);


        //insert serial number
        actions.enterText(instrumentsPage.filterSerialNumber,firstSerialNumber);

        //click apply
        actions.clickElement(instrumentsPage.applyFilterBtn);

        //test that filtered instrument appears
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(instrumentsPage.firstRowSerialNumber), firstSerialNumber);
    }

    @Ignore
    @Test(priority = 2)
    public void filterByInstrumentType() throws InterruptedException {
        //clear any preset filter

        //click filter
        Thread.sleep(2000);
        actions.clickElement(instrumentsPage.filterBtn);

        //click clear
        actions.clickElement(instrumentsPage.clearFiltersBtn);
        

        //click filter
        actions.clickElement(instrumentsPage.filterBtn);

        //insert instrument name
        actions.enterText(instrumentsPage.filterTypeField,"Buchi");

        //click apply
        actions.clickElement(instrumentsPage.applyFilterBtn);

        //test that filtered instrument appears
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(instrumentsPage.firstRowType), "B15FG115");
    }

    @Test(priority = 2)
    @Ignore
    public void filterByModel() throws InterruptedException {
        //clear any preset filter

        //click filter
        actions.clickElement(instrumentsPage.filterBtn);

        //click clear
        actions.clickElement(instrumentsPage.clearFiltersBtn);
        

        Thread.sleep(2000);
        String firstModel= actions.getText(instrumentsPage.firstRowModel);

        //click filter
        actions.clickElement(instrumentsPage.filterBtn);

        //insert model
        actions.enterText(instrumentsPage.filterModelTextField,firstModel);

        //click apply
        actions.clickElement(instrumentsPage.applyFilterBtn);

        //test that instrument appears
        Thread.sleep(3000);
        Assert.assertEquals(actions.getText(instrumentsPage.firstRowModel), firstModel);
    }

    @Test(priority = 3)
    public void toggleColumns() throws InterruptedException {

        //test that created at column is not visible
        Assert.assertFalse(actions.isElementDisplayed(instrumentsPage.createdAtColumnHeader));

        //test that last updated at column is not visible
        Assert.assertFalse(actions.isElementDisplayed(instrumentsPage.lastUpdatedColumnHeader));

        //click view
        actions.clickElement(instrumentsPage.viewBtn);

        //toggle created at column
        actions.clickElement(instrumentsPage.toggleCreatedAtColumnOption);

        actions.scrollToElementHorizontally(instrumentsPage.tableHorizontalScrollBar, 500);
        Thread.sleep(2000);
        Assert.assertTrue(actions.isElementDisplayed(instrumentsPage.createdAtColumnHeader));

        //click view
        Thread.sleep(2000);

        actions.clickElement(instrumentsPage.viewBtn);

        //toggle updated at column
        actions.clickElement(instrumentsPage.toggleLastUpdatedAtColumnOption);

        //test that seventh column is last updated at
        Thread.sleep(2000);
        Assert.assertTrue(actions.isElementDisplayed(instrumentsPage.lastUpdatedColumnHeader));
    }

    @Test(priority = 4)
    public void cancelEditsInstrument() throws InterruptedException {

        String nameBeforeEdit;
        //sign-out from support and login with admin

        Thread.sleep(2000);
        homePage.clickProfileIconBtn();
        homePage.clickSignoutBtn();

        //login with admin
        Helpers.loginWithValidUser((ChromeDriver) MainTestRunner.ChromeDriver, Credentials.adminUsername, Credentials.adminPassword);

        //navigate to instruments page
        homePage.clickInstrumentsDashboardBtn();

        nameBeforeEdit = actions.getText(instrumentsPage.firstRowName);

        //click options for first instrument
        Thread.sleep(2000);
        actions.scrollToElementHorizontally(instrumentsPage.tableHorizontalScrollBar, 500);
        actions.clickElement(instrumentsPage.firstRowOptionsBtn);

        //click edit
        actions.clickElement(instrumentsPage.firstRowEditOption);
        actions.clickElement(instrumentsPage.firstRowEditOption);
        //clear all fields
        Thread.sleep(2000);
        actions.clearText(instrumentsPage.editName);
        actions.clearText(instrumentsPage.editModel);

        //insert any dummy name
        actions.enterText(instrumentsPage.editName,"EFGHD");
        actions.enterText(instrumentsPage.editModel,"EFGHD");

        //click cancel
        Thread.sleep(2000);

        actions.clickElement(instrumentsPage.cancelEditBtn);

        //test that name of first instrument didn't change
        Assert.assertEquals(actions.getText(instrumentsPage.firstRowName), nameBeforeEdit);
    }

    @Test(priority = 5)
    public void editInstrument() throws InterruptedException {
        String editedName = "Edited_Name" + MainTestRunner.date;
        String editedModel = Helpers.generateRandomString();

        //clear any preset filters

        //click filter
        Thread.sleep(2000);
        actions.clickElement(instrumentsPage.filterBtn);

        //click clear
        actions.clickElement(instrumentsPage.clearFiltersBtn);

        //click options for first instrument
        Thread.sleep(2000);
        actions.scrollToElementHorizontally(instrumentsPage.tableHorizontalScrollBar, 500);
        actions.clickElement(instrumentsPage.firstRowOptionsBtn);
        
        //click edit
        actions.clickElement(instrumentsPage.firstRowEditOption);

        //clear all fields
        Thread.sleep(2000);
        actions.clearText(instrumentsPage.editName);
        actions.clearText(instrumentsPage.editModel);

        //insert edited name
        actions.enterText(instrumentsPage.editName,editedName);
        actions.enterText(instrumentsPage.editModel,editedModel);

        //click save
        Thread.sleep(2000);
        actions.clickElement(instrumentsPage.saveEditBtn);

        //confirm edits
        Thread.sleep(2000);
        actions.clickElement(instrumentsPage.submitEditBtn);

        //clear any preset filter

        //click filter
        actions.clickElement(instrumentsPage.filterBtn);

        //click clear
        actions.clickElement(instrumentsPage.clearFiltersBtn);
        
        //click filter
        actions.clickElement(instrumentsPage.filterBtn);

        //insert model
        actions.enterText(instrumentsPage.filterNameTextField,editedName);

        //click apply
        actions.clickElement(instrumentsPage.applyFilterBtn);

        //test that instrument appears
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(instrumentsPage.firstRowName), editedName);

    }

    @Test(priority = 5)
    public void sortData() throws InterruptedException {
        //clear any preset filter
        Thread.sleep(2000);
        actions.clickElement(instrumentsPage.filterBtn);
        actions.clickElement(instrumentsPage.clearFiltersBtn);

        //remove default sort
        Thread.sleep(2000);
        actions.clickElement(instrumentsPage.nameSortingBtn);
        actions.clickElement(instrumentsPage.sortingNameAsc);

        //click sort by name
        Thread.sleep(2000);
        actions.clickElement(instrumentsPage.nameSortingBtn);

        //choose sort ascending
        actions.clickElement(instrumentsPage.sortingNameAsc);

        //fetch first and second instruments name
        Thread.sleep(3000);
        String first = actions.getText(instrumentsPage.firstRowName);
        String second = actions.getText(instrumentsPage.secondInstrumentName);

        //test that data is sorted
        Assert.assertTrue(first.compareTo(second) <= 0);

        //click sort by name
        actions.clickElement(instrumentsPage.nameSortingBtn);

        //choose sort descending
        actions.clickElement(instrumentsPage.sortingNameDesc);

        //fetch first and second instruments name
        Thread.sleep(2000);
        first = actions.getText(instrumentsPage.firstRowName);
        second = actions.getText(instrumentsPage.secondInstrumentName);

        //test that data is sorted
        Assert.assertTrue(first.compareTo(second) >= 0);

        //remove the descending name sort
        actions.clickElement(instrumentsPage.nameSortingBtn);
        actions.clickElement(instrumentsPage.sortingNameDesc);

        //click sort by serial number
        Thread.sleep(3000);
        actions.clickElement(instrumentsPage.serialNumberSortingBtn);

        //choose sort ascending
        actions.clickElement(instrumentsPage.sortingSerialNumberAsc);

        //fetch first and second serial numbers
        first = actions.getText(instrumentsPage.firstRowSerialNumber);
        second=actions.getText(instrumentsPage.secondSerialNumber);

        //test that data is sorted
        Assert.assertTrue(first.compareTo(second) <= 0);

        //click sort by name
        Thread.sleep(2000);
        actions.clickElement(instrumentsPage.serialNumberSortingBtn);

        //choose sort descending
        actions.clickElement(instrumentsPage.sortingSerialNumberDesc);

        //fetch first and second instruments name
        Thread.sleep(2000);
        first = actions.getText(instrumentsPage.firstRowName);
        second=actions.getText(instrumentsPage.secondSerialNumber);

        //test that data is sorted
        Assert.assertTrue(first.compareTo(second) >= 0);
    }
}
