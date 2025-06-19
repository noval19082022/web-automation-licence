package steps.mamipay.terminationoption;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.admin.mamipay.terminationOption.TerminationOptionPO;

import java.util.List;

public class TerminationOptionSteps {
    Page page = ActiveContext.getActivePage();
    TerminationOptionPO terminationOption = new TerminationOptionPO(page);

    @Given("admin open menu Termination Option")
    public void admin_open_menu_termination_option() {
        terminationOption.clickTerminationOptionMenu();
    }

    @When("admin add new reason {string} show on {string}")
    public void admin_add_new_reason_show_on(String reason, String showOn) {
        terminationOption.addNewReason(reason, showOn);
    }

    @Then("admin can see toast message {string}")
    public void admin_can_see_toast_message(String message) {
        Assert.assertEquals(terminationOption.getToastMessage(), message);
    }

    @Then("admin can see reason/subreason {string} in {string} table")
    public void admin_can_see_reason_in_table(String reason, String column) {
        if (column.equalsIgnoreCase("Owner")){
            Assert.assertTrue(terminationOption.isOwnerReasonVisible(reason));
        } else if (column.equalsIgnoreCase("Tenant")){
            Assert.assertTrue(terminationOption.isTenantReasonVisible(reason));
        }
    }

    @Then("admin can't see + button in {string} row")
    public void admin_can_t_see_plus_button_in_row(String reason) {
        Assert.assertFalse(terminationOption.isButtonPlusVisible(reason));
    }

    @Then("admin can see + button in {string} row")
    public void admin_can_see_plus_button_in_row(String reason) {
        Assert.assertTrue(terminationOption.isButtonPlusVisible(reason));
    }

    @When("admin delete reason {string}")
    public void admin_delete_reason(String reason) {
        terminationOption.deleteReason(reason);
    }

    @Then("admin can't see reason/subreason {string} in {string} table")
    public void admin_can_t_see_reason_in_table(String reason, String column) {
        if (column.equalsIgnoreCase("Owner")){
            Assert.assertFalse(terminationOption.isOwnerReasonVisible(reason));
        } else if (column.equalsIgnoreCase("Tenant")){
            Assert.assertFalse(terminationOption.isTenantReasonVisible(reason));
        }
    }

    @When("admin add new subreason {string} to {string}")
    public void admin_add_new_subreason_to(String subreason, String reason) {
        terminationOption.addNewSubreason(subreason, reason);
    }

    @When("admin edit subreason {string} to {string}")
    public void admin_edit_subreason_to(String oldSubreason, String newSubreason) {
        terminationOption.editSubreason(oldSubreason, newSubreason);
    }

    @When("admin move {string} subreason {string}")
    public void admin_move_subreason(String direction, String subreason) {
        terminationOption.moveSubreason(direction, subreason);
    }

    @Then("subreason order should be")
    public void subreason_order_should_be(List<String> subreasons) {
        for (int i=0;i<subreasons.size();i++){
            Assert.assertEquals(terminationOption.getSubreason(i), subreasons.get(i));
        }
    }

    @Then("admin delete subreason {string}")
    public void admin_delete_subreason(String subreason) {
        terminationOption.deleteSubreason(subreason);
    }
}
