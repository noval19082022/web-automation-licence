package config.playwright.context;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Tracing;
import config.playwright.PlaywrightSourceManager;
import config.playwright.browser.BrowserOptions;

public class AdminContextInitializer {
    /**
     * Initialize admin browser context
     */
    public static void initializeAdminBrowserContext() {
        BrowserContext adminBrowser = PlaywrightSourceManager.getLocalBrowser().newContext(BrowserOptions.browserContextOptions());
    }

    /**
     * Initialize admin page
     */
    public static void initializeAdminPage() {
        AdminContext.getAdminBrowserContext().tracing().start(new Tracing.StartOptions()
            .setScreenshots(true)
            .setSnapshots(true)
            .setSources(false));
        ActiveContext.setActivePage(AdminContext.getAdminBrowserContext().newPage());
    }
}
