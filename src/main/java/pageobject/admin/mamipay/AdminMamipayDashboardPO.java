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
        return page.getByText(popUp).first().isVisible();
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
     *
     */
    public void clickOnFilterStatusDropdown() {
        filterStatusDropdown.click();
    }

    /**
     * admin click on filter rules
     *
     */
    public void clickOnFilterRulesDropdown() {
        filterRuleDropdown.click();
    }

    /**
     * admin click on filter team
     *
     */
    public void clickOnFilterTeamDropdown() {
        filterTeamDropdown.click();
    }

    /**
     * admin click on dropdown filter status
     *
     */
    public String getAllFilterOptions(String filter) {
        Locator text = page.locator("//li[normalize-space()='"+filter+"']");
        return playwright.getText(text);
    }
    /**
     * admin click on filter
     *
     */
    public void clickOnFilter(String filter) {
        String text = "//li[normalize-space()='"+filter+"']";
        ElementHandle element = page.querySelector(text);
        element.click();
    }

    /**
     * admin click on search button
     *
     */
    public void clickOnSearchButton() {
       playwright.clickOn(searchButton);
    }

    /**
     * admin see result select filter
     *
     */
    public String getResultSelectFilter(String filter) {
        Locator text = page.locator("(//*[.='"+filter+"'])[1]");
        return playwright.getText(text);
    }

    /**
     * admin input voucher
     *
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
}