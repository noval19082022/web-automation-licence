package steps.pms.otherTransaction;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pageobject.pms.otherTransaction.AddOwnerExpenditurePO;
import pageobject.pms.otherTransaction.EditOwnerExpenditurePO;
import pageobject.pms.otherTransaction.listOwnerExpenditurePO;

import java.util.List;
import java.util.Map;

public class EditOwnerExpenditureSteps {
    Page page = ActiveContext.getActivePage();

    EditOwnerExpenditurePO edit = new EditOwnerExpenditurePO(page);
    AddOwnerExpenditurePO add = new AddOwnerExpenditurePO(page);
    listOwnerExpenditurePO list = new listOwnerExpenditurePO(page);

    private List<Map<String, String>> biayaPengeluaran;

    @When("admin edit type pengajuan cash out to {string} at property {string}")
    public void admin_edit_type_pengajuan_cash_out_to_at_property(String type, String name) {
        edit.editOwnerExpenditure();
        add.chooseCashOutType(type);
        add.selectProperty(name);
    }
    @When("admin edit pengeluaran owner expenditure :")
    public void admin_edit_pengeluaran_owner_expenditure(DataTable tables) {
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
        }
    }
    @When("admin reupload lampiran")
    public void admin_reupload_lampiran() {
        edit.deleteAttachment();
        add.uploadAttachment("pdf");
    }
    @When("owner expenditure data should be change to :")
    public void owner_expenditure_data_should_be_change_to(DataTable tables) {
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
    @When("detail transfer should be change to :")
    public void detail_transfer_should_be_change_to(DataTable tables) {
        List<Map<String, String>> data = tables.asMaps(String.class,String.class);
        for (Map<String,String> record : data) {
            String vendor = record.get("Vendor Name");
            String acc = record.get("Vendor Account");
            String bank = record.get("Vendor Bank");
            String owner = record.get("Vendor Owner");
            String invoice = record.get("No Invoice Biaya");

            list.assertFirstVendorName(vendor,owner,acc,bank);
            list.assertFirstNoInvoice(invoice);
        }
    }
    @When("detail pengeluaran data should be change to :")
    public void detail_pengeluaran_data_should_be_change_to(DataTable tables) {
        List<Map<String, String>> data = tables.asMaps(String.class,String.class);
        for (Map<String,String> record : data) {
            String kategori = record.get("Kategori Pengeluaran");
            String name = record.get("Nama Pengeluaran");

            list.assertFirstDataContainsPengeluaran(kategori);
            list.assertFirstDataContainsPengeluaran(name);
        }
    }
    @When("edit owner expenditure")
    public void edit_owner_expenditure(){
        edit.ubahOwnerExpenditure();
    }
}
