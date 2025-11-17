package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import utilities.PlaywrightHelpers;

public class OwnerLocationSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);

    @And("owner edits draft property location to area prio {string}")
    public void ownerEditsDraftPropertyLocationToAreaPrio(String location) {
        editDraftPropertyLocation(location, true); // true = navigate back to property list where popup will appear
    }

    /**
     * Edits draft property location with option to navigate away or stay on popup
     * @param location The location to change to
     * @param navigateAway If true, navigates back to property list; if false, stays on popup
     */
    public void editDraftPropertyLocation(String location, boolean navigateAway) {
        // Navigate to property saya kos page
        playwright.navigateTo("https://jambu.kerupux.com/ownerpage/kos");
        playwright.waitTillPageLoaded(60000.0);

        // Dismiss FTUE Goldplus if it appears
        dismissFTUEGoldplusIfPresent();

        // Click "Lengkapi Data Kos" for draft property and wait for next page to load
        var lengkapiDataLink = page.getByRole(com.microsoft.playwright.options.AriaRole.LINK,
                new Page.GetByRoleOptions().setName("Lengkapi Data Kos")).first();
        lengkapiDataLink.click();
        playwright.waitTillPageLoaded(60000.0);

        // Close photo info popup if it appears
        closePhotoInfoPopupIfPresent();

        // Navigate to "Alamat Kos" tab and wait for map section to load
        page.getByText("Alamat Kos").click(new com.microsoft.playwright.Locator.ClickOptions().setForce(true));
        playwright.waitTillPageLoaded(60000.0);  // Wait for page load event with increased timeout

        // Change location to the specified area prio
        changeLocationTo(location);

        // Click "Lanjutkan" button to save and wait for navigation
        var lanjutkanButton = page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Lanjutkan"));
        lanjutkanButton.click();

        if (navigateAway) {
            // Wait for save operation to complete by waiting for page to transition
            // The page should navigate to the next step automatically after save
            playwright.waitTillPageLoaded(60000.0); // Increased timeout for save operation

            // Now navigate back to property saya kos page
            playwright.navigateTo("https://jambu.kerupux.com/ownerpage/kos");
            playwright.waitTillPageLoaded(60000.0);

            // Wait for photo info popup to appear (indicates page fully loaded)
            try {
                var photoInfoPopup = page.getByText("Tips Upload Foto");
                playwright.waitFor(photoInfoPopup, 15000.0);
            } catch (Exception e) {
                // Photo info popup didn't appear, that's okay - page is loaded
                System.out.println("Photo info popup not found: " + e.getMessage());
            }
        } else {
            // Wait for page to be fully loaded before checking for popup
            playwright.waitTillPageLoaded(30000.0);
        }
    }

    private void dismissFTUEGoldplusIfPresent() {
        try {
            if (page.getByText("Goldplus").isVisible()) {
                page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON,
                        new Page.GetByRoleOptions().setName("close")).first().click();
                playwright.waitTillPageLoaded(30000.0);
            }
        } catch (Exception e) {
            System.out.println("FTUE Goldplus popup not present: " + e.getMessage());
        }
    }

    private void closePhotoInfoPopupIfPresent() {
        try {
            if (page.getByText("Tips Upload Foto").isVisible()) {
                page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON,
                        new Page.GetByRoleOptions().setName("close")).first().click();
                playwright.waitTillPageLoaded(30000.0);
            }
        } catch (Exception e) {
            System.out.println("Photo info popup not present: " + e.getMessage());
        }
    }

    private void changeLocationTo(String location) {
        try {
            // Wait for the search input field to be visible and ready first
            // This indicates the map section has loaded
            var searchInput = page.getByPlaceholder("Masukkan nama lokasi/ area/ alamat");
            playwright.waitFor(searchInput, 30000.0);

            // Click on the search field to ensure suggestions will appear
            searchInput.click();

            // Wait for search field to be focused and ready for input
            playwright.waitForElementStateToBe(searchInput, "editable");

            // Clear the search field
            playwright.clearText(searchInput);

            // Type the location name with delay to trigger autocomplete properly
            playwright.fillCharacterByCharacter(searchInput, location, 200.0);

            // Wait for autocomplete results to appear by checking for listitem elements
            var searchResults = page.getByRole(com.microsoft.playwright.options.AriaRole.LISTITEM);
            playwright.waitForSelectorState(searchResults.first(),
                    com.microsoft.playwright.options.WaitForSelectorState.VISIBLE, 15000.0);

            // Click on the first search result button
            var firstResult = page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON)
                    .filter(new com.microsoft.playwright.Locator.FilterOptions().setHasText("place-holder"))
                    .first();
            playwright.clickOn(firstResult);

            // Wait a bit for the location to be selected
            // Note: Cannot use waitTillNetworkIdle() as maps continuously load tiles
            playwright.waitTillPageLoaded(30000.0);
        } catch (Exception e) {
            throw new RuntimeException("Failed to change location to " + location + ": " + e.getMessage(), e);
        }
    }
}
