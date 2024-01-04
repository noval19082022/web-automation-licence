package pageobject.singgahsini;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

public class joinSinggahsiniPO {
    private Page page;
    PlaywrightHelpers playwright;

    private static final String MAMIKOS = "src/main/resources/mamikos.properties";
    public static final String ENV = JavaHelpers.getPropertyValue(MAMIKOS, "env");

    private Locator daftarSekarangButton;
    private Locator daftarPageTitleText;
    private Locator daftarPageSubtitleText;
    private Locator daftarButton;
    private Locator namaLengkapErrorMessage;
    private Locator noHandphoneErrorMessage;
    private Locator namaKosErrorMessage;
    private Locator kotaErrorMessage;
    private Locator alamatErrorMessage;
    private Locator namaLengkapField;
    private Locator noHandphoneField;
    private Locator namaKosField;
    private Locator alamatField;
    private Locator kotaDropdown;
    private Locator kecamatanDropdown;
    private Locator kelurahanDropdown;
    private Locator cariField;
    private Locator searchKotaErrorMessage;
    private Locator kembaliButton;
    private Locator lanjutIsiButton;
    private Locator keluarButton;
    private Locator suggestionText;
    private Locator titleSuccessPopUpText;
    private Locator subtitleSuccessPopUpText;
    private Locator okeSuccessPopUpButton;

    public joinSinggahsiniPO(Page page){
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        daftarSekarangButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Daftar Sekarang").setExact(true)).first();
        daftarPageTitleText = page.locator("h1.title");
        daftarPageSubtitleText = page.locator("p.subtitle");
        daftarButton = page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Daftar").setExact(true));
        namaLengkapErrorMessage = page.locator("(//*[@class='input-field'])[1]//div[@class='bg-c-field__message']");
        noHandphoneErrorMessage = page.locator("//*[@class='input-field phone-number']//div[@class='bg-c-field__message']");
        namaKosErrorMessage = page.locator("(//*[@class='input-field'])[2]//div[@class='bg-c-field__message']");
        kotaErrorMessage = page.locator("//*[@class='select-field']//div[@class='bg-c-field__message']");
        alamatErrorMessage = page.locator("//*[@class='text-field']//div[@class='bg-c-field__message']");
        namaLengkapField = page.locator("#nameInput_txt");
        noHandphoneField = page.locator("#phoneInput_txt");
        namaKosField = page.locator("#kosNameInput_txt");
        alamatField = page.locator("#addressInput_txt");
        kotaDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih kabupaten / kota kos Anda"));
        kecamatanDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih kecamatan kos Anda"));
        kelurahanDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih kelurahan kos Anda"));
        cariField = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Cari"));
        searchKotaErrorMessage = page.locator("//input[@placeholder='Cari']/following::span");
        kembaliButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kembali"));
        keluarButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Keluar"));
        lanjutIsiButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lanjut Isi"));
        titleSuccessPopUpText = page.locator(".bg-c-modal__body h3");
        subtitleSuccessPopUpText = page.locator(".bg-c-modal__body p");
        okeSuccessPopUpButton = page.locator(".singgahsini-modal__btn");
    }

    /**
     * Navigate to singgahsini.id
     */
    public void navigateToSinggahsiniId() {
        if (ENV.equalsIgnoreCase("stag")){
            playwright.navigateTo("https://jambu.kerupux.com/singgahsini",30000.0);
        } else if (ENV.equalsIgnoreCase("prod")) {
            playwright.navigateTo("https://singgahsini.id/",30000.0);
        }
    }

    /**
     * Click Daftar Sekarang in Landing Page
     */
    public void clickDaftarSekarang() {
        playwright.clickOn(daftarSekarangButton);
    }

    /**
     * Get URL Singgahsini
     * @return String
     */
    public String getURLSinggahsini() {
        return playwright.getPageUrl();
    }

    /**
     * Get singgahsini/daftar page title
     * @return String
     */
    public String getDaftarPageTitle() {
        return playwright.getText(daftarPageTitleText);
    }

    /**
     * Get singgahsini/daftar page subtitle
     * @return
     */
    public String getDaftarPageSubtitle() {
        return playwright.getText(daftarPageSubtitleText).replaceAll("[\\t\\n\\r]+"," ");
    }

    /**
     * Click Daftar in singgahsini/daftar page
     */
    public void clickDaftarButton() {
        playwright.clickOn(daftarButton);
    }

    /**
     * Get error message Nama Lengkap field
     * @return String
     */
    public String getNamaLengkapErrorMessage() {
        playwright.waitTillLocatorIsVisible(namaLengkapErrorMessage);
        return playwright.getText(namaLengkapErrorMessage);
    }

    /**
     * Get error message No Handphone field
     * @return String
     */
    public String getNoHandphoneErrorMessage() {
        playwright.waitTillLocatorIsVisible(noHandphoneErrorMessage);
        return playwright.getText(noHandphoneErrorMessage);
    }

    /**
     * Get error message Nama Kos field
     * @return String
     */
    public String getNamaKosErrorMessage() {
        playwright.waitTillLocatorIsVisible(namaKosErrorMessage);
        return playwright.getText(namaKosErrorMessage);
    }

    /**
     * Get error message Kabupaten/Kota field
     * @return String
     */
    public String getKabupatenKotaErrorMessage() {
        playwright.waitTillLocatorIsVisible(kotaErrorMessage);
        return playwright.getText(kotaErrorMessage);
    }

    /**
     * Get error message Alamat field
     * @return String
     */
    public String getAlamatErrorMessage() {
        playwright.waitTillLocatorIsVisible(alamatErrorMessage);
        return playwright.getText(alamatErrorMessage);
    }

    /**
     * Fill Nama Lengkap field
     * @param name
     */
    public void fillNamaLengkapField(String name) {
        String name50 = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";

        if (name.equalsIgnoreCase("50 char")){
            name = name50;
        }

        playwright.fill(namaLengkapField,name);
    }

    /**
     * Fill No Handphone field
     * @param phoneNumber
     */
    public void fillNoHandphoneField(String phoneNumber) {
        playwright.fill(noHandphoneField,phoneNumber);
    }

    /**
     * Fill Kos Name field
     * @param kosName
     */
    public void fillKosNameField(String kosName) {
        String kos30 = "Kost Singgahsini Automation1234";

        if (kosName.equalsIgnoreCase(">30 char")){
            kosName = kos30;
        }

        playwright.fill(namaKosField,kosName);
    }

    /**
     * Fill Alamat Lengkap field
     * @param address
     */
    public void fillAlamatField(String address) {
        playwright.fill(alamatField,address);
    }

    /**
     * Only search Kota field
     * @param city
     */
    public void fillCitySearchField(String city) {
        playwright.clickOn(kotaDropdown);
        playwright.fill(cariField,city);
    }

    /**
     * Get result search kota
     * @return String
     */
    public String getSearchCityErrorMessage() {
        return playwright.getText(searchKotaErrorMessage);
    }

    /**
     * Click Kembali button in top
     */
    public void clickKembaliButton() {
        playwright.clickOn(kembaliButton);
    }

    /**
     * Click Keluar in exit confirmation pop up
     */
    public void clickKeluarButton() {
        playwright.clickOn(keluarButton);
    }

    /**
     * Click Lanjut Isi in exit confirmation pop up
     */
    public void clickLanjutIsiButton() {
        playwright.clickOn(lanjutIsiButton);
    }

    /**
     * Search and Select kota
     * @param kota
     */
    public void selectKota(String kota) {
        suggestionText = page.locator("a").filter(new Locator.FilterOptions().setHasText(kota));

        playwright.clickOn(kotaDropdown);
        playwright.fill(cariField,kota);
        playwright.clickOn(suggestionText);
    }

    /**
     * Search and Select kecamatan
     * @param kecamatan
     */
    public void selectKecamatan(String kecamatan) {
        suggestionText = page.locator("a").filter(new Locator.FilterOptions().setHasText(kecamatan));

        playwright.clickOn(kecamatanDropdown);
        playwright.fill(cariField,kecamatan);
        playwright.clickOn(suggestionText);
    }

    /**
     * Search and select kelurahan
     * @param kelurahan
     */
    public void selectKelurahan(String kelurahan) {
        suggestionText = page.locator("a").filter(new Locator.FilterOptions().setHasText(kelurahan));

        playwright.clickOn(kelurahanDropdown);
        playwright.fill(cariField,kelurahan);
        playwright.clickOn(suggestionText);
    }

    /**
     * Get title in Success Register Pop Up
     * @return String
     */
    public String getSuccessRegisterPopUpTitle() {
        return playwright.getText(titleSuccessPopUpText);
    }

    /**
     * Get subtitle in Success Register Pop Up
     * @return String
     */
    public String getSuccessRegisterPopUpSubtitle() {
        return playwright.getText(subtitleSuccessPopUpText);
    }

    /**
     * Click Oke in Success Register Pop Up
     */
    public void closeSuccessRegisterPopUp() {
        playwright.clickOn(okeSuccessPopUpButton);
    }
}
