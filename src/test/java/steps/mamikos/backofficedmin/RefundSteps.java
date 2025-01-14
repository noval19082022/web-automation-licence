package steps.mamikos.backofficedmin;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.admin.mamipay.paidinvoicelist.RefundPO;

import java.util.List;
import java.util.Map;

public class RefundSteps {
    Page page = ActiveContext.getActivePage();
    RefundPO refundPO = new RefundPO(page);
    private List<Map<String, String>> searchBy;

    @And("admin pick one invoice on list to refund")
    public void adminRefund() {
        refundPO.clickOnRefundBtn();
    }

    @And("admin pick one invoice on list to refund from cc payment")
    public void adminRefundCC() {
        refundPO.clickOnRefundBtnForCCPayment();
    }

    @And("admin fill bank name {string} on refund detail")
    public void adminFillBankNameOnRefundDetail(String bankName) {
        refundPO.fillBankName(bankName);
    }

    @And("admin visit transferred list on refund page")
    public void adminVisitTransferedListOnRefundPage() {
        refundPO.clickOnTransferredBtn();
    }

    @And("admin want to export the refund report")
    public void adminWantToExportTheRefundReport() {
        refundPO.exportReport();
    }

    @And("admin choose export report for today")
    public void adminChooseExportReportForToday() {
        refundPO.exportReportForToday();
    }

    @And("admin download the transferred refund report")
    public void adminDownloadTheTransferredRefundReport() {
        refundPO.clickOnDownloadXls();
    }

    @And("admin filter booking transaction using tenant phone {string}")
    public void adminSearchBookingTransactionUsingTenantPhone(String tenantPhone) {
        refundPO.filterTransactionUsingTenantPhoneNumber(tenantPhone);
    }

    @And("admin set allow refund the transaction")
    public void adminRefundTheTransaction() {
        refundPO.setAllowRefundTransaction();
    }

    @And("admin uncheck admin fee for refund")
    public void adminUncheckAdminFeeForRefund() {
        refundPO.clickOnCheckAdminFee();
    }

    @And("admin edit paid amount credit card {string} for refund")
    public void adminEditPaidAmountCreditCardForRefund(String amount) {
        refundPO.fillRefundAmount(amount);
    }

    @And("admin change of reason list to {string} for refund")
    public void adminChangeOfReasonListToForRefund(String Reason) {
        refundPO.chooseRefundReasonPemilikMembatalkan(Reason);
    }


    @And("admin set to refund the paid invoice")
    public void adminSetToRefundThePaidInvoice() {
        refundPO.clickOnRefundAndTransfer();
    }

    @And("admin set rekening number {string} and rekening owner {string} for refund")
    public void adminSetRekeningNumberAndRekeningOwnerForRefund(String rekeningNumber, String rekeningOwner) {
        refundPO.fillRekeningNumber(rekeningNumber);
        refundPO.fillRekeningName(rekeningOwner);
    }

    @Then("admin verify download button is disable")
    public void adminVerifyDownloadButtonIsDisable() {
        Assert.assertTrue(refundPO.IsOnDownloadXlsDisable());
    }

    @Then("admin verify transferred transaction for user {string} is visible")
    public void adminVerifyTransferredTransactionForUserIsDone(String username) {
        Assert.assertTrue(refundPO.transferredUserName().contains(username));
    }

    @And("admin search transferred refund by tenant Phone Number and input field {string}")
    public void adminSearchTransferredRefundByTenantPhoneNumberAndInputField(String tenantPhoneNumber) {
        refundPO.searchTransferredListByPhoneNumber(tenantPhoneNumber);
    }

    @And("admin close the refund detail")
    public void adminCloseTheRefundDetail() {
        refundPO.closeRefundDetailPopUp();
    }

    @And("admin want to download receipt transferred invoice")
    public void adminWantToSeeReceiptTransferredInvoice() {
        refundPO.clickOnReceiptTransferredInvoice();
    }

    @Then("admin verify bank name for refund is {string}")
    public void adminVerifyBankNameForRefundIs(String bankName) {
        Assert.assertEquals(refundPO.getBankNameForRefund(), bankName);
    }

    @And("admin visit failed list on refund page")
    public void adminVisitFailedListOnRefundPage() {
        refundPO.clickOnFailedBtn();
    }

    @And("admin pick one invoice on failed list")
    public void adminPickOneInvoiceOnFailedList() {
        refundPO.clickOnDetailFailedInvoiceList();
    }

    @And("admin search data refund by using:")
    public void adminSearchDataRefund(DataTable tables) {
        searchBy = tables.asMaps(String.class, String.class);
        for (Map<String, String> searchData : searchBy) {
            String name = searchData.get("Search by");
            String value = searchData.get("Value");
            refundPO.adminSearchDataRefund(name, value);
        }
    }

    @Then("admin verify warning text {string}")
    public void adminVerifyWarningText(String text) {
        Assert.assertTrue(refundPO.isLessAmountVisible(text));
    }

}
