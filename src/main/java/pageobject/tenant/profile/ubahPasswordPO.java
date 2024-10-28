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

    public ubahPasswordPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        pengaturan = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Pengaturan"));
        ubahPassword = page.getByText("Ubah Password");
//                page.getByText("Ubah", new Page.GetByTextOptions().setExact(true));
        passwordLama = page.getByPlaceholder("Masukkan password lama");
        passwordBaru = page.getByPlaceholder("Masukkan password baru");
        ketikUlangPassword = page.getByPlaceholder("Ketik ulang password");
        buttonSimpanPassword = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Simpan"));
        passwordBerhasilDiubah = page.locator("//*[contains(text(),'Password berhasil diubah')]");
        passwordBaruOwner = page.getByPlaceholder("Password minimal 8 karakter");
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
}
