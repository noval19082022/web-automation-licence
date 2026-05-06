package pageobject.license;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import utilities.PlaywrightHelpers;

public class LicensePriceListPO {

    private Page page;
    private PlaywrightHelpers playwright;

    Locator codeField;
    Locator nameField;
    Locator currencySelect;
    Locator descriptionField;
    Locator saveButton;

    Locator itemsTab;
    Locator addItemButton;
    Locator itemChargeTypeSelect;
    Locator itemReferenceSelect;
    Locator itemBillingCycleSelect;
    Locator itemAmountField;
    Locator itemInitialAmountField;
    Locator itemSaveButton;

    public LicensePriceListPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        codeField = page.locator("#price-list-code");
        nameField = page.locator("#price-list-name");
        currencySelect = page.locator("#price-list-currency");
        descriptionField = page.locator("#price-list-description");
        saveButton = page.locator("#price-list-save");

        itemsTab = page.locator("#price-list-items-tab");
        addItemButton = page.locator("#price-list-item-add");
        itemChargeTypeSelect = page.locator("#price-list-item-charge-type");
        itemReferenceSelect = page.locator("#price-list-item-reference");
        itemBillingCycleSelect = page.locator("#price-list-item-billing-cycle");
        itemAmountField = page.locator("#price-list-item-amount");
        itemInitialAmountField = page.locator("#price-list-item-initial-amount");
        itemSaveButton = page.locator("#price-list-item-save");
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
     * Select Currency by visible label (e.g. "IDR").
     * @param label visible option label
     */
    public void selectCurrency(String label) {
        currencySelect.selectOption(new SelectOption().setLabel(label));
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
                    response -> response.url().contains("/license/price-lists")
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
     * Select a price list row by code. Clicks the table row whose text contains
     * the given code, which puts the form into edit mode for that price list and
     * exposes the per-row tabs (Overview, Items).
     * @param code unique code of the price list (e.g. "IDR-20260505183901")
     */
    public void selectByCode(String code) {
        Locator row = page.locator("tr:has-text(\"" + code + "\")").first();
        playwright.waitTillLocatorIsVisible(row, 30000.0);
        playwright.clickOn(row);
    }

    /**
     * Click the "Items" tab on the per-row detail panel to switch to items view.
     * Corresponds to the "add items" step (open the items section).
     */
    public void clickItemsTab() {
        playwright.waitTillLocatorIsVisible(itemsTab, 30000.0);
        playwright.clickOn(itemsTab);
    }

    /**
     * Click the "Add Item" button to open the add-item form within the items panel.
     */
    public void clickAddItemButton() {
        playwright.waitTillLocatorIsVisible(addItemButton, 30000.0);
        playwright.clickOn(addItemButton);
    }

    /**
     * Case-insensitive partial-label option resolver. Used because charge-type
     * options are uppercase ("PLAN") while scenario data may use mixed case ("Plan").
     */
    private void selectByPartialLabelInsensitive(Locator select, String partial) {
        Object value = select.evaluate(
                "(el, partial) => { const p = (partial||'').toLowerCase(); const o = Array.from(el.options).find(o => (o.textContent||'').toLowerCase().includes(p)); return o ? o.value : null; }",
                partial
        );
        if (value == null) {
            throw new RuntimeException("No option found containing '" + partial + "' (case-insensitive)");
        }
        select.selectOption(value.toString());
    }

    /**
     * Select Charge Type by partial label, case-insensitive
     * (options are uppercase: PLAN / MODULE / MOBILE_MODULE).
     */
    public void selectItemChargeType(String chargeType) {
        playwright.waitTillLocatorIsVisible(itemChargeTypeSelect, 30000.0);
        selectByPartialLabelInsensitive(itemChargeTypeSelect, chargeType);
    }

    /**
     * Select Reference by partial label. The Reference list cascades from Charge Type —
     * options are decorated like "Invoice Testing (Invoice-001)".
     */
    public void selectItemReference(String reference) {
        playwright.waitTillLocatorIsVisible(itemReferenceSelect, 30000.0);
        // Wait for the cascaded reference options to load (more than the placeholder).
        page.waitForFunction("() => document.querySelector('#price-list-item-reference').options.length > 1");
        selectByPartialLabelInsensitive(itemReferenceSelect, reference);
    }

    /**
     * Select Billing Cycle by visible label (e.g. "MONTHLY", "YEARLY").
     */
    public void selectItemBillingCycle(String label) {
        itemBillingCycleSelect.selectOption(new SelectOption().setLabel(label));
    }

    /**
     * Fill Amount input.
     */
    public void fillItemAmount(String amount) {
        playwright.fill(itemAmountField, amount);
    }

    /**
     * Fill Initial Amount input.
     */
    public void fillItemInitialAmount(String amount) {
        playwright.fill(itemInitialAmountField, amount);
    }

    /**
     * Click "Save Item" and wait for the create/update API call to fire.
     * Distinct from the header-level clickSaveButton (#price-list-save).
     */
    public void clickSaveItemButton() {
        try {
            page.waitForResponse(
                    response -> response.url().contains("/license/price-lists")
                            && (response.request().method().equalsIgnoreCase("POST")
                                    || response.request().method().equalsIgnoreCase("PUT")),
                    new Page.WaitForResponseOptions().setTimeout(20000),
                    () -> playwright.clickOn(itemSaveButton)
            );
        } catch (com.microsoft.playwright.TimeoutError ignored) {
            // No save request was fired (client-side validation blocked submit).
        }
    }

    /**
     * @return true if the per-item add/edit form is currently visible.
     * Used by the steps layer to route the generic "save" step to the
     * correct save button when both forms exist on the same page.
     */
    public boolean isItemFormActive() {
        try {
            return itemSaveButton.isVisible() && itemChargeTypeSelect.isVisible();
        } catch (Throwable ignored) {
            return false;
        }
    }
}
