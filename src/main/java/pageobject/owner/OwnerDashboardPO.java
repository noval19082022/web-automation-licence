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
    Locator terimaButton;
    Locator tolakButton;
    Locator pengajuanSewaSection;
    Locator gpWidgetButton;
    Locator helpCenter;
    Locator seeAllNotification;

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
        notificationButton = page.locator(".notification-menu > .bg-c-icon");
        firstNotificationText = page.locator(".c-notification__item").first();
        mamipoinButton = page.getByText("MamiPoin");
        terimaButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Terima"));
        tolakButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tolak"));
        pengajuanSewaSection = page.locator("div.booking-confirmation-section__content");
        gpWidgetButton = page.locator("a").filter(new Locator.FilterOptions().setHasText("mamikos GoldPlus"));
        helpCenter = page.locator("//*[text()='Pusat Bantuan']");
        seeAllNotification = page.locator("//div[@class='c-notification__see-more']");
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
        playwright.waitTillLocatorIsVisible(manajemenKost, 3000.0);
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
        kelolaTagihan.waitFor();
        playwright.clickOn(kelolaTagihan);
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

    /**
     * Click on Terima Button on owner dashboard
     */
    public void clickOnTerimaViaHomepage() {
        playwright.clickOn(terimaButton);
    }

    /**
     * Click on Tolak Button on owner dashboard
     */
    public void clickOnTolakViaHomepage() {
        playwright.clickOn(tolakButton);
    }

    /**
     * check if pengajuan section dashboard is present
     *
     * @return true if appears pengajuan sewa section
     */
    public boolean isPengajuanSewaSectionPresent() {
        pengajuanSewaSection.waitFor();
        return playwright.waitTillLocatorIsVisible(pengajuanSewaSection);
    }

    /**
     * Click on gold plus widget button
     */
    public void clickOnGpWidgetButton() {
        playwright.clickOn(gpWidgetButton);
    }

    /**
     * Click on pusat bantuan owner
     */
    public void clickHelpCenterOwner() {
        playwright.pageScrollUntilElementIsVisible(helpCenter);
        playwright.clickOn(helpCenter);
    }

    /**
     * Click on see all notification
     */
    public void clicOnSeeAllNotification() {
        playwright.waitTillLocatorIsVisible(seeAllNotification);
        playwright.clickOn(seeAllNotification);
    }


}
