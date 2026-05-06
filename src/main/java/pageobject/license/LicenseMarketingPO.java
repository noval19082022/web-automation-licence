package pageobject.license;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import utilities.PlaywrightHelpers;

public class LicenseMarketingPO {

    private Page page;
    private PlaywrightHelpers playwright;

    Locator addRowTab;
    Locator codeField;
    Locator nameField;
    Locator emailField;
    Locator fullNameField;
    Locator phoneField;
    Locator statusSelect;
    Locator notesField;
    Locator saveButton;

    public LicenseMarketingPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        addRowTab = page.locator("#data-add-edit-tab");
        codeField = page.locator("#marketing-code");
        nameField = page.locator("#marketing-name");
        emailField = page.locator("#marketing-email");
        fullNameField = page.locator("#marketing-full-name");
        phoneField = page.locator("#marketing-phone");
        statusSelect = page.locator("#marketing-active");
        notesField = page.locator("#marketing-notes");
        saveButton = page.locator("#marketing-save");
    }

    /**
     * Click on Add Row tab to open the marketing add/edit form.
     */
    public void clickAddRowTab() {
        playwright.waitTillLocatorIsVisible(addRowTab, 30000.0);
        playwright.clickOn(addRowTab);
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
     * Fill Email field
     * @param email email string
     */
    public void fillEmail(String email) {
        playwright.fill(emailField, email);
    }

    /**
     * Fill Full Name field
     * @param fullName full name string
     */
    public void fillFullName(String fullName) {
        playwright.fill(fullNameField, fullName);
    }

    /**
     * Fill Phone field
     * @param phone phone number string
     */
    public void fillPhone(String phone) {
        playwright.fill(phoneField, phone);
    }

    /**
     * Select Status by visible label text (e.g. "Active", "Inactive").
     * @param label visible text of the option
     */
    public void selectStatus(String label) {
        statusSelect.selectOption(new SelectOption().setLabel(label));
    }

    /**
     * Fill Notes field
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
                    response -> response.url().contains("/license/marketing")
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
