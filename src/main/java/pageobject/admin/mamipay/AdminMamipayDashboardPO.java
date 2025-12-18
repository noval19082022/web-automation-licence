package pageobject.admin.mamipay;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import pageobject.admin.mamipay.contract.SearchContractPO;
import pageobject.admin.mamipay.invoice.MamikosListInvoicePO;
import pageobject.admin.mamipay.voucher.MamikosListMassVoucherPO;
import utilities.PlaywrightHelpers;

public class AdminMamipayDashboardPO {
    private Page page;
    private PlaywrightHelpers playwright;
    Locator inputBiayaKerusakanOnPopUp;
    Locator sisaDepositTextOnPopUp;
    Locator searchContract;
    Locator voucherDiscount;
    Locator mamikosVoucher;
    Locator searchInvoice;
    Locator sidebarMenu;
    Locator filterStatusDropdown;
    Locator filterRuleDropdown;
    Locator filterTeamDropdown;
    Locator partnerVoucher;
    Locator searchButton;
    Locator phoneOwnerTextbox;
    Locator deleteMamipayButton;

    Locator inputPhoneNumberRecurring;
    Locator optionGpRecurring;
    Locator createRecurringBtn;
    Locator addFeeButton;

    public AdminMamipayDashboardPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        inputBiayaKerusakanOnPopUp = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Rp"));
        sisaDepositTextOnPopUp = page.getByRole(AriaRole.DIALOG, new Page.GetByRoleOptions().setName("Edit Deposit for Confirm to Finance")).getByText("Sisa Deposit", new Locator.GetByTextOptions().setExact(true));
        searchContract = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Search Contract"));
        voucherDiscount = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Voucher Discount "));
        mamikosVoucher = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Mamikos Voucher"));
        partnerVoucher = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Partner Voucher"));
        searchInvoice = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Search Invoice"));
        filterStatusDropdown = page.locator("div:nth-child(7) > span > .selection > .select2-selection > .select2-selection__arrow");
        filterRuleDropdown = page.locator(".select2-selection__arrow").first();
        filterTeamDropdown = page.locator("div:nth-child(5) > span > .selection > .select2-selection > .select2-selection__arrow");
        searchButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search"));
        phoneOwnerTextbox = page.locator("//input[@name='search_value']");
        deleteMamipayButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(""));

        inputPhoneNumberRecurring = page.locator("form").filter(new Locator.FilterOptions().setHasText("Create Recurring")).getByPlaceholder("Phone Number");
        optionGpRecurring = page.getByRole(AriaRole.COMBOBOX);
        createRecurringBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create Recurring"));
        addFeeButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add Fee"));
    }

    /**
     * this method will click the hyperlink text on admin dashboard
     *
     * @param text
     */
    public void clickOnTextHyperlink(String text) {
        page.getByText(text).first().click();
    }

    /**
     * this method will check if admin get pop up
     *
     * @param popUp
     * @return boolean
     */
    public Boolean getPopUpText(String popUp) {
        Locator textLocator = page.getByText(popUp).first();
        return playwright.waitTillLocatorIsVisible(textLocator, 5000.0);
    }
    
    /**
     * Get all visible text messages for debugging
     * This helps identify what messages are actually shown
     * 
     * @return String containing all visible alert/notification messages
     */
    public String getAllVisibleMessages() {
        StringBuilder messages = new StringBuilder();
        
        // Check common notification selectors
        String[] selectors = {".alert", ".notification", ".toast", ".message", 
                            ".modal-body", "[role='alert']", ".swal2-container"};
        
        for (String selector : selectors) {
            Locator elements = page.locator(selector);
            if (elements.count() > 0) {
                for (int i = 0; i < elements.count(); i++) {
                    String text = playwright.getLocatorTextContent(elements.nth(i));
                    if (text != null && !text.trim().isEmpty()) {
                        messages.append("Found in ").append(selector).append(": ").append(text.trim()).append("\n");
                    }
                }
            }
        }
        
        return messages.toString();
    }

    /**
     * Input Biaya kerusakan on edit deposit menu
     *
     * @param biaya
     */
    public void inputBiayaKerusakanOnEditDposit(String biaya) {
        inputBiayaKerusakanOnPopUp.click();
        page.keyboard().type(biaya);
    }

    /**
     * additonal notes menu on detail pop up after click Edit Deposit btn
     *
     * @return
     */
    public Boolean getAdditionalNotesMenuOnDetailPopup() {
        return page.getByText("Additional Notes Minus").first().isVisible();
    }

    /**
     * Click on search contract
     *
     * @return SearchContractPO class
     */
    public SearchContractPO clickOnSearchContract() {
        playwright.waitTillLocatorIsVisible(searchContract, 30000.0);
        playwright.clickOn(searchContract);
        return new SearchContractPO(page);
    }

    /**
     * Go to mamikos voucher by click on voucher discount and mamikos voucher
     *
     * @return MamikosListMassVoucherPO class after navigate to it
     */
    public MamikosListMassVoucherPO goToMamikosVoucher() {
        playwright.clickOn(voucherDiscount);
        playwright.clickOn(mamikosVoucher);
        return new MamikosListMassVoucherPO(page);
    }

    /**
     * Go to mamikos search Invoice
     *
     * @return MamikosListInvoicePO class
     */
    public MamikosListInvoicePO goToMamikosSearchInvoice() {
        playwright.clickOn(searchInvoice);
        return new MamikosListInvoicePO(page);
    }

    /**
     * Click sidebar menu in mamipay
     *
     * @param menu , menu name
     */
    public void NavigateToMamipayMenu(String menu) {
        sidebarMenu = page.locator("//li[@class='menu-item ']/a[contains(text(),'" + menu + "')]");
        sidebarMenu.click();
    }

    /**
     * admin click on filter status
     */
    public void clickOnFilterStatusDropdown() {
        filterStatusDropdown.click();
    }

    /**
     * admin click on filter rules
     */
    public void clickOnFilterRulesDropdown() {
        filterRuleDropdown.click();
    }

    /**
     * admin click on filter team
     */
    public void clickOnFilterTeamDropdown() {
        playwright.waitFor(filterTeamDropdown);
        playwright.clickOn(filterTeamDropdown);
    }

    /**
     * admin click on dropdown filter status
     */
    public String getAllFilterOptions(String filter) {
        Locator text = page.locator("//li[normalize-space()='" + filter + "']");
        return playwright.getText(text);
    }

    /**
     * admin click on filter
     */
    public void clickOnFilter(String filter) {
        String text = "//li[normalize-space()='" + filter + "']";
        ElementHandle element = page.querySelector(text);
        element.click();
    }

    /**
     * admin click on search button
     */
    public void clickOnSearchButton() {
        playwright.clickOn(searchButton);
    }

    /**
     * admin see result select filter
     */
    public String getResultSelectFilter(String filter) {
        Locator text = page.locator("(//*[.='" + filter + "'])[1]");
        return playwright.getText(text);
    }

    /**
     * admin input voucher
     */
    public void clickOnInputVoucher(String id) {
        String inputTextbox = "//*[@name='campaign_voucher']";
        ElementHandle element = page.querySelector(inputTextbox);
        element.click();
        element.fill(id);
    }

    /**
     * Go to mamikos voucher by click on voucher discount and mamikos voucher
     *
     * @return MamikosListPartnerVoucherPO class after navigate to it
     */
    public MamikosListMassVoucherPO goToPartneroucher() {
        playwright.clickOn(voucherDiscount);
        playwright.clickOn(partnerVoucher);
        return new MamikosListMassVoucherPO(page);
    }

    /**
     * Search phone owner and press Enter
     *
     * @param phoneOwner
     */
    public void searchPhoneOwner(String phoneOwner) {
        playwright.forceFill(phoneOwnerTextbox, phoneOwner);
        playwright.pressKeyboardKey("Enter");
    }

    /**
     * Verify the first delete mamipay button is displayed
     *
     * @return boolean (true, false)
     */
    public boolean isFirstDeleteMamipayDisplayed() {
        return playwright.isLocatorVisibleAfterLoad(deleteMamipayButton, 3000.0);
    }

    /**
     * Click first delete mamipay button
     */
    public void clickOnFirstDeleteMamipay() {
        playwright.clickOn(deleteMamipayButton);
        playwright.acceptDialog(deleteMamipayButton);
    }

    //-------------addFee MVP-------------//

    /**
     * click on Add fee button on detail fee page
     */
    public void clickOnAddFee() {
        playwright.clickOn(addFeeButton);
    }

    /**
     * validate Biaya Tambahan Opsional di Kos
     *
     * @param text
     * @return text
     */
    public Boolean isOptionalAddFeeVisible(String text) {
        Locator optionalAddFee = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("" + text + ""));
        return playwright.waitTillLocatorIsVisible(optionalAddFee, 2000.0);
    }

    /**
     * input owner phone number for recurring gold plus
     *
     * @param day
     * @param phoneNumber
     */
    public void inputRecurringGoldplusPhoneNumber(String day, String phoneNumber) {
        day = day.replaceAll("-", "").replaceAll(" ", "").toLowerCase();
        playwright.clickLocatorAndTypeKeyboard(inputPhoneNumberRecurring, phoneNumber);
        playwright.selectDropdownByValue(optionGpRecurring, day);
        playwright.clickOn(createRecurringBtn);
    }
}