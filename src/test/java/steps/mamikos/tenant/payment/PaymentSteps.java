package steps.mamikos.tenant.payment;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.java.en.And;
import pageobject.tenant.payment.PaymentPO;
import utilities.PlaywrightHelpers;

public class PaymentSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    PaymentPO paymentPO = new PaymentPO(page);

    @And("tenant select payment method BNI with VA number {string} and amount {string}")
    public void paymentBNI(String VA, String amount) {
        paymentPO.paymentUsingBNI(VA, amount);
    }

    @And("tenant want to see invoice on riwayat booking after payment")
    public void seeInvoice() {
        playwright.navigateTo(Mamikos.URL + Mamikos.TENANT_RIWAYAT_BOOKING, 30000.0, LoadState.LOAD);
        paymentPO.seeInvoiceAfterPayment();
    }
}
