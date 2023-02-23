package steps.mamikos.tenant;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import pageobject.common.HomePO;
import pageobject.common.KostDetailsPO;
import pageobject.common.SearchPO;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

import java.util.List;
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

    @When("user search for random keyword:")
    public void user_search_for_random_keyword(DataTable table) {
        var kostNameData = table.asMaps(String.class, String.class);
        var searchArea = kostNameData.get(0).get("search " + Mamikos.ENV);
        search.searchArea(searchArea);
    }

    @Then("should display the result list of keyword {string}")
    public void should_display_the_result_list_of_keyword(String semarang) {
        Assert.assertTrue(search.listResultKeyword(semarang), "not displayed area");
    }

    @Then("should display the result exception {string}")
    public void should_display_the_result_exception(String notfound) {
        Assert.assertTrue(search.setExeptionText(notfound), "is displayed Exeption Text");
    }

    @Then("user see searchbar is empty")
    public void user_see_searchbar_is_empty() {
        Assert.assertTrue(search.isSearchbarEmpty());
    }

    @Then("user click the search result based on area")
    public void user_click_the_search_result_based_on_area() {
        search.clickTheFirstResultBasedOnArea();
    }

    @Then("user click the search result based on name")
    public void user_click_the_search_result_based_on_name() {
        kostDetail.getKostTitle();
    }

    @When("user search property by name and select the matching result to go to kos details page")
    public void userSearchAndSelectKost(DataTable table) {
        var kostNameData = table.asMaps(String.class, String.class);
        var kostName = kostNameData.get(0).get("kost "+ Mamikos.ENV);
        search.suggetionKostOnTheSearchListNumberSix(kostName);
    }

    @When("user clicks Search")
    public void userClicksSearch() {
        search.clickSearchBar();
    }

    @Then("After user click City name, city name will expand and Area name listed below it.")
    public void after_user_click_city_name_city_name_will_expand_and_area_name_listed_below_it(DataTable table) throws InterruptedException {
        List<List<String>> listCity = table.asLists(String.class);
        for (int j=0; j<listCity.size(); j++) {
            search.userTapCity(listCity.get(0).get(j));
            for (int i=j+1; i<listCity.size(); i++) {
                Assert.assertTrue(search.checkElementbyText(listCity.get(i).get(j)), "City not appear in dropdown.");
            }
        }
    }

    @Then("under popular search, there's this city :")
    public void underPopularSearchThereSThisCity(DataTable table) {
        var cities = table.asMaps(String.class, String.class);
        for (Map<String, String> city : cities) {
            Assert.assertTrue(search.listPopularCity(city.get("city " + Mamikos.ENV)), city.get("city " + Mamikos.ENV) + " is not displayed");
        }
    }

    @Given("user navigates to ugm kost listing")
    public void userNavigatesToUgmKostListing() {
        playwright.navigateTo(Mamikos.URL + Mamikos.UGM_KOST_LIST, 30000.0, LoadState.LOAD);
    }

    @Then("user clicks the {string} button and the description will appears {string}")
    public void userClicksTheButtonAndTheDescriptionWillAppears(String filter, String text) throws InterruptedException {
        if(filter.equalsIgnoreCase("Promo Ngebut"))
        {
            search.clickPromoNgebutFilter();
            String desc = search.getPromoNgebutDescText().replaceAll("\\s", "");
            String expected = text.toLowerCase().replaceAll("\\s", "");
            Assert.assertTrue(desc.contains(expected), "Description Promo Ngebut text is wrong");
        }
        else if(filter.equalsIgnoreCase("Kos Andalan"))
        {
            search.clickKosAndalanFilter();
            String desc = search.getKosAndalanDescText().replaceAll("\\s", "");
            String expected = text.toLowerCase().replaceAll("\\s", "");
            Assert.assertTrue(desc.contains(expected), "Kos Andalan Description text is wrong");
        }
    }

    @When("user sets gender filter {string}")
    public void userSetsGenderFilter(String gender) throws InterruptedException {
        search.selectFilterByGender(gender);
    }

    @Then("user validates the result kos gender is {string}")
    public void userValidatesTheResultKosGenderIs(String gender) throws InterruptedException {
        List<String> genderList = search.getListGender(gender);
        for(String a: genderList){
            Assert.assertEquals(a, gender);
        }
    }
}