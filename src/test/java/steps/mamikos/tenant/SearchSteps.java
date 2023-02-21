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

import java.util.Map;

public class SearchSteps {
    Page page = ActiveContext.getActivePage();
    HomePO homePO = new HomePO(page);
    KostDetailsPO kostDetail = new KostDetailsPO(page);
    SearchPO search = new SearchPO(page);
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    private Map<String, String> cityName;
    HomePO home = new HomePO(page);
    SearchPO searchPO;

    @When("user search keyword:")
    public void userSearchKeyword(DataTable table) {
        var kostNameData = table.asMaps(String.class, String.class);
        var searchAreaa = kostNameData.get(0).get("search " + Mamikos.ENV);
        search.searchAreaByName(searchAreaa);
    }

    @Then("navbar before login appears")
    public void navbarBeforeLoginAppears() {
        Assert.assertTrue(home.isBookingKosDisplayed(), "Booking Kos button not present!");
        Assert.assertTrue(home.isDownloadAppDisplayed(), "Download App button not present!");
        Assert.assertTrue(home.isSearchAdsDisplayed(), "Cari Iklan button not present!");
        Assert.assertTrue(home.isHelpCenterDisplayed(), "Pusat Bantuan button not present!");
        Assert.assertTrue(home.isTermConditionDisplayed(), "Syarat Ketentuan button not present!");
        Assert.assertTrue(home.isPromosiAdsDisplayed(), "Promosi Iklan button not present!");
        Assert.assertTrue(home.isEnterButtonDisplayed(), "Enter button not present!");
    }

    @When("user search property name and select matching result to go kos detail")
    public void user_search_property_name_and_select_matching_result_to_go_kos_detail(DataTable table) {
        var kostNameData = table.asMaps(String.class, String.class);
        var kostName = kostNameData.get(0).get("favorite " + Mamikos.ENV);
        searchPO = homePO.clickOnSearchButton();
        kostDetail = searchPO.searchByText(kostName);
    }

    @Then("user in kost detail navbar before login appears")
    public void userInKostDetailNavbarBeforeLoginAppears() throws InterruptedException {

        Assert.assertTrue(home.isBookingKosDisplayed(), "Booking Kos button not present!");
        Assert.assertTrue(home.isDownloadAppDisplayed(), "Download App button not present!");
        Assert.assertTrue(home.isSearchAdsDisplayed(), "Cari Iklan button not present!");
        Assert.assertTrue(home.isHelpCenterDisplayed(), "Pusat Bantuan button not present!");
        Assert.assertTrue(home.isTermConditionDisplayed(), "Syarat Ketentuan button not present!");
        Assert.assertTrue(home.isPromosiAdsDisplayed(), "Promosi Iklan button not present!");
        Assert.assertTrue(home.isEnterButtonDisplayed(), "Enter button not present!");
        Assert.assertTrue(kostDetail.isInKosDetail(), "You are not in kos detail page");
    }

    @Then("navbar after login appears")
    public void navbarAfterLoginAppears() throws InterruptedException {
        Assert.assertTrue(home.isSearchIklanDisplayed(), "Cari Iklan button not present!");
        Assert.assertTrue(home.isFavoriteDisplayed(), "Favorite button not present!");
        Assert.assertTrue(home.isChatDisplayed(), "Chat button not present!");
        Assert.assertTrue(home.isNotificationButtonDisplayed(), "Notification button not present!");
        Assert.assertTrue(home.isOtherButtonDisplayed(), "Other button not present!");
        Assert.assertTrue(home.isTenantProfilePictureDisplayed(), "Profile pic not present!");
    }
}