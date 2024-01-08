package steps.mamipay.cpdisbursement;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.admin.mamipay.cpdisbursement.CpDisbursementPO;
import utilities.JavaHelpers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class CpDisbursementSteps {
    Page page = ActiveContext.getActivePage();
    CpDisbursementPO cpdisbursement = new CpDisbursementPO(page);

    //---Test Data---//
    private String CPDisbursement = "src/test/resources/testdata/mamipay/cpDisbursement.properties";
    private String propertyNameEdit = JavaHelpers.getPropertyValue(CPDisbursement, "propertyNameEdit");
    private String tipeTransaksiEdit = JavaHelpers.getPropertyValue(CPDisbursement, "tipeTransaksiEdit");
    private String totalPendapatanRpEdit = JavaHelpers.getPropertyValue(CPDisbursement, "totalPendapatanRpEdit");
    private String propertyName = JavaHelpers.getPropertyValue(CPDisbursement, "propertyName");
    private String tipeTransaksi = JavaHelpers.getPropertyValue(CPDisbursement, "tipeTransaksi");
    private String totalPendapatanRp = JavaHelpers.getPropertyValue(CPDisbursement, "totalPendapatanRp");
    private String pemilikRekening = JavaHelpers.getPropertyValue(CPDisbursement, "pemilikRekening");
    private String errorMessageOnNomorRekening = JavaHelpers.getPropertyValue(CPDisbursement, "errorMessageOnNomorRekening");
    private String errorMessageOnTotalPendapatan = JavaHelpers.getPropertyValue(CPDisbursement, "errorMessageOnTotalPendapatan");
    private String errorMessageOnNamaPemilikRekening = JavaHelpers.getPropertyValue(CPDisbursement, "errorMessageOnNamaPemilikRekening");

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
        SimpleDateFormat today = new SimpleDateFormat("yyyy-MM-dd");
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
    @When("admin search cp disbursement by {string} using keyword {string}")
    public void admin_search_cp_disbursement_by_using_keyword(String searchBy, String keyword) {
        cpdisbursement.searchDaftarTransfer(searchBy,keyword);
    }
    @Then("show {string} empty page")
    public void show_empty_page(String tab) {
        switch (tab){
            case "Daftar Transfer":
                Assert.assertEquals(cpdisbursement.getEmptyPageMessageTitle(),"Belum Ada Data Transfer");
                Assert.assertEquals(cpdisbursement.getEmptyPageMessageDescription(),"Silakan tambah data transfer terlebih dahulu.");
                break;
            case "Transfer Diproses":
                Assert.assertEquals(cpdisbursement.getEmptyPageMessageTitle(),"Silakan proses transfer pendapatan terlebih dahulu.");
                Assert.assertEquals(cpdisbursement.getEmptyPageMessageDescription(),"Silakan proses transfer pendapatan terlebih dahulu.");
                break;
            case "Transfer Gagal":
                Assert.assertEquals(cpdisbursement.getEmptyPageMessageTitle(),"Belum Ada Transfer Gagal");
                Assert.assertEquals(cpdisbursement.getEmptyPageMessageDescription(),"Data transfer pendapatan yang gagal akan tampil di sini.");
                break;
            default:
                System.out.println("Invalid Tab name");
        }
    }
    @Then("show all disbursement from property name {string}")
    public void show_all_disbursement_from_property_name(String property) {
        for (int i=0;i<cpdisbursement.countRow();i++) {
            Assert.assertEquals(cpdisbursement.getPropertyNameList(i),property);
        }
    }
    @Then("show all disbursement from account name {string}")
    public void show_all_disbursement_from_account_name(String accountName) {
        for (int i=0;i<cpdisbursement.countRow();i++) {
            String[] detailRekeningActual = cpdisbursement.getDetailRekeningList(i).split("\\R ");

            Assert.assertEquals(detailRekeningActual[0],accountName);
        }
    }
    @Then("show all disbursement from account number {string}")
    public void show_all_disbursement_from_account_number(String accountNo) {
        for (int i=0;i<cpdisbursement.countRow();i++) {
            String[] detailRekeningActual = cpdisbursement.getDetailRekeningList(i).split("\\R ");

            Assert.assertEquals(detailRekeningActual[2].trim(),accountNo);
        }
    }
    @When("admin open {string} tab")
    public void admin_open_tab(String tab) {
        cpdisbursement.openCPDisbursementTab(tab);
    }
    @When("admin reset filter cp disbursement")
    public void admin_reset_filter_cp_disbursement() {
        cpdisbursement.resetFilter();
    }
    @When("admin search cp dibursement by transfer status {string}")
    public void admin_search_cp_dibursement_by_transfer_status(String status) {
        cpdisbursement.filterCpDisbursementByStatusTransfer(status);
    }
    @Then("show all disbursement with status transfered {string}")
    public void show_all_disbursement_with_status_transfered(String label) {
        for (int i=0;i<cpdisbursement.countRow();i++) {
            Assert.assertEquals(cpdisbursement.getStatusTransfer(i), label);
        }
    }
    @Then("filter reset to default")
    public void filter_reset_to_default() {
        Assert.assertEquals(cpdisbursement.getSearchByValue(),"Search By");
        Assert.assertEquals(cpdisbursement.getSearchFieldValue(),"");
        Assert.assertEquals(cpdisbursement.getJadwalTransferValue(),"Jadwal Transfer");
        Assert.assertEquals(cpdisbursement.getTransferFailedValue(),"Transfer Failed Date");
    }

    @When("admin preview data transfer and edit the information")
    public void admin_preview_data_transfer_and_edit_the_information(){
        cpdisbursement.clickActionTransfer();
        cpdisbursement.editNamaProperty("Harapan");
        cpdisbursement.clickFirstPropertySuggestion();
        cpdisbursement.editTotalPendapatan("100100");
        cpdisbursement.editTipeTransaksi("Revenue Share");
        cpdisbursement.editTanggalTransfer();
        cpdisbursement.clicksTransferSekarang();
    }

    @Then("system show message {string}")
    public void system_show_message(String toast){
        Assert.assertEquals(cpdisbursement.getToastMessage(), toast,"Toast Message not Equal");
    }

    @Then("disbursement {string} is displayed in Process tab")
    public void disbursement_is_displayed_in_Process_tab(String disbursement){
        if (disbursement.equalsIgnoreCase("edit")){
            Assert.assertEquals(cpdisbursement.getTglTransferCol(), "(1 Days More)", "The data does not match");
            Assert.assertEquals(cpdisbursement.getNamaPropCol(), propertyNameEdit, "Nama Property does not match");
            System.out.println(cpdisbursement.getNamaPropCol());
            Assert.assertEquals(cpdisbursement.getTipeTransaksiCol(), tipeTransaksiEdit, "Tipe Transaksi does not match");
            Assert.assertEquals(cpdisbursement.getTotalPndptnCol(), totalPendapatanRpEdit, "Total Pendapatan does not match");
            Assert.assertEquals(cpdisbursement.getStatusTransferAfterEdit(),"processing","Status Transfer does not match");
        } else if (disbursement.equalsIgnoreCase("without edit")) {
            Assert.assertEquals(cpdisbursement.getTglTransferCol(), "(Today)", "The data does not match");
            Assert.assertEquals(cpdisbursement.getNamaPropColWithoutEdit(), propertyName, "The data does not match");
            Assert.assertEquals(cpdisbursement.getTipeTransaksiCol(), tipeTransaksi, "The data does not match");
            Assert.assertEquals(cpdisbursement.getTotalPndptnCol(), totalPendapatanRp, "The data does not match");
            Assert.assertEquals(cpdisbursement.getDetailRekColWithoutEdit(), pemilikRekening, "The data does not match");
            Assert.assertEquals(cpdisbursement.getStatusTransferWithoutEdit(),"processing","Status Transfer does not match");
        }
    }

    @When("admin checks Preview Data Transfer")
    public void admin_checks_Preview_Data_Transfer(){
        cpdisbursement.clickActionTransfer();
    }

    @Then("Data Transfer that has been inputted is displayed on Preview Data Transfer")
    public void Data_Transfer_that_has_been_inputted_is_displayed_on_Preview_Data_Transfer(DataTable tables){
        transferInfo = tables.asMaps(String.class, String.class);
        SimpleDateFormat today = new SimpleDateFormat("yyyy-MM-dd");
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
        String disbursement = transferInfo.get(0).get("Tipe Disbursement");

        Assert.assertEquals(cpdisbursement.getPropertyNameOnPreview(),property);
        Assert.assertEquals(cpdisbursement.getProductTypeOnPreview(),product);
        Assert.assertEquals(cpdisbursement.getBankOnPreview(),bank);
        Assert.assertEquals(cpdisbursement.getNoRekeningOnPreview(),norek);
        Assert.assertEquals(cpdisbursement.getNamaPemilikRekeningOnPreview(),name);
        Assert.assertEquals(cpdisbursement.getNoTelponPemilikOnPreview(),nohp);
        Assert.assertEquals(cpdisbursement.getTotalPendapatanOnPreview(),total);
        Assert.assertEquals(cpdisbursement.getTipeTransaksiOnPreview(),tipe);
        if (tanggal.equalsIgnoreCase("today")){
            Assert.assertEquals(cpdisbursement.getTanggalTransferOnPreview(),today.format(dates));
        } else {
            Assert.assertEquals(cpdisbursement.getTanggalTransfer(),tanggal);
        }

        if (disbursement.equalsIgnoreCase("Disbursement utama")){
            disbursement = "main";
        } else if (disbursement.equalsIgnoreCase("Disbursement susulan")) {
            disbursement = "followup";
        }
        Assert.assertEquals(cpdisbursement.getDisbursementTypeOnPreview(),disbursement);
    }

    @When("admin clicks Transfer Sekarang on Preview Data Transfer")
    public void admin_clicks_Transfer_Sekarang_on_Preview_Data_Transfer(){
        cpdisbursement.clicksTransferSekarang();
    }

    @When("admin preview data transfer and edit Bank Account Number")
    public void admin_preview_data_transfer_and_edit_Bank_Account_Number(){
        cpdisbursement.clickActionTransfer();
        cpdisbursement.editNoRekening("1234asds");
    }

    @Then("admin cannot input account number using char")
    public void admin_cannot_input_account_number_using_char(){
        Assert.assertEquals(cpdisbursement.getNoRekeningPreview(),"1234");
    }

    @Then("disbursement data contains status {string}")
    public void disbursement_data_contains_status(String status) {
        Assert.assertTrue(cpdisbursement.isDisbursementContainsStatus(status),"Data not contains status :"+status);
    }

    @Then("all disbursement have id")
    public void all_disbursement_have_id() {
        Assert.assertEquals(cpdisbursement.getHeaderColumnName(1),"Id");
        Assert.assertTrue(cpdisbursement.allDisbursementHaveID());
    }

    @Then("error message on {string} field is displayed")
    public void error_message_on_field_is_displayed(String field){
        if (field.equalsIgnoreCase("Total Pendapatan")){
            Assert.assertEquals(cpdisbursement.getErrorMessageOnTotalPendapatan(), errorMessageOnTotalPendapatan, "Error Message Copy does not match!");
        } else if (field.equalsIgnoreCase("Nomor Rekening")) {
            Assert.assertEquals(cpdisbursement.getErrorMessageOnNomorRekening(), errorMessageOnNomorRekening, "Error Message Copy does not match!");
        } else if (field.equalsIgnoreCase("Nama Pemilik Rekening")) {
            Assert.assertEquals(cpdisbursement.getErrorMessageOnNamaPemilikRekening(), errorMessageOnNamaPemilikRekening, "Error Message Copy does not match!");
        } else {
            System.out.println("Invalid input parameter");
        }
    }

    @Then("Tambahkan button is disable")
    public void Tambahkan_button_is_disable(){
        Assert.assertTrue(cpdisbursement.isTambahkanBtnDisable(), "Tambahkan button is enable!");
    }

    @When("admin clicks Transfer button in one of list data transaction")
    public void admin_clicks_Transfer_button_in_one_of_list_data_transaction(){
        cpdisbursement.clickActionTransfer();
    }

    @When("admin remove {string} value")
    public void admin_remove_value(String field){
        if (field.equalsIgnoreCase("Total Pendapatan")){
            cpdisbursement.removeTotalPendapatanValue();
        } else if (field.equalsIgnoreCase("Nomor Rekening")) {
            cpdisbursement.removeNomorRekeningValue();
        } else if (field.equalsIgnoreCase("Nama Pemilik Rekening")) {
            cpdisbursement.removeNamaPemilikRekening();
        } else {
            System.out.println("Invalid input parameter");
        }
    }

    @When("admin refresh page in CP Disbursement")
    public void admin_refresh_page_in_CP_Disbursement(){
        cpdisbursement.cpDisbursementRefreshPage();
    }
}
