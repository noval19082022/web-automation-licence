package pageobject.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

public class ForgotPasswordPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private LocatorHelpers locatorHelpers;

    private Locator pemilikKostBtn;
    private Locator lupaPasswordBtn;
    private Locator inputPhoneNumber;
    private Locator pilihMethodeVerifikasiBtn;
    private Locator sendOtpBySMSBtn;
    private Locator sendOtpByWABtn;
    private Locator kirimUlangOtpBtn;
    private Locator backBtn;
    private Locator batalkanConfirmationBtn;
    private Locator pilihMethodeVerifikasiTitle;
    private Locator getErrorMessagePhone;


    public ForgotPasswordPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.locatorHelpers = new LocatorHelpers(page);

        this.pemilikKostBtn = page.getByTestId("pemilikKosButton");
        this.lupaPasswordBtn = page.getByText("Lupa password?");
        this.inputPhoneNumber = page.getByPlaceholder("Masukkan sesuai yang Anda daftarkan");
        this.pilihMethodeVerifikasiBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih metode verifikasi"));
        this.sendOtpBySMSBtn = page.getByTestId("selectOtpSms");
        this.sendOtpByWABtn = page.getByTestId("selectOtpWhatsApp");
        this.kirimUlangOtpBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kirim ulang kode"));
        this.backBtn = page.getByRole(AriaRole.BUTTON).filter(new Locator.FilterOptions().setHasText("back"));
        this.batalkanConfirmationBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ya, batalkan"));
        this.pilihMethodeVerifikasiTitle = page.getByText("Pilih Metode Verifikasi");
        this.getErrorMessagePhone = page.getByText("Masukkan nomor handphone yang terdaftar.");
    }

    /**
     * Entry to Owner Login Page On Login Page
     */
    public void clickOnLoginAsOwner() {
        pemilikKostBtn.click();
    }

    /**
     * Entry to Lupa Password Page On Owner or Tenant Login Page
     */
    public void clickOnLupaPassword() {
        lupaPasswordBtn.click();
    }

    /**
     * Fill Phone Number On Owner or Tenant Login Page
     *
     * @input String phone number
     */
    public void fillPhoneNumber(String PhoneNumber) {
        inputPhoneNumber.fill(PhoneNumber);
    }

    /**
     * Choose Verification Method
     */
    public void chooseVerificationMethod() {
        playwright.waitTillLocatorIsVisible(pilihMethodeVerifikasiBtn);
        pilihMethodeVerifikasiBtn.click();
    }

    /**
     * Choose SMS to send OTP
     */
    public void selectOTPBySMS() {
        sendOtpBySMSBtn.click();
    }

    /**
     * Choose WhatsApp to send OTP
     */
    public void selectOTPByWA() {
        sendOtpByWABtn.click();
    }

    /**
     * Resend OTP From Send OTP Text
     *
     * @return String text
     */
    public String getResendOTPButton() {
        playwright.waitTillLocatorIsVisible(kirimUlangOtpBtn);
        return kirimUlangOtpBtn.textContent();
    }

    /**
     * Resend OTP From Send OTP Page
     */
    public void clickOnResendOtp() {
        playwright.waitTillLocatorIsVisible(kirimUlangOtpBtn);
        kirimUlangOtpBtn.click();
    }

    /**
     * Back Button From Send OTP Page
     */
    public void backButtonFromSendOTPPage() {
        backBtn.click();
        batalkanConfirmationBtn.click();
    }

    /**
     * Get Title Verifikasi Page
     *
     * @return String 'Pilih Metode Verifikasi'
     */
    public String getTitleVerifikasiPage() {
        return pilihMethodeVerifikasiTitle.textContent();
    }

    /**
     * Get error message
     *
     * @return String error message
     */
    public String getErrorMessage() {
        playwright.waitTillLocatorIsVisible(getErrorMessagePhone);
        return getErrorMessagePhone.textContent();
    }
}
