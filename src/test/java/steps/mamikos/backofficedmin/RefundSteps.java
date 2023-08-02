package steps.mamikos.backofficedmin;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.admin.mamipay.paidinvoicelist.RefundPO;

public class RefundSteps {
    Page page = ActiveContext.getActivePage();
    RefundPO refundPO = new RefundPO(page);

    @And("admin pick one invoice on list to refund")
    public void adminRefund() {
        refundPO.clickOnRefundBtn();
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
        refundPO.unCheckAdminFee();
    }

    @And("admin edit paid amount credit card {string} for refund")
    public void adminEditPaidAmountCreditCardForRefund(String amount) {
        refundPO.fillRefundAmount(amount);
    }

    @And("admin change of reason list to pemilik membatalkan for refund")
    public void adminChangeOfReasonListToPemilikMembatalkanForRefund() {
        refundPO.chooseRefundReasonPemilikMembatalkan();
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
}
