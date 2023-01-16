package pageobject.admin;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class SearchContractPO {
    private Page page;
    private PlaywrightHelpers playwright;
    Locator searchContract;
    Locator searchBy;
    Locator searchInput;
    Locator searchButton;
    Locator batalkanContractButton;
    Locator berhentikanContractButton;
    Locator inputTerminateDate;
    Locator berhentikanContractPopUpButton;
    Locator selectTerminateDate;
    Locator successTerminateText;
    public SearchContractPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        searchContract = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Search Contract"));
        searchBy = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Search by"));
        searchButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search"));
        searchInput = page.getByPlaceholder("Search");
        batalkanContractButton = page.locator("//*[.='Batalkan Kontrak']");
        berhentikanContractButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Akhiri Kontrak"));
        inputTerminateDate = page.getByPlaceholder("Masukkan tanggal checkout");
        berhentikanContractPopUpButton = page.getByRole(AriaRole.DIALOG, new Page.GetByRoleOptions().setName("Akhiri Kontrak Sewa")).getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Akhiri Kontrak"));
        selectTerminateDate = page.locator(".skin-green > div:nth-of-type(2) > .xdsoft_timepicker .xdsoft_current");
        successTerminateText = page.getByText("Kontrak berhasil diakhiri.");

    }

    /**
     * Select dropdown search by it value
     * @param optionValue option value String type
     */
    public void selectSearchBy(String optionValue) {
        searchBy.selectOption(optionValue);
    }

    /**
     * Fill search input value
     * @param search String type e.g (Phone Number Tenant or Phone Number Owner)
     */
    public void fillSearchByValue(String search) {
        searchInput.fill(search);
    }

    /**
     * Click on search button
     */
    public void clickOnSearchButton() {
        searchButton.click();
    }

    /**
     * Set accept dialog and click on revoke/batalkan contract button
     */
    public void clickOnCancelContractButton() {
        if (playwright.waitTillLocatorIsVisible(batalkanContractButton, 5000.00)) {
            playwright.acceptDialog(batalkanContractButton);
            page.waitForSelector(".callout.callout-success");
        }
    }

    /**
     * Set accept dialog and click on terminate contract button
     */
    public void clickOnTerminateContractButton() {
        if (berhentikanContractButton.isVisible()) {
            berhentikanContractButton.click();
            inputTerminateDate.click();
            selectTerminateDate.click();
            berhentikanContractPopUpButton.click();
        }
    }

    /**
     * Wait until terminated is process is finished
     * @return
     */
    public boolean waitUntilSuccessTerminateVisible() {
        return successTerminateText.isVisible();
    }

    /**
     * Get success terminate heading text
     * @return String data type
     */
    public String getSuccessTerminateHeadingText() {
        return playwright.getText(successTerminateText);
    }


}
