package steps.mamikos.tenant;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.HomePO;
import pageobject.common.KostDetailsPO;
import pageobject.common.SearchPO;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

import java.text.ParseException;

public class KostDetailSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    JavaHelpers java = new JavaHelpers();

    HomePO home = new HomePO(page);
    SearchPO search = new SearchPO(page);
    KostDetailsPO kostDetail = new KostDetailsPO(page);

    @Then("user can see overview section on detail page")
    public void userCanSeeOverViewSection(DataTable table) {
        var kostNameData = table.asMaps(String.class, String.class);
        var kostName = kostNameData.get(0).get("kost " + Mamikos.ENV);
        Assert.assertTrue(kostDetail.getKostTitle().contains(kostName));
        Assert.assertTrue(kostDetail.isPropertyGenderDisplayed(), "Property Gender Label is not displayed");
        Assert.assertTrue(kostDetail.isPropertyLocationDisplayed(), "Property Location Label is not displayed");
        Assert.assertTrue(kostDetail.isRoomAvailabilityDisplayed(), "Property Room AvailabilityLabel is not displayed");
    }

    //------------ promo section ----------------
    @When("user want to select kost on promo section")
    public void userSelectKostOnPromoSection() {
        // passing return value object to move next page
        this.kostDetail = home.selectKostOnPromoSection();
    }

    @Then("user see promo owner section")
    public void userSeePromoOwnerSection() {
        playwright.pageScrollToDown(200);
        kostDetail.dismissFTUE();
        Assert.assertTrue(kostDetail.isPromoOwnerSectionDisplayed(), "Promo Owner Section is not displayed");
    }

    @When("user want to get more information about kost promo")
    public void userWantToseeMoreAboutKostPromo() {
        kostDetail.clickOnButtonPromoOwner();
        kostDetail.clickOnTanyaPemilikKost();
    }

    @Then("user will get {string} pop up")
    public void hubungiKostPopUp(String popUpMsg) {
        Assert.assertTrue(kostDetail.isChatKostPopUpDisplayed(), "Pop Up Hubungi Kos Ini Section is not displayed");
        Assert.assertTrue(kostDetail.hubungiKostHeadingText().contains(popUpMsg));
    }

    //---------------login pop up Section----------------------
    @Then("user will see login pop up")
    public void loginPopUp() {
        playwright.pageScrollToDown(200);
        Assert.assertFalse(kostDetail.isChatKostPopUpDisplayed(), "Pop Up Hubungi Kos Ini Section is displayed");
        Assert.assertTrue(kostDetail.isLoginPopUpDisplayed(), "Login Pop up is not displayed");
    }

    //---------------Facility Room Section----------------------
    @And("user want to see more detail room facility section on the kost detail page")
    public void userWantToSeeRoomFacilty() {
        playwright.pageScrollToDown(200);
        kostDetail.dismissFTUE();
        kostDetail.clickFacilityRoomSeeAll();
    }

    @Then("user see all facility room section")
    public void userSeeAllRoomFacility() {
        playwright.pageScrollToDown(200);
        Assert.assertTrue(kostDetail.isRoomFacilitiyPopUpDisplayed(), "Room Facility pop up is not displayed");
    }

    //--------------Facility Bath Section----------------------
    @Then("user can see facility bath section on detail page")
    public void userCanSeeFacilityBathSection() {
        playwright.pageScrollToDown(200);
        kostDetail.dismissFTUE();
        Assert.assertTrue(kostDetail.isFacBathShow(), "Bathroom Facility section is not displayed");
        Assert.assertTrue(kostDetail.isBathFacilitiyIconDisplayed(), "Bathroom Facility icon is not displayed");
        Assert.assertTrue(kostDetail.isBathFacilitiyNameDisplayed(), "Bathroom Facility name is not displayed");
    }

    //------------------Facility Notes Section-----------------
    @Then("user can see facility notes on detail kos and button is not present")
    public void userCanSeeFacilityNotesOnDetailKosBtnNotPresent() {
        playwright.pageScrollToDown(200);
        kostDetail.dismissFTUE();
        Assert.assertTrue(kostDetail.isFacilityNotesSectionDisplayed(), "Facility Notes section is not displayed");
        Assert.assertTrue(kostDetail.isFacilityNotesDescDisplayed(), "Facility Notes Description is not displayed");
        Assert.assertFalse(kostDetail.isExpandFacNotesDisplayed(), "Facility Notes expand button is displayed");
    }

    @Then("user can see facility notes on detail kos and button is present")
    public void userCanSeeFacilityNotesOnDetailKosBtnPresent() {
        playwright.pageScrollToDown(200);
        kostDetail.dismissFTUE();
        Assert.assertTrue(kostDetail.isFacilityNotesSectionDisplayed(), "Facility Notes section is not displayed");
        Assert.assertTrue(kostDetail.isFacilityNotesDescDisplayed(), "Facility Notes Description is not displayed");
        Assert.assertTrue(kostDetail.isExpandFacNotesDisplayed(), "Facility Notes expand button is not displayed");
        kostDetail.clickOnExpandFacNotes();
    }

    //------------------Owner Story Section-----------------
    @Then("user can see owner story on detail kos and button is not present")
    public void userCanSeeOwnerStoryOnDetailKos() {
        playwright.pageScrollToDown(200);
        kostDetail.dismissFTUE();
        Assert.assertTrue(kostDetail.isOwnerStorySectionDisplayed(), "Owner Story section is not displayed");
        Assert.assertTrue(kostDetail.isOwnerStoryDescDisplayed(), "Owner Story description is not displayed");
        Assert.assertFalse(kostDetail.isExpandOwnerStoryDisplayed(), "Owner Story expand button section is displayed");
    }

    @Then("user can see owner story on detail kos and button is present")
    public void userCanSeeOwnerStoryOnDetailKosBtnIsPresent() {
        playwright.pageScrollToDown(200);
        kostDetail.dismissFTUE();
        Assert.assertTrue(kostDetail.isOwnerStorySectionDisplayed(), "Owner Story section is not displayed");
        Assert.assertTrue(kostDetail.isOwnerStoryDescDisplayed(), "Owner Story description is not displayed");
        Assert.assertTrue(kostDetail.isExpandOwnerStoryDisplayed(), "Owner Story expand button section is displayed");
        kostDetail.clickOnExpandOwnerStory();
    }

    //------------ Facilty Share section ----------------
    @Then("user can see facility share section on detail page")
    public void userSeeAllFacility() {
        playwright.pageScrollToDown(200);
        kostDetail.dismissFTUE();
        Assert.assertTrue(kostDetail.isFacShareShow(), "Facility Share is not displayed");
    }

    @Then("user want to see all facility share")
    public void userWantToSeeAllFacility() {
        playwright.pageScrollToDown(200);
        kostDetail.clickOnButtonFacShare();
    }

    @Then("user see all facility share section")
    public void userSeeAllFacilityShareSection() {
        playwright.pageScrollToDown(200);
        Assert.assertTrue(kostDetail.isSharedFacilitiyTitleDisplayed(), "Facility shared title is not displayed!");
        Assert.assertTrue(kostDetail.isSharedFacilitiyDescDisplayed(), "Facility description title is not displayed!");
        Assert.assertTrue(kostDetail.isSharedFacilitiyPopUpDisplayed(), "Facility pop up is not displayed!");
    }

    //------------------Facilty Parking Section-----------------
    @Then("user can see facility parking section on detail page")
    public void user_can_see_facility_parking_section_on_detail_page() {
        playwright.pageScrollToDown(200);
        kostDetail.dismissFTUE();
        Assert.assertTrue(kostDetail.isFacParkingTitleDisplayed(), "Facility Parking Title Section is not displayed");
        Assert.assertTrue(kostDetail.isFacParkingDisplayed(), "Facility Parking Section is not displayed");
    }

    // ------------ Kos rule -------------
    @Then("user can see kos rule list on detail kos")
    public void user_can_see_kos_rule_list_on_detail_kos() {
        playwright.pageScrollToDown(200);
        kostDetail.dismissFTUE();
        Assert.assertTrue(kostDetail.isKosRulePresent(), "Kos rule is not present!");
        Assert.assertTrue(kostDetail.isKosRuleTitlePresent(), "Kos rule title is not present!");
        Assert.assertTrue(kostDetail.isKosRuleButtonShow(), "Kos Rule Button is not displayed");
        Assert.assertTrue(kostDetail.isKosRuleImagePresent(), "Kos rule image is not present!");
        kostDetail.clickOnSeeAllKosRuleButton();
    }

    // ------------ Kost Map section -----------
    @Then("user want to reached map section and see lihat peta button")
    public void userCanSeeLihatPetaBtn() {
        playwright.pageScrollToDown(200);
        kostDetail.dismissFTUE();
        Assert.assertTrue(kostDetail.isLihatPetaButtonPresent(), "Lihat Peta Button is not present!");
        Assert.assertTrue(kostDetail.isStaticMapPresent(), "Static Map is not present!");
        Assert.assertTrue(kostDetail.isPOILandmarkShow(), "POI Landmark is not displayed");
    }

    @When("user want to see more detail kost location")
    public void seeKostMapBtn() {
        kostDetail.clickOnSeeMapButton();
    }

    @Then("user want to reached map section and see tanya alamat lengkap button")
    public void userCanSeeAlamatLengkapPetaBtn() {
        playwright.pageScrollToDown(200);
        kostDetail.dismissFTUE();
        Assert.assertTrue(kostDetail.isTanyaAlamatBtnPresent(), "Tanya Alamat Button is not present!");
        Assert.assertTrue(kostDetail.isKostCurrentLocationPresent(), "Kost current position is not present!");
        Assert.assertTrue(kostDetail.isPOILandmarkShow(), "POI Landmark is not displayed");
    }

    @When("user want to ask kost address")
    public void userAskAdreess() {
        kostDetail.clickOnTanyaAlamatBtn();
    }

    @Then("chat room appear with latest message")
    public void msgChatRoom() {
        Assert.assertTrue(kostDetail.isChatRoomPresent(), "Chat room is not present!");
        var message = "Kos DC BAR Automation Tipe A beralamat di: ";
        Assert.assertTrue(kostDetail.getLatestChatText().trim().replaceAll("\\s", "")
                .contains(message.replaceAll("\\s", "")), "Kos address in title is wrong");
    }

    // ------------ Kos Report Section -----------
    @Then("user can see kos report section")
    public void i_should_reached_kos_report_section() {
        playwright.pageScrollToDown(200);
        kostDetail.dismissFTUE();
        Assert.assertTrue(kostDetail.isKosReportPresent(), "Kos report is not present");
    }

    @And("user want to report this kos")
    public void i_click_button_report_kos() {
        kostDetail.clickOnKosReportButton();
    }

    @And("user send text {string} in form kos report")
    public void user_enter_text_in_form_kos_report(String textReport) {
        kostDetail.clickOnCheckBox();
        kostDetail.insertReportText(textReport);
        kostDetail.clickOnSendReportButton();
    }

    @Then("user will see display pop up confirmation already have send report kos")
    public void display_pop_up_confirmation_already_have_send_report_kos() {
        Assert.assertTrue(kostDetail.isReportConfirmationPresent(), "Pop Up Confirmation send report is not present");
    }

    //------------ Kos Owner Information Section ------------------
    @Then("user can see owner information section")
    public void i_should_reached_owner_lower_section() {
        playwright.pageScrollToDown(200);
        kostDetail.dismissFTUE();
        kostDetail.isOwnerSectionPresent();
        Assert.assertTrue(kostDetail.isOwnerNameDisplayed(), "Owner name not present!");
        Assert.assertTrue(kostDetail.isOwnerPictureDisplayed(), "Owner picture not present!");
        Assert.assertTrue(kostDetail.isOwnerStatusDisplayed(), "Owner status not present!");
        Assert.assertTrue(kostDetail.isNumberTransactionDisplayed(), "Number of transaction not present!");
        Assert.assertTrue(kostDetail.isBookingProcessedDisplayed(), "Booking processed not present!");
        Assert.assertTrue(kostDetail.isBookingChanceDisplayed(), "Booking chance not present!");
    }

    @And("user want to see more detail owner information section")
    public void i_validate_the_elements_of_owner_section() {
        kostDetail.clickStatisticsDetailButton();
        Assert.assertTrue(kostDetail.isStatisticsModalDisplayed(), "Statistics modal not present!");
        kostDetail.closeStatisticsModal();
    }

    //------------ Check Gallery Photo Section ------------------
    @And("user want to display detail gallery")
    public void i_can_see_lihat_semua_foto() {
        Assert.assertTrue(kostDetail.isSeeAllPhotoButtonPresent(), "Button Lihat semua foto is not present");
        kostDetail.clickOnSeeAllButton();
        Assert.assertTrue(kostDetail.isCloseButtonPresent(), "Button close is not present");
        Assert.assertTrue(kostDetail.isBuildingPhotosPresent(), "Foto Bangunan is not present");
        Assert.assertTrue(kostDetail.isRoomPhotosPresent(), "Foto Kamar is not present");
        Assert.assertTrue(kostDetail.isBathroomPhotosPresent(), "Foto Kamar Mandi is not present");
        Assert.assertTrue(kostDetail.isOthersPhotosPresent(), "Foto Lainnya is not present");
        kostDetail.clickOnDetailPhotoButton();
        kostDetail.clickOnArrowPhotoGalleryNextButton();
    }

    //-------------- Kost Recomendation Section--------------
    @Then("user want to see the other kost on recommendation section")
    public void i_can_see_kost_recommendation() {
        kostDetail.dismissFTUE();
        Assert.assertTrue(kostDetail.isLihatSemuaKosButtonPresent(), "Button Lihat semua is not present");
        Assert.assertTrue(kostDetail.isArrowRecommendationButtonPresent(), "arrow button is not present");
        Assert.assertTrue(kostDetail.isListPhotoRecommendationKosPresent(), "Foto kos recommendation is not present");
    }

    @And("user see description recomendation kos {string}")
    public void user_see_description_recomendation_kos(String text) {
        Assert.assertEquals(kostDetail.getRecommendationKosLabel(), text, "Recommendation kos label in detail is not equals!");
    }

    @And("user want to explore kost recomendation section")
    public void user_click_on_next_button_and_display_next_recommendation_kos() {
        kostDetail.clickOnArrowRecommendationNextButton();
        Assert.assertFalse(kostDetail.isFirstKostCardRecommendationPresent(), "First Kost Card still display");
        kostDetail.clickOnArrowRecommendationPreviousButton();
        Assert.assertFalse(kostDetail.isNextRecommendationElementPresent(), "Next Kost Card still display");
        this.kostDetail = kostDetail.clickOnSeeAllRecommendation();
    }

    @And("user see listing kos recommendation arround kos with detail {string} and filter by mix gender")
    public void user_clicks_on_previous_button_and_display_first_page_recomendation_kos(String text) {
        Assert.assertTrue(kostDetail.getRecommendationKosList().contains(text), "Recomendation Title in list is not equals!");
        Assert.assertTrue(kostDetail.isMixGenderDisplay(), "Mixed Gender is not display");
    }

    //------------ Right Panel Section -----------------
    @Then("user sees total price property")
    public void user_sees_total_price_property() {
        kostDetail.dismissFTUE();
        Assert.assertTrue(kostDetail.isTotalPricePresent(), "Total Price is not present!");
    }

    @When("user sees form booking date")
    public void user_sees_form_booking_date() {
        Assert.assertTrue(kostDetail.isFormBookingDatePresent(), "Form booking date is not present!");
        kostDetail.clickOnBookingDate();
    }

    @Then("user validates description {string}")
    public void user_validates_description(String desc) {
        Assert.assertEquals(kostDetail.getDescBookingDateText(desc).toLowerCase(), desc.toLowerCase(), "Description is not equal / present!");
    }

    @And("user sees date and alert message {string}")
    public void user_sees_alert_message(String alert) {
        Assert.assertTrue(kostDetail.isDateBookingPresent(), "Date Booking is not present!");
        Assert.assertTrue(kostDetail.isAlertBookingDateTextPresent(alert), "Alert is not equal / present!");
        kostDetail.clickOnBookingDate();
    }

    @When("user sees form booking duration")
    public void user_sees_form_booking_duration() {
        Assert.assertTrue(kostDetail.isFormBookingDurationPresent(), "Booking duration form is not present!");
    }

    @And("user select date {string} and rent type {string}")
    public void user_select_date_and_rent_type(String time, String rentType) throws ParseException {
        String dateTime = "";
        if (time.equalsIgnoreCase("tomorrow")) {
            dateTime = java.updateTimeLocal("yyyy MMM dd", java.getTimeStamp("yyy MMM dd"), "d", "en", 0, 1, 0, 0, 0);
        }
        kostDetail.selectDateForStartBoarding(dateTime);
        kostDetail.selectRentType(rentType);
    }

    @And("user sees booking button")
    public void user_sees_booking_button() {
        Assert.assertTrue(kostDetail.isBookingButtonPresent(), "Booking button is not present!");
    }

    // ---------- Kost Badge(Apik, SinggahSini) ---------------------
    @Then("user can see apik badge kos")
    public void user_can_see_apik_badge_kos() {
        Assert.assertTrue(kostDetail.isApikBadgePresent(), "Apik Badge is not displayed");
    }

    @Then("user can see singgahsini badge kos")
    public void userCanSeeSinggahsiniBadgeKos() {
        Assert.assertTrue(kostDetail.isSinggahsiniBadgePresent(), "Singgahsini Badge is not displayed");
    }

    @Then("user reached owner badges section")
    public void i_should_reached_owner_badges_section() {
        kostDetail.dismissFTUE();
        Assert.assertTrue(kostDetail.ownerBadgesSectionAsPresent(), "owner section is not displayed");
        Assert.assertTrue(kostDetail.isOwnerStatement(), "Owner Statement is not displayed");
        Assert.assertTrue(kostDetail.isOwnerNameDisplayed(), "Owner name is not displayed");
        Assert.assertTrue(kostDetail.isOwnerPictureDisplayed(), "Owner Picture is not displayed");
        Assert.assertTrue(kostDetail.isNumberTransactionDisplayed(), "Number of transaction is not displayed");
    }

    // ----------------Kost Benefit---------------------
    @Then("user see benefit title, benefit description")
    public void userSeeBenefitTitleBenefitDescription() {
        kostDetail.dismissFTUE();
        Assert.assertTrue(kostDetail.isBenefitTitlePresent(), "Title Of Kos Benefit is not displayed");
        Assert.assertTrue(kostDetail.isBenefitDescPresent(), "Description of Kos Benefit is not displayed");
    }

    // ------------ Kost Review Section -----------
    @Then("user see review kos detail page section")
    public void userSeeReviewKosDetailPageSection() {
        kostDetail.dismissFTUE();
        kostDetail.scrollToReviewSection();
        Assert.assertTrue(kostDetail.isReviewOverviewDisplayed(), "Review Overview is not displayed");
        Assert.assertTrue(kostDetail.isReviewCategoryDisplayed(), "Review Category is not displayed");
        Assert.assertTrue(kostDetail.isUserReviewDisplayed(), "User Review is not displayed");
    }

    @And("user want to see all review")
    public void userClickOnSeeAllReview() {
        kostDetail.clickSeeAllReviewBtn();
        Assert.assertTrue(kostDetail.isOverviewReviewModalDisplayed(), "Review Overview in Modal is not displayed");
        Assert.assertTrue(kostDetail.isReviewCategoryModalDisplayed(), "Review Category in Modal is not displayed");
        Assert.assertTrue(kostDetail.isSortingReviewDisplayed(), "Sorting Review in Modal is not displayed");
        Assert.assertTrue(kostDetail.isUserReviewModalDisplayed(), "User Review in Modal is not displayed");
        kostDetail.closeAllReviewModal();
    }

    //------------ Favorite kost section ----------------
    @Then("user can favorite the kost")
    public void userCanFavoriteTheKost() {
        kostDetail.dismissFTUE();
        kostDetail.clickOnFavoriteKostButton();
        Assert.assertTrue(kostDetail.isSuccessFavoriteKostDisplayed(), "Success Favorite Pop up is not displayed");
    }

    @Then("user can unfavorite the kost")
    public void userCanUnfavoriteTheKost() {
        kostDetail.dismissFTUE();
        kostDetail.clickOnUnfavoriteKostButton();
        Assert.assertTrue(kostDetail.isSuccessUnfavoriteKostDisplayed(), "Success Unfavorite Pop up is not displayed");
    }

    @Then("Non login user cannot favorite the kost")
    public void nonLoginUserCannotFavoriteTheKost() {
        kostDetail.dismissFTUE();
        kostDetail.clickOnFavoriteKostButton();
        Assert.assertTrue(kostDetail.isLoginPopUpDisplayed(), "Login Pop up is not displayed");
    }

    @Then("user can share the kost")
    public void userCanShareTheKost() {
        kostDetail.dismissFTUE();
        kostDetail.clickOnShareKostButton();
    }
}
