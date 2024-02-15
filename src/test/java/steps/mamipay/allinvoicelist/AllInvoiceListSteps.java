package steps.mamipay.allinvoicelist;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import config.playwright.context.ActiveContext;
import data.payment.Payment;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.admin.mamipay.allinvoicelist.AllInvoiceListPO;
import pageobject.midtrans.MidtransPaymentPO;
import pageobject.tenant.InvoicePO;
import steps.mamikos.common.NavigatesSteps;
import testdata.InvoiceTestData;
import utilities.PlaywrightHelpers;

import java.util.List;
import java.util.Map;

public class AllInvoiceListSteps {
    Page page = ActiveContext.getActivePage();
    AllInvoiceListPO allInvoice = new AllInvoiceListPO(page);
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    MidtransPaymentPO midtrans = new MidtransPaymentPO(page);
    NavigatesSteps navigate = new NavigatesSteps();

    private List<Map<String, String>> dataInvoice;
    private List<Map<String, String>> revisionHistory;
    private List<Map<String, String>> paymentHistory;

    @When("admin open menu all invoice list")
    public void admin_open_menu_all_invoice_list() {
        allInvoice.openAllInvoiceListMenu();
    }
    @Then("list contains invoice manual")
    public void list_contains_invoice_manual() {
        Assert.assertTrue(allInvoice.isListContainsInvoiceManual(), "Invoice Manual not found");
    }
    @When("admin filter by order type {string}")
    public void admin_filter_by_order_type(String type) {
        allInvoice.filterOrderType(type);
    }
    @Then("system should display only invoice with type {string}")
    public void system_should_display_only_invoice_with_type(String type) {
        if (type.equalsIgnoreCase("Invoice Manual")){
            Assert.assertTrue(allInvoice.isAllListInvoiceManual());
        }
    }
    @When("admin search by {string} using {string}")
    public void admin_search_by_using(String searchBy, String searchValue) {
        if (searchValue.equalsIgnoreCase("saved invoice")){
            searchValue = InvoiceTestData.getManualInvoiceNumber();
        }
        allInvoice.searchInvoice(searchBy,searchValue);
    }
    @Then("invoice status should be {string}")
    public void invoice_status_should_be(String status) {
        navigate.tenantSetActivePageTo(0);
        playwright.hardWait(3000);
        navigate.tenantRefreshPage(0);
        playwright.hardWait(1000);
        page.waitForLoadState(LoadState.NETWORKIDLE);
        AllInvoiceListPO allinvoice = new AllInvoiceListPO(ActiveContext.getActivePage());
        for (int i=0;i<allinvoice.countRowData();i++){
            Assert.assertEquals(allinvoice.getInvoiceStatus(i),status);
        }
    }
    @When("admin change status invoice to {string} {string}")
    public void admin_change_status_invoice_to(String status, String date) {
        allInvoice.changeStatusInvoice(status,date);
    }
    @When("admin open tenant invoice")
    public void admin_open_tenant_invoice() {
        allInvoice.openTenantInvoice();
    }
    @When("admin pay tenant invoice using bank {string}")
    public void admin_pay_tenant_invoice_using_bank(String bank) {
        page = ActiveContext.getActiveBrowserContext().pages().get(1);
        InvoicePO invoice = new InvoicePO(page);
        invoice.clickOnPilihPembayaran();
        switch (bank){
            case "Mandiri":
                invoice.clickOnMandiri();
                break;
            case "BNI":
                invoice.clickOnBNI();
                break;
        }
        invoice.clickOnBayarSekarang();

        //midtrans
        String kodePerusahaan = invoice.getCompanyCodeText();
        String nomorVirtualAccount = invoice.getVirtualAccountNumberText();
        navigate.tenantOpenNewPage();
        page = ActiveContext.getActiveBrowserContext().pages().get(2);
        playwright = new PlaywrightHelpers(page);
        playwright.navigateTo(Payment.MANDIRI_MIDTRANS, 30000.0, LoadState.LOAD);
        midtrans = new MidtransPaymentPO(page);
        midtrans.inputBillerCode(kodePerusahaan);
        midtrans.inputPaymentCode(nomorVirtualAccount);
        midtrans.clickOnInquireButton();
        midtrans.clickOnPayButton();
        midtrans.waitForSuccessTransaction();
    }
    @When("admin view log invoice manual")
    public void admin_view_log_invoice_manual() {
        allInvoice.viewLog();
    }
    @Then("detail data invoice should be")
    public void detail_data_invoice_should_be(DataTable tables) {
        dataInvoice = tables.asMaps(String.class, String.class);

        String invoiceNo = dataInvoice.get(0).get("Invoice number");
        String status = dataInvoice.get(0).get("Status");
        String type = dataInvoice.get(0).get("Order Type");
        String amount = dataInvoice.get(0).get("Amount");
        String paidAmount = dataInvoice.get(0).get("Paid Amount");

        if (invoiceNo.equalsIgnoreCase("saved invoice")){
            invoiceNo = InvoiceTestData.getManualInvoiceNumber();
        }

        Assert.assertEquals(allInvoice.getDataInvoiceNumber(),invoiceNo);
        Assert.assertEquals(allInvoice.getDataStatus(),status);
        Assert.assertEquals(allInvoice.getDataOrderType(),type);
        Assert.assertEquals(allInvoice.getDataAmount(),amount);
        Assert.assertEquals(allInvoice.getDataPaidAmount(),paidAmount);
    }
    @Then("detail data invoice revision history should be")
    public void detail_data_invoice_revision_history_should_be(DataTable tables) {
        revisionHistory = tables.asMaps(String.class, String.class);

        for (Map<String, String> data : revisionHistory){
            String row = data.get("Row");
            String changeBy = data.get("Change by");
            String role = data.get("Changer role");
            String changes = data.get("What Changed");
            String oldValue = data.get("Old Value");
            String newValue = data.get("New Value");
            Integer i = Integer.parseInt(row);

            Assert.assertEquals(allInvoice.getRevisionChangeBy(i),changeBy);
            Assert.assertEquals(allInvoice.getRevisionChangerRole(i),role);
            Assert.assertEquals(allInvoice.getRevisionWhatChanged(i),changes);
            Assert.assertEquals(allInvoice.getRevisionOldValue(i),oldValue);
            Assert.assertEquals(allInvoice.getRevisionNewValue(i),newValue);
        }
    }
    @Then("detail data invoice payment history should be")
    public void detail_data_invoice_payment_history_should_be(DataTable tables) {
        paymentHistory = tables.asMaps(String.class, String.class);

        String paymentMethod = paymentHistory.get(0).get("Payment Method");
        String amount = paymentHistory.get(0).get("Amount");
        String status = paymentHistory.get(0).get("Status");
        String paidAmount = paymentHistory.get(0).get("Paid Amount");

        Assert.assertEquals(allInvoice.getHistoryPaymentMethod(),paymentMethod);
        Assert.assertEquals(allInvoice.getHistoryAmount(),amount);
        Assert.assertEquals(allInvoice.getHistoryStatus(),status);
        Assert.assertEquals(allInvoice.getHistoryPaidAmount(),paidAmount);
    }
}
