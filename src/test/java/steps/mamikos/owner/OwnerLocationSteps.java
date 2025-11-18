package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import pageobject.owner.kos.OwnerLocationPO;
import utilities.PlaywrightHelpers;

public class OwnerLocationSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    OwnerLocationPO ownerLocationPO = new OwnerLocationPO(page);


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
        ownerLocationPO.navigateToPropertySayaKos("https://jambu.kerupux.com/ownerpage/kos");

        // Dismiss FTUE Goldplus if it appears
        ownerLocationPO.dismissFTUEGoldplusIfPresent();

        // Click "Lengkapi Data Kos" for draft property and wait for next page to load
        ownerLocationPO.clickLengkapiDataKos();

        // Close photo info popup if it appears
        ownerLocationPO.closePhotoInfoPopupIfPresent();

        // Navigate to "Alamat Kos" tab and wait for map section to load
        ownerLocationPO.clickAlamatKosTab();

        // Change location to the specified area prio
        ownerLocationPO.changeLocationTo(location);

        // Click "Lanjutkan" button to save and wait for navigation
        ownerLocationPO.clickLanjutkanButton();

        if (navigateAway) {
            // Wait for save operation to complete by waiting for page to transition
            // The page should navigate to the next step automatically after save
            playwright.waitTillPageLoaded(60000.0); // Increased timeout for save operation

            // Now navigate back to property saya kos page
            ownerLocationPO.navigateToPropertySayaKos("https://jambu.kerupux.com/ownerpage/kos");

            // Wait for photo info popup to appear (indicates page fully loaded)
            ownerLocationPO.waitForPhotoInfoPopup();
        } else {
            // Wait for page to be fully loaded
            playwright.waitTillPageLoaded(30000.0);
        }
    }
}
