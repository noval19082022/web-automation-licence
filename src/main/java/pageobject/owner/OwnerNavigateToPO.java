package pageobject.owner;

import com.microsoft.playwright.Page;
import data.mamikos.Mamikos;
import utilities.PlaywrightHelpers;
import com.microsoft.playwright.options.LoadState;
public class OwnerNavigateToPO {
    private Page page;
    private PlaywrightHelpers playwright;
    public OwnerNavigateToPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
    }

    /**
     * Navigates to Mamiads History page
     */
    public void navigateToMamiadsHistory() {
        playwright.navigateTo(Mamikos.OWNER_URL + Mamikos.MAMIADS_HISTORY, 30000.0, LoadState.LOAD);
    }

    /**
     * Navigates to Mamiads History page
     */
    public void navigateToMamiads() {
        playwright.navigateTo(Mamikos.OWNER_URL + Mamikos.MAMIADS, 30000.0, LoadState.LOAD);
    }
}
