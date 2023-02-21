package pageobject.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

import java.util.ArrayList;
import java.util.List;

public class HeaderPO {
    private Locator searchKost;
    private Locator searchBoxInput;
    private Locator suggetionKostOnTheSearchList;
    private PlaywrightHelpers playwright;
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

    public HeaderPO(Page page) {
        this.playwright = new PlaywrightHelpers(page);
        this.bookingKosButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Icon Smartphone Download App"));
        this.searchAdsButton = page.locator("//div[@class = 'nav-main-link']");
        this.helpCenterButton = page.locator("#globalNavbar .nav-main-li:nth-child(2) .nav-main-link");
        this.termAndConditionButton = page.locator("#globalNavbar .nav-main-li:nth-child(3) .nav-main-link");
        this.promoAdsButton = page.locator(".nav-topbar-right .nav-topbar-url");
        this.enterButton = page.locator("//*[@data-testid='entryButton']");
        this.favoriteButton = page.locator("//li/a[contains(.,'Favorit')]");
        this.downloadAppButton = page.locator(".nav-topbar-left .nav-topbar-url:first-child");
        this.kosDetailPage = page.locator("detailKostContainer");
        this.chatHeaderButton = page.locator("(//li[@class = 'nav-main-li'])[2]");
        this.notificationButton = page.locator("#notifCenter .nav-notification");
        this.otherButton = page.locator("(//div/div[@class='nav-main-link'])[2]");
        this.tenantProfilePicture = page.locator("//div[@class='user-profile-dropdown__trigger']");
        this.searchIklanButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cari Iklan dropdown-down"));
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

}
