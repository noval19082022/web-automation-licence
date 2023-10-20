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
    Locator emailField;
    Locator confirmChangeButton;
    Locator inboxVerifEmail;
    Locator mailhogEmailVerifButton;

    public VerifikasiAkunPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.verifikasiAkunMenu = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Verifikasi Akun"));
        this.changeEmailButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ubah")).first();
        this.emailField = page.locator("#contentBox div.detail-text.edit-detail input");
        this.confirmChangeButton = page.getByTestId("verificationEmail");
        this.inboxVerifEmail = page.locator("(//*[contains(text(),'Verifikasi email')])[1]");
        this. mailhogEmailVerifButton = page.frameLocator("#preview-html").locator(".button-container > div");
        }

    /**
     * click on verifikasi akun menu
     */
    public void clickOnVerifikasiAkunMenu() {
        playwright.clickOn(verifikasiAkunMenu);
    }

    /**
     * user click field nama lengkap
     */
    public void changeEmail(String email){
        playwright.clickOn(changeEmailButton);
        playwright.clickOn(emailField);
        playwright.fill(emailField, email);
        playwright.clickOn(confirmChangeButton);
    }

    /**
     * Navigates to mailhog and login
     */
    public void navigatesToMailHogAndLogin() {
        playwright.navigateTo("https://mamiteam:M4!Lcatcher2020!@mailhog.kerupux.com/#");
    }

    /**
     * verify error message phone number
     */
    public void confirmEmailFromMailHog(){
        playwright.clickOn(inboxVerifEmail);
        playwright.clickOn(mailhogEmailVerifButton);
    }

}
