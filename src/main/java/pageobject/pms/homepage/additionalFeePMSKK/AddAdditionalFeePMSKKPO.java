package pageobject.pms.homepage.additionalFeePMSKK;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import config.global.GlobalConfig;
import utilities.PlaywrightHelpers;
import com.microsoft.playwright.options.AriaRole;

public class AddAdditionalFeePMSKKPO {

    private Page page;
    PlaywrightHelpers playwright;

    private Locator pilihNamaBiayaDropdown;
    private Locator fieldCari;
    private Locator suggestionNamaBiaya;
    private Locator ketentuanBagiHasil;
    private Locator jenisBiayaChecked;
    private Locator satuanWaktuDropdown;
    private Locator satuanWaktu;
    private Locator tambahBtnInTambahBiayaTambahan;
    private Locator satuanBesaranDropdown;
    private Locator satuanBesaran;
    private Locator hargaField;
    private Locator jenisBiayaRadioBtn;
    private Locator termasukHargaSewaChecked;
    private Locator pengaturanRincianSewa;
    private Locator suggestionNamaBiayaLaundry;
    private Locator fieldManualBagiHasil;

    public AddAdditionalFeePMSKKPO(Page page){
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        pilihNamaBiayaDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih nama biaya dropdown-down"));
        fieldCari = page.getByPlaceholder("Cari");
        suggestionNamaBiaya = page.getByTestId("additional-fee-modal").locator("a");
        satuanWaktuDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih satuan waktu biaya dropdown-down"));
        tambahBtnInTambahBiayaTambahan = page.getByTestId("additional-fee-modal").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Tambah"));
        satuanBesaranDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih satuan besaran biaya dropdown-down"));
        suggestionNamaBiayaLaundry = page.locator("(//a[@class='bg-c-dropdown__menu-item bg-u-radius-md'][contains(., 'Laundry')])[3]");
        fieldManualBagiHasil = page.getByTestId("commission-percentage-field").nth(1);
    }

    /**
     * Search Nama Biaya Tambahan in Tambah Biaya Tambahan pop up
     * @param biaya
     */
    public void searchNamaBiayaTambahan(String biaya) {
        playwright.clickOn(pilihNamaBiayaDropdown);
        playwright.fill(fieldCari, biaya);
        playwright.clickOn(suggestionNamaBiaya);
    }

    /**
     * Selects Ketentuan Bagi Hasil in Tambah Biaya Tambahan pop up
     * @param bagiHasil
     */
    public void selectsKetentuanBagiHasil(String bagiHasil) {
        playwright.waitTillPageLoaded(GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT);
        ketentuanBagiHasil = page.locator("//div[@class='bg-c-list-item__description']/p[contains(., '" +bagiHasil+ "')]");
        playwright.clickOn(ketentuanBagiHasil);
    }

    /**
     * Check Is Auto Select Jenis Biaya Checked in Tambah Biaya Tambahan pop up
     * @param jenisBiaya
     */
    public void isAutoSelectsJenisBiayaChecked(String jenisBiaya) {
        jenisBiayaChecked = page.getByText(jenisBiaya);
        playwright.isRadioButtonChecked(jenisBiayaChecked);
    }

    /**
     * Selects Satuan Waktu in Tambah Biaya Tambahan pop up
     * @param waktu
     */
    public void selectsSatuanWaktu(String waktu) {
        satuanWaktu = page.locator("//div[@data-testid='search-checkbox-dropdown']//p[contains(text(), '" +waktu+ "')]");
        playwright.clickOn(satuanWaktuDropdown);
        playwright.clickOn(satuanWaktu);
    }

    /**
     * Clicks Tambah button in Tambah Biaya Tambahan pop up
     */
    public void clicksTambahButtonInBiayaTambahanPopUp() {
        playwright.clickOn(tambahBtnInTambahBiayaTambahan);
    }

    /**
     * Selects Satuan Besaran in Tambah Biaya Tambahan pop up
     */
    public void selectsSatuanBesaran() {
        satuanBesaran = page.getByTestId("modal-specific-information").locator("a");
        playwright.clickOn(satuanBesaranDropdown);
        playwright.clickOn(satuanBesaran);
    }

    /**
     * Inputs Harga at Satuan Waktu field in Tambah Biaya Tambahan pop up
     * @param harga
     */
    public void inputsHarga(String harga) {
        hargaField = page.getByTestId("input-currency-masking");
        playwright.fill(hargaField, harga);
    }

    /**
     * Select Jenis Biaya in Tambah Biaya Tambahan pop up
     * @param jenisBiaya
     */
    public void selectsJenisBiaya(String jenisBiaya) {
        jenisBiayaRadioBtn = page.locator("//div[@class='bg-c-list-item__description']/p[contains(., '" +jenisBiaya+ "')]");
        playwright.clickOn(jenisBiayaRadioBtn);
    }

    /**
     * Check Is Auto Selects Biaya Termasuk Harga Sewa Checked in Tambah Biaya Tambahan pop up
     * @param biayaTermasukHargaSewa
     */
    public void isAutoSelectsBiayaTermasukHargaSewaChecked(String biayaTermasukHargaSewa) {
        termasukHargaSewaChecked = page.locator("//div[@class='bg-c-list-item__description']/p[contains(., '" +biayaTermasukHargaSewa+ "')]");
        playwright.isRadioButtonChecked(termasukHargaSewaChecked);
    }

    /**
     * Check Is Auto Selects Pengaturan Rincian Sewa in Tambah Biaya Tambahan pop up
     * @param pengaturanDiRincianSewa
     */
    public void isAutoSelectsPengaturanRincianSewa(String pengaturanDiRincianSewa) {
        pengaturanRincianSewa = page.locator("//div[@class='bg-c-list-item__description']/p[contains(., '" +pengaturanDiRincianSewa+ "')]");
        playwright.isRadioButtonChecked(pengaturanRincianSewa);
    }

    /**
     * Search Nama Biaya Laundry in Tambah Biaya Tambahan pop up
     * @param namaBiaya
     */
    public void searchNamaBiayaLaundry(String namaBiaya) {
        playwright.clickOn(pilihNamaBiayaDropdown);
        playwright.fill(fieldCari, namaBiaya);
        playwright.clickOn(suggestionNamaBiayaLaundry);
    }

    /**
     * Inputs Manual Bagi Hasil in Tambah Biaya Tambahan pop up
     * @param amount
     */
    public void inputsManualBagiHasil(String amount) {
        playwright.waitTillPageLoaded(GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT);
        playwright.fill(fieldManualBagiHasil, amount);
    }
}
