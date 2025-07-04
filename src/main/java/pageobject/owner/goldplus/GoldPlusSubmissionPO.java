package pageobject.owner.goldplus;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.PlaywrightHelpers;

public class GoldPlusSubmissionPO {
    private Page page;
    private PlaywrightHelpers playwright;

    private Locator pilihPaketButton;
    private Locator pilihPeriode;
    private Locator bayarSekarangButton;
    private Locator gpSectionCardList;
    private Locator selectedFavoritGpPackage;
    private Locator selectedGpPeriode;

    public GoldPlusSubmissionPO(Page page) {
        this.page = page;
        playwright = new PlaywrightHelpers(this.page);
        pilihPaketButton = playwright.getButtonBySetName("Pilih");
        pilihPeriode = playwright.getButtonBySetName("Pilih Periode");
        bayarSekarangButton = playwright.getButtonBySetName("Bayar Sekarang Rp");
        gpSectionCardList = page.getByTestId("periode-card-gp");
        selectedFavoritGpPackage = page.locator(".bg-c-radio--checked + .goldplus-periode-select__option .bg-c-label--pill-red");
        selectedGpPeriode = page.locator(".goldplus-periode__package-content .bg-c-radio--checked");
    }

//    /**
//     * Clicks on pilih periode button
//     */
//    public void clicksOnPilihPeriodeButton() {
//        playwright.clickOn(pilihPeriode);
//    }

    /**
     * Clicks on pilih paket button
     */
    public void clicksOnPilihPeriodeButton() {
        playwright.clickOn(pilihPeriode);
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
    public void clickOnGpSatuFirstRadioButton(boolean tapPilihPeriode) {
        playwright.waitFor(gpSectionCardList.first());
        var carList = playwright.getLocators(gpSectionCardList);

        playwright.clickOn(carList.get(carList.size() -1));

        if (tapPilihPeriode) {
            playwright.clickOn(pilihPeriode);
        }
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
