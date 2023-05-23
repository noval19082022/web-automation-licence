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
import pageobject.common.KostLandingAreaPO;
import pageobject.common.SearchPO;
import utilities.PlaywrightHelpers;

import java.util.List;
import java.util.Map;

public class SearchSteps {
    Page page = ActiveContext.getActivePage();
    HomePO homePO = new HomePO(page);
    KostDetailsPO kostDetail = new KostDetailsPO(page);
    SearchPO search = new SearchPO(page);
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    HomePO home = new HomePO(page);
    SearchPO searchPO;
    KostLandingAreaPO kostLanding = new KostLandingAreaPO(page);
    private Map<String, String> cityName;
    private Map<String, String> areaSearch;
    private int kostListBefore;
    private int kostListAfter;

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
        List<String> resultList = search.listResultKeyword();
        for (String a : resultList) {
            Assert.assertTrue(a.contains(semarang), "Search result " + a + " not in correct location");
        }
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
        var kostName = kostNameData.get(0).get("kost " + Mamikos.ENV);
        search.suggetionKostOnTheSearchListNumberSix(kostName);
    }

    @When("user clicks Search")
    public void userClicksSearch() {
        search.clickSearchBar();
    }

    @Then("After user click City name, city name will expand and Area name listed below it.")
    public void after_user_click_city_name_city_name_will_expand_and_area_name_listed_below_it(DataTable table) throws InterruptedException {
        List<List<String>> listCity = table.asLists(String.class);
        System.out.println("size()" + listCity.size());
        for (int j = 0; j < listCity.size(); j++) {
            search.userTapCity(listCity.get(0).get(j));
            for (int i = j + 1; i < listCity.size(); i++) {
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
        if (filter.equalsIgnoreCase("Promo Ngebut")) {
            search.clickPromoNgebutFilter();
            String desc = search.getPromoNgebutDescText().replaceAll("\\s", "");
            String expected = text.toLowerCase().replaceAll("\\s", "");
            Assert.assertTrue(desc.contains(expected), "Description Promo Ngebut text is wrong");
        } else if (filter.equalsIgnoreCase("Dikelola Mamikos")) {
            search.clickDikelolaMamikosFilter();
            String desc = search.getDikelolaMamikosDescText().replaceAll("\\s", "");
            String expected = text.toLowerCase().replaceAll("\\s", "");
            Assert.assertTrue(desc.contains(expected), "Dikelola Mamikos Description text is wrong");
        } else if (filter.equalsIgnoreCase("Kos Andalan")) {
            search.clickKosAndalanFilter();
            String desc = search.getKosAndalanDescText().replaceAll("\\s", "");
            String expected = text.toLowerCase().replaceAll("\\s", "");
            Assert.assertTrue(desc.contains(expected), "Kos Andalan Description text is wrong");
        }
    }

    @Then("listing that appear have location")
    public void listingThatAppearHaveLocation(DataTable table) {
        var city = table.asMaps(String.class, String.class);
        var popular = city.get(0).get("city " + Mamikos.ENV);
//        search.clickAreaBerdasarkanKotaBelow(popular);
    }

    @And("user click area city")
    public void userClickAreaCity(DataTable table) throws InterruptedException {
        var city = table.asMaps(String.class, String.class);
        var popular = city.get(0).get("city " + Mamikos.ENV);
        search.clickPopularCity(popular);
    }

    @Then("under popular search, click city :")
    public void underPopularSearchClickCity(DataTable table) throws InterruptedException {
        var city = table.asMaps(String.class, String.class);
        var popular = city.get(0).get("city " + Mamikos.ENV);
        search.clickPopularCity(popular);
    }


    @Then("under area city click")
    public void underAreaCityClick(DataTable table) throws InterruptedException {
        var city = table.asMaps(String.class, String.class);
        var popular = city.get(0).get("city " + Mamikos.ENV);
        search.clickPopularCity(popular);

    }

    @Then("listing that appear have no {string} property")
    public void listingThatAppearHaveNoProperty(String apartemen) {
        search.suggestionAreaClick();
        List<String> addressList = search.listKostAddress();
        for (String a : addressList) {
            Assert.assertFalse(a.toLowerCase().contains(apartemen.toLowerCase()), "Search result " + a + " not in correct location");
        }
    }

    @When("user search for random keyword:{string}")
    public void userSearchForRandomKeyword(String city) throws InterruptedException {
        search.searchArea(city);
    }

    @Then("title listing that appear have location in {string}")
    public void titleListingThatAppearHaveLocationIn(String cityArea) {
        search.clickOnListPopularCity(cityArea);
        List<String> addressList = search.listKostAddress();
        for (String a : addressList) {
            Assert.assertTrue(a.toLowerCase().contains(cityArea.toLowerCase()), "Search result " + a + " not in correct location");
        }
        Assert.assertTrue(search.getTitleListingResult(cityArea).contains(cityArea), "Title Listing Result is not equals with the keyword!");

    }

    @When("user click search area based on campus")
    public void userClickSearchAreaBasedOnCampus() {
        search.searchByCampus();

    }

    @Then("user verify popular campus")
    public void userVerifyPopularCampus(DataTable table) {
        var campus = table.asMaps(String.class, String.class);
        for (Map<String, String> kampus : campus) {
            Assert.assertTrue(search.listPopularCity(kampus.get("campus " + Mamikos.ENV)), kampus.get("campus " + Mamikos.ENV) + " is not displayed");
        }
    }

    @When("user sets gender filter {string}")
    public void userSetsGenderFilter(String gender) {
        search.selectFilterByGender(gender);
    }

    @Then("user validates the result kos gender is {string}")
    public void userValidatesTheResultKosGenderIs(String gender) {
        List<String> genderList = search.getListGender(gender);
        for (String a : genderList) {
            Assert.assertEquals(a, gender);
        }
    }

    @And("user click button kampus")
    public void userClickButtonKampus(DataTable table) {
        var campus = table.asMaps(String.class, String.class);
        var popular = campus.get(0).get("campus " + Mamikos.ENV);
        search.getCampusArea(popular);


    }

    @Then("title listing that appear have location campus in {string}")
    public void titleListingThatAppearHaveLocationCampusIn(String campusArea) {
        List<String> addressList = search.listKostAddress();
        for (String a : addressList) {
            Assert.assertTrue(a.toLowerCase().contains(campusArea.toLowerCase()), "Search result " + a + " not in correct location");
        }
    }

    @And("user click kampus berdasarkan kota")
    public void userClickKampusBerdasarkanKota(DataTable table) throws InterruptedException {
        var campus = table.asMaps(String.class, String.class);
        var popular = campus.get(0).get("campus " + Mamikos.ENV);
        search.clickPopularCity(popular);
    }

    @When("user click stasiun&halte")
    public void userClickStasiunHalte() {
        search.clickSearchBar();
        search.stasiunDanHalteClickOn();
    }

    @When("user sets facility filter {string}")
    public void userSetsFacilityFilter(String facility) {
        search.selectFilterByFacility(facility);
    }

    @Then("user validates the result kos facility is {string}")
    public void userValidatesTheResultKosFacilityIs(String facility) {
        List<String> facilityList = search.getListFacility(facility);
        for (String a : facilityList) {
            Assert.assertTrue(a.contains(facility), "Search result " + a + " not in correct facility");
        }
    }

    @And("user sets top kos rule filter {string}")
    public void userSetsTopKosRuleFilter(String rule) {
        search.selectFilterByKostRule(rule);
    }

    @Then("user validates the result kos rule is {string}")
    public void userValidatesTheResultKosRuleIs(String rule) {
        List<String> ruleList = search.getListKostRule(rule);
        for (String a : ruleList) {
            Assert.assertTrue(a.contains(rule), "Search result " + a + " not in correct facility");
        }
    }

    @And("user sets Kos Andalan filter")
    public void userSetsKosAndalanFilter() {
        search.activateKosAndalanFilter();
    }

    @Then("user validated the result kos have Kos Andalan label")
    public void userValidatedTheResultKosHaveKosAndalanLabel() {
        Assert.assertTrue(search.isKosAndalanPropertyDisplayed(), "Kos Andalan property is not present");
    }

    @And("user sets Promo Ngebut filter")
    public void userSetsPromoNgebutFilter() {
        search.activatePromoNgebutFilter();
    }

    @Then("user validated the result kos have Promo Ngebut label")
    public void userValidatedTheResultKosHavePromoNgebutLabel() {
        Assert.assertTrue(search.isPromoNgebutPropertyDisplayed(), "Promo Ngebut property is not present");
    }

    @When("user set range time filter {string}")
    public void userSetRangeTimeFilter(String time) {
        search.selectFilterByRangeTime(time);
    }

    @Then("user validates the result range time is {string}")
    public void userValidatesTheResultRangeTimeIs(String time) {
        List<String> timeList = search.getListFacility(time);
        for (String a : timeList) {
            Assert.assertTrue(a.contains(time), "Search result " + a + " not in correct range time");
        }
    }

    @When("user selects sorting {string} in kost listing")
    public void userSelectsSortingInKostListing(String sort) {
        search.selectSorting(sort);
    }

    @Then("user validates the price of first listing is more expensive than the last listing in listing property page")
    public void userValidatesThePriceOfFirstListingIsMoreExpensiveThanTheLastListingInListingPropertyPage() {
        Assert.assertTrue(search.getFirstPricePropertyPageListing() > search.getLastPricePropertyPageListing(), "First number is cheaper than last number!");
    }

    @Then("user validates the price of first listing is cheaper than the last listing in listing property page")
    public void userValidatesThePriceOfFirstListingIsCheaperThanTheLastListingInListingPropertyPage() {
        Assert.assertTrue(search.getFirstPricePropertyPageListing() < search.getLastPricePropertyPageListing(), "First number is not cheaper than last number!");
    }

    @When("user want to search kost list by place on {string} from homepage")
    public void user_search_for_keyword(String city) {
        search = homePO.clickOnSearchButton();
        search.enterTextToSearchAndSelectResultCity(city);
    }

    @Then("user sees the facilities on kos card are {string} or {string} or {string}")
    public void user_sees_the_facilities_on_kos_card_are_or_or(String facility1, String facility2, String facility3) {
        List<String> addressList = search.listKostFacilities();
        for (String a : addressList) {
            if (a.contains(facility1)) {
                Assert.assertTrue(a.contains(facility1), "Search result " + a + " not in correct facility");
            } else if (a.contains(facility2)) {
                Assert.assertTrue(a.contains(facility2), "Search result " + a + " not in correct facility");
            } else if (a.contains(facility3)) {
                Assert.assertTrue(a.contains(facility3), "Search result " + a + " not in correct facility");
            }
        }
    }

    @When("user search and go to kost landing based on area:")
    public void userGoToKostLandingBasedOnArea(DataTable table) {
        areaSearch = table.asMap(String.class, String.class);
        var area = areaSearch.get("search keyword");
        var areaToClick = areaSearch.get("area result");
        searchPO = homePO.clickOnSearchButton();
        kostLanding = searchPO.searchByArea(area, areaToClick);
    }

    @Then("user can see the kost list are from {string}")
    public void userCanSeeTheKostListAreFrom(String area) {
        Assert.assertTrue(kostLanding.getResultHeadingText().contains(area), "Result is not from: " + area);
    }

    @Given("user filter price minimal to {int}, and maximal to {int}")
    public void userFilterPriceMinimalToAndMaximalTo(int minimal, int maximal) {
        kostLanding.filterByHarga(minimal, maximal);
    }

    @Then("user can see kost landing behavior for kost list with just {int} result")
    public void userCanSeeKostLandingBehaviorForKostListWithJustResult(int kostList) {
        Assert.assertEquals(kostLanding.getKostListLocator().size(), kostList, "Result is more than one or zero");
        Assert.assertTrue(kostLanding.isNominatimMapVisible(), "Nominatim map is not visible");
        Assert.assertTrue(kostLanding.isFilterResetTextVisible(), "Reset filter text is not visible");
        Assert.assertTrue(kostLanding.isFilterResetButtonVisible(), "Reset filter button is not visible");
    }

    @Given("user reset filter")
    public void userResetFilter() {
        kostLanding.clickOnResetFilterButton();
    }

    @Then("user can see kost list is more than {int}")
    public void userCanSeeKostListIsMoreThan(int kostList) {
        Assert.assertTrue(kostLanding.getKostListLocator().size() > kostList, "Kost list is not greater than " + kostList);
        Assert.assertFalse(kostLanding.isFilterResetTextVisible(), "Reset filter text is visible");
        Assert.assertFalse(kostLanding.isFilterResetButtonVisible(), "Reset filter button is visible");
    }


    @And("user want to maximize the screen size")
    public void user_maximize_the_screen_size() {
        page.setViewportSize(1920, 1080);
    }

    @Then("user can check the legend of map price cluster")
    public void user_check_the_legend_of_map_price_cluster(List<String> wording) {
        playwright.hardWait(2_000);
        for (int i = 0; i < wording.size(); i++) {
            Assert.assertTrue(search.isLegendPresent(wording.get(i)), "Cluster " + wording + " is not present");
            Assert.assertEquals(search.getLegendDesc(wording.get(i)), wording.get(i), "Cluster icon not equal to " + wording.get(i));
        }
    }

    @And("user can check the legend of map description cluster")
    public void user_check_the_legend_of_map_description_cluster(List<String> wording) {
        for (int i = 0; i < wording.size(); i++) {
            Assert.assertTrue(search.isLegendDescPresent(wording.get(i)), "Description " + wording + " is not present");
            Assert.assertEquals(search.getLegendDescText(wording.get(i)), wording.get(i), "Description text not equal to " + wording.get(i));
        }
    }

    @And("user can check the legend of map information cluster")
    public void user_check_the_legend_of_map_information_cluster(List<String> wording) {
        for (int i = 0; i < wording.size(); i++) {
            Assert.assertTrue(search.isLegendInformationPresent(wording.get(i)), "Information " + wording + " is not present");
            Assert.assertTrue(search.getLegendInformationText(wording.get(i)).contains(wording.get(i)), "Information text not equal to " + wording.get(i));
        }
    }

    @And("user want to close the legend map")
    public void user_close_the_legend_map() {
        search.clickMapLegendButton();
    }

    @Then("user will see the pop up closed")
    public void user_see_the_pop_up_closed() {
        Assert.assertFalse(search.isMapLegendPresent(), "Map Legend still appears!");
    }

    @Then("user can see empty state kost landing area")
    public void userCanSeeEmptyStateKostLandingArea() {
        Assert.assertTrue(kostLanding.getAllContentNominatimEmptyList().get(0).contains("Kos Tidak Ditemukan"));
        Assert.assertTrue(kostLanding.getAllContentNominatimEmptyList().get(0).contains("Silahkan ubah filter untuk meningkatkan hasil pencarian kos."));
    }

    @Then("user can see Lihat Lebih Banyak And Back To Top Button")
    public void userCanSeeLihatLebihBanyakAndBackToTopButton() {
        Assert.assertTrue(kostLanding.isLihatLebihBanyakButtonVisible(), "Lihat Lebih Banyak button is not visible");
        Assert.assertTrue(kostLanding.isBackToTopButtonVisible(), "Back To To Button is not visible");
    }

    @Given("user click on Lihat Lebih Banyak button")
    public void userClickOnLihatLebihBanyakButton() {
        kostListBefore = kostLanding.getKostListLocator().size();
        kostLanding.clickOnLihatLebihBanyakButton();
        kostListAfter = kostLanding.getKostListLocator().size();
    }


    @Then("user can see kos lists are expanded")
    public void userCanSeeKosListsAreExpanded() {
        Assert.assertTrue(kostListBefore < kostListAfter);
    }

    @Then("user can use Back To Top Button")
    public void userCanUseBackToTopButton() {
        kostLanding.clickOnSayaMengertiButton();
        Assert.assertTrue(kostLanding.isBackToTopButtonEnabled(), "Back To Top Button Is Not Clickable");
        kostLanding.clickOnBackToTopButton();
    }

    @Then("user can see kos list result area are the list below:")
    public void userCanSeeKosListResultAreaAreTheListBelow(DataTable area) {
        List<String> areaList = area.asList();
        kostLanding.clickOnCariBerdasarkanPeta();
        int kosAreaSize = kostLanding.getKosAreaSize();
        for (int i = 0; i < kosAreaSize; i++) {
            System.out.println(kostLanding.getKosAreaText(i));
            if (kostLanding.getKosAreaText(i).equalsIgnoreCase("unknown")) {
                continue;
            }
            Assert.assertTrue(areaList.contains(kostLanding.getKosAreaText(i)), "Kos Area " + kostLanding.getKosAreaText(i) + " Is not present in the list");
        }
    }

    @And("user type for keyword {string}")
    public void userTypeForKeyword(String city) {
        search = homePO.clickOnSearchButton();
        search.enterTextOnSearchSearchBox(city);
    }

    @Then("user validate the suggestion result contains {string}")
    public void userValidateTheSuggestionResultContains(String suggestion) {
        search = new SearchPO(ActiveContext.getActivePage());
        List<String> suggestionInnerText = search.getSuggestionText();
        Assert.assertTrue(suggestionInnerText.get(0).contains(suggestion));
    }

    @When("user use filter {string}")
    public void userUseFilter(String filter) {
        kostLanding.clickOnFilter(filter);
    }

    @Then("user can see kos tidak ditemukan state on kos landing area")
    public void userCanSeeKosTidakDitemukanStateOnKosLandingArea() {
        Assert.assertTrue(kostLanding.isImageKosTidakDitemukanVisible(), "Image kos tidak ditemukan is not visible");
        Assert.assertTrue(kostLanding.isKosTidakDitemukanHeadingVisible(), "Kos Tidak Ditemukan heading is not visible");
        Assert.assertTrue(kostLanding.hapusSemuaFilterButtonVisible(), "Hapus semua filter button is not visible");
    }

    @When("user set price sorting from lower to greater")
    public void userSetPriceSortingFromLowerToGreater() {
        kostLanding.setPriceSortingFrom("Harga Termurah");
    }

    @Then("user can see kos list rearrange from cheaper to expensive")
    public void userCanSeeKosListRearrangeFromCheaperToExpensive() {
        for (int i = 0; i < kostLanding.getKosPriceListSize(); i++) {
            if (i == (kostLanding.getKosPriceListSize() - 1)) {
                break;
            }
            var cheaperPrice = kostLanding.getKostPrice(i);
            var greaterPrice = kostLanding.getKostPrice(i + 1);
            System.out.println("Iterate number " + (i + 1));
            System.out.println("Cheaper price is " + cheaperPrice);
            System.out.println("Expensive price is " + greaterPrice);
            Assert.assertTrue(cheaperPrice <= greaterPrice, cheaperPrice + "is not cheaper than " + greaterPrice);
        }
    }

    @When("user set price sorting from greater to lower")
    public void userSetPriceSortingFromGreaterToLower() {
        kostLanding.setPriceSortingFrom("Harga Termahal");
    }

    @Then("user/tenant/owner can see kos list rearrange from expensive to cheaper")
    public void userCanSeeKosListRearrangeFromExpensiveToCheaper() {
        for (int i = 0; i < kostLanding.getKosPriceListSize(); i++) {
            if (i == (kostLanding.getKosPriceListSize() - 1)) {
                break;
            }
            var greaterPrice = kostLanding.getKostPrice(i);
            var lowerPrice = kostLanding.getKostPrice(i + 1);
            System.out.println("Iterate number " + (i + 1));
            System.out.println("Greater price is " + greaterPrice);
            System.out.println("Lower price is " + lowerPrice);
            Assert.assertTrue(greaterPrice >= lowerPrice, greaterPrice + " is not more expensive than " + lowerPrice);
        }
    }
}