package base;

import data.Credentials;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Actions;
import pages.HomePage;
import pages.UsersPage;
import utils.Helpers;

import java.util.Date;

public class UsersModule {
    UsersPage usersPage;
    HomePage homePage;
    Actions actions;
    String userFirstName;
    String userLastName;
    String userEmail;

    @BeforeClass
    public void initializeClasses() {
        usersPage = new UsersPage((ChromeDriver) MainTestRunner.ChromeDriver);
        homePage = new HomePage((ChromeDriver) MainTestRunner.ChromeDriver);
        actions=new Actions((ChromeDriver) MainTestRunner.ChromeDriver,20);
    }

    @Test()
    public void createInvalidUserBySupport() throws InterruptedException {
        //navigate to users page
        Thread.sleep(2000);

        actions.clickElement(homePage.usersSidebarBtn);
        
        //click add user
        actions.clickElement(usersPage.addUserBtn);
        
        //click save without entering any data
        actions.clickElement(usersPage.saveBtn);
        
        //test that error messages appear for requried data (first name , last name , etc..)
        Assert.assertEquals(actions.getText(usersPage.firstNameErrorMsg), "First name is required.");
        Assert.assertEquals(actions.getText(usersPage.lastNameErrorMsg), "Last name is required.");
        Assert.assertEquals(actions.getText(usersPage.affiliateErrorMsg), "Affiliate is required.");
        Assert.assertEquals(actions.getText(usersPage.roleErrorMsg), "Role is required.");
        Assert.assertEquals(actions.getText(usersPage.emailErrorMsg), "Email is too short. it must be at least 1 characters long.");
        Assert.assertEquals(actions.getText(usersPage.passwordErrorMsg), "Password is too short. it must be at least 8 characters long.");

        //test that password confirmation must be equal to password
        actions.enterText(usersPage.confirmPasswordTextField,"a");
        Assert.assertEquals(actions.getText(usersPage.confirmPasswordErrorMsg), "Passwords do not match");

        //test that email must be of valid form
        actions.enterText(usersPage.createEmailTextField,"not a valid email address");
        Assert.assertEquals(actions.getText(usersPage.emailErrorMsg), "Please enter a valid email address.");

        //test that password cannot be more than 20 characters
        actions.enterText(usersPage.passwordTextField,"This password is longer than required");
        Assert.assertEquals(actions.getText(usersPage.passwordErrorMsg), "Password is too long. it must be no more than 20 characters long.");

        //test that password contains all required symbols
        
        actions.clearText(usersPage.passwordTextField);
        actions.enterText(usersPage.passwordTextField,"abcdefgh");
        Assert.assertEquals(actions.getText(usersPage.passwordErrorMsg), "Password must be between 8 and 20 characters long, and include at least one uppercase letter, one lowercase letter, one number, and one special character (e.g., @$!%*?&).");

        //test that first and last name cannot be more than 30 characters
        actions.enterText(usersPage.firstNameCreateTextField,"kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
        Thread.sleep(2000);
        
        Assert.assertEquals(actions.getText(usersPage.firstNameErrorMsg), "First name is too long. it must be no more than 30 characters long.");

        actions.enterText(usersPage.lastNameCreateTextField,"kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
        Assert.assertEquals(actions.getText(usersPage.lastNameErrorMsg), "Last name is too long. it must be no more than 30 characters long.");

        //click cancel
        actions.clickElement(usersPage.cancelBtn);
    }

    public void createPartnerAdminUserBySupport() throws InterruptedException {
        //navigate to users page
        actions.clickElement(homePage.usersSidebarBtn);

        //clear any preset filter
        actions.clickElement(usersPage.filterBtn);
        
        actions.clickElement(usersPage.clearFiltersBtn);
        
        //click add user
        actions.clickElement(usersPage.addUserBtn);

        //insert user data
        Thread.sleep(3000);
        userFirstName = "FirstName_" + MainTestRunner.CurrentTestTime;
        userLastName = "LastName_" + MainTestRunner.CurrentTestTime;
        userEmail = "Email_" + Helpers.generateRandomString() + "@email.com";

        //insert first name
        actions.enterText(usersPage.firstNameCreateTextField,userFirstName);
        
        //insert last name
        actions.enterText(usersPage.lastNameCreateTextField,userLastName);

        //choose affiliate
        actions.chooseFromDropDown(usersPage.affiliateDropDown,"Buchi");
        
        //select role
        actions.chooseFromDropDown(usersPage.roleDropDown,"PartnerAdmin");
        
        //insert email
        actions.enterText(usersPage.createEmailTextField,userEmail);

        //insert password and password confirmation
        actions.enterText(usersPage.passwordTextField,Credentials.adminPassword);
        
        actions.enterText(usersPage.confirmPasswordTextField,Credentials.adminPassword);

        //click save
        actions.clickElement(usersPage.saveBtn);

        //filter for created user
        //click filter button
        actions.clickElement(usersPage.filterBtn);

        //filter by first name to test user is created
        Thread.sleep(2000);
        actions.enterText(usersPage.firstNameFilterTextField,userFirstName);

        //click apply
        actions.clickElement(usersPage.applyFiltersBtn);
        
        //test that user appears
        Thread.sleep(3000);
        
        Assert.assertEquals(actions.getText(usersPage.filteredUserName), userFirstName + " " + userLastName);

        deleteUser(userFirstName);
    }

    public void createPartnerUserBySupport() throws InterruptedException {
        //navigate to users page
        actions.clickElement(homePage.usersSidebarBtn);

        //clear any preset filter
        actions.clickElement(usersPage.filterBtn);
        actions.clickElement(usersPage.clearFiltersBtn);
        
        //click add user
        actions.clickElement(usersPage.addUserBtn);

        //insert user data
        Thread.sleep(3000);
        userFirstName = "FirstName_" + MainTestRunner.CurrentTestTime;
        userLastName = "LastName_" + MainTestRunner.CurrentTestTime;
        userEmail = "Email_" + Helpers.generateRandomString() + "@email.com";

        //insert first name
        actions.enterText(usersPage.firstNameCreateTextField,userFirstName);

        //insert last name
        actions.enterText(usersPage.lastNameCreateTextField,userLastName);

        //choose affiliate
        actions.chooseFromDropDown(usersPage.affiliateDropDown,"Buchi");

        //select role
        actions.chooseFromDropDown(usersPage.roleDropDown,"PartnerUser");
        
        //insert email
        actions.enterText(usersPage.createEmailTextField,userEmail);

        //insert password and password confirmation
        actions.enterText(usersPage.passwordTextField,Credentials.adminPassword);
        actions.enterText(usersPage.confirmPasswordTextField,Credentials.adminPassword);

        //click save
        actions.clickElement(usersPage.saveBtn);

        //filter for created user

        //click filter button
        actions.clickElement(usersPage.filterBtn);

        //filter by first name to test user is created
        actions.enterText(usersPage.firstNameFilterTextField,userFirstName);
        
        //click apply
        actions.clickElement(usersPage.applyFiltersBtn);

        //test that user appears
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(usersPage.filteredUserName), userFirstName + " " + userLastName);

        deleteUser(userFirstName);
    }

    public void createAdminUserBySupport() throws InterruptedException {
        Thread.sleep(2000);
        //navigate to users page
        actions.clickElement(homePage.usersSidebarBtn);
        actions.clickElement(homePage.usersSidebarBtn);

        //clear any preset filter
        Thread.sleep(2000);
        actions.clickElement(usersPage.filterBtn);
        actions.clickElement(usersPage.clearFiltersBtn);

        //click add user
        actions.clickElement(usersPage.addUserBtn);

        //insert user data
        Thread.sleep(3000);
        userFirstName = "FirstName_" + MainTestRunner.CurrentTestTime;
        userLastName = "LastName_" + MainTestRunner.CurrentTestTime;
        userEmail = "Email_" + Helpers.generateRandomString() + "@email.com";

        //insert first name
        actions.enterText(usersPage.firstNameCreateTextField,userFirstName);

        //insert last name
        actions.enterText(usersPage.lastNameCreateTextField,userLastName);

        //choose affiliate
        Thread.sleep(2000);
        actions.chooseFromDropDown(usersPage.affiliateDropDown,"Sub1");
        
        //select role
        actions.chooseFromDropDown(usersPage.roleDropDown,"Admin");

        //insert email
        actions.enterText(usersPage.createEmailTextField,userEmail);

        //insert password and password confirmation
        actions.enterText(usersPage.passwordTextField,Credentials.adminPassword);
        actions.enterText(usersPage.confirmPasswordTextField,Credentials.adminPassword);

        //click save
        actions.clickElement(usersPage.saveBtn);

        //filter for created user
        //click filter button
        actions.clickElement(usersPage.filterBtn);

        //filter by first name to test user is created
        actions.enterText(usersPage.firstNameFilterTextField,userFirstName);

        //click apply
        actions.clickElement(usersPage.applyFiltersBtn);

        //test that user appears
        Thread.sleep(3000);
        Assert.assertEquals(actions.getText(usersPage.filteredUserName), userFirstName + " " + userLastName);

        deleteUser(userFirstName);
    }

    public void createUserBySupport() throws InterruptedException {
        usersPage = new UsersPage((ChromeDriver) MainTestRunner.ChromeDriver);
        homePage = new HomePage((ChromeDriver) MainTestRunner.ChromeDriver);

        //navigate to users page
        actions.clickElement(homePage.usersSidebarBtn);

        //clear any preset filter
        actions.clickElement(usersPage.filterBtn);
        actions.clickElement(usersPage.clearFiltersBtn);

        //click add user
        actions.clickElement(usersPage.addUserBtn);

        //insert user data
        Thread.sleep(3000);
        userFirstName = "FirstName_" + MainTestRunner.CurrentTestTime;
        userLastName = "LastName_" + MainTestRunner.CurrentTestTime;
        userEmail = "Email_" + Helpers.generateRandomString() + "@email.com";

        //insert first name
        actions.enterText(usersPage.firstNameCreateTextField,userFirstName);

        //insert last name
        actions.enterText(usersPage.lastNameCreateTextField,userLastName);

        //choose affiliate
        actions.chooseFromDropDown(usersPage.affiliateDropDown,"Sub1");

        //select role
        actions.chooseFromDropDown(usersPage.roleDropDown,"User");

        //insert email
        actions.enterText(usersPage.createEmailTextField,userEmail);

        //insert password and password confirmation
        actions.enterText(usersPage.passwordTextField,Credentials.adminPassword);
        actions.enterText(usersPage.confirmPasswordTextField,Credentials.adminPassword);

        //click save
        actions.clickElement(usersPage.saveBtn);

        //filter for created user

        //click filter button
        actions.clickElement(usersPage.filterBtn);

        //filter by first name to test user is created
        actions.enterText(usersPage.firstNameFilterTextField,userFirstName);

        //click apply
        actions.clickElement(usersPage.applyFiltersBtn);

        //test that user appears
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(usersPage.filteredUserName), userFirstName + " " + userLastName);
    }

    @Test(priority = 1)
    public void cancelUserEdits() throws InterruptedException {

        //clear any preset filter
        Thread.sleep(2000);
        actions.clickElement(usersPage.filterBtn);
        actions.clickElement(usersPage.clearFiltersBtn);

        //filter by username
        Thread.sleep(2000);
        actions.clickElement(usersPage.filterBtn);

        //filter by first name to test user is created
        actions.enterText(usersPage.firstNameFilterTextField,userFirstName);

        //click apply
        actions.clickElement(usersPage.applyFiltersBtn);

        //click actions button
        Thread.sleep(2000);
        actions.scrollToElementHorizontally(usersPage.tableHorizontalScrollBar, 500);
        actions.clickElement(usersPage.firstRowActionsBtn);

        //click edit
        actions.clickElement(usersPage.editUserOption);

        //clear all fields
        Thread.sleep(3000);
        actions.clearText(usersPage.firstNameEditTextField);
        actions.clearText(usersPage.lastNameEditTextField);
        actions.clearText(usersPage.lastNameEditTextField);
        actions.clearText(usersPage.editEmailTextField);
        actions.clearText(usersPage.editEmailTextField);

        //insert first name

        actions.enterText(usersPage.firstNameEditTextField,"Any Name");
        actions.enterText(usersPage.lastNameEditTextField,"Any Name");
        actions.enterText(usersPage.editEmailTextField,"Any_email@mail.com");
        
        //click reset
        usersPage.clickResetEditBtn();
        actions.clickElement(usersPage.resetEditBtn);

        //select affiliate
        actions.chooseFromDropDown(usersPage.affiliateDropDown,"Buchi");

        //select role
        actions.chooseFromDropDown(usersPage.roleDropDown,"PartnerAdmin");

        //click save
        actions.clickElement(usersPage.saveEditsBtn);
        
        //click submit
        Thread.sleep(2000);
        actions.clickElement(usersPage.confirmEditBtn);

        //filter for created user

        //clear any preset filter
        actions.clickElement(usersPage.filterBtn);
        actions.clickElement(usersPage.clearFiltersBtn);
        
        Thread.sleep(2000);
        //filter by first name to test user is created
        actions.clickElement(usersPage.filterBtn);
        actions.enterText(usersPage.firstNameFilterTextField,userFirstName);

        //click apply
        actions.clickElement(usersPage.applyFiltersBtn);

        //test that user appears
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(usersPage.filteredUserName), userFirstName + " " + userLastName);
    }

    @Test(priority = 1)
    public void editUser() throws InterruptedException {

        //clear any preset filter
        actions.clickElement(usersPage.filterBtn);
        actions.clickElement(usersPage.clearFiltersBtn);

        //filter by username
        Thread.sleep(2000);
        actions.clickElement(usersPage.filterBtn);

        //filter by first name to test user is created
        actions.enterText(usersPage.firstNameFilterTextField,userFirstName);

        //click apply
        actions.clickElement(usersPage.applyFiltersBtn);

        //click actions button
        Thread.sleep(2000);
        actions.scrollToElementHorizontally(usersPage.tableHorizontalScrollBar, 500);
        actions.clickElement(usersPage.firstRowActionsBtn);

        //click edit
        actions.clickElement(usersPage.editUserOption);

        //clear all fields
        Thread.sleep(2000);
        actions.clearText(usersPage.firstNameEditTextField);
        actions.clearText(usersPage.lastNameEditTextField);
        actions.clearText(usersPage.editEmailTextField);

        //insert first name
        userFirstName = "EditedFirst" + MainTestRunner.CurrentTestTime;
        userLastName = "EditedLast" + MainTestRunner.CurrentTestTime;
        userEmail = "EditedEmail" + Helpers.generateRandomString() + "@email.com";

        actions.enterText(usersPage.firstNameEditTextField,userFirstName);
        actions.enterText(usersPage.lastNameEditTextField,userLastName);
        actions.enterText(usersPage.editEmailTextField,userEmail);

        //select affiliate
        actions.chooseFromDropDown(usersPage.affiliateDropDown,"Buchi");

        //select role
        actions.chooseFromDropDown(usersPage.roleDropDown,"PartnerAdmin");

        //click save
        actions.clickElement(usersPage.saveEditsBtn);

        //click submit
        actions.clickElement(usersPage.confirmEditBtn);

        //clear any preset filter
        actions.clickElement(usersPage.filterBtn);
        Thread.sleep(2000);
        actions.clickElement(usersPage.clearFiltersBtn);

        //filter by first name to test user is edited
        actions.clickElement(usersPage.filterBtn);
        Thread.sleep(2000);

        actions.enterText(usersPage.firstNameFilterTextField,userFirstName);

        //click apply
        actions.clickElement(usersPage.applyFiltersBtn);

        //test that user appears
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(usersPage.filteredUserName), userFirstName + " " + userLastName);
    }

    @Test(priority = 2)
    public void filterByFirstName() throws InterruptedException {

        //clear any preset filter
        actions.clickElement(usersPage.filterBtn);
        actions.clickElement(usersPage.clearFiltersBtn);

        //filter by first name
        actions.clickElement(usersPage.filterBtn);
        actions.enterText(usersPage.firstNameFilterTextField,userFirstName);
        actions.clickElement(usersPage.applyFiltersBtn);

        //test that results appear
        Thread.sleep(2000);
        Assert.assertTrue(actions.getText(usersPage.filteredUserName).contains(userFirstName));
    }

    @Test(priority = 2)
    public void filterByLastName() throws InterruptedException {

        //clear any preset filter
        actions.clickElement(usersPage.filterBtn);
        actions.clickElement(usersPage.clearFiltersBtn);

        //filter by last name
        actions.clickElement(usersPage.filterBtn);
        actions.enterText(usersPage.lastNameFilterTextField,userLastName);
        actions.clickElement(usersPage.applyFiltersBtn);

        //test that results appear
        Thread.sleep(2000);
        Assert.assertTrue(actions.getText(usersPage.filteredUserName).contains(userLastName));

    }

    @Test(priority = 2)
    public void filterByEmail() throws InterruptedException {

        //clear any preset filter
        actions.clickElement(usersPage.filterBtn);
        actions.clickElement(usersPage.clearFiltersBtn);


        //filter by last name
        actions.clickElement(usersPage.filterBtn);
        actions.enterText(usersPage.emailFilterTextField,userEmail);
        actions.clickElement(usersPage.applyFiltersBtn);

        //test that results appear
        Thread.sleep(2000);
        
        Assert.assertEquals(actions.getText(usersPage.filteredEmail), userEmail);
    }

    @Test(priority = 2)
    public void toggleColumns() throws InterruptedException {

        //clear any preset filter
        actions.clickElement(usersPage.filterBtn);
        actions.clickElement(usersPage.clearFiltersBtn);

        //click view
        Thread.sleep(2000);
        
        actions.clickElement(usersPage.viewBtn);
        
        actions.clickElement(usersPage.toggleCreatedAtColumnOption);

        //test that column is not visible and the fifth column is modified at
        Assert.assertFalse(actions.isElementDisplayed(usersPage.createdAtColumnHeader));

        //click view
        Thread.sleep(2000);
        actions.clickElement(usersPage.viewBtn);
        actions.clickElement(usersPage.toggleCreatedAtColumnOption);

        //test that column is  visible and the fifth column is created at
        Assert.assertTrue(actions.isElementDisplayed(usersPage.createdAtColumnHeader));

        //hide both created at and modified at
        //click view
        Thread.sleep(2000);
        actions.clickElement(usersPage.viewBtn);
        actions.clickElement(usersPage.toggleCreatedAtColumnOption);

        Thread.sleep(2000);
        actions.clickElement(usersPage.viewBtn);
        actions.clickElement(usersPage.toggleModifiedAtColumnOption);
        
        Assert.assertFalse(actions.isElementDisplayed(usersPage.lastUpdatedAtColumnHeader));

        //reset the to default view (both columns viewed)
        //click view
        Thread.sleep(2000);
        actions.clickElement(usersPage.viewBtn);
        actions.clickElement(usersPage.toggleCreatedAtColumnOption);

        Thread.sleep(2000);
        actions.clickElement(usersPage.viewBtn);
        actions.clickElement(usersPage.toggleModifiedAtColumnOption);
    }

    @Test(priority = 2)
    public void searchUser() throws InterruptedException {
        //clear any preset filter
        actions.clickElement(usersPage.filterBtn);
        actions.clickElement(usersPage.clearFiltersBtn);

        //click filter
        actions.clickElement(usersPage.filterBtn);

        //insert first name
        actions.enterText(usersPage.firstNameFilterTextField,userFirstName);

        //click apply
        actions.clickElement(usersPage.applyFiltersBtn);
        
        //test that user appears
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(usersPage.filteredUserName), userFirstName + " " + userLastName);

        //clear search field by refreshing the browser
        actions.refreshWindow();
        Thread.sleep(3000);
    }

    @Test(priority = 2)
    public void sortData() throws InterruptedException {
        //clear any preset filter
        actions.clickElement(usersPage.filterBtn);
        actions.clickElement(usersPage.clearFiltersBtn);

        //test sort by name ascending
        actions.clickElement(usersPage.sortByName);
        actions.clickElement(usersPage.sortNameAscOption);
        actions.clickElement(usersPage.sortByName);
        actions.clickElement(usersPage.sortNameAscOption);
        Thread.sleep(2000);
        System.out.println(actions.getText(usersPage.filteredUserName));
        System.out.println(usersPage.getSecondUsernameText());
        Assert.assertTrue(actions.getText(usersPage.filteredUserName).compareTo(usersPage.getSecondUsernameText()) <= 0);

        //test sort name descending
        Thread.sleep(2000);
        actions.clickElement(usersPage.sortByName);
        
        actions.clickElement(usersPage.sortNameDescOption);
        Thread.sleep(2000);
        Assert.assertTrue(actions.getText(usersPage.filteredUserName).compareTo(usersPage.getSecondUsernameText()) >= 0);

        //clear sorting
        actions.clickElement(usersPage.sortByName);
        actions.clickElement(usersPage.sortNameDescOption);

        //test sort by email ascending
        Thread.sleep(2000);
        actions.clickElement(usersPage.sortByEmail);
        actions.clickElement(usersPage.sortEmailAscOption);
        Thread.sleep(3000);
        System.out.println(actions.getText(usersPage.filteredEmail));
        System.out.println(usersPage.getSecondEmailText());
        System.out.println(actions.getText(usersPage.filteredEmail).compareTo(usersPage.getSecondEmailText()));
        Assert.assertTrue(actions.getText(usersPage.filteredEmail).compareTo(usersPage.getSecondEmailText()) <= 0);

        //test sort email descending
        actions.clickElement(usersPage.sortByEmail);
        actions.clickElement(usersPage.sortEmailDescOption);
        Thread.sleep(2000);
        System.out.println(actions.getText(usersPage.filteredEmail));
        System.out.println(usersPage.getSecondEmailText());
        System.out.println(actions.getText(usersPage.filteredEmail).compareTo(usersPage.getSecondEmailText()));
        Assert.assertTrue(actions.getText(usersPage.filteredEmail).compareTo(usersPage.getSecondEmailText()
        ) >= 0);


        //clear sorting
        actions.clickElement(usersPage.sortByEmail);
        actions.clickElement(usersPage.sortEmailDescOption);

        //test sort created at ascending
        Thread.sleep(2000);
        actions.clickElement(usersPage.sortByCreatedAt);
        actions.clickElement(usersPage.sortCreatedAtAscOption);
        Thread.sleep(2000);
        Date firstDate = new Date(usersPage.getFilteredCreatedAtText());
        Date secondDate = new Date(usersPage.getFilteredModifiedAtText());

        System.out.println(firstDate);
        System.out.println(secondDate);

        Assert.assertTrue(firstDate.compareTo(secondDate) <= 0);

        //test sort created at descending
        actions.clickElement(usersPage.sortByCreatedAt);
        actions.clickElement(usersPage.sortCreatedAtDescOption);
        Thread.sleep(2000);
        firstDate = new Date(usersPage.getFilteredCreatedAtText());
        secondDate = new Date(usersPage.getFilteredModifiedAtText());

        Assert.assertTrue(firstDate.compareTo(secondDate) <= 0);

        //clear sorting
        actions.clickElement(usersPage.sortByCreatedAt);
        actions.clickElement(usersPage.sortCreatedAtDescOption);
        Thread.sleep(2000);

        //test sort modified at ascending
        actions.clickElement(usersPage.sortByUpdatedAt);
        actions.clickElement(usersPage.sortUpdatedAtAscOption);
        Thread.sleep(2000);
        firstDate = new Date(usersPage.getFilteredCreatedAtText());
        secondDate = new Date(usersPage.getFilteredModifiedAtText());

        Assert.assertTrue(firstDate.compareTo(secondDate) <= 0);

        //test sort created at descending
        actions.clickElement(usersPage.sortByUpdatedAt);
        actions.clickElement(usersPage.sortUpdatedAtDescOption);
        Thread.sleep(2000);
        firstDate = new Date(usersPage.getFilteredCreatedAtText());
        secondDate = new Date(usersPage.getFilteredModifiedAtText());

        Assert.assertTrue(firstDate.compareTo(secondDate) <= 0);
    }

    @Test(priority = 3)
    public void deleteUser() throws InterruptedException {
        //clear any preset filter
        actions.clickElement(usersPage.filterBtn);
        actions.clickElement(usersPage.clearFiltersBtn);

        //filter by first name
        actions.clickElement(usersPage.filterBtn);
        actions.enterText(usersPage.firstNameFilterTextField,userFirstName);
        actions.clickElement(usersPage.applyFiltersBtn);

        /*
        //click actions
        Thread.sleep(2000);
        actions.clickElement(usersPage.firstRowActionsBtn);

        //click delete
        actions.clickElement(usersPage.deleteUserOption);

        //cancel cancel
        usersPage.clickCancelDeleteBtn();

        //test that user still exists
        Assert.assertEquals(actions.getText(usersPage.filteredUserName), userFirstName + " " + userLastName);
*/
        //click actions
        Thread.sleep(2000);
        actions.scrollToElementHorizontally(usersPage.tableHorizontalScrollBar, 500);
        actions.clickElement(usersPage.firstRowActionsBtn);

        //click delete
        actions.clickElement(usersPage.deleteUserOption);

        //click confirm delete
        actions.clickElement(usersPage.confirmDeleteBtn);

        //clear any preset filter
        actions.refreshWindow();

        Thread.sleep(4000);
        actions.clickElement(usersPage.filterBtn);
        actions.clickElement(usersPage.clearFiltersBtn);

        //filter by first name
        actions.clickElement(usersPage.filterBtn);
        actions.enterText(usersPage.firstNameFilterTextField,"first");
        actions.clickElement(usersPage.applyFiltersBtn);

        //test that user is deleted and no results image is displayed
        Thread.sleep(3000);
        Assert.assertFalse(usersPage.isSearchResultsDisplayed());
    }

    @Test(priority = 4)
    public void invalidFirstnameFilter() throws InterruptedException {

        //clear any preset filter
        actions.clickElement(usersPage.filterBtn);
        actions.clickElement(usersPage.clearFiltersBtn);

        //filter by first name
        actions.clickElement(usersPage.filterBtn);
        actions.enterText(usersPage.firstNameFilterTextField,userFirstName);
        actions.clickElement(usersPage.applyFiltersBtn);

        //test that no results appear
        Thread.sleep(2000);
        Assert.assertFalse(actions.isElementDisplayed(usersPage.filteredUserName));
    }

    @Test(priority = 4)
    public void invalidLastnameFilter() throws InterruptedException {
        //clear any preset filter
        Thread.sleep(2000);
        actions.clickElement(usersPage.filterBtn);
        actions.clickElement(usersPage.clearFiltersBtn);

        //filter by first name
        actions.clickElement(usersPage.filterBtn);
        actions.enterText(usersPage.lastNameFilterTextField,userLastName);
        actions.clickElement(usersPage.applyFiltersBtn);

        //test that no results appear
        Thread.sleep(2000);
        Assert.assertFalse(actions.isElementDisplayed(usersPage.filteredUserName));
    }

    @Test(priority = 4)
    public void invalidEmailFilter() throws InterruptedException {
        //clear any preset filter
        actions.clickElement(usersPage.filterBtn);
        actions.clickElement(usersPage.clearFiltersBtn);

        //filter by first name
        actions.clickElement(usersPage.filterBtn);
        actions.enterText(usersPage.emailFilterTextField,userEmail);
        actions.clickElement(usersPage.applyFiltersBtn);

        //test that no results appear
        Thread.sleep(2000);
        Assert.assertFalse(actions.isElementDisplayed(usersPage.filteredUserName));
    }

    @Test(priority = 5)
    public void searchInvalidUser() throws InterruptedException {
        //clear any preset filter
        Thread.sleep(2000);
        actions.clickElement(usersPage.filterBtn);
        actions.clickElement(usersPage.clearFiltersBtn);

        //insert username in search field
        Thread.sleep(2000);
        actions.enterText(usersPage.searchField,userFirstName);

        //click search
        actions.clickElement(usersPage.searchBtn);
        
        //test that no results image appears
        Thread.sleep(2000);
        Assert.assertFalse(actions.isElementDisplayed(usersPage.filteredUserName));

        //clear search field by refreshing the browser
        actions.refreshWindow();
        Thread.sleep(3000);
    }

    @Test(priority = 6)
    public void createSupportUserBySuperAdmin() throws InterruptedException {

        //signout from user
        actions.clickElement(homePage.profileIconBtn);
        actions.clickElement(homePage.signoutBtn);

        ///login with super-admin account
        Helpers.loginWithValidUser((ChromeDriver) MainTestRunner.ChromeDriver,Credentials.superAdminUsername,Credentials.superAdminPassword);

        //navigate to users page
        actions.clickElement(homePage.usersSidebarBtn);

        //clear any preset filter
        actions.clickElement(usersPage.filterBtn);
        actions.clickElement(usersPage.clearFiltersBtn);

        //click add user
        actions.clickElement(usersPage.addUserBtn);

        //insert user data
        Thread.sleep(3000);
        userFirstName = "FirstName_" + MainTestRunner.CurrentTestTime;
        userLastName = "LastName_" + MainTestRunner.CurrentTestTime;
        userEmail = "Email_" + Helpers.generateRandomString() + "@email.com";

        //insert first name
        actions.enterText(usersPage.firstNameCreateTextField,userFirstName);

        //insert last name
        actions.enterText(usersPage.lastNameCreateTextField,userLastName);

        //insert email
        actions.enterText(usersPage.createEmailTextField,userEmail);

        //insert password and password confirmation
        actions.enterText(usersPage.passwordTextField,Credentials.adminPassword);
        actions.enterText(usersPage.confirmPasswordTextField,Credentials.adminPassword);

        //select affiliate
        actions.chooseFromDropDown(usersPage.superAdminAffiliateDropDown,"Buchi");

        //select role
        actions.chooseFromDropDown(usersPage.superAdminRoleDropDown,"Support");

        //click add
        actions.clickElement(usersPage.superAdminAddAffiliateBtn);

        //select affiliate
        actions.chooseFromDropDown(usersPage.superAdminAffiliateDropDown,"Sub1");

        //select role
        actions.chooseFromDropDown(usersPage.superAdminRoleDropDown,"Admin");

        //click add
        actions.clickElement(usersPage.superAdminAddAffiliateBtn);

        //click save
        actions.clickElement(usersPage.saveBtn);

        //filter for created user
        //click filter button
        actions.clickElement(usersPage.filterBtn);

        //filter by first name to test user is created
        Thread.sleep(2000);
        actions.enterText(usersPage.firstNameFilterTextField,userFirstName);

        //click apply
        actions.clickElement(usersPage.applyFiltersBtn);

        //test that user appears
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(usersPage.filteredUserName), userFirstName + " " + userLastName);

        deleteUser(userFirstName);
    }

    @Test(priority = 7)
    public void createPartnerAdminUserBySuperAdmin() throws InterruptedException {

        //navigate to users page
        actions.clickElement(homePage.usersSidebarBtn);

        //clear any preset filter
        actions.clickElement(usersPage.filterBtn);
        actions.clickElement(usersPage.clearFiltersBtn);

        //click add user
        actions.clickElement(usersPage.addUserBtn);

        //insert user data
        Thread.sleep(3000);
        userFirstName = "FirstName_" + MainTestRunner.CurrentTestTime;
        userLastName = "LastName_" + MainTestRunner.CurrentTestTime;
        userEmail = "Email_" + Helpers.generateRandomString() + "@email.com";

        //insert first name
        actions.enterText(usersPage.firstNameCreateTextField,userFirstName);

        //insert last name
        actions.enterText(usersPage.lastNameCreateTextField,userLastName);

        //insert email
        actions.enterText(usersPage.createEmailTextField,userEmail);

        //insert password and password confirmation
        actions.enterText(usersPage.passwordTextField,Credentials.adminPassword);
        actions.enterText(usersPage.confirmPasswordTextField,Credentials.adminPassword);
        //select affiliate
        actions.chooseFromDropDown(usersPage.superAdminAffiliateDropDown,"Buchi");

        //select role
        actions.chooseFromDropDown(usersPage.superAdminRoleDropDown,"PartnerAdmin");

        //click add
        actions.clickElement(usersPage.superAdminAddAffiliateBtn);

        //select affiliate
        actions.chooseFromDropDown(usersPage.superAdminAffiliateDropDown,"Sub1");

        //select role
        actions.chooseFromDropDown(usersPage.superAdminRoleDropDown,"Admin");

        //click add
        actions.clickElement(usersPage.superAdminAddAffiliateBtn);

        //click save
        actions.clickElement(usersPage.saveBtn);

        //filter for created user
        //click filter button
        actions.clickElement(usersPage.filterBtn);

        //filter by first name to test user is created
        Thread.sleep(2000);
        actions.enterText(usersPage.firstNameFilterTextField,userFirstName);

        //click apply
        actions.clickElement(usersPage.applyFiltersBtn);

        //test that user appears
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(usersPage.filteredUserName), userFirstName + " " + userLastName);

        deleteUser(userFirstName);
    }

    @Test(priority = 7)
    public void createPartnerUserUserBySuperAdmin() throws InterruptedException {

        //navigate to users page
        actions.clickElement(homePage.usersSidebarBtn);

        //clear any preset filter
        actions.clickElement(usersPage.filterBtn);
        actions.clickElement(usersPage.clearFiltersBtn);

        //click add user
        actions.clickElement(usersPage.addUserBtn);

        //insert user data
        Thread.sleep(3000);
        userFirstName = "FirstName_" + MainTestRunner.CurrentTestTime;
        userLastName = "LastName_" + MainTestRunner.CurrentTestTime;
        userEmail = "Email_" + Helpers.generateRandomString() + "@email.com";

        //insert first name
        actions.enterText(usersPage.firstNameCreateTextField,userFirstName);

        //insert last name
        actions.enterText(usersPage.lastNameCreateTextField,userLastName);

        //insert email
        actions.enterText(usersPage.createEmailTextField,userEmail);

        //insert password and password confirmation
        actions.enterText(usersPage.passwordTextField,Credentials.adminPassword);
        actions.enterText(usersPage.confirmPasswordTextField,Credentials.adminPassword);

        //select affiliate
        actions.chooseFromDropDown(usersPage.superAdminAffiliateDropDown,"Buchi");

        //select role
        actions.chooseFromDropDown(usersPage.superAdminRoleDropDown,"PartnerUser");

        //click add
        actions.clickElement(usersPage.superAdminAddAffiliateBtn);

        //select affiliate
        actions.chooseFromDropDown(usersPage.superAdminAffiliateDropDown,"Sub1");

        //select role
        actions.chooseFromDropDown(usersPage.superAdminRoleDropDown,"Admin");

        //click add
        actions.clickElement(usersPage.superAdminAddAffiliateBtn);

        //click save
        actions.clickElement(usersPage.saveBtn);

        //click filter button
        actions.clickElement(usersPage.filterBtn);

        //filter by first name to test user is created
        Thread.sleep(2000);
        actions.enterText(usersPage.firstNameFilterTextField,userFirstName);

        //click apply
        actions.clickElement(usersPage.applyFiltersBtn);

        //test that user appears
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(usersPage.filteredUserName), userFirstName + " " + userLastName);

        deleteUser(userFirstName);
    }

    @Test(priority = 7)
    public void createUserBySuperAdmin() throws InterruptedException {

        //navigate to users page
        actions.clickElement(homePage.usersSidebarBtn);

        //clear any preset filter
        actions.clickElement(usersPage.filterBtn);
        actions.clickElement(usersPage.clearFiltersBtn);


        //click add user
        actions.clickElement(usersPage.addUserBtn);

        //insert user data
        Thread.sleep(3000);
        userFirstName = "FirstName_" + MainTestRunner.CurrentTestTime;
        userLastName = "LastName_" + MainTestRunner.CurrentTestTime;
        userEmail = "Email_" + Helpers.generateRandomString() + "@email.com";

        //insert first name
        actions.enterText(usersPage.firstNameCreateTextField,userFirstName);

        //insert last name
        actions.enterText(usersPage.lastNameCreateTextField,userLastName);

        //insert email
        actions.enterText(usersPage.createEmailTextField,userEmail);

        //insert password and password confirmation
        actions.enterText(usersPage.passwordTextField,Credentials.adminPassword);
        actions.enterText(usersPage.confirmPasswordTextField,Credentials.adminPassword);

        //select affiliate
        actions.chooseFromDropDown(usersPage.superAdminAffiliateDropDown,"Buchi");

        //select role
        actions.chooseFromDropDown(usersPage.superAdminRoleDropDown,"PartnerAdmin");

        //click add
        actions.clickElement(usersPage.superAdminAddAffiliateBtn);

        //select affiliate
        actions.chooseFromDropDown(usersPage.superAdminAffiliateDropDown,"Sub1");

        //select role
        actions.chooseFromDropDown(usersPage.superAdminRoleDropDown,"user");

        //click add
        actions.clickElement(usersPage.superAdminAddAffiliateBtn);

        //click save
        actions.clickElement(usersPage.saveBtn);

        //filter for created user
        //click filter button
        actions.clickElement(usersPage.filterBtn);

        //filter by first name to test user is created
        Thread.sleep(2000);
        actions.enterText(usersPage.firstNameFilterTextField,userFirstName);

        //click apply
        actions.clickElement(usersPage.applyFiltersBtn);

        //test that user appears
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(usersPage.filteredUserName), userFirstName + " " + userLastName);

        deleteUser(userFirstName);
    }

    @Test(priority = 7)
    public void createAdminUserBySuperAdmin() throws InterruptedException {

        //navigate to users page
        actions.clickElement(homePage.usersSidebarBtn);

        //clear any preset filter
        actions.clickElement(usersPage.filterBtn);
        actions.clickElement(usersPage.clearFiltersBtn);

        //click add user
        actions.clickElement(usersPage.addUserBtn);

        //insert user data
        Thread.sleep(3000);
        userFirstName = "FirstName_" + MainTestRunner.CurrentTestTime;
        userLastName = "LastName_" + MainTestRunner.CurrentTestTime;
        userEmail = "Email_" + Helpers.generateRandomString() + "@email.com";

        //insert first name
        actions.enterText(usersPage.firstNameCreateTextField,userFirstName);

        //insert last name
        actions.enterText(usersPage.lastNameCreateTextField,userLastName);

        //insert email
        actions.enterText(usersPage.createEmailTextField,userEmail);

        //insert password and password confirmation
        actions.enterText(usersPage.passwordTextField,Credentials.adminPassword);
        actions.enterText(usersPage.confirmPasswordTextField,Credentials.adminPassword);

        //select affiliate
        actions.chooseFromDropDown(usersPage.superAdminAffiliateDropDown,"Buchi");

        //select role
        actions.chooseFromDropDown(usersPage.superAdminRoleDropDown,"PartnerAdmin");

        //click add
        actions.clickElement(usersPage.superAdminAddAffiliateBtn);

        //select affiliate
        actions.chooseFromDropDown(usersPage.superAdminAffiliateDropDown,"Sub1");

        //select role
        actions.chooseFromDropDown(usersPage.superAdminRoleDropDown,"Admin");

        //click add
        actions.clickElement(usersPage.superAdminAddAffiliateBtn);

        //click add
        actions.clickElement(usersPage.superAdminAddAffiliateBtn);

        //select affiliate
        actions.chooseFromDropDown(usersPage.superAdminAffiliateDropDown,"Sub1");

        //select role
        actions.chooseFromDropDown(usersPage.superAdminRoleDropDown,"Admin");

        //click add
        actions.clickElement(usersPage.superAdminAddAffiliateBtn);

        //click save
        actions.clickElement(usersPage.saveBtn);

        //filter for created user
        //click filter button
        actions.clickElement(usersPage.filterBtn);

        //filter by first name to test user is created
        Thread.sleep(2000);
        actions.enterText(usersPage.firstNameFilterTextField,userFirstName);

        //click apply
        actions.clickElement(usersPage.applyFiltersBtn);

        //test that user appears
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(usersPage.filteredUserName), userFirstName + " " + userLastName);

        deleteUser(userFirstName);
    }

    @Test(priority = 8)
    public void createPartnerAdminUserByPartnerAdmin() throws InterruptedException {

        //signout from user
        actions.clickElement(homePage.profileIconBtn);
        actions.clickElement(homePage.signoutBtn);

        ///login with partner-admin account
        Helpers.loginWithValidUser((ChromeDriver) MainTestRunner.ChromeDriver,Credentials.partnerAdminUsername,Credentials.partnerAdminPassword);

        //navigate to users page
        actions.clickElement(homePage.usersSidebarBtn);

        //clear any preset filter
        actions.clickElement(usersPage.filterBtn);
        actions.clickElement(usersPage.clearFiltersBtn);


        //click add user
        actions.clickElement(usersPage.addUserBtn);

        //insert user data
        Thread.sleep(3000);
        userFirstName = "FirstName_" + MainTestRunner.CurrentTestTime;
        userLastName = "LastName_" + MainTestRunner.CurrentTestTime;
        userEmail = "Email_" + Helpers.generateRandomString() + "@email.com";

        //insert first name
        actions.enterText(usersPage.firstNameCreateTextField,userFirstName);

        //insert last name
        actions.enterText(usersPage.lastNameCreateTextField,userLastName);

        //choose affiliate
        actions.chooseFromDropDown(usersPage.affiliateDropDown,"Buchi");

        //select role
        actions.chooseFromDropDown(usersPage.roleDropDown,"PartnerAdmin");

        //insert email
        actions.enterText(usersPage.createEmailTextField,userEmail);

        //insert password and password confirmation
        actions.enterText(usersPage.passwordTextField,Credentials.adminPassword);
        actions.enterText(usersPage.confirmPasswordTextField,Credentials.adminPassword);

        //click save
        actions.clickElement(usersPage.saveBtn);

        //filter for created user
        //click filter button
        actions.clickElement(usersPage.filterBtn);

        //filter by first name to test user is created
        Thread.sleep(2000);
        actions.enterText(usersPage.firstNameFilterTextField,userFirstName);

        //click apply
        actions.clickElement(usersPage.applyFiltersBtn);

        //test that user appears
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(usersPage.filteredUserName), userFirstName + " " + userLastName);

        deleteUser(userFirstName);
    }

    @Test(priority = 9)
    public void createPartnerUserByPartnerAdmin() throws InterruptedException {

        //navigate to users page
        actions.clickElement(homePage.usersSidebarBtn);

        //clear any preset filter
        actions.clickElement(usersPage.filterBtn);
        actions.clickElement(usersPage.clearFiltersBtn);

        //click add user
        actions.clickElement(usersPage.addUserBtn);

        //insert user data
        Thread.sleep(3000);
        userFirstName = "FirstName_" + MainTestRunner.CurrentTestTime;
        userLastName = "LastName_" + MainTestRunner.CurrentTestTime;
        userEmail = "Email_" + Helpers.generateRandomString() + "@email.com";

        //insert first name
        actions.enterText(usersPage.firstNameCreateTextField,userFirstName);

        //insert last name
        actions.enterText(usersPage.lastNameCreateTextField,userLastName);

        //choose affiliate
        actions.chooseFromDropDown(usersPage.affiliateDropDown,"Buchi");

        //select role
        actions.chooseFromDropDown(usersPage.roleDropDown,"PartnerUser");

        //insert email
        actions.enterText(usersPage.createEmailTextField,userEmail);

        //insert password and password confirmation
        actions.enterText(usersPage.passwordTextField,Credentials.adminPassword);
        actions.enterText(usersPage.confirmPasswordTextField,Credentials.adminPassword);

        //click save
        actions.clickElement(usersPage.saveBtn);

        //filter for created user
        //click filter button
        actions.clickElement(usersPage.filterBtn);

        //filter by first name to test user is created
        Thread.sleep(2000);
        actions.enterText(usersPage.firstNameFilterTextField,userFirstName);

        //click apply
        actions.clickElement(usersPage.applyFiltersBtn);

        //test that user appears
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(usersPage.filteredUserName), userFirstName + " " + userLastName);

        deleteUser(userFirstName);
    }

    @Test(priority = 9)
    public void createUserByPartnerAdmin() throws InterruptedException {

        //navigate to users page
        actions.clickElement(homePage.usersSidebarBtn);

        //clear any preset filter
        actions.clickElement(usersPage.filterBtn);
        actions.clickElement(usersPage.clearFiltersBtn);

        //click add user
        actions.clickElement(usersPage.addUserBtn);

        //insert user data
        Thread.sleep(3000);
        userFirstName = "FirstName_" + MainTestRunner.CurrentTestTime;
        userLastName = "LastName_" + MainTestRunner.CurrentTestTime;
        userEmail = "Email_" + Helpers.generateRandomString() + "@email.com";

        //insert first name
        actions.enterText(usersPage.firstNameCreateTextField,userFirstName);

        //insert last name
        actions.enterText(usersPage.lastNameCreateTextField,userLastName);

        //choose affiliate
        actions.chooseFromDropDown(usersPage.affiliateDropDown,"Sub1");

        //select role
        actions.chooseFromDropDown(usersPage.roleDropDown,"User");

        //insert email
        actions.enterText(usersPage.createEmailTextField,userEmail);

        //insert password and password confirmation
        actions.enterText(usersPage.passwordTextField,Credentials.adminPassword);
        actions.enterText(usersPage.confirmPasswordTextField,Credentials.adminPassword);

        //click save
        actions.clickElement(usersPage.saveBtn);

        //filter for created user
        //click filter button
        actions.clickElement(usersPage.filterBtn);

        //filter by first name to test user is created
        Thread.sleep(2000);
        actions.enterText(usersPage.firstNameFilterTextField,userFirstName);

        //click apply
        actions.clickElement(usersPage.applyFiltersBtn);

        //test that user appears
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(usersPage.filteredUserName), userFirstName + " " + userLastName);

        deleteUser(userFirstName);
    }

    @Test(priority = 9)
    public void createAdminUserByPartnerAdmin() throws InterruptedException {

        //navigate to users page
        actions.clickElement(homePage.usersSidebarBtn);

        //clear any preset filter
        actions.clickElement(usersPage.filterBtn);
        actions.clickElement(usersPage.clearFiltersBtn);

        //click add user
        actions.clickElement(usersPage.addUserBtn);

        //insert user data
        Thread.sleep(3000);
        userFirstName = "FirstName_" + MainTestRunner.CurrentTestTime;
        userLastName = "LastName_" + MainTestRunner.CurrentTestTime;
        userEmail = "Email_" + Helpers.generateRandomString() + "@email.com";

        //insert first name
        actions.enterText(usersPage.firstNameCreateTextField,userFirstName);

        //insert last name
        actions.enterText(usersPage.lastNameCreateTextField,userLastName);

        //choose affiliate
        actions.chooseFromDropDown(usersPage.affiliateDropDown,"Sub1");

        //select role
        actions.chooseFromDropDown(usersPage.roleDropDown,"Admin");

        //insert email
        actions.enterText(usersPage.createEmailTextField,userEmail);

        //insert password and password confirmation
        actions.enterText(usersPage.passwordTextField,Credentials.adminPassword);
        actions.enterText(usersPage.confirmPasswordTextField,Credentials.adminPassword);

        //click save
        actions.clickElement(usersPage.saveBtn);

        //filter for created user
        //click filter button
        actions.clickElement(usersPage.filterBtn);

        //filter by first name to test user is created
        Thread.sleep(2000);
        actions.enterText(usersPage.firstNameFilterTextField,userFirstName);

        //click apply
        actions.clickElement(usersPage.applyFiltersBtn);

        //test that user appears
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(usersPage.filteredUserName), userFirstName + " " + userLastName);

        deleteUser(userFirstName);
    }

    @Test(priority = 10)
    public void createAdminUserByAdmin() throws InterruptedException {

        //sign-out from user
        actions.clickElement(homePage.profileIconBtn);
        actions.clickElement(homePage.signoutBtn);

        ///login with partner-admin account
        Thread.sleep(3000);
        Helpers.loginWithValidUser((ChromeDriver) MainTestRunner.ChromeDriver,Credentials.adminUsername,Credentials.adminPassword);

        //navigate to users page
        actions.clickElement(homePage.usersSidebarBtn);

        //clear any preset filter
        actions.clickElement(usersPage.filterBtn);
        actions.clickElement(usersPage.clearFiltersBtn);

        //click add user
        actions.clickElement(usersPage.addUserBtn);

        //insert user data
        Thread.sleep(3000);
        userFirstName = "FirstName_" + MainTestRunner.CurrentTestTime;
        userLastName = "LastName_" + MainTestRunner.CurrentTestTime;
        userEmail = "Email_" + Helpers.generateRandomString() + "@email.com";

        //insert first name
        actions.enterText(usersPage.firstNameCreateTextField,userFirstName);

        //insert last name
        actions.enterText(usersPage.lastNameCreateTextField,userLastName);

        //choose affiliate
        actions.chooseFromDropDown(usersPage.affiliateDropDown,"Sub1");

        //select role
        actions.chooseFromDropDown(usersPage.roleDropDown,"Admin");

        //insert email
        actions.enterText(usersPage.createEmailTextField,userEmail);

        //insert password and password confirmation
        actions.enterText(usersPage.passwordTextField,Credentials.adminPassword);
        actions.enterText(usersPage.confirmPasswordTextField,Credentials.adminPassword);

        //click save
        actions.clickElement(usersPage.saveBtn);

        //filter for created user
        //click filter button
        actions.clickElement(usersPage.filterBtn);

        //filter by first name to test user is created
        Thread.sleep(2000);
        actions.enterText(usersPage.firstNameFilterTextField,userFirstName);

        //click apply
        actions.clickElement(usersPage.applyFiltersBtn);

        //test that user appears
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(usersPage.filteredUserName), userFirstName + " " + userLastName);

        deleteUser(userFirstName);
    }

    @Test(priority = 11)
    public void createUserByAdmin() throws InterruptedException {

        //clear any preset filter
        actions.clickElement(usersPage.filterBtn);
        actions.clickElement(usersPage.clearFiltersBtn);

        //click add user
        actions.clickElement(usersPage.addUserBtn);

        //insert user data
        Thread.sleep(3000);
        userFirstName = "FirstName_" + MainTestRunner.CurrentTestTime;
        userLastName = "LastName_" + MainTestRunner.CurrentTestTime;
        userEmail = "Email_" + Helpers.generateRandomString() + "@email.com";

        //insert first name
        actions.enterText(usersPage.firstNameCreateTextField,userFirstName);

        //insert last name
        actions.enterText(usersPage.lastNameCreateTextField,userLastName);

        //choose affiliate
        actions.chooseFromDropDown(usersPage.affiliateDropDown,"Sub1");

        //select role
        actions.chooseFromDropDown(usersPage.roleDropDown,"User");

        //insert email
        actions.enterText(usersPage.createEmailTextField,userEmail);

        //insert password and password confirmation
        actions.enterText(usersPage.passwordTextField,Credentials.adminPassword);
        actions.enterText(usersPage.confirmPasswordTextField,Credentials.adminPassword);

        //click save
        actions.clickElement(usersPage.saveBtn);

        //filter for created user
        //click filter button
        actions.clickElement(usersPage.filterBtn);

        //filter by first name to test user is created
        Thread.sleep(2000);
        actions.enterText(usersPage.firstNameFilterTextField,userFirstName);

        //click apply
        actions.clickElement(usersPage.applyFiltersBtn);

        //test that user appears
        Thread.sleep(2000);
        Assert.assertEquals(actions.getText(usersPage.filteredUserName), userFirstName + " " + userLastName);

        deleteUser(userFirstName);
    }

    //helper method to delete any created user
    public void deleteUser(String username) throws InterruptedException {

        //clear any preset filter
        actions.clickElement(usersPage.filterBtn);
        actions.clickElement(usersPage.clearFiltersBtn);

       //click filter
        actions.clickElement(usersPage.filterBtn);

        //insert firstname
        actions.enterText(usersPage.firstNameFilterTextField,username);

        actions.clickElement(usersPage.applyFiltersBtn);

        //click actions
        Thread.sleep(2000);
        actions.scrollToElementHorizontally(usersPage.tableHorizontalScrollBar, 500);
        actions.clickElement(usersPage.firstRowActionsBtn);

        //click delete
        actions.clickElement(usersPage.deleteUserOption);

        //confirm delete
        actions.clickElement(usersPage.confirmDeleteBtn);

        //refresh window
        actions.refreshWindow();
    }
}
