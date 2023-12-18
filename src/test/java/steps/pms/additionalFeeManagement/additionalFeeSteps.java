package steps.pms.additionalFeeManagement;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.pms.additionalFeeManagement.addAdditionalFeePO;
import pageobject.pms.additionalFeeManagement.additionalFeePO;
import utilities.PlaywrightHelpers;

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
        String tipePembayarancolor = "";
        String tipePembayaranbgColor = "";
        String waktuPenentuanHargacolor = "";
        String waktuPenentuanHargaBgColor = "";
        String penyewaPilihMandiriColor = "";
        String penyewaPilihMandiriBgColor = "";
        additionalFeeDetails = tables.asMaps(String.class, String.class);

        String tipePembayaran = additionalFeeDetails.get(0).get("Tipe Pembayaran");
        String satuanBiayaTop = additionalFeeDetails.get(0).get("Satuan Biaya Top");
        String satuanBiayaBottom = additionalFeeDetails.get(0).get("Satuan Biaya Bottom");
        String waktuPenentuanHarga = additionalFeeDetails.get(0).get("Waktu Penentuan Harga Biaya");
        String pilihMandiri = additionalFeeDetails.get(0).get("Penyewa Bisa Pilih Mandiri");
        String fasePenyewa = additionalFeeDetails.get(0).get("Fase Penyewa Pilih Biaya");

        Assert.assertEquals(addAdditionalFee.getToastMessage(),message);
        Assert.assertEquals(additionalFee.getNamaBiaya(0),name);
        Assert.assertEquals(additionalFee.getTipePembayaranBiaya(0),tipePembayaran);
        Assert.assertEquals(additionalFee.getSatuanBiaya(0),satuanBiayaTop);
        if (!satuanBiayaBottom.equalsIgnoreCase("-")){
            Assert.assertEquals(additionalFee.getSatuanBiaya(1),satuanBiayaBottom);
        }
        Assert.assertEquals(additionalFee.getWaktuPenentuanHarga(0),waktuPenentuanHarga);
        Assert.assertEquals(additionalFee.getPenyewaBisaPilihMandiri(0),pilihMandiri);
        if (pilihMandiri.equalsIgnoreCase("Ya")) {
            Assert.assertEquals(additionalFee.getFasePenyewaPilihMandiri(0), fasePenyewa);
        }

        // set expected color and background color
        if (tipePembayaran.equalsIgnoreCase("Tetap")){
            tipePembayarancolor = "rgb(0, 82, 164)";
            tipePembayaranbgColor = "rgb(241, 247, 255)";
        } else if (tipePembayaran.equalsIgnoreCase("Satu Kali")) {
            tipePembayarancolor = "rgb(140, 59, 0)";
            tipePembayaranbgColor = "rgb(252, 247, 227)";
        }

        //Assert Tipe Pembayaran color
        additionalFee.assertTipePembayaranCSS("color",tipePembayarancolor);
        additionalFee.assertTipePembayaranCSS("background-color",tipePembayaranbgColor);

        if (waktuPenentuanHarga.equalsIgnoreCase("Ditentukan di Awal")) {
            waktuPenentuanHargacolor = "rgb(1, 96, 52)";
            waktuPenentuanHargaBgColor = "rgb(237, 249, 244)";
        } else if (waktuPenentuanHarga.equalsIgnoreCase("Disesuaikan dengan Tagihan")) {
            waktuPenentuanHargacolor = "rgb(140, 59, 0)";
            waktuPenentuanHargaBgColor = "rgb(252, 247, 227)";
        }

        //Assert Waktu Penentuan Harga Biaya color
        additionalFee.assertWaktuPenentuanHargaCSS("color",waktuPenentuanHargacolor);
        additionalFee.assertWaktuPenentuanHargaCSS("background-color",waktuPenentuanHargaBgColor);

        if (pilihMandiri.equalsIgnoreCase("Ya")) {
            penyewaPilihMandiriColor = "rgb(1, 96, 52)";
            penyewaPilihMandiriBgColor = "rgb(237, 249, 244)";
        }else if (pilihMandiri.equalsIgnoreCase("Tidak")) {
            penyewaPilihMandiriColor = "rgb(140, 59, 0)";;
            penyewaPilihMandiriBgColor = "rgb(252, 247, 227)";
        }

        //Assert Penyewa pilih mandiri color
        additionalFee.assertPenyewaPilihMandiriCSS("color",penyewaPilihMandiriColor);
        additionalFee.assertPenyewaPilihMandiriCSS("background-color",penyewaPilihMandiriBgColor);
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
