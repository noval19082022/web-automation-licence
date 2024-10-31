package steps.mamikos.harvest.harvestDashboard;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.Given;
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
    @When("admin choose member {string}")
    public void admin_choose_member(String name) {
        role.clickSuggestionMember(name);
    }
    @Then("member {string} should add in list member")
    public void member_should_add_in_list_member(String member) {
        if (member.equalsIgnoreCase("Yudha")) {
            Assert.assertEquals(role.getListMemberName(), "Yudha");
            Assert.assertEquals(role.getListMemberEmail(), "yudha@mamiteam.com");
        }else if (member.equalsIgnoreCase("Yudha Ferroza")){
            Assert.assertEquals(role.getListMemberName(), "Yudha Ferroza Hadi Kus Chandra");
            Assert.assertEquals(role.getListMemberEmail(), "yudha@mamikos.com");
        } else {
            System.out.println("Invalid Member Name");
        }
    }
    @Given("admin delete list member")
    public void admin_delete_list_member() {
        role.deleteListMember();
    }
}
