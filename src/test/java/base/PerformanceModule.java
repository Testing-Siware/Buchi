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
import pages.UsersPage;
import utils.Helpers;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.util.ArrayList;

public class PerformanceModule {
    ArrayList<String> createdPartnerAdmins;
    ArrayList<String> createdAffiliates;
    ArrayList<String> createdSubAffiliates;
    ArrayList<String> createdAdmins;
    HomePage homePage;
    AffiliatePage affiliatePage;
    UsersPage usersPage;
    Actions actions;

    @BeforeClass
    public void initializeClasses() throws InterruptedException {
        createdPartnerAdmins = new ArrayList<>();
        createdAffiliates = new ArrayList<>();
        createdSubAffiliates = new ArrayList<>();
        createdAdmins = new ArrayList<>();
        homePage = new HomePage((ChromeDriver) MainTestRunner.ChromeDriver);
        affiliatePage = new AffiliatePage((ChromeDriver) MainTestRunner.ChromeDriver);
        usersPage = new UsersPage((ChromeDriver) MainTestRunner.ChromeDriver);
        actions= new Actions((ChromeDriver) MainTestRunner.ChromeDriver,20);

        //logout and login with super admin
        actions.clickElement(homePage.profileIconBtn);
        actions.clickElement(homePage.signoutBtn);

        Helpers.loginWithValidUser((ChromeDriver) MainTestRunner.ChromeDriver, Credentials.superAdminUsername, Credentials.superAdminPassword);
    }

    //helper method to create an affiliate
    public void createAffiliate(int affiliateNumber) throws InterruptedException {

        //setup affiliate name & partner admin email
        String affiliateName="MainAFF";

        if(affiliateNumber<=9){
            affiliateName+="00"+affiliateNumber;
        }
        else {
            if (affiliateNumber <= 99) {
                affiliateName += "0" + affiliateNumber;
            } else {
                affiliateName += affiliateNumber;
            }
        }

        //navigate to affiliates page
        actions.clickElement(homePage.affiliateSidebarBtn);
        actions.clickElement(affiliatePage.addAffiliateBtn);

        Thread.sleep(2000);
        actions.enterText(affiliatePage.affiliateName,affiliateName);

        //insert max user
        actions.enterText(affiliatePage.maxUsers,"50");;

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
        Thread.sleep(2000);
        actions.clearText(affiliatePage.filterAffiliateName);
        actions.enterText(affiliatePage.filterAffiliateName,affiliateName);

        //click apply filter
        actions.clickElement(affiliatePage.applyFilterBtn);

        //test that affiliate appears
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(affiliatePage.firstAffiliateName), affiliateName);
        System.out.println(affiliateName+" created successfully!");
        createdAffiliates.add(affiliateName);
    }

    //helper method to create partner admin
    public void createPartnerAdmin(int partnerAdminNumber) throws InterruptedException {
        String firstName;
        String lastName;
        String affiliateName;

        //setup affiliate name & partner admin email
        String partnerAdminEmail="partnerAdmin";

        if(partnerAdminNumber<=9){
            partnerAdminEmail+="00"+partnerAdminNumber+"@si-ware.com";
        }
        else {
            if (partnerAdminNumber <= 99) {
                partnerAdminEmail += "0" + partnerAdminNumber + "@si-ware.com";
            } else {
                partnerAdminEmail += partnerAdminNumber + "@si-ware.com";
            }
        }
        firstName=partnerAdminEmail.split("@")[0];
        lastName=partnerAdminEmail.split("@")[0];
        affiliateName="MainAff"+partnerAdminEmail.split("@")[0].substring(12);
        System.out.println("The affiliate name: "+affiliateName);
        //navigate to users page
        actions.clickElement(homePage.usersSidebarBtn);

        //click add user
        actions.clickElement(usersPage.addUserBtn);

        //insert user data
        Thread.sleep(3000);

        //insert first name
        actions.enterText(usersPage.firstNameCreateTextField,partnerAdminEmail.split("@")[0]);

        //insert last name
        actions.enterText(usersPage.lastNameCreateTextField,partnerAdminEmail.split("@")[0]);

        //insert email
        actions.enterText(usersPage.createEmailTextField,partnerAdminEmail);

        //insert password and password confirmation
        actions.enterText(usersPage.passwordTextField,Credentials.adminPassword);
        actions.enterText(usersPage.confirmPasswordTextField,Credentials.adminPassword);

        //select affiliate
        actions.chooseFromDropDown(usersPage.superAdminAffiliateDropDown,affiliateName);

        //select role
        actions.chooseFromDropDown(usersPage.superAdminRoleDropDown,"PartnerAdmin");

        actions.clickElement(usersPage.superAdminAddAffiliateBtn);

        //click save
        actions.clickElement(usersPage.saveBtn);

        //filter for created user
        //click filter button
        Thread.sleep(2000);
        actions.clickElement(usersPage.filterBtn);

        //filter by first name to test user is created
        Thread.sleep(2000);
        actions.clearText(usersPage.firstNameFilterTextField);
        actions.enterText(usersPage.firstNameFilterTextField,firstName);

        //click apply
        actions.clickElement(usersPage.applyFiltersBtn);

        //test that user appears
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(usersPage.filteredUserName), firstName + " " + lastName);
        System.out.println(partnerAdminEmail.split("@")[0]+" created successfully!");
        createdPartnerAdmins.add(partnerAdminEmail);
    }

    @Test(dependsOnMethods = "deleteAffliates")
    @Ignore
    public void createAffiliates() throws InterruptedException {
        //create 500 affiliate
        for(int i=0;i<1;i++){
            createAffiliate(i+1);
        }
    }

    @Test(priority =1)
    @Ignore
    public void createPartnerAdmins() throws InterruptedException {
        for(int i=4;i<99;i++){
            createPartnerAdmin(i+1);
        }
    }

    //helper method to create sub-affiliate
    public String createSubAffiliate(int affiliateNumber) throws InterruptedException {
        //initialise affiliate name
        String affiliateName="SubAFF";

        if(affiliateNumber<=9){
            affiliateName+="000"+affiliateNumber;
        }
        else {
            if (affiliateNumber <= 99) {
                affiliateName += "00" + affiliateNumber;
            } else{if(affiliateNumber<=999) {
                affiliateName += "0"+affiliateNumber;
            }
            else {
                affiliateName += affiliateNumber;
            }
            }
        }

        //navigate to affiliates page
        actions.clickElement(homePage.affiliateSidebarBtn);
        actions.clickElement(affiliatePage.addAffiliateBtn);

        Thread.sleep(2000);
        actions.enterText(affiliatePage.affiliateName,affiliateName);

        //insert max user
        actions.enterText(affiliatePage.maxUsers,"50");;

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
        Thread.sleep(2000);
        actions.clearText(affiliatePage.filterAffiliateName);
        actions.enterText(affiliatePage.filterAffiliateName,affiliateName);

        //click apply filter
        actions.clickElement(affiliatePage.applyFilterBtn);

        //test that affiliate appears
        Thread.sleep(4000);
        Assert.assertEquals(actions.getText(affiliatePage.firstAffiliateName), affiliateName);
        System.out.println(affiliateName+" created successfully!");
        createdSubAffiliates.add(affiliateName);

        //generate license key for affiliate
        //click options
        actions.scrollToElementHorizontally(affiliatePage.tableHorizontalScrollBar, 500);
        actions.clickElement(affiliatePage.firstAffiliateOptionsBtn);

        //click generate license option
        actions.clickElement(affiliatePage.affiliateGenerateLicenseBtn);

        //test that confirmation dialog box appears
        Assert.assertTrue(actions.isElementDisplayed(affiliatePage.confirmLicenseGenerateBtn));

        //confirm license generation
        actions.clickElement(affiliatePage.confirmLicenseGenerateBtn);
        System.out.println("License key generated for affiliate: "+affiliateName+"!");

        Thread.sleep(2000);
        return affiliateName;
    }

    //helper method to create admins to sub-affiliates
    public void createAdminsToSubAffiliates(int adminNumber,String affiliateName) throws InterruptedException {
        //setup admin data
        String adminEmail="admin";
        String firstName;
        String lastName;

        if(adminNumber<=9){
            adminEmail+="000"+adminNumber+"@si-ware.com";
        }
        else {
            if (adminNumber <= 99) {
                adminEmail+= "00" + adminNumber + "@si-ware.com";
            } else {
                if(adminNumber<=999) {
                    adminEmail+= "0"+adminNumber+"@si-ware.com";
                }
                else{
                adminEmail += adminNumber + "@si-ware.com";
                }
            }
        }
        firstName=adminEmail.split("@")[0];
        lastName=adminEmail.split("@")[0];

        //navigate to users page
        actions.clickElement(homePage.usersSidebarBtn);

        //click add user
        actions.clickElement(usersPage.addUserBtn);

        //insert user data
        Thread.sleep(3000);

        //insert first name
        actions.enterText(usersPage.firstNameCreateTextField,adminEmail.split("@")[0]);

        //insert last name
        actions.enterText(usersPage.lastNameCreateTextField,adminEmail.split("@")[0]);

        //insert email
        actions.enterText(usersPage.createEmailTextField,adminEmail);

        //insert password and password confirmation
        actions.enterText(usersPage.passwordTextField,Credentials.adminPassword);
        actions.enterText(usersPage.confirmPasswordTextField,Credentials.adminPassword);

        //select affiliate
        actions.chooseFromDropDown(usersPage.affiliateDropDown,affiliateName);

        //select role
        actions.chooseFromDropDown(usersPage.roleDropDown,"Admin");

        actions.clickElement(usersPage.superAdminAddAffiliateBtn);

        //click save
        actions.clickElement(usersPage.saveBtn);

        //filter for created user
        //click filter button
        Thread.sleep(2000);
        actions.clickElement(usersPage.filterBtn);

        //filter by first name to test user is created
        Thread.sleep(2000);
        actions.clearText(usersPage.firstNameFilterTextField);
        actions.enterText(usersPage.firstNameFilterTextField,firstName);

        //click apply
        actions.clickElement(usersPage.applyFiltersBtn);

        //test that user appears
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(usersPage.filteredUserName), firstName + " " + lastName);
        System.out.println(adminEmail.split("@")[0]+" created successfully!");
        createdAdmins.add(adminEmail);
    }

    @Test(priority = 2)
    public void createSubAffiliates() throws InterruptedException {
        String partnerAdminEmail;
        String affiliateName;
        for(int i=22;i<500;i++){
            partnerAdminEmail="partnerAdmin";

            if((i+1)<=9){
                partnerAdminEmail+="00"+(i+1)+"@si-ware.com";
            }
            else {
                if ((i+1) <= 99) {
                    partnerAdminEmail += "0" + (i+1) + "@si-ware.com";
                } else {
                    partnerAdminEmail += (i+1) + "@si-ware.com";
                }
            }

            //logout from user
            actions.clickElement(homePage.profileIconBtn);
            actions.clickElement(homePage.signoutBtn);

            //login with the desired partner admin
            Helpers.loginWithValidUser((ChromeDriver) MainTestRunner.ChromeDriver,partnerAdminEmail, Credentials.adminPassword);

            for(int j=0;j<20;j++){
                affiliateName=createSubAffiliate(i*20+(j+1));
                createAdminsToSubAffiliates(i*20+(j+1),affiliateName);
            }
        }
    }

    @Test(priority = 3)
    public void createAdminsToSubAffiliates() throws InterruptedException {
        for(int i=0;i<500;i++){
        }
    }
}
