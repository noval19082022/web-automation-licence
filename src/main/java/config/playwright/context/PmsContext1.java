package config.playwright.context;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

public class PmsContext1 {
    private static Page pmsPage;
    private static BrowserContext tenantBrowserContext;

    public static Page getPmsPage() {
        return pmsPage;
    }

    public static void setPmsPage(Page pmsPage) {
        PmsContext1.pmsPage = pmsPage;
    }

    /**
     * Get tenant browser context
     * @return BrowserContext type
     */
    public static BrowserContext getTenantBrowserContext() {
        return tenantBrowserContext;
    }

    /**
     * Set tenant browser context
     * @param tenantBrowserContext BrowserContext type
     */
    public synchronized static void setTenantBrowserContext(BrowserContext tenantBrowserContext) {
        PmsContext1.tenantBrowserContext = tenantBrowserContext;
    }
}
