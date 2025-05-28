package pageobject.pms.homepage.additionalFeePMSKK;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class AdditionalFeePMSKKPO {

    private Page page;
    PlaywrightHelpers playwright;

    private Locator emptyState;
    private Locator tambahBiayaBtn;
    private Locator namaBiayaInTable;
    private Locator penyewaPilihMandiriInTable;
    private Locator jenisBiayaInTable;
    private Locator termasukDiDalamHargaSewaInTable;
    private Locator tipePembayaranBiayaInTable;
    private Locator ketentuanBagiHasilInTable;
    private Locator totalListingAdditionalFee;
    private Locator listingName;
    private Locator expandBtn;
    private Locator hargaInListing;
    private Locator kebabBtn;
    private Locator editOnTypeButton;
    private Locator deleteOnTypeButton;
    private Locator deleteConfirmationButton;

    public AdditionalFeePMSKKPO(Page page){
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        emptyState = page.getByText("Tidak ada data yang ditampilkan");
        tambahBiayaBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tambah Biaya"));
        totalListingAdditionalFee = page.locator(".additional-fee-content__table-body-price-table tbody tr");
        expandBtn = page.locator("//button[@class='bg-c-button bg-c-button--tertiary bg-c-button--sm']");
        kebabBtn = page.locator("//div[@data-testid='additional-fee-action']");
        deleteConfirmationButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hapus").setExact(true));
    }

    /**
     * Get String Empty State in Biaya Tambahan table
     * @return String Empty State
     */
    public String emptyState() {
        return playwright.getText(emptyState);
    }

    /**
     * Clicks Tambah Biaya button in Biaya Tambahan table
     */
    public void clickAddFeeButton() {
        playwright.clickOn(tambahBiayaBtn);
    }

    /**
     * Get String Nama Biaya in Biaya Tambahan table
     * @param biaya
     * @return String Nama Biaya
     */
    public String getNamaBiayaInTable(String biaya) {
        namaBiayaInTable = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(biaya));
        return playwright.getText(namaBiayaInTable);
    }

    /**
     * Get String Penyewa Bisa Pilih Mandiri in Biaya Tambahan table
     * @param pilihMandiri
     * @return String Penyewa Bisa Pilih Mandiri
     */
    public String getPenyewaBisaPilihMandiri(String pilihMandiri) {
        penyewaPilihMandiriInTable = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(pilihMandiri)).first();
        return playwright.getText(penyewaPilihMandiriInTable);
    }

    /**
     * Get String Jenis Biaya in Biaya Tambahan table
     * @param jenisBiaya
     * @return String Jenis Biaya
     */
    public String getJenisBiaya(String jenisBiaya) {
        jenisBiayaInTable = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(jenisBiaya)).first();
        return playwright.getText(jenisBiayaInTable);
    }

    /**
     * Get String Termasuk Di Dalam Harga Sewa in Biaya Tambahan table
     * @return String Termasuk Di Dalam Harga Sewa
     */
    public String getTermasukDiDalamHargaSewa() {
        termasukDiDalamHargaSewaInTable = page.locator(".additional-fee-content__table-body tr td:nth-of-type(5)").first();
        return playwright.getText(termasukDiDalamHargaSewaInTable);
    }

    /**
     * Get String Tipe Pembayaran Biaya in Biaya Tambahan table
     * @param tipePembayaranBiaya
     * @return String Tipe Pembayaran Biaya
     */
    public String getTipePembayaranBiaya(String tipePembayaranBiaya) {
        tipePembayaranBiayaInTable = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(tipePembayaranBiaya)).first();
        return playwright.getText(tipePembayaranBiayaInTable);
    }

    /**
     * Get String Ketentuan Bagi Hasil in Biaya Tambahan table
     * @param ketentuanBagiHasil
     * @return String Ketentuan Bagi Hasil
     */
    public String getKetentuanBagiHasil(String ketentuanBagiHasil) {
        ketentuanBagiHasilInTable = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(ketentuanBagiHasil)).first();
        return playwright.getText(ketentuanBagiHasilInTable);
    }

    /**
     * Get Total Listing in Biaya Tambahan table
     * @return Total Listing
     */
    public int getTotalListing() {
        return totalListingAdditionalFee.count();
    }

    /**
     * Get String Nama Listing in Biaya Tambahan table
     * @param indexListing
     * @return String Nama Listing
     */
    public String getListing(int indexListing) {
        listingName = page.locator("tbody:first-of-type :nth-of-type(1) > p");
        return playwright.getText(listingName.nth(indexListing+1));
    }

    /**
     * Clicks Expand button in Biaya Tambahan table
     */
    public void expandAddFee() {
        playwright.clickOn(expandBtn);
    }

    /**
     * Get String Harga Disesuaikan dengan Tagihan in Biaya Tambahan table
     * @param indexHarga
     * @return String Harga Disesuaikan dengan Tagihan
     */
    public String getHargaDisesuaikanDenganTagihan(int indexHarga) {
        hargaInListing = page.locator("tbody:first-of-type :nth-of-type(2) > div");
        return playwright.getText(hargaInListing.nth(indexHarga+1));
    }

    /**
     * Get String Harga in Listing in Biaya Tambahan table
     * @param indexHarga
     * @return String Harga in Listing
     */
    public String getHargaInListing(int indexHarga) {
        hargaInListing = page.locator("tbody:first-of-type :nth-of-type(2) > p");
        return playwright.getText(hargaInListing.nth(indexHarga+1));
    }

    /**
     * Get Total Row in Biaya Tambahan table
     * @return Total Row
     */
    public int getTotalRow() {
        return expandBtn.count();
    }

    /**
     * Check if Kebab button is visible
     * @return kebab button
     */
    public boolean isKebabBtnVisible() {
        return playwright.isLocatorVisibleAfterLoad(kebabBtn, 10000.0);
    }

    /**
     * Click Edit On Type button
     * @param id
     */
    public void clickEditOnType(int id) {
        editOnTypeButton = page.getByTestId("ubah-listing-price-"+id);
        playwright.clickOn(editOnTypeButton);
    }

    /**
     * Click Delete On Type button
     * @param id
     */
    public void clickDeleteOnType(int id) {
        deleteOnTypeButton = page.getByTestId("hapus-listing-price-"+id);
        playwright.clickOn(deleteOnTypeButton);
        playwright.clickOn(deleteConfirmationButton);
    }
}