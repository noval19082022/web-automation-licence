package steps.pms.billingTracker;

import com.microsoft.playwright.Locator;
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
    private List<Map<String, String>> pmsCredential;

    @And("admin search billing tracker by {string} and {string}")
    public void admin_search_billing_tracker_by(String type, String text) {
        billingTracker.searchType(type, text);
    }

    @Then("admin can see validation {string}")
    public void admin_can_see_validation(String text) {
        Assert.assertTrue(billingTracker.getValidationBillingTrackertext(text), "element is displayed");
    }

    @Then("admin can see data search")
    public void admin_can_see_data_search() {
        Assert.assertTrue(billingTracker.getResutlDataTable(), "element is not displayed");
    }

    @And("admin click on reset button")
    public void admin_click_on_reset_button() {
        billingTracker.clickResetButton();
    }

    @And("admin filter for {string}")
    public void admin_filter_for(String text) {
        billingTracker.clickFilterButton(text);
    }

    @And("admin click on {string}")
    public void admin_click_on(String text) {
        billingTracker.clickBulkFollowUp(text);
    }

    @Then("admin can see bulk {string}")
    public void admin_can_see_bulk(String text) {
        billingTracker.getBulkText(text);
    }

    @Then("admin can see tambah catatan button")
    public void admin_can_see_tambah_catatan_button() {
        Assert.assertTrue(billingTracker.getCreateNotesButtonVisible(), "tambah catatan not displayed");
    }

    @And("admin fill notes tracker with:")
    public void admin_fill_notes_tracker_with(DataTable table) {
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
    public void admin_can_see_notes_with(String text) {
        Assert.assertTrue(billingTracker.getNotedOnMainPage(text), "noted not visible");
    }

    @Then("Admin can see all invoice recurring from mamipay :")
    public void admin_can_see_all_invoice_reccuring(DataTable tables) {
        for (Map<String, String> row : tables.asMaps(String.class, String.class)) {
            String jatuhTempo = row.get("Jatuh Tempo");
            String namaBiaya = row.get("Nama Biaya");
            Assert.assertTrue(billingTracker.getResutlDataTableReccuring(jatuhTempo, namaBiaya), "Element is not displayed for " + jatuhTempo + " and " + namaBiaya);
        }
    }

    @And("admin click on Lihat lebih banyak catatan note dropdown")
    public void admin_click_on_lihat_lebih_banyak_catatan_note_dropdown() {
        billingTracker.clickOnLihatLebihBanyakDropdown();
    }

    @And("admin edit note {string}")
    public void admin_edit_note(String text) {
        billingTracker.adminEditNote(text);
    }

    @And ("admin choose month {string}")
    public void admin_choose_month(String month) {
        billingTracker.adminChooseMonth(month);
    }

    @And("admin click on expand billing announcement")
    public void admin_click_on_expand_billing_announcement(){
        billingTracker.clickAnnouncementTitle();
    }

    @And("admin choose bse name with {string}")
    public void admin_choose_bse_name_with(String bseName){
        billingTracker.clickBseName(bseName);
    }

    @And("admin click on {string} button")
    public void admin_click_on_button(String text){
        if (text.equalsIgnoreCase("Tambah")){
            billingTracker.clickTambahAnnouncement();
        }
        else if(text.equalsIgnoreCase("Ubah")){
            billingTracker.clickEditAnnouncement();
        }
    }

    @And("admin input announcement")
    public void admin_input_announcement(){
        billingTracker.inputAnnouncemenet();
        billingTracker.clickSaveButton();
        }

    @And("admin can see announcement toast {string}")
    public void admin_can_see_announcement_toast(String text){
        billingTracker.getSuccessToast(text);
    }

    @And("admin can see blank announcement with {string}")
    public void admin_can_see_blank_announcement_with(String text){
        billingTracker.getBlankAnnouncement(text);
    }

}

