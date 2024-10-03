package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import utiles.MethodHandles;

import java.time.Duration;


public class LoginPage extends MethodHandles {

    WebDriverWait wait;

    public LoginPage(){
        super();
    }

    public LoginPage(ChromeDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }


    @FindBy(id = "idp-discovery-username")
    private WebElement EmailField;

    @FindBy(id = "okta-signin-password")
    private WebElement PasswordField;

    @FindBy(id = "idp-discovery-submit")
    private WebElement LoginNextButton;

    @FindBy(id = "okta-signin-submit")
    private WebElement SignInButton;

    @FindBy(xpath = "/html/body/div/div/div/div/main/div[2]/div/div/form/div[1]/div[1]/div/div")
    private WebElement SignInErrorMessage;

    @FindBy(id = "input-container-error46")
    private WebElement BlankErrorMessage;

    @FindBy(xpath = "/html/body/div/div[1]/div/div/main/div[2]/div/div/form/div[1]/div[2]/div[2]/div[2]/span/span/span[1]")
    private WebElement eyeIcon;

    @FindBy(xpath = "/html/body/div/div[1]/div/div/main/div[2]/div/div/form/div[1]/div[1]/div/div/p")
    private WebElement UnableToSignErrorMessage;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div/main/div[2]/div/div/div/a")
    private WebElement NeedHelpSigningInButton;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div/main/div[2]/div/div/div/ul/li[1]/a")
    private WebElement ForgotPassword;

    @FindBy(xpath = "/html/body/div/div[1]/div/div/main/div[2]/div/div/form/div/div[2]/a")
    private WebElement resetViaEmailBtn;

    @FindBy(xpath = "/html/body/div/div[1]/div/div/main/div[2]/div/div/form/div/h2")
    private WebElement resetEmailSent;

    @FindBy(xpath = "/html/body/div/div[1]/div/div/main/div[2]/div/div/form/div/div[2]/a")
    private WebElement backToSignInBtn;

    @FindBy(xpath = "//html/body/div/div[1]/div/div/main/div[2]/div/div/div/ul/li[2]/a")
    private WebElement helpBtn;

    @FindBy(id = "account-recovery-username")
    private WebElement AccountRecoveryUsernameFiled;
    public boolean BlankErrorMessageIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(BlankErrorMessage));
        return BlankErrorMessage.isDisplayed();
    }

    public void clickBackToSignInBtn() {
        clickElement(backToSignInBtn);
    }

    public boolean clickEyeIcon() { return clickElement(eyeIcon);}

    public String getPasswordText(){
        return getElementText(PasswordField);
    }
    public boolean clickHelpBtn(){
        return clickElement(helpBtn);
    }

    public String getUnableToSigninMessageText(){
        return getElementText(UnableToSignErrorMessage);
    }


    public boolean sendTextToRecoveryEmailField(String email) {
        return sendTextToElement(AccountRecoveryUsernameFiled, email);
    }

    public boolean EmailFieldIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(EmailField));
        return EmailField.isDisplayed();
    }

    public void EnterEmailField(String email){
        wait.until(ExpectedConditions.visibilityOf(EmailField));
        EmailField.sendKeys(email);
    }

    public boolean clickResetViaEmailBtn(){return clickElement(resetViaEmailBtn);}

    public String getResetEmailSendText(){return getElementText(resetEmailSent);}

    public boolean PasswordFieldIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(PasswordField));
        return PasswordField.isDisplayed();
    }

    public void EnterPasswordField(String password){
        wait.until(ExpectedConditions.visibilityOf(PasswordField));
        PasswordField.sendKeys(password);
    }



    public boolean LoginNextButtonIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(LoginNextButton));
        return LoginNextButton.isDisplayed();
    }

    public void ClickLoginNextButton(){
        wait.until(ExpectedConditions.visibilityOf(LoginNextButton));
        LoginNextButton.click();
    }



    public boolean SignInButtonIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(SignInButton));
        return SignInButton.isDisplayed();
    }

    public void ClickSignInButton(){
        wait.until(ExpectedConditions.visibilityOf(SignInButton));
        SignInButton.click();
    }




    public boolean SignInErrorMessageIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(SignInErrorMessage));
        return SignInErrorMessage.isDisplayed();
    }

    public String GetSignInErrorMessage(){
        wait.until(ExpectedConditions.visibilityOf(SignInErrorMessage));
        return SignInErrorMessage.getText();
    }

    public boolean NeedHelpSigningInButtonIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(NeedHelpSigningInButton));
        return NeedHelpSigningInButton.isDisplayed();
    }

    public void ClickNeedHelpSigningInButton(){
        wait.until(ExpectedConditions.visibilityOf(NeedHelpSigningInButton));
        NeedHelpSigningInButton.click();
    }

    public boolean ForgotPasswordIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(ForgotPassword));
        return ForgotPassword.isDisplayed();
    }

    public void ClickForgotPassword(){
        wait.until(ExpectedConditions.visibilityOf(ForgotPassword));
        ForgotPassword.click();
    }

    public boolean AccountRecoveryUsernameFiledIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(AccountRecoveryUsernameFiled));
        return AccountRecoveryUsernameFiled.isDisplayed();
    }

    public void ClickAccountRecoveryUsernameFiled(){
        wait.until(ExpectedConditions.visibilityOf(AccountRecoveryUsernameFiled));
        AccountRecoveryUsernameFiled.click();
    }

    public void loginWithCredentials(String username, String password){
       EnterEmailField(username);
       ClickLoginNextButton();
        EnterPasswordField(password);
        ClickSignInButton();


    }
}
