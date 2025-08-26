package pageobject.tenant.profile;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class ubahPasswordPO {
    Page page;
    PlaywrightHelpers playwright;
    Locator pengaturan;
    Locator ubahPassword;
    Locator passwordLama;
    Locator passwordBaru;
    Locator ketikUlangPassword;
    Locator buttonSimpanPassword;
    Locator passwordBerhasilDiubah;
    Locator passwordBaruOwner;
    Locator ownerUbahPasswordButton;
    Locator errorMessage;
    Locator ownerPasswordForm;

    public ubahPasswordPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        pengaturan = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Pengaturan"));
        ubahPassword = page.getByText("Ubah Password");
        passwordLama = page.getByPlaceholder("Masukkan password lama");
        passwordBaru = page.getByPlaceholder("Masukkan password baru");
        ketikUlangPassword = page.getByPlaceholder("Ketik ulang password");
        buttonSimpanPassword = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Simpan"));
        passwordBerhasilDiubah = page.locator("//*[contains(text(),'Password berhasil diubah')]");
        passwordBaruOwner = page.locator("input[type='password']").nth(1)
            .or(page.locator("input[name*='new']"))
            .or(page.locator("input[name*='password']:not([name*='old']):not([name*='confirm'])"))
            .or(page.getByPlaceholder("Masukkan password baru"));
        ownerUbahPasswordButton = page.locator("text='Ubah Password'").or(page.locator("button:has-text('Password')")).or(page.getByText("Password"));
        errorMessage = page.locator(".error-message").or(page.locator(".alert-danger")).or(page.locator("text='Password Lama Anda tidak valid'"));
        ownerPasswordForm = page.locator(".password-form").or(page.locator("form")).or(page.locator("input[type='password']"));
    }

    /**
     * Click on Ubah Button
     * @throws InterruptedException
     */
    public void clickPengaturanButton(){
        playwright.clickOn(pengaturan);
        playwright.clickOn(ubahPassword);
    }

    /**
     * Fills Password Lama
     */
    public void userFillsPasswordLama (String password) {
        playwright.fill(passwordLama, password);
    }

    /**
     * Fills Password baru
     */
    public void userFillsPasswordBaru (String password) {
        playwright.fill(passwordBaru, password);
    }

    /**
     * Fills Ketik Ulang Password
     */
    public void userFillsKetikUlangPassword (String password) {
        playwright.fill(ketikUlangPassword, password);
    }

    /**
     * Owner Fills Password baru
     */
    public void ownerFillsPasswordBaru(String password) {
        playwright.waitTillLocatorIsVisible(passwordBaruOwner);
        playwright.fill(passwordBaruOwner, password);
    }

    /**
     * Click on Simpan Button
     */
    public void clickSimpanButton () {
        playwright.clickOn(buttonSimpanPassword);
    }

    /**
     * Appears Message Password Berhasil Diubah
     * @return
     * @throws InterruptedException
     */
    public String passwordBerhasilDiubahMessage()throws InterruptedException{
        return playwright.getText(passwordBerhasilDiubah);
    }

    /**
     * Empty Old Password
     */
    public void userEmptyOldPassword(){
        playwright.clearText(passwordLama);
    }

    /**
     * Empty New Password
     */
    public void userEmptyNewPassword(){
        playwright.clearText(passwordBaru);
    }

    /**
     * Empty Ketik Ulang Password
     */
    public void userEmptyConfirmationPassword(){
        playwright.clearText(ketikUlangPassword);
    }

    /**
     * Owner empty New Password
     */
    public void ownerEmptyNewPassword(){
        playwright.clearText(passwordBaruOwner);
    }

    /**
     * Click on Ubah Password for Owner (without hardwait)
     */
    public void clickUbahPasswordOwner() {
        playwright.clickOn(ownerUbahPasswordButton);
        playwright.waitTillLocatorIsVisible(ownerPasswordForm);
    }

    /**
     * Get Error Message (without hardwait)
     * @return error message text
     */
    public String getErrorMessage() {
        playwright.waitTillLocatorIsVisible(errorMessage);
        return playwright.getText(errorMessage);
    }

    /**
     * Check if Password Form is Visible (without hardwait)
     * @return true if form is visible
     */
    public boolean isPasswordFormVisible() {
        return playwright.waitTillLocatorIsVisible(ownerPasswordForm);
    }
}
