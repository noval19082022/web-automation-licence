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
    Locator dikelolaMamikosToggle;
    Locator dikelolaMamikosLabel;
    private Locator kostPromo;

    //header
    Locator searchAdsButton;
    Locator helpCenterButton;
    Locator termAndConditionButton;
    Locator promoAdsButton;
    Locator favoriteButton;
    Locator downloadAppButton;
    Locator chatHeaderButton;
    Locator notificationButton;
    Locator otherButton;
    Locator searchIklanButton;
    private Locator flashSaleIcon;
    Locator bookingKosButtonHeadBar;
    Locator kostMenuDropdown;
    Locator apartmentMenuDropdown;
    Locator profileDropdown;
    Locator profileMenu;
    Locator riwayatTransaksiMenu;
    Locator logOutButton;

    //footer
    private Locator tentangKamiButton;
    private Locator kebijakanPrivasiButton;
    private Locator kebijakanPrivasiTitle;
    private Locator syaratKetentuanButton;
    private Locator jobMamikosButton;
    private Locator promosikanIklanAndaButton;
    private Locator pusatBantuanButton;
    private Locator emailFooter;
    private Locator formBantuanTitle;
    private Locator whatsappButton;
    private Locator facebookButton;
    private Locator twitterButton;
    private Locator instagramButton;
    private Locator copyrightFooter;



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
        dikelolaMamikosToggle = page.getByTestId("singgahsini-filter_tgl");
        dikelolaMamikosLabel = page.getByTestId("roomCardCover-brandIcon").first();


        //header
        this.searchAdsButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cari Iklan dropdown-down"));
        this.helpCenterButton = page.locator("#globalNavbar").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Pusat Bantuan"));
        this.termAndConditionButton = page.locator("#globalNavbar").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Syarat dan Ketentuan"));
        this.promoAdsButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Icon Promote Promosikan Iklan Anda"));
        this.favoriteButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Favorit"));
        this.downloadAppButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Icon Smartphone Download App"));
        this.chatHeaderButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Chat"));
        this.notificationButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("notification"));
        this.otherButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lainnya dropdown-down"));
        this.searchIklanButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cari Iklan dropdown-down"));
        this.bookingKosButtonHeadBar = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Icon Booking Kos Booking Kos"));
        flashSaleIcon = page.getByText("flash");
        this.kostPromo = page.locator("#promoted").getByTestId("roomCardCover-photo").nth(0);
        this.kostMenuDropdown = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("bed Kos"));
        this.apartmentMenuDropdown = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("apartment Apartemen"));
        this.profileDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("User Photo"));
        this.profileMenu = page.getByTestId("profileButton");
        this.riwayatTransaksiMenu = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Riwayat Transaksi"));
        this.logOutButton = page.getByTestId("exitButton");

        //footer
        this.tentangKamiButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Tentang Kami"));
        this.kebijakanPrivasiButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Kebijakan Privasi"));
        this.kebijakanPrivasiTitle = page.locator("#__layout h1");
        this.syaratKetentuanButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Syarat dan Ketentuan Umum"));
        this.jobMamikosButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Job Mamikos"));
        this.promosikanIklanAndaButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Promosikan Kost Anda"));
        this.pusatBantuanButton = page.getByRole(AriaRole.CONTENTINFO).getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Pusat Bantuan"));
        this.emailFooter = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("email cs@mamikos.com"));
        this.formBantuanTitle = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Form Bantuan"));
        this.whatsappButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("whatsapp 0813-2511-1171"));
        this.facebookButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("facebook"));
        this.twitterButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("twitter"));
        this.instagramButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("instagram"));
        this.copyrightFooter = page.getByText("© 2023 Mamikos.com, All rights reserved");
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
        page.setViewportSize(1920, 1080);
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
     *
     * @return boolean type, visible true otherwise false
     */
    public boolean promoNgebutHeadingIsVisible() {
        return promoNgebutHeading.isVisible();
    }

    /**
     * Get promo ngebut options value
     *
     * @return String data type
     */
    public String getPromoNgebutOptionsValue() {
        return promoNgebutOptions.inputValue();
    }

    /**
     * Check is flash sale timer visible
     *
     * @return boolean type, visible true otherwise false
     */
    public boolean isFlashSaleTimerVisible() {
        return flashSaleTimer.isVisible();
    }

    /**
     * Check is flash sale kost container visible
     *
     * @return boolean type, visible true otherwise false
     */
    public boolean isFlashSaleKostContainerVisible() {
        return flashSaleKostListContainer.isVisible();
    }

    /**
     * Check is flash sale lihat semua button visible
     *
     * @return boolean type, visible true otherwise false
     */
    public boolean isFlashSaleLihatSemuaButtonVisible() {
        return flashSaleLihatSemuaButton.isVisible();
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
        return playwright.isLocatorVisibleAfterLoad(btnMasuk, 50.0);
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
        return playwright.isLocatorVisibleAfterLoad(userPhoto, 5.0);
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
     *
     * @return List<Locator> of flash sale icon
     */
    public List<Locator> getAllFlashSaleLocator() {
        return flashSaleIcon.all();
    }

    //------------ promo section ----------------
    /**
     * This PO is example of move page and return new object with parameter of next page
     *
     * @return next object page
     */
    public KostDetailsPO selectKostOnPromoSection() {
        Page nextPage;
        for (int i = 0; i < 4; i++) {
            playwright.pageScrollToDown(1000);
            if (kostPromo.isVisible()) {
                break;
            }
        }
        nextPage = playwright.movePageByClickLocator(page, kostPromo);
        return new KostDetailsPO(nextPage);
    }

    /**
     * Check element booking kos button header is displayed
     *
     * @return status true / false
     */
    public boolean isBookingKosDisplayed() {
        return playwright.isLocatorVisibleAfterLoad(bookingKosButtonHeadBar, 50.0);
    }

    /**
     * Click on Kebijakan Privasi button
     *
     */
    public void clickOnKebijakanPrivasiButton() {
        kebijakanPrivasiButton.click();
    }

    /**
     * Check element kebijakan privasi title is displayed
     *
     * @return status true / false
     */
    public boolean isKebijakanPrivasiTitleDisplayed() {
        return kebijakanPrivasiTitle.isVisible();
    }

    /**
     * Click on Syarat dan Ketentuan button
     *
     */
    public void clickOnSyaratKetentuanButton() {
        syaratKetentuanButton.click();
    }

    /**
     * Get URL
     * @return url is equal
     */
    public String getURL() {
        return page.url();
    }

    /**
     * Click on Cari Iklan dropdown
     *
     */
    public void clickOnAdsDropdown() {
        searchIklanButton.click();
    }

    /**
     * Check elementt Kos Menu is displayed
     *
     * @return status true / false
     */
    public boolean isKostMenuDisplayed() {
        return kostMenuDropdown.isVisible();
    }


    /**
     * Check element Apartment Menu is displayed
     *
     * @return status true / false
     */
    public boolean isApartmentMenuDisplayed() {
        return apartmentMenuDropdown.isVisible();
    }

    /**
     * Click on Profile dropdown
     *
     */
    public void clickOnProfileDropdown() {
        profileDropdown.click();
    }

    /**
     * Check element Profile Menu is displayed
     *
     * @return status true / false
     */
    public boolean isProfileMenuDisplayed() {
        return profileMenu.isVisible();
    }

    /**
     * Check element Riwayat Transaksi Menu is displayed
     *
     * @return status true / false
     */
    public boolean isRiwayatTransaksiMenuDisplayed() {
        return profileMenu.isVisible();
    }

    /**
     * Check element Lot Out button is displayed
     *
     * @return status true / false
     */
    public boolean isLogOutButtonDisplayed() {
        return logOutButton.isVisible();
    }

    /**
     * Click on Tentang Kami button
     *
     */
    public void clickOnTentangKamiButton() {
        tentangKamiButton.click();
    }

    /**
     * Click on Job Mamikos button
     *
     */
    public void clickOnJobMamikosButton() {
        jobMamikosButton.click();
    }

    /**
     * Click on Promosikan Iklan Anda button
     *
     */
    public void clickOnPromosikanIklanAndaButton() {
        promosikanIklanAndaButton.click();
    }

    /**
     * Click on Pusat Bantuan button
     *
     */
    public void clickOnPusatBantuanButton() {
        pusatBantuanButton.click();
    }

    /**
     * Click on E-mail on footer
     *
     */
    public void clickOnEmailFooterLink() {
        emailFooter.click();
    }

    /**
     * Check element form bantuan title is displayed
     *
     * @return status true / false
     */
    public boolean isFormBantuanTitleDisplayed() {
        return formBantuanTitle.isVisible();
    }

    /**
     * Click on Whatsapp number
     *
     */
    public void clickOnWhatsappNumber() {
        whatsappButton.click();
    }

    /**
     * Click on Facebook button
     *
     */
    public void clickOnFacebookButton() {
        facebookButton.click();
    }

    /**
     * Click on Twitter button
     *
     */
    public void clickOnTwitterButton() {
        twitterButton.click();
    }

    /**
     * Click on Instagram button
     *
     */
    public void clickOnInstagramButton() {
        instagramButton.click();
    }

    /**
     * Get Copyright text
     *
     * @return String data type
     */
    public String getCopyrightText() {
        return playwright.getText(copyrightFooter);
    }

    /**
     * Entry to Login Page On Home Page
     */
    public void clickOnEntryToLoginPage() {
        btnMasuk.click();
    }
}
