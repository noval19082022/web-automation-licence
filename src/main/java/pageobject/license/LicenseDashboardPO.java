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
    Locator subscriberUserOrgMenu;
    Locator marketingMenu;
    Locator mappingAkunMenu;
    Locator billingMenu;
    Locator plansMenu;
    Locator priceListMenu;
    Locator subscriptionsMenu;
    Locator subscriptionModulesMenu;

    public LicenseDashboardPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        dashboardMenu = page.locator("#sidebarMenu a.sidebar-link:has-text('Dashboard')");
        dashboardHeading = page.locator("h2:has-text('License Home')");
        customersMenu = page.locator("#sidebarMenu .sidebar-item > a.sidebar-link:has-text('Customers')");
        organizationsMenu = page.locator("#sidebarMenu a.sidebar-link:has-text('Organizations')");
        organizationLevelsMenu = page.locator("#sidebarMenu a.sidebar-link:has-text('Organization Level')");
        subscriberUsersMenu = page.locator("#sidebarMenu a.sidebar-link:has-text('Subscriber Users')");
        subscriberUserOrgMenu = page.locator("#sidebarMenu a.sidebar-link:has-text('Subscriber User Org')");
        marketingMenu = page.locator("#sidebarMenu a.sidebar-link:has-text('Marketing')");
        mappingAkunMenu = page.locator("#sidebarMenu a.sidebar-link:has-text('Mapping Akun')");
        billingMenu = page.locator("#sidebarMenu .sidebar-item > a.sidebar-link:has-text('Billing')");
        plansMenu = page.locator("#sidebarMenu a.sidebar-link:has-text('Plans')");
        priceListMenu = page.locator("#sidebarMenu a.sidebar-link:has-text('Price Lists')");
        subscriptionsMenu = page.locator("#sidebarMenu a.sidebar-link:has-text('Subscriptions')");
        subscriptionModulesMenu = page.locator("#sidebarMenu a.sidebar-link:has-text('Subscription Modules')");
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

    /**
     * Click on Subscriber User Org sub-menu under Customers
     */
    public void clickSubscriberUserOrgMenu() {
        playwright.waitTillLocatorIsVisible(subscriberUserOrgMenu, 30000.0);
        playwright.clickOn(subscriberUserOrgMenu);
        page.waitForLoadState();
    }

    /**
     * Click on Marketing sub-menu under Customers
     */
    public void clickMarketingMenu() {
        playwright.waitTillLocatorIsVisible(marketingMenu, 30000.0);
        playwright.clickOn(marketingMenu);
        page.waitForLoadState();
    }

    /**
     * Click on Mapping Akun sub-menu under Customers
     * (navigates to /license/marketing-account-mappings)
     */
    public void clickMappingAkunMenu() {
        playwright.waitTillLocatorIsVisible(mappingAkunMenu, 30000.0);
        playwright.clickOn(mappingAkunMenu);
        page.waitForLoadState();
    }

    /**
     * Click on Billing menu in sidebar to expand its sub-items.
     * Billing is a parent group (href javascript:void(0)) — clicking only toggles the section.
     */
    public void clickBillingMenu() {
        playwright.waitTillLocatorIsVisible(billingMenu, 30000.0);
        playwright.clickOn(billingMenu);
    }

    /**
     * Click on Plans sub-menu under Billing (navigates to /license/plans).
     */
    public void clickPlansMenu() {
        playwright.waitTillLocatorIsVisible(plansMenu, 30000.0);
        playwright.clickOn(plansMenu);
        page.waitForLoadState();
    }

    /**
     * Click on Price Lists sub-menu under Billing (navigates to /license/price-lists).
     */
    public void clickPriceListMenu() {
        playwright.waitTillLocatorIsVisible(priceListMenu, 30000.0);
        playwright.clickOn(priceListMenu);
        page.waitForLoadState();
    }

    /**
     * Click on Subscriptions sub-menu under Billing (navigates to /license/subscriptions).
     */
    public void clickSubscriptionsMenu() {
        playwright.waitTillLocatorIsVisible(subscriptionsMenu, 30000.0);
        playwright.clickOn(subscriptionsMenu);
        page.waitForLoadState();
    }

    /**
     * Click on Subscription Modules sub-menu under Billing
     * (navigates to /license/subscription-modules).
     */
    public void clickSubscriptionModulesMenu() {
        playwright.waitTillLocatorIsVisible(subscriptionModulesMenu, 30000.0);
        playwright.clickOn(subscriptionModulesMenu);
        page.waitForLoadState();
    }
}
