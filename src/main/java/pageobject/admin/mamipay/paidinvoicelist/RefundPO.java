package pageobject.admin.mamipay.paidinvoicelist;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.SelectOption;
import utilities.PlaywrightHelpers;

public class RefundPO {
    private Page page;
    private PlaywrightHelpers playwrightHelpers;
    private Locator refundBtn;
    //--- refund detail ----
    private Locator selectedBankForRefund;
    private Locator selectBank;
    private Locator searchBankName;
    private Locator checkMarkAdminFee;
    private Locator inputAmountRefund;
    private Locator inputRekeningNumber;
    private Locator inputRekeningName;
    private Locator refundReasonDropDown;
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
    private Locator actionBtnOnInvoiceList;
    private Locator actionTransferredPermission;
    private Locator allowRefundBox;
    private Locator refundReasons;
    private Locator sendBtnRefund;
    private Locator filterTransactionBtn;
    private Locator phoneNumberPlaceHolder;
    private Locator cariBtn;

    public RefundPO(Page page) {
        this.page = page;
        this.playwrightHelpers = new PlaywrightHelpers(page);
        this.refundBtn = page.getByRole(AriaRole.BUTTON).getByText("Refund").first();
        //--- refund detail ----
        this.selectedBankForRefund = page.getByRole(AriaRole.COMBOBOX).getByRole(AriaRole.TEXTBOX).first();
        this.selectBank = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Mandiri")).locator("span").nth(1);
        this.searchBankName = page.locator("input[type='search']");
        this.checkMarkAdminFee = page.getByLabel("Biaya admin dikembalikan Rp200 (Kesalahan Owner)");
        this.inputAmountRefund = page.getByPlaceholder("Input paid amount").first();
        this.inputRekeningNumber = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Masukkan nomor rekening"));
        this.inputRekeningName = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Masukkan nama pemilik rekening"));
        this.refundReasonDropDown = page.locator(".refund-invoice__modal-select").first();
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
        this.actionBtnOnInvoiceList = page.getByRole(AriaRole.BUTTON).getByText("Actions").first();
        this.actionTransferredPermission = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(" Actions  Detail  Cancel  Check In  Show Booking Remarks  Edit Listing Note  Transfer Permission")).getByText("Transfer Permission");
        this.allowRefundBox = page.getByRole(AriaRole.COMBOBOX);
        this.refundReasons = page.locator("select[name='refund_reason']");
        this.sendBtnRefund = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Send"));
        this.filterTransactionBtn = page.getByText("Tampilkan Filter");
        this.phoneNumberPlaceHolder = page.getByPlaceholder("Ex: 081987654321");
        this.cariBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Cari"));
    }

    /**
     * admin click refund btn for the first invoice list
     */
    public void clickOnRefundBtn() {
        playwrightHelpers.clickOn(refundBtn);
    }

    /**
     * fill bank name on refund detail
     *
     * @param bankName
     */
    public void fillBankName(String bankName) {
        playwrightHelpers.clickOn(selectBank);
        playwrightHelpers.clickLocatorAndTypeKeyboard(searchBankName, bankName);
        playwrightHelpers.pressKeyboardKey("Enter");
    }

    /**
     * click on transferred to redirect to the transferred list invoice
     */
    public void clickOnTransferredBtn() {
        playwrightHelpers.clickOn(transferred);
    }

    /**
     * Export report transferred invoice
     */
    public void exportReport() {
        playwrightHelpers.clickOn(exportReport);
    }

    /**
     * choose date on download report for today
     */
    public void exportReportForToday() {
        playwrightHelpers.clickOn(chooseDateTransferredReport);
        playwrightHelpers.clickOn(chooseExportForToday);
    }

    /**
     * download transferred report
     */
    public void clickOnDownloadXls() {
        playwrightHelpers.clickOn(downloadXlsReport);
    }

    /**
     * check if download xls disable
     *
     * @return
     */
    public boolean IsOnDownloadXlsDisable() {
        return playwrightHelpers.isButtonDisable(downloadXlsReport);
    }

    /**
     * filter data booking using tenant phone number
     *
     * @param tenantPhone
     */
    public void filterTransactionUsingTenantPhoneNumber(String tenantPhone) {
        playwrightHelpers.clickOn(filterTransactionBtn);
        playwrightHelpers.clickLocatorAndTypeKeyboard(phoneNumberPlaceHolder, tenantPhone);
        playwrightHelpers.clickOn(cariBtn);
    }

    /**
     * Set allow refund transaction on data booking
     */
    public void setAllowRefundTransaction() {
        playwrightHelpers.clickOn(actionBtnOnInvoiceList);
        playwrightHelpers.clickOn(actionTransferredPermission);
        playwrightHelpers.selectDropdownBySelectOption(allowRefundBox, new SelectOption().setValue("allow_refund"));
        playwrightHelpers.selectDropdownByValue(refundReasons, "booking_is_cancelled");
        playwrightHelpers.clickOn(sendBtnRefund);
    }

    /**
     * uncheck the admin fee on refund process
     */
    public void unCheckAdminFee() {
        playwrightHelpers.uncheckBox(checkMarkAdminFee);
    }

    /**
     * fill the refund amount
     *
     * @param amount
     */
    public void fillRefundAmount(String amount) {
        playwrightHelpers.clearText(inputAmountRefund);
        playwrightHelpers.clickLocatorAndTypeKeyboard(inputAmountRefund, amount);
    }

    /**
     * choose Pemilik membatalkan for refund reason
     */
    public void chooseRefundReasonPemilikMembatalkan() {
        playwrightHelpers.selectDropdownByValue(refundReasonDropDown, "Pemilik Membatalkan");
    }

    /**
     * set or click refund for paid invoice
     */
    public void clickOnRefundAndTransfer() {
        playwrightHelpers.clickOn(refundBtnAction);
    }

    /**
     * input rekening Number for refund
     *
     * @param rekeningNumber
     */
    public void fillRekeningNumber(String rekeningNumber) {
        playwrightHelpers.clickLocatorAndTypeKeyboard(inputRekeningNumber, rekeningNumber);
    }

    /**
     * input rekening Name for refund
     *
     * @param rekeningName
     */
    public void fillRekeningName(String rekeningName) {
        playwrightHelpers.clickLocatorAndTypeKeyboard(inputRekeningName, rekeningName);
    }


    /**
     * get text first list account on transferred invoice list
     *
     * @return
     */
    public String transferredUserName() {
        return playwrightHelpers.getText(firstTransferredUserOnlist);
    }

    /**
     * admin search or sorting refund list by tenant phone number
     *
     * @param tenantPhoneNumber
     */
    public void searchTransferredListByPhoneNumber(String tenantPhoneNumber) {
        playwrightHelpers.clickOn(searchBy);
        playwrightHelpers.clickOn(tenantPhoneNumberOptionOnSearchBy);
        playwrightHelpers.clickLocatorAndTypeKeyboard(searchPlaceHolder, tenantPhoneNumber);
        playwrightHelpers.clickOn(searchBtnAction);
    }

    /**
     * admin clickOn Close Btn on refund pop up detail after click refund invoice on list
     */
    public void closeRefundDetailPopUp() {
        playwrightHelpers.clickOn(closeBtnActionOnRefundDetail);
    }

    /**
     * admin download receipt action button on transferred invoicce list
     */
    public void clickOnReceiptTransferredInvoice() {
        playwrightHelpers.clickOn(receiptBtn);
    }

    /**
     * get bank name for refund
     *
     * @return
     */
    public String getBankNameForRefund() {
        return playwrightHelpers.getText(selectedBankForRefund);
    }
}
