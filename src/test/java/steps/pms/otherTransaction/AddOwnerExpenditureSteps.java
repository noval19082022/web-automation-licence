package steps.pms.otherTransaction;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pageobject.pms.otherTransaction.AddOwnerExpenditurePO;

import java.util.List;
import java.util.Map;

public class AddOwnerExpenditureSteps {
    Page page = ActiveContext.getActivePage();
    AddOwnerExpenditurePO add = new AddOwnerExpenditurePO(page);

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
            if (Integer.parseInt(no) < biaya.size()-1){
                add.addMorePengeluaran();
            }
        }
    }

    @When("admin upload valid attachment")
    public void admin_upload_valid_attachment() {
        add.uploadAttachment("jpg");
    }
}
