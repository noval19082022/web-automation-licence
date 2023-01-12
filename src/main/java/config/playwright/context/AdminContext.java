package config.playwright.context;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

public class AdminContext {
    private static Page adminPage;
    private static BrowserContext adminBrowserContext;

    /**
     * Get admin page
     * @return Page type
     */
    public static Page getAdminPage() {
        return adminPage;
    }

    /**
     * Set admin page
     * @param adminPage Page type
     */
    public synchronized static void setAdminPage(Page adminPage) {
        AdminContext.adminPage = adminPage;
    }

    /**
     * Get admin browser context
     * @return BrowserContext type
     */
    public static BrowserContext getAdminBrowserContext() {
        return adminBrowserContext;
    }

    /**
     * Set admin browser context
     * @param adminBrowserContext BrowserContext type
     */
    public static synchronized void setAdminBrowserContext(BrowserContext adminBrowserContext) {
        AdminContext.adminBrowserContext = adminBrowserContext;
    }
}
