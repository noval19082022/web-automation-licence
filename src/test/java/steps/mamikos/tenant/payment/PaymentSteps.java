package steps.mamikos.tenant.payment;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.tenant.InvoicePO;
import pageobject.tenant.payment.PaymentPO;
import pageobject.tenant.profile.RiwayatBookingPO;

import java.util.Optional;

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

    @And("tenant select payment method with DANA")
    public void tenantSelectPaymentMethodWithDANA() {
        invoicePO = riwayatBookingPO.clickOnBayarSekarangButton();
        ActiveContext.setActivePage(ActiveContext.getActiveBrowserContext().pages().get(1));
        paymentPO = invoicePO.paymentUsingDANA();
        ActiveContext.setActivePage(ActiveContext.getActiveBrowserContext().pages().get(2));
    }

    @And("tenant select payment method using LinkAja")
    public void tenantSelectPaymentMethodUsingLinkAja() {
        invoicePO = riwayatBookingPO.clickOnBayarSekarangButton();
        ActiveContext.setActivePage(ActiveContext.getActiveBrowserContext().pages().get(1));
        paymentPO = invoicePO.paymentUsingLinkAja();
        ActiveContext.setActivePage(ActiveContext.getActiveBrowserContext().pages().get(2));
    }

    @And("tenant want to see invoice on riwayat booking after payment")
    public void seeInvoice() {
        // this optional will check if object is null will create object using java lambda with lazy arg to avoid null pointer exception
        paymentPO = Optional.ofNullable(paymentPO).orElseGet(() -> new PaymentPO(page));
        paymentPO.seeInvoiceAfterPayment();
    }

    @Then("tenant will see payment is success")
    public void paymentSuccess() {
        // this optional will check if object is null will create object using java lambda with lazy arg to avoid null pointer exception
        paymentPO = Optional.ofNullable(paymentPO).orElseGet(() -> new PaymentPO(page));
        Assert.assertTrue(paymentPO.isPaymentSuccess(), "Payment failed");
    }
}
