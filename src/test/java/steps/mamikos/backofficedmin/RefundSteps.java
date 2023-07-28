package steps.mamikos.backofficedmin;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import pageobject.admin.mamipay.paidinvoicelist.RefundPO;

import java.util.Optional;

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
}
