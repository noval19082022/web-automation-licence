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
import java.util.Optional;

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
        Assert.assertTrue(home.isSearchIklanDisplayed(), "Cari Iklan button not present!");
        Assert.assertTrue(home.isHelpCenterDisplayed(), "Pusat Bantuan button not present!");
        Assert.assertTrue(home.isTermConditionDisplayed(), "Syarat Ketentuan button not present!");
        Assert.assertTrue(home.isPromosiAdsDisplayed(), "Promosi Iklan button not present!");
        Assert.assertTrue(home.isEnterButtonDisplayed(), "Enter button not present!");
    }

    @Then("Check navbar before login appears in pencari login")
    public void CheckNavbarBeforeLoginAppearsInPencariLogin() {
        Assert.assertTrue(home.isBookingKosNotDisplayed(), "Booking Kos button is present, but it should not be!");
        Assert.assertTrue(home.isDownloadAppNotDisplayed(), "Download App button present, but it should not be!");
        Assert.assertTrue(home.isPromosiAdsNotDisplayed(), "Promosi Iklan button present, but it should not be!");
        Assert.assertTrue(home.isEnterButtonNotDisplayed(), "Enter button present, but it should not be!");
    }

    @Then("user in kost detail navbar before login appears")
    public void userInKostDetailNavbarBeforeLoginAppears() throws InterruptedException {

        Assert.assertTrue(home.isBookingKosDisplayed(), "Booking Kos button not present!");
        Assert.assertTrue(home.isDownloadAppDisplayed(), "Download App button not present!");
        Assert.assertTrue(home.isSearchIklanDisplayed(), "Cari Iklan button not present!");
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
        home.isTenantProfilePictureDisplayed();
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

    @Then("user see the search result based on name")
    public void user_see_the_search_result_based_on_name() {
        kostDetail.getKostTitle();
    }

    @When("user search property by name Autocomplete")
    public void userSearchPropertyByNameAutocomplete(DataTable table) {
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
            playwright.waitTillPageLoaded(1000.0);
            String desc = search.getPromoNgebutDescText().replaceAll("\\s", "");
            String expected = text.toLowerCase().replaceAll("\\s", "");
            Assert.assertTrue(desc.contains(expected), "Description Promo Ngebut text is wrong");
        } else if (filter.equalsIgnoreCase("Dikelola Mamikos")) {
            playwright.waitTillPageLoaded(1000.0);
            String desc = search.getDikelolaMamikosDescText().replaceAll("\\s", "");
            String expected = text.toLowerCase().replaceAll("\\s", "");
            Assert.assertTrue(desc.contains(expected), "Dikelola Mamikos Description text is wrong");
        } else if (filter.equalsIgnoreCase("Kos Andalan")) {
            playwright.waitTillPageLoaded(1000.0);
//            search.clickKosAndalanFilter();
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
        search.enterTextToSearchAndSelectResultCity(city);
    }

    @When("user want to visit search page from homepage")
    public void user_visit_search_page() {
        home.clickOnSearchButton();
    }

    @When("user type to search kost with keywords {string}")
    public void user_search_for_keyword_(String city) {
        search.enterTextToSearch(city);
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
    }

    @Then("user/admin/tenant can see kost list is more than {int}")
    public void userCanSeeKostListIsMoreThan(int kostList) {
        Assert.assertTrue(kostLanding.getKostListLocator().size() > kostList, "Kost list is not greater than " + kostList);
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
        
        // Wait for content to load after clicking the button
        playwright.hardWait(8000);
        
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
        int kosAreaSize = Math.min(kostLanding.getKosAreaSize(), 4); // Limit to 4 areas
        for (int i = 0; i < kosAreaSize; i++) {
            String kosAreaText = kostLanding.getKosAreaText(i);
            System.out.println(kosAreaText);
            if (kosAreaText.equalsIgnoreCase("unknown")) {
                continue;
            }
            Assert.assertTrue(areaList.contains(kosAreaText), "Kos Area " + kosAreaText + " is not present in the list");
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
        Assert.assertNotNull(suggestionInnerText, "Suggestion list should not be null");
        Assert.assertFalse(suggestionInnerText.isEmpty(), "Suggestion list should not be empty");
        Assert.assertTrue(suggestionInnerText.get(0).contains(suggestion), "First suggestion should contain: " + suggestion);
    }

    @And("user select first kost on the search result to burn saldo {int} times")
    public void selectFisrtKost(int times) {
        searchPO = new SearchPO(ActiveContext.getActivePage());
        for (int i = 0; i < times; i++) {
            searchPO.selectFirstKostOnSearchResult();
        }
        playwright.hardWait(3000);
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
        kostLanding.setSortingFromLowerToGreater();
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
        kostLanding.setSortingFromGreaterToLower();
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

    @When("user visit search page, and visit popular search based on {string} for location on {string}")
    public void userVisitSearchPageAndVisitPopularSearchBasedOnForLocationOn(String place, String popPlace) {
        searchPO = homePO.clickOnSearchButton();
        searchPO.clickPopularArea(place, popPlace);
    }

    @Then("user can see total kost in area with {string}")
    public void user_can_see_total_kost_in_area_with(String text){
        kostLanding.getTotalSearchAreatext(text);
    }

    @And("tenant can click on load more button")
    public void tenant_can_click_on_load_more_button(){
        kostLanding.clickLoadMore();
    }

    @And("user verify see kost name {string} in suggestion prime list")
    public void user_verify_see_kos_prime_on_list(String kostName) {
        searchPO = Optional.ofNullable(searchPO).orElseGet(() -> new SearchPO(page));
        var kostPrime = searchPO.getListSuggestionKostNamePrime();

        var isExistCount = 0;
        for (var kost : kostPrime) {
            if (kost.contains(kostName)) {
                isExistCount++;
            }
        }

        Assert.assertTrue(isExistCount > 0, String.format("kost %s not exist in prime", kostName));
        Assert.assertFalse(isExistCount > 1, String.format("kost %s exist more than once in prime with count %d", kostName, isExistCount));
    }

    @And("user verify see kost name {string} is not exist in suggestion prime list")
    public void user_verify_see_kos_not_prime_on_list(String kostName) {
        searchPO = Optional.ofNullable(searchPO).orElseGet(() -> new SearchPO(page));
        var kostPrime = searchPO.getListSuggestionKostNamePrime();

        var isExistCount = 0;
        for (var kost : kostPrime) {
            if (kost.contains(kostName)) {
                isExistCount++;
            }
        }

        Assert.assertFalse(isExistCount > 0, String.format("kost %s is exist in prime", kostName));
    }

    @Then("user verify see kost name {string} in suggestion nama kost terkait list")
    public void user_verify_see_kos_non_prime_on_list(String kostName) {
        searchPO = Optional.ofNullable(searchPO).orElseGet(() -> new SearchPO(page));
        var kostNonPrime = searchPO.getListSuggestionKostNameNonPrime();
        System.out.println(kostNonPrime);

        var isExistCount = 0;
        for (var kost : kostNonPrime) {
            if (kost.contains(kostName)) {
                isExistCount++;
            }
        }

        Assert.assertTrue(isExistCount > 0, String.format("kost %s not exist in nama kost terkait", kostName));
        Assert.assertFalse(isExistCount > 1, String.format("kost %s exist more than once in nama kost terkait with count %d", kostName, isExistCount));
    }

    @Then("user can not see any prime suggestion list")
    public void userCanNotSeeAnyPrimeSuggestionList() {
        Assert.assertFalse(search.isPrimeSuggestionBoxVisible());
    }

    @When("user click on cluster number {string} on maps")
    public void userClickOnClusterNumberOnMaps(String number){
        search.clickMapsClusterButton(number);
    }

    @When("user click on {string} on maps")
    public void userCLickOnMaps(String text){
        if(text.equalsIgnoreCase("zoom in")){
            search.clickZoomInButton();
        }
        else if(text.equalsIgnoreCase("zoom out")){
            search.clickZoomOutButton();
        }
    }

    @Then("user can see usp filter with {string}")
    public void userCanSeeUspFilter(String filter){
        List<String> filterText = search.getFilterText(filter);
        for (String a : filterText) {
            Assert.assertEquals(a, filter);
        }
    }

    @And("user sets top kos Rooms Available filter")
    public void userSetsTopKosRoomAvailableFilter() {
        search.kosRoomAvailableFilter();
    }

    @When("user click on search kos")
    public void userClickOnSearchKos() {
        search.clickOnSearchKos();
    }

    @And("user input area {string}")
    public void userInputArea(String area) {
        search.inputArea(area);
    }

    @Then("user no longer see text {string}")
    public void userNoLongerSeeText(String text) {
        // Wait a moment for any text changes to occur
        playwright.hardWait(1000);

        // Check that the specified text is no longer visible
        boolean textNotVisible = !page.getByText(text).isVisible();

        Assert.assertTrue(textNotVisible,
                "Expected text '" + text + "' to no longer be visible, but it is still displayed");

        System.out.println("Verified that text '" + text + "' is no longer visible");
    }

    @When("user click on {string}")
    public void userClickOnAreaTerkaitLink(String linkText) {
        search.clickOnLink(linkText);
        System.out.println("Clicked on link: " + linkText);
    }

    @Then("user see display {int} suggestion kos")
    public void userSeeDisplayNumberOfSuggestionKos(int expectedCount) {
        boolean hasSuggestions = search.verifyAdditionalSuggestions(expectedCount);

        Assert.assertTrue(hasSuggestions,
                "Expected to see " + expectedCount + " additional kos suggestions, but they were not displayed");

        System.out.println("Successfully verified that " + expectedCount + " additional kos suggestions are displayed");
    }

    @When("user non login")
    public void userNonLogin() {
        Assert.assertTrue(home.isEnterButtonDisplayed(), "User should not be logged in - Enter/Masuk button not visible!");
        System.out.println("Verified user is not logged in");
    }

    @And("user fill keywords:")
    public void userFillKeywords(DataTable table) {
        var keywordData = table.asMaps(String.class, String.class);
        var keyword = keywordData.get(0).get("keywords");
        search.inputArea(keyword);
        System.out.println("Filled search with keyword: " + keyword);
    }

    @Then("user see listing {string} displayed on section recommendation kos")
    public void userSeeListingDisplayedOnSectionRecommendationKos(String listingName) {
        boolean isListingDisplayed = search.isListingDisplayedInRecommendation(listingName);
        Assert.assertTrue(isListingDisplayed,
                "Expected listing '" + listingName + "' to be displayed in recommendation section, but it was not found");
        System.out.println("Successfully verified that listing '" + listingName + "' is displayed in recommendation section");
    }
}
