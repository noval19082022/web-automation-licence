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
import utilities.PlaywrightHelpers;

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
            Assert.assertEquals(listTimePeriod.replace("/", "").trim(), period);
        }
    }

    @Then("user will see displays apartment lists by area and city")
    public void userWillSeeDisplaysApartmentListsByAreaAndCity(List<String> listValidationArea) {
        Assert.assertTrue(apartment.getCityAndAreaValidationOnList().containsAll(listValidationArea), "Area validation not match");
    }

    @When("user filter apartment by furniture is {string}")
    public void userFilterApartmentByFurnitureIs(String furniture) {
        apartment.filterByFurniture(furniture);
    }

    @Then("user see displays apartment lists by furniture is {string}")
    public void userSeeDisplaysApartmentListsByFurnitureIs(String furniture) {
        Assert.assertTrue(apartment.getApartmentListSize() > 1, "Apartment list is not visible");
        for (var listFurniturePeriod : apartment.getApartmentListByFurniture()) {
            // Find the index of the "·" character
            int indexOfDot = listFurniturePeriod.indexOf("·");
            // Extract the substring after "·"
            String result = listFurniturePeriod.substring(indexOfDot + 1).trim();

            Assert.assertEquals(result.trim(), furniture);
        }
    }
}
