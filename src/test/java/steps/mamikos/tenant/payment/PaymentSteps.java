package steps.mamikos.tenant.payment;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.tenant.InvoicePO;
import pageobject.tenant.payment.PaymentPO;
import pageobject.tenant.profile.RiwayatBookingPO;

public class PaymentSteps {
    Page page = ActiveContext.getActivePage();
    RiwayatBookingPO riwayatBookingPO = new RiwayatBookingPO(page);
    InvoicePO invoicePO;
    PaymentPO paymentPO;

    @And("tenant select payment method BNI with VA number {string} and amount {string}")
    public void paymentBNI(String VA, String amount) {
        invoicePO = riwayatBookingPO.clickOnBayarSekarangButton();
        ActiveContext.setActivePage(ActiveContext.getActiveBrowserContext().pages().get(1));
        paymentPO = invoicePO.paymentUsingBNI();
        ActiveContext.setActivePage(ActiveContext.getActiveBrowserContext().pages().get(1));
        paymentPO.paymentUsingBNI(VA, amount);
    }

    @And("tenant select payment method Credit Card with cc number is {string}, expired date month {string} years {string}, and ccv is {string}")
    public void tenantSelectPaymentMethodCreditCard(String ccNumber, String month, String years, String ccv) {
        invoicePO = riwayatBookingPO.clickOnBayarSekarangButton();
        ActiveContext.setActivePage(ActiveContext.getActiveBrowserContext().pages().get(1));
        paymentPO = invoicePO.paymentUsingCC(ccNumber, month, years, ccv);
        ActiveContext.setActivePage(ActiveContext.getActiveBrowserContext().pages().get(1));
        paymentPO.paymentUsingCC();
    }

    @And("tenant want to see invoice on riwayat booking after payment")
    public void seeInvoice() {
        paymentPO.seeInvoiceAfterPayment();
    }

    @Then("tenant will see payment is success")
    public void paymentSuccess() {
        Assert.assertTrue(paymentPO.isPaymentSuccess(), "Payment failed");
    }
}
