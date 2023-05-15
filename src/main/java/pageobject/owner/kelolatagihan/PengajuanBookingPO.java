package pageobject.owner.kelolatagihan;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

public class PengajuanBookingPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private LocatorHelpers locator;
    private Locator terimaButton;
    private Locator yaTerimaButton;
    private Locator terimaButtonWithName;
    private Locator tolakButton;
    private Locator yaTolakButton;

    private Locator rejectButton;
    private Locator acceptButton;


    public PengajuanBookingPO(Page page) {
        this.page = page;
        playwright = new PlaywrightHelpers(page);
        locator = new LocatorHelpers(page);
        this.terimaButton = playwright.locatorByRoleSetName(locator.roleButton, "Terima");
        this.yaTerimaButton = playwright.locatorByRoleSetName(locator.roleButton, "Ya, Terima");
        this.tolakButton = playwright.locatorByRoleSetName(locator.roleButton, "Tolak");
        this.yaTolakButton = playwright.locatorByRoleSetName(locator.roleButton, "Ya, Tolak");
        this.rejectButton =  page.getByTestId("bookingRequestDetail-actionButtonDesktop").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Tolak"));
        this.acceptButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ya, Tolak"));
    }

    /**
     * Click on terima and go to tenant room management
     */
    public BillAndBookingManagementPO ownerAcceptBooking() {
        terimaButton.click();
        yaTerimaButton.click();
        return new BillAndBookingManagementPO(page);
    }

    /**
     * Owner accept booking by tenant name
     * @param tenantName Tenant Name
     * @return BillAndBookingManagementPO class
     */
    public BillAndBookingManagementPO ownerAcceptBooking(String tenantName) {
        terimaButtonWithName = page.getByTestId("bookingRequestList-list")
                .locator("div").filter(new Locator.FilterOptions()
                        .setHasText(tenantName)).getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Terima"));
        playwright.clickOn(terimaButtonWithName);
        yaTerimaButton.click();
        return new BillAndBookingManagementPO(page);
    }

    /**
     * Click on tolak and go to popup reason reject booking
     */
    public BillAndBookingManagementPO ownerRejectBooking() {
        tolakButton.click();
        yaTolakButton.click();
        return new BillAndBookingManagementPO(page);
    }
    /**
     * Click on tolak and go to popup reason reject booking from view detail
     */
    public BillAndBookingManagementPO ownerRejectBookingFromViewDetail() {
        rejectButton.click();
        acceptButton.click();
        return new BillAndBookingManagementPO(page);
    }
}
