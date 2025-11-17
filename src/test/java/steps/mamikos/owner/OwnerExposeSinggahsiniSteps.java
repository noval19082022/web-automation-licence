package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.owner.kos.OwnerExposeSinggahsiniPO;

import java.util.List;

public class OwnerExposeSinggahsiniSteps {
    Page page = ActiveContext.getActivePage();
    OwnerExposeSinggahsiniPO exposeSinggahsiniPO = new OwnerExposeSinggahsiniPO(page);

    @Then("Expose Singgahsini popup is displayed with:")
    public void exposeSinggahsiniPopupIsDisplayedWith(DataTable dataTable) {
        // Wait for page to be fully loaded to ensure popup has time to appear
        exposeSinggahsiniPO.waitForPageLoad();

        // DataTable format: | type | text |
        // Each row is a key-value pair without header
        List<List<String>> rows = dataTable.asLists(String.class);

        for (List<String> row : rows) {
            String type = row.get(0); // "message" or "button"
            String expectedText = row.get(1); // The actual text

            if (type.equals("message")) {
                // Wait for and verify the message text is displayed in the popup
                exposeSinggahsiniPO.waitForPopupMessage(expectedText);
                Assert.assertTrue(exposeSinggahsiniPO.isPopupMessageVisible(expectedText),
                        "Popup message '" + expectedText + "' should be visible");
            } else if (type.equals("button")) {
                // Wait for and verify the button is displayed in the popup
                exposeSinggahsiniPO.waitForPopupButton(expectedText);
                Assert.assertTrue(exposeSinggahsiniPO.isPopupButtonVisible(expectedText),
                        "Button '" + expectedText + "' should be visible");
            }
        }
    }

    @When("owner has triggered Expose Singgahsini popup by editing location to {string}")
    public void ownerHasTriggeredExposeSinggahsiniPopupByEditingLocationTo(String location) {
        // This step should trigger the popup by editing the location
        // We need to stay on the page (don't navigate away) so the popup remains visible
        OwnerLocationSteps locationSteps = new OwnerLocationSteps();
        locationSteps.editDraftPropertyLocation(location, false); // false = don't navigate away, keep popup open
    }

    @When("owner clicks {string} on the popup")
    public void ownerClicksOnThePopup(String buttonText) {
        exposeSinggahsiniPO.clickPopupButton(buttonText);
    }

    @Then("owner is redirected to Singgahsini.id with source {string}")
    public void ownerIsRedirectedToSinggahsiniIdWithSource(String source) {
        // Wait for the redirect to complete by waiting for page to load
        exposeSinggahsiniPO.waitForPageLoad();

        // Get the current URL
        String currentUrl = exposeSinggahsiniPO.getCurrentUrl();

        // Verify the URL contains singgahsini.id
        Assert.assertTrue(exposeSinggahsiniPO.isRedirectedToSinggahsini(),
                "Should be redirected to singgahsini.id but current URL is: " + currentUrl);

        // Verify the source parameter is in the URL
        Assert.assertTrue(exposeSinggahsiniPO.urlContainsSourceParameter(source),
                "URL should contain source parameter with '" + source + "' but current URL is: " + currentUrl);
    }

    @And("owner resets draft property location back to {string}")
    public void ownerResetsDraftPropertyLocationBackTo(String location) {
        // Reset location back to the specified location (e.g., Kretek)
        // This ensures the test can run again and trigger the popup
        OwnerLocationSteps locationSteps = new OwnerLocationSteps();

        // If location is Kretek, don't navigate away (stay on page)
        // Otherwise, navigate back to property list
        boolean navigateAway = !location.equalsIgnoreCase("Kretek");
        locationSteps.editDraftPropertyLocation(location, navigateAway);
    }
}
