package pageobject.owner;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

public class PengajuanBookingPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private LocatorHelpers locator;
    private Locator terimaButton;
    private Locator yaTerimaButton;

    public PengajuanBookingPO(Page page) {
        this.page = page;
        playwright = new PlaywrightHelpers(page);
        locator = new LocatorHelpers(page);
        this.terimaButton = playwright.locatorByRoleSetName(locator.roleButton, "Terima");
        this.yaTerimaButton = playwright.locatorByRoleSetName(locator.roleButton, "Ya, Terima");
    }

    /**
     * Click on terima and go to tenant room management
     */
    public BillAndBookingManagementPO ownerAcceptBooking() {
        terimaButton.click();
        yaTerimaButton.click();
        return new BillAndBookingManagementPO(page);
    }
}
