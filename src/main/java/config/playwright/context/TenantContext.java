package config.playwright.context;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

public class TenantContext {
    private static Page tenantPage;
    private static BrowserContext tenantBrowserContext;

    public static Page getTenantPage() {
        return tenantPage;
    }

    public static void setTenantPage(Page tenantPage) {
        TenantContext.tenantPage = tenantPage;
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
        TenantContext.tenantBrowserContext = tenantBrowserContext;
    }
}
