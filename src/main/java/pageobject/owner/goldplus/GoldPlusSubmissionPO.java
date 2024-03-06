package pageobject.owner.goldplus;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.PlaywrightHelpers;

public class GoldPlusSubmissionPO {
    private Page page;
    private PlaywrightHelpers playwright;

    private Locator pilihPaketButton;
    private Locator bayarSekarangButton;
    private Locator gpSatuFirstRadioButton;
    private Locator selectedFavoritGpPackage;
    private Locator selectedGpPeriode;

    public GoldPlusSubmissionPO(Page page) {
        this.page = page;
        playwright = new PlaywrightHelpers(this.page);
        pilihPaketButton = playwright.getButtonBySetName("Pilih");
        bayarSekarangButton = playwright.getButtonBySetName("Bayar Sekarang Rp");
        gpSatuFirstRadioButton = page.locator(".bg-c-radio__icon").first();
        selectedFavoritGpPackage = page.locator(".bg-c-radio--checked + .goldplus-periode-select__option .bg-c-label--pill-red");
        selectedGpPeriode = page.locator(".goldplus-periode__package-content .bg-c-radio--checked");
    }

    /**
     * Clicks on pilih paket button
     */
    public void clicksOnPilihPaketButton() {
        playwright.waitFor(pilihPaketButton);
        playwright.clickOn(pilihPaketButton);
    }

    /**
     * Click on bayar sekarang button and wait until page loaded
     */
    public void clicksOnBayarSekarangButton() {
        playwright.waitFor(bayarSekarangButton, 30000.0);
        playwright.clickOn(bayarSekarangButton);
        playwright.waitTillPageLoaded();
    }

    /**
     * Click on gp satu 3 bulan radio button
     */
    public void clickOnGpSatuFirstRadioButton() {
        playwright.waitFor(gpSatuFirstRadioButton);
        playwright.clickOn(gpSatuFirstRadioButton);
    }

    /**
     * Check if favorit gp radio selected
     * @return boolean true if favorit gp radio selected, otherwise false
     */
    public boolean isFavoritGpRadioSelected() {
        return playwright.waitTillLocatorIsVisible(selectedFavoritGpPackage);
    }

    /**
     * Check if gp periode selected
     * @return boolean true if gp periode selected, otherwise false
     */
    public boolean isGpPeriodeSelected() {
        return playwright.waitTillLocatorIsVisible(selectedGpPeriode.first());
    }
}
