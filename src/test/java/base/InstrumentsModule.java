package base;

import data.Credentials;
import org.checkerframework.checker.units.qual.Temperature;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;
import pages.HomePage;
import pages.InstrumentsPage;
import utils.Helpers;

import java.util.Date;

public class InstrumentsModule {
    InstrumentsPage instrumentsPage;
    HomePage homePage;

    @Test(priority = 0)
    public void instrumentSearch() throws InterruptedException {
        instrumentsPage = new InstrumentsPage((ChromeDriver) MainTestRunner.ChromeDriver);
        homePage = new HomePage((ChromeDriver) MainTestRunner.ChromeDriver);

        //navigate to instruments page
        homePage.clickInstrumentsDashboardBtn();

        //send text to search field
        Thread.sleep(2000);
        instrumentsPage.sendTextToSearchField("B15FG115");
        instrumentsPage.clickSearchBtn();

        //test that results appear
        Thread.sleep(2000);
        Assert.assertEquals(instrumentsPage.getFirstRowNameText(), "B15FG115");

        instrumentsPage.refreshWindow();
        Thread.sleep(8000);
    }

    @Test(priority = 1)
    public void filterByInstrumentName() throws InterruptedException {
        //clear any preset filter

        //click filter
        instrumentsPage.clickFilterBtn();

        //click clear
        Thread.sleep(2000);
        instrumentsPage.clickClearFiltersBtn();

        //click apply
        instrumentsPage.clickApplyFilterBtn();

        //click filter
        instrumentsPage.clickFilterBtn();

        //insert instrument name
        instrumentsPage.sendTextToFilterNameTextField("B15FG115");

        //click apply
        instrumentsPage.clickApplyFilterBtn();

        //test that filtered instrument appears
        Thread.sleep(3000);
        Assert.assertEquals(instrumentsPage.getFirstRowNameText(), "B15FG115");
    }

    @Test(priority = 1)
    public void filterBySerialNumber() throws InterruptedException {
        //clear any preset filter

        //click filter
        instrumentsPage.clickFilterBtn();

        //click clear
        instrumentsPage.clickClearFiltersBtn();

        //click apply
        instrumentsPage.clickApplyFilterBtn();

        Thread.sleep(2000);
        String firstSerialNumber = instrumentsPage.getFirstRowSerialNumberText();


        //click filter
        instrumentsPage.clickFilterBtn();


        //insert serial number
        instrumentsPage.sendTextToFilterSerialNumberTextField(firstSerialNumber);

        //click apply
        instrumentsPage.clickApplyFilterBtn();

        //test that filtered instrument appears
        Thread.sleep(2000);
        Assert.assertEquals(instrumentsPage.getFirstRowSerialNumberText(), firstSerialNumber);
    }

    @Ignore
    @Test(priority = 1)
    public void filterByInstrumentType() throws InterruptedException {
        //clear any preset filter

        //click filter
        Thread.sleep(2000);
        instrumentsPage.clickFilterBtn();

        //click clear
        instrumentsPage.clickClearFiltersBtn();

        //click apply
        instrumentsPage.clickApplyFilterBtn();

        //click filter
        instrumentsPage.clickFilterBtn();

        //insert instrument name
        instrumentsPage.sendTextToFilterTypeTextField("Buchi");

        //click apply
        instrumentsPage.clickApplyFilterBtn();

        //test that filtered instrument appears
        Thread.sleep(2000);
        Assert.assertEquals(instrumentsPage.getFirstRowTypeText(), "B15FG115");
    }

    @Test(priority = 1)
    public void filterByModel() throws InterruptedException {
        //clear any preset filter

        //click filter
        instrumentsPage.clickFilterBtn();

        //click clear
        instrumentsPage.clickClearFiltersBtn();

        //click apply
        instrumentsPage.clickApplyFilterBtn();

        Thread.sleep(2000);
        String firstModel= instrumentsPage.getFirstRowModelText();

        //click filter
        instrumentsPage.clickFilterBtn();

        //insert model
        instrumentsPage.sendTextToFilterModelTextField(firstModel);

        //click apply
        instrumentsPage.clickApplyFilterBtn();

        //test that instrument appears
        Thread.sleep(3000);
        Assert.assertEquals(instrumentsPage.getFirstRowModelText(), firstModel);
    }

    @Test(priority = 2)
    public void toggleColumns() throws InterruptedException {

        //test that seventh column is created at
        Assert.assertEquals(instrumentsPage.getEigtthColHeaderText(), "Created at");

        //click view
        instrumentsPage.clickViewBtn();

        //toggle created at column
        instrumentsPage.clickToggleCreatedAtColumnOption();

        //click view
        Thread.sleep(2000);

        instrumentsPage.clickViewBtn();

        //toggle created at column
        instrumentsPage.clickToggleLastUpdatedAtColumnOption();

        //test that seventh column is last updated at
        Assert.assertEquals(instrumentsPage.getEigtthColHeaderText(), "Last updated at");


    }

    @Test(priority = 3)
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

        nameBeforeEdit = instrumentsPage.getFirstRowNameText();

        //click options for first instrument
        Thread.sleep(2000);
        instrumentsPage.clickFirstRowOptionsBtn();

        //click edit
        instrumentsPage.clickFirstRowEditOption();

        //clear all fields
        Thread.sleep(2000);
        instrumentsPage.resetEditNameField("");
        instrumentsPage.resetEditModelField("");


        //insert any dummy name
        instrumentsPage.sendTextToEditNameTextField("ABCDE");
        instrumentsPage.sendTextToEditModelTextField("ABCDE");

        //click cancel
        Thread.sleep(2000);

        instrumentsPage.clickEditCancelBtn();

        //test that name of first instrument didn't change
        Assert.assertEquals(instrumentsPage.getFirstRowNameText(), nameBeforeEdit);
    }

    @Test(priority = 4)
    public void editInstrument() throws InterruptedException {
        String editedName = "Edited_Name" + MainTestRunner.date;
        String editedModel = Helpers.generateRandomString();

        //clear any preset filters

        //click filter
        Thread.sleep(2000);
        instrumentsPage.clickFilterBtn();

        //click clear
        instrumentsPage.clickClearFiltersBtn();

        //click apply
        instrumentsPage.clickApplyFilterBtn();

        //click options for first instrument
        Thread.sleep(2000);
        instrumentsPage.clickFirstRowOptionsBtn();

        //click edit
        instrumentsPage.clickFirstRowEditOption();

        //clear all fields
        instrumentsPage.resetEditNameField("");
        instrumentsPage.resetEditModelField("");

        //insert new name
        instrumentsPage.sendTextToEditNameTextField(editedName);

        //insert new Model
        instrumentsPage.sendTextToEditModelTextField(editedModel);

        //click save
        Thread.sleep(2000);
        instrumentsPage.clickEditSaveBtn();

        //confirm edits
        Thread.sleep(2000);

        instrumentsPage.clickSubmitEditBtn();

        //clear any preset filter

        //click filter
        instrumentsPage.clickFilterBtn();

        //click clear
        instrumentsPage.clickClearFiltersBtn();

        //click apply
        instrumentsPage.clickApplyFilterBtn();

        //click filter
        instrumentsPage.clickFilterBtn();

        //insert model
        instrumentsPage.sendTextToFilterNameTextField(editedName);

        //click apply
        instrumentsPage.clickApplyFilterBtn();

        //test that instrument appears
        Thread.sleep(2000);
        Assert.assertEquals(instrumentsPage.getFirstRowNameText(), editedName);

    }

    @Test(priority = 4)
    public void sortData() throws InterruptedException {
        //clear any preset filter
        instrumentsPage.clickFilterBtn();
        instrumentsPage.clickClearFiltersBtn();
        instrumentsPage.clickApplyFilterBtn();

        //click sort by name
        instrumentsPage.clickSortByNameBtn();

        //choose sort ascending
        instrumentsPage.clickSortingNameAscOption();

        //fetch first and second instruments name
        Thread.sleep(2000);
        String first = instrumentsPage.getFirstRowNameText();
        String second = instrumentsPage.getSecondInstrumentNameText();

        //test that data is sorted
        Assert.assertTrue(first.compareTo(second) <= 0);

        //click sort by name
        instrumentsPage.clickSortByNameBtn();

        //choose sort descending
        instrumentsPage.clickSortingNameDescOption();

        //fetch first and second instruments name
        Thread.sleep(2000);
        first = instrumentsPage.getFirstRowNameText();
        second = instrumentsPage.getSecondInstrumentNameText();

        //test that data is sorted
        Assert.assertTrue(first.compareTo(second) >= 0);

        //click sort by serial number
        instrumentsPage.clickSerialNumberSortingBtn();

        //choose sort ascending
        instrumentsPage.clickSortingSerialNumberAscOption();

        //fetch first and second serial numbers
        first = instrumentsPage.getFirstRowSerialNumberText();
        second=instrumentsPage.getSecondSerialNumber();

        //test that data is sorted
        Assert.assertTrue(first.compareTo(second) <= 0);

        //click sort by name
        Thread.sleep(2000);
        instrumentsPage.clickSerialNumberSortingBtn();

        //choose sort descending
        instrumentsPage.clickSortingSerialNumberDescOption();

        //fetch first and second instruments name
        Thread.sleep(2000);
        first = instrumentsPage.getFirstRowNameText();
        second = instrumentsPage.getSecondInstrumentNameText();

        //test that data is sorted
        Assert.assertTrue(first.compareTo(second) >= 0);
    }
}
