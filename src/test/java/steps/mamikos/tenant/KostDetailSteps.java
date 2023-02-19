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
import utilities.PlaywrightHelpers;

public class KostDetailSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);

    HomePO home = new HomePO(page);
    SearchPO search = new SearchPO(page);
    KostDetailsPO kostDetail = new KostDetailsPO(page);

    @When("user want to search kost from homepage")
    public void userSearchAndSelectKost(DataTable table) {
        var kostNameData = table.asMaps(String.class, String.class);
        var kostName = kostNameData.get(0).get("kost " + Mamikos.ENV);
        search.searchKostFromHomePage(kostName);
    }

    @Then("user can see overview section on detail page")
    public void userCanSeeOverViewSection(DataTable table) {
        var kostNameData = table.asMaps(String.class, String.class);
        var kostName = kostNameData.get(0).get("kost " + Mamikos.ENV);
//        kostDetail.dismissFTUE();
        Assert.assertTrue(kostDetail.getKostTitle().contains(kostName));
        Assert.assertTrue(kostDetail.isPropertyGenderDisplayed(), "Property Gender Label is not displayed");
        Assert.assertTrue(kostDetail.isPropertyLocationDisplayed(), "Property Location Label is not displayed");
        Assert.assertTrue(kostDetail.isRoomAvailabilityDisplayed(), "Property Room AvailabilityLabel is not displayed");
    }

    @When("user want to select kost on promo section")
    public void userSelectKostOnPromoSection() {
        this.kostDetail = home.selectKostOnPromoSection(true);
    }

    @When("user want to select kost on promo section with non login condition")
    public void userSelectKostOnPromoSectionNonLogin() {
        this.kostDetail = home.selectKostOnPromoSection(false);
    }

    @Then("user see promo owner section")
    public void userSeePromoOwnerSection() {
        playwright.pageScrollToDown(200);
        Assert.assertTrue(kostDetail.isPromoOwnerSectionDisplayed(), "Promo Owner Section is not displayed");
    }

    @When("user want to get more information about kost promo")
    public void userWantToseeMoreAboutKostPromo() {
        kostDetail.clickOnButtonPromoOwner();
        kostDetail.clickOnTanyaPemilikKost();
    }

    @Then("user will get {string} pop up")
    public void hubungiKostPopUp(String popUpMsg) {
        playwright.pageScrollToDown(200);
        Assert.assertTrue(kostDetail.isChatKostPopUpDisplayed(), "Pop Up Hubungi Kos Ini Section is not displayed");
        Assert.assertTrue(kostDetail.hubungiKostHeadingText().contains(popUpMsg));
    }

    @Then("user will see login pop up")
    public void loginPopUp() {
        playwright.pageScrollToDown(200);
        Assert.assertFalse(kostDetail.isChatKostPopUpDisplayed(), "Pop Up Hubungi Kos Ini Section is displayed");
        Assert.assertTrue(kostDetail.isLoginPopUpDisplayed(), "Login Pop up is not displayed");
    }

    @And("user want to see more detail room facility section on the kost detail page")
    public void userWantToSeeRoomFacilty() {
        playwright.pageScrollToDown(200);
        kostDetail.clickFacilityRoomSeeAll();
    }

    @Then("user see all facility room section")
    public void userSeeAllRoomFacility() {
        playwright.pageScrollToDown(200);
        Assert.assertTrue(kostDetail.isRoomFacilitiyPopUpDisplayed(), "Room Facility pop up is not displayed");
//        Assert.assertTrue(kostDetail.isRoomFacilitiyIconDisplayed(), "Room Facility icon is not displayed");
//        Assert.assertTrue(kostDetail.isRoomFacilitiyNameDisplayed(), "Room Facility name is not displayed");
    }

    @Then("user can see facility bath section on detail page")
    public void userCanSeeFacilityBathSection() {
        playwright.pageScrollToDown(200);
        Assert.assertTrue(kostDetail.isFacBathShow(), "Bathroom Facility section is not displayed");
//        Assert.assertTrue(kostDetail.isBathFacilitiyIconDisplayed(), "Bathroom Facility icon is not displayed");
//        Assert.assertTrue(kostDetail.isBathFacilitiyNameDisplayed(), "Bathroom Facility name is not displayed");
    }

    @Then("user can see facility notes on detail kos and button is not present")
    public void userCanSeeFacilityNotesOnDetailKosBtnNotPresent() {
        playwright.pageScrollToDown(200);
        Assert.assertTrue(kostDetail.isFacilityNotesSectionDisplayed(), "Facility Notes section is not displayed");
        Assert.assertTrue(kostDetail.isFacilityNotesDescDisplayed(), "Facility Notes Description is not displayed");
        Assert.assertFalse(kostDetail.isExpandFacNotesDisplayed(), "Facility Notes expand button is displayed");
    }

    @Then("user can see facility notes on detail kos and button is present")
    public void userCanSeeFacilityNotesOnDetailKosBtnPresent() {
        playwright.pageScrollToDown(200);
        Assert.assertTrue(kostDetail.isFacilityNotesSectionDisplayed(), "Facility Notes section is not displayed");
        Assert.assertTrue(kostDetail.isFacilityNotesDescDisplayed(), "Facility Notes Description is not displayed");
        Assert.assertTrue(kostDetail.isExpandFacNotesDisplayed(), "Facility Notes expand button is not displayed");
        kostDetail.clickOnExpandFacNotes();
    }

    @Then("user can see owner story on detail kos and button is not present")
    public void userCanSeeOwnerStoryOnDetailKos() {
        playwright.pageScrollToDown(200);
        Assert.assertTrue(kostDetail.isOwnerStorySectionDisplayed(), "Owner Story section is not displayed");
        Assert.assertTrue(kostDetail.isOwnerStoryDescDisplayed(), "Owner Story description is not displayed");
        Assert.assertFalse(kostDetail.isExpandOwnerStoryDisplayed(), "Owner Story expand button section is displayed");
    }

    @Then("user can see owner story on detail kos and button is present")
    public void userCanSeeOwnerStoryOnDetailKosBtnIsPresent() {
        playwright.pageScrollToDown(200);
        Assert.assertTrue(kostDetail.isOwnerStorySectionDisplayed(), "Owner Story section is not displayed");
        Assert.assertTrue(kostDetail.isOwnerStoryDescDisplayed(), "Owner Story description is not displayed");
        Assert.assertTrue(kostDetail.isExpandOwnerStoryDisplayed(), "Owner Story expand button section is displayed");
        kostDetail.clickOnExpandOwnerStory();
    }

    @Then("user can see facility share section on detail page")
    public void userSeeAllFacility() {
        playwright.pageScrollToDown(200);
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

    @Then("user can see facility parking section on detail page")
    public void user_can_see_facility_parking_section_on_detail_page() {
        playwright.pageScrollToDown(200);
        Assert.assertTrue(kostDetail.isFacParkingDisplayed(), "Facility Parking Section is not displayed");
        Assert.assertTrue(kostDetail.isFacParkingTitleDisplayed(), "Facility Parking Title Section is not displayed");
    }

    @Then("user can see kos rule list on detail kos")
    public void user_can_see_kos_rule_list_on_detail_kos() {
        playwright.pageScrollToDown(200);
        Assert.assertTrue(kostDetail.isKosRulePresent(), "Kos rule is not present!");
        Assert.assertTrue(kostDetail.isKosRuleButtonShow(), "Kos Rule Button is not displayed");
        Assert.assertTrue(kostDetail.isKosRuleImagePresent(), "Kos rule image is not present!");
    }

    @Then("user want to reached map section and see lihat peta button")
    public void userCanSeeLihatPetaBtn() {
        playwright.pageScrollToDown(200);
        Assert.assertTrue(kostDetail.isStaticMapPresent(), "Kost current position is not present!");
        Assert.assertTrue(kostDetail.isLihatPetaButtonPresent(), "Lihat Peta Button is not present!");
        Assert.assertTrue(kostDetail.isPOILandmarkShow(), "POI Landmark is not displayed");
    }

    @When("user want to see more detail kost location")
    public void seeKostMapBtn() {
        kostDetail.clickOnSeeMapButton();
    }

    @Then("user want to reached map section and see tanya alamat lengkap button")
    public void userCanSeeAlamatLengkapPetaBtn() {
        playwright.pageScrollToDown(200);
        Assert.assertTrue(kostDetail.isKostCurrentLocationPresent(), "Kost current position is not present!");
        Assert.assertTrue(kostDetail.isTanyaAlamatBtnPresent(), "Tanya Alamat Button is not present!");
        Assert.assertTrue(kostDetail.isPOILandmarkShow(), "POI Landmark is not displayed");
    }

    @When("user want to ask kost address")
    public void userAskAdreess() {
        kostDetail.clickOnTanyaAlamatBtn();
    }

    @Then("chat room appear with latest message")
    public void msgChatRoom() {
        Assert.assertTrue(kostDetail.isChatRoomPresent(), "Chat room is not present!");
//        var message = "Kos DC BAR Automation Tipe A beralamat di: ";
//        Assert.assertTrue(kostDetail.getLatestChatText().trim().replaceAll("\\s", "")
//                .contains(message.replaceAll("\\s", "")), "Kos address in title is wrong");
    }
}
