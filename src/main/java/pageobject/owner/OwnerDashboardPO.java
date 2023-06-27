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
    Locator broadcastChatBtn;
    Locator warningBroadcastText;
    Locator closePopUpIcon;
    private Locator penyewaMenu;
    Locator notificationButton;
    Locator firstNotificationText;
    Locator mamipoinButton;

    public OwnerDashboardPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.locator = new LocatorHelpers(page);
        manajemenKost = playwright.locatorByRoleAndText(locator.roleComplementary, "Manajemen Kos");
        pengajuanBooking = playwright.locatorByRoleSetName(locator.roleButton, "Pengajuan Booking");
        ownerProfile = playwright.locatorByRoleSetName(locator.roleButton, "account Akun");
        kelolaTagihan = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kelola Tagihan"));
        broadcastChatBtn = page.getByRole(AriaRole.BUTTON).filter(new Locator.FilterOptions().setHasText("'broadcast-message'"));
        warningBroadcastText = page.locator("//h3[@class='bg-c-modal__body-title']");
        closePopUpIcon = page.locator(".bg-c-modal__action-closable");
        penyewaMenu = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Penyewa"));
        notificationButton = page.locator("a").filter(new Locator.FilterOptions().setHasText("notification"));
        firstNotificationText = page.locator(".c-notification__item").first();
        mamipoinButton = page.getByText("MamiPoin");
    }

    /**
     * click on icon close at pop up
     * <p>doesn't have kost active</p>
     */
    public void clickOnButtonIconClose(){
        playwright.clickOn(closePopUpIcon);
        playwright.hardWait(2000);
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
     *
     * @return TenantBillManagementPO class
     */
    public TenantBillManagementPO clickOnKelolaKos() {
        playwright.doubleClick(kelolaTagihan);
        return new TenantBillManagementPO(page);
    }

    /**
     * Dismiss FTUE Godlplus
     */
    public void dismissFTUEGoldplus() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Nanti Saja")).click();
    }

    /**
     * Click on Kelola Kos and navigate to Tenant Bill Management
     *
     * @return TenantBillManagementPO class
     */
    public TenantBillManagementPO clickOnPenyewaKos() {
        playwright.hardWait(1000);
        playwright.clickOn(penyewaMenu);
        return new TenantBillManagementPO(page);
    }

    /**
     * Click on notification button header
     *
     */
    public void clickNotificationButton() {
        playwright.clickOn(notificationButton);
    }

    /**
     * Click on first notification owner
     */
    public void clickFirstNotificationText() {
        playwright.clickOn(firstNotificationText);
    }

     /**
      * Click on Mamipoin Button
     */
    public void clickMamipoinButton() {
        playwright.clickOn(mamipoinButton);
    }
}
