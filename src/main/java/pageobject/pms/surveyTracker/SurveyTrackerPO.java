package pageobject.pms.surveyTracker;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class SurveyTrackerPO {
    private Page page;
    private PlaywrightHelpers playwright;
    Locator penyewaFilterButton;
    Locator pilihPlatformFilter;
    Locator pilihPlatformValue;
    Locator pilihStatusPlatformFilter;
    Locator pilihStatusPlatformValue;

    public SurveyTrackerPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        penyewaFilterButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("filter Filter"));
        pilihPlatformFilter = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih platform survei dropdown-down"));
        pilihStatusPlatformFilter = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih status survei dropdown-down"));
    }

    /**
     * click Filter Penyewa
     */
    public void clickFilterPenyewa() {
        playwright.clickOn(penyewaFilterButton);
    }

    /**
     * Select Filter Tahapan
     */
    public void selectFilterTahapan(String filterPlatform) {
        playwright.clickOn(pilihPlatformFilter);
        pilihPlatformValue = page.locator("a").filter(new Locator.FilterOptions().setHasText(filterPlatform));
        playwright.clickOn(pilihPlatformValue);
    }

    /**
     * Select Filter Status
     */
    public void selectFilterStatus(String filterStatus) {
        playwright.clickOn(pilihStatusPlatformFilter);
        pilihStatusPlatformValue = page.locator("a").filter(new Locator.FilterOptions().setHasText(filterStatus));
        playwright.clickOn(pilihStatusPlatformValue);
    }
}
