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
    }
}
