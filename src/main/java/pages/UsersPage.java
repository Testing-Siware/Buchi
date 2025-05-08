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
    public WebElement addUserBtn;

    //search field to search by user
    @FindBy(id="users-list-table-search-input")
    public WebElement searchField;

    //confirm delete button
    @FindBy(id = "user-list-alert-dialog-button-confirm")
    public WebElement confirmDeleteBtn;

    //confirm edit button
    @FindBy(id = "user-edit-form-alert-dialog-button-confirm")
    public WebElement confirmEditBtn;

    //cancel edits button
    @FindBy(id="user-edit-form-container-button-cancel")
    public WebElement cancelEditBtn;

    //search button to fetch searched results
    @FindBy(id = "users-list-table-search-submit")
    public WebElement searchBtn;

    //filter button to show filter menu
    @FindBy(id = "users-list-table-filter-button")
    public WebElement filterBtn;

    //text field to filter by first name
    @FindBy(id = "users-list-table-filter-input-firstName")
    public WebElement firstNameFilterTextField;

    //text field to filter by second name
    @FindBy(id = "users-list-table-filter-input-lastName")
    public WebElement lastNameFilterTextField;

    //text field to filter by email
    @FindBy(id = "users-list-table-filter-input-email")
    public WebElement emailFilterTextField;

    //clear any set filters button
    @FindBy(id = "users-list-table-filter-button-clear")
    public WebElement clearFiltersBtn;

    //apply any set filters button
    @FindBy(id = "users-list-table-filter-button-submit")
    public WebElement applyFiltersBtn;

    //cancel any edits in filters button
    @FindBy(id = "users-list-table-filter-button-cancel")
    public WebElement cancelFiltersBtn;

    //views button to view extra columns in grid view
    @FindBy(id = "users-list-table-viewing-options")
    public WebElement viewBtn;

    @FindBy(id="users-list-table-viewing-options-dropdown-menu-item-clear-sorting")
    public WebElement clearSortingBtn;

    //name of first user in search results
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[2]")
    public WebElement filteredUserName;

    //email of first user in search results
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[5]")
    public WebElement filteredEmail;

    //created at of first user in search result
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[6]")
    public WebElement filteredCreatedAt;

    //modified at of first user in search result
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[7]")
    public WebElement filteredModifiedAt;

    //actions button to edit or delete user
    @FindBy(id="users-list-table-actions-cell-0")
    public WebElement firstRowActionsBtn;

    //actions button to edit or delete user when logged in with admin
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[3]/table/tbody/tr[1]/td[7]/button")
    public WebElement actionsBtnAdmin;

    //option to edit user from actions button dropdown
    @FindBy(id = "dropdown-menu-item-user-list-table-option-edit")
    public WebElement editUserOption;

    //option to delete user from actions button dropdown
    @FindBy(id = "dropdown-menu-item-user-list-table-option-delete")
    public WebElement deleteUserOption;

    //fifth column header (can be created or modified at)
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[1]/div[2]/div[1]/div[2]/div/div/div[3]/div[3]/div/div/div")
    public WebElement fifthColumnHeader;

    @FindBy(id = "users-list-table-createdAt-column")
    public WebElement createdAtColumnHeader;

    @FindBy(id = "users-list-table-lastUpdatedAt-column")
    public WebElement lastUpdatedAtColumnHeader;

    //toggle the created at column option to hide or view
    @FindBy(id = "createdAt")
    public WebElement toggleCreatedAtColumnOption;

    //toggle the modified at column option to hide or view
    @FindBy(id = "lastUpdatedAt")
    public WebElement toggleModifiedAtColumnOption;

    //clear any sorting
    @FindBy(xpath = "/html/body/div[2]/div/div[7]")
    public WebElement clearSortingOption;

    //second user in table name
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[2]/div[2]")
    public WebElement secondUsername;

    //email of second user in table name
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[2]/div[5]")
    public WebElement secondUserEmail;

    //second user created at
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[2]/div[6]")
    public WebElement secondUserCreatedAt;

    //second user modified at
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[2]/div[7]")
    public WebElement secondUserModifiedAt;

    //sort ascending button for any column
    @FindBy(id = "users-list-table-name-column-options-menu-item-asc")
    public WebElement sortNameAscOption;

    //sort descending button for any column
    @FindBy(id = "users-list-table-name-column-options-menu-item-desc")
    public WebElement sortNameDescOption;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/div[8]/div[2]")
    public WebElement tableHorizontalScrollBar;
    ///////////////////////////////////////Add User Page///////////////////////////////////////

    //first name text field
    @FindBy(id = "user-create-form-input-firstName")
    public WebElement firstNameCreateTextField;

    ///first name text field in edit
    @FindBy(id = "user-edit-form-input-firstName")
    public WebElement firstNameEditTextField;

    //last name text field
    @FindBy(id = "user-create-form-input-lastName")
    public WebElement lastNameCreateTextField;

    @FindBy(id="user-edit-form-input-lastName")
    public WebElement lastNameEditTextField;

    //affiliate dropdown list
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div[1]/div[2]/div[3]/div[1]/div/div[1]/div[2]/input")
    public WebElement affiliateDropDown;

    //role dropdown list
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div[1]/div[2]/div[4]/div[1]/div/div[1]/div[2]/input")
    public WebElement roleDropDown;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div[3]/div[2]/div[1]/div[1]/div/div[1]/div[2]/input")
    public WebElement superAdminAffiliateDropDown;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div[3]/div[2]/div[2]/div[1]/div/div[1]/div[2]/input")
    public WebElement superAdminRoleDropDown;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div[3]/div[2]/div[3]/button")
    public WebElement superAdminAddAffiliateBtn;
    //email text field
    @FindBy(id= "user-create-form-input-email")
    public WebElement createEmailTextField;

    @FindBy(id= "user-edit-form-input-email")
    public WebElement editEmailTextField;

    //password field
    @FindBy(id = "user-create-form-input-password")
    public WebElement passwordTextField;

    //password confirm field
    @FindBy(id = "user-create-form-input-passwordConfirmation")
    public WebElement confirmPasswordTextField;

    @FindBy(xpath = "/html/body/div[3]/div[2]/button[1]")
    public WebElement cancelDeleteBtn;

    //error message if first name is invalid
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div[1]/div[2]/div[1]/div[2]/span")
    public WebElement firstNameErrorMsg;

    //error message if last name is invalid
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div[1]/div[2]/div[2]/div[2]/span")
    public WebElement lastNameErrorMsg;

    //error message if affiliate name is invalid
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div[3]/div[2]/div[1]/div[2]/span")
    public WebElement affiliateErrorMsg;

    //error message if role is invalid
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div[3]/div[2]/div[2]/div[2]/span")
    public WebElement roleErrorMsg;

    //error message if email is invalid
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div[2]/div[2]/div[1]/div[2]/span")
    public WebElement emailErrorMsg;

    //error message if first name is invalid
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div[2]/div[2]/div[3]/div[2]/span")
    public WebElement passwordErrorMsg;

    //error message if passwords don't match
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/form/div/div[3]/div[2]/div[2]/div[4]/div[2]/span")
    public WebElement confirmPasswordErrorMsg;

    //button to reset and clear all data entered in all fields
    @FindBy(id = "user-create-form-container-button-clear")
    public WebElement resetCreateBtn;

    @FindBy(id="user-edit-form-container-button-clear")
    public WebElement resetEditBtn;

    //button to cancel and return to users homepage
    @FindBy(id = "user-create-form-container-button-cancel")
    public WebElement cancelBtn;

    //button to save and create the user
    @FindBy(id = "user-create-form-container-button-submit")
    public WebElement saveBtn;

    //button to save and edit user
    @FindBy(id = "user-edit-form-container-button-submit")
    public WebElement saveEditsBtn;

    //create password on behalf of user checkbox
    @FindBy(id="user-create-form-checkbox-isPasswordRequired" )
    public WebElement createPasswordOnBehalfCheckBox;

    //image appears when search or filter don't return results
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[3]/div[2]/div/div[3]/div/div/img")
    public WebElement noResultsImg;

    //clear search field icon
    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div[2]/div/div[2]/form/div/div/div/div/div/svg")
    public WebElement clearSearchIcon;

    //sort by email button
    @FindBy(id = "users-list-table-email-column-options-trigger")
    public WebElement sortByEmail;

    @FindBy(id="users-list-table-email-column-options-menu-item-asc")
    public WebElement sortEmailAscOption;

    @FindBy(id="users-list-table-email-column-options-menu-item-desc")
    public WebElement sortEmailDescOption;

    //sort by created at button
    @FindBy(id = "users-list-table-createdAt-column-options-trigger")
    public WebElement sortByCreatedAt;

    @FindBy(id="users-list-table-createdAt-column-options-menu-item-asc")
    public WebElement sortCreatedAtAscOption;

    @FindBy(id="users-list-table-createdAt-column-options-menu-item-desc")
    public WebElement sortCreatedAtDescOption;

    //sort by modified at button
    @FindBy(id = "users-list-table-lastUpdatedAt-column-options-trigger")
    public WebElement sortByUpdatedAt;

    @FindBy(id="users-list-table-lastUpdatedAt-column-options-menu-item-asc")
    public WebElement sortUpdatedAtAscOption;

    @FindBy(id="users-list-table-lastUpdatedAt-column-options-menu-item-desc")
    public WebElement sortUpdatedAtDescOption;

    //sort by name button
    @FindBy(id = "users-list-table-name-column-options-trigger")
    public WebElement sortByName;

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
        return clickElement(firstRowActionsBtn);
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

    public boolean clickSortByName(){
        return clickElement(sortByName);
    }

    public boolean clickPasswordOnBehalfCheckbox(){
        return clickElement(createPasswordOnBehalfCheckBox);
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
