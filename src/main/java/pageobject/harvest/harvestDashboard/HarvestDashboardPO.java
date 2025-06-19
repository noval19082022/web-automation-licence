package pageobject.harvest.harvestDashboard;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.PlaywrightHelpers;

public class HarvestDashboardPO {
    private Page page;
    private PlaywrightHelpers playwright;

    private Locator sidebarMenu;
    private Locator buttonManageLeads;
    private Locator buttonUploadCSV;

    public HarvestDashboardPO(Page page){
        this.page = page;
        playwright = new PlaywrightHelpers(page);
    }

    /**
     * Click Sidebar Menu
     * @param menu menu name
     */
    public void clickSidebarMenu(String menu) {
        sidebarMenu = page.getByText(menu);

        playwright.clickOn(sidebarMenu);
    }

    /**
     * Check if button is visible
     * @param buttonName button name
     * @return boolean
     */
    public boolean isButtonVisible(String buttonName) {
        buttonManageLeads = page.getByText(buttonName);
        buttonUploadCSV = page.getByText(buttonName);
        boolean isVisible = false;

        if(buttonName.equals("Manage Leads")){
            isVisible = playwright.isLocatorVisibleAfterLoad(buttonManageLeads,10000.0);
        }
        else if(buttonName.equals("Upload CSV")){
            isVisible = playwright.isLocatorVisibleAfterLoad(buttonUploadCSV,10000.0);
        }
        return isVisible;
    }
}
