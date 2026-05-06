package pageobject.license;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.PlaywrightHelpers;

public class LicensePlanPO {

    private Page page;
    private PlaywrightHelpers playwright;

    Locator addPlanTab;
    Locator codeField;
    Locator nameField;
    Locator descriptionField;
    Locator saveButton;

    public LicensePlanPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        addPlanTab = page.locator("#plan-add-edit-tab");
        codeField = page.locator("#plan-code");
        nameField = page.locator("#plan-name");
        descriptionField = page.locator("#plan-description");
        saveButton = page.locator("#plan-save");
    }

    /**
     * Click on the "Add Plan" tab to open the plan add/edit form.
     * The plans page uses #plan-add-edit-tab (page-specific), not the shared #data-add-edit-tab.
     */
    public void clickAddPlanTab() {
        playwright.waitTillLocatorIsVisible(addPlanTab, 30000.0);
        playwright.clickOn(addPlanTab);
    }

    /**
     * Fill Code field
     * @param code code string
     */
    public void fillCode(String code) {
        playwright.fill(codeField, code);
    }

    /**
     * Fill Name field
     * @param name name string
     */
    public void fillName(String name) {
        playwright.fill(nameField, name);
    }

    /**
     * Fill Description textarea.
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
                    response -> response.url().contains("/license/plans")
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
