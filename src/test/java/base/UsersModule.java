package base;

import com.beust.ah.A;
import data.Credentials;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UsersPage;
import utils.Helpers;

public class UsersModule {
    UsersPage usersPage;
    HomePage homePage;
    String userFirstName;
    String userLastName;
    String userEmail;

    @Test(priority = 0)
    public void createInvalidUser() {
        usersPage = new UsersPage((ChromeDriver) MainTestRunner.ChromeDriver);
        homePage = new HomePage((ChromeDriver) MainTestRunner.ChromeDriver);

        //navigate to users page
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
        usersPage.sendTextToEmailField("not a valid email address");
        Assert.assertEquals(usersPage.getEmailErrorMsg(), "Please enter a valid email address.");

        //test that password cannot be more than 20 characters
        usersPage.sendTextToPasswordField("This password is longer than required");
        Assert.assertEquals(usersPage.getPasswordErrorMsg(), "Password is too long. it must be no more than 20 characters long.");

        //test that password contains all required symbols
        usersPage.clearPasswordField();
        usersPage.sendTextToPasswordField("abcdefgh");
        Assert.assertEquals(usersPage.getPasswordErrorMsg(), "Password must be between 8 and 20 characters long, and include at least one uppercase letter, one lowercase letter, one number, and one special character (e.g., @$!%*?&).");

        //test that first and last name cannot be more than 30 characters
        usersPage.sendTextToFirstNameFieldText("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
        Assert.assertEquals(usersPage.getFirstNameErrorMsg(), "First name is too long. it must be no more than 30 characters long.");

        usersPage.sendTextToLastNameFieldText("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
        Assert.assertEquals(usersPage.getLastNameErrorMsg(),"Last name is too long. it must be no more than 30 characters long.");

        //click cancel
        usersPage.clickCancelBtn();
    }

    @Test(priority = 0)
    public void createValidUser() throws InterruptedException {
        usersPage = new UsersPage((ChromeDriver) MainTestRunner.ChromeDriver);
        homePage = new HomePage((ChromeDriver) MainTestRunner.ChromeDriver);

        //navigate to users page
        homePage.clickUsersSidebarBtn();

        //click add user
        usersPage.clickAddUserBtn();

        //insert user data
        Thread.sleep(3000);
        userFirstName = "FirstName_" + MainTestRunner.CurrentTestTime;
        userLastName = "LastName_" + MainTestRunner.CurrentTestTime;
        userEmail = "Email_" + Helpers.generateRandomString() + "@email.com";

        //insert first name
        usersPage.sendTextToFirstNameFieldText(userFirstName);

        //insert last name
        usersPage.sendTextToLastNameFieldText(userFirstName);

        //choose affiliate
        usersPage.sendTextToAffiliateDropDown("Buchi");

        //select role
        usersPage.sendTextToRoleDropDown("PartnerAdmin");

        //insert email
        usersPage.sendTextToEmailField(userEmail);

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
        System.out.println(usersPage.getFilteredUserNameText());

    }
}
