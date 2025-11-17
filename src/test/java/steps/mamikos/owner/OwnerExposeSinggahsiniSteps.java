package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utilities.PlaywrightHelpers;

import java.util.List;
import java.util.Map;

public class OwnerExposeSinggahsiniSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);

    @Then("Expose Singgahsini popup is displayed with:")
    public void exposeSinggahsiniPopupIsDisplayedWith(DataTable dataTable) {
        // Wait for page to be fully loaded to ensure popup has time to appear
        playwright.waitTillPageLoaded(30000.0);

        // DataTable format: | type | text |
        // Each row is a key-value pair without header
        List<List<String>> rows = dataTable.asLists(String.class);

        for (List<String> row : rows) {
            String type = row.get(0); // "message" or "button"
            String expectedText = row.get(1); // The actual text

            if (type.equals("message")) {
                // Wait for and verify the message text is displayed in the popup
                var messageLocator = page.getByText(expectedText);
                playwright.waitFor(messageLocator, 10000.0);
                Assert.assertTrue(messageLocator.isVisible(),
                        "Popup message '" + expectedText + "' should be visible");
            } else if (type.equals("button")) {
                // Wait for and verify the button is displayed in the popup
                var buttonLocator = page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON,
                        new Page.GetByRoleOptions().setName(expectedText));
                playwright.waitFor(buttonLocator, 10000.0);
                Assert.assertTrue(buttonLocator.isVisible(),
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
        var button = page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName(buttonText));
        button.click();
        // Wait for navigation to complete after clicking the button
        playwright.waitTillPageLoaded(60000.0);
    }

    @Then("owner is redirected to Singgahsini.id with source {string}")
    public void ownerIsRedirectedToSinggahsiniIdWithSource(String source) {
        // Wait for the redirect to complete by waiting for page to load
        playwright.waitTillPageLoaded(30000.0);

        // Get the current URL
        String currentUrl = page.url();

        // Verify the URL contains singgahsini.id
        Assert.assertTrue(currentUrl.contains("singgahsini.id"),
                "Should be redirected to singgahsini.id but current URL is: " + currentUrl);

        // Verify the source parameter is in the URL
        // The URL may contain the source parameter in various encoded formats:
        // - redirection_source='kos saya pop up singgahsini' (with quotes)
        // - spaces encoded as + or %20
        // - quotes encoded as %27
        boolean hasSourceParam = currentUrl.contains("redirection_source") ||
                                 currentUrl.contains("source=" + source) ||
                                 currentUrl.contains("source=" + source.replace(" ", "+")) ||
                                 currentUrl.contains("source=" + source.replace(" ", "%20"));

        Assert.assertTrue(hasSourceParam,
                "URL should contain source parameter with '" + source + "' but current URL is: " + currentUrl);
    }

    @And("owner resets draft property location back to {string}")
    public void ownerResetsDraftPropertyLocationBackTo(String location) {
        // Reset location back to the specified location (e.g., Kretek)
        // This ensures the test can run again and trigger the popup
        OwnerLocationSteps locationSteps = new OwnerLocationSteps();
        locationSteps.editDraftPropertyLocation(location, true); // true = navigate back to property list
    }
}
