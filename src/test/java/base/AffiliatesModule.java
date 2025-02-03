package base;

import data.Credentials;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.Actions;
import pages.AffiliatePage;
import pages.HomePage;
import pages.UsersPage;
import utils.Helpers;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;


public class AffiliatesModule {
    HomePage homePage;
    AffiliatePage affiliatePage;
    String affiliateName;

    Actions actions;

    @Test(priority = 0)
    public void intializeClasses(){
        homePage = new HomePage((ChromeDriver) MainTestRunner.ChromeDriver);
        affiliatePage = new AffiliatePage((ChromeDriver) MainTestRunner.ChromeDriver);
        actions = new Actions((ChromeDriver) MainTestRunner.ChromeDriver,20);
    }

    @Test(priority = 1)
    public void createInvalidAffilateBySupport() {


        //navigate to affiliates page
        homePage.clickAffiliateSidebarBtn();

        //click add affiliate button
        affiliatePage.addAffiliateBtnIsDisplayed();
        affiliatePage.clickAddAffiliateBtn();

        //click save without adding any data
        affiliatePage.clickSaveAffiliateBtn();

        //test that error messages appear under required fields
        Assert.assertEquals(affiliatePage.getAffiliateRequiredErrorMsg(), "Name is required.");
        Assert.assertEquals(affiliatePage.getTypeRequiredErrorMsg(), "Type is required.");
        Assert.assertEquals(affiliatePage.getMaxUsersRequiredErrorMsg(), "Maxusers is required.");


        //insert affiliate name more than 30 characters
        affiliatePage.sendTextToAffiliateNameTextField("222222222222222222222222222222222222222222222222222222222222222222");
        Assert.assertEquals(affiliatePage.getAffiliateRequiredErrorMsg(), "Name is too long. it must be no more than 30 characters long.");

        //insert max users less than 1
        affiliatePage.sendTextToAffiliateMaxUsersTextField("0");
        Assert.assertEquals(affiliatePage.getMaxUsersRequiredErrorMsg(), "Invalid value: Expected >=1 but received 0");

        //click cancel
        affiliatePage.clickCancelBtn();
    }

    @Test(priority = 1)
    public void createAffiliateBySupport() throws InterruptedException {
        homePage = new HomePage((ChromeDriver) MainTestRunner.ChromeDriver);
        affiliatePage = new AffiliatePage((ChromeDriver) MainTestRunner.ChromeDriver);

        Thread.sleep(1500);
        //navigate to affiliates page
        Thread.sleep(4000);
        homePage.clickAffiliateSidebarBtn();
        homePage.clickAffiliateSidebarBtn();

        //click add affiliate button
        Thread.sleep(1000);
        affiliatePage.addAffiliateBtnIsDisplayed();
        affiliatePage.clickAddAffiliateBtn();

        //insert affiliate name
        Thread.sleep(2000);
        affiliateName = ("Affiliate_" + (MainTestRunner.date)).substring(0, 29);
        affiliatePage.sendTextToAffiliateNameTextField(affiliateName);

        //insert max user
        affiliatePage.sendTextToAffiliateMaxUsersTextField("20");

        //choose affiliate type
        affiliatePage.sendTextToAffiliateTypeTextField("Farm");

        //insert abbreviation
        affiliatePage.sendTextToAffiliateAbbreviationTextField(Helpers.generateRandomString());

        //click save
        affiliatePage.clickSaveAffiliateBtn();

        //click filter
        Thread.sleep(2000);
        affiliatePage.clickFilterBtn();

        //insert affiliate name
        affiliatePage.sendTextToFilterAffiliateNameTextField(affiliateName);

        //click apply filter
        affiliatePage.clickFilterApplyBtn();

        //test that affiliate appears
        Thread.sleep(4000);
        Assert.assertEquals(actions.getText(affiliatePage.firstAffiliateName), affiliateName);
    }

    @Test(priority = 1 ,dependsOnMethods = "createAffiliateBySupport")
    public void generateLicense () throws InterruptedException {
        //clear any preset filter
        //click filter
        affiliatePage.clickFilterBtn();

        //click clear
        affiliatePage.clickFilterClearBtn();

        //filter for created affiliate
        affiliatePage.clickFilterBtn();

        //insert affiliate name
        affiliatePage.sendTextToFilterAffiliateNameTextField(affiliateName);

        //click apply filter
        affiliatePage.clickFilterApplyBtn();

        //test that affiliate appears
        Thread.sleep(3000);

        //click options
        actions.scrollToElementHorizontally(affiliatePage.tableHorizontalScrollBar, (ChromeDriver) MainTestRunner.ChromeDriver);
        affiliatePage.clickFirstAffiliateOptionsBtn();

        //test text is "Generate license"
        Assert.assertEquals(actions.getText(affiliatePage.affiliateGenerateLicenseBtn),"Generate license");

        //click generate license option
        actions.clickElement(affiliatePage.affiliateGenerateLicenseBtn);

        //test that confirmation dialog box appears
        Assert.assertTrue(actions.isElementDisplayed(affiliatePage.confirmLicenseGenerateBtn));

        //click cancel button of popup
        actions.clickElement(affiliatePage.cancelLicenseGenerateBtn);

        //test that generate license still appears
        affiliatePage.clickFirstAffiliateOptionsBtn();

        //test text is "Generate license"
        Assert.assertEquals(actions.getText(affiliatePage.affiliateGenerateLicenseBtn),"Generate license");

        //click generate license option
        actions.clickElement(affiliatePage.affiliateGenerateLicenseBtn);

        //test that confirmation dialog box appears
        Assert.assertTrue(actions.isElementDisplayed(affiliatePage.confirmLicenseGenerateBtn));





        //confirm license generation
        actions.clickElement(affiliatePage.confirmLicenseGenerateBtn);

        //click options button
        Thread.sleep(2000);
        actions.clickElement(affiliatePage.firstAffiliateOptionsBtn);

        //test that text is "View license"
        Assert.assertEquals(actions.getText(affiliatePage.affiliateViewLicenseOptionBtn),"View license");

        actions.clickElement(affiliatePage.affiliateViewLicenseOptionBtn);

        //copy affiliate license into clipboard
        actions.clickElement(affiliatePage.copyLicenseBtn);

        //test that affiliate license is copied into clipboard
        try{
            String clipboardText = (String) Toolkit.getDefaultToolkit()
                    .getSystemClipboard()
                    .getData(DataFlavor.stringFlavor);
            Assert.assertTrue(clipboardText.contains("sync"));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        //click cancel
        actions.clickElement(affiliatePage.cancelLicenseCopyBtn);
    }
    @Test(priority = 2)
    public void cancelAffiliateEdits() throws InterruptedException {
        //clear any preset filter
        //click filter
        affiliatePage.clickFilterBtn();

        //click clear
        affiliatePage.clickFilterClearBtn();



        //filter for created affiliate
        affiliatePage.clickFilterBtn();

        //insert affiliate name
        affiliatePage.sendTextToFilterAffiliateNameTextField(affiliateName);

        //click apply filter
        affiliatePage.clickFilterApplyBtn();

        //test that affiliate appears
        Thread.sleep(3000);

        //click options
        affiliatePage.clickFirstAffiliateOptionsBtn();

        //click edit
        affiliatePage.clickFirstAffiliateEditBtn();

        //clear all affiliate details
        affiliatePage.clearMaxUsersTextField();
        affiliatePage.clearAbbreviation();

        //insert any dummy data

        //insert max user
        affiliatePage.sendTextToAffiliateMaxUsersTextField("25");

        //insert abbreviation
        affiliatePage.sendTextToAffiliateAbbreviationTextField(Helpers.generateRandomString());

        //click cancel
        affiliatePage.clickCancelBtn();

        //click filter
        affiliatePage.clickFilterBtn();

        //click clear
        affiliatePage.clickFilterClearBtn();


        //filter for created affiliate
        affiliatePage.clickFilterBtn();

        //insert affiliate name
        affiliatePage.sendTextToFilterAffiliateNameTextField(affiliateName);

        //click apply
        affiliatePage.clickFilterApplyBtn();

        //test that affiliate details didn't change
        Thread.sleep(3000);
        Assert.assertEquals(affiliatePage.getFirstAffiliateName(), affiliateName);

    }

    @Test(priority = 2)
    public void editAffiliate() throws InterruptedException {
        try {
            //clear any preset filter
            //click filter
            affiliatePage.clickFilterBtn();

            //click clear
            affiliatePage.clickFilterClearBtn();

            //filter for created affiliate
            affiliatePage.clickFilterBtn();

            //insert affiliate name
            affiliatePage.sendTextToFilterAffiliateNameTextField(affiliateName);

            //click apply
            affiliatePage.clickFilterApplyBtn();

            Thread.sleep(3000);
            //click actions
            affiliatePage.clickFirstAffiliateOptionsBtn();

            //click edit
            affiliatePage.clickFirstAffiliateEditBtn();

            //clear all affiliate details
            affiliatePage.clearMaxUsersTextField();
            affiliatePage.clearAbbreviation();

            //insert max users
            affiliatePage.sendTextToAffiliateMaxUsersTextField("30");

            //insert abbreviation
            affiliatePage.sendTextToAffiliateAbbreviationTextField(Helpers.generateRandomString());

            //click save
            affiliatePage.clickSaveAffiliateBtn();

            //click submit edits button
            affiliatePage.clickSubmitAffiliateBtn();

            //click filter
            Thread.sleep(2000);
            affiliatePage.clickFilterBtn();

            //click clear
            affiliatePage.clickFilterClearBtn();

            //insert affiliate name
            affiliatePage.sendTextToFilterAffiliateNameTextField(affiliateName);

            //click apply filter
            affiliatePage.clickFilterApplyBtn();

            //test that affiliate was edited and appears
            Thread.sleep(2000);
            Assert.assertEquals(affiliatePage.getFirstAffiliateName(), affiliateName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

        @Test(priority = 3)
        public void filterByAffiliateName () throws InterruptedException {
            //clear any preset filter
            //click filter
            affiliatePage.clickFilterBtn();

            //click clear
            affiliatePage.clickFilterClearBtn();

            //filter for created affiliate
            affiliatePage.clickFilterBtn();

            //insert affiliate name
            affiliatePage.sendTextToFilterAffiliateNameTextField(affiliateName);

            //click apply
            affiliatePage.clickFilterApplyBtn();

            //test that affiliate appears
            Thread.sleep(2000);
            Assert.assertEquals(affiliatePage.getFirstAffiliateName(), affiliateName);

        }

        @Test(priority = 3)
        public void filterByType () throws InterruptedException {
            //clear any preset filter
            //click filter
            affiliatePage.clickFilterBtn();

            //click clear
            affiliatePage.clickFilterClearBtn();

            //filter for created affiliate
            affiliatePage.clickFilterBtn();

            //insert affiliate type
            affiliatePage.sendTextToFilterAffiliateTypeTextField("Farm");

            //click apply
            affiliatePage.clickFilterApplyBtn();

            //test that affiliates that appear are of the filtered type
            Thread.sleep(3000);
            Assert.assertEquals(actions.getText(affiliatePage.firstAffiliateType), "Farm");


        }

        @Test(priority = 3)
        public void toggleColumns () throws InterruptedException {
            UsersPage usersPage = new UsersPage((ChromeDriver) MainTestRunner.ChromeDriver);
            usersPage.refreshWindow();

            //clear any preset filter
            Thread.sleep(2000);
            affiliatePage.clickFilterBtn();
            affiliatePage.clickFilterClearBtn();

            //click view
            Thread.sleep(2000);
            affiliatePage.clickViewBtn();
            usersPage.clickToggleCreatedAtColumn();

            //test that column is  not visible and the fifth column is created at
            Thread.sleep(4000);
            Assert.assertFalse(affiliatePage.isCreatedAtColumnDisplayed());
//
//            //click view to view  created at column again
//            Thread.sleep(2000);
//            affiliatePage.clickViewBtn();
//            usersPage.clickToggleCreatedAtColumn();

            //test that column is  visible and the fifth column is modified at
            Thread.sleep(2000);
            affiliatePage.clickViewBtn();
            usersPage.clickToggleModifiedAtColumn();

            Thread.sleep(2000);
            Assert.assertFalse(affiliatePage.isLastUpdatedAtColumnDisplayed());

            //hide both created at and modified at
            //click view
            Thread.sleep(2000);
            affiliatePage.clickViewBtn();
            usersPage.clickToggleModifiedAtColumn();

            //test that none of them is visible
            Assert.assertFalse(usersPage.isFifthColumnHeaderDisplayed());

        }

        @Test(priority = 3)
        @Ignore
        public void searchAffiliate () throws InterruptedException {
            //clear any preset filter
            //click filter
            affiliatePage.clickFilterBtn();

            //click clear
            affiliatePage.clickFilterClearBtn();

            //insert affiliate name
            affiliatePage.sendTextToSearchField(affiliateName);

            //click search btn to saarch
            affiliatePage.clickSearchBtn();

            //test that results apply
            Thread.sleep(2000);
            Assert.assertEquals(affiliatePage.getFirstAffiliateName(), affiliateName);

            //refresh window
            affiliatePage.refreshWindow();
            Thread.sleep(6000);
        }

        @Test(priority = 4)
        @Ignore
        public void deleteAffiliate ()throws InterruptedException {
            //clear any preset filter
            //click filter
            affiliatePage.clickFilterBtn();

            //click clear
            affiliatePage.clickFilterClearBtn();

            //filter for created affiliate
            Thread.sleep(2000);
            affiliatePage.clickFilterBtn();

            //insert affiliate name
            affiliatePage.sendTextToFilterAffiliateNameTextField(affiliateName);

            //click apply filter
            affiliatePage.clickFilterApplyBtn();

            //click options
            Thread.sleep(2000);
            affiliatePage.clickFirstAffiliateOptionsBtn();

        /*
        //click delete
        affiliatePage.clickFirstAffiliateDeleteBtn();

        //click cancel  delete button
        affiliatePage.clickCancelDeleteBtn();

        //test that affiliate not deleted
        Assert.assertEquals(affiliatePage.getFirstAffiliateName(),affiliateName);

        //click options
        affiliatePage.clickFirstAffiliateOptionsBtn();
*/
            //click delete
            affiliatePage.clickFirstAffiliateDeleteBtn();

            //click confirm delete
            affiliatePage.clickConfirmDeleteBtn();

            //click filter
            affiliatePage.clickFilterBtn();

            //click clear
            affiliatePage.clickFilterClearBtn();

            //filter for created affiliate
            affiliatePage.clickFilterBtn();

            //insert affiliate name
            affiliatePage.sendTextToFilterAffiliateNameTextField(affiliateName);

            //click apply filter
            affiliatePage.clickFilterApplyBtn();

            //test that affiliate is deleted
            Assert.assertFalse(affiliatePage.affiliateNameIsDisplayed());

        }

        @Test(priority = 4  /*,dependsOnMethods = "deleteAffiliate"*/)
        public void sortData () throws InterruptedException {
            //clear any preset filter
            //click filter
            affiliatePage.clickFilterBtn();

            //click clear
            affiliatePage.clickFilterClearBtn();


            //sort by name ascending
            affiliatePage.clickNameColumn();
            affiliatePage.clickSortNameAscOption();
            Thread.sleep(6000);

            //sort by name ascending (click again as it is default and ensure it is set)
            affiliatePage.clickNameColumn();
            affiliatePage.clickSortNameAscOption();
            Thread.sleep(3000);

            System.out.println(affiliatePage.getFirstAffiliateName());
            System.out.println(affiliatePage.getSecondAffiliateName());
            System.out.println(affiliatePage.getFirstAffiliateName().compareTo(affiliatePage.getSecondAffiliateName()));
            Assert.assertTrue(affiliatePage.getFirstAffiliateName().compareTo(affiliatePage.getSecondAffiliateName()) <= 0);

            //sort by name descending
            Thread.sleep(2000);
            affiliatePage.clickNameColumn();
            affiliatePage.clickSortNameDescOption();
            Thread.sleep(4000);
            System.out.println(affiliatePage.getFirstAffiliateName());
            System.out.println(affiliatePage.getSecondAffiliateName());
            System.out.println(affiliatePage.getFirstAffiliateName().compareTo(affiliatePage.getSecondAffiliateName()));
            Assert.assertTrue(affiliatePage.getFirstAffiliateName().compareTo(affiliatePage.getSecondAffiliateName()) >= 0);

            //clear name sorting
            affiliatePage.clickNameColumn();
            affiliatePage.clickSortNameDescOption();

            //sort by user count ascending
            Thread.sleep(2000);
            affiliatePage.clickActiveUsersColumn();
            affiliatePage.clickSortActiveUsersAscOption();
            Thread.sleep(3000);

            //try catch to handle if users count is -- and set its value to zero
            int num1, num2;
            try {

                num1 = Integer.parseInt(affiliatePage.getSecondAffiliateUserCount());
            } catch (NumberFormatException ex) {
                num1 = 0;
            }

            try {

                num2 = Integer.parseInt(affiliatePage.getSecondAffiliateUserCount());
            } catch (NumberFormatException ex) {
                num2 = 0;
            }

            Assert.assertTrue(num1 >= num2);

            //sort by user count descending
            Thread.sleep(3000);
            affiliatePage.clickActiveUsersColumn();
            affiliatePage.clickSortActiveUsersDescOption();

            //try catch to handle if users count is -- and set its value to zero
            try {

                num1 = Integer.parseInt(affiliatePage.getSecondAffiliateUserCount());
            } catch (NumberFormatException ex) {
                num1 = 0;
            }

            try {

                num2 = Integer.parseInt(affiliatePage.getSecondAffiliateUserCount());
            } catch (NumberFormatException ex) {
                num2 = 0;
            }

            Assert.assertTrue(num1 <= num2);
        }

        @Test(priority = 5)
        public void createAffiliateByAdmin () throws InterruptedException {
            //sign-out from support
            homePage.clickProfileIconBtn();
            homePage.clickSignoutBtn();

            //login with admin account
            Helpers.loginWithValidUser((ChromeDriver) MainTestRunner.ChromeDriver, Credentials.partnerAdminUsername, Credentials.partnerAdminPassword);

            //navigate to affiliates page
            Thread.sleep(6000);
            homePage.clickAffiliateSidebarBtn();

            //click add affiliate button
            Thread.sleep(4000);
            affiliatePage.clickAddAffiliateBtn();

            //insert affiliate name
            affiliateName = ("Affiliate_" + (MainTestRunner.date)).substring(0, 23) + Helpers.generateRandomString();
            affiliatePage.sendTextToAffiliateNameTextField(affiliateName);

            //insert max user
            affiliatePage.sendTextToAffiliateMaxUsersTextField("20");

            //choose affiliate type
            affiliatePage.sendTextToAffiliateTypeTextField("Farm");

            //insert abbreviation
            affiliatePage.sendTextToAffiliateAbbreviationTextField(Helpers.generateRandomString());

            //click save
            affiliatePage.clickSaveAffiliateBtn();

            //click filter
            Thread.sleep(2000);
            affiliatePage.clickFilterBtn();

            //insert affiliate name
            affiliatePage.sendTextToFilterAffiliateNameTextField(affiliateName);

            //click apply filter
            affiliatePage.clickFilterApplyBtn();

            //test that affiliate appears
            Thread.sleep(3000);
            Assert.assertEquals(affiliatePage.getFirstAffiliateName(), affiliateName);

            //click options
            actions.scrollToElementHorizontally(affiliatePage.tableHorizontalScrollBar, (ChromeDriver) MainTestRunner.ChromeDriver);
            affiliatePage.clickFirstAffiliateOptionsBtn();

            //test text is "Generate license"
            Assert.assertEquals(actions.getText(affiliatePage.affiliateGenerateLicenseBtn),"Generate license");


            //click generate license
            actions.clickElement(affiliatePage.affiliateGenerateLicenseBtn);

            //click cancel button
            actions.clickElement(affiliatePage.cancelLicenseGenerateBtn);
        }

        @Test(priority = 5)
        public void createAffiliateBySuperAdmin () throws InterruptedException {

            //sign-out from support

            homePage.clickProfileIconBtn();
            homePage.clickSignoutBtn();

            //login with admin account
            Helpers.loginWithValidUser((ChromeDriver) MainTestRunner.ChromeDriver, Credentials.superAdminUsername, Credentials.superAdminPassword);

            //navigate to affiliates page'
            Thread.sleep(5000);
            homePage.clickAffiliateSidebarBtn();

            //click add affiliate button
            affiliatePage.clickAddAffiliateBtn();

            //insert affiliate name
            affiliateName = ("Affiliate_" + (MainTestRunner.date)).substring(0, 22) + Helpers.generateRandomString();
            affiliatePage.sendTextToAffiliateNameTextField(affiliateName);

            //insert max user
            affiliatePage.sendTextToAffiliateMaxUsersTextField("20");

            //choose affiliate type
            affiliatePage.sendTextToAffiliateTypeTextField("Farm");

            //insert abbreviation
            affiliatePage.sendTextToAffiliateAbbreviationTextField(Helpers.generateRandomString());

            //click save
            Thread.sleep(2000);
            affiliatePage.clickSaveAffiliateBtn();

            //click filter
            Thread.sleep(2000);
            affiliatePage.clickFilterBtn();

            //insert affiliate name
            affiliatePage.sendTextToFilterAffiliateNameTextField(affiliateName);

            //click apply filter
            affiliatePage.clickFilterApplyBtn();

            //test that affiliate appears
            Thread.sleep(3000);
            Assert.assertEquals(affiliatePage.getFirstAffiliateName(), affiliateName);

            //click options
            actions.scrollToElementHorizontally(affiliatePage.tableHorizontalScrollBar, (ChromeDriver) MainTestRunner.ChromeDriver);
            affiliatePage.clickFirstAffiliateOptionsBtn();

            //test text is "Generate license"
            Assert.assertEquals(actions.getText(affiliatePage.affiliateGenerateLicenseBtn),"Generate license");

            //click generate license
            actions.clickElement(affiliatePage.affiliateGenerateLicenseBtn);

            //click cancel button
            actions.clickElement(affiliatePage.cancelLicenseGenerateBtn);
        }



        public void deleteAffiliate (String afiliateName) throws InterruptedException {

            //clear any preset filter
            //click filter
            affiliatePage.clickFilterBtn();

            //click clear
            affiliatePage.clickFilterClearBtn();

            //filter for created affiliate
            affiliatePage.clickFilterBtn();

            //insert affiliate name
            affiliatePage.sendTextToFilterAffiliateNameTextField(affiliateName);

            //click apply filter
            affiliatePage.clickFilterApplyBtn();

            //click options
            Thread.sleep(2000);
            affiliatePage.clickFirstAffiliateOptionsBtn();

            //click delete
            affiliatePage.clickFirstAffiliateDeleteBtn();

        /*
        //click cancel  delete button
        affiliatePage.clickCancelDeleteBtn();

        //test that affiliate not deleted
        Assert.assertEquals(affiliatePage.getFirstAffiliateName(), affiliateName);

        //click options
        affiliatePage.clickFirstAffiliateOptionsBtn();

        //click delete
        affiliatePage.clickFirstAffiliateDeleteBtn();
*/
        //click confirm delete
        affiliatePage.clickConfirmDeleteBtn();}


    }

