package pageobject.license;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.PlaywrightHelpers;

public class LicenseOrganizationLevelPO {

    private Page page;
    private PlaywrightHelpers playwright;

    Locator addEditTab;
    Locator tableBody;
    Locator firstRow;
    Locator nameField;
    Locator levelField;
    Locator descriptionField;
    Locator saveButton;

    public LicenseOrganizationLevelPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        addEditTab = page.locator("#data-add-edit-tab");
        tableBody = page.locator("#org-level-table-body");
        firstRow = page.locator("#org-level-table-body tr[data-id]").first();
        nameField = page.locator("#org-level-name");
        levelField = page.locator("#org-level-level");
        descriptionField = page.locator("#org-level-description");
        saveButton = page.locator("#org-level-save");
    }

    /**
     * Select the first data row and open the Add/Edit tab (now labeled "Edit Row"),
     * putting the form into edit mode for that row.
     */
    public void clickEditRowMenu() {
        playwright.waitTillLocatorIsVisible(tableBody, 30000.0);
        playwright.waitTillLocatorIsVisible(firstRow, 30000.0);
        playwright.clickOn(firstRow);
        playwright.waitTillLocatorIsVisible(addEditTab, 30000.0);
        playwright.clickOn(addEditTab);
    }

    /**
     * Fill Name field
     * @param name name string
     */
    public void fillName(String name) {
        playwright.fill(nameField, name);
    }

    /**
     * Fill Level field
     * @param level level number as string
     */
    public void fillLevel(String level) {
        playwright.fill(levelField, level);
    }

    /**
     * Fill Description field
     * @param description description string
     */
    public void fillDescription(String description) {
        playwright.fill(descriptionField, description);
    }

    /**
     * Click Save button and wait for the create/update API call to complete so the
     * success toast is guaranteed to be triggered before the next step asserts it.
     */
    public void clickSaveButton() {
        try {
            page.waitForResponse(
                    response -> response.url().contains("/license/organization-levels")
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
