package pageobject.admin.mamipay.paidinvoicelist;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.*;

public class RefundPO {
    private Page page;
    private Locator refundBtn;
    //--- refund detail ----
    private Locator selectBank;
    private Locator searchBankName;
    private Locator checkMarkAdminFee;
    private Locator inputAmountRefund;
    private Locator inputRekeningNunmber;
    private Locator inputRekeningName;
    private Locator refundBtnAction;
    private Locator closeBtnActionOnRefundDetail;
    // transferred list
    private Locator transferred;
    private Locator searchBy;
    private Locator tenantPhoneNumberOptionOnSearchBy;
    private Locator searchPlaceHolder;
    private Locator searchBtnAction;
    private Locator firstTransferredUserOnlist;
    private Locator exportReport;
    private Locator receiptBtn;
    //--- export transferred report detail ----
    private Locator chooseDateTransferredReport;
    private Locator chooseExportForToday;
    private Locator downloadXlsReport;
    //--- Data booking menu on bang kerupux ---
    private Locator filterTransactionBtn;
    private Locator phoneNumberPlaceHolder;
    private Locator cariBtn;

    public RefundPO(Page page) {
        this.page = page;
        this.refundBtn = page.getByRole(AriaRole.BUTTON).getByText("Refund").first();
        //--- refund detail ----
        this.selectBank = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Mandiri")).locator("span").nth(1);
        this.searchBankName = page.locator("input[type='search']");
        this.checkMarkAdminFee = page.getByLabel("Biaya admin dikembalikan Rp200 (Kesalahan Owner)");
        this.inputAmountRefund = page.getByPlaceholder("Input paid amount").first();
        this.inputRekeningNunmber = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Masukkan nomor rekening"));
        this.inputRekeningName = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Masukkan nama pemilik rekening"));
        this.refundBtnAction = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Refund & Transfer"));
        this.closeBtnActionOnRefundDetail = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Close"));
        //--- transferred list
        this.transferred = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Transferred"));
        this.searchBy = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Search By")).nth(1);
        this.tenantPhoneNumberOptionOnSearchBy = page.locator("#bs-select-1-5");
        this.searchPlaceHolder = page.getByPlaceholder("Search");
        this.searchBtnAction = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search"));
        this.firstTransferredUserOnlist = page.locator("//tbody/tr[1]/td[8]");
        this.exportReport = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Export"));
        this.receiptBtn = page.getByRole(AriaRole.ROW).getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Receipt")).first();
        //--- export transferred detail ---
        this.chooseDateTransferredReport = page.locator("#refund-invoice-daterange");
        this.chooseExportForToday = page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("Today"));
        this.downloadXlsReport = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Download .XLSX"));
        //-- data booking menu on bank kerupux ---
        this.filterTransactionBtn = page.getByText("Tampilkan Filter");
        this.phoneNumberPlaceHolder = page.getByPlaceholder("Ex: 081987654321");
        this.cariBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Cari"));
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
        searchBankName.click();
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
        chooseExportForToday.click();
    }

    /**
     * download transferred report
     */
    public void clickOnDownloadXls() {
        downloadXlsReport.click();
    }

    /**
     * check if download xls disable
     *
     * @return
     */
    public boolean IsOnDownloadXlsDisable() {
        return downloadXlsReport.isDisabled();
    }

    /**
     * filter data booking using tenant phone number
     *
     * @param tenantPhone
     */
    public void filterTransactionUsingTenantPhoneNumber(String tenantPhone) {
        filterTransactionBtn.click();
        phoneNumberPlaceHolder.click();
        page.keyboard().type(tenantPhone);
        cariBtn.click();
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
        checkMarkAdminFee.uncheck();
    }

    /**
     * fill the refund amount
     *
     * @param amount
     */
    public void fillRefundAmount(String amount) {
        inputAmountRefund.clear();
        inputAmountRefund.click();
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
        refundBtnAction.click();
    }

    /**
     * input rekening Number for refund
     *
     * @param rekeningNumber
     */
    public void fillRekeningNumber(String rekeningNumber) {
        inputRekeningNunmber.click();
        page.keyboard().type(rekeningNumber);
    }

    /**
     * input rekening Name for refund
     *
     * @param rekeningName
     */
    public void fillRekeningName(String rekeningName) {
        inputRekeningName.click();
        page.keyboard().type(rekeningName);
    }


    /**
     * get text first list account on transferred invoice list
     *
     * @return
     */
    public String transferredUserName() {
        return firstTransferredUserOnlist.textContent().trim();
    }

    /**
     * admin search or sorting refund list by tenant phone number
     *
     * @param tenantPhoneNumber
     */
    public void searchTransferredListByPhoneNumber(String tenantPhoneNumber) {
        searchBy.click();
        tenantPhoneNumberOptionOnSearchBy.click();
        searchPlaceHolder.click();
        page.keyboard().type(tenantPhoneNumber);
        searchBtnAction.click();
    }

    /**
     * admin clickOn Close Btn on refund pop up detail after click refund invoice on list
     */
    public void closeRefundDetailPopUp() {
        closeBtnActionOnRefundDetail.click();
    }

    /**
     * admin download receipt action button on transferred invoicce list
     */
    public void clickOnReceiptTransferredInvoice() {
        receiptBtn.click();
    }
}
