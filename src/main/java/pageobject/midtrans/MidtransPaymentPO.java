package pageobject.midtrans;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class MidtransPaymentPO {
    private Page page;
    private PlaywrightHelpers playwright;
    Locator billerCode;
    Locator paymentCode;
    Locator inquireButton;
    Locator payButton;
    Locator successTransaction;

    public MidtransPaymentPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        billerCode = page.locator("#biller_code");
        paymentCode = page.locator("#payment_code");
        inquireButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Inquire"));
        payButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pay"));
        successTransaction = page.getByText("Success Transaction");
    }

    /**
     * Input company number
     * @param code company code number
     */
    public void inputBillerCode(String code) {
        billerCode.fill(code);
    }

    /**
     * Input payment virtual account code
     * @param code payment virtual account
     */
    public void inputPaymentCode(String code) {
        paymentCode.fill(code);
    }

    /**
     * Click on inquire button
     */
    public void clickOnInquireButton() {
        playwright.clickOn(inquireButton);
    }

    /**
     * Click on pay button
     */
    public void clickOnPayButton() {
        playwright.clickOn(payButton);
    }

    /**
     * Wait for payment success
     */
    public void waitForSuccessTransaction() {
        playwright.waitFor(successTransaction, 30000.0);
    }
}
