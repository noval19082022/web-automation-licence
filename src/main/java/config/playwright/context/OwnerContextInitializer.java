package config.playwright.context;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Tracing;
import config.playwright.PlaywrightSourceManager;
import config.playwright.browser.BrowserOptions;

public class OwnerContextInitializer {
    public static void initializeOwnerBrowserContext() {
        BrowserContext ownerBrowser = PlaywrightSourceManager.getLocalBrowser().newContext(BrowserOptions.browserContextOptions());
        OwnerContext.setOwnerBrowserContext(ownerBrowser);
    }

    public static void initializeOwnerPage() {
        OwnerContext.getOwnerBrowserContext().tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(false));
        ActiveContext.setActivePage(OwnerContext.getOwnerBrowserContext().newPage());
    }
}
