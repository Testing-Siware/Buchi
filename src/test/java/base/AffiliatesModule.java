package base;

import data.Credentials;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.Actions;
import pages.AffiliatePage;
import pages.HomePage;
import pages.LicensePage;
import utils.EnvironmentSelector;
import utils.Helpers;

import java.util.List;


public class AffiliatesModule {
    HomePage homePage;
    AffiliatePage affiliatePage;
    LicensePage licensePage;
    String affiliateName;

    Actions actions;

    @BeforeClass
    public void intializeClasses(){
        homePage = new HomePage((ChromeDriver) MainTestRunner.ChromeDriver);
        affiliatePage = new AffiliatePage((ChromeDriver) MainTestRunner.ChromeDriver);
        licensePage = new LicensePage((ChromeDriver) MainTestRunner.ChromeDriver);
        actions = new Actions((ChromeDriver) MainTestRunner.ChromeDriver,20);
    }

    @Test(priority = 1)
    public void createInvalidAffiliateBySupport() throws InterruptedException {
        //navigate to affiliates page
        actions.clickElement(homePage.affiliateSidebarBtn);

        //click add affiliate button
        actions.clickElement(affiliatePage.addAffiliateBtn);

        //click save without adding any data
        actions.clickElement(affiliatePage.saveBtn);

        //test that error messages appear under required fields
        Assert.assertEquals(actions.getText(affiliatePage.affiliateRequiredErrorMsg), "Name is required.");
        Assert.assertEquals(actions.getText(affiliatePage.typeRequiredErrorMsg), "Type is required.");
        Assert.assertEquals(actions.getText(affiliatePage.maxUsersRequiredErrorMsg), "Max users is required.");

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

        //logout and login with the second support account
        actions.clickElement(homePage.profileIconBtn);
        actions.clickElement(homePage.signoutBtn);

        Helpers.loginWithValidUser((ChromeDriver) MainTestRunner.ChromeDriver, Credentials.supportUsernameTwo, Credentials.supportPassword);

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
        actions.enterText(affiliatePage.maxUsers,"20");

        //insert max instruments
        actions.enterText(affiliatePage.maxInstruments,"3");

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

    @Ignore
    @Test(priority = 1, dependsOnMethods = "createAffiliateBySupport")
    public void generateLicense () throws InterruptedException {

        String[] instrumentsNames =new String[2];
        instrumentsNames[0]="instrument_"+Helpers.generateRandomString().substring(0,4);
        instrumentsNames[1]="instrument_"+Helpers.generateRandomString().substring(0,4);

        //click licenses button
        actions.clickElement(licensePage.licensesBtn);

        //test that user is redirected to license page
        Thread.sleep(1000);
        Assert.assertEquals(actions.getCurrentUrl(), EnvironmentSelector.licenseUrl);

        //click generate license button
        actions.clickElement(licensePage.generateLicenseBtn);

        //test that user is redirected to license generation page
        Thread.sleep(1000);
        Assert.assertEquals(actions.getCurrentUrl(), EnvironmentSelector.generateLicenseUrl);

        //click add
        actions.clickElement(licensePage.licenseSubmitBtn);

        //test that affiliate is required
        Assert.assertEquals(actions.getText(licensePage.licenseAffiliateRequiredMsg),"Affiliate is required.");

        //test that instrument is required
        Assert.assertEquals(actions.getText(licensePage.licenseInstrumentRequiredMsg),"Instrument SNR can not be empty!");

        //select affiliate from dropdown
        actions.chooseFromDropDown(licensePage.licenseAffiliateDropdown,affiliateName);

        //insert first instrument name
        actions.enterText(licensePage.licenseInstrumentField, instrumentsNames[0]);
        //click add
        actions.clickElement(licensePage.licenseAddInstrumentBtn);

        //insert second instrument name
        actions.enterText(licensePage.licenseInstrumentField, instrumentsNames[1]);
        //click add
        actions.clickElement(licensePage.licenseAddInstrumentBtn);

        //fetch added instruments
        List<WebElement> addedInstruments= actions.getElementChildren(licensePage.licenseAddedInstruments);
        int numOfInstruments=addedInstruments.size();

        //test that 2 instruments were added
        Assert.assertEquals(numOfInstruments,2);

        //test that the instrument was added in list of instruments
        for (int i=0;i<numOfInstruments;i++){
            Assert.assertEquals(addedInstruments.get(i).getText(), instrumentsNames[i]);
        }

        //fetch clipboard content before license generation
        String clipboardBeforeGeneration=Helpers.getClipboardContents();

        //click save
        actions.clickElement(licensePage.licenseSubmitBtn);

        //fetch notification
        Assert.assertEquals(actions.getText(homePage.alertMessage),"Success\n"+"License key generated successfully and copied to the clipboard");

        //fetch clipboard content after license generation
        Thread.sleep(2000);
        String clipboardAfterGeneration=Helpers.getClipboardContents();

        //test that license was copied into clipboard
        Assert.assertNotEquals(clipboardBeforeGeneration,clipboardAfterGeneration);

        //search for the affiliate
        actions.enterText(licensePage.licenseSearchInput,affiliateName);
        actions.clickElement(licensePage.licenseSearchBtn);

        //test that data matches license (name and number of instruments)
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(licensePage.licenseTableFirstRowAffiliate),affiliateName);
        Assert.assertEquals(actions.getText(licensePage.licenseTableFirstRowInstruments),String.valueOf(numOfInstruments));

        //click actions button
        actions.clickElement(licensePage.licenseTableFirstRowActionCell);

        //test that second option is view license
        Assert.assertEquals(actions.getText(licensePage.viewLicenseOption),"View license");

        //click view license option
        actions.clickElement(licensePage.viewLicenseOption);

        //click copy license
        actions.clickElement(licensePage.copyLicenseBtn);

        //click cancel copy license button
        actions.clickElement(licensePage.cancelLicenseCopyBtn);

        //test that copy pop-up is not visible
        Assert.assertFalse(actions.isElementEnabled(licensePage.cancelLicenseCopyBtn));

        //test that license is copied into clipboard
        Assert.assertEquals(Helpers.getClipboardContents(),clipboardAfterGeneration);

        //navigate back to affiliate page
        actions.clickElement(homePage.affiliateSidebarBtn);

        Thread.sleep(2000);
        //scroll the table
        actions.scrollToElementHorizontally(affiliatePage.tableHorizontalScrollBar,2000);

        //click actions button
        actions.clickElement(affiliatePage.firstAffiliateOptionsBtn);

        //test that the option visible "view license"
        Assert.assertEquals(actions.getText(affiliatePage.affiliateViewLicenseOptionBtn),"View license");

        //click view license option
        actions.clickElement(affiliatePage.affiliateViewLicenseOptionBtn);

        //click copy license button
        actions.clickElement(licensePage.copyLicenseBtn);

        String copiedLicense=Helpers.getClipboardContents();

        //test that the license is copied
        Assert.assertEquals(clipboardAfterGeneration,copiedLicense);

        actions.clickElement(licensePage.cancelLicenseCopyBtn);


        //filter for affiliate

        /*

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
        actions.clickElement(affiliatePage.cancelLicenseCopyBtn);*/
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
        actions.enterText(affiliatePage.maxUsers,"20");

        //insert max instruments
        actions.enterText(affiliatePage.maxInstruments,"3");


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
            actions.clearText(affiliatePage.maxInstruments);
            actions.clearText(affiliatePage.affiliateAbbreviation);

            //insert max user
            actions.enterText(affiliatePage.maxUsers,"20");

            //insert max instruments
            actions.enterText(affiliatePage.maxInstruments,"3");


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
            System.out.println("Error: Was not able to parse both numbers");
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
            actions.enterText(affiliatePage.maxUsers,"20");

            //insert max instruments
            actions.enterText(affiliatePage.maxInstruments,"3");


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
            actions.clickElement(licensePage.cancelLicenseGenerateBtn);
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
            actions.enterText(affiliatePage.maxUsers,"20");

            //insert max instruments
            actions.enterText(affiliatePage.maxInstruments,"3");


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
            actions.clickElement(licensePage.cancelLicenseGenerateBtn);
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

