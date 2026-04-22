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
     * Click Save button
     */
    public void clickSaveButton() {
        playwright.clickOn(saveButton);
        page.waitForLoadState();
    }

    /**
     * Verify success toast message is displayed after save
     * @return true if toast with "Organization created" is visible
     */
    public boolean isSuccessToastDisplayed() {
        Locator toast = page.locator("#toast-container .toast-body:has-text('Organization created')");
        return playwright.waitTillLocatorIsVisible(toast, 10000.0);
    }

    /**
     * Get the status text from the organization detail panel
     * @return status text (e.g. "Active", "Inactive")
     */
    public String getOrganizationDetailStatus() {
        Locator statusBadge = page.locator("#organization-detail-status");
        playwright.waitTillLocatorIsVisible(statusBadge, 30000.0);
        return playwright.getText(statusBadge);
    }
}
