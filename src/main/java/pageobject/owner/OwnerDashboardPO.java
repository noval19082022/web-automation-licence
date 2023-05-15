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
    }

    /**
     * Click based on Text
     */
    public void clickOnText(String menu) {
        playwright.waitTillLocatorIsVisible(page.getByText(menu),3000.0);
        playwright.delayAndClickOn(page.getByText(menu),3000.0);
        playwright.hardWait(5000);
    }

    /**
     * Click based on Text Button
     */
    public void clickOnTextButton(String buttonText) {
        playwright.waitTillLocatorIsVisible(page.getByRole(AriaRole.BUTTON).filter(new Locator.FilterOptions().setHasText(buttonText)),3000.0);
        playwright.clickOn(page.getByRole(AriaRole.BUTTON).filter(new Locator.FilterOptions().setHasText(buttonText)));
        playwright.hardWait(3000);
    }

    /**
     * Check element based on text is displayed
     *
     * @return status true / false
     */
    public boolean isTextDisplayed(String text) {
        playwright.hardWait(3000);
        return playwright.isLocatorVisibleAfterLoad(page.getByText(text), 3000.0);
    }


    /**
     * Check if element button based on text is displayed
     *
     * @return status true / false
     */
    public boolean isButtonWithTextDisplayed(String button){
        playwright.hardWait(3000.0);
        return playwright.waitTillLocatorIsVisible(page.getByRole(AriaRole.BUTTON).filter(new Locator.FilterOptions().setHasText(button)),5000.0);
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
}
