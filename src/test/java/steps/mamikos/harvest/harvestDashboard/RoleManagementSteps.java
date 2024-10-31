package steps.mamikos.harvest.harvestDashboard;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.harvest.harvestDashboard.RoleManagementPO;

public class RoleManagementSteps {
    Page page = ActiveContext.getActivePage();
    RoleManagementPO role = new RoleManagementPO(page);

    @When("admin add new role harvest {string}")
    public void admin_add_new_role_harvest(String roleName) {
        role.clickRoleManagementMenu();
        role.clickTambahRoleButton();
        role.fillNamaRole(roleName);
    }

    @When("admin search member {string}")
    public void admin_search_member(String memberName) {
        role.fillMemberName(memberName);
    }
    @Then("system should show member suggestion {string}")
    public void system_should_show_member_suggestion(String suggestion) {
        Assert.assertTrue(role.isSuggestionVisible(suggestion));
    }

    @When("admin change search member search by {string}")
    public void admin_change_search_member_search_by(String value) {
        role.searchBy(value);
    }
}
