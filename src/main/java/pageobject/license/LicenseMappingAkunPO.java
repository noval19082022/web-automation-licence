package pageobject.license;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import utilities.PlaywrightHelpers;

public class LicenseMappingAkunPO {

    private Page page;
    private PlaywrightHelpers playwright;

    Locator addRowTab;
    Locator marketingTrigger;
    Locator marketingSearch;
    Locator marketingList;
    Locator organizationTrigger;
    Locator organizationSearch;
    Locator organizationList;
    Locator effectiveFromField;
    Locator effectiveToField;
    Locator statusSelect;
    Locator notesField;
    Locator saveButton;

    public LicenseMappingAkunPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        addRowTab = page.locator("#data-add-edit-tab");
        marketingTrigger = page.locator("#mapping-marketing-id-dropdown");
        marketingSearch = page.locator("#mapping-marketing-id-search");
        marketingList = page.locator("#mapping-marketing-id-list");
        organizationTrigger = page.locator("#mapping-organization-id-dropdown");
        organizationSearch = page.locator("#mapping-organization-id-search");
        organizationList = page.locator("#mapping-organization-id-list");
        effectiveFromField = page.locator("#mapping-effective-from");
        effectiveToField = page.locator("#mapping-effective-to");
        statusSelect = page.locator("#mapping-active");
        notesField = page.locator("#mapping-notes");
        saveButton = page.locator("#mapping-save");
    }

    /**
     * Click on Add Row tab to open the mapping add/edit form.
     */
    public void clickAddRowTab() {
        playwright.waitTillLocatorIsVisible(addRowTab, 30000.0);
        playwright.clickOn(addRowTab);
    }

    /**
     * Select a marketing entry via the searchable dropdown:
     * open trigger, type the search term, then click the first matching option.
     * The dropdown items are rendered as button.dropdown-item inside the list.
     * @param marketing search term (matches against visible option text e.g. "Zenix 02 (ZENIX-002)")
     */
    public void selectMarketing(String marketing) {
        playwright.waitTillLocatorIsVisible(marketingTrigger, 30000.0);
        playwright.clickOn(marketingTrigger);
        playwright.waitTillLocatorIsVisible(marketingSearch, 10000.0);
        playwright.fill(marketingSearch, marketing);
        Locator option = marketingList.locator(".dropdown-item").first();
        playwright.waitTillLocatorIsVisible(option, 15000.0);
        playwright.clickOn(option);
    }

    /**
     * Select a root organization via the searchable dropdown.
     * @param organization search term (matches against visible option text)
     */
    public void selectRootOrganization(String organization) {
        playwright.waitTillLocatorIsVisible(organizationTrigger, 30000.0);
        playwright.clickOn(organizationTrigger);
        playwright.waitTillLocatorIsVisible(organizationSearch, 10000.0);
        playwright.fill(organizationSearch, organization);
        Locator option = organizationList.locator(".dropdown-item").first();
        playwright.waitTillLocatorIsVisible(option, 15000.0);
        playwright.clickOn(option);
    }

    /**
     * Fill Effective From date input (HTML date input expects YYYY-MM-DD).
     * @param date date string e.g. "2026-04-24"
     */
    public void fillEffectiveFrom(String date) {
        playwright.fill(effectiveFromField, date);
    }

    /**
     * Fill Effective To date input (HTML date input expects YYYY-MM-DD).
     * @param date date string e.g. "2027-04-24"
     */
    public void fillEffectiveTo(String date) {
        playwright.fill(effectiveToField, date);
    }

    /**
     * Select Status by visible label (e.g. "Active", "Inactive").
     * Backed by a boolean select (value true/false), so labels are matched.
     * @param label visible option label
     */
    public void selectStatus(String label) {
        statusSelect.selectOption(new SelectOption().setLabel(label));
    }

    /**
     * Fill Notes textarea.
     * @param notes notes string
     */
    public void fillNotes(String notes) {
        playwright.fill(notesField, notes);
    }

    /**
     * Click Save button and wait for the create/update API call to complete so the
     * success toast is guaranteed to be triggered before the next step asserts it.
     */
    public void clickSaveButton() {
        try {
            page.waitForResponse(
                    response -> response.url().contains("/license/marketing-account-mappings")
                            && (response.request().method().equalsIgnoreCase("POST")
                                    || response.request().method().equalsIgnoreCase("PUT")),
                    new Page.WaitForResponseOptions().setTimeout(20000),
                    () -> playwright.clickOn(saveButton)
            );
        } catch (com.microsoft.playwright.TimeoutError ignored) {
            // No save request was fired (client-side validation blocked submit);
            // the subsequent toast assertion will surface the failure with a clearer signal.
        }
    }
}
