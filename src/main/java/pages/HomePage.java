package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utiles.MethodHandles;

import java.time.Duration;

public class HomePage extends MethodHandles {
    WebDriverWait wait;

    public HomePage(){
    }

    public HomePage(ChromeDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    //sidebar button expands and collapses it
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[1]/div[1]/div[1]/button")
    private WebElement sideBarBtn;

    //profile icon
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[1]/div[2]/div[1]/div/span/span/div")
    private WebElement profileIconBtn;

    //profile info displayed after expanding profile
    @FindBy(xpath = "/html/body/div[2]/div/div[1]/div/div")
    private WebElement profileInfo;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]")
    private WebElement signoutBtn;

    //change theme button
    @FindBy(xpath = "//*[@id=\"main-layout\"]/div[1]/div[2]/button[2]")
    private WebElement changeThemeBtn;

    //change language button
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[1]/div[2]/button[1]")
    private WebElement changeLanguageBtn;

    //first language option (English)
    @FindBy(xpath = "/html/body/div[2]/div/div[3]")
    private WebElement firstLanguageOption;

    //second language option (Portuguese)
    @FindBy(xpath = "/html/body/div[2]/div/div[4]")
    private WebElement secondLanguageOption;

    //third language option (Chinese)
    @FindBy(xpath = "/html/body/div[2]/div/div[5]")
    private WebElement thirdLanguageOption;

    //fourth language option (Korean)
    @FindBy(xpath = "/html/body/div[2]/div/div[6]")
    private WebElement fourthLanguageOption;

    //fifth language option (Polish)
    @FindBy(xpath = "/html/body/div[2]/div/div[7]")
    private WebElement fifthLanguageOption;

    //sixth language option (Spanish)
    @FindBy(xpath = "/html/body/div[2]/div/div[8]")
    private WebElement sixthLanguageOption;

    //button to return to homepage
    @FindBy(xpath = "//*[@id=\"main-layout\"]/div[1]/div[1]/nav/ol/li/button")
    private WebElement homeBtn;

    //dashboard button in sidebar
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div[1]/div")
    private WebElement dashboardSidebarBtn;

    //analytics button in sidebar
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div[2]/div")
    private WebElement analyticsDashboardBtn;

    //instruments button in sidebar
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div[3]/div")
    private WebElement instrumentsSidebarBtn;

    //recipes button in sidebar
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div[4]/div")
    private WebElement recipesSidebarBtn;

    //journals button in sidebar
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div[5]/div")
    private WebElement journalsSidebarBtn;

    //alerts button in sidebar
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div[6]/div")
    private WebElement alertsSidebarBtn;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div[7]/div")
    private WebElement affiliateSidebarBtn;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div[8]/div")
    private WebElement usersSidebarBtn;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div[8]/div")
    private WebElement helpAndSupportSidebarBtn;

    ////////////////////////Click Methods////////////////////////
    public boolean clickSideBarBtn(){
        return clickElement(sideBarBtn);
    }

    public boolean clickSignoutBtn(){
        return clickElement(signoutBtn);
    }

    public boolean clickSidebarAnalyticsBtn(){
        return clickElement(analyticsDashboardBtn);
    }

    public boolean clickDashBoardSidebarBtn(){
        return clickElement(dashboardSidebarBtn);
    }

    public boolean clickInstrumentsDashboardBtn(){
        return clickElement(instrumentsSidebarBtn);
    }

    public boolean clickRecipesSidebarBtn(){
        return clickElement(recipesSidebarBtn);
    }

    public boolean clickJournalsSidebarBtn(){
        return clickElement(journalsSidebarBtn);
    }

    public boolean clickAlertsSidebarBtn(){
        return clickElement(alertsSidebarBtn);
    }

    public boolean clickAffiliateSidebarBtn(){
        return clickElement(affiliateSidebarBtn);
    }

    public boolean clickUsersSidebarBtn(){
        return clickElement(usersSidebarBtn);
    }

    public boolean clickHelpAndSupportSidebarBtn(){
        return clickElement(helpAndSupportSidebarBtn);
    }

    public boolean clickProfileIconBtn(){
        return clickElement(profileIconBtn);
    }

    public boolean clickChangeThemeBtn(){
        return clickElement(changeThemeBtn);
    }

    public boolean clickChangeLanguageBtn(){
        return clickElement(changeLanguageBtn);
    }

    public boolean clickFirstLanguageOption(){
        return clickElement(firstLanguageOption);
    }

    public boolean clickSecondLanguageOption(){
        return clickElement(secondLanguageOption);
    }

    public boolean clickThirdLanguageOption(){
        return clickElement(thirdLanguageOption);
    }

    public boolean clickFourthLanguageOption(){
        return clickElement(fourthLanguageOption);
    }

    public boolean clickFifthLanguageOption(){
        return clickElement(fifthLanguageOption);
    }

    public boolean clickSixthLanguageOption(){
        return clickElement(sixthLanguageOption);
    }

    public boolean clickHomeBtn(){
        return clickElement(homeBtn);
    }
/////////////////////////getText Methods/////////////////////////

    public String getProfileInfoText(){
        return getElementText(profileInfo);
    }



}
