package base;

import data.Credentials;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UsersPage;
import utils.Helpers;

import java.util.Date;

public class UsersModule {
    UsersPage usersPage;
    HomePage homePage;
    String userFirstName;
    String userLastName;
    String userEmail;

    @Test(priority = 0)
    public void createInvalidUserBySupport() throws InterruptedException {
        usersPage = new UsersPage((ChromeDriver) MainTestRunner.ChromeDriver);
        homePage = new HomePage((ChromeDriver) MainTestRunner.ChromeDriver);

        //navigate to users page
        Thread.sleep(2000);
        homePage.clickUsersSidebarBtn();

        //click add user
        usersPage.clickAddUserBtn();

        //click save without entering any data
        usersPage.clickSaveBtn();

        //test that error messages appear for requried data (first name , last name , etc..)
        Assert.assertEquals(usersPage.getFirstNameErrorMsg(), "First name is required.");
        Assert.assertEquals(usersPage.getLastNameErrorMsg(), "Last name is required.");
        Assert.assertEquals(usersPage.getAffiliateErrorMsg(), "Affiliate is required.");
        Assert.assertEquals(usersPage.getRoleErrorMsg(), "Role is required.");
        Assert.assertEquals(usersPage.getEmailErrorMsg(), "Email is too short. it must be at least 1 characters long.");
        Assert.assertEquals(usersPage.getPasswordErrorMsg(), "Password is too short. it must be at least 8 characters long.");

        //test that password confirmation must be equal to password
        usersPage.sendTextToConfirmPasswordField("a");
        Assert.assertEquals(usersPage.getConfirmPasswordErrorMsg(), "Passwords do not match");

        //test that email must be of valid form
        usersPage.sendTextToCreateEmailField("not a valid email address");
        Assert.assertEquals(usersPage.getEmailErrorMsg(), "Please enter a valid email address.");

        //test that password cannot be more than 20 characters
        usersPage.sendTextToPasswordField("This password is longer than required");
        Assert.assertEquals(usersPage.getPasswordErrorMsg(), "Password is too long. it must be no more than 20 characters long.");

        //test that password contains all required symbols
        usersPage.clearPasswordField();
        usersPage.sendTextToPasswordField("abcdefgh");
        Assert.assertEquals(usersPage.getPasswordErrorMsg(), "Password must be between 8 and 20 characters long, and include at least one uppercase letter, one lowercase letter, one number, and one special character (e.g., @$!%*?&).");

        //test that first and last name cannot be more than 30 characters
        usersPage.sendTextToFirstNameCreateFieldText("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
        Thread.sleep(2000);
        Assert.assertEquals(usersPage.getFirstNameErrorMsg(), "First name is too long. it must be no more than 30 characters long.");

        usersPage.sendTextToLastNameCreateFieldText("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
        Assert.assertEquals(usersPage.getLastNameErrorMsg(), "Last name is too long. it must be no more than 30 characters long.");

        //click cancel
        usersPage.clickCancelBtn();
    }

    @Test(priority = 0)
    public void createPartnerAdminUserBySupport() throws InterruptedException {
        usersPage = new UsersPage((ChromeDriver) MainTestRunner.ChromeDriver);
        homePage = new HomePage((ChromeDriver) MainTestRunner.ChromeDriver);

        //navigate to users page
        homePage.clickUsersSidebarBtn();

        //clear any preset filter
        usersPage.clickFilterBtn();
        usersPage.clickClearFiltersBtn();
        usersPage.clickApplyFiltersBtn();

        //click add user
        usersPage.clickAddUserBtn();

        //insert user data
        Thread.sleep(3000);
        userFirstName = "FirstName_" + MainTestRunner.CurrentTestTime;
        userLastName = "LastName_" + MainTestRunner.CurrentTestTime;
        userEmail = "Email_" + Helpers.generateRandomString() + "@email.com";

        //insert first name
        usersPage.sendTextToFirstNameCreateFieldText(userFirstName);

        //insert last name
        usersPage.sendTextToLastNameCreateFieldText(userLastName);

        //choose affiliate
        usersPage.sendTextToAffiliateDropDown("Buchi");

        //select role
        usersPage.sendTextToRoleDropDown("PartnerAdmin");

        //insert email
        usersPage.sendTextToCreateEmailField(userEmail);

        //insert password and password confirmation
        usersPage.sendTextToPasswordField(Credentials.adminPassword);
        usersPage.sendTextToConfirmPasswordField(Credentials.adminPassword);

        //click save
        usersPage.clickSaveBtn();


        //filter for created user

        //click filter button
        usersPage.clickFilterBtn();

        //filter by first name to test user is created
        Thread.sleep(2000);
        usersPage.sendTextToFirstNameFilter(userFirstName);

        //click apply
        usersPage.clickApplyFiltersBtn();

        //test that user appears
        Thread.sleep(3000);
        Assert.assertEquals(usersPage.getFilteredUserNameText(), userFirstName + " " + userLastName);

        deleteUser(userFirstName);

    }

    @Test(priority = 0)
    public void createPartnerUserUserySupport() throws InterruptedException {
        usersPage = new UsersPage((ChromeDriver) MainTestRunner.ChromeDriver);
        homePage = new HomePage((ChromeDriver) MainTestRunner.ChromeDriver);

        //navigate to users page
        homePage.clickUsersSidebarBtn();

        //clear any preset filter
        usersPage.clickFilterBtn();
        usersPage.clickClearFiltersBtn();
        usersPage.clickApplyFiltersBtn();


        //click add user
        usersPage.clickAddUserBtn();

        //insert user data
        Thread.sleep(3000);
        userFirstName = "FirstName_" + MainTestRunner.CurrentTestTime;
        userLastName = "LastName_" + MainTestRunner.CurrentTestTime;
        userEmail = "Email_" + Helpers.generateRandomString() + "@email.com";

        //insert first name
        usersPage.sendTextToFirstNameCreateFieldText(userFirstName);

        //insert last name
        usersPage.sendTextToLastNameCreateFieldText(userLastName);

        //choose affiliate
        usersPage.sendTextToAffiliateDropDown("Buchi");

        //select role
        usersPage.sendTextToRoleDropDown("PartnerUser");

        //insert email
        usersPage.sendTextToCreateEmailField(userEmail);

        //insert password and password confirmation
        usersPage.sendTextToPasswordField(Credentials.adminPassword);
        usersPage.sendTextToConfirmPasswordField(Credentials.adminPassword);

        //click save
        usersPage.clickSaveBtn();

        //filter for created user

        //click filter button
        usersPage.clickFilterBtn();

        //filter by first name to test user is created
        usersPage.sendTextToFirstNameFilter(userFirstName);

        //click apply
        usersPage.clickApplyFiltersBtn();

        //test that user appears
        Thread.sleep(2000);
        Assert.assertEquals(usersPage.getFilteredUserNameText(), userFirstName + " " + userLastName);

        deleteUser("first");
    }

    @Test(priority = 0)
    public void createAdminUserBySupport() throws InterruptedException {
        usersPage = new UsersPage((ChromeDriver) MainTestRunner.ChromeDriver);
        homePage = new HomePage((ChromeDriver) MainTestRunner.ChromeDriver);

        //navigate to users page
        homePage.clickUsersSidebarBtn();

        //clear any preset filter
        Thread.sleep(2000);
        usersPage.clickFilterBtn();
        usersPage.clickClearFiltersBtn();
        usersPage.clickApplyFiltersBtn();


        //clear any preset filter
        usersPage.clickFilterBtn();
        usersPage.clickClearFiltersBtn();
        usersPage.clickApplyFiltersBtn();

        //click add user
        usersPage.clickAddUserBtn();

        //insert user data
        Thread.sleep(3000);
        userFirstName = "FirstName_" + MainTestRunner.CurrentTestTime;
        userLastName = "LastName_" + MainTestRunner.CurrentTestTime;
        userEmail = "Email_" + Helpers.generateRandomString() + "@email.com";

        //insert first name
        usersPage.sendTextToFirstNameCreateFieldText(userFirstName);

        //insert last name
        usersPage.sendTextToLastNameCreateFieldText(userLastName);

        //choose affiliate
        Thread.sleep(2000);
        usersPage.sendTextToAffiliateDropDown("Sub1");

        //select role
        usersPage.sendTextToRoleDropDown("Admin");

        //insert email
        usersPage.sendTextToCreateEmailField(userEmail);

        //insert password and password confirmation
        usersPage.sendTextToPasswordField(Credentials.adminPassword);
        usersPage.sendTextToConfirmPasswordField(Credentials.adminPassword);

        //click save
        usersPage.clickSaveBtn();

        //filter for created user

        //click filter button
        usersPage.clickFilterBtn();

        //filter by first name to test user is created
        usersPage.sendTextToFirstNameFilter(userFirstName);

        //click apply
        usersPage.clickApplyFiltersBtn();

        //test that user appears
        Thread.sleep(3000);
        Assert.assertEquals(usersPage.getFilteredUserNameText(), userFirstName + " " + userLastName);

        deleteUser(userFirstName);

    }

    @Test(priority = 0)
    public void createUserBySupport() throws InterruptedException {
        usersPage = new UsersPage((ChromeDriver) MainTestRunner.ChromeDriver);
        homePage = new HomePage((ChromeDriver) MainTestRunner.ChromeDriver);

        //navigate to users page
        homePage.clickUsersSidebarBtn();

        //clear any preset filter
        usersPage.clickFilterBtn();
        usersPage.clickClearFiltersBtn();
        usersPage.clickApplyFiltersBtn();



        //click add user
        usersPage.clickAddUserBtn();

        //insert user data
        Thread.sleep(3000);
        userFirstName = "FirstName_" + MainTestRunner.CurrentTestTime;
        userLastName = "LastName_" + MainTestRunner.CurrentTestTime;
        userEmail = "Email_" + Helpers.generateRandomString() + "@email.com";

        //insert first name
        usersPage.sendTextToFirstNameCreateFieldText(userFirstName);

        //insert last name
        usersPage.sendTextToLastNameCreateFieldText(userLastName);

        //choose affiliate
        usersPage.sendTextToAffiliateDropDown("Sub1");

        //select role
        usersPage.sendTextToRoleDropDown("User");

        //insert email
        usersPage.sendTextToCreateEmailField(userEmail);

        //insert password and password confirmation
        usersPage.sendTextToPasswordField(Credentials.adminPassword);
        usersPage.sendTextToConfirmPasswordField(Credentials.adminPassword);

        //click save
        usersPage.clickSaveBtn();

        //filter for created user

        //click filter button
        usersPage.clickFilterBtn();

        //filter by first name to test user is created
        usersPage.sendTextToFirstNameFilter(userFirstName);

        //click apply
        usersPage.clickApplyFiltersBtn();

        //test that user appears
        Thread.sleep(2000);
        Assert.assertEquals(usersPage.getFilteredUserNameText(), userFirstName + " " + userLastName);

    }

    @Test(priority = 1)
    public void cancelUserEdits() throws InterruptedException {

        //clear any preset filter
        Thread.sleep(2000);
        usersPage.clickFilterBtn();
        usersPage.clickClearFiltersBtn();

        //filter by username
        Thread.sleep(2000);
        usersPage.clickClearFiltersBtn();

        //filter by first name to test user is created
        usersPage.sendTextToFirstNameFilter(userFirstName);

        //click apply
        usersPage.clickApplyFiltersBtn();

        //click actions button
        usersPage.clickActionsBtn();

        //click edit
        usersPage.clickEditUserOption();

        //clear all fields
        Thread.sleep(3000);
        usersPage.clearFirstNameEditField();
        usersPage.clearLastNameEditField();
        usersPage.clearEditEmailField();

        //insert first name
        usersPage.sendTextToFirstNameEditFieldText("Any Name");
        usersPage.sendTextToLastNameEditFieldText("Any Name");
        usersPage.sendTextToEditEmailField("Any_email@mail.com");

        //click reset
        usersPage.clickResetEditBtn();

        //click save
        usersPage.clickSaveEditsBtn();

        //click submit
        usersPage.clickConfirmEditBtn();

        //filter for created user

        //click filter button
        usersPage.clickFilterBtn();

        //filter by first name to test user is created
        usersPage.sendTextToFirstNameFilter(userFirstName);

        //click apply
        usersPage.clickApplyFiltersBtn();

        //test that user appears
        Assert.assertEquals(usersPage.getFilteredUserNameText(), userFirstName + " " + userLastName);
    }

    @Test(priority = 1)
    public void editUser() throws InterruptedException {

        //clear any preset filter
        usersPage.clickFilterBtn();
        usersPage.clickClearFiltersBtn();

        //filter by username
        Thread.sleep(2000);
        usersPage.clickClearFiltersBtn();

        //filter by first name to test user is created
        usersPage.sendTextToFirstNameFilter(userFirstName);

        //click apply
        usersPage.clickApplyFiltersBtn();

        //click actions button
        usersPage.clickActionsBtn();

        //click edit
        usersPage.clickEditUserOption();

        //clear all fields
        Thread.sleep(2000);
        usersPage.clearFirstNameEditField();
        usersPage.clearLastNameEditField();
        usersPage.clearEditEmailField();

        //insert first name
        userFirstName = "EditedFirst" + MainTestRunner.CurrentTestTime;
        userLastName = "EditedLast" + MainTestRunner.CurrentTestTime;
        userEmail = "EditedEmail" + Helpers.generateRandomString() + "@email.com";

        usersPage.sendTextToFirstNameEditFieldText(userFirstName);
        usersPage.sendTextToLastNameEditFieldText(userLastName);
        usersPage.sendTextToEditEmailField(userEmail);

        //click save
        usersPage.clickSaveEditsBtn();

        //click submit
        usersPage.clickConfirmEditBtn();

        //clear any preset filter
        usersPage.clickFilterBtn();
        usersPage.clickClearFiltersBtn();

        //filter by first name to test user is edited
        usersPage.sendTextToFirstNameFilter(userFirstName);

        //click apply
        usersPage.clickApplyFiltersBtn();

        //test that user appears
        Thread.sleep(2000);
        Assert.assertEquals(usersPage.getFilteredUserNameText(), userFirstName + " " + userLastName);
    }

    @Test(priority = 2)
    public void filterByFirstName() throws InterruptedException {

        //clear any preset filter
        usersPage.clickFilterBtn();
        usersPage.clickClearFiltersBtn();

        //filter by first name
        usersPage.sendTextToFirstNameFilter(userFirstName);
        usersPage.clickApplyFiltersBtn();

        //test that results appear
        Thread.sleep(2000);
        Assert.assertTrue(usersPage.getFilteredUserNameText().contains(userFirstName));

    }

    @Test(priority = 2)
    public void filterByLastName() throws InterruptedException {

        //clear any preset filter
        usersPage.clickFilterBtn();
        usersPage.clickClearFiltersBtn();

        //filter by last name
        usersPage.sendTextToLastNameFilter(userLastName);
        usersPage.clickApplyFiltersBtn();

        //test that results appear
        Thread.sleep(2000);
        Assert.assertTrue(usersPage.getFilteredUserNameText().contains(userLastName));

    }

    @Test(priority = 2)
    public void filterByEmail() throws InterruptedException {

        //clear any preset filter
        usersPage.clickFilterBtn();
        usersPage.clickClearFiltersBtn();


        //filter by last name
        usersPage.sendTextToEmailFilter(userEmail);
        usersPage.clickApplyFiltersBtn();

        //test that results appear
        Thread.sleep(2000);
        Assert.assertEquals(usersPage.getFilteredEmailText(), userEmail);
    }

    @Test(priority = 2)
    public void toggleColumns() throws InterruptedException {

        //clear any preset filter
        usersPage.clickFilterBtn();
        usersPage.clickClearFiltersBtn();
        usersPage.clickApplyFiltersBtn();

        //click view
        Thread.sleep(2000);
        usersPage.clickViewBtn();
        usersPage.clickToggleCreatedAtColumn();

        //test that column is not visible and the fifth column is modified at
        Assert.assertEquals(usersPage.getFifthColumnHeaderText(), "Modified at");

        //click view
        Thread.sleep(2000);
        usersPage.clickViewBtn();
        usersPage.clickToggleCreatedAtColumn();

        //test that column is  visible and the fifth column is created at
        Assert.assertEquals(usersPage.getFifthColumnHeaderText(), "Created at");

        //hide both created at and modified at
        //click view
        Thread.sleep(2000);
        usersPage.clickViewBtn();
        usersPage.clickToggleCreatedAtColumn();

        Thread.sleep(2000);
        usersPage.clickViewBtn();
        usersPage.clickToggleModifiedAtColumn();

        //reset the to default view (both columns viewed)
        //click view
        Thread.sleep(2000);
        usersPage.clickViewBtn();
        usersPage.clickToggleCreatedAtColumn();

        Thread.sleep(2000);
        usersPage.clickViewBtn();
        usersPage.clickToggleModifiedAtColumn();


        //test that there is no fifth column
        Assert.assertFalse(usersPage.isFifthColumnHeaderDisplayed());

    }

    @Test(priority = 2)
    public void searchUser() throws InterruptedException {

        //clear any preset filter
        usersPage.clickFilterBtn();
        usersPage.clickClearFiltersBtn();
        usersPage.clickApplyFiltersBtn();

        //click filter
        usersPage.clickFilterBtn();

        //insert first name
        usersPage.sendTextToFirstNameFilter(userFirstName);

        //click apply
        usersPage.clickApplyFiltersBtn();


        //test that user appears
        Thread.sleep(2000);
        Assert.assertEquals(usersPage.getFilteredUserNameText(), userFirstName + " " + userLastName);

        //clear search field by refreshing the browser
        usersPage.refreshWindow();
        Thread.sleep(3000);
    }

    @Test(priority = 2)
    public void sortData() throws InterruptedException {
        //clear any preset filter
        usersPage.clickFilterBtn();
        usersPage.clickClearFiltersBtn();
        usersPage.clickApplyFiltersBtn();

        //test sort by name ascending
        usersPage.clickSortByName();
        usersPage.clickSortAscBtn();
        Thread.sleep(2000);

        Assert.assertTrue(usersPage.getFilteredUserNameText().compareTo(usersPage.getSecondUsernameText()
        ) <= 0);

        //test sort name descending
        Thread.sleep(2000);
        usersPage.clickSortByName();
        usersPage.clickSortDescBtn();
        Thread.sleep(2000);
        Assert.assertTrue(usersPage.getFilteredUserNameText().compareTo(usersPage.getSecondUsernameText()
        ) >= 0);

        //test sort by email ascending
        usersPage.clickSortByEmailBtn();
        usersPage.clickSortAscBtn();
        Thread.sleep(2000);
        Assert.assertTrue(usersPage.getFilteredEmailText().compareTo(usersPage.getSecondEmailText()
        ) <= 0);

        //test sort email descending
        usersPage.clickSortByEmailBtn();
        usersPage.clickSortDescBtn();
        Thread.sleep(2000);
        System.out.println(usersPage.getFilteredUserNameText());
        System.out.println(usersPage.getSecondUsernameText());
        Assert.assertTrue(usersPage.getFilteredEmailText().compareTo(usersPage.getSecondEmailText()
        ) >= 0);

        //test sort created at ascending
        usersPage.clickSortByCreatedAtBtn();
        usersPage.clickSortAscBtn();
        Thread.sleep(2000);
        Date firstDate = new Date(usersPage.getFilteredCreatedAtText());
        Date secondDate = new Date(usersPage.getFilteredModifiedAtText());

        Assert.assertTrue(firstDate.compareTo(secondDate) <= 0);

        //test sort created at descending
        usersPage.clickSortByCreatedAtBtn();
        usersPage.clickSortDescBtn();
        Thread.sleep(2000);
        firstDate = new Date(usersPage.getFilteredCreatedAtText());
        secondDate = new Date(usersPage.getFilteredModifiedAtText());

        Assert.assertTrue(firstDate.compareTo(secondDate) <= 0);


        //test sort modified at ascending
        usersPage.clickSortByModifiedAtBtn();
        usersPage.clickSortAscBtn();
        Thread.sleep(2000);
        firstDate = new Date(usersPage.getFilteredCreatedAtText());
        secondDate = new Date(usersPage.getFilteredModifiedAtText());

        Assert.assertTrue(firstDate.compareTo(secondDate) <= 0);

        //test sort created at descending
        usersPage.clickSortByModifiedAtBtn();
        usersPage.clickSortDescBtn();
        Thread.sleep(2000);
        firstDate = new Date(usersPage.getFilteredCreatedAtText());
        secondDate = new Date(usersPage.getFilteredModifiedAtText());

        Assert.assertTrue(firstDate.compareTo(secondDate) <= 0);
    }

    @Test(priority = 3)
    public void deleteUser() throws InterruptedException {
        //clear any preset filter
        usersPage.clickFilterBtn();
        usersPage.clickClearFiltersBtn();
        usersPage.clickApplyFiltersBtn();

        //filter by first name
        usersPage.clickFilterBtn();
        usersPage.sendTextToFirstNameFilter(userFirstName);
        usersPage.clickApplyFiltersBtn();

        /*
        //click actions
        Thread.sleep(2000);
        usersPage.clickActionsBtn();

        //click delete
        usersPage.clickDeleteUserOption();

        //cancel cancel
        usersPage.clickCancelDeleteBtn();

        //test that user still exists
        Assert.assertEquals(usersPage.getFilteredUserNameText(), userFirstName + " " + userLastName);
*/
        //click actions
        Thread.sleep(2000);
        usersPage.clickActionsBtn();

        //click delete
        usersPage.clickDeleteUserOption();

        //click confirm delete
        usersPage.clickConfirmDeleteBtn();

        //clear any preset filter
        usersPage.refreshWindow();

        Thread.sleep(4000);
        usersPage.clickFilterBtn();
        usersPage.clickClearFiltersBtn();
        usersPage.clickApplyFiltersBtn();

        //filter by first name
        usersPage.clickFilterBtn();
        usersPage.sendTextToFirstNameFilter("first");
        usersPage.clickApplyFiltersBtn();

        //test that user is deleted and no results image is displayed
        Thread.sleep(3000);
        Assert.assertFalse(usersPage.isSearchResultsDisplayed());
    }

    @Test(priority = 4)
    public void invalidFirstnameFilter() throws InterruptedException {

        //clear any preset filter
        usersPage.clickFilterBtn();
        usersPage.clickClearFiltersBtn();

        //filter by first name
        usersPage.sendTextToFirstNameFilter(userFirstName);
        usersPage.clickApplyFiltersBtn();

        //test that no results appear
        Thread.sleep(2000);
        Assert.assertFalse(usersPage.isSearchResultsDisplayed());
    }

    @Test(priority = 4)
    public void invalidLastnameFilter() throws InterruptedException {
        //clear any preset filter
        Thread.sleep(2000);
        usersPage.clickFilterBtn();
        usersPage.clickClearFiltersBtn();

        //filter by first name
        usersPage.sendTextToLastNameFilter(userLastName);
        usersPage.clickApplyFiltersBtn();

        //test that no results appear
        Thread.sleep(2000);
        Assert.assertFalse(usersPage.isSearchResultsDisplayed());
    }

    @Test(priority = 4)
    public void invalidEmailFilter() throws InterruptedException {
        //clear any preset filter
        usersPage.clickFilterBtn();
        usersPage.clickClearFiltersBtn();

        //filter by first name
        usersPage.sendTextToEmailFilter(userFirstName);
        usersPage.clickApplyFiltersBtn();

        //test that no results appear
        Thread.sleep(2000);
        Assert.assertFalse(usersPage.isSearchResultsDisplayed());
    }

    @Test(priority = 5)
    @Ignore
    public void searchInvalidUser() throws InterruptedException {
        //clear any preset filter
        Thread.sleep(2000);
        usersPage.clickFilterBtn();
        usersPage.clickClearFiltersBtn();
        usersPage.clickApplyFiltersBtn();

        //insert username in search field
        usersPage.sendTextToSearchField(userFirstName);

        //click search
        usersPage.clickSearchBtn();

        //test that no results imagee appears
        Assert.assertFalse(usersPage.isSearchResultsDisplayed());

        //clear search field by refreshing the browser
        usersPage.refreshWindow();
        Thread.sleep(3000);
    }

    @Test(priority = 6)
    public void createSupportUserBySuperAdmin() throws InterruptedException {

        //signout from user
        homePage.clickProfileIconBtn();
        homePage.clickSignoutBtn();

        ///login with super-admin account
        Helpers.loginWithValidUser((ChromeDriver) MainTestRunner.ChromeDriver,Credentials.superAdminUsername,Credentials.superAdminPassword);

        //navigate to users page
        homePage.clickUsersSidebarBtnSuperAdmin();

        //clear any preset filter
        usersPage.clickFilterBtn();
        usersPage.clickClearFiltersBtn();
        usersPage.clickApplyFiltersBtn();

        //click add user
        usersPage.clickAddUserBtn();

        //insert user data
        Thread.sleep(3000);
        userFirstName = "FirstName_" + MainTestRunner.CurrentTestTime;
        userLastName = "LastName_" + MainTestRunner.CurrentTestTime;
        userEmail = "Email_" + Helpers.generateRandomString() + "@email.com";

        //insert first name
        usersPage.sendTextToFirstNameCreateFieldText(userFirstName);

        //insert last name
        usersPage.sendTextToLastNameCreateFieldText(userLastName);

        //choose affiliate
        usersPage.sendTextToAffiliateDropDown("Buchi");

        //select role
        usersPage.sendTextToRoleDropDown("Support");

        //insert email
        usersPage.sendTextToCreateEmailField(userEmail);

        //insert password and password confirmation
        usersPage.sendTextToPasswordField(Credentials.adminPassword);
        usersPage.sendTextToConfirmPasswordField(Credentials.adminPassword);

        //click save
        usersPage.clickSaveBtn();

        //filter for created user

        //click filter button
        usersPage.clickFilterBtn();

        //filter by first name to test user is created
        Thread.sleep(2000);
        usersPage.sendTextToFirstNameFilter(userFirstName);

        //click apply
        usersPage.clickApplyFiltersBtn();

        //test that user appears
        Thread.sleep(2000);
        Assert.assertEquals(usersPage.getFilteredUserNameText(), userFirstName + " " + userLastName);

        deleteUser(userFirstName);

    }

    @Test(priority = 7)
    public void createPartnerAdminUserBySuperAdmin() throws InterruptedException {

        //navigate to users page
        homePage.clickUsersSidebarBtnSuperAdmin();

        //clear any preset filter
        usersPage.clickFilterBtn();
        usersPage.clickClearFiltersBtn();
        usersPage.clickApplyFiltersBtn();

        //click add user
        usersPage.clickAddUserBtn();

        //insert user data
        Thread.sleep(3000);
        userFirstName = "FirstName_" + MainTestRunner.CurrentTestTime;
        userLastName = "LastName_" + MainTestRunner.CurrentTestTime;
        userEmail = "Email_" + Helpers.generateRandomString() + "@email.com";

        //insert first name
        usersPage.sendTextToFirstNameCreateFieldText(userFirstName);

        //insert last name
        usersPage.sendTextToLastNameCreateFieldText(userLastName);

        //choose affiliate
        usersPage.sendTextToAffiliateDropDown("Buchi");

        //select role
        usersPage.sendTextToRoleDropDown("PartnerAdmin");

        //insert email
        usersPage.sendTextToCreateEmailField(userEmail);

        //insert password and password confirmation
        usersPage.sendTextToPasswordField(Credentials.adminPassword);
        usersPage.sendTextToConfirmPasswordField(Credentials.adminPassword);

        //click save
        usersPage.clickSaveBtn();

        //filter for created user

        //click filter button
        usersPage.clickFilterBtn();

        //filter by first name to test user is created
        Thread.sleep(2000);
        usersPage.sendTextToFirstNameFilter(userFirstName);

        //click apply
        usersPage.clickApplyFiltersBtn();

        //test that user appears
        Thread.sleep(2000);
        Assert.assertEquals(usersPage.getFilteredUserNameText(), userFirstName + " " + userLastName);

        deleteUser(userFirstName);

    }

    @Test(priority = 7)
    public void createPartnerUserUserBySuperAdmin() throws InterruptedException {

        //navigate to users page
        homePage.clickUsersSidebarBtnSuperAdmin();

        //clear any preset filter
        usersPage.clickFilterBtn();
        usersPage.clickClearFiltersBtn();
        usersPage.clickApplyFiltersBtn();

        //click add user
        usersPage.clickAddUserBtn();

        //insert user data
        Thread.sleep(3000);
        userFirstName = "FirstName_" + MainTestRunner.CurrentTestTime;
        userLastName = "LastName_" + MainTestRunner.CurrentTestTime;
        userEmail = "Email_" + Helpers.generateRandomString() + "@email.com";

        //insert first name
        usersPage.sendTextToFirstNameCreateFieldText(userFirstName);

        //insert last name
        usersPage.sendTextToLastNameCreateFieldText(userLastName);

        //choose affiliate
        usersPage.sendTextToAffiliateDropDown("Buchi");

        //select role
        usersPage.sendTextToRoleDropDown("PartnerUser");

        //insert email
        usersPage.sendTextToCreateEmailField(userEmail);

        //insert password and password confirmation
        usersPage.sendTextToPasswordField(Credentials.adminPassword);
        usersPage.sendTextToConfirmPasswordField(Credentials.adminPassword);

        //click save
        usersPage.clickSaveBtn();

        //filter for created user

        //click filter button
        usersPage.clickFilterBtn();

        //filter by first name to test user is created
        Thread.sleep(2000);
        usersPage.sendTextToFirstNameFilter(userFirstName);

        //click apply
        usersPage.clickApplyFiltersBtn();

        //test that user appears
        Thread.sleep(2000);
        Assert.assertEquals(usersPage.getFilteredUserNameText(), userFirstName + " " + userLastName);

        deleteUser(userFirstName);
    }

    @Test(priority = 7)
    public void createUserBySuperAdmin() throws InterruptedException {

        //navigate to users page
        homePage.clickUsersSidebarBtnSuperAdmin();

        //clear any preset filter
        usersPage.clickFilterBtn();
        usersPage.clickClearFiltersBtn();
        usersPage.clickApplyFiltersBtn();

        //click add user
        usersPage.clickAddUserBtn();

        //insert user data
        Thread.sleep(3000);
        userFirstName = "FirstName_" + MainTestRunner.CurrentTestTime;
        userLastName = "LastName_" + MainTestRunner.CurrentTestTime;
        userEmail = "Email_" + Helpers.generateRandomString() + "@email.com";

        //insert first name
        usersPage.sendTextToFirstNameCreateFieldText(userFirstName);

        //insert last name
        usersPage.sendTextToLastNameCreateFieldText(userLastName);

        //choose affiliate
        usersPage.sendTextToAffiliateDropDown("Sub1");

        //select role
        usersPage.sendTextToRoleDropDown("User");

        //insert email
        usersPage.sendTextToCreateEmailField(userEmail);

        //insert password and password confirmation
        usersPage.sendTextToPasswordField(Credentials.adminPassword);
        usersPage.sendTextToConfirmPasswordField(Credentials.adminPassword);

        //click save
        usersPage.clickSaveBtn();

        //filter for created user

        //click filter button
        usersPage.clickFilterBtn();

        //filter by first name to test user is created
        Thread.sleep(2000);
        usersPage.sendTextToFirstNameFilter(userFirstName);

        //click apply
        usersPage.clickApplyFiltersBtn();

        //test that user appears
        Thread.sleep(2000);
        Assert.assertEquals(usersPage.getFilteredUserNameText(), userFirstName + " " + userLastName);

        deleteUser(userFirstName);

    }

    @Test(priority = 7)
    public void createAdminUserBySuperAdmin() throws InterruptedException {

        //navigate to users page
        homePage.clickUsersSidebarBtnSuperAdmin();

        //clear any preset filter
        usersPage.clickFilterBtn();
        usersPage.clickClearFiltersBtn();
        usersPage.clickApplyFiltersBtn();

        //click add user
        usersPage.clickAddUserBtn();

        //insert user data
        Thread.sleep(3000);
        userFirstName = "FirstName_" + MainTestRunner.CurrentTestTime;
        userLastName = "LastName_" + MainTestRunner.CurrentTestTime;
        userEmail = "Email_" + Helpers.generateRandomString() + "@email.com";

        //insert first name
        usersPage.sendTextToFirstNameCreateFieldText(userFirstName);

        //insert last name
        usersPage.sendTextToLastNameCreateFieldText(userLastName);

        //choose affiliate
        usersPage.sendTextToAffiliateDropDown("Sub1");

        //select role
        usersPage.sendTextToRoleDropDown("Admin");

        //insert email
        usersPage.sendTextToCreateEmailField(userEmail);

        //insert password and password confirmation
        usersPage.sendTextToPasswordField(Credentials.adminPassword);
        usersPage.sendTextToConfirmPasswordField(Credentials.adminPassword);

        //click save
        usersPage.clickSaveBtn();

        //filter for created user

        //click filter button
        usersPage.clickFilterBtn();

        //filter by first name to test user is created
        Thread.sleep(2000);
        usersPage.sendTextToFirstNameFilter(userFirstName);

        //click apply
        usersPage.clickApplyFiltersBtn();

        //test that user appears
        Thread.sleep(2000);
        Assert.assertEquals(usersPage.getFilteredUserNameText(), userFirstName + " " + userLastName);

        deleteUser(userFirstName);

    }

    @Test(priority = 8)
    public void createPartnerAdminUserByPartnerAdmin() throws InterruptedException {

        //signout from user
        homePage.clickProfileIconBtn();
        homePage.clickSignoutBtn();

        ///login with partner-admin account
        Helpers.loginWithValidUser((ChromeDriver) MainTestRunner.ChromeDriver,Credentials.partnerAdminUsername,Credentials.partnerAdminPassword);

        //navigate to users page
        homePage.clickUsersSidebarBtn();

        //clear any preset filter
        usersPage.clickFilterBtn();
        usersPage.clickClearFiltersBtn();
        usersPage.clickApplyFiltersBtn();

        //click add user
        usersPage.clickAddUserBtn();

        //insert user data
        Thread.sleep(3000);
        userFirstName = "FirstName_" + MainTestRunner.CurrentTestTime;
        userLastName = "LastName_" + MainTestRunner.CurrentTestTime;
        userEmail = "Email_" + Helpers.generateRandomString() + "@email.com";

        //insert first name
        usersPage.sendTextToFirstNameCreateFieldText(userFirstName);

        //insert last name
        usersPage.sendTextToLastNameCreateFieldText(userLastName);

        //choose affiliate
        usersPage.sendTextToAffiliateDropDown("Buchi");

        //select role
        usersPage.sendTextToRoleDropDown("PartnerAdmin");

        //insert email
        usersPage.sendTextToCreateEmailField(userEmail);

        //insert password and password confirmation
        usersPage.sendTextToPasswordField(Credentials.adminPassword);
        usersPage.sendTextToConfirmPasswordField(Credentials.adminPassword);

        //click save
        usersPage.clickSaveBtn();

        //filter for created user

        //click filter button
        usersPage.clickFilterBtn();

        //filter by first name to test user is created
        Thread.sleep(2000);
        usersPage.sendTextToFirstNameFilter(userFirstName);

        //click apply
        usersPage.clickApplyFiltersBtn();

        //test that user appears
        Thread.sleep(2000);
        Assert.assertEquals(usersPage.getFilteredUserNameText(), userFirstName + " " + userLastName);

        deleteUser(userFirstName);

    }

    @Test(priority = 9)
    public void createPartnerUserByPartnerAdmin() throws InterruptedException {

        //navigate to users page
        homePage.clickUsersSidebarBtn();

        //clear any preset filter
        usersPage.clickFilterBtn();
        usersPage.clickClearFiltersBtn();
        usersPage.clickApplyFiltersBtn();

        //click add user
        usersPage.clickAddUserBtn();

        //insert user data
        Thread.sleep(3000);
        userFirstName = "FirstName_" + MainTestRunner.CurrentTestTime;
        userLastName = "LastName_" + MainTestRunner.CurrentTestTime;
        userEmail = "Email_" + Helpers.generateRandomString() + "@email.com";

        //insert first name
        usersPage.sendTextToFirstNameCreateFieldText(userFirstName);

        //insert last name
        usersPage.sendTextToLastNameCreateFieldText(userLastName);

        //choose affiliate
        usersPage.sendTextToAffiliateDropDown("Buchi");

        //select role
        usersPage.sendTextToRoleDropDown("PartnerUser");

        //insert email
        usersPage.sendTextToCreateEmailField(userEmail);

        //insert password and password confirmation
        usersPage.sendTextToPasswordField(Credentials.adminPassword);
        usersPage.sendTextToConfirmPasswordField(Credentials.adminPassword);

        //click save
        usersPage.clickSaveBtn();

        //filter for created user

        //click filter button
        usersPage.clickFilterBtn();

        //filter by first name to test user is created
        Thread.sleep(2000);
        usersPage.sendTextToFirstNameFilter(userFirstName);

        //click apply
        usersPage.clickApplyFiltersBtn();

        //test that user appears
        Thread.sleep(2000);
        Assert.assertEquals(usersPage.getFilteredUserNameText(), userFirstName + " " + userLastName);

        deleteUser(userFirstName);

    }

    @Test(priority = 9)
    public void createUserByPartnerAdmin() throws InterruptedException {

        //navigate to users page
        homePage.clickUsersSidebarBtn();

        //clear any preset filter
        usersPage.clickFilterBtn();
        usersPage.clickClearFiltersBtn();
        usersPage.clickApplyFiltersBtn();

        //click add user
        usersPage.clickAddUserBtn();

        //insert user data
        Thread.sleep(3000);
        userFirstName = "FirstName_" + MainTestRunner.CurrentTestTime;
        userLastName = "LastName_" + MainTestRunner.CurrentTestTime;
        userEmail = "Email_" + Helpers.generateRandomString() + "@email.com";

        //insert first name
        usersPage.sendTextToFirstNameCreateFieldText(userFirstName);

        //insert last name
        usersPage.sendTextToLastNameCreateFieldText(userLastName);

        //choose affiliate
        usersPage.sendTextToAffiliateDropDown("Sub1");

        //select role
        usersPage.sendTextToRoleDropDown("User");

        //insert email
        usersPage.sendTextToCreateEmailField(userEmail);

        //insert password and password confirmation
        usersPage.sendTextToPasswordField(Credentials.adminPassword);
        usersPage.sendTextToConfirmPasswordField(Credentials.adminPassword);

        //click save
        usersPage.clickSaveBtn();

        //filter for created user

        //click filter button
        usersPage.clickFilterBtn();

        //filter by first name to test user is created
        Thread.sleep(2000);
        usersPage.sendTextToFirstNameFilter(userFirstName);

        //click apply
        usersPage.clickApplyFiltersBtn();

        //test that user appears
        Thread.sleep(2000);
        Assert.assertEquals(usersPage.getFilteredUserNameText(), userFirstName + " " + userLastName);

        deleteUser(userFirstName);

    }

    @Test(priority = 9)
    public void createAdminUserByPartnerAdmin() throws InterruptedException {

        //navigate to users page
        homePage.clickUsersSidebarBtn();

        //clear any preset filter
        usersPage.clickFilterBtn();
        usersPage.clickClearFiltersBtn();
        usersPage.clickApplyFiltersBtn();

        //click add user
        usersPage.clickAddUserBtn();

        //insert user data
        Thread.sleep(3000);
        userFirstName = "FirstName_" + MainTestRunner.CurrentTestTime;
        userLastName = "LastName_" + MainTestRunner.CurrentTestTime;
        userEmail = "Email_" + Helpers.generateRandomString() + "@email.com";

        //insert first name
        usersPage.sendTextToFirstNameCreateFieldText(userFirstName);

        //insert last name
        usersPage.sendTextToLastNameCreateFieldText(userLastName);

        //choose affiliate
        usersPage.sendTextToAffiliateDropDown("Sub1");

        //select role
        usersPage.sendTextToRoleDropDown("Admin");

        //insert email
        usersPage.sendTextToCreateEmailField(userEmail);

        //insert password and password confirmation
        usersPage.sendTextToPasswordField(Credentials.adminPassword);
        usersPage.sendTextToConfirmPasswordField(Credentials.adminPassword);

        //click save
        usersPage.clickSaveBtn();

        //filter for created user

        //click filter button
        usersPage.clickFilterBtn();

        //filter by first name to test user is created
        Thread.sleep(2000);
        usersPage.sendTextToFirstNameFilter(userFirstName);

        //click apply
        usersPage.clickApplyFiltersBtn();

        //test that user appears
        Thread.sleep(2000);
        Assert.assertEquals(usersPage.getFilteredUserNameText(), userFirstName + " " + userLastName);

        deleteUser(userFirstName);

    }

    @Test(priority = 10)
    public void createAdminUserByAdmin() throws InterruptedException {

        //sign-out from user
        homePage.clickProfileIconBtn();
        homePage.clickSignoutBtnAdmin();

        ///login with partner-admin account
        Thread.sleep(3000);
        Helpers.loginWithValidUser((ChromeDriver) MainTestRunner.ChromeDriver,Credentials.adminUsername,Credentials.adminPassword);

        //navigate to users page
        homePage.clickUsersSidebarBtnAdmin();

        //clear any preset filter
        usersPage.clickFilterBtn();
        usersPage.clickClearFiltersBtn();
        usersPage.clickApplyFiltersBtn();

        //click add user
        usersPage.clickAddUserBtn();

        //insert user data
        Thread.sleep(3000);
        userFirstName = "FirstName_" + MainTestRunner.CurrentTestTime;
        userLastName = "LastName_" + MainTestRunner.CurrentTestTime;
        userEmail = "Email_" + Helpers.generateRandomString() + "@email.com";

        //insert first name
        usersPage.sendTextToFirstNameCreateFieldText(userFirstName);

        //insert last name
        usersPage.sendTextToLastNameCreateFieldText(userLastName);

        //choose affiliate
        usersPage.sendTextToAffiliateDropDown("Sub1");

        //select role
        usersPage.sendTextToRoleDropDown("Admin");

        //insert email
        usersPage.sendTextToCreateEmailField(userEmail);

        //insert password and password confirmation
        usersPage.sendTextToPasswordField(Credentials.adminPassword);
        usersPage.sendTextToConfirmPasswordField(Credentials.adminPassword);

        //click save
        usersPage.clickSaveBtn();

        //filter for created user

        //click filter button
        usersPage.clickFilterBtn();

        //filter by first name to test user is created
        Thread.sleep(2000);
        usersPage.sendTextToFirstNameFilter(userFirstName);

        //click apply
        usersPage.clickApplyFiltersBtn();

        //test that user appears
        Thread.sleep(2000);
        Assert.assertEquals(usersPage.getFilteredUserNameText(), userFirstName + " " + userLastName);

        deleteUserAdmin(userFirstName);

    }

    @Test(priority = 11)
    public void createUserByAdmin() throws InterruptedException {


        //clear any preset filter
        usersPage.clickFilterBtn();
        usersPage.clickClearFiltersBtn();
        usersPage.clickApplyFiltersBtn();

        //click add user
        usersPage.clickAddUserBtn();

        //insert user data
        Thread.sleep(3000);
        userFirstName = "FirstName_" + MainTestRunner.CurrentTestTime;
        userLastName = "LastName_" + MainTestRunner.CurrentTestTime;
        userEmail = "Email_" + Helpers.generateRandomString() + "@email.com";

        //insert first name
        usersPage.sendTextToFirstNameCreateFieldText(userFirstName);

        //insert last name
        usersPage.sendTextToLastNameCreateFieldText(userLastName);

        //choose affiliate
        usersPage.sendTextToAffiliateDropDown("Sub1");

        //select role
        usersPage.sendTextToRoleDropDown("User");

        //insert email
        usersPage.sendTextToCreateEmailField(userEmail);

        //insert password and password confirmation
        usersPage.sendTextToPasswordField(Credentials.adminPassword);
        usersPage.sendTextToConfirmPasswordField(Credentials.adminPassword);

        //click save
        usersPage.clickSaveBtn();

        //filter for created user
        //click filter button
        usersPage.clickFilterBtn();

        //filter by first name to test user is created
        Thread.sleep(2000);
        usersPage.sendTextToFirstNameFilter(userFirstName);

        //click apply
        usersPage.clickApplyFiltersBtn();

        //test that user appears
        Thread.sleep(2000);
        Assert.assertEquals(usersPage.getFilteredUserNameText(), userFirstName + " " + userLastName);

        deleteUserAdmin(userFirstName);
    }

    //helper method to delete any created user
    public void deleteUser(String username) throws InterruptedException {
        //clear any preset filter
        usersPage.clickFilterBtn();
        usersPage.clickClearFiltersBtn();
        usersPage.clickApplyFiltersBtn();

        //insert username in search field
        usersPage.sendTextToSearchField(username);

        //click search
        usersPage.clickSearchBtn();


        //click actions
        Thread.sleep(2000);
        usersPage.clickActionsBtn();

        //click delete
        usersPage.clickDeleteUserOption();

        //confirm delete
        usersPage.clickConfirmDeleteBtn();

        //refresh window
        usersPage.refreshWindow();
    }


    //helper method to delete any user created by admin
    public void deleteUserAdmin(String username) throws InterruptedException {
        //clear any preset filter
        usersPage.clickFilterBtn();
        usersPage.clickClearFiltersBtn();
        usersPage.clickApplyFiltersBtn();

        //insert username in search field
        usersPage.sendTextToSearchField(username);

        //click search
        usersPage.clickSearchBtn();

        //click actions
        Thread.sleep(2000);
        usersPage.clickActionsBtnAdmin();

        //click delete
        usersPage.clickDeleteUserOption();

        //confirm delete
        usersPage.clickConfirmDeleteBtn();

        //refresh window
        usersPage.refreshWindow();
    }


}
