package pageobject.license;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import utilities.PlaywrightHelpers;

public class LicenseSubscriptionPO {

    private Page page;
    private PlaywrightHelpers playwright;

    Locator addTab;
    Locator organizationSelect;
    Locator planSelect;
    Locator priceListSelect;
    Locator billingSelect;
    Locator statusSelect;
    Locator startDateField;
    Locator endDateField;
    Locator saveButton;

    public LicenseSubscriptionPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        addTab = page.locator("#subscription-add-edit-tab");
        organizationSelect = page.locator("#subscription-organization");
        planSelect = page.locator("#subscription-plan");
        priceListSelect = page.locator("#subscription-price-list");
        billingSelect = page.locator("#subscription-billing");
        statusSelect = page.locator("#subscription-status");
        startDateField = page.locator("#subscription-start-date");
        endDateField = page.locator("#subscription-end-date");
        saveButton = page.locator("#subscription-save");
    }

    /**
     * Click the "Add Subscription" tab to open the create form.
     * Subscriptions page uses #subscription-add-edit-tab (page-specific).
     */
    public void clickAddSubscriptionTab() {
        playwright.waitTillLocatorIsVisible(addTab, 30000.0);
        playwright.clickOn(addTab);
    }

    /**
     * Select the first option whose visible text contains the given partial label.
     * Used for dropdowns whose options are decorated (e.g. "John (AC-01)") so
     * scenarios can reference just "John" without knowing the full label.
     */
    private void selectByPartialLabel(Locator select, String partial) {
        Object value = select.evaluate(
                "(el, partial) => { const o = Array.from(el.options).find(o => o.textContent && o.textContent.includes(partial)); return o ? o.value : null; }",
                partial
        );
        if (value == null) {
            throw new RuntimeException("No option found containing '" + partial + "' in select " + select);
        }
        select.selectOption(value.toString());
    }

    /**
     * Select Organization by partial label match against decorated options
     * like "John (AC-01)" — accepts "John" or the full label.
     */
    public void selectOrganization(String organization) {
        playwright.waitTillLocatorIsVisible(organizationSelect, 30000.0);
        selectByPartialLabel(organizationSelect, organization);
    }

    /**
     * Select Plan by partial label match against decorated options
     * like "Invoice Testing (Invoice-001)".
     */
    public void selectPlan(String plan) {
        playwright.waitTillLocatorIsVisible(planSelect, 30000.0);
        selectByPartialLabel(planSelect, plan);
    }

    /**
     * Select Price List by partial label match against decorated options
     * like "Invoice Testing 20260505183754 (IDR-20260505183754) - IDR".
     */
    public void selectPriceList(String priceList) {
        playwright.waitTillLocatorIsVisible(priceListSelect, 30000.0);
        selectByPartialLabel(priceListSelect, priceList);
    }

    /**
     * Select Billing Cycle by visible label (e.g. "MONTHLY", "YEARLY").
     */
    public void selectBillingCycle(String label) {
        billingSelect.selectOption(new SelectOption().setLabel(label));
    }

    /**
     * Select Status by visible label (e.g. "Active", "Inactive").
     */
    public void selectStatus(String label) {
        statusSelect.selectOption(new SelectOption().setLabel(label));
    }

    /**
     * Fill Start Date input (HTML date expects YYYY-MM-DD).
     */
    public void fillStartDate(String date) {
        playwright.fill(startDateField, date);
    }

    /**
     * Fill End Date input (HTML date expects YYYY-MM-DD).
     */
    public void fillEndDate(String date) {
        playwright.fill(endDateField, date);
    }

    /**
     * Click Save button and wait for the create/update API call to complete so the
     * success toast is guaranteed to be triggered before the next step asserts it.
     */
    public void clickSaveButton() {
        try {
            page.waitForResponse(
                    response -> response.url().contains("/license/subscriptions")
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
