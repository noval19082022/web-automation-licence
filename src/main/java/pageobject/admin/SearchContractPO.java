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
    public SearchContractPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        searchContract = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Search Contract"));
        searchBy = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Search by"));
        searchButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search"));
        searchInput = page.getByPlaceholder("Search");
        batalkanContractButton = page.locator("//*[.='Batalkan Kontrak']");
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
    public void clickOnRevokeContractButton() {
        if (playwright.waitTillLocatorIsVisible(batalkanContractButton, 5000.00)) {
            playwright.acceptDialog(batalkanContractButton);
            page.waitForSelector(".callout.callout-success");
        }
    }
}
