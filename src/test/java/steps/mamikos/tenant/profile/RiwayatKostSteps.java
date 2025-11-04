package steps.mamikos.tenant.profile;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.HomePO;
import pageobject.tenant.profile.RiwayatKostPO;
import utilities.PlaywrightHelpers;

import java.util.List;
import java.util.Map;

public class RiwayatKostSteps {
    List<Map<String, String>> reviewText;
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    HomePO home = new HomePO(page);
    RiwayatKostPO riwayatKost = new RiwayatKostPO(page);
    private List<Map<String, String>> bankAccount;


    @And("user click review kost")
    public void user_click_review_kost() {
        riwayatKost.clickReviewKos();
    }
    @Then("user will see review page and user click close on review page")
    public void user_will_see_review_page_and_user_click_close_on_review_page() {
        riwayatKost.isReviewKostPagePresent();
        riwayatKost.clickCloseRiviewKost();
    }
    @When("user click Lihat Detail")
    public void user_click_lihat_detail() {
        riwayatKost.clickLihatDetail();
    }
    @When("user click Lihat Fasilitas and close pop up fasilitas")
    public void user_click_lihat_fasilitas_and_close_pop_up_fasilitas() {
        riwayatKost.clickLihatFasilitas();
        riwayatKost.clickCloseFacility();
    }

    @When("user click Lihat Riwayat Transaksi and user click Kembali ke Booking button")
    public void user_click_lihat_riwayat_transaksi_and_user_click_kembali_ke_booking_button() {
        riwayatKost.clickLihatRiwayatTransaksi();
        riwayatKost.clickKembaliKeBooking();
    }
    @When("user click Booking Ulang")
    public void user_click_booking_ulang() {
        riwayatKost.clickBookingUlang();
    }
    @Then("user will open new tab and go to Booking form")
    public void user_will_open_new_tab_and_go_to_booking_form() {
        riwayatKost.isTitleBookingFormPresent();
    }

    @Then("user will see empty state")
    public void userWillSeeEmptyState() {
        Assert.assertEquals(riwayatKost.getEmptyStateTitle(), "Belum Ada Kos", "Empty state title is not correct");
        Assert.assertTrue(riwayatKost.isEmptyStateSubtitlePresent(), "Empty State Subtitle not present");
    }

    @Then("there will be a review menu with the title {string}")
    public void there_will_be_a_review_menu_with_the_title(String title){
        Assert.assertEquals(riwayatKost.getTitleRiwayatKosReviewText().replaceAll("\n",""),title, "title is not correct");
    }

    @Then("there will be a kost saya with the title {string}")
    public void there_will_be_a_kost_saya_with_the_title(String title){
        Assert.assertEquals(riwayatKost.getTitleKosSayaText().replaceAll("\n",""),title, "title is not correct");
    }

    @Then("user will see review form")
    public void user_will_see_review_form(){
        Assert.assertEquals(riwayatKost.getTitleReviewText(),"Yuk, kasih review untuk kos yang kamu sewa", "title is not correct");
    }

    @When("user click ajukan berhenti sewa on kontrak saya page")
    public void user_click_ajukan_berhenti_sewa_on_kos_saya_page () {
        riwayatKost.clickAjukanBerhentiSewaText();
    }

    @Then("tenant can see hentikan sewa singgahsini popup with {string}")
    public void userCanSeeHentikanSewaSinggahSiniPopup(String text){
        Assert.assertTrue(riwayatKost.validateBerhentiSewaPopup(text), "popup not appears");
    }

    @And("tenant click on berhenti sewa button on popup")
    public void tenantClickOnBerhentiSewaButtonOnPopup(){
        riwayatKost.clickBerhentiSewaButtonOnPopup();
    }

    @Then("tenant can not see hentikan sewa singgahsini popup with {string}")
    public void tenantCannotSeeHentikanSewaSinggahsiniPopup(String text){
        Assert.assertFalse(riwayatKost.validateBerhentiSewaPopup(text), "popup is appears");
    }

    @Then("tenant can see stop rent contract")
    public void tenantCanSeeStopRentContract(){
        Assert.assertTrue(riwayatKost.getStopRentContract(), "stop rent contract not visible");
    }

    @Then("there will be a ajukan sewa with the title {string}")
    public void there_will_be_a_ajukan_sewa_with_the_title(String title){
        Assert.assertEquals(riwayatKost.getTitleAjukanSewaText(),title, "title is not correct");
    }

    @When("user click title ajukan sewa")
    public void userClickTitleAjukanSewa() {
        riwayatKost.clickAjukanSewaTitle();
    }

    @Then("user see at review page contains:")
    public void user_see_at_review_page_contains(DataTable dataTable) {
        List<Map<String, String>> table = dataTable.asMaps();
        int i=0;
        for (Map<String, String> content : table) {
            Assert.assertEquals(riwayatKost.getAllReviewPage(i),content.get("Review Page"),"Review page should contain" + content.get("Review Page"));
            i++;
        }
    }

    @Then("user see ajukan berhenti sewa button is disabled")
    public void user_see_edit_finished_button_is_disabled() {
        Assert.assertTrue(riwayatKost.isAjukanBerhentiSewaButtonDisabled(), "ajukan berhenti sewa button is not disabled");
    }

    @Then("there will be a Kost Review submitted with the title {string}")
    public void thereWillBeAKostReviewSubmittedWithTheTitle(String title) {
        Assert.assertEquals(riwayatKost.getTitleKostReviewSubmittedText().replaceAll("\n",""),title, "title is not correct");
    }

    @And("there will be a Kost Review submitted with the stars amount {string}")
    public void there_will_be_a_kost_review_submitted_with_the_stars_amount(String title){
        Assert.assertEquals(riwayatKost.getStarsKostReviewSubmittedText().replaceAll("\n",""),title, "title is not correct");
    }

    @And("user verify Kost Review entry point is not displayed")
    public void user_verify_Kost_Review_entry_point_is_not_displayed() {
        Assert.assertTrue(riwayatKost.isKostReviewEntryPointNotDisplayed());
    }
    @When("user stop rent kost with reason {string} and subreason {string}")
    public void user_stop_rent_with_reason_and_subreason(String reason, String subreason) {
        riwayatKost.clickReasonStopRent(reason, subreason);
    }

    @And("user input review kost with rating 5:")
    public void user_click_input_review(DataTable table) {
        reviewText = table.asMaps(String.class, String.class);
        var review = reviewText.get(0).get("review stop rent " + Mamikos.ENV);
        riwayatKost.clickReviewKebersihan();
        riwayatKost.clickReviewKeamanan();
        riwayatKost.clickReviewKenyamanan();
        riwayatKost.clickReviewFasilitasKamar();
        riwayatKost.clickReviewFasilitasUmum();
        riwayatKost.clickReviewKesesuaianHarga();
        riwayatKost.fillReviewKost(review);
        riwayatKost.clickKirimButton();
        }
    @When("user click ajukan berhenti sewa on kontrak saya after review kos")
    public void user_click_ajukan_berhenti_sewa_on_kos_saya_page_after_review_kos () {
        riwayatKost.clickAjukanBerhentiSewaTextAfterReviewKos();
    }

    @And("user click ajukan berhenti sewa on kontrak saya after input data diri")
    public void user_click_ajukan_berhenti_sewa_on_kontrak_saya_after_input_data_diri(){
        riwayatKost.clickAjukanBerhentiSewaButton();
    }

    @Then("tenant can see {string} on bank account section")
    public void tenant_can_see_on_bank_account_section(String text){
        riwayatKost.validateBankAccount(text);
    }

    @Then("tenant can see popup with:")
    public void tenant_can_see_popup_with(DataTable table){
        bankAccount = table.asMaps(String.class, String.class);
        String bankName = bankAccount.get(0).get("Nama bank");
        String number = bankAccount.get(0).get("Nomor rekening");
        String name = bankAccount.get(0).get("Nama pemilik rekening");
        Assert.assertTrue(riwayatKost.validateConfirmationPopupAccount(bankName), "nama bank or number or name not displayed");
        Assert.assertTrue(riwayatKost.validateConfirmationPopupAccount(number), "nama bank or number or name not displayed");
        Assert.assertTrue(riwayatKost.validateConfirmationPopupAccount(name), "nama bank or number or name not displayed");
    }

    @And("tenant click on {string} button on popup confirmation")
    public void tenant_click_on_button_on_popup_confirmation(String text){
        riwayatKost.clickButtonOnPopup(text);
    }

    @Then("tenant cannot see {string} on bank account section")
    public void tenant_cannot_see_on_bank_account_section(String text){
        Assert.assertFalse(riwayatKost.validateBankAccount(text), "bank account is visible");
    }
}

