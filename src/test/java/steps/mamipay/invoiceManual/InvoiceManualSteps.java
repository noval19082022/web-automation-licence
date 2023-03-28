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

    private List<Map<String, String>> tenantInfo;
    private List<Map<String, String>> tenantDetail;
    private List<Map<String, String>> detailBiaya;
    private List<Map<String, String>> rincianBiaya;
    private List<Map<String, String>> invoiceData;
    private List<Map<String, String>> hoverData;
    @When("admin input nama penyewa in buat invoice manual")
    public void admin_input_nama_penyewa_in_buat_invoice_manual(DataTable tables) {
        String listing = "";
        String tenant = "";

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
        manualInvoice.closePopUpBuatDanKirim();
        manualInvoice.assertPopUpBuatdanKirimClosed();
        //check kembali button
        manualInvoice.previewBuatdanKirimInvoiceManual();
        manualInvoice.kembaliPopupBuatDanKirim();
        manualInvoice.assertPopUpBuatdanKirimClosed();
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

    //---Biaya Tambahan---//
    @When("the user selects {string} in the Biaya Tambahan")
    public void the_user_selects_in_the_Biaya_Tambahan(String biaya){
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
}
