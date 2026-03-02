package pageobject.admin.mamipay.contract;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import utilities.PlaywrightHelpers;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SearchContractPO {
    private Page page;
    private PlaywrightHelpers playwright;
    Locator searchContract;
    Locator searchBy;
    Locator searchInput;
    Locator searchKostLevel;
    Locator searchButton;
    Locator batalkanContractButton;
    Locator berhentikanContractButton;
    Locator berhentikanContractPopUpButton;
    Locator akhiriContractLink;
    Locator successTerminateText;
    private Locator editDepositBtn;
    private Locator inputTextDetailKerusakan;
    private Locator seeLogBtn;
    private Locator extendContractBtn;
    private Locator akhiriContractButton;
    private Locator bankNameText;
    private Locator konfirmasiSisaDepoBtn;
    private Locator akhiriContractHead;
    private Locator callout;
    Locator searchTextBox;
    Locator invoiceEl;
    Locator detailInvoiceEl;
    Locator tableHeader;

    public SearchContractPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        searchContract = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Search Contract"));
        searchBy = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Search by"));
        searchButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search"));
        searchInput = page.getByPlaceholder("Search");
        searchKostLevel = page.getByPlaceholder("Kos Level");
        batalkanContractButton = page.locator("li > .btn").first();
        berhentikanContractButton = page.locator(".tools-contract__btn-danger");
        berhentikanContractPopUpButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Akhiri Kontrak"));
        akhiriContractLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Akhiri Kontrak"));
        akhiriContractButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Akhiri Kontrak"));
        successTerminateText = page.getByText("Kontrak berhasil diakhiri.");
        akhiriContractHead = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Akhiri Kontrak Sewa"));
        editDepositBtn = page.locator("a").getByText("Edit Deposit").first();
        bankNameText = page.locator("//div[@class='tools-contract__modal modal fade in']//select[@name='destination_bank']");
        konfirmasiSisaDepoBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Konfirmasi Sisa Deposit"));
        inputTextDetailKerusakan = page.getByRole(AriaRole.DIALOG, new Page.GetByRoleOptions().setName("Edit Deposit for Confirm to Finance")).locator("textarea[name='remark']");
        seeLogBtn = page.locator("a").getByText("See log").first();
        extendContractBtn = page.locator("a").getByText("Extend Kontrak").first();
        searchTextBox = page.locator("input[name='search_value']");
        callout = page.locator(".callout");
    }

    /**
     * Select dropdown search kost level
     *
     * @param kostLevel option value String type
     */
    public void selectKosLevel(String kostLevel) {
        playwright.clickLocatorAndTypeKeyboard(searchKostLevel, kostLevel);
        playwright.pressKeyboardKey("Enter");
    }

    /**
     *
     * @param phoneNumber
     */
    public void selectRenterPhoneNumber(String phoneNumber) {
        playwright.selectDropdownByValue(searchBy, "renter_phone_number");
        playwright.clickLocatorAndTypeKeyboard(searchInput, phoneNumber);
    }

    /**
     * Select dropdown search contract periode
     *
     * @param periode
     */
    public void selectPeriodSearchContract(String periode) {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Contract Date Period ")).click();
        page.locator("li").getByText(periode).click();
    }

    /**
     * Click on edit deposit button
     */
    public void clickOnEditDepositButton() {
        playwright.clickOn(editDepositBtn);
    }

    /**
     * input text detail kerusakan
     *
     * @param text
     */
    public void inputDetailKerusakan(String text) {
        playwright.clickLocatorAndTypeKeyboard(inputTextDetailKerusakan, text);
    }

    /**
     * Click on see log button
     */
    public void clickOnSeeLogButton() {
        seeLogBtn.click();
    }

    /**
     * check if contract data is not null
     *
     * @return boolean
     */
    public boolean isContractDataVisible() {
        return page.locator("tbody").first().locator("tr").first().isVisible();
    }

    /**
     * check if search contract header is visible
     *
     * @return boolean
     */
    public boolean isSearchContractHeaderVisible() {
        return page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Search Contract")).isVisible();
    }

    /**
     * Select dropdown search by it value
     *
     * @param optionValue option value String type
     */
    public void selectSearchBy(String optionValue) {
        searchBy.selectOption(optionValue);
    }

    /**
     * Fill search input value
     *
     * @param search String type e.g (Phone Number Tenant or Phone Number Owner)
     */
    public void fillSearchByValue(String search) {
        playwright.clearText(searchInput);
        playwright.clickLocatorAndTypeKeyboard(searchInput, search);
    }

    /**
     * Click on search button
     */
    public void clickOnSearchButton() {
        searchButton.click();
    }


    /**
     * check if akhiri kontak button on terminate kontrak pop up is disable
     *
     * @return boolean
     */
    public Boolean isTerminatedContractButtonDissable() {
        if (page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Akhiri Kontrak")).isVisible()) {
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Akhiri Kontrak")).click();
        }
        return page.locator("div").locator("input").getByText("Akhiri Kontrak").isDisabled();
    }

    /**
     * Set accept dialog and click on revoke/batalkan contract button
     */
    public void clickOnCancelContractButton() {
        if (playwright.waitTillLocatorIsVisible(batalkanContractButton, 5000.00)) {
            playwright.acceptDialog(batalkanContractButton);
            try {
                page.waitForSelector(".callout.callout-success", new Page.WaitForSelectorOptions().setTimeout(15000));
            } catch (com.microsoft.playwright.TimeoutError e) {
                System.out.println("Success callout did not appear within timeout period: " + e.getMessage());
            }
        }
    }

    /**
     * Set accept dialog and click on terminate contract button
     */
    public void clickOnTerminateContractButton() {
        if (playwright.waitTillLocatorIsVisible(berhentikanContractButton, 5000.00)) {
            playwright.acceptDialog(berhentikanContractButton);
            berhentikanContractPopUpButton.click();
            try {
                page.waitForSelector(".callout.callout-success", new Page.WaitForSelectorOptions().setTimeout(15000));
            } catch (com.microsoft.playwright.TimeoutError e) {
                System.out.println("Success callout did not appear within timeout period: " + e.getMessage());
            }
        }
    }


    /**
     * Wait until terminated is process is finished
     *
     * @return
     */
    public boolean waitUntilSuccessTerminateVisible() {
        return successTerminateText.isVisible();
    }

    /**
     * Wait for callout messagge to be visible
     * @return visible true otherwise false
     */
    public boolean waitForCalloutMessage() {
        return playwright.waitTillLocatorIsVisible(callout, 15000.0);
    }

    /**
     * Get callout text
     * @return String data type
     */
    public String getCalloutText() {
        return playwright.getText(callout);
    }

    /**
     * Get success terminate heading text
     *
     * @return String data type
     */
    public String getSuccessTerminateHeadingText() {
        return playwright.getText(successTerminateText);
    }

    /**
     * Click on akhiri contract button, and accept akhiri kontrak dialog.
     * Or input date if date picker appear.
     */
    public void clickOnAkhiriContractButton() {
        page.waitForLoadState(LoadState.LOAD);
        playwright.waitTillLocatorIsVisible(akhiriContractButton.first(), 10000.0);
        playwright.clickOn(akhiriContractButton.first());
        playwright.waitTillLocatorIsVisible(akhiriContractLink, 5000.0);
        playwright.clickOn(akhiriContractLink);
        page.waitForLoadState(LoadState.LOAD);
    }

    /**
     * choose bank on edit deposit page
     * @param bankName
     */
    public void chooseBankOnEditDepositPage(String bankName) {
        bankNameText.click();
        page.keyboard().type(bankName);
        page.mouse().down();
    }

    /**
     * check if bank name is exist on the detail edit deposit
     * @param bankName
     * @return string bank name
     */
    public String getTextBankOnEditDeposit(String bankName) {
        return page.getByText(bankName).first().textContent();
    }

    /**
     * input rekening number on edit deposit page
     * @param rekening
     */
    public void inputRekeningOnEditDepositPage(String rekening) {
        page.getByRole(AriaRole.SPINBUTTON).click();
        page.keyboard().type(rekening);
    }

    /**
     * input rekening name on edit deposit page
     * @param rekeningName
     */
    public void inputRekeningNameOnEditDepositPage(String rekeningName) {
        page.getByRole(AriaRole.DIALOG, new Page.GetByRoleOptions().setName("Edit Deposit for Confirm to Finance")).locator("input[name='destination_name']").click();
        page.keyboard().type(rekeningName);
    }

    /**
     * input transfer date on edit deposit page
     * @param date
     */
    public void inputTransferDateOnEditDepositPage(String date) {
        page.getByRole(AriaRole.DIALOG, new Page.GetByRoleOptions().setName("Edit Deposit for Confirm to Finance")).locator("input[name='transfer_due_date']").click();
        page.keyboard().type(date);
    }

    /**
     * click on simpan draft on edit deposit page
     */
    public void simpanDraftEditDeposit() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Simpan Draf")).click();
    }

    /**
     * Click on extend contract btn
     */
    public void clickOnExtendContractButton() {
        extendContractBtn.click();
    }

    /**
     * check if sisa deposit button is disable
     *
     * @return boolean
     */
    public boolean isSisaDepositBtnDisable() {
        if (playwright.isButtonEnable(konfirmasiSisaDepoBtn)){
            return konfirmasiSisaDepoBtn.isEnabled();
         }
        return konfirmasiSisaDepoBtn.isDisabled();
    }

    /**
     * Select Filter Search By
     *
     * @param filterText
     * @throws InterruptedException
     */
    public void selectFilterSearchBy(String filterText) throws InterruptedException {
        playwright.clickOn(page.locator("select[name=search_by]"));
        page.keyboard().type(filterText);
        page.keyboard().down("Enter");
    }

    /**
     * Enter Search Text in to Search box
     *
     * @param searchText search text
     * @throws InterruptedException
     */
    public void enterTextToSearchTextbox(String searchText) throws InterruptedException {
        playwright.clickOn(page.locator("input[name=search_value]"));
        page.keyboard().type(searchText);

    }

    /**
     * Click on batalkan kontrak on admin pay if kontrak is exist
     */
    public void batalkanContractIfExist() {
        if (page.getByText("Batalkan Kontrak").first().isVisible()) {
            page.onDialog(dialog -> dialog.accept());
            page.getByText("Batalkan Kontrak").first().click();
        }
    }

    /**
     * Chect the visibility of akhiri contract button
     * @return visible true otherwise false
     */
    public boolean isAkhiriContractButtonVisible() {
        page.waitForLoadState(LoadState.LOAD);
        return akhiriContractButton.first().isVisible();
    }

    /**
     * Get akhiri contract button size
     * @return int data type
     */
    public int getAkhiriContractButtonSize() {
        return playwright.getLocators(akhiriContractButton).size();
    }

    /**
     * click on invoice on contract first index
     *
     * @param index 1,2,3,4,5 etc
     */
    public void clicksOnInvoiceNumberOnFirstIndex(String index) {
        invoiceEl = page.locator("(//tr[1]/following::ul/li/a[contains(text(), 'Pembayaran')])[" + index + "]");
        playwright.clickOn(invoiceEl);
        detailInvoiceEl = page.locator("//td[1]/a");
        playwright.clickOn(detailInvoiceEl);
    }

    /**
     * check table header is visible or not
     * @param headerName refer to table header name
     */
    public void isTableHeaderVisible(String headerName) {
        tableHeader = page.locator("//th[text()='" + headerName + "']");
        assertThat(tableHeader).isVisible();
    }
}
