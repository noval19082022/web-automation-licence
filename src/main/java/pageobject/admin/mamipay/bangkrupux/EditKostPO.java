package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import config.global.GlobalConfig;
import utilities.PlaywrightHelpers;

public class EditKostPO {
    private Page page;
    PlaywrightHelpers playwright;

    private Locator saveButton;
    private Locator successToast;
    private Locator facilityDropdown;
    private Locator facilityTag;

    /**
     * Constructor for EditKostPO
     * @param page Playwright Page instance
     */
    public EditKostPO(Page page){
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        saveButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save"));
        successToast = page.locator(".toast-success, .Toastify__toast--success, .success-message");
    }

    /**
     * Add facility under specific category
     * @param category The facility category (e.g., "Fasilitas Umum", "Fasilitas Kamar")
     * @param facility The facility name to add
     */
    public void addFacility(String category, String facility) {
        facilityDropdown = page.getByText(category);
        facilityTag = page.getByLabel(category).filter(new Locator.FilterOptions().setHasText(facility));

        playwright.pageScrollInView(facilityDropdown);
        playwright.clickOn(facilityDropdown);
        playwright.clickOn(facilityTag);
    }

    /**
     * Remove facility under specific category
     * @param category The facility category
     * @param facility The facility name to remove
     */
    public void removeFacility(String category, String facility) {
        Locator facilityCheckbox = page.locator("//input[@type='checkbox' and @value='" + facility + "']");

        if (facilityCheckbox.isChecked()) {
            playwright.clickOn(facilityCheckbox);
        }
    }

    /**
     * Click Save button to save kost changes
     */
    public void clickSave() {
        playwright.clickOn(saveButton);
        playwright.waitTillPageLoaded(GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT);
    }

    /**
     * Check if success toast message is visible
     * @return boolean element status
     */
    public boolean isSuccessToastVisible() {
        return playwright.isLocatorVisibleAfterLoad(successToast, 10000.0);
    }

    /**
     * Get success toast message text
     * @return String toast message text
     */
    public String getSuccessToastMessage() {
        return playwright.getText(successToast);
    }

    /**
     * Check if save button is visible
     * @return boolean element status
     */
    public boolean isSaveButtonVisible() {
        return playwright.isLocatorVisibleAfterLoad(saveButton, GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT);
    }
}
