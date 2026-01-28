package pageobject.owner;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import config.playwright.context.ActiveContext;
import pageobject.owner.kelolatagihan.PengajuanSewaPO;
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
    private Locator tagihanPenyewa;
    private Locator broadcastChatBtn;
    Locator warningBroadcastText;
    Locator closePopUpIcon;
    private Locator penyewaMenu;
    Locator notificationButton;
    Locator firstNotificationText;
    Locator mamipoinButton;
    Locator pengajuanSewaSection;
    Locator gpWidgetButton;
    Locator seeAllNotification;
    Locator gpStatusImage;
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
    Locator mamiadsSubtitle;
    Locator mamiadsLihatDisini;
    Locator saldoMamiAdsButton;
    Locator noProperty;
    Locator propertySekitar;
    Locator dropdownKosName;
    Locator toggleEntryTime;
    Locator dropDownJumlahWaktu;
    Locator dropDownUnitTime;
    Locator saveInPopUpButton;
    Locator nearestTimeSaveButton;
    Locator saveBssButton;
    Locator toggleEnable;
    Locator mamitourDashboard;
    Locator mamitourMenu;
    Locator mamifotoButton;
    Locator pageHeader;
    Locator totalNotBookingPopup;
    Locator closeIconOnNotBookingPopup;
    Locator daftarPenyewMenu;
    Locator ubahPeraturan;
    Locator dariMamikosSection;
    Locator dariMamikosBanner;
    Locator daftarGpButton;
    Locator entryPointCardGP;
    Locator gpspPromoCountDown;

    private Locator fiturPromosiExpand;
    private Locator nantiSajaButton;
    private Locator goldPlusFeaturePopupText;
    private Locator goldPlusWelcomePopupText;
    private Locator widgetDaftarGoldplus;
    private Locator leadsMenu;
    private Locator mamiprimeWidget;
    private Locator mamiprimeBannerPopUp;
    private Locator mamiprimeBannerCloseButton;

    private Locator perpanjangBtnReccuringGpPopUp;
    private Locator dialogPopUp;
    private Locator widgetInfoUntukAndaParagraph;
    private Locator informationCard;
    private Locator generalCloseButton;
    private Locator welcomeTitle;
    private Locator welcomeSubtitle;
    private Locator pasangIklanPertamaButton;
    private Locator pilihPaketGoldplus;
    private Locator inginKosDikelolaLink;
    private Locator gpPeriodFavoriteOption;
    private Locator gpPeriodFirstOption;
    private Locator pilihPeriodeButton;

    public OwnerDashboardPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.locator = new LocatorHelpers(page);
        manajemenKost = page.locator(".bg-l-sidebar__item p").filter(new Locator.FilterOptions().setHasText("Manajemen Kos"));
        pengajuanSewaBtn = page.getByRole(AriaRole.PARAGRAPH).filter(new Locator.FilterOptions().setHasText("Pengajuan Sewa"));
        ownerProfile = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("mamikos").setExact(true));
        tagihanPenyewa = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tagihan Penyewa"));
        broadcastChatBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Broadcast Chat"));
        warningBroadcastText = page.locator("//h3[@class='bg-c-modal__body-title']");
        closePopUpIcon = page.locator(".bg-c-modal__action-closable");
        penyewaMenu = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kontrak Penyewa"));
        notificationButton = page.locator(".notification-menu > .bg-c-icon");
        firstNotificationText = page.locator(".c-notification__item").first();
        mamipoinButton = page.getByText("MamiPoin");
        pengajuanSewaSection = page.locator("div.booking-confirmation-section__content");
        gpWidgetButton = page.locator(".goldplus-card__main");
        seeAllNotification = page.locator("//div[@class='c-notification__see-more']");
        gpStatusImage = page.locator("img[src*='logo-goldplus']");
        ftueChatListOwner = page.locator("[data-testid='ftueTooltipComponent']");
        icnCloseBcTooltip = page.locator("//button[contains(@class, 'bg-c-button')]/following::div[@id='tooltipContent']");
        gpLabelChatList = page.locator(".mc-goldplus-entrypoint-card");
        helpCenterOwnerButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Pusat Bantuan"));
        notificationOwnerButton = page.locator("[href='#basic-notification']");
        ownerUserName = page.locator(".c-mk-header__username");
        mamikosLogo = page.locator(".c-mk-header__logo");
        bookingKosButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Icon Sewa Kos Sewa Kos"));
        promoAdsButton = page.locator("//span[.='Promosikan Iklan Anda']");
        homeHelpCenterButton = page.locator("#globalNavbar").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Pusat Bantuan"));
        propertySayaDropdownMenu = page.locator("(//div[@class='bg-c-grid__item bg-is-col-3'])[1]");
        ownerPageButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Halaman Pemilik"));
        ownerLogoutButton = page.getByTestId("exitButton");
        chatCSButton = page.getByTestId("chat-cs-btn");
        contactUsPopUp = page.locator("//iframe[@title='Messaging window']");
        greetingUserLabel = page.locator(".greeting-section__name");
        accountSettingsButton = page.getByText("Setelan Akun");
        logoutOwnerPageButton = page.getByText("Logout");
        addKostButton = page.locator("//p[contains(.,'Tambah Properti')]");
        widgetTitleWaktunyaMengelolaProperti = page.locator("//*[@class='mk-action-card__main-content-title bg-c-text bg-c-text--title-5']");
        widgetSubtitleWaktunyaMengelolaProperti = page.locator("//*[@class='mk-action-card__main-content-subtitle bg-c-text bg-c-text--body-2']");
        ratingCardDetails = page.locator(".rating-card__details");
        reviewLists = page.locator(".rating-card");
        detailReviewLists = page.locator("(//div[@class='row stats-list'])[1]");
        ratingCardWrapperLists = page.locator(".rating-card__wrapper");
        mamiadsSubtitle = page.locator("//span[@class='bg-c-text bg-c-text--body-4']");
        mamiadsLihatDisini = page.locator("//h2[@class='bg-c-text bg-c-text--title-2']");
        saldoMamiAdsButton = page.locator(".mamiads-card");
        fiturPromosiExpand = page.getByText("Fitur Promosi");
        noProperty = page.locator(".no-property");
        propertySekitar = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cek Properti Sekitar"));
        dropdownKosName = page.locator("//div[@role='textbox']//*[name()='svg']");
        toggleEntryTime = page.getByRole(AriaRole.CHECKBOX);
        dropDownJumlahWaktu = page.getByTestId("min-checkin-amount").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("chevron-down"));
        dropDownUnitTime = page.getByTestId("min-checkin-time-unit").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("chevron-down"));
        nearestTimeSaveButton = page.getByTestId("checkin-option-modal").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Simpan"));
        saveInPopUpButton = page.getByTestId("checkin-save-btn");
        saveBssButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Simpan"));
        toggleEnable = page.locator("//div[@class='bg-c-switch checkin-setting-modal__d-day-checkin-switch bg-c-switch--on bg-c-switch--hover']");
        mamitourDashboard = page.locator("a").filter(new Locator.FilterOptions().setHasText("virtual-tour-360 MamiTour Tur virtual keliling properti kos chevron-right"));
        mamitourMenu = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("MamiTour"));
        mamifotoButton = page.locator("img[alt='mamifoto-logo']");
        pageHeader = page.locator(".room-page__header");
        totalNotBookingPopup = page.locator("div.suggestion-modal__title");
        closeIconOnNotBookingPopup = page.locator("//*[@class='mdi mdi-close mdi-24px']");
        daftarPenyewMenu = page.locator("a").filter(new Locator.FilterOptions().setHasText("account Penyewa Daftar kontrak penyewa kos chevron-right"));
        ubahPeraturan = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Peraturan Sewa"));
        dariMamikosSection = page.getByText("Dari Mamikos", new Page.GetByTextOptions().setExact(true));
        dariMamikosBanner = page.locator(".banner-card__image-wrapper > .bg-c-image__img").first();
        nantiSajaButton = page.locator("//button[normalize-space()='Nanti Saja']");
        goldPlusFeaturePopupText = page.getByText("Sudah cek fitur-fitur GoldPlus ini?").first();
        goldPlusWelcomePopupText = page.getByText("Selamat bergabung di GoldPlus 2!").first();
        widgetDaftarGoldplus = page.getByTestId("registerGP_btn");
        daftarGpButton = page.getByTestId("registerGP_btn");
        leadsMenu = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Leads"));
        mamiprimeWidget = page.getByTestId("membership-prime-card");
        mamiprimeBannerPopUp = page.frameLocator("iframe >> nth=0").getByRole(AriaRole.LINK);
        mamiprimeBannerCloseButton = page.frameLocator("iframe >> nth=0").getByLabel("Close");
        perpanjangBtnReccuringGpPopUp = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Perpanjang"));
        dialogPopUp = page.locator("//*[@role='dialog' and @aria-modal='true']//button[@class='bg-c-modal__action-closable']");
        widgetInfoUntukAndaParagraph = page.locator(".information-card .information-card__list-wrapper p");
        informationCard = page.locator(".information-card");
        generalCloseButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("close"));
        welcomeTitle = page.getByText("👋🏼  Selamat datang, Owner tanpa kost");
        welcomeSubtitle = page.getByText("Pasang iklan pertama Anda agar bisa segera ditemukan calon penyewa!");
        pasangIklanPertamaButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pasang Iklan Pertama"));
        pilihPaketGoldplus = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih Paket GoldPlus"));
        entryPointCardGP = page.locator(".membership-card__section").first();
        gpspPromoCountDown = page.getByTestId("countdown-container");
        inginKosDikelolaLink = page.locator("a").filter(new Locator.FilterOptions().setHasText("Ingin kos dikelola secara"));
        gpPeriodFavoriteOption = page.locator("//div[contains(@class, 'goldplus-periode-select__option') and contains(., '4 Bulan')]");
        gpPeriodFirstOption = page.locator("//div[contains(@class, 'goldplus-periode-select__option')]").first();
        pilihPeriodeButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih Periode"));
    }

    /**
     * click on icon close at pop up
     * <p>doesn't have kost active</p>
     */
    public void clickOnButtonIconClose(){
        playwright.clickOn(closePopUpIcon);
        playwright.hardWait(2000);
    }

    public void clickOnButtonIconCloseIfExist(){
        if (playwright.waitTillLocatorIsVisible(closePopUpIcon, 3000.0)) {
            playwright.clickOn(closePopUpIcon);
            playwright.hardWait(2000);
        }
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
        if (playwright.isTextDisplayed("Sudah cek fitur-fitur GoldPlus ini?") || playwright.isTextDisplayed("Selamat bergabung di GoldPlus 2!")) {
            playwright.clickOnText("Nanti Saja", 5000.0);
        }
        playwright.waitTillLocatorIsVisible(manajemenKost, 60000.0);
        playwright.clickOn(manajemenKost);
    }

    /**
     * Click on pengajuan booking
     */
    public PengajuanSewaPO clickOnPengajuanSewa() {
        playwright.waitFor(pengajuanSewaBtn);
        playwright.clickOn(pengajuanSewaBtn);
        return new PengajuanSewaPO(page);
    }

    /**
     * Click on Kelola Kos and navigate to Tenant Bill Management
     *
     * @return TenantBillManagementPO class
     */
    public TenantBillManagementPO clickOnKelolaKos() {
        tagihanPenyewa.waitFor();
        playwright.clickOn(tagihanPenyewa);
        return new TenantBillManagementPO(page);
    }

    /**
     * Dismiss FTUE Godlplus
     */
    public void dismissFTUEGoldplus() {
        playwright.hardWait(7_000.0);
        if (playwright.waitTillLocatorIsVisible(nantiSajaButton)) {
            playwright.clickOn(nantiSajaButton);
        }

        if (playwright.isTextDisplayed("Sudah cek fitur-fitur GoldPlus ini?")) {
            playwright.clickOn(closePopUpIcon);
        }
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
        playwright.delayAndClickOn(notificationButton, 3_000.0);
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
        playwright.waitTillPageLoaded();
        playwright.clickOn(mamipoinButton);
    }

    /**
     * check if pengajuan section dashboard is present
     *
     * @return true if appears pengajuan sewa section
     */
    public boolean isPengajuanSewaSectionPresent() {
        return playwright.waitTillLocatorIsVisible(pengajuanSewaSection);
    }

    /**
     * Click on gold plus widget button
     */
    public void clickOnGpWidgetButton() {
        playwright.waitTillLocatorIsVisible(gpWidgetButton);
        playwright.clickOn(gpWidgetButton);
    }

    /**
     * Click on see all notification
     */
    public void clicOnSeeAllNotification() {
        playwright.clickOn(seeAllNotification);
    }

    /**
     * Verify GP Status ( Menunggu pembayaran, Sedang Diproses, Goldplus 1, Goldplus 2)
     * Extracts GP level from the goldplus logo image filename
     *
     * @return text gpStatus (e.g., "GoldPlus 2")
     */
    public String getTextGPStatus() {
        // Wait for goldplus image to be visible
        playwright.waitFor(gpStatusImage);

        // Get the image src attribute
        String imgSrc = playwright.getAttributeValue(gpStatusImage, "src");

        // Extract GP level from filename pattern: logo-goldplus-gradient-{number}.webp
        if (imgSrc != null && imgSrc.contains("logo-goldplus-gradient-")) {
            String level = imgSrc.replaceAll(".*logo-goldplus-gradient-(\\d+).*", "$1");
            return "GoldPlus " + level;
        }

        // Fallback to empty string if pattern not found
        return "";
    }

    /**
     * click on menu one of feature kelola property
     * @param menu is menu on feature kelola property
     */
    public void clickOnMenuKelolaProperty(String menu){
        menuKelolaProperty = page.locator("//p[contains(.,'"+menu+"')]");
        playwright.waitFor(menuKelolaProperty);
        playwright.pageScrollUntilElementIsVisible(menuKelolaProperty);
        playwright.clickOn(menuKelolaProperty);
    }

    /**
     * Dismiss GoldPlus features pop-up if it appears
     * Handles multiple GoldPlus popup variants:
     * - "Sudah cek fitur-fitur GoldPlus ini?"
     * - "Selamat bergabung di GoldPlus 2!"
     */
    public void dismissPopUp() {
        playwright.hardWait(3000);

        if (goldPlusFeaturePopupText.count() > 0) {
            if (nantiSajaButton.count() > 0) {
                playwright.clickOn(nantiSajaButton);
            }
        }

        if (goldPlusWelcomePopupText.count() > 0) {
            if (nantiSajaButton.count() > 0) {
                playwright.clickOn(nantiSajaButton);
            }
        }
    }

    /** check FTUE at chat list is present
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
        playwright.waitFor(helpCenterOwnerButton);
        return playwright.waitTillLocatorIsVisible(helpCenterOwnerButton);
    }

    /**
     * Check element notification button owner header is displayed
     *
     * @return status true / false
     */
    public boolean isNotificationOwnerButtonDisplayed() {
        playwright.waitFor(notificationOwnerButton);
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
        playwright.waitFor(contactUsPopUp);
        return playwright.waitTillLocatorIsVisible(contactUsPopUp);
    }

    /**
     * Wait for owner dashboard to be fully loaded
     * Waits for the greeting label to be visible
     */
    public void waitForOwnerDashboardToLoad() {
        playwright.waitTillLocatorIsVisible(greetingUserLabel, 10000.0);
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
        playwright.waitTillPageLoaded();
        textOnReviewList = page.locator("//p[contains(.,'"+text+"')]");
        return playwright.waitTillLocatorIsVisible(textOnReviewList);
    }

    /**
     * Get Review Lists Card
     * @return integer
     */
    public Integer getReviewListsCard() {
        playwright.hardWait(5000.0);
        playwright.waitTillPageLoaded();
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
        return playwright.waitTillLocatorIsVisible(detailReviewLists, 5000.0);
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
        playwright.waitFor(fiturPromosiExpand);
        playwright.clickOn(fiturPromosiExpand);
    }

    /**
     * Click on Broadcast Chat after fitur promosi is expanded
     */
    public void clickOnBroadcastChat() {
        playwright.clickOn(broadcastChatBtn);
    }

    /**
     * Get text of mamiads subtitle
     * @return String subtitle text mamiads
     */
    public String getSubtitleMamiads() {
        return playwright.getText(mamiadsSubtitle);
    }

    /**
     * Get text lihat disini mamiads
     * @return String lihat disini text
     */
    public String getLihatDisiniMamiads() {
        playwright.waitTillLocatorIsVisible(mamiadsSubtitle);
        return playwright.getText(mamiadsLihatDisini);
    }

    /**
     * Wait till locator is visible and click
     * on saldo mamiads card on owner dashboard
     */
    public void clickSaldoMamiAdsButton() {
        playwright.waitForLocatorVisibleAndClickOn(saldoMamiAdsButton);
    }

    /**
     * Click Waktunya Mengelola Properti
     * @param action
     *
     */
    public void clickOnWaktunyaMengelolaProperti(String action) {
        Locator element = page.locator("//p[contains(., '"+ action +"')]");
        playwright.pageScrollUntilElementIsVisible(element);
        playwright.clickOn(element);
    }

    /**
     * Validate have active kos
     * @return noProperty
     *
     */
    public boolean isNoHaveActiveKos() {
        return playwright.isLocatorVisibleAfterLoad(noProperty, 2000.0);
    }

    /**
     * Click Tambah button kos
     *
     *
     */
    public void clickOnTambahKos() {
        playwright.clickOnTextButton("Tambah Kos", 3000.0);
    }

    /**
     * Click tambah kos baru button
     *
     *
     */
    public void clickOnTambahKosBaru() {
        playwright.clickOnText("Tambah Kos Baru", 3000.0);
    }

    /**
     * Verify is tambah kos visible
     * @return boolean true false
     *
     */
    public boolean isTambahKosVisible() {
        return playwright.isButtonWithTextDisplayed("Tambah Kos");
    }

    /**
     * Click on cek properti sekitar
     */
    public void clickOnPropertySekitar() {
        playwright.clickOn(propertySekitar);
    }

    /**
     * Click on dropdown kos name
     */
    public void clickOnDropdownKosName() {
        playwright.clickOn(dropdownKosName);
    }

    /**
     * Click on toogle entry time kos
     */
    public void clickOnToggleEntryTime() {
        if (toggleEnable.isVisible()) {
            toggleEntryTime.click();
        }
    }

    /**
     * fill Nearest Amount Time
     */
    public void fillNearestAmountTime(String amount, String unitTime) {
        playwright.clickOn(dropDownJumlahWaktu);
        Locator amountTime = page.locator("//p[normalize-space()='" + amount + "']");
        playwright.clickOn(amountTime);
        playwright.clickOn(nearestTimeSaveButton);
        playwright.clickOn(dropDownUnitTime);
        Locator unitTimeNearest = page.locator("//p[normalize-space()='" + unitTime + "']");
        playwright.clickOn(unitTimeNearest);
        playwright.clickOn(nearestTimeSaveButton);
        playwright.clickOn(saveInPopUpButton);
        playwright.clickOn(saveBssButton);
    }

    /**
     * click on mamitour entry point on owner dashboard
     */
    public void clickMamitourOnDashboard() {
        playwright.waitFor(mamitourDashboard);
        playwright.clickOn(mamitourDashboard);
    }

    /**
     * click on mamitour menu on sidebar
     */
    public void clickMamitourOnSidebar() {
        playwright.clickOn(mamitourMenu);
    }

    /**
     * click on mamifoto button on owner dashboard
     */
    public void clickOnMamiFoto() {
        playwright.waitTillLocatorIsVisible(mamifotoButton, 30000.0);
        playwright.clickOn(mamifotoButton);
    }

    /**
     * Get text the page header
     * @return page header text
     *
     */
    public String getPageHeader() {
        return playwright.getText(pageHeader);
    }

    /**
     * Verify total not booking popup present
     * @return true if present and false if not present
     *
     */
    public boolean isTotalNotBookingPopupPresent() {
        return playwright.waitTillLocatorIsVisible(totalNotBookingPopup, 10000.0);
    }

    /**
     * Click close on pop up total not booking
     *
     */
    public void clickOnCloseOnPopupTotalNotBooking() {
        playwright.clickOn(closeIconOnNotBookingPopup);
    }

    /**
     * Click penyewa on waktunya mengelola properti in owner dashboard
     *
     */
    public void clickOnPenyewaWaktunyaMengelolaProperti() {
        playwright.clickOn(daftarPenyewMenu);
    }

    /**
     * Click pusat bantuan on waktunya mengelola properti in owner dashboard
     *
     */
    public void clickOnPusatBantuanWaktunyaMengelolaProperti() {
        playwright.clickOn(helpCenterOwnerButton);
    }

    public void clickUbahPeraturanButton(){
        clickOnManagementKost();
        playwright.waitFor(ubahPeraturan);
        playwright.clickOn(ubahPeraturan);
    }

    public void scrollIntoDariMamikosSection() {
        playwright.pageScrollInView(dariMamikosSection);
    }

    public void clickOnBannerDariMamikosSection() {
        // Wait for the banner to be visible first
        playwright.waitTillLocatorIsVisible(dariMamikosBanner);
        // Force click to bypass intercepting elements
        playwright.forceClickOn(dariMamikosBanner);
    }

    /**
     * Verify widget Dafter Goldplus
     * @return true if present and false if not present
     *
     */
    public boolean isWidgetDaftarGoldplusDisplayed(){
        return playwright.waitTillLocatorIsVisible(widgetDaftarGoldplus, 5000.0);
    }

    /**
     * Check if GP widget is visible on dashboard
     *
     * @return boolean
     */
    public boolean isGPWidgetVisible() {
        return playwright.waitTillLocatorIsVisible(gpWidgetButton, 5000.0);
    }

    /**
     * Click on GP widget from dashboard
     */
    public void clickOnGPWidget() {
        playwright.waitFor(gpWidgetButton, 5000.0);
        playwright.clickOn(gpWidgetButton);
        playwright.waitTillPageLoaded();
    }

    /**
     * Click daftar GP on owner dashboard
     * This method handles the popup that appears after clicking the daftar GP button
     *
     */
    public void clickOnDaftarGP() {
        // Handle popup with multiple strategies
        boolean popupClosed = handlePopupWithMultipleStrategies();

        // Try popup handling again if needed
        if (!popupClosed) {
            System.out.println("Trying popup handling again before clicking daftar GP...");
            handlePopupWithMultipleStrategies();
        }

        playwright.waitTillPageLoaded();
        if (playwright.waitTillLocatorIsVisible(daftarGpButton)) {
            playwright.clickOn(daftarGpButton);
            handleDaftarGPPeriodSelectionPopup();
        } else {
            playwright.waitTillLocatorIsVisible(entryPointCardGP, 30000.0);
            playwright.clickOn(entryPointCardGP);
        }
    }

    /**
     * Handle the GoldPlus period selection popup that appears after clicking daftar GP button
     * This popup appears in the @TEST_LIMO-1393 scenario
     */
    private void handleDaftarGPPeriodSelectionPopup() {
        playwright.waitTillPageLoaded();

        // Check if we're redirected to the GoldPlus period selection page
        if (page.url().contains("goldplus/submission/periode")) {
            System.out.println("GoldPlus period selection popup detected after clicking daftar GP button");

            // Wait for the page to load and elements to be visible
            playwright.hardWait(2000.0);

            // Look for the favorite option (4 Bulan option which is marked as "Favorit")
            if (playwright.waitTillLocatorIsVisible(gpPeriodFavoriteOption, 5000.0)) {
                playwright.clickOn(gpPeriodFavoriteOption);
                System.out.println("Selected 4 Bulan (Favorit) option in GoldPlus period selection popup");
            } else {
                // If favorite option not found, select the first available option
                if (playwright.waitTillLocatorIsVisible(gpPeriodFirstOption, 3000.0)) {
                    playwright.clickOn(gpPeriodFirstOption);
                    System.out.println("Selected first available period option in GoldPlus period selection popup");
                }
            }

            // Click the "Pilih Periode" button if it exists
            if (playwright.waitTillLocatorIsVisible(pilihPeriodeButton, 3000.0)) {
                playwright.clickOn(pilihPeriodeButton);
                System.out.println("Clicked 'Pilih Periode' button in GoldPlus period selection popup");
            }

            if (playwright.waitTillLocatorIsVisible(pilihPaketGoldplus, 3000.0)) {
                playwright.clickOn(pilihPeriodeButton);
            }
        } else {
            System.out.println("No GoldPlus period selection popup detected. Current URL: " + page.url());
        }
    }

    /**
     * Check is leads menu visible
     * @return boolean
     */
    public boolean isLeadsMenuVisible() {
        playwright.waitTillLocatorIsVisible(leadsMenu, 30000.0);
        return playwright.isLocatorVisibleAfterLoad(leadsMenu,5000.0);
    }

    /**
     * Click leads menu
     */
    public void clickLeadsMenu() {
        Page newTab = page.waitForPopup(() -> {
            playwright.clickOn(leadsMenu);
        });
        newTab.waitForLoadState();
        System.out.println(newTab.title());
        ActiveContext.setActivePage(newTab);
    }

    /** Click on FTUE on button
     * @param buttonText
     */
    public void clickOnButtonFTUE(String buttonText) {
        Locator buttonTextFtue = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(buttonText));
        playwright.clickOn(buttonTextFtue);
    }

    /**
     * Wait till locator is visible and click
     * on mamiprime widget on owner dashboard
     */
    public void clickMamiprimeWidget() {
        playwright.waitForLocatorVisibleAndClickOn(mamiprimeWidget);
    }

    /**
     * Check banner mamiprime pop up visible or not
     * @return
     */
    public boolean isMamiprimeBannerAppear() {
        return playwright.isLocatorVisibleAfterLoad(mamiprimeBannerPopUp,7000.0);
    }

    /**
     * click close button in mamiprime banner pop up
     */
    public void closeMamiprimeBanner() {
        playwright.clickOn(mamiprimeBannerCloseButton);
    }

    /**
     * click on perpanjang btn on gold plus pop up recurring
     */
    public void clickOnPerpanjangGoldPlusPopUp() {
        playwright.clickOn(perpanjangBtnReccuringGpPopUp);
    }

    /**
     * clicks on dialog owner pop-ups
     */
    public void clicksOnCloseIconDialogOwnerPopUp() {
        playwright.hardWait(5000.0);
        if (playwright.waitTillLocatorIsVisible(dialogPopUp)) {
            List<Locator>popUpLocators = playwright.getLocators(dialogPopUp);
            for (var locator : popUpLocators) {
                playwright.clickOn(locator);
            }
        }
    }

    /**
     * Get aria snapshot of Info untuk Anda section
     * @return String aria snapshot of the information card
     */
    public String getInfoUntukAndaAriaSnapshot() {
        // Wait for the information card container to be visible first
        playwright.waitTillLocatorIsVisible(informationCard, 10000.0);
        playwright.hardWait(1000); // Wait for content to render
        return playwright.getAriaSnapshot(informationCard);
    }

    /**
     * Check if welcome title is visible for owner without property
     * @return boolean true if welcome title is visible
     */
    public boolean isWelcomeTitleVisible() {
        return playwright.waitTillLocatorIsVisible(welcomeTitle, 10000.0);
    }

    /**
     * Check if welcome subtitle is visible for owner without property
     * @return boolean true if welcome subtitle is visible
     */
    public boolean isWelcomeSubtitleVisible() {
        return playwright.waitTillLocatorIsVisible(welcomeSubtitle, 10000.0);
    }

    /**
     * Check if Pasang Iklan Pertama button is visible for owner without property
     * @return boolean true if button is visible
     */
    public boolean isPasangIklanPertamaButtonVisible() {
        return playwright.waitTillLocatorIsVisible(pasangIklanPertamaButton, 10000.0);
    }

    /**
     * Get welcome title text
     * @return String welcome title text
     */
    public String getWelcomeTitleText() {
        return playwright.getText(welcomeTitle);
    }

    /**
     * Get welcome subtitle text
     * @return String welcome subtitle text
     */
    public String getWelcomeSubtitleText() {
        return playwright.getText(welcomeSubtitle);
    }

    /**
     * Click on info untuk anda
     * @param targetTextToClick String
     */
    public void clicksOnInfoUntukAnda(String targetTextToClick) {
        Locator infoUntukAndaLocatorToClick = page.locator("//p[contains(text(),'"+targetTextToClick+"')]");
        playwright.clickOn(infoUntukAndaLocatorToClick);
    }

    /**
     * Handle general popup by checking and closing it if it appears
     * @param timeout Maximum time to wait for popup in milliseconds
     * @return true if popup was found and closed, false if no popup appeared
     */
    public boolean handleGeneralPopup(double timeout) {
        if (playwright.waitTillLocatorIsVisible(generalCloseButton, timeout)) {
            System.out.println("Popup detected - attempting to close...");
            playwright.clickOn(generalCloseButton);
            playwright.hardWait(1000.0); // Wait for popup to close
            System.out.println("Popup close attempted");
            return true;
        }
        return false;
    }

    /**
     * Handle general popup with default timeout (3 seconds)
     * @return true if popup was found and closed, false if no popup appeared
     */
    public boolean handleGeneralPopup() {
        return handleGeneralPopup(3000.0);
    }

    /**
     * Handle popup with multiple strategies - try different close button locators
     * @return true if popup was found and closed, false if no popup appeared
     */
    public boolean handlePopupWithMultipleStrategies() {
        // Strategy 1: Try the general close button
        if (playwright.waitTillLocatorIsVisible(generalCloseButton, 2000.0)) {
            System.out.println("Strategy 1: Using general close button");
            playwright.clickOn(generalCloseButton);
            playwright.hardWait(1000.0);
            return true;
        }

        // Strategy 2: Try existing close popup icon
        if (playwright.waitTillLocatorIsVisible(closePopUpIcon, 2000.0)) {
            System.out.println("Strategy 2: Using existing close popup icon");
            playwright.clickOn(closePopUpIcon);
            playwright.hardWait(1000.0);
            return true;
        }

        // Strategy 3: Try dialog popup close
        if (playwright.waitTillLocatorIsVisible(dialogPopUp, 2000.0)) {
            System.out.println("Strategy 3: Using dialog popup close");
            playwright.clickOn(dialogPopUp);
            playwright.hardWait(1000.0);
            return true;
        }

        // Strategy 4: Try clicking outside the popup (ESC key)
        if (playwright.isTextDisplayed("close", 1000.0)) {
            System.out.println("Strategy 4: Pressing ESC key to close popup");
            page.keyboard().press("Escape");
            playwright.hardWait(1000.0);
            return true;
        }

        return false;
    }

    public boolean isGpspPromoCountDownExist() {
        return playwright.isLocatorVisibleAfterLoad(gpspPromoCountDown, 2000.0);
    }

    /**
     * Click on "Ingin kos dikelola secara..." link in owner dashboard
     */
    public void clickOnInginKosDikelolaLink() {
        playwright.waitTillLocatorIsVisible(inginKosDikelolaLink);
        playwright.clickOn(inginKosDikelolaLink);
    }

    /**
     * Check if "Ingin kos dikelola secara..." link is visible
     * @return true if visible, false otherwise
     */
    public boolean isInginKosDikelolaLinkVisible() {
        playwright.waitFor(inginKosDikelolaLink);
        playwright.pageScrollInView(inginKosDikelolaLink);
        return playwright.waitTillLocatorIsVisible(inginKosDikelolaLink, 20000.0);
    }

    /**
     * Get GoldPlus logo image file name from src attribute
     * @return String image file name (e.g., "logo-goldplus-gradient-1.webp")
     */
    public String getGoldPlusLogoImageName() {
        playwright.waitTillLocatorIsVisible(gpStatusImage);
        String src = playwright.getAttributeValue(gpStatusImage, "src");
        if (src != null && src.contains("/")) {
            return src.substring(src.lastIndexOf("/") + 1);
        }
        return src;
    }
}
