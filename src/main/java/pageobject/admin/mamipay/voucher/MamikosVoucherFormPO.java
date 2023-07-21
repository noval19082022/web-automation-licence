package pageobject.admin.mamipay.voucher;

import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import utilities.JavaHelpers;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

import java.nio.file.Paths;
import java.text.ParseException;
import java.util.List;

public class MamikosVoucherFormPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private LocatorHelpers locator;
    private JavaHelpers java = new JavaHelpers();
    String applyKostContent;
    Locator applyKost;
    Locator kostNameApplied;
    Locator kostNameInput;
    String kostName;
    Locator editMassVoucherButton;
    Locator yesDoItButton;
    Locator professionOption;
    Locator inputMinimumPrice;
    Locator targetEmailNotApplicableInput;
    Locator targeEmailApplyInput;
    Locator startDateInput;
    Locator endDateInput;
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
    Locator timeDateInput;
    Locator paymentRulesEl;
    Locator submitMassButton;
    Locator voucherStatusEl;
    Locator submitEditMassButton;
    Locator confirmationEditButton;
    Locator uploadCampignImage;
    Locator imageCampaignUploaded;
    Locator campaignTnCInput;
    Locator campaignTitleInput;
    Locator updateMassVoucherButton;
    Locator activeCheckbox;
    Locator alertMessageDisplayed;

    public MamikosVoucherFormPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.locator = new LocatorHelpers(page);
        applyKostContent = ".select2-selection__choice";
        applyKost = page.locator(applyKostContent);
        kostNameApplied = page.getByRole(AriaRole.LISTITEM).getByText("×");
        kostNameInput = page.getByPlaceholder("Search Kost by name...");
        editMassVoucherButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Edit Mass Voucher"));
        yesDoItButton = playwright.locatorByRoleSetName(locator.roleButton, "Yes, Do It!");
        professionOption = page.locator("select[name='applicable_group[profession]']");
        inputMinimumPrice = page.locator("input[name='voucher_min_amount']");
        targetEmailNotApplicableInput = page.locator("(//textarea[@class='form-control input-email'])[2]");
        targeEmailApplyInput = page.locator("(//textarea[@class='form-control input-email'])[1]");
        startDateInput = page.getByLabel("Start Date*");
        endDateInput = page.getByLabel("End Date");
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
        timeDateInput = page.locator ("//body[@class='skin-green sidebar-mini']/div[5]//div[@class='xdsoft_time xdsoft_current']");
        submitMassButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add Mass Voucher"));
        totalQuotaInput = page.locator("#total_limit");
        submitEditMassButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Edit Mass Voucher"));
        confirmationEditButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Yes, Do It!"));
        uploadCampignImage = page.locator("\"#inputCampaignImage\"");
        imageCampaignUploaded = page.locator("#campaignImage");
        campaignTnCInput = page.locator(".note-editable");
        campaignTitleInput = page.locator("input[name=\"public_campaign\\[title\\]\"]");
        updateMassVoucherButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(""));
        activeCheckbox = page.locator("//b[normalize-space()='Active']//preceding-sibling::input");
        alertMessageDisplayed = page.getByText("Voucher AUTOVINVALID updated");
    }

    /**
     * Get inner text off apply kost name
     * @return Kost name String List
     */
    public List<String> getAllApplyKostNameInnerText() {
        page.waitForLoadState(LoadState.LOAD);
        return applyKost.allInnerTexts();
    }

    /**
     * Remove all kost name
     * @throws InterruptedException
     */
    public void removeKostName() throws InterruptedException {
        var initialKostNameSize = getAllApplyKostNameInnerText().size();
        for (int i = 0; i < initialKostNameSize; i++) {
            if (getAllApplyKostNameInnerText().size() > 1)
                playwright.clickOn(kostNameApplied.first());
            else{
                playwright.clickOn(kostNameApplied);
            }
        }
    }

    /**
     * fill kost name
     * @param index 0 for apply 1 for not apply
     * @param kostName Kost Name String type
     */
    public void fillKostName(int index, String kostName) {
        this.kostName = kostName;
        kostNameInput.nth(index).fill(kostName);
        playwright.locatorByRoleSetName(locator.roleOption,this.kostName).click();
    }

    /**
     * Apply change immediately after edit mass voucher data
     * @return MamikostListMassVoucherPO class
     */
    public MamikosListMassVoucherPO doneEditMassVoucher() {
        playwright.clickOn(editMassVoucherButton);
        playwright.clickOn(yesDoItButton);
        return new MamikosListMassVoucherPO(page);
    }

    /**
     * Check on rules
     * @param rules voucher rules
     */
    public void checkOnRules(String rules) {
        Locator ruleLoc = page.getByLabel(rules);
        ruleLoc.check();
    }

    /**
     * Uncheck on rules
     * @param rules voucher rules
     */
    public void unCheckOnRules(String rules) {
        Locator ruleLoc = page.getByLabel(rules);
        ruleLoc.uncheck();
    }

    /**
     * Select profession dropdown
     * @param profession String data type mahasiswa or karyawan
     */
    public void selectProfession(String profession) {
        professionOption.selectOption(profession.toLowerCase());
    }

    /**
     * Fill minimum transaction
     * @param minimumTransaction data string type of minimum transaction
     */
    public void fillMinimumTransaction(String minimumTransaction) {
        inputMinimumPrice.fill(minimumTransaction);
    }

    /**
     * Fill not apply for tenant email
     * @param email tenant target email
     */
    public void fillNotApplicableForEmail(String email) {
        targetEmailNotApplicableInput.fill(email);
    }

    /**
     * Fill apply for tenant email
     * @param targetEmail tenant target email
     */
    public void fillApplicableForEmail(String targetEmail) {
        targeEmailApplyInput.fill(targetEmail);
    }

    /**
     * Get tenant email from applicable email for tenant input
     * @return String data type of tenant email
     */
    public String applicableEmailContent() {
        return targeEmailApplyInput.textContent();
    }

    /**
     * Get tenant email from not applicable email for tenant input
     * @return String data type of tenant email
     */
    public String notApplicableForEmailContent() {
        return targetEmailNotApplicableInput.textContent();
    }

    /**
     * Choose start date by click on date chooser
     * @param date String type target date
     */
    public void chooseStartDate(String date) {
        Locator targetDate = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(date)).getByText(date);
        startDateInput.click();
        targetDate.click();
    }

    /**
     * Fill start date directly to start date input form
     * @param date String type target date
     */
    public void fillStartDate(String date) {
        startDateInput.fill(date);
    }

    /**
     * Choose end date by click on date chooser
     * @param date String type target date
     */
    public void chooseEndDate(String date) {
        Locator targetDate = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(date)).getByText(date);
        endDateInput.click();
        targetDate.click();
    }

    /**
     * Fill end date directly to start date input form
     * @param date String type target date
     */
    public void fillEndDate(String date) {
        endDateInput.fill(date);
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
     * Input voucher start date based on current date, tommorrow, or desired date number
     * @param startDate input with tomorrow, today, or dateNumber
     * @throws ParseException
     * @throws InterruptedException
     */
    public void chooseFormStartDate(String startDate) throws ParseException, InterruptedException {
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

    /**
     * Click on edit Mass voucher button
     */
    public void activateMassVoucher() {
        playwright.clickOn(updateMassVoucherButton);
        playwright.waitTillLocatorIsVisible(activeCheckbox);
        playwright.clickOn(activeCheckbox);
        playwright.clickOn(editMassVoucherButton);
        playwright.clickOn(yesDoItButton);
    }
    /**
     * this method will be information activities update voucher
     */
    public Boolean isAlertMessageDisplayed(){
        return playwright.waitTillLocatorIsVisible(alertMessageDisplayed);
    }
}
