package pageobject.lct;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.PlaywrightHelpers;

public class homepageLctPO {
    private Page page;
    private PlaywrightHelpers playwright;

    private Locator userRoleText;

    public homepageLctPO(Page page){
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);

        userRoleText = page.locator("p.bg-c-text--label-4");
    }

    /**
     * Get User Role
     * @return String
     */
    public String getUserRole() {
        return playwright.getText(userRoleText);
    }

    /**
     * Get LCT URL
     * @return String
     */
    public String getLctUrl() {
        return page.url();
    }
}
