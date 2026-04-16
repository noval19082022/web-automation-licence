package steps.mamikos.common;

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
import pageobject.owner.kelolatagihan.TenantBillManagementPO;
import pageobject.tenant.InvoicePO;
import pageobject.tenant.profile.KostSayaBillingPO;
import pageobject.tenant.profile.RiwayatBookingPO;
import pageobject.xendit.XenditApiPO;
import testdata.InvoiceTestData;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public class PaymentSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    KostSayaBillingPO billing = new KostSayaBillingPO(page);
    InvoicePO invoice = new InvoicePO(page);
    RiwayatBookingPO riwayatBooking = new RiwayatBookingPO(page);
    MidtransPaymentPO midtrans = new MidtransPaymentPO(page);
    XenditApiPO xenditAPI = new XenditApiPO(page);
    List<Map<String, String>> voucherName;
    private List<Map<String, String>> filterKost;
    private JavaHelpers java = new JavaHelpers();
    OwnerDashboardPO ownerDashboard = new OwnerDashboardPO(page);
    TenantBillManagementPO tenantBillManagement = new TenantBillManagementPO(page);

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

    @When("user click button masukan on voucher")
    public void tenantApplyVoucher() throws InterruptedException {
        invoice.clickOnMasukkanVoucher();
        invoice.clickOnMasukkanVoucherPopUp();
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

    @Then("tenant can see mamirooms voucher is applied")
    public void tenantCanSeeMamiroomsVoucherIsApplied() {
        Assert.assertEquals(invoice.getToastText(), "Voucher Dipakai");
        var voucher = voucherName.get(0).get("voucher name " + Mamikos.ENV);
        var subTotal = invoice.getSubTotal();
        var biayaLayanan = invoice.getBiayaLayananMamirooms();
        var voucherDeductionValue = invoice.getVoucherReductionPrice(voucher);
        var totalPayment = invoice.getTotalPembayaran();
        var totalAfterDeduction = subTotal - voucherDeductionValue;
        Assert.assertEquals(totalPayment, totalAfterDeduction,
                "Check total pembayaran setelah voucher dipakai, subtotal pembayaran: " + subTotal + ", total pembayaran: " + totalPayment + ", diskon dari voucher: " + voucherDeductionValue + ", biaya layanan mamirooms: " + biayaLayanan);
    }

    @Then("tenant can not use the voucher")
    public void tenantCanNotUseTheVoucher() {
        var voucherInvalidWording = "Kode voucher tidak bisa digunakan.";
        String actualWarningText = invoice.voucherInputPopUpWarningText();
        Assert.assertEquals(actualWarningText, voucherInvalidWording,
            "Expected voucher error message: '" + voucherInvalidWording + "' but got: '" + actualWarningText + "'");
    }

    @Then("tenant should see voucher error message {string}")
    public void tenantShouldSeeVoucherErrorMessage(String expectedErrorMessage) {
        String actualWarningText = invoice.voucherInputPopUpWarningText();
        Assert.assertEquals(actualWarningText, expectedErrorMessage, 
            "Expected voucher error message: '" + expectedErrorMessage + "' but got: '" + actualWarningText + "'");
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
        String voucherErrorMessage = errorMessage + "Silakan hapus voucher.";
        String voucherErrorMessageActualRemoveLineSeparator = invoice.getToastText().replaceAll("\\R", " ");
        String voucherErrorMessageActualRemoveExtraSpace = voucherErrorMessageActualRemoveLineSeparator.replaceAll("\\s+", " ");
        Assert.assertEquals(voucherErrorMessageActualRemoveExtraSpace, voucherErrorMessage);
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

    @When("tenant/user/owner pay invoice from invoice detail using mandiri without close the page")
    public void tenantPayInvoiceDetailWithoutCloseThePage() {
        invoice = new InvoicePO(ActiveContext.getActivePage());
        invoice.clickOnPilihPembayaran();
        invoice.clickOnMandiri();
        invoice.clickOnBayarSekarang();
        page = ActiveContext.getActiveBrowserContext().waitForPage(() -> {
            ActiveContext.getActiveBrowserContext().newPage();
        });
        ActiveContext.setActivePage(page);
        var kodePerusahaan = invoice.getCompanyCodeText();
        var nomorVirtualAccount = invoice.getVirtualAccountNumberText();
        playwright = new PlaywrightHelpers(ActiveContext.getActivePage());
        playwright.navigateTo(Payment.MANDIRI_MIDTRANS, 30000.0);
        midtrans = new MidtransPaymentPO(ActiveContext.getActivePage());
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
        ownerDashboard.clickOnKelolaKos();
        invoice.filterTagihanKost(filter);
    }

    @Then("owner can sees total amount is basic amount plus other price")
    public void ownerCanSeesTotalAmountIsBasicAmountPlusOtherPrice(List<Integer> priceList) {
        playwright.waitTillPageLoaded();
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
        if (monthNumber.equalsIgnoreCase("current")) {
            monthNumber = java.updateTimeLocal("yyyy MMM dd", java.getTimeStamp("yyyy MMM dd"), "M", "en", 0, 0, 0, 0, 0);
            invoice.selectManageNextBillsMonthFilter(monthNumber);
        } else if (monthNumber.equalsIgnoreCase("next")) {
            monthNumber = java.updateTimeLocal("yyyy MMM dd", java.getTimeStamp("yyyy MMM dd"), "M", "en", 0, 1, 0, 0, 0);
            invoice.selectManageNextBillsMonthFilter(monthNumber);
        } else if (monthNumber.equalsIgnoreCase("Januari")) {
            monthNumber = java.updateTimeLocal("yyyy MMM dd", java.getTimeStamp("yyyy MMM dd"), "M", "en", 0, 0, 0, 0, 0);
            invoice.selectManageNextBillsMonthFilterOctober(monthNumber);
        } else if (monthNumber.equalsIgnoreCase("Februari")) {
            tenantBillManagement.selectMonthFilterByMonthAndYear("Februari", 2025);
        } else {
            // Handle all other month names (Maret, April, etc.)
            tenantBillManagement.selectMonthFilter(monthNumber);
        }
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
        page = ActiveContext.getActivePage();
        riwayatBooking = new RiwayatBookingPO(page);
        invoice = riwayatBooking.goToSettlementInvoice();
    }

    @And("tenant pay kost from riwayat booking using ovo {string}")
    public void tenantPayKostFromRiwayatBookingUsingOvo(String phoneNumber) {
        invoice = riwayatBooking.clickOnBayarSekarangButton();
        invoice.paymentOvoClosePage(phoneNumber);
    }

    @And("tenant pay kost from riwayat booking using ovo {string} without close the page")
    public void tenantPayKostFromRiwayatBookingUsingOvoWithoutCloseThePage(String phoneNumber) {
        invoice = riwayatBooking.clickOnBayarSekarangButton();
        invoice.paymentOVOBeforeVerification(phoneNumber);
    }

    @And("tenant click button bayar sekarang")
    public void tenantClickButtonBayarSekarang() {
        invoice = riwayatBooking.clickOnBayarSekarangButton();
    }

    @When("payment owner/tenant/user success using ovo as payment method")
    public void payment_owner_success_using_ovo_as_payment_method() {
        invoice.paymentOVO("0812999000");
    }

    @When("auto select payment owner/tenant/user success using ovo as payment method")
    public void auto_select_payment_owner_success_using_ovo_as_payment_method() {
        invoice.paymentOVOAutoSelect("0812999000");
    }

    @When("tenant make bill payments using {string}")
    public void tenantMakeBillPaymentsUsingOvo(String method) {
        invoice.choosePaymentUsing(method);
    }


    @And("tenant pay booking to extended contract using ovo {string}")
    public void tenantPayBookingToExtendedContractUsingOvo(String phoneNumber) {
        invoice.paymentOvoClosePage(phoneNumber);
    }

    @And("tenant pay booking to extended contract using ovo {string} without close the page")
    public void tenantPayBookingToExtendedContractUsingOvoWithoutClosePage(String phoneNumber) {
        invoice.paymentOVO(phoneNumber);
    }

    @Then("tenant can not sees add on price on payment page")
    public void tenantCanNotSeesAddOnPriceOnPaymentPage() {
        invoice = new InvoicePO(ActiveContext.getActivePage());
        int basicAmount = invoice.getBasicPrice();
        int adminFee = invoice.getAdminPrice();
        int totalAmount = invoice.getSubTotal();
        Assert.assertEquals(basicAmount + adminFee, totalAmount, "Basic amount + admin fee is not equal with total amount");
    }

    @Then("tenant can not sees add on price on payment page after pay")
    public void tenantCanNotSeesAddOnPriceOnPaymentPageAfterPay() {
        invoice = new InvoicePO(ActiveContext.getActivePage());
        int basicAmount = invoice.getBasicPrice();
        int adminFee = invoice.getAdminPriceFinal();
        int totalAmount = invoice.getSubTotal();
        Assert.assertEquals(basicAmount + adminFee, totalAmount, "Basic amount + admin fee is not equal with total amount");
    }

    @Then("tenant can see TnC {string} on invoice")
    public void tenant_can_see_tnc_x_on_invoice(String tnc) {
        Assert.assertEquals(invoice.getTnCInvoiceFullText(), tnc, "not the same text");
    }

    @And("tenant click text Syarat dan Ketentuan Umum on invoice")
    public void tenant_click_text_x_on_invoice() {
        invoice.clickTnCInvoice();
    }

    @When("system display remaining payment {string} use mamipoin for payment monthly")
    public void system_display_remaining_payment_use_mamipoin_for_payment(String condition) {
        String remainingPaymentBefore = "Rp555.355";
        String remainingPaymentAfter = "Rp555.355";

        if(condition.equals("before")){
            Assert.assertEquals(invoice.getTotalCost(), remainingPaymentBefore, "Remaining payment before doesn't match");
        }
        else {
            Assert.assertEquals(invoice.getTotalCost(), remainingPaymentAfter, "Remaining payment after doesn't match");
        }
    }

    @When("user clicks on mamipoin toggle button to On Off")
    public void user_clicks_on_mamipoin_toggle_button_to_off() {
        invoice.clickMamipoinToggleButtonToOnOff();
    }

    @Then("tenant can see disable mamipoin button")
    public void tenantCanSeeDisbleMamipoinButton(){
        invoice.isMamipoinisDisable();
    }

    @Then("tenant point estimate not displayed on invoice")
    public void tenant_point_estimate_not_displayed_on_invoice()  {
        Assert.assertFalse(invoice.isPointEstimateTenantVisible());
    }
    @And("tenant clicks Pakai voucher list:")
    public void tenant_clicks_on_pakai_button(DataTable table) {
        voucherName = table.asMaps(String.class, String.class);
        var voucher = voucherName.get(0).get("voucher name " + Mamikos.ENV);
        invoice.clickOnDeleteVoucher();
        invoice.clickOnMasukkanVoucher();
        invoice.clickOnPakaiVoucherButton();
    }

    @Then("tenant can see voucher suggestion empty state")
        public void tenant_can_see_voucher_suggestion_empty_state(){
        invoice.clickOnMasukkanVoucher();
        Assert.assertTrue(invoice.isVoucherSuggestionEmptyStateVisible());
        }

    @Then("tenant display warning message {string}")
    public synchronized void systemDisplayWarningMessage(String warningMessage) {
        Assert.assertEquals(invoice.voucherInputPopUpWarningText(), warningMessage);
    }
    @And("tenant click on ubah metode pembayaran")
    public void tenantClickOnUbahMetodePembayaran() {
        invoice.ubahMetodePembayaran();
    }

    @Then("tenant can verify voucher discount calculation:")
    public void tenantCanVerifyVoucherDiscountCalculation(DataTable table) {
        List<Map<String, String>> voucherData = table.asMaps(String.class, String.class);
        var voucherInfo = voucherData.get(0);

        var voucherCode = voucherInfo.get("voucher code");
        var discountPercentage = Integer.parseInt(voucherInfo.get("discount percentage"));
        var maximalDiscountAmount = Integer.parseInt(voucherInfo.get("maximal discount amount"));

        var subTotal = invoice.getSubTotal();
        var actualDiscountAmount = invoice.getVoucherReductionPrice(voucherCode);

        var calculatedDiscount = (subTotal * discountPercentage) / 100;
        var expectedDiscount = Math.min(calculatedDiscount, maximalDiscountAmount);

        Assert.assertEquals(actualDiscountAmount, expectedDiscount,
                String.format("Voucher discount calculation incorrect. SubTotal: %d, Discount: %d%%, Calculated: %d, Max Cap: %d, Expected: %d, Actual: %d",
                        subTotal, discountPercentage, calculatedDiscount, maximalDiscountAmount, expectedDiscount, actualDiscountAmount));

        var totalPayment = invoice.getTotalPembayaran();
        var expectedTotal = subTotal - expectedDiscount;
        Assert.assertEquals(totalPayment, expectedTotal,
                String.format("Total payment calculation incorrect. SubTotal: %d, Voucher Discount: %d, Expected Total: %d, Actual Total: %d",
                        subTotal, expectedDiscount, expectedTotal, totalPayment));
    }
}
