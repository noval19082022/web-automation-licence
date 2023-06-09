package pageobject.admin.mamipay.invoice;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.JavaHelpers;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

import java.util.List;

public class MamikosListInvoicePO {
    private Page page;
    private PlaywrightHelpers playwright;
    private LocatorHelpers locator;
    Locator searchInvoiceBy;
    Locator inputSearchValue;
    Locator cariInvoice;
    Locator invoiceDetail;
    Locator addFeeButton;
    Locator inputCostTitle;
    Locator inputCostValue;
    Locator addFeeAdditionalPriceButton;
    Locator additionalPriceTypeOption;
    Locator detailFirst;
    Locator detailSecond;
    Page.GetByRoleOptions pageRoleOptions;
    Locator.GetByRoleOptions locatorRoleOptions;
    Locator otherPrice;
    Locator otherPriceName;
    Locator getOtherPriceNumber;
    Locator txtBasicAmount;
    Locator editBasicAmount;
    Locator basicAmountTextField;
    Locator updateButton;
    Locator shortlink;
    Locator invoiceNumber;
    Locator invoiceName;
    Locator scheduledDate;
    Locator orderType;
    Locator paymentMethod;
    Locator totalamount;
    Locator ownerrenter;
    Locator invoicestatus;
    Locator blankScreen;
    Locator resetButton;
    Locator inputScheduleFrom;
    Locator inputScheduleTo;
    Locator dataScheduledDate;
    Locator valueFrom;
    Locator valueTo;
    Locator clickChangeStatus;
    Locator inputDateAndTime;
    Locator checklistNotInMamipay;
    Locator clickSubmitChange;
    Locator logButtonSearchContract;
    Locator clickOnDetailFee;
    Locator clickOnBasicAmount;
    Locator updateAmountButton;
    Locator headerSearchInvoice;
    Locator dataDetailInvoice;
    Locator firstInvoiceNumber;
    Locator rowListInvoiceNumber;
    Locator paidInvoiceList;
    Locator searchByDropdownlist;
    Locator searchRefund;
    Locator editAddOns;
    Locator updateFeeAdditionalPriceButton;
    Locator actionResult;

    public MamikosListInvoicePO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.locator = new LocatorHelpers(page);
        searchInvoiceBy = page.locator("select[name=\"search_by\"]");
        inputSearchValue = page.locator("input[name=\"search_value\"]");
        cariInvoice = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cari Invoice"));
        addFeeButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add Fee"));
        inputCostTitle = page.locator("input[name=\"cost_title\"]");
        inputCostValue = page.locator("input[name=\"cost_value\"]");
        addFeeAdditionalPriceButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add Fee"));
        additionalPriceTypeOption = page.locator("#cost-type-select");
        detailFirst = page.locator("tr:first-of-type td a:first-of-type + a");
        detailSecond = page.locator("//tr[2]//td[@class='invoice-action']//*[@class='btn btn-xs bg-maroon btn-flat']");
        txtBasicAmount = page.locator("//*[.='Basic Amount']/following-sibling::dd[1]");
        pageRoleOptions = new Page.GetByRoleOptions();
        locatorRoleOptions = new Locator.GetByRoleOptions();
        editBasicAmount = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(""));
        basicAmountTextField = page.getByRole(AriaRole.TEXTBOX);
        updateButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Update"));
        shortlink = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("Shortlink"));
        invoiceNumber = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("Invoice Number"));
        invoiceName = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("Invoice Name"));
        scheduledDate = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("Scheduled Date"));
        orderType = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("Order Type"));
        paymentMethod = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("Payment Method"));
        totalamount = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("Total Amount"));
        ownerrenter = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("Owner/Renter"));
        invoicestatus = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("Invoice Status"));
        blankScreen = page.locator(".box-footer");
        resetButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Reset"));
        inputScheduleFrom = page.locator("input[name='schedule_date_from']");
        inputScheduleTo = page.locator("input[name='schedule_date_to']");
        dataScheduledDate = page.locator("//tr[1]/td[4]");
        valueFrom = page.locator("input[name='nominal_from']");
        valueTo = page.locator("input[name='nominal_to']");
        clickChangeStatus = page.locator("//a[.='Change Status']");
        inputDateAndTime = page.locator("//input[@name='paid_at']");
        checklistNotInMamipay = page.locator("#notMamipay");
        clickSubmitChange = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit Change"));
        logButtonSearchContract = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("View Log"));
        clickOnDetailFee = page.locator("(//a[@class='btn btn-xs bg-maroon btn-flat'][normalize-space()='Detail Fee'])[1]");
        clickOnBasicAmount = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(""));
        updateAmountButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Update"));
        headerSearchInvoice = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Search Invoice"));
        dataDetailInvoice = page.locator("//tbody[1]/tr[1]");
        firstInvoiceNumber = page.locator("//tr[1]//td[2]");
        rowListInvoiceNumber = page.locator("//td[2]");
        paidInvoiceList = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Paid Invoice List "));
        searchByDropdownlist = page.locator(".col-xs-2:nth-child(1) .filter-option");
        searchRefund = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search"));
        editAddOns = page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName("adiautomation Add Ons 100000  ")).getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName(""));
        updateFeeAdditionalPriceButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Update Fee"));
        actionResult = page.getByText("The cost value must be an integer.");
    }

    /**
     * This method will set status on Change Status Invoice Page
     *
     * @param status
     */
    public void setStatusPaidOrUnpaid(String status) {
        page.getByRole(AriaRole.COMBOBOX).selectOption(status);
    }

    /**
     * this method will fill date on change status invoice page
     *
     * @param date
     */
    public void setDate(String date) {
        page.getByPlaceholder("Transaction Date").fill(date);
    }

    /**
     * Search invoice by
     *
     * @param searchBy String data type
     */
    public void selectSearchInvoiceBy(String searchBy) {
        playwright.selectDropdownByValue(searchInvoiceBy, searchBy);
    }

    /**
     * Fill search value
     *
     * @param searchValue String data type
     */
    public void fillInputSearchValue(String searchValue) {
        inputSearchValue.fill(searchValue);
    }

    /**
     * Click on cari invoice
     */
    public void clickOnCariInvoice() {
        playwright.clickOn(cariInvoice);
    }

    /**
     * Go to invoice detail
     *
     * @param invoiceText Text of unique parameter of invoice(e.g invoice number)
     */
    public void goToInvoiceDetail(String invoiceText) {
        invoiceDetail = page.getByRole(AriaRole.ROW, pageRoleOptions.setName(invoiceText)).getByRole(AriaRole.LINK, locatorRoleOptions.setName("Detail Fee")).first();
        playwright.clickOn(invoiceDetail);
    }

    /**
     * Click on add fee in invoice detail
     */
    public void clickOnAddFeeInInvoice() {
        playwright.clickOn(addFeeButton);
    }

    /**
     * Click on Detail in first invoice detail
     */
    public void clickOnDetailFirstButton() {
        playwright.clickOn(detailFirst);
    }

    /**
     * Click on Detail in first invoice detail
     */
    public void clickOnDetailSecondButton() {
        playwright.clickOn(detailSecond);
    }

    /**
     * Fill additional price name
     *
     * @param priceName Price/Title name of addiontal price
     */
    public void fillAdditionalPriceName(String priceName) {
        inputCostTitle.fill(priceName);
    }

    /**
     * Fill additional price cost value
     *
     * @param priceValue String data type number
     */
    public void fillAdditionalPriceCostValue(String priceValue) {
        inputCostValue.fill(priceValue);
    }

    /**
     * Click on add fee in additional price
     */
    public void clickOnAddFeeInAdditionalPrice() {
        playwright.clickOn(addFeeAdditionalPriceButton);
    }

    /**
     * Select additional price type
     *
     * @param costType cost type one of the following list: fixed, other, admin, discount, addon.
     *                 by default dropdown value is other
     */
    public void selectAdditionalPriceType(String costType) {
        playwright.selectDropdownByValue(additionalPriceTypeOption, costType);
    }

    /**
     * Get invoice detail element value
     *
     * @param invoiceEl input with element name that present on invoice detail
     * @return string data type
     */
    public String getInvoiceElementValue(String invoiceEl) {
        return playwright.getText(page.locator("//*[.='" + invoiceEl + "']/following-sibling::*[1]")).trim();
    }

    /**
     * Get other price's price number
     *
     * @param invoiceEl input with other price Fee Type example "Admin", "Biaya Tetap" etc
     * @return Integer data type of other price's price number
     */
    public Integer getOtherPriceNumber(String invoiceEl) {
        getOtherPriceNumber = page.locator("//*[.='" + invoiceEl + "']/following-sibling::*[1]");
        return JavaHelpers.extractNumber(playwright.getText(getOtherPriceNumber));
    }

    /**
     * Get basic amount as text
     *
     * @return string data type
     */
    public String getBasicAmountText() {
        return playwright.getText(txtBasicAmount);
    }

    /**
     * Delete active other price
     *
     * @param otherPriceName input with other price name
     * @throws InterruptedException
     */
    public void deleteAdditionalOtherPrice(String otherPriceName) throws InterruptedException {
        otherPrice = page.locator("//*[.='" + otherPriceName + "']/following-sibling::*//*[@title='Delete Fee']");
        playwright.clickOn(otherPrice);
        page.waitForSelector(".callout.callout-success");
    }

    /**
     * Get total amount by it index
     *
     * @param invoiceIndex index input with number. By element index.
     * @return string data type
     */
    public String getTotalAmount(int invoiceIndex) {
        return playwright.getText(page.locator("tr:nth-child(" + invoiceIndex + ") td:nth-child(5)"));
    }

    /**
     * Edit basic amount on admin invoice
     *
     * @param newBasicAmountPrice input with desired price
     * @throws InterruptedException
     */
    public void editBasicAmount(Integer newBasicAmountPrice) throws InterruptedException {
        playwright.clickOn(editBasicAmount);
        playwright.forceFill(basicAmountTextField, newBasicAmountPrice.toString());
        playwright.clickOn(updateButton);
    }

    /**
     * Check the visibility of aditional price is visible
     *
     * @return boolean
     */
    public boolean isAdditionalPriceNameIsVisible(String otherPrice) {
        otherPriceName = page.locator("//*[.='" + otherPrice + "']");
        for (int i = 0; i < 4; i++) {
            if (otherPriceName.isVisible()) {
                break;
            }
        }
        return playwright.waitTillLocatorIsVisible(otherPriceName);
    }

    /**
     * Verify Data Transaction
     *
     * @throws InterruptedException
     */
    public void verifyDataTransaction() throws InterruptedException {
        playwright.waitTillLocatorIsVisible(shortlink);
        playwright.waitTillLocatorIsVisible(invoiceNumber);
        playwright.waitTillLocatorIsVisible(invoiceName);
        playwright.waitTillLocatorIsVisible(scheduledDate);
        playwright.waitTillLocatorIsVisible(orderType);
        playwright.waitTillLocatorIsVisible(paymentMethod);
        playwright.waitTillLocatorIsVisible(totalamount);
        playwright.waitTillLocatorIsVisible(ownerrenter);
        playwright.waitTillLocatorIsVisible(invoicestatus);
    }

    /**
     * user get blank Screen
     *
     * @throws InterruptedException
     */
    public void getBlankScreen() throws InterruptedException {
        playwright.getText(blankScreen);
    }

    /**
     * Click Button reset
     *
     * @throws InterruptedException
     */
    public void clickReset() throws InterruptedException {
        playwright.clickOn(resetButton);
    }

    /**
     * verify data based other invoice booking
     *
     * @throws InterruptedException
     */
    public void getDataInvoice(String otherInvoiceBooking) throws InterruptedException {
        playwright.waitTillLocatorIsVisible(page.locator("//td[.='" + otherInvoiceBooking + "']"));
    }

    /**
     * user choose pament method
     *
     * @throws InterruptedException
     */
    public void selectPayment(String method) {
        playwright.selectDropdownByValue(page.locator("select[name='payment_method']"), method);
    }

    /**
     * user verify data transaction with method has been selected earlier
     *
     * @throws InterruptedException
     */
    public void showResultData(String resultMethod) throws InterruptedException {
        playwright.waitTillLocatorIsVisible(page.locator("(//td[contains(.,'" + resultMethod + "')])[1]"));
    }

    /**
     * user input schdule date from and to
     *
     * @throws InterruptedException
     */
    public void chooseSchedule(String From, String To) throws InterruptedException {
        inputScheduleFrom.click();
        page.keyboard().type(From);
        inputScheduleTo.click();
        page.keyboard().type(To);
        playwright.clickOn(cariInvoice);
    }

    /**
     * verify data transaction that already selected
     *
     * @throws InterruptedException
     */
    public void showDataBaseOnScheduleDate() throws InterruptedException {
        playwright.getText(dataScheduledDate);
    }

    /**
     * input nominal from and to
     *
     * @throws InterruptedException
     */
    public void inputValueAmount(String nominalFrom, String nominalTo) throws InterruptedException {
        valueFrom.click();
        page.keyboard().type(nominalFrom);
        valueTo.click();
        page.keyboard().type(nominalTo);
        playwright.clickOn(cariInvoice);
    }

    /**
     * verify data based on nominal
     *
     * @throws InterruptedException
     */
    public void showResultBasedOnNominal(String dataNominal) throws InterruptedException {
        playwright.waitTillLocatorIsVisible(page.locator("(//td[.='" + dataNominal + "'])[1]"));
    }

    /**
     * choose status transaction
     *
     * @throws InterruptedException
     */
    public void selectDetailStatus(String statusTransaction) throws InterruptedException {
        playwright.selectDropdownByValue(page.locator("select[name='status']"), statusTransaction);
    }

    /**
     * verify data transaction based on status
     */
    public void resultDataBasedOnStatus(String dataStatus) {
        playwright.waitTillLocatorIsVisible(page.locator("(//span[.='" + dataStatus + "'])[1]"));
    }

    /**
     * select order type
     *
     * @throws InterruptedException
     */
    public void selectOrderType(String selectOrderType) throws InterruptedException {
        playwright.selectDropdownByValue(page.locator("select[name='order_type']"), selectOrderType);
    }

    /**
     * verify data based on order type
     *
     * @throws InterruptedException
     */
    public void resultDataBasedOnOrderType(String resultType) throws InterruptedException {
        playwright.waitTillLocatorIsVisible(page.locator("(//td[contains(.,'" + resultType + "')])[1]"));
    }

    /**
     * user click status invoice
     *
     * @throws InterruptedException
     */
    public void clickChangeStatus() throws InterruptedException {
        playwright.clickOn(clickChangeStatus);
    }

    /**
     * user change status invoice to paid
     *
     * @throws InterruptedException
     */
    public void changeToPaid(String method) throws InterruptedException {
        playwright.selectDropdownByValue(page.getByRole(AriaRole.COMBOBOX), method);
    }

    /**
     * user input date and time
     *
     * @throws InterruptedException
     */
    public void inputDateAndTime(String date) throws InterruptedException {
        inputDateAndTime.click();
        page.keyboard().type(date);
        playwright.clickOn(clickSubmitChange);
    }

    /**
     * invoice ststus updated
     *
     * @throws InterruptedException
     */
    public void showInvoiceAfterChange(String status) throws InterruptedException {
        playwright.waitTillLocatorIsVisible(page.locator("//span[text()='" + status + "']"));
    }

    /**
     * user checklist section not in mamipay
     *
     * @throws InterruptedException
     */
    public void checklistNotInMamipay() throws InterruptedException {
        playwright.clickOn(checklistNotInMamipay);
    }

    /**
     * click see log button
     *
     * @throws InterruptedException
     */
    public void clickSeeLogButton() throws InterruptedException {
        if (playwright.waitTillLocatorIsVisible(logButtonSearchContract)) {
            playwright.clickOn(logButtonSearchContract);
        } else {
            playwright.clickOn(logButtonSearchContract);
        }
    }

    /**
     * log status invoice
     *
     * @param status
     * @return
     * @throws InterruptedException
     */
    public String logStatusInvoice(String status) throws InterruptedException {
        return page.locator("td").getByText(status).nth(0).textContent();
    }

    /**
     * click on detail fee button
     * * @throws InterruptedException
     */
    public void userClickOnDetailFee() throws InterruptedException {
        playwright.clickOn(clickOnDetailFee);
    }

    /**
     * click on basic amount button
     * * @throws InterruptedException
     */
    public void userClickOnBasicAmount(String amount) throws InterruptedException {
        playwright.clickOn(clickOnBasicAmount);
        basicAmountTextField.click();
        basicAmountTextField.clear();
        page.keyboard().type(amount);
        playwright.clickOn(updateAmountButton);
    }

    /**
     * Get invoice discount Page Header
     *
     * @return
     */
    public String getInvoiceDiscountPageHeader() {
        return playwright.getText(headerSearchInvoice);
    }

    /**
     * verify invoice number is appeared
     *
     * @return
     */
    public String getInvoiceNumber(String name) {
        return playwright.getText(page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(name)));
    }

    /**
     * verify invoice header is appeared
     *
     * @return
     */
    public String getSearchInvoicePageHeader() {
        return playwright.getText(headerSearchInvoice);
    }

    /**
     * verify data detail invoice is appeared
     */
    public void checkDataDetailInvoice() {
        playwright.waitTillLocatorIsVisible(dataDetailInvoice);
    }

    /**
     * verify first invoice
     *
     * @return
     */
    public String getFirstInvoiceTextOnList() {
        playwright.waitTillLocatorIsVisible(firstInvoiceNumber);
        return playwright.getText(firstInvoiceNumber);
    }

    /**
     * verify size invoice
     *
     * @return
     */
    public Integer totalRowListInvoice() {
        List<Locator> listLocator = rowListInvoiceNumber.all();
        return listLocator.size();
    }

    /**
     * user click paid invoice list and refund
     */
    public void clickPaidInvoiceList(String invoiceList) {
        page.reload();
        playwright.hardWait(5);
        playwright.clickOn(paidInvoiceList);
        playwright.clickOn(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(invoiceList)).nth(0));
    }

    /**
     * Select Filter Search By
     *
     * @param filterText
     * @throws InterruptedException
     */
    public void selectFilterSearchBy(String filterText) throws InterruptedException {
        playwright.clickOn(searchByDropdownlist);
        playwright.clickOn(page.locator("//span[normalize-space()='" + filterText + "']"));
    }

    /**
     * Enter Search Text in to Search box
     *
     * @param searchText search text
     * @throws InterruptedException
     */
    public void enterTextToSearchTextbox(String searchText) throws InterruptedException {
        playwright.clickOn(page.locator("input[name='search_value']"));
        page.keyboard().type(searchText);
        playwright.clickOn(searchRefund);
    }

    /**
     * Get result coloum kost detail
     *
     * @return string data type
     */
    public boolean listInColoumKostDetail(String kostName) {
        return playwright.waitTillLocatorIsVisible(page.locator("//tbody[1]/tr[1]/td[contains(.,'" + kostName + "')]"));
    }

    /**
     * click on edit addons button on field
     *
     */
    public void clickOnEditButton() {
        playwright.clickOn(editAddOns);
    }

    /**
     * Click on add fee in additional price
     */
    public void clickOnUpdateFeeInAdditionalPrice() {
        playwright.clickOn(updateFeeAdditionalPriceButton);
    }

    /**
     * Get action result message, success or fail message
     * @return string data type, succes or fail message
     */
    public String getActionResultMessage() {
        return playwright.getText(actionResult);
    }
}
