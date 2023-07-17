package pageobject.admin.mamipay.voucher;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

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
    Locator totalQuotaInput;
    Locator monthlyQuotaInput;
    Locator discountAmountInput;
    Locator maximumAmountInput;
    Locator minimumTransactionInput;
    Locator selectTypeButton;
    Locator campaignTeamButton;
    Locator voucherCodeInput;
    Locator dailyQuotaInput;
    Locator voucherNameInput;
    Locator startDateEditText;
    Locator endDateEditText;
    Locator startDateInput;
    Locator timeDateInput;
    Locator endDateInput;
    Locator paymentRulesEl;
    public MamikosListMassVoucherPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        singleVoucherButton = page.locator("//*[.='Single Voucher']");
        campaignNameInput = page.locator("input[name=\"campaign_voucher\"]");
        searchButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search"));
        editButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(""));
        addMassButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add Mass Voucher"));
        callout = page.locator(".callout");
        totalQuotaInput = page.locator("input[name=\"kost_limit\"]");
        monthlyQuotaInput = page.locator("input[name=\"kost_limit_monthly\"]");
        discountAmountInput = page.locator("input[name=\"voucher_amount\"]");
        maximumAmountInput = page.locator("input[name=\"voucher_max_amount\"]");
        minimumTransactionInput = page.locator("input[name=\"voucher_min_amount\"]");
        selectTypeButton = page.locator("#field_voucher_type");
        campaignTeamButton = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Campaign Team*"));
        voucherCodeInput = page.getByPlaceholder("e.g: AKUCODE899");
        dailyQuotaInput = page.locator("#daily_limit");
        voucherNameInput = page.getByLabel("Campaign Name*");
        startDateEditText = page.locator("start-date");
        endDateEditText = page.locator("end-date");
        startDateInput = page.getByLabel("Start Date*");
        timeDateInput = page.locator ("//body[@class='skin-green sidebar-mini']/div[5]//div[@class='xdsoft_time xdsoft_current']");
        endDateInput = page.getByLabel("End Date");
    }

    /**
     * Click on voucher campaign team
     */
    public void selectOncampaignTeam(String team) {
        campaignTeamButton.selectOption(team);
    }

    /**
     * Click on voucher type
     */
    public void selectOnVocTypeButton(String voucherType) {
        selectTypeButton.selectOption(voucherType);
    }

    /**
     * Fill voucher name
     * @param voucherName
     */
    public void fillVocName(String voucherName) {
        playwright.forceFill(voucherNameInput, voucherName);
    }

    /**
     * Fill voucher code
     * @param voucherCode
     */
    public void fillVocCode(String voucherCode) {
        playwright.forceFill(voucherCodeInput, voucherCode);
    }

    /**
     * Fill minimum transaction
     * @param minTransaction campaign name, voucher name, or id String data type
     */
    public void fillMinTransaction(String minTransaction) {
        playwright.forceFill(minimumTransactionInput, minTransaction);
    }

    /**
     * Fill maximum discount
     * @param maxDiscount campaign name, voucher name, or id String data type
     */
    public void fillMaxDiscountAmount(String maxDiscount) {
        playwright.forceFill(maximumAmountInput, maxDiscount);
    }


    /**
     * Fill discount amount
     * @param discountAmount campaign name, voucher name, or id String data type
     */
    public void fillDiscountAmount(String discountAmount) {
        playwright.forceFill(discountAmountInput, discountAmount);
    }


    /**
     * Fill each quota monthly
     * @param monthlyQuota campaign name, voucher name, or id String data type
     */
    public void fillMonthlyQuota(String monthlyQuota) {
        playwright.forceFill(monthlyQuotaInput, monthlyQuota);
    }

    /**
     * Fill each quota daily
     * @param dailyQuota campaign name, voucher name, or id String data type
     */
    public void fillDailyQuota(String dailyQuota) {
        playwright.forceFill(dailyQuotaInput, dailyQuota);
    }


    /**
     * Fill each quota total
     * @param totalQuota campaign name, voucher name, or id String data type
     */
    public void fillTotalQuota(String totalQuota) {
        playwright.forceFill(totalQuotaInput, totalQuota);
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
    public MamikosVoucherFormPO clickOnEditButton() {
        playwright.clickOn(editButton);
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
     * Input voucher start date based on current date, tommorrow, or desired date number
     * @param startDate input with tomorrow, today, or dateNumber
     * @throws ParseException
     * @throws InterruptedException
     */
    public void chooseStartDate(String startDate) throws ParseException, InterruptedException {
        String day;
        if (startDate.equalsIgnoreCase("today")) {
            day = java.updateTime("yyyy MMM dd", java.getTimeStamp("yyy MMM dd"), "d", 0, 0, 0, 0);
        }
        else if (startDate.equalsIgnoreCase("tomorrow")) {
            day = java.updateTime("yyyy MMM dd", java.getTimeStamp("yyy MMM dd"), "d", 1, 0, 0, 0);
        }
        else {
            day = startDate;
        }
        String dateElement = "//body[@class='skin-green sidebar-mini']/div[5]//div[.='"+day+"']";
        String date = java.getTimeStamp("YYYY/MM");

        startDateInput.click();
        page.click("xpath=" + dateElement);
        endDateInput.click();
    }

    /**
     * Tick on payment rules based on it value
     * @param value payment rules element value booking_with_dp, booking, pelunasan, tenant
     */
    public void tickOnPaymentRules(String value) throws InterruptedException {
        paymentRulesEl = page.getByLabel(value);
        paymentRulesEl.check();
//        String paymentRulesEl = ".form-group-payment-rules input[value='"+value+"']";
//        selenium.clickOn(By.cssSelector(paymentRulesEl));
//        selenium.hardWait(1);
    }

}
