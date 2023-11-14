package pageobject.owner.kelolatagihan;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

public class PengajuanSewaPO {
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
    Locator terimaButtonPopUp;
    private Locator searchKost;
    private Locator searchKostInputText;
    private Locator searchKostFirstOption;
    private Locator lainnyaRejectReasonRadioBtn;
    private Locator lainnyaRejectReasonInput;
    private Locator tncCheckmarkRejectReason;
    private Locator pilihOnRejectButton;



    public PengajuanSewaPO(Page page) {
        this.page = page;
        playwright = new PlaywrightHelpers(page);
        locator = new LocatorHelpers(page);
        this.terimaButton = playwright.locatorByRoleSetName(locator.roleButton, "Terima").first();
        this.yaTerimaButton = playwright.locatorByRoleSetName(locator.roleButton, "Ya, Terima");
        this.tolakButton = page.getByTestId("bookingRequestDetail-actionButtonDesktop").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Tolak"));
        this.yaTolakButton = playwright.locatorByRoleSetName(locator.roleButton, "Ya, Tolak");
        this.rejectButton =  page.getByTestId("bookingRequestDetail-actionButtonDesktop").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Tolak"));
        this.acceptButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ya, Tolak"));
        terimaButtonPopUp = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ya, Terima"));
        this.searchKost = page.getByPlaceholder("Pilih Kos");
        this.searchKostInputText = page.getByTestId("bookingRequestKosFilter-searchBar");
        this.searchKostFirstOption = page.locator(".bg-c-dropdown__menu--fixed li:nth-of-type(1) .bg-c-dropdown__menu-item-content");
        this.lainnyaRejectReasonRadioBtn = page.locator("div:nth-child(10) > .reject-modal__reason-option-overlay");
        this.lainnyaRejectReasonInput = page.getByPlaceholder("Masukkan alasan lainnya di sini");
        this.tncCheckmarkRejectReason = page.locator("span").filter(new Locator.FilterOptions().setHasText("checkmark"));
        this.pilihOnRejectButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih"));
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
        playwright.waitTillLocatorIsVisible(terimaButtonWithName);
        playwright.clickOn(terimaButtonWithName);
        playwright.clickOn(yaTerimaButton);
        return new BillAndBookingManagementPO(page);
    }

    /**
     * Check if terima button with name visible
     * @param tenantName Tenant Name
     * @return boolean
     */
    public boolean terimaButtonWithNameVisible(String tenantName) {
        terimaButtonWithName = page.getByTestId("bookingRequestList-list")
                .locator("div").filter(new Locator.FilterOptions()
                        .setHasText(tenantName)).getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Terima"));
        return playwright.waitTillLocatorIsVisible(terimaButtonWithName);
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
        rejectButton.waitFor();
        rejectButton.click();
        acceptButton.click();
        return new BillAndBookingManagementPO(page);
    }

    /**
     * Click on terima popup from view detail
     */
    public void clickOnTerimaPopUp() {
        terimaButtonPopUp.click();
    }

    /**
     * search kost name on filter pengajuan booking page
     * @param kostName that want to search
     */
    public  BillAndBookingManagementPO searchKostOnKostFilter(String kostName) {
        searchKost.click();
        searchKostInputText.fill(kostName);
        searchKostFirstOption.click();
        return new BillAndBookingManagementPO(page);
    }

    /**
     * click "Ya, Tolak" when reject booking request
     */
    public void clickYaTolakOnPengajuanBooking() {
        playwright.waitTillLocatorIsVisible(yaTolakButton);
        yaTolakButton.click();
    }

    /**
     * click and input reason on lainnya
     * reject reason until check tnc and click pilih
     * @param reason stands for input reason string
     */
    public void clickAndFillLainnyaRejectReason(String reason) {
        lainnyaRejectReasonRadioBtn.click();
        lainnyaRejectReasonInput.fill(reason);
        tncCheckmarkRejectReason.click();
        pilihOnRejectButton.click();
        playwright.hardWait(1000);
    }
}
