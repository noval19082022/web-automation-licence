package steps.mamikos.tenant;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.HeaderPO;
import pageobject.common.HomePO;
import pageobject.common.KostDetailsPO;
import pageobject.common.SearchPO;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

import java.util.Map;

public class SearchSteps {
    Page page = ActiveContext.getActivePage();
    HomePO homePO = new HomePO(page);
    KostDetailsPO kostDetail = new KostDetailsPO(page);
    SearchPO search = new SearchPO(page);
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    private Map<String, String> cityName;
    HeaderPO header = new HeaderPO(page);

    @When("user search keyword:")
    public void userSearchKeyword(DataTable table) {
        var kostNameData = table.asMaps(String.class, String.class);
        var searchAreaa = kostNameData.get(0).get("search " + Mamikos.ENV);
        search.searchAreaByName(searchAreaa);
    }

    @Then("navbar before login appears")
    public void navbarBeforeLoginAppears() {
        Assert.assertTrue(header.isBookingKosDisplayed(), "Booking Kos button not present!");
        Assert.assertTrue(header.isDownloadAppDisplayed(), "Download App button not present!");
        Assert.assertTrue(header.isSearchAdsDisplayed(), "Cari Iklan button not present!");
        Assert.assertTrue(header.isHelpCenterDisplayed(), "Pusat Bantuan button not present!");
        Assert.assertTrue(header.isTermConditionDisplayed(), "Syarat Ketentuan button not present!");
        Assert.assertTrue(header.isPromosiAdsDisplayed(), "Promosi Iklan button not present!");
        Assert.assertTrue(header.isEnterButtonDisplayed(), "Enter button not present!");
    }

}
