package base;

import data.Credentials;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Actions;
import pages.AlertsPage;
import pages.HomePage;
import utils.EnvironmentSelector;
import utils.Helpers;

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

        Thread.sleep(2000);

        //test that filter button is displayed & enabled
        Assert.assertTrue(actions.isElementDisplayed(alertsPage.filterBtn) && actions.isElementEnabled(alertsPage.filterBtn));

        //test that new alert button is displayed & enabled
        Assert.assertTrue(actions.isElementDisplayed(alertsPage.newAlertBtn) && actions.isElementEnabled(alertsPage.newAlertBtn));

        //test that view button is displayed & enabled
        Assert.assertTrue(actions.isElementDisplayed(alertsPage.viewingOptions) && actions.isElementEnabled(alertsPage.viewingOptions));

        //test that refresh button is displayed & enabled
        Assert.assertTrue(actions.isElementDisplayed(alertsPage.refreshBtn) && actions.isElementEnabled(alertsPage.refreshBtn));

        //test that options button is displayed & disabled
        Assert.assertTrue(actions.isElementDisplayed(alertsPage.optionsBtn) && !actions.isElementEnabled(alertsPage.optionsBtn));

        //test that grid & related components appear
        Assert.assertTrue(actions.getText(alertsPage.alertsGridHeader).contains("Name"));
        Assert.assertTrue(actions.getText(alertsPage.alertsGridHeader).contains("Recipe"));
        Assert.assertTrue(actions.getText(alertsPage.alertsGridHeader).contains("Notification type"));
        Assert.assertTrue(actions.getText(alertsPage.alertsGridHeader).contains("Affiliate"));
        Assert.assertTrue(actions.getText(alertsPage.alertsGridHeader).contains("Created at"));
        Assert.assertTrue(actions.getText(alertsPage.alertsGridHeader).contains("Created by"));
        Assert.assertTrue(actions.getText(alertsPage.alertsGridHeader).contains("Status"));

        //test that alerts title is displayed
        Assert.assertTrue(actions.getText(alertsPage.alertsPageTitle).contains("Alerts"));

        //test that the grid contains no more than 10 recipes
        Assert.assertTrue(actions.getElementChildren(alertsPage.alertsGrid).size()<=10);

        //test that pagination to last page exists
        Assert.assertTrue(actions.isElementDisplayed(alertsPage.alertsGridPaginationLastPage));

        //test that pagination to next page exists
        Assert.assertTrue(actions.isElementDisplayed(alertsPage.alertsGridPaginationNextPage));

        //click new alert button
        actions.clickElement(alertsPage.newAlertBtn);

        //test that user is redirected to new alert creation page
        Assert.assertEquals(MainTestRunner.ChromeDriver.getCurrentUrl(), EnvironmentSelector.NewAlertUrl);

        //test that recipe dropdown title div has the title , red asterisk for required & info icon
        Assert.assertEquals(actions.getElementChildren(alertsPage.newAlertRecipeDropdownTitle).size(),3);

        //insert alert details1
        //alert name
        createdAlert="Alert_"+MainTestRunner.formatter.format(new Date());
        actions.enterText(alertsPage.newAlertName,createdAlert);

        //test no instrument dropdown is disabled before choosing an affiliate
        Assert.assertFalse(actions.isElementEnabled(alertsPage.newAlertInstrument));

        //affiliate
        actions.chooseFromDropDown(alertsPage.newAlertAffiliate,"sub1");

        //recipe
        Thread.sleep(2000);
        actions.chooseFromDropDown(alertsPage.newAlertRecipe,"Corn");

        //test that instrument dropdown is enabled after choosing an affiliate
        Assert.assertTrue(actions.isElementEnabled(alertsPage.newAlertInstrument));

        //instruments SNR
        actions.chooseFromDropDown(alertsPage.newAlertInstrument,"320");

        //alerts constraints
        //first parameter
        actions.chooseFromDropDown(alertsPage.newAlertFirstParameter,"Protein");

        System.out.println(actions.getText(alertsPage.newAlertConfigurations));
        System.out.println(actions.getText(alertsPage.newAlertFirstParameterMinValueInput));


        //clear min and max value
        //first parameter max value
        actions.clearText(alertsPage.newAlertFirstParameterMaxValue);

        //first parameter min value
        Thread.sleep(2000);
        System.out.println(actions.getText(alertsPage.newAlertFirstParameterMinValueLabel));
        actions.clearText(alertsPage.newAlertFirstParameterMinValueInput);

        //insert equal value
        actions.enterText(alertsPage.newAlertFirstParameterEqualValue,"10");

        //click add parameter button
        actions.clickElement(alertsPage.newAlertAddParameterBtn);

        //first parameter
        actions.chooseFromDropDown(alertsPage.newAlertSecondParameter,"Moisture");

        //clear min and max value
        //first parameter max value
        Thread.sleep(1000);
        System.out.println("Max Value: "+actions.getText(alertsPage.newAlertSecondParameterMaxValue));
        actions.clearText(alertsPage.newAlertSecondParameterMaxValue);

        //first parameter min value
        System.out.println(actions.getText(alertsPage.newAlertSecondParameterMinValue));
        actions.clearText(alertsPage.newAlertSecondParameterMinValue);

        //insert equal value
        actions.enterText(alertsPage.newAlertSecondParameterEqualValue,"10");

        //insert alert recipients
        actions.chooseFromDropDown(alertsPage.newAlertRecipients,"mohamed.khaled+support@si-ware.com");

        //click save alert
        actions.clickElement(alertsPage.newAlertSaveBtn);

        //test that alert appeared
        Assert.assertEquals(actions.getText(alertsPage.alertPageNotification),"Success\n" +"Alert created successfully!");

        //test that user id re-directed to alerts page
        Thread.sleep(2000);
        Assert.assertEquals(actions.getCurrentUrl(),EnvironmentSelector.AlertsUrl);

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
        actions.chooseFromDropDown(alertsPage.newAlertAffiliate,"sub1");

        //recipe
        actions.chooseFromDropDown(alertsPage.newAlertRecipe,"Corn");

        //instruments SNR
        actions.chooseFromDropDown(alertsPage.newAlertInstrument,"320");

        //alerts constraints
        //first parameter
        actions.chooseFromDropDown(alertsPage.newAlertFirstParameter,"Protein");

        Thread.sleep(2000);
        //clear min and max value
        //first parameter max value

        actions.sendKeys(alertsPage.newAlertFirstParameterMaxValue,new Keys[]{Keys.BACK_SPACE,Keys.BACK_SPACE});

        //first parameter min value
        actions.sendKeys(alertsPage.newAlertFirstParameterMinValueInput, new Keys[]{Keys.BACK_SPACE});

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

        //test that all filter inputs are visible
        Assert.assertTrue(actions.isElementDisplayed(alertsPage.filterNameInput));


        //click clear button
        actions.clickElement(alertsPage.clearFilterBtn);

        //click filter button
        actions.clickElement(alertsPage.filterBtn);

        //test that all elements of filter pop-up are available
        Assert.assertTrue(actions.getText(alertsPage.filterPopUp).contains("Name"));
        Assert.assertTrue(actions.getText(alertsPage.filterPopUp).contains("Affiliate"));
        Assert.assertTrue(actions.getText(alertsPage.filterPopUp).contains("Recipe"));
        Assert.assertTrue(actions.getText(alertsPage.filterPopUp).contains("Created at"));
        Assert.assertTrue(actions.getText(alertsPage.filterPopUp).contains("Status"));

        //test that recipe filter header div ahs two elements recipes and info icon
        Assert.assertEquals(actions.getElementChildren(alertsPage.recipeFilterHeader).size(),2);

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
        //refresh the browser (to reset scroll)
        actions.refreshWindow();

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
         actions.chooseFromDropDown(alertsPage.filterRecipeInput,"Corn");

        //click apply
        actions.clickElement(alertsPage.submitFilterBtn);

        //test that alert is created
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(alertsPage.firstAlertRecipe),"Corn");
    }

    @Test(priority = 2)
    public void filterByStatus() throws InterruptedException{
        //navigate to alerts page
        homePage.clickAlertsSidebarBtn();
        Thread.sleep(2000);

        //click filter button
        actions.clickElement(alertsPage.filterBtn);

        //click clear button
        Thread.sleep(1000);
        actions.clickElement(alertsPage.clearFilterBtn);

        //click filter button
        actions.clickElement(alertsPage.filterBtn);

        //insert status of alert
        actions.chooseFromDropDown(alertsPage.filterStatusInput,"Active");

        //click apply
        actions.clickElement(alertsPage.submitFilterBtn);

        //scroll table horizontal bar
        Thread.sleep(2000);
        actions.scrollToElementHorizontally(alertsPage.tableHorizontalScrollBar,500);

        //test that displayed alert is active
        Thread.sleep(3000);
        String status =actions.getText(alertsPage.firstAlertStatus);
        System.out.println(status);
        Assert.assertEquals(status,"ACTIVE");
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
        actions.chooseFromDropDown(alertsPage.filterAffiliateInput,"sub1");

        //click apply
        actions.clickElement(alertsPage.submitFilterBtn);

        //test that alert is created
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(alertsPage.firstAlertAffiliate),"Sub1");
    }

    @Test(priority = 3)
    public void editAlert() throws InterruptedException {
        //navigate to alerts page
        Thread.sleep(2000);
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

        actions.scrollToElementHorizontally(alertsPage.tableHorizontalScrollBar,500);

        actions.clickElement(alertsPage.firstAlertActionsBtn);

        //choose edit option
        actions.clickElement(alertsPage.editAlertOptionBtn);

        //test that user is redirected to edit page
        Thread.sleep(1000);
        Assert.assertEquals(MainTestRunner.ChromeDriver.getCurrentUrl(),EnvironmentSelector.EditAlertUrl);

        //test that all data of alert are populated before editing

        System.out.println(actions.getText(alertsPage.newAlertConfigurations));
        Assert.assertTrue(actions.getText(alertsPage.newAlertConfigurations).contains("Sub1"));
        Assert.assertTrue(actions.getText(alertsPage.newAlertConfigurations).contains("Corn"));
        Assert.assertTrue(actions.getText(alertsPage.newAlertConfigurations).contains("320FG103"));
        Assert.assertTrue(actions.getText(alertsPage.newAlertConfigurations).contains("Protein"));
        Assert.assertTrue(actions.getText(alertsPage.newAlertConfigurations).contains("Moisture"));
        Assert.assertTrue(actions.getText(alertsPage.newAlertConfigurations).contains("mohamed.khaled+support@si-ware.com"));

        //edit name
        createdAlert="Edit_Alert_"+MainTestRunner.formatter.format(new Date());
        System.out.println(actions.getText(alertsPage.newAlertName));
        actions.clearText(alertsPage.newAlertName);
        actions.enterText(alertsPage.newAlertName,createdAlert);

        //choose new affiliate
        actions.chooseFromDropDown(alertsPage.newAlertAffiliate,"Sub1");

        //choose new recipe
        actions.chooseFromDropDown(alertsPage.newAlertRecipe,"Milk");

        //choose instrument
        actions.chooseFromDropDown(alertsPage.newAlertInstrument,"416");

        //select parameter
        actions.chooseFromDropDown(alertsPage.newAlertFirstParameter,"Lactose");
        actions.enterText(alertsPage.newAlertFirstParameterMinValueInput,"10");

        //click save
        actions.clickElement(alertsPage.newAlertSaveBtn);

        //test that notification appears
        Assert.assertEquals(actions.getText(alertsPage.alertPageNotification),"Success\n" + "Alert updated successfully!");

        //verify it redirects user to listing page
        Thread.sleep(2000);
        Assert.assertEquals(MainTestRunner.ChromeDriver.getCurrentUrl(),EnvironmentSelector.AlertsUrl);

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

        //test that alert is edited
        Thread.sleep(3000);
        Assert.assertEquals(actions.getText(alertsPage.firstAlertAffiliate),"Sub1");
        Assert.assertEquals(actions.getText(alertsPage.firstAlertName),createdAlert);
        System.out.println(actions.getText(alertsPage.firstAlertRecipe));
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
        actions.scrollToElementHorizontally(alertsPage.tableHorizontalScrollBar,200);
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
        Thread.sleep(3000);
        Assert.assertEquals(actions.getText(alertsPage.firstAlertName),createdAlert);
    }

    @Test(priority = 4)
    public void deleteAlert() throws InterruptedException{
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

        //test that delete option is visible
        Assert.assertTrue(actions.isElementDisplayed(alertsPage.deleteAlertOptionBtn));

        //click delete option
        actions.clickElement(alertsPage.deleteAlertOptionBtn);

        //test that delete pop-up appears
        Assert.assertTrue(actions.getText(alertsPage.deleteConfirmationPopUp).contains("Are you sure that you want to delete selected alerts?" ));
        Assert.assertTrue(actions.getText(alertsPage.deleteConfirmationPopUp).contains( "If you delete these alerts, they will be disappeared from the system" ));

        //click cancel
        actions.clickElement(alertsPage.cancelDeleteBtn);

        //test that alert is not deleted
        Assert.assertEquals(actions.getText(alertsPage.firstAlertName),createdAlert);

        //click actions button
        Thread.sleep(2000);
        actions.clickElement(alertsPage.firstAlertActionsBtn);

        //click delete option
        actions.clickElement(alertsPage.deleteAlertOptionBtn);

        //confirm delete
        actions.clickElement(alertsPage.confirmAlertDialogBtn);

        //navigate to alerts page
        Thread.sleep(2000);
        homePage.clickAlertsSidebarBtn();

        //click filter button
        actions.clickElement(alertsPage.filterBtn);

        //click clear button
        actions.clickElement(alertsPage.clearFilterBtn);

        //click filter button
        actions.clickElement(alertsPage.filterBtn);

        //insert name of created alert
        actions.enterText(alertsPage.filterNameInput,createdAlert);

        //click apply filter
        actions.clickElement(alertsPage.submitFilterBtn);

        //test that the alert is not displayed
        Thread.sleep(2000);
        Assert.assertFalse(actions.isElementDisplayed(alertsPage.firstAlertName));
    }

    @Test(priority = 5)
    public void sortAlerts() throws InterruptedException {
        //refresh the browser (to reset scroll)
        actions.refreshWindow();

        //click filter
        actions.clickElement(alertsPage.filterBtn);

        //click clear
        Thread.sleep(2000);
        actions.clickElement(alertsPage.clearFilterBtn);

        Thread.sleep(2000);

        //click name column
        actions.clickElement(alertsPage.alertsNameColumnHeader);

        //remove default sorting (name ascending)
        actions.clickElement(alertsPage.sortAlertsByNameAscOption);
        Thread.sleep(2000);

        //click sort asc
        actions.clickElement(alertsPage.alertsNameColumnHeader);
        actions.clickElement(alertsPage.sortAlertsByNameAscOption);
        Thread.sleep(2000);

        System.out.println(actions.getText(alertsPage.firstAlertName).compareTo(actions.getText(alertsPage.secondAlertName)));
        Assert.assertTrue(actions.getText(alertsPage.firstAlertName).compareTo(actions.getText(alertsPage.secondAlertName))<=0);
        Thread.sleep(2000);

        //click name column
        actions.clickElement(alertsPage.alertsNameColumnHeader);

        //click desc
        actions.clickElement(alertsPage.sortAlertsByNameDescOption);
        Thread.sleep(2000);
        System.out.println(actions.getText(alertsPage.firstAlertName).compareTo(actions.getText(alertsPage.secondAlertName)));
        Assert.assertTrue(actions.getText(alertsPage.firstAlertName).compareTo(actions.getText(alertsPage.secondAlertName))>=0);

        //click name column
        actions.clickElement(alertsPage.alertsNameColumnHeader);

        //remove sorting (name desc)
        actions.clickElement(alertsPage.sortAlertsByNameDescOption);
        Thread.sleep(2000);

        //click created at column
        actions.clickElement(alertsPage.alertsCreatedAtColumnHeader);

        //choose ascending option
        actions.clickElement(alertsPage.sortAlertsByCreatedAtAscOption);

        System.out.println(actions.getText(alertsPage.firstAlertCreatedAt));

        Thread.sleep(2000);
        Date firstDate= new Date(actions.getText(alertsPage.firstAlertCreatedAt));
        Date secondDate= new Date(actions.getText(alertsPage.secondAlertCreatedAt));
        Assert.assertTrue(firstDate.compareTo(secondDate)<=0);

        System.out.println(firstDate);
        System.out.println(secondDate);

        //click created at column
        actions.clickElement(alertsPage.alertsCreatedAtColumnHeader);

        //choose descending option
        actions.clickElement(alertsPage.sortAlertsByCreatedAtDescOption);

        Thread.sleep(2000);

        firstDate= new Date(actions.getText(alertsPage.firstAlertCreatedAt));
        secondDate= new Date(actions.getText(alertsPage.secondAlertCreatedAt));

        System.out.println(firstDate);
        System.out.println(secondDate);
        Assert.assertTrue(firstDate.compareTo(secondDate)>=0);


    }

    @Test(priority = 6)
    public void ActivateAlerts() throws InterruptedException {

        //test that by default options button is disabled
        Assert.assertFalse(actions.isElementEnabled(alertsPage.optionsBtn));

        //select all alerts
        actions.clickElement(alertsPage.selectAllAlertsCheckbox);

        //test that options button is affected & becomes enabled
        int numOfAlerts=actions.getElementChildren(alertsPage.alertsGrid).size();
        Assert.assertTrue(actions.getText(alertsPage.optionsBtn).contains(""+numOfAlerts));
        Assert.assertTrue(actions.isElementEnabled(alertsPage.optionsBtn));

        //deselect all alerts
        actions.clickElement(alertsPage.selectAllAlertsCheckbox);

        //select first two alerts
        actions.clickElement(alertsPage.firstAlertCheckBox);
        actions.clickElement(alertsPage.secondAlertCheckBox);

        Assert.assertTrue(actions.getText(alertsPage.optionsBtn).contains("2"));

        //click options button
        actions.clickElement(alertsPage.optionsBtn);

        //choose deactivate option
        actions.clickElement(alertsPage.deactivateOption);

        //confirm deactivation
        actions.clickElement(alertsPage.confirmAlertDialogBtn);

        Assert.assertEquals(actions.getText(alertsPage.alertPageNotification),"Success\n" + "Alert deactivated successfully!");

        Thread.sleep(3000);

        //test that alerts become inactive
        Assert.assertEquals(actions.getText(alertsPage.firstAlertStatus),"INACTIVE");
        Assert.assertEquals(actions.getText(alertsPage.secondAlertStatus),"INACTIVE");

        //select first two alerts
        actions.clickElement(alertsPage.firstAlertCheckBox);
        actions.clickElement(alertsPage.secondAlertCheckBox);

        //click options button
        actions.clickElement(alertsPage.optionsBtn);

        //choose activate option
        actions.clickElement(alertsPage.activateOption);

        //confirm activation
        actions.clickElement(alertsPage.confirmAlertDialogBtn);

        //test that notification appears
        Assert.assertEquals(actions.getText(alertsPage.alertPageNotification),"Success\n" +
                "Alert activated successfully!");
        Thread.sleep(2000);

        Assert.assertEquals(actions.getText(alertsPage.firstAlertStatus),"ACTIVE");
        Assert.assertEquals(actions.getText(alertsPage.secondAlertStatus),"ACTIVE");

        //scroll table horizontal bar
        Thread.sleep(2000);
        actions.scrollToElementHorizontally(alertsPage.tableHorizontalScrollBar,500);

        //click actions button
        actions.clickElement(alertsPage.firstAlertActionsBtn);

        //test that deactivate options available
        Assert.assertTrue(actions.isElementDisplayed(alertsPage.dropDownMenuDeactivate));

        //click deactivate option
        actions.clickElement(alertsPage.dropDownMenuDeactivate);

        //confirm deactivation
        actions.clickElement(alertsPage.confirmAlertDialogBtn);

        Assert.assertEquals(actions.getText(alertsPage.alertPageNotification),"Success\n" +
                "Alert deactivated successfully!");

        //test that alert is deactivated
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(alertsPage.firstAlertStatus),"INACTIVE");

        Thread.sleep(2000);

        //click actions button
        actions.clickElement(alertsPage.firstAlertActionsBtn);

        //test that activate options available
        Assert.assertTrue(actions.isElementDisplayed(alertsPage.dropDownMenuActivate));

        //click activate option
        actions.clickElement(alertsPage.dropDownMenuActivate);

        //confirm activation
        actions.clickElement(alertsPage.confirmAlertDialogBtn);

        //test that notification appears
        Assert.assertEquals(actions.getText(alertsPage.alertPageNotification),"Success\n" +
                "Alert activated successfully!");
        //test that alert is activated
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(alertsPage.firstAlertStatus),"ACTIVE");
    }

    @Test(priority = 7)
    public void multipleAlertDeletion() throws InterruptedException {

        String firstAlert="Alert A";
        String secondAlert="Alert B";

        int maxValue = (int)(Math.random()*100) +1;
        int minValue= (int)(Math.random()*100) +1;

        while(maxValue<=minValue){
            maxValue = (int)(Math.random()*100) +1;
            minValue= (int)(Math.random()*100) +1;
        }

        //create two alerts
        createAlertHelper(String.valueOf(minValue),String.valueOf(maxValue+1),firstAlert);

        maxValue = (int)(Math.random()*100) +1;
        minValue= (int)(Math.random()*100) +1;

        while(maxValue<=minValue){
            maxValue = (int)(Math.random()*100) +1;
            minValue= (int)(Math.random()*100) +1;
        }
        createAlertHelper(String.valueOf(minValue),String.valueOf(maxValue),secondAlert);

        Thread.sleep(2000);
        //select first two alerts
        actions.clickElement(alertsPage.firstAlertCheckBox);
        actions.clickElement(alertsPage.secondAlertCheckBox);

        //click options button
        actions.clickElement(alertsPage.optionsBtn);

        //choose delete option
        actions.clickElement(alertsPage.deleteOption);

        //confirm delete
        actions.clickElement(alertsPage.confirmAlertDialogBtn);

        //filter for first alert & test it is not found
        //click filter button
        actions.clickElement(alertsPage.filterBtn);

        //insert name of created alert
        actions.enterText(alertsPage.filterNameInput,firstAlert);

        //click apply
        actions.clickElement(alertsPage.submitFilterBtn);

        //test that alert is not found
        Thread.sleep(2000);
        Assert.assertFalse(actions.isElementDisplayed(alertsPage.firstAlertName));

        //click filter button
        actions.clickElement(alertsPage.filterBtn);

        //insert name of created alert
        Thread.sleep(2000);
        actions.clearText(alertsPage.filterNameInput);
        actions.enterText(alertsPage.filterNameInput,secondAlert);

        //click apply
        actions.clickElement(alertsPage.submitFilterBtn);

        //test that alert is not found
        Thread.sleep(2000);
        Assert.assertFalse(actions.isElementDisplayed(alertsPage.firstAlertName));
    }

    @Test(priority = 8)
    public void accessAsPartnerAdmin() throws InterruptedException {
        actions.clickElement(homePage.profileIconBtn);
        actions.clickElement(homePage.signoutBtn);

        Helpers.loginWithValidUser((ChromeDriver) MainTestRunner.ChromeDriver, Credentials.partnerAdminUsername, Credentials.partnerAdminPassword);

        //navigate to alerts page
        actions.clickElement(homePage.alertsSidebarBtn);

        int maxValue = (int)(Math.random()*100) +1;
        int minValue= (int)(Math.random()*100) +1;

        while(maxValue<=minValue){
            maxValue = (int)(Math.random()*100) +1;
            minValue= (int)(Math.random()*100) +1;
        }

        //create an alert as a partner-admin
        createAlertHelper(String.valueOf(minValue),String.valueOf(minValue+1));

        maxValue = (int)(Math.random()*100) +1;

        //edit alert
        editAlertHelper(String.valueOf(maxValue));

        //scroll table horizontal bar
        Thread.sleep(2000);
        actions.scrollToElementHorizontally(alertsPage.tableHorizontalScrollBar,500);

        //click actions button
        actions.clickElement(alertsPage.firstAlertActionsBtn);

        //test that deactivate options available
        Assert.assertTrue(actions.isElementDisplayed(alertsPage.dropDownMenuDeactivate));

        //click deactivate option
        actions.clickElement(alertsPage.dropDownMenuDeactivate);

        //confirm deactivation
        actions.clickElement(alertsPage.confirmAlertDialogBtn);

        Assert.assertEquals(actions.getText(alertsPage.alertPageNotification),"Success\n" +
                "Alert deactivated successfully!");

        //test that alert is deactivated
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(alertsPage.firstAlertStatus),"INACTIVE");

        Thread.sleep(2000);

        //click actions button
        actions.clickElement(alertsPage.firstAlertActionsBtn);

        //test that activate options available
        Assert.assertTrue(actions.isElementDisplayed(alertsPage.dropDownMenuActivate));

        //click activate option
        actions.clickElement(alertsPage.dropDownMenuActivate);

        //confirm activation
        actions.clickElement(alertsPage.confirmAlertDialogBtn);

        //test that notification appears
        Assert.assertEquals(actions.getText(alertsPage.alertPageNotification),"Success\n" +
                "Alert activated successfully!");

        //test that alert is activated
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(alertsPage.firstAlertStatus),"ACTIVE");

        Thread.sleep(2000);

        //click actions button
        Thread.sleep(2000);
        actions.clickElement(alertsPage.firstAlertActionsBtn);

        //test that delete option is visible
        Assert.assertTrue(actions.isElementDisplayed(alertsPage.deleteAlertOptionBtn));

        //click delete option
        actions.clickElement(alertsPage.deleteAlertOptionBtn);

        //test that delete pop-up appears
        Assert.assertTrue(actions.getText(alertsPage.deleteConfirmationPopUp).contains("Are you sure that you want to delete selected alerts?" ));
        Assert.assertTrue(actions.getText(alertsPage.deleteConfirmationPopUp).contains( "If you delete these alerts, they will be disappeared from the system" ));

        //click cancel
        actions.clickElement(alertsPage.cancelDeleteBtn);

        //test that alert is not deleted
        Assert.assertEquals(actions.getText(alertsPage.firstAlertName),createdAlert);

        //click actions button
        Thread.sleep(2000);
        actions.clickElement(alertsPage.firstAlertActionsBtn);

        //click delete option
        actions.clickElement(alertsPage.deleteAlertOptionBtn);

        //confirm delete
        actions.clickElement(alertsPage.confirmAlertDialogBtn);

        //navigate to alerts page
        Thread.sleep(2000);
        homePage.clickAlertsSidebarBtn();

        //click filter button
        actions.clickElement(alertsPage.filterBtn);

        //click clear button
        actions.clickElement(alertsPage.clearFilterBtn);

        //click filter button
        actions.clickElement(alertsPage.filterBtn);

        //insert name of created alert
        actions.enterText(alertsPage.filterNameInput,createdAlert);

        //click apply filter
        actions.clickElement(alertsPage.submitFilterBtn);

        //test that the alert is not displayed
        Thread.sleep(2000);
        Assert.assertFalse(actions.isElementDisplayed(alertsPage.firstAlertName));
    }

    @Test(priority = 9)
    public void accessAsAdmin() throws InterruptedException{
        actions.clickElement(homePage.profileIconBtn);
        actions.clickElement(homePage.signoutBtn);

        Helpers.loginWithValidUser((ChromeDriver) MainTestRunner.ChromeDriver, Credentials.adminUsername, Credentials.adminPassword);

        //navigate to alerts page
        actions.clickElement(homePage.alertsSidebarBtn);

        int maxValue = (int)(Math.random()*100) +1;
        int minValue= (int)(Math.random()*100) +1;

        while(maxValue<=minValue){
            maxValue = (int)(Math.random()*100) +1;
            minValue= (int)(Math.random()*100) +1;
        }

        //click new alert button
        actions.clickElement(alertsPage.newAlertBtn);

        //create an alert as an admin
        //insert alert details1
        //alert name
        createdAlert="Alert_"+MainTestRunner.formatter.format(new Date());
        actions.enterText(alertsPage.newAlertName,createdAlert);

        //recipe
        Thread.sleep(2000);
        actions.chooseFromDropDown(alertsPage.newAlertAffiliate,"Corn");

        //instruments SNR
        actions.chooseFromDropDown(alertsPage.newAlertRecipe,"320FG103");

        //alerts constraints
        //first parameter
        actions.chooseFromDropDown(alertsPage.newAlertFirstParameter,"Protein");

        //clear min and max value
        //first parameter max value
        actions.clearText(alertsPage.newAlertFirstParameterMaxValue);

        //first parameter min value
        Thread.sleep(2000);
        actions.clearText(alertsPage.newAlertFirstParameterMinValueInput);

        //insert equal value
        actions.enterText(alertsPage.newAlertFirstParameterMinValueInput,String.valueOf(minValue));

        //click add parameter button
        actions.clickElement(alertsPage.newAlertAddParameterBtn);

        //first parameter
        actions.chooseFromDropDown(alertsPage.newAlertSecondParameter,"Moisture");

        //clear min and max value
        //first parameter max value
        Thread.sleep(1000);
        actions.clearText(alertsPage.newAlertSecondParameterMaxValue);

        //first parameter min value
        actions.clearText(alertsPage.newAlertSecondParameterMinValue);

        //insert max value
        actions.enterText(alertsPage.newAlertSecondParameterMaxValue,String.valueOf(maxValue));

        //insert alert recipients
        actions.chooseFromDropDown(alertsPage.newAlertRecipients,"mohamed.khaled+support@si-ware.com");

        //click save alert
        actions.clickElement(alertsPage.newAlertSaveBtn);

        //test that alert appeared
        Assert.assertEquals(actions.getText(alertsPage.alertPageNotification),"Success\n" +"Alert created successfully!");

        //test that user id re-directed to alerts page
        Thread.sleep(2000);
        Assert.assertEquals(actions.getCurrentUrl(),EnvironmentSelector.AlertsUrl);

        //filter for alert
        actions.clickElement(alertsPage.filterBtn);

        //insert name of created alert
        actions.enterText(alertsPage.filterNameInput,createdAlert);

        //click apply
        actions.clickElement(alertsPage.submitFilterBtn);

        //test that alert is created
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(alertsPage.firstAlertName),createdAlert);

        int firstRandomNum= (int)(Math.random()*100) +1;

        //edit alert
        //click actions button
        Thread.sleep(2000);

        actions.scrollToElementHorizontally(alertsPage.tableHorizontalScrollBar,500);
        actions.clickElement(alertsPage.firstAlertActionsBtn);

        //choose edit option
        actions.clickElement(alertsPage.editAlertOptionBtn);

        //test that user is redirected to edit page
        Thread.sleep(1000);
        Assert.assertEquals(MainTestRunner.ChromeDriver.getCurrentUrl(),EnvironmentSelector.EditAlertUrl);

        //edit name
        createdAlert="Edit_Alert_"+MainTestRunner.formatter.format(new Date());
        System.out.println(actions.getText(alertsPage.newAlertName));
        actions.clearText(alertsPage.newAlertName);
        actions.enterText(alertsPage.newAlertName,createdAlert);


        //choose new recipe
        actions.chooseFromDropDown(alertsPage.newAlertAffiliate,"Milk");

        //choose instrument
        actions.chooseFromDropDown(alertsPage.newAlertRecipe,"416");

        //select parameter
        actions.chooseFromDropDown(alertsPage.newAlertFirstParameter,"Fat");
        actions.enterText(alertsPage.newAlertFirstParameterMinValueInput,String.valueOf(firstRandomNum));

        //click save
        actions.clickElement(alertsPage.newAlertSaveBtn);

        //test that notification appears
        Assert.assertEquals(actions.getText(alertsPage.alertPageNotification),"Success\n" + "Alert updated successfully!");

        //verify it redirects user to listing page
        Thread.sleep(2000);
        Assert.assertEquals(MainTestRunner.ChromeDriver.getCurrentUrl(),EnvironmentSelector.AlertsUrl);

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

        //test that alert is edited
        Thread.sleep(3000);
        Assert.assertEquals(actions.getText(alertsPage.firstAlertName),createdAlert);
        System.out.println(actions.getText(alertsPage.firstAlertRecipe));

        //scroll table horizontal bar
        Thread.sleep(2000);
        actions.scrollToElementHorizontally(alertsPage.tableHorizontalScrollBar,500);

        //click actions button
        actions.clickElement(alertsPage.firstAlertActionsBtn);

        //test that deactivate options available
        Assert.assertTrue(actions.isElementDisplayed(alertsPage.dropDownMenuDeactivate));

        //click deactivate option
        actions.clickElement(alertsPage.dropDownMenuDeactivate);

        //confirm deactivation
        actions.clickElement(alertsPage.confirmAlertDialogBtn);

        Assert.assertEquals(actions.getText(alertsPage.alertPageNotification),"Success\n" +
                "Alert deactivated successfully!");

        //test that alert is deactivated
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(alertsPage.firstAlertStatusAdmin),"INACTIVE");

        Thread.sleep(2000);

        //click actions button
        actions.clickElement(alertsPage.firstAlertActionsBtn);

        //test that activate options available
        Assert.assertTrue(actions.isElementDisplayed(alertsPage.dropDownMenuActivate));

        //click activate option
        actions.clickElement(alertsPage.dropDownMenuActivate);

        //confirm activation
        actions.clickElement(alertsPage.confirmAlertDialogBtn);

        //test that notification appears
        Assert.assertEquals(actions.getText(alertsPage.alertPageNotification),"Success\n" +
                "Alert activated successfully!");
        //test that alert is activated
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(alertsPage.firstAlertStatusAdmin),"ACTIVE");

        Thread.sleep(2000);
        //click actions button
        Thread.sleep(2000);
        actions.clickElement(alertsPage.firstAlertActionsBtn);

        //test that delete option is visible
        Assert.assertTrue(actions.isElementDisplayed(alertsPage.deleteAlertOptionBtn));

        //click delete option
        actions.clickElement(alertsPage.deleteAlertOptionBtn);

        //test that delete pop-up appears
        Assert.assertTrue(actions.getText(alertsPage.deleteConfirmationPopUp).contains("Are you sure that you want to delete selected alerts?" ));
        Assert.assertTrue(actions.getText(alertsPage.deleteConfirmationPopUp).contains( "If you delete these alerts, they will be disappeared from the system" ));

        //click cancel
        actions.clickElement(alertsPage.cancelDeleteBtn);

        //test that alert is not deleted
        Assert.assertEquals(actions.getText(alertsPage.firstAlertName),createdAlert);

        //click actions button
        Thread.sleep(2000);
        actions.clickElement(alertsPage.firstAlertActionsBtn);

        //click delete option
        actions.clickElement(alertsPage.deleteAlertOptionBtn);

        //confirm delete
        actions.clickElement(alertsPage.confirmAlertDialogBtn);

        //navigate to alerts page
        Thread.sleep(2000);
        homePage.clickAlertsSidebarBtn();

        //click filter button
        actions.clickElement(alertsPage.filterBtn);

        //click clear button
        actions.clickElement(alertsPage.clearFilterBtn);

        //click filter button
        actions.clickElement(alertsPage.filterBtn);

        //insert name of created alert
        actions.enterText(alertsPage.filterNameInput,createdAlert);

        //click apply filter
        actions.clickElement(alertsPage.submitFilterBtn);

        //test that the alert is not displayed
        Thread.sleep(2000);
        Assert.assertFalse(actions.isElementDisplayed(alertsPage.firstAlertName));
    }

    @Test(priority = 9)
    public void accessAsUser() throws InterruptedException{
        actions.clickElement(homePage.profileIconBtn);
        actions.clickElement(homePage.signoutBtn);

        Helpers.loginWithValidUser((ChromeDriver) MainTestRunner.ChromeDriver, Credentials.userName, Credentials.userPassword);

        //navigate to alerts page
        actions.clickElement(homePage.alertsSidebarBtn);

        int maxValue = (int)(Math.random()*100) +1;
        int minValue= (int)(Math.random()*100) +1;

        while(maxValue<=minValue){
            maxValue = (int)(Math.random()*100) +1;
            minValue= (int)(Math.random()*100) +1;
        }

        //click new alert button
        //test that user cannot create an alert
        Assert.assertFalse(actions.isElementDisplayed(alertsPage.newAlertBtn));

        //test that edit option is not available
        Assert.assertFalse(actions.isElementDisplayed(alertsPage.editAlertOptionBtn));
    }

    public void createAlertHelper(String minVal,String maxVal) throws InterruptedException{

        //click new alert button
        actions.clickElement(alertsPage.newAlertBtn);

        //test that user is redirected to new alert creation page
        Assert.assertEquals(MainTestRunner.ChromeDriver.getCurrentUrl(), EnvironmentSelector.NewAlertUrl);

        //insert alert details1
        //alert name
        createdAlert="Alert_"+MainTestRunner.formatter.format(new Date());
        actions.enterText(alertsPage.newAlertName,createdAlert);

        //affiliate
        actions.chooseFromDropDown(alertsPage.newAlertAffiliate,"sub1");

        //recipe
        Thread.sleep(2000);
        actions.chooseFromDropDown(alertsPage.newAlertRecipe,"Corn");

        //instruments SNR
        actions.chooseFromDropDown(alertsPage.newAlertInstrument,"320FG103");

        //alerts constraints
        //first parameter
        actions.chooseFromDropDown(alertsPage.newAlertFirstParameter,"Protein");

        //clear min and max value
        //first parameter max value
        actions.clearText(alertsPage.newAlertFirstParameterMaxValue);

        //first parameter min value
        Thread.sleep(2000);
        actions.clearText(alertsPage.newAlertFirstParameterMinValueInput);

        //insert equal value
        actions.enterText(alertsPage.newAlertFirstParameterMinValueInput,minVal);

        //click add parameter button
        actions.clickElement(alertsPage.newAlertAddParameterBtn);

        //first parameter
        actions.chooseFromDropDown(alertsPage.newAlertSecondParameter,"Moisture");

        //clear min and max value
        //first parameter max value
        Thread.sleep(1000);
        actions.clearText(alertsPage.newAlertSecondParameterMaxValue);

        //first parameter min value
        actions.clearText(alertsPage.newAlertSecondParameterMinValue);

        //insert max value
        actions.enterText(alertsPage.newAlertSecondParameterMaxValue,maxVal);

        //insert alert recipients
        actions.chooseFromDropDown(alertsPage.newAlertRecipients,"mohamed.khaled+support@si-ware.com");

        //click save alert
        actions.clickElement(alertsPage.newAlertSaveBtn);

        //test that alert appeared
        Assert.assertEquals(actions.getText(alertsPage.alertPageNotification),"Success\n" +"Alert created successfully!");

        //test that user id re-directed to alerts page
        Thread.sleep(2000);
        Assert.assertEquals(actions.getCurrentUrl(),EnvironmentSelector.AlertsUrl);

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

    public void editAlertHelper(String minVal) throws InterruptedException{
        //click actions button
        Thread.sleep(2000);

        actions.scrollToElementHorizontally(alertsPage.tableHorizontalScrollBar,500);
        actions.clickElement(alertsPage.firstAlertActionsBtn);

        //choose edit option
        actions.clickElement(alertsPage.editAlertOptionBtn);

        //test that user is redirected to edit page
        Thread.sleep(1000);
        Assert.assertEquals(MainTestRunner.ChromeDriver.getCurrentUrl(),EnvironmentSelector.EditAlertUrl);

        //edit name
        createdAlert="Edit_Alert_"+MainTestRunner.formatter.format(new Date());
        System.out.println(actions.getText(alertsPage.newAlertName));
        actions.clearText(alertsPage.newAlertName);
        actions.enterText(alertsPage.newAlertName,createdAlert);

        //choose new affiliate
        actions.chooseFromDropDown(alertsPage.newAlertAffiliate,"Sub1");

        //choose new recipe
        actions.chooseFromDropDown(alertsPage.newAlertRecipe,"Rice");

        //choose instrument
        actions.chooseFromDropDown(alertsPage.newAlertInstrument,"720");

        //select parameter
        actions.chooseFromDropDown(alertsPage.newAlertFirstParameter,"Carb");
        actions.enterText(alertsPage.newAlertFirstParameterMinValueInput,minVal);

        //click save
        actions.clickElement(alertsPage.newAlertSaveBtn);

        //test that notification appears
        Assert.assertEquals(actions.getText(alertsPage.alertPageNotification),"Success\n" + "Alert updated successfully!");

        //verify it redirects user to listing page
        Thread.sleep(2000);
        Assert.assertEquals(MainTestRunner.ChromeDriver.getCurrentUrl(),EnvironmentSelector.AlertsUrl);

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

        //test that alert is edited
        Thread.sleep(3000);
        Assert.assertEquals(actions.getText(alertsPage.firstAlertAffiliate),"Sub1");
        Assert.assertEquals(actions.getText(alertsPage.firstAlertName),createdAlert);
        System.out.println(actions.getText(alertsPage.firstAlertRecipe));

    }

    public void createAlertHelper(String minVal,String maxVal,String alertName) throws InterruptedException{

        //click new alert button
        actions.clickElement(alertsPage.newAlertBtn);

        //test that user is redirected to new alert creation page
        Assert.assertEquals(MainTestRunner.ChromeDriver.getCurrentUrl(), EnvironmentSelector.NewAlertUrl);


        //insert alert details1
        actions.enterText(alertsPage.newAlertName,alertName);

        //affiliate
        actions.chooseFromDropDown(alertsPage.newAlertAffiliate,"sub1");

        //recipe
        Thread.sleep(2000);
        actions.chooseFromDropDown(alertsPage.newAlertRecipe,"Corn");

        //instruments SNR
        actions.chooseFromDropDown(alertsPage.newAlertInstrument,"320");

        //alerts constraints
        //first parameter
        actions.chooseFromDropDown(alertsPage.newAlertFirstParameter,"Protein");

        //clear min and max value
        //first parameter max value
        actions.clearText(alertsPage.newAlertFirstParameterMaxValue);

        //first parameter min value
        Thread.sleep(2000);
        actions.clearText(alertsPage.newAlertFirstParameterMinValueInput);

        //insert equal value
        actions.enterText(alertsPage.newAlertFirstParameterMinValueInput,minVal);

        //click add parameter button
        actions.clickElement(alertsPage.newAlertAddParameterBtn);

        //first parameter
        actions.chooseFromDropDown(alertsPage.newAlertSecondParameter,"Moisture");

        //clear min and max value
        //first parameter max value
        Thread.sleep(1000);
        actions.clearText(alertsPage.newAlertSecondParameterMaxValue);

        //first parameter min value
        actions.clearText(alertsPage.newAlertSecondParameterMinValue);

        //insert max value
        actions.enterText(alertsPage.newAlertSecondParameterMaxValue,maxVal);

        //insert alert recipients
        actions.chooseFromDropDown(alertsPage.newAlertRecipients,"mohamed.khaled+support@si-ware.com");

        //click save alert
        actions.clickElement(alertsPage.newAlertSaveBtn);
    }

}
