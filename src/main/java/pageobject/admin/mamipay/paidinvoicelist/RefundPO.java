package pageobject.admin.mamipay.paidinvoicelist;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.*;

public class RefundPO {
    private Page page;
    private Locator refundBtn;
    private Locator selectBank;

    public RefundPO(Page page) {
        this.page = page;
        this.refundBtn = page.getByRole(AriaRole.BUTTON).getByText("Refund").first();
        this.selectBank = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Mandiri")).locator("span").nth(1);
    }

    /**
     * admin click refund btn for the first invoice list
     */
    public void clickOnRefundBtn() {
        refundBtn.click();
    }

    /**
     * fill bank name on refund detail
     * @param bankName
     */
    public void fillBankName(String bankName) {
        selectBank.click();
        page.locator("input[type='search']").click();
        page.keyboard().type(bankName);
        page.keyboard().press("Enter");
    }
}
