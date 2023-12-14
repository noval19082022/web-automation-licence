package steps.pms.homepage.additionalFeePMSKK;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
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

        additionalFeePMSKK.clicksTambahBiayaButton();

        //search biaya tambahan in pop up Tambah Biaya Tambahan
        if (namaBiaya.equalsIgnoreCase("Laundry")){
            addAdditionalFeePMSKK.searchNamaBiayaLaundry(namaBiaya);
        } else {
            addAdditionalFeePMSKK.searchNamaBiayaTambahan(namaBiaya);
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
                addAdditionalFeePMSKK.isAutoSelectsBiayaTermasukHargaSewaChecked(biayaTermasukHargaSewa);
                addAdditionalFeePMSKK.isAutoSelectsPengaturanRincianSewa(pengaturanDiRincianSewa);
                addAdditionalFeePMSKK.selectsSatuanWaktu(satuanWaktu);
                addAdditionalFeePMSKK.inputsHarga(hargaSatuanWaktu);
            } else if (data.equalsIgnoreCase("Satuan Besaran")) {
                hargaKg = addFee.get(0).get("Harga Kilogram (kg)");

                addAdditionalFeePMSKK.selectsJenisBiaya(jenisBiaya);
                addAdditionalFeePMSKK.selectsSatuanBesaran();
                addAdditionalFeePMSKK.inputsHarga(hargaKg);
            } else if (data.equalsIgnoreCase("Satuan Waktu and Satuan Besaran")) {
                satuanWaktu = addFee.get(0).get("Satuan Waktu");

                addAdditionalFeePMSKK.selectsJenisBiaya(jenisBiaya);
                addAdditionalFeePMSKK.selectsSatuanWaktu(satuanWaktu);
                addAdditionalFeePMSKK.inputsHarga(hargaSatuanWaktu);
                addAdditionalFeePMSKK.selectsSatuanBesaran();
            }
        } else {
            System.out.println("Satuan is invalid");
        }

        addAdditionalFeePMSKK.clicksTambahButtonInBiayaTambahanPopUp();
    }
}