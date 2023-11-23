package pageobject.admin.mamipay.voucher;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

public class MamikosListVoucherOwnerPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private JavaHelpers java = new JavaHelpers();

    Locator ownerVoucher;
    Locator voucherDiscount;
    Locator tooltipOwnerList;
    Locator headerVoucherCodeListOwner;
    Locator buttonBackVoucher;
    Locator tableListVoucher;
    Locator tooltipUsageList;
    Locator headerUsageVoucherOwner;
    Locator containerInfoVocher;
    Locator tableUsageVoucher;
    Locator tooltipUpdateOwnerVoucher;
    Locator headerUpdateVoucher;
    Locator headerCampaign;
    Locator btnCanceUpdateOwnerVoucher;


    public MamikosListVoucherOwnerPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);

        voucherDiscount = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Voucher Discount "));
        ownerVoucher =page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Owner Voucher"));
        headerVoucherCodeListOwner = page.locator("//h1[.='Voucher Code List']");
        buttonBackVoucher = page.locator("//a[.='Back to Voucher']");
        tableListVoucher = page.locator("//table[@class='table table-hover']");
        headerUsageVoucherOwner = page.locator("//h1[.='Voucher Usages']");
        containerInfoVocher = page.locator("//div[@class='row clearfix']//div[@class='row']");
        tableUsageVoucher = page.locator("//th[.='Invoice Number']");
        headerUpdateVoucher = page.locator("//h1[.='Edit Single Voucher']");
        headerCampaign = page.locator("//h3[contains(.,'CAMPAIGN')]");
        btnCanceUpdateOwnerVoucher = page.locator("//a[.='Cancel']");

    }

    /**
     * Go to owner voucher by click on voucher discount and owner voucher
     *
     * @return MamikosListMassVoucherPO class after navigate to it
     */
    public MamikosListVoucherOwnerPO goToOwnerVoucher() {
        playwright.clickOn(voucherDiscount);
        playwright.clickOn(ownerVoucher);
        return new MamikosListVoucherOwnerPO(page);
    }

    /**
     * click Voucher List tooltip in Owner Voucher menu
     * @throws InterruptedException
     */
    public void clickVoucherListOwner(String index) throws InterruptedException {
            tooltipOwnerList = page.locator("(//i[@class='fa fa-list']/parent::a)["+index+"]");
            playwright.clickOn(tooltipOwnerList);
    }

    /**
     * Check voucher code list page is appear
     *
     * @return
     */
    public boolean isVocherCodeListDisplayed(){
        return playwright.waitTillLocatorIsVisible(headerVoucherCodeListOwner, 2000.0);

    }

    /**
     * Click back button voucher
     *
     */
    public void clickOnBackButtonVoucher(){
       playwright.clickOn(buttonBackVoucher);
    }

    /**
     * Check table voucher list is appear
     *
     */
    public boolean isTableListVoucherDisplayed(){
        return playwright.waitTillLocatorIsVisible(tableListVoucher, 1000.0);
    }

    /**
     * click Usage list tooltip in Owner Voucher menu
     * @throws InterruptedException
     */
    public void clickUsageListOwner(String index) throws InterruptedException {
        tooltipUsageList = page.locator("(//i[@class='fa fa-eye']/parent::a)["+index+"]");
        playwright.clickOn(tooltipUsageList);
    }

    /**
     * Check table voucher list is appear
     *
     */
    public boolean isHeaderUsagePageIsDisplayed(){
        return playwright.waitTillLocatorIsVisible(headerUsageVoucherOwner, 1000.0);

    }

    /**
     * Check box of information voucher is appear
     *
     */
    public boolean isVoucherInformationIsDisplayed(){
        return playwright.waitTillLocatorIsVisible(containerInfoVocher, 1000.0);

    }

    /**
     * Check table usgae voucher owner is appear
     *
     */
    public boolean isTableUsageVoucherOwnerIsDisplayed(){
        return playwright.waitTillLocatorIsVisible(tableUsageVoucher, 1000.0);

    }

    /**
     * click Update tooltip in Owner Voucher menu
     * @throws InterruptedException
     */
    public void clickUpdateVoucherOwner(String index) throws InterruptedException {
       tooltipUpdateOwnerVoucher = page.locator("(//i[@class='fa fa-edit']/parent::a)["+index+"]");
        playwright.clickOn(tooltipUpdateOwnerVoucher);
    }

    /**
     * Check header update voucher owner is appear
     *
     */
    public boolean isHeaderUpdateVoucherOwnerAppear(){
        return playwright.waitTillLocatorIsVisible(headerUpdateVoucher, 1000.0);

    }

    /**
     * Check campaign header voucher owner is appear
     *
     */
    public boolean isCampaignHeaderAppear(){
        return playwright.waitTillLocatorIsVisible(headerCampaign, 1000.0);

    }

    /**
     * Click cancel update button voucher
     *
     */
    public void clickOnCancelButtonOwnerVoucher(){
        playwright.pageScrollUntilElementIsVisible(btnCanceUpdateOwnerVoucher);
        playwright.clickOn(btnCanceUpdateOwnerVoucher);
    }
}
