package pageobject.tenant.profile;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class VerifikasiAkunPO {
    Page page;
    PlaywrightHelpers playwright;
    Locator verifikasiAkunMenu;
    Locator changeEmailButton;
    Locator changePhoneNumberButton;
    Locator textBoxField;
    Locator confirmChangeEmailButton;
    Locator inboxVerifEmail;
    Locator mailhogEmailVerifButton;
    Locator otpVerificationMessageText;

    public VerifikasiAkunPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.verifikasiAkunMenu = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Verifikasi Akun"));
        this.changeEmailButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ubah")).first();
        this.changePhoneNumberButton = page.getByTestId("verificationPhoneNumber");
        this.textBoxField = page.locator("#contentBox div.detail-text.edit-detail input");
        this.confirmChangeEmailButton = page.getByTestId("verificationEmail");
        this.inboxVerifEmail = page.locator("(//*[contains(text(),'Verifikasi email')])[1]");
        this.mailhogEmailVerifButton = page.frameLocator("#preview-html").locator(".button-container > div");
        this.otpVerificationMessageText = page.locator("  #contentBox .notif-phone-verification");
        }

    /**
     * click on verifikasi akun menu
     */
    public void clickOnVerifikasiAkunMenu() {
        playwright.clickOn(verifikasiAkunMenu);
    }

    /**
     * user change email
     */
    public void changeEmail(String email){
        playwright.clickOn(changeEmailButton);
        playwright.clickOn(textBoxField);
        playwright.fill(textBoxField, email);
        playwright.clickOn(confirmChangeEmailButton);
    }

    /**
     * Navigates to mailhog and login
     */
    public void navigatesToMailHogAndLogin() {
        playwright.navigateTo("https://mamiteam:M4!Lcatcher2020!@mailhog.kerupux.com/#");
    }

    /**
     * Click email verification button on mailhog
     */
    public void confirmEmailFromMailHog(){
        playwright.clickOn(inboxVerifEmail);
        playwright.clickOn(mailhogEmailVerifButton);
    }

    /**
     * user change phone number
     */
    public void changePhoneNumber(String phone){
        playwright.clickOn(changePhoneNumberButton);
        playwright.clickOn(textBoxField);
        playwright.fill(textBoxField, phone);
        playwright.clickOn(changePhoneNumberButton);
    }

    /**
     * Get OTP Verification Message Text
     * @return string
     */
    public String getOTPVerificationMessage() {
        playwright.waitTillLocatorIsVisible(otpVerificationMessageText,5.0);
        return playwright.getText(otpVerificationMessageText).replaceAll("\\s+"," ");
    }
}
