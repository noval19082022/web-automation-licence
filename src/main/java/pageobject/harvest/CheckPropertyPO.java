package pageobject.harvest;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import data.mamikos.Mamikos;
import utilities.PlaywrightHelpers;

public class CheckPropertyPO {
    private Page page;
    private PlaywrightHelpers playwright;

    private Locator searchBar;
    private Locator propertyName;
    private Locator propertyAddress;
    private Locator propertyArea;
    private Locator nextButton;
    private Locator closeButton;
    private Locator propertyTitle;

    public CheckPropertyPO(Page page){
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        searchBar = page.getByPlaceholder("Isikan kriteria pencarian rumah kost / unit apartemen yang ingin Anda cek");
        propertyArea = page.locator(".minilist-container").first();
        nextButton = page.getByLabel("Next slide");
        closeButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(""));
    }

    /**
     * Navigate to Check Property URL
     */
    public void navigateToCheckPropertyPage() {
        playwright.navigateTo(Mamikos.CHECKPROPERTY_URL, 30000.0, LoadState.LOAD);
    }

    /**
     * Search Property by Nama Properto
     * @param keyword
     */
    public void searchNamaProperti(String keyword) {
        playwright.fill(searchBar, keyword);
        playwright.waitTillNetworkIdle();
    }

    /**
     * Get String Property Name
     * @param result
     * @return String Property Name
     */
    public String getPropertyName(String result) {
        propertyName = page.getByText(result, new Page.GetByTextOptions().setExact(true));

        playwright.waitTillLocatorIsVisible(propertyName);
        return playwright.getText(propertyName);
    }

    /**
     * Get String Property Address
     * @param result
     * @return String Property Address
     */
    public String getPropertyAddress(String result) {
        propertyAddress = page.getByText(result).first();
        return playwright.getText(propertyAddress);
    }

    /**
     * Clear Keyword in Search Bar
     */
    public void clearKeywordInSearchBar() {
        playwright.clearText(searchBar);
    }

    /**
     * Clicks on Property
     */
    public void opensProperty() {
        playwright.clickOn(propertyArea);
    }

    /**
     * Check if Next Button on Image is Disable
     * True = Disable
     * False = Enable
     * @return if Next Button on Image is Disable
     */
    public boolean isNextButtonDisable() {
        return playwright.isButtonDisable(nextButton);
    }

    /**
     * Clicks Close on Pop Up Property
     */
    public void closePopUpProperty() {
        playwright.clickOn(closeButton);
    }

    /**
     * Clicks Next Button on Image
     */
    public void clicksNextButtonOnImage() {
        playwright.clickOn(nextButton);
    }

    /**
     * Get String Property Title
     * @param title
     * @return String Property Title
     */
    public String getPropertyTitle(String title) {
        propertyTitle = page.locator("#photosModal").getByText(title);
        return playwright.getText(propertyTitle);
    }
}