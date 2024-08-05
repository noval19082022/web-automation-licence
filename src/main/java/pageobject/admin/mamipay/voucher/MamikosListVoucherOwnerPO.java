package pageobject.admin.mamipay.voucher;

import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

import java.nio.file.Paths;
import java.util.UUID;

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
    Locator tooltipVoucherHistory;
    Locator headerUpdateVoucher;
    Locator headerCampaign;
    Locator btnCanceUpdateOwnerVoucher;
    Locator btnAddSingleVoucher;
    Locator optionProduct;
    Locator campaignNamePlacHolder;
    Locator startDateCampaign;
    Locator endDateCampaign;
    Locator inputPrefixVoucherCodeCampaign;
    Locator inputTotalVoucherCampaign;
    Locator selectDiscountTypeCampaign;
    Locator inputDiscountAmountCampaign;
    Locator uploadOwnerList;
    Locator selectInvoiceType;
    Locator selectOptionDoubleRedeem;
    Locator createBtnSingleListVoucher;


    public MamikosListVoucherOwnerPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);

        voucherDiscount = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Voucher Discount "));
        ownerVoucher = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Owner Voucher"));
        headerVoucherCodeListOwner = page.locator("//h1[.='Voucher Code List']");
        tooltipVoucherHistory = page.locator("//tbody/tr/td[9]/a[1]");
        buttonBackVoucher = page.locator("//a[.='Back to Voucher']");
        tableListVoucher = page.locator("//table[@class='table table-hover']");
        headerUsageVoucherOwner = page.locator("//h1[.='Voucher Usages']");
        containerInfoVocher = page.locator("//div[@class='row clearfix']//div[@class='row']");
        tableUsageVoucher = page.locator("//th[.='Invoice Number']");
        headerUpdateVoucher = page.locator("//h1[.='Edit Single Voucher']");
        headerCampaign = page.locator("//h3[contains(.,'CAMPAIGN')]");
        btnCanceUpdateOwnerVoucher = page.locator("//a[.='Cancel']");
        btnAddSingleVoucher = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add Single Voucher"));
        optionProduct = page.locator("select[name='product_type']");
        campaignNamePlacHolder = page.locator("input[name='campaign[name]']");
        startDateCampaign = page.getByLabel("Start Date");
        endDateCampaign = page.getByLabel("End Date");
        inputPrefixVoucherCodeCampaign = page.locator("input[name='voucher_code_prefix']");
        inputTotalVoucherCampaign = page.locator("input[name='voucher_code_total']");
        selectDiscountTypeCampaign = page.locator("#discount-type");
        inputDiscountAmountCampaign = page.locator("input[name='discount_amount']");
        uploadOwnerList = page.locator("input[name='voucher_targeted_users_file']");
        selectInvoiceType = page.locator("#invoice-type");
        selectOptionDoubleRedeem = page.locator("#mamipoin-redeem-supported");
        createBtnSingleListVoucher = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create Voucher"));
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
     *
     * @throws InterruptedException
     */
    public void clickVoucherListOwner(String index) throws InterruptedException {
        tooltipOwnerList = page.locator("(//i[@class='fa fa-list']/parent::a)[" + index + "]");
        playwright.clickOn(tooltipOwnerList);
    }

    /**
     * Check voucher code list page is appear
     *
     * @return
     */
    public boolean isVocherCodeListDisplayed() {
        return playwright.waitTillLocatorIsVisible(headerVoucherCodeListOwner, 2000.0);

    }

    /**
     * Click back button voucher
     */
    public void clickOnBackButtonVoucher() {
        playwright.clickOn(buttonBackVoucher);
    }

    /**
     * Check table voucher list is appear
     */
    public boolean isTableListVoucherDisplayed() {
        return playwright.waitTillLocatorIsVisible(tableListVoucher, 1000.0);
    }

    /**
     * click Usage list tooltip in Owner Voucher menu
     *
     * @throws InterruptedException
     */
    public void clickUsageListOwner(String index) throws InterruptedException {
        tooltipUsageList = page.locator("(//i[@class='fa fa-eye']/parent::a)[" + index + "]");
        playwright.clickOn(tooltipUsageList);
    }

    /**
     * Check table voucher list is appear
     */
    public boolean isHeaderUsagePageIsDisplayed() {
        return playwright.waitTillLocatorIsVisible(headerUsageVoucherOwner, 1000.0);

    }

    /**
     * Check box of information voucher is appear
     */
    public boolean isVoucherInformationIsDisplayed() {
        return playwright.waitTillLocatorIsVisible(containerInfoVocher, 1000.0);

    }

    /**
     * Check table usgae voucher owner is appear
     */
    public boolean isTableUsageVoucherOwnerIsDisplayed() {
        return playwright.waitTillLocatorIsVisible(tableUsageVoucher, 1000.0);

    }

    /**
     * click Update tooltip in Owner Voucher menu
     *
     * @throws InterruptedException
     */
    public void clickUpdateVoucherOwner(String index) throws InterruptedException {
        tooltipUpdateOwnerVoucher = page.locator("(//i[@class='fa fa-edit']/parent::a)[" + index + "]");
        playwright.clickOn(tooltipUpdateOwnerVoucher);
    }

    /**
     * Check header update voucher owner is appear
     */
    public boolean isHeaderUpdateVoucherOwnerAppear() {
        return playwright.waitTillLocatorIsVisible(headerUpdateVoucher, 1000.0);

    }

    /**
     * Check campaign header voucher owner is appear
     */
    public boolean isCampaignHeaderAppear() {
        return playwright.waitTillLocatorIsVisible(headerCampaign, 1000.0);

    }

    /**
     * Click cancel update button voucher
     */
    public void clickOnCancelButtonOwnerVoucher() {
        playwright.pageScrollUntilElementIsVisible(btnCanceUpdateOwnerVoucher);
        playwright.clickOn(btnCanceUpdateOwnerVoucher);
    }

    /**
     * click voucher history on list
     *
     * @param index
     */
    public void clickHistoryVoucherOwner(String index) {
        var indexInt = Integer.parseInt(index) - 1;
        if (indexInt < 0) {
            indexInt = 0;
        }
        playwright.clickOn(tooltipVoucherHistory.nth(indexInt));
    }

    /**
     * click on add single voucher
     */
    public void clickOnAddSingleVoucher() {
        playwright.clickOn(btnAddSingleVoucher);
    }

    /**
     * select option GP
     */
    public void selectOptionProductGP() {
        playwright.selectDropdownByValue(optionProduct, "goldplus");
    }

    /**
     * input campaign name
     *
     * @param campaignName
     */
    public void inputCampaignName(String campaignName) {
        playwright.clickLocatorAndTypeKeyboard(campaignNamePlacHolder, campaignName);
    }

    /**
     * input start date campaign
     *
     * @param startDate
     */
    public void inputStartDateCampaign(String startDate) {
        var todayDate = JavaHelpers.getCurrentDateOrTime("yyyy/MM/dd HH:mm");
        var tomorrowDate = JavaHelpers.getCostumDateOrTime("yyyy/MM/dd HH:mm", 1, 0, 0);

        var date = startDate.trim().toLowerCase().contains("today") ? todayDate : tomorrowDate;
        playwright.clickLocatorAndTypeKeyboard(startDateCampaign, date);
        playwright.pressKeyboardKey("Enter");
        playwright.clickOn(campaignNamePlacHolder);
    }

    /**
     * input End date campaign
     *
     * @param endDate
     */
    public void inputEndDateCampaign(String endDate) {
        var todayDate = JavaHelpers.getCurrentDateOrTime("yyyy/MM/dd HH:mm");
        var tomorrowDate = JavaHelpers.getCostumDateOrTime("yyyy/MM/dd HH:mm", 1, 0, 0);
        var nextWeek = JavaHelpers.getCostumDateOrTime("yyyy/MM/dd HH:mm", 7, 0, 0);

        var date = endDate.trim().toLowerCase().contains("today") ? todayDate : tomorrowDate;
        date = endDate.trim().toLowerCase().contains("tomorrow") ? tomorrowDate : nextWeek;
        playwright.clickLocatorAndTypeKeyboard(endDateCampaign, date);
        playwright.pressKeyboardKey("Enter");
        playwright.clickOn(campaignNamePlacHolder);
    }

    /**
     * input voucher code on single voucher list
     *
     * @param voucherPrefixCode
     */
    public void inputVoucherPrefix(String voucherPrefixCode) {
        voucherPrefixCode = voucherPrefixCode.toLowerCase().contains("random") ? UUID.randomUUID().toString() : voucherPrefixCode;
        playwright.clickLocatorAndTypeKeyboard(inputPrefixVoucherCodeCampaign, voucherPrefixCode);
    }

    /**
     * input total voucher on single voucher list
     *
     * @param totalVoucher
     */
    public void inputTotalVoucher(String totalVoucher) {
        playwright.clickLocatorAndTypeKeyboard(inputTotalVoucherCampaign, totalVoucher);
    }

    /**
     * input dicsount type on single voucher
     *
     * @param discountType
     */
    public void inputDiscountType(String discountType) {
        playwright.selectDropdownByValue(selectDiscountTypeCampaign, discountType);
    }

    /**
     * input discount amount
     *
     * @param discountAmount
     */
    public void inputDiscountAmount(String discountAmount) {
        playwright.clickLocatorAndTypeKeyboard(inputDiscountAmountCampaign, discountAmount);
    }

    /**
     * upload discount owner list
     *
     * @param ownersList
     */
    public void uploadOwnerList(String ownersList) {
        var invalidPath = "src/main/resources/file/owner-list/ownerListInvalid.csv";
        var validaPath = "";

        var path = ownersList.toLowerCase().contains("invalid")? invalidPath : validaPath;
        FileChooser fileChooser = page.waitForFileChooser(() -> uploadOwnerList.click());
        fileChooser.setFiles(Paths.get(path));
        playwright.waitTillLocatorIsVisible(uploadOwnerList);
        playwright.hardWait(3000);
    }

    /**
     * input invoice type campaign
     *
     * @param invoiceType
     */
    public void inputInvoiceType(String invoiceType) {
        playwright.selectDropdownByValue(selectInvoiceType, invoiceType);
    }

    /**
     * checklist doube redem campaign
     *
     * @param doubleRedeemWithMamiPoin
     */
    public void inputDoubleRedeemWithMamiPoin(String doubleRedeemWithMamiPoin) {
        var option = doubleRedeemWithMamiPoin.toLowerCase().contains("yes") ? "1" : "0";
        playwright.selectDropdownByValue(selectOptionDoubleRedeem, option);

    }

    /**
     * clickOn create Btn when create voucher single list
     */
    public void clickOnCreateVoucherBtn() {
        playwright.clickOn(createBtnSingleListVoucher);
    }
}
