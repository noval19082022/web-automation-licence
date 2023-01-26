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
}
