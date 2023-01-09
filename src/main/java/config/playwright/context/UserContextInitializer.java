package config.playwright.context;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Tracing;
import config.playwright.PlaywrightSourceManager;
import config.playwright.browser.BrowserOptions;

public class UserContextInitializer {

    /**
     * Initialize user browser context
     */
    public static void initializeUserBrowserContext() {
        BrowserContext userContext = PlaywrightSourceManager.getLocalBrowser().newContext(BrowserOptions.browserContextOptions());
        UserContext.setUserBrowserContext(userContext);
    }

    /**
     * Initialize user page
     */
    public static void initializeUserPage() {
        UserContext.getUserBrowserContext().tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(false));
        ActiveContext.setActivePage(UserContext.getUserBrowserContext().newPage());
    }
}
