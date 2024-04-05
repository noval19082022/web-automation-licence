package steps.mamikos.bangkrupux;
import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.admin.mamipay.bangkrupux.WhitelistFeaturePO;
import utilities.PlaywrightHelpers;




public class WhitelistFeatureSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    WhitelistFeaturePO whitelistFeaturePO = new WhitelistFeaturePO(page);

    @Then("admin can see message {string}")
    public void admin_can_see_message(String message) {
     Assert.assertEquals(whitelistFeaturePO.getTitleMessageAllertWhitelist(message),message,"message doesnt equals");
    }

    @When("admin select feature with {string}")
    public void admin_select_feature_with(String feature) {
        whitelistFeaturePO.chooseFeatureWhitelist(feature);
    }

    @When("admin input owner id with {string}")
    public void admin_input_owner_id_with(String ownerId) {
        whitelistFeaturePO.inputOwnerId(ownerId);
    }

    @When("admin wants to add whitelist feature")
    public void admin_wants_to_add_whitelist_feature() {
        whitelistFeaturePO.addButtonWhitelist();
    }

}