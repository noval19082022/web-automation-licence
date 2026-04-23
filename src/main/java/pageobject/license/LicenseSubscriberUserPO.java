package pageobject.license;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.PlaywrightHelpers;

public class LicenseSubscriberUserPO {

    private Page page;
    private PlaywrightHelpers playwright;

    Locator usernameField;
    Locator emailField;
    Locator phoneField;
    Locator fullNameField;
    Locator saveButton;
    Locator firstViewButton;
    Locator toolbarDeleteButton;

    public LicenseSubscriberUserPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        usernameField = page.locator("#subscriber-user-username");
        emailField = page.locator("#subscriber-user-email");
        phoneField = page.locator("#subscriber-user-phone-number");
        fullNameField = page.locator("#subscriber-user-full-name");
        saveButton = page.locator("#subscriber-user-save");
        firstViewButton = page.locator("#subscriber-user-table-body button[data-action='view']").first();
        toolbarDeleteButton = page.locator("#subscriber-user-delete-button");
    }

    /**
     * Fill Username field
     * @param username username string
     */
    public void fillUsername(String username) {
        playwright.fill(usernameField, username);
    }

    /**
     * Fill Email field
     * @param email email string
     */
    public void fillEmail(String email) {
        playwright.fill(emailField, email);
    }

    /**
     * Fill Phone Number field
     * @param phone phone number string
     */
    public void fillPhone(String phone) {
        playwright.fill(phoneField, phone);
    }

    /**
     * Fill Full Name field
     * @param fullName full name string
     */
    public void fillFullName(String fullName) {
        playwright.fill(fullNameField, fullName);
    }

    /**
     * Click the View button on the first data row. Selects the row and loads its detail,
     * which enables the top toolbar Delete button.
     */
    public void clickViewButton() {
        playwright.waitTillLocatorIsVisible(firstViewButton, 30000.0);
        playwright.clickOn(firstViewButton);
    }

    /**
     * Click the top toolbar Delete button (becomes enabled after a row is selected/viewed).
     * Opens the delete confirmation modal.
     */
    public void clickToolbarDeleteButton() {
        playwright.waitTillLocatorIsVisible(toolbarDeleteButton, 30000.0);
        playwright.clickOn(toolbarDeleteButton);
    }

    /**
     * Click Save button and wait for the create/update API call to complete so the
     * success toast is guaranteed to be triggered before the next step asserts it.
     */
    public void clickSaveButton() {
        try {
            page.waitForResponse(
                    response -> response.url().contains("/license/subscriber-users")
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
