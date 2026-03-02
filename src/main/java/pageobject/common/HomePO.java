package pageobject.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitUntilState;
import config.global.GlobalConfig;
import data.mamikos.Mamikos;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

import java.util.List;

public class HomePO {
    private Page page;
    private PlaywrightHelpers playwright;
    private LocatorHelpers locatorHelpers;
    private Locator cariApaDropDownMenu;
    private Locator btnMasuk;
    private Locator cariButton;
    private Locator mamikosLogo;
    private Locator userProfile;
    private Locator promoNgebutHeading;
    private Locator promoNgebutOptions;
    private Locator flashSaleTimer;
    private Locator flashSaleKostListContainer;
    private Locator flashSaleSection;
    private Locator flashSaleLihatSemuaButton;
    private Locator flashSalePromoInfoList;
    Locator dikelolaMamikosToggle;
    Locator dikelolaMamikosLabel;
    private Locator firstKostPromoIcon;
    private Locator lihatPengajuanLainBtn;
    Locator areaKosTerpopulerTitle;

    //header
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
    Locator singgahsiniApikMenuDropDown;
    Locator kosAndalanMenuDropDown;
    Locator apartmentMenuDropdown;
    Locator profileMenu;
    Locator riwayatTransaksiMenu;
    Locator logOutButton;
    private Locator logInButtonPopularAreaPage;

    //Content
    private Locator seeAllPromoAds;
    private Locator seeAllPromoOwner;
    private Locator popularAreaJakarta;
    private Locator popularAreaYogyakarta;
    private Locator aroundUnivUGM;
    private Locator aroundUnivUNDIP;
    private Locator promoNgebutPriceBeforePromo;
    private Locator promoNgebutPriceInfoForFirstMonth;
    private Locator promoNgebutPriceInfoOtherThanFirstMonth;
    private Locator promoNgebutRentType;
    private Locator nextListProbut;
    private Locator lihatSemuaSekitarKampus;
    private Locator lihatSemuaAreaKostTerpopuler;

    //footer
    private Locator tentangKamiButton;
    private Locator kebijakanPrivasiButton;
    private Locator kebijakanPrivasiTitle;
    private Locator syaratKetentuanButton;
    private Locator jobMamikosButton;
    private Locator promosikanIklanAndaButton;
    private Locator blogMamikosBtn;
    private Locator sewaKostUntukPerusahaan;
    private Locator singgahSiniFooter;
    private Locator pusatBantuanButton;
    private Locator emailFooter;
    private Locator formBantuanTitle;
    private Locator whatsappButton;
    private Locator facebookButton;
    private Locator twitterButton;
    private Locator instagramButton;
    private Locator copyrightFooter;
    private Locator appStoreFooterMenu;
    private Locator googlePlayBtn;
    private Locator kebijakanPrivasiPopup;
    private Locator sayaSetujuButton;

    public HomePO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.locatorHelpers = new LocatorHelpers(page);
        this.cariApaDropDownMenu = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cari Apa? dropdown-down"));
        this.btnMasuk = page.getByTestId("entryButton");
        this.cariButton = page.getByText("Masukan nama lokasi/area/alamat");
        mamikosLogo = page.getByTestId("bg-l-footer-general").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Mamikos Logo"));
        userProfile = page.locator("div.user-profile-dropdown");
        promoNgebutHeading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Promo Ngebut"));
        promoNgebutOptions = page.locator("#flashsale #userLocation");
        flashSaleTimer = page.getByText("Akan Berakhir dalam waktu:");
        flashSaleKostListContainer = page.locator(".flashsale-wrapper > .swiper-container");
        flashSaleSection = page.locator("#flashsale");
        flashSaleLihatSemuaButton = page.locator("#flashsale").getByText("Lihat semua");
        flashSalePromoInfoList = page.locator(".rc-price__discount-icon").first();
        promoNgebutPriceBeforePromo = page.getByTestId("flashSaleHomePagePriceBeforePromo");
        promoNgebutPriceInfoForFirstMonth = page.getByTestId("flashSaleHomePagePromoInfo");
        promoNgebutPriceInfoOtherThanFirstMonth = page.getByTestId("flashSaleHomePageOtherPromoInfo");
        promoNgebutRentType = page.locator(".rc-price__type");
        nextListProbut = page.locator("#flashsale").getByLabel("Next slide");
        dikelolaMamikosToggle = page.getByTestId("singgahsini-filter_tgl");
        dikelolaMamikosLabel = page.getByTestId("roomCardCover-brandIcon").first();
        this.seeAllPromoAds = page.locator(".promo-banner__navigation-link");
        areaKosTerpopulerTitle = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Area Kos Terpopuler"));
        this.seeAllPromoOwner = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Lihat semua").setExact(true));
        this.popularAreaJakarta = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Kos Jakarta"));
        this.popularAreaYogyakarta = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Kos Yogyakarta"));
        this.aroundUnivUGM = page.getByTestId("link-UGM");
        this.aroundUnivUNDIP = page.getByTestId("link-UNDIP");
        this.lihatPengajuanLainBtn = page.locator("a.bg-c-link:nth-child(2)");
        lihatSemuaSekitarKampus = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Lihat semua →")).nth(1);
        lihatSemuaAreaKostTerpopuler = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Lihat semua →")).first();
        kebijakanPrivasiPopup = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Pembaharuan Kebijakan Privasi"));
        sayaSetujuButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Saya Setuju"));


        //header
        this.helpCenterButton = page.locator("#globalNavbar").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Pusat Bantuan"));
        this.termAndConditionButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Syarat dan Ketentuan").setExact(true));
        this.promoAdsButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Icon Promote Promosikan Iklan Anda"));
        this.favoriteButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Favorit"));
        this.downloadAppButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Icon Smartphone Download App"));
        this.chatHeaderButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Chat"));
        this.notificationButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("notification"));
        this.otherButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lainnya"));
        this.searchIklanButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cari Apa? dropdown-down"));
        this.bookingKosButtonHeadBar = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Icon Sewa Kos Sewa Kos"));
        flashSaleIcon = page.getByText("flash");
        this.firstKostPromoIcon = page.locator(".rc-price__other-promo-icon").first();
        this.kostMenuDropdown = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("bed Kos"));
        this.singgahsiniApikMenuDropDown = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Kos Singgahsini & Apik"));
        this.kosAndalanMenuDropDown = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Kos Andalan"));
        this.apartmentMenuDropdown = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Apartemen"));
        this.profileMenu = page.getByTestId("profileButton");
        this.riwayatTransaksiMenu = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Riwayat Transaksi"));
        this.logOutButton = page.getByTestId("exitButton");
        this.logInButtonPopularAreaPage = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Masuk"));

        //footer
        this.tentangKamiButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Tentang Kami"));
        this.kebijakanPrivasiButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Kebijakan Privasi"));
        this.kebijakanPrivasiTitle = page.locator("#__nuxt h1");
        this.syaratKetentuanButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Syarat dan Ketentuan Umum"));
        this.jobMamikosButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Job Mamikos"));
        this.promosikanIklanAndaButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Promosikan Kost Anda"));
        this.blogMamikosBtn = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Blog Mamikos"));
        this.sewaKostUntukPerusahaan = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sewa Kos untuk Perusahaan"));
        this.singgahSiniFooter = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Singgahsini").setExact(true));
        this.pusatBantuanButton = page.getByRole(AriaRole.CONTENTINFO).getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Pusat Bantuan"));
        this.emailFooter = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("cs@mamikos.com"));
        this.formBantuanTitle = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Form Bantuan"));
        this.whatsappButton = page.locator("footer a[href*='whatsapp'], footer a[href*='wa.me']").first();
        this.facebookButton = page.getByRole(AriaRole.LINK).filter(new Locator.FilterOptions().setHasText("facebook"));
        this.twitterButton = page.locator("footer a[href*='twitter'], footer a[href*='x.com']").first();
        this.instagramButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("instagram"));
        this.copyrightFooter = page.getByText("© 2026 Mamikos.com. All rights reserved");
        this.appStoreFooterMenu = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("App Store"));
        this.googlePlayBtn = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Google Play"));
    }

    /**
     * Navigates to homepage
     */
    public void navigatesToHomepage() {
        playwright.navigateTo(Mamikos.URL, WaitUntilState.DOMCONTENTLOADED, GlobalConfig.LONG_TIMEOUT);
        playwright.waitTillLocatorIsVisible(getMamikosLogo(), 60000.0);
    }

    /**
     * Click on button masuk on home page
     * @return LoginPO class
     */
    public LoginPO clickOnButtonMasuk() {
        playwright.waitTillLocatorIsVisible(btnMasuk, GlobalConfig.LONG_TIMEOUT);
        playwright.clickOn(btnMasuk);
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
        playwright.waitFor(userProfile, 30000.0);
        playwright.assertVisible(userProfile);
    }

    /**
     * Get mamikos logo
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
     * Check element promosi ads button header is not displayed
     *
     * @return status true / false
     */
    public boolean isPromosiAdsNotDisplayed() {
        return !playwright.waitTillLocatorIsVisible(promoAdsButton, 50.0);
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
     * Enter Button is not Displayed
     *
     * @return true / false
     */
    public boolean isEnterButtonNotDisplayed() {
        return !playwright.isLocatorVisibleAfterLoad(btnMasuk, 50.0);
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
     * Check element download app button header is not displayed
     *
     * @return status true / false
     */
    public boolean isDownloadAppNotDisplayed() {
        return !playwright.isLocatorVisibleAfterLoad(downloadAppButton, 50.0);
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
    public void isTenantProfilePictureDisplayed() {
        playwright.assertVisible(userProfile);
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
            if (firstKostPromoIcon.isVisible()) {
                break;
            }
        }
        nextPage = playwright.movePageByClickLocator(page, firstKostPromoIcon);
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
     * Check element booking kos button header is not displayed
     *
     * @return status true / false
     */
    public boolean isBookingKosNotDisplayed() {
        return !playwright.isLocatorVisibleAfterLoad(bookingKosButtonHeadBar, 50.0);
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
        return playwright.waitTillLocatorIsVisible(kebijakanPrivasiTitle, 50.0);
//        return kebijakanPrivasiTitle.isVisible();
    }

    /**
     * Click on Syarat dan Ketentuan button
     *
     */
    public void clickOnSyaratKetentuanButton() {
        playwright.clickOn(syaratKetentuanButton);
        playwright.hardWait(2000);
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
     * Check elementt Singgahsini and Apik Menu is displayed
     *
     * @return status true / false
     */
    public boolean isSinggahsiniApikMenuDisplayed() {
        return singgahsiniApikMenuDropDown.isVisible();
    }

    /**
     * Check elementt Kos Andalan Menu is displayed
     *
     * @return status true / false
     */
    public boolean isKosAndalanMenuDisplayed() {
        return kosAndalanMenuDropDown.isVisible();
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
        userProfile.click();
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
     * Wait for profile menu to be visible
     */
    public void waitForProfileMenuToBeVisible() {
        playwright.waitTillLocatorIsVisible(profileMenu, 30000.0);
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
        playwright.clickOn(promosikanIklanAndaButton);
        playwright.hardWait(2000);
    }

    /**
     * Click on Pusat Bantuan button
     *
     */
    public void clickOnPusatBantuanButton() {
        playwright.clickOn(pusatBantuanButton);
        playwright.hardWait(2000);
    }

    /**
     * Click on E-mail on footer
     *
     */
    public void clickOnEmailFooterLink() {
        playwright.clickOn(emailFooter);
        playwright.hardWait(2000);
    }

    /**
     * Check element form bantuan title is displayed
     *
     * @return status true / false
     */
    public boolean isFormBantuanTitleDisplayed() {
        return playwright.waitTillLocatorIsVisible(formBantuanTitle);
    }

    /**
     * Click on Whatsapp number
     *
     */
    public void clickOnWhatsappNumber() {
        playwright.pageScrollUntilElementIsVisible(copyrightFooter);
        playwright.hardWait(2000);
        whatsappButton.scrollIntoViewIfNeeded();
        playwright.hardWait(1000);
        playwright.clickOn(whatsappButton);
        playwright.hardWait(2000);
    }

    /**
     * Click on Facebook button
     *
     */
    public void clickOnFacebookButton() {
        playwright.clickOn(facebookButton);
        playwright.hardWait(2000);
    }

    /**
     * Click on Twitter button
     *
     */
    public void clickOnTwitterButton() {
        // Scroll to footer area where social media links are located
        playwright.pageScrollUntilElementIsVisible(copyrightFooter);
        playwright.hardWait(2000);
        
        // Ensure twitter button is visible before clicking
        twitterButton.scrollIntoViewIfNeeded();
        playwright.hardWait(1000);
        playwright.clickOn(twitterButton);
        playwright.hardWait(2000);
    }

    /**
     * Click on Instagram button
     *
     */
    public void clickOnInstagramButton() {
        playwright.clickOn(instagramButton);
        playwright.hardWait(2000);
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

    /**
     * Click Masuk buttom
     *
     */
    public void EnterButton(){
        btnMasuk.click();
    }

    /**
     * Click see all promo owner buttom
     *
     */
    public void clickOnSeeAllPromoOwnerButton() {
        playwright.pageScrollUntilElementIsVisible(areaKosTerpopulerTitle);
        playwright.clickOn(seeAllPromoOwner);
        playwright.hardWait(2000);
    }

    /**
     * Click see all promo ads buttom
     *
     */
    public void clickOnSeeAllPromoAdsButton() {
        playwright.pageScrollToDown(300);
        seeAllPromoAds.click();
    }

    /**
     * Click Download App buttom
     *
     */
    public void clickOnDownloadAppButton() {
        downloadAppButton.click();
    }

    /**
     * Click Booking Kos Header buttom
     *
     */
    public void clickOnBookingKosHeaderButton() {
        bookingKosButtonHeadBar.click();
    }

    /**
     * Click Jakarta on Popular Area
     *
     */
    public void clickPopularAreaOnJakarta() {
        playwright.pageScrollToDown(3000);
        popularAreaJakarta.click();
    }

    /**
     * Click Yogyakarta on Popular Area
     *
     */
    public void clickPopularAreaOnYogyakarta() {
        playwright.pageScrollToDown(3000);
        playwright.clickOn(popularAreaYogyakarta);
    }

    /**
     * Click UGM on Around University
     *
     */
    public void clickAroundUGM() {
        playwright.pageScrollToDown(3000);
        aroundUnivUGM.click();
    }

    /**
     * Click UNDIP on Around University
     *
     */
    public void clickAroundUNDIP() {
        playwright.pageScrollToDown(3000);
        playwright.clickOn(aroundUnivUNDIP);
    }

    /**
     * Check visibility of lihat pengajuan lain button
     * @return boolean
     */
    public boolean isLihatPengajuanLainBtnVisible() {
        return lihatPengajuanLainBtn.isVisible();
    }

    /**
     * Click lihat pengajuan lain button
     */
    public void clickLihatPengajuanLainBtn() {
        playwright.pageScrollToDown(500);
        lihatPengajuanLainBtn.click();
    }


    /**
     * user scroll into promo ngebut section
     */
    public void scrollIntoPromoNgebut() {
        playwright.pageScrollUntilElementIsVisible(flashSaleSection);
    }

    /**
     * get promo ngebut info on kost card
     * @return
     */
    public List<String> promoNgebutInfo() {
        playwright.pageScrollUntilElementIsVisible(flashSalePromoInfoList);
        return playwright.getListInnerTextFromListLocator(flashSalePromoInfoList);
    }

    /**
     * visit apartment list page
     */
    public void visitApartmentListPage() {
        playwright.clickOn(cariApaDropDownMenu);
        playwright.clickOn(apartmentMenuDropdown);
    }

    /**
     * click on download app on the app store on the footer menu
     */
    public void clickOnAppStore() {
        playwright.clickOn(appStoreFooterMenu);
    }

    /**
     * visit cari kost list page from ads dropdown
     */
    public void visitCariKosttListPage() {
        playwright.clickOn(cariApaDropDownMenu);
        playwright.clickOn(kostMenuDropdown);
    }


    /**
     * get rent type on flash sale section
     * @return
     */
    public String getPromoNgebutRenType() {
        // Wait for flash sale section and rent type element
        playwright.waitFor(flashSaleSection, 5000.0);
        playwright.hardWait(2000);
        
        // Try finding "(Bulan pertama)" in current view
        String result = findBulanPertamaTextOrFirst();
        if (!result.equals("/bulan") && result.contains("Bulan pertama")) {
            return result;
        }
        
        // If not found in current view, try to slide to next
        if (playwright.waitTillLocatorIsVisible(nextListProbut, 2000.0)) {
            playwright.clickOn(nextListProbut);
            playwright.hardWait(2000);
            
            // Check again after sliding
            return findBulanPertamaTextOrFirst();
        }
        
        // Return the result from first attempt
        return result;
    }
    
    private String findBulanPertamaTextOrFirst() {
        List<Locator> rentTypes = flashSaleSection.locator(".kost-rc__price .rc-price__type").all();
        
        // First, try to find "Bulan pertama"
        for (Locator rentType : rentTypes) {
            String text = playwright.getText(rentType);
            if (text.contains("Bulan pertama")) {
                return text;
            }
        }
        
        // If not found, return the first one available
        return rentTypes.size() > 0 ? playwright.getText(rentTypes.get(0)) : "/bulan";
    }

    /**
     * price strike on kost card before promo
     * @return
     */
    public boolean priceStrikePromoNgebutIsVisible() {
        return playwright.isLocatorVisibleAfterLoad(promoNgebutPriceBeforePromo.first(), 3.0);
    }

    /**
     * promo ngebut info on kost card for first month
     * @return
     */
    public boolean promoNgebutInfoIsVisible() {
        return playwright.isLocatorVisibleAfterLoad(promoNgebutPriceInfoForFirstMonth.first(), 3.0);
    }

    /**
     * promo ngebut info on kost card other than first month
     * @return
     */
    public boolean promoNgebutInfoOtherThanFirstMonthIsVisible() {
        return playwright.isLocatorVisibleAfterLoad(
                promoNgebutPriceInfoOtherThanFirstMonth.first(),
                3.0) ? true : promoNgebutInfoOtherThanFirstMonthIsVisibleOnTheNextList();
    }

    /**
     * promo ngebut info on kost card other than first month is visible on the next list
     * @return
     */
    public boolean promoNgebutInfoOtherThanFirstMonthIsVisibleOnTheNextList() {
        playwright.clickOn(nextListProbut);
        return playwright.isLocatorVisibleAfterLoad(promoNgebutPriceInfoOtherThanFirstMonth.first(), 3.0);
    }

    /**
     * get text promo ngebut info on kost card other than first month
     * @return
     */
    public String promoNgebutInfoOtherThanFirstMonthText() {
        playwright.waitFor(promoNgebutPriceInfoOtherThanFirstMonth.first());
        return playwright.getText(promoNgebutPriceInfoOtherThanFirstMonth.first());
    }

    /**
     * click on kost card promo ngebut that has bulan pertama
     */
    public void clickOnKostCardPromoNgebutBulanPertama() {
        playwright.waitFor(promoNgebutPriceInfoForFirstMonth.first());
        playwright.clickOn(promoNgebutPriceInfoForFirstMonth.first());
    }

    /**
     * click on kost card promo ngebut that other than bulan pertama
     */
    public void clickOnKostCardPromoNgebutOtherThanBulanPertama() {
        playwright.waitFor(promoNgebutPriceInfoOtherThanFirstMonth.first());
        playwright.clickOn(promoNgebutPriceInfoOtherThanFirstMonth.first());
    }

    /**
     * clickOn Google Play on the footer
     */
    public void clickOnGooglePlayFooterLink() {
        playwright.clickOn(googlePlayBtn);
    }

    /**
     * clickOn Blog Mamikos on the footer
     */
    public void clickOnBlogMamikos() {
        playwright.clickOn(blogMamikosBtn);
    }

    /**
     * clickOn Sewa Kost Untuk Perusahaan on the footer
     */
    public void clickOnSewaKostUntukPerusahaan() {
        playwright.clickOn(sewaKostUntukPerusahaan);
    }

    /**
     * clickOn Singgahsini on the footer
     */
    public void clickOnSinggahSiniOnFooter() {
        playwright.clickOn(singgahSiniFooter);
    }

    /**
     * clickOn Lihat semua sekitar kampus
     */
    public void clickOnLihatSemuaSekitarKampus() {
        playwright.pageScrollUntilElementIsVisible(lihatSemuaSekitarKampus);
        playwright.clickOn(lihatSemuaSekitarKampus);
    }
    /**
     * List all popular sekitar kampus/kos populer
     *
     * @return popular area
     */
    public boolean listKostDekatKampus(String area) {
        Locator listKostDekatKampus = playwright.locatorByRoleSetName(AriaRole.HEADING, area);;
        return playwright.waitTillLocatorIsVisible(listKostDekatKampus);
    }

    /**
     * clickOn Lihat semua Area kos terpopuler
     */
    public void clickonLihatSemuaAreaKosTerpopuler(){
        playwright.pageScrollUntilElementIsVisible(lihatSemuaAreaKostTerpopuler);
        playwright.clickOn(lihatSemuaAreaKostTerpopuler);
    }

    /**
     * Click on button masuk on popular area page
     *
     * @return LoginPO class
     */
    public LoginPO clickOnButtonMasukOnPopularArea() {
        logInButtonPopularAreaPage.click();
        return new LoginPO(page);
    }

    /**
     * Dismiss Pembaharuan Kebijakan Privasi pop-up
     *
     */
    public void clickOnSayaSetujuButton() {
        playwright.hardWait(5000);
        if (playwright.waitTillLocatorIsVisible(kebijakanPrivasiPopup, 3000.0)) {
            playwright.clickOn(sayaSetujuButton);
        }
    }
}
