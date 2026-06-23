package pageobject.license;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.PlaywrightHelpers;

public class LicenseGenerateLicensePO {

    private Page page;
    private PlaywrightHelpers playwright;

    Locator orgContextDropdown;
    Locator orgContextSearch;
    Locator orgContextList;
    Locator generateActivationCodeButton;

    public LicenseGenerateLicensePO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        // Org-context selector — same Bootstrap dropdown pattern reused across
        // billing-invoices / proposals / subscription-modules screens.
        orgContextDropdown = page.locator("#org-context-dropdown");
        orgContextSearch = page.locator("#org-context-search");
        orgContextList = page.locator("#org-context-list");
        generateActivationCodeButton = page.locator("#btn-generate-code");
    }

    /**
     * Set the page-level organization context. Required before generating an
     * activation code — the button validates that an org is selected.
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
        page.waitForLoadState();
    }

    /**
     * Click "Generate Activation Code" and wait for the licensing API call.
     * Wraps the click in waitForResponse so the test does not race the async
     * call. Tolerates timeout silently — downstream assertions surface failure.
     */
    public void clickGenerateActivationCode() {
        try {
            page.waitForResponse(
                    response -> response.url().contains("/license/")
                            && (response.request().method().equalsIgnoreCase("POST")
                                    || response.request().method().equalsIgnoreCase("PUT")),
                    new Page.WaitForResponseOptions().setTimeout(20000),
                    () -> playwright.clickOn(generateActivationCodeButton)
            );
        } catch (com.microsoft.playwright.TimeoutError ignored) {
            // Generate did not fire (validation blocked submit) — assertion later will surface failure.
        }
    }
}
