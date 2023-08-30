package pageobject.owner.goldplus;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.PlaywrightHelpers;

public class GoldPlusSubmissionPO {
    private Page page;
    private PlaywrightHelpers playwright;

    private Locator pilihPaketButton;
    private Locator bayarSekarangButton;

    public GoldPlusSubmissionPO(Page page) {
        this.page = page;
        playwright = new PlaywrightHelpers(this.page);
        pilihPaketButton = playwright.getButtonBySetName("Pilih");
        bayarSekarangButton = playwright.getButtonBySetName("Bayar Sekarang Rp");
    }

    /**
     * Clicks on pilih paket button
     */
    public void clicksOnPilihPaketButton() {
        playwright.clickOn(pilihPaketButton);
    }

    /**
     * Click on bayar sekarang button and wait until page loaded
     */
    public void clicksOnBayarSekarangButton() {
        playwright.clickOn(bayarSekarangButton);
        playwright.waitTillPageLoaded();
    }
}
