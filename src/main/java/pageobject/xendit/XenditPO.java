package pageobject.xendit;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import pageobject.tenant.payment.PaymentPO;
import utilities.PlaywrightHelpers;

/**
 * Page Object for Xendit payment gateway
 * Handles payment confirmation on Xendit page (after clicking DANA/LinkAja on invoice page)
 */
public class XenditPO {
    private Page page;
    private PlaywrightHelpers playwright;

    Locator proceedToPayButton;

    public XenditPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);

        proceedToPayButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Proceed to Pay"));
    }

    /**
     * Complete DANA payment flow through Xendit gateway
     * Waits for and clicks "Proceed to Pay" button on Xendit page
     * Waits for redirect to payment completion page (success-payment or finish-payment)
     *
     * @return PaymentPO instance with the final payment page
     */
    public PaymentPO completeDanaPayment() {
        playwright.waitTillLocatorIsVisible(proceedToPayButton, 10000.0);
        playwright.clickOn(proceedToPayButton);

        // Wait for page navigation to complete (DANA typically redirects to success-payment with step=3)
        playwright.waitTillPageLoaded();
        playwright.hardWait(3000);

        return new PaymentPO(page);
    }

    /**
     * Complete LinkAja payment flow through Xendit gateway
     * Waits for and clicks "Proceed to Pay" button on Xendit page
     * Waits for redirect to payment completion page (success-payment or finish-payment)
     *
     * @return PaymentPO instance with the final payment page
     */
    public PaymentPO completeLinkAjaPayment() {
        playwright.waitTillLocatorIsVisible(proceedToPayButton, 10000.0);
        playwright.clickOn(proceedToPayButton);

        // Wait for page navigation to complete (LinkAja typically redirects to finish-payment with step=2)
        playwright.waitTillPageLoaded();
        playwright.hardWait(3000);

        return new PaymentPO(page);
    }
}
