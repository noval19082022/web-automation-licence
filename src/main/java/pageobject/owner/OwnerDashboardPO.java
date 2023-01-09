package pageobject.owner;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class OwnerDashboardPO {
    private Page page;
    private Locator ownerProfile;
    public OwnerDashboardPO(Page page) {
        this.page = page;
        this.ownerProfile = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("account Akun"));
    }

    /**
     * Click on owner profile
     */
    public void clickOnOwnerProfile() {
        ownerProfile.click();
    }
}
