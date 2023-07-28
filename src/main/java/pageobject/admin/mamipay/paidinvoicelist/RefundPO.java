package pageobject.admin.mamipay.paidinvoicelist;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.*;

public class RefundPO {
    private Page page;
    private Locator refundBtn;
    private Locator selectBank;
    private Locator transferred;
    private Locator exportReport;
    private Locator chooseDateTransferredReport;

    public RefundPO(Page page) {
        this.page = page;
        this.refundBtn = page.getByRole(AriaRole.BUTTON).getByText("Refund").first();
        this.selectBank = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Mandiri")).locator("span").nth(1);
        this.transferred = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Transferred"));
        this.exportReport = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Export"));
        this.chooseDateTransferredReport = page.locator("#refund-invoice-daterange");
    }

    /**
     * admin click refund btn for the first invoice list
     */
    public void clickOnRefundBtn() {
        refundBtn.click();
    }

    /**
     * fill bank name on refund detail
     *
     * @param bankName
     */
    public void fillBankName(String bankName) {
        selectBank.click();
        page.locator("input[type='search']").click();
        page.keyboard().type(bankName);
        page.keyboard().press("Enter");
    }

    /**
     * click on transferred to redirect to the transferred list invoice
     */
    public void clickOnTransferredBtn() {
        transferred.click();
    }

    /**
     * Export report transferred invoice
     */
    public void exportReport() {
        exportReport.click();
    }

    /**
     * choose date on download report for today
     */
    public void exportReportForToday() {
        chooseDateTransferredReport.click();
        page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("Today")).click();
    }

    /**
     * download transferred report
     */
    public void clickOnDownloadXls() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Download .XLSX")).click();
    }
}
