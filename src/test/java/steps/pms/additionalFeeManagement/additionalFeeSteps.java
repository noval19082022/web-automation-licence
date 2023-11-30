package steps.pms.additionalFeeManagement;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.pms.additionalFeeManagement.addAdditionalFeePO;
import pageobject.pms.additionalFeeManagement.additionalFeePO;

import java.util.List;
import java.util.Map;

public class additionalFeeSteps {
    Page page = ActiveContext.getActivePage();

    additionalFeePO additionalFee = new additionalFeePO(page);
    addAdditionalFeePO addAdditionalFee = new addAdditionalFeePO(page);

    private List<Map<String, String>> additionalFeeDetails;

    @Then("new additional fee {string} added")
    public void new_additional_fee_added(String name, DataTable tables) {
        String message = "Data berhasil ditambahkan.";
        additionalFeeDetails = tables.asMaps(String.class, String.class);

        String tipePembayaran = additionalFeeDetails.get(0).get("Tipe Pembayaran");
        String satuanBiaya = additionalFeeDetails.get(0).get("Satuan Biaya");
        String waktuPenentuanHarga = additionalFeeDetails.get(0).get("Waktu Penentuan Harga Biaya");
        String pilihMandiri = additionalFeeDetails.get(0).get("Penyewa Bisa Pilih Mandiri");

        Assert.assertEquals(addAdditionalFee.getToastMessage(),message);
        Assert.assertEquals(additionalFee.getNamaBiaya(0),name);
        Assert.assertEquals(additionalFee.getTipePembayaranBiaya(0),tipePembayaran);
        Assert.assertEquals(additionalFee.getSatuanBiaya(0),satuanBiaya);
        Assert.assertEquals(additionalFee.getWaktuPenentuanHarga(0),waktuPenentuanHarga);
        Assert.assertEquals(additionalFee.getPenyewaBisaPilihMandiri(0),pilihMandiri);
    }

    @When("admin delete additional fee {string}")
    public void admin_delete_additional_fee(String name) {
        additionalFee.deleteAdditionalFee(name);
    }
    @Then("no additional fee master data with name {string}")
    public void no_additional_fee_master_data_with_name(String name) {
        Assert.assertFalse(additionalFee.isBiayaTambahanExist(name));
    }
}
