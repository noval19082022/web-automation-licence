package pageobject.license;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import utilities.PlaywrightHelpers;

public class LicenseMasterSubscriptionModulePO {

    private Page page;
    private PlaywrightHelpers playwright;

    Locator addPresetTab;
    Locator codeField;
    Locator nameField;
    Locator descriptionField;
    Locator saveButton;

    // Per-preset Modules sub-flow on /license/subscription-module-master-modules
    Locator modulesButton;
    Locator addModuleTab;
    Locator moduleSelect;
    Locator sourceSelect;
    Locator moduleSaveButton;

    public LicenseMasterSubscriptionModulePO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        addPresetTab = page.locator("#master-add-edit-tab");
        codeField = page.locator("#master-code");
        nameField = page.locator("#master-name");
        descriptionField = page.locator("#master-description");
        saveButton = page.locator("#master-save");

        // Modules sub-flow
        modulesButton = page.locator("button:has-text('Modules')").first();
        addModuleTab = page.locator("#master-module-add-edit-tab");
        moduleSelect = page.locator("#master-module-module");
        sourceSelect = page.locator("#master-module-source");
        moduleSaveButton = page.locator("#master-module-save");
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

    /**
     * Click the row-level "Modules" button on the preset table to navigate into
     * that preset's modules sub-page (/license/subscription-module-master-modules).
     * The button has no id and there are multiple "Modules" buttons; the first one
     * (the most-recently created preset's row) is clicked.
     */
    public void clickModulesButton() {
        playwright.waitTillLocatorIsVisible(modulesButton, 30000.0);
        playwright.clickOn(modulesButton);
        page.waitForLoadState();
    }

    /**
     * Click the "Add Module" tab on the modules sub-page to open the per-module form.
     */
    public void clickAddModuleTab() {
        playwright.waitTillLocatorIsVisible(addModuleTab, 30000.0);
        playwright.clickOn(addModuleTab);
    }

    /**
     * Case-insensitive partial-label option resolver, used because option labels
     * may carry decoration (e.g. "Involvia System Admin").
     */
    private void selectByPartialLabel(Locator select, String partial) {
        Object value = select.evaluate(
                "(el, partial) => { const p = (partial||'').toLowerCase(); const o = Array.from(el.options).find(o => (o.textContent||'').toLowerCase().includes(p)); return o ? o.value : null; }",
                partial
        );
        if (value == null) {
            throw new RuntimeException("No option found containing '" + partial + "'");
        }
        select.selectOption(value.toString());
    }

    /**
     * Select Module by partial label (e.g. "Involvia System Admin").
     */
    public void selectModule(String module) {
        playwright.waitTillLocatorIsVisible(moduleSelect, 30000.0);
        selectByPartialLabel(moduleSelect, module);
    }

    /**
     * Select Source by visible label — exact match (PLAN / MANUAL / ADDON).
     */
    public void selectSource(String label) {
        sourceSelect.selectOption(new SelectOption().setLabel(label));
    }

    /**
     * Click "Simpan" on the per-module form and wait for the create/update API call.
     * Distinct from the preset-level clickSaveButton (#master-save vs #master-module-save).
     */
    public void clickSaveModuleButton() {
        try {
            page.waitForResponse(
                    response -> response.url().contains("/license/subscription-module-master-modules")
                            && (response.request().method().equalsIgnoreCase("POST")
                                    || response.request().method().equalsIgnoreCase("PUT")),
                    new Page.WaitForResponseOptions().setTimeout(20000),
                    () -> playwright.clickOn(moduleSaveButton)
            );
        } catch (com.microsoft.playwright.TimeoutError ignored) {
            // Save did not fire (validation blocked).
        }
    }

    /**
     * @return true if the per-module add/edit form is currently visible.
     * Used by the steps layer to route the generic "save" step when both a preset
     * form and a module form may exist on related URLs.
     */
    public boolean isModuleFormActive() {
        try {
            return moduleSaveButton.isVisible() && moduleSelect.isVisible();
        } catch (Throwable ignored) {
            return false;
        }
    }
}
