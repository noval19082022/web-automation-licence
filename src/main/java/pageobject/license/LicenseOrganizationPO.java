package pageobject.license;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import utilities.PlaywrightHelpers;

public class LicenseOrganizationPO {

    private Page page;
    private PlaywrightHelpers playwright;

    Locator addRowTab;
    Locator codeField;
    Locator nameField;
    Locator organizationLevelSelect;
    Locator parentOrganizationSelect;
    Locator businessNameField;
    Locator countrySelect;
    Locator phoneField;
    Locator emailField;
    Locator postalCodeField;
    Locator npwpField;
    Locator addressField;
    Locator taxInvoiceNameField;
    Locator saveButton;
    Locator moreButton;

    public LicenseOrganizationPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        addRowTab = page.locator("#data-add-edit-tab");
        codeField = page.locator("#organization-code");
        nameField = page.locator("#organization-name");
        organizationLevelSelect = page.locator("#organization-level-id");
        parentOrganizationSelect = page.locator("#organization-parent-id");
        businessNameField = page.locator("#organization-business-name");
        countrySelect = page.locator("#organization-country");
        phoneField = page.locator("#organization-phone");
        emailField = page.locator("#organization-email");
        postalCodeField = page.locator("#organization-postal-code");
        npwpField = page.locator("#organization-npwp");
        addressField = page.locator("#organization-address");
        taxInvoiceNameField = page.locator("#organization-tax-invoice-name");
        saveButton = page.locator("#organization-save");
        moreButton = page.locator("button.dropdown-toggle:has-text('More'), button:has-text('More')").first();
    }

    /**
     * Click on Add Row tab
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
     * Select Organization Level by visible label text.
     * Waits for options to be loaded dynamically before selecting.
     * @param label visible text of the option
     */
    public void selectOrganizationLevel(String label) {
        organizationLevelSelect.waitFor(new Locator.WaitForOptions().setTimeout(30000));
        page.waitForFunction("() => document.querySelector('#organization-level-id').options.length > 1");
        organizationLevelSelect.selectOption(new SelectOption().setLabel(label));
    }

    /**
     * Select Parent Organization by visible label text.
     * Waits for options to be loaded dynamically (cascaded from Organization Level) before selecting.
     * @param label visible text of the option
     */
    public void selectParentOrganization(String label) {
        page.waitForFunction("() => document.querySelector('#organization-parent-id').options.length > 1");
        parentOrganizationSelect.selectOption(new SelectOption().setLabel(label));
    }

    /**
     * Fill Business Name field
     * @param businessName business name string
     */
    public void fillBusinessName(String businessName) {
        playwright.fill(businessNameField, businessName);
    }

    /**
     * Select Country by visible label text
     * @param label visible text of the option
     */
    public void selectCountry(String label) {
        countrySelect.selectOption(new SelectOption().setLabel(label));
    }

    /**
     * Fill Phone Number field
     * @param phone phone number string
     */
    public void fillPhone(String phone) {
        playwright.fill(phoneField, phone);
    }

    /**
     * Fill Email field
     * @param email email string
     */
    public void fillEmail(String email) {
        playwright.fill(emailField, email);
    }

    /**
     * Fill Postal Code field
     * @param postalCode postal code string
     */
    public void fillPostalCode(String postalCode) {
        playwright.fill(postalCodeField, postalCode);
    }

    /**
     * Fill NPWP field
     * @param npwp NPWP string
     */
    public void fillNpwp(String npwp) {
        playwright.fill(npwpField, npwp);
    }

    /**
     * Fill Address field
     * @param address address string
     */
    public void fillAddress(String address) {
        playwright.fill(addressField, address);
    }

    /**
     * Fill Tax Invoice Name field
     * @param taxInvoiceName tax invoice name string
     */
    public void fillTaxInvoiceName(String taxInvoiceName) {
        playwright.fill(taxInvoiceNameField, taxInvoiceName);
    }

    /**
     * Click Save button and wait for the create/update API call to complete so the
     * success toast is guaranteed to be triggered before the next step asserts it.
     */
    public void clickSaveButton() {
        try {
            page.waitForResponse(
                    response -> response.url().contains("/license/organizations")
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


    /**
     * Click on the More button to reveal the action dropdown
     */
    public void clickMoreButton() {
        playwright.waitTillLocatorIsVisible(moreButton, 30000.0);
        playwright.clickOn(moreButton);
    }

    /**
     * Click on an action item (e.g. Delete) inside the dropdown menu revealed by the More button
     * @param action visible text of the action (e.g. "Delete")
     */
    public void clickActionMenu(String action) {
        Locator actionItem = page.locator(
                ".dropdown-menu.show :is(a, button, li):has-text('" + action + "'), " +
                ".dropdown-menu :is(a, button, li):has-text('" + action + "')"
        ).first();
        playwright.waitTillLocatorIsVisible(actionItem, 30000.0);
        playwright.clickOn(actionItem);
    }

    /**
     * Click on a button inside the confirmation pop up / modal
     * @param label visible text of the button (e.g. "Delete")
     */
    public void clickConfirmationButton(String label) {
        Locator confirmButton = page.locator(
                ".modal.show button:has-text('" + label + "'), " +
                "[role='dialog'] button:has-text('" + label + "'), " +
                ".swal2-popup button:has-text('" + label + "')"
        ).first();
        playwright.waitTillLocatorIsVisible(confirmButton, 30000.0);
        playwright.clickOn(confirmButton);
        page.waitForLoadState();
    }
}
