package pageobject.tenant.profile;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import pageobject.tenant.InvoicePO;
import utilities.PlaywrightHelpers;

public class KostSayaBillingPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private Locator bayarButton;
    private Locator bayarDisiniButton;

    public KostSayaBillingPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        bayarButton = page.locator(".payment-action > .bg-c-button").first();
        bayarDisiniButton = page.locator(".bg-c-button");
    }

    /**
     * This method clicks on the "bayar" button and
     * @return  a new page object of type "InvoicePO".
     * It also waits for a popup before performing the click action.
     */
    public InvoicePO clickOnBayarButton() {
        page = page.waitForPopup(() -> {
            playwright.clickOn(bayarButton);
        });
        ActiveContext.setActivePage(page);
        return new InvoicePO(page);
    }

    /**
     * This method clicks on the "bayar" button in Tagihan Saya and
     * @return  a new page object of type "InvoicePO".
     * It also waits for a popup before performing the click action.
     */
    public InvoicePO clickOnBayarDisiniButton() {
        playwright.waitTillPageLoaded();
        playwright.clickOn(bayarDisiniButton);
        return new InvoicePO(page);
    }
}
