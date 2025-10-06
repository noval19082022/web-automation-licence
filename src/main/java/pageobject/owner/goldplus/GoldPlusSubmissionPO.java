package pageobject.owner.goldplus;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pageobject.admin.testingtools.GoldPlusPO;
import utilities.PlaywrightHelpers;
import java.util.ArrayList;
import java.util.List;

public class GoldPlusSubmissionPO {
    private Page page;
    private PlaywrightHelpers playwright;

    private Locator pilihPeriode;
    private Locator bayarSekarangButton;
    private Locator gpSectionCardList;
    private Locator selectedFavoritGpPackage;
    private Locator selectedGpPeriode;
    private Locator periodOptionsList;

    public GoldPlusSubmissionPO(Page page) {
        this.page = page;
        GoldPlusPO GoldPlusPO = new GoldPlusPO(page);
        playwright = new PlaywrightHelpers(this.page);
        pilihPeriode = playwright.getButtonBySetName("Pilih Periode");
        bayarSekarangButton = playwright.getButtonBySetName("Bayar Sekarang Rp");
        gpSectionCardList = page.getByTestId("periode-card-gp");
        selectedFavoritGpPackage = page.locator(".bg-c-radio--checked + .goldplus-periode-select__option .bg-c-label--pill-red");
        selectedGpPeriode = page.locator(".goldplus-periode__package-content .bg-c-radio--checked");
        periodOptionsList = page.locator("//div[@class='goldplus-periode-select']");
    }


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
        if (playwright.waitTillLocatorIsVisible(bayarSekarangButton)) {
            playwright.waitFor(bayarSekarangButton, 3000.0);
            playwright.clickOn(bayarSekarangButton);
            playwright.hardWait(5000);
        } else {
            playwright.waitFor(pilihPeriode, 3000.0);
            playwright.clickOn(pilihPeriode);
            playwright.waitTillPageLoaded();
        }
    }

    /**
     * Click on gp satu 3 bulan radio button
     */
    public void clickOnGpSatuFirstRadioButton(boolean tapPilihPeriode) {
        playwright.waitFor(gpSectionCardList.first());
        var carList = playwright.getLocators(gpSectionCardList);

        playwright.clickOn(carList.get(carList.size() -1));
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
    /**
     * Get all period options displayed on the page
     * @return List of period option texts
     */
    public List<String> getAllPeriodOptions() {
        List<String> periodTexts = new ArrayList<>();
        playwright.waitFor(periodOptionsList.first(), 5000.0);

        int count = periodOptionsList.count();
        for (int i = 0; i < count; i++) {
            String periodText = periodOptionsList.nth(i).textContent().trim();
            periodTexts.add(periodText);
        }

        return periodTexts;
    }
}
