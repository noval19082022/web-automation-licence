package steps.mamipay.invoicemanual;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.admin.mamipay.AdminMamipayDashboardPO;
import pageobject.admin.mamipay.invoiceManual.InvoiceManualPO;
import pageobject.common.HomePO;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class InvoiceManualSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    private AdminMamipayDashboardPO admin = new AdminMamipayDashboardPO(page);
    private InvoiceManualPO manualInvoice = new InvoiceManualPO(page);
    HomePO home = new HomePO(page);
    Page page1;

    private String listing;
    private String tenant;
    private List<Map<String, String>> tenantInfo;
    private List<Map<String, String>> tenantDetail;
    private List<Map<String, String>> detailBiaya;
    private List<Map<String, String>> rincianBiaya;
    private List<Map<String, String>> invoiceData;
    private List<Map<String, String>> hoverData;
    private List<Map<String, String>> changeInvoice;

    //---test data---//
    private String invoiceManual = "src/test/resources/testdata/mamipay/invoiceManual.properties";
    private String char256 = JavaHelpers.getPropertyValue(invoiceManual, "char256");
    private String char255 = JavaHelpers.getPropertyValue(invoiceManual, "char255");
    private String popUpTitleChangeInvConfirmation = JavaHelpers.getPropertyValue(invoiceManual, "changeInvPopupTitle");
    private String popUpSubtitleChangeInvConfirmation = JavaHelpers.getPropertyValue(invoiceManual, "changeInvPopupSubtitle");
    private String statusInvTitle = JavaHelpers.getPropertyValue(invoiceManual, "statusInvTitle");
    private String jenisBiayaTitle = JavaHelpers.getPropertyValue(invoiceManual, "jenisBiayaTitle");
    private String tglInvDibuat = JavaHelpers.getPropertyValue(invoiceManual, "tglInvDibuat");
    private String tglMulaiTitle = JavaHelpers.getPropertyValue(invoiceManual, "tglMulaiTitle");
    private String tglAkhirTitle = JavaHelpers.getPropertyValue(invoiceManual, "tglAkhirTitle");

    //---Biaya Tambahan Pop Up---//
    private List<Map<String, String>> fillFields;
    private List<Map<String, String>> requiredFields;
    //---End of Biaya Tambahan Pop Up---//
    @When("admin input nama penyewa in buat invoice manual")
    public void admin_input_nama_penyewa_in_buat_invoice_manual(DataTable tables) {
        tenantInfo = tables.asMaps(String.class, String.class);

        if (Mamikos.ENV.equalsIgnoreCase("stag")){
            listing = tenantInfo.get(0).get("property name");
            tenant = tenantInfo.get(0).get("tenant name");
        } else if (Mamikos.ENV.equalsIgnoreCase("prod")) {
            listing = tenantInfo.get(1).get("property name");
            tenant = tenantInfo.get(1).get("tenant name");
        }

        admin.NavigateToMamipayMenu("Invoice Manual");
        manualInvoice.clickBuatInvoice();
        manualInvoice.inputListingName(listing);
        manualInvoice.inputTenantName(tenant);
    }

    @When("admin create invoice manual")
    public void admin_create_invoice_manual(DataTable tables){
        tenantInfo = tables.asMaps(String.class, String.class);
        listing = tenantInfo.get(0).get("property name");
        tenant = tenantInfo.get(0).get("tenant name");

        manualInvoice.clickBuatInvoice();
        manualInvoice.inputListingName(listing);
        manualInvoice.inputTenantName(tenant);
    }

    @When("admin go to invoice manual page")
    public void admin_go_to_invoive_manual_page(DataTable tables){
        tenantInfo = tables.asMaps(String.class, String.class);
        listing = tenantInfo.get(0).get("property name");
        tenant = tenantInfo.get(0).get("tenant name");

        manualInvoice.clickBackButtonBuatInvoice();
        manualInvoice.clickBuatInvoice();
        manualInvoice.inputListingName(listing);
        manualInvoice.inputTenantName(tenant);
    }

    @Then("tenant information should be auto fill")
    public void tenant_information_should_be_auto_fill(DataTable tables) {
        String noHP = "";
        String noKamar = "";

        tenantDetail = tables.asMaps(String.class, String.class);

        if (Mamikos.ENV.equalsIgnoreCase("stag")){
            noHP = tenantDetail.get(0).get("No HP");
            noKamar = tenantDetail.get(0).get("No Kamar");
        } else if (Mamikos.ENV.equalsIgnoreCase("prod")) {
            noHP = tenantDetail.get(1).get("No HP");
            noKamar = tenantDetail.get(1).get("No Kamar");
        }

        manualInvoice.assertNoHPTenant(noHP);
        manualInvoice.assertNoKamarTenant(noKamar);
    }

    @When("admin add invoice manual {string}")
    public void admin_add_invoice_manual (String type, DataTable tables){
        String namaBiaya = "",periodeAwal = "",periodeAkhir = "",durasiBiaya = "", jumlahBiaya = "";

        detailBiaya = tables.asMaps(String.class, String.class);

        namaBiaya = detailBiaya.get(0).get("Nama Biaya");
        periodeAwal = detailBiaya.get(0).get("Periode Awal");
        periodeAkhir = detailBiaya.get(0).get("Periode Akhir");
        durasiBiaya = detailBiaya.get(0).get("Durasi Biaya");
        jumlahBiaya = detailBiaya.get(0).get("Jumlah Biaya");

        manualInvoice.selectJenisInvoice(type);
        manualInvoice.tambahBiayaButton();
        manualInvoice.setNamaBiayaInvoiceManual(namaBiaya);
        manualInvoice.setPeriodeAwalInvoiceManual(periodeAwal);
        manualInvoice.setPeriodeAkhirInvoiceManual(periodeAkhir);
        manualInvoice.setDurasiBiayaInvoiceManual(durasiBiaya);
        manualInvoice.setJumlahBiayaInvoiceManual(jumlahBiaya);
        manualInvoice.submitBiayaInvoiceManual(type);
    }

    @When("admin add invoice manual {string} without submit")
    public void admin_add_invoice_manual_without_submit(String type, DataTable tables){
        String namaBiaya = "",periodeAwal = "",periodeAkhir = "",durasiBiaya = "", jumlahBiaya = "";

        detailBiaya = tables.asMaps(String.class, String.class);

        if (type.equalsIgnoreCase("Biaya Tambahan")){
            namaBiaya = detailBiaya.get(0).get("Nama Biaya");
            periodeAwal = detailBiaya.get(0).get("Periode Awal");
            periodeAkhir = detailBiaya.get(0).get("Periode Akhir");
            durasiBiaya = detailBiaya.get(0).get("Durasi Biaya");
            jumlahBiaya = detailBiaya.get(0).get("Jumlah Biaya");
        } else if (type.equalsIgnoreCase("Biaya Sewa")) {
            namaBiaya = detailBiaya.get(1).get("Nama Biaya");
            periodeAwal = detailBiaya.get(1).get("Periode Awal");
            periodeAkhir = detailBiaya.get(1).get("Periode Akhir");
            durasiBiaya = detailBiaya.get(1).get("Durasi Biaya");
            jumlahBiaya = detailBiaya.get(1).get("Jumlah Biaya");
        }

        manualInvoice.selectJenisInvoice(type);
        manualInvoice.tambahBiayaButton();
        manualInvoice.setNamaBiayaInvoiceManual(namaBiaya);
        manualInvoice.setPeriodeAwalInvoiceManual(periodeAwal);
        manualInvoice.setPeriodeAkhirInvoiceManual(periodeAkhir);
        if (durasiBiaya.equalsIgnoreCase("more than 255 characters")){
            manualInvoice.setDurasiBiayaInvoiceManual(char256);
        } else {
            manualInvoice.setDurasiBiayaInvoiceManual(durasiBiaya);
        }
        manualInvoice.setJumlahBiayaInvoiceManual(jumlahBiaya);
    }

    @Then("durasi biaya should be only contains {string} and counter show {string}")
    public void durasi_biaya_should_be_only_contains_and_counter_show(String durasiBiaya, String counter){
        if (durasiBiaya.equalsIgnoreCase("max 255 characters")){
            manualInvoice.assertDurasiBiaya(char255);
            manualInvoice.assertCounterTxt(counter);
        }
    }

    @Then("admin verify data {string} in Buat dan Kirim pop up correct")
    public void admin_verify_data_in_buat_dan_kirim_pop_up_correct(String type, DataTable tables) {
        rincianBiaya = tables.asMaps(String.class, String.class);
        String namaBiaya = "",periodeAwal = "",periodeAkhir = "",jumlahBiaya = "",disburseToPenmilik = "";

        if (type.equalsIgnoreCase("Biaya Tambahan")){
            namaBiaya = rincianBiaya.get(0).get("Nama Biaya");
            periodeAwal = rincianBiaya.get(0).get("Awal");
            periodeAkhir = rincianBiaya.get(0).get("Akhir");
            jumlahBiaya = rincianBiaya.get(0).get("Jumlah Biaya");
            disburseToPenmilik = rincianBiaya.get(0).get("Disburse to Pemilik");
        } else if (type.equalsIgnoreCase("Biaya Sewa")) {
            namaBiaya = rincianBiaya.get(0).get("Nama Biaya");
            periodeAwal = rincianBiaya.get(0).get("Awal");
            periodeAkhir = rincianBiaya.get(0).get("Akhir");
            jumlahBiaya = rincianBiaya.get(0).get("Jumlah Biaya");
            disburseToPenmilik = rincianBiaya.get(0).get("Disburse to Pemilik");
        }

        manualInvoice.previewBuatdanKirimInvoiceManual();
        manualInvoice.assertNamaBiayaInPreviewBuatDanKirim(namaBiaya,type);
        manualInvoice.assertPeriodeAwalInPreviewBuatDanKirim(periodeAwal,type);
        manualInvoice.assertPeriodeAkhirInPreviewBuatDanKirim(periodeAkhir,type);
        manualInvoice.assertJumlahBiayaInPreviewBuatDanKirim(jumlahBiaya,type);
        manualInvoice.assertDisburseToPemilikInPreviewBuatDanKirim(disburseToPenmilik,type);
    }

    @When("admin check pop up button and confirm it")
    public void admin_check_pop_up_button_and_confirm_it() {
        //check close button
        manualInvoice.clickClosePopUp();
        manualInvoice.assertPopUpInInvoiceManual();
        //check kembali button
        manualInvoice.previewBuatdanKirimInvoiceManual();
        manualInvoice.kembaliPopupButton();
        manualInvoice.assertPopUpInInvoiceManual();
        //confirm button
        manualInvoice.previewBuatdanKirimInvoiceManual();
        manualInvoice.confirmPopUpBuatDanKirim();
    }

    @Then("invoice manual {string} created")
    public void invoice_manual_created(String type, DataTable tables) {
        String namaListing = "", jumlahBiaya = "", statusInvoice = "";

        invoiceData = tables.asMaps(String.class, String.class);

        if (type.equalsIgnoreCase("Biaya Tambahan")){
            namaListing = invoiceData.get(0).get("Nama Listing");
            jumlahBiaya = invoiceData.get(0).get("Jumlah Biaya");
            statusInvoice = invoiceData.get(0).get("Status Invoice");
        } else if (type.equalsIgnoreCase("Biaya Sewa")) {
            namaListing = invoiceData.get(0).get("Nama Listing");
            jumlahBiaya = invoiceData.get(0).get("Jumlah Biaya");
            statusInvoice = invoiceData.get(0).get("Status Invoice");
        }

        manualInvoice.goToLastPageInvoiceManual();
        manualInvoice.assertNewNamaListing(namaListing);
        manualInvoice.assertNewJenisInvoice(type);
        manualInvoice.assertNewTotalInvoice(jumlahBiaya);
        manualInvoice.assertNewStatusInvoice(statusInvoice);
    }

    @Then("show detail biaya {string} if hovered")
    public void show_detail_biaya_if_hovered(String type, DataTable tables) {
        String namaBiaya = "", jumlahBiaya = "";

        hoverData = tables.asMaps(String.class, String.class);

        if (type.equalsIgnoreCase("Biaya Tambahan")){
            namaBiaya = hoverData.get(0).get("Nama Biaya");
            jumlahBiaya = hoverData.get(0).get("Jumlah Biaya");
        } else if (type.equalsIgnoreCase("Biaya Sewa")) {
            namaBiaya = hoverData.get(0).get("Nama Biaya");
            jumlahBiaya = hoverData.get(0).get("Jumlah Biaya");
        }

        manualInvoice.hoverLastInvoiceData();
        manualInvoice.assertNamaBiayaHover(namaBiaya);
        manualInvoice.assertJumlahBiayaHover(jumlahBiaya);
    }
    @When("admin click back button in buat invoice manual page")
    public void admin_click_back_button_in_buat_invoice_manual_page() {
        manualInvoice.clickBackButtonBuatInvoice();
    }
    @Then("exit buat invoice confirmation pop up should be appear")
    public void exit_buat_invoice_confirmation_pop_up_should_be_appear() {
        manualInvoice.assertExitInvoicePopUpAppear();
        manualInvoice.assertExitBuatInvoicePopUpTitle();
        manualInvoice.assertExitBuatInvoicePopUpDescription();
        manualInvoice.assertExitBuatInvoicePopUpButton();
    }
    @When("admin check confirmation functionality and confirm exit")
    public void admin_check_confirmation_functionality_and_confirm_exit() {
        //click 'tidak' in Exit Buat Invoice Confirmation pop up
        manualInvoice.cancelExitBuatInvoice();
        manualInvoice.assertExitInvoicePopUpClosed();
        //click 'ya' in Exit Buat Invoice Confirmation pop up
        manualInvoice.clickBackButtonBuatInvoice();
        manualInvoice.confirmExitBuatInvoice();
    }
    @Then("admin redirect to invoice manual page")
    public void admin_redirect_to_invoice_manual_page() {
        manualInvoice.assertURLInvoiceManual();
    }
    @Then("admin redirect to invoice manual page without confirmation")
    public void admin_redirect_to_invoice_manual_page_without_confirmation() {
        manualInvoice.assertURLInvoiceManual();
    }

    @When("admin selects Jenis Invoice {string} when {string}")
    public void admin_selects_Jenis_Invoice(String type, String biaya){
        if (biaya.equalsIgnoreCase("There are Biaya Data")){
            manualInvoice.selectJenisInvoice(type);
            manualInvoice.assertChangeInvConfirmationTitle(popUpTitleChangeInvConfirmation);
            manualInvoice.assertChangeInvConfirmationSubtitle(popUpSubtitleChangeInvConfirmation);
            manualInvoice.clickBatalOnChangeInvConfirmation();
            manualInvoice.selectJenisInvoice(type);
            manualInvoice.clickLanjutkanOnChangeInvConfirmation();
        } else if (biaya.equalsIgnoreCase("There is no Biaya Data")) {
            manualInvoice.selectJenisInvoice(type);
        }
    }

    @When("admin selects Jenis Invoice")
    public void admin_selects_Jenis_Invoice(DataTable tables){
        String jenisInvoice = "", changeInvoiceTo = "", changeInvoiceAgainTo = "";

        changeInvoice = tables.asMaps(String.class, String.class);

        jenisInvoice = changeInvoice.get(0).get("Jenis Invoice");
        changeInvoiceTo = changeInvoice.get(0).get("Change Invoice to");
        changeInvoiceAgainTo = changeInvoice.get(0).get("Change Invoice again to");

        manualInvoice.selectJenisInvoice(jenisInvoice);
        manualInvoice.selectJenisInvoice(changeInvoiceTo);
        manualInvoice.selectJenisInvoice(changeInvoiceAgainTo);
    }

    @Then("empty state on the biaya {string} table is displayed")
    public void empty_state_on_the_biaya_table_is_displayed(String emptyState){
        if (emptyState.equalsIgnoreCase("Biaya Sewa")){
            manualInvoice.assertEmptyStateBiayaSewa();
        } else if (emptyState.equalsIgnoreCase("Biaya Tambahan")) {
            manualInvoice.assertEmptyStateBiayaTambahan();
        }
    }

    @Then("the pop up confirmation is not displayed")
    public void the_pop_up_confirmation_is_not_displayed(){
        manualInvoice.changeInvConfirmationPopUpIsNotDisplay();
    }

    @When("admin clicks invoice number with unpaid status")
    public void admin_clicks_invoice_number_with_unpaid_status(){
        page1 = manualInvoice.clickInvoiceNumber();
    }

    @When("click Invoice Manual menu")
    public void click_Invoice_Manual_menu(){
        admin.NavigateToMamipayMenu("Invoice Manual");
    }

    @Then("invoice detail for {string} is displayed")
    public void invoice_detail_for_is_displayed(String invType){
        if (invType.equalsIgnoreCase("Biaya Tambahan")){
            playwright.hardWait(10000);
            home = new HomePO(page1);
            System.out.println(home.getURL());
            manualInvoice.assertJenisPembayaran(invType);
            manualInvoice.assertTotalPembayaranOnLeftSide();
            manualInvoice.assertListingName();
            manualInvoice.assertJenisBiayaOnRincianPembayaran(invType);
            manualInvoice.assertNamaBiayaOnRincianPembayaran();
            manualInvoice.assertTotalPembayaranOnRightSide();
        } else if (invType.equalsIgnoreCase("Biaya Sewa")) {
            playwright.hardWait(10000);
            home = new HomePO(page1);
            System.out.println(home.getURL());
            manualInvoice.assertJenisPembayaran(invType);
            manualInvoice.assertTotalPembayaranOnLeftSide();
            manualInvoice.assertListingName();
            manualInvoice.assertJenisBiayaOnRincianPembayaran(invType);
            manualInvoice.assertNamaBiayaOnRincianPembayaran();
            manualInvoice.assertTotalPembayaranOnRightSide();
        }
    }

    @Then("the Buat dan Kirim button is disabled")
    public void the_Buat_dan_Kirim_Button_is_disabled(){
        manualInvoice.assertBuatDanKirimDisable();
    }

    @When("admin search by {string} with value {string}")
    public void admin_search_by_with_value(String searchBy, String value){
        if (searchBy.equalsIgnoreCase("Nomor Invoice without change Search By")){
            admin.NavigateToMamipayMenu("Invoice Manual");
            manualInvoice.enterSearchValue(value);
        } else if (searchBy.equalsIgnoreCase("Nama Penyewa")) {
            manualInvoice.selectSearchBy(searchBy);
            manualInvoice.enterSearchValue(value);
        } else if (searchBy.equalsIgnoreCase("Nama Listing")) {
            manualInvoice.selectSearchBy(searchBy);
            manualInvoice.enterSearchValue(value);
        } else if (searchBy.equalsIgnoreCase("Nomor Invoice")) {
            manualInvoice.selectSearchBy(searchBy);
            manualInvoice.enterSearchValue(value);
        }
    }

    @Then("the result is displayed according the value {string}, {string}, {string}")
    public void the_result_is_displayed_according_the_value(String result1, String result2, String result3){
        manualInvoice.assertNoInvoice(result1);
        manualInvoice.assertDetailPenyewa(result2);
        manualInvoice.assertNamaListing(result3);
    }

    @Then("the result is displayed according the value Search per word {string}")
    public void the_result_is_displayed_according_the_value_Search_per_word(String result){
        if (result.equalsIgnoreCase("Data yang dicari tidak ditemukan")){
            manualInvoice.assertNotFound(result);
        } else {
            manualInvoice.assertNamaListing(result);
        }
    }

    //---Biaya Tambahan Pop Up---//
    @When("the admin selects {string} in the {string}")
    public void the_admin_selects_in_the(String biaya, String invType){
        admin.NavigateToMamipayMenu("Invoice Manual");
        manualInvoice.clickBuatInvoice();

        if (invType.equalsIgnoreCase("Biaya Tambahan")){
            manualInvoice.clickJenisBiayaTambahan();
            manualInvoice.clickTambah();
            manualInvoice.setNamaBiayaInvoiceManual(biaya);
        } else {
            manualInvoice.clickJenisBiayaSewa();
            manualInvoice.clickTambah();
            manualInvoice.setNamaBiayaInvoiceManual(biaya);
        }

    }

    @Then("the Periode Awal and Periode Akhir are disable")
    public void the_Periode_Awal_and_Periode_Akhir_are_disable(){
        manualInvoice.assertPeriodDate();
    }

    @When("the admin fills all fields in Tambah Biaya Tambahan pop up")
    public void the_admin_fills_all_fields_in_Tambah_Biaya_Tambahan_pop_up(DataTable tables){
        String durasiBiaya = "";
        String jumlahBiaya = "";

        fillFields = tables.asMaps(String.class, String.class);

        if (Mamikos.ENV.equalsIgnoreCase("stag")){
            durasiBiaya = fillFields.get(0).get("Durasi Biaya");
            jumlahBiaya = fillFields.get(0).get("Jumlah Biaya");
        } else if (Mamikos.ENV.equalsIgnoreCase("prod")) {
            durasiBiaya = fillFields.get(1).get("Durasi Biaya");
            jumlahBiaya = fillFields.get(1).get("Jumlah Biaya");
        }

        manualInvoice.setDurasiBiayaInvoiceManual(durasiBiaya);
        manualInvoice.setJumlahBiayaInvoiceManual(jumlahBiaya);
    }

    @When("the admin clicks {string} modal tambah biaya")
    public void the_admin_clicks_modal_tambah_biaya(String button){
        if (button.equalsIgnoreCase("Close")){
            manualInvoice.clickClosePopUp();
        } else if (button.equalsIgnoreCase("Kembali")) {
            manualInvoice.kembaliPopupButton();
        }
    }

    @Then("tambah biaya modal is closed")
    public void tambah_biaya_modal_is_closed(){
        manualInvoice.assertPopUpInInvoiceManual();
    }

    @When("admin tambah pengeluaran {string}")
    public void admin_tambah_pengeluaran(String invType){
        admin.NavigateToMamipayMenu("Invoice Manual");
        manualInvoice.clickBuatInvoice();

        if (invType.equalsIgnoreCase("Biaya Tambahan")){
            manualInvoice.clickJenisBiayaTambahan();
        } else if (invType.equalsIgnoreCase("Biaya Sewa")){
            manualInvoice.clickJenisBiayaSewa();
        }
    }
    @When("Checks required fields {string}, {string}, {string}, {string}, {string}")
    public void Checks_required_fields(String nama, String awal, String akhir, String durasi, String jml){
        manualInvoice.clickTambah();

        if (!(nama.equalsIgnoreCase("-"))) {
            manualInvoice.setNamaBiayaInvoiceManual(nama);
        }
        if (!(awal.equalsIgnoreCase("-"))) {
            manualInvoice.setPeriodeAwalInvoiceManual(awal);
        }
        if (!(akhir.equalsIgnoreCase("-"))) {
            manualInvoice.setPeriodeAkhirInvoiceManual(akhir);
        }
        if (!(durasi.equalsIgnoreCase("-"))) {
            manualInvoice.setDurasiBiayaInvoiceManual(durasi);
        }
        if (!(jml.equalsIgnoreCase("-"))) {
            manualInvoice.setJumlahBiayaInvoiceManual(jml);
        }

        manualInvoice.clickTambahSubmitInPopUp();
    }

    @Then("the error messages {string}, {string}, {string}, {string} are displayed")
    public void the_error_messages_are_displayed(String namaErrMsg, String awalErrMsg, String akhirErrMsg, String jmlErrMsg){
        if (!(namaErrMsg.equalsIgnoreCase("-"))){
            manualInvoice.assertNamaBiayaErrMsg();
        }
        if (!(awalErrMsg.equalsIgnoreCase("-"))) {
            manualInvoice.assertPeriodeAwalErrMsg();
        }
        if (!(akhirErrMsg.equalsIgnoreCase("-"))) {
            manualInvoice.assertPeriodeAkhirErrMsg();
        }
        if (!(jmlErrMsg.equalsIgnoreCase("-"))) {
            manualInvoice.assertJumlahBiayaErrMsg();
        }
        manualInvoice.clickClosePopUp();
    }

    @When("admin creates Invoice Manual {string}")
    public void admin_creates_Invoice_Manual(String invType, DataTable tables){
        String namaBiaya = "", periodeAwal = "", periodeAkhir = "", durasiBiaya = "", jumlahBiaya = "";

        detailBiaya = tables.asMaps(String.class, String.class);

        admin.NavigateToMamipayMenu("Invoice Manual");
        manualInvoice.clickBuatInvoice();

        if (invType.equalsIgnoreCase("Biaya Tambahan")){
            manualInvoice.clickJenisBiayaTambahan();
            namaBiaya = detailBiaya.get(0).get("Nama Biaya");
            periodeAwal = detailBiaya.get(0).get("Periode Awal");
            periodeAkhir = detailBiaya.get(0).get("Periode Akhir");
            durasiBiaya = detailBiaya.get(0).get("Durasi Biaya");
            jumlahBiaya = detailBiaya.get(0).get("Jumlah Biaya");
        } else if (invType.equalsIgnoreCase("Biaya Sewa")){
            manualInvoice.clickJenisBiayaSewa();
            namaBiaya = detailBiaya.get(0).get("Nama Biaya");
            periodeAwal = detailBiaya.get(0).get("Periode Awal");
            periodeAkhir = detailBiaya.get(0).get("Periode Akhir");
            durasiBiaya = detailBiaya.get(0).get("Durasi Biaya");
            jumlahBiaya = detailBiaya.get(0).get("Jumlah Biaya");
        }

        manualInvoice.clickTambah();
        manualInvoice.setNamaBiayaInvoiceManual(namaBiaya);
        manualInvoice.setPeriodeAwalInvoiceManual(periodeAwal);
        manualInvoice.setPeriodeAkhirInvoiceManual(periodeAkhir);
        manualInvoice.setDurasiBiayaInvoiceManual(durasiBiaya);
        manualInvoice.setJumlahBiayaInvoiceManual(jumlahBiaya);
        manualInvoice.clickTambahSubmitInPopUp();
    }

    @When("the admin deletes Invoice Manual")
    public void the_admin_deletes_Invoice_Manual(){
        manualInvoice.clickDeleteInvManual();
    }

    @Then("the empty state is display in {string} table")
    public void the_empty_state_is_display_in_table(String invType){
        if (invType.equalsIgnoreCase("Biaya Tambahan")){
            manualInvoice.assertEmptyStateBiayaTambahan();
        } else if (invType.equalsIgnoreCase("Biaya Sewa")) {
            manualInvoice.assertEmptyStateBiayaSewa();
        }
    }

    @When("the admin creates Invoice Manual {string} and input all fields {string}, {string}, {string}, {string}, {string}, {string}")
    public void the_admin_creates_Invoice_Manual_and_input_all_fields(String invType, String nama, String lainnya, String awal, String akhir, String durasi, String jml){
        admin.NavigateToMamipayMenu("Invoice Manual");
        manualInvoice.clickBuatInvoice();

        if (invType.equalsIgnoreCase("Biaya Tambahan")){
            manualInvoice.clickJenisBiayaTambahan();
        } else if (invType.equalsIgnoreCase("Biaya Sewa")){
            manualInvoice.clickJenisBiayaSewa();
        }

        manualInvoice.clickTambah();

        manualInvoice.setNamaBiayaInvoiceManual(nama);
        if (!(lainnya.equalsIgnoreCase("-"))) {
            manualInvoice.setLainnyaInvoiceManual(lainnya);
        }
        if (!(awal.equalsIgnoreCase("-"))){
            manualInvoice.setPeriodeAwalInvoiceManual(awal);
        }
        if (!(akhir.equalsIgnoreCase("-"))){
            manualInvoice.setPeriodeAkhirInvoiceManual(akhir);
        }
        if (!(durasi.equalsIgnoreCase("-"))){
            manualInvoice.setDurasiBiayaInvoiceManual(durasi);
        }
        manualInvoice.setJumlahBiayaInvoiceManual(jml);

        manualInvoice.clickTambahSubmitInPopUp();
    }

    @Then("{string}, {string}, {string}, {string}, {string} are displayed in the biaya tambahan table")
    public void are_displayed_in_the_biaya_tambahan_table(String nama, String awal, String akhir, String jml, String disburse){
        manualInvoice.assertNamaBiayaOnTable(nama);
        manualInvoice.assertAwalPeriodOnTable();
        manualInvoice.assertAkhirPeriodOnTable();
        manualInvoice.assertJumlahBiayaOnTable(jml);
        manualInvoice.assertDisburseToPemilikOnTable(disburse);
    }

    @When("admin creates multiple Invoice Manual {string}")
    public void admin_creates_multiple_invoice_manual(String invType, DataTable tables){
        String namaBiaya = "", lainnya = "", periodeAwal = "", periodeAkhir = "", durasiBiaya = "", jumlahBiaya = "";

        detailBiaya = tables.asMaps(String.class, String.class);

        admin.NavigateToMamipayMenu("Invoice Manual");
        manualInvoice.clickBuatInvoice();

        if (invType.equalsIgnoreCase("Biaya Tambahan")){
            manualInvoice.clickJenisBiayaTambahan();
            for (int i=0; i<4; i++){
                manualInvoice.clickTambah();
                namaBiaya = detailBiaya.get(i).get("Nama Biaya");
                manualInvoice.setNamaBiayaInvoiceManual(namaBiaya);

                lainnya = detailBiaya.get(i).get("Lainnya");
                if (!(lainnya.equalsIgnoreCase("-"))){
                    manualInvoice.setLainnyaInvoiceManual(lainnya);
                }

                periodeAwal = detailBiaya.get(i).get("Periode Awal");
                if (!(periodeAwal.equalsIgnoreCase("-"))){
                    manualInvoice.setPeriodeAwalInvoiceManual(periodeAwal);
                }

                periodeAkhir = detailBiaya.get(i).get("Periode Akhir");
                if (!(periodeAkhir.equalsIgnoreCase("-"))){
                    manualInvoice.setPeriodeAkhirInvoiceManual(periodeAkhir);
                }

                durasiBiaya = detailBiaya.get(i).get("Durasi Biaya");
                jumlahBiaya = detailBiaya.get(i).get("Jumlah Biaya");
                manualInvoice.setDurasiBiayaInvoiceManual(durasiBiaya);
                manualInvoice.setJumlahBiayaInvoiceManual(jumlahBiaya);
                manualInvoice.clickTambahSubmitInPopUp();
            }
        } else if (invType.equalsIgnoreCase("Biaya Sewa")) {
            manualInvoice.clickJenisBiayaSewa();
            for (int i=0; i<4; i++){
                manualInvoice.clickTambah();
                namaBiaya = detailBiaya.get(i).get("Nama Biaya");
                manualInvoice.setNamaBiayaInvoiceManual(namaBiaya);

                lainnya = detailBiaya.get(i).get("Lainnya");
                if (!(lainnya.equalsIgnoreCase("-"))){
                    manualInvoice.setLainnyaInvoiceManual(lainnya);
                }

                periodeAwal = detailBiaya.get(i).get("Periode Awal");
                if (!(periodeAwal.equalsIgnoreCase("-"))){
                    manualInvoice.setPeriodeAwalInvoiceManual(periodeAwal);
                }

                periodeAkhir = detailBiaya.get(i).get("Periode Akhir");
                if (!(periodeAkhir.equalsIgnoreCase("-"))){
                    manualInvoice.setPeriodeAkhirInvoiceManual(periodeAkhir);
                }

                durasiBiaya = detailBiaya.get(i).get("Durasi Biaya");
                jumlahBiaya = detailBiaya.get(i).get("Jumlah Biaya");
                manualInvoice.setDurasiBiayaInvoiceManual(durasiBiaya);
                manualInvoice.setJumlahBiayaInvoiceManual(jumlahBiaya);
                manualInvoice.clickTambahSubmitInPopUp();
            }
        }
    }

    @Then("{string} Invoice Manual are displayed on table")
    public void Invoice_Manual_are_displayed_on_table(String invType, DataTable tables){
        String namaBiayaTable = "";
        Integer row = 0;

        detailBiaya = tables.asMaps(String.class, String.class);

        if (invType.equalsIgnoreCase("Biaya Tambahan")){
            for (int i=0; i<4; i++){
                namaBiayaTable = detailBiaya.get(i).get("Nama Biaya on Table");
                manualInvoice.assertNamaBiayaTableList(namaBiayaTable);
                manualInvoice.assertNamaBiayaInRow(row);
            }
        } else if (invType.equalsIgnoreCase("Biaya Sewa")) {
            for (int i=0; i<4; i++){
                namaBiayaTable = detailBiaya.get(i).get("Nama Biaya on Table");
                manualInvoice.assertNamaBiayaTableList(namaBiayaTable);
                manualInvoice.assertNamaBiayaInRow(row);
            }
        }
    }

    @When("admin deletes all {string} or sewa on Invoice Manual")
    public void admin_deletes_all_or_sewa_on_Invoice_Manual(String invType){
        if (invType.equalsIgnoreCase("Biaya Tambahan")){
            manualInvoice.deleteAllBiaya();
        } else if (invType.equalsIgnoreCase("Biaya Sewa")) {
            manualInvoice.deleteAllBiaya();
        }
    }

    @Then("the empty state of {string} is displayed")
    public void the_empty_state_of_is_displayed(String invType){
        if (invType.equalsIgnoreCase("Biaya Tambahan")){
            manualInvoice.assertEmptyStateBiayaTambahan();
        } else if (invType.equalsIgnoreCase("Biaya Sewa")) {
            manualInvoice.assertEmptyStateBiayaSewa();
        }
    }

    @When("admin edits Invoice Manual {string} and checks them on the table")
    public void admin_edits_Invoice_Manual_and_checks_them_on_the_table(String invType, DataTable tables){
        String namaBiaya = "", periodeAwal = "", periodeAkhir = "", durasiBiaya = "", jumlahBiaya = "";
        String namaBiayaTable = "", jumlahBiayaTable = "", disburseToPemilik = "";

        detailBiaya = tables.asMaps(String.class, String.class);

        manualInvoice.clickEditInvoice();

        if (invType.equalsIgnoreCase("Biaya Tambahan")){
            namaBiaya = detailBiaya.get(0).get("Nama Biaya");

            periodeAwal = detailBiaya.get(0).get("Periode Awal");
            if (!(periodeAwal.equalsIgnoreCase("-"))){
                manualInvoice.setPeriodeAwalInvoiceManual(periodeAwal);
            }

            periodeAkhir = detailBiaya.get(0).get("Periode Akhir");
            if (!(periodeAkhir.equalsIgnoreCase("-"))){
                manualInvoice.setPeriodeAkhirInvoiceManual(periodeAkhir);
            }

            durasiBiaya = detailBiaya.get(0).get("Durasi Biaya");
            jumlahBiaya = detailBiaya.get(0).get("Jumlah Biaya");
            namaBiayaTable = detailBiaya.get(0).get("Nama Biaya on Table");
            jumlahBiayaTable = detailBiaya.get(0).get("Jumlah Biaya on Table");
            disburseToPemilik = detailBiaya.get(0).get("Disburse to Pemilik");
        } else if (invType.equalsIgnoreCase("Biaya Sewa")){
            namaBiaya = detailBiaya.get(0).get("Nama Biaya");

            periodeAwal = detailBiaya.get(0).get("Periode Awal");
            if (!(periodeAwal.equalsIgnoreCase("-"))){
                manualInvoice.setPeriodeAwalInvoiceManual(periodeAwal);
            }

            periodeAkhir = detailBiaya.get(0).get("Periode Akhir");
            if (!(periodeAkhir.equalsIgnoreCase("-"))){
                manualInvoice.setPeriodeAkhirInvoiceManual(periodeAkhir);
            }

            durasiBiaya = detailBiaya.get(0).get("Durasi Biaya");
            jumlahBiaya = detailBiaya.get(0).get("Jumlah Biaya");
            namaBiayaTable = detailBiaya.get(0).get("Nama Biaya on Table");
            jumlahBiayaTable = detailBiaya.get(0).get("Jumlah Biaya on Table");
        }

        manualInvoice.setEditNamaBiayaInvoiceManual(namaBiaya);
        manualInvoice.setDurasiBiayaInvoiceManual(durasiBiaya);
        manualInvoice.setJumlahBiayaInvoiceManual(jumlahBiaya);
        manualInvoice.clickTambahSubmitInPopUp();

        manualInvoice.assertNamaBiayaOnTable(namaBiayaTable);
        manualInvoice.assertAwalPeriodOnTable();
        manualInvoice.assertAkhirPeriodOnTable();
        manualInvoice.assertJumlahBiayaOnTable(jumlahBiayaTable);
        manualInvoice.assertDisburseToPemilikOnTable(disburseToPemilik);
    }

    @When("admin edits Invoice Manual {string} into Lainnya and checks them on the table")
    public void admin_edits_Invoice_Manual_into_Lainnya_and_checks_them_on_the_table(String invType, DataTable tables){
        String namaBiaya = "", lainnya = "", periodeAwal = "", periodeAkhir = "", jumlahBiaya = "";
        String namaBiayaTable = "", jumlahBiayaTable = "", disburseToPemilik = "";

        detailBiaya = tables.asMaps(String.class, String.class);

        manualInvoice.clickEditInvoice();

        if (invType.equalsIgnoreCase("Biaya Tambahan")){
            namaBiaya = detailBiaya.get(0).get("Nama Biaya");
            manualInvoice.setEditNamaBiayaInvoiceManual(namaBiaya);

            lainnya = detailBiaya.get(0).get("Lainnya");
            manualInvoice.setLainnyaInvoiceManual(lainnya);

            jumlahBiaya = detailBiaya.get(0).get("Jumlah Biaya");
            namaBiayaTable = detailBiaya.get(0).get("Nama Biaya on Table");
            jumlahBiayaTable = detailBiaya.get(0).get("Jumlah Biaya on Table");
            disburseToPemilik = detailBiaya.get(0).get("Disburse to Pemilik");
        } else if (invType.equalsIgnoreCase("Biaya Sewa")){
            namaBiaya = detailBiaya.get(0).get("Nama Biaya");
            manualInvoice.setEditNamaBiayaInvoiceManual(namaBiaya);

            lainnya = detailBiaya.get(0).get("Lainnya");
            manualInvoice.setLainnyaInvoiceManual(lainnya);

            periodeAwal = detailBiaya.get(0).get("Periode Awal");
            if (!(periodeAwal.equalsIgnoreCase("-"))){
                manualInvoice.setPeriodeAwalInvoiceManual(periodeAwal);
            }

            periodeAkhir = detailBiaya.get(0).get("Periode Akhir");
            if (!(periodeAkhir.equalsIgnoreCase("-"))){
                manualInvoice.setPeriodeAkhirInvoiceManual(periodeAkhir);
            }

            jumlahBiaya = detailBiaya.get(0).get("Jumlah Biaya");
            namaBiayaTable = detailBiaya.get(0).get("Nama Biaya on Table");
            jumlahBiayaTable = detailBiaya.get(0).get("Jumlah Biaya on Table");
        }

        manualInvoice.clearDurasiBiayaInvoiceManual();
        manualInvoice.setJumlahBiayaInvoiceManual(jumlahBiaya);
        manualInvoice.clickTambahSubmitInPopUp();

        manualInvoice.assertNamaBiayaOnTable(namaBiayaTable);
        manualInvoice.assertAwalPeriodOnTable();
        manualInvoice.assertAkhirPeriodOnTable();
        manualInvoice.assertJumlahBiayaOnTable(jumlahBiayaTable);
        manualInvoice.assertDisburseToPemilikOnTable(disburseToPemilik);
    }

    @When("the admin creates Invoice Manual {string} Lainnya")
    public void the_admin_creates_Invoice_Manual_and_input_Lainnya_field(String invType){
        admin.NavigateToMamipayMenu("Invoice Manual");
        manualInvoice.clickBuatInvoice();

        if (invType.equalsIgnoreCase("Biaya Tambahan")){
            manualInvoice.clickJenisBiayaTambahan();
        } else if (invType.equalsIgnoreCase("Biaya Sewa")){
            manualInvoice.clickJenisBiayaSewa();
        }

        manualInvoice.clickTambah();

        manualInvoice.setNamaBiayaLainnyaInvoiceManual();
    }

    @Then("error message {string} appear if user input Lainnya field :")
    public void error_message_appear_if_user_input_lainnya_field(String error, List<String> keywordLainnya) {
        for(String keyword: keywordLainnya){
            manualInvoice.setLainnyaInvoiceManual(keyword);
            manualInvoice.assertErrMsgLainnya(error);
            manualInvoice.clearLainnyaField();
        }
    }
    //---End of Biaya Tambahan Pop Up---//

    //---Biaya Sewa---//
    @Then("{string}, {string}, {string}, {string} are displayed in the biaya sewa table")
    public void are_displayed_in_the_biaya_sewa_table(String nama, String awal, String akhir, String jml){
        manualInvoice.assertNamaBiayaOnTable(nama);
        manualInvoice.assertAwalPeriodOnTable();
        manualInvoice.assertAkhirPeriodOnTable();
        manualInvoice.assertJumlahBiayaOnTable(jml);
    }

    @When("the admin fills all fields in Tambah Biaya Sewa pop up")
    public void the_admin_fills_all_fields_in_Tambah_Biaya_Sewa_pop_up(DataTable tables){
        String durasiBiaya = "";
        String jumlahBiaya = "";

        fillFields = tables.asMaps(String.class, String.class);

        if (Mamikos.ENV.equalsIgnoreCase("stag")){
            durasiBiaya = fillFields.get(0).get("Durasi Biaya");
            jumlahBiaya = fillFields.get(0).get("Jumlah Biaya");
        } else if (Mamikos.ENV.equalsIgnoreCase("prod")) {
            durasiBiaya = fillFields.get(1).get("Durasi Biaya");
            jumlahBiaya = fillFields.get(1).get("Jumlah Biaya");
        }

        manualInvoice.setDurasiBiayaInvoiceManual(durasiBiaya);
        manualInvoice.setJumlahBiayaInvoiceManual(jumlahBiaya);
    }
    //---End of Biaya Sewa---//

    //---Filter Invoice Manual---//
    @When("admin clicks Filter in Invoice Manual")
    public void admin_clicks_Filter_in_Invoice_Manual(){
        manualInvoice.clicksFilter();
        manualInvoice.assertFilterTitleNSubtitle();
        manualInvoice.assertStatusInvTitle(statusInvTitle);
        manualInvoice.assertJenisBiaya(jenisBiayaTitle);
        manualInvoice.assertTanggalInvoiceDibuat(tglInvDibuat);
        manualInvoice.assertTanggalMulaiTitle(tglMulaiTitle);
        manualInvoice.assertTanggalAkhirTitle(tglAkhirTitle);
    }

    @When("admin clicks {string} button on Filter")
    public void admin_clicks_button_on_Filter(String btn){
        if (btn.equalsIgnoreCase("Terapkan")){
            manualInvoice.clicksTerapkan();
        } else if (btn.equalsIgnoreCase("Reset")) {
            manualInvoice.clicksFilter();
            manualInvoice.clicksReset();
        } else if (btn.equalsIgnoreCase("Main Reset")) {
            manualInvoice.clicksMainReset();
            manualInvoice.counterOnFilterIsHidden();
        }
    }

    @Then("{string} Status Invoice is displayed")
    public void Status_Invoice_is_displayed(String result){
        manualInvoice.assertValueStatusInv(result);
    }

    @Then("the counter on filter is disappears")
    public void the_counter_on_filter_is_disappears(){
        manualInvoice.counterOnFilterIsHidden();
    }

    @When("admin ticks {string} on the {string} dropdown")
    public void admin_ticks_on_the_dropdown(String value, String dropdown){
        if (dropdown.equalsIgnoreCase("Status Invoice")){
            manualInvoice.ticksStatusInvoice(value);
        } else if (dropdown.equalsIgnoreCase("Jenis Biaya")) {
            if (value.equalsIgnoreCase("Biaya Tambahan")){
                manualInvoice.tickJenisBiayaTambahan(value);
            } else if (value.equalsIgnoreCase("Biaya Sewa")) {
                manualInvoice.tickJenisBiayaSewa(value);
            }
        }
    }

    @Then("{string} Jenis Biaya is displayed")
    public void Jenis_Biaya_is_displayed(String result){
        manualInvoice.assertValueJenisBiaya(result);
    }

    @When("admin refresh page and clicks Filter in Invoice Manual")
    public void admin_refresh_page_and_clicks_Filter_in_Invoice_Manual(){
        //refresh page first, to check default Unpaid filter
        manualInvoice.refreshPageInvoiceManual();
        manualInvoice.clicksFilter();
        manualInvoice.clicksCloseOnFilter();
    }

    @When("admin selects the date for {string}")
    public void admin_selects_the_date_for(String date){
        if (date.equalsIgnoreCase("today")){
            manualInvoice.clickCalViewOnTglMulai();
            manualInvoice.setTanggalMulai(date);
        } else if (date.equalsIgnoreCase("tomorrow")) {
            manualInvoice.clickCalViewOnTglAkhir();
            manualInvoice.setTanggalAkhir(date);
            manualInvoice.clicksTerapkan();
        }
    }

    @When("admin selects the date for {string} with clicks Terapkan")
    public void admin_selects_the_date_for_with_clicks_Terapkan(String date){
        manualInvoice.clickCalViewOnTglMulai();
        manualInvoice.setTanggalMulai(date);
        manualInvoice.clicksTerapkan();
    }

    @Then("the Tanggal Invoice Dibuat {string} is displayed according to the filter")
    public void the_Tanggal_Invoice_Dibuat_is_displayed_according_to_the_filter(String result){
        if (result.equalsIgnoreCase("today")){
            SimpleDateFormat today = new SimpleDateFormat("dd/MM/yyyy");
            Date day = new Date();
            String expectedDate = today.format(day);
            manualInvoice.assertDibuatOleh(expectedDate);
        }
    }

    @Then("the {string}, {string}, {string}, {string} are displayed according to the search and filter")
    public void are_displayed_according_to_the_search_and_filter(String result1, String result2, String result3, String result4){
        manualInvoice.assertNamaListing(result1);
        manualInvoice.assertValueStatusInv(result2);
        manualInvoice.assertValueJenisBiaya(result3);
        if (result4.equalsIgnoreCase("today")){
            SimpleDateFormat today = new SimpleDateFormat("dd/MM/yyyy");
            Date day = new Date();
            String expectedDate = today.format(day);
            manualInvoice.assertDibuatOleh(expectedDate);
        }
    }

    @When("admin ticks {string} on the {string} dropdown without clicks Terapkan")
    public void admin_ticks_on_the_dropdown_without_clicks_Terapkan(String value, String dropdown){
        if (dropdown.equalsIgnoreCase("Status Invoice")){
            manualInvoice.ticksStatusInvoiceWithoutClicksTerapkan(value);
        } else if (dropdown.equalsIgnoreCase("Jenis Biaya")) {
            if (value.equalsIgnoreCase("Biaya Tambahan")){
                manualInvoice.tickJenisBiayaTambahanWithoutClicksTerapkan(value);
            } else if (value.equalsIgnoreCase("Biaya Sewa")) {
                manualInvoice.tickJenisBiayaSewaWithoutClicksTerapkan(value);
            }
        }
    }
    //---End of Filter Invoice Manual---//
}
