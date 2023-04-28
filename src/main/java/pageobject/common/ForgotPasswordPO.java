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
     * clear Phone Number On Owner or Tenant Login Page
     */
    public void clearInputPhoneNumber() {
        inputPhoneNumber.clear();
    }

    /**
     * Choose Verification Method
     */
    public void chooseVerificationMethod() {
        playwright.waitTillLocatorIsVisible(pilihMethodeVerifikasiBtn);
        pilihMethodeVerifikasiBtn.click();
    }

    /**
     * button Verification Method is disable
     *
     * @return boolean
     */
    public Boolean buuttonVerificationMethodIsDisable() {
        return pilihMethodeVerifikasiBtn.isDisabled();
    }

    /**
     * Choose SMS to send OTP
     */
    public void selectOTPBySMS() {
        if (pilihMethodeVerifikasiBtn.isVisible()) {
            pilihMethodeVerifikasiBtn.click();
        }
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
     * And click pop up confirmation
     */
    public void backButtonFromSendOTPPage() {
        backBtn.click();
        if (batalkanConfirmationBtn.isVisible()) {
            batalkanConfirmationBtn.click();
        }
    }

    /**
     * Back Button From Send OTP Page
     */
    public void backButton() {
        playwright.waitTillLocatorIsVisible(page.getByRole(AriaRole.TEXTBOX).first());
        backBtn.click();
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
     * @input String message
     */
    public String getErrorMessage(String message) {
        return page.getByText(message).textContent();
    }

    /**
     * Get message
     *
     * @return String message
     * @input String message
     */
    public String getMessage(String message) {
        return page.getByText(message).textContent();
    }

    /**
     * check if message appear
     *
     * @return Boolean
     * @input String message
     */
    public Boolean isMessageAppear(String message) {
        return page.getByText(message).isVisible();
    }

    /**
     * input OTP
     */
    public void fillOTP(String otp) {
        page.getByRole(AriaRole.TEXTBOX).first().fill(String.valueOf(otp.charAt(0)));
        page.getByRole(AriaRole.TEXTBOX).nth(1).fill(String.valueOf(otp.charAt(1)));
        page.getByRole(AriaRole.TEXTBOX).nth(2).fill(String.valueOf(otp.charAt(2)));
        page.getByRole(AriaRole.TEXTBOX).nth(3).fill(String.valueOf(otp.charAt(3)));
    }
}
