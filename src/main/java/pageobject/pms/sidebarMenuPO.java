package pageobject.pms;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import utilities.PlaywrightHelpers;

public class sidebarMenuPO {
    private Page page;
    PlaywrightHelpers playwright;

    Locator hompageButton;
    Locator disbursementButton;
    Locator roleManagementButton;
    Locator tenantCommunicationButton;
    Locator survetTrackerButton;
    Locator otherTransactionButton;
    Locator additionalFeeManagementButton;

    public sidebarMenuPO(Page page){
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        hompageButton = page.getByTestId("homepageSidebarMenu");
        disbursementButton = page.getByTestId("disbursementSidebarMenu");
        otherTransactionButton = page.getByTestId("otherTransactionSidebarMenu");
        roleManagementButton = page.getByTestId("roleManagementSidebarMenu");
        tenantCommunicationButton = page.getByTestId("tenantCommunicationSidebarMenu");
        survetTrackerButton = page.getByTestId("surveyTrackerSidebarMenu");
        additionalFeeManagementButton = page.getByTestId("additionalFeeManagementSidebarMenu");
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
        page.waitForTimeout(1500);
        tenantCommunicationButton.waitFor();
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

    /**
     * Click Additional fee management menu
     */
    public void clickAdditionalFeeManagementMenu() {
        playwright.hardWait(1000.0);
        playwright.waitFor(additionalFeeManagementButton,10000.0);
        playwright.clickOn(additionalFeeManagementButton);
    }
}
