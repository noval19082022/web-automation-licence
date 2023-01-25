package steps.mamikos.tenant;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import config.mamikos.Mamikos;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.tenant.InvoicePO;
import pageobject.tenant.KostSayaBillingPO;
import utilities.PlaywrightHelpers;

import java.util.List;
import java.util.Map;

public class TenantPaymentSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    KostSayaBillingPO billing = new KostSayaBillingPO(page);
    InvoicePO invoice;
    List<Map<String, String>> voucherName;

    @When("tenant navigate to tagihan kost saya")
    public void userNavigateToTagihanKostSaya() {
        playwright.navigateTo(Mamikos.URL + Mamikos.KOST_SAYA_BILLING, 30000.0, LoadState.LOAD);
    }

    @When("tenant go to invoice page")
    public void tenantGoToInvoicePage() {
        invoice = billing.clickOnBayarButton();
    }

    @When("tenant apply voucher:")
    public void tenantApplyVoucher(DataTable table) throws InterruptedException {
        voucherName = table.asMaps(String.class, String.class);
        var voucher = voucherName.get(0).get("voucher name " + Mamikos.ENV);
        invoice.clickOnDeleteVoucher();
        invoice.clickOnMasukkanVoucher();
        invoice.clickOnMasukkanVoucherPopUp();
        invoice.fillVoucherID(voucher);
        invoice.clickOnPakaiVoucherButton();
    }

    @Then("tenant can see voucher is applied")
    public void tenantCanSeeVoucherIsApplied() {
        Assert.assertEquals(invoice.getToastText(), "Voucher Dipakai");
        var voucher = voucherName.get(0).get("voucher name " + Mamikos.ENV);
        var subTotal = invoice.getSubTotal();
        var voucherDeductionValue = invoice.getVoucherReductionPrice(voucher);
        var totalPayment = invoice.getTotalPembayaran();
        var totalAfterDeduction = subTotal - voucherDeductionValue;
        Assert.assertEquals(totalPayment, totalAfterDeduction,
                "Check total pembayaran setelah voucher dipakai, subtotal pembayaran: " + subTotal + ", total pembayaran: " + totalPayment + ", diskon dari voucher: " + voucherDeductionValue);
        ActiveContext.getActiveBrowserContext().pages().get(1).close();
    }

    @Then("tenant can not use the voucher")
    public void tenantCanNotUseTheVoucher() {
        Assert.assertEquals(invoice.getToastText(), "Kode voucher tidak bisa digunakan. "+ System.lineSeparator() +"    Silakan hapus voucher.");
        Assert.assertTrue(invoice.isInvalidVoucherIconVisible(), "Voucher is valid, invalid voucher must have 'x' icon.");
    }

    @When("tenant remove voucher by toast message")
    public void tenantRemoveVoucherByToastMessage() {
        invoice = new InvoicePO(ActiveContext.getActiveBrowserContext().pages().get(1));
        invoice.clickOnHapusInToast();
    }

    @Then("tenant can see voucher is deleted")
    public void tenantCanSeeVoucherIsDeleted() {
        Assert.assertEquals(invoice.getToastText(), "Voucher Dihapus", "Voucher toast must appear after voucher is deleted");
    }

    @Then("Voucher code has been used")
    public void voucherCodeHasBeenUsed() {
        if (invoice.waitUntilvoucherUsedTextVisible())
        {
            Assert.assertEquals(invoice.getVoucherUsedText().trim(), "Kode voucher tidak bisa digunakan.");
        }
        invoice.closeVoucherPopUp();
    }
}
