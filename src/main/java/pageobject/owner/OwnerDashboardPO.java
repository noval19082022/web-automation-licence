package pageobject.owner;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

public class OwnerDashboardPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private LocatorHelpers locator;
    private Locator ownerProfile;
    private Locator manajemenKost;
    private Locator pengajuanBooking;
    public OwnerDashboardPO(Page page) {
        this.page = page;
        playwright = new PlaywrightHelpers(page);
        locator = new LocatorHelpers(page);
        this.manajemenKost = playwright.locatorByRoleAndText(locator.roleComplementary, "Manajemen Kos");
        this.pengajuanBooking = playwright.locatorByRoleSetName(locator.roleButton, "Pengajuan Booking");
        this.ownerProfile = playwright.locatorByRoleSetName(locator.roleButton, "account Akun");

    }

    /**
     * Click on owner profile
     */
    public void clickOnOwnerProfile() {
        ownerProfile.click();
    }

    /**
     * Click on manajemen kost
     */
    public void clickOnManagementKost() {
        manajemenKost.click();
    }

    /**
     * Click on pengajuan booking
     */
    public PengajuanBookingPO clickOnPengajuanBooking() {
        pengajuanBooking.click();
        return new PengajuanBookingPO(page);
    }
}
