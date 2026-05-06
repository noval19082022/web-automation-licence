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
