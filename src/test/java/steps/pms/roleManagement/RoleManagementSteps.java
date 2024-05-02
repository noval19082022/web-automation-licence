package steps.pms.roleManagement;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.pms.HomepagePO;
import pageobject.pms.disbursement.DisbursementPO;
import pageobject.pms.roleManagement.RoleManagementPO;
import pageobject.pms.sidebarMenuPO;
import utilities.JavaHelpers;

import java.util.List;

public class RoleManagementSteps {
    Page page = ActiveContext.getActivePage();
    RoleManagementPO role = new RoleManagementPO(page);
    HomepagePO homepage = new HomepagePO(page);
    sidebarMenuPO sidebarmenu = new sidebarMenuPO(page);
    DisbursementPO disbursement = new DisbursementPO(page);

    private List<String> permissions;

    private String roleManagementPage ="src/test/resources/testdata/pms/roleManagement.properties";
    private String emptyStateCopy = JavaHelpers.getPropertyValue(roleManagementPage, "emptyStateCopy");

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
    @When("admin assign member {string} to role {string}")
    public void admin_assign_member_to_role(String member, String roleName){
        role.searchRole(roleName);
        role.assignMember();
        role.addMember(member);
    }
    @Then("system show tambah member error message {string}")
    public void system_show_tambah_member_error_message(String error){
        Assert.assertEquals(role.getMemberErrorMessage(),error);
    }

    @Then("member {string} should/still registered")
    public void member_should_registered(String member){
        Assert.assertTrue(role.isMemberRegistered(member));
    }
    @Then("member {string} not registered")
    public void member_not_registered(String member){
        Assert.assertFalse(role.isMemberRegistered(member));
    }
    @When("admin delete member {string}")
    public void admin_delete_member(String member){
        role.deleteMember(member);
    }
    @When("admin cancel confirmation to delete")
    public void admin_cancel_confirmation_to_delete(){
        role.cancelDeleteMember();
    }
    @When("admin confirm to delete member")
    public void admin_confirm_to_delete_member(){
        role.confirmDeleteMember();
    }

    @Then("admin automation have permission for button")
    public void admin_automation_have_permission_for_button(List<String> Button) {
        for (String button: Button) {
            Assert.assertTrue(homepage.isButtonExist(button));
        }
    }

    @Then("admin automation doesn't have permission for button")
    public void admin_automation_doesn_t_have_permission_for_button(List<String> Button) {
        for (String button: Button) {
            Assert.assertFalse(homepage.isButtonExist(button));
        }
    }

    @Then("admin automation has permission on Disbursement for button")
    public void admin_automation_has_permission_on_Disbursement_for_button(List<String> button){
        for (String listButton: button){
            Assert.assertTrue(disbursement.isButtonExistInDisbursement(listButton));
        }
    }

    @Then("admin automation has permission on Disbursement at Detail Transfer Pendapatan page")
    public void admin_automation_has_permission_on_Disbursement_at_Detail_Transfer_Pendapatan_page(List<String> button){
        for (String listButton: button){
            Assert.assertTrue(disbursement.isButtonExistInDetailTransferPendapatan(listButton));
        }
    }

    @When("admin Filter Status Data Pendapatan {string}")
    public void admin_Filter_Status_Data_Pendapatan(String filter){
        disbursement.clicksFilter();
        disbursement.tickStatusDataPendapatan(filter);
    }

    @When("admin go back to role management page")
    public void admin_go_back_to_role_management_page(){
        role.clickBackButton();
    }

    @When("admin edit and add permission")
    public void admin_edit_and_add_permission(List<String> tables){
        role.editRole();
        permissions = tables;

        for (int i=0; i<permissions.size(); i++){
            role.checkPermission(permissions.get(i));
        }
    }

    @When("admin go to Disbursement menu and refresh page")
    public void admin_go_to_Disbursement_menu_and_refresh_page(){
        sidebarmenu.clickDisbursementMenu();
        disbursement.refreshPage();
    }

    @When("admin edit and untick permission")
    public void admin_edit_and_untick_permission(List<String> tables){
        role.editRole();
        permissions = tables;

        for (int i=0; i<permissions.size(); i++){
            role.untickPermission(permissions.get(i));
        }
    }

    @Then("the buttons in Detail Transfer Pendapatan page are not available")
    public void the_buttons_in_Detail_Transfer_Pendapatan_page_are_not_available(List<String> button){
        for (String listButton: button){
            Assert.assertFalse(disbursement.isButtonExistInDetailTransferPendapatan(listButton));
        }
    }

    @Then("the buttons in Disbursement menu are not available")
    public void the_buttons_in_Disbursement_menu_are_not_available(List<String> button){
        for (String listButton: button){
            Assert.assertFalse(disbursement.isButtonExistInDisbursement(listButton));
        }
    }

    @Then("empty state is displayed")
    public void empty_state_is_displayed(){
        Assert.assertEquals(role.getEmptyState(), emptyStateCopy, "Empty State Copy does not match!");
    }
    @Then("role list should contains column")
    public void role_list_should_contains_column(List<String> columnName) {
        for (int i=0;i<columnName.size();i++) {
            Assert.assertEquals(role.getColumnName(i),columnName.get(i));
        }
    }
    @Then("list contains max {int} role per page")
    public void list_contains_max_role_per_page(Integer total) {
        Assert.assertEquals(role.countTotalRow(),total);
    }
    @Then("contains button {string}")
    public void contains_button(String buttonName) {
        Assert.assertTrue(role.isButtonExist(buttonName));
    }
    @Then("action button contains action to")
    public void action_button_contains_action_to(List<String> button) {
        role.clickActionButton();
        for (int i=0;i< button.size();i++){
            Assert.assertEquals(role.getActionButtonName(button.get(i)),button.get(i));
        }
    }
}

