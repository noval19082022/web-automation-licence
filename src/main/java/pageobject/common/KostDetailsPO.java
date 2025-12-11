package pageobject.common;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import pageobject.tenant.BookingFormPO;
import utilities.JavaHelpers;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

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

    Locator chatPemilikButton;

    Locator bantuanButton;

    Locator chatListTittle;

    Locator informationKosDetail;

    Locator tagihanKosTittle;
    Locator contractTittle;
    Locator chatOwnerTittle;
    Locator forumTittle;
    Locator kategoriBantuanTittle;
    Locator aktivitasKosSayaButton;

    //------------ Favorite and share kost section ----------------
    Locator favoriteKostButton;
    Locator unFavoriteKostButton;
    Locator successFavoritePopUp;
    Locator successUnfavoritePopUp;
    Locator shareKostButton;
    Locator filterButton;
    Locator needConfirmation;
    Locator seeCompleteBtn;
    Locator cancelBookingBtn;
    Locator reasonOption;
    Locator yesCancelBookingBtn;
    Locator nextSlideFtue;
    Locator uploadImage;
    Locator inputSearch;

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

    //---------------Facility Umum Section----------------------
    private Locator facilityUmumBtn;

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
    private Locator mapSection;

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
    private Locator breadcrumbTrail;
    private Locator priceCardBase;

    //------------ Right Panel Section -----------------
    private Locator totalPriceText;
    private Locator discountPriceKostDetailText;
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

    // ----------------Job Locator---------------------
    private Locator jobLocator;

    // ------------ Kost Review Section --------------
    private Locator reviewSection;
    private Locator lihatSemuaReviewButton;
    private Locator overviewRatingReview;
    private Locator reviewCategory;
    private Locator userReview;
    private Locator seeAllReviewBtn;
    private Locator overviewRatingModal;
    private Locator reviewCategoryModal;
    private Locator sortingReviewBtn;
    private Locator userReviewModal;
    private Locator closeModalReviewBtn;

    // ------------ Refund Policy Section --------------
    private Locator refundPolicySection;
    private Locator canRefundText;
    private Locator accordingToTnCRefundText;
    private Locator whatAreTheTermsText;
    private Locator tncRefundtitleText;
    private Locator refundPolicyMamikos;
    private Locator timeConditionText;
    private Locator tncRefundPoint;

    String datePickXpath = "//span[not(contains(@class, 'disabled'))][contains(text(), '%s')]";
    Locator kosDetailPage;

    //------------waiting list----------//
    private Locator fullRoomText;
    private Locator waitingListButton;
    private Locator anotherTypeButton;
    private Locator anotherKosButton;
    private Locator anotherTypeSection;
    private Locator anotherKosSection;
    private Locator waitingListSubmitText;
    private Locator kostNameWLForm;
    private Locator kostTypeWLForm;
    private Locator tenantNameWLForm;
    private Locator tenantPhoneWLForm;
    private Locator sudahAdaTglPastiOption;
    private Locator secepatnyaOption;
    private Locator baruPerkiraanOption;
    private Locator belumAdaTglOption;
    private Locator submitWLButton;
    private Locator selectDateForSudahAdaTgl;
    private Locator selectDateForBaruPerkiraan;
    private Locator closeWaitingListButton;
    Locator dateCannotBooking;
    Locator calendarView;
    Locator nextMonthButton;
    Locator nextMonthaDisableButton;
    private Locator succesSubmitWLText;

    //-------------kost booking validation----------//
    private Locator popupValidationText;
    private Locator btnBukaProfil;
    Locator validateLihatPengajuan;

    //-------------peraturan kos disini------------//
    private Locator peraturanDisinitext;
    private Locator peraturanBawaAnak;

    //-------------------request booking DBET tenant---------------//
    Locator notificationOnHeader;
    Locator toggleFotoKartuIdentitas;
    Locator toggleJatuhTempo;

    //-------------------USP---------------//
    private Locator uspHeader;
    private Locator uspContainer;
    private Locator uspTitle;
    private Locator uspDescription;
    private Locator refundTitle;
    private Locator refundDescription;

    //-------------------Voucher---------------//
    private Locator voucherList;
    private Locator closeVoucher;
    private Locator lihatDetailVoucher;
    private Locator salinButton;
    private Locator toastMessage;
    private Locator salinDetailButton;

    //-------------------Survey Label---------------//
    private Locator surveyLabelSection;

    //-------------------Inactive Owner Warning---------------//
    private Locator inactiveOwnerWarningInfoBox;
    private Locator inactiveOwnerWarningCloseIcon;

    public KostDetailsPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.locator = new LocatorHelpers(page);
        this.kostDetailsContainer = page.locator("#detailKostContainer");
        this.datePicker = page.getByTestId("bookingInputCheckinContent-datePicker");
        this.ftueSlider = page.getByText("Lanjut");
        this.ftuePopUP = page.locator(".onboarding-ftue");
        this.ftueBookingBenefitText = page.locator(".swiper-slide h4");
        this.mulaiKosInput = page.getByPlaceholder("Mulai kos");
        this.roomFacilities = page.getByTestId("detailKostFacilityCategory");
        this.bookingPeriodInput = page.locator("div.booking-rent-type__input");
        this.ajukanSewaButton = playwright.getButtonBySetName("Ajukan Sewa", true);
        this.kostTitle = page.locator("#detailTitle");
        this.propertyGender = page.locator(".detail-kost-overview__gender-box");
        this.propertyLocation = page.locator(".detail-kost-overview__area");
        this.roomAvailability = page.locator(".detail-kost-overview__availability");
        this.kosDetailPage = page.locator("detailKostContainer");
        this.filterButton = page.locator(".filter-item-mobile:first-child span");
        this.needConfirmation = page.locator("li:nth-child(2) button");
        this.seeCompleteBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lihat selengkapnyachevron-down"));
        this.cancelBookingBtn = page.getByTestId("detailBookingCardCancel_btn");
        this.reasonOption = page.locator(".fade.in .form-options");
        this.yesCancelBookingBtn = page.locator("//*[@id='bookingModalCancel' and @style]//*[contains(text(), 'Ya, Batalkan')]");
        this.saveDraftButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Simpan ke Draft"));
        this.textPopup = page.getByText("Fasilitas umum");
        this.backButton = page.locator(".booking-request-form__back-btn");
        this.kosCheckedByOwner = page.locator(".booking-shortcut__card-title");
        this.draftMenu = page.locator("//a[normalize-space()='Draft']");
        this.deleteButtonOnTabOneDraftBooking = page.locator("#draftBookingWrapper").getByRole(AriaRole.BUTTON).first();
        this.hapusDraft = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hapus Draft"));
        this.mauCobaDongSectionAtHomepage = page.locator(".bg-c-text--button-sm");
        this.chatPemilikButton = page.getByTestId("userKostActivities-menus").locator("div").filter(new Locator.FilterOptions().setHasText("Chat pemilik"));
        this.chatListTittle = page.getByText("Chat room");
        this.bantuanButton = page.getByTestId("userKostActivities-menus").locator("div").filter(new Locator.FilterOptions().setHasText("Bantuan"));
        this.informationKosDetail = page.getByText("Informasi Kos");
        this.tagihanKosTittle = page.getByText("Tagihan kos");
        this.contractTittle = page.getByText("Kontrak");
        this.chatOwnerTittle = page.getByText("Chat pemilik");
        this.forumTittle = page.getByText("Forum");
        this.kategoriBantuanTittle = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Kategori Bantuan"));
        this.inputSearch = page.locator("input[title]");


        //---------login popup---------------
        this.loginPopUp = page.locator("p[class='login-title']");
        this.loginByGoogleBtn = page.getByTestId("loginGoogleButton");
        this.loginByFbBtn = page.getByTestId("loginFacebookButton");
        this.loginByAppleIdBtn = page.getByTestId("loginAppleButton");

        //---------promo section-------------
        this.promoOwnerSection = page.getByTestId("detailKostOwnerPromo");
        this.lihatSelengkapnyaPromoOwnerBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lihat selengkapnya"));
        this.tanyaPemilikKostLink = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tanya Pemilik"));
        this.chatKostPopUp = page.locator(".modal-chat__body");
        this.hubungiKostHeading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Hubungi Kost"));
        this.btnMamikosPromoNgebut = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Mamikos Promo Ngebut"));
        this.btnMauDong = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Mau Dong!"));
        this.btnSayaMengerti = page.getByText("Saya Mengerti");

        //------------ Favorite and share kost section ----------------
        this.favoriteKostButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Simpan"));
        this.unFavoriteKostButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hapus"));
        this.successFavoritePopUp = page.getByText("Berhasil ditambahkan ke favorit.");
        this.successUnfavoritePopUp = page.getByText("Berhasil dihapus dari favorit.");
        this.shareKostButton = page.getByText("share Bagikan");

        //---------------Room Specification----------------------
        this.subtitleSpesifikasiTipeKamer = page.getByText("Spesifikasi tipe kamar");

        //---------------Facility Room Section----------------------
        this.facilityRoomSeeAllBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lihat semua fasilitas kamar tipe ini"));
        this.facilityRoomPopUp = page.locator("div[class='detail-kost-facilities-modal__body']");

        //---------------Facility Umum Section----------------------
        this.facilityUmumBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lihat semua fasilitas kos ini"));

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
        this.kosRuleSection = page.getByTestId("detail-kost-special-rules__content");
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
        this.mapSection = page.getByTestId("map-container");

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
        this.ownerStatement = page.locator("//div[@class='detail-kost-owner-section__owner-title']");
        this.ownerImageProfile = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("Foto Owner")).first();
        this.ownerStatus = page.locator("#kostOwnerInformation .owner-information__type");
        this.successfulTansaction = page.locator("#kostOwnerInformation .owner-kost-information__label");
        this.bookingProcessed = page.locator("#kostOwnerInformation .owner-rate-information__info").nth(0);
        this.bookingChance = page.getByText("Peluang Booking", new Page.GetByTextOptions().setExact(true));

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
        this.breadcrumbTrail = page.locator("ol").locator("li").locator(".breadcrumb-trail");
        this.priceCardBase = page.locator("#priceCard");

        //------------ Right Panel Section -----------------
        this.totalPriceText = page.locator("#priceCard .rc-price__real");
        this.discountPriceKostDetailText = page.getByTestId("kostDetailPriceBeforePromo");
        this.bookingDateForm = page.getByPlaceholder("Mulai kos");
        this.bookingDate = page.locator("div[class='vdp-datepicker__calendar inline']");
        this.bookingDurationForm =  page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^dropdown-down$"))).first();
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

        // ----------------Job Locator---------------------
        this.jobLocator = page.locator("//div[@class='bg-c-select__trigger bg-c-select__trigger--lg']");

        // ------------ Kost Review Section -----------
        this.reviewSection = page.locator("#detailKostReview");
        this.lihatSemuaReviewButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lihat semua review"));
        this.overviewRatingReview = page.locator(".kost-review__overview-rating");
        this.reviewCategory = page.locator(".kost-review__fac-rating");
        this.userReview = page.locator(".kost-review__users-feedback");
        this.seeAllReviewBtn = page.getByText("Lihat semua review");
        this.overviewRatingModal = page.locator("#modalAllReview");
        this.reviewCategoryModal = page.locator("div[class='kost-review-fac-rating']").first();
        this.sortingReviewBtn = page.getByTestId("filter-tag");
        this.userReviewModal = page.locator("div[class='users-feedback']").first();
        this.closeModalReviewBtn = page.locator("span[class='kost-review-modal-header__close']");

        // ------------ Refund Policy Section --------------
        this.refundPolicySection = page.locator(".detail-kost-refund div");
        this.canRefundText = page.getByText("Bisa Refund");
        this.accordingToTnCRefundText = page.getByText("Sesuai dengan ketentuan dan kebijakan refund yang berlaku di Mamikos.");
        this.whatAreTheTermsText = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Bagaimana ketentuannya?"));
        this.tncRefundtitleText = page.locator("//p[contains(.,'Syarat dan Ketentuan Refund')]");
        this.refundPolicyMamikos = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Kebijakan refund Mamikos"));
        this.timeConditionText = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("ketentuan waktu berikut"));

        //---------------------waiting list------------------------//
        this.fullRoomText = page.locator("//p[@class=\"detail-kost-overview__availability-text bg-c-text bg-c-text--body-2\"]");
        this.waitingListButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("notification Ikut Daftar Tunggu"));
        this.anotherTypeButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lihat tipe lain"));
        this.anotherKosButton  = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lihat kos lain"));
        this.anotherTypeSection = page.locator("//*[@class='detail-container__kost-types']");
        this.anotherKosSection = page.locator("//*[@class='related-box__title']");
        this.kostNameWLForm = page.getByLabel("Nama Kos");
        this.kostTypeWLForm = page.getByLabel("Tipe Kamar");
        this.tenantNameWLForm = page.getByPlaceholder("Contoh: Reza Febrian");
        this.tenantPhoneWLForm = page.getByPlaceholder("Contoh: 081244335566");
        this.sudahAdaTglPastiOption = page.getByText("Iya, sudah ada tanggal pasti");
        this.secepatnyaOption = page.getByText("Secepatnya");
        this.baruPerkiraanOption = page.getByText("Baru perkiraan");
        this.belumAdaTglOption = page.getByText("Belum ada tanggal atau perkiraan");
        this.submitWLButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kirim"));
        this.selectDateForSudahAdaTgl = page.getByPlaceholder("Isi dengan tanggal masuk kos");
        this.selectDateForBaruPerkiraan = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih rentang tanggal calendar"));
        this.closeWaitingListButton = page.locator("//button[@class=\"bg-c-modal__action-closable\"]");
        this.succesSubmitWLText = page.locator("//div[@class=\"bg-c-alert__content\"]");

        //-------------------kost booking validation---------------//
        this.popupValidationText = page.locator("//h3[@class='bg-c-modal__body-title']");
        this.btnBukaProfil = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Buka profil saya"));
        uploadImage = page.locator("//img[@alt='id photo']");
        dateCannotBooking = page.locator("//span[@class='cell day disabled today weekend sun']");
        calendarView = page.getByRole(AriaRole.TEXTBOX).first();
        nextMonthButton = page.locator("//span[@class='next']");
        validateLihatPengajuan = playwright.locatorByRoleSetName(locator.roleButton, "Lihat riwayat pengajuan sewa");
        nextMonthaDisableButton = page.locator("//span[@class='next disabled']");

        //-------------------request booking DBET tenant---------------//
        notificationOnHeader = page.locator("//a[@aria-label='notification']");
        toggleFotoKartuIdentitas = page.locator("(//input[@type='checkbox'])[1]");
        toggleJatuhTempo = page.locator("(//input[@type='checkbox'])[2]");

        //-------------------USP---------------//
        uspHeader = page.locator(".detail-kost-benefit-title");
        uspContainer = page.getByTestId("kostBenefitContent");
        uspTitle = page.locator(".detail-kost-benefit-content-wrapper-information__title");
        uspDescription = page.locator(".detail-kost-benefit-content-wrapper-information__subtitle");
        refundTitle = page.locator(".detail-kost-refund__title");
        refundDescription = page.locator(".detail-kost-refund__description");

        //------------voucher------------//
        voucherList = page.locator("//div[@class=\"all-vouchers-modal__vouchers bg-u-pt-md\"]");
        closeVoucher = page.locator("//button[@class = 'bg-c-modal__action-closable']");
        lihatDetailVoucher = page.locator("div:nth-child(2) > .voucher-card__title-container > .bg-u-mt-xxxs > .bg-c-link");
        salinButton = page.locator("//button[contains(.,'Salin')]").first();
        toastMessage = page.getByText("Kode voucher berhasil disalin.");
        salinDetailButton = page.locator("//button[@class=\"bg-c-button bg-c-button--primary bg-c-button--lg\"]");

        //------------survey label------------//
        surveyLabelSection = page.locator("#priceCard").getByTestId("detailFomoLabel");

        //------------inactive owner warning------------//
        inactiveOwnerWarningInfoBox = page.locator(".bg-c-alert--warning").filter(new Locator.FilterOptions().setHasText("Pemilik Kos Tidak Aktif"));
        inactiveOwnerWarningCloseIcon = page.locator(".bg-c-alert--warning button.bg-c-alert__action-close");
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
        var maxLoop = 0;
        playwright.pageScrollToDown(300);
        playwright.waitFor(ftueSlider, 5000.0);
        do {
            maxLoop++;
            if (playwright.waitTillLocatorIsVisible(ftueSlider)) {
                playwright.clickOn(ftueSlider.first());
            }
            if (playwright.waitTillLocatorIsVisible(btnSayaMengerti)) {
                playwright.forceClickOn(btnSayaMengerti);
            }
            if (maxLoop == 7) {
                break;
            }
        } while (playwright.waitTillLocatorIsVisible(ftueSlider));
    }

    public void dismissFTUEIfExist() {
        playwright.pageScrollToDown(300);
        if (playwright.waitTillLocatorIsVisible(ftueSlider, 5000.0)) {
            this.dismissFTUE();
        }
    }

    /**
     * Select booking date
     *
     * @param date tomorrow, today, or specific date by number on string data type
     */
    public void selectBookingDate(String date) {
        if (date.equalsIgnoreCase("tomorrow")) {
            this.date = JavaHelpers.getCostumDateOrTime("d", 1, 0, 0);
        } else if (date.equalsIgnoreCase("today")) {
            this.date = JavaHelpers.getCurrentDateOrTime("d");
        } else {
            this.date = date;
        }
        playwright.clickOn(mulaiKosInput);
        playwright.waitFor(datePicker, 5000.0);
        Locator datePick = page.getByTestId("bookingInputCheckinContent-datePicker").getByText(this.date);
        List<Locator> datePicks = playwright.getLocators(datePick);
        for (Locator pick : datePicks) {
            if (pick.isEnabled() && pick.isVisible()) {
                playwright.clickOn(pick);
            }
        }
    }

    /**
     * select booking period
     *
     * @param bookingPeriod string data type
     */
    public void selectBookingPeriod(String bookingPeriod) {
        if (!page.getByText(bookingPeriod).last().isVisible()) {
            bookingPeriodInput.click();
        }
        page.getByText(bookingPeriod).last().click();
    }

    /**
     * Click on ajukan sewa button
     *
     * @return BookingFormPO class
     */
    public BookingFormPO clickOnAjukanSewaButton() {
        playwright.clickOn(ajukanSewaButton);
        return new BookingFormPO(page);
    }

    /**
     * get list breadcrumb on detail kost
     * example breadcrumb is "Home > Kost Semarang > Kost Putra Dorgiocavall Bulusan Semarang"
     * @return string list of breadcrumb
     */
    public List<String> getListBreadCrumb() {
        return breadcrumbTrail.allInnerTexts();
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
            playwright.hardWait(700);
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
            playwright.pageScrollToDown(500);
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
        playwright.pageScrollInView(facilityRoomSeeAllBtn);
        playwright.waitTillLocatorIsVisible(facilityRoomSeeAllBtn);
        facilityRoomSeeAllBtn.click();
    }

    /**
     * this method will be click facilty umum section and more facility list will be appear
     */
    public void clickFasilitasUmumSeeAll(){
        playwright.pageScrollToDown(1900);
        playwright.waitTillLocatorIsVisible(facilityUmumBtn);
        playwright.clickOn(facilityUmumBtn);
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
        playwright.pageScrollInView(facilityNotesSection);
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
        playwright.pageScrollInView(facilityNotesSection);
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
        playwright.pageScrollInView(ownerStorySection);
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
        playwright.pageScrollInView(facShareSection);
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
        playwright.pageScrollInView(facParkirTitle);
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
        playwright.pageScrollInView(kosRuleSection);
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
        playwright.pageScrollToDown(3000);
        playwright.pageScrollInView(lihatPetaBtn);
        return playwright.waitTillLocatorIsVisible(lihatPetaBtn);
    }

    /**
     * this method will be check that map image is static or unclear on map section caused by non login condition
     *
     * @return 'boolean' that map image is static or unclear on map section caused by non login condition
     */
    public boolean isStaticMapPresent() {
        playwright.getText(staticMap);
        return playwright.waitTillLocatorIsVisible(staticMap);
    }

    /**
     * this method will be check 'tempat terdekat landmark' on map section
     *
     * @return 'boolean' 'tempat terdekat landmark' on map section visibility
     */
    public boolean isPOILandmarkShow() {
        playwright.getText(tabPOILandmark);
        return playwright.waitTillLocatorIsVisible(tabPOILandmark);
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
        playwright.pageScrollToDown(3100);
        playwright.pageScrollInView(tanyaAlamatLengkapBtn);
        return playwright.waitTillLocatorIsVisible(tanyaAlamatLengkapBtn);
    }

    /**
     * this method will be check that map is clear and user can see more detail kost location on map section for login condition
     *
     * @return 'boolean' that map is clear and user can see more detail kost location on map section for login condition visibility
     */
    public boolean isKostCurrentLocationPresent() {
        playwright.getText(currentLocation);
        return playwright.waitTillLocatorIsVisible(currentLocation);
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
        playwright.waitFor(chatRoom);
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
        playwright.pageScrollInView(kosReportContainer);
        return playwright.waitTillLocatorIsVisible(kosReportContainer);
    }

    /**
     * Click on kos report button
     */
    public void clickOnKosReportButton() {
        playwright.pageScrollInView(kosReportContainer);
        playwright.clickOn(kosReportButton);
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
        playwright.pageScrollInView(aboutStatisticsButton);
        return playwright.waitTillLocatorIsVisible(aboutStatisticsButton);
    }

    /**
     * Check owner name is displayed
     *
     * @return status true / false
     */
    public boolean isOwnerNameDisplayed() {
        playwright.pageScrollInView(ownerNameText);
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
        playwright.pageScrollInView(relatedCard);
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
        return playwright.waitTillLocatorIsVisible(bookingDateForm);
    }

    /**
     * Click on booking date form
     */
    public void clickOnBookingDate() {
        playwright.waitFor(bookingDateForm, 5000.0);
        playwright.clickOn(bookingDateForm);
    }

    /**
     * Get booking date description inside booking date
     *
     * @return string data type
     */
    public String getDescBookingDateText(String desc) {
        Locator description = priceCardBase.getByText(desc).first();
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
        playwright.pageScrollInView(ownerImageProfile);
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
        playwright.pageScrollInView(kosBenefit);
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
        playwright.pageScrollInView(lihatSemuaReviewButton);
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
        playwright.pageScrollInView(seeAllReviewBtn);
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
            if (playwright.waitTillLocatorIsVisible(ftueSlider.first())) {
                break;
            }
            playwright.hardWait(1000);
        }
        playwright.waitTillLocatorIsVisible(ftuePopUP,3000.0);
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
        needConfirmation.waitFor();
        needConfirmation.click();
        if (seeCompleteBtn.isVisible()) {
            playwright.waitFor(seeCompleteBtn,5000.0);
            seeCompleteBtn.click();
            cancelBookingBtn.click();
            playwright.waitTillLocatorIsVisible(reasonOption);
            yesCancelBookingBtn.click();
            page.reload();
            filterButton.waitFor();
        }
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
        playwright.pageScrollInView(kosCheckedByOwner);
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
        playwright.waitTillPageLoaded();

            int i = 0;
            while (isDeleteDraftBtnVisible()) {
                playwright.clickOn(deleteButtonOnTabOneDraftBooking);
                playwright.clickOn(hapusDraft);
                page.waitForTimeout(3000);
                i++;
            }
    }

    /**
     * Verify the delete draft button is visible or not
     * @return boolean, true if button visible and false if button not visible
     *
     */
    private boolean isDeleteDraftBtnVisible() {
        return playwright.waitTillLocatorIsVisible(deleteButtonOnTabOneDraftBooking, 3000.0);
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

    /**
     * click calendar
     */
    public void clickOnCalendar() {
        playwright.waitTillLocatorIsVisible(dateTextBox);
        playwright.clickOn(mulaiKosInput);
    }

    /**
     * get BSS information
     *
     * @return 'string' BSS information
     */
    public String getBSSInformationText(String infoBSSText) {
            return playwright.getText(page.getByText(infoBSSText));
    }

    /**
     * check is it ajukan sewa button is enable
     * @return boolean
     */
    public boolean isAjukanSewaButtonEnable(){
        return ajukanSewaButton.isEnabled();
    }

    /**
     * check if harga coret is visible
     * @return boolean, true if harga coret visible
     */
    public boolean isHargaCoretVisible() {
        return discountPriceKostDetailText.isVisible();
    }
    /**
     * Click on chat pemilik button
     */
    public void clickOnChatPemilikButton() {
        chatPemilikButton.click();
    }

    /**
     * Click on bantuan button
     */
    public void clickOnBantuanMenuButton() {
        bantuanButton.click();
    }

    /**
     * Click on button text
     */
    public void clickOnBytextButton(String buttonText) {
        aktivitasKosSayaButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(buttonText));
        playwright.clickOn(aktivitasKosSayaButton);
    }

    /**
     * this method will be chatlist tittle displayed
     */
    public Boolean isChatListTittleDisplayed() {
        playwright.hardWait(3);
        return playwright.waitTillLocatorIsVisible(chatListTittle);
    }

    /**
     * this method will be information kos detail displayed
     */
    public Boolean isInformationKosDetaileDisplayed() {
        playwright.hardWait(3);
        return playwright.waitTillLocatorIsVisible(informationKosDetail);
    }

    /**
     * this method will be information activities tagihan in my kos displayed
     */
    public Boolean isTagihanKosDisplayed(){
        return playwright.waitTillLocatorIsVisible(tagihanKosTittle);
    }
    /**
     * this method will be information activities contract in my kos displayed
     */
    public Boolean isKontrakDisplayed(){
        return playwright.waitTillLocatorIsVisible(contractTittle);
    }
    /**
     * this method will be information activities chat pemilik in mya kos displayed
     */
    public Boolean isChatPemilikDisplayed(){
        return playwright.waitTillLocatorIsVisible(chatOwnerTittle);
    }
    /**
     * this method will be information activities bantuan in mya kos displayed
     */
    public Boolean isBantuanDisplayed(){
        return playwright.waitTillLocatorIsVisible(bantuanButton);
    }
    /**
     * this method will be information activities forum in mya kos displayed
     */
    public Boolean isForumDisplayed(){
        return playwright.waitTillLocatorIsVisible(forumTittle);
    }
    /**
     * this method will be information activities forum in mya kos displayed
     */
    public Boolean isKategoriBantuanTittleDisplayed(){
        return playwright.waitTillLocatorIsVisible(kategoriBantuanTittle);
    }

    /**
     * check is refund policy section and all inside it is visible or not
     * @return boolean, true if visible
     */
    public boolean isRefundPolicySectionVisible() {
        playwright.waitTillLocatorIsVisible(canRefundText);
        canRefundText.isVisible();
        playwright.waitTillLocatorIsVisible(accordingToTnCRefundText);
        accordingToTnCRefundText.isVisible();
        return refundPolicySection.isVisible();
    }

    /**
     * click bagaimana ketentuannya? text on refund policy section
     */
    public void clickBagaimanaKetentuan() {
        playwright.pageScrollInView(whatAreTheTermsText);
        whatAreTheTermsText.click();
    }

    /**
     * check is refund tnc title visible or not
     * @return boolean, true if visible
     */
    public boolean isTnCRefundVisible() {
        return playwright.waitTillLocatorIsVisible(tncRefundtitleText);
    }

    /**
     * scroll until element and click "kebijakan refund mamikos"
     */
    public void clickRefundPolicyMamikos() {
        playwright.pageScrollInView(refundPolicyMamikos);
        refundPolicyMamikos.click();
    }

    /**
     * click on "ketentuan waktu berikut" text on refund tnc
     */
    public void clickTimeConditionRefund() {
        timeConditionText.click();
    }

    /**
     * check TnC refund is visible
     * @param refundSubtile refer to TnC refund list/point
     *                      e.g. Refund sebelum check-in
     */
    public void isTnCRefundPoint(String refundSubtile) {
        tncRefundPoint = page.getByText(refundSubtile);
        assertThat(tncRefundPoint).isVisible();
    }

    /**
     * Check the visibility of ftue booking benefit
     * @return boolean
     */
    public boolean isFTUEBookingBenefitIsNotVisible() {
        for (int i = 0; i < 4; i++) {
            playwright.pageScrollToDown(300);
            if (playwright.waitTillLocatorIsVisible(ftueSlider.first())) {
                break;
            }
            playwright.hardWait(500);
        }
        return playwright.waitTillLocatorIsVisible(ftuePopUP);
    }

    /**
     * Check the visibility of full room text
     * @return boolean
     */
    public boolean isFullRoomVisible() {
        return fullRoomText.isVisible();
    }

    /**
     * Check the visibility of waiting list button
     * @return boolean
     */
    public boolean isWaitingListButtonVisible(){
        return waitingListButton.isVisible();
    }

    /**
     * Check the visibility of lihat tipe lain button
     * @return boolean
     */
    public boolean isAnotherTypeButtonVisible(){
        return anotherTypeButton.isVisible();
    }

    /**
     * Click lihat tipe lain button
     */
    public void clickAnotherTypeButton(){
        playwright.clickOn(anotherTypeButton);
    }

    /**
     * Check the visibility of lihat kost lain button
     * @return boolean
     */
    public boolean isAnotherKosButtonVisible(){
        return anotherKosButton.isVisible();
    }

    /**
     * Click lihat kost lain button
     */
    public void clickAnotherKosButton(){
        playwright.clickOn(anotherKosButton);
    }

    /**
     * Check the visibility of tanya pemilik button
     * @return boolean
     */
    public boolean isTanyaPemilikVisible(){
        playwright.waitFor(tanyaPemilikKostLink);
        return tanyaPemilikKostLink.isVisible();
    }

    /**
     * Check the visibility of tipe lain section
     * @return boolean
     */
    public boolean isAnotherTypeSectionVisible() {
        return anotherTypeSection.isVisible();
    }

    /**
     * Check the visibility of tipe lain section is not visible
     * @return boolean
     */
    public boolean isAnotherTypeSectionNotVisible() {
        return !anotherTypeSection.isVisible();
    }

    /**
     * Check if the "text"  is not visible
     * @return boolean
     */
    public boolean isAnotherKosSectionNotVisible() {
        return !anotherKosSection.isVisible();
    }


    /**
     * Check the visibility of kamu mungkin menyukainya section
     * @return boolean
     */
    public boolean isAnotherKosSectionVisible(){
        return anotherKosSection.isVisible();
    }

    /**
     * Check the visibility of kost booking validation example : Kost ini khusus mahasiswa
     * @return boolean
     */
    public boolean isPopupValidationVisible(){
        return popupValidationText.isVisible();
    }

    /**
     * Click on Buka profile button on popup validation
     */
    public void clickBukaProfile(){
        playwright.clickOn(btnBukaProfil);
    }

    /**
     * validate peraturan kost disini
     * @param text
     * @return
     */
    public boolean getPeraturanKosDisinitext(String text){
        peraturanDisinitext = page.locator("//*[@class=\"bg-c-list-item detail-kost-rule-item detail-kost-rules__item\"]//p[contains(.,'"+text+"')]");
        playwright.pageScrollUsingCoordinate(300, 2500);
        playwright.waitFor(peraturanDisinitext);
        return peraturanDisinitext.isVisible();
    }

    /**
     * validate information when success submit waiting list
     * @param text
     * @return
     */
    public boolean waitingListInformationText(String text){
        waitingListSubmitText = page.locator("#priceCard").getByText(""+text+"");
        return waitingListSubmitText.isVisible();
    }

    /**
     * Verify the kos name and location
     * @param kosName
     * @return true if kos name displayed and false if kos name not displayed
     */
    public boolean isKostNameAndLocationAbsence(String kosName) {
        playwright.hardWait(2000.0);
        return playwright.isTextDisplayed(kosName, 3000.0);
    }

    /**
     * Verify text on pop up
     * @param text
     * @return true if text displayed and false if text not displayed
     */
    public boolean getTextOnPopUp(String text) {
        return playwright.isTextDisplayed(text);
    }

    /**
     * Verify the FTUE booking on kos detail visible or not
     * @return true if ftue displayed and false if ftue not displayed
     */
    public boolean isBookingFtueVisible() {
        playwright.pageScrollToDown(300);
        return playwright.isLocatorVisibleAfterLoad(ftueSlider, 3000.0);
    }
    /**
     * Click on text pilih button
     */
    public void clickOnPilihInformasiPenyewa(String indexToClick) {
        ElementHandle[] buttons = page.querySelectorAll("(//a[@role='button'])").toArray(new ElementHandle[0]);
        int index = Integer.parseInt(indexToClick);
        if (index >= 0 && index < buttons.length) {
            buttons[index].click();
        }

    }

    /**
     * verify name instansi, universitas dan karyawan
     */
    public void userWillSeeHaveJobName() {
        playwright.pageScrollHeightToBottom();
        playwright.getText(jobLocator);
    }

    /**
     * Check the visibility of Kost Name in waiting list form
     */
    public Boolean isKostNameWLFromDisplayed(){
        return playwright.waitTillLocatorIsVisible(kostNameWLForm);
    }

    /**
     * Check the visibility of Kost Type in waiting list form
     */
    public Boolean isKostTypeWLFormDisplayed(){
        return playwright.waitTillLocatorIsVisible(kostTypeWLForm);
    }

    /**
     * Check the visibility of Tenant Name in waiting list form
     */
    public Boolean isTenantNameWLFormDisplayed(){
        return playwright.waitTillLocatorIsVisible(tenantNameWLForm);
    }

    /**
     * Check the visibility of Tenant Phone Number in waiting list form
     */
    public Boolean isTenantPhoneWLFOrmDisplayed(){
        return playwright.waitTillLocatorIsVisible(tenantPhoneWLForm);
    }

    /**
     * Check the visibility of Sudah ada tanggal pasti option in waiting list form
     */
    public Boolean isSudahAdaTglPastiOptionDisplayed(){
        return playwright.waitTillLocatorIsVisible(sudahAdaTglPastiOption);
    }

    /**
     * Check the visibility of Secepatnya option in waiting list form
     */
    public Boolean isSecepatnyaOptionDisplayed(){
        return playwright.waitTillLocatorIsVisible(secepatnyaOption);
    }

    /**
     * Check the visibility of Baru perkiraan option in waiting list form
     */
    public Boolean isBaruPerkiraanOptionDisplayed(){
        return playwright.waitTillLocatorIsVisible(baruPerkiraanOption);
    }

    /**
     * Check the visibility of Belum ada tanggal option in waiting list form
     */
    public Boolean isBelumAdaTglOptionDisplayed(){
        return playwright.waitTillLocatorIsVisible(belumAdaTglOption);
    }

    /**
     * Check the visibility of Kirim button in waiting list form
     */
    public Boolean isKirimButtonDisplayed(){
        return playwright.waitTillLocatorIsVisible(submitWLButton);
    }

    /**
     * clicks Calendar View for Sudah ada tanggal pasti
     */
    public void clickCalViewOnTglMasukKos(){
        playwright.clickOn(selectDateForSudahAdaTgl);
    }

    /**
     * clicks Calendar View for Perkiraan
     */
    public void clickCalViewOnRentangTglMasukKos(){
        playwright.clickOn(selectDateForBaruPerkiraan);
    }

    /**
     * check text success submit waiting list
     * @return text
     */
    public boolean isSucceSubmitWLTextDisplayed(){
        return playwright.waitTillLocatorIsVisible(succesSubmitWLText);
    }

    /**
     * check phone number placeholder
     * @param text
     * @return text
     */
    public boolean isPhoneNumberPlaceHolderText(String text){
        Locator phonePlaceholdertext = page.locator("//input[@placeholder='"+text+"']");
        return playwright.waitTillLocatorIsVisible(phonePlaceholdertext);
    }

    /**
     * click on camera shutter
     */
    public void uploadIdVerification() {
        playwright.pageScrollHeightToBottom();
        playwright.clickOn(page.locator("//div[@class='dbet-tenant-input-id__input']"));
        playwright.clickOnText("Lanjutkan");
        playwright.clickOnText("Lanjutkan");
        page.evaluate("navigator.mediaDevices.getUserMedia({ video: true })");
        playwright.hardWait(3000);
        playwright.clickOn(page.locator("//div[@class='camera-shutter']"));
        playwright.waitFor(uploadImage);
        playwright.clickOnText("Simpan");
    }
    /**
     * click on notification header
     */
    public void clickNotifikasiOnHeader()  {
        playwright.clickOn(notificationOnHeader);
    }
    /**
     * click on Toggle Foto Kartu Identitas
     */
    public void clickOnToggleFotoKartuIdentitas()  {
        playwright.clickOn(toggleFotoKartuIdentitas);
    }
    /**
     * click on Toggle Jatuh Tempo
     */
    public void clickOnToggleJatuhTempo() {
        playwright.clickOn(toggleJatuhTempo);
    }

    /**
     * click on Close waiting list button
      */
    public void clickCloseWaitingListButton(){
        playwright.clickOn(closeWaitingListButton);
    }
    /**
     * checking date today cannot booking
     */
    public void dateCannotBooking() {
        mulaiKosInput.click();
        playwright.getLocators(dateCannotBooking);
    }

    /**
     * checking date next month
     */
    public void tenantCanCheckInNextMonth(String month) {
        playwright.clickOn(calendarView);
        int numberOfMonths = Integer.parseInt(month);
        for (int i = 0; i < numberOfMonths; i++) {
            playwright.clickOn(nextMonthButton);
        }
        LocalDate currentDate = LocalDate.now();
        LocalDate futureDate = currentDate.plusMonths(numberOfMonths);
        String formattedDate = futureDate.format(DateTimeFormatter.ofPattern("d", Locale.ENGLISH));
        
        // Try multiple selectors for the date, excluding muted dates
        Locator dateLocator = page.locator("//span[contains(@class,'cell') and contains(@class,'day') and not(contains(@class,'disabled')) and not(contains(@class,'muted'))][normalize-space()='"+formattedDate+"']");
        
        // Wait for the date to be visible
        playwright.waitTillLocatorIsVisible(dateLocator, 10000.0);
        
        // If the exact date is disabled, try to find the nearest available date
        if (!dateLocator.isEnabled() || dateLocator.getAttribute("class").contains("disabled")) {
            // Try the next day
            for (int i = 1; i <= 7; i++) {
                LocalDate alternateDate = futureDate.plusDays(i);
                String alternateDateFormatted = alternateDate.format(DateTimeFormatter.ofPattern("d", Locale.ENGLISH));
                Locator alternateDateLocator = page.locator("//span[contains(@class,'cell') and contains(@class,'day') and not(contains(@class,'disabled')) and not(contains(@class,'muted'))][normalize-space()='"+alternateDateFormatted+"']");
                if (playwright.waitTillLocatorIsVisible(alternateDateLocator, 2000.0) && alternateDateLocator.isEnabled()) {
                    playwright.clickOn(alternateDateLocator);
                    return;
                }
            }
        }
        
        playwright.clickOn(dateLocator);
    }
    /**
     * checking date next month
     */
    public void tenantCanCheckInNextWeek(String week) {
        playwright.clickOn(calendarView);
        int numberOfWeeks = Integer.parseInt(week);
        LocalDate currentDate = LocalDate.now();
        LocalDate futureDate = currentDate.plusWeeks(numberOfWeeks);
        String formattedDate = futureDate.format(DateTimeFormatter.ofPattern("d", Locale.ENGLISH));
        if (page.isVisible("//span[@class='cell day'][normalize-space()='" + formattedDate + "']")) {
            page.click("//span[@class='cell day'][normalize-space()='" + formattedDate + "']");
        } else {
            playwright.getLocators(nextMonthaDisableButton);
        }
    }

    /**
     * Verify the promo owner is displayed on kost detail page
     * @param promoOwner
     * @return true, false
     * true if promo owner displayed, false if promo owner not displayed
     */
    public boolean isPromoOwnerDisplayed(String promoOwner) {
        return playwright.isTextDisplayed(promoOwner);
    }

    /**
     * Scroll down until map section
     */
    public void scrollToViewMap() {
        int maxloop = 0;

        do {
            maxloop++;
            playwright.pageScrollToDown(100);
            playwright.hardWait(1000);

            if (maxloop == 100) break;
        } while (!mapSection.isVisible());
    }

    /**
     * Get USP header
     * @return String USP header
     */
    public String  getUSPHeader() {
        playwright.pageScrollInView(uspHeader);
        return playwright.getText(uspHeader);
    }

    /**
     * Get USP title
     * @param index USP title index
     * @return String USP title
     */
    public String getUSPTitle(int index) {
        playwright.pageScrollToDown(600);
        return playwright.getText(uspTitle.nth(index));
    }

    /**
     * Get USP description
     * @param index USP description index
     * @return String USP description
     */
    public String getUSPDescription(int index) {
        return playwright.getText(uspDescription.nth(index));
    }

    /**
     * Get refund title
     * @return String refund title
     */
    public String getRefundTitle() {
        playwright.pageScrollToDown(600);
        return playwright.getText(refundTitle);
    }

    /**
     * Get refund description
     * @return String refund description
     */
    public String getRefundDescription() {
        return playwright.getText(refundDescription);
    }

    /**
     * Get voucher text
     * @param voucherName voucher name
     * @return String voucher text
     */
    public String getVoucherText(String voucherName) {
        Locator voucherText = page.locator("//p[contains(.,'"+voucherName+"')]");
        playwright.waitTillPageLoaded();
        return playwright.getText(voucherText);
    }

    /**
     * Check if voucher text is visible for kost p2
     * @param voucherName
     * @return voucher text name
     */
    public boolean isVoucherTextVisible(String voucherName) {
        Locator voucherTextName = page.locator("//p[contains(.,'"+voucherName+"')]");
        playwright.waitTillPageLoaded();
        return playwright.waitTillLocatorIsVisible(voucherTextName);
    }

    /**
     * Click on voucher
     * @param voucherName
     */
    public void clickONVoucher(String voucherName) {
        Locator voucher = page.locator("//p[contains(.,'"+voucherName+"')]");
        playwright.waitTillPageLoaded();
        playwright.clickOn(voucher);
    }

    /**
     * Check if voucher list is visible
     * @return voucher list
     */
    public boolean isVoucherListVisible() {
        playwright.waitTillPageLoaded();
        return playwright.waitTillLocatorIsVisible(voucherList);
    }

    /**
     * click close icon
     */
    public void clickCloseIcon(){
        playwright.clickOn(closeVoucher);
    }

    /**
     * click on lihat detail button
     */
    public void clickOnLihatDetailButton(){
        playwright.clickOn(lihatDetailVoucher);
    }

    /**
     * get voucher name
     * @param voucherName
     * @return
     */
    public String getVoucherName(String voucherName){
        Locator voucherNameText = page.locator("//p[contains(.,'"+voucherName+"')]").nth(1);
        return playwright.getText(voucherNameText);
    }

    /**
     * click on salin button on list
     */
    public void clickOnSalinButton(){
        playwright.clickOn(salinButton);
    }

    /**
     * get toast message
     * @return text
     */
    public String getToastSuccess(){
        return playwright.getText(toastMessage);
    }

    /**
     * click on salin button on detail voucher
     */
    public void clickOnSalinDetailButton(){
        playwright.clickOn(salinDetailButton);
    }

    /**
     * Check if survey label section is visible below price
     * @return boolean true if visible, false otherwise
     */
    public boolean isSurveyLabelSectionVisible() {
        return playwright.waitTillLocatorIsVisible(surveyLabelSection, 3000.0);
    }

    /**
     * Check if survey label section is NOT visible below price
     * @return boolean true if not visible, false if visible
     */
    public boolean isSurveyLabelSectionNotVisible() {
            return !surveyLabelSection.isVisible();
    }

    /**
     * Get survey label text from kost detail page
     * @return String survey label text
     */
    public String getSurveyLabelText() {
            playwright.waitTillLocatorIsVisible(surveyLabelSection, 3000.0);
                return playwright.getText(surveyLabelSection);
    }

    //------------ Inactive Owner Warning Section ----------------

    /**
     * Check if inactive owner warning info box is displayed
     * @return boolean true if visible, false otherwise
     */
    public boolean isInactiveOwnerWarningInfoBoxDisplayed() {
        return playwright.waitTillLocatorIsVisible(inactiveOwnerWarningInfoBox, 5000.0);
    }

    /**
     * Click on close icon on inactive owner warning info box
     */
    public void clickCloseIconOnInactiveOwnerWarning() {
        playwright.waitTillLocatorIsVisible(inactiveOwnerWarningCloseIcon);
        playwright.clickOn(inactiveOwnerWarningCloseIcon);
    }

    /**
     * Navigate back to previous page (SRP)
     */
    public void navigateBackToPreviousPage() {
        page.goBack();
        playwright.waitTillPageLoaded();
    }

    /**
     * Navigate forward to next page (property detail)
     */
    public void navigateForwardToNextPage() {
        page.goForward();
        playwright.waitTillPageLoaded();
    }
}