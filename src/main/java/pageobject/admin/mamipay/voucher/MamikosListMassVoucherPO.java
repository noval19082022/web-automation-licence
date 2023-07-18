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
    Locator updateEl;
    Locator callout;
    Locator editButtonWithNameId;
    Locator addMassButton;
    Locator totalKosQuotaInput;
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
    Locator submitMassButton;
    Locator voucherStatusEl;
    Locator submitEditMassButton;
    Locator confirmationEditButton;
    Locator uploadCampignImage;
    Locator imageCampaignUploaded;
    Locator campaignTnCInput;
    Locator campaignTitleInput;
    public MamikosListMassVoucherPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        singleVoucherButton = page.locator("//*[.='Single Voucher']");
        campaignNameInput = page.locator("input[name=\"campaign_voucher\"]");
        searchButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search"));
        editButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(""));
        addMassButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add Mass Voucher"));
        callout = page.locator(".callout");
        totalKosQuotaInput = page.locator("input[name=\"kost_limit\"]");
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
        submitMassButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add Mass Voucher"));
        totalQuotaInput = page.locator("#total_limit");
        submitEditMassButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Edit Mass Voucher"));
        confirmationEditButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Yes, Do It!"));
        uploadCampignImage = page.locator("\"#inputCampaignImage\"");
        imageCampaignUploaded = page.locator("#campaignImage");
        campaignTnCInput = page.locator(".note-editable");
        campaignTitleInput = page.locator("input[name=\"public_campaign\\[title\\]\"]");
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
     * Fill campaign title
     * @param campaignTitle
     */
    public void fillCampaignTitle(String campaignTitle) {
        playwright.forceFill(campaignTitleInput, campaignTitle);
    }

    /**
     * Fill campaign T&C
     * @param campaignTnC
     */
    public void fillCampaignTnC(String campaignTnC) {
        playwright.forceFill(campaignTnCInput, campaignTnC);
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
     * Fill each quota total
     * @param totalKosQuota campaign name, voucher name, or id String data type
     */
    public void fillTotalKosQuota(String totalKosQuota) {
        playwright.forceFill(totalKosQuotaInput, totalKosQuota);
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
     * Click on Submit Add Mass button
     * @return MamikosVoucherFormPO class
     */
    public void clickOnSubmitAddMassVocButton() {
        playwright.clickOn(submitMassButton);
    }

    /**
     * Click on Submit Add Mass button
     * @return MamikosVoucherFormPO class
     */
    public void clickOnEditAddMassVocButton() {
        playwright.clickOn(submitEditMassButton);
        playwright.clickOn(confirmationEditButton);
    }


    /**
     * Click on edit button
     * @return MamikosVoucherFormPO class
     */
    public MamikosVoucherFormPO clickOnEditButton() {
        playwright.clickOn(editButton);
        return new MamikosVoucherFormPO(page);
    }

    public void clickOnUpdateIconIndex(String index) throws InterruptedException {
        updateEl = page.locator("(//i[@class='fa fa-pencil']/parent::a)["+index+"]");
        playwright.clickOn(updateEl);
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
    }

    /**
     * Tick on contract rules based on it value
     * @param value payment rules element value booking_with_dp, booking, pelunasan, tenant
     */
    public void tickOnContractRules(String value) throws InterruptedException {
        paymentRulesEl = page.getByLabel(value);
        paymentRulesEl.check();
    }

    /**
     * Tick on important rules based on it value
     * @param value payment rules element value booking_with_dp, booking, pelunasan, tenant
     */
    public void tickOnImportantRules(String value) throws InterruptedException {
        paymentRulesEl = page.getByLabel(value);
        paymentRulesEl.check();
    }

    /**
     * Untick on important rules based on it value
     * @param value payment rules element value booking_with_dp, booking, pelunasan, tenant
     */
    public void untickOnImportantRules(String value) throws InterruptedException {
        paymentRulesEl = page.getByLabel(value);
        paymentRulesEl.uncheck();
    }

    /**
     * Get voucher status text
     * @param index index from top to bottom start with 1
     * @return strign data type
     */
    public String getVoucherListStatusIndex(String index) {
        voucherStatusEl = page.locator(".box tr:nth-child("+index+") span");
        return playwright.getText(voucherStatusEl);
    }

    /**
     * Upload campaign image
     */
    public void uploadCampaignImage() throws InterruptedException {
        String imagePath = "src/main/resources/images/ownerExpenditure/ABY06593.jpg";
        FileChooser fileChooser = page.waitForFileChooser(() -> page.locator("#inputCampaignImage").click());
        fileChooser.setFiles(Paths.get(imagePath));
        playwright.waitTillLocatorIsVisible(imageCampaignUploaded);
        playwright.hardWait(3000);
    }

    /**
     * Upload csv file for mass voucher
     * @throws InterruptedException
     */
    public void uploadMassVoucherCSVFile() throws InterruptedException {
        String csvPath = "src/main/resources/file/massVoucherFile.csv";
        FileChooser fileChooser = page.waitForFileChooser(() -> page.locator("input[name=\"applicable_group\\[email_csv\\]\"]").click());
        fileChooser.setFiles(Paths.get(csvPath));
        playwright.hardWait(1000);
    }

}
