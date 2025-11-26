package pageobject.admin.mamipay.manualPayout;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import config.playwright.context.ActiveContext;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

import java.util.Optional;

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
    private Locator sortingOption;

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
        cancelOnMainPageButton = page.locator("//a[text()='Cancel']").first();
        changeTypeButton = page.locator("//a[text()='Change Type']").first();
        changeTypeDropdown = page.getByRole(AriaRole.COMBOBOX);
        changeInvoiceButton = page.locator("//a[text()='Change Invoice']").first();
        submitChangeButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit Change"));
        editButton = page.locator("//a[text()='Edit']").first();
        updatePayoutButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Update Payout"));
        transferButton = page.locator("//a[text()='Transfer']").first();
        amountWarning = page.getByText("Amount required.");
        reasonWaring = page.getByText("Reason required.");
        notAllowedWarning = page.getByText("Not allowed to create transfer.");
        minimalAmountWarning = page.getByText("Amount minimal 10000.");
        readyToProcessedMessage = page.getByText("Payout ready to be processed.");
        payoutCanceledMessage = page.getByText("Payout cancelled.");
        successUpdateMessage = page.getByText("Data telah berhasil diupdate.");
        processingPayoutMessage = page.locator(".callout.callout-success");
        sortingOption = page.locator("select[name='sort']");
    }

    /**
     * Check if error page is displayed
     * @return true if error page is displayed
     */
    public boolean isErrorPageDisplayed() {
        try {
            // First check the page title for error codes
            String pageTitle = page.title();
            if (pageTitle != null) {
                String lowerTitle = pageTitle.toLowerCase();
                if (lowerTitle.contains("429") || lowerTitle.contains("502") || lowerTitle.contains("504") || 
                    lowerTitle.contains("error") || lowerTitle.contains("bad gateway") || lowerTitle.contains("timeout")) {
                    return true;
                }
            }
            
            // Check for error pages using a single efficient selector
            boolean hasErrorPage = playwright.waitTillLocatorIsVisible(
                page.locator("center h1:text-matches('(502|504|429|Bad Gateway|Gateway Timeout|Too Many Requests)'), body > h1:text-matches('(502|504|429)')"), 
                1000.0
            );
            
            return hasErrorPage;
        } catch (Exception e) {
            // If any error occurs while checking, assume no error page
            return false;
        }
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
    public void getSearchResult(String searchResult) {
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
     *
     * @param start String data type
     */
    public void fillStartDateValue(String start) {
        startDate.fill(start);
    }

    /**
     * Fill End Date value
     *
     * @param end String data type
     */
    public void fillEndDateValue(String end) {
        endDate.fill(end);
    }

    /**
     * User verify data transaction that has been searched by create date
     */
    public void vefirytTransactionbyCreateDate(String createFrom, String createTo) {
        Page page = ActiveContext.getActivePage();
        createDateFrom = page.locator("//td[contains(text(), '" + createFrom + "')]");
        createDateFrom.isVisible();
        createDateTo = page.locator("//td[contains(text(), '" + createTo + "')]");
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
     *
     * @return boolean type, visible true otherwise false
     */
    public boolean isAmountWarningVisible() {
        return amountWarning.isVisible();
    }

    /**
     * Check if reason warning visible
     *
     * @return boolean type, visible true otherwise false
     */
    public boolean isReasonWarningVisible() {
        return reasonWaring.isVisible();
    }

    /**
     * Select Payout type
     *
     * @param type String data type
     */
    public void selectPayoutType(String type) {
        playwright.selectDropdownByValue(payoutType, type);
    }

    /**
     * Fill Account number
     *
     * @param acount String data type
     */
    public void fillAccountNumber(String acount) {
        accountNumberField.fill(acount);
    }

    /**
     * Fill Account name
     *
     * @param name String data type
     */
    public void fillAccountName(String name) {
        accountNameField.fill(name);
    }

    /**
     * Select Bank Account
     *
     * @param bank String data type
     */
    public void selectBankAccount(String bank) {
        playwright.selectDropdownByValue(bankAccountDropdown, bank);
    }

    /**
     * Fill Amount
     *
     * @param amount String data type
     */
    public void fillAmount(String amount) {
        amountField.fill(amount);
    }

    /**
     * Fill Reason
     *
     * @param reason String data type
     */
    public void fillReason(String reason) {
        reasonField.fill(reason);
    }

    /**
     * Fill Invoice Number
     *
     * @param invoice String data type
     */
    public void fillInvoice(String invoice) {
        invoiceNumberField.fill(invoice);
    }

    /**
     * Click on confirm create payout button
     */
    public void clickOnConfirmButton() {
        playwright.clickOn(confirmButton);
        // Wait a bit for server response
        playwright.hardWait(2000.0);
        // Check if error page appears after submission
        if (isErrorPageDisplayed()) {
            playwright.reloadPage();
        }
    }

    /**
     * Check if Not allowed error message visible
     *
     * @return boolean type, visible true otherwise false
     */
    public boolean isNotAllowedErrorMessageVisible() {
        return notAllowedWarning.isVisible();
    }

    /**
     * Check if minimal amount warning visible
     *
     * @return boolean type, visible true otherwise false
     */
    public boolean isMinimalAmountWarningVisible() {
        return minimalAmountWarning.isVisible();
    }

    /**
     * Check if Payout ready to precessed message visible
     *
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
     *
     * @return boolean type, visible true otherwise false
     */
    public boolean isPayoutCanceledMessageVisible() {
        return payoutCanceledMessage.isVisible();
    }

    /**
     * Click on Change Type button
     */
    public void clickOnChangeTypeButton() {
        playwright.clickOn(changeTypeButton);
    }

    /**
     * Change Payout type
     *
     * @param type String data type
     */
    public void changePayoutType(String type) {
        var typeInput = type.trim();
        type = typeInput.equals("Refund Outside MamiPAY") ? "refund_outside" : type;
        type = typeInput.equals("Payout to Tenant") ? "payout_tenant" : type;
        type = typeInput.equals("Additional Payout to Owner") ? "payout_tenant" : type;
        playwright.selectDropdownByValue(changeTypeDropdown, type.trim().toLowerCase().replaceAll(" ", "_"));
    }

    /**
     * Click on Submit Change button
     */
    public void clickOnSubmitChangeButton() {
        submitChangeButton.click();
    }

    /**
     * Check if Success Update Payout type message visible
     *
     * @return boolean type, visible true otherwise false
     */
    public boolean isSuccessUpdateMessageVisible() {
        playwright.waitTillLocatorIsVisible(successUpdateMessage);
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
        playwright.clickOn(editButton);
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
        // Wait for the page to load
        playwright.hardWait(2000.0);
        
        // Find all transfer buttons
        Locator allTransferButtons = page.locator("//a[text()='Transfer']");
        int count = allTransferButtons.count();
        
        // Find the first visible and enabled transfer button
        for (int i = 0; i < count; i++) {
            Locator currentButton = allTransferButtons.nth(i);
            if (currentButton.isVisible() && currentButton.isEnabled()) {
                // Click this transfer button with dialog acceptance
                playwright.acceptDialog(currentButton);
                return;
            }
        }
        
        // If no transfer button found, fall back to the first one
        playwright.waitTillLocatorIsVisible(transferButton, 10000.0);
        playwright.acceptDialog(transferButton);
    }

    /**
     * Check if Processing Payout message visible
     *
     * @return boolean type, visible true otherwise false
     */
    public boolean isProcessingPayoutMessageVisible() {
        // Wait for page to stabilize after clicking transfer
        playwright.hardWait(5000.0);
        
        // Check if we're still on the correct page
        if (isErrorPageDisplayed()) {
            return false;
        }
        
        // Just check for the specific processing message with longer timeout
        return playwright.waitTillLocatorIsVisible(processingPayoutMessage, 20000.0);
    }

    /**
     * sorting payout list
     * @param sortDirection
     */
    public void sortPayoutList(String sortDirection) {
        String direction = Optional.ofNullable(sortDirection)
                .map(String::toLowerCase)
                .filter(s -> s.equals("newest") || s.equals("oldest"))
                .map(s -> s.equals("newest") ? "desc" : "asc")
                .orElse("");
        playwright.selectDropdownByValue(sortingOption, direction);
    }
}
