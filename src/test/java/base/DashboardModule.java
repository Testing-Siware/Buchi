package base;

import data.Credentials;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.Actions;
import pages.DashboardPage;
import pages.HomePage;
import utils.EnvironmentSelector;
import utils.Helpers;

import java.util.List;

public class DashboardModule {

    HomePage homePage;
    Actions actions;
    DashboardPage dashboardPage;

    @BeforeClass
    public void intializeClasses(){
        homePage = new HomePage((ChromeDriver) MainTestRunner.ChromeDriver);
        actions = new Actions((ChromeDriver) MainTestRunner.ChromeDriver,20);
        dashboardPage = new DashboardPage((ChromeDriver) MainTestRunner.ChromeDriver);
    }

    @Test
    public void dashboardSupport() throws InterruptedException {
        //click dashboard button on side menu
        actions.clickElement(homePage.dashboardSidebarBtn);

        //test that user is redirected to dashboard
        Thread.sleep(2000);
        Assert.assertEquals(actions.getCurrentUrl(), EnvironmentSelector.dashboardUrl);

        //test that Sx-Suite column is visible
        Assert.assertTrue(actions.isElementDisplayed(dashboardPage.sxSuiteColumnHeader));

        //test that instrument column is visible
        Assert.assertTrue(actions.isElementDisplayed(dashboardPage.instrumentColumnHeader));

        //test that status column is visible
        Assert.assertTrue(actions.isElementDisplayed(dashboardPage.statusColumnHeader));

        //test that recipe column is visible
        Assert.assertTrue(actions.isElementDisplayed(dashboardPage.recipeColumnHeader));

        //test that events column is visible
        Assert.assertTrue(actions.isElementDisplayed(dashboardPage.eventsColumnHeader));

        //test that alias column is visible
        Assert.assertTrue(actions.isElementDisplayed(dashboardPage.aliasColumnHeader));

        //test that sx-suites are by default sorted in ascending order
        Assert.assertTrue(actions.getText(dashboardPage.firstRowSxSuite).compareTo(actions.getText(dashboardPage.firstRowSxSuite))<=0);

        //expand second row
        actions.clickElement(dashboardPage.secondRowExpandBtn);

        //test that there is "--" for no value parameter
        Assert.assertEquals(actions.getText(dashboardPage.firstParameterPredictionValue),"--");

        //test that the first row recipe is oats and its alias
        Assert.assertEquals(actions.getText(dashboardPage.firstRowRecipe),"Oats");
        Assert.assertEquals(actions.getText(dashboardPage.firstRowAlias),"oats alias");
        Assert.assertEquals(actions.getText(dashboardPage.firstRowInstrument),"522FG020");

        String filteredParameter="oat1";
        //click filter button
        actions.clickElement(dashboardPage.filterBtn);

        //choose filtered parameter from dropdown
        actions.chooseFromDropDown(dashboardPage.parameterDropdownFilter,filteredParameter);

        //click apply
        actions.clickElement(dashboardPage.submitFilterBtn);
        Thread.sleep(2000);

        //expand first row
        actions.clickElement(dashboardPage.firstRowExpand);

        //test that predicted value is two decimal places
        String predVal=actions.getText(dashboardPage.firstParameterPredictionValue);
        Assert.assertEquals(predVal.split("\\.")[1].length(),2);

    }

    @Test(priority = 1)
    public void filterByParameter() throws InterruptedException {

        String filteredParameter="Fiber";
        //click filter button
        actions.clickElement(dashboardPage.filterBtn);

        //click clear filter
        actions.clickElement(dashboardPage.clearFilterBtn);

        //click filter button
        actions.clickElement(dashboardPage.filterBtn);

        //choose filtered parameter from dropdown
        actions.chooseFromDropDown(dashboardPage.parameterDropdownFilter,filteredParameter);

        //click apply
        actions.clickElement(dashboardPage.submitFilterBtn);

        //expand first sx-suite
        Thread.sleep(2000);
        actions.clickElement(dashboardPage.firstRowExpand);

        //test that first parameter is the filtered one
        Assert.assertEquals(actions.getText(dashboardPage.firstRowNestedGridFirstRowParameter),filteredParameter);

    }

    @Test(priority = 1)
    public void filterByMD() throws InterruptedException {
        //click filter button
        actions.clickElement(dashboardPage.filterBtn);

        //click clear filter
        actions.clickElement(dashboardPage.clearFilterBtn);

        //click filter button
        actions.clickElement(dashboardPage.filterBtn);

        //insert MD ranges
        actions.enterText(dashboardPage.mdFromFilter,"105");
        actions.enterText(dashboardPage.mdToFilter,"106");

        //click apply filter
        actions.clickElement(dashboardPage.submitFilterBtn);


        //expand first sx-suite
        Thread.sleep(2000);
        actions.clickElement(dashboardPage.firstRowExpand);

        //test that first parameter is the filtered one
        Assert.assertEquals(actions.getText(dashboardPage.firstRowNestedGridFirstRowParameter),"Moisture");
    }

    @Test(priority = 1)
    public void filterByPrediction() throws InterruptedException {
        //click filter button
        actions.clickElement(dashboardPage.filterBtn);

        //click clear filter
        actions.clickElement(dashboardPage.clearFilterBtn);

        //click filter button
        actions.clickElement(dashboardPage.filterBtn);

        //insert MD ranges
        actions.enterText(dashboardPage.predictionValueFromFilter,"12");
        actions.enterText(dashboardPage.predictionValueToFilter,"13");

        //click apply filter
        actions.clickElement(dashboardPage.submitFilterBtn);

        //expand first sx-suite
        Thread.sleep(2000);
        actions.clickElement(dashboardPage.firstRowExpand);

        //test that first parameter is the filtered one
        Assert.assertEquals(actions.getText(dashboardPage.firstRowNestedGridFirstRowParameter),"Moisture");
    }

    @Test(priority = 1)
    public void filterByEvents() throws InterruptedException {
        //click filter button
        actions.clickElement(dashboardPage.filterBtn);

        //click clear filter
        actions.clickElement(dashboardPage.clearFilterBtn);

        //click filter button
        actions.clickElement(dashboardPage.filterBtn);

        //choose event from dropdown list
        Thread.sleep(2000);
        actions.chooseFromDropDown(dashboardPage.eventsDropdownFilter,"range");

        //click apply filter
        actions.clickElement(dashboardPage.submitFilterBtn);

        //test that filtered suites are out of range
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(dashboardPage.firstRowEvents),"Out Of Range");
    }

    @Test(priority = 1)
    public void filterByIso() throws InterruptedException {
        //click filter button
        actions.clickElement(dashboardPage.filterBtn);

        //click clear filter
        actions.clickElement(dashboardPage.clearFilterBtn);

        //click filter button
        actions.clickElement(dashboardPage.filterBtn);

        //filter by false
        Thread.sleep(2000);
        actions.scrollToElement(dashboardPage.iso12099DropdownFilter);
        actions.chooseFromDropDown(dashboardPage.iso12099DropdownFilter,"False");

        //click apply
        actions.clickElement(dashboardPage.submitFilterBtn);

        //expand first sx-suite
        Thread.sleep(2000);
        actions.clickElement(dashboardPage.firstRowExpand);

        //test that first parameter is the filtered one
        Assert.assertEquals(actions.getText(dashboardPage.firstRowNestedGridFirstRowISO),"FAIL");}

    @Test(priority = 2)
    public void instrumentNameRedirect()throws InterruptedException{
        String instrumentName="";
        String affiliateName="";
        String filteredParameter="Fiber";

        //click filter button
        actions.clickElement(dashboardPage.filterBtn);

        //click clear filter
        actions.clickElement(dashboardPage.clearFilterBtn);

        //click filter button
        actions.clickElement(dashboardPage.filterBtn);

        //choose filtered parameter from dropdown
        actions.chooseFromDropDown(dashboardPage.parameterDropdownFilter,filteredParameter);

        //click apply
        actions.clickElement(dashboardPage.submitFilterBtn);

        Thread.sleep(2000);

        //fetch affiliate name and instrument name
        affiliateName=actions.getText(dashboardPage.firstRowSxSuite);
        instrumentName=actions.getText(dashboardPage.firstRowInstrument);

        //click on first instrument
        actions.clickElement(dashboardPage.firstRowInstrument);

        //test that user is redirected to instrument page
        Assert.assertEquals(actions.getCurrentUrl(),EnvironmentSelector.parametersDashboardUrl);
        Assert.assertTrue(actions.getText(dashboardPage.dashboardInstrumentHeader).contains(affiliateName));
        Assert.assertTrue(actions.getText(dashboardPage.dashboardInstrumentHeader).contains(instrumentName));

        //test that the chart appears for every parameter
        Thread.sleep(2000);
        Assert.assertTrue(actions.isElementDisplayed(dashboardPage.firstParameterChart));

        // test that the default is 24 hours
        Assert.assertEquals(actions.getText(dashboardPage.graphTimeFilter),"24 hours");

        //test that go back button redirects to dashboard
        actions.clickElement(dashboardPage.backBtnDashboardPage);

        Assert.assertEquals(actions.getCurrentUrl(),EnvironmentSelector.dashboardUrl);
    }

    @Test(priority = 3)
    public void parameterWidgetContent()throws InterruptedException{
        String instrumentName="";
        String affiliateName="";
        String filteredParameter="Fiber";

        //click filter button
        actions.clickElement(dashboardPage.filterBtn);

        //click clear filter
        actions.clickElement(dashboardPage.clearFilterBtn);

        //click filter button
        actions.clickElement(dashboardPage.filterBtn);

        //choose filtered parameter from dropdown
        actions.chooseFromDropDown(dashboardPage.parameterDropdownFilter,filteredParameter);

        //click apply
        actions.clickElement(dashboardPage.submitFilterBtn);

        //click on first instrument

        Thread.sleep(2000);
        actions.clickElement(dashboardPage.firstRowInstrument);

        Thread.sleep(2000);

        //test that parameter widget appear
        Assert.assertTrue(actions.getText(dashboardPage.parameterDetailWidget).contains("ISO12099"));
        Assert.assertTrue(actions.getText(dashboardPage.parameterDetailWidget).contains("Treat"));
        Assert.assertTrue(actions.getText(dashboardPage.parameterDetailWidget).contains("Range"));
        Assert.assertTrue(actions.getText(dashboardPage.parameterDetailWidget).contains("SECN"));
        Assert.assertTrue(actions.getText(dashboardPage.parameterDetailWidget).contains("Factors"));
        Assert.assertTrue(actions.getText(dashboardPage.parameterDetailWidget).contains("Method"));

        //test that MD chart appears
        Assert.assertTrue(actions.getText(dashboardPage.MDChart).contains("MD"));

        //click back
        actions.clickElement(dashboardPage.backBtnDashboardPage);

    }

    @Test(priority = 4)
    public void sortBySxSuite() throws InterruptedException {

        //click filter
        actions.clickElement(dashboardPage.filterBtn);
        actions.clickElement(dashboardPage.clearFilterBtn);

        Thread.sleep(2000);
        //click on sx-suite column header
        actions.clickElement(dashboardPage.sxSuiteColumnHeader);

        //choose sort desc
        Thread.sleep(1000);
        actions.clickElement(dashboardPage.sxSuiteSortDescOption);

        Thread.sleep(3000);
        System.out.println(actions.getText(dashboardPage.firstRowSxSuite));
        Assert.assertTrue(actions.getText(dashboardPage.firstRowSxSuite).compareTo(actions.getText(dashboardPage.secondRowSxSuite))>=0);

        //click on sx-suite column header
        actions.clickElement(dashboardPage.sxSuiteColumnHeader);

        //choose sort asc
        actions.clickElement(dashboardPage.sxSuiteSortAscOption);

        Thread.sleep(2000);
        System.out.println(actions.getText(dashboardPage.firstRowSxSuite));
        Assert.assertTrue(actions.getText(dashboardPage.firstRowSxSuite).compareTo(actions.getText(dashboardPage.secondRowSxSuite))<=0);

    }

    @Test(priority = 6,dependsOnMethods = "dashboardPartnerAdmin")
    public void nestedGridContent() throws InterruptedException {
        //expand first row
        actions.clickElement(dashboardPage.firstRowExpand);
        Thread.sleep(2000);
        List<WebElement> nestedGridHeaders=dashboardPage.firstRowNestedGridHeader.findElements(By.xpath("./child::*"));
        List<String> expectedHeaders = List.of("Parameter","Parameter Alias","MD", "Prediction Value","Events / Alerts", "Calibration age", "ISO12099");

        //test that all 5 headers are present
        Assert.assertEquals(nestedGridHeaders.size(),7);
        for(int i=0;i<nestedGridHeaders.size();i++){
            Assert.assertEquals(nestedGridHeaders.get(i).getText(),expectedHeaders.get(i));
        }
        }

    @Test(priority = 6)
    public void dashboardPartnerAdmin() throws InterruptedException {
        //sign-out from support
        actions.clickElement(homePage.profileIconBtn);
        actions.clickElement(homePage.signoutBtn);

        //login with admin account
        Helpers.loginWithValidUser((ChromeDriver) MainTestRunner.ChromeDriver, Credentials.partnerAdminUsername, Credentials.partnerAdminPassword);

        //navigate to dashboard
        actions.clickElement(homePage.dashboardSidebarBtn);

        //test that user is redirected
        Assert.assertEquals(actions.getCurrentUrl(),EnvironmentSelector.dashboardUrl);

        //test that data is displayed using sx-suite in ascending order
        System.out.println(actions.getText(dashboardPage.firstRowSxSuite));
        System.out.println(actions.getText(dashboardPage.secondRowSxSuite));
        Assert.assertTrue(actions.getText(dashboardPage.firstRowSxSuite).compareTo(actions.getText(dashboardPage.secondRowSxSuite))<=0);

        //test that instrument column is displayed
        Assert.assertTrue(actions.isElementDisplayed(dashboardPage.instrumentColumnHeader));
        System.out.println(actions.getText(dashboardPage.firstRowInstrument));
        System.out.println(actions.getText(dashboardPage.secondRowInstrument));
        Assert.assertTrue(actions.getText(dashboardPage.secondRowInstrument).compareTo(actions.getText(dashboardPage.firstRowInstrument))>=0);

        //test that status column is displayed
        Assert.assertTrue(actions.isElementDisplayed(dashboardPage.statusColumnHeader));

        //test that recipe column is displayed
        Assert.assertTrue(actions.isElementDisplayed(dashboardPage.recipeColumnHeader));

        //test content of information message below dashboard title
        Assert.assertEquals(actions.getText(dashboardPage.informationMessage),"Monitor near real-time measurement statuses for your instruments, along with the actual MD results for the parameters of the measured recipes.");

        //click on first instrument
        actions.clickElement(dashboardPage.firstRowInstrument);

        //test that time filter is visible and by default 24 hours
        Assert.assertTrue(actions.isElementDisplayed(dashboardPage.graphTimeFilter));
        Assert.assertEquals(actions.getText(dashboardPage.graphTimeFilter),"24 hours");

        actions.clickElement(dashboardPage.backBtnDashboardPage);

        //test that prediction filter is visible
        actions.clickElement(dashboardPage.filterBtn);

        Assert.assertTrue(actions.isElementDisplayed(dashboardPage.predictionValueToFilter));

        //click cancel filter
        actions.clickElement(dashboardPage.cancelFilterBtn);
    }

    @Test(priority = 7)
    public void dashboardAdmin() throws InterruptedException {
        //sign-out from support
        actions.clickElement(homePage.profileIconBtn);
        actions.clickElement(homePage.signoutBtn);


        //login with admin account
        Helpers.loginWithValidUser((ChromeDriver) MainTestRunner.ChromeDriver, Credentials.adminUsername, Credentials.adminPassword);

        //navigate to dashboard
        actions.clickElement(homePage.dashboardSidebarBtn);

        //test that user is redirected
        Assert.assertEquals(actions.getCurrentUrl(),EnvironmentSelector.dashboardUrl);

        //test that sx-suite column is not visible
        Assert.assertFalse(actions.isElementDisplayed(dashboardPage.sxSuiteColumnHeader));

        //test that instrument column is displayed
        System.out.println(actions.getText(dashboardPage.firstRowSxSuite));
        System.out.println(actions.getText(dashboardPage.secondRowSxSuite));
        Assert.assertTrue(actions.getText(dashboardPage.firstRowSxSuite).compareTo(actions.getText(dashboardPage.secondRowSxSuite))<=0);

        //test that status column is displayed
        Assert.assertTrue(actions.isElementDisplayed(dashboardPage.statusColumnHeader));

        //test that recipe column is displayed
        Assert.assertEquals(actions.getText(dashboardPage.instrumentColumnHeader),"Recipe");

        //test content of information message below dashboard title
        Assert.assertEquals(actions.getText(dashboardPage.informationMessage),"Monitor near real-time measurement statuses for your instruments, along with the actual MD results for the parameters of the measured recipes.");

        //click on first instrument
        actions.clickElement(dashboardPage.firstRowInstrumentAdmin);

        //test that time filter is visible and by default 24 hours
        Assert.assertTrue(actions.isElementDisplayed(dashboardPage.graphTimeFilter));
        System.out.println(actions.getText(dashboardPage.graphTimeFilter));

        //click back btn
        actions.clickElement(dashboardPage.backBtnDashboardPage);

        //test that prediction filter is visible
        actions.clickElement(dashboardPage.filterBtn);

        Assert.assertTrue(actions.isElementDisplayed(dashboardPage.predictionValueToFilter));

        //click cancel filter
        actions.clickElement(dashboardPage.cancelFilterBtn);

    }

    @Test(priority = 7)
    public void dashboardUser() throws InterruptedException {
        //sign-out from support
        actions.clickElement(homePage.profileIconBtn);
        actions.clickElement(homePage.signoutBtn);

        //login with admin account
        Helpers.loginWithValidUser((ChromeDriver) MainTestRunner.ChromeDriver, Credentials.userName, Credentials.userPassword);

        //navigate to dashboard
        actions.clickElement(homePage.dashboardSidebarBtn);

        //test that user is redirected
        Assert.assertEquals(actions.getCurrentUrl(),EnvironmentSelector.dashboardUrl);

        //test that sx-suite column is not visible
        Assert.assertFalse(actions.isElementDisplayed(dashboardPage.sxSuiteColumnHeader));

        //test that instrument column is displayed
        System.out.println(actions.getText(dashboardPage.firstRowSxSuite));
        System.out.println(actions.getText(dashboardPage.secondRowSxSuite));
        Assert.assertTrue(actions.getText(dashboardPage.firstRowSxSuite).compareTo(actions.getText(dashboardPage.secondRowSxSuite))<=0);

        //test that status column is displayed
        Assert.assertTrue(actions.isElementDisplayed(dashboardPage.statusColumnHeader));

        //test that recipe column is displayed
        Assert.assertEquals(actions.getText(dashboardPage.instrumentColumnHeader),"Recipe");

        //test content of information message below dashboard title
        Assert.assertEquals(actions.getText(dashboardPage.informationMessage),"Monitor near real-time measurement statuses for your instruments, along with the actual MD results for the parameters of the measured recipes.");

        //click on first instrument
        actions.clickElement(dashboardPage.firstRowInstrumentAdmin);

        //test that time filter is visible and by default 24 hours
        Assert.assertTrue(actions.isElementDisplayed(dashboardPage.graphTimeFilter));
        System.out.println(actions.getText(dashboardPage.graphTimeFilter));

        //click back btn
        actions.clickElement(dashboardPage.backBtnDashboardPage);

        //test that prediction filter is visible
        actions.clickElement(dashboardPage.filterBtn);

        Assert.assertTrue(actions.isElementDisplayed(dashboardPage.predictionValueToFilter));

        //click cancel filter
        actions.clickElement(dashboardPage.cancelFilterBtn);

    }

   @Test(priority = 7)
   @Ignore
    public void dashboardPartnerUser() throws InterruptedException {
        //sign-out from support
        actions.clickElement(homePage.profileIconBtn);
        actions.clickElement(homePage.signoutBtn);

        //login with admin account
        Helpers.loginWithValidUser((ChromeDriver) MainTestRunner.ChromeDriver, Credentials.partnerUserUsername, Credentials.partnerUserPassword);

        //navigate to dashboard
        actions.clickElement(homePage.dashboardSidebarBtn);

        //test that user is redirected
        Assert.assertEquals(actions.getCurrentUrl(),EnvironmentSelector.dashboardUrl);

        //test that sx-suite column is not visible
        Assert.assertFalse(actions.isElementDisplayed(dashboardPage.sxSuiteColumnHeader));

        //test that instrument column is displayed
        System.out.println(actions.getText(dashboardPage.firstRowSxSuite));
        System.out.println(actions.getText(dashboardPage.secondRowSxSuite));
        Assert.assertTrue(actions.getText(dashboardPage.firstRowSxSuite).compareTo(actions.getText(dashboardPage.secondRowSxSuite))<=0);

        //test that status column is displayed
        Assert.assertTrue(actions.isElementDisplayed(dashboardPage.statusColumnHeader));

        //test that recipe column is displayed
        Assert.assertEquals(actions.getText(dashboardPage.instrumentColumnHeader),"Recipe");

        //test content of information message below dashboard title
        Assert.assertEquals(actions.getText(dashboardPage.informationMessage),"Monitor near real-time measurement statuses for your instruments, along with the actual MD results for the parameters of the measured recipes.");

        //click on first instrument
       actions.clickElement(dashboardPage.firstRowInstrument);

       //test that time filter is visible and by default 24 hours
       Assert.assertTrue(actions.isElementDisplayed(dashboardPage.graphTimeFilter));
       System.out.println(actions.getText(dashboardPage.graphTimeFilter));
    }

    @Ignore
    @Test(priority = 8)
    public void dashboardSuperAdmin() throws InterruptedException {
        //sign-out from support
        actions.clickElement(homePage.profileIconBtn);
        actions.clickElement(homePage.signoutBtn);

        //login with admin account
        Helpers.loginWithValidUser((ChromeDriver) MainTestRunner.ChromeDriver, Credentials.superAdminUsername, Credentials.superAdminPassword);

        //navigate to dashboard
        actions.clickElement(homePage.dashboardSidebarBtn);

        //test that user is redirected
        Assert.assertEquals(actions.getCurrentUrl(),EnvironmentSelector.dashboardUrl);

        //test that sx-suite column is not visible
        Assert.assertFalse(actions.isElementDisplayed(dashboardPage.sxSuiteColumnHeader));

        //test that instrument column is displayed
        System.out.println(actions.getText(dashboardPage.firstRowSxSuite));
        System.out.println(actions.getText(dashboardPage.secondRowSxSuite));
        Assert.assertTrue(actions.getText(dashboardPage.firstRowSxSuite).compareTo(actions.getText(dashboardPage.secondRowSxSuite))<=0);

        //test that status column is displayed
        Assert.assertTrue(actions.isElementDisplayed(dashboardPage.statusColumnHeader));

        //test that recipe column is displayed
        Assert.assertEquals(actions.getText(dashboardPage.instrumentColumnHeader),"Recipe");

        //test content of information message below dashboard title
        Assert.assertEquals(actions.getText(dashboardPage.informationMessage),"Monitor near real-time measurement statuses for your instruments, along with the actual MD results for the parameters of the measured recipes.");

    }

}
