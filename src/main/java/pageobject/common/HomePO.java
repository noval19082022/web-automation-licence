package pageobject.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

import java.util.List;

public class HomePO {
    private Page page;
    private PlaywrightHelpers playwright;
    private LocatorHelpers locatorHelpers;
    private Locator btnMasuk;
    private Locator cariButton;
    private Locator mamikosLogo;
    private Locator userPhoto;
    private Locator promoNgebutHeading;
    private Locator promoNgebutOptions;
    private Locator flashSaleTimer;
    private Locator flashSaleKostListContainer;
    private Locator flashSaleLihatSemuaButton;
    Locator dikelolaMamikosButton;
    Locator dikelolaMamikosLabel;

    //header
    Locator bookingKosButton;
    Locator searchAdsButton;
    Locator helpCenterButton;
    Locator termAndConditionButton;
    Locator promoAdsButton;
    Locator enterButton;
    Locator favoriteButton;
    Locator downloadAppButton;
    Locator kosDetailPage;
    Locator chatHeaderButton;
    Locator notificationButton;
    Locator otherButton;
    Locator tenantProfilePicture;
    Locator searchIklanButton;
    private Locator flashSaleIcon;

    public HomePO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.locatorHelpers = new LocatorHelpers(page);
        this.btnMasuk = page.getByTestId("entryButton");
        this.cariButton = playwright.filterLocatorHasText(locatorHelpers.span, "Cari");
        mamikosLogo = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Mamikos Logo"));
        userPhoto = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("User Photo"));
        promoNgebutHeading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Promo Ngebut"));
        promoNgebutOptions = page.locator("#flashsale #userLocation");
        flashSaleTimer = page.getByText("Akan Berakhir dalam waktu:");
        flashSaleKostListContainer = page.locator(".flashsale-wrapper > .swiper-container");
        flashSaleLihatSemuaButton = page.locator("#flashsale").getByText("Lihat semua");
        dikelolaMamikosButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Dikelola Mamikos"));
        dikelolaMamikosLabel = page.getByTestId("roomCardCover-brandIcon").first();

        //header
        this.bookingKosButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ajukan Sewa"));
        this.searchAdsButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cari Iklan dropdown-down"));
        this.helpCenterButton = page.locator("#globalNavbar").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Pusat Bantuan"));
        this.termAndConditionButton = page.locator("#globalNavbar").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Syarat dan Ketentuan"));
        this.promoAdsButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Icon Promote Promosikan Iklan Anda"));
        this.enterButton = page.getByTestId("entryButton");
        this.favoriteButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Favorit"));
        this.downloadAppButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Icon Smartphone Download App"));
        this.kosDetailPage = page.locator("detailKostContainer");
        this.chatHeaderButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Chat"));
        this.notificationButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("notification"));
        this.otherButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lainnya dropdown-down"));
        this.tenantProfilePicture = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("User Photo"));
        this.searchIklanButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cari Iklan dropdown-down"));
        flashSaleIcon = page.getByText("flash");
    }

    /**
     * Click on button masuk on home page
     *
     * @return LoginPO class
     */
    public LoginPO clickOnButtonMasuk() {
        btnMasuk.click();
        return new LoginPO(page);
    }

    /**
     * Click on search button
     *
     * @return SearchPO
     */
    public SearchPO clickOnSearchButton() {
        cariButton.click();
        return new SearchPO(page);
    }

    /**
     * Wait till mamikos logo is visible
     */
    public void waitTillLogoIsVisible() {
        page.waitForLoadState(LoadState.LOAD);
        playwright.waitFor(mamikosLogo, 30000.0);
        playwright.waitFor(userPhoto, 3000.0);
    }

    /**
     * Get mamikos logo
     *
     * @return Locator data type of mamikos logo
     */
    public Locator getMamikosLogo() {
        return mamikosLogo;
    }

    /**
     * Scroll to view promo ngebut heading
     */
    public void scrollToViewPromoNgebutHeading() {
        promoNgebutHeading.scrollIntoViewIfNeeded();
    }

    /**
     * Check if promo ngebut heading is visible
     * @return boolean type, visible true otherwise false
     */
    public boolean promoNgebutHeadingIsVisible() {
        return promoNgebutHeading.isVisible();
    }

    /**
     * Get promo ngebut options value
     * @return String data type
     */
    public String getPromoNgebutOptionsValue() {
        return promoNgebutOptions.inputValue();
    }

    /**
     * Check is flash sale timer visible
     * @return boolean type, visible true otherwise false
     */
    public boolean isFlashSaleTimerVisible() {
        return flashSaleTimer.isVisible();
    }

    /**
     * Check is flash sale kost container visible
     * @return boolean type, visible true otherwise false
     */
    public boolean isFlashSaleKostContainerVisible() {
        return flashSaleKostListContainer.isVisible();
    }

    /**
     * Check is flash sale lihat semua button visible
     * @return boolean type, visible true otherwise false
     */
    public boolean isFlashSaleLihatSemuaButtonVisible() {
        return flashSaleLihatSemuaButton.isVisible();
    }

    /**
     * Click on filter Mamirooms button
     * @throws InterruptedException
     */

    public void clickFilterDikelolaMamikos() throws InterruptedException {
        playwright.clickOn(dikelolaMamikosButton);
    }

    /**
     * Check if Singgahsini/Apik label is present
     * @return displayed true, otherwise false
     */
    public boolean isDikelolaMamikosDisplayed() throws InterruptedException {
        return playwright.isLocatorVisibleAfterLoad(dikelolaMamikosLabel, 2000.0);
    }

    /**
     * Check element booking kos button header is displayed
     *
     * @return status true / false
     */
    public boolean isBookingKosDisplayed() {
        return playwright.isLocatorVisibleAfterLoad(bookingKosButton, 50.0);
    }

    /**
     * Check element search ads button header is displayed
     *
     * @return status true / false
     */
    public boolean isSearchAdsDisplayed() {
        return playwright.isLocatorVisibleAfterLoad(searchAdsButton, 50.0);
    }

    /**
     * Check element help center button header is displayed
     *
     * @return status true / false
     */
    public boolean isHelpCenterDisplayed() {
        return playwright.isLocatorVisibleAfterLoad(helpCenterButton, 50.0);
    }

    /**
     * Check element help center button header is displayed
     *
     * @return status true / false
     */
    public Boolean isTermConditionDisplayed() {
        return playwright.waitTillLocatorIsVisible(termAndConditionButton, 50.0);
    }

    /**
     * Check element promosi ads button header is displayed
     *
     * @return status true / false
     */
    public boolean isPromosiAdsDisplayed() {
        return playwright.waitTillLocatorIsVisible(promoAdsButton, 50.0);
    }

    /**
     * Enter Button is  Displayed
     *
     * @return true / false
     */
    public boolean isEnterButtonDisplayed() {
        return playwright.isLocatorVisibleAfterLoad(enterButton, 50.0);
    }

    /**
     * Check Favorite button is displayed
     *
     * @return status true or false
     */
    public boolean isFavoriteDisplayed() {
        return playwright.isLocatorVisibleAfterLoad(favoriteButton, 50.0);
    }

    /**
     * Check element download app button header is displayed
     *
     * @return status true / false
     */
    public boolean isDownloadAppDisplayed() {
        return playwright.isLocatorVisibleAfterLoad(downloadAppButton, 50.0);
    }

    /**
     * Check detail kos page reached
     *
     * @return Boolean
     * @throws InterruptedException
     */
    public boolean isInKosDetail() {
        kosDetailPage.isVisible();
        return true;
    }

    /**
     * Check Chat button is displayed
     *
     * @return status true or false
     */
    public boolean isChatDisplayed() throws InterruptedException {
        return playwright.isLocatorVisibleAfterLoad(chatHeaderButton, 7.0);
    }

    /**
     * Check element notification button header is displayed
     *
     * @return status true / false
     */
    public boolean isNotificationButtonDisplayed() {
        return playwright.isLocatorVisibleAfterLoad(notificationButton, 5.0);
    }

    /**
     * Check element other dropdown header is displayed
     *
     * @return status true / false
     */
    public boolean isOtherButtonDisplayed() {
        return playwright.isLocatorVisibleAfterLoad(otherButton, 5.0);
    }

    /**
     * Tenant Profile Picture is  Displayed
     *
     * @return Tenant Profile Picture
     */
    public boolean isTenantProfilePictureDisplayed() {
        return playwright.isLocatorVisibleAfterLoad(tenantProfilePicture, 5.0);
    }

    /**
     * Check element search iklan button header is displayed
     *
     * @return status true / false
     */
    public boolean isSearchIklanDisplayed() {
        return playwright.isLocatorVisibleAfterLoad(searchIklanButton, 50.0);
    }

     /** Get all flash sale icon as list
     * @return List<Locator> of flash sale icon
     */
    public List<Locator> getAllFlashSaleLocator() {
        return flashSaleIcon.all();
    }
}
