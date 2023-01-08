package config.playwright.context;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

public class ActiveContext {
    private static BrowserContext activeBrowserContext;
    private static Page activePage;
    private static String contextName;

    /**
     * Set active browser context
     * @param activeBrowserContext BrowserContext type
     */
    public static void setActiveBrowserContext(BrowserContext activeBrowserContext) {
        ActiveContext.activeBrowserContext = activeBrowserContext;
    }

    /**
     * Get active browser context
     * @return BrowserContext data type
     */
    public static BrowserContext getActiveBrowserContext() {
        return activeBrowserContext;
    }

    /**
     * set active page
     * @param activePage Page type
     */
    public synchronized static void setActivePage(Page activePage) {
        ActiveContext.activePage = activePage;
    }

    /**
     * Get active page
     * @return Page type
     */
    public static Page getActivePage() {
        return activePage;
    }

    /**
     * Set context name
     * @param contextName String type
     */
    public static void setContextName(String contextName) {
        ActiveContext.contextName = contextName;
    }

    /**
     * Get context name
     * @return String type
     */
    public static String getContextName() {
        return contextName;
    }

    /**
     * Active tenant context for multiple context scenario
     * @param pageIndex index page
     */
    public synchronized static void activateTenant(int pageIndex) {
        ActiveContext.setActiveBrowserContext(TenantContext.getTenantBrowserContext());
        ActiveContext.setActivePage(TenantContext.getTenantBrowserContext().pages().get(pageIndex));
    }

    /**
     * Activate owner context for multiple context scenario
     * @param pageIndex index page
     */
    public synchronized static void activateOwner(int pageIndex) {
        ActiveContext.setActiveBrowserContext(OwnerContext.getOwnerBrowserContext());
        ActiveContext.setActivePage(OwnerContext.getOwnerBrowserContext().pages().get(pageIndex));
    }

    /**
     * Activate admin context for multiple context scenario
     * @param pageIndex
     */
    public static void activateAdmin(int pageIndex) {
        System.out.println("later" + pageIndex);
    }
}
