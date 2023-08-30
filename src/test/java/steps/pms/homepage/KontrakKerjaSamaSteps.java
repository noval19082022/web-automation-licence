package steps.pms.homepage;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.pms.homepage.KontrakKerjaSamaPO;
import utilities.PlaywrightHelpers;

import java.util.List;
import java.util.Map;

public class KontrakKerjaSamaSteps {
    Page page = ActiveContext.getActivePage();

    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    KontrakKerjaSamaPO contract = new KontrakKerjaSamaPO(page);

    private List<Map<String, String>> profilPemilik;
    private List<Map<String, String>> profilPemilikEdit;
    private List<Map<String, String>> transfer;
    private List<Map<String, String>> kontrak;
    private List<Map<String, String>> additionalFee;
    private List<Map<String, String>> detailListing;

    @When("admin see profil pemilik")
    public void admin_see_profil_pemilik() {
        contract.clickKontrakKerjaSamaTab();
    }
    @Then("profil pemilik section match with data")
    public void profil_pemilik_section_match_with_data(DataTable tables) {
        profilPemilik = tables.asMaps(String.class, String.class);
        String nama = profilPemilik.get(0).get("Nama");
        String noHP = profilPemilik.get(0).get("Nomor HP");
        String alamat = profilPemilik.get(0).get("Alamat");
        String provinsi = profilPemilik.get(0).get("Provinsi");
        String kota = profilPemilik.get(0).get("kota/Kabupaten");
        String kecamatan = profilPemilik.get(0).get("Kecamatan");
        String kelurahan = profilPemilik.get(0).get("Kelurahan");

        contract.assertNamaPemilik(nama);
        contract.assertNoHPPemilik(noHP);
        contract.assertAlamatPemilik(alamat);
        contract.assertProvinsiPemilik(provinsi);
        contract.assertKotaPemilik(kota);
        contract.assertKecamatanPemilik(kecamatan);
        contract.assertKelurahanPemilik(kelurahan);
    }
    @When("admin edit profil pemilik")
    public void admin_edit_profil_pemilik(DataTable tables) {
        profilPemilikEdit = tables.asMaps(String.class, String.class);
        String nama = profilPemilikEdit.get(0).get("Nama");
        String noHP = profilPemilikEdit.get(0).get("Nomor HP");
        String alamat = profilPemilikEdit.get(0).get("Alamat");
        String provinsi = profilPemilikEdit.get(0).get("Provinsi");
        String kota = profilPemilikEdit.get(0).get("kota/Kabupaten");
        String kecamatan = profilPemilikEdit.get(0).get("Kecamatan");
        String kelurahan = profilPemilikEdit.get(0).get("Kelurahan");

        contract.ubahProfilPemilik();
        contract.editNamaPemilik(nama);
        contract.editNoHPPemilik(noHP);
        contract.editAlamatPemilik(alamat);
        contract.editProvinsiPemilik(provinsi);
        contract.editKotaPemilik(kota);
        contract.editKecamatanPemilik(kecamatan);
        contract.editKelurahanPemilik(kelurahan);
        contract.submitEditProfilPemilik();
    }

    @When("admin edit informasi transfer pendapatan")
    public void admin_edit_informasi_transfer_pendapatan(DataTable tables) {
        transfer = tables.asMaps(String.class, String.class);
        String noRek = transfer.get(0).get("Nomor Rekening");
        String bankName = transfer.get(0).get("Nama Bank");
        String branch = transfer.get(0).get("Cabang");
        String pemilik = transfer.get(0).get("Nama Pemilik");
        String tanggalTransfer = transfer.get(0).get("Tanggal Transfer");

        contract.ubahInformasiTransferPendapatan();
        contract.editNoRekening(noRek);
        contract.editNamaBank(bankName);
        contract.editCabangBank(branch);
        contract.editNamaPemilikBank(pemilik);
        contract.editTanggalTransfer(tanggalTransfer);
        contract.submitEditInformasiTransferPendapatan();
    }

    @Then("informasi transfer pendapatan should be match with data")
    public void informasi_transfer_pendapatan_should_be_match_with_data(DataTable tables) {
        transfer = tables.asMaps(String.class, String.class);
        String noRek = transfer.get(0).get("Nomor Rekening");
        String bankName = transfer.get(0).get("Nama Bank");
        String branch = transfer.get(0).get("Cabang");
        String pemilik = transfer.get(0).get("Nama Pemilik");
        String tanggalTransfer = transfer.get(0).get("Tanggal Transfer");

        contract.assertNoRekening(noRek);
        contract.assertNamaBank(bankName);
        contract.assertCabangBank(branch);
        contract.assertNamaPemilikRekening(pemilik);
        contract.assertTanggalTransfer(tanggalTransfer);
    }
    @When("admin see detail kerja sama")
    public void admin_see_detail_kerja_sama() {
        contract.clickKontrakKerjaSamaTab();
    }
    @Then("detail kerja sama should be match with data")
    public void detail_kerja_sama_should_be_match_with_data(DataTable tables) {
        kontrak = tables.asMaps(String.class, String.class);
        String produk = kontrak.get(0).get("Jenis Produk");
        String model = kontrak.get(0).get("Model Kerja Sama");
        String commission = kontrak.get(0).get("Basic Commission");
        String roomTotal = kontrak.get(0).get("Total Kamar");
        String jpType = kontrak.get(0).get("Tipe JP");
        String jpPrecentage = kontrak.get(0).get("Presentase JP");
        String jpAmount = kontrak.get(0).get("Jumlah JP");
        String adpType = kontrak.get(0).get("Tipe ADP");
        String adpPrecentage = kontrak.get(0).get("Presentase ADP");
        String adpAmount = kontrak.get(0).get("Jumlah ADP");
        String revBookingPemilik = kontrak.get(0).get("Pemilik Booking");
        String revBookingMamikos = kontrak.get(0).get("Mamikos Booking");
        String month = kontrak.get(0).get("Jangka Waktu");
        String start = kontrak.get(0).get("Awal Kerja Sama");
        String end = kontrak.get(0).get("Akhir Kerja Sama");
        String fee = kontrak.get(0).get("Biaya Keanggotaan");

        playwright.hardWait(5000);
        page.reload();
        contract.viewSectionDetailKerjaSama();

        contract.assertModelKerjaSama(produk, model, commission,roomTotal);
        contract.assertRevenuShare(jpType, jpPrecentage, jpAmount, adpType, adpPrecentage, adpAmount, revBookingPemilik, revBookingMamikos);
        contract.assertContractDuration(month, start, end, fee);
    }

    @When("admin edit detail kerja sama")
    public void admin_edit_detail_kerja_sama(DataTable tables) {
        kontrak = tables.asMaps(String.class, String.class);
        String produk = kontrak.get(0).get("Jenis Produk");
        String model = kontrak.get(0).get("Model Kerja Sama");
        String commission = kontrak.get(0).get("Basic Commission");
        String jpType = kontrak.get(0).get("Tipe JP");
        String jpPrecentage = kontrak.get(0).get("Presentase JP");
        String jpAmount = kontrak.get(0).get("Jumlah JP");
        String adpType = kontrak.get(0).get("Tipe ADP");
        String adpPrecentage = kontrak.get(0).get("Presentase ADP");
        String adpAmount = kontrak.get(0).get("Jumlah ADP");
        String month = kontrak.get(0).get("Jangka Waktu");
        String fee = kontrak.get(0).get("Biaya Keanggotaan");

        contract.ubahDetailKerjaSama();
        contract.editJenisProduk(produk);
        contract.editModelKerjaSama(model);
        contract.editBasicCommission(commission);
        contract.editJp(jpType, jpPrecentage, jpAmount);
        contract.editAdp(adpType, adpPrecentage, adpAmount);
        contract.editJangkaWaktuKerjaSama(month);
        contract.editBiayaKeanggotaan(fee);
        contract.submitEditDetailKerjaSama();
    }
    @When("admin turn on Hybrid and set mamikos precentage to {string} percent")
    public void admin_turn_on_hybrid_and_set_mamikos_precentage_to_percent(String precentage) {
        contract.ubahDetailKerjaSama();
        contract.setHybridRevenue(precentage);
        contract.submitEditDetailKerjaSama();
    }
    @Then("kontrak kerja sama should contains hybrid rev share")
    public void kontrak_kerja_sama_should_contains_hybrid_rev_share(DataTable tables) {
        kontrak = tables.asMaps(String.class, String.class);
        String precentagePemilik = kontrak.get(0).get("Pemilik DBET");
        String precentageMamikos = kontrak.get(0).get("Mamikos DBET");

        contract.viewSectionDetailKerjaSama();
        contract.assertHybridContractSection("visible");
        contract.assertHybridRevenue(precentagePemilik, precentageMamikos);
    }
    @When("admin turn off Hybrid")
    public void admin_turn_off_hybrid() {
        contract.ubahDetailKerjaSama();
        contract.turnOffHybridRevenue();
        contract.submitEditDetailKerjaSama();
    }
    @Then("kontrak kerja sama should not contains hybrid rev share")
    public void kontrak_kerja_sama_should_not_contains_hybrid_rev_share() {
        contract.viewSectionDetailKerjaSama();
        contract.assertHybridContractSection("hidden");
    }
    
    @When("admin see biaya tambahan")
    public void admin_see_biaya_tambahan() {
        contract.viewSectionBiayaTambahan();
    }

    @Then("biaya tambahan should contains")
    public void biaya_tambahan_should_contains(DataTable tables) {
        additionalFee = tables.asMaps(String.class, String.class);

        contract.viewSectionBiayaTambahan();

        for (int i = 0; i< additionalFee.size(); i++){
            String fee = additionalFee.get(i).get("Nama Biaya");
            String amount = additionalFee.get(i).get("Amount");

            contract.assertBiayaTambahan(i, fee, amount);
        }
    }

    @When("admin add new biaya tambahan")
    public void admin_add_new_biaya_tambahan(DataTable tables) {
        additionalFee = tables.asMaps(String.class, String.class);

        contract.ubahBiayaTambahan();
        for (int i = 0; i< additionalFee.size(); i++){
            String fee = additionalFee.get(i).get("Nama Biaya");
            String amount = additionalFee.get(i).get("Amount");

            contract.addBiayaTambahan(fee, amount);
        }
    }

    @Then("detail biaya tambahan should contains")
    public void detail_biaya_tambahan_should_contains(DataTable tables) {
        additionalFee = tables.asMaps(String.class, String.class);

        for (int i = 0; i< additionalFee.size(); i++){
            String fee = additionalFee.get(i).get("Nama Biaya");
            String amount = additionalFee.get(i).get("Amount");

            contract.assertDetailBiayaTambahan(i, fee, amount);
        }
    }
    @When("admin edit biaya tambahan {string} to")
    public void admin_edit_biaya_tambahan_to(String feeName, DataTable tables) {
        additionalFee = tables.asMaps(String.class, String.class);

        for (int i = 0; i< additionalFee.size(); i++){
            String fee = additionalFee.get(i).get("Nama Biaya");
            String amount = additionalFee.get(i).get("Amount");

            contract.editBiayaTambahan(feeName, fee, amount);
        }
    }

    @When("admin delete biaya tambahan {string}")
    public void admin_delete_biaya_tambahan(String feeName){
        contract.deleteBiayaTambahan(feeName);
    }

    @When("admin see rincian tipe kamar dan harga")
    public void admin_see_rincian_tipe_kamar_dan_harga() {
        contract.viewSectionRincianTipeKamarDanHarga();
    }
    @Then("rincian tipe kamar dan harga should match")
    public void rincian_tipe_kamar_dan_harga_should_match(DataTable tables) {
        detailListing = tables.asMaps(String.class, String.class);

        for (int i=0;i< detailListing.size();i++){
            String type = detailListing.get(i).get("Tipe Kamar");
            String gender = detailListing.get(i).get("Gender");
            String room = detailListing.get(i).get("Jumlah Kamar");
            String ota = detailListing.get(i).get("Harga OTA");
            String monthly = detailListing.get(i).get("Harga Bulanan");
            String threeMonth = detailListing.get(i).get("Harga 3 Bulan");
            String sixMonth = detailListing.get(i).get("Harga 6 Bulan");
            String staticMonthly = detailListing.get(i).get("Static Bulanan");
            String staticThreeMonth = detailListing.get(i).get("Static 3 Bulan");
            String staticSixMonth = detailListing.get(i).get("Static 6 Bulan");
            String publishMonthly = detailListing.get(i).get("Publish Bulanan");
            String publishThreeMonth = detailListing.get(i).get("Publish 3 Bulan");
            String publishSixMonth = detailListing.get(i).get("Publish 6 Bulan");

            contract.assertTipeDanHargaKamar(i, type,gender,room,ota,monthly,threeMonth,sixMonth,staticMonthly,staticThreeMonth,staticSixMonth,publishMonthly,publishThreeMonth,publishSixMonth);
        }
    }
}
