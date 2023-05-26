package steps.mamikos.admin;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
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
        invoicePO.getDataInvoice(otherInvoiceBooking);
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
        invoicePO.chooseSchedule(From, To);
    }

    @Then("data transaction appeared")
    public void dataTransactionAppeared() throws InterruptedException {
        invoicePO.showDataBaseOnScheduleDate();
    }

    @And("admin input amount from and to {string} and {string}")
    public void adminInputAmountFromAndToAnd(String nominalFrom, String nominalTo) throws InterruptedException {
        invoicePO.inputValueAmount(nominalFrom, nominalTo);
    }

    @Then("appeared data with amount {string}")
    public void appearedDataWithAmount(String dataNominal) throws InterruptedException {
        invoicePO.showResultBasedOnNominal(dataNominal);
    }

    @And("admin choose method Status {string}")
    public void adminChooseMethodStatus(String method) throws InterruptedException {
        invoicePO.selectDetailStatus(method);
    }

    @Then("admin will get data Status with method {string}")
    public void adminWillGetDataStatusWithMethod(String output) {
        invoicePO.resultDataBasedOnStatus(output);
    }

    @And("admin choose order type {string}")
    public void adminChooseOrderType(String method) throws InterruptedException {
        invoicePO.selectOrderType(method);
    }

    @Then("appeared data transaction with order type {string}")
    public void appearedDataTransactionWithOrderType(String output) throws InterruptedException {
        invoicePO.resultDataBasedOnOrderType(output);
    }

    @And("admin click change status")
    public void adminClickChangeStatus() throws InterruptedException {
        invoicePO.clickChangeStatus();
    }

    @And("admin change {string}")
    public void adminChange(String method) throws InterruptedException {
        invoicePO.changeToPaid(method);
    }

    @And("admin input date and time {string}")
    public void adminInputDateAndTime(String date) throws InterruptedException {
        invoicePO.inputDateAndTime(date);
    }

    @Then("invoice will changes to {string}")
    public void invoiceWillChangesTo(String status) throws InterruptedException {
        invoicePO.showInvoiceAfterChange(status);
    }

    @And("admin click checkbox not in mamipay")
    public void adminClickCheckboxNotInMamipay() {
    }
}
