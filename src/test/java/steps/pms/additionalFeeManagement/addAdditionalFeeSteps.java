package steps.pms.additionalFeeManagement;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.pms.additionalFeeManagement.addAdditionalFeePO;

public class addAdditionalFeeSteps {
    Page page = ActiveContext.getActivePage();
    addAdditionalFeePO addAdditionalFee = new addAdditionalFeePO(page);
    @When("admin add new additional fee")
    public void admin_add_new_additional_fee() {
        addAdditionalFee.clickTambahBiayaTambahan();
    }
    @When("admin input nama biaya {string}")
    public void admin_input_nama_biaya(String name) {
        addAdditionalFee.setAdditionalFeeName(name);
    }
    @Then("show nama biaya error message {string}")
    public void show_nama_biaya_error_message(String message) {
        Assert.assertEquals(addAdditionalFee.getNamaBiayaErrorMessage(),message,"Error message nama biaya not equals");
    }
    @Then("nama biaya error message not appear")
    public void nama_biaya_error_message_not_appear() {
        Assert.assertFalse(addAdditionalFee.isNamaBiayaErrorMessageAppear());
    }
    @When("admin select tipe pembayaran biaya {string}")
    public void admin_select_tipe_pembayaran_biaya(String tipePembayaran) {
        addAdditionalFee.chooseTipePembayaranBiaya(tipePembayaran);
    }
    @Then("waktu penentuan harga biaya ditentukan di awal auto selected")
    public void waktu_penentuan_harga_biaya_ditentukan_di_awal_auto_selected() {
        Assert.assertTrue(addAdditionalFee.isWaktuPenentuanHargaBiayaDitentukanDiawalChecked());
    }
    @Then("waktu penentuan harga biaya disesuaikan dengan tagihan is not visible")
    public void waktu_penentuan_harga_biaya_disesuaikan_dengan_tagihan_is_not_visible() {
        Assert.assertFalse(addAdditionalFee.isBiayaDisesuaikanTagihanVisible());
    }
    @When("admin select waktu penentuan harga biaya {string}")
    public void admin_select_waktu_penentuan_harga_biaya(String waktu) {
        addAdditionalFee.chooseWaktuPenentuanHargaBiaya(waktu);
    }
    @Then("penyewa bisa pilih mandiri is auto select Tidak")
    public void penyewa_bisa_pilih_mandiri_is_auto_select_tidak() {
        Assert.assertTrue(addAdditionalFee.isPenyewaBisaPilihMandiriTidakChecked());
    }
    @Then("penyewa bisa pilih mandiri are disabled")
    public void penyewa_bisa_pilih_mandiri_are_disabled() {
        Assert.assertTrue(addAdditionalFee.isPenyewaBisaPilihMandiriYaDisabled());
        Assert.assertTrue(addAdditionalFee.isPenyewaBisaPilihMandiriTidakDisabled());
    }
    @When("admin choose satuan waktu biaya {string}")
    public void admin_choose_satuan_waktu_biaya(String waktu) {
        addAdditionalFee.selectSatuanWaktuBiaya(waktu);
    }
    @When("admin choose satuan besaran biaya {string}")
    public void admin_choose_satuan_besaran_biaya(String besaran) {
        addAdditionalFee.selectSatuanBesaranBiaya(besaran);
    }
    @When("admin submit additional fee")
    public void admin_submit_additional_fee() {
        addAdditionalFee.submitAddAdditionalFee();
    }
    @Then("button tambah disabled")
    public void button_tambah_disabled() {
        Assert.assertTrue(addAdditionalFee.isTambahButtonDisable());
    }
    @When("admin select penyewa bisa pilih mandiri {string}")
    public void admin_select_penyewa_bisa_pilih_mandiri(String option) {
        addAdditionalFee.choosePenyewaBisaPilihMandiri(option);
    }
    @When("admin select fase penyewa pilih biaya {string}")
    public void admin_select_fase_penyewa_pilih_biaya(String option) {
        addAdditionalFee.selectFasePenyewaPilihBiaya(option);
    }
    @When("admin select kategori asuransi {string}")
    public void admin_select_kategori_asuransi(String option) {
        addAdditionalFee.chooseKategoriAsuransi(option);
    }
    @Then("button tambah enable")
    public void button_tambah_enable() {
        Assert.assertFalse(addAdditionalFee.isTambahButtonDisable());
    }
}
