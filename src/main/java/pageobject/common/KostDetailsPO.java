package pageobject.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import pageobject.tenant.BookingFormPO;
import utilities.JavaHelpers;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

import java.util.List;

public class KostDetailsPO {
    Page page;
    PlaywrightHelpers playwright;
    LocatorHelpers locator;
    String date;
    Locator kostDetailsContainer;
    Locator mulaiKosInput;
    Locator datePicker;
    Locator ftueSlider;
    private Locator ftuePopUP;
    private Locator ftueBookingBenefitText;
    Locator roomFacilities;
    Locator bookingPeriodInput;
    Locator ajukanSewaButton;
    Locator saveDraftButton;
    Locator backButton;
    Locator textPopup;
    Locator kosCheckedByOwner;
    Locator draftMenu;
    Locator deleteButtonOnTabOneDraftBooking;

    Locator mauCobaDongSectionAtHomepage;

    Locator hapusDraft;

    //------------ Favorite and share kost section ----------------
    Locator favoriteKostButton;
    Locator unFavoriteKostButton;
    Locator successFavoritePopUp;
    Locator successUnfavoritePopUp;
    Locator shareKostButton;
    Locator filterButton;
    Locator needConfirmation;
    private Locator kostTitle;
    private Locator propertyGender;
    private Locator propertyLocation;
    private Locator roomAvailability;

    //---------login pop up section-------------
    private Locator loginPopUp;
    private Locator loginByGoogleBtn;
    private Locator loginByFbBtn;
    private Locator loginByAppleIdBtn;

    //---------promo section-------------
    private Locator promoOwnerSection;
    private Locator lihatSelengkapnyaPromoOwnerBtn;
    private Locator tanyaPemilikKostLink;
    private Locator chatKostPopUp;
    private Locator hubungiKostHeading;
    private Locator btnMamikosPromoNgebut;
    private Locator btnMauDong;
    private Locator btnSayaMengerti;

    //---------------Facility Room Section----------------------
    private Locator subtitleSpesifikasiTipeKamer;

    //---------------Facility Room Section----------------------
    private Locator facilityRoomSeeAllBtn;
    private Locator facilityRoomPopUp;

    //--------------Facility Bath Section----------------------
    private Locator facilityBathSection;
    private Locator facilityBathIcon;
    private Locator facilityBathName;

    //------------------Facility Notes Section-----------------
    private Locator facilityNotesSection;
    private Locator facilityNotesDesc;
    private Locator expandFacilityNotesBtn;

    //------------------Owner Story Section-----------------
    private Locator ownerStorySection;
    private Locator ownerStoryDesc;
    private Locator expandOwnerStoryBtn;

    //------------------Facilty Share Section-----------------
    private Locator facShareSection;
    private Locator facShareSeeAllButton;
    private Locator facilitySharedTitle;
    private Locator facDescription;

    //------------------Facilty Parking Section-----------------
    private Locator facParkirTitle;
    private Locator facParkingSection;

    // -------------------Kos rule ----------------------------
    private Locator kosRuleTitle;
    private Locator kosRuleSection;
    private Locator kosRuleImageElement;
    private Locator seeAllKosRuleButton;

    // ------------ Kost Map section -----------
    private Locator lihatPetaBtn;
    private Locator staticMap;
    private Locator currentLocation;
    private Locator tanyaAlamatLengkapBtn;
    private Locator tabPOILandmark;
    private Locator latestChat;
    private Locator chatRoom;

    // ------------ Kos Report Section -----------
    private Locator kosReportContainer;
    private Locator kosReportButton;
    private Locator popUpReportKos;
    private Locator reportTextBox;
    private Locator sendReportButton;
    private Locator checkBoxKosReport;
    private Locator reportConfirmationPopUp;

    //------------ Kos Owner Information Section ------------------
    private Locator kostOwnerInformation;
    private Locator aboutStatisticsButton;
    private Locator statisticModal;
    private Locator closeStatisticsModalBtn;
    private Locator ownerNameText;
    private Locator ownerStatement;
    private Locator ownerImageProfile;
    private Locator ownerStatus;
    private Locator successfulTansaction;
    private Locator bookingProcessed;
    private Locator bookingChance;

    //------------ Check Gallery Photo Section ------------------
    private Locator seeAllPhotoButton;
    private Locator closeButtonGallery;
    private Locator fotoBangunanText;
    private Locator fotoKamarText;
    private Locator fotoKamarMandiText;
    private Locator fotoLainnya;
    private Locator detailPhotoButton;
    private Locator arrowPhotoNextButton;

    //-------------- Kost recomendation Section ----------------
    private Locator relatedCard;
    private Locator recommendationKosText;
    private Locator seeAllRecomendationButton;
    private Locator arrowRecommendationNextButton;
    private Locator arrowRecommendationPrevButton;
    private Locator photoRecommendation;
    private Locator nextRecommendation;
    private Locator firstKostCard;

    //------------ Right Panel Section -----------------
    private Locator totalPriceText;
    private Locator bookingDateForm;
    private Locator bookingDate;
    private Locator bookingDurationForm;
    private Locator dateTextBox;
    private Locator bookingButton;
    private Locator tomorrowDateLabel;
    private Locator saturdayDateLabel;
    private Locator sundayDateLabel;
    private Locator datePickToday;

    // ---------- Kost Badge(Apik, SinggahSini, Kost Pilihan) ---------------------
    private Locator pilihanBadge;
    private Locator apikBadge;
    private Locator singgahsiniBadge;

    // ----------------Kost Benefit---------------------
    private Locator kosBenefit;
    private Locator benefitTitle;
    private Locator benefitDesc;

    // ------------ Kost Review Section --------------
    private Locator reviewSection;
    private Locator overviewRatingReview;
    private Locator reviewCategory;
    private Locator userReview;
    private Locator seeAllReviewBtn;
    private Locator overviewRatingModal;
    private Locator reviewCategoryModal;
    private Locator sortingReviewBtn;
    private Locator userReviewModal;
    private Locator closeModalReviewBtn;


    String datePickXpath = "//span[not(contains(@class, 'disabled'))][contains(text(), '%s')]";
    Locator kosDetailPage;

    public KostDetailsPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.locator = new LocatorHelpers(page);
        this.kostDetailsContainer = page.locator("#detailKostContainer");
        this.datePicker = page.getByTestId("bookingInputCheckinContent-datePicker");
        this.ftueSlider = playwright.locatorByRoleSetName(locator.roleButton, "Next slide");
        this.ftuePopUP = page.locator(".onboarding-ftue");
        this.ftueBookingBenefitText = page.locator(".swiper-slide h4");
        this.mulaiKosInput = page.getByPlaceholder("Mulai kos");
        this.roomFacilities = page.getByTestId("detailKostFacilityCategory");
        this.bookingPeriodInput = page.locator("input.booking-rent-type__input");
        this.ajukanSewaButton = playwright.locatorByRoleSetName(locator.roleButton, "Ajukan Sewa");
        this.kostTitle = page.locator("#detailTitle");
        this.propertyGender = page.locator(".detail-kost-overview__gender-box");
        this.propertyLocation = page.locator(".detail-kost-overview__area");
        this.roomAvailability = page.locator(".detail-kost-overview__availability");
        this.kosDetailPage = page.locator("detailKostContainer");
        this.filterButton = page.locator(".filter-item-mobile:first-child span");
        this.needConfirmation = page.locator("li:nth-child(2) button");
        this.saveDraftButton = page.locator("//*[@class='bg-c-button bg-c-button--primary-naked bg-c-button--md bg-c-button--block']");
        this.textPopup = page.getByText("Fasilitas umum");
        this.backButton = page.locator(".booking-request-form__back-btn");
        this.kosCheckedByOwner = page.locator(".booking-shortcut__card-title");
        this.draftMenu = page.locator("//a[normalize-space()='Draft']");
        this.deleteButtonOnTabOneDraftBooking = page.locator(".btn-default[data-v-195f9976]");
        this.hapusDraft = page.locator("//button[contains(.,'Hapus Draft')]");
        this.mauCobaDongSectionAtHomepage = page.locator(".bg-c-text--button-sm");

        //---------login popup---------------
        this.loginPopUp = page.locator("p[class='login-title']");
        this.loginByGoogleBtn = page.getByTestId("loginGoogleButton");
        this.loginByFbBtn = page.getByTestId("loginFacebookButton");
        this.loginByAppleIdBtn = page.getByTestId("loginAppleButton");

        //---------promo section-------------
        this.promoOwnerSection = page.getByRole(AriaRole.IMG).filter(new Locator.FilterOptions().setHasText("flash")).locator("use");
        this.lihatSelengkapnyaPromoOwnerBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lihat selengkapnya"));
        this.tanyaPemilikKostLink = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tanya Pemilik"));
        this.chatKostPopUp = page.locator(".modal-chat__body");
        this.hubungiKostHeading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Hubungi Kost"));
        this.btnMamikosPromoNgebut = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Mamikos Promo Ngebut"));
        this.btnMauDong = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Mau Dong!"));
        this.btnSayaMengerti = page.getByText("Saya Mengerti");

        //------------ Favorite and share kost section ----------------
        this.favoriteKostButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("wishlist Simpan"));
        this.unFavoriteKostButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("wishlist-glyph Hapus"));
        this.successFavoritePopUp = page.getByText("Berhasil ditambahkan ke favorit.");
        this.successUnfavoritePopUp = page.getByText("Berhasil dihapus dari favorit.");
        this.shareKostButton = page.getByText("share Bagikan");

        //---------------Room Specification----------------------
        this.subtitleSpesifikasiTipeKamer = page.getByText("Spesifikasi tipe kamar");

        //---------------Facility Room Section----------------------
        this.facilityRoomSeeAllBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lihat semua fasilitas kamar tipe ini"));
        this.facilityRoomPopUp = page.locator("div[class='detail-kost-facilities-modal__body']");

        //--------------Facility Bath Section----------------------
        this.facilityBathSection = page.getByText("Fasilitas kamar mandi");
        this.facilityBathIcon = page.locator("//div[@class='detail-kost-bathroom-facilities']//div[@class='detail-kost-facility-item__icon']");
        this.facilityBathName = page.locator("//div[@class='detail-kost-bathroom-facilities']//div[@class='bg-c-list-item__description']");

        //------------------Facility Notes Section-----------------
        this.facilityNotesSection = page.getByText("Catatan tambahan seputar fasilitas");
        this.facilityNotesDesc = page.getByTestId("kost-facility-note-description");
        this.expandFacilityNotesBtn = page.locator(".detail-kost-facility-notes").getByRole(AriaRole.BUTTON);

        //------------------Owner Story Section-----------------
        this.ownerStorySection = page.getByText("Cerita pemilik tentang kos ini");
        this.ownerStoryDesc = page.getByTestId("kost-owner-story-content");
        this.expandOwnerStoryBtn = page.locator(".detail-kost-owner-story").getByRole(AriaRole.BUTTON);

        //------------------Facilty Share Section-----------------
        this.facShareSection = page.locator(".detail-kost-public-facilities");
        this.facShareSeeAllButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lihat semua fasilitas kos ini"));
        this.facilitySharedTitle = page.getByTestId("detailPagePublicFacilitiesModal").getByText("Fasilitas umum");
        this.facDescription = page.locator(".detail-kost-facilities-modal__description");

        //------------------Facilty Parking Section-----------------
        this.facParkirTitle = page.getByText("Fasilitas parkir");
        this.facParkingSection = page.getByTestId("detailKostFacilityCategory").getByText("Fasilitas parkir");

        // -------------------Kos rule ----------------------------
        this.kosRuleTitle = page.getByText("Peraturan di kos ini");
        this.kosRuleSection = page.locator(" .detail-kost-rules__content");
        this.kosRuleImageElement = page.locator(".kost-rules-gallery");
        this.seeAllKosRuleButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lihat semua peraturan"));

        // ------------ Kost Map section -----------
        this.lihatPetaBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lihat peta"));
        this.staticMap = page.getByTestId("detail-kost-location__map-static");
        this.currentLocation = page.getByTestId("current-position");
        this.tanyaAlamatLengkapBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tanya alamat lengkap"));
        this.tabPOILandmark = page.getByTestId("kost-landmark-list__tabs");
        this.latestChat = page.locator(".mc-balloon-chat__content").locator("div").last();
        this.chatRoom = page.locator(".mc-chat-room");

        // ------------ Kos Report Section -----------
        this.kosReportContainer = page.locator(".kost-report-container .kost-report");
        this.kosReportButton = page.getByText("Laporkan");
        this.popUpReportKos = page.getByText("Laporkan Kost");
        this.reportTextBox = page.locator("#reportDescription");
        this.sendReportButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kirim Laporan"));
        this.checkBoxKosReport = page.locator(".modal-report__body").locator("label").nth(0);
        this.reportConfirmationPopUp = page.locator("#swal2-content");

        //------------ Kos Owner Information Section ------------------
        this.kostOwnerInformation = page.locator("#kostOwnerInformation");
        this.aboutStatisticsButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tentang statistik"));
        this.statisticModal = page.getByTestId("owner-rate-modal-content");
        this.closeStatisticsModalBtn = page.getByRole(AriaRole.BUTTON).filter(new Locator.FilterOptions().setHasText("close"));
        this.ownerNameText = page.locator("#kostOwnerInformation").locator(".owner-information__name");
        this.ownerStatement = page.locator(".detail-kost-owner-section__kost-keeper");
        this.ownerImageProfile = page.locator("#kostOwnerInformation .owner-information__profile");
        this.ownerStatus = page.locator("#kostOwnerInformation .owner-information__type");
        this.successfulTansaction = page.locator("#kostOwnerInformation .owner-kost-information__label");
        this.bookingProcessed = page.locator("#kostOwnerInformation .owner-rate-information__info").nth(0);
        this.bookingChance = page.locator("#kostOwnerInformation .owner-rate-information__info").nth(1);

        //------------ Check Gallery Photo Section ------------------
        this.seeAllPhotoButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lihat semua foto"));
        this.closeButtonGallery = page.locator("//span[@class = 'detail-category-header__close']");
        this.fotoBangunanText = page.getByText("Foto Bangunan");
        this.fotoKamarText = page.getByText("Foto Kamar").first();
        this.fotoKamarMandiText = page.getByText("Foto Kamar Mandi");
        this.fotoLainnya = page.getByText("Foto Lainnya");
        this.detailPhotoButton = page.locator("#detailPhotoContainer .detail-category-content__img-wrapper.detail-category-content__img-wrapper").first();
        this.arrowPhotoNextButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next slide"));

        //-------------- Kost recomendation Section ----------------
        this.relatedCard = page.locator("#relatedCard");
        this.recommendationKosText = page.getByText("Kamu mungkin menyukainya");
        this.seeAllRecomendationButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Lihat semua"));
        this.arrowRecommendationNextButton = page.locator("#relatedCard").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Next slide"));
        this.arrowRecommendationPrevButton = page.locator("#relatedCard").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Previous slide"));
        this.photoRecommendation = page.locator(".rc-photo__cover");
        this.nextRecommendation = page.locator("//h3[@data-path='lbl_roomTitle']").nth(5);
        this.firstKostCard = page.locator("//h3[@data-path='lbl_roomTitle']").first();

        //------------ Right Panel Section -----------------
        this.totalPriceText = page.locator("#priceCard .rc-price__real");
        this.bookingDateForm = page.locator(".booking-input-checkin__input-icon");
        this.bookingDate = page.locator("div[class='vdp-datepicker__calendar inline']");
        this.bookingDurationForm = page.locator("input[class='booking-rent-type__input']");
        this.bookingButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ajukan Sewa"));
        this.datePickToday = page.locator(".today");
        this.tomorrowDateLabel = page.locator("span[class='cell day']").first();
        this.saturdayDateLabel = page.locator("span[class='cell day weekend sat']").first();
        this.sundayDateLabel = page.locator("span[class='cell day weekend sun']").first();
        this.dateTextBox = page.locator("//input[@class='booking-input-checkin__input']");

        // ---------- Kost Badge(Apik, SinggahSini, Kost Pilihan) ---------------------
        this.pilihanBadge = page.getByAltText("Kos Pilihan logo");
        this.apikBadge = page.getByAltText("Apik logo");
        this.singgahsiniBadge = page.getByAltText("Singgahsini logo");

        // ----------------Kost Benefit---------------------
        this.kosBenefit = page.getByTestId("kostBenefitContent");
        this.benefitTitle = page.locator("#detailKostContainer .detail-kost-benefit-content span").first();
        this.benefitDesc = page.locator("#detailKostContainer .detail-kost-benefit-content p").first();

        // ------------ Kost Review Section -----------
        this.reviewSection = page.locator("#detailKostReview");
        this.overviewRatingReview = page.locator(".kost-review__overview-rating");
        this.reviewCategory = page.locator(".kost-review__fac-rating");
        this.userReview = page.locator(".kost-review__users-feedback");
        this.seeAllReviewBtn = page.getByText("Lihat semua review");
        this.overviewRatingModal = page.locator("#modalAllReview");
        this.reviewCategoryModal = page.locator("div[class='kost-review-fac-rating']").first();
        this.sortingReviewBtn = page.getByTestId("filter-tag");
        this.userReviewModal = page.locator("div[class='users-feedback']").first();
        this.closeModalReviewBtn = page.locator("span[class='kost-review-modal-header__close']");
    }

    /**
     * Wait until kost detail kontainer id is visible
     */
    public void waitTillKostDetailPageVisible() {
        playwright.waitForElementStateToBe(kostDetailsContainer, "visible");
    }

    /**
     * Dismiss FTUE screen
     */
    public void dismissFTUE() {
        playwright.pageScrollToDown(300);
        for (int i = 0; i < 4; i++) {
            if (ftueSlider.isVisible()) {
                break;
            }
        }
        do {
            playwright.forceClickOn(ftueSlider);
        } while (ftueSlider.isVisible());
    }

    /**
     * Select booking date
     *
     * @param date tomorrow, today, or specific date by number on string data type
     */
    public void selectBookingDate(String date) {
        Locator datePick;
        if (date.equalsIgnoreCase("tomorrow")) {
            this.date = JavaHelpers.getCostumDateOrTime("d", 1, 0, 0);
        } else if (date.equalsIgnoreCase("today")) {
            this.date = JavaHelpers.getCurrentDateOrTime("d");
        } else {
            this.date = date;
        }
        mulaiKosInput.click();
        datePick = page.getByTestId("bookingInputCheckinContent-datePicker").getByText(this.date);
        List<Locator> datePicks = playwright.getLocators(datePick);
        for (Locator pick : datePicks) {
            if (pick.isEnabled() && pick.isVisible()) {
                pick.click();
            }
        }
    }

    /**
     * select booking period
     *
     * @param bookingPeriod string data type
     */
    public void selectBookingPeriod(String bookingPeriod) {
        if (!page.getByText(bookingPeriod).isVisible()) {
            bookingPeriodInput.click();
        }
        page.getByText(bookingPeriod).click();
    }

    /**
     * Click on ajukan sewa button
     *
     * @return BookingFormPO class
     */
    public BookingFormPO clickOnAjukanSewaButton() {
        ajukanSewaButton.click();
        return new BookingFormPO(page);
    }

    /**
     * get title detail kost page
     *
     * @return 'string' kost title
     */
    public String getKostTitle() {
        playwright.waitTillLocatorIsVisible(kostTitle);
        return kostTitle.textContent();
    }

    /**
     * get gender detail kost page
     *
     * @return 'boolean' property gender element visibility
     */
    public boolean isPropertyGenderDisplayed() {
        playwright.waitTillLocatorIsVisible(propertyGender);
        return propertyGender.isVisible();
    }

    /**
     * get location detail kost page
     *
     * @return 'boolean' property location element visibility
     */
    public boolean isPropertyLocationDisplayed() {
        playwright.waitTillLocatorIsVisible(propertyLocation);
        return propertyLocation.isVisible();
    }

    /**
     * get room detail kost page
     *
     * @return 'boolean' room element visibility
     */
    public boolean isRoomAvailabilityDisplayed() {
        playwright.waitTillLocatorIsVisible(roomAvailability);
        return roomAvailability.isVisible();
    }

    /**
     * Check detail kos page reached
     *
     * @return Boolean
     */
    public boolean isInKosDetail() {
        kosDetailPage.isVisible();
        return true;
    }

    // ------- kost detail from kost promo section -----

    /**
     * get visibility promo kost on detail kost page
     *
     * @return 'boolean' promo owner section visibility
     */
    public boolean isPromoOwnerSectionDisplayed() {
        playwright.waitTillLocatorIsVisible(promoOwnerSection);
        return promoOwnerSection.isVisible();
    }

    /**
     * this method will be click lihat selengkapnya button
     */
    public void clickOnButtonPromoOwner() {
        lihatSelengkapnyaPromoOwnerBtn.click();
    }

    /**
     * Scroll until promo pop up is visible, max scroll is 4 times
     */
    public void scrollDownToUntilPromoPopUpVisible() {
        for (int i = 0; i < 4; i++) {
            playwright.pageScrollToDown(300);
            if (btnMamikosPromoNgebut.isVisible()) {
                break;
            }
        }
    }

    /**
     * Check visibility of mamikos promo ngebut button
     * @return boolean
     */
    public boolean isMamikosPromoNgebutButtonVisible() {
        return playwright.waitTillLocatorIsVisible(btnMamikosPromoNgebut);
    }

    /**
     * Check visibility of Mau Dong button
     * @return boolean
     */
    public boolean isMauDongButtonVisible() {
        return playwright.waitTillLocatorIsVisible(btnMauDong);
    }

    /**
     * Check visibility of Saya Mengerti Button
     * @return boolean
     */
    public boolean isSayaMengertiButtonVisible() {
        return playwright.waitTillLocatorIsVisible(btnSayaMengerti);
    }

    /**
     * Dismiss popup click saya mengerti button
     */
    public void clickOnSayaMengertiButton() {
        for (int i = 0; i < 2; i++) {
            playwright.pageScrollToDown(300);
            if (btnSayaMengerti.isVisible()) {
                break;
            }
        }
        do {
            playwright.forceClickOn(btnSayaMengerti);
        } while (btnSayaMengerti.isVisible());
    }

    /**
     * this method will be click link tanya pemilik and will be redirect to chat option
     */
    public void clickOnTanyaPemilikKost() {
        tanyaPemilikKostLink.click();
    }

    /**
     * this method will be check 'Hubungi Kos Ini' visibility
     *
     * @return 'Hubungi Kos Ini' element visibility
     */
    public boolean isChatKostPopUpDisplayed() {
        playwright.waitTillLocatorIsVisible(chatKostPopUp);
        return chatKostPopUp.isVisible();
    }

    /**
     * this method will be check heading text "Hubungi Kost" on the detail kost promo section
     *
     * @return 'string' hubungi kost
     */
    public String hubungiKostHeadingText() {
        return hubungiKostHeading.textContent();
    }

    /**
     * this method will be check login pop visibility
     *
     * @return 'boolean' login pop up visibility
     */
    public Boolean isLoginPopUpDisplayed() {
        playwright.waitTillLocatorIsVisible(loginPopUp);
        return loginPopUp.isVisible() && loginByGoogleBtn.isVisible() && loginByFbBtn.isVisible() && loginByAppleIdBtn.isVisible();
    }

    //---------------Room Specification----------------------

    /**
     * Scroll to view spesifikasi tipe kamar
     */
    public void scrollToViewSpesifikasiTipeKamar() {
        subtitleSpesifikasiTipeKamer.scrollIntoViewIfNeeded();
    }

    //---------------Facility Room Section----------------------

    /**
     * this method will be click room facilty section and more facility list will be appear
     */
    public void clickFacilityRoomSeeAll() {
        playwright.pageScrollUntilElementIsVisible(facilityRoomSeeAllBtn);
        playwright.waitTillLocatorIsVisible(facilityRoomSeeAllBtn);
        facilityRoomSeeAllBtn.click();
    }

    /**
     * this method will be check room facilty section after click button see all
     *
     * @return 'boolean' facility room pop up
     */
    public boolean isRoomFacilitiyPopUpDisplayed() {
        return facilityRoomPopUp.isVisible();
    }

    //--------------Facility Bath Section----------------------

    /**
     * this method will be check bath facilty section
     *
     * @return 'boolean' bath facility is visible
     */
    public boolean isFacBathShow() {
        playwright.pageScrollUntilElementIsVisible(facilityBathSection);
        return facilityBathSection.isVisible();
    }

    /**
     * this method will be check list of icon on bath facilty section
     *
     * @return 'boolean' icon on bath facility is not null
     */
    public boolean isBathFacilitiyIconDisplayed() {
        List<Locator> facilityBathIcons = playwright.getLocators(facilityBathIcon);
        return !facilityBathIcons.isEmpty();
    }

    /**
     * this method will be check list of icon name on bath facilty section
     *
     * @return 'boolean' icon name on bath facility is not null
     */
    public boolean isBathFacilitiyNameDisplayed() {
        List<Locator> facilityBathNames = playwright.getLocators(facilityBathName);
        return !facilityBathNames.isEmpty();
    }

    //------------------Facility Notes Section-----------------

    /**
     * this method will be check 'Catatan tambahan seputar fasilitas' section
     *
     * @return 'boolean' 'Catatan tambahan seputar fasilitas' is visible
     */
    public boolean isFacilityNotesSectionDisplayed() {
        playwright.pageScrollUntilElementIsVisible(facilityNotesSection);
        return facilityNotesSection.isVisible();
    }

    /**
     * this method will be check description of 'Catatan tambahan seputar fasilitas' section
     *
     * @return 'boolean' description of 'Catatan tambahan seputar fasilitas' is visible
     */
    public boolean isFacilityNotesDescDisplayed() {
        return facilityNotesDesc.isVisible();
    }

    /**
     * this method will be check expantion of description on 'Catatan tambahan seputar fasilitas' section
     *
     * @return 'boolean' expantion of description on 'Catatan tambahan seputar fasilitas' is visible
     */
    public boolean isExpandFacNotesDisplayed() {
        return expandFacilityNotesBtn.isVisible();
    }

    /**
     * this method will be check expantion of description on 'Catatan tambahan seputar fasilitas' section is clickable
     */
    public void clickOnExpandFacNotes() {
        playwright.waitTillLocatorIsVisible(expandFacilityNotesBtn);
        expandFacilityNotesBtn.click();
    }

    //------------------Owner Story Section-----------------

    /**
     * this method will be check 'Cerita pemilik tentang kos ini' section
     *
     * @return 'boolean' 'Cerita pemilik tentang kos ini' is visible
     */
    public boolean isOwnerStorySectionDisplayed() {
        playwright.pageScrollUntilElementIsVisible(ownerStorySection);
        return ownerStorySection.isVisible();
    }

    /**
     * this method will be check description of 'Cerita pemilik tentang kos ini' section
     *
     * @return 'boolean' description of 'Cerita pemilik tentang kos ini' is visible
     */
    public boolean isOwnerStoryDescDisplayed() {
        return ownerStoryDesc.isVisible();
    }

    /**
     * this method will be check expantion of description on 'Cerita pemilik tentang kos ini' section
     *
     * @return 'boolean' expantion of description on 'Cerita pemilik tentang kos ini' is visible
     */
    public boolean isExpandOwnerStoryDisplayed() {
        return expandOwnerStoryBtn.isVisible();
    }

    /**
     * this method will be check expantion of description on 'Cerita pemilik tentang kos ini' section is clickable
     */
    public void clickOnExpandOwnerStory() {
        playwright.waitTillLocatorIsVisible(expandOwnerStoryBtn);
        expandOwnerStoryBtn.click();
    }

    //------------------Facilty Share Section-----------------

    /**
     * this method will be check 'Fasilitas Umum' Section
     *
     * @return 'boolean' 'Fasilitas Umum' Section visibility
     */
    public boolean isFacShareShow() {
        playwright.pageScrollToDown(2000);
        playwright.pageScrollUntilElementIsVisible(facShareSection);
        return facShareSection.isVisible();
    }

    /**
     * this method will be check fungsional of 'Lihat semua fasilitas kos ini' button
     */
    public void clickOnButtonFacShare() {
        playwright.waitTillLocatorIsVisible(facShareSeeAllButton);
        facShareSeeAllButton.click();
    }

    /**
     * this method will be check 'Fasilitas Umum' Title
     *
     * @return 'boolean' 'Fasilitas Umum' Title visibility
     */
    public boolean isSharedFacilitiyTitleDisplayed() {
        return facilitySharedTitle.isVisible();
    }

    /**
     * this method will be check 'Fasilitas Umum' contains section
     *
     * @return 'boolean' 'Fasilitas Umum' contains visibility
     */
    public boolean isSharedFacilitiyDescDisplayed() {
        return facDescription.isVisible();
    }

    /**
     * this method will be check 'Fasilitas Umum' section after click button see all
     *
     * @return 'boolean' 'Fasilitas Umum' room pop up visibility
     */
    public boolean isSharedFacilitiyPopUpDisplayed() {
        return facilityRoomPopUp.isVisible();
    }

    //------------------Facilty Parking Section-----------------

    /**
     * this method will be check 'Fasilitas Parkir' title section
     *
     * @return 'boolean' 'Fasilitas Parkir' title visibility
     */
    public boolean isFacParkingTitleDisplayed() {
        playwright.pageScrollToDown(2000);
        playwright.pageScrollUntilElementIsVisible(facParkirTitle);
        return facParkirTitle.isVisible();
    }

    /**
     * this method will be check 'Fasilitas Parkir' contains section
     *
     * @return 'boolean' 'Fasilitas Parkir' contains visibility
     */
    public boolean isFacParkingDisplayed() {
        return facParkingSection.isVisible();
    }

    // ------------ Kos rule -------------

    /**
     * this method will be check 'Peraturan Kost' containt section
     *
     * @return 'boolean' 'Peraturan Kost' containt visibility
     */
    public boolean isKosRulePresent() {
        playwright.pageScrollToDown(2500);
        playwright.pageScrollUntilElementIsVisible(kosRuleSection);
        return kosRuleSection.isVisible();
    }

    /**
     * this method will be check 'Peraturan Kost ini' title
     *
     * @return 'boolean' 'Peraturan Kost ini' title visibility
     */
    public boolean isKosRuleTitlePresent() {
        return kosRuleTitle.isVisible();
    }

    /**
     * this method will be check 'Lihat semua peraturan' button
     *
     * @return 'boolean' 'Lihat semua peraturan' button visibility
     */
    public boolean isKosRuleButtonShow() {
        return seeAllKosRuleButton.isVisible();
    }

    /**
     * this method will be check function of 'Lihat semua peraturan' button
     */
    public void clickOnSeeAllKosRuleButton() {
        seeAllKosRuleButton.click();
    }

    /**
     * this method will be check 'Peraturan Kost ini' image
     *
     * @return 'boolean' 'Peraturan Kost ini' image visibility
     */
    public boolean isKosRuleImagePresent() {
        return kosRuleImageElement.isVisible();
    }

    // ------------Kost Map section -----------

    /**
     * this method will be check 'Lihat Peta' button on map section for non login condition
     *
     * @return 'boolean' 'Lihat Peta' button on map section for non login condition visibility
     */
    public boolean isLihatPetaButtonPresent() {
        playwright.pageScrollToDown(2500);
        playwright.pageScrollUntilElementIsVisible(lihatPetaBtn);
        return lihatPetaBtn.isVisible();
    }

    /**
     * this method will be check that map image is static or unclear on map section caused by non login condition
     *
     * @return 'boolean' that map image is static or unclear on map section caused by non login condition
     */
    public boolean isStaticMapPresent() {
        return staticMap.isVisible();
    }

    /**
     * this method will be check 'tempat terdekat landmark' on map section
     *
     * @return 'boolean' 'tempat terdekat landmark' on map section visibility
     */
    public boolean isPOILandmarkShow() {
        return tabPOILandmark.isVisible();
    }

    /**
     * this method will be check of funcionality from 'Lihat Peta' button on map section for non login condition
     */
    public void clickOnSeeMapButton() {
        lihatPetaBtn.click();
    }

    /**
     * this method will be check 'Tanya alamat' button on map section for login condition
     *
     * @return 'boolean' 'Tanya alamat' button on map section for login condition visibility
     */
    public boolean isTanyaAlamatBtnPresent() {
        playwright.pageScrollToDown(2500);
        playwright.pageScrollUntilElementIsVisible(tanyaAlamatLengkapBtn);
        return tanyaAlamatLengkapBtn.isVisible();
    }

    /**
     * this method will be check that map is clear and user can see more detail kost location on map section for login condition
     *
     * @return 'boolean' that map is clear and user can see more detail kost location on map section for login condition visibility
     */
    public boolean isKostCurrentLocationPresent() {
        return currentLocation.isVisible();
    }

    /**
     * this method will be check of funcionality from 'Tanya Alamat' button on map section for login condition
     */
    public void clickOnTanyaAlamatBtn() {
        playwright.waitTillLocatorIsVisible(tanyaAlamatLengkapBtn);
        tanyaAlamatLengkapBtn.click();
    }

    /**
     * this method will be check chat room is present for user with login condition
     *
     * @return 'boolean' chat room is present for user with login condition visibility
     */
    public boolean isChatRoomPresent() {
        playwright.waitTillLocatorIsVisible(chatRoom);
        return chatRoom.isVisible();
    }

    /**
     * this method will be check latest chat on chat room for user with login condition
     *
     * @return 'String' latest chat on chat room for user with login condition visibility
     */
    public String getLatestChatText() {
        playwright.waitTillLocatorIsVisible(latestChat);
        return latestChat.textContent();
    }

    // ------------ Kos Report Section -----------

    /**
     * Check image kos report is present
     *
     * @return true / false
     */
    public boolean isKosReportPresent() {
        playwright.pageScrollToDown(2000);
        playwright.pageScrollUntilElementIsVisible(kosReportContainer);
        return kosReportContainer.isVisible();
    }

    /**
     * Click on kos report button
     */
    public void clickOnKosReportButton() {
        kosReportButton.click();
    }

    /**
     * Check pop up image kos report is present
     *
     * @return true / false
     */
    public boolean isPopUpKosReportPresent() {
        return playwright.waitTillLocatorIsVisible(popUpReportKos);
    }

    /**
     * Enter text to textbox
     *
     * @param textReport is text we want to enter
     */
    public void insertReportText(String textReport) {
        reportTextBox.fill(textReport);
        reportTextBox.press("Enter");
    }

    /**
     * Click on check box kos report
     */
    public void clickOnCheckBox() {
        checkBoxKosReport.click();
    }

    /**
     * Click on send report button
     */
    public void clickOnSendReportButton() {
        sendReportButton.click();
    }

    /**
     * Check kos report pop up confirmation is present
     *
     * @return true / false
     */
    public boolean isReportConfirmationPresent() {
        return playwright.waitTillLocatorIsVisible(reportConfirmationPopUp);
    }

    //------------ Kos Owner Information Section ------------------

    /**
     * Check owner section is present
     *
     * @return true / false
     */
    public boolean isOwnerSectionPresent() {
        playwright.pageScrollToDown(4800);
        playwright.pageScrollUntilElementIsVisible(kostOwnerInformation);
        return playwright.waitTillLocatorIsVisible(aboutStatisticsButton);
    }

    /**
     * Check owner name is displayed
     *
     * @return status true / false
     */
    public boolean isOwnerNameDisplayed() {
        playwright.pageScrollUntilElementIsVisible(ownerNameText);
        return playwright.waitTillLocatorIsVisible(ownerNameText);
    }

    /**
     * Check owner picture  is displayed
     *
     * @return status true / false
     */
    public boolean isOwnerPictureDisplayed() {
        return playwright.waitTillLocatorIsVisible(ownerImageProfile);
    }

    /**
     * Check owner status is displayed
     *
     * @return status true / false
     */
    public boolean isOwnerStatusDisplayed() {
        return playwright.waitTillLocatorIsVisible(ownerStatus);
    }

    /**
     * Check number of transaction is displayed
     *
     * @return status true / false
     */
    public boolean isNumberTransactionDisplayed() {
        return playwright.waitTillLocatorIsVisible(successfulTansaction);
    }

    /**
     * Check booking processed is displayed
     *
     * @return status true / false
     */
    public boolean isBookingProcessedDisplayed() {
        return playwright.waitTillLocatorIsVisible(bookingProcessed);
    }

    /**
     * Check booking chance is displayed
     *
     * @return status true / false
     */
    public boolean isBookingChanceDisplayed() {
        return playwright.waitTillLocatorIsVisible(bookingChance);
    }

    /**
     * Click on about statistics button
     */
    public void clickStatisticsDetailButton() {
        playwright.clickOn(aboutStatisticsButton);
    }

    /**
     * Check statistics modal is displayed
     *
     * @return status true / false
     */
    public boolean isStatisticsModalDisplayed() {
        return playwright.waitTillLocatorIsVisible(statisticModal);
    }

    /**
     * Click on close statistics modal button
     */
    public void closeStatisticsModal() {
        playwright.clickOn(closeStatisticsModalBtn);
    }

    //------------ Check Gallery Photo Section ------------------

    /**
     * Check button see all photo is present
     *
     * @return true / false
     */
    public boolean isSeeAllPhotoButtonPresent() {
        return playwright.waitTillLocatorIsVisible(seeAllPhotoButton);
    }

    /**
     * Click on see all button
     */
    public void clickOnSeeAllButton() {
        playwright.clickOn(seeAllPhotoButton);
    }

    /**
     * Check button close photo is present
     *
     * @return true / false
     */
    public boolean isCloseButtonPresent() {
        return playwright.waitTillLocatorIsVisible(closeButtonGallery);
    }

    /**
     * Check text Foto Bangunan is present
     *
     * @return true / false
     */
    public boolean isBuildingPhotosPresent() {
        return playwright.waitTillLocatorIsVisible(fotoBangunanText);
    }

    /**
     * Check text foto kamar is present
     *
     * @return true / false
     */
    public boolean isRoomPhotosPresent() {
        playwright.pageScrollUsingCoordinate(0, 2000);
        return playwright.waitTillLocatorIsVisible(fotoKamarText);
    }

    /**
     * Check text foto kamar mandi is present
     *
     * @return true / false
     */
    public boolean isBathroomPhotosPresent() {
        return playwright.waitTillLocatorIsVisible(fotoKamarMandiText);
    }

    /**
     * Check text foto lainnya is present
     *
     * @return true / false
     */
    public boolean isOthersPhotosPresent() {
        return playwright.waitTillLocatorIsVisible(fotoLainnya);
    }

    /**
     * Click on detail photo gallery button
     */
    public void clickOnDetailPhotoButton() {
        playwright.clickOn(detailPhotoButton);
    }

    /**
     * swipe on photo gallery
     */
    public void clickOnArrowPhotoGalleryNextButton() {
        playwright.waitTillLocatorIsVisible(arrowPhotoNextButton);
        playwright.clickOn(arrowPhotoNextButton);
    }

    //-------------- Kost recomendation Section ----------------

    /**
     * Check button see all is present
     *
     * @return true / false
     */
    public boolean isLihatSemuaKosButtonPresent() {
        playwright.pageScrollHeightToBottom();
        playwright.pageScrollUntilElementIsVisible(relatedCard);
        return playwright.waitTillLocatorIsVisible(seeAllRecomendationButton);
    }

    /**
     * Check button arrow next is present
     *
     * @return true / false
     */
    public boolean isArrowRecommendationButtonPresent() {
        return playwright.waitTillLocatorIsVisible(arrowRecommendationNextButton);
    }

    /**
     * Check list photo kos recommendation is present
     *
     * @return true / false
     */
    public boolean isListPhotoRecommendationKosPresent() {
        List<Locator> photos = playwright.getLocators(photoRecommendation);
        return !photos.isEmpty();
    }

    /**
     * Get recommendation kos Desc Text
     *
     * @return recommendation label
     */
    public String getRecommendationKosLabel() {
        String desc = playwright.getText(recommendationKosText);
        return desc;
    }

    /**
     * swipe on next kos recommendation
     */
    public void clickOnArrowRecommendationNextButton() {
        playwright.clickOn(arrowRecommendationNextButton);
    }

    /**
     * swipe on previous kos recommendation
     */
    public void clickOnArrowRecommendationPreviousButton() {
        playwright.clickOn(arrowRecommendationPrevButton);
    }

    /**
     * click on lihat semua kos recommendation
     *
     * @return next kost object
     */
    public KostLandingAreaPO clickOnSeeAllRecommendation() {
        Page nextPage = playwright.movePageByClickLocator(page, seeAllRecomendationButton);
        return new KostLandingAreaPO(nextPage);
    }

    /**
     * Is next recommendation kos present
     *
     * @return true or false
     */
    public boolean isNextRecommendationElementPresent() {
        return playwright.waitTillLocatorIsVisible(nextRecommendation);
    }

    /**
     * Is first kos recommendation present
     *
     * @return true or false
     */
    public boolean isFirstKostCardRecommendationPresent() {
        return playwright.waitTillLocatorIsVisible(firstKostCard);
    }

    //------------ Right Panel Section -----------------

    /**
     * Check if total price is present
     *
     * @return visible true, otherwise false
     */
    public boolean isTotalPricePresent() {
        return playwright.waitTillLocatorIsVisible(totalPriceText);
    }

    /**
     * Check if form booking date is present
     *
     * @return visible true, otherwise false
     */
    public boolean isFormBookingDatePresent() {
        playwright.pageScrollUsingCoordinate(0, 500);
        return playwright.waitTillLocatorIsVisible(bookingDateForm);
    }

    /**
     * Click on booking date form
     */
    public void clickOnBookingDate() {
        playwright.pageScrollUntilElementIsVisible(seeAllPhotoButton);
        playwright.waitTillLocatorIsVisible(bookingDateForm);
        playwright.clickOn(bookingDateForm);
    }

    /**
     * Get booking date description inside booking date
     *
     * @return string data type
     */
    public String getDescBookingDateText(String desc) {
        Locator description = page.locator("#priceCard").getByText(desc).first();
        playwright.pageScrollUntilElementIsVisible(description);
        return playwright.getText(description).toLowerCase();
    }

    /**
     * Check alert is present present / not
     *
     * @return true / false
     */
    public boolean isAlertBookingDateTextPresent(String alert) {
        return page.getByText(alert).first().isVisible();
    }

    /**
     * Check if booking date is present
     *
     * @return visible true, otherwise false
     */
    public boolean isDateBookingPresent() {
        return playwright.waitTillLocatorIsVisible(bookingDate);
    }

    /**
     * Check if booking duration form is present
     *
     * @return visible true, otherwise false
     */
    public boolean isFormBookingDurationPresent() {
        return playwright.waitTillLocatorIsVisible(bookingDurationForm);
    }

    /**
     * Check if booking duration is present
     *
     * @return displayed true, otherwise false
     */
    public boolean isBookingButtonPresent() {
        return bookingButton.isVisible();
    }

    /**
     * Select Starting Date of Boarding if exist
     *
     * @param date date e.g. 15,20 etc
     */
    public void selectDateForStartBoarding(String date) {
        if (playwright.waitTillLocatorIsVisible(dateTextBox)) {
            playwright.clickOn(dateTextBox);
            if (date.equalsIgnoreCase("today")) {
                playwright.waitTillLocatorIsVisible(datePickToday);
                playwright.clickOn(datePickToday);
            } else {
                if (playwright.waitTillLocatorIsVisible(tomorrowDateLabel)) {
                    tomorrowDateLabel.click();
                } else if (playwright.waitTillLocatorIsVisible(saturdayDateLabel)) {
                    saturdayDateLabel.click();
                } else {
                    sundayDateLabel.click();
                }
            }
        }
    }

    /**
     * Select Rent Type of Booking
     *
     * @param type type of rent
     */
    public void selectRentType(String type) {
        playwright.clickOn(page.getByText(type));
    }

    // ---------- Kost Badge(Apik, SinggahSini, Kost Pilihan) ---------------------

    /**
     * Check if Apik badge is present
     *
     * @return displayed true, otherwise false
     */
    public boolean isApikBadgePresent() {
        return playwright.waitTillLocatorIsVisible(apikBadge);
    }

    /**
     * Check if Singgahsini badge is present
     *
     * @return displayed true, otherwise false
     */
    public boolean isSinggahsiniBadgePresent() {
        return playwright.waitTillLocatorIsVisible(singgahsiniBadge);
    }

    /**
     * check owner badges section on kost detail
     *
     * @return owner badges label is present
     */
    public boolean ownerBadgesSectionAsPresent() {
        playwright.pageScrollToDown(4000);
        playwright.pageScrollUntilElementIsVisible(ownerImageProfile);
        return playwright.waitTillLocatorIsVisible(ownerNameText);
    }

    /**
     * Check if Owner Statement is present
     *
     * @return displayed true, otherwise false
     */
    public boolean isOwnerStatement() {
        return playwright.waitTillLocatorIsVisible(ownerStatement);
    }

    // ----------------Kost Benefit---------------------

    /**
     * Check if Kos Benefit Title is present
     */
    public boolean isBenefitTitlePresent() {
        playwright.pageScrollUntilElementIsVisible(kosBenefit);
        return playwright.waitTillLocatorIsVisible(benefitTitle);
    }

    /**
     * Check if Kos Benefit Description is present
     */
    public boolean isBenefitDescPresent() {
        return playwright.waitTillLocatorIsVisible(benefitDesc);
    }

    // ------------ Kost Review Section -----------

    /**
     * Scroll to review section
     */
    public void scrollToReviewSection() {
        playwright.pageScrollToDown(4000);
        playwright.pageScrollUntilElementIsVisible(reviewSection);
    }

    /**
     * Check review overview is displayed
     *
     * @return status true / false
     */
    public boolean isReviewOverviewDisplayed() {
        return playwright.waitTillLocatorIsVisible(overviewRatingReview);
    }

    /**
     * Check review category is displayed
     *
     * @return status true / false
     */
    public boolean isReviewCategoryDisplayed() {
        return playwright.waitTillLocatorIsVisible(reviewCategory);
    }

    /**
     * Check user review is displayed
     *
     * @return status true / false
     */
    public boolean isUserReviewDisplayed() {
        return playwright.waitTillLocatorIsVisible(userReview);
    }

    /**
     * Click on See all review button
     */
    public void clickSeeAllReviewBtn() {
        playwright.pageScrollToDown(4000);
        playwright.pageScrollUntilElementIsVisible(seeAllReviewBtn);
        playwright.clickOn(seeAllReviewBtn);
    }

    /**
     * Check overview review modal is displayed
     *
     * @return status true / false
     */
    public boolean isOverviewReviewModalDisplayed() {
        return playwright.waitTillLocatorIsVisible(overviewRatingModal);
    }

    /**
     * Check overview review modal is displayed
     *
     * @return status true / false
     */
    public boolean isReviewCategoryModalDisplayed() {
        return playwright.waitTillLocatorIsVisible(reviewCategoryModal);
    }

    /**
     * Check sorting review is displayed
     *
     * @return status true / false
     */
    public boolean isSortingReviewDisplayed() {
        return playwright.waitTillLocatorIsVisible(sortingReviewBtn);
    }

    /**
     * Check user review Modal is displayed
     *
     * @return status true / false
     */
    public boolean isUserReviewModalDisplayed() {
        return playwright.waitTillLocatorIsVisible(userReviewModal);
    }

    /**
     * Click on close See all review button
     */
    public void closeAllReviewModal() {
        playwright.clickOn(closeModalReviewBtn);
    }

    //------------ Favorite kost section ----------------

    /**
     * Click on favorite kost button
     */
    public void clickOnFavoriteKostButton() {
        favoriteKostButton.click();
    }

    /**
     * Check if success favorite pop up displayed
     *
     * @return status true / false
     */
    public boolean isSuccessFavoriteKostDisplayed() {
        playwright.waitTillLocatorIsVisible(successFavoritePopUp);
        return successFavoritePopUp.isVisible();
    }

    /**
     * Click on unfavorite kost button
     */
    public void clickOnUnfavoriteKostButton() {
        unFavoriteKostButton.click();
    }

    /**
     * Check if success unfavorite pop up displayed
     *
     * @return status true / false
     */
    public boolean isSuccessUnfavoriteKostDisplayed() {
        playwright.waitTillLocatorIsVisible(successUnfavoritePopUp);
        return successUnfavoritePopUp.isVisible();
    }

    /**
     * Click on share kost button
     */
    public void clickOnShareKostButton() {
        shareKostButton.click();
    }

    /**
     * Check the visibility of ftue booking benefit
     * @return boolean
     */
    public boolean isFTUEBookingBenefitVisible() {
        for (int i = 0; i < 4; i++) {
            playwright.pageScrollToDown(300);
            if (ftueSlider.isVisible()) {
                break;
            }
        }
        return playwright.waitTillLocatorIsVisible(ftuePopUP);
    }

    /**
     * Get ftue booking benefit wording
     * @param index 0-4 ftue booking benefit wording currently are 5
     * @return String data type
     */
    public String getFTUEBookingBenefitWording(int index) {
        return playwright.getText(ftueBookingBenefitText.nth(index));
    }
    /**
     * Click on filter in riwayat booking
     */
    public void cancelAllBookingWithDefaultReason() {
        filterButton.click();
        page.pause();
        needConfirmation.click();
    }

    /**
     * Click on save draft button
     */
    public void clickSaveDraftButton() {
        saveDraftButton.click();
    }
    /**
     * Wait until FTUE
     * @return
     */
    public boolean isElementFTUEDisplayed() {
        return textPopup.isVisible();
    }
    /**
     * Click on back button
     */
    public void clickBackButton() {
        backButton.click();
    }
    /**
     * Get notPaidFirstRent value text
     * @return
     */
    public String getKosCheckedByOwner(){
        playwright.pageScrollUntilElementIsVisible(kosCheckedByOwner);
        return playwright.getText(kosCheckedByOwner);
    }

    /**
     * Click on draft menu button
     */
    public void clickOnDraftMenu() {
        draftMenu.click();
    }
    /**
     * Click on delete draft button
     */
    public void clickDeleteButtonOnTabOneDraftBooking() {
        deleteButtonOnTabOneDraftBooking.click();
        hapusDraft.click();
    }
    /**
     * Click on mau coba dong section button
     */
    public void clickMauCobaDongSectionAtHomepage() {
        mauCobaDongSectionAtHomepage.click();
    }

    /**
     * click booking
     */
    public void clickOnBookingButton() {
        bookingButton.click();
    }

    /**
     * @param text is present
     * @return boolean
     */
    public Boolean isRuleTextPresent(String text) {
        if (seeAllKosRuleButton.isVisible()) {
            seeAllKosRuleButton.click();
        }

        if (!page.getByText(text).first().isVisible()) {
            playwright.pageScrollToDown(1000);
        }
        return page.getByText(text).first().isVisible();
    }
}