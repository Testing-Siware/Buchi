package base;


import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.sql.Driver;

import pages.*;
import data.Credentials;
import utils.EnvironmentSelector;
import utils.Helpers;

public class LoginModule {
    LoginPage  loginPage;
    HomePage homePage;


    //blank fields
//    @Test(priority = 0)
//    public  void BlankFields() throws InterruptedException
//    {
//        //initialize loginPage class
//        loginPage = new LoginPage((ChromeDriver) MainTestRunner.ChromeDriver);
//        //initialize homePage class
//        homePage = new HomePage((ChromeDriver) MainTestRunner.ChromeDriver);
//        Thread.sleep(2000);
//    }

//    @Test(priority = 1)
//    public void resetPassword() throws InterruptedException, TesseractException, IOException, AWTException {
//
//        //click need help sign in
//        loginPage.NeedHelpSigningInButtonIsDisplayed();
//        loginPage.ClickNeedHelpSigningInButton();
//
//        //click forgot password
//        loginPage.ForgotPasswordIsDisplayed();
//        loginPage.ClickForgotPassword();
//
//        //insert email
//        loginPage.sendTextToRecoveryEmailField("email@mail.com");
//
//        //click reset via email
//        loginPage.clickResetViaEmailBtn();
//
//        //test that reset email message appears
//        Thread.sleep(2000);
//        Assert.assertEquals(loginPage.getResetEmailSendText(), "Email sent!");
//
//        //click back to sign in
//        Thread.sleep(3000);
//        loginPage.clickBackToSignInBtn();
//    }
//
//    @Test(priority = 2)
//    public void navigateToHelpPage() throws InterruptedException {
//
//        String originalWindow = loginPage.getWindowHandle();
//
//        Thread.sleep(5000);
//        //click need help sign in
//        loginPage.NeedHelpSigningInButtonIsDisplayed();
//        loginPage.ClickNeedHelpSigningInButton();
//
//        //click help
//        loginPage.clickHelpBtn();
//        loginPage.changeWindow();
//
//        //test that user is redirected to the okta help page
//        Assert.assertEquals(loginPage.getCurrentURL(),"https://dev-27844335.okta.com/help/login");
//
//        loginPage.switchWindow(originalWindow);
//
//    }
//
//    @Test(priority = 3)
//    public void showAndHidePassword() throws TesseractException, IOException, AWTException, InterruptedException {
//
//        //insert credentials
//        loginPage.EnterEmailField("InvalidUsername");
//        loginPage.ClickLoginNextButton();
//        loginPage.EnterPasswordField("c@234");
//
//        //take screenshot while password is hidden & test that password is not visible
//        Thread.sleep(2000);
//        System.out.println(Helpers.getOCR());
//        Assert.assertFalse(Helpers.getOCR().contains("c@234"));
//
//        //click show password icon
//        loginPage.clickEyeIcon();
//        System.out.println("---------------------------------------------------");
//
//        //take screenshot while password is visible & test that password is  visible
//        Thread.sleep(2000);
//        System.out.println(Helpers.getOCR());
//        Assert.assertTrue(Helpers.getOCR().contains("c@234"));
//
//        loginPage.navigateBack();
//
//    }
//
//    @Test(priority = 3)
//    public void LoginWithInValidCredentials (){
//
//        loginPage.EnterEmailField("InvalidUsername");
//        loginPage.ClickLoginNextButton();
//        loginPage.EnterPasswordField("1234");
//        loginPage.ClickSignInButton();
//
//        Assert.assertEquals(loginPage.getUnableToSigninMessageText(),"Unable to sign in");
//
//        loginPage.navigateTo(EnvironmentSelector.PortaMainlUrl);
//    }

//    @Test(priority = 5)
//    public void loginWithPartnerAdmin() throws  InterruptedException {
//
//        loginPage.navigateTo(EnvironmentSelector.PortaMainlUrl);
//
//        loginPage.EnterEmailField(Credentials.partnerAdminUsername);
//        loginPage.ClickLoginNextButton();
//        loginPage.EnterPasswordField(Credentials.partnerAdminPassword);
//        loginPage.ClickSignInButton();
//
//        //test that user logged in with partner admin
//        homePage.clickProfileIconBtn();
//        Thread.sleep(9000);
//        Assert.assertTrue(homePage.getProfileInfoText().contains("PartnerAdmin"));
//
//
//        //click signout
//        homePage.clickSignoutBtn();
//        Thread.sleep(1000);
//    }

//    @Test(priority = 6)
//    public void loginWithUser() throws  InterruptedException {
//        loginPage.EnterEmailField(Credentials.userName);
//        loginPage.ClickLoginNextButton();
//        loginPage.EnterPasswordField(Credentials.userPassword);
//        loginPage.ClickSignInButton();
//
//        //test that user logged in with partner admin
//        homePage.clickProfileIconBtn();
//        Thread.sleep(9000);
//        Assert.assertTrue(homePage.getProfileInfoText().contains("User"));
//
//        //click signout
//        homePage.clickSignoutBtn();
//    }
//
//    @Test(priority = 6)
//    public void loginWithSuperAdmin() throws  InterruptedException {
//        loginPage.EnterEmailField(Credentials.superAdminUsername);
//        loginPage.ClickLoginNextButton();
//        loginPage.EnterPasswordField(Credentials.superAdminPassword);
//        loginPage.ClickSignInButton();
//
//        //test that user logged in with partner admin
//        homePage.clickProfileIconBtn();
//        Thread.sleep(9000);
//        Assert.assertTrue(homePage.getProfileInfoText().contains("SuperAdmin"));
//
//        //click signout
//        homePage.clickSignoutBtn();
//    }
//
//    @Test(priority = 6)
//    public void loginWithAdmin() throws  InterruptedException {
//        loginPage.EnterEmailField(Credentials.adminUsername);
//        loginPage.ClickLoginNextButton();
//        loginPage.EnterPasswordField(Credentials.adminPassword);
//        loginPage.ClickSignInButton();
//
//        //test that user logged in with partner admin
//        homePage.clickProfileIconBtn();
//        Thread.sleep(9000);
//        System.out.println(homePage.getProfileInfoText());
//        Assert.assertTrue(homePage.getProfileInfoText().contains("Admin"));
//
//        //click signout
//        homePage.clickSignoutBtn();
//    }
//
//    @Test(priority = 6)
//    public void loginWithPartnerUser() throws  InterruptedException {
//        loginPage.EnterEmailField(Credentials.partnerUserUsername);
//        loginPage.ClickLoginNextButton();
//        loginPage.EnterPasswordField(Credentials.partnerUserPassword);
//        loginPage.ClickSignInButton();
//
//        //test that user logged in with partner admin
//        homePage.clickProfileIconBtn();
//        Thread.sleep(9000);
//        Assert.assertTrue(homePage.getProfileInfoText().contains("PartnerUser"));
//
//        //click signout
//        homePage.clickSignoutBtn();
//    }
//
//    @Test(priority = 7)
//    public void loginWithSupport() throws  InterruptedException {
//        loginPage.EnterEmailField(Credentials.supportUsername);
//        loginPage.ClickLoginNextButton();
//        loginPage.EnterPasswordField(Credentials.supportPassword);
//        loginPage.ClickSignInButton();
//
//        //test that user logged in with partner admin
//        homePage.clickProfileIconBtn();
//        Thread.sleep(9000);
//        Assert.assertTrue(homePage.getProfileInfoText().contains("Support"));
//        homePage.navigateBack();
//
//    }





    /*
    @Test(priority = 4)
    public void loginWithLockedAccount() {

        loginPage.EnterEmailField(Credentials.DevLockedUsername);
        loginPage.ClickLoginNextButton();
        loginPage.EnterPasswordField(Credentials.DevSupportPassword);
        loginPage.ClickSignInButton();

        Assert.assertEquals(loginPage.getUnableToSigninMessageText(),"Your account is locked. Please contact your administrator.");

        //click back
        loginPage.navigateBack();
    }

    @Test(priority = 5)
    public void loginWithPartnerUser() throws  InterruptedException {

        loginPage.EnterEmailField(Credentials.DevPartnerUserName);
        loginPage.ClickLoginNextButton();
        loginPage.EnterPasswordField(Credentials.DevPartnerUserPassword);
        loginPage.ClickSignInButton();

        homePage.ClickProfileDropDownList();
        Assert.assertTrue(homePage.getProfileRoleText().contains("PartnerUser"));
    }
*/


}
