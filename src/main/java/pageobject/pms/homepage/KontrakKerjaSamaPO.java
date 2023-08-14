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
}
