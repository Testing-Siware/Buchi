package base;

import data.Credentials;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.Actions;
import pages.HomePage;
import pages.LoginPage;
import pages.UsersPage;

public class deleteUsers {

    UsersPage usersPage;
    HomePage homePage;
    Actions actions;

    @Test(priority = 0)
    public void deleteUsers() throws InterruptedException {
        //search for user to delete
        usersPage=new UsersPage((ChromeDriver) MainTestRunner.ChromeDriver);
        homePage=new HomePage((ChromeDriver) MainTestRunner.ChromeDriver);

        LoginPage loginPage=new LoginPage((ChromeDriver) MainTestRunner.ChromeDriver);


        loginPage.EnterEmailField(Credentials.superAdminUsername);
        loginPage.ClickLoginNextButton();
        loginPage.EnterPasswordField(Credentials.superAdminPassword);
        loginPage.ClickSignInButton();

        homePage.clickUsersSidebarBtn();

        String name;
        actions=new Actions((ChromeDriver) MainTestRunner.ChromeDriver,20);
        for (int i=44;i<=99;i++){
             name="partnerAdmin";
            if(i<=9){
                name+="00"+i;
            }
            else{
                name+="0"+i;
            }
            deleteUser(name);
            Thread.sleep(4000);
        }

    }

    //helper method to delete any user created by admin
    public void deleteUser(String username) throws InterruptedException {
        //clear any preset filter
        usersPage.clickFilterBtn();
        usersPage.clickClearFiltersBtn();

        Thread.sleep(4000);

        //insert username in search field
        usersPage.sendTextToSearchField(username);

        //click search
        usersPage.clickSearchBtn();

        //click actions
        Thread.sleep(2000);
        actions.scrollToElementHorizontally(usersPage.tableHorizontalScrollBar,500);
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
