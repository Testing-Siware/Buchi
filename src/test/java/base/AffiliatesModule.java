package base;

import data.Credentials;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.Actions;
import pages.AffiliatePage;
import pages.HomePage;
import utils.Helpers;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;


public class AffiliatesModule {
    HomePage homePage;
    AffiliatePage affiliatePage;
    String affiliateName;

    Actions actions;

    @BeforeClass
    public void intializeClasses(){
        homePage = new HomePage((ChromeDriver) MainTestRunner.ChromeDriver);
        affiliatePage = new AffiliatePage((ChromeDriver) MainTestRunner.ChromeDriver);
        actions = new Actions((ChromeDriver) MainTestRunner.ChromeDriver,20);
    }

    @Test(priority = 1)
    public void createInvalidAffilateBySupport() {
        //navigate to affiliates page
        actions.clickElement(homePage.affiliateSidebarBtn);

        //click add affiliate button
        actions.clickElement(affiliatePage.addAffiliateBtn);

        //click save without adding any data
        actions.clickElement(affiliatePage.saveBtn);

        //test that error messages appear under required fields
        Assert.assertEquals(actions.getText(affiliatePage.affiliateRequiredErrorMsg), "Name is required.");
        Assert.assertEquals(actions.getText(affiliatePage.typeRequiredErrorMsg), "Type is required.");
        Assert.assertEquals(actions.getText(affiliatePage.maxUsersRequiredErrorMsg), "Maxusers is required.");

        //insert affiliate name more than 30 characters
        actions.enterText(affiliatePage.affiliateName, "222222222222222222222222222222222222222222222222222222222222222222");
        Assert.assertEquals(actions.getText(affiliatePage.affiliateRequiredErrorMsg), "Name is too long. it must be no more than 30 characters long.");

        //insert max users less than 1
        actions.enterText(affiliatePage.maxUsers,"0");
        Assert.assertEquals(actions.getText(affiliatePage.maxUsersRequiredErrorMsg), "Invalid value: Expected >=1 but received 0");

        //click cancel
        actions.clickElement(affiliatePage.cancelBtn);
    }

    @Test(priority = 1)
    public void createAffiliateBySupport() throws InterruptedException {
        homePage = new HomePage((ChromeDriver) MainTestRunner.ChromeDriver);
        affiliatePage = new AffiliatePage((ChromeDriver) MainTestRunner.ChromeDriver);


        //navigate to affiliates page
        Thread.sleep(4000);
        actions.clickElement(homePage.affiliateSidebarBtn);

        //click add affiliate button
        Thread.sleep(1000);
        actions.clickElement(affiliatePage.addAffiliateBtn);

        //insert affiliate name
        Thread.sleep(2000);
        affiliateName = ("Affiliate_" + (MainTestRunner.date)).substring(0, 29);
        actions.enterText(affiliatePage.affiliateName,affiliateName);

        //insert max user
        actions.enterText(affiliatePage.maxUsers,"20");;
        

        //choose affiliate type
        actions.chooseFromDropDown(affiliatePage.affiliateType,"Farm");

        //insert abbreviation
        actions.enterText(affiliatePage.affiliateAbbreviation,Helpers.generateRandomString());
        
        //click save
        actions.clickElement(affiliatePage.saveBtn);

        //click filter
        Thread.sleep(2000);
        actions.clickElement(affiliatePage.filterBtn);
        
        //insert affiliate name
        actions.enterText(affiliatePage.filterAffiliateName,affiliateName);;
        
        //click apply filter
        actions.clickElement(affiliatePage.applyFilterBtn);
        //test that affiliate appears
        Thread.sleep(4000);
        Assert.assertEquals(actions.getText(affiliatePage.firstAffiliateName), affiliateName);
    }

    @Test(priority = 1 ,dependsOnMethods = "createAffiliateBySupport")
    public void generateLicense () throws InterruptedException {
        //clear any preset filter
        //click filter

        actions.clickElement(affiliatePage.filterBtn);

        //click clear
        actions.clickElement(affiliatePage.clearFiltersBtn);

        //filter for created affiliate
        actions.clickElement(affiliatePage.filterBtn);

        //insert affiliate name
        actions.enterText(affiliatePage.filterAffiliateName,affiliateName);;

        //click apply filter
        actions.clickElement(affiliatePage.applyFilterBtn);

        //test that affiliate appears
        Thread.sleep(3000);

        //click options
        actions.scrollToElementHorizontally(affiliatePage.tableHorizontalScrollBar, 500);
        actions.clickElement(affiliatePage.firstAffiliateOptionsBtn);

        //test text is "Generate license"
        Assert.assertEquals(actions.getText(affiliatePage.affiliateGenerateLicenseBtn),"Generate license");

        //click generate license option
        actions.clickElement(affiliatePage.affiliateGenerateLicenseBtn);

        //test that confirmation dialog box appears
        Assert.assertTrue(actions.isElementDisplayed(affiliatePage.confirmLicenseGenerateBtn));

        //click cancel button of popup
        actions.clickElement(affiliatePage.cancelLicenseGenerateBtn);

        //test that generate license still appears
        actions.clickElement(affiliatePage.firstAffiliateOptionsBtn);

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
        actions.clickElement(affiliatePage.filterBtn);

        //click clear
        actions.clickElement(affiliatePage.clearFiltersBtn);
        
        //filter for created affiliate
        actions.clickElement(affiliatePage.filterBtn);

        //insert affiliate name
        actions.enterText(affiliatePage.filterAffiliateName,affiliateName);;

        //click apply filter
        actions.clickElement(affiliatePage.applyFilterBtn);

        //test that affiliate appears
        Thread.sleep(3000);

        //click options
        actions.clickElement(affiliatePage.firstAffiliateOptionsBtn);

        //click edit
        actions.clickElement(affiliatePage.affiliateEditOptionBtn);

        //clear all affiliate details
        Thread.sleep(2000);
        actions.clearText(affiliatePage.maxUsers);
        actions.clearText(affiliatePage.affiliateAbbreviation);

        //insert max user
        actions.enterText(affiliatePage.maxUsers,"25");

        //insert abbreviation
        actions.enterText(affiliatePage.affiliateAbbreviation,Helpers.generateRandomString());

        //click cancel
        actions.clickElement(affiliatePage.cancelBtn);

        //click filter
        actions.clickElement(affiliatePage.filterBtn);
        //click clear
        actions.clickElement(affiliatePage.clearFiltersBtn);

        //filter for created affiliate
        actions.clickElement(affiliatePage.filterBtn);

        //insert affiliate name
        actions.enterText(affiliatePage.filterAffiliateName,affiliateName);;

        //click apply
        actions.clickElement(affiliatePage.applyFilterBtn);

        //test that affiliate details didn't change
        Thread.sleep(3000);
        Assert.assertEquals(actions.getText(affiliatePage.firstAffiliateName), affiliateName);
        System.out.println(actions.getText(affiliatePage.firstAffiliateActiveUsersCount));
    }

    @Test(priority = 2)
    public void editAffiliate() throws InterruptedException {
        try {
            //clear any preset filter
            //click filter
            actions.clickElement(affiliatePage.filterBtn);

            //click clear
            actions.clickElement(affiliatePage.clearFiltersBtn);

            //filter for created affiliate
            actions.clickElement(affiliatePage.filterBtn);

            //insert affiliate name
            actions.enterText(affiliatePage.filterAffiliateName,affiliateName);;

            //click apply
            actions.clickElement(affiliatePage.applyFilterBtn);

            Thread.sleep(3000);
            //click actions
            actions.clickElement(affiliatePage.firstAffiliateOptionsBtn);

            //click edit
            actions.clickElement(affiliatePage.affiliateEditOptionBtn);
            

            //clear all affiliate details
            actions.clearText(affiliatePage.maxUsers);
            actions.clearText(affiliatePage.affiliateAbbreviation);

            //insert max users
            affiliatePage.sendTextToAffiliateMaxUsersTextField("30");

            //insert abbreviation
            actions.enterText(affiliatePage.affiliateAbbreviation,Helpers.generateRandomString());

            //click save
            actions.clickElement(affiliatePage.saveBtn);

            //click submit edits button
            Thread.sleep(1000);
            actions.clickElement(affiliatePage.submitAffiliateEditBtn);

            //click filter
            Thread.sleep(2000);
            actions.clickElement(affiliatePage.filterBtn);

            //click clear
            actions.clickElement(affiliatePage.clearFiltersBtn);

            actions.clickElement(affiliatePage.filterBtn);

            //insert affiliate name
            actions.enterText(affiliatePage.filterAffiliateName,affiliateName);;

            //click apply filter
            actions.clickElement(affiliatePage.applyFilterBtn);

            //test that affiliate was edited and appears
            Thread.sleep(2000);
            Assert.assertEquals(actions.getText(affiliatePage.firstAffiliateName), affiliateName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

        @Test(priority = 3)
        public void filterByAffiliateName () throws InterruptedException {
            //clear any preset filter
            //click filter
            actions.clickElement(affiliatePage.filterBtn);

            //click clear
            actions.clickElement(affiliatePage.clearFiltersBtn);

            //filter for created affiliate
            actions.clickElement(affiliatePage.filterBtn);

            //insert affiliate name
            actions.enterText(affiliatePage.filterAffiliateName,affiliateName);;

            //click apply
            actions.clickElement(affiliatePage.applyFilterBtn);

            //test that affiliate appears
            Thread.sleep(2000);
            Assert.assertEquals(actions.getText(affiliatePage.firstAffiliateName), affiliateName);

        }

        @Test(priority = 3)
        public void filterByType () throws InterruptedException {
            //clear any preset filter
            //click filter
            actions.clickElement(affiliatePage.filterBtn);

            //click clear
            actions.clickElement(affiliatePage.clearFiltersBtn);

            //filter for created affiliate
            actions.clickElement(affiliatePage.filterBtn);

            //insert affiliate type
            actions.chooseFromDropDown(affiliatePage.filterAffiliateType,"Farm");

            //click apply
            actions.clickElement(affiliatePage.applyFilterBtn);

            //test that affiliates that appear are of the filtered type
            Thread.sleep(3000);
            Assert.assertEquals(actions.getText(affiliatePage.firstAffiliateType), "Farm");
        }

        @Test(priority = 3)
        public void toggleColumns () throws InterruptedException {
            //refresh page
            MainTestRunner.ChromeDriver.navigate().refresh();

            //clear any preset filter
            Thread.sleep(2000);
            actions.clickElement(affiliatePage.clearFiltersBtn);

            //click view
            Thread.sleep(2000);
            actions.clickElement(affiliatePage.viewBtn);
            actions.clickElement(affiliatePage.toggleCreatedAtColumnOption);

            //test that column is  not visible and the fifth column is created at
            Thread.sleep(4000);
            Assert.assertFalse(actions.isElementDisplayed(affiliatePage.createdAtColumn));

            //test that column is  visible
            Thread.sleep(2000);
            actions.clickElement(affiliatePage.viewBtn);
            actions.clickElement(affiliatePage.toggleCreatedAtColumnOption);
            Assert.assertTrue(actions.isElementDisplayed(affiliatePage.createdAtColumn));

            //toggle last updated at column
            //click view
            Thread.sleep(2000);
            actions.clickElement(affiliatePage.viewBtn);
            actions.clickElement(affiliatePage.toggleLastUpdatedAtColumnOption);

            Thread.sleep(2000);
            Assert.assertFalse(affiliatePage.isLastUpdatedAtColumnDisplayed());

            //test that column is  visible
            Thread.sleep(2000);
            actions.clickElement(affiliatePage.viewBtn);
            actions.clickElement(affiliatePage.toggleLastUpdatedAtColumnOption);
            Assert.assertTrue(actions.isElementDisplayed(affiliatePage.createdAtColumn));
        }

        @Test(priority = 3)
        public void searchAffiliate () throws InterruptedException {
            //clear any preset filter
            //click filter
            actions.clickElement(affiliatePage.filterBtn);

            //click clear
            actions.clickElement(affiliatePage.clearFiltersBtn);

            //insert affiliate name
            Thread.sleep(2000);
            actions.enterText(affiliatePage.searchField,affiliateName);

            //click search btn to saarch
            actions.clickElement(affiliatePage.searchBtn);

            //test that results apply
            Thread.sleep(2000);
            Assert.assertEquals(actions.getText(affiliatePage.firstAffiliateName), affiliateName);

            //refresh window
            actions.refreshWindow();
            Thread.sleep(6000);
        }

        @Test(priority = 4)
        @Ignore
        public void deleteAffiliate ()throws InterruptedException {
            //clear any preset filter
            //click filter
            actions.clickElement(affiliatePage.filterBtn);

            //click clear
            actions.clickElement(affiliatePage.clearFiltersBtn);

            //filter for created affiliate
            Thread.sleep(2000);
            actions.clickElement(affiliatePage.filterBtn);


            //insert affiliate name
            actions.enterText(affiliatePage.filterAffiliateName,affiliateName);;

            //click apply filter
            actions.clickElement(affiliatePage.applyFilterBtn);

            //click options
            Thread.sleep(2000);
            actions.clickElement(affiliatePage.firstAffiliateOptionsBtn);

        /*
        //click delete
        actions.clickElement(affiliatePage.affiliateDeleteOptionBtn);

        //click cancel  delete button
        affiliatePage.clickCancelDeleteBtn();

        //test that affiliate not deleted
        Assert.assertEquals(actions.getText(affiliatePage.firstAffiliateName),affiliateName);

        //click options
        actions.clickElement(affiliatePage.firstAffiliateOptionsBtn);
*/
            //click delete
            actions.clickElement(affiliatePage.affiliateDeleteOptionBtn);

            //click confirm delete
            affiliatePage.clickConfirmDeleteBtn();

            //click filter
            actions.clickElement(affiliatePage.filterBtn);

            //click clear
            actions.clickElement(affiliatePage.clearFiltersBtn);

            //filter for created affiliate
            actions.clickElement(affiliatePage.filterBtn);

            //insert affiliate name
            actions.enterText(affiliatePage.filterAffiliateName,affiliateName);;

            //click apply filter
            actions.clickElement(affiliatePage.applyFilterBtn);

            //test that affiliate is deleted
            Assert.assertFalse(affiliatePage.affiliateNameIsDisplayed());

        }

        @Test(priority = 4  /*,dependsOnMethods = "deleteAffiliate"*/)
        public void sortData () throws InterruptedException {
            //clear any preset filter
            //click filter
            actions.clickElement(affiliatePage.filterBtn);

            //click clear
            actions.clickElement(affiliatePage.clearFiltersBtn);
            
            //sort by name ascending
            actions.clickElement(affiliatePage.nameColumn);
            
            actions.clickElement(affiliatePage.sortNamesAscOption);
            
            Thread.sleep(6000);
            //sort by name ascending (click again as it is default and ensure it is set)
            actions.clickElement(affiliatePage.nameColumn);
            actions.clickElement(affiliatePage.sortNamesAscOption);
            Thread.sleep(3000);
            
            System.out.println(actions.getText(affiliatePage.firstAffiliateName));
            System.out.println(actions.getText(affiliatePage.secondAffiliateName));
            System.out.println(actions.getText(affiliatePage.firstAffiliateName).compareTo(actions.getText(affiliatePage.secondAffiliateName)));
            Assert.assertTrue(actions.getText(affiliatePage.firstAffiliateName).compareTo(actions.getText(affiliatePage.secondAffiliateName)) <= 0);

            //sort by name descending
            Thread.sleep(2000);
            actions.clickElement(affiliatePage.nameColumn);
            actions.clickElement(affiliatePage.sortNamesDescOption);;
            
            Thread.sleep(4000);
            System.out.println(actions.getText(affiliatePage.firstAffiliateName));
            System.out.println(actions.getText(affiliatePage.secondAffiliateName));
            System.out.println(actions.getText(affiliatePage.firstAffiliateName).compareTo(actions.getText(affiliatePage.secondAffiliateName)));
            Assert.assertTrue(actions.getText(affiliatePage.firstAffiliateName).compareTo(actions.getText(affiliatePage.secondAffiliateName)) >= 0);

            //clear name sorting
            actions.clickElement(affiliatePage.nameColumn);
            actions.clickElement(affiliatePage.sortNamesDescOption);;

            //sort by user count ascending

            Thread.sleep(2000);
            actions.clickElement(affiliatePage.currentActiveUsersColumn);
            actions.clickElement(affiliatePage.sortActiveUsersAscOption);
            Thread.sleep(3000);

            //try catch to handle if users count is -- and set its value to zero
            int num1, num2;
            try {
                
                num1 = Integer.parseInt(actions.getText(affiliatePage.firstAffiliateActiveUsersCount));
            } catch (NumberFormatException ex) {
                num1 = 0;
            }

            try {

                num2 = Integer.parseInt(actions.getText(affiliatePage.secondAffiliateUsersCount));
            } catch (NumberFormatException ex) {
                num2 = 0;
            }

            Assert.assertTrue(num1 <= num2);

            //sort by user count descending
            Thread.sleep(3000);
            actions.clickElement(affiliatePage.currentActiveUsersColumn);
            actions.clickElement(affiliatePage.sortActiveUsersDescOption);
            Thread.sleep(2000);

            //try catch to handle if users count is -- and set its value to zero
            try {

                num1 = Integer.parseInt(actions.getText(affiliatePage.firstAffiliateActiveUsersCount));
            } catch (NumberFormatException ex) {
                num1 = 0;
            }

            try {

                num2 = Integer.parseInt(actions.getText(affiliatePage.secondAffiliateUsersCount));
            } catch (NumberFormatException ex) {
                num2 = 0;
            }
            System.out.println(num1);
            System.out.println(num2);
            Assert.assertTrue(num1 >= num2);
        }

        @Test(priority = 5)
        public void createAffiliateByAdmin () throws InterruptedException {
            //sign-out from support
            actions.clickElement(homePage.profileIconBtn);
            actions.clickElement(homePage.signoutBtn);
            

            //login with admin account
            Helpers.loginWithValidUser((ChromeDriver) MainTestRunner.ChromeDriver, Credentials.partnerAdminUsername, Credentials.partnerAdminPassword);

            //navigate to affiliates page
            Thread.sleep(6000);
            actions.clickElement(homePage.affiliateSidebarBtn);
            

            //click add affiliate button
            Thread.sleep(4000);
            actions.clickElement(affiliatePage.addAffiliateBtn);

            //insert affiliate name
            affiliateName = ("Affiliate_" + (MainTestRunner.date)).substring(0, 23) + Helpers.generateRandomString();
            actions.enterText(affiliatePage.affiliateName,affiliateName);;

            //insert max user
            actions.enterText(affiliatePage.maxUsers,"20");;

            //choose affiliate type
            actions.chooseFromDropDown(affiliatePage.affiliateType,"Farm");

            //insert abbreviation
            actions.enterText(affiliatePage.affiliateAbbreviation,Helpers.generateRandomString());

            //click save
            actions.clickElement(affiliatePage.saveBtn);

            //click filter
            Thread.sleep(2000);
            actions.clickElement(affiliatePage.filterBtn);
            //insert affiliate name
            actions.enterText(affiliatePage.filterAffiliateName,affiliateName);;

            //click apply filter
            actions.clickElement(affiliatePage.applyFilterBtn);

            //test that affiliate appears
            Thread.sleep(3000);
            Assert.assertEquals(actions.getText(affiliatePage.firstAffiliateName), affiliateName);

            //click options
            actions.scrollToElementHorizontally(affiliatePage.tableHorizontalScrollBar, 500);
            actions.clickElement(affiliatePage.firstAffiliateOptionsBtn);

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
            actions.clickElement(homePage.profileIconBtn);
            actions.clickElement(homePage.signoutBtn);

            //login with admin account
            Helpers.loginWithValidUser((ChromeDriver) MainTestRunner.ChromeDriver, Credentials.superAdminUsername, Credentials.superAdminPassword);

            //navigate to affiliates page'
            Thread.sleep(5000);
            actions.clickElement(homePage.affiliateSidebarBtn);

            //click add affiliate button
            actions.clickElement(affiliatePage.addAffiliateBtn);

            //insert affiliate name
            affiliateName = ("Affiliate_" + (MainTestRunner.date)).substring(0, 22) + Helpers.generateRandomString();
            actions.enterText(affiliatePage.affiliateName,affiliateName);;

            //insert max user
            actions.enterText(affiliatePage.maxUsers,"20");;

            //choose affiliate type
            actions.chooseFromDropDown(affiliatePage.affiliateType,"Farm");

            //insert abbreviation
            actions.enterText(affiliatePage.affiliateAbbreviation,Helpers.generateRandomString());

            //click save
            Thread.sleep(2000);
            actions.clickElement(affiliatePage.saveBtn);

            //click filter
            Thread.sleep(2000);
            actions.clickElement(affiliatePage.filterBtn);
            //insert affiliate name
            actions.enterText(affiliatePage.filterAffiliateName,affiliateName);;

            //click apply filter
            actions.clickElement(affiliatePage.applyFilterBtn);

            //test that affiliate appears
            Thread.sleep(3000);
            Assert.assertEquals(actions.getText(affiliatePage.firstAffiliateName), affiliateName);

            //click options
            actions.scrollToElementHorizontally(affiliatePage.tableHorizontalScrollBar, 500);
            actions.clickElement(affiliatePage.firstAffiliateOptionsBtn);

            //test text is "Generate license"
            Assert.assertFalse(actions.isElementDisplayed(affiliatePage.affiliateGenerateLicenseBtn));

            //click generate license
            actions.clickElement(affiliatePage.affiliateGenerateLicenseBtn);

            //click cancel button
            actions.clickElement(affiliatePage.cancelLicenseGenerateBtn);
        }


        public void deleteAffiliate (String affiliateName) throws InterruptedException {

            //clear any preset filter
            //click filter
            actions.clickElement(affiliatePage.filterBtn);
            //click clear
            actions.clickElement(affiliatePage.clearFiltersBtn);

            //filter for created affiliate
            actions.clickElement(affiliatePage.filterBtn);
            //insert affiliate name
            actions.enterText(affiliatePage.filterAffiliateName, this.affiliateName);;

            //click apply filter
            actions.clickElement(affiliatePage.applyFilterBtn);

            //click options
            Thread.sleep(2000);
            actions.clickElement(affiliatePage.firstAffiliateOptionsBtn);

            //click delete
            actions.clickElement(affiliatePage.affiliateDeleteOptionBtn);
            

        /*
        //click cancel  delete button
        affiliatePage.clickCancelDeleteBtn();

        //test that affiliate not deleted
        Assert.assertEquals(actions.getText(affiliatePage.firstAffiliateName), affiliateName);

        //click options
        actions.clickElement(affiliatePage.firstAffiliateOptionsBtn);

        //click delete
        actions.clickElement(affiliatePage.affiliateDeleteOptionBtn);
*/
        //click confirm delete
        actions.clickElement(affiliatePage.confirmDeleteBtn);
    }

    }

