package steps.mamikos.admin;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.When;
import pageobject.admin.mamipay.AdminMamipayDashboardPO;
import pageobject.admin.mamipay.invoice.MamikosListInvoicePO;

public class SearchInvoiceSteps {
    private Page page = ActiveContext.getActivePage();
    private AdminMamipayDashboardPO admin = new AdminMamipayDashboardPO(page);
    private MamikosListInvoicePO invoicePO = new MamikosListInvoicePO(page);

    @When("admin want to reactivate invoice by invoice number {string}")
    public void reactivateInvoice(String invoiceNumber) {
        admin.clickOnTextHyperlink("Search Invoice");
        invoicePO.selectSearchInvoiceBy("Invoice Number");
        invoicePO.fillInputSearchValue(invoiceNumber);
        invoicePO.clickOnCariInvoice();
        // change to unpaid
        admin.clickOnTextHyperlink("Change Status");
        // unpaid
        invoicePO.setStatusPaidOrUnpaid("unpaid");
        // date
        invoicePO.setDate("2021-02-04 16:35:11");
        admin.clickOnTextHyperlink("Submit Change");
        // change to paid to activate the invoice
        admin.clickOnTextHyperlink("Change Status");
        // paid
        invoicePO.setStatusPaidOrUnpaid("paid");
        // date
        invoicePO.setDate("2021-02-04 16:35:11");
        admin.clickOnTextHyperlink("Submit Change");
    }
}
