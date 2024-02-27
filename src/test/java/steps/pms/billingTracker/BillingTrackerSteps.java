package steps.pms.billingTracker;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.billingTracker.BillingTrackePO;
import utilities.PlaywrightHelpers;

import java.util.List;
import java.util.Map;

public class BillingTrackerSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    BillingTrackePO billingTracker = new BillingTrackePO(page);

    private Map<String, String> notedData;

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

    @Then("admin can see tambah catatan button")
    public void admin_can_see_tambah_catatan_button(){
        Assert.assertTrue(billingTracker.getCreateNotesButtonVisible(), "tambah catatan not displayed");
    }

    @And("admin fill notes tracker with:")
    public void admin_fill_notes_tracker_with(DataTable table){
        notedData = table.asMap(String.class, String.class);
        var type = notedData.get("type");
        var notes = notedData.get("catatan");
        billingTracker.clickCreateNotesAction();
        billingTracker.setAndInputNotesType(type);
        if (notes != null) {
            billingTracker.fillNotesCatatan(notes);
        }
        billingTracker.clickSaveButton();
    }

    @Then("admin can see notes with {string}")
    public void admin_can_see_notes_with(String text){
        Assert.assertTrue(billingTracker.getNotedOnMainPage(text),  "noted not visible");
    }
}
