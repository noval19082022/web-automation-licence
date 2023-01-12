package pageobject.admin;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class AdminMamipayDashboardPO {
    private Page page;
    private PlaywrightHelpers playwright;
    Locator searchContract;
    public AdminMamipayDashboardPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        searchContract = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Search Contract"));
    }

    /**
     * Click on search contract
     * @return SearchContractPO class
     */
    public SearchContractPO clickOnSearchContract() {
        searchContract.click();
        return new SearchContractPO(page);
    }
}
