package steps.pms.RoleManagement;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.pms.RoleManagement.RoleManagementPO;

import java.util.List;

public class RoleManagementSteps {
    Page page = ActiveContext.getActivePage();
    RoleManagementPO role = new RoleManagementPO(page);

    private List<String> permissions;

    @When("admin go to tambah role")
    public void admin_go_to_tambah_role(){
        role.clickTambahRole();
    }

    @When("admin set new role {string}")
    public void admin_set_new_role(String roleName, List<String> tables) {
        permissions = tables;

        role.fillRoleName(roleName);
        for (int i=0;i< permissions.size();i++){
            role.checkPermission(permissions.get(i));
        }
    }
    @When("admin back to role management home")
    public void admin_back_to_role_management_home() {
        role.clickBackButton();
    }
    @Then("role {string} should not exist")
    public void role_should_not_exist(String roleName) {
        role.searchRole(roleName);
        Assert.assertTrue(role.isRoleNotFound());
    }
    @When("admin reset permission")
    public void admin_reset_permission() {
        role.clickResetPermissionButton();
    }
    @Then("all permission are unchecked")
    public void all_permission_are_unchecked() {
        Assert.assertFalse(role.isAnyPermissionChecked());
    }
    @When("admin submit add new role")
    public void admin_submit_add_new_role() {
        role.submitRole();
    }
    @Then("system should show toast message {string}")
    public void system_should_show_toast_message(String toastMessage) {
        Assert.assertEquals(role.getToastMessage(),toastMessage);
    }
    @Then("role {string} should exist")
    public void role_should_exist(String roleName) {
        role.searchRole(roleName);
        Assert.assertEquals(role.getRoleName(),roleName);
    }
    @When("admin search role {string}")
    public void admin_search_role(String roleName){
        role.searchRole(roleName);
    }
    @Then("system show nama role error message {string}")
    public void system_show_name_role_error_message(String error){
        Assert.assertEquals(role.getRoleNameErrorMessage(),error);
    }
    @When("admin delete role {string}")
    public void admin_delete_role(String roleName){
        role.searchRole(roleName);
        role.deleteRole();
    }
    @When("admin edit role {string} to {string}")
    public void admin_edit_role_to(String before, String after) {
        role.searchRole(before);
        role.editRole();
        role.fillRoleName(after);
    }
    @When("admin add permissions")
    public void admin_add_permissions(List<String> tables) {
        permissions = tables;

        for (int i=0;i< permissions.size();i++){
            role.checkPermission(permissions.get(i));
        }
    }
    @When("admin rename role name to {string}")
    public void admin_rename_role_name_to(String name){
        role.fillRoleName(name);
    }
}
