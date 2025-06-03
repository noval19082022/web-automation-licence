package pageobject.pms.homepage.additionalFeePMSKK;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import config.global.GlobalConfig;
import utilities.PlaywrightHelpers;

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
    private Locator ubahBtnInTambahBiayaTambahan;
    private Locator satuanBesaranDropdown;
    private Locator satuanBesaran;
    private Locator hargaField;
    private Locator jenisBiayaRadioBtn;
    private Locator termasukHargaSewaChecked;
    private Locator pengaturanRincianSewa;
    private Locator suggestionNamaBiayaLaundry;
    private Locator fieldManualBagiHasil;
    private Locator toggleTerapkankeSemuaListingOn;
    private Locator toggleTerapkankeSemuaListingOff;
    private Locator dropdownListing;
    private Locator dropdownListingOptions;
    private Locator closeButton;
    private Locator ketentuanBagiHasilRadioBtn;
    private Locator satuanBesaranBiayaDropdown;
    private Locator feeUnitRadioButton;
    private Locator feeOptionRadioButton;
    private Locator satuanBiaya;
    private Locator satuanWaktuBiayaDropdown;

    public AddAdditionalFeePMSKKPO(Page page){
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        pilihNamaBiayaDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih nama biaya dropdown-down"));
        fieldCari = page.getByPlaceholder("Cari");
        suggestionNamaBiaya = page.getByTestId("additional-fee-modal").locator("a");
        satuanWaktuDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih satuan waktu biaya dropdown-down"));
        tambahBtnInTambahBiayaTambahan = page.getByTestId("additional-fee-modal").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Tambah"));
        ubahBtnInTambahBiayaTambahan = page.getByTestId("additional-fee-modal").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Ubah"));
        satuanBesaranDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih satuan besaran biaya dropdown-down"));
        suggestionNamaBiayaLaundry = page.locator("(//a[@class='bg-c-dropdown__menu-item bg-u-radius-md'][contains(., 'Laundry')])[3]");
        fieldManualBagiHasil = page.getByTestId("commission-percentage-field").nth(1);
        toggleTerapkankeSemuaListingOn = page.locator(".bg-c-switch--on").last();
        toggleTerapkankeSemuaListingOff = page.locator(".bg-c-switch--off").last();
        dropdownListing = page.locator(".search-checkbox__trigger", new Page.LocatorOptions().setHasText("Pilih listing yang akan diterapkan"));
        closeButton = page.locator(".bg-c-modal__action-closable");
        satuanBesaranBiayaDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih satuan besaran biaya"));
        satuanWaktuBiayaDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih satuan waktu biaya"));
    }

    /**
     * Search Nama Biaya Tambahan in Tambah Biaya Tambahan pop up
     * @param biaya
     */
    public void selectFeeName(String biaya) {
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
     * @param price
     */
    public void setPrice(String price) {
        hargaField = page.getByTestId("input-currency-masking");
        playwright.fill(hargaField, price);
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

    /**
     * Only search fee in Tambah Biaua Tambahan pop up
     * @param feeName
     */
    public void searchFee(String feeName) {
        playwright.clickOn(pilihNamaBiayaDropdown);
        playwright.fill(fieldCari, feeName);
    }

    /**
     * Check if fee not found
     * @return boolean
     */
    public boolean isFeeNotFound() {
        return playwright.isTextDisplayed("There is no data");
    }

    /**
     * set toggle Terapkan ke Semua Listing to Off
     */
    public void switchToggleTerapkanKeSemuaListingOff() {
        playwright.clickOn(toggleTerapkankeSemuaListingOn);
    }

    /**
     * set toggle Terapkan ke Semua Listing to On
     */
    public void switchToggleTerapkanKeSemuaListingOn() {
        playwright.clickOn(toggleTerapkankeSemuaListingOff);
    }

    /**
     * Check if dropdown listing appear
     * @return boolean
     */
    public boolean isDropdownPilihListingAppear() {
        return playwright.isLocatorVisibleAfterLoad(dropdownListing,10000.0);
    }

    /**
     * Get listing name in Pilih Listing dropdown
     * @param index
     * @return String
     */
    public String getListingNameOptions(int index) {
        dropdownListingOptions = page.locator(".search-checkbox__checkbox p").nth(index);
        return playwright.getText(dropdownListingOptions);
    }

    /**
     * Select listing name in Pilih Listing dropdown
     * @param listingName
     */
    public void checkListing(String listingName) {
        dropdownListingOptions = page.locator("label").filter(new Locator.FilterOptions().setHasText("checkmark"+listingName)).locator("span");
        playwright.clickOn(dropdownListingOptions);
    }

    /**
     * Close Tambah Biaya Tambahan Modal
     */
    public void clickCloseButton() {
        playwright.clickOn(closeButton);
    }

    /**
     * Click Dropdown Listing
     */
    public void clickDropdownListing() {
        playwright.clickOn(dropdownListing);
    }

    /**
     * Choose Provit Sharing Provision
     * @param sharing
     */
    public void chooseProvitSharingProvision(String sharing) {
        ketentuanBagiHasilRadioBtn = page.getByTestId("additional-fee-modal").getByText(sharing);
        playwright.clickOn(ketentuanBagiHasilRadioBtn);
    }

    /**
     * Click Satuan Besaran Dropdown
     */
    public void clickSatuanBesaranBiayaDropdown() {
        playwright.clickOn(satuanBesaranBiayaDropdown);
    }

    /**
     * Select Unit Fee
     */
    public void selectUnitFee() {
        feeUnitRadioButton = page.getByTestId("modal-specific-information").locator("a");
        playwright.clickOn(feeUnitRadioButton);
    }

    /**
     * Choose Fee Option
     * @param feeOption
     */
    public void chooseFeeOption(String feeOption) {
        feeOptionRadioButton = page.locator("label").filter(new Locator.FilterOptions().setHasText(feeOption));
        playwright.clickOn(feeOptionRadioButton);
    }

    /**
     * Clicks Ubah button in Biaya Tambahan pop up
     */
    public void clicksEditButtonInBiayaTambahanPopUp() {
        playwright.clickOn(ubahBtnInTambahBiayaTambahan);
    }

    /**
     * Click on Satuan Waktu Biaya Dropdown
     */
    public void clickSatuanWaktuBiayaDropdown() {
        playwright.clickOn(satuanWaktuBiayaDropdown);
    }

    /**
     * Select satuan waktu biaya
     * @param satuan
     */
    public void selectSatuanWaktuBiaya(String satuan) {
        satuanBiaya = page.locator("label").filter(new Locator.FilterOptions().setHasText(satuan)); //page.getByText("checkmarkBulanan")
        playwright.clickOn(satuanBiaya);
    }
}
