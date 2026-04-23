package pageobject.license;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.PlaywrightHelpers;

public class LicenseDashboardPO {

    private Page page;
    private PlaywrightHelpers playwright;

    Locator dashboardMenu;
    Locator dashboardHeading;
    Locator customersMenu;
    Locator organizationsMenu;
    Locator organizationLevelsMenu;
    Locator subscriberUsersMenu;

    public LicenseDashboardPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        dashboardMenu = page.locator("#sidebarMenu a.sidebar-link:has-text('Dashboard')");
        dashboardHeading = page.locator("h2:has-text('License Home')");
        customersMenu = page.locator("#sidebarMenu .sidebar-item > a.sidebar-link:has-text('Customers')");
        organizationsMenu = page.locator("#sidebarMenu a.sidebar-link:has-text('Organizations')");
        organizationLevelsMenu = page.locator("#sidebarMenu a.sidebar-link:has-text('Organization Level')");
        subscriberUsersMenu = page.locator("#sidebarMenu a.sidebar-link:has-text('Subscriber Users')");
    }

    /**
     * Click on Dashboard menu
     */
    public void clickDashboardMenu() {
        playwright.waitTillLocatorIsVisible(dashboardMenu, 30000.0);
        playwright.clickOn(dashboardMenu);
        page.waitForLoadState();
    }

    /**
     * Verify dashboard page is displayed
     * @return true if dashboard heading is visible
     */
    public boolean isDashboardDisplayed() {
        return playwright.waitTillLocatorIsVisible(dashboardHeading, 30000.0);
    }

    /**
     * Click on Customers menu in sidebar to expand sub-items
     */
    public void clickCustomersMenu() {
        playwright.waitTillLocatorIsVisible(customersMenu, 30000.0);
        playwright.clickOn(customersMenu);
    }

    /**
     * Click on Organizations sub-menu under Customers
     */
    public void clickOrganizationsMenu() {
        playwright.waitTillLocatorIsVisible(organizationsMenu, 30000.0);
        playwright.clickOn(organizationsMenu);
        page.waitForLoadState();
    }

    /**
     * Click on Organization Level sub-menu under Customers
     */
    public void clickOrganizationLevelsMenu() {
        playwright.waitTillLocatorIsVisible(organizationLevelsMenu, 30000.0);
        playwright.clickOn(organizationLevelsMenu);
        page.waitForLoadState();
    }

    /**
     * Click on Subscriber Users sub-menu under Customers
     */
    public void clickSubscriberUsersMenu() {
        playwright.waitTillLocatorIsVisible(subscriberUsersMenu, 30000.0);
        playwright.clickOn(subscriberUsersMenu);
        page.waitForLoadState();
    }
}
