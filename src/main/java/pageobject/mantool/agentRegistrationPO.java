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

    private Locator berikutnyaButton;

    private Locator uploadKTPErrorMessage;
    //Informasi Pribadi

    public agentRegistrationPO(Page page){
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        skemaAgenAkuisisiRadioButton = page.locator("input#acquisition");
        skemaAgenInputDataRadioButton = page.locator("input#data_input");
        namaLengkapText = page.getByPlaceholder("Masukkan nama lengkap Anda");
        nomorHandphoneText = page.getByPlaceholder("08xxxxxxxxxx");
        emailText = page.locator(".bg-c-input__field").nth(2);
        usiaText = page.locator(".bg-c-input__field").nth(3);
        noKTPText = page.locator(".bg-c-input__field").nth(4);
        berikutnyaButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Berikutnya"));
        passwordText = page.getByPlaceholder("Minimal 8 karakter angka dan huruf").first();
        konfirmasiPasswordText = page.getByPlaceholder("Minimal 8 karakter angka dan huruf").nth(1);

        uploadKTPErrorMessage = page.locator(".bg-c-field__message");
    }

    /**
     * Choose skema agen
     * @param skema
     */
    public void chooseSkemaAgen(String skema) {
        if (skema.equalsIgnoreCase("Agen Akuisi")){
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
     * get upload ktp error message
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
}
