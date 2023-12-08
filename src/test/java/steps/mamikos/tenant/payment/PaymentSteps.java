package steps.mamikos.tenant.payment;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.midtrans.MidtransPaymentPO;
import pageobject.tenant.InvoicePO;
import pageobject.tenant.payment.PaymentPO;
import pageobject.tenant.profile.RiwayatBookingPO;
import pageobject.xendit.XenditApiPO;

import java.util.List;
import java.util.Optional;

public class PaymentSteps {
    Page page = ActiveContext.getActivePage();
    RiwayatBookingPO riwayatBookingPO = new RiwayatBookingPO(page);
    InvoicePO invoicePO = new InvoicePO(page);
    PaymentPO paymentPO;
    MidtransPaymentPO midtransPaymentPO;
    XenditApiPO xenditAPI = new XenditApiPO(page);

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
        riwayatBookingPO.clickOnBayarSekarangButton()
                .paymentUsingCC(ccNumber, month, years, ccv)
                .paymentUsingCC();
    }

    @And("tenant/owner/user select payment from invoice detail using Credit Card with cc number is {string}, expired date month {string} years {string}, and ccv is {string}")
    public void tenantSelectPaymentMamiadsCreditCard(String ccNumber, String month, String years, String ccv) {
        invoicePO.paymentUsingCC(ccNumber, month, years, ccv)
                .paymentUsingCC();
    }

    @And("tenant select payment method with DANA")
    public void tenantSelectPaymentMethodWithDANA() {
        invoicePO = riwayatBookingPO.clickOnBayarSekarangButton();
        ActiveContext.setActivePage(ActiveContext.getActiveBrowserContext().pages().get(1));
        paymentPO = invoicePO.paymentUsingDANA();
        ActiveContext.setActivePage(ActiveContext.getActiveBrowserContext().pages().get(2));
    }

    @And("tenant/owner/user select payment from invoice detail with DANA")
    public void tenantSelectPaymentMamiadsWithDANA() {
        paymentPO = invoicePO.paymentUsingDANA();
        ActiveContext.setActivePage(ActiveContext.getActiveBrowserContext().pages().get(1));
    }

    @And("tenant select payment method using LinkAja")
    public void tenantSelectPaymentMethodUsingLinkAja() {
        invoicePO = riwayatBookingPO.clickOnBayarSekarangButton();
        ActiveContext.setActivePage(ActiveContext.getActiveBrowserContext().pages().get(1));
        paymentPO = invoicePO.paymentUsingLinkAja();
        ActiveContext.setActivePage(ActiveContext.getActiveBrowserContext().pages().get(2));
    }

    @And("tenant/owner/user select payment from invoice detail using LinkAja")
    public void tenantSelectPaymentMamiadsUsingLinkAja() {
        paymentPO = invoicePO.paymentUsingLinkAja();
        ActiveContext.setActivePage(ActiveContext.getActiveBrowserContext().pages().get(1));
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
        Assert.assertEquals(paymentPO.isPaymentSuccessText(), "Pembayaran Berhasil", "Payment failed");
    }

    @Then("tenant can not sees price with name {string} on invoice page")
    public void tenantCanNotSeesPriceWithNameOnInvoicePage(String addOnsPriceType) {
        invoicePO = new InvoicePO(ActiveContext.getActivePage());
        List<String> biayaLainnyaInnerText = invoicePO.getAdditionalPriceInnerText();
        Assert.assertFalse(biayaLainnyaInnerText.get(0).contains(addOnsPriceType));
    }

    @Then("user should see potongan mamipoin is {int} and total payment is {int}")
    public void user_should_see_potongan_mamipoin_and_total_payment(int DiscMamipoin, int ttlPayment) {
        invoicePO = new InvoicePO(ActiveContext.getActivePage());
        Assert.assertEquals(invoicePO.getDiscountMamipoinText(), DiscMamipoin, "Discount mamipoin is not equal");
        Assert.assertEquals(invoicePO.getTotalPembayaran(), ttlPayment, "Total payment is not equal");
    }

    @And("user remove voucher")
    public void userRemoveVoucher() {
        invoicePO = new InvoicePO(ActiveContext.getActivePage());
        invoicePO.clickOnDeleteVoucher();
    }

    @And("tenant select payment method using {string}")
    public void tenantSelectPaymentMethodUsing(String Bank) {
        invoicePO = riwayatBookingPO.clickOnBayarSekarangButton();
        invoicePO.clickOnPilihPembayaran();
        invoicePO.clickOnPermata();
        invoicePO.clickOnBayarSekarang();
        var kodePembayaran = invoicePO.getKodePembayaranNumberText();
        page = ActiveContext.getActiveBrowserContext().pages().get(1);
        // this optional will check if object is null will create object using java lambda with lazy arg to avoid null pointer exception
        midtransPaymentPO = Optional.ofNullable(midtransPaymentPO).orElseGet(() -> new MidtransPaymentPO(page));
        midtransPaymentPO.paymentForPermata(kodePembayaran, Bank);
    }

    @And("tenant is on invoice page and pay using ovo {string} without close the page")
    public void tenantIsOnInvoicePageAndPayUsingOvoWithoutCloseThePage(String phoneNumber) {
        invoicePO.paymentOVO(phoneNumber);
    }

    @And("tenant select payment method using BNI")
    public void tenantSelectPaymentMethodUsingBNI() {
        invoicePO = riwayatBookingPO.clickOnBayarSekarangButton();
        invoicePO.clickOnPilihPembayaran();
        invoicePO.clickOnBNI();
        invoicePO.clickOnBayarSekarang();
        var kodePembayaran = invoicePO.getKodePembayaranNumberText();
        page = ActiveContext.getActiveBrowserContext().pages().get(1);
        // this optional will check if object is null will create object using java lambda with lazy arg to avoid null pointer exception
        midtransPaymentPO = Optional.ofNullable(midtransPaymentPO).orElseGet(() -> new MidtransPaymentPO(page));
        midtransPaymentPO.paymentForBNI(kodePembayaran);
    }

    @And("tenant/owner/user select payment method from invoice detail using BNI")
    public void tenantSelectPaymentUsingBNI() {
        invoicePO.clickOnPilihPembayaran();
        invoicePO.clickOnBNI();
        invoicePO.clickOnBayarSekarang();
        var kodePembayaran = invoicePO.getKodePembayaranNumberText();
        // this optional will check if object is null will create object using java lambda with lazy arg to avoid null pointer exception
        midtransPaymentPO = Optional.ofNullable(midtransPaymentPO).orElseGet(() -> new MidtransPaymentPO(ActiveContext.getActivePage()));
        midtransPaymentPO.paymentForBNI(kodePembayaran);
    }

    @And("tenant select payment method using Alfamart")
    public void tenantSelectPaymentMethodUsingAlfamart() {
        invoicePO = riwayatBookingPO.clickOnBayarSekarangButton();
        invoicePO.clickOnPilihPembayaran();
        invoicePO.clickOnAlfamart();
        invoicePO.clickOnBayarSekarang();
        var kodePerusahaan = invoicePO.getCodePembayaran();
        var nominal = invoicePO.getTotalPembayaran();
        xenditAPI.BayarAlfaViaPostman(kodePerusahaan, String.valueOf(nominal));
        invoicePO.sayaSudahBayar();

    }
}
