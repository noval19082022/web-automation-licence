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

    public static BrowserContext getTenantBrowserContext() {
        return tenantBrowserContext;
    }

    public static void setTenantBrowserContext(BrowserContext tenantBrowserContext) {
        TenantContext.tenantBrowserContext = tenantBrowserContext;
    }
}
