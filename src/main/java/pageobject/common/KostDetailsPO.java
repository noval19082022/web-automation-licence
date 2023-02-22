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
    Locator roomFacilities;
    Locator bookingPeriodInput;
    Locator ajukanSewaButton;

    //------------ Favorite and share kost section ----------------
    Locator favoriteKostButton;
    Locator unFavoriteKostButton;
    Locator successFavoritePopUp;
    Locator successUnfavoritePopUp;
    Locator shareKostButton;
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

    String datePickXpath = "//span[not(contains(@class, 'disabled'))][contains(text(), '%s')]";
    Locator kosDetailPage;

    public KostDetailsPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.locator = new LocatorHelpers(page);
        this.kostDetailsContainer = page.locator("#detailKostContainer");
        this.datePicker = page.getByTestId("bookingInputCheckinContent-datePicker");
        this.ftueSlider = playwright.locatorByRoleSetName(locator.roleButton, "Next slide");
        this.mulaiKosInput = page.getByPlaceholder("Mulai kos");
        this.roomFacilities = page.getByTestId("detailKostFacilityCategory");
        this.bookingPeriodInput = page.locator("input.booking-rent-type__input");
        this.ajukanSewaButton = playwright.locatorByRoleSetName(locator.roleButton, "Ajukan Sewa");
        this.kostTitle = page.locator("#detailTitle");
        this.propertyGender = page.locator(".detail-kost-overview__gender-box");
        this.propertyLocation = page.locator(".detail-kost-overview__area");
        this.roomAvailability = page.locator(".detail-kost-overview__availability");
        this.kosDetailPage = page.locator("detailKostContainer");

        //---------login popup---------------
        this.loginPopUp = page.locator("p[class='login-title']");
        this.loginByGoogleBtn = page.getByTestId("loginGoogleButton");
        this.loginByFbBtn = page.getByTestId("loginFacebookButton");
        this.loginByAppleIdBtn = page.getByTestId("loginAppleButton");

        //---------promo section-------------
        this.promoOwnerSection = page.getByTestId("detailKostOwnerPromo");
        this.lihatSelengkapnyaPromoOwnerBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lihat selengkapnya"));
        this.tanyaPemilikKostLink = page.getByText("tanya pemilik kos terlebih dahulu.");
        this.chatKostPopUp = page.locator(".modal-chat__body");
        this.hubungiKostHeading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Hubungi Kost"));

        //------------ Favorite and share kost section ----------------
        this.favoriteKostButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("wishlist Simpan"));
        this.unFavoriteKostButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("wishlist-glyph Hapus"));
        this.successFavoritePopUp = page.getByText("Berhasil ditambahkan ke favorit.");
        this.successUnfavoritePopUp = page.getByText("Berhasil dihapus dari favorit.");
        this.shareKostButton = page.getByText("share Bagikan");

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
        for (int i = 0; i < 4; i++) {
            playwright.pageScrollToDown(300);
            if (ftueSlider.isVisible()) {
                break;
            }
        }
        do {
            playwright.forceClickOn(ftueSlider);
        }
        while (ftueSlider.isVisible());
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
        playwright.waitTillLocatorIsVisible(kostTitle, 1.0);
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
     * @throws InterruptedException
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
        playwright.waitTillLocatorIsVisible(loginPopUp, 2.0);
        return loginPopUp.isVisible() && loginByGoogleBtn.isVisible() && loginByFbBtn.isVisible() && loginByAppleIdBtn.isVisible();
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
        playwright.waitTillLocatorIsVisible(expandFacilityNotesBtn, 1.0);
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
}
