package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.LoadingPO;
import pageobject.owner.OwnerDashboardPO;
import pageobject.owner.goldplus.GoldplusPO;
import pageobject.owner.kelolatagihan.PengajuanSewaPO;
import utilities.PlaywrightHelpers;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertTrue;

public class OwnerDashboardSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    OwnerDashboardPO ownerDashboardPO = new OwnerDashboardPO(page);
    OwnerDashboardPO ownerDashboardGP = new OwnerDashboardPO(page);
    GoldplusPO goldplus = new GoldplusPO(page);
    PengajuanSewaPO PengajuanSewaPO = new PengajuanSewaPO(page);
    LoadingPO loading = new LoadingPO(page);

    private List<Map<String, String>> ownerDashboard;

    @When("Check if the button with label {string} is visible on the {string} page.")
    public void check_if_button_with_label_is_visible_on_the_page(String button, String page) {
        Assert.assertTrue(playwright.isButtonWithTextDisplayed(button));
    }

    @When("user clicks on the close button")
    public void user_clicks_on_close_button() {
        ownerDashboardPO.clickOnButtonIconClose();
    }

    @And("user click on widget Penyewa")
    public void userClickOnWidgetPenyewa() {

    }

    @When("user click mamipoin in owner's menu")
    public void user_click_mamipoin_in_owner_s_menu() {
        ownerDashboardPO.clickMamipoinButton();
    }

    @Then("owner can see pengajuan sewa detail on dashboard")
    public void ownerCanSeePengajuanSewaDetailOnDashboard() {
        Assert.assertTrue(ownerDashboardPO.isPengajuanSewaSectionPresent(), "pengajuan sewa not appears");
    }

    @When("owner open notification icon")
    public void owner_open_notification_icon() {
        ownerDashboardPO.clickNotificationButton();
    }

    @And("owner wants to see all notification")
    public void owner_wants_to_see_all_notification() {
        ownerDashboardPO.clicOnSeeAllNotification();
    }

    @Then("validate that owner have {string}")
    public void validate_that_owner_have(String gpStatus) {
        Assert.assertEquals(ownerDashboardPO.getTextGPStatus(), gpStatus, "GP Level is not equal to ");
    }

    @When("owner click close icon pop up")
    public void ownerClickCloseIconPopUp() {
        playwright.clickOnTextButton("close");
    }

    @Then("user verify text {string} on section info untuk anda is appear")
    public void user_verify_text_on_section_info_untuk_anda_is_appear(String textInfoUntukAnda) {
        playwright.clickOnText(textInfoUntukAnda);
    }

    @And("user click menu {string} on feature waktunya mengelola property")
    public void userClickOnFeatureWaktunyaMengelolaProperty(String menu) {
        ownerDashboardPO.clickOnMenuKelolaProperty(menu);
    }

    @When("verify ftue {string}")
    public void verify_ftue(String isDisplayed) {
        if (isDisplayed.equals("displayed")) {
            Assert.assertTrue(ownerDashboardPO.isFTUEChatDisplayed(), "FTUE doesn't displayed!");
        } else {
            Assert.assertFalse(ownerDashboardPO.isFTUEChatDisplayed(), "FTUE displayed!");
        }

    }

    @When("verify title ftue is {string} and description {string}")
    public void verify_title_ftue_is_and_description(String titleFtue, String descFtue) {
        Assert.assertEquals(ownerDashboardPO.getTitleFtue(titleFtue), titleFtue, "Title FTUE doesn't match!");
        Assert.assertEquals(ownerDashboardPO.getDescFtue(descFtue), descFtue, "Description FTUE doesn't match!");
    }

    @When("user click close icon tooltip broadcast chat on chatlist")
    public void user_click_close_icon_tooltip_broadcast_chat_on_chatlist() throws InterruptedException {
        ownerDashboardPO.clickOnCloseIconBcTooltip();
    }

    @Then("verify label goldplus on chatlist")
    public void verify_label_goldplus_on_chatlist() {
        Assert.assertTrue(ownerDashboardPO.isGoldplusLabelDisplayed(), "Owner doesn't goldplus member!");
    }

    @Then("check the header menu display on homepage owner")
    public void check_the_header_menu_display_on_homepage_owner() {
        loading.waitForLoadingIconDisappear();
        Assert.assertTrue(ownerDashboardPO.isHelpCenterOwnerDisplayed(), "Element Pusat Bantuan not present!");
        Assert.assertTrue(ownerDashboardPO.isNotificationOwnerButtonDisplayed(), "Element Notifikasi Button not present!");
    }

    @Then("user see username in top right shows as {string}")
    public void user_see_username_in_top_right_shows_as(String name) {
        Assert.assertEquals(ownerDashboardPO.getOwnerUsername(), name, "Username label is wrong");
    }

    @When("user click mamikos.com logo")
    public void userClickMamikosComLogo() {
        ownerDashboardPO.clickOnMamikosLogo();
    }

    @And("user click booking kos button")
    public void userClickBookingKosButton() {
        ownerDashboardPO.clickOnBookingKos();
    }

    @And("user click promosi iklan anda button")
    public void userClickPromosiIklanAndaButton() {
        ownerDashboardPO.clickOnPromosiIklanAnda();
    }

    @And("user clicks pusat bantuan on nav bar owner")
    public void userClicksPusatBantuanOnNavBarOwner() {
        ownerDashboardPO.clickOnPusatBantuan();
    }

    @Then("user will be verify dropdown in property saya")
    public void user_will_be_verify_dropdown_in_property_saya() {
        Assert.assertTrue(ownerDashboardPO.isPropertyMenuDropdownShowing(), "Dropdown is not showing");
    }

    @When("user click profile on header")
    public void user_click_profile_on_header() {
        ownerDashboardPO.clickOnOwnerProfile();
    }

    @Then("user see dropdown with button owner page and exit")
    public void user_see_dropdown_with_button_owner_page_and_exit() {
        Assert.assertTrue(ownerDashboardPO.isOwnerPageDisplayed(), "Owner page menu is missing");
        Assert.assertTrue(ownerDashboardPO.isExitButtonDisplayed(), "Exit menu is missing");
    }

    @When("user click owner page button")
    public void user_click_owner_page_button() {
        ownerDashboardPO.clickOnOwnerPage();
    }

    @When("user click Chat CS button")
    public void user_click_Chat_CS_button() {
        ownerDashboardPO.clickOnChatCS();
    }

    @Then("user see Contact us pop up is appear")
    public void user_see_Contact_us_pop_up_is_appear() {
        Assert.assertTrue(ownerDashboardPO.isContactUsPresent(), "Contact CS pop up is not appear");
    }

    @Then("user see user's name {string} in owner dashboard")
    public void user_see_user_s_name_in_owner_dashboard(String userName) {
        Assert.assertEquals(ownerDashboardPO.getUserGreeting().trim(), userName, "Username greeting is wrong");
    }

    @When("user click username in owner dashboard")
    public void user_click_username_in_owner_dashboard() {
        ownerDashboardPO.clickUserGreeting();
    }

    @When("user click owner username on header")
    public void user_click_owner_username_on_header() {
        ownerDashboardPO.clickOwnerUserName();
    }

    @Then("user see owner's name & phone number, text link {string} & {string}")
    public void user_see_owner_s_name_phone_number_text_link(String settings, String logout) {
        Assert.assertEquals(ownerDashboardPO.getSettingsLabel(), settings, "Settings label is wrong");
        Assert.assertEquals(ownerDashboardPO.getLogoutLabel(), logout, "Logout label is wrong");
    }

    @And("user see widget waktunya mengelola properti is as expected")
    public void user_see_widget_waktunya_mengelola_properti_is_as_expected(DataTable dataTable) {
        List<Map<String, String>> table = dataTable.asMaps();
        int i = 2;
        for (Map<String, String> content : table) {
            Assert.assertEquals(ownerDashboardPO.widgetWaktunyaMengelolaProperti("title", i), content.get("title"), "title not equal to " + content.get("title"));
            Assert.assertEquals(ownerDashboardPO.widgetWaktunyaMengelolaProperti("subtitle", i), content.get("subtitle"), "subtitle not equal to" + content.get("subtitle"));
            i++;
        }
    }

    @And("user click on rating card details")
    public void user_click_on_rating_card_details() {
        ownerDashboardPO.clickOnRatingCardDetails();
    }

    @Then("user validate review section with {string}")
    public void user_validate(String noReview) {
        Assert.assertTrue(ownerDashboardPO.isTextOnReviewListPresent(noReview), "Message is not equal to " + noReview);
    }

    @Then("user verify there are only {int} review lists")
    public void user_verify_there_are_only_review_lists(Integer number) {
        Assert.assertEquals(ownerDashboardPO.getReviewListsCard(), number, "Kos review list should have " + number + " items");
    }

    @When("user click one of review lists")
    public void user_click_one_of_review_lists() {
        ownerDashboardPO.clickOnKosReviewListing();
    }

    @Then("user should see the review detail page")
    public void user_should_see_the_review_detail_page() {
        Assert.assertTrue(ownerDashboardPO.isDetailedReviewListsAppear(), "Detailed kos review lists is not appear");
    }

    @Then("user verify there are more than {int} review lists")
    public void user_verify_there_are_more_than_int_review_lists(int number) {
        Assert.assertTrue(ownerDashboardPO.getRatingCardWrapperSize() > number, "Kost review lists are not more than " + number);
    }

    @And("user verify there is no kos review section")
    public void user_verify_there_is_no_kos_review_section() {
        Assert.assertFalse(ownerDashboardPO.isSeeAllKostReviewTextAppear(), "See all kost review text is appeared");
    }

    @Then("user verify title {string} and message {string} in saldo MamiAds")
    public void user_verify_message_x_in_saldo_mamiads(String titleText, String subtitle) {
        Assert.assertEquals(ownerDashboardPO.getLihatDisiniMamiads(), titleText, "The text is not equal to " + titleText);
        Assert.assertEquals(ownerDashboardPO.getSubtitleMamiads(), subtitle, "The text is not equal to " + subtitle);
    }

    @When("user click on Saldo MamiAds at owner dashboard")
    public void user_click_on_saldo_mamiads_button() {
        ownerDashboardPO.clickSaldoMamiAdsButton();
    }

    @And("owner click {string} on waktunya mengelola properti")
    public void ownerClickOnWaktunyaMengelolaProperti(String action) {
        ownerDashboardPO.clickOnWaktunyaMengelolaProperti(action);
    }

    @Then("verify that owner not yet have active kos")
    public void verifyThatOwnerNotYetHaveActiveKos() {
        Assert.assertTrue(ownerDashboardPO.isNoHaveActiveKos(), "Owner have active kos!");
    }

    @When("owner create new kos")
    public void ownerCreateNewKos() {
        ownerDashboardPO.clickOnTambahKos();
        ownerDashboardPO.clickOnTambahKosBaru();
    }

    @And("verify tambah kos button displayed")
    public void verifyTambahKosButtonDisplayed() {
        Assert.assertTrue(ownerDashboardPO.isTambahKosVisible());
    }

    @When("owner accsess cek properti sekitar")
    public void owner_accsess_cek_properti_sekitar() {
        ownerDashboardPO.clickToExpandFiturPromosi();
        ownerDashboardPO.clickOnPropertySekitar();
    }

    @And("owner select kos {string}")
    public void owner_select_kos(String kosName) {
        ownerDashboardPO.clickOnDropdownKosName();
        playwright.clickOnText(kosName);
    }

    @And("owner click on toggle entry time kos")
    public void owner_click_on_toggle_entry_time_kos() {
        ownerDashboardPO.clickOnToggleEntryTime();
    }

    @And("owner edit Jarak waktu terdekat:")
    public void owner_edit_jarak_waktu_terdekat(DataTable tables) {
        ownerDashboard = tables.asMaps(String.class, String.class);
        String amount = ownerDashboard.get(0).get("Jumlah");
        String unitTime = ownerDashboard.get(0).get("Satuan Waktu");
        ownerDashboardPO.fillNearestAmountTime(amount, unitTime);
    }

    @Then("widget daftar GP is not appears")
    public void widget_daftar_gp_is_not_appears() {
       Assert.assertFalse(goldplus.isWidgetGPAppear(),"widget GP is appear");
    }

    @Then("owner see info untuk anda section GP {string} appears")
    public void info_untuk_anda_section_gp_appears(String infoUntukAnda) {
       Assert.assertTrue(goldplus.isInfoUntukAndaAppear(infoUntukAnda),"info untuk anda section GP is not appear");
    }

    @Then("info untuk anda section GP {string} is not appears")
    public void info_untuk_anda_section_gp_is_not_appears(String infoUntukAnda) {
        Assert.assertFalse(goldplus.isInfoUntukAndaIsNotAppear(infoUntukAnda),"info untuk anda section GP is appear");
    }

    @And("user access mamitour from owner dashboard")
    public void user_access_mamitour_from_owner_dashboard() {
        ownerDashboardPO.clickMamitourOnDashboard();
    }

    @And("user access mamitour from fitur promosi")
    public void user_access_mamitour_from_fitur_promosi() {
        ownerDashboardPO.clickToExpandFiturPromosi();
        ownerDashboardPO.clickMamitourOnSidebar();
    }

    @Then("user see screen {string}")
    public void user_see_screen(String expectedPage) {
        Assert.assertEquals(ownerDashboardPO.getPageHeader(), expectedPage, "Page header doesn't match!");
    }

    @Then("user can see manage booking pop up")
    public void user_can_see_manage_booking_pop_up() {
        assertTrue(ownerDashboardPO.isTotalNotBookingPopupPresent(), "not appear manage direct booking popup");
        ownerDashboardPO.clickOnCloseOnPopupTotalNotBooking();
    }

    @And("user click menu Penyewa on feature waktunya mengelola property")
    public void user_click_menu_penyewa_on_feature_waktunya_mengelola_property() {
        ownerDashboardPO.clickOnPenyewaWaktunyaMengelolaProperti();
    }

    @And("user click menu Pusat Bantuan on feature waktunya mengelola property")
    public void user_click_menu_pusat_bantuan_on_feature_waktunya_mengelola_property() {
        ownerDashboardPO.clickOnPusatBantuanWaktunyaMengelolaProperti();
    }

    @And("owner click ubah peraturan at {string}")
    public void ownerClickUbahPeraturanAtDashboard(String text) {
        if (text.equalsIgnoreCase("dashboard")){
          ownerDashboardPO.clickUbahPeraturanButton();
      }
        else if (text.equalsIgnoreCase("pengajuan sewa")){
            PengajuanSewaPO.clickUbahAturanButton();
        }
    }

    @And("owner go to event banner section")
    public void onwerGoToEventBannerSection() {
        ownerDashboardPO.scrollIntoDariMamikosSection();
        ownerDashboardGP.dismissFTUEGoldplus();
    }

    @And("owner click on banner on dari mamikos section")
    public void ownerClickOnBannerOnDariMamikosSection() {
        ownerDashboardPO.clickOnBannerDariMamikosSection();
    }

    @And("widget daftar goldplus is displayed")
    public void widget_daftar_goldplus_is_displayed(){
        ownerDashboardPO.isWidgetDaftarGoldplusDisplayed();
    }

    @And("user click daftar GP button")
    public void userClickDaftarGPButton() {
        loading.waitForLoadingIconDisappear();
        ownerDashboardPO.clickOnDaftarGP();
    }

    @Then("owner should have menu {string}")
    public void owner_should_have_menu(String menu) {
        if (ownerDashboardPO.isMamiprimeBannerAppear()){
            ownerDashboardPO.closeMamiprimeBanner();
        }
        if (menu.equalsIgnoreCase("Leads")){
            Assert.assertTrue(ownerDashboardPO.isLeadsMenuVisible());
        }
    }
    @When("owner click leads menu")
    public void owner_click_leads_menu() {
        ownerDashboardPO.clickLeadsMenu();
    }

    @When("user click {string} on ftue")
    public void userClickOnFtue(String buttonText) {
        ownerDashboardPO.clickOnButtonFTUE(buttonText);
    }

    @And("user click on mamiprime widget at owner dashboard")
    public void user_click_on_mamiprime_widget_at_owner_dashboard() {
        ownerDashboardPO.clickMamiprimeWidget();
    }

    @And("owner wants to paid invoice recurring from recurring pop up")
    public void ownerWantsToPaidInvoiceRecurringFromRecurringPopUp() {
        ownerDashboardPO.clickOnPerpanjangGoldPlusPopUp();
    }

    @When("owner dismiss active pop-ups")
    public void ownerDismissActivePopUps() {
        ownerDashboardPO.clicksOnCloseIconDialogOwnerPopUp();
    }

    @When("owner click on expose singgahsini link")
    public void ownerClickOnExposeSinggahsiniLink() {
        ownerDashboardPO.clickOnInginKosDikelolaLink();
    }

    @Then("owner should see expose singgahini link")
    public void ownerShouldSeeExposeSinggahsiniLink() {
        Assert.assertTrue(ownerDashboardPO.isInginKosDikelolaLinkVisible(), "expose singgahsjini link is not visible");
    }

    @Then("owner can not see expose singgahsini link")
    public void ownerCanNotSeeExposeSinggahsiniLink(){
        Assert.assertFalse(ownerDashboardPO.isInginKosDikelolaLinkVisible(), "expose singgahsini link is visible");
    }

    @When("owner dismiss pop-up if appears")
    public void ownerDismissPopUpIfAppears() {
        ownerDashboardPO.dismissPopUp();
    }

    @Then("owner can see onboarding card on owner dashboard")
    public void ownerCanSeeOnboardingCardOnOwnerDashboard() {
        Assert.assertTrue(ownerDashboardPO.isOnboardingCardVisible(), "Onboarding card is not visible");
    }

    @Then("owner can see onboarding title {string}")
    public void ownerCanSeeOnboardingTitle(String expectedTitle) {
        Assert.assertEquals(ownerDashboardPO.getOnboardingTitle(), expectedTitle, "Onboarding title doesn't match");
    }

    @Then("owner can see onboarding description {string}")
    public void ownerCanSeeOnboardingDescription(String expectedDescription) {
        Assert.assertTrue(ownerDashboardPO.getOnboardingDescription().contains(expectedDescription), "Onboarding description doesn't contain expected text");
    }

    @Then("owner cannot see onboarding card on owner dashboard")
    public void ownerCannotSeeOnboardingCardOnOwnerDashboard() {
        Assert.assertTrue(ownerDashboardPO.isOnboardingCardNotVisible(), "Onboarding card should not be visible but it is");
    }
}

