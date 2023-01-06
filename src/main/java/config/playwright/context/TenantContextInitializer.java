package config.playwright.context;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Tracing;
import config.playwright.PlaywrightSourceManager;
import config.playwright.browser.BrowserOptions;

public class TenantContextInitializer {

    public static void initializeTenantBrowserContext() {
        BrowserContext tenantContext = PlaywrightSourceManager.getLocalBrowser().newContext(BrowserOptions.browserContextOptions());
        TenantContext.setTenantBrowserContext(tenantContext);
    }

    public static void initializeTenantPage() {
        TenantContext.getTenantBrowserContext().tracing().start(new Tracing.StartOptions()
            .setScreenshots(true)
            .setSnapshots(true)
            .setSources(false));
        ActiveContext.setActivePage(TenantContext.getTenantBrowserContext().newPage());
    }
}
