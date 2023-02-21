package steps.mamikos.tenant;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.datatable.DataTable;
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
}
