package base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
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

        //insert alert details
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
}
