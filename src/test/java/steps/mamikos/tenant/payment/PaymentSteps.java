package steps.mamikos.tenant.payment;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.midtrans.MidtransPaymentPO;
import pageobject.tenant.InvoicePO;
import pageobject.tenant.kostSayaPO;
import pageobject.tenant.payment.PaymentPO;
import pageobject.tenant.profile.RiwayatBookingPO;
import pageobject.xendit.XenditApiPO;
import utilities.PlaywrightHelpers;

import java.util.List;
import java.util.Optional;

public class PaymentSteps {
    Page page = ActiveContext.getActivePage();
    RiwayatBookingPO riwayatBookingPO = new RiwayatBookingPO(page);
    InvoicePO invoicePO = new InvoicePO(page);
    PaymentPO paymentPO;
    MidtransPaymentPO midtransPaymentPO;
    XenditApiPO xenditAPI = new XenditApiPO(page);
    kostSayaPO kostSaya = new kostSayaPO(page);

    @And("tenant select payment method BNI with VA number {string} and amount {string}")
    public void paymentBNI(String VA, String amount) {
        invoicePO = riwayatBookingPO.clickOnBayarSekarangButton();
        ActiveContext.setActivePage(ActiveContext.getActiveBrowserContext().pages().get(1));
        paymentPO = invoicePO.paymentUsingBNI();
        ActiveContext.setActivePage(ActiveContext.getActiveBrowserContext().pages().get(1));
        paymentPO.paymentUsingBNI(VA, amount);
    }

    @And("tenant select payment method Credit Card")
    public void tenantSelectPaymentMethodCreditCard() {
        riwayatBookingPO.clickOnBayarSekarangButton()
                .paymentUsingCC("4000000000001091", "12", "30", "123")
                .paymentUsingCC();
    }

    @And("tenant/owner/user select payment from invoice detail using Credit Card")
    public void tenantSelectPaymentMamiadsCreditCard() {
        invoicePO.paymentUsingCC("4000000000001091", "12", "30", "123")
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
        paymentPO = Optional.ofNullable(paymentPO).orElseGet(() -> new PaymentPO(ActiveContext.getActivePage()));
        paymentPO.seeInvoiceAfterPayment();
    }

    @Then("tenant will see payment is success")
    public void paymentSuccess() {
        // this optional will check if object is null will create object using java lambda with lazy arg to avoid null pointer exception
        paymentPO = Optional.ofNullable(paymentPO).orElseGet(() -> new PaymentPO(ActiveContext.getActivePage()));
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

    @And("tenant/owner/user select payment method using {string}")
    public void tenantSelectPaymentMethodUsing(String Bank) {
        invoicePO = riwayatBookingPO.clickOnBayarSekarangButton();
        invoicePO.clickOnPilihPembayaran();
        invoicePO.clickOnPermata();
        invoicePO.clickOnBayarSekarang();
        var kodePembayaran = invoicePO.getKodePembayaranNumberText();
        var amountPembayaranBNI =invoicePO.getAmountPembayaranBNINumberText();
        // this optional will check if object is null will create object using java lambda with lazy arg to avoid null pointer exception
        midtransPaymentPO = Optional.ofNullable(midtransPaymentPO).orElseGet(() -> new MidtransPaymentPO(ActiveContext.getActivePage()));
        midtransPaymentPO.paymentForPermata(kodePembayaran, Bank);
        midtransPaymentPO.amountBNI(amountPembayaranBNI);
    }

    @And("owner/tenant/user select payment method from invoice detail using {string}")
    public void ownerSelectPaymentMethodUsing(String Bank) {
        invoicePO.clickOnPilihPembayaran();
        invoicePO.clickOnPermata();
        invoicePO.clickOnBayarSekarang();
        var kodePembayaran = invoicePO.getKodePembayaranNumberText();
        // this optional will check if object is null will create object using java lambda with lazy arg to avoid null pointer exception
        midtransPaymentPO = Optional.ofNullable(midtransPaymentPO).orElseGet(() -> new MidtransPaymentPO(ActiveContext.getActivePage()));
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
        var amountPembayaranBNI =invoicePO.getAmountPembayaranBNINumberText();
        page = ActiveContext.getActiveBrowserContext().pages().get(1);
        // this optional will check if object is null will create object using java lambda with lazy arg to avoid null pointer exception
        midtransPaymentPO = Optional.ofNullable(midtransPaymentPO).orElseGet(() -> new MidtransPaymentPO(ActiveContext.getActivePage()));
        midtransPaymentPO.paymentForBNI(kodePembayaran);
        midtransPaymentPO.amountBNI(amountPembayaranBNI);

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

    @And("tenant select payment method using BRI from riwayat booking")
    public void tenantSelectPaymentMethodUsingBRIFromRiwayatBooking() {
        invoicePO = riwayatBookingPO.clickOnBayarSekarangButton();
        invoicePO.clickOnPilihPembayaran();
        invoicePO.clickOnBRI();
        invoicePO.clickOnBayarSekarang();
        var kodePembayaran = invoicePO.getKodePembayaranNumberText();
        // this optional will check if object is null will create object using java lambda with lazy arg to avoid null pointer exception
        midtransPaymentPO = Optional.ofNullable(midtransPaymentPO).orElseGet(() -> new MidtransPaymentPO(ActiveContext.getActivePage()));
        midtransPaymentPO.paymentForBRI(kodePembayaran);
    }

    @And("tenant/owner/user select payment method from invoice detail using BRI")
    public void tenantSelectPaymentUsingBRI() {
        invoicePO.clickOnPilihPembayaran();
        invoicePO.clickOnBRI();
        invoicePO.clickOnBayarSekarang();
        var kodePembayaran = invoicePO.getKodePembayaranNumberText();
        // this optional will check if object is null will create object using java lambda with lazy arg to avoid null pointer exception
        midtransPaymentPO = Optional.ofNullable(midtransPaymentPO).orElseGet(() -> new MidtransPaymentPO(ActiveContext.getActivePage()));
        midtransPaymentPO.paymentForBRI(kodePembayaran);
    }
    @Then("user/tenant/admin refresh invoice page and see payment success")
    public void refreshInvoiceAndSeePaymentSucess() {
        var pw = new PlaywrightHelpers(ActiveContext.getActivePage());
        for (int i = 0; i < 3; i++) {
            pw.reloadPage();
        }
        var payment = new PaymentPO(ActiveContext.getActivePage());
        Assert.assertEquals(payment.isPaymentSuccessText(), "Pembayaran Berhasil", "Payment failed");
    }

    @And("owner/tenant/user select payment using alfamart xendit as payment method from invoice detail")
    public void paymentOwnerSuccessUsingAlfamartXenditAsPaymentMethod() {
        invoicePO.clickOnPilihPembayaran();
        invoicePO.clickOnAlfamart();
        invoicePO.clickOnBayarSekarang();
        var kodePerusahaan = invoicePO.getCodePembayaran();
        var nominal = invoicePO.getTotalPembayaran();
        xenditAPI.BayarAlfaViaPostman(kodePerusahaan, String.valueOf(nominal));
    }

    @And("owner/tenant/user select payment method from invoice detail using Permata")
    public void ownerSelectPaymentMethodUsingPermata() {
        invoicePO.clickOnPilihPembayaran();
        invoicePO.clickOnPermata();
        invoicePO.clickOnBayarSekarang();
        var kodePembayaran = invoicePO.getKodePembayaranNumberText();
        // this optional will check if object is null will create object using java lambda with lazy arg to avoid null pointer exception
        midtransPaymentPO = Optional.ofNullable(midtransPaymentPO).orElseGet(() -> new MidtransPaymentPO(ActiveContext.getActivePage()));
        midtransPaymentPO.paymentForPermata(kodePembayaran, "PERMATA");
    }

    @And("tenant click bayar sekarang before paid")
    public void tenantClickBayarSekarangBeforePaid() {
        invoicePO = riwayatBookingPO.clickOnBayarSekarangButton();
        invoicePO.clickOnPilihPembayaran();
        invoicePO.clickOnPermata();
        invoicePO.clickOnBayarSekarang();
        invoicePO.sayaSudahBayarBeforePaid();
    }

    @And("tenant click sudah di bayar")
    public void tenantClickSudahDiBayar() {
        kostSaya.clickSudahDiBayar();
    }

    @Then("tenant will see invoice {string}")
    public void tenantWillSeeInvoice(String statusInvoice) {
        Assert.assertEquals(kostSaya.isPaymentSuccessText(statusInvoice),""+statusInvoice +"");
    }
}
