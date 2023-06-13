package steps.pms.otherTransaction;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.pms.otherTransaction.AddOwnerExpenditurePO;
import pageobject.pms.otherTransaction.listOwnerExpenditurePO;

import java.util.List;
import java.util.Map;

public class AddOwnerExpenditureSteps {
    Page page = ActiveContext.getActivePage();
    AddOwnerExpenditurePO add = new AddOwnerExpenditurePO(page);
    listOwnerExpenditurePO list = new listOwnerExpenditurePO(page);

    private List<Map<String, String>> biayaPengeluaran;

    @When("admin add new owner expenditure {string} in property {string}")
    public void admin_add_new_owner_expenditure_in_property(String type, String name) {
        add.clickTambahData();
        add.chooseCashOutType(type);
        add.selectProperty(name);
    }
    @When("admin add multiple biaya pengeluaran :")
    public void admin_add_multiple_biaya_pengeluaran(DataTable tables) {
        biayaPengeluaran = tables.asMaps(String.class, String.class);

        for (Map<String,String> biaya : biayaPengeluaran){
            String no = biaya.get("no");
            String category = biaya.get("Kategori Pengeluaran");
            String name = biaya.get("Nama Pengeluaran");
            String quantity = biaya.get("Kuantitas");
            String amount = biaya.get("Nominal Pengeluaran");
            String status = biaya.get("Status Persediaan");
            String product = biaya.get("Jenis Produk");

            add.setKategoriPengeluaran(category,no);
            add.setNamaPengeluaran(name,no);
            add.setKuantitas(quantity,no);
            add.setNominalPengeluaran(amount,no);
            add.setStatusPersediaan(status,no);
            add.setJenisProduk(product,no);

            //Tambah Pengeluaran if any
            if (Integer.parseInt(no) < biayaPengeluaran.size()){
                add.addMorePengeluaran();
            }
        }
    }
    @When("admin upload valid attachment")
    public void admin_upload_valid_attachment() {
        add.uploadAttachment("jpg");
    }
    @When("admin input no invoice biaya {string}")
    public void admin_input_no_invoice_biaya(String invoice) {
        add.setNoInvoiceBiaya(invoice);
    }
    @When("admin choose tujuan transfer {string}")
    public void admin_choose_tujuan_transfer(String vendor) {
        add.setTujuanTransfer(vendor);
    }
    @When("submit owner expenditure")
    public void submit_owner_expenditure() {
        add.submitAddOwnerExpenditure();
    }
    @Then("owner expenditure confirmation pop up appear")
    public void owner_expenditure_confirmation_pop_up_appear() {
        add.assertConfirmationPopUpAddOwnerExpenditure();
    }
    @When("user {string} tambah data owner expenditure")
    public void user_tambah_data_owner_expenditure(String action) {
        if (action.equalsIgnoreCase("cancel")){
            add.cancelAddOwnerExpenditure();
        } else if (action.equalsIgnoreCase("confirm")) {
            add.confirmAddOwnerExpenditure();
        }
    }
    @Then("confirmation pop up should closed")
    public void confirmation_pop_up_should_closed() {
        add.assertConfirmationPopUpAddOwnerExpenditureClosed();
    }
    @Then("toast message {string} should be appear")
    public void toast_message_should_be_appear(String message) {
        add.assertToastMessage(message);
    }
    @Then("new owner expenditure record should be on the first list contains:")
    public void new_owner_expenditure_record_should_be_on_the_first_list_contains(DataTable tables) {
        List<Map<String, String>> data = tables.asMaps(String.class,String.class);
        for (Map<String,String> record : data) {
            String tipe = record.get("Tipe Pengajuan Cash Out");
            String prop = record.get("Nama Properti");
            String total = record.get("Total Pengeluaran");

            list.assertTipePengajuanCashoutFirstData(tipe);
            list.assertPropertynameFirstData(prop);
            list.assertTotalPengeluaranFirstData(total);
        }
    }
    @Then("should contains nama pengeluaran:")
    public void should_contains_nama_pengeluaran(List<String> tables) {
        for (String pengeluaran: tables) {
            list.assertFirstDataContainsPengeluaran(pengeluaran);
        }
    }
    @When("admin add new owner expenditure and search property {string}")
    public void admin_add_new_owner_expenditure_and_search_property(String property) {
        add.clickTambahData();
        add.searchProperty(property);
    }
    @Then("system should show property suggestion {string}")
    public void system_should_show_property_suggestion(String property) {
        add.assertPropertySuggestion(property);
    }
    @Then("property suggestion not appear")
    public void property_suggestion_not_appear() {
        add.assertPropertySuggestionNotAppear();
    }
    @When("admin edit and choose property {string}")
    public void admin_edit_and_choose_property(String property) {
        add.editSearchProperty(property);
    }
    @Then("kota and sisa kontrak kerja sama should be {string}")
    public void kota_and_sisa_kontrak_kerja_sama_should_be(String text) {
        add.assertKota(text);
        add.assertSisaKontrak(text);
    }
    @Then("system should be auto fill kota and sisa kontrak kerja sama")
    public void system_should_be_auto_fill_kota_and_sisa_kontrak_kerja_sama() {
        add.assertKotaNotEmpty();
        add.assertSisaKontrakNotEmpty();
    }
    @When("admin tambah data owner expenditure")
    public void admin_tambah_data_owner_expenditure() {
        add.clickTambahData();
    }
    @Then("admin verify kategori pengeluaran list should contains :")
    public void admin_verify_kategori_pengeluaran_list_should_contains(List<String> pengeluaran) {
        add.expandKategoriPengeluaran();
        for (int i=0;i< pengeluaran.size();i++) {
            add.assertKategoriPengeluaranList(i, pengeluaran.get(i));
        }
    }
    @When("admin fill biaya pengeluaran except nama pengeluaran")
    public void admin_fill_biaya_pengeluaran_except_nama_pengeluaran() {
        add.setKategoriPengeluaran("Amenities Penyewa","1");
        add.setKuantitas("2","1");
        add.setNominalPengeluaran("40000","1");
        add.setStatusPersediaan("Stock","1");
        add.setJenisProduk("LSSS","1");
    }
    @When("admin fill nama pengeluaran {string}")
    public void admin_fill_nama_pengeluaran(String name) {
        add.setNamaPengeluaran(name,"1");
    }

    @Then("tambah pengeluaran button should be disabled")
    public void tambah_pengeluaran_button_should_be_disabled() {
        add.assertTambahPengeluaranButtonDisable();
    }
    @Then("tambah pengeluaran button should be enable")
    public void tambah_pengeluaran_button_should_be_enable() {
        add.assertTambahPengeluaranButtonEnable();
    }
    @When("admin fill nama pengeluaran more than 50 characters")
    public void admin_fill_nama_pengeluaran_more_than_50_characters() {
        add.setNamaPengeluaran("Lorem ipsum dolor sit amet, consectetur adipiscing elit","1");
    }
    @Then("nama pengeluaran should be only contains 50 characters")
    public void nama_pengeluaran_should_be_only_contains_50_characters() {
        String expected = "Lorem ipsum dolor sit amet, consectetur adipiscing";
        add.assertNamaPengeluaran(expected);
    }

    @When("admin fill biaya pengeluaran except kuantitas")
    public void admin_fill_biaya_pengeluaran_except_kuantitas() {
        add.setKategoriPengeluaran("Amenities Penyewa","1");
        add.setNamaPengeluaran("Token Listrik","1");
        add.setNominalPengeluaran("20000","1");
        add.setStatusPersediaan("Stock","1");
        add.setJenisProduk("LSSS","1");
    }
    @When("admin fill kuantitas {string}")
    public void admin_fill_kuantitas(String qty) {
        add.setKuantitas(qty,"1");
    }
    @Then("kuantitas field value should be {string}")
    public void kuantitas_field_value_should_be(String qty) {
        add.assertKuantitasValue(qty);
    }
    @Then("kuantitas field value should be empty")
    public void kuantitas_field_value_should_be_empty() {
        add.assertKuantitasValue("empty");
    }
    @When("admin fill biaya pengeluaran except nominal")
    public void admin_fill_biaya_pengeluaran_except_nominal() {
        add.setKategoriPengeluaran("Pembayaran Listrik","1");
        add.setNamaPengeluaran("Token Listrik","1");
        add.setKuantitas("2","1");
        add.setStatusPersediaan("Non Stock","1");
        add.setJenisProduk("LSSS","1");
    }
    @When("admin fill biaya pengeluaran {string}")
    public void admin_fill_biaya_pengeluaran(String value) {
        add.setNominalPengeluaran(value,"1");
    }
    @Then("biaya pengeluaran value should be {string}")
    public void biaya_pengeluaran_value_should_be(String value) {
        add.assertBiayaPengeluaran(value);
    }
    @When("admin upload {string} attachment")
    public void admin_upload_attachment(String format) {
        add.uploadAttachment(format);
    }
    @When("admin delete attachment")
    public void admin_delete_attachment() {
        add.deleteAttachment();
    }
    @Then("{string} attachment should be uploaded")
    public void attachment_should_be_uploaded(String format) {
        String filename = "";
        switch (format){
            case "jpg":
                filename = "ABY06593.jpg";
                break;
            case "jpeg":
                filename = "ABY05305.jpeg";
                break;
            case "png":
                filename = "BG_Anniv Mamikos ke7.png";
                break;
            case "pdf":
                filename = "pdf example.pdf";
                break;
            case "jpg 8MB":
                filename = "jpg8MB.jpg";
                break;
            case "pdf 8MB":
                filename = "pdf8MB.pdf";
                break;
            default:
                System.out.println("Invalid Format");
        }
        add.assertFileName(filename);
        add.assertTrashIconVisible();
    }
    @Then("show upload attachment error message")
    public void show_upload_attachment_error_message() {
        add.assertAttachmentErrorMessage();
    }
    @When("admin upload invalid attachment")
    public void admin_upload_invalid_attachment() {
        add.uploadAttachment("svg");
    }
    @When("admin add 30 pengeluaran")
    public void admin_add_pengeluaran() {
        for (int i=1;i<=30;i++){
            add.setKategoriPengeluaran("Amenities Penyewa",String.valueOf(i));
            add.setNamaPengeluaran("Sabun Mandi",String.valueOf(i));
            add.setKuantitas("5",String.valueOf(i));
            add.setNominalPengeluaran("50000",String.valueOf(i));
            add.setStatusPersediaan("Non Stock",String.valueOf(i));
            add.setJenisProduk("LSSS",String.valueOf(i));
            if (i<30){
                add.addMorePengeluaran();
            }
        }
    }
    @Then("admin can't add more pengeluaran")
    public void admin_can_t_add_more_pengeluaran() {
        add.assertTambahPengeluaranButtonDisable();
    }
}
