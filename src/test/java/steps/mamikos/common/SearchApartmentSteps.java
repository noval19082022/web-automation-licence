package steps.mamikos.common;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
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
}
