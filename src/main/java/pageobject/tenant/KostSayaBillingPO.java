package pageobject.tenant;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class KostSayaBillingPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private Locator bayarButton;

    public KostSayaBillingPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        bayarButton = page.getByTestId("userKostClaim-list").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Bayar"));
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
        return new InvoicePO(page);
    }
}
