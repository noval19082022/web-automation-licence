package steps.pms.homepage.additionalFeePMSKK;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.pms.homepage.additionalFeePMSKK.AdditionalFeePMSKKPO;

import java.util.List;
import java.util.Map;

public class AdditionalFeePMSKKSteps {

    Page page = ActiveContext.getActivePage();
    AdditionalFeePMSKKPO additionalFeePMSKK = new AdditionalFeePMSKKPO(page);

    private List<Map<String, String>> addFee;
    private List<Map<String, String>> addFeeInListing;

    @Then("empty state in Biaya Tambahan is displayed")
    public void empty_state_in_Biaya_Tambahan_is_displayed(){
        Assert.assertEquals(additionalFeePMSKK.emptyState(), "Tidak ada data yang ditampilkan", "Wording does not match!");
    }

    @Then("additional fee is created in PMS KK")
    public void additional_fee_is_created_in_PMS_KK(DataTable tables){
        String namaBiaya = "", penyewaBisaPilihMandiri = "", jenisBiaya = "", termasukDiDalamHargaSewa = "", tipePembayaranBiaya = "", ketentuanBagiHasil = "";
        addFee = tables.asMaps(String.class, String.class);

        namaBiaya = addFee.get(0).get("Nama Biaya");
        penyewaBisaPilihMandiri = addFee.get(0).get("Penyewa Bisa Pilih Mandiri");
        jenisBiaya = addFee.get(0).get("Jenis Biaya");
        termasukDiDalamHargaSewa = addFee.get(0).get("Termasuk di Dalam Harga Sewa");
        tipePembayaranBiaya = addFee.get(0).get("Tipe Pembayaran Biaya");
        ketentuanBagiHasil = addFee.get(0).get("Ketentuan Bagi Hasil");

        Assert.assertEquals(additionalFeePMSKK.getNamaBiayaInTable(namaBiaya), namaBiaya, "Nama Biaya does not match!");
        Assert.assertEquals(additionalFeePMSKK.getPenyewaBisaPilihMandiri(penyewaBisaPilihMandiri), penyewaBisaPilihMandiri, "Penyewa Bisa Pilih Mandiri does not match!");
        Assert.assertEquals(additionalFeePMSKK.getJenisBiaya(jenisBiaya), jenisBiaya, "Jenis Biaya does not match!");
        Assert.assertEquals(additionalFeePMSKK.getTermasukDiDalamHargaSewa(), termasukDiDalamHargaSewa, "Termasuk Di Dalam Harga Sewa does not match!");
        Assert.assertEquals(additionalFeePMSKK.getTipePembayaranBiaya(tipePembayaranBiaya), tipePembayaranBiaya, "Tipe Pembayaran Biaya does not match!");
        Assert.assertEquals(additionalFeePMSKK.getKetentuanBagiHasil(ketentuanBagiHasil), ketentuanBagiHasil, "Ketentuan Bagi Hasil does not match!");
    }

    @Then("additional fee is created in every listing")
    public void additional_fee_is_created_in_every_listing(DataTable tables){
        String listing = "", harga = "";
        addFeeInListing = tables.asMaps(String.class, String.class);

        int totalListing = additionalFeePMSKK.getTotalListing();
        additionalFeePMSKK.expandAddFee();

        int i=0;
        while (i < totalListing){
            listing = addFeeInListing.get(i).get("Listing");
            harga = addFeeInListing.get(i).get("Harga");

            Assert.assertEquals(additionalFeePMSKK.getListing(i), listing, "Listing does not match!");

            if (harga.equalsIgnoreCase("Disesuaikan dengan tagihan")){
                Assert.assertEquals(additionalFeePMSKK.getHargaDisesuaikanDenganTagihan(i), harga, "Harga does not match!");
            } else {
                Assert.assertEquals(additionalFeePMSKK.getHargaInListing(i), harga, "Harga does not match!");
            }
            i++;
        }
        additionalFeePMSKK.expandAddFee();
    }

    @When("admin edit additional fee in {string}")
    public void admin_edit_additional_fee_in(String listing) {
        additionalFeePMSKK.expandAddFee();
        if (listing.equalsIgnoreCase("Tipe A")){
            additionalFeePMSKK.clickEditOnType(1000023998);
        } else if (listing.equalsIgnoreCase("Tipe B")){
            additionalFeePMSKK.clickEditOnType(1000024001);
        } else if (listing.equalsIgnoreCase("Tipe C")){
            additionalFeePMSKK.clickEditOnType(1000024002);
        } else {
            System.out.println("Invalid Listing Type");
        }
    }

    @When("admin delete additional fee in {string}")
    public void admin_delete_additional_fee_in(String listing) {
        additionalFeePMSKK.expandAddFee();
        if (listing.equalsIgnoreCase("Tipe A")) {
            additionalFeePMSKK.clickDeleteOnType(1000023998);
        } else if (listing.equalsIgnoreCase("Tipe B")) {
            additionalFeePMSKK.clickDeleteOnType(1000024001);
        } else if (listing.equalsIgnoreCase("Tipe C")) {
            additionalFeePMSKK.clickDeleteOnType(1000024002);
        } else {
            System.out.println("Invalid Listing Type");
        }
    }
}