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
    private Locator kostTitle;
    private Locator shareButton;
    private Locator propertyGender;
    private Locator propertyLocation;
    private Locator roomAvailability;
    private Locator promoOwnerSection;
    private Locator lihatSelengkapnyaPromoOwnerBtn;
    private Locator tanyaPemilikKostLink;
    private Locator chatKostPopUp;
    private Locator loginPopUp;
    private Locator loginByGoogleBtn;
    private Locator loginByFbBtn;
    private Locator loginByAppleIdBtn;
    private Locator hubungiKostHeading;
    private Locator facilityRoomSeeAllBtn;

    //---------------Facility Room Section----------------------
    private Locator facPopup;
    private List<Locator> facilityRoomIcon;
    private List<Locator> facRoomName;
    //--------------Facility Bath Section----------------------
    private Locator facBathSection;
    private List<Locator> facBathIcon;
    private List<Locator> facBathName;
    //------------------Facility Notes Section-----------------
    private Locator facNotesSection;
    private Locator facNotesDesc;
    private Locator expandFacNotesBtn;
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
    private Locator facParkingSection;
    private Locator facParkirTitle;
    // -------------------Kos rule ----------------------------
    private Locator seeMoreFacButton;
    private Locator kosRuleTitle;
    private Locator kosRuleSection;
    private Locator kosRuleElement;
    private Locator kosRuleImageElement;
    private Locator iconArrowNextButton;
    private Locator iconArrowPrevButton;
    private Locator kosRulePopUpImageElement;
    private Locator kosRuleContent;
    private Locator seeAllKosRuleButton;
    // ------------ Map section -----------
    private Locator lihatPeta;
    private Locator lihatPetaBtn;
    private Locator staticMap;
    private Locator currentLocation;
    private Locator kostMapContainer;
    private Locator kosLocationAddressText;
    private Locator tanyaAlamatLengkapBtn;
    private Locator askAddressButton;
    private Locator tabPOILandmark;
    private Locator latestChat;
    private Locator chatRoom;

    String datePickXpath = "//span[not(contains(@class, 'disabled'))][contains(text(), '%s')]";

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
        this.kostTitle = page.locator("div[id='detailTitle']");
        this.shareButton = page.locator("//button[contains(text(),'Bagikan')]");
        this.propertyGender = page.locator("//span[@class='detail-kost-overview__gender-box']");
        this.propertyLocation = page.locator("//div[@class='detail-kost-overview__area']");
        this.roomAvailability = page.locator("//div[@class='detail-kost-overview__availability']");
        this.promoOwnerSection = page.getByTestId("detailKostOwnerPromo");
        this.lihatSelengkapnyaPromoOwnerBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lihat selengkapnya"));
        this.tanyaPemilikKostLink = page.getByText("tanya pemilik kos terlebih dahulu.");
        this.chatKostPopUp = page.locator(".modal-chat__body");
        this.hubungiKostHeading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Hubungi Kost"));
        this.loginPopUp = page.locator("p[class='login-title']");
        this.loginByGoogleBtn = page.getByTestId("loginGoogleButton");
        this.loginByFbBtn = page.getByTestId("loginFacebookButton");
        this.loginByAppleIdBtn = page.getByTestId("loginAppleButton");
        this.facilityRoomSeeAllBtn = page.locator("(//button[@class='bg-c-button detail-kost-facility-category__see-more-button bg-c-button--tertiary bg-c-button--md'])[1]");
        this.facPopup = page.locator("div[class='detail-kost-facilities-modal__body']");
        this.facilityRoomIcon = page.getByTestId("detailPageRoomFacilitiesModal").getByRole(AriaRole.IMG).all();
        this.facRoomName = page.getByTestId("detailPageRoomFacilitiesModal").all();
        this.facBathSection = page.locator(".detail-kost-bathroom-facilities");
        this.facBathIcon = page.locator("//div[@class='detail-kost-bathroom-facilities']//div[@class='detail-kost-facility-item__icon']").all();
        this.facBathName = page.locator("//div[@class='detail-kost-bathroom-facilities']//div[@class='bg-c-list-item__description']").all();
        this.facNotesSection = page.locator("//div[@class='detail-kost-facility-notes']");
        this.facNotesDesc = page.locator("//div[@id='kost-facility-note-description']");
        this.expandFacNotesBtn = page.locator("//div[@class='detail-kost-facility-notes']//button");
        this.ownerStorySection = page.locator("//div[@class='detail-kost-owner-story']");
        this.ownerStoryDesc = page.locator("//div[@id='kost-owner-story-content']");
        this.expandOwnerStoryBtn = page.locator("//div[@class='detail-kost-owner-story']//button");
        this.facShareSection = page.locator(".detail-kost-public-facilities");
        this.facShareSeeAllButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lihat semua fasilitas kos ini"));
        this.facilitySharedTitle = page.locator(".detail-kost-facilities-modal__title");
        this.facDescription = page.locator(".detail-kost-facilities-modal__description");
        this.facParkingSection = page.locator(".detail-kost-parking-facilities__content");
        this.facParkirTitle = page.locator("//p[contains(.,'Fasilitas parkir')]");
        this.seeMoreFacButton = page.locator(".fac-top .fac-top__button .btn-fac-more");
        this.kosRuleTitle = page.locator(" .detail-kost-rules__title");
        this.kosRuleSection = page.locator(" .detail-kost-rules__content");
        this.kosRuleElement = page.locator(".kost-rules .kost-rules-list .kost-rules-list__item:nth-child(1)");
        this.kosRuleImageElement = page.locator(".kost-rules-gallery > div:nth-of-type(1)");
        this.iconArrowNextButton = page.locator(".kost-gallery-modal-content__gallery-next.swiper-arrow");
        this.iconArrowPrevButton = page.locator(".kost-gallery-modal-content__gallery-prev.swiper-arrow");
        this.kosRulePopUpImageElement = page.locator(".modal-content .kost-gallery-modal-content");
        this.kosRuleContent = page.locator("//div[@class='kost-rules__content']");
        this.seeAllKosRuleButton = page.locator(".detail-kost-rules__see-all");
        this.lihatPeta = page.locator("button[class='bg-c-button kost-location__map-button bg-c-button--tertiary-inversed bg-c-button--md']");
        this.lihatPetaBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lihat peta"));
        this.staticMap = page.getByTestId("detail-kost-location__map-static");
        this.currentLocation = page.getByTestId("current-position");
        this.kostMapContainer = page.locator("div[id='detailMap']");
        this.kosLocationAddressText = page.locator(".kost-location .kost-location__address");
        this.tanyaAlamatLengkapBtn = page.locator("button[class='bg-c-button bg-c-button--tertiary bg-c-button--md kost-location__map-action']");
        this.askAddressButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tanya alamat lengkap"));
        this.tabPOILandmark = page.locator(".kost-landmark-list__tabs");
        this.latestChat = page.locator("(//div[@class='mc-balloon-chat__content']//div)[last()]");
        this.chatRoom = page.locator("div[class='mc-chat-room']");
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
//        for (int i = 0; i < 4; i++) {
//            playwright.tapKeyboard("ArrowDown");
//            if (ftueSlider.isVisible()) {
//                break;
//            }
//        }
        playwright.pageScrollToDown(500);
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
     * get detail page
     *
     * @return
     */

    public String getKostTitle() {
        playwright.waitTillLocatorIsVisible(kostTitle, 1.0);
        return kostTitle.textContent();
    }

    public boolean isPropertyGenderDisplayed() {
        playwright.waitTillLocatorIsVisible(propertyGender);
        return propertyGender.isVisible();
    }

    public boolean isPropertyLocationDisplayed() {
        playwright.waitTillLocatorIsVisible(propertyLocation);
        return propertyLocation.isVisible();
    }

    public boolean isRoomAvailabilityDisplayed() {
        playwright.waitTillLocatorIsVisible(roomAvailability);
        return roomAvailability.isVisible();
    }

    public boolean isPromoOwnerSectionDisplayed() {
        playwright.pageScrollToDown(200);
        dismissFTUE();
        playwright.pageScrollToDown(2000);
        playwright.waitTillLocatorIsVisible(promoOwnerSection);
        return promoOwnerSection.isVisible();
    }

    public void clickOnButtonPromoOwner() {
        lihatSelengkapnyaPromoOwnerBtn.click();
    }

    public void clickOnTanyaPemilikKost() {
        tanyaPemilikKostLink.click();
    }

    public boolean isChatKostPopUpDisplayed() {
        playwright.waitTillLocatorIsVisible(chatKostPopUp);
        return chatKostPopUp.isVisible();
    }

    public String hubungiKostHeadingText() {
        return hubungiKostHeading.textContent();
    }

    public Boolean isLoginPopUpDisplayed() {
        playwright.waitTillLocatorIsVisible(loginPopUp, 2.0);
        return loginPopUp.isVisible() && loginByGoogleBtn.isVisible() && loginByFbBtn.isVisible() && loginByAppleIdBtn.isVisible();
    }

    public void clickFacilityRoomSeeAll() {
        playwright.pageScrollToDown(200);
        dismissFTUE();
        playwright.pageScrollToDown(2000);
        playwright.waitTillLocatorIsVisible(facilityRoomSeeAllBtn);
        facilityRoomSeeAllBtn.click();
    }

    //---------------Facility Room Section----------------------

    public boolean isRoomFacilitiyPopUpDisplayed() {
        return facPopup.isVisible();
    }

    public boolean isRoomFacilitiyIconDisplayed() {
        return facilityRoomIcon.size() > 0;
    }

    public boolean isRoomFacilitiyNameDisplayed() {
        return facRoomName.size() > 0;
    }

    //--------------Facility Bath Section----------------------

    public boolean isFacBathShow() {
        playwright.pageScrollToDown(200);
        dismissFTUE();
        playwright.pageScrollToDown(2000);
        return facBathSection.isVisible();
    }

    public boolean isBathFacilitiyIconDisplayed() {
        return !facBathIcon.isEmpty();
    }

    public boolean isBathFacilitiyNameDisplayed() {
        return !facBathName.isEmpty();
    }

    //------------------Facility Notes Section-----------------

    public boolean isFacilityNotesSectionDisplayed() {
        playwright.pageScrollToDown(200);
        dismissFTUE();
        playwright.pageScrollToDown(2000);
        return facNotesSection.isVisible();
    }

    public boolean isFacilityNotesDescDisplayed() {
        return facNotesDesc.isVisible();
    }

    public boolean isExpandFacNotesDisplayed() {
        return expandFacNotesBtn.isVisible();
    }

    public void clickOnExpandFacNotes() {
        playwright.waitTillLocatorIsVisible(expandFacNotesBtn, 1.0);
        expandFacNotesBtn.click();
    }

    //------------------Owner Story Section-----------------

    public boolean isOwnerStorySectionDisplayed() {
        playwright.pageScrollToDown(200);
        dismissFTUE();
        playwright.pageScrollToDown(2000);
        return ownerStorySection.isVisible();
    }

    public boolean isOwnerStoryDescDisplayed() {
        return ownerStoryDesc.isVisible();
    }

    public boolean isExpandOwnerStoryDisplayed() {
        return expandOwnerStoryBtn.isVisible();
    }

    public void clickOnExpandOwnerStory() {
        playwright.waitTillLocatorIsVisible(expandOwnerStoryBtn);
        expandOwnerStoryBtn.click();
    }

    //------------------Facilty Share Section-----------------

    public boolean isFacShareShow() {
        playwright.pageScrollToDown(200);
        dismissFTUE();
        playwright.pageScrollToDown(2000);
        return facShareSection.isVisible();
    }

    public void clickOnButtonFacShare() {
        playwright.waitTillLocatorIsVisible(facShareSeeAllButton);
        facShareSeeAllButton.click();
    }

    public boolean isSharedFacilitiyTitleDisplayed() {
        return facilitySharedTitle.isVisible();
    }

    public boolean isSharedFacilitiyDescDisplayed() {
        return facDescription.isVisible();
    }

    public boolean isSharedFacilitiyPopUpDisplayed() {
        return facPopup.isVisible();
    }

    //------------------Facilty Parking Section-----------------

    public boolean isFacParkingDisplayed() {
        playwright.pageScrollToDown(200);
        dismissFTUE();
        playwright.pageScrollToDown(2200);
        return facParkingSection.isVisible();
    }

    public boolean isFacParkingTitleDisplayed() {
        return facParkirTitle.isVisible();
    }

    // ------------ Kos rule -------------

    public boolean isKosRulePresent() {
        playwright.pageScrollToDown(200);
        dismissFTUE();
        playwright.pageScrollToDown(3300);
        return kosRuleSection.isVisible();
    }

    public boolean isKosRuleButtonShow() {
        return seeAllKosRuleButton.isVisible();
    }

    public boolean isKosRuleImagePresent() {
        return kosRuleImageElement.isVisible();
    }

    // ------------ Map section -----------
    public boolean isLihatPetaButtonPresent() {
        playwright.pageScrollToDown(200);
        dismissFTUE();
        playwright.pageScrollToDown(3100);
        playwright.waitTillLocatorIsVisible(lihatPeta, 2.0);
        return lihatPeta.isVisible();
    }

    public boolean isStaticMapPresent() {
        return staticMap.isVisible();
    }

    public boolean isPOILandmarkShow() {
        return tabPOILandmark.isVisible();
    }

    public void clickOnSeeMapButton() {
        lihatPetaBtn.click();
    }

    public boolean isTanyaAlamatBtnPresent() {
        playwright.pageScrollToDown(200);
        dismissFTUE();
        playwright.pageScrollToDown(3000);
        playwright.waitTillLocatorIsVisible(tanyaAlamatLengkapBtn, 2.0);
        return tanyaAlamatLengkapBtn.isVisible();
    }

    public boolean isKostCurrentLocationPresent() {
        return currentLocation.isVisible();
    }

    public void clickOnTanyaAlamatBtn() {
        playwright.waitTillLocatorIsVisible(askAddressButton, 3.0);
        askAddressButton.click();
    }

    public String getLatestChatText() {
        playwright.waitTillLocatorIsVisible(latestChat, 7.0);
        playwright.pageScrollInView(latestChat);
        return latestChat.textContent();
    }

    public boolean isChatRoomPresent() {
        playwright.waitTillLocatorIsVisible(chatRoom, 3.0);
        return chatRoom.isVisible();
    }
}
