package steps.pms;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.LoadingPO;
import pageobject.pms.HomepagePO;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class HomepageSteps {
    Page page = ActiveContext.getActivePage();
    HomepagePO homepage = new HomepagePO(page);
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);

    LoadingPO loading = new LoadingPO(page);

    private String homepagePage ="src/test/resources/testdata/pms/homepage.properties";
    private String emptyStateTitleInHomepage = JavaHelpers.getPropertyValue(homepagePage, "emptyStateTitleCopy");
    private String emptyStateSubtitleInHomepage = JavaHelpers.getPropertyValue(homepagePage, "emptyStateSubtitleCopy");
    private String urlDetailProperty = JavaHelpers.getPropertyValue(homepagePage, "urlDetailProperty");
    private String urlRoomAllotmentPage = JavaHelpers.getPropertyValue(homepagePage, "urlRoomAllotmentPage");
    private String tanggalLiveMulai = JavaHelpers.getPropertyValue(homepagePage, "tanggalLiveMulai");
    private String tanggalLiveAkhir = JavaHelpers.getPropertyValue(homepagePage, "tanggalLiveAkhir");
    private String tanggalExpiredMulai = JavaHelpers.getPropertyValue(homepagePage, "tanggalExpiredMulai");
    private String tanggalExpiredAkhir = JavaHelpers.getPropertyValue(homepagePage, "tanggalExpiredAkhir");
    private String pilihProduk = JavaHelpers.getPropertyValue(homepagePage, "pilihProduk");
    private String pilihBSE = JavaHelpers.getPropertyValue(homepagePage, "pilihBSE");
    private String pilihBD = JavaHelpers.getPropertyValue(homepagePage, "pilihBD");
    private String pilihAS = JavaHelpers.getPropertyValue(homepagePage, "pilihAS");
    private String pilihHospitality = JavaHelpers.getPropertyValue(homepagePage, "pilihHospitality");
    private String pilihKota = JavaHelpers.getPropertyValue(homepagePage, "pilihKota");
    private String namaProperti = JavaHelpers.getPropertyValue(homepagePage, "namaProperti");
    private String kota = JavaHelpers.getPropertyValue(homepagePage, "kota");
    private String produk = JavaHelpers.getPropertyValue(homepagePage, "produk");
    private String BSE = JavaHelpers.getPropertyValue(homepagePage, "BSE");
    private String BD = JavaHelpers.getPropertyValue(homepagePage, "BD");
    private String AS = JavaHelpers.getPropertyValue(homepagePage, "AS");
    private String hospitality = JavaHelpers.getPropertyValue(homepagePage, "hospitality");

    private List<Map<String, String>> informasiPembayaran;
    private List<Map<String, String>> gender;

    private List<Map<String, String>> otherFee;
    private List<Map<String, String>> changeLog;

    @And("admin go to room allotment page {string}")
    public void admin_go_to_room_allotment_page(String name) {
        homepage.searchProperty(name);
        homepage.clicksActionButton();
        homepage.clickRoomAllotment();
    }

    @When("admin go to detail property {string}")
    public void admin_go_to_detail_property(String name) {
        homepage.searchProperty(name);
        homepage.clicksActionButton();
        homepage.clickSeeDetail();
    }

    @And("admin create contract tenant new booking")
    public void admin_create_contract_tenant_new_booking() {
        homepage.clickOnTambahPenyewa();
        homepage.clickOnBooking();
        homepage.clickOnDropdownTipeBooking();
        homepage.clickOnNewBooking();
        homepage.clickOnSelanjutnyaButton();
    }

    @And("admin selected type room {string}")
    public void admin_selected_type_room(String text) {
        homepage.clickOnTypeRoom(text);
    }

    @And("admin fill phone number tenant {string}")
    public void admin_fill_number_handphone_tenant(String number) {
        homepage.fillNumberHandphoneTenant(number);
    }

    @And("admin fill nama tenant {string}")
    public void admin_fill_nama_tenant(String name) {
        homepage.fillNameTenant(name);
    }

    @Then("admin see informasi penyewa")
    public void admin_see_informasi_penyewa() {
        Assert.assertTrue(homepage.isInformasiPenyewaDisplayed(), "Informasi penyewa is not displayed");
    }

    @And("admin fill informasi pembayaran:")
    public void admin_fill_informasi_pembayaran(DataTable tables) {
        informasiPembayaran = tables.asMaps(String.class, String.class);
        String hitunganSewaKos = informasiPembayaran.get(0).get("Hitungan Sewa");
        String tanggalCheckIn = informasiPembayaran.get(0).get("Tanggal Check-in");
        String durasiSewa = informasiPembayaran.get(0).get("Durasi Sewa");
        String metodePembayaran = informasiPembayaran.get(0).get("Metode Pembayaran");
        homepage.fillHitunganSewa(hitunganSewaKos);
        homepage.fillTanggalCheckInKos(tanggalCheckIn);
        homepage.fillDurasiSewa(durasiSewa);
        homepage.fillNomorKamar();
        homepage.fillMetodePembayaran(metodePembayaran);
    }

    @And("admin add other cost:")
    public void admin_add_other_cost(DataTable tables) {
        otherFee = tables.asMaps(String.class, String.class);
            String nameFee0 = otherFee.get(0).get("Nama Biaya");
            String nameFee1 = otherFee.get(1).get("Nama Biaya");
            String amountFee0 = otherFee.get(0).get("Harga");
            String amountFee1 = otherFee.get(1).get("Harga");
            homepage.fillOtherFeeName(nameFee0, nameFee1);
            homepage.fillOtherFeeAmount(amountFee0, amountFee1);
        }

    @And("admin see has fee Informasi Biaya Lain:")
    public void admin_see_has_other_fee(DataTable tables) {
        otherFee = tables.asMaps(String.class, String.class);
        String nameFee0 = otherFee.get(0).get("Nama Biaya");
        String nameFee1 = otherFee.get(1).get("Nama Biaya");
        String amountFee0 = otherFee.get(0).get("Harga");
        String amountFee1 = otherFee.get(1).get("Harga");
        Assert.assertTrue(homepage.isInformasiBiayaLainDisplayed(nameFee0, nameFee1, amountFee0, amountFee1), "is displayed");
    }

    @Then("admin click on save button")
    public void admin_click_on_save_button() {
            homepage.clickOnSaveButton();
    }

    //--------------------dbet pms--------//
    @And("admin create contract tenant dbet")
    public void admin_create_contract_tenant_dbet() {
        loading.waitForLoadingIconDisappear();
        homepage.clickOnTambahPenyewa();
        homepage.clickDbetButton();
    }

    @Then("admin can see {string} on phone number")
    public void admin_can_see_error_message_on_phone_number(String text) {
        Assert.assertEquals(homepage.getPhoneNumberErrorMessage(),text, "not display error message");
    }

    @Then("admin can see {string} on tenant name")
    public void admin_can_see_x_on_tenant_name(String text) {
        Assert.assertEquals(homepage.getTenantNameErrorMessage(), text, "not display error message");
    }

    @And("admin fill email tenant {string}")
    public void admin_fill_email_tenant(String email) {
        homepage.fillEmailTenant(email);
    }

    @Then("admin can see {string} on email")
    public void admin_can_see_x_on_email(String text) {
        Assert.assertEquals(homepage.getEmailErrorMessage(), text, "not display error message");
    }

    @And("admin click on ya simpan button")
    public void admin_click_on_ya_simpan_button() {
        homepage.clickOnYaSimpanButton();
    }

    @And("admin see block line status {string}")
    public void admin_see_block_line_status (String text) {
        Assert.assertEquals(homepage.getStatusBooking(text), text, "not display error message");
    }

    @When("admin change Transfer Pendapatan Otomatis to {string}")
    public void admin_change_Transfer_Pendapatan_Otomatis_to(String toggle){
        if (toggle.equalsIgnoreCase("ON")){
            homepage.setToggleAutoDisbursement();
        } else {
            homepage.goToOverviewTab();
            homepage.setToggleAutoDisbursement();
        }
    }

    @Then("change log auto disbursement {string} is displayed")
    public void change_log_auto_disbursement_is_displayed(String toggle, DataTable tables){
        changeLog = tables.asMaps(String.class, String.class);
        String diubahOleh = "", role = "", dataYangDiubah = "", inputLama = "", inputBaru = "", waktuDiubah = "";

        //Clicks on Kontrak Kerja Sama tab
        homepage.goToKontrakKerjaSamaTab();
        homepage.clicksRiwayatPerubahanKontrak();

        diubahOleh = changeLog.get(0).get("Diubah oleh");
        role = changeLog.get(0).get("Role");
        dataYangDiubah = changeLog.get(0).get("Data yang Diubah");
        inputLama = changeLog.get(0).get("Input Lama");
        inputBaru = changeLog.get(0).get("Input Baru");
        waktuDiubah = changeLog.get(0).get("Waktu Diubah");

        if (toggle.equalsIgnoreCase("ON")){
            Assert.assertEquals(homepage.getInputLama(), "Nonaktif", "Value does not match.");
            Assert.assertEquals(homepage.getInputBaru(), "Aktif", "Value does not match.");
        } else if (toggle.equalsIgnoreCase("OFF")){
            Assert.assertEquals(homepage.getInputLama(), "Aktif", "Value does not match.");
            Assert.assertEquals(homepage.getInputBaru(), "Nonaktif", "Value does not match.");
        } else {
            System.out.println("Toggle is not valid");
        }
        Assert.assertEquals(homepage.getDiubahOleh(), "PMAN Admin", "Value does not match.");
        Assert.assertEquals(homepage.getRole(), "Super Admin", "Value does not match.");
        Assert.assertEquals(homepage.getDataYangDiubah(), "Transfer Pendapatan Otomatis", "Value does not match.");

        //get today
        SimpleDateFormat today = new SimpleDateFormat("dd/MM/yyyy");
        Date dates = new Date();
        Assert.assertEquals(homepage.getWaktuDiubah(), today.format(dates));
    }

    @When("admin go to Homepage")
    public void admin_go_to_Homepage(){
        homepage.clicksHomepage();
    }

    @When("admin search property {string}")
    public void admin_search_property(String property){
        homepage.searchProperty(property);
    }

    @Then("empty state in Homepage menu is displayed")
    public void empty_state_in_Homepage_menu_is_displayed(){
        Assert.assertEquals(homepage.getEmptyStateTitleInHomepage(), emptyStateTitleInHomepage, "Empty State Copy does not match!");
        Assert.assertEquals(homepage.getEmptyStateSubtitleInHomepage(), emptyStateSubtitleInHomepage, "Empty State Copy does not match!");

        homepage.clearKeyword();
    }

    @When("admin search property using ID {string}")
    public void admin_search_property_using_ID(String id){
        homepage.searchPropertyId(id);
    }

    @Then("admin redirect to detail property page")
    public void admin_redirect_to_detail_property_page(){
        playwright.waitTillPageLoaded();
        Assert.assertEquals(homepage.getURLDetailProperty(), urlDetailProperty);
    }

    @When("admin go to Ketersediaan Kamar in Homepage action button")
    public void admin_go_to_Ketersediaan_Kamar_in_Homepage_action_button(){
        homepage.clicksActionButton();
        homepage.clicksKetersediaanKamarButton();
    }

    @Then("admin redirect to room allotment page")
    public void admin_redirect_to_room_allotment_page(){
        playwright.waitTillPageLoaded();
        Assert.assertEquals(homepage.getURLRoomAllotmentPage(), urlRoomAllotmentPage);
    }

    @When("admin Filter data in Homepage")
    public void admin_Filter_data_in_Homepage(){
        playwright.waitTillPageLoaded();
        homepage.clicksFilter();

        playwright.waitTillPageLoaded();
        homepage.inputsTanggalMulaiLiveDate(tanggalLiveMulai);
        homepage.inputsTanggalAkhirLiveDate(tanggalLiveAkhir);
        homepage.inputsTanggalMulaiExpiredDate(tanggalExpiredMulai);
        homepage.inputsTanggalAkhirExpiredDate(tanggalExpiredAkhir);
        homepage.ticksProduk(pilihProduk);
        homepage.ticksBSE(pilihBSE);
        homepage.ticksBD(pilihBD);
        homepage.ticksAS(pilihAS);
        homepage.ticksHospitality(pilihHospitality);
        homepage.selectsKota(pilihKota);
    }

    @Then("property is displayed")
    public void property_is_displayed(){
        playwright.waitTillPageLoaded();
        Assert.assertEquals(homepage.getNamaPropertiInTable(namaProperti), namaProperti, "Nama Properti does not match!");
        Assert.assertEquals(homepage.getKotaInTable(kota), kota, "Kota does not match!");
        Assert.assertEquals(homepage.getProdukInTable(produk), produk, "Produk does not match!");
        Assert.assertEquals(homepage.getBSEInTable(BSE), BSE, "BSE does not match!");
        Assert.assertEquals(homepage.getBDInTable(BD), BD, "BD does not match!");
        Assert.assertEquals(homepage.getASInTable(AS), AS, "AS does not match!");
        Assert.assertEquals(homepage.getHospitality(hospitality), hospitality, "Hospitality does not match!");
    }
}

