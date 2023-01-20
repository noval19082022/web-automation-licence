package pageobject.admin.mamipay.voucher;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class MamikosListMassVoucherPO {
    private Page page;
    private PlaywrightHelpers playwright;
    Locator singleVoucherButton;
    Locator campaignNameInput;
    Locator searchButton;
    Locator editButton;
    Locator callout;
    public MamikosListMassVoucherPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        singleVoucherButton = page.locator("//*[.='Single Voucher']");
        campaignNameInput = page.locator("input[name=\"campaign_voucher\"]");
        searchButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search"));
        editButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(""));
        callout = page.locator(".callout");
    }

    /**
     * Fill campaign voucher name, or id
     * @param voucher campaign name, voucher name, or id String data type
     */
    public void fillCampaignVoucher(String voucher) {
        playwright.forceFill(campaignNameInput, voucher);
    }

    /**
     * Click on search button
     */
    public void clickOnSearchButton() {
        playwright.clickOn(searchButton);
    }

    /**
     * Click on edit button
     * @return MamikosVoucherFormPO class
     */
    public MamikosVoucherFormPO clickOnEditButton() {
        playwright.clickOn(editButton);
        return new MamikosVoucherFormPO(page);
    }

    /**
     * Click on single voucher tab
     * @return MamikosSingleVoucherPO inner class of this class
     */
    public MamikosSingleVoucherPO clickSingleVoucher() {
        playwright.clickOn(singleVoucherButton);
        return new MamikosListMassVoucherPO(page).new MamikosSingleVoucherPO(page);
    }

    /**
     * Get callout text
     * @return String data type of current callout
     */
    public String getCalloutText() {
        return callout.innerText().trim();
    }

    /**
     * In case there are different between mass voucher and single voucher
     * fill single voucher method and variable inside this inner class.
     */
    public class MamikosSingleVoucherPO {
        private Page page;
        private PlaywrightHelpers playwright;
        public MamikosSingleVoucherPO(Page page) {
            this.page = page;
            this.playwright = new PlaywrightHelpers(page);
        }
    }
}
