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

    /**
     * filter data booking using tenant phone number
     *
     * @param tenantPhone
     */
    public void filterTransactionUsingTenantPhoneNumber(String tenantPhone) {
        page.getByText("Tampilkan Filter").click();
        page.getByPlaceholder("Ex: 081987654321").click();
        page.keyboard().type(tenantPhone);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Cari")).click();
    }

    /**
     * Set allow refund transaction on data booking
     */
    public void setAllowRefundTransaction() {
        page.getByRole(AriaRole.BUTTON).getByText("Actions").first().click();
        page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(" Actions  Detail  Cancel  Check In  Show Booking Remarks  Edit Listing Note  Transfer Permission")).getByText("Transfer Permission").click();
        page.getByRole(AriaRole.COMBOBOX).selectOption(new SelectOption().setValue("allow_refund"));
        page.locator("select[name='refund_reason']").selectOption("booking_is_cancelled");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Send")).click();
    }

    /**
     * uncheck the admin fee on refund process
     */
    public void unCheckAdminFee() {
        page.getByLabel("Biaya admin dikembalikan Rp200 (Kesalahan Owner)").uncheck();
    }

    /**
     * fill the refund amount
     *
     * @param amount
     */
    public void fillRefundAmount(String amount) {
        page.getByPlaceholder("Input paid amount").first().clear();
        page.getByPlaceholder("Input paid amount").first().click();
        page.keyboard().type(amount);
    }

    /**
     * choose Pemilik membatalkan for refund reason
     */
    public void chooseRefundReasonPemilikMembatalkan() {
        page.locator(".refund-invoice__modal-select").first().selectOption("Pemilik Membatalkan");
    }

    /**
     * set or click refund for paid invoice
     */
    public void clickOnRefundAndTransfer() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Refund & Transfer")).click();
    }

    /**
     * input rekening Number for refund
     *
     * @param rekeningNumber
     */
    public void fillRekeningNumber(String rekeningNumber) {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Masukkan nomor rekening")).click();
        page.keyboard().type(rekeningNumber);
    }

    /**
     * input rekening Name for refund
     *
     * @param rekeningName
     */
    public void fillRekeningName(String rekeningName) {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Masukkan nama pemilik rekening")).click();
        page.keyboard().type(rekeningName);
    }
}
