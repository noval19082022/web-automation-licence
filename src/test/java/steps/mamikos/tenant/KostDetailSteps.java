package steps.mamikos.tenant;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.KostDetailsPO;
import pageobject.common.SearchPO;

public class KostDetailSteps {
    Page page = ActiveContext.getActivePage();

    SearchPO search = new SearchPO(page);
    KostDetailsPO kostDetail = new KostDetailsPO(page);

    @When("user search property by name and select the matching result to go to kos details page")
    public void userSearchAndSelectKost(DataTable table) {
        var kostNameData = table.asMaps(String.class, String.class);
        var kostName = kostNameData.get(0).get("kost "+ Mamikos.ENV);
        search.searchKostFromHomePage(kostName);
    }

    @Then("user can see overview section on detail page")
    public void userCanSeeOverViewSection(DataTable table) {
        var kostNameData = table.asMaps(String.class, String.class);
        var kostName = kostNameData.get(0).get("kost "+ Mamikos.ENV);
        Assert.assertTrue(kostDetail.getKostTitle().contains(kostName));
        kostDetail.dismissFTUE();
        Assert.assertTrue(kostDetail.isPropertyGenderDisplayed(),"Property Gender Label is not displayed");
        Assert.assertTrue(kostDetail.isPropertyLocationDisplayed(),"Property Location Label is not displayed");
        Assert.assertTrue(kostDetail.isRoomAvailabilityDisplayed(),"Property Room AvailabilityLabel is not displayed");
    }
}
