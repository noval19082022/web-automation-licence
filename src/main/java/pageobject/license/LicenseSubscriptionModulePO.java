package pageobject.license;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import utilities.PlaywrightHelpers;

public class LicenseSubscriptionModulePO {

    private Page page;
    private PlaywrightHelpers playwright;

    Locator subscriptionSelect;
    Locator moduleSelect;
    Locator priceItemSelect;
    Locator sourceSelect;
    Locator saveButton;

    Locator orgContextDropdown;
    Locator orgContextSearch;
    Locator orgContextList;

    // Top-level (page header) controls — present even when add-row form isn't open.
    Locator contextSubscriptionSelect;
    Locator applyMasterPresetButton;

    public LicenseSubscriptionModulePO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        // Note: this form does not expose Price List as an independent input —
        // the price list is derived from the chosen Subscription (cascade).
        subscriptionSelect = page.locator("#submodule-subscription");
        moduleSelect = page.locator("#submodule-module");
        priceItemSelect = page.locator("#submodule-price-item");
        sourceSelect = page.locator("#submodule-source");
        saveButton = page.locator("#submodule-save");

        // Page-level "Select organization" dropdown — must be set first to populate
        // the Subscription/Module/Price Item options with org-scoped data.
        orgContextDropdown = page.locator("#org-context-dropdown");
        orgContextSearch = page.locator("#org-context-search");
        orgContextList = page.locator("#org-context-list");

        // Page header — visible without entering add-row mode.
        contextSubscriptionSelect = page.locator("#submodule-context-subscription");
        applyMasterPresetButton = page.locator("#submodule-apply-master-button");
    }

    /**
     * Select the first option whose visible text contains the given partial label.
     * Used for native &lt;select&gt; whose options carry decoration (e.g. "John (AC-01)")
     * so scenarios can reference the bare value.
     */
    private void selectByPartialLabel(Locator select, String partial) {
        Object value = select.evaluate(
                "(el, partial) => { const o = Array.from(el.options).find(o => o.textContent && o.textContent.includes(partial)); return o ? o.value : null; }",
                partial
        );
        if (value == null) {
            throw new RuntimeException("No option found containing '" + partial + "'");
        }
        select.selectOption(value.toString());
    }

    /**
     * Set the page-level organization context required by this page before
     * Subscription/Module options can populate.
     * Opens the #org-context-dropdown, types into search, and clicks the
     * matching .dropdown-item (click commits the selection — no Apply button).
     * @param organization partial label, e.g. "PT.Super Smart TBK"
     */
    public void selectOrganizationContext(String organization) {
        playwright.waitTillLocatorIsVisible(orgContextDropdown, 30000.0);
        playwright.clickOn(orgContextDropdown);
        playwright.waitTillLocatorIsVisible(orgContextSearch, 10000.0);
        playwright.fill(orgContextSearch, organization);
        Locator option = orgContextList.locator(".dropdown-item")
                .filter(new Locator.FilterOptions().setHasText(organization))
                .first();
        playwright.waitTillLocatorIsVisible(option, 15000.0);
        playwright.clickOn(option);
        // Allow the page to refetch org-scoped data (subscription / module options)
        page.waitForLoadState();
    }

    /**
     * Select Subscription by partial label. Note: this select is gated on an
     * organization context being set first (page-level org-context selector).
     */
    public void selectSubscription(String subscription) {
        playwright.waitTillLocatorIsVisible(subscriptionSelect, 30000.0);
        selectByPartialLabel(subscriptionSelect, subscription);
    }

    /**
     * Select Module by partial label.
     */
    public void selectModule(String module) {
        playwright.waitTillLocatorIsVisible(moduleSelect, 30000.0);
        selectByPartialLabel(moduleSelect, module);
    }

    /**
     * Select Price Item by partial label (default option is "Follow plan price").
     */
    public void selectPriceItem(String priceItem) {
        playwright.waitTillLocatorIsVisible(priceItemSelect, 30000.0);
        selectByPartialLabel(priceItemSelect, priceItem);
    }

    /**
     * Select Source by visible label (exact match — options are "PLAN" / "MANUAL").
     */
    public void selectSource(String label) {
        sourceSelect.selectOption(new SelectOption().setLabel(label));
    }

    /**
     * Select Subscription on the page-header context selector
     * (#submodule-context-subscription) — distinct from the add-form
     * Subscription select (#submodule-subscription) used by selectSubscription().
     * Use this when the scenario sets a subscription context without entering add-row mode.
     */
    public void selectContextSubscription(String subscription) {
        playwright.waitTillLocatorIsVisible(contextSubscriptionSelect, 30000.0);
        page.waitForFunction("() => document.querySelector('#submodule-context-subscription').options.length > 1");
        selectByPartialLabel(contextSubscriptionSelect, subscription);
        // Page reloads scoped data after subscription context changes.
        page.waitForLoadState();
    }

    /**
     * Click the "Apply Master Preset" button on the page header.
     * Triggers the master-preset apply flow (resets/applies preset modules to the
     * current subscription context).
     */
    public void clickApplyMasterPreset() {
        playwright.waitTillLocatorIsVisible(applyMasterPresetButton, 30000.0);
        playwright.clickOn(applyMasterPresetButton);
    }

    /**
     * Click Save button and wait for the create/update API call to complete so the
     * success toast is guaranteed to be triggered before the next step asserts it.
     */
    public void clickSaveButton() {
        try {
            page.waitForResponse(
                    response -> response.url().contains("/license/subscription-modules")
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
