package config.playwright.context;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Tracing;
import config.playwright.PlaywrightSourceManager;
import config.playwright.browser.BrowserOptions;

public class PmsContextInitializer1 {

    /**
     * Initialize tenant browser context
     */
    public static void initializePmsBrowserContext() {
        BrowserContext tenantContext = PlaywrightSourceManager.getLocalBrowser().newContext(BrowserOptions.browserContextOptions());
        TenantContext.setTenantBrowserContext(tenantContext);
    }

    /**
     * Initialize tenant page
     */
    public static void initializePmsPage() {
        TenantContext.getTenantBrowserContext().tracing().start(new Tracing.StartOptions()
            .setScreenshots(true)
            .setSnapshots(true)
            .setSources(false));
        ActiveContext.setActivePage(TenantContext.getTenantBrowserContext().newPage());
    }
}
