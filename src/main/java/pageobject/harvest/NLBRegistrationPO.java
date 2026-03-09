package pageobject.harvest;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import data.mamikos.Mamikos;
import utilities.PlaywrightHelpers;

public class NLBRegistrationPO {

    private Page page;
    private PlaywrightHelpers playwright;

    // Form fields
    private Locator namaPemilikKosField;
    private Locator nomorHPField;
    private Locator totalKamarDikelolaField;
    private Locator totalKamarTerisiField;
    private Locator tahunMulaiField;

    // Dropdown triggers
    private Locator kotaButton;
    private Locator kecamatanButton;
    private Locator kelurahanButton;
    private Locator cariField;
    private Locator suggestionText;

    // Price fields (appear after selecting tipe kamar)
    private Locator hargaSewaField;
    private Locator hargaTerendahField;
    private Locator hargaTertinggiField;

    // Submit
    private Locator daftarButton;

    // LBT Search
    private Locator lbtSearchInput;

    // Success
    private Locator successPopUpTitle;
    private Locator successPopUpButton;

    public NLBRegistrationPO(Page page) {
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        namaPemilikKosField = page.getByPlaceholder("Isi sesuai KTP");
        nomorHPField = page.getByPlaceholder("Nomor HP/WhatsApp");
        totalKamarDikelolaField = page.getByRole(AriaRole.SPINBUTTON,
                new Page.GetByRoleOptions().setName("Berapa total kamar yang dikelola di properti ini?"));
        totalKamarTerisiField = page.getByRole(AriaRole.SPINBUTTON,
                new Page.GetByRoleOptions().setName("Berapa total kamar yang terisi di properti ini?"));
        tahunMulaiField = page.getByPlaceholder("Tahun mulai disewakan");

        kotaButton = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Pilih kabupaten / kota kos Anda"));
        kecamatanButton = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Pilih kecamatan kos Anda"));
        kelurahanButton = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Pilih kelurahan kos Anda"));
        cariField = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Cari"));

        hargaSewaField = page.locator("input[placeholder='1.500.000']").first();
        hargaTerendahField = page.locator("input[placeholder='1.500.000']").first();
        hargaTertinggiField = page.locator("input[placeholder='1.500.000']").last();

        daftarButton = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Daftar").setExact(true));

        successPopUpTitle = page.getByRole(AriaRole.HEADING,
                new Page.GetByRoleOptions().setName("Terima kasih telah mendaftar!"));
        successPopUpButton = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Kembali ke Beranda"));

        // LBT Search - default search type is "No. HP Pemilik"
        lbtSearchInput = page.locator(".bg-c-searchbar input[type='text']");
    }

    /**
     * Navigate to NLB registration page
     */
    public void navigateToNLBRegistrationPage() {
        playwright.navigateTo(Mamikos.URL + "/naik-kelas/daftar", 30000.0, LoadState.LOAD);
    }

    /**
     * Fill Nama Pemilik Kos field
     * @param name owner name
     */
    public void fillNamaPemilikKos(String name) {
        playwright.fill(namaPemilikKosField, name);
    }

    /**
     * Fill Nomor HP field
     * @param phone phone number
     */
    public void fillNomorHP(String phone) {
        playwright.fill(nomorHPField, phone);
    }

    /**
     * Fill Total Kamar Dikelola field
     * @param totalKamar total rooms managed
     */
    public void fillTotalKamarDikelola(String totalKamar) {
        playwright.fill(totalKamarDikelolaField, totalKamar);
    }

    /**
     * Fill Total Kamar Terisi field
     * @param totalKamar total rooms occupied
     */
    public void fillTotalKamarTerisi(String totalKamar) {
        playwright.fill(totalKamarTerisiField, totalKamar);
    }

    /**
     * Select Kota from dropdown
     * @param kota city name
     */
    public void selectKota(String kota) {
        playwright.clickOn(kotaButton);
        playwright.fill(cariField, kota);
        suggestionText = page.locator("a").filter(new Locator.FilterOptions().setHasText(kota));
        playwright.clickOn(suggestionText);
    }

    /**
     * Select Kecamatan from dropdown
     * @param kecamatan district name
     */
    public void selectKecamatan(String kecamatan) {
        playwright.clickOn(kecamatanButton);
        playwright.fill(cariField, kecamatan);
        suggestionText = page.locator("a").filter(new Locator.FilterOptions().setHasText(kecamatan));
        playwright.clickOn(suggestionText);
    }

    /**
     * Select Kelurahan from dropdown
     * @param kelurahan sub-district name
     */
    public void selectKelurahan(String kelurahan) {
        playwright.clickOn(kelurahanButton);
        playwright.fill(cariField, kelurahan);
        suggestionText = page.locator("a").filter(new Locator.FilterOptions().setHasText(kelurahan));
        playwright.clickOn(suggestionText);
    }

    /**
     * Fill Tahun Mulai Disewakan field
     * @param tahun year
     */
    public void fillTahunMulaiDisewakan(String tahun) {
        playwright.fill(tahunMulaiField, tahun);
    }

    /**
     * Select Tipe Kamar radio button
     * @param tipeKamar "Ya" or "Tidak"
     */
    public void selectTipeKamar(String tipeKamar) {
        Locator radio = page.getByRole(AriaRole.RADIO,
                new Page.GetByRoleOptions().setName(tipeKamar)).first();
        playwright.forceClickOn(radio);
    }

    /**
     * Fill Harga Sewa Kamar per Bulan (shown when Tipe Kamar = Tidak)
     * @param harga price
     */
    public void fillHargaSewa(String harga) {
        playwright.fill(hargaSewaField, harga);
    }

    /**
     * Fill Harga Terendah Sewa Kamar per Bulan (shown when Tipe Kamar = Ya)
     * @param harga lowest price
     */
    public void fillHargaTerendah(String harga) {
        playwright.fill(hargaTerendahField, harga);
    }

    /**
     * Fill Harga Tertinggi Sewa Kamar per Bulan (shown when Tipe Kamar = Ya)
     * @param harga highest price
     */
    public void fillHargaTertinggi(String harga) {
        playwright.fill(hargaTertinggiField, harga);
    }

    /**
     * Select Jenis Renovasi radio button
     * @param renovasi "Renovasi Bangunan" or "Penambahan Fasilitas"
     */
    public void selectRenovasi(String renovasi) {
        Locator radio = page.getByRole(AriaRole.RADIO,
                new Page.GetByRoleOptions().setName(renovasi));
        playwright.forceClickOn(radio);
    }

    /**
     * Select renovation item checkbox
     * @param item "Perbaikan Bangunan" or "Penambahan Kamar"
     */
    public void selectItemRenovasi(String item) {
        Locator checkbox = page.getByRole(AriaRole.CHECKBOX,
                new Page.GetByRoleOptions().setName(item));
        playwright.forceClickOn(checkbox);
    }

    /**
     * Fill renovation explanation textarea
     * @param penjelasan explanation text
     */
    public void fillPenjelasanRenovasi(String penjelasan) {
        Locator textbox = page.getByRole(AriaRole.TEXTBOX,
                new Page.GetByRoleOptions().setName("Berikan penjelasan singkat terkait kebutuhan Anda"));
        playwright.fill(textbox, penjelasan);
    }

    /**
     * Select Pemilik Kos di Mamikos radio button
     * @param pemilik "Ya" or "Tidak"
     */
    public void selectPemilikMamikos(String pemilik) {
        Locator radio = page.getByRole(AriaRole.RADIO,
                new Page.GetByRoleOptions().setName(pemilik)).last();
        playwright.forceClickOn(radio);
    }

    /**
     * Click Daftar button to submit form
     */
    public void clickDaftarButton() {
        playwright.clickOn(daftarButton);
    }

    /**
     * Get success pop up title text
     * @return success message title
     */
    public String getSuccessPopUpTitle() {
        playwright.waitTillLocatorIsVisible(successPopUpTitle);
        return playwright.getText(successPopUpTitle);
    }

    /**
     * Check if success pop up is visible
     * @return true if visible
     */
    public boolean isSuccessPopUpVisible() {
        return playwright.isLocatorVisibleAfterLoad(successPopUpTitle, 10000.0);
    }

    /**
     * Close success pop up
     */
    public void closeSuccessPopUp() {
        playwright.clickOn(successPopUpButton);
    }

    /**
     * Search leads in LBT by phone number (default search type is "No. HP Pemilik")
     * @param phoneNumber phone number to search
     */
    public void searchLBTByPhoneNumber(String phoneNumber) {
        playwright.waitTillPageLoaded();
        lbtSearchInput.fill(phoneNumber);
        playwright.pressKeyboardKey("Enter");
        playwright.hardWait(3000);
    }

    /**
     * Check if phone number is found in LBT table
     * @param phoneNumber phone number to find
     * @return text content of the matching cell, or null if not found
     */
    public String getPhoneNumberInLBT(String phoneNumber) {
        playwright.waitTillPageLoaded();
        Locator cell = page.getByText(phoneNumber);
        return playwright.getText(cell);
    }

    /**
     * Check if phone number exists in LBT table
     * @param phoneNumber phone number to check
     * @return true if found, false otherwise
     */
    public boolean isPhoneNumberInLBT(String phoneNumber) {
        Locator cell = page.getByText(phoneNumber);
        return playwright.isLocatorVisibleAfterLoad(cell, 5000.0);
    }

    /**
     * Get leads status text from LBT table for a specific phone number row
     * @param phoneNumber phone number to locate the row
     * @return status text
     */
    public String getLeadsStatus(String phoneNumber) {
        Locator row = page.locator("tr").filter(new Locator.FilterOptions().setHasText(phoneNumber));
        Locator statusCell = row.locator("td").nth(20);
        return playwright.getText(statusCell);
    }
}
