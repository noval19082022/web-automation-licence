package steps.pms.billingTracker;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.billingTracker.BillingTrackePO;
import utilities.PlaywrightHelpers;

import java.util.List;
import java.util.Map;

public class BillingTrackerSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    BillingTrackePO billingTracker = new BillingTrackePO(page);

    private List<Map<String, String>> notedData;
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

    @Then("admin can see {string} button")
    public void admin_can_see_button(String text) {
        if (text.equalsIgnoreCase("Tambah Catatan")) {
            Assert.assertTrue(billingTracker.getCreateNotesButtonVisible(), "tambah catatan not displayed");
        }
        else if (text.equalsIgnoreCase("Sembunyikan")){
            Assert.assertTrue(billingTracker.getSembunyikantextButton(), "not appears sembunyikan button");
        }
    }

    @And("admin fill notes tracker with:")
    public void admin_fill_notes_tracker_with(DataTable tables) {
        notedData = tables.asMaps(String.class, String.class);
        String type = notedData.get(0).get("type");
        String notes = notedData.get(0).get("notes");
        billingTracker.clickCreateNotesAction();
        billingTracker.setAndInputNotesType(type);
        if (notes != null) {
            billingTracker.fillNotesCatatan(notes);
        }
        billingTracker.clickSaveButton();
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

    @And("admin input announcement with {string}")
    public void admin_input_announcement_with(String text){
        billingTracker.inputAnnouncement(text);
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


    @And("admin filter contract status with {string}")
    public void admin_filter_contract_status_with(String text){
        billingTracker.chooseContractStatus(text);
    }

    @Then("admin can see contract status with {string}")
    public void admin_can_see_contract_status_with(String text){
        Assert.assertTrue(billingTracker.getContractStatusOnListText(text), "status doesnt match");
    }

    @And("admin can see phone number with {string}")
    public void admin_can_see_phone_number_with(String text){
        Assert.assertTrue(billingTracker.getTenantPhoneNumbertext(text), "admin can't see phone number");
    }

    @And("admin click on pagination")
    public void admin_click_on_pagination(){
        billingTracker.clickOnPagination();
    }

    @Then("admin can see notes with:")
    public void admin_can_see_notes_with(DataTable tables) {
        for (Map<String, String> row : tables.asMaps(String.class, String.class)) {
            String type = row.get("type");
            String notes = row.get("notes");
            Assert.assertTrue(billingTracker.getResutlDataTableType(type), "Element is not displayed for ");
            Assert.assertTrue(billingTracker.getResultDataTableNote(notes), "Element is not displayed for");
        }
    }

    @When("admin click on property name")
    public void admin_click_on_property_name(){
        billingTracker.clickOnPropertyNametext();
    }

    @And("admin can see contract status filtering with:")
    public void admin_can_see_contract_status_filtering_with(DataTable tables) {
        for (Map<String, String> row : tables.asMaps(String.class, String.class)) {
            String status = row.get("status");
            Assert.assertTrue(billingTracker.checkFilteringContractStatusText(status), "Element not appears");
        }
    }

    @And("admin filter paid status with {string}")
    public void admin_filter_paid_status_with(String text){
        billingTracker.clickFilterPaidStatus(text);
    }

    @When("admin can see bse name with:")
    public void admin_can_see_bse_name_with(DataTable tables) {
        for (Map<String, String> row : tables.asMaps(String.class, String.class)) {
            String status = row.get("bse");
            Assert.assertTrue(billingTracker.getBseNametext(status), "elemet not appears");
        }
    }
}

