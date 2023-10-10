package steps.mamipay.cpdisbursement;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.admin.mamipay.cpdisbursement.CpDisbursementPO;
import utilities.PlaywrightHelpers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class CpDisbursementSteps {
    Page page = ActiveContext.getActivePage();
    CpDisbursementPO cpdisbursement = new CpDisbursementPO(page);

    private List<Map<String, String>> transferInfo;
    private List<Map<String, String>> transferAmount;
    private List<Map<String, String>> dataTransfer;

    @When("admin open menu CP Disbursement")
    public void admin_open_menu_cp_disbursement() {
        cpdisbursement.openMenuCpDisbursement();
    }
    @When("admin tambah data transfer")
    public void admin_tambah_data_transfer() {
        cpdisbursement.tambahDataTransfer();
    }
    @When("admin search property {string} in tambah data transfer")
    public void admin_search_property(String keyword) {
        cpdisbursement.searchProperty(keyword);
    }
    @Then("error message {string} should occur in nama property field")
    public void error_message_should_occur_in_nama_property_field(String error) {
        Assert.assertEquals(cpdisbursement.getNamaPropertyErrorMessage(),error);
    }
    @When("admin select suggestion {string}")
    public void admin_select_suggestion(String property) {
        cpdisbursement.choosePropertySuggestion(property);
    }
    @Then("transfer information should auto fill")
    public void transfer_information_should_auto_fill(DataTable tables) {
        transferInfo = tables.asMaps(String.class, String.class);

        String product = transferInfo.get(0).get("Product Type");
        String bank = transferInfo.get(0).get("Bank");
        String norek = transferInfo.get(0).get("Nomor Rekening");
        String name = transferInfo.get(0).get("Nama Pemilik Rekening");
        String nohp = transferInfo.get(0).get("Nomor Telepon Pemilik");

        Assert.assertEquals(cpdisbursement.getProductType(),product);
        Assert.assertEquals(cpdisbursement.getBank(),bank);
        Assert.assertEquals(cpdisbursement.getNoRekening(),norek);
        Assert.assertEquals(cpdisbursement.getNamaPemilikRekening(),name);
        Assert.assertEquals(cpdisbursement.getNoTelponPemilik(),nohp);
    }
    @When("admin fill remaining field")
    public void admin_fill_remaining_field(DataTable tables) {
        transferAmount = tables.asMaps(String.class, String.class);

        String total = transferAmount.get(0).get("Total Pendapatan");
        String tipe = transferAmount.get(0).get("Tipe Transaksi");
        String tanggal = transferAmount.get(0).get("Tanggal Transfer");
        String pdf = transferAmount.get(0).get("Berkas Laporan");
        String disbursement = transferAmount.get(0).get("Tipe Disbursement");

        cpdisbursement.setTotalPendapatan(total);
        cpdisbursement.setTipeTransaksi(tipe);
        cpdisbursement.setTanggalTransferPemilik(tanggal);
        cpdisbursement.uploadBerkasLaporan(pdf);
        cpdisbursement.setTipeDisbursement(disbursement);
    }
    @When("admin close pop up tambah data transfer")
    public void admin_close_pop_up_tambah_data_transfer() {
        cpdisbursement.closeTambahDataTransferPopUp();
    }
    @Then("all information should be keep")
    public void all_information_should_be_keep(DataTable tables) {
        transferInfo = tables.asMaps(String.class, String.class);
        SimpleDateFormat today = new SimpleDateFormat("yyyy-M-dd");
        Date dates = new Date();

        String property = transferInfo.get(0).get("Nama Property");
        String product = transferInfo.get(0).get("Product Type");
        String bank = transferInfo.get(0).get("Bank");
        String norek = transferInfo.get(0).get("Nomor Rekening");
        String name = transferInfo.get(0).get("Nama Pemilik Rekening");
        String nohp = transferInfo.get(0).get("Nomor Telepon Pemilik");
        String total = transferInfo.get(0).get("Total Pendapatan");
        String tipe = transferInfo.get(0).get("Tipe Transaksi");
        String tanggal = transferInfo.get(0).get("Tanggal Transfer");
        String pdf = transferInfo.get(0).get("Berkas Laporan");
        String disbursement = transferInfo.get(0).get("Tipe Disbursement");

        Assert.assertEquals(cpdisbursement.getPropertyName(),property);
        Assert.assertEquals(cpdisbursement.getProductType(),product);
        Assert.assertEquals(cpdisbursement.getBank(),bank);
        Assert.assertEquals(cpdisbursement.getNoRekening(),norek);
        Assert.assertEquals(cpdisbursement.getNamaPemilikRekening(),name);
        Assert.assertEquals(cpdisbursement.getNoTelponPemilik(),nohp);
        Assert.assertEquals(cpdisbursement.getTotalPendapatan(),total);
        Assert.assertEquals(cpdisbursement.getTipeTransaksi(),tipe);
        if (tanggal.equalsIgnoreCase("today")){
            Assert.assertEquals(cpdisbursement.getTanggalTransfer(),today.format(dates));
        } else {
            Assert.assertEquals(cpdisbursement.getTanggalTransfer(),tanggal);
        }
        Assert.assertEquals(cpdisbursement.getBerkasLaporan(),pdf);
        if (disbursement.equalsIgnoreCase("Disbursement utama")){
            disbursement = "main";
        } else if (disbursement.equalsIgnoreCase("Disbursement susulan")) {
            disbursement = "followup";
        }
        Assert.assertEquals(cpdisbursement.getDisbursementType(),disbursement);

    }
    @When("admin select tipe transaksi lainnya {string}")
    public void admin_select_tipe_transaksi_lainnya(String type) {
        if (type.equalsIgnoreCase(">50 characters")){
            type = "Lorem Ipsum is simply dummy text of the printing and typesetting";
        }

        cpdisbursement.setTipeTransaksi("Lainnya");
        cpdisbursement.setLainnyaTransaksi(type);
    }
    @Then("admin only can input transaksi lainnya using only 50 characters")
    public void admin_only_can_input_transaksi_lainnya_using_only_characters() {
        Assert.assertEquals(cpdisbursement.getTipeTransaksiLainnya(),"Lorem Ipsum is simply dummy text of the printing a");
    }
    @When("admin submit tambah data transfer")
    public void admin_submit_tambah_data_transfer() {
        cpdisbursement.submitTambahDataTransfer();
    }
    @Then("new cp disbursement data should add in daftar transfer")
    public void new_cp_disbursement_data_should_add_in_daftar_transfer(DataTable tables) {
        dataTransfer = tables.asMaps(String.class, String.class);

        String tanggal = dataTransfer.get(0).get("Tanggal Transfer ke Pemilik");
        String property = dataTransfer.get(0).get("Nama Property");
        String tipe = dataTransfer.get(0).get("Tipe Transaksi");
        String total = dataTransfer.get(0).get("Total Pendapatan");
        String rekening = dataTransfer.get(0).get("Detail Rekening");

        Assert.assertEquals(cpdisbursement.getTanggalTransferList(),tanggal);
        Assert.assertEquals(cpdisbursement.getPropertyNameList(),property);
        Assert.assertEquals(cpdisbursement.getTipeTransaksiList(),tipe);
        Assert.assertEquals(cpdisbursement.getTotalPendapatanList(),total);

        String[] detailRekeningActual = cpdisbursement.getDetailRekeningList().split("\\R ");
        String[] detailRekeningExpected = rekening.split(" ");

        Assert.assertEquals(detailRekeningActual[0],detailRekeningExpected[0].concat(" "+detailRekeningExpected[1]));
        Assert.assertEquals(detailRekeningActual[2].trim(),detailRekeningExpected[2]);
        Assert.assertEquals(detailRekeningActual[4].trim(),detailRekeningExpected[3]);
    }
}
