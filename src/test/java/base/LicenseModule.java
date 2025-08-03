package base;

import com.beust.ah.A;
import data.Credentials;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;
import pages.Actions;
import pages.AffiliatePage;
import pages.HomePage;
import pages.LicensePage;
import utils.EnvironmentSelector;
import utils.Helpers;

import java.util.ArrayList;
import java.util.List;

public class LicenseModule {
    HomePage homePage;
    AffiliatePage affiliatePage;
    LicensePage licensePage;
    String affiliateName;
    List<WebElement> addedInstruments;
    ArrayList<String> addedInstrumentsNames;
    int numOfInstruments;

    Actions actions;

    @BeforeClass
    public void intializeClasses() {
        homePage = new HomePage((ChromeDriver) MainTestRunner.ChromeDriver);
        affiliatePage = new AffiliatePage((ChromeDriver) MainTestRunner.ChromeDriver);
        licensePage = new LicensePage((ChromeDriver) MainTestRunner.ChromeDriver);
        actions = new Actions((ChromeDriver) MainTestRunner.ChromeDriver, 20);
        addedInstrumentsNames = new ArrayList<>();
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

        //test that max instruments column is visible
        Assert.assertTrue(actions.isElementDisplayed(affiliatePage.maxInstrumentsColumn));

        //click add affiliate button
        Thread.sleep(1000);
        actions.clickElement(affiliatePage.addAffiliateBtn);

        //test that max instruments is visible
        Assert.assertTrue(actions.isElementDisplayed(affiliatePage.maxInstruments));

        //insert affiliate name
        Thread.sleep(2000);
        affiliateName = ("Affiliate_" + (MainTestRunner.date)).substring(0, 29);
        actions.enterText(affiliatePage.affiliateName, affiliateName);

        //insert max user
        actions.enterText(affiliatePage.maxUsers, "20");

        //insert max instruments
        actions.enterText(affiliatePage.maxInstruments, "3");

        //choose affiliate type
        actions.chooseFromDropDown(affiliatePage.affiliateType, "Farm");

        //insert abbreviation
        actions.enterText(affiliatePage.affiliateAbbreviation, Helpers.generateRandomString());

        //click save
        actions.clickElement(affiliatePage.saveBtn);

        //click filter
        Thread.sleep(2000);
        actions.clickElement(affiliatePage.filterBtn);

        //insert affiliate name
        actions.enterText(affiliatePage.filterAffiliateName, affiliateName);
        ;

        //click apply filter
        actions.clickElement(affiliatePage.applyFilterBtn);
        //test that affiliate appears
        Thread.sleep(4000);
        Assert.assertEquals(actions.getText(affiliatePage.firstAffiliateName), affiliateName);
    }

    @Test(priority = 1)
    public void deleteAffiliateWithoutLicense() throws InterruptedException {
        deleteAffiliate(affiliateName);
    }

    @Test(priority = 2, dependsOnMethods = "createAffiliateBySupport")
    public void generateLicense() throws InterruptedException {
        String[] instrumentsNames = new String[2];
        instrumentsNames[0] = "instrument_" + Helpers.generateRandomString().substring(0, 4);
        instrumentsNames[1] = "instrument_" + Helpers.generateRandomString().substring(0, 4);

        //create another affiliate
        createAffiliateBySupport();

        //click licenses button
        actions.clickElement(licensePage.licensesBtn);

        //test that user is redirected to license page
        Thread.sleep(1000);
        Assert.assertEquals(actions.getCurrentUrl(), EnvironmentSelector.licenseUrl);

        Assert.assertEquals(actions.getText(licensePage.licensePageTitle), "Licenses\n" +
                "Here you can manage your affiliate's licenses");

        //click generate license button
        actions.clickElement(licensePage.generateLicenseBtn);

        //test that user is redirected to license generation page
        Thread.sleep(1000);
        Assert.assertEquals(actions.getCurrentUrl(), EnvironmentSelector.generateLicenseUrl);

        //click add
        actions.clickElement(licensePage.licenseSubmitBtn);

        //test that affiliate is required
        Assert.assertEquals(actions.getText(licensePage.licenseAffiliateRequiredMsg), "Affiliate is required.");

        //test that instrument is required
        Assert.assertEquals(actions.getText(licensePage.licenseInstrumentRequiredMsg), "Instrument SNR can not be empty!");

        //select affiliate from dropdown
        actions.chooseFromDropDown(licensePage.licenseAffiliateDropdown, affiliateName);

        //add 8 random instruments
        for (int i = 0; i < 8; i++) {
            actions.enterText(licensePage.licenseInstrumentField, Helpers.generateRandomString().substring(0, 4));
            actions.clickElement(licensePage.licenseAddInstrumentBtn);
        }

        actions.enterText(licensePage.licenseInstrumentField, Helpers.generateRandomString().substring(0, 4));
        actions.clickElement(licensePage.licenseAddInstrumentBtn);
        actions.clearText(licensePage.licenseInstrumentField);

        //test that user cannot add more than 8 instruments
        Assert.assertEquals(actions.getText(licensePage.licenseInstrumentRequiredMsg), "Allowed only 8 Instruments per Affiliate");

        //delete all 8 random instruments
        for (int i = 0; i < 8; i++) {
            actions.clickElement(licensePage.licenseDeleteInstrumentBtn);
        }

        //add 4 random instruments (exceeds limits of license)
        for (int i = 0; i < 4; i++) {
            actions.enterText(licensePage.licenseInstrumentField, Helpers.generateRandomString().substring(0, 4));
            actions.clickElement(licensePage.licenseAddInstrumentBtn);
        }
        //click save
        actions.clickElement(licensePage.licenseSubmitBtn);

        //test that user cannot exceed limits of affiliate
        Assert.assertTrue(actions.getText(homePage.alertMessage).contains(
                "The Count of Instruments added exceeds the defined license count. Please add only the allowed number of Instruments or contact the support to extend your license."));

        //delete all 4 random instruments
        for (int i = 0; i < 4; i++) {
            actions.clickElement(licensePage.licenseDeleteInstrumentBtn);
        }

        //insert first instrument name
        actions.enterText(licensePage.licenseInstrumentField, instrumentsNames[0]);

        //click add
        actions.clickElement(licensePage.licenseAddInstrumentBtn);

        //insert second instrument name
        actions.enterText(licensePage.licenseInstrumentField, instrumentsNames[1]);

        //click add
        actions.clickElement(licensePage.licenseAddInstrumentBtn);

        //fetch added instruments
        addedInstruments = actions.getElementChildren(licensePage.licenseAddedInstruments);
        numOfInstruments = addedInstruments.size();
        for (WebElement addedInstrument : addedInstruments) {
            addedInstrumentsNames.add(addedInstrument.getText());
        }

        //test that 2 instruments were added
        Assert.assertEquals(numOfInstruments, 2);

        //test that the instrument was added in list of instruments
        for (int i = 0; i < numOfInstruments; i++) {
            Assert.assertEquals(addedInstrumentsNames.get(i), instrumentsNames[i]);
        }

        //fetch clipboard content before license generation
        String clipboardBeforeGeneration = Helpers.getClipboardContents();

        Thread.sleep(3000);

        //click save
        actions.clickElement(licensePage.licenseSubmitBtn);

        //fetch notification
        Assert.assertTrue(actions.getText(homePage.alertMessage).contains("License key generated successfully and copied to the clipboard"));

        //fetch clipboard content after license generation
        Thread.sleep(2000);
        String clipboardAfterGeneration = Helpers.getClipboardContents();

        //test that license was copied into clipboard
        Assert.assertNotEquals(clipboardBeforeGeneration, clipboardAfterGeneration);

        //search for the affiliate
        actions.enterText(licensePage.licenseSearchInput, affiliateName);
        actions.clickElement(licensePage.licenseSearchBtn);

        //test that data matches license (name and number of instruments)
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(licensePage.licenseTableFirstRowAffiliate), affiliateName);
        Assert.assertEquals(actions.getText(licensePage.licenseTableFirstRowInstruments), String.valueOf(numOfInstruments));

        //click actions button
        actions.clickElement(licensePage.licenseTableFirstRowActionCell);

        //test that second option is view license
        Assert.assertEquals(actions.getText(licensePage.viewLicenseOption), "View license");

        //click view license option
        actions.clickElement(licensePage.viewLicenseOption);

        //test that share by email option is visible
        Assert.assertTrue(actions.isElementDisplayed(licensePage.shareLicenseByEmail));

        //click copy license
        actions.clickElement(licensePage.copyLicenseBtn);

        //click cancel copy license button
        actions.clickElement(licensePage.cancelLicenseCopyBtn);

        //test that copy pop-up is not visible
        Assert.assertFalse(actions.isElementEnabled(licensePage.cancelLicenseCopyBtn));

        //test that license is copied into clipboard
        Assert.assertEquals(Helpers.getClipboardContents(), clipboardAfterGeneration);

        String copiedLicense = Helpers.getClipboardContents();

        //navigate to license page
        Thread.sleep(2000);
        actions.clickElement(licensePage.licensesBtn);

        //click actions button on first license
        actions.clickElement(licensePage.licenseTableFirstRowActionCell);

        //click view license
        actions.clickElement(licensePage.viewLicenseOption);

        //click cancel
        Thread.sleep(2000);
        actions.clickElement(licensePage.cancelLicenseCopyBtn);

        //test that clipboard content didn't change
        //test that the license is copied
        String currentClipboard = Helpers.getClipboardContents();
        Assert.assertEquals(currentClipboard, copiedLicense);
    }

    @Test(priority = 2, dependsOnMethods = "generateLicense")
    public void sendLicenseByEmail() throws InterruptedException {
        //click actions button
        actions.clickElement(licensePage.licenseTableFirstRowActionCell);

        //click view license
        actions.clickElement(licensePage.viewLicenseOption);

        //test that share by email button is visible
        Assert.assertTrue(actions.isElementDisplayed(licensePage.shareLicenseByEmail));

        //click send by email button
        actions.clickElement(licensePage.shareLicenseByEmail);

        //click send
        actions.clickElement(licensePage.sendEmailBtn);
        //test that error message appears under dropdown
        Assert.assertEquals(actions.getText(licensePage.emailDropDownErrorMsg), "Emails can not be empty!");

        //insert email in dropdown
        actions.chooseFromDropDown(licensePage.emailDropdownShareLicense, "testing@email.com");

        //click cancel
        actions.clickElement(licensePage.cancelEmailBtn);

        //test that view license modal is still open
        Assert.assertTrue(actions.isElementDisplayed(licensePage.cancelLicenseCopyBtn));

        //click send by email button
        actions.clickElement(licensePage.shareLicenseByEmail);

        //insert email in dropdown
        actions.chooseFromDropDown(licensePage.emailDropdownShareLicense, "testing@email.com");

        //click send
        actions.clickElement(licensePage.sendEmailBtn);

        //test that notification appears
        Assert.assertEquals(homePage.getNotificationText(), "Email(s) sent successfully!");
    }

    @Test(priority = 3, dependsOnMethods = "createAffiliateBySupport")
    public void editPendingLicense() throws InterruptedException {
        //click actions button
        actions.clickElement(licensePage.licenseTableFirstRowActionCell);

        //click edit option
        actions.clickElement(licensePage.editLicenseOption);

        //add new instrument
        Thread.sleep(2000);
        String newInstrument = "instrument_" + Helpers.generateRandomString().substring(0, 4);
        addedInstrumentsNames.add(newInstrument);
        actions.enterText(licensePage.licenseInstrumentField, newInstrument);
        actions.clickElement(licensePage.licenseAddInstrumentBtn);
        numOfInstruments += 1;

        //click generate
        actions.clickElement(licensePage.licenseSubmitBtn);

        //test that pop-up appears and new license will be generated
        Assert.assertTrue(actions.getText(licensePage.newLicenseGeneratePopUp).contains("Generate New License\n" +
                "This action will generate a new license which will deactivate the current one and syncing of the data will be stopped.\n" +
                "Please insert the new key in the sync app to ensure the continue syncing of the data.\n"));

        //click cancel
        actions.clickElement(licensePage.cancelNewLicenseGenerationBtn);

        //test that user is still on the edit page
        Assert.assertEquals(actions.getCurrentUrl(), EnvironmentSelector.editLicenseUrl);

        //click generate
        actions.clickElement(licensePage.licenseSubmitBtn);

        //click generate button
        Thread.sleep(3000);
        actions.clickElement(licensePage.generateNewLicenseGenerationBtn);

        //test that notification and new license is created
        Assert.assertEquals(homePage.getNotificationText(), "License key generated successfully and copied to the clipboard");

        Thread.sleep(2000);
        //test that instruments of affiliates became three
        Assert.assertEquals(actions.getText(licensePage.licenseTableFirstRowInstruments), String.valueOf(numOfInstruments));

    }


    @Test(priority = 4)
    public void searchAffiliateLicense() throws InterruptedException {
        //click filter
        actions.clickElement(licensePage.licenseFilterBtn);

        //click clear filter
        actions.clickElement(licensePage.clearFilterBtn);

        //search for affiliate
        actions.clearText(licensePage.licenseSearchInput);
        actions.enterText(licensePage.licenseSearchInput, affiliateName);
        actions.clickElement(licensePage.licenseSearchBtn);

        //test that affiliate appears
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(licensePage.licenseTableFirstRowAffiliate), affiliateName);
    }

    @Test(priority = 5)
    public void editGeneratedLicense() throws InterruptedException {
        //navigate to licenses
        Thread.sleep(2000);
        actions.clickElement(licensePage.licensesBtn);

        //search for licensed affiliate
        actions.clearText(licensePage.licenseSearchInput);
        actions.enterText(licensePage.licenseSearchInput, affiliateName);
        actions.clickElement(licensePage.licenseSearchBtn);

        //click actions button
        Thread.sleep(2000);
        actions.clickElement(licensePage.licenseTableFirstRowActionCell);

        //test that edit license option is available
        Assert.assertEquals(actions.getText(licensePage.editLicenseOption), "Edit");

        //click edit license
        actions.clickElement(licensePage.editLicenseOption);

        //test that user is re-directed to edit license page
        Assert.assertEquals(actions.getCurrentUrl(), EnvironmentSelector.editLicenseUrl);

        //test that affiliate data appears
        System.out.println(actions.getText(licensePage.licenseAffiliateDropdown));

        //test that two instruments are available
        List<WebElement> currentInstruments = actions.getElementChildren(licensePage.licenseAddedInstruments);
        System.out.println("Size of current instruments: " + currentInstruments.size());

        for (int i = 0; i < currentInstruments.size(); i++) {
            Assert.assertEquals(currentInstruments.get(i).getText(), addedInstrumentsNames.get(i));
        }

    }

    @Test(priority = 6)
    public void viewColumnsLicense() throws InterruptedException {
        //navigate to affiliate page
        actions.clickElement(homePage.affiliateSidebarBtn);

        //click licenses button
        actions.clickElement(licensePage.licensesBtn);

        //click view button
        actions.clickElement(licensePage.viewBtn);

        //view created by column
        actions.clickElement(licensePage.toggleCreatedByColumn);

        //test that column appears
        Thread.sleep(2000);
        Assert.assertTrue(actions.isElementDisplayed(licensePage.createdByColumnHeader));

        //click view button
        actions.clickElement(licensePage.viewBtn);

        //view created at column
        actions.clickElement(licensePage.toggleCreatedAtColumn);

        //test that column appears
        Thread.sleep(2000);
        Assert.assertTrue(actions.isElementDisplayed(licensePage.createdAtColumnHeader));

        //click view button
        actions.clickElement(licensePage.viewBtn);

        //view last updated at column
        actions.clickElement(licensePage.toggleLastUpdatedAtColumn);

        //test that column appears
        Thread.sleep(2000);
        Assert.assertTrue(actions.isElementDisplayed(licensePage.lastUpdatedAtColumnHeader));

        //refresh window
        actions.refreshWindow();

        //test that all columns are still visible
        Assert.assertTrue(actions.isElementDisplayed(licensePage.lastUpdatedAtColumnHeader));
        Assert.assertTrue(actions.isElementDisplayed(licensePage.createdAtColumnHeader));
        Assert.assertTrue(actions.isElementDisplayed(licensePage.createdByColumnHeader));


    }

    @Test(priority = 6)
    public void deleteAffiliateWithLicenseNoDataSync() throws InterruptedException {

        //navigate to affiliate page
        actions.clickElement(homePage.affiliateSidebarBtn);

        deleteAffiliate(affiliateName);

        //click licenses button
        actions.clickElement(licensePage.licensesBtn);

        //search for the affiliate deleted
        Thread.sleep(2000);
        actions.enterText(licensePage.licenseSearchInput, affiliateName);
        actions.clickElement(licensePage.licenseSearchBtn);

        //test that there is no license displayed
        Thread.sleep(2000);
        Assert.assertFalse(actions.isElementDisplayed(licensePage.licenseTableFirstRowAffiliate));

    }

    @Test(priority = 7)
    public void sortingFunctionality() throws InterruptedException {

        //refresh window
        actions.refreshWindow();

        //clear filter
        actions.clickElement(licensePage.licenseFilterBtn);

        //click clear
        actions.clickElement(licensePage.clearFilterBtn);

        Thread.sleep(4000);
        //click name column
        actions.clickElement(licensePage.licenseNameColumnHeader);

        //choose desc option
        actions.clickElement(licensePage.sortLicenseNameDescOption);

        //test that names are sorted
        Thread.sleep(4000);
        actions.getText(licensePage.licenseTableFirstRowName);
        actions.getText(licensePage.licenseTableSecondRowName);
        System.out.println((actions.getText(licensePage.licenseTableSecondRowName)).compareToIgnoreCase(actions.getText(licensePage.licenseTableFirstRowName)));
        Assert.assertTrue((actions.getText(licensePage.licenseTableSecondRowName)).compareToIgnoreCase(actions.getText(licensePage.licenseTableFirstRowName)) <= 0);

        //click name column
        actions.clickElement(licensePage.licenseNameColumnHeader);

        //choose desc option
        actions.clickElement(licensePage.sortLicenseNameAscOption);

        //test that names are sorted
        Thread.sleep(3000);
        actions.getText(licensePage.licenseTableFirstRowName);
        actions.getText(licensePage.licenseTableSecondRowName);
        System.out.println((actions.getText(licensePage.licenseTableSecondRowName)).compareToIgnoreCase(actions.getText(licensePage.licenseTableFirstRowName)));
        Assert.assertTrue((actions.getText(licensePage.licenseTableSecondRowName)).compareToIgnoreCase(actions.getText(licensePage.licenseTableFirstRowName)) >= 0);

        //refresh page
        actions.refreshWindow();

        //test that sorting is still applied
        Thread.sleep(3000);
        actions.getText(licensePage.licenseTableFirstRowName);
        actions.getText(licensePage.licenseTableSecondRowName);
        System.out.println((actions.getText(licensePage.licenseTableSecondRowName)).compareToIgnoreCase(actions.getText(licensePage.licenseTableFirstRowName)));
        Assert.assertTrue((actions.getText(licensePage.licenseTableSecondRowName)).compareToIgnoreCase(actions.getText(licensePage.licenseTableFirstRowName)) >= 0);


        //remove applied sorting
        actions.clickElement(licensePage.licenseNameColumnHeader);
        actions.clickElement(licensePage.sortLicenseNameAscOption);

        Thread.sleep(3000);

        //click status column
        actions.clickElement(licensePage.licenseStatusColumnHeader);

        //choose desc option
        actions.clickElement(licensePage.sortLicenseStatusDescOption);

        //test that status is sorted
        Thread.sleep(3000);
        actions.getText(licensePage.licenseTableFirstRowStatus);
        actions.getText(licensePage.licenseTableSecondtRowStatus);
        System.out.println((actions.getText(licensePage.licenseTableSecondtRowStatus)).compareToIgnoreCase(actions.getText(licensePage.licenseTableFirstRowStatus)));
        Assert.assertTrue((actions.getText(licensePage.licenseTableSecondtRowStatus)).compareToIgnoreCase(actions.getText(licensePage.licenseTableFirstRowStatus)) <= 0);

        //click status column
        actions.clickElement(licensePage.licenseStatusColumnHeader);

        //choose desc option
        actions.clickElement(licensePage.sortLicenseStatusAscOption);

        //test that status is sorted
        Thread.sleep(3000);
        actions.getText(licensePage.licenseTableFirstRowStatus);
        actions.getText(licensePage.licenseTableSecondtRowStatus);
        System.out.println((actions.getText(licensePage.licenseTableSecondtRowStatus)).compareToIgnoreCase(actions.getText(licensePage.licenseTableFirstRowStatus)));
        Assert.assertTrue((actions.getText(licensePage.licenseTableSecondtRowStatus)).compareToIgnoreCase(actions.getText(licensePage.licenseTableFirstRowStatus)) >= 0);

    }

    public void deleteAffiliate(String affiliateName) throws InterruptedException {
        //click filter
        actions.clickElement(affiliatePage.filterBtn);

        //click clear
        actions.clickElement(affiliatePage.clearFiltersBtn);

        //filter for created affiliate
        Thread.sleep(2000);
        actions.clickElement(affiliatePage.filterBtn);

        //insert affiliate name
        actions.enterText(affiliatePage.filterAffiliateName, affiliateName);
        ;

        //click apply filter
        actions.clickElement(affiliatePage.applyFilterBtn);

        //scroll the table horizontally
        actions.scrollToElementHorizontally(affiliatePage.tableHorizontalScrollBar, 600);
        //click options
        Thread.sleep(2000);
        actions.clickElement(affiliatePage.firstAffiliateOptionsBtn);

        //click delete
        actions.clickElement(affiliatePage.affiliateDeleteOptionBtn);

        //click confirm delete
        actions.clickElement(affiliatePage.confirmDeleteBtn);

        //click filter
        actions.clickElement(affiliatePage.filterBtn);

        //click clear
        actions.clickElement(affiliatePage.clearFiltersBtn);

        //filter for created affiliate
        actions.clickElement(affiliatePage.filterBtn);

        //insert affiliate name
        actions.enterText(affiliatePage.filterAffiliateName, affiliateName);
        ;

        //click apply filter
        actions.clickElement(affiliatePage.applyFilterBtn);

        //test that affiliate is deleted
        Assert.assertFalse(affiliatePage.affiliateNameIsDisplayed());
    }

    @Test(priority = 8)
    public void createAffiliateSuperAdmin() throws InterruptedException {

        //logout and login with the super-admin account
        actions.clickElement(homePage.profileIconBtn);
        actions.clickElement(homePage.signoutBtn);

        Helpers.loginWithValidUser((ChromeDriver) MainTestRunner.ChromeDriver, Credentials.superAdminUsername, Credentials.superAdminPassword);

        //navigate to affiliates page
        Thread.sleep(4000);
        actions.clickElement(homePage.affiliateSidebarBtn);

        //test that licenses button is not visible
        Assert.assertFalse(actions.isElementDisplayed(licensePage.licensesBtn));

        //test that partner column is visible
        Assert.assertTrue(actions.isElementDisplayed(affiliatePage.partnerColumn));

        // click add affiliate button
        actions.clickElement(affiliatePage.addAffiliateBtn);

        //test that max instruments is visible
        Assert.assertTrue(actions.isElementDisplayed(affiliatePage.maxInstruments));

        //click save affiliate without any data
        actions.clickElement(affiliatePage.saveBtn);

        //test that max instruments is required
        Assert.assertEquals(actions.getText(affiliatePage.maxInstrumentsErrorMsg), "Max instruments is required.");

        //test that max instruments only takes positive values
        actions.enterText(affiliatePage.maxInstruments, "0");
        Assert.assertEquals(actions.getText(affiliatePage.maxInstrumentsErrorMsg), "Invalid value: Expected >=1 but received 0");

        //click reset
        actions.clickElement(affiliatePage.resetBtn);

        //insert affiliate name
        Thread.sleep(2000);
        affiliateName = ("Affiliate_" + (MainTestRunner.date)).substring(0, 29);
        actions.enterText(affiliatePage.affiliateName, affiliateName);

        //insert max user
        actions.enterText(affiliatePage.maxUsers, "20");

        //insert max instruments
        actions.enterText(affiliatePage.maxInstruments, "3");

        //choose affiliate type
        actions.chooseFromDropDown(affiliatePage.affiliateType, "Farm");

        //insert abbreviation
        actions.enterText(affiliatePage.affiliateAbbreviation, Helpers.generateRandomString());

        //click save
        actions.clickElement(affiliatePage.saveBtn);

        //click filter
        Thread.sleep(2000);
        actions.clickElement(affiliatePage.filterBtn);

        //insert affiliate name
        actions.enterText(affiliatePage.filterAffiliateName, affiliateName);
        ;

        //click apply filter
        actions.clickElement(affiliatePage.applyFilterBtn);

        //test that affiliate appears
        Thread.sleep(4000);
        Assert.assertEquals(actions.getText(affiliatePage.firstAffiliateName), affiliateName);

        //click actions button
        actions.scrollToElementHorizontally(affiliatePage.tableHorizontalScrollBar, 600);
        actions.clickElement(affiliatePage.firstAffiliateOptionsBtn);

        //test that generate license option is not available
        Assert.assertFalse(actions.isElementDisplayed(affiliatePage.affiliateGenerateLicenseBtn));

        //super-admin attempts to access license page
        MainTestRunner.ChromeDriver.navigate().to(EnvironmentSelector.licenseUrl);

        //test that user was not directed and stayed on affiliate
        Thread.sleep(3000);
        Assert.assertEquals(actions.getCurrentUrl(), EnvironmentSelector.affiliatesUrl);

    }

    @Test(priority = 8)
    public void createAffiliatePartnerAdmin() throws InterruptedException {

        //logout and login with the super-admin account
        actions.clickElement(homePage.profileIconBtn);
        actions.clickElement(homePage.signoutBtn);

        Helpers.loginWithValidUser((ChromeDriver) MainTestRunner.ChromeDriver, Credentials.partnerAdminUsernameTwo, Credentials.partnerAdminPassword);

        //navigate to affiliates page
        Thread.sleep(4000);
        actions.clickElement(homePage.affiliateSidebarBtn);

        // click add affiliate button
        actions.clickElement(affiliatePage.addAffiliateBtn);

        //test that max instruments is visible
        Assert.assertTrue(actions.isElementDisplayed(affiliatePage.maxInstruments));

        //click save affiliate without any data
        actions.clickElement(affiliatePage.saveBtn);

        //test that max instruments is required
        Assert.assertEquals(actions.getText(affiliatePage.maxInstrumentsErrorMsg), "Max instruments is required.");

        //test that max instruments only takes positive values
        actions.enterText(affiliatePage.maxInstruments, "0");
        Assert.assertEquals(actions.getText(affiliatePage.maxInstrumentsErrorMsg), "Invalid value: Expected >=1 but received 0");

        //click reset
        actions.clickElement(affiliatePage.resetBtn);

        //insert affiliate name
        Thread.sleep(2000);
        affiliateName = ("Affiliate_" + (MainTestRunner.date)).substring(0, 28);
        actions.enterText(affiliatePage.affiliateName, affiliateName);

        //insert max user
        actions.enterText(affiliatePage.maxUsers, "20");

        //test that max instruments cannot take a value more than max of main affiliate
        actions.enterText(affiliatePage.maxInstruments, "900");

        //insert max instruments
        actions.enterText(affiliatePage.maxInstruments, "3");

        //choose affiliate type
        actions.chooseFromDropDown(affiliatePage.affiliateType, "Farm");

        //insert abbreviation
        actions.enterText(affiliatePage.affiliateAbbreviation, Helpers.generateRandomString());

        //click save
        actions.clickElement(affiliatePage.saveBtn);

        //test that the affiliate cannot be created due to number of max instruments
        Assert.assertTrue(licensePage.getNotificationText().contains("The Max Instruments value exceeds the sold licenses for the whole Affiliate. The remaining available count is"));
        Assert.assertTrue(licensePage.getNotificationText().contains("Please add only the allowed Max Instruments value or contact the support to extend your license."));

        //insert a valid max instruments
        //insert max instruments
        Thread.sleep(4000);
        actions.clearText(affiliatePage.maxInstruments);
        actions.enterText(affiliatePage.maxInstruments, "3");

        //click save
        actions.clickElement(affiliatePage.saveBtn);


        //click filter
        Thread.sleep(2000);
        actions.clickElement(affiliatePage.filterBtn);

        //insert affiliate name
        actions.enterText(affiliatePage.filterAffiliateName, affiliateName);
        ;

        //click apply filter
        actions.clickElement(affiliatePage.applyFilterBtn);
        //test that affiliate appears
        Thread.sleep(4000);
        Assert.assertEquals(actions.getText(affiliatePage.firstAffiliateName), affiliateName);

    }

    @Test(priority = 9)
    public void accessRights() throws InterruptedException {
        //logout and login with the admin account
        actions.clickElement(homePage.profileIconBtn);
        actions.clickElement(homePage.signoutBtn);

        Helpers.loginWithValidUser((ChromeDriver) MainTestRunner.ChromeDriver, Credentials.adminUsername, Credentials.adminPassword);

        Thread.sleep(4000);
        String currentUrl=MainTestRunner.ChromeDriver.getCurrentUrl();
        MainTestRunner.ChromeDriver.navigate().to(EnvironmentSelector.licenseUrl);

        //test that user was not directed and stayed on same page
        Thread.sleep(2000);
        Assert.assertEquals(actions.getCurrentUrl(),currentUrl);

        //logout and login with the admin account
        actions.clickElement(homePage.profileIconBtn);
        actions.clickElement(homePage.signoutBtn);

        Helpers.loginWithValidUser((ChromeDriver) MainTestRunner.ChromeDriver, Credentials.userName, Credentials.userPassword);

        Thread.sleep(4000);
         currentUrl=MainTestRunner.ChromeDriver.getCurrentUrl();
        MainTestRunner.ChromeDriver.navigate().to(EnvironmentSelector.licenseUrl);

        //test that user was not directed and stayed on same page
        Thread.sleep(2000);
        Assert.assertEquals(actions.getCurrentUrl(),currentUrl);
    }

}
