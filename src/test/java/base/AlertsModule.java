package base;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.Actions;
import pages.AlertsPage;
import pages.HomePage;

import java.util.Date;

public class AlertsModule {
    public AlertsPage alertsPage;
    public HomePage homePage;
    public Actions actions;
    String createdAlert="";

    @Test(priority = 0)
    public void intializeClasses() {
        homePage= new HomePage((ChromeDriver) MainTestRunner.ChromeDriver);
        alertsPage=new AlertsPage((ChromeDriver) MainTestRunner.ChromeDriver);
        actions = new Actions((ChromeDriver) MainTestRunner.ChromeDriver,20);
    }

    @Test(priority = 1)
    public void createAlert() throws InterruptedException {
        //navigate to alerts page
        homePage.clickAlertsSidebarBtn();

        //click new alert button
        actions.clickElement(alertsPage.newAlertBtn);

        //test that user is redirected to new alert creation page
        Assert.assertEquals(MainTestRunner.ChromeDriver.getCurrentUrl(),alertsPage.newAlertPageURL);

        //insert alert details1
        //alert name
        createdAlert="Alert_"+MainTestRunner.formatter.format(new Date());
        actions.enterText(alertsPage.newAlertName,createdAlert);

        //affiliate
        actions.chooseFromDropDown(alertsPage.newAlertAffiliate,"sub2");

        //recipe
        actions.chooseFromDropDown(alertsPage.newAlertRecipe,"Bcloned");

        //instruments SNR
        actions.chooseFromDropDown(alertsPage.newAlertInstrument,"416FG106");

        //alerts constraints
        //first parameter
        actions.chooseFromDropDown(alertsPage.newAlertFirstParameter,"Fat");

        //clear min and max value
        //first parameter max value
        actions.clearText(alertsPage.newAlertFirstParameterMaxValue);

        //first parameter min value
        actions.clearText(alertsPage.newAlertFirstParameterMinValue);

        //insert equal value
        actions.enterText(alertsPage.newAlertFirstParameterEqualValue,"10");

        //click add parameter button
        actions.clickElement(alertsPage.newAlertAddParameterBtn);

        //first parameter
        actions.chooseFromDropDown(alertsPage.newAlertSecondParameter,"Protein");

        //clear min and max value
        //first parameter max value
        actions.clearText(alertsPage.newAlertSecondParameterMaxValue);

        //first parameter min value
        actions.clearText(alertsPage.newAlertSecondParameterMinValue);

        //insert equal value
        actions.enterText(alertsPage.newAlertSecondParameterEqualValue,"10");

        //insert alert recipients
        actions.chooseFromDropDown(alertsPage.newAlertRecipients,"mohamed.khaled+support@si-ware.com");

        //click save alert
        actions.clickElement(alertsPage.newAlertSaveBtn);

        //filter for alert
        actions.clickElement(alertsPage.filterBtn);

        //insert name of created alert
        actions.enterText(alertsPage.filterNameInput,createdAlert);

        //click apply
        actions.clickElement(alertsPage.submitFilterBtn);

        //test that alert is created
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(alertsPage.firstAlertName),createdAlert);
    }

    @Test(priority = 1)
    public void createEmptyAlert() throws InterruptedException {
        //navigate to alerts page
        homePage.clickAlertsSidebarBtn();

        //click new alert button
        actions.clickElement(alertsPage.newAlertBtn);

        //click save button without entering any data
        actions.clickElement(alertsPage.newAlertSaveBtn);

        //test that all error messages appear
        Assert.assertEquals(actions.getText(alertsPage.newAlertNameEmptyMsg),"Name can not be empty!");
        Assert.assertEquals(actions.getText(alertsPage.newAlertAffiliateEmptyMsg),"Affiliate can not be empty!");
        Assert.assertEquals(actions.getText(alertsPage.newAlertRecipeEmptyMsg),"Recipe can not be empty!");
        Assert.assertEquals(actions.getText(alertsPage.newAlertIngredientEmptyMsg),"Instruments can not be empty!");
        Assert.assertEquals(actions.getText(alertsPage.newAlertParameterEmptyMsg),"Parameter can not be empty!");
        Assert.assertEquals(actions.getText(alertsPage.newAlertRecipientsEmptyMsg),"Alert recipients can not be empty!");

        //add all required fields except parameter constraint
        actions.enterText(alertsPage.newAlertName,"Alert Name");

        //affiliate
        actions.chooseFromDropDown(alertsPage.newAlertAffiliate,"sub2");

        //recipe
        actions.chooseFromDropDown(alertsPage.newAlertRecipe,"Bcloned");

        //instruments SNR
        actions.chooseFromDropDown(alertsPage.newAlertInstrument,"416FG106");

        //alerts constraints
        //first parameter
        actions.chooseFromDropDown(alertsPage.newAlertFirstParameter,"Fat");

        Thread.sleep(2000);
        //clear min and max value
        //first parameter max value

        actions.sendKeys(alertsPage.newAlertFirstParameterMaxValue,new Keys[]{Keys.BACK_SPACE,Keys.BACK_SPACE});

        //first parameter min value
        actions.sendKeys(alertsPage.newAlertFirstParameterMinValue, new Keys[]{Keys.BACK_SPACE});

        //click save alert
        actions.clickElement(alertsPage.newAlertSaveBtn);
        Assert.assertEquals(actions.getText(alertsPage.newAlertParameterEmptyMsg),"Parameter constraints must have at least 1 constraint");
    }

    @Test(priority = 2)
    public void filterAlertByName() throws InterruptedException {
        //navigate to alerts page
        homePage.clickAlertsSidebarBtn();

        //click filter button
        actions.clickElement(alertsPage.filterBtn);

        //click clear button
        actions.clickElement(alertsPage.clearFilterBtn);

        //click filter button
        actions.clickElement(alertsPage.filterBtn);

        //insert name of created alert
        actions.enterText(alertsPage.filterNameInput,createdAlert);

        //click apply
        actions.clickElement(alertsPage.submitFilterBtn);

        //test that alert is created
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(alertsPage.firstAlertName),createdAlert);
    }

    @Test(priority = 2)
    public void filterRecipe() throws InterruptedException {
        //navigate to alerts page
        homePage.clickAlertsSidebarBtn();

        //click filter button
        actions.clickElement(alertsPage.filterBtn);

        //click clear button
        actions.clickElement(alertsPage.clearFilterBtn);

        //click filter button
        actions.clickElement(alertsPage.filterBtn);

        //insert affiliate
        actions.chooseFromDropDown(alertsPage.filterAffiliateInput,"Sub1");

        //insert recipe
         actions.chooseFromDropDown(alertsPage.filterRecipeInput,"Milk");

        //click apply
        actions.clickElement(alertsPage.submitFilterBtn);

        //test that alert is created
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(alertsPage.firstAlertRecipe),"Milk");
    }

    @Test(priority = 2)
    public void filterAffiliate() throws InterruptedException {
        //navigate to alerts page
        homePage.clickAlertsSidebarBtn();

        //click filter button
        actions.clickElement(alertsPage.filterBtn);

        //click clear button
        actions.clickElement(alertsPage.clearFilterBtn);

        //click filter button
        actions.clickElement(alertsPage.filterBtn);

        //insert affiliate
        actions.chooseFromDropDown(alertsPage.filterAffiliateInput,"Sub2");

        //click apply
        actions.clickElement(alertsPage.submitFilterBtn);

        //test that alert is created
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(alertsPage.firstAlertAffiliate),"Sub2");
    }

    @Test(priority = 3)
    public void editAlert() throws InterruptedException {
        //navigate to alerts page
        homePage.clickAlertsSidebarBtn();

        //click filter button
        actions.clickElement(alertsPage.filterBtn);

        //click clear button
        actions.clickElement(alertsPage.clearFilterBtn);

        //click filter button
        actions.clickElement(alertsPage.filterBtn);

        //insert name of created alert
        actions.enterText(alertsPage.filterNameInput,createdAlert);

        //click apply
        actions.clickElement(alertsPage.submitFilterBtn);

        //click actions button
        Thread.sleep(2000);

        actions.clickElement(alertsPage.firstAlertActionsBtn);

        //choose edit option
        actions.clickElement(alertsPage.editAlertOptionBtn);

        //test that user is redirected to edit page
        Assert.assertEquals(MainTestRunner.ChromeDriver.getCurrentUrl(),"https://lablake-dev.neospectra.cloud/fleet-management/alert/edit");


        //edit name
        createdAlert="Edit_Alert_"+MainTestRunner.formatter.format(new Date());
        actions.clearText(alertsPage.newAlertName);
        actions.enterText(alertsPage.newAlertName,createdAlert);

        //choose new affiliate
        actions.chooseFromDropDown(alertsPage.newAlertAffiliate,"sub1");

        //choose new recipe
        actions.chooseFromDropDown(alertsPage.newAlertRecipe,"Milk");

        //choose isntrument
        actions.chooseFromDropDown(alertsPage.newAlertInstrument,"B15");

        //select parameter
        actions.chooseFromDropDown(alertsPage.newAlertFirstParameter,"Fat");

        //click save
        actions.clickElement(alertsPage.newAlertSaveBtn);

        //click filter button
        actions.clickElement(alertsPage.filterBtn);

        //click clear button
        actions.clickElement(alertsPage.clearFilterBtn);

        //click filter button
        actions.clickElement(alertsPage.filterBtn);

        //insert name of created alert
        actions.enterText(alertsPage.filterNameInput,createdAlert);

        //click apply
        actions.clickElement(alertsPage.submitFilterBtn);

        //test that alert is created
        Thread.sleep(2000);
        System.out.println(actions.getText(alertsPage.firstAlertAffiliate));
        System.out.println(actions.getText(alertsPage.newAlertRecipe));
        System.out.println(actions.getText(alertsPage.newAlertInstrument));
        Assert.assertEquals(actions.getText(alertsPage.firstAlertName),createdAlert);

    }

    @Test(priority = 3)
    public void emptyEdits() throws InterruptedException {
        //navigate to alerts page
        homePage.clickAlertsSidebarBtn();

        //click filter button
        actions.clickElement(alertsPage.filterBtn);

        //click clear button
        actions.clickElement(alertsPage.clearFilterBtn);

        //click filter button
        actions.clickElement(alertsPage.filterBtn);

        //insert name of created alert
        actions.enterText(alertsPage.filterNameInput,createdAlert);

        //click apply
        actions.clickElement(alertsPage.submitFilterBtn);

        //click actions button
        Thread.sleep(2000);
        actions.clickElement(alertsPage.firstAlertActionsBtn);

        //choose edit option
        actions.clickElement(alertsPage.editAlertOptionBtn);

        //clear alert name
        Thread.sleep(2000);
        actions.clearText(alertsPage.newAlertName);
        actions.sendKeys(alertsPage.newAlertName,new Keys[]{Keys.NUMPAD0,Keys.BACK_SPACE});

        //clear alert recipients
        actions.sendKeys(alertsPage.newAlertRecipients,new Keys[]{Keys.BACK_SPACE});

        //click save
        actions.clickElement(alertsPage.newAlertSaveBtn);

        //test that alert messages appear
        Assert.assertEquals(actions.getText(alertsPage.newAlertRecipientsEmptyMsg),"Alert recipients can not be empty!");
        Assert.assertEquals(actions.getText(alertsPage.newAlertNameEmptyMsg),"Name is required.");

        //click cancel
        actions.clickElement(alertsPage.newAlertCancelBtn);
    }

    @Test(priority = 3)
    public void cancelEdits() throws InterruptedException {
        //navigate to alerts page
        homePage.clickAlertsSidebarBtn();

        //click filter button
        actions.clickElement(alertsPage.filterBtn);

        //click clear button
        actions.clickElement(alertsPage.clearFilterBtn);

        //click filter button
        actions.clickElement(alertsPage.filterBtn);

        //insert name of created alert
        actions.enterText(alertsPage.filterNameInput,createdAlert);

        //click apply
        actions.clickElement(alertsPage.submitFilterBtn);

        //click actions button
        Thread.sleep(2000);
        actions.clickElement(alertsPage.firstAlertActionsBtn);

        //choose edit option
        actions.clickElement(alertsPage.editAlertOptionBtn);

        //clear alert name
        Thread.sleep(2000);
        actions.clearText(alertsPage.newAlertName);
        actions.sendKeys(alertsPage.newAlertName,new Keys[]{Keys.NUMPAD0,Keys.BACK_SPACE});

        //insert a temporary name
        actions.enterText(alertsPage.newAlertName,"Temp_Name");

        //click cancel
        actions.clickElement(alertsPage.newAlertCancelBtn);

        //test that alert name didn't change
        //click filter button
        actions.clickElement(alertsPage.filterBtn);

        //click clear button
        actions.clickElement(alertsPage.clearFilterBtn);

        //click filter button
        actions.clickElement(alertsPage.filterBtn);

        //insert name of created alert
        actions.enterText(alertsPage.filterNameInput,createdAlert);

        //click apply
        actions.clickElement(alertsPage.submitFilterBtn);
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(alertsPage.firstAlertName),createdAlert);
    }
}
