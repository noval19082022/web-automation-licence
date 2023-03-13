package steps.mamikos.common;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.apartment.ApartmentLandingPO;
import utilities.PlaywrightHelpers;

public class SearchApartmentSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    ApartmentLandingPO apartment = new ApartmentLandingPO(page);
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

    @And("user click on hubungi pengelola button")
    public void userClickOnHubungiPengelolaButton() {
        apartment.clickContactApt();
    }
}
