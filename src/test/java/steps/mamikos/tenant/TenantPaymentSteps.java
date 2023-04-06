package steps.mamikos.tenant;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import data.payment.Payment;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.midtrans.MidtransPaymentPO;
import pageobject.owner.OwnerDashboardPO;
import pageobject.tenant.InvoicePO;
import pageobject.tenant.profile.KostSayaBillingPO;
import pageobject.tenant.profile.RiwayatBookingPO;
import testdata.InvoiceTestData;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public class TenantPaymentSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    KostSayaBillingPO billing = new KostSayaBillingPO(page);
    InvoicePO invoice = new InvoicePO(page);
    RiwayatBookingPO riwayatBooking = new RiwayatBookingPO(page);
    MidtransPaymentPO midtrans = new MidtransPaymentPO(page);
    List<Map<String, String>> voucherName;
    private List<Map<String, String>> filterKost;
    private JavaHelpers java = new JavaHelpers();
    OwnerDashboardPO ownerDashboard = new OwnerDashboardPO(page);

    @When("tenant go to invoice page")
    public void tenantGoToInvoicePage() {
        invoice = billing.clickOnBayarButton();
    }

    @When("tenant go to invoice page after pay DP")
    public void tenantGoToInvoicePageAfterPayDP(){
        invoice = billing.clickOnBayarDisiniButton();
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
    }

    @Then("tenant can not use the voucher")
    public void tenantCanNotUseTheVoucher() {
        Assert.assertEquals(invoice.getToastText(), "Kode voucher tidak bisa digunakan. "+ System.lineSeparator() +"    Silakan hapus voucher.");
        Assert.assertTrue(invoice.isInvalidVoucherIconVisible(), "Voucher is valid, invalid voucher must have 'x' icon.");
    }

    @When("tenant remove voucher by toast message")
    public void tenantRemoveVoucherByToastMessage() {
        invoice = new InvoicePO(page);
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

    @Then("tenant can not use voucher with message {string}")
    public void tenantCanNotUseVoucheWithMessage(String errorMessage) {
        Assert.assertEquals(invoice.getToastText(), errorMessage + System.lineSeparator() +"    Silakan hapus voucher.");
        Assert.assertTrue(invoice.isInvalidVoucherIconVisible(), "Voucher is valid, invalid voucher must have 'x' icon.");
    }

    @Then("tenant can see warning message {string}")
    public synchronized void tenantCanSeeWarningMessage(String warningMessage) {
        Assert.assertEquals(invoice.voucherInputPopUpWarningText(), warningMessage);
    }

    /**
     * Step hanya bisa digunakan ketika pop-up input voucher tampil di layar.
     * Step untuk flow continue pengetesan invalid dan valid voucher
     */
    @When("tenant input voucher:")
    public void tenantInputVoucher(DataTable table) {
        voucherName = table.asMaps(String.class, String.class);
        var voucher = voucherName.get(0).get("voucher name " + Mamikos.ENV);
        invoice.fillVoucherID(voucher);
        invoice.clickOnPakaiVoucherButton();
    }

    @When("tenant pay kost from riwayat booking using mandiri")
    public void tenantPayKostFromRiwayatBooking() {
        invoice = riwayatBooking.clickOnBayarSekarangButton();
        invoice.clickOnPilihPembayaran();
        invoice.clickOnMandiri();
        invoice.clickOnBayarSekarang();
        var kodePerusahaan = invoice.getCompanyCodeText();
        var nomorVirtualAccount = invoice.getVirtualAccountNumberText();
        page = ActiveContext.getActiveBrowserContext().pages().get(1);
        playwright = new PlaywrightHelpers(page);
        playwright.navigateTo(Payment.MANDIRI_MIDTRANS, 30000.0, LoadState.LOAD);
        midtrans = new MidtransPaymentPO(page);
        midtrans.inputBillerCode(kodePerusahaan);
        midtrans.inputPaymentCode(nomorVirtualAccount);
        midtrans.clickOnInquireButton();
        midtrans.clickOnPayButton();
        midtrans.waitForSuccessTransaction();
        ActiveContext.getActiveBrowserContext().pages().get(1).close();
    }

    @When("tenant pay kost from riwayat booking using mandiri without close the page")
    public void tenantPayKostFromRiwayatBookingWithoutCloseThePage() {
        invoice = riwayatBooking.clickOnBayarSekarangButton();
        invoice.clickOnPilihPembayaran();
        invoice.clickOnMandiri();
        invoice.clickOnBayarSekarang();
        var kodePerusahaan = invoice.getCompanyCodeText();
        var nomorVirtualAccount = invoice.getVirtualAccountNumberText();
        page = ActiveContext.getActiveBrowserContext().pages().get(1);
        playwright = new PlaywrightHelpers(page);
        playwright.navigateTo(Payment.MANDIRI_MIDTRANS, 30000.0, LoadState.LOAD);
        midtrans = new MidtransPaymentPO(page);
        midtrans.inputBillerCode(kodePerusahaan);
        midtrans.inputPaymentCode(nomorVirtualAccount);
        midtrans.clickOnInquireButton();
        midtrans.clickOnPayButton();
        midtrans.waitForSuccessTransaction();
    }

    @When("tenant get invoice number")
    public void tenantGetInvoiceNumber() {
        invoice = new InvoicePO(ActiveContext.getActivePage());
        InvoiceTestData.setInvoiceNumber(invoice.getInvoiceNumber());
    }

    @Then("tenant can sees total cost is equal to basic amount, admin fee plus additional price below")
    public void tenantCanSeesTotalCostIsEqualToBasicAmountAdminFeePlusAdditionalPriceBelow(List<Integer> priceList) {
        int totalCost = JavaHelpers.extractNumber(invoice.getTotalCost());
        int adminCost = JavaHelpers.extractNumber(invoice.getAdminCost());
        int rentCostPerPeriod = JavaHelpers.extractNumber(invoice.getRentCostPerPeriod());
        int additionalPriceCost = 0;
        for (int number : priceList) {
            additionalPriceCost += number;
        }
        Assert.assertEquals( adminCost + rentCostPerPeriod, totalCost - additionalPriceCost);

    }

    @And("owner goes to bills details")
    public void ownerGoesToBillsDetails(DataTable table) {
        filterKost = table.asMaps(String.class, String.class);
        var filter = filterKost.get(0).get("kost name " + Mamikos.ENV);
        ownerDashboard.clickOnManagementKost();
        invoice.openKelolaTagihan();
        invoice.filterTagihanKost(filter);
    }

    @Then("owner can sees total amount is basic amount plus other price")
    public void ownerCanSeesTotalAmountIsBasicAmountPlusOtherPrice(List<Integer> priceList) {
        int totalCost = JavaHelpers.extractNumber(invoice.getTotalCostInvoiceDetail());
        int perPeriodCost = JavaHelpers.extractNumber(invoice.getRentCostPerPeriodInvoiceDetail());
        int additionalPriceCost = 0;
        for (int number : priceList) {
            additionalPriceCost += number;
        }
        Assert.assertEquals( perPeriodCost, totalCost - additionalPriceCost);
    }

    @And("owner set Kelola Tagihan filter month to {string} month")
    public void ownerSetKelolaTagihanFilterMonthToMonth(String monthNumber) throws ParseException, InterruptedException {
        if(monthNumber.equalsIgnoreCase("current")) {
            monthNumber = java.updateTimeLocal("yyyy MMM dd", java.getTimeStamp("yyyy MMM dd"), "M", "en", 0, 0, 0, 0, 0);
        }
        else if (monthNumber.equalsIgnoreCase("next")){
            monthNumber = java.updateTimeLocal("yyyy MMM dd", java.getTimeStamp("yyyy MMM dd"), "M", "en", 0, 1, 0, 0, 0);
        }
        invoice.selectManageNextBillsMonthFilter(monthNumber);
    }

    @And("user open invoice details")
    public void userOpenInvoiceDetails() {
        invoice.openBills();
    }

    @Then("tenant can see additional price {string} with price {string}")
    public void tenantCanSeeAdditionalPriceWithPrice(String biayaLainnyaTitle, String biayaLainnyaPrice) {
        invoice = new InvoicePO(ActiveContext.getActivePage());
        List<String> biayaLainnyaInnerText = invoice.getAdditionalPriceInnerText();
        Assert.assertTrue(biayaLainnyaInnerText.get(0).contains(biayaLainnyaTitle));
        Assert.assertTrue(biayaLainnyaInnerText.get(0).contains(biayaLainnyaPrice));
    }

    @And("user open riwayat booking")
    public void userOpenRiwayatBooking() {
        invoice = riwayatBooking.clickOnBayarSekarangButton();
    }

    @When("tenant get invoice number from riwayat booking")
    public void tenantGetInvoiceNumberFromRiwayatBooking() {
        invoice = riwayatBooking.clickOnBayarSekarangButton();
        InvoiceTestData.setInvoiceNumber(invoice.getInvoiceNumber());
    }

    @When("tenant go to invoice page from riwayat booking")
    public void tenantGoToInvoicePageFromRiwayatBooking() {
        invoice = riwayatBooking.clickOnBayarSekarangButton();
    }

    @When("tenant go to invoice DP from riwayat booking")
    public void tenantGoToInvoiceDP() {
        invoice = riwayatBooking.goToSettlementInvoice();
    }

    @And("tenant pay kost from riwayat booking using ovo {string}")
    public void tenantPayKostFromRiwayatBookingUsingOvo(String phoneNumber) {
        invoice = riwayatBooking.clickOnBayarSekarangButton();
        invoice.clickOnPilihPembayaran();
        invoice.clickOnOVO();
        invoice.inputPhoneNumberOvo(phoneNumber);
        invoice.clickOnBayarSekarang();
        page.reload();
        ActiveContext.getActiveBrowserContext().pages().get(1).close();
    }

    @And("tenant pay kost from riwayat booking using ovo {string} without close the page")
    public void tenantPayKostFromRiwayatBookingUsingOvoWithoutCloseThePage(String phoneNumber) {
        invoice = riwayatBooking.clickOnBayarSekarangButton();
        invoice.clickOnPilihPembayaran();
        invoice.clickOnOVO();
        invoice.inputPhoneNumberOvo(phoneNumber);
        invoice.clickOnBayarSekarang();
        page.reload();
    }
}
