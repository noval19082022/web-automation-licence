package pageobject.tenant.payment;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import data.mamikos.Mamikos;
import data.payment.Payment;
import utilities.PlaywrightHelpers;

public class PaymentPO {
    Page page;
    PlaywrightHelpers playwright;
    private Locator paymentSuccessText;

    public PaymentPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.paymentSuccessText = page.getByText("Pembayaran Berhasil").first();
    }

    /**
     * this method is step for payment using BNI
     *
     * @param virtualAcount
     * @param amount
     */
    public void paymentUsingBNI(String virtualAcount, String amount) {
        playwright.navigateTo(Payment.BNI_SIMULATOR, 30000.0, LoadState.LOAD);
        page.getByLabel("VA Number").click();
        page.keyboard().type(virtualAcount);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("")).click();
        page.getByLabel("Payment Amount").click();
        page.keyboard().type(amount);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Flag")).click();
        page.getByText("Transaction success. VA number " + virtualAcount + " has been paid with amount IDR " + amount).isVisible();
    }

    /**
     * Payment method using cc
     */
    public void paymentUsingCC() {
        page.waitForLoadState();
        page.frameLocator("#universalInvoiceContainer iframe").frameLocator("iframe[title=\"Bank Authentication\"]").getByPlaceholder(" Enter Code Here").click();
        page.frameLocator("#universalInvoiceContainer iframe").frameLocator("iframe[title=\"Bank Authentication\"]").getByPlaceholder(" Enter Code Here").fill("1234");
        page.frameLocator("#universalInvoiceContainer iframe").frameLocator("iframe[title=\"Bank Authentication\"]").getByText("SUBMIT").click();
        page.waitForTimeout(3_000);
        String urlPaymentSignature = page.url()
                .replace("select-payment/", "success-payment/")
                .replace("step=1", "step=3");
        page.navigate(urlPaymentSignature);
    }

    /**
     * it will navigate to detail invoice from riwayat booking after payment
     */
    public void seeInvoiceAfterPayment() {
        page.navigate(Mamikos.URL + Mamikos.TENANT_RIWAYAT_BOOKING);
        page.getByText("Lihat selengkapnya").first().click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Lihat Invoice")).click();
    }

    /**
     * check if payment is success
     *
     * @return boolean
     */
    public boolean isPaymentSuccess() {
        System.out.println(paymentSuccessText.textContent());
        return paymentSuccessText.isVisible();
    }
}
