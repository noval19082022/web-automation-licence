package pageobject.admin.mamipay.manualPayout;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import config.playwright.context.ActiveContext;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

public class ManualPayoutPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private LocatorHelpers locator;
    private Locator searchButton;
    private Locator invoiceType;
    private Locator invoiceStatus;
    private Locator startDate;
    private Locator endDate;
    private Locator createDateFrom;
    private Locator createDateTo;
    private Locator createPayoutButton;
    private Locator payoutType;
    private Locator accountNumberField;
    private Locator accountNameField;
    private Locator bankAccountDropdown;
    private Locator amountField;
    private Locator reasonField;
    private Locator invoiceNumberField;
    private Locator confirmButton;
    private Locator cancelOnMainPageButton;
    private Locator changeTypeButton;
    private Locator changeTypeDropdown;
    private Locator changeInvoiceButton;
    private Locator submitChangeButton;
    private Locator editButton;
    private Locator updatePayoutButton;
    private Locator transferButton;
    private Locator amountWarning;
    private Locator reasonWaring;
    private Locator notAllowedWarning;
    private Locator minimalAmountWarning;
    private Locator readyToProcessedMessage;
    private Locator payoutCanceledMessage;
    private Locator successUpdateMessage;
    private Locator processingPayoutMessage;

    public ManualPayoutPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.locator = new LocatorHelpers(page);
        searchButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search"));
        invoiceType = page.locator("select[name=\"type\"]");
        invoiceStatus = page.locator("select[name=\"status\"]");
        startDate = page.getByPlaceholder("From");
        endDate = page.getByPlaceholder("To");
        createPayoutButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Create Payout"));
        payoutType = page.locator("select[name=\"type\"]");
        accountNumberField = page.locator("input[name=\"destination_account\"]");
        accountNameField = page.locator("input[name=\"destination_name\"]");
        bankAccountDropdown = page.locator("select[name=\"destination_bank\"]");
        amountField = page.locator("input[name=\"transfer_amount\"]");
        reasonField = page.locator("textarea[name=\"reason\"]");
        invoiceNumberField = page.locator("input[name=\"invoice_number\"]");
        confirmButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create Payout"));
        cancelOnMainPageButton = page.locator("(//a[text()='Cancel'])[1]");
        changeTypeButton = page.locator("(//a[text()='Change Type'])[1]");
        changeTypeDropdown = page.getByRole(AriaRole.COMBOBOX);
        changeInvoiceButton = page.locator("(//a[text()='Change Invoice'])[1]");
        submitChangeButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit Change"));
        editButton = page.locator("(//a[text()='Edit'])[1]");
        updatePayoutButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Update Payout"));
        transferButton = page.locator("(//a[text()='Transfer'])[1]");
        amountWarning = page.getByText("Amount required.");
        reasonWaring = page.getByText("Reason required.");
        notAllowedWarning = page.getByText("Not allowed to create transfer.");
        minimalAmountWarning = page.getByText("Amount minimal 10000.");
        readyToProcessedMessage = page.getByText("Payout ready to be processed.");
        payoutCanceledMessage = page.getByText("Payout cancelled.");
        successUpdateMessage = page.getByText("Data telah berhasil diupdate.");
        processingPayoutMessage = page.getByText("Payout is processing.");
    }

    /**
     * Click on serch button
     */
    public void clickOnSearchButton() {
        searchButton.click();
    }

    /**
     * verify the search result
     *
     * @throws InterruptedException
     */
    public void getSearchResult(String searchResult){
        playwright.waitTillLocatorIsVisible(page.locator("(//td[.='" + searchResult + "'])[1]"));
    }

    /**
     * Search invoice by Type
     *
     * @param searchBy String data type
     */
    public void selectInvoiceType(String searchBy) {
        playwright.selectDropdownByValue(invoiceType, searchBy);
    }



    /**
     * Search invoice by Type
     *
     * @param searchBy String data type
     */
    public void selectInvoiceStatus(String searchBy) {
        playwright.selectDropdownByValue(invoiceStatus, searchBy);
    }

    /**
     * Fill Start Date value
     * @param start String data type
     */
    public void fillStartDateValue(String start) {
        startDate.fill(start);
    }

    /**
     * Fill End Date value
     * @param end String data type
     */
    public void fillEndDateValue(String end) {
        endDate.fill(end);
    }

    /**
     * User verify data transaction that has been searched by create date
     */
    public void vefirytTransactionbyCreateDate(String createFrom, String createTo){
        Page page = ActiveContext.getActivePage();
        createDateFrom = page.locator("//td[contains(text(), '"+createFrom+"')]");
        createDateFrom.isVisible();
        createDateTo = page.locator("//td[contains(text(), '"+createTo+"')]");
        createDateTo.isVisible();
    }

    /**
     * Click on Create Payout button
     */
    public void clickOnCreatePayoutButton() {
        createPayoutButton.click();
    }

    /**
     * Check if amount warning visible
     * @return boolean type, visible true otherwise false
     */
    public boolean isAmountWarningVisible() {
        return amountWarning.isVisible();
    }

    /**
     * Check if reason warning visible
     * @return boolean type, visible true otherwise false
     */
    public boolean isReasonWarningVisible() {
        return reasonWaring.isVisible();
    }

    /**
     * Select Payout type
     * @param type String data type
     */
    public void selectPayoutType(String type) {
        playwright.selectDropdownByValue(payoutType, type);
    }

    /**
     * Fill Account number
     * @param acount String data type
     */
    public void fillAccountNumber(String acount) {
        accountNumberField.fill(acount);
    }

    /**
     * Fill Account name
     * @param name String data type
     */
    public void fillAccountName(String name) {
        accountNameField.fill(name);
    }

    /**
     * Select Bank Account
     * @param bank String data type
     */
    public void selectBankAccount(String bank) {
        playwright.selectDropdownByValue(bankAccountDropdown, bank);
    }

    /**
     * Fill Amount
     * @param amount String data type
     */
    public void fillAmount(String amount) {
        amountField.fill(amount);
    }

    /**
     * Fill Reason
     * @param reason String data type
     */
    public void fillReason(String reason) {
        reasonField.fill(reason);
    }

    /**
     * Fill Invoice Number
     * @param invoice String data type
     */
    public void fillInvoice(String invoice) {
        invoiceNumberField.fill(invoice);
    }

    /**
     * Click on confirm create payout button
     */
    public void clickOnConfirmButton() {
        confirmButton.click();
    }

    /**
     * Check if Not allowed error message visible
     * @return boolean type, visible true otherwise false
     */
    public boolean isNotAllowedErrorMessageVisible() {
        return notAllowedWarning.isVisible();
    }

    /**
     * Check if minimal amount warning visible
     * @return boolean type, visible true otherwise false
     */
    public boolean isMinimalAmountWarningVisible() {
        return minimalAmountWarning .isVisible();
    }

    /**
     * Check if Payout ready to precessed message visible
     * @return boolean type, visible true otherwise false
     */
    public boolean isPayoutReadyToPrecessedMessageVisible() {
        return readyToProcessedMessage.isVisible();
    }

    /**
     * Click on cancel button on main page
     */
    public void clickCancelButtonOnMainPage() {
        cancelOnMainPageButton.click();
    }

    /**
     * Check if Payout canceled message visible
     * @return boolean type, visible true otherwise false
     */
    public boolean isPayoutCanceledMessageVisible() {
        return payoutCanceledMessage.isVisible();
    }

    /**
     * Click on Change Type button
     */
    public void clickOnChangeTypeButton() {
        changeTypeButton.click();
    }

    /**
     * Change Payout type
     * @param type String data type
     */
    public void changePayoutType(String type) {
        playwright.selectDropdownByValue(changeTypeDropdown, type);
    }

    /**
     * Click on Submit Change button
     */
    public void clickOnSubmitChangeButton() {
        submitChangeButton.click();
    }

    /**
     * Check if Success Update Payout type message visible
     * @return boolean type, visible true otherwise false
     */
    public boolean isSuccessUpdateMessageVisible() {
        return playwright.waitTillLocatorIsVisible(successUpdateMessage);
    }

    /**
     * Click on Change Type button
     */
    public void clickOnChangeInvoiceButton() {
        changeInvoiceButton.click();
    }

    /**
     * Click on Edit button on main page
     */
    public void clickEditButtonOnMainPage() {
        editButton.click();
    }

    /**
     * Click on Update Payout button
     */
    public void clickOnUpdatePayoutButton() {
        updatePayoutButton.click();
    }

    /**
     * Click on Transfer button on main page
     */
    public void clickOnTransferButtonOnMainPage() {
        playwright.acceptDialog(transferButton);
    }

    /**
     * Check if Processing Payout message visible
     * @return boolean type, visible true otherwise false
     */
    public boolean isProcessingPayoutMessageVisible() {
        return processingPayoutMessage.isVisible();
    }
}
