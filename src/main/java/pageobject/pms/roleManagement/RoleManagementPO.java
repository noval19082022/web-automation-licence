package pageobject.pms.roleManagement;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class RoleManagementPO {
    private Page page;
    private PlaywrightHelpers playwright;

    Locator tambahRoleButton;
    Locator searchField;
    Locator cariButton;
    Locator roleName;
    Locator actionButton;
    Locator actionHapusButton;
    Locator actionEditButton;
    Locator actionAssignMemberButton;
    Locator confirmHapusButton;

    //Tambah Role
    Locator roleNameField;
    Locator permissionsCheckbox;
    Locator backButton;
    Locator resetPermissionButton;
    Locator checkedPermission;
    Locator simpanButton;
    Locator toast;
    Locator roleNameErrorMessage;
    //End Tambah Role

    //Assign Member
    Locator memberField;
    Locator tambahMemberButton;
    Locator errorMember;
    Locator hapusMemberButton;
    Locator cancelHapusMemberButton;
    //End Assign Member

    public RoleManagementPO(Page page){
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);

        tambahRoleButton = page.locator(".bg-c-button").filter(new Locator.FilterOptions().setHasText("Tambah Role"));
        roleNameField = page.getByPlaceholder("Masukkan nama role");
        backButton = page.locator(".back-button");
        searchField = page.getByPlaceholder("Cari berdasarkan nama role");
        cariButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cari"));
        resetPermissionButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Reset"));
        simpanButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Simpan"));
        checkedPermission = page.locator(".bg-c-checkbox--checked");
        toast = page.locator(".global-toast");
        roleName = page.locator(".ss-table td").nth(0);
        roleNameErrorMessage = page.locator(".bg-c-field__message");
        actionButton = page.locator(".menu-activator");
        actionHapusButton = page.locator(".bg-c-list-item__description").filter(new Locator.FilterOptions().setHasText("Hapus"));
        actionEditButton = page.locator(".bg-c-list-item__description").filter(new Locator.FilterOptions().setHasText("Edit"));
        confirmHapusButton = page.getByRole(AriaRole.DIALOG).getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Hapus"));
        actionAssignMemberButton = page.locator(".bg-c-list-item__description").filter(new Locator.FilterOptions().setHasText("Atur Member"));
        memberField = page.getByPlaceholder("Cari berdasarkan nama lengkap/email");
        tambahMemberButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tambah"));
        errorMember = page.locator(".bg-c-field__message");
        cancelHapusMemberButton = page.getByRole(AriaRole.DIALOG).getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Batal"));
    }

    /**
     * Click Tambah Role Button
     */
    public void clickTambahRole() {
        playwright.clickOn(tambahRoleButton);
    }

    /**
     * Fill Role Name in Tambah Role
     * @param roleName
     */
    public void fillRoleName(String roleName) {
        playwright.fill(roleNameField,roleName);
    }

    /**
     * Check permission
     * @param permission
     */
    public void checkPermission(String permission) {
        permissionsCheckbox = page.locator(".checkbox").filter(new Locator.FilterOptions().setHasText(permission));

        playwright.clickOn(permissionsCheckbox);
    }

    /**
     * Click Arrow Back Button
     */
    public void clickBackButton() {
        playwright.clickOn(backButton);
    }

    /**
     * Search Role by Role Name
     * @param roleName
     */
    public void searchRole(String roleName) {
        playwright.fill(searchField,roleName);
        playwright.clickOn(cariButton);
    }

    /**
     * Check if error message Role not found is appear
     * @return
     */
    public boolean isRoleNotFound() {
        return playwright.isTextDisplayed("Role tidak ditemukan di kata kunci yang Anda gunakan.");
    }

    /**
     * Click Reset permission button in Tambah Role
     */
    public void clickResetPermissionButton() {
        playwright.clickOn(resetPermissionButton);
    }

    /**
     * check if any permission checked
     * @return boolean
     */
    public boolean isAnyPermissionChecked() {
        return playwright.isLocatorVisibleAfterLoad(checkedPermission,10.0);
    }

    /**
     * click simpan button in tambah role
     */
    public void submitRole() {
        playwright.clickOn(simpanButton);
    }

    /**
     * Get message in toast
     * @return String
     */
    public String getToastMessage() {
        return playwright.getText(toast);
    }

    /**
     * Get role name in table
     * @return String
     */
    public String getRoleName() {
        return playwright.getText(roleName);
    }

    /**
     * Get role name error message in tambah role
     * @return String
     */
    public String getRoleNameErrorMessage() {
        playwright.pageScrollUntilElementIsVisible(roleNameErrorMessage);
        return playwright.getText(roleNameErrorMessage);
    }

    /**
     * Action Delete in Role management
     */
    public void deleteRole() {
        playwright.clickOn(actionButton);
        playwright.clickOn(actionHapusButton);
        playwright.clickOn(confirmHapusButton);
    }

    /**
     * Action Edit in Role Management
     */
    public void editRole() {
        playwright.clickOn(actionButton);
        playwright.clickOn(actionEditButton);
    }

    /**
     * Action assign member in Role Management
     */
    public void assignMember() {
        playwright.clickOn(actionButton);
        playwright.clickOn(actionAssignMemberButton);
    }

    /**
     * Add member to Role
     * @param member email mamiteam
     */
    public void addMember(String member) {
        playwright.fill(memberField,member);
        playwright.clickOn(tambahMemberButton);
    }

    /**
     * Get error message when email member invalid
     * @return String
     */
    public String getMemberErrorMessage() {
        return playwright.getText(errorMember);
    }

    /**
     * Check if member assign to Role
     * @param member email
     * @return boolean
     */
    public boolean isMemberRegistered(String member) {
        return playwright.isTextDisplayed(member);
    }

    /**
     * Delete member from Role
     * @param member email
     */
    public void deleteMember(String member) {
        hapusMemberButton = page.locator("//tr/td[contains(text(),'"+member+"')]/following-sibling::*");

        playwright.clickOn(hapusMemberButton);
    }

    /**
     * Cancel confirmation pop up delete member
     */
    public void cancelDeleteMember() {
        playwright.clickOn(cancelHapusMemberButton);
    }

    /**
     * Confirm confirmation pop up delete member
     */
    public void confirmDeleteMember() {
        playwright.clickOn(confirmHapusButton);
    }
}

