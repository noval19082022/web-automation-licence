package pageobject.admin.mamipay.paidinvoicelist;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.SelectOption;
import utilities.PlaywrightHelpers;

public class RefundPO {
    private Page page;
    private PlaywrightHelpers playwrightHelpers;
    private Locator refundBtnNotCC;
    private Locator refundBtnForCC;
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
    // failed list
    private Locator failed;
    private Locator detailBtn;
    private Locator amountRefundWarningText;
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
    private Locator reasonField;

    public RefundPO(Page page) {
        this.page = page;
        this.playwrightHelpers = new PlaywrightHelpers(page);
        this.refundBtnNotCC = page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName(" - MAMI")).getByRole(AriaRole.BUTTON).first();
        this.refundBtnForCC = page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName(" ( from Credit Card ) MAMI")).getByRole(AriaRole.BUTTON).first();
        //--- refund detail ----
        this.selectedBankForRefund = page.getByRole(AriaRole.COMBOBOX).getByRole(AriaRole.TEXTBOX).first();
        this.selectBank = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Mandiri")).locator("span").nth(1);
        this.searchBankName = page.locator("input[type='search']");
        this.checkMarkAdminFee = page.locator("//div[@class='refund-invoice__modal modal fade in']//label[1]/input[1]");
        this.inputAmountRefund = page.locator("//div[@class='refund-invoice__modal modal fade in']//div[1]/input[@class='form-control']");
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
        //---- failed list
        this.failed = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Failed"));
        this.detailBtn = page.getByRole(AriaRole.ROW).getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Detail")).first();
        this.amountRefundWarningText = page.locator(".box-body > div:nth-of-type(1) div:nth-of-type(2) > div:nth-of-type(1) > span:nth-of-type(1)");
        //--- export transferred detail ---
        this.chooseDateTransferredReport = page.locator("#refund-invoice-daterange");
        this.chooseExportForToday = page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("Today"));
        this.downloadXlsReport = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Download .XLSX"));
        //-- data booking menu on bank kerupux ---
        this.actionBtnOnInvoiceList = page.locator("(//button[@type='button'][normalize-space()='Actions'])[1]");
        this.actionTransferredPermission = page.locator("//a[@title='Set Transfer Permission']").first();
        this.allowRefundBox = page.getByRole(AriaRole.COMBOBOX);
        this.refundReasons = page.locator("select[name='refund_reason']");
        this.sendBtnRefund = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Send"));
        this.filterTransactionBtn = page.getByText("Tampilkan Filter");
        this.phoneNumberPlaceHolder = page.getByPlaceholder("Ex: 081987654321");
        this.cariBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Cari"));
        this.reasonField = page.locator("//div[@class='refund-invoice__modal modal fade in']//select[@class='form-control refund-invoice__modal-select']");
    }

    /**
     * admin click refund btn for the first invoice list non cc
     */
    public void clickOnRefundBtn() {
        playwrightHelpers.clickOn(refundBtnNotCC);
    }

    /**
     * admin click refund btn for the first invoice list for cc payment
     */
    public void clickOnRefundBtnForCCPayment() {
        playwrightHelpers.clickOn(refundBtnForCC);
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
     * clickOn the admin fee on refund process
     */
    public void clickOnCheckAdminFee() {
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
    public void chooseRefundReasonPemilikMembatalkan(String Reason) {
        playwrightHelpers.clickOn(reasonField);
        playwrightHelpers.selectDropdownBySelectOption(reasonField, new SelectOption().setValue(Reason));
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

    /**
     * click on failed to redirect to the failed list invoice
     */
    public void clickOnFailedBtn() {
        playwrightHelpers.clickOn(failed);
    }

    /**
     * click on detailBtn on first list of failed refund
     */
    public void clickOnDetailFailedInvoiceList() {
        playwrightHelpers.clickOn(detailBtn);
    }

    /**
     * Input data refund
     * click on search button
     */
    public void adminSearchDataRefund(String name, String value) {
        playwrightHelpers.clickOn(searchBy);
        Locator searchBy = page.locator("//span[normalize-space()='"+name+"']");
        playwrightHelpers.clickOn(searchBy);
        Locator valueBy = page.locator("input[placeholder='Search']");
        playwrightHelpers.fill(valueBy, value);
        playwrightHelpers.clickOn(searchBtnAction);
    }

    /**
     * check if amount refund warning text is visible
     *
     * @return boolean
     */
    public boolean isLessAmountVisible(String text) {
        return playwrightHelpers.getText(amountRefundWarningText).contains(text);
    }

}
