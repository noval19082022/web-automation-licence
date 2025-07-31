package steps.mamikos.bangkrupux;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.admin.mamipay.bangkrupux.WhitelistFeaturePO;


public class WhitelistFeatureSteps {
    Page page = ActiveContext.getActivePage();
    WhitelistFeaturePO whitelistFeaturePO = new WhitelistFeaturePO(page);

    @Then("admin can see message {string}")
    public void admin_can_see_message(String message) {
        Assert.assertEquals(whitelistFeaturePO.getTitleMessageAllertWhitelist(message), message, "message doesnt equals");
    }

    @When("admin select feature with {string}")
    public void admin_select_feature_with(String feature) {
        // Check if feature is already selected, if yes then skip selection
        whitelistFeaturePO.chooseFeatureWhitelistIfNotSelected(feature);
    }

    @When("admin input owner id with {string}")
    public void admin_input_owner_id_with(String ownerId) {
        whitelistFeaturePO.inputOwnerId(ownerId);
    }

    @When("admin wants to add whitelist feature")
    public void admin_wants_to_add_whitelist_feature() {
        whitelistFeaturePO.addButtonWhitelist();
    }

    @And("admin search whitelist owner by user_id {string}")
    public void adminSearchWhitelistOwnerByUser_id(String user_id) {
        whitelistFeaturePO.searchByUserId(user_id);
    }

    @Then("admin click on delete btn on whitelist menu for order {string}")
    public void adminClickOnDeleteBtnOnWhitelistMenu(String order) {
        whitelistFeaturePO.clickOnDeleteBtn(order);
    }

    @And("admin click edit button for owner")
    public void adminClickEditButtonForOwner() {
        whitelistFeaturePO.clickOnEditButton();
    }

    @And("admin save whitelist changes")
    public void adminSaveWhitelistChanges() {
        whitelistFeaturePO.clickOnSaveButton();
    }

    @And("admin logout from bangkrupux")
    public void adminLogoutFromBangkrupux() {
        whitelistFeaturePO.clickOnLogoutButton();
    }
}