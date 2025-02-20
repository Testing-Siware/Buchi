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
    public WebElement sideBarBtn;

    //profile icon
    @FindBy(id = "navbar-avatar-desktop-view-tooltip-trigger")
    public WebElement profileIconBtn;

    //profile info displayed after expanding profile
    @FindBy(xpath = "/html/body/div[2]/div/div[1]/div/div")
    public WebElement profileInfo;

    //button to signout from user
    @FindBy(id = "navbar-avatar-desktop-view-dropdown-menu-item-sign-out")
    public WebElement signoutBtn;

    @FindBy(id = "navbar-avatar-desktop-view-dropdown-menu-item-sign-out")
    public WebElement signoutBtnAdmin;
    //button to view profile info
    @FindBy(xpath = "/html/body/div[2]/div/div[3]")
    public WebElement securityBtn;

    @FindBy(xpath = "/html/body/div[2]/div/div[4]")
    public WebElement profileBtn;

    //change theme button
    @FindBy(xpath = "//*[@id=\"main-layout\"]/div[1]/div[2]/button[2]")
    public WebElement changeThemeBtn;

    //change language button
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[1]/div[2]/button[1]")
    public WebElement changeLanguageBtn;

    //first language option (English)
    @FindBy(xpath = "/html/body/div[2]/div/div[3]")
    public WebElement firstLanguageOption;

    //second language option (Portuguese)
    @FindBy(xpath = "/html/body/div[2]/div/div[4]")
    public WebElement secondLanguageOption;

    //third language option (Chinese)
    @FindBy(xpath = "/html/body/div[2]/div/div[5]")
    public WebElement thirdLanguageOption;

    //fourth language option (Korean)
    @FindBy(xpath = "/html/body/div[2]/div/div[6]")
    public WebElement fourthLanguageOption;

    //fifth language option (Polish)
    @FindBy(xpath = "/html/body/div[2]/div/div[7]")
    public WebElement fifthLanguageOption;

    //sixth language option (Spanish)
    @FindBy(xpath = "/html/body/div[2]/div/div[8]")
    public WebElement sixthLanguageOption;

    //button to return to homepage
    @FindBy(xpath = "//*[@id=\"main-layout\"]/div[1]/div[1]/nav/ol/li/button")
    public WebElement homeBtn;

    //dashboard button in sidebar
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div[1]/div")
    public WebElement dashboardSidebarBtn;

    //analytics button in sidebar
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div[2]/div")
    public WebElement analyticsDashboardBtn;

    //instruments button in sidebar
    @FindBy(id = "side-menu-fleet-management-instruments")
    public WebElement instrumentsSidebarBtn;

    //recipes button in sidebar
    @FindBy(id = "side-menu-fleet-management-recipes")
    public WebElement recipesSidebarBtn;

    //journals button in sidebar
    @FindBy(id = "side-menu-fleet-management-journals")
    public WebElement journalsSidebarBtn;

    //alerts button in sidebar
    @FindBy(id = "side-menu-fleet-management-alerts")
    public WebElement alertsSidebarBtn;

    @FindBy(id = "side-menu-access-management-affiliates")
    public WebElement affiliateSidebarBtn;

    @FindBy(id = "side-menu-access-management-users-tooltip-trigger")
    public WebElement usersSidebarBtn;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div[8]/div")
    public WebElement helpAndSupportSidebarBtn;

    //users sidebar button for superadmin
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div[3]/div")
    public WebElement usersSidebarBtnSuperAdmin;

    //users sidebar button for superadmin
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div[7]/div")
    public WebElement usersSidebarBtnAdmin;

    //affiliates sidebar button for superadmin
    @FindBy(id = "/html/body/div/div[1]/div[2]/div[2]/div[2]/div")
    public WebElement affiliateSidebarBtnSuperAdmin;

    ///////////////////////////////////////Click Methods///////////////////////////////////////
    public boolean clickAffiliateSidebarBtnSuperAdmin(){ return clickElement(affiliateSidebarBtnSuperAdmin);}

    public boolean clickUsersSidebarBtnAdmin(){
        return clickElement(usersSidebarBtnAdmin);
    }

    public boolean clickUsersSidebarBtnSuperAdmin(){
        return clickElement(usersSidebarBtnSuperAdmin);
    }
    public boolean clickSideBarBtn(){
        return clickElement(sideBarBtn);
    }

    public boolean clickSignoutBtn(){
        return clickElement(signoutBtn);
    }
    public boolean clickSignoutBtnAdmin(){
        return clickElement(signoutBtnAdmin);
    }
    public boolean clickSecurityBtn(){
        return clickElement(securityBtn);
    }
    public boolean clickProfileBtn(){
        return clickElement(profileBtn);
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
