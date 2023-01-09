package config.playwright.context;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Tracing;
import config.playwright.PlaywrightSourceManager;
import config.playwright.browser.BrowserOptions;

public class OwnerContextInitializer {
    /**
     * Initialize owner browser context
     */
    public static void initializeOwnerBrowserContext() {
        BrowserContext ownerBrowser = PlaywrightSourceManager.getLocalBrowser().newContext(BrowserOptions.browserContextOptions());
        OwnerContext.setOwnerBrowserContext(ownerBrowser);
    }

    /**
     * Initialize owner page
     */
    public static void initializeOwnerPage() {
        OwnerContext.getOwnerBrowserContext().tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(false));
        ActiveContext.setActivePage(OwnerContext.getOwnerBrowserContext().newPage());
    }
}
