package pageobject.license;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.PlaywrightHelpers;

public class LicenseMasterSubscriptionModulePO {

    private Page page;
    private PlaywrightHelpers playwright;

    Locator addPresetTab;
    Locator codeField;
    Locator nameField;
    Locator descriptionField;
    Locator saveButton;

    public LicenseMasterSubscriptionModulePO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        addPresetTab = page.locator("#master-add-edit-tab");
        codeField = page.locator("#master-code");
        nameField = page.locator("#master-name");
        descriptionField = page.locator("#master-description");
        saveButton = page.locator("#master-save");
    }

    /**
     * Click the "Add Preset" tab to open the create form.
     * The page uses #master-add-edit-tab (page-specific, not the shared #data-add-edit-tab).
     */
    public void clickAddPresetTab() {
        playwright.waitTillLocatorIsVisible(addPresetTab, 30000.0);
        playwright.clickOn(addPresetTab);
    }

    /**
     * Fill Code field
     */
    public void fillCode(String code) {
        playwright.fill(codeField, code);
    }

    /**
     * Fill Name field
     */
    public void fillName(String name) {
        playwright.fill(nameField, name);
    }

    /**
     * Fill Description textarea
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
                    response -> response.url().contains("/license/subscription-module-masters")
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
