package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utiles.MethodHandles;

public class UsersPage extends MethodHandles {

    public UsersPage(ChromeDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }
    ///////////////////////////////////////Users Homepage///////////////////////////////////////

    //new user button
    @FindBy(id = "user-list-add-section-button")
    private WebElement addUserBtn;

    //search field to search by user
    @FindBy(id="users-list-table-search-input")
    private WebElement searchField;

    //confirm delete button
    @FindBy(id = "user-list-alert-dialog-button-confirm")
    public WebElement confirmDeleteBtn;

    //confirm edit button
    @FindBy(id = "user-edit-form-alert-dialog-button-confirm")
    public WebElement confirmEditBtn;

    //search button to fetch searched results
    @FindBy(id = "users-list-table-search-submit")
    private WebElement searchBtn;

    //filter button to show filter menu
    @FindBy(id = "users-list-table-filter-button")
    public WebElement filterBtn;

    //text field to filter by first name
    @FindBy(id = "users-list-table-filter-input-firstName")
    private WebElement firstNameFilterTextField;

    //text field to filter by second name
    @FindBy(id = "users-list-table-filter-input-lastName")
    private WebElement lastNameFilterTextField;

    //text field to filter by email
    @FindBy(id = "users-list-table-filter-input-email")
    private WebElement emailFilterTextField;

    //clear any set filters button
    @FindBy(id = "users-list-table-filter-button-clear")
    private WebElement clearFiltersBtn;

    //apply any set filters button
    @FindBy(id = "users-list-table-filter-button-submit")
    private WebElement applyFiltersBtn;

    //cancel any edits in filters button
    @FindBy(id = "users-list-table-filter-button-cancel")
    private WebElement cancelFiltersBtn;

    //views button to view extra columns in grid view
    @FindBy(id = "user-list-table-viewing-option-dropdown-trigger")
    private WebElement viewBtn;

    //name of first user in search results
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[2]")
    public WebElement filteredUserName;

    //email of first user in search results
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[4]")
    private WebElement filteredEmail;

    //created at of first user in search result
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[1]/div[2]/div[3]/div[1]/div[2]/div/div/div[4]")
    private WebElement filteredCreatedAt;

    //modified at of first user in search result
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[1]/div[2]/div[3]/div[1]/div[2]/div/div/div[3]")
    private WebElement filteredModifiedAt;

    //actions button to edit or delete user
    @FindBy(id="users-list-table-actions-cell-0")
    public WebElement actionsBtn;

    //actions button to edit or delete user when logged in with admin
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr[1]/td[7]/button")
    private WebElement actionsBtnAdmin;

    //option to edit user from actions button dropdown
    @FindBy(id = "dropdown-menu-item-user-list-table-option-edit")
    private WebElement editUserOption;

    //option to delete user from actions button dropdown
    @FindBy(id = "dropdown-menu-item-user-list-table-option-delete")
    public WebElement deleteUserOption;

    //fifth column header (can be created or modified at)
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[1]/div[2]/div[1]/div[2]/div/div/div[3]/div[3]/div/div/div")
    private WebElement fifthColumnHeader;

    //toggle the created at column option to hide or view
    @FindBy(xpath = "/html/body/div[2]/div/div[3]")
    private WebElement toggleCreatedAtColumnOption;

    //toggle the modified at column option to hide or view
    @FindBy(xpath = "/html/body/div[2]/div/div[4]")
    private WebElement toggleModifiedAtColumnOption;

    //clear any pinning
    @FindBy(xpath = "/html/body/div[2]/div/div[6]")
    private WebElement clearPinningOption;

    //clear any sorting
    @FindBy(xpath = "/html/body/div[2]/div/div[7]")
    private WebElement clearSortingOption;

    //second user in table name
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr[2]/td[2]")
    private WebElement secondUsername;

    //email of second user in table name
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr[2]/td[5]")
    private WebElement secondUserEmail;

    //second user created at
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr[2]/td[5]")
    private WebElement secondUserCreatedAt;

    //second user modified at
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr[2]/td[7]")
    private WebElement secondUserModifiedAt;

    //sort ascending button for any column
    @FindBy(xpath = "/html/body/div[2]/div/div[1]")
    private WebElement sortAscOption;

    //sort descending button for any column
    @FindBy(xpath = "/html/body/div[2]/div/div[2]")
    private WebElement sortDescOption;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[8]/div[2]")
    public WebElement tableHorizontalScrollBar;
    ///////////////////////////////////////Add User Page///////////////////////////////////////

    //first name text field
    @FindBy(id = "user-create-form-input-firstName")
    private WebElement firstNameCreateTextField;

    ///first name text field in edit
    @FindBy(id = "user-edit-form-input-firstName")
    private WebElement firstNameEditTextField;

    //last name text field
    @FindBy(id = "user-create-form-input-lastName")
    private WebElement lastNameCreateTextField;

    @FindBy(id="user-edit-form-input-lastName")
    private WebElement lastNameEditTextField;

    //affiliate dropdown list
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div[1]/div[2]/div[3]/div[1]/div/div[1]/div[2]/input")
    private WebElement affiliateDropDown;

    //role dropdown list
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div[1]/div[2]/div[4]/div[1]/div/div[1]/div[2]/input")
    private WebElement roleDropDown;

    //email text field
    @FindBy(id= "user-create-form-input-email")
    private WebElement createEmailTextField;


    @FindBy(id= "user-edit-form-input-email")
    private WebElement editEmailTextField;

    //password field
    @FindBy(id = "user-create-form-input-password")
    private WebElement passwordTextField;

    //password confirm field
    @FindBy(id = "user-create-form-input-passwordConfirmation")
    private WebElement confirmPasswordTextField;

    @FindBy(xpath = "/html/body/div[3]/div[2]/button[1]")
    private WebElement cancelDeleteBtn;

    //error message if first name is invalid
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div[1]/div[2]/div[1]/div[2]/span")
    private WebElement firstNameErrorMsg;

    //error message if last name is invalid
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div[1]/div[2]/div[2]/div[2]/span")
    private WebElement lastNameErrorMsg;

    //error message if affiliate name is invalid
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div[1]/div[2]/div[3]/div[2]/span")
    private WebElement affiliateErrorMsg;

    //error message if role is invalid
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div[1]/div[2]/div[4]/div[2]/span")
    private WebElement roleErrorMsg;

    //error message if email is invalid
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div[2]/div[2]/div[1]/div[2]/span")
    private WebElement emailErrorMsg;

    //error message if first name is invalid
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div[2]/div[2]/div[3]/div[2]/span")
    private WebElement passwordErrorMsg;

    //error message if passwords don't match
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div[2]/div[2]/div[4]/div[2]/span")
    private WebElement confirmPasswordErrorMsg;

    //button to reset and clear all data entered in all fields
    @FindBy(id = "user-create-form-container-button-clear")
    private WebElement resetCreateBtn;

    @FindBy(id="user-edit-form-container-button-clear")
    private WebElement resetEditBtn;

    //button to cancel and return to users homepage
    @FindBy(id = "user-create-form-container-button-cancel")
    private WebElement cancelBtn;

    //button to save and create the user
    @FindBy(id = "user-create-form-container-button-submit")
    private WebElement saveBtn;

    //button to save and edit user
    @FindBy(id = "user-edit-form-container-button-submit")
    private WebElement saveEditsBtn;

    //create password on behalf of user checkbox
    @FindBy(id="user-create-form-checkbox-isPasswordRequired" )
    private WebElement createPasswordOnBehalfCheckBox;

    //image appears when search or filter don't return results
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[3]/div[2]/div/div[3]/div/div/img")
    private WebElement noResultsImg;

    //clear search field icon
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/form/div/div/div/div/div/svg")
    private WebElement clearSearchIcon;

    //sort by email button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/thead/tr/th[5]/div/div/div")
    private WebElement sortByEmail;

    //sort by created at button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/thead/tr/th[6]/div/div/div")
    private WebElement sortByCreatedAt;

    //sort by modified at button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/thead/tr/th[7]/div/div/div")
    private WebElement sortByModifiedAt;

    //sort by name button
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/thead/tr/th[2]/div/div/div")
    private WebElement sortByName;

    ///////////////////////////////////////Click Methods///////////////////////////////////////


    public boolean clickAddUserBtn() {
        return clickElement(addUserBtn);
    }

    public boolean clickConfirmDeleteBtn(){
        return clickElement(confirmDeleteBtn);
    }

    public boolean clickConfirmEditBtn(){
        return clickElement(confirmEditBtn);
    }

    public boolean clickCancelDeleteBtn(){
        return clickElement(cancelDeleteBtn);
    }

    public boolean clickSearchBtn() {
        return clickElement(searchBtn);
    }

    public boolean clickFilterBtn() {
        return clickElement(filterBtn);
    }

    public boolean clickClearFiltersBtn() {
        return clickElement(clearFiltersBtn);
    }

    public boolean clickApplyFiltersBtn() {
        return clickElement(applyFiltersBtn);
    }

    public boolean clickCancelFiltersBtn() {
        return clickElement(cancelFiltersBtn);
    }

    public boolean clickViewBtn() {
        return clickElement(viewBtn);
    }

    public boolean clickActionsBtn() {
        return clickElement(actionsBtn);
    }

    public boolean clickActionsBtnAdmin(){
        return clickElement(actionsBtnAdmin);
    }
    public boolean clickEditUserOption() {
        return clickElement(editUserOption);
    }

    public boolean clickDeleteUserOption() {
        return clickElement(deleteUserOption);
    }

    public boolean clickToggleCreatedAtColumn() {
        return clickElement(toggleCreatedAtColumnOption);
    }

    public boolean clickToggleModifiedAtColumn() {
        return clickElement(toggleModifiedAtColumnOption);
    }

    public boolean clickClearPinningOption() {
        return clickElement(clearPinningOption);
    }

    public boolean clickClearSortingOption() {
        return clickElement(clearSortingOption);
    }

    public boolean clickCancelBtn(){
        return clickElement(cancelBtn);
    }

    public boolean clickSaveBtn(){
        return clickElement(saveBtn);
    }

    public boolean clickSaveEditsBtn(){
        return clickElement(saveEditsBtn);
    }


    public boolean clickResetCreateBtn(){
        return clickElement(resetCreateBtn);
    }

    public boolean clickResetEditBtn(){
        return clickElement(resetEditBtn);
    }


    public boolean clickSortByEmailBtn(){
        return clickElement(sortByEmail);
    }

    public boolean clickSortByCreatedAtBtn(){
        return clickElement(sortByCreatedAt);
    }

    public boolean clickSortByModifiedAtBtn(){
        return clickElement(sortByModifiedAt);
    }

    public boolean clickSortByName(){
        return clickElement(sortByName);
    }

    public boolean clickPasswordOnBehalfCheckbox(){
        return clickElement(createPasswordOnBehalfCheckBox);
    }

    public boolean clickSortAscBtn(){
        return clickElement(sortAscOption);
    }

    public boolean clickSortDescBtn(){
        return clickElement(sortDescOption);
    }

    ///////////////////////////////////////Get Text Methods///////////////////////////////////////
    public String getFilteredUserNameText() {
        return getElementText(filteredUserName);
    }

    public String getFilteredEmailText() {
        return getElementText(filteredEmail);
    }

    public String getFilteredCreatedAtText() {
        return getElementText(filteredCreatedAt);
    }

    public String getFilteredModifiedAtText() {
        return getElementText(filteredModifiedAt);
    }

    public String getFifthColumnHeaderText() {
        return getElementText(fifthColumnHeader);
    }

    public String  getFirstNameErrorMsg(){
        return getElementText(firstNameErrorMsg);
    }

    public String  getLastNameErrorMsg(){
        return getElementText(lastNameErrorMsg);
    }

    public String getAffiliateErrorMsg(){
        return getElementText(affiliateErrorMsg);
    }

    public String getRoleErrorMsg(){
        return getElementText(roleErrorMsg);
    }

    public String getEmailErrorMsg(){
        return getElementText(emailErrorMsg);
    }

    public String getPasswordErrorMsg(){
        return getElementText(passwordErrorMsg);
    }

    public String getConfirmPasswordErrorMsg(){
        return getElementText(confirmPasswordErrorMsg);
    }

    public String getSecondUsernameText(){
        return getElementText(secondUsername);
    }

    public String getSecondEmailText(){
        return getElementText(secondUserEmail);
    }

    public String getSecondCreatedAtText(){
        return getElementText(secondUserCreatedAt);
    }

    public String getSecondModifiedAtText(){
        return getElementText(secondUserModifiedAt);
    }

    ///////////////////////////////////////send Text Methods///////////////////////////////////////
    public boolean sendTextToSearchField(String text) {
        return sendTextToElement(searchField, text);
    }

    public boolean sendTextToFirstNameFilter(String text) {
        return sendTextToElement(firstNameFilterTextField, text);
    }

    public boolean sendTextToLastNameFilter(String text) {
        return sendTextToElement(lastNameFilterTextField, text);
    }

    public boolean sendTextToEmailFilter(String text) {
        return sendTextToElement(emailFilterTextField, text);
    }

    public boolean sendTextToFirstNameCreateFieldText(String text) {
        return sendTextToElement(firstNameCreateTextField, text);
    }

    public boolean sendTextToFirstNameEditFieldText(String text) {
        return sendTextToElement(firstNameEditTextField, text);
    }

    public boolean sendTextToLastNameCreateFieldText(String text) {
        return sendTextToElement(lastNameCreateTextField, text);
    }

    public boolean sendTextToLastNameEditFieldText(String text) {
        return sendTextToElement(lastNameEditTextField, text);
    }

    public boolean sendTextToAffiliateDropDown(String text) {
        return sendTextToElement(affiliateDropDown, text, Keys.ENTER);
    }

    public boolean sendTextToRoleDropDown(String text) {
        return sendTextToElement(roleDropDown, text, Keys.ENTER);
    }

    public boolean sendTextToCreateEmailField(String text) {
        return sendTextToElement(createEmailTextField,text);
    }

    public boolean sendTextToEditEmailField(String text) {
        return sendTextToElement(editEmailTextField,text);
    }

    public boolean sendTextToPasswordField(String text) {
        return sendTextToElement(passwordTextField,text);
    }

    public boolean sendTextToConfirmPasswordField(String text) {
        return sendTextToElement(confirmPasswordTextField,text);
    }

    ///////////////////////////////////////clear Text Methods///////////////////////////////////////
    public boolean clearFirstNameCreateField(){
        return clearText(firstNameCreateTextField);
    }

    public boolean clearFirstNameEditField(){
        return clearText(firstNameEditTextField);
    }

    public boolean clearLastNameCreateField(){
        return clearText(lastNameCreateTextField);
    }

    public boolean clearLastNameEditField(){
        return clearText(lastNameEditTextField);
    }

    public boolean clearCreateEmailField(){
        return clearText(createEmailTextField);
    }


    public boolean clearEditEmailField(){
        return clearText(editEmailTextField);
    }
    public boolean clearPasswordField(){return clearText(passwordTextField);}

    public boolean clearSearchField(){return clearText(searchField);}

    ///////////////////////////////////////isDisplayed Methods///////////////////////////////////////
    public boolean isFifthColumnHeaderDisplayed(){
        return isDisplayed(fifthColumnHeader,10);
    }

    public boolean isSearchResultsDisplayed(){
        return isDisplayed(filteredUserName,10);
    }


}
