package pageobject.owner;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import pageobject.owner.kelolatagihan.PengajuanBookingPO;
import pageobject.owner.kelolatagihan.TenantBillManagementPO;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

public class OwnerDashboardPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private LocatorHelpers locator;
    private Locator ownerProfile;
    private Locator manajemenKost;
    private Locator pengajuanBooking;
    private Locator kelolaTagihan;
    public OwnerDashboardPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.locator = new LocatorHelpers(page);
        manajemenKost = playwright.locatorByRoleAndText(locator.roleComplementary, "Manajemen Kos");
        pengajuanBooking = playwright.locatorByRoleSetName(locator.roleButton, "Pengajuan Booking");
        ownerProfile = playwright.locatorByRoleSetName(locator.roleButton, "account Akun");
        kelolaTagihan = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kelola Tagihan"));
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
        pengajuanBooking.waitFor();
        pengajuanBooking.click();
        return new PengajuanBookingPO(page);
    }

    /**
     * Click on Kelola Kos and navigate to Tenant Bill Management
     * @return TenantBillManagementPO class
     */
    public TenantBillManagementPO clickOnKelolaKos() {
        playwright.doubleClick(kelolaTagihan);
        return new TenantBillManagementPO(page);
    }
}
