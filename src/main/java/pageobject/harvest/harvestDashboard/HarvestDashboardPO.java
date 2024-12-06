package pageobject.harvest.harvestDashboard;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.PlaywrightHelpers;

public class HarvestDashboardPO {
    private Page page;
    private PlaywrightHelpers playwright;

    private Locator sidebarMenu;

    public HarvestDashboardPO(Page page){
        this.page = page;
        playwright = new PlaywrightHelpers(page);
    }

    public void clickSidebarMenu(String menu) {
        sidebarMenu = page.getByText(menu);

        playwright.clickOn(sidebarMenu);
    }
}
