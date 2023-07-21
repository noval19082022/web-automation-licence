package pageobject.pms;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class sidebarMenuPO {
    private Page page;

    Locator hompageButton;
    Locator disbursementButton;
    Locator roleManagementButton;
    Locator tenantCommunicationButton;
    Locator survetTrackerButton;
    Locator otherTransactionButton;

    public sidebarMenuPO(Page page){
        this.page = page;
        hompageButton = page.getByTestId("homepageSidebarMenu");
        disbursementButton = page.getByTestId("disbursementSidebarMenu");
        otherTransactionButton = page.getByTestId("otherTransactionSidebarMenu");
        roleManagementButton = page.getByTestId("roleManagementSidebarMenu");
        tenantCommunicationButton = page.getByTestId("tenantCommunicationSidebarMenu");
        survetTrackerButton = page.getByTestId("surveyTrackerSidebarMenu");
    }

    /**
     * click Homepage Sidebar Menu
     */
    public void clickHomepageMenu(){
        hompageButton.click();
    }

    /**
     * click Disbursement Sidebar Menu
     */
    public void clickDisbursementMenu(){
        disbursementButton.click();
    }

    /**
     * click Role Management Sidebar Menu
     */
    public void clickRoleManagementMenu(){
        roleManagementButton.click();
    }

    /**
     * click Other Transaction Sidebar Menu
     */
    public void clickOtherTransactionMenu() {
        otherTransactionButton.waitFor();
        otherTransactionButton.click();
    }

    /**
     * click Tenant Communication Menu
     */
    public void clickTenantCommunicationMenu() {
        tenantCommunicationButton.waitFor();
        tenantCommunicationButton.click();
    }

    /**
     * click Survey Tracker Menu
     */
    public void clickSurveyTrackerMenu() {
        survetTrackerButton.waitFor();
        survetTrackerButton.click();
    }
}
