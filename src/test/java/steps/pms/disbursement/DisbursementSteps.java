package steps.pms.disbursement;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.HomePO;
import pageobject.pms.disbursement.DisbursementPO;
import utilities.JavaHelpers;

import java.util.List;
import java.util.Map;

public class DisbursementSteps {
    Page page = ActiveContext.getActivePage();
    DisbursementPO disbursement = new DisbursementPO(page);
    HomePO home = new HomePO(page);

    private static final String MAMIKOS = "src/main/resources/mamikos.properties";
    public static final String ENV = JavaHelpers.getPropertyValue(MAMIKOS, "env");

    private String disbursementPage = "src/test/resources/testdata/pms/disbursement.properties";
    private String keteranganTambahanToast = JavaHelpers.getPropertyValue(disbursementPage, "keteranganTambahanToast");
    private String noteLessThan = JavaHelpers.getPropertyValue(disbursementPage, "disbursementNoteLessThan1500");
    private String keteranganTambahanErrorMessage = JavaHelpers.getPropertyValue(disbursementPage, "keteranganTambahanErrorMessage");
    private String noteMoreThan = JavaHelpers.getPropertyValue(disbursementPage, "noteMoreThan");
    private String errorMessageMoreThan1500Chars = JavaHelpers.getPropertyValue(disbursementPage, "errorMessageMoreThan1500Chars");
    private String emptyStateTitleInDisbursement = JavaHelpers.getPropertyValue(disbursementPage, "emptyStateTitleInDisbursement");
    private String emptyStateSubtitleInDisbursement = JavaHelpers.getPropertyValue(disbursementPage, "emptyStateSubtitleInDisbursement");

    private List<Map<String, String>> modelKerjaSama;
    private List<Map<String, String>> tambahanPendapatan;

    @When("admin go to detail transfer {string}")
    public void admin_go_to_detail_transfer(String property){
        disbursement.searchProperty(property);
        disbursement.clicksLihatDetail();
    }

    @When("admin clicks Refresh Halaman ini")
    public void admin_clicks_Refresh_Halaman_ini(){
        disbursement.clicksRefreshHalamanIniBtn();
    }

    @Then("Model Kerja Sama and Add On are displayed in Informasi Transfer Pendapatan Properti according Detail Kerja Sama data")
    public void Model_Kerja_Sama_and_Add_On_are_displayed_in_Informasi_Transfer_Pendapatan_Properti_according_Detail_kerja_Sama_data(DataTable tables){
        modelKerjaSama = tables.asMaps(String.class, String.class);

        String modelKerjaSamaBooking = modelKerjaSama.get(0).get("Model Kerja Sama Booking");
        String modelKerjaSamaDBET = modelKerjaSama.get(0).get("Model Kerja Sama DBET");
        String addOnJP = modelKerjaSama.get(0).get("Add On JP");
        String addOnADP = modelKerjaSama.get(0).get("Add On ADP");

        disbursement.clicksRefreshHalamanIniBtn();

        Assert.assertEquals(disbursement.getModelKerjaSamaBooking(), modelKerjaSamaBooking);
        Assert.assertEquals(disbursement.getModelKerjaSamaDBET(), modelKerjaSamaDBET);
        Assert.assertEquals(disbursement.getAddOnJP(), addOnJP);
        Assert.assertEquals(disbursement.getAddOnADP(), addOnADP);
    }
    @When("admin add new tambahan pendapatan")
    public void admin_add_new_tambahan_pendapatan(List<String> fee) {
        disbursement.addTambahanPendapatan(fee);
    }
    @Then("tambahan pendapatan should contains biaya")
    public void tambahan_pendapatan_should_contains_biaya(DataTable tables) {
        tambahanPendapatan = tables.asMaps(String.class, String.class);

        for (int i = 0; i < tambahanPendapatan.size(); i++) {
            String name = tambahanPendapatan.get(i).get("Nama Pendapatan");
            String price = tambahanPendapatan.get(i).get("Harga Satuan");
            String qty = tambahanPendapatan.get(i).get("Kuantitas");
            String total = tambahanPendapatan.get(i).get("Total Pendapatan");
            String totalFee = tambahanPendapatan.get(i).get("Total Tambahan Pendapatan");

            Assert.assertEquals(disbursement.getTambahanPendapatanName(i),name);
            Assert.assertEquals(disbursement.getTambahanPendapatanPrice(i),price);
            Assert.assertEquals(disbursement.getTambahanPendapatanQty(i),qty);
            Assert.assertEquals(disbursement.getTambahanPendapatanTotal(i),total);
            Assert.assertEquals(disbursement.getTambahanPendapatanTotalPendapatan(),totalFee);
        }
    }
    @When("admin edit tambahan pendapatan {int}")
    public void admin_edit_tambahan_pendapatan(Integer row,List<String> fee) {
        disbursement.editTambahanPendapatan(fee,row);
    }
    @When("admin delete tambahan pendapatan {int}")
    public void admin_delete_tambahan_pendapatan(Integer row) {
        disbursement.deleteTambahanPendapatan(row);
    }
    @Then("tambahan pendapatan should be empty")
    public void tambahan_pendapatan_should_be_empty() {
        Assert.assertEquals(disbursement.getEmptyTambahanPendapatanMessage(),"Belum Ada Biaya Tambahan Pendapatan");
    }
    @When("admin click riwayat transfer pendapatan")
    public void admin_click_riwayat_transfer_pendapatan() {
        disbursement.clickRiwayatTransferPendapatan();
    }
    @Then("admin should redirect to riwayat transfer pendapatan section")
    public void admin_should_redirect_to_riwayat_transfer_pendapatan_section() {
        Assert.assertTrue(disbursement.isRiwayatTransferPendapatanVisible());
        if (ENV.equalsIgnoreCase("stag")){
            Assert.assertEquals(home.getURL(),"https://sini-jambu.kerupux.com/property-detail/3143/overview#transfer-pendapatan-history");
        } else if (ENV.equalsIgnoreCase("prod")) {
            Assert.assertEquals(home.getURL(),"https://singgahsini.kerupux.com/property-detail/36335/overview#transfer-pendapatan-history");
        }
    }
    @Then("button refresh should be visible")
    public void button_refresh_should_be_visible() {
        Assert.assertTrue(disbursement.isRefreshButtonVisible());
    }
    @Then("button refresh should be invisible")
    public void button_refresh_should_be_invisible() {
        Assert.assertFalse(disbursement.isRefreshButtonVisible());
    }
    @When("admin {string} dibursement from detail")
    public void admin_dibursement_from_detail(String action) {
        if (action.equalsIgnoreCase("approve")){
            disbursement.approveFromdDetail();
        } else if (action.equalsIgnoreCase("unapprove")) {
            disbursement.unapproveFromDetail();
        }
    }

    @When("admin {string} disbursement from list")
    public void admin_disbursement_from_list(String action) {
        if (action.equalsIgnoreCase("approve")){
            disbursement.approveFromList();
        } else if (action.equalsIgnoreCase("unapprove")) {
            disbursement.unapproveFromList();
        }
    }
    @When("admin go to detail transfer")
    public void admin_go_to_detail_transfer() {
        disbursement.clicksLihatDetail();
    }
    @When("admin search disbursement {string}")
    public void admin_search_disbursement(String keyword) {
        disbursement.searchProperty(keyword);
    }

    @When("admin inputs characters {string}")
    public void admin_inputs_characters(String chars){
        if (chars.equalsIgnoreCase("note <= 1500")){
            disbursement.clicksUbahInKeteranganTambahan();
            disbursement.inputsCharactersLessInKeteranganTambahan(noteLessThan);
        } else if (chars.equalsIgnoreCase("note > 1500")) {
            disbursement.inputsCharactersMoreInKeteranganTambahan(noteMoreThan);
        } else {
            System.out.println("Invalid Inputs Characters");
        }
    }

    @Then("Keterangan Tambahan value {string} is displayed")
    public void Keterangan_Tambahan_value_is_displayed(String keteranganTambahanValue){
        if (keteranganTambahanValue.equalsIgnoreCase("note <= 1500")){
            Assert.assertEquals(disbursement.getKeteranganTambahanToast(keteranganTambahanToast), keteranganTambahanToast, "Toast after add Keterangan Tambahan untuk Owner does not match!");
            Assert.assertEquals(disbursement.getKeteranganTambahanValue(noteLessThan), noteLessThan, "Value in Keterangan Tambahan untuk Owner does not match!");
        }
    }

    @When("admin does not input charaters")
    public void admin_does_note_input_character(){
        disbursement.clearKeteranganTambahanValue();
    }
    @Then("the Simpan button is disable")
    public void the_Simpan_button_is_disable(){
        Assert.assertEquals(disbursement.errorMessageEmptyStateInKeteranganTambahan(keteranganTambahanErrorMessage), keteranganTambahanErrorMessage, "Error Message in Keterangan Tambahan untuk Owner does not match!");
        Assert.assertTrue(disbursement.isSimpanButtonInKeteranganTambahanDisable(), "Simpan button in Keterangan Tambahan untuk Owner is Enable!");
    }

    @Then("error message is displayed")
    public void error_message_is_displayed(){
        Assert.assertEquals(disbursement.errorMessageMoreThan1500Chars(errorMessageMoreThan1500Chars), errorMessageMoreThan1500Chars, "Error Message for More Than 1500 Characters does not match!");
    }

    @When("admin clicks on next month in calendar")
    public void admin_clicks_on_next_month_in_calendar(){
        disbursement.clicksCalendar();
    }

    @Then("empty state in Disbursement menu is displayed")
    public void empty_state_in_Disbursement_menu_is_displayed(){
        Assert.assertEquals(disbursement.getEmptyStateTitleInDisbursement(), emptyStateTitleInDisbursement, "Empty State Title does not match!");
        Assert.assertEquals(disbursement.getEmptyStateSubtitleInDisbursement(), emptyStateSubtitleInDisbursement, "Empty State Subtitle does not match!");
    }
    @Then("show all disbursement list")
    public void show_all_disbursement_list() {
        Assert.assertFalse(disbursement.isEmptyStateDisbursementListAppear(),"empty list disbursement");
    }
    @Then("show empty list disbursmement")
    public void show_empty_list_disbursmement() {
        Assert.assertTrue(disbursement.isEmptyStateDisbursementListAppear(),"There are disbursement in list");
    }
    @Then("show only disbursment for {string}")
    public void show_only_disbursment_for(String name) {
        Assert.assertEquals(disbursement.getPropertyNameinList(),name);
    }
    @When("admin select disbursement period {string}")
    public void admin_select_disbursement_period(String period) {
        disbursement.selectDisbursementPeriod(period);
    }
}
