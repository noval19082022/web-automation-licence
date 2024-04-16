package pageobject.owner;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class MamiprimePO {
    private Page page;
    private PlaywrightHelpers playwright;

    // Landing Page
    Locator lihatRiwayatButton;

    public MamiprimePO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        lihatRiwayatButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lihat Riwayat"));
    }

    /**
     * Check is it lihat riwayat button is visible or not
     * @return boolean, true if visible
     */
    public boolean isLihatRiwayatVisible() {
        return lihatRiwayatButton.isVisible();
    }

    /**
     * Click on Lihat Riwayat Button on landing page
     */
    public void clickOnLihatRiwayat() {
        playwright.clickOn(lihatRiwayatButton);
    }
}
