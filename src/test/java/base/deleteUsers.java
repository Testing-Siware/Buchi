package base;

import data.Credentials;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UsersPage;

public class deleteUsers {

    UsersPage usersPage;
    HomePage homePage;

    @Test(priority = 0)
    public void deleteUsers() throws InterruptedException {
        //search for user to delete
        usersPage=new UsersPage((ChromeDriver) MainTestRunner.ChromeDriver);
        homePage=new HomePage((ChromeDriver) MainTestRunner.ChromeDriver);

        LoginPage loginPage=new LoginPage((ChromeDriver) MainTestRunner.ChromeDriver);


        loginPage.EnterEmailField(Credentials.supportUsername);
        loginPage.ClickLoginNextButton();
        loginPage.EnterPasswordField(Credentials.supportPassword);
        loginPage.ClickSignInButton();

        homePage.clickUsersSidebarBtn();


        for (int i=0;i<17;i++){
            deleteUser("first");
            Thread.sleep(4000);
        }

    }

    //helper method to delete any user created by admin
    public void deleteUser(String username) throws InterruptedException {
        //clear any preset filter
        usersPage.clickFilterBtn();
        usersPage.clickClearFiltersBtn();
        usersPage.clickApplyFiltersBtn();

        Thread.sleep(4000);

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
}
