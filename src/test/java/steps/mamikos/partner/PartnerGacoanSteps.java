package steps.mamikos.partner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.partner.PartnerGacoanPO;
import utilities.PlaywrightHelpers;

import java.util.List;
import java.util.Map;

public class PartnerGacoanSteps {

    Page page = ActiveContext.getActivePage();
    PartnerGacoanPO partnerGacoan = new PartnerGacoanPO(page);
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);

    private List<Map<String, String>> credentials;

    @Given("admin gacoan visit partner portal page")
    public void adminGacoanVisitPartnerPortalPage() {
        partnerGacoan.navigateToPartnerPortal();
    }

    @When("admin gacoan login into partner portal:")
    public void adminGacoanLoginIntoPartnerPortal(DataTable table) {
        credentials = table.asMaps(String.class, String.class);
        String username = credentials.get(0).get("user");
        String password = credentials.get(0).get("password");
        partnerGacoan.login(username, password);
    }

    @Then("admin gacoan able to see the listing catalog")
    public void adminGacoanAbleToSeeTheListingCatalog() {
        Assert.assertTrue(partnerGacoan.isListingCatalogVisible(), "Listing catalog is not visible");
    }

    @And("admin gacoan try to check the filter and sorting")
    public void adminGacoanTryToCheckTheFilterAndSorting() {
        // Click Direkomendasikan button and select Harga Terendah
        partnerGacoan.selectSorting("Direkomendasikan", "Harga Terendah");
        playwright.hardWait(1000);

        // Click Harga Terendah button and select Harga Tertinggi
        partnerGacoan.selectSorting("Harga Terendah", "Harga Tertinggi");
        playwright.hardWait(1000);
    }

    @Then("the filter and sorting should be works")
    public void theFilterAndSortingShouldBeWorks() {
        Assert.assertTrue(partnerGacoan.isListingCatalogVisible(), "Filter and sorting failed - listing catalog not visible");
    }

    @And("admin gacoan select first kost on the listing catalog")
    public void adminGacoanSelectKostWithTheHighestPriceOnTheListingCatalog() {
        // After sorting by Harga Tertinggi, the first kost should have highest price
        partnerGacoan.clickFirstKostListing();
    }

    @Then("admin gacoan will redirect into booking form")
    public void adminGacoanWillRedirectIntoBookingForm() {
        Assert.assertTrue(partnerGacoan.isBookingFormVisible(), "Booking form is not visible");
    }

    @When("admin gacoan fill all required field using phone number {string}")
    public void adminGacoanFillAllRequiredFieldUsingPhoneNumber(String phoneNumber) {
        partnerGacoan.clickTambahPenyewa();
        playwright.hardWait(500);

        // Fill booking form with phone number, random name, and male gender
        partnerGacoan.fillBookingForm(phoneNumber, "Test Automation", "male");
    }

    @And("admin gacoan able to submit the booking")
    public void adminGacoanAbleToSubmitTheBooking() {
        partnerGacoan.submitBooking();
        playwright.hardWait(2000);

        // Verify booking submitted successfully - Ajukan Sewa Lagi link should be visible
        Assert.assertTrue(partnerGacoan.isAjukanSewaLagiLinkVisible(), "Booking submission failed - Ajukan Sewa Lagi link not visible");

        // Click Ajukan Sewa Lagi to go back
        partnerGacoan.clickAjukanSewaLagi();
    }

    @And("admin logout from partner page")
    public void adminLogoutFromPartnerPage() {
        partnerGacoan.logout();
    }
}
