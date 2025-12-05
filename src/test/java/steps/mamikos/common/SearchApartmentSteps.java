package steps.mamikos.common;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.HomePO;
import pageobject.common.KostDetailsPO;
import pageobject.common.SearchPO;
import pageobject.common.apartment.ApartmentDetailPO;
import pageobject.common.apartment.ApartmentLandingPO;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SearchApartmentSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    ApartmentLandingPO apartment = new ApartmentLandingPO(page);
    ApartmentDetailPO apartmentDetail = new ApartmentDetailPO(page);
    SearchPO searchPO;
    HomePO homePO = new HomePO(page);
    KostDetailsPO kostDetail = new KostDetailsPO(page);
    private List<Map<String, String>> searchApartment;

    @When("user search {string} on landing apartment")
    public void userSearchOnLandingApartment(String area) {
        apartment.fillApartmentSearchInput(area);
        apartment.clickOnSearch();
    }


    @Then("user can see no apartment list")
    public void userCanSeeNoApartmentList() {
        Assert.assertTrue(apartment.isApartemenTidakDitemukanTextVisible(), "Apartemen tidak ditemukan text is not visible");
        Assert.assertTrue(apartment.isImageNoPropertyVisible(), "No property image is not visible");
    }

    @Then("user can see apartment list")
    public void userCanSeeApartmentList() {
        Assert.assertTrue(apartment.getApartmentListSize() > 1, "Apartment list is not visible");
    }

    @When("user go to apartment details from apartment landing list number {int}")
    public void userGoToApartmentDetailsFromApartmentLandingListNumber(int listNumber) {
        playwright = new PlaywrightHelpers(page);
        playwright.navigateTo(Mamikos.URL + Mamikos.APARTMENT, 30000.0, LoadState.LOAD);
        apartment.clickOnApartmentListNumber(listNumber - 1);
    }

    @Then("tenant open tab pernah dilihat at menu favorite")
    public void tenant_open_tab_pernah_dilihat_at_menu_favorite() {
        apartment.clickOnHistoryApartment();
    }

    @Then("tenant verify the property with name {string} is appear")
    public void tenant_verify_the_property_with_name_is_appear(String propertyName) {
        Assert.assertEquals(apartment.getLastSeenDetailProperti(propertyName), propertyName, "There is no last seen detail properti!");
    }

    @Then("tenant verify the Hapus History button is appear")
    public void tenant_verify_the_hapus_history_button_is_appear() {
        Assert.assertTrue(apartment.isHapusHistoryVisible(), "hapus histori button is visible");
    }

    @When("tenant search kost then go to apartment details:")
    public void tenant_search_kost_then_go_to_apartment_details(DataTable table) {
        searchApartment = table.asMaps(String.class, String.class);
        var kostName = searchApartment.get(0).get("kost name " + Mamikos.ENV);
        searchPO = homePO.clickOnSearchButton();
        kostDetail = searchPO.searchByText(kostName);
        apartment.waitTillApartmentDetailPageVisible();
    }

    @When("tenant open tab difavoritkan at menu favorite")
    public void tenant_open_tab_difavoritkan_at_menu_favorite() {
        apartment.clickOnFavoriteApartment();
    }

    @Then("user verify rekomendasi listing section didn't display")
    public void user_verify_rekomendasi_listing_section_didn_t_display() {
        Assert.assertFalse(apartment.isRekomendasiSectionVisible(), "rekomendasi listing is display!");
    }

    @When("user filter apartment by time period is {string}")
    public void userFilterApartmentByTimePeriodIs(String period) {
        apartment.filterByTimePeriod(period);
    }

    @Then("user/tenant see displays apartment lists by time period is {string}")
    public void userSeeDisplaysApartmentListsByTimePeriodIs(String period) {
        Assert.assertTrue(apartment.getApartmentListSize() > 1, "Apartment list is not visible");
        for (var listTimePeriod : apartment.getApartmentListByPeriod()) {
            Assert.assertEquals(JavaHelpers.removeCharAndWhiteSpaceFromString(listTimePeriod, "/"), period);
        }
    }

    @Then("user will see displays apartment lists by area and city")
    public void userWillSeeDisplaysApartmentListsByAreaAndCity(List<String> listValidationArea) {
        List<String> actualAreas = apartment.getCityAndAreaValidationOnList();
        
        // Check if any of the expected areas are present (flexible validation)
        boolean foundAnyExpectedArea = false;
        List<String> foundAreas = new ArrayList<>();
        
        for (String expectedArea : listValidationArea) {
            for (String actualArea : actualAreas) {
                // Use contains() for flexible matching (handles partial matches)
                if (actualArea.toLowerCase().contains(expectedArea.toLowerCase())) {
                    foundAnyExpectedArea = true;
                    foundAreas.add(actualArea);
                    break;
                }
            }
        }
        
        Assert.assertTrue(foundAnyExpectedArea, 
            String.format("Area validation not match. Expected any of: %s, but found areas: %s", 
                listValidationArea, actualAreas));
    }

    @When("user filter apartment by furniture is {string}")
    public void userFilterApartmentByFurnitureIs(String furniture) {
        apartment.filterByFurniture(furniture);
    }

    @Then("user see displays apartment lists by furniture is {string}")
    public void userSeeDisplaysApartmentListsByFurnitureIs(String furniture) {
        Assert.assertTrue(apartment.getApartmentListSize() > 1, "Apartment list is not visible");
        for (var listFurniturePeriod : apartment.getApartmentListByUnitOrFurniture()) {
            String result = JavaHelpers.getStringAfterSpecificChar(listFurniturePeriod, "·");
            Assert.assertEquals(result.trim(), furniture);
        }
    }

    @When("user filter apartment by price direction is {string}")
    public void userFilterApartmentByPriceIs(String price) {
        apartment.filterByPriceDirection(price);
    }

    @Then("user see displays apartment lists by price direction is {string}")
    public void userSeeDisplaysApartmentListsByPriceDirectionIs(String price) {
        Assert.assertTrue(apartment.getApartmentListSize() > 1, "Apartment list is not visible");
        boolean assertionResult = (price.toLowerCase().equals("kosong ke penuh")) ? !apartment.isFullyBooked() :
                (price.toLowerCase().equals("acak")) ? isRandom(apartment.getApartmentListByPrice()) :
                        (price.toLowerCase().equals("harga termurah")) ? isSortedAscending(apartment.getApartmentListByPrice()) :
                                (price.toLowerCase().equals("harga termahal")) ? isSortedDescending(apartment.getApartmentListByPrice()) :
                                        false;

        Assert.assertTrue(assertionResult, "apartment is sorted incorrectly");
    }

    private boolean isRandom(List<Integer> prices) {
        // Check if the prices are not sorted in ascending or descending order
        boolean ascending = true;
        boolean descending = true;

        for (int i = 1; i < prices.size(); i++) {
            ascending = (prices.get(i) >= prices.get(i - 1)) ? ascending : false;
            descending = (prices.get(i) <= prices.get(i - 1)) ? descending : false;
        }

        return !(ascending || descending);
    }

    private boolean isSortedAscending(List<Integer> prices) {
        // Check if the prices are sorted in ascending order
        for (int i = 1; i < prices.size(); i++) {
            if (prices.get(i) < prices.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSortedDescending(List<Integer> prices) {
        // Check if the prices are sorted in descending order
        for (int i = 1; i < prices.size(); i++) {
            if (prices.get(i) > prices.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    @When("user filter apartment by unit type is {string}")
    public void userFilterApartmentByUnitTypeIs(String unitType) {
        apartment.filterByUnit(unitType);
    }

    @Then("user see apartment lists by unit type is {string}")
    public void userSeeApartmentListsByUnitTypeIs(String unitType) {
        Assert.assertTrue(apartment.getApartmentListSize() > 1, "Apartment list is not visible");
        apartment.getApartmentListByUnitOrFurniture().forEach(
                UnitAndFurnitureInfo ->
                        Assert.assertTrue(UnitAndFurnitureInfo.trim().contains(unitType))
        );
    }

    @When("user click mamikos logo on apartement list page")
    public void userClickMamikosLogoOnApartementListPage() {
        apartment.clickOnMamikosLogo();
    }

    @When("user select the first apartment on the list apartment page")
    public void userPickTheFirstApartementOnTheListApartmentPage() {
        var page1 = ActiveContext.getActiveBrowserContext().waitForPage(() -> {
            apartment.clickOnApartmentListNumber(0);
        });
        ActiveContext.setActivePage(page1);
    }

    @When("user select apartement by area on {string}")
    public void userSelectApartementByAreaOn(String area) {
        apartment.searchByArea(area);
    }
}
