package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pageobject.common.LoginPO;
import utilities.PlaywrightHelpers;

public class PointManagementPO extends LoginPO {

    Locator inputSearch;

    public PointManagementPO(Page page) {
        super(page);
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        inputSearch = page.getByPlaceholder("Name / Email / Phone");
    }

    /**
     * Search user based on Name / Email / Phone
     *
     * @param user name
     */
    public void searchUserpoinTextBox(String user) {
        inputSearch.fill(user);
    }

    /**
     * Status user as owner
     *
     * @param action whitelist or blacklist
     */
    public Locator statusUser(String action) {
        return page.locator("//td/a[contains(.,'" + action + "')]");
    }

}
