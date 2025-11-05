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
    private Locator facilityRemoveButton;
    private Locator facilityTag;

    /**
     * Constructor for EditKostPO
     * @param page Playwright Page instance
     */
    public EditKostPO(Page page){
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        saveButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save"));
        successToast = page.locator(".alert b");
    }

    /**
     * Get category ID selector based on category name
     * @param category The facility category name
     * @return String CSS selector for the category
     */
    private String getCategoryID(String category) {
        switch (category){
            case "Fasilitas Umum":
                return "#inputFacilityShare_chosen";

            case "*Fasilitas Kamar":
                return "#inputFacilityRoom_chosen";

            case "Fasilitas Kamar Mandi":
                return "#inputFacilityBath_chosen";

            case "Fasilitas Parkir":
                return "#inputFacilityPark_chosen";

            case "Fasilitas Lainnya":
                return "#inputFacilityOther_chosen";

            case "Peraturan Kos":
                return "#inputKosRule_chosen";

            default:
                throw new IllegalArgumentException("Unknown category: " + category);
        }
    }

    /**
     * Add facility under specific category
     * @param category The facility category (e.g., "Fasilitas Umum", "Fasilitas Kamar")
     * @param facility The facility name to add
     */
    public void addFacility(String category, String facility) {
        String categoryID = getCategoryID(category);

        facilityDropdown = page.locator(categoryID);
        // Target only the li elements in the dropdown results, not the selected tags
        facilityTag = page.locator(categoryID + " .chosen-results li").getByText(facility,new Locator.GetByTextOptions().setExact(true));

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
        String categoryID = getCategoryID(category);

        facilityRemoveButton = page.locator(categoryID).getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHas(page.getByText(facility, new Page.GetByTextOptions().setExact(true)))).locator("a");

        playwright.pageScrollInView(facilityRemoveButton);
        playwright.clickOn(facilityRemoveButton);
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
