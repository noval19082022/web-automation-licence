package pageobject.pms.homepage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class KontrakKerjaSamaPO {
    private Page page;

    //Profil Pemilik
    Locator kontrakKerjaSamaTab;
    Locator sectionOwnerProfile;
    Locator namaPemilik;
    Locator nomorHPPemilik;
    Locator alamatPemilik;
    Locator provinsiPemilik;
    Locator kotaPemilik;
    Locator kecamatanPemilik;
    Locator kelurahanPemilik;
    Locator ubahProfilPemilikButton;
    //End Profil Pemilik

    //Edit Profil Pemilik
    Locator namaPemilikInput;
    Locator noHPPemilikInput;
    Locator alamatPemilikInput;
    Locator provinsiPemilikInput;
    Locator kotaPemilikInput;
    Locator kecamatanPemilikInput;
    Locator kelurahanPemilikInput;
    Locator dropdownOptions;
    Locator simpanButton;
    Locator confirmSimpanButton;
    //End Edit Profil Pemilik

    //Informasi Transfer Pendapatan
    Locator nomorRekening;
    Locator namaBank;
    Locator cabangBank;
    Locator namaPemilikRekening;
    Locator tanggalTransferPemilik;
    Locator ubahInformasiTransferPendapatanButton;
    //End Informasi Transfer Pendapatan

    //Edit Informasi Transfer Pendapatan
    Locator nomorRekeningInput;
    Locator namaBankInput;
    Locator namaBankSelect;
    Locator cabangBankInput;
    Locator namaPemilikRekeningInput;
    Locator tanggalTransferPemilikInput;
    Locator tanggalTransferPemilikSelect;
    //End Edit Informasi Transfer Pendapatan

    //Detail Kerja Sama
    Locator detailKerjaSamaSection;
    Locator jenisProduk;
    Locator modelKerjaSama;
    Locator basicCommission;
    Locator totalKamar;
    Locator tipeJp;
    Locator presentaseJp;
    Locator jumlahJp;
    Locator tipeAdp;
    Locator presentaseAdp;
    Locator jumlahAdp;
    Locator pendapatanPemilikBooking;
    Locator pendapatanMamikosBooking;
    Locator jangkaWaktu;
    Locator awalKerjaSama;
    Locator akhirKerjaSama;
    Locator biayaKeanggotaan;
    Locator ubahDetailKerjaSamaButton;
    Locator hybridSection;
    Locator pendapatanPemilikDbet;
    Locator pendapatanMamikosDbet;
    //End Detail Kerja Sama

    //Edit Detail Kerja Sama
    Locator jenisProdukSelect;
    Locator jenisProdukInput;
    Locator modelKerjaSamaSelect;
    Locator basiCommissionInput;
    Locator tipeJpSelect;
    Locator tipeJpNone;
    Locator presentaseJpInput;
    Locator jumlahJpInput;
    Locator tipeAdpSelect;
    Locator tipeAdpNone;
    Locator presentaseAdpInput;
    Locator jumlahAdpInput;
    Locator hybridButton;
    Locator hybridButtonOff;
    Locator penpadatanDbetMamikosInput;
    Locator jangkaWaktuKerjaSamaInput;
    Locator biayaKeanggotaanInput;
    //End Edit Detail Kerja Sama

    public KontrakKerjaSamaPO (Page page){
        this.page = page;

        kontrakKerjaSamaTab = page.locator("[aria-controls='contract']");
        sectionOwnerProfile = page.locator("#owner-profile");
        namaPemilik = page.locator(".bg-c-list-item__description").nth(0);
        nomorHPPemilik = page.locator(".bg-c-list-item__description").nth(1);
        alamatPemilik = page.locator(".bg-c-list-item__description").nth(2);
        provinsiPemilik = page.locator(".bg-c-list-item__description").nth(3);
        kotaPemilik = page.locator(".bg-c-list-item__description").nth(4);
        kecamatanPemilik = page.locator(".bg-c-list-item__description").nth(5);
        kelurahanPemilik = page.locator(".bg-c-list-item__description").nth(6);
        ubahProfilPemilikButton = page.locator("#owner-profile").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Ubah"));

        namaPemilikInput = page.locator("input.bg-c-input__field").nth(0);
        noHPPemilikInput = page.locator("input.bg-c-input__field").nth(1);
        alamatPemilikInput = page.locator("textarea.bg-c-textarea__field");
        provinsiPemilikInput = page.locator(".bg-c-select__trigger").first();
        kotaPemilikInput = page.locator(".bg-c-select__trigger").nth(1);
        kecamatanPemilikInput = page.locator(".bg-c-select__trigger").nth(2);
        kelurahanPemilikInput = page.locator(".bg-c-select__trigger").last();
        dropdownOptions = page.locator(".bg-c-dropdown__menu-item-content");
        simpanButton = page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Simpan"));
        confirmSimpanButton = page.getByRole(AriaRole.DIALOG).getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Simpan"));

        nomorRekening = page.locator("#disbursement-information .bg-c-list-item__description").first();
        namaBank = page.locator("#disbursement-information .bg-c-list-item__description").nth(1);
        cabangBank = page.locator("#disbursement-information .bg-c-list-item__description").nth(2);
        namaPemilikRekening = page.locator("#disbursement-information .bg-c-list-item__description").nth(3);
        tanggalTransferPemilik = page.locator("#disbursement-information .bg-c-list-item__description").nth(4);
        ubahInformasiTransferPendapatanButton = page.locator("#disbursement-information").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Ubah"));

        nomorRekeningInput = page.locator("input.bg-c-input__field").nth(0);
        namaBankInput = page.locator("input.bg-c-input__field").nth(1);
        cabangBankInput = page.locator("input.bg-c-input__field").nth(2);
        namaPemilikRekeningInput = page.locator("input.bg-c-input__field").nth(3);
        namaBankSelect = page.locator(".bg-c-select").first();
        tanggalTransferPemilikSelect = page.locator(".bg-c-select").last();

        detailKerjaSamaSection = page.locator("#partnership-detail");
        jenisProduk = page.locator("#partnership-detail .bg-c-list-item__description").nth(0);
        modelKerjaSama = page.locator("#partnership-detail .bg-c-list-item__description").nth(1);
        basicCommission = page.locator("#partnership-detail .bg-c-list-item__description").nth(2);
        totalKamar = page.locator("#partnership-detail .bg-c-list-item__description").nth(3);
        tipeJp = page.locator("#partnership-detail .bg-c-list-item__description").nth(4);
        presentaseJp = page.locator("#partnership-detail .bg-c-list-item__description").nth(5);
        jumlahJp = page.locator("#partnership-detail .bg-c-list-item__description").nth(6);
        tipeAdp = page.locator("#partnership-detail .bg-c-list-item__description").nth(7);
        presentaseAdp = page.locator("#partnership-detail .bg-c-list-item__description").nth(8);
        jumlahAdp = page.locator("#partnership-detail .bg-c-list-item__description").nth(9);
        pendapatanPemilikBooking = page.locator("#partnership-detail .bg-c-list-item__description").nth(10);
        pendapatanMamikosBooking = page.locator("#partnership-detail .bg-c-list-item__description").nth(11);
        jangkaWaktu = page.locator("#partnership-detail .bg-c-list-item__description").nth(12);
        awalKerjaSama = page.locator("#partnership-detail .bg-c-list-item__description").nth(13);
        akhirKerjaSama = page.locator("#partnership-detail .bg-c-list-item__description").nth(14);
        biayaKeanggotaan = page.locator("#partnership-detail .bg-c-list-item__description").nth(15);
        ubahDetailKerjaSamaButton = page.locator("#partnership-detail").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Ubah"));
        hybridSection = page.getByText("Ketentuan Komisi dari Penyewa DBET");
        pendapatanPemilikDbet = page.locator("#partnership-detail .bg-c-list-item__description").nth(12);
        pendapatanMamikosDbet = page.locator("#partnership-detail .bg-c-list-item__description").nth(13);

        jenisProdukSelect = page.locator(".bg-c-select").first();
        modelKerjaSamaSelect = page.locator(".bg-c-select").nth(1);
        basiCommissionInput = page.locator(".bg-c-input__field").first();
        tipeJpSelect = page.locator(".bg-c-select").nth(2);
        tipeJpNone = page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("None")).locator("a");
        presentaseJpInput = page.locator(".bg-c-input__field").nth(2);
        jumlahJpInput = page.locator(".bg-c-input__field").nth(3);
        tipeAdpSelect = page.locator(".bg-c-select").nth(3);
        tipeAdpNone = page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("None")).locator("a");
        presentaseAdpInput = page.locator(".bg-c-input__field").nth(4);
        jumlahAdpInput = page.locator(".bg-c-input__field").nth(5);
        hybridButton = page.locator(".bg-c-switch__input");
        hybridButtonOff = page.locator(".bg-c-switch--off");
        penpadatanDbetMamikosInput = page.locator(".bg-c-input__field").nth(9);
        jangkaWaktuKerjaSamaInput = page.getByRole(AriaRole.TEXTBOX).filter(new Locator.FilterOptions().setHasText("Bulan")).getByRole(AriaRole.TEXTBOX);
        biayaKeanggotaanInput = page.getByTestId("input-currency-masking").last();
    }

    /**
     * Go to Kontrak Kerja Sama tab
     */
    public void clickKontrakKerjaSamaTab() {
        kontrakKerjaSamaTab.click();
        page.waitForLoadState();
    }

    /**
     * Assert Nama Pemilik - Profil Pemilik Section
     * @param nama
     */
    public void assertNamaPemilik(String nama) {
        sectionOwnerProfile.waitFor();
        assertThat(namaPemilik).hasText(nama);
    }

    /**
     * Assert No HP Pemilik - Profil Pemilik Section
     * @param noHP
     */
    public void assertNoHPPemilik(String noHP) {
        assertThat(nomorHPPemilik).hasText(noHP);
    }

    /**
     * Assert Alamat Pemilik - Profil Pemilik Section
     * @param alamat
     */
    public void assertAlamatPemilik(String alamat) {
        assertThat(alamatPemilik).hasText(alamat);
    }

    /**
     * Assert Provinsi Pemilik - Profil Pemilik Section
     * @param provinsi
     */
    public void assertProvinsiPemilik(String provinsi) {
        assertThat(provinsiPemilik).hasText(provinsi);
    }

    /**
     * Assert Kota Pemilik - Profil Pemilik Section
     * @param kota
     */
    public void assertKotaPemilik(String kota) {
        assertThat(kotaPemilik).hasText(kota);
    }

    /**
     * Assert Kecamatan Pemilik - Profil Pemilik Section
     * @param kecamatan
     */
    public void assertKecamatanPemilik(String kecamatan) {
        assertThat(kecamatanPemilik).hasText(kecamatan);
    }

    /**
     * Assert Kelurahan Pemilik - Profil Pemilik Section
     * @param kelurahan
     */
    public void assertKelurahanPemilik(String kelurahan) {
        assertThat(kelurahanPemilik).hasText(kelurahan);
    }

    /**
     * Ubah Profil Pemilik
     */
    public void ubahProfilPemilik() {
        ubahProfilPemilikButton.click();
    }

    /**
     * Edit Nama Pemilik - Profil Pemilik Section
     * @param nama
     */
    public void editNamaPemilik(String nama) {
        namaPemilikInput.fill(nama);
    }

    /**
     * Edit No HP Pemilik  - Profil Pemilik Section
     * @param noHP
     */
    public void editNoHPPemilik(String noHP) {
        noHPPemilikInput.fill(noHP);
    }

    public void editAlamatPemilik(String alamat) {
        alamatPemilikInput.fill(alamat);
    }

    /**
     * Edit Provinsi Pemilik - Profil Pemilik Section
     * @param provinsi
     */
    public void editProvinsiPemilik(String provinsi) {
        provinsiPemilikInput.click();
        dropdownOptions.filter(new Locator.FilterOptions().setHasText(provinsi)).click();
    }

    /**
     * Edit Kota Pemilik - Profil Pemilik Section
     * @param kota
     */
    public void editKotaPemilik(String kota) {
        kotaPemilikInput.click();
        dropdownOptions.filter(new Locator.FilterOptions().setHasText(kota)).click();
    }

    /**
     * Edit Kecamatan Pemilik - Profil Pemilik Section
     * @param kecamatan
     */
    public void editKecamatanPemilik(String kecamatan) {
        kecamatanPemilikInput.click();
        dropdownOptions.filter(new Locator.FilterOptions().setHasText(kecamatan)).click();
    }

    /**
     * Edit Kelurahan Pemilik - Profil Pemilik Section
     * @param kelurahan
     */
    public void editKelurahanPemilik(String kelurahan) {
        kelurahanPemilikInput.click();
        dropdownOptions.filter(new Locator.FilterOptions().setHasText(kelurahan)).click();
    }

    /**
     * Save ubah Profil Pemilik
     */
    public void submitEditProfilPemilik() {
        simpanButton.click();
        confirmSimpanButton.click();
    }

    /**
     * Assert No Rekening in Kontrak Kerja Sama tab, Informasi Transfer Pendapatan section
     * @param noRek
     */
    public void assertNoRekening(String noRek) {
        assertThat(nomorRekening).hasText(noRek);
    }

    /**
     * Assert Nama Bank in Kontrak Kerja Sama tab, Informasi Transfer Pendapatan section
     * @param bankName
     */
    public void assertNamaBank(String bankName) {
        assertThat(namaBank).hasText(bankName);
    }

    /**
     * Assert Cabang Bank in Kontrak Kerja Sama tab, Informasi Transfer Pendapatan section
     * @param branch
     */
    public void assertCabangBank(String branch) {
        assertThat(cabangBank).hasText(branch);
    }

    /**
     * Assert Nama Pemilik Rekening in Kontrak Kerja Sama tab, Informasi Transfer Pendapatan section
     * @param pemilik
     */
    public void assertNamaPemilikRekening(String pemilik) {
        assertThat(namaPemilikRekening).hasText(pemilik);
    }

    /**
     * Assert Tanggal Transfer ke Pemilik in Kontrak Kerja Sama tab, Informasi Transfer Pendapatan section
     * @param tanggalTransfer
     */
    public void assertTanggalTransfer(String tanggalTransfer) {
        assertThat(tanggalTransferPemilik).hasText(tanggalTransfer);
    }

    /**
     * Click Ubah in Informasi Transfer Pendapatan
     */
    public void ubahInformasiTransferPendapatan() {
        ubahInformasiTransferPendapatanButton.waitFor();
        ubahInformasiTransferPendapatanButton.click();
    }

    /**
     * Nomor Rekening field in Edit Informasi Transfer Pendapatan form
     * @param noRek
     */
    public void editNoRekening(String noRek) {
        nomorRekeningInput.fill(noRek);
    }

    /**
     * Nama Bank field in Edit Informasi Transfer Pendapatan form
     * @param bankName
     */
    public void editNamaBank(String bankName) {
        Locator bank = page.locator("a").filter(new Locator.FilterOptions().setHasText(bankName)).first();
        namaBankSelect.click();
        namaBankInput.fill(bankName);
        bank.click();
    }

    /**
     * Cabang Bank field in Edit Informasi Transfer Pendapatan form
     * @param branch
     */
    public void editCabangBank(String branch) {
        cabangBankInput.fill(branch);
    }

    /**
     * Nama Pemilik Rekening in Edit Informasi Transfer Pendapatan form
     * @param pemilik
     */
    public void editNamaPemilikBank(String pemilik) {
        namaPemilikRekeningInput.fill(pemilik);
    }

    /**
     * Tanggal Transfer in Edit Informasi Transfer Pendapatan form
     * @param tanggalTransfer
     */
    public void editTanggalTransfer(String tanggalTransfer) {
        Locator tanggal = page.locator("a").filter(new Locator.FilterOptions().setHasText(tanggalTransfer));

        tanggalTransferPemilikSelect.click();
        tanggal.click();
    }

    /**
     * Simpan edit Informasi Transfer Pendapatan
     */
    public void submitEditInformasiTransferPendapatan() {
        simpanButton.click();
        confirmSimpanButton.click();
    }

    /**
     * scroll to view section detail kerja sama
     */
    public void viewScetionDetailKerjaSama() {
        detailKerjaSamaSection.waitFor();
        detailKerjaSamaSection.scrollIntoViewIfNeeded();
    }

    /**
     * Assert model kerja sama section
     * @param produk
     * @param model
     * @param commission
     * @param roomTotal
     */
    public void assertModelKerjaSama(String produk, String model, String commission, String roomTotal) {
        assertThat(jenisProduk).hasText(produk);
        assertThat(modelKerjaSama).hasText(model);
        assertThat(basicCommission).hasText(commission);
        assertThat(totalKamar).hasText(roomTotal);
    }

    /**
     * Assert Revenue share section
     * @param jpType
     * @param jpPrecentage
     * @param jpAmount
     * @param adpType
     * @param adpPrecentage
     * @param adpAmount
     * @param revBookingPemilik
     * @param revBookingMamikos
     */
    public void assertRevenuShare(String jpType, String jpPrecentage, String jpAmount, String adpType, String adpPrecentage, String adpAmount, String revBookingPemilik, String revBookingMamikos) {
        assertThat(tipeJp).hasText(jpType);
        assertThat(presentaseJp).hasText(jpPrecentage);
        assertThat(jumlahJp).hasText(jpAmount);
        assertThat(tipeAdp).hasText(adpType);
        assertThat(presentaseAdp).hasText(adpPrecentage);
        assertThat(jumlahAdp).hasText(adpAmount);
        assertThat(pendapatanPemilikBooking).hasText(revBookingPemilik);
        assertThat(pendapatanMamikosBooking).hasText(revBookingMamikos);
    }

    /**
     * assert contract section
     * @param month
     * @param start
     * @param end
     * @param fee
     */
    public void assertContractDuration(String month, String start, String end, String fee) {
        assertThat(jangkaWaktu).hasText(month);
        assertThat(awalKerjaSama).hasText(start);
        assertThat(akhirKerjaSama).hasText(end);
        assertThat(biayaKeanggotaan).hasText(fee);
    }

    /**
     * click ubah detail kerja sama
     */
    public void ubahDetailKerjaSama() {
        ubahDetailKerjaSamaButton.click();
    }

    /**
     * edit Jenis Produk
     * @param produk
     */
    public void editJenisProduk(String produk) {
        jenisProdukSelect.click();
        dropdownOptions.filter(new Locator.FilterOptions().setHasText(produk)).click();
    }

    /**
     * edit model kerja sama
     * @param model
     */
    public void editModelKerjaSama(String model) {
        modelKerjaSamaSelect.click();
        dropdownOptions.filter(new Locator.FilterOptions().setHasText(model)).click();
    }

    /**
     * edit Basic Commission
     * @param commission
     */
    public void editBasicCommission(String commission) {
        basiCommissionInput.fill(commission);
    }

    /**
     * edit revenue share JP
     * @param jpType
     * @param jpPrecentage
     * @param jpAmount
     */
    public void editJp(String jpType, String jpPrecentage, String jpAmount) {
        tipeJpSelect.scrollIntoViewIfNeeded();
        if (jpType.equalsIgnoreCase("none")){
            tipeJpSelect.click();
            tipeJpNone.click();
        } else {
            tipeJpSelect.click();
            dropdownOptions.filter(new Locator.FilterOptions().setHasText(jpType)).click();
            presentaseJpInput.fill(jpPrecentage);
            jumlahJpInput.fill(jpAmount);
        }
    }

    /**
     * edit revenue share ADP
     * @param adpType
     * @param adpPrecentage
     * @param adpAmount
     */
    public void editAdp(String adpType, String adpPrecentage, String adpAmount) {
        tipeAdpSelect.scrollIntoViewIfNeeded();
        if (adpType.equalsIgnoreCase("none")){
            tipeAdpSelect.click();
            tipeAdpNone.click();
        } else {
            tipeAdpSelect.click();
            dropdownOptions.filter(new Locator.FilterOptions().setHasText(adpType)).click();
            presentaseAdpInput.fill(adpPrecentage);
            jumlahAdpInput.fill(adpAmount);
        }
    }

    /**
     * Edit jangka waktu kerja sama
     * @param month
     */
    public void editJangkaWaktuKerjaSama(String month) {
        jangkaWaktuKerjaSamaInput.scrollIntoViewIfNeeded();
        jangkaWaktuKerjaSamaInput.fill(month);
    }

    /**
     * Edit biaya keanggotaan
     * @param fee
     */
    public void editBiayaKeanggotaan(String fee) {
        biayaKeanggotaanInput.scrollIntoViewIfNeeded();
        biayaKeanggotaanInput.fill(fee);
    }

    /**
     * Save edit detail kerja sama
     */
    public void submitEditDetailKerjaSama() {
        simpanButton.scrollIntoViewIfNeeded();
        simpanButton.click();
        confirmSimpanButton.click();
    }

    /**
     * turn on and set hybrid precentage value
     * @param precentage
     */
    public void setHybridRevenue(String precentage) {
        if (hybridButtonOff.isVisible()){
            hybridButton.scrollIntoViewIfNeeded();
            hybridButton.click();
            penpadatanDbetMamikosInput.fill(precentage);
        }
    }

    /**
     * turn off hybrid revenue share
     */
    public void turnOffHybridRevenue() {
        if (!hybridButtonOff.isVisible()){
            hybridButton.click();
        }
    }

    /**
     * Assert hybrid revenue section
     * @param state hidden / visible
     */
    public void assertHybridContractSection(String state) {
        if (state.equalsIgnoreCase("visible")){
            assertThat(hybridSection).isVisible();
        } else if (state.equalsIgnoreCase("hidden")) {
            assertThat(hybridSection).isHidden();
        }
    }

    /**
     * Assert hybrid revenue share
     * @param precentagePemilik
     * @param precentageMamikos
     */
    public void assertHybridRevenue(String precentagePemilik, String precentageMamikos) {
        assertThat(pendapatanPemilikDbet).hasText(precentagePemilik);
        assertThat(pendapatanMamikosDbet).hasText(precentageMamikos);
    }
}
