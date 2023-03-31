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

    private Locator entryToLoginPageBtn;
    private Locator pemilikKostBtn;
    private Locator lupaPasswordBtn;
    private Locator inputPhoneNumber;
    private Locator pilihMethodeVerifikasiBtn;
    private Locator sendOtpBySMSBtn;
    private Locator sendOtpByWABtn;
    private Locator kirimUlangOtpBtn;
    private Locator backBtn;
    private Locator batalkanConfirmationBtn;


    public ForgotPasswordPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.locatorHelpers = new LocatorHelpers(page);

        this.entryToLoginPageBtn = page.getByTestId("entryButton");
        this.pemilikKostBtn = page.getByTestId("pemilikKosButton");
        this.lupaPasswordBtn = page.getByText("Lupa password?");
        this.inputPhoneNumber = page.getByPlaceholder("Masukkan sesuai yang Anda daftarkan");
        this.pilihMethodeVerifikasiBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih metode verifikasi"));
        this.sendOtpBySMSBtn = page.getByTestId("selectOtpSms");
        this.sendOtpByWABtn = page.getByTestId("selectOtpWhatsApp");
        this.kirimUlangOtpBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kirim ulang kode"));
        this.backBtn = page.getByRole(AriaRole.BUTTON).filter(new Locator.FilterOptions().setHasText("back"));
        this.batalkanConfirmationBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ya, batalkan"));
    }

    /**
     * Entry to Login Page On Home Page
     */
    public void clickOnEntryToLoginPage() {
        entryToLoginPageBtn.click();
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
     * Resend OTP From Send OTP Text and wait 60 seconds
     */
    public String getResendOTPButton() {
        playwright.waitTillLocatorIsVisible(kirimUlangOtpBtn, 60000.0);
        return kirimUlangOtpBtn.textContent();
    }

    /**
     * Resend OTP From Send OTP Page and wait 60 seconds
     */
    public void clickOnResendOtp() {
        playwright.waitTillLocatorIsVisible(kirimUlangOtpBtn, 60000.0);
        kirimUlangOtpBtn.click();
    }

    /**
     * Back Button From Send OTP Page
     */
    public void backButtonFromSendOTPPage() {
        backBtn.click();
        batalkanConfirmationBtn.click();
    }
}
