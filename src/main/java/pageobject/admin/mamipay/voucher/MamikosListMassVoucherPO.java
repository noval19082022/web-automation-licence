package pageobject.admin.mamipay.voucher;

import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

import java.io.File;
import java.nio.file.Paths;
import java.text.ParseException;

public class MamikosListMassVoucherPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private JavaHelpers java = new JavaHelpers();
    Locator singleVoucherButton;
    Locator campaignNameInput;
    Locator searchButton;
    Locator editButton;
    Locator callout;
    Locator editButtonWithNameId;
    Locator addMassButton;
    Locator updateEl;
    Locator addSingleButton;

    public MamikosListMassVoucherPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        singleVoucherButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Single Voucher"));
        campaignNameInput = page.locator("input[name=\"campaign_voucher\"]");
        searchButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search"));
        editButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(""));
        addMassButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add Mass Voucher"));
        callout = page.locator(".callout");
        addSingleButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add Single Voucher"));
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
     * Click on Add Mass button
     * @return MamikosVoucherFormPO class
     */
    public MamikosVoucherFormPO clickOnCreateButton() {
        playwright.clickOn(addMassButton);
        return new MamikosVoucherFormPO(page);
    }

    /**
     * Click on edit button
     * @return MamikosVoucherFormPO class
     */
    public MamikosVoucherFormPO clickOnEditButton(String voucherId, String voucherName) {
        editButtonWithNameId = playwright.locatorByRoleSetName(AriaRole.ROW, voucherId + " " + voucherName).getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName(""));
        playwright.clickOn(editButtonWithNameId);
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

    /**
     * Click on edit button
     * @return MamikosVoucherFormPO class
     */
    public MamikosVoucherFormPO clickOnEditButton() {
        playwright.clickOn(editButton);
        return new MamikosVoucherFormPO(page);
    }

    /**
     * Click on add single button
     */
    public void clickOnAddSingleButton() {
        playwright.clickOn(addSingleButton);
    }

    public void clickOnUpdateIconIndex(String index) throws InterruptedException {
        updateEl = page.locator("(//i[@class='fa fa-pencil']/parent::a)["+index+"]");
        playwright.clickOn(updateEl);
    }



}
