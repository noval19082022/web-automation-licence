package steps.mamipay.invoiceManual;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.admin.mamipay.AdminMamipayDashboardPO;
import pageobject.admin.mamipay.invoiceManual.InvoiceManualPO;
import utilities.PlaywrightHelpers;

import java.util.List;
import java.util.Map;

public class InvoiceManualSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    private AdminMamipayDashboardPO admin = new AdminMamipayDashboardPO(page);
    private InvoiceManualPO manualInvoice = new InvoiceManualPO(page);

    private String listing;
    private String tenant;
    private List<Map<String, String>> tenantInfo;
    private List<Map<String, String>> tenantDetail;
    private List<Map<String, String>> detailBiaya;
    private List<Map<String, String>> rincianBiaya;
    private List<Map<String, String>> invoiceData;
    private List<Map<String, String>> hoverData;

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
        String namaBiaya = "",periodeAwal = "",periodeAkhir = "",durasiBiaya = "",jumlahBiaya = "";

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
        manualInvoice.setDurasiBiayaInvoiceManual(durasiBiaya);
        manualInvoice.setJumlahBiayaInvoiceManual(jumlahBiaya);
        manualInvoice.submitBiayaInvoiceManual(type);
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
            namaBiaya = rincianBiaya.get(1).get("Nama Biaya");
            periodeAwal = rincianBiaya.get(1).get("Awal");
            periodeAkhir = rincianBiaya.get(1).get("Akhir");
            jumlahBiaya = rincianBiaya.get(1).get("Jumlah Biaya");
            disburseToPenmilik = rincianBiaya.get(1).get("Disburse to Pemilik");
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
            namaListing = invoiceData.get(1).get("Nama Listing");
            jumlahBiaya = invoiceData.get(1).get("Jumlah Biaya");
            statusInvoice = invoiceData.get(1).get("Status Invoice");
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
            namaBiaya = hoverData.get(1).get("Nama Biaya");
            jumlahBiaya = hoverData.get(1).get("Jumlah Biaya");
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
        manualInvoice.clickBuatInvoice();
        manualInvoice.inputListingName(listing);
        manualInvoice.inputTenantName(tenant);
    }
    //---Biaya Tambahan---//

    //---Biaya Tambahan Pop Up---//
    @When("the admin selects {string} in the Biaya Tambahan")
    public void the_admin_selects_in_the_Biaya_Tambahan(String biaya){
        admin.NavigateToMamipayMenu("Invoice Manual");
        manualInvoice.clickBuatInvoice();
        manualInvoice.clickJenisBiayaTambahan();
        manualInvoice.clickTambah();
        manualInvoice.setNamaBiayaInvoiceManual(biaya);
    }

    @Then("the Periode Awal and Periode Akhir are disable")
    public void the_Periode_Awal_and_Periode_Akhir_are_disable(){
        manualInvoice.assertPeriodDate();
    }

    @When("the admin fill all fields in Tambah Biaya Tambahan pop up")
    public void the_admin_fill_all_fields_in_Tambah_Biaya_Tambahan_pop_up(DataTable tables){
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

    @When("the admin click {string} modal tambah biaya")
    public void the_admin_click_modal_tambah_biaya(String button){
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

    @When("the admin create Invoice Manual {string} and check required fields {string}, {string}, {string}, {string}, {string}")
    public void the_admin_create_Invoice_Manual_and_check_required_fields(String invType, String nama, String awal, String akhir, String durasi, String jml){
        admin.NavigateToMamipayMenu("Invoice Manual");
        manualInvoice.clickBuatInvoice();

        if (invType.equalsIgnoreCase("Biaya Tambahan")){
            manualInvoice.clickJenisBiayaTambahan();
        } else if (invType.equalsIgnoreCase("Biaya Sewa")){
            manualInvoice.clickJenisBiayaSewa();
        }

        manualInvoice.clickTambah();

        if (!(nama.equalsIgnoreCase("-"))) {
            manualInvoice.setNamaBiayaInvoiceManual(nama);
        } else if (!(awal.equalsIgnoreCase("-"))) {
            manualInvoice.setPeriodeAwalInvoiceManual(awal);
        } else if (!(akhir.equalsIgnoreCase("-"))) {
            manualInvoice.setPeriodeAkhirInvoiceManual(akhir);
        } else if (!(durasi.equalsIgnoreCase("-"))) {
            manualInvoice.setDurasiBiayaInvoiceManual(durasi);
        } else if (!(jml.equalsIgnoreCase("-"))) {
            manualInvoice.setJumlahBiayaInvoiceManual(jml);
        }

        manualInvoice.clickTambahSubmitInPopUp();
    }

    @Then("the error messages {string}, {string}, {string}, {string} are displayed")
    public void the_error_messages_are_displayed(String namaErrMsg, String awalErrMsg, String akhirErrMsg, String jmlErrMsg){
        if (!(namaErrMsg.equalsIgnoreCase("-"))){
            manualInvoice.assertNamaBiayaErrMsg();
        } else if (!(awalErrMsg.equalsIgnoreCase("-"))) {
            manualInvoice.assertPeriodeAwalErrMsg();
        } else if (!(akhirErrMsg.equalsIgnoreCase("-"))) {
            manualInvoice.assertPeriodeAkhirErrMsg();
        } else if (!(jmlErrMsg.equalsIgnoreCase("-"))) {
            manualInvoice.assertJumlahBiayaErrMsg();
        }
    }

    @When("admin create Invoice Manual {string}")
    public void admin_create_Invoice_Manual(String invType, DataTable tables){
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

    @When("the admin delete Invoice Manual")
    public void the_admin_delete_Invoice_Manual(){
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
    //---End of Biaya Tambahan Pop Up---//
}
