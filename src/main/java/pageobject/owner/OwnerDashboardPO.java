package pageobject.owner;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import pageobject.owner.kelolatagihan.PengajuanBookingPO;
import pageobject.owner.kelolatagihan.TenantBillManagementPO;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

import java.util.List;

public class OwnerDashboardPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private LocatorHelpers locator;
    private Locator ownerProfile;
    private Locator manajemenKost;
    private Locator pengajuanSewaBtn;
    private Locator kelolaTagihan;
    private Locator broadcastChatBtn;
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
    Locator seeAllNotification;
    Locator gpStatus;
    Locator menuKelolaProperty;
    Locator ftueChatListOwner;
    Locator icnCloseBcTooltip;
    Locator gpLabelChatList;
    Locator helpCenterOwnerButton;
    Locator notificationOwnerButton;
    Locator ownerUserName;
    Locator mamikosLogo;
    Locator bookingKosButton;
    Locator promoAdsButton;
    Locator homeHelpCenterButton;
    Locator propertySayaDropdownMenu;
    Locator ownerPageButton;
    Locator ownerLogoutButton;
    Locator chatCSButton;
    Locator contactUsPopUp;
    Locator greetingUserLabel;
    Locator accountSettingsButton;
    Locator addKostButton;
    Locator widgetTitleWaktunyaMengelolaProperti;
    Locator widgetSubtitleWaktunyaMengelolaProperti;
    Locator logoutOwnerPageButton;
    Locator ratingCardDetails;
    Locator textOnReviewList;
    Locator reviewLists;
    Locator detailReviewLists;
    Locator ratingCardWrapperLists;

    private Locator fiturPromosiExpand;

    public OwnerDashboardPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.locator = new LocatorHelpers(page);
        manajemenKost = playwright.locatorByRoleAndText(locator.roleComplementary, "Manajemen Kos");
        pengajuanSewaBtn = playwright.getButtonBySetName("Pengajuan Sewa");
        ownerProfile = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("mamikos").setExact(true));
        kelolaTagihan = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kelola Tagihan"));
        broadcastChatBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Broadcast Chat"));
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
        seeAllNotification = page.locator("//div[@class='c-notification__see-more']");
        gpStatus = page.locator(".membership-card__label");
        ftueChatListOwner = page.locator("[data-testid='ftueTooltipComponent']");
        icnCloseBcTooltip = page.locator("//button[contains(@class, 'bg-c-button')]/following::div[@id='tooltipContent']");
        gpLabelChatList = page.locator(".mc-goldplus-entrypoint-card");
        helpCenterOwnerButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Pusat Bantuan"));
        notificationOwnerButton = page.locator("[href='#basic-notification']");
        ownerUserName = page.locator(".c-mk-header__username");
        mamikosLogo = page.locator(".c-mk-header__logo");
        bookingKosButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Icon Booking Kos Booking Kos"));
        promoAdsButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Icon Promote Promosikan Iklan Anda"));
        homeHelpCenterButton = page.locator("#globalNavbar").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Pusat Bantuan"));
        propertySayaDropdownMenu = page.getByText("kos-marketing Properti Saya chevron-right Kos Apartemen");
        ownerPageButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Halaman Pemilik"));
        ownerLogoutButton = page.getByTestId("exitButton");
        chatCSButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Chat CS"));
        contactUsPopUp = page.frameLocator("iframe[title=\"Find more information here\"]").getByTestId("widget-header-view");
        greetingUserLabel = page.locator(".greeting-section__name");
        accountSettingsButton = page.getByText("Setelan Akun");
        logoutOwnerPageButton = page.getByText("Logout");
        addKostButton = page.locator("//p[contains(.,'Tambah Properti')]");
        widgetTitleWaktunyaMengelolaProperti = page.locator("//*[@class='mk-action-card__main-content-title bg-c-text bg-c-text--title-5']");
        widgetSubtitleWaktunyaMengelolaProperti = page.locator("//*[@class='mk-action-card__main-content-subtitle bg-c-text bg-c-text--body-2']");
        ratingCardDetails = page.locator(".rating-card__details");
        reviewLists = page.locator(".rating-card");
        detailReviewLists = page.locator("//*[@class='row stats-list']");
        ratingCardWrapperLists = page.locator(".rating-card__wrapper");
        fiturPromosiExpand = page.getByText("Fitur Promosi");
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
        playwright.waitFor(pengajuanSewaBtn);
        playwright.clickOn(pengajuanSewaBtn);
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
        tolakButton.waitFor();
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
     * Click on see all notification
     */
    public void clicOnSeeAllNotification() {
        playwright.waitTillLocatorIsVisible(seeAllNotification);
        playwright.clickOn(seeAllNotification);
    }

    /**
     * Verify GP Status ( Menunggu pembayaran, Sedang Diproses, Goldplus 1, Goldplus 2)
     *
     * @return text gpStatus
     */
    public String getTextGPStatus() {
        return playwright.getText(gpStatus);
    }

    /**
     * click on menu one of feature kelola property
     * @param menu is menu on feature kelola property
     */
    public void clickOnMenuKelolaProperty(String menu){
        page.reload();
        menuKelolaProperty = page.locator("//p[contains(.,'"+menu+"')]");
        playwright.pageScrollUntilElementIsVisible(menuKelolaProperty);
        playwright.clickOn(menuKelolaProperty);
    }

    /**     * check FTUE at chat list is present
     *
     * @return true if appears FTUE Chat List section
     */
    public boolean isFTUEChatDisplayed() {
        return playwright.waitTillLocatorIsVisible(ftueChatListOwner);
    }

    /**
     * Get title FTUE text
     *
     * @return titleFtue
     * @params titleFtue
     */
    public String getTitleFtue(String titleFtue) {
        String titleFtueElement = "//p[contains(.,'" + titleFtue + "')]";
        playwright.waitTillLocatorIsVisible(page.locator(titleFtueElement));
        return playwright.getText(page.locator(titleFtueElement));
    }

    /**
     * Get description FTUE text
     *
     * @return descFtue
     * @params descFtue
     */
    public String getDescFtue(String descFtue) {
        String descElement = "//p[contains(.,'" + descFtue + "')]";
        playwright.waitTillLocatorIsVisible(page.locator(descElement));
        return playwright.getText(page.locator(descElement));
    }

    /**
     * Click on close icon Broadcast Chat tooltip
     *
     * @throws InterruptedException
     */
    public void clickOnCloseIconBcTooltip() throws InterruptedException {
        playwright.waitTillLocatorIsVisible(icnCloseBcTooltip);
        playwright.clickOn(icnCloseBcTooltip);
    }

    /**
     * Verify Goldplus Label is display or not
     *
     * @return gpLabelChatList
     */
    public boolean isGoldplusLabelDisplayed() {
        playwright.waitTillLocatorIsVisible(gpLabelChatList);
        return gpLabelChatList.isVisible();
    }

    /**
     * Check element help center owner button header is displayed
     *
     * @return status true / false
     */
    public Boolean isHelpCenterOwnerDisplayed() {
        return playwright.waitTillLocatorIsVisible(helpCenterOwnerButton);
    }

    /**
     * Check element notification button owner header is displayed
     *
     * @return status true / false
     */
    public boolean isNotificationOwnerButtonDisplayed() {
        return playwright.waitTillLocatorIsVisible(notificationOwnerButton);
    }

    /**
     * Get owner username in top right
     *
     * @return String owner username
     */
    public String getOwnerUsername() {
        return playwright.getText(ownerUserName);
    }

    /**
     * Click mamikos.com logo
     */
    public void clickOnMamikosLogo() {
        playwright.clickOn(mamikosLogo);
    }

    /**
     * Click booking kos on dashboard
     */
    public void clickOnBookingKos() {
        playwright.clickOn(bookingKosButton);
    }

    /**
     * Click booking kos on dashboard
     */
    public void clickOnPromosiIklanAnda() {
        playwright.clickOn(promoAdsButton);
    }

    /**
     * Click booking kos on dashboard
     */
    public void clickOnPusatBantuan() {
        playwright.clickOn(homeHelpCenterButton);
    }

    /**
     * Check  dropdown property saya
     * @return true if dropdown menu showing. Otherwise false
     */
    public boolean isPropertyMenuDropdownShowing(){
        return playwright.waitTillLocatorIsVisible(propertySayaDropdownMenu);
    }

    /**
     * Check element owner page is displayed
     *
     * @return status true / false
     */
    public Boolean isOwnerPageDisplayed() {
        return playwright.waitTillLocatorIsVisible(ownerPageButton);
    }

    /**
     * Check element Exit button is displayed
     *
     * @return status true / false
     */
    public Boolean isExitButtonDisplayed() {
        return playwright.waitTillLocatorIsVisible(ownerLogoutButton);
    }

    /**
     * Click on Owner Page
     */
    public void clickOnOwnerPage() {
        playwright.clickOn(ownerPageButton);
    }

    /**
     * Click on "Chat CS"
     */
    public void clickOnChatCS() {
        playwright.clickOn(chatCSButton);
    }

    /**
     * Check contact us pop up is present
     * @return true if appear
     */
    public boolean isContactUsPresent() {
        return playwright.waitTillLocatorIsVisible(contactUsPopUp);
    }

    /**
     * Get username greeting in owner dashboard
     * @return String "Halo, <username>"
     */
    public String getUserGreeting() {
        return playwright.getText(greetingUserLabel);
    }

    /**
     * Click on username greeting in owner dashboard
     * */
    public void clickUserGreeting() {
        playwright.clickOn(greetingUserLabel);
    }

    /**
     * Click on Owner username in top right
     */
    public void clickOwnerUserName() {
        playwright.clickOn(ownerUserName);
    }

    /**
     * Get Settings label in pop up main menu
     *
     * @return text settings label
     */
    public String getSettingsLabel() {
        return playwright.getText(accountSettingsButton);
    }

    /**
     * Get Logout label in pop up main menu
     *
     * @return text logout label
     */
    public String getLogoutLabel() {
        return playwright.getText(logoutOwnerPageButton).trim();
    }

    /**
     * Get Text of Review Title by index
     * @param index - index review title
     * @return text of Review Page
     */
    public String widgetWaktunyaMengelolaProperti (String widgetList, int index){
        String value= "";
        page.waitForLoadState();
        playwright.pageScrollUntilElementIsVisible(widgetTitleWaktunyaMengelolaProperti.nth(5));
        if (widgetList.equals("title")) {
            value = playwright.getText(widgetTitleWaktunyaMengelolaProperti.nth(index));
        } else if (widgetList.equals("subtitle")) {
            value = playwright.getText(widgetSubtitleWaktunyaMengelolaProperti.nth(index));
        }
        return value;
    }

    /**
     * Scroll to Rating Card Details and Click Rating Card Details
     */
    public void clickOnRatingCardDetails() {
        playwright.pageScrollUntilElementIsVisible(ratingCardDetails);
        playwright.clickOn(ratingCardDetails);
    }

    /**
     * Check contact us pop up is present
     * @return true if appear
     */
    public boolean isTextOnReviewListPresent(String text) {
        playwright.hardWait(3000.0);
        textOnReviewList = page.locator("//p[contains(.,'"+text+"')]");
        return playwright.waitTillLocatorIsVisible(textOnReviewList);
    }

    /**
     * Get Review Lists Card
     * @return integer
     */
    public Integer getReviewListsCard() {
        playwright.hardWait(5000.0);
        List<Locator> listCities = playwright.getLocators(reviewLists);
        return listCities.size();
    }

    /**
     * Click on Kos Review Listing
     */
    public void clickOnKosReviewListing() {
        playwright.clickOn(reviewLists.first());
    }

    /**
     * Is Detailed Review Lists Appear?
     * @return true or false
     */
    public Boolean isDetailedReviewListsAppear() {
        return playwright.waitTillLocatorIsVisible(detailReviewLists.first());
    }

    /**
     * Get Rating Card Wrapper List Size
     *
     * @return int
     */
    public Integer getRatingCardWrapperSize() {
        playwright.hardWait(2000.0);
        List<Locator> listCard = playwright.getLocators(ratingCardWrapperLists);
        return listCard.size();
    }

    /**
     * Is See All Kost Review Text Appear?
     *
     * @return true or false
     */
    public Boolean isSeeAllKostReviewTextAppear() {
        return playwright.waitTillLocatorIsVisible(reviewLists);
    }

    /**
     * Click in order to expand promotion feature
     */
    public void clickToExpandFiturPromosi() {
        playwright.clickOn(fiturPromosiExpand);
    }

    /**
     * Click on Broadcast Chat after fitur promosi is expanded
     */
    public void clickOnBroadcastChat() {
        playwright.clickOn(broadcastChatBtn);
    }
}
