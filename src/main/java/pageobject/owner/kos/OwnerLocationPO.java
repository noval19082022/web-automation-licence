package pageobject.owner.kos;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;
import utilities.PlaywrightHelpers;

public class OwnerLocationPO {
    private Page page;
    private PlaywrightHelpers playwright;

    // Locators
    private Locator lengkapiDataKosLink;
    private Locator goldplusPopupText;
    private Locator closeButton;
    private Locator photoInfoPopupText;
    private Locator closePopUpButton;
    private Locator alamatKosTab;
    private Locator mapMarker;
    private Locator locationSearchInput;
    private Locator searchResultsList;
    private Locator firstSearchResultButton;
    private Locator lanjutkanButton;
    private Locator loadingSpinner;

    public OwnerLocationPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(this.page);
        initializeLocators();
    }

    private void initializeLocators() {
        lengkapiDataKosLink = page.getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions().setName("Lengkapi Data Kos")).first();
        goldplusPopupText = page.getByText("Goldplus");
        closeButton = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("close")).first();
        photoInfoPopupText = page.locator(".photo-submission-tips");
        closePopUpButton = page.locator(".bg-c-modal__action-closable");
        alamatKosTab = page.getByText("Alamat Kos");
        locationSearchInput = page.getByPlaceholder("Masukkan nama lokasi/ area/ alamat");
        searchResultsList = page.getByRole(AriaRole.LISTITEM);
        lanjutkanButton = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Lanjutkan"));
        loadingSpinner = page.locator(".bg-c-loading-spinner.bg-c-loading-spinner--lg");
        mapMarker = page.locator(".leaflet-marker-icon");
    }

    /**
     * Navigate to property saya kos page
     * @param url The URL to navigate to
     */
    public void navigateToPropertySayaKos(String url) {
        playwright.navigateTo(url);
        playwright.waitTillPageLoaded(60000.0);
    }

    /**
     * Click on "Lengkapi Data Kos" link for draft property
     */
    public void clickLengkapiDataKos() {
        playwright.clickOn(lengkapiDataKosLink);
        playwright.waitTillPageLoaded(60000.0);
    }

    /**
     * Check if Goldplus FTUE popup is visible
     * @return true if visible, false otherwise
     */
    public boolean isGoldplusPopupVisible() {
        return goldplusPopupText.isVisible();
    }

    /**
     * Dismiss FTUE Goldplus popup if present
     */
    public void dismissFTUEGoldplusIfPresent() {
        if (isGoldplusPopupVisible()) {
            playwright.clickOn(closeButton);
            playwright.waitTillPageLoaded(30000.0);
        }
    }

    /**
     * Check if photo info popup is visible
     * @return true if visible, false otherwise
     */
    public boolean isPhotoInfoPopupVisible() {
        return playwright.isLocatorVisibleAfterLoad(photoInfoPopupText,10000.0);
    }

    /**
     * Close photo info popup if present
     */
    public void closePhotoInfoPopupIfPresent() {
        if (isPhotoInfoPopupVisible()) {
            playwright.clickOn(closePopUpButton);
            playwright.waitTillPageLoaded(30000.0);
        }
    }

    /**
     * Click on "Alamat Kos" tab
     */
    public void clickAlamatKosTab() {
        playwright.clickOn(alamatKosTab);
        playwright.waitTillPageLoaded(60000.0);
    }

    /**
     * Wait for map to appear on the page
     * Waits for the Leaflet map marker to be visible, indicating the map has loaded
     */
    public void waitForMapToAppear() {
        playwright.hardWait(10000);
        playwright.waitTillLocatorIsVisible(mapMarker, 30000.0);
    }

    /**
     * Wait for location search input to be ready
     */
    public void waitForLocationSearchInput() {
        playwright.waitTillLocatorIsVisible(locationSearchInput, 30000.0);
    }

    /**
     * Click on location search input
     */
    public void clickLocationSearchInput() {
        playwright.clickOn(locationSearchInput);
    }

    /**
     * Clear location search input
     */
    public void clearLocationSearchInput() {
        playwright.waitForElementStateToBe(locationSearchInput, "editable");
        playwright.clearText(locationSearchInput);
    }

    /**
     * Type location name character by character to trigger autocomplete
     * @param location The location name to type
     */
    public void typeLocationName(String location) {
        playwright.fillCharacterByCharacter(locationSearchInput, location, 200.0);
    }

    /**
     * Wait for search results to appear
     */
    public void waitForSearchResults() {
        playwright.waitForSelectorState(searchResultsList.first(),
                WaitForSelectorState.VISIBLE, 15000.0);
    }

    /**
     * Click on first search result
     */
    public void clickFirstSearchResult() {
        firstSearchResultButton = page.getByRole(AriaRole.BUTTON)
                .filter(new Locator.FilterOptions().setHasText("place-holder"))
                .first();
        playwright.clickOn(firstSearchResultButton);
    }

    /**
     * Change location to specified location
     * @param location The location to change to
     */
    public void changeLocationTo(String location) {
        waitForLoadingDisappear();
        waitForMapToAppear();
        waitForLocationSearchInput();
        clickLocationSearchInput();
        clearLocationSearchInput();
        typeLocationName(location);
        waitForSearchResults();
        clickFirstSearchResult();
        waitForLoadingDisappear();
    }

    /**
     * Click "Lanjutkan" button to save location
     */
    public void clickLanjutkanButton() {
        playwright.clickOn(lanjutkanButton);
        waitForLoadingDisappear();
        playwright.waitTillPageLoaded(30000.0);
    }

    /**
     * Wait for property list page to be fully loaded
     * Waits for the "Lengkapi Data Kos" link to appear as page load indicator
     */
    public void waitForPhotoInfoPopup() {
        playwright.waitTillLocatorIsVisible(lengkapiDataKosLink, 30000.0);
    }

    /**
     * Wait for loading spinner to disappear
     * Waits for the loading spinner element to become hidden from the page
     */
    public void waitForLoadingDisappear() {
        playwright.waitForSelectorState(loadingSpinner, WaitForSelectorState.HIDDEN, 30000.0);
    }
}
