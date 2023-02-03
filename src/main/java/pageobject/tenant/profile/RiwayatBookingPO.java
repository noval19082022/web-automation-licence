package pageobject.tenant.profile;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import pageobject.tenant.InvoicePO;
import utilities.PlaywrightHelpers;

public class RiwayatBookingPO {
    Page page;
    PlaywrightHelpers playwright;
    Locator bayarSekarangButton;
    Locator checkinButton;
    Locator chekcinOnPopUpButton;
    Locator doneToKostSayaButton;

    public RiwayatBookingPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        bayarSekarangButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Bayar Sekarang"));
        checkinButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Check-in Kos"));
        chekcinOnPopUpButton = page.getByRole(AriaRole.DIALOG).filter(new Locator.FilterOptions().setHasText("close Pastikan")).getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Check-in"));
        doneToKostSayaButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Selesai & ke Kos Saya"));
    }

    /**
     * Click on bayar sekarang button
     * @return InvoicePO class
     */
    public InvoicePO clickOnBayarSekarangButton() {
        page = page.waitForPopup(() -> {
            playwright.clickOn(bayarSekarangButton);
        });
        return new InvoicePO(page);
    }

    /**
     * Click on check-in button
     */
    public void clickOnCheckinButton() {
        playwright.clickOn(checkinButton);
    }

    /**
     * Click on check-in pop-up button
     */
    public void clickOnCheckinPopUpButton() {
        playwright.clickOn(chekcinOnPopUpButton);
    }

    /**
     * Click on selesai and go to kost saya
     */
    public void clickOnSelesaiAndKeKostSaya() {
        playwright.clickOn(doneToKostSayaButton);
        page.waitForLoadState(LoadState.LOAD);
    }
}
