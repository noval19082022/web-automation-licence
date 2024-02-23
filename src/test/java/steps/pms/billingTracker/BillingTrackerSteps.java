package steps.pms.billingTracker;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.billingTracker.BillingTrackePO;
import utilities.PlaywrightHelpers;

public class BillingTrackerSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    BillingTrackePO billingTracker = new BillingTrackePO(page);

    @And("admin search billing tracker by {string} and {string}")
    public void admin_search_billing_tracker_by(String type, String text){
        billingTracker.searchType(type, text);
    }

    @Then("admin can see validation {string}")
    public void admin_can_see_validation(String text){
        Assert.assertTrue(billingTracker.getValidationBillingTrackertext(text), "element is displayed");
    }

    @Then("admin can see data search")
    public void admin_can_see_data_search(){
        Assert.assertTrue(billingTracker.getResutlDataTable(), "element is not displayed");
    }

    @And("admin click on reset button")
    public void admin_click_on_reset_button(){
        billingTracker.clickResetButton();
    }

    @And("admin filter for {string}")
    public void admin_filter_for(String text){
        billingTracker.clickFilterButton(text);
    }

    @And("admin click on {string}")
    public void admin_click_on(String text){
        billingTracker.clickBulkFollowUp(text);
    }

    @Then("admin can see bulk {string}")
    public void admin_can_see_bulk(String text){
        billingTracker.getBulkText(text);
    }
}
