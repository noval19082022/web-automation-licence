package pageobject.admin.mamipay;

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
    Locator searchContract;
    Locator voucherDiscount;
    Locator mamikosVoucher;
    Locator searchInvoice;
    Locator sidebarMenu;
    public AdminMamipayDashboardPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        searchContract = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Search Contract"));
        voucherDiscount = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Voucher Discount "));
        mamikosVoucher = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Mamikos Voucher"));
        searchInvoice = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Search Invoice"));
    }

    /**
     * this method will click the hyperlink text on admin dashboard
     * @param text
     */
    public void clickOnTextHyperlink(String text) {
        page.getByText(text).first().click();
    }

    /**
     * this method will check if admin get pop up
     * @param popUp
     * @return boolean
     */
    public Boolean getPopUpText(String popUp) {
        return page.getByText(popUp).first().isVisible();
    }

    /**
     * Click on search contract
     * @return SearchContractPO class
     */
    public SearchContractPO clickOnSearchContract() {
        searchContract.click();
        return new SearchContractPO(page);
    }

    /**
     * Go to mamikos voucher by click on voucher discount and mamikos voucher
     * @return MamikosListMassVoucherPO class after navigate to it
     */
    public MamikosListMassVoucherPO goToMamikosVoucher() {
        playwright.clickOn(voucherDiscount);
        playwright.clickOn(mamikosVoucher);
        return new MamikosListMassVoucherPO(page);
    }

    /**
     * Go to mamikos search Invoice
     * @return MamikosListInvoicePO class
     */
    public MamikosListInvoicePO goToMamikosSearchInvoice() {
        playwright.clickOn(searchInvoice);
        return new MamikosListInvoicePO(page);
    }

    /**
     * Click sidebar menu in mamipay
     * @param menu , menu name
     */
    public void NavigateToMamipayMenu (String menu){
        sidebarMenu = page.locator("//li[@class='menu-item ']/a[contains(text(),'"+menu+"')]");
        sidebarMenu.click();
    }
}