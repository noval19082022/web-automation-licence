package pageobject.admin.mamipay.voucher;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

import java.util.List;

public class MamikosVoucherFormPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private LocatorHelpers locator;
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
    public MamikosVoucherFormPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.locator = new LocatorHelpers(page);
        applyKostContent = ".select2-selection__choice";
        applyKost = page.locator(applyKostContent);
        kostNameApplied = page.getByRole(AriaRole.LISTITEM).getByText("×");
        kostNameInput = page.getByPlaceholder("Search Kost by name...");
        editMassVoucherButton = playwright.locatorByRoleSetName(locator.roleButton, "Edit Mass Voucher");
        yesDoItButton = playwright.locatorByRoleSetName(locator.roleButton, "Yes, Do It!");
        professionOption = page.locator("select[name='applicable_group[profession]']");
        inputMinimumPrice = page.locator("input[name='voucher_min_amount']");
        targetEmailNotApplicableInput = page.locator("(//textarea[@class='form-control input-email'])[2]");
        targeEmailApplyInput = page.locator("(//textarea[@class='form-control input-email'])[1]");
        startDateInput = page.getByLabel("Start Date*");
        endDateInput = page.getByLabel("End Date");
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
}
