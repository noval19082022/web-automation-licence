package steps.pms.homepage.additionalFeePMSKK;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.pms.homepage.additionalFeePMSKK.AddAdditionalFeePMSKKPO;
import pageobject.pms.homepage.additionalFeePMSKK.AdditionalFeePMSKKPO;

import java.util.List;
import java.util.Map;

public class AddAdditionalFeePMSKKSteps {

    Page page = ActiveContext.getActivePage();

    AddAdditionalFeePMSKKPO addAdditionalFeePMSKK = new AddAdditionalFeePMSKKPO(page);
    AdditionalFeePMSKKPO additionalFeePMSKK = new AdditionalFeePMSKKPO(page);

    private List<Map<String, String>> addFee;

    @When("admin add additional fee in PMS KK with data {string} for {string}")
    public void admin_add_additional_fee_in_PMS_KK_with_data_for(String penentuanHarga, String data, DataTable tables){
        String namaBiaya = "", ketentuanBagiHasil = "", jenisBiaya = "", biayaTermasukHargaSewa = "", pengaturanDiRincianSewa = "",
                satuanWaktu = "", hargaBulanan = "", hargaKg = "", amount = "", hargaHarian = "", hargaSatuanWaktu = "";

        addFee = tables.asMaps(String.class, String.class);

        namaBiaya = addFee.get(0).get("Nama Biaya");
        ketentuanBagiHasil = addFee.get(0).get("Ketentuan Bagi Hasil");
        jenisBiaya = addFee.get(0).get("Jenis Biaya");

        additionalFeePMSKK.clickAddFeeButton();

        //search biaya tambahan in pop up Tambah Biaya Tambahan
        if (namaBiaya.equalsIgnoreCase("Laundry")){
            addAdditionalFeePMSKK.searchNamaBiayaLaundry(namaBiaya);
        } else {
            addAdditionalFeePMSKK.selectFeeName(namaBiaya);
        }

        //selects Ketentuan Bagi Hasil in pop up Tambah Biaya Tambahan
        addAdditionalFeePMSKK.selectsKetentuanBagiHasil(ketentuanBagiHasil);
        if (ketentuanBagiHasil.equalsIgnoreCase("Masukkan Manual")){
            amount = addFee.get(0).get("Amount");
            addAdditionalFeePMSKK.inputsManualBagiHasil(amount);
        }

        if (penentuanHarga.equalsIgnoreCase("Disesuaikan dengan Tagihan")){
            if (data.equalsIgnoreCase("Satuan Waktu")){
                satuanWaktu = addFee.get(0).get("Satuan Waktu");
                addAdditionalFeePMSKK.isAutoSelectsJenisBiayaChecked(jenisBiaya);
                addAdditionalFeePMSKK.selectsSatuanWaktu(satuanWaktu);
            } else if (data.equalsIgnoreCase("Satuan Besaran")) {
                addAdditionalFeePMSKK.selectsJenisBiaya(jenisBiaya);
                addAdditionalFeePMSKK.selectsSatuanBesaran();
            } else {
                System.out.println("Satuan is invalid");
            }
        } else if (penentuanHarga.equalsIgnoreCase("Ditentukan di Awal")) {
            hargaSatuanWaktu = addFee.get(0).get("Harga Satuan Waktu");
            if (data.equalsIgnoreCase("Satuan Waktu")){
                biayaTermasukHargaSewa = addFee.get(0).get("Biaya Termasuk Harga Sewa");
                pengaturanDiRincianSewa = addFee.get(0).get("Pengaturan di Rincian Sewa");
                satuanWaktu = addFee.get(0).get("Satuan Waktu");

                addAdditionalFeePMSKK.selectsJenisBiaya(jenisBiaya);
                if (jenisBiaya.equalsIgnoreCase("Wajib")){
                    addAdditionalFeePMSKK.isAutoSelectsBiayaTermasukHargaSewaChecked(biayaTermasukHargaSewa);
                    addAdditionalFeePMSKK.isAutoSelectsPengaturanRincianSewa(pengaturanDiRincianSewa);
                }
                addAdditionalFeePMSKK.selectsSatuanWaktu(satuanWaktu);
                addAdditionalFeePMSKK.setPrice(hargaSatuanWaktu);
            } else if (data.equalsIgnoreCase("Satuan Besaran")) {
                hargaKg = addFee.get(0).get("Harga Kilogram (kg)");

                addAdditionalFeePMSKK.selectsJenisBiaya(jenisBiaya);
                addAdditionalFeePMSKK.selectsSatuanBesaran();
                addAdditionalFeePMSKK.setPrice(hargaKg);
            } else if (data.equalsIgnoreCase("Satuan Waktu and Satuan Besaran")) {
                satuanWaktu = addFee.get(0).get("Satuan Waktu");

                addAdditionalFeePMSKK.selectsJenisBiaya(jenisBiaya);
                addAdditionalFeePMSKK.selectsSatuanWaktu(satuanWaktu);
                addAdditionalFeePMSKK.setPrice(hargaSatuanWaktu);
                addAdditionalFeePMSKK.selectsSatuanBesaran();
            }
        } else {
            System.out.println("Satuan is invalid");
        }

        addAdditionalFeePMSKK.clicksTambahButtonInBiayaTambahanPopUp();
    }

    @When("admin add existing additional fee {string}")
    public void admin_add_existing_additional_fee(String feeName) {
        additionalFeePMSKK.clickAddFeeButton();
        addAdditionalFeePMSKK.searchFee(feeName);
    }
    @Then("admin can't find additional fee")
    public void admin_can_t_find_additional_fee() {
        Assert.assertTrue(addAdditionalFeePMSKK.isFeeNotFound());
        addAdditionalFeePMSKK.clickCloseButton();
    }

    @When("admin select additional fee {string}")
    public void admin_select_additional_fee(String feeName) {
        additionalFeePMSKK.clickAddFeeButton();
        addAdditionalFeePMSKK.selectFeeName(feeName);
    }
    @When("admin turn off toggle terapkan ke semua listing")
    public void admin_turn_off_toggle_terapkan_ke_semua_listing() {
        addAdditionalFeePMSKK.switchToggleTerapkanKeSemuaListingOff();
    }
    @Then("dropdown pilih listing appear")
    public void dropdown_pilih_listing_appear() {
        Assert.assertTrue(addAdditionalFeePMSKK.isDropdownPilihListingAppear());
    }
    @Then("dropdown pilih listing contains listing")
    public void dropdown_pilih_listing_contains_listing(List<String> listingName) {
        addAdditionalFeePMSKK.clickDropdownListing();
        for (int i = 0; i < listingName.size(); i++) {
            Assert.assertEquals(addAdditionalFeePMSKK.getListingNameOptions(i),listingName.get(i),"Listing Name tidak sesuai");
        }
    }
    @When("admin check listing {string}")
    public void admin_check_listing(String listingName) {
        addAdditionalFeePMSKK.checkListing(listingName);
        addAdditionalFeePMSKK.clickDropdownListing();
    }
    @When("admin select ketentuan bagi hasil {string}")
    public void admin_select_ketentuan_bagi_hasil(String sharing) {
        addAdditionalFeePMSKK.chooseProvitSharingProvision(sharing);
    }
    @When("admin choose jenis biaya {string}")
    public void admin_choose_jenis_biaya(String feeOption) {
        addAdditionalFeePMSKK.chooseFeeOption(feeOption);
    }
    @When("admin fill harga bulanan {string}")
    public void admin_fill_harga_bulanan(String price) {
        addAdditionalFeePMSKK.setPrice(price);
    }
    @When("admin select satuan besaran biaya {string}")
    public void admin_select_satuan_besaran_biaya(String unit) {
        addAdditionalFeePMSKK.clickSatuanBesaranBiayaDropdown();
        addAdditionalFeePMSKK.selectUnitFee();
    }
    @When("admin submit additional fee pms")
    public void admin_submit_additional_fee_pms() {
        addAdditionalFeePMSKK.clicksTambahButtonInBiayaTambahanPopUp();
    }

    @When("admin submit edit additional fee")
    public void admin_submit_edit_additional_fee() {
        addAdditionalFeePMSKK.clicksEditButtonInBiayaTambahanPopUp();
    }
    @When("admin select satuan waktu biaya {string}")
    public void admin_select_satuan_waktu_biaya(String satuan) {
        addAdditionalFeePMSKK.clickSatuanWaktuBiayaDropdown();
        addAdditionalFeePMSKK.selectSatuanWaktuBiaya(satuan);
    }
}