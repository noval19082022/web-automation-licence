package steps.mamikos.admin;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.admin.mamipay.AdminMamipayDashboardPO;
import pageobject.admin.mamipay.invoice.MamikosListInvoicePO;

public class allInvoiceSteps {
    private Page page = ActiveContext.getActivePage();
    private AdminMamipayDashboardPO admin = new AdminMamipayDashboardPO(page);
    private MamikosListInvoicePO invoicePO = new MamikosListInvoicePO(page);

    @And("admin want to search invoice number {string}")
    public void adminWantToSearchInvoiceNumber(String invoiceNumber) {
        admin.clickOnTextHyperlink("All Invoice List");
        invoicePO.selectSearchInvoiceBy("Invoice Number");
        invoicePO.fillInputSearchValue(invoiceNumber);
        invoicePO.clickOnCariInvoice();
    }

    @Then("admin verify data transaction")
    public void adminVerifyDataTransaction() throws InterruptedException {
        invoicePO.verifyDataTransaction();
    }

    @And("admin click button reset input invoice number {string}")
    public void adminClickButtonResetInputInvoiceNumber(String invoiceNumber) throws InterruptedException {
        invoicePO.clickReset();
        invoicePO.selectSearchInvoiceBy("Invoice Number");
        invoicePO.fillInputSearchValue(invoiceNumber);
        invoicePO.clickOnCariInvoice();
    }

    @Then("admin get blank screen")
    public void adminGetBlankScreen() throws InterruptedException {
        invoicePO.getBlankScreen();
    }

    @And("admin want to search invoice code {string}")
    public void adminWantToSearchInvoiceCode(String invoiceCode) {
        admin.clickOnTextHyperlink("All Invoice List");
        invoicePO.selectSearchInvoiceBy("Invoice Code");
        invoicePO.fillInputSearchValue(invoiceCode);
        invoicePO.clickOnCariInvoice();
    }

    @And("admin click button reset input invoice code {string}")
    public void adminClickButtonResetInputInvoiceCode(String invoiceCode) throws InterruptedException {
        invoicePO.clickReset();
        invoicePO.selectSearchInvoiceBy("Invoice Code");
        invoicePO.fillInputSearchValue(invoiceCode);
        invoicePO.clickOnCariInvoice();
    }

    @Then("admin will get data invoice {string}")
    public void adminWillGetDataInvoice(String otherInvoiceBooking) throws InterruptedException {
        invoicePO.getDataInvoice (otherInvoiceBooking);
    }

    @And("admin click button reset")
    public void adminClickButtonReset() throws InterruptedException {
        invoicePO.clickReset();
    }

    @And("admin choose method {string}")
    public void adminChooseMethod(String method) throws InterruptedException {
        admin.clickOnTextHyperlink("All Invoice List");
        invoicePO.selectPayment(method);
        invoicePO.clickOnCariInvoice();
    }

    @Then("admin will get data transatcion with method {string}")
    public void adminWillGetDataTransatcionWithMethod(String resultMethod) throws InterruptedException {
        invoicePO.showResultData(resultMethod);
    }

    @And("admin choose date picker {string} and {string}")
    public void adminChooseDatePickerAnd(String From, String To) throws InterruptedException {
        invoicePO.choosescheduleDate(From, To);
        invoicePO.clickOnCariInvoice();

    }

    @Then("data transaction appeared")
    public void dataTransactionAppeared() throws InterruptedException {
        invoicePO.showDataBaseOnSchduleDate ();
    }
}
