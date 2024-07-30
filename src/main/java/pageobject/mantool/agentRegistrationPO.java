package pageobject.mantool;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

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
}
