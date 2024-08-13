package pageobject.mantool;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

import java.util.regex.Pattern;

public class agentRegistrationPO {

    private Page page;
    private PlaywrightHelpers playwright;

    //Informasi Pribadi
    private Locator skemaAgenAkuisisiRadioButton;
    private Locator skemaAgenInputDataRadioButton;
    private Locator namaLengkapText;
    private Locator nomorHandphoneText;
    private Locator emailText;
    private Locator usiaText;
    private Locator noKTPText;
    private Locator uploadKTPFile;
    private Locator passwordText;
    private Locator konfirmasiPasswordText;
    private Locator deleteFotoKtpButton;

    private Locator berikutnyaButton;

    private Locator errorMessage;
    private Locator uploadKTPErrorMessage;
    //Informasi Pribadi

    //Tempat Tinggal
    private Locator provinceDropdown;
    private Locator provinceSearchText;
    private Locator provinceOption;
    private Locator kotaDropdown;
    private Locator kotaDropdownDisabled;
    private Locator kotaSearchText;
    private Locator kotaOption;
    private Locator addressTextArea;
    private Locator addressCounterText;
    //Tempat Tinggal

    //Profil Agen
    private Locator namaBankDropdown;
    private Locator namaBankSearchText;
    private Locator namaBankOption;
    private Locator noRekeningText;
    private Locator pendidikanTerakhirDropdown;
    private Locator pendidikanTerakhirOption;
    private Locator kegiatanSaatIniDropdown;
    private Locator kegiatanSaatIniOption;
    private Locator sumberInformasiDropdown;
    private Locator sumberInformasiOption;
    private Locator tncCheckbox;
    private Locator daftarAgenButton;
    //Profil Agen

    //konfirmasi data pop up
    private Locator konfirmasiDataPopUp;
    private Locator confirmationPopUpText;
    private Locator captchaSection;
    //konfirmasi data pop up

    public agentRegistrationPO(Page page){
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        skemaAgenAkuisisiRadioButton = page.getByText("Agen Akuisisi");
        skemaAgenInputDataRadioButton = page.getByText("Agen Input Data");
        namaLengkapText = page.getByPlaceholder("Masukkan nama lengkap Anda");
        nomorHandphoneText = page.getByPlaceholder("08xxxxxxxxxx");
        emailText = page.locator(".bg-c-input__field").nth(2);
        usiaText = page.locator(".bg-c-input__field").nth(3);
        noKTPText = page.locator(".bg-c-input__field").nth(4);
        berikutnyaButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Berikutnya"));
        passwordText = page.getByPlaceholder("Minimal 8 karakter angka dan huruf").first();
        konfirmasiPasswordText = page.getByPlaceholder("Minimal 8 karakter angka dan huruf").nth(1);
        uploadKTPFile = page.locator(".bg-c-image-uploader input");
        deleteFotoKtpButton = page.getByTestId("imageDelete_btn");

        errorMessage = page.locator(".bg-c-field__message");
        uploadKTPErrorMessage = page.locator(".bg-c-image-uploader__error-message");

        provinceDropdown = page.locator(".bg-c-select__trigger").first();
        provinceSearchText = page.locator(".bg-c-input__field").first();
        kotaDropdown = page.locator(".bg-c-select__trigger").nth(1);
        kotaDropdownDisabled = page.locator("bg-c-select__trigger--disabled");
        kotaSearchText = page.locator(".bg-c-input__field").nth(1);
        addressTextArea = page.locator(".bg-c-textarea__field");
        addressCounterText = page.getByTestId("textarea-char-counter");

        namaBankDropdown = page.locator(".bg-c-select").first();
        namaBankSearchText = page.getByPlaceholder("Search");
        noRekeningText = page.getByPlaceholder("Masukkan nomor rekening");
        pendidikanTerakhirDropdown = page.locator(".bg-c-select__trigger--lg").nth(1);
        kegiatanSaatIniDropdown = page.locator(".bg-c-select__trigger--lg").nth(2);
        sumberInformasiDropdown = page.locator(".bg-c-select__trigger--lg").nth(3);
        tncCheckbox = page.locator(".bg-c-checkbox__icon");
        daftarAgenButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Daftar Agen "));

        konfirmasiDataPopUp = page.locator(".bg-c-modal__inner");
        confirmationPopUpText = page.locator(".confirmation-data b");
        captchaSection = page.locator(".confirmation-validate [title='reCAPTCHA']");
    }

    /**
     * Choose skema agen
     * @param skema
     */
    public void chooseSkemaAgen(String skema) {
        if (skema.equalsIgnoreCase("Agen Akuisisi")){
            playwright.clickOn(skemaAgenAkuisisiRadioButton);
        } else if (skema.equalsIgnoreCase("Agen Input Data")) {
            playwright.clickOn(skemaAgenInputDataRadioButton);
        }
    }

    /**
     * fill nama lengkap field
     * @param name
     */
    public void fillNamaLengkap(String name) {
        playwright.fill(namaLengkapText,name);
    }

    /**
     * fill Nomor handphone field
     * @param noHP
     */
    public void fillNomorHandphone(String noHP) {
        playwright.fill(nomorHandphoneText,noHP);
    }

    /**
     * fill email field
     * @param email
     */
    public void fillEmail(String email) {
        playwright.fill(emailText,email);
    }

    /**
     * fill usia field
     * @param age
     */
    public void fillUsia(String age) {
        playwright.scrollToUp(page);
        playwright.fill(usiaText,age);
    }

    /**
     * fill no ktp field
     * @param noKtp
     */
    public void fillNoKTP(String noKtp) {
        playwright.fill(noKTPText,noKtp);
    }

    /**
     * click berikutnya button
     */
    public void clickBerikutnya() {
        playwright.clickOn(berikutnyaButton);
    }

    /**
     * get error message
     * @return String
     */
    public String getErrorMessage() {
        return playwright.getText(errorMessage.first());
    }

    /**
     * get foto ktp error message
     * @return String
     */
    public String getUploadPhotoErrorMessage() {
        return playwright.getText(uploadKTPErrorMessage);
    }

    /**
     * fill password field
     * @param password
     */
    public void fillPassword(String password) {
        playwright.fill(passwordText,password);
    }

    /**
     * fill konfirmasi password field
     * @param password
     */
    public void fillKonfirmasiPassword(String password) {
        playwright.fill(konfirmasiPasswordText,password);
    }

    /**
     * Upload foto ktp file
     * @param path file url path
     */
    public void uploadPhotoKTP(String path) {
        if (playwright.isLocatorVisibleAfterLoad(deleteFotoKtpButton,2000.0)){
            playwright.clickOn(deleteFotoKtpButton);
        }

        playwright.uploadFile(uploadKTPFile,path);
        playwright.hardWait(1000.0);
    }


    /**
     * Assert upload ktp error message visible or not
     * @return boolean
     */
    public boolean isFotoKTPErrorMessageVisible() {
        return playwright.isLocatorVisibleAfterLoad(uploadKTPErrorMessage,3000.0);
    }

    /**
     * Assert error message visible or not
     * @return boolean
     */
    public boolean isErrorMessageVisible() {
        return playwright.isLocatorVisibleAfterLoad(errorMessage,3000.0);
    }

    /**
     * select province
     * @param province
     */
    public void selectProvince(String province) {
        provinceOption = page.locator("a").filter(new Locator.FilterOptions().setHasText(province));

        playwright.clickOn(provinceDropdown);
        playwright.fill(provinceSearchText,province);
        playwright.clickOn(provinceOption);
    }

    /**
     * assert kota dropdown visible or not
     * @return boolean
     */
    public boolean isKotaDisabled() {
        return playwright.isLocatorVisibleAfterLoad(kotaDropdownDisabled,3000.0);
    }

    /**
     * Select city
     * @param city
     */
    public void selectCity(String city) {
        kotaOption = page.locator("a").filter(new Locator.FilterOptions().setHasText(city));

        playwright.clickOn(kotaDropdown);
        playwright.fill(kotaSearchText,city);
        playwright.clickOn(kotaOption);
    }

    /**
     * Fill address
     * @param address
     */
    public void fillAddress(String address) {
        playwright.fill(addressTextArea,address);
    }

    /**
     * count address text
     * @return integer
     */
    public int countAddressText() {
        return playwright.getInputValue(addressTextArea).length();
    }

    /**
     * Get counter address text
     * @return String
     */
    public String getAddressCounter() {
        return playwright.getText(addressCounterText);
    }

    /**
     * Choose bank name
     * @param bank
     */
    public void chooseBankName(String bank) {
        namaBankOption = page.locator("a").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^"+bank+"$")));

        playwright.clickOn(namaBankDropdown);
        playwright.fill(namaBankSearchText,bank);
        playwright.clickOn(namaBankOption);
    }


    /**
     * Fill No Rekening
     * @param noRek
     */
    public void fillNoRekening(String noRek) {
        playwright.clearText(noRekeningText);
        playwright.fillCharacterByCharacter(noRekeningText,noRek,50.0);
    }

    /**
     * Get No rekening value
     * @return String
     */
    public String getNoRekening() {
        return playwright.getInputValue(noRekeningText);
    }

    /**
     * Choose pendidikan terakhir
     * @param education
     */
    public void choosePendidikanTerakhir(String education) {
        pendidikanTerakhirOption = page.locator("a").filter(new Locator.FilterOptions().setHasText(education));

        playwright.clickOn(pendidikanTerakhirDropdown);
        playwright.clickOn(pendidikanTerakhirOption);
    }

    /**
     * Choose kegiatan saat ini
     * @param job
     */
    public void chooseKegiatanSaatIni(String job) {
        kegiatanSaatIniOption = page.locator("a").filter(new Locator.FilterOptions().setHasText(job));

        playwright.clickOn(kegiatanSaatIniDropdown);
        playwright.clickOn(kegiatanSaatIniOption);
    }

    /**
     * choose sumber informasi
     * @param source
     */
    public void chooseSumberInformasi(String source) {
        sumberInformasiOption = page.locator("a").filter(new Locator.FilterOptions().setHasText(source));

        playwright.clickOn(sumberInformasiDropdown);
        playwright.clickOn(sumberInformasiOption);
    }

    /**
     * Check terms and condition
     */
    public void acceptTermsConditionCreateAgen() {
        playwright.clickOn(tncCheckbox);
    }

    /**
     * Click on daftar agen
     */
    public void clickDaftarAgen() {
        playwright.clickOn(daftarAgenButton);
    }

    /**
     * Verify Konfirmasi pop up button visible or not
     * @return boolean
     */
    public boolean isConfirmationPopUpAgentVisible() {
        return playwright.isLocatorVisibleAfterLoad(konfirmasiDataPopUp,3000.0);
    }

    /**
     * Get text in confirmatio pop up
     * @param confirmationText
     * @return String
     */
    public String getConfirmationPopUpInfo(String confirmationText) {
        int index = 0;

        switch (confirmationText){
            case "skema":
                index = 0;
                break;
            case "noktp":
                index = 1;
                break;
            case "email":
                index = 2;
                break;
            case "password":
                index = 3;
                break;
            case "bank":
                index = 4;
                break;
            case "rekening":
                index = 5;
                break;
            default:
                System.out.println("invalid case confirmation pop up text");
        }

        return playwright.getText(confirmationPopUpText.nth(index));
    }

    /**
     * Verify captcha section is visible or not
     * @return Boolean
     */
    public boolean isCaptchaVisible() {
        return playwright.isLocatorVisibleAfterLoad(captchaSection,3000.0);
    }
}