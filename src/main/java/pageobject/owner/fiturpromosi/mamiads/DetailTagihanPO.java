package pageobject.owner.fiturpromosi.mamiads;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

public class DetailTagihanPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private LocatorHelpers locatorHelpers;

    private Locator pilihanAndaText;
    private Locator rincianPembayaranProdukText;
    private Locator rincianPembayaranNominalText;
    private Locator totalPembayaranText;
    private Locator ubahSaldoBtn;
    private Locator bayarSekarangBtnOnDetailTagihan;

    public DetailTagihanPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.locatorHelpers = new LocatorHelpers(page);

        this.pilihanAndaText = page.locator(".chosen-subtitle");
        this.rincianPembayaranProdukText = page.locator(".detail-subtitle");
        this.rincianPembayaranNominalText = page.locator(".nominal").first();
        this.totalPembayaranText = page.locator(".nominal").last();
        this.ubahSaldoBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih Ulang Nominal MamiAds"));
        this.bayarSekarangBtnOnDetailTagihan = playwright.locatorByRoleAndText(AriaRole.BUTTON, "Bayar Sekarang");
    }

    /**
     * Get saldo Pilihan Anda
     *
     * @return String "Saldo 6.000"
     */
    public String getPilihanAndaText() {
        return playwright.getText(pilihanAndaText);
    }

    /**
     * Get Rincian Pembayaran Saldo
     *
     * @return String "Saldo 6.000"
     */
    public String getRincianPembayaranProdukText() {
        return playwright.getText(rincianPembayaranProdukText);
    }

    /**
     * Get Rincian Pembayaran Nominal Saldo
     *
     * @return String "Rp 6.000"
     */
    public String getRincianPembayaranNominalText() {
        return playwright.getText(rincianPembayaranNominalText);
    }

    /**
     * Get Total Pembayaran
     *
     * @return String "Rp 6.000"
     */
    public String getTotalPembayaranText() {
        return playwright.getText(totalPembayaranText);
    }

    /**
     * click on Ubah to change amount of saldo mamiads
     */
    public void clickOnUbahSaldo(){
        playwright.clickOn(ubahSaldoBtn);
    }

    /**
     * Click on bayar sekarang button and wait until page loaded
     */
    public void clicksOnBayarSekarangButton() {
        playwright.waitTillLocatorIsVisible(bayarSekarangBtnOnDetailTagihan, 30000.0);
        playwright.clickOn(bayarSekarangBtnOnDetailTagihan);
        playwright.waitTillPageLoaded();
    }
}